package Commands;

import City.City;
import City.CityCollection;

import java.util.LinkedList;

public class UpdateIdArg implements Command{
    @Override
    public void comply(Object o){

    }

    @Override
    public String getName(){
        return "update";
    }

    @Override
    public String getDescription(){
        return "Обновляет значение элемента коллекции, id которого равен заданному";
    }

    public static void comply(Object o1, Object o2){
        int id = Integer.parseInt((String) o1);
        int population = Integer.parseInt((String) o2);

        LinkedList<City> collection = CityCollection.getCollection();
        for (City c : collection){
            if (c.getId() == id){
                c.setPopulation(population);
            }
        }
        System.out.println("Количество жителей у города успешно изменено на " + population);

    }
}
