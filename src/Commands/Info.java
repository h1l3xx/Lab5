package Commands;

import City.CityCollection;

public class Info implements Command{

    @Override
    public String comply(Object o){
        System.out.println("Тип коллекции: " + CityCollection.getType() + " дата инициализации: " + CityCollection.getTime() + " количество элементов: " + CityCollection.getSize());
        return null;
    }

    @Override
    public String getName(){
        return "info";
    }
    @Override
    public String getDescription(){
        return "Выводит в стандартный поток вывода информацию о коллекции";
    }
}
