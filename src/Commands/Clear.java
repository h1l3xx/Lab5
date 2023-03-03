package Commands;

import City.CityCollection;

public class Clear implements Command{
    @Override
    public void comply(Object o){
        CityCollection collection = new CityCollection();
        collection.clear();
        System.out.println("Коллекция очищена");
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Очищает коллекцию";
    }
}
