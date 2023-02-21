package Commands;

import City.City;

import java.util.Iterator;
import java.util.LinkedList;

import City.CityCollection;
import City.CityCollectionCompareSort;
import City.CityCompareByDefault;


public class PrintAscending implements Command {
    @Override
    public String comply(Object o){

        LinkedList<City> UnSortedCityCollection = CityCollection.getCollection();

        CityCollectionCompareSort c = new CityCollectionCompareSort();

        UnSortedCityCollection.sort(c);

        for (City city : UnSortedCityCollection){
            System.out.println(city.toString());
        }

        LinkedList<City> collection = CityCollection.getCollection();

        CityCompareByDefault compare = new CityCompareByDefault();

        collection.sort(compare);


        return null;
    }

    @Override
    public String getName(){
        return "print_ascending";
    }

    @Override
    public String getDescription(){
        return "Выводит все элементы коллекции в порядке возрастания";
    }
}
