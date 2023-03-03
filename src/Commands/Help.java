package Commands;

import Main.Operator;

import java.util.Map;

public class Help implements Command{
    @Override
    public void comply(Object o){
        Map<String,String> descriptionList = Operator.getCommandDescriptionList();
        for(Map.Entry<String, String> part : descriptionList.entrySet()) {
            System.out.println(part.getKey() + " : " +  part.getValue());
        }
    }

    @Override
    public String getName(){
        return "help";
    }

    @Override
    public String getDescription(){
        return "Справка по командам";
    }
}
