package Commands;

import City.City;
import City.CityCollection;

import java.util.Iterator;

public class RemoveLower implements Command{
    @Override
    public String comply(Object o){
        int population = Integer.parseInt((String) o);
        for (Iterator<City> iterator = (Iterator<City>) CityCollection.getCollection().iterator(); iterator.hasNext();){
            City iterCity = iterator.next();
            if (iterCity.getPopulation() < population){
                iterator.remove();
            }
        }

        System.out.println("Все города с населением меньше, чем " + population + " были удалены");

        return null;
    }

    @Override
    public String getName(){
        return "remove_lower";
    }

    @Override
    public String getDescription(){
        return "Удаляет из коллекции все элементы, меньшие, чем заданный";
    }
}
