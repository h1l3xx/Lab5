package Commands;

import City.City;
import City.CityCollection;

import java.util.Iterator;
import java.util.LinkedList;

public class RemoveAllByMetersAboveSeaLevel implements Command{



    @Override
    public String comply(Object o) {
        long meters = Long.parseLong((String) o);


        for (Iterator<City> iterator = (Iterator<City>) CityCollection.getCollection().iterator(); iterator.hasNext();){
           City iterCity = iterator.next();
           if (iterCity.getMetersAboveSeaLevel().equals(meters)){
               iterator.remove();
           }
        }


        System.out.println("Все города со значением параметра metersAboveSeaLevel эквивалентные заданному были удалены");
        return null;
    }

    @Override
    public String getDescription(){
        return "Удаляет из коллекции все элементы, значение поля metersAboveSeaLevel которого эквивалентно заданному";
    }

    @Override
    public String getName(){
        return "remove_all_by_meters_above_sea_level";
    }
}
