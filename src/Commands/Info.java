package Commands;

import City.CityCollection;

public class Info implements Command{

    @Override
    public void comply(Object o){
        System.out.println("Тип коллекции: " + CityCollection.getType() + " дата инициализации: " + CityCollection.getTime() + " количество элементов: " + CityCollection.getSize());
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
