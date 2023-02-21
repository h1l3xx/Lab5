package Commands;

import City.City;
import City.CityCollection;

import java.util.LinkedList;

public class Show implements Command{

    @Override
    public String comply(Object o){
        LinkedList<City> collection = CityCollection.getCollection();
        if (collection.size() > 0) {
            for (City c : collection) {
                System.out.println(c.toString());

            }
        }else {
            System.out.println("Коллекция пуста");
        }

        return null;
    }
    @Override
    public String getName(){
        return "show";
    }

    @Override
    public String getDescription(){
        return "Выводит3 коллекцию на экран";
    }
}
