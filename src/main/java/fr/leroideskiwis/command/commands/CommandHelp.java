package fr.leroideskiwis.command.commands;

import fr.leroideskiwis.command.core.CommandExecutor;
import fr.leroideskiwis.command.core.CommandManager;

import java.util.List;

public class CommandHelp extends CommandExecutor {
    public CommandHelp(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(CommandManager manager, String[] args) {

        List<CommandExecutor> commands = manager.getCommands();

        manager.print("Il y a "+commands.size()+" commandes");

        for(CommandExecutor commandExecutor : commands){

            manager.print("- "+commandExecutor.toString());

        }

    }
}
