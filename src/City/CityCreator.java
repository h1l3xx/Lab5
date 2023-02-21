package City;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CityCreator {
    Scanner scanner = new Scanner(System.in);


    public City create() {


        City city = new City();

        this.setName(city);

        city.setId((int) CityCollection.getFreeId());



        Coordinates coordinates = new Coordinates();
        this.setCoordinateX(coordinates);
        this.setCoordinateY(coordinates);
        city.setCoordinates(coordinates);
        city.setCreationDate(new Date());
        this.setArea(city);
        this.setPopulation(city);
        this.setMetersAboveSeaLevel(city);
        this.setAgglomeration(city);
        this.setClimate(city);
        this.setGovernment(city);
        Human governor = new Human();
        this.setAgeGovernor(governor);
        this.setBirthdayGovernor(governor);
        city.setGovernor(governor);
        return city;
    }

    public void setName(City city){
        System.out.println("Введите название города");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            System.out.println("Имя не может быть пустым");
            this.setName(city);
        } else {
            city.setName(name);
        }
    }


    public void setCoordinateX(Coordinates coords) {
        try {
            System.out.println("Введите координату x: (Long)");
            String x = scanner.nextLine();
            if (x.equals("")) {
                System.out.println("x не может быть null");
                this.setCoordinateX(coords);
            } else {
                long x_long = Long.parseLong(x);
                if (x_long >= -882) {
                    coords.setX(x_long);
                } else {
                    System.out.println("Минимальное значение x: -882");
                    this.setCoordinateX(coords);
                }
                coords.setX(x_long);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"Long\".");
            this.setCoordinateX(coords);
        }
    }

    public void setCoordinateY(Coordinates coords) {
        try {
            System.out.println("Введите координату y: (float)");
            String y = scanner.nextLine();
            if (y.equals("")) this.setCoordinateY(coords);
            else {
                float yn = Float.parseFloat(y);
                if (yn <= 10000) {
                    coords.setY(yn);
                } else {
                    System.out.println("Максимальное значение y: 10000");
                    this.setCoordinateY(coords);
                }
                coords.setY(yn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"float\".");
            this.setCoordinateY(coords);
        }
    }

    public void setArea(City city) {
        try{
            System.out.println("Введите значение параметра area: (long)");
            long area = Long.parseLong(scanner.nextLine());
            if (area < 0) {
                System.out.println("Значение параметра area не может быть меньше 0");
                this.setArea(city);
            } else {
                city.setArea(area);
            }
        }catch (InputMismatchException | NumberFormatException e){
            System.out.println("Значение должно быть типа (long)");
            this.setArea(city);
        }
    }

    public void setPopulation(City city) {
        try {
            System.out.println("Введите количество жителей");
            String population = (scanner.nextLine());
            if (population.equals("")) {
                System.out.println("Количество жителей не может быть null.");
                this.setPopulation(city);
            } else {
                int charPopulation = Integer.parseInt(population);
                if (charPopulation < 0) {
                    System.out.println("Количество жителей не может быть отрицательным числом.");
                    this.setPopulation(city);
                } else {
                    city.setPopulation(charPopulation);
                }
            }
        }catch (InputMismatchException | NumberFormatException e){
            System.out.println("Количество жителей должно быть целым числом");
            this.setPopulation(city);
        }

    }

    public void setMetersAboveSeaLevel(City city){
        try {
            System.out.println("Введите высоту над уровнем моря");
            long meters = Long.parseUnsignedLong(scanner.nextLine());
            city.setMetersAboveSeaLevel(meters);
        }catch (InputMismatchException | NumberFormatException e){
            System.out.println("Высота должна выражаться числом в формате (long)");
            this.setMetersAboveSeaLevel(city);
        }

    }

    public void setAgglomeration(City city){
        try{
            System.out.println("Введите номер агломерации");
            double agglomeration = Double.parseDouble(scanner.nextLine());
            city.setAgglomeration(agglomeration);}
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Номер агломерации должен быть числом в формате (Double)");
            this.setAgglomeration(city);
        }
    }

    public void setClimate(City city){
        System.out.println("Введите тип климата: \n    HUMIDCONTINENTAL, \n    MEDITERRANIAN,\n    STEPPE");
        String climate = scanner.nextLine().toUpperCase();
        try {
            city.setClimate(Climate.valueOf(climate));
        } catch (Exception e) {
            System.out.println("Введенное значение должно соответствовать перечисленным типам. Введите значение:");
            this.setClimate(city);}
    }

    public void setGovernment(City city){
        System.out.println("Введите тип правительства: \n    OLIGARCHY, \n    JUNTA,\n    ETHNOCRACY");
        String government = scanner.nextLine().toUpperCase();
        try {
            city.setGovernment(Government.valueOf(government));
        } catch (Exception e) {
            System.out.println("Введенный тип должно соответствовать перечисленным типам. Введите тип:");
            this.setGovernment(city);
        }
    }

    public void setAgeGovernor(Human governor){
        try {
            System.out.println("Введите возраст губернатора:");
            String age = scanner.nextLine();
            if (age.equals("")) this.setAgeGovernor(governor);
            else {
                long longAge = Long.parseLong(age);
                governor.setAge(longAge);
            }
        }catch (NumberFormatException | InputMismatchException e){
            System.out.println("Возраст губернатора должен быть целым числом");
            this.setAgeGovernor(governor);
        }
    }

    public void setBirthdayGovernor(Human governor){
        try {
            System.out.println("Введите день рождения губернатора:");
            String birthday = scanner.nextLine();
            if (birthday.equals("")) this.setBirthdayGovernor(governor);
            else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(birthday, formatter);

                ZonedDateTime result = date.atStartOfDay(ZoneId.systemDefault());
                governor.setBirthday(result);

            }
        }catch (Exception e){
            System.out.println("Введите день рождения в корректной форме, согласно образцу:");
            System.out.println("DD/MM/YYYY");
            this.setBirthdayGovernor(governor);
        }
    }

    public City createForScript(String name, Long x, float y, long area, int population, long meters, double agg, String climate, String government, long age, String birt){
        City city = new City();

        city.setName(name);

        city.setId((int) CityCollection.getFreeId());



        Coordinates coordinates = new Coordinates();
        this.setCoordinateXForScript(coordinates ,x);
        this.setCoordinateYForScript(coordinates, y);
        city.setCoordinates(coordinates);
        city.setCreationDate(new Date());
        city.setArea(area);
        city.setPopulation(population);
        city.setMetersAboveSeaLevel(meters);
        city.setAgglomeration(agg);
        this.setClimateForScript(city, climate);
        this.setGovernmentForScript(city, government);
        Human governor = new Human();
        this.setAgeGovernorForScript(governor, age);
        this.setBirthdayGovernorForScript(governor, birt);
        city.setGovernor(governor);

        return city;
    }


    public void setCoordinateXForScript(Coordinates coords, Long x) {
        try {
            if (x >= -882) {
                coords.setX(x);
            } else {
                System.out.println("Минимальное значение x: -882");
                this.setCoordinateX(coords);
            }
            coords.setX(x);
        } catch (Exception e) {
            System.out.println("Значение координаты x должно быть типа:\"Long\".");
            System.out.println("Дальнейшее выполнение скрипта невозможно, исправьте ошибку.");
        }
    }

    public void setCoordinateYForScript(Coordinates coords, float y) {
        try {
             if (y <= 10000) {
                 coords.setY(y);
             } else {
                 System.out.println("Максимальное значение y: 10000");
                 this.setCoordinateY(coords);
             }
             coords.setY(y);
        } catch (Exception e) {
            System.out.println("Значение координаты y должно быть типа:\"float\".");
            System.out.println("Дальнейшее выполнение скрипта невозможно, исправьте ошибку.");
        }
    }

    public void setClimateForScript(City city, String climate){
        String climate_up = climate.toUpperCase();
        try {
            city.setClimate(Climate.valueOf(climate_up));
        } catch (Exception e) {
            System.out.println("Введенное значение должно соответствовать перечисленным типам. Введите одно из значений:\\n    HUMIDCONTINENTAL, \\n    MEDITERRANIAN,\\n    STEPPE\"");
            System.out.println("Дальнейшее выполнение скрипта невозможно, исправьте ошибку.");
        }
    }

    public void setGovernmentForScript(City city, String government){
        String gav_up = government.toUpperCase();
        try {
            city.setGovernment(Government.valueOf(gav_up));
        } catch (Exception e) {
            System.out.println("Введенный тип должно соответствовать перечисленным типам. Введите одно из значений:\\n    OLIGARCHY, \\n    JUNTA,\\n    ETHNOCRACY\"");
            System.out.println("Дальнейшее выполнение скрипта невозможно, исправьте ошибку.");
        }
    }
    public void setAgeGovernorForScript(Human governor, long age){
        try {
            governor.setAge(age);
        }catch (Exception e){
            System.out.println("Возраст губернатора должен быть целым числом");
            System.out.println("Дальнейшее выполнение скрипта невозможно, исправьте ошибку.");
        }
    }

    public void setBirthdayGovernorForScript(Human governor, String birt){
        try {
            if (birt.equals("")) this.setBirthdayGovernor(governor);
            else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(birt, formatter);

                ZonedDateTime result = date.atStartOfDay(ZoneId.systemDefault());
                governor.setBirthday(result);

            }
        }catch (Exception e){
            System.out.println("Введите день рождения в корректной форме, согласно образцу:");
            System.out.println("DD/MM/YYYY");
            System.out.println("Дальнейшее выполнение скрипта невозможно, исправьте ошибку.");
        }
    }
}
