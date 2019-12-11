package fr.leroideskiwis.command.core;

public class CommandExecutor {

    public final String name;
    public final String description;

    public CommandExecutor(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void execute(CommandManager manager, String[] args){
        manager.print("Command not defined.");
    }

    public boolean canExecute(CommandManager commandManager){
        return true;
    }

    public void handleCantExecute(CommandManager commandManager){
        commandManager.print("You can't execute this command !");
    }

    @Override
    public String toString() {
        return name+" : "+description;
    }
}
