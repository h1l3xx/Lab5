package Main;

import Commands.Command;
import Commands.UpdateIdArg;


import java.util.HashMap;
import java.util.Map;


public class Operator {

    private static final Map<String, Command> commandList = new HashMap<>();
    private static final Map<String, String> commandDescriptionList = new HashMap<>();


    public static Map<String, String> getCommandDescriptionList() {
        return commandDescriptionList;
    }

    public void register(Command... commands) {
        for (Command command : commands) {
            Operator.commandList.put(command.getName(), command);
            Operator.commandDescriptionList.put(command.getName(), command.getDescription());
        }
    }


    public void runCommand(String command) {
        if (command.contains("update")){
            String[] com = command.split(" ");
            String name = com[0];
            String id = com[1];
            String arg = com[2];

            if (commandList.get(name) == null) {
                System.out.println("Такой команды не существует");
            } else if (com.length > 4) {
                System.out.println("Неверный формат ввода");
            } else {
                try {
                    UpdateIdArg.comply(id, arg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            String[] nameAndArgument = command.split(" ");
            String name = nameAndArgument[0];
            String arg = nameAndArgument[1];
            if (commandList.get(name) == null) {
                System.out.println("Такой команды не существует");
            }else {
                try {
                    commandList.get(name).comply(arg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
