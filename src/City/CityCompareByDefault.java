package City;

import java.util.Comparator;

public class CityCompareByDefault implements Comparator<City> {
    @Override
    public int compare(City c1, City c2){
        if (c1.getPopulation().equals(c2.getPopulation())){
            return 0;
        }
        if (c1.getPopulation() > c2.getPopulation()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
