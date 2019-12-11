package fr.leroideskiwis.command.utils;

public class Utils {
    public static String[] splitArgs(String cmd) {

        String[] args = cmd.split(" ");
        String[] toReturn = new String[args.length-1];
        System.arraycopy(args, 1, toReturn, 0, toReturn.length);
        return toReturn;

    }
}
