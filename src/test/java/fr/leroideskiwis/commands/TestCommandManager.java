package fr.leroideskiwis.commands;

import fr.leroideskiwis.command.core.CommandManager;
import fr.leroideskiwis.command.core.CommandMode;

public class TestCommandManager {

    public static void main(String[] args){

        CommandManager manager = new CommandManager(CommandMode.WRITE);
        manager.start();

    }

}
