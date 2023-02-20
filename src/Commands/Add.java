package Commands;

import City.CityCollection;
import City.City;
import City.CityCreator;
import City.CityCompareByDefault;

import java.util.LinkedList;


public class Add implements Command{





    @Override
    public String comply(Object o) {
        CityCreator cityCreator = new CityCreator();

        City city;

        String ci = (String) o;

        if (ci.equals("City")){


            city = cityCreator.create();

            CityCollection.add(city);
            System.out.println("Город успешно добавлен");

            LinkedList<City> collection = CityCollection.getCollection();

            CityCompareByDefault c = new CityCompareByDefault();

            collection.sort(c);}

        else {
            System.out.println("В коллекцию можно добавить только город (City)");
        }


        return null;
    }

    @Override
    public String getName() {
        return "add";
    }



    @Override
    public String getDescription() {
        return "Добавляет город в коллекцию";
    }

}
