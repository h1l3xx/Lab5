package Commands;



public class Exit implements Command{

    @Override
    public String comply(Object o) {
        System.out.println("Работа приложения завершена");
        System.exit(0);
        return null;
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
