package Commands;
import City.City;
import City.CityCollection;

import java.util.Iterator;

public class FilterContainsName implements Command{
    @Override
    public void comply(Object arg) {

        if (CityCollection.getSize() != 0) {
            for(Iterator<City> it = (Iterator<City>) CityCollection.getCollection().iterator(); it.hasNext();) {
                City city = (City) it.next();
                if (city.getName().contains((String)arg)){
                    System.out.println(city.toString());}}

            System.out.println("Выведены все города, в названии которых есть заданная подстрока");
        }
        else {
            System.out.println("Коллекция пуста");
        }
    }

        @Override
        public String getName() {
            return "filter_contains_name";
        }

        @Override
        public String getDescription() {
            return "Выводит элементы, значение поля name которых содержит заданную подстроку";
        }
    }

