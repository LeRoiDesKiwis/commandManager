package fr.leroideskiwis.command.core;

import fr.leroideskiwis.command.commands.CommandHelp;
import fr.leroideskiwis.command.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private CommandMode commandMode;
    private boolean running;
    private List<CommandExecutor> commands = new ArrayList<>();
    private CustomScanner scanner = new CustomScanner();

    public CommandManager(CommandMode commandMode){
        this.commandMode = commandMode;
        registerCommand(new CommandHelp("help", "affiche l'aide"));
    }

    public void start(){
        this.running = true;
        while(running){
            String cmd = scanner.readString("> ");
            CommandExecutor commandExecutor = getCommand(cmd.split(" ")[0]);

            if(commandExecutor == null) handleHelp();

            else if(commandMode == CommandMode.WRITE){
                if(commandExecutor.canExecute(this)) commandExecutor.execute(this, Utils.splitArgs(cmd));
                else commandExecutor.handleCantExecute(this);
            }
        }
    }

    private void handleHelp() {
        getCommand("help").execute(this, new String[0]);
    }

    public CommandExecutor getCommand(String name){
        for(CommandExecutor commandExecutor : commands){
            if(commandExecutor.name.equals(name)) return commandExecutor;
        }
        return null;
    }

    public void stop(){
        this.running = false;

    }

    public void registerCommand(CommandExecutor commandExecutor) {
        commands.add(commandExecutor);
    }

    public void print(String message){
        System.out.println(message);
    }

    public List<CommandExecutor> getCommands(){
        return new ArrayList<>(commands);
    }

}