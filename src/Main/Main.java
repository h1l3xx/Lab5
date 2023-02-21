package Main;


import java.util.Scanner;
import City.CityCollection;
import Commands.*;


public class Main {
    public static void main(String[] args){

        System.out.println("Введите файл, данными которого автоматически заполнится коллекция (формат .xml)");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        CityCollection.setFileName(name);

        Operator operator = new Operator();
        operator.register(new Add(), new Show(), new Exit(), new Clear(), new RemoveAtIndex(), new Info(), new FilterContainsName(), new RemoveAllByMetersAboveSeaLevel(),
                new Sort(), new RemoveLower(), new PrintAscending(), new UpdateIdArg(), new Save(), new ExecuteScript(), new Help());



        while (true) {
            String command = scanner.nextLine();
            operator.runCommand(command + " a");
        }
    }
}