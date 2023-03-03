package Commands;

import City.*;
import Main.Operator;

import java.io.*;
import java.util.LinkedList;

public class ExecuteScript implements Command {

    private static int count_lines;

    @Override
    public void comply(Object o) throws IOException {
        try {
            BufferedReader buf_for_count_lines = new BufferedReader(new FileReader((String) o));

            while (buf_for_count_lines.readLine() != null) {
                count_lines += 1;
            }

            BufferedReader buf = new BufferedReader(new FileReader((String) o));

            for (int i = 0; i < count_lines; i++) {


                String line = buf.readLine();
                City city;

                Operator operator = new Operator();


                if (line.equals("add City")) {
                    CityCreator cityCreator = new CityCreator();
                    try {
                        String name = buf.readLine();
                        long x = Long.parseLong(buf.readLine());
                        float y = Float.parseFloat(buf.readLine());
                        long area = Long.parseLong(buf.readLine());
                        int population = Integer.parseInt(buf.readLine());
                        long meters = Long.parseLong(buf.readLine());
                        double agg = Double.parseDouble(buf.readLine());
                        String climate = buf.readLine();
                        String government = buf.readLine();
                        long age = Long.parseLong(buf.readLine());
                        String birt = buf.readLine();
                        city = cityCreator.createForScript(name, x, y, area, population, meters, agg, climate, government, age, birt);

                        CityCollection.add(city);
                        System.out.println("Город успешно добавлен");

                        LinkedList<City> collection = CityCollection.getCollection();

                        CityCompareByDefault c = new CityCompareByDefault();

                        collection.sort(c);

                        i += 11;

                    } catch (Exception e) {
                        System.out.println("Невозможно исполнение команды add City, проверьте количество переменных");
                    }
                } else {
                    operator.runCommand(line + " a");
                }
            }
        }catch (IOException e){
            System.out.println("Ошибка. Либо не существует данного файла, либо путь до файла некорректный");
        }
    }

    @Override
    public String getName(){
        return "execute_script";
    }

    @Override
    public String getDescription(){
        return "Считывает и исполняет скрипт из указанного файла";
    }
}
