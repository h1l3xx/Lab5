package Commands;

import City.CityCollection;
public class RemoveAtIndex implements Command{

    @Override
    public String comply(Object o){
        int index = Integer.parseInt((String) o);


        CityCollection.removeAtIndex(index);
        System.out.println("Элемент под индексом " + index + " удалён");
        return null;
    }

    @Override
    public String getName(){
        return "remove_at";
    }

    @Override
    public String getDescription(){
        return "Удаляет элемент, находящийся в заданной позиции коллекции (index)";
    }
}
