package Commands;

import City.City;
import City.CityCollection;
import City.CityCollectionCompareSort;

import java.util.LinkedList;

public class Sort implements Command{
    @Override
    public void comply(Object o){
        LinkedList<City> collection = CityCollection.getCollection();

        CityCollectionCompareSort c = new CityCollectionCompareSort();

        collection.sort(c);

        System.out.println("Коллекция отсортирована в естественном порядке");

    }

    @Override
    public String getName(){
        return "sort";
    }

    @Override
    public String getDescription(){
        return "Сортирует коллекцию в естественном порядке (в порядке добавления)";
    }
}
