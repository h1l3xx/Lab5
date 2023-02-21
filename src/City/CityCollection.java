package City;

import java.time.LocalDateTime;
import java.util.*;

public class CityCollection{


    private static LinkedList<City> collection = new LinkedList<City>();

    private static LocalDateTime time = LocalDateTime.now();
    private static String fileName;



    public static void setFileName(String fileName){
        CityCollection.fileName = fileName;
    }

    public static String getFileName(){
        return CityCollection.fileName;
    }

    public static LocalDateTime getTime() {
        return time;
    }

    public static void setTime(LocalDateTime time) {
        CityCollection.time = time;
    }

    public static LinkedList<City> getCollection(){
        return collection;
    }

    public static void setCollection(LinkedList<City> collection){
        CityCollection.collection = collection;
    }
    public static LinkedList<City> getCollection(LinkedList<City> collection){
        return collection;
    }

    public void clear(){
        collection.clear();
    }


    public static void add(City city){
        collection.add(city);
    }

    public static int getSize(){
        return collection.size();
    }

    public static int getFreeId(){
        ArrayList<Integer> busyId = new ArrayList<>();
        Iterator<City> it = collection.iterator();
        while(it.hasNext()){
            busyId.add(it.next().getId());
        }
        for (int id = 1; id <= busyId.size() + 1; id ++){
            if (!busyId.contains(id)){
                return id;
            }
        }
        return 0;
    }

    public static Class<? extends Collection> getType(){
        return collection.getClass();
    }

    public static void removeAtIndex(int index){
        collection.remove(index);
    }

    public static void remove(City c){
        collection.remove(c);
    }



}
