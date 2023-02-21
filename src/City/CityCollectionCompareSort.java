package City;

import java.util.Comparator;

public class CityCollectionCompareSort implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        if (city1.getCreationDate().equals(city2.getCreationDate())){
            return 0;
        }
        if (city2.getCreationDate().before(city1.getCreationDate())){
            return 1;
        }
        else{
            return -1;
        }
    }
}
