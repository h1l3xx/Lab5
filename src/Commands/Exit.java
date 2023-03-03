package Commands;



public class Exit implements Command{

    @Override
    public void comply(Object o) {
        System.out.println("Работа приложения завершена");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Завершение работы без сохранения в файл";
    }
}
