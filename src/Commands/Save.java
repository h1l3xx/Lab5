package Commands;

import City.CityCollection;
import City.City;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;


public class Save implements Command{
    @Override
    public String comply(Object o) throws IOException, ParserConfigurationException, TransformerException {

        CityCollection cityCollection = new CityCollection();
        LinkedList<City> collection = CityCollection.getCollection();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        File trueFile = new File(CityCollection.getFileName());


        Element root = document.createElement("Cities");
        for (City city: collection){
            Element documentCity = document.createElement("Product");
            documentCity.setAttribute("id", String.valueOf(city.getId()));

            Element docName = document.createElement("name");
            docName.setTextContent(city.getName());
            documentCity.appendChild(docName);

            Element docCoordinateX = document.createElement("coordinateX");
            docCoordinateX.setTextContent(Long.toString(city.getCoordinates().getX()));
            documentCity.appendChild(docCoordinateX);

            Element docCoordinateY = document.createElement("coordinateY");
            docCoordinateY.setTextContent(Double.toString(city.getCoordinates().getY()));
            documentCity.appendChild(docCoordinateY);

            Element docTime = document.createElement("date");
            Date time = city.getCreationDate();
            docTime.setTextContent(String.valueOf(time));
            documentCity.appendChild(docTime);

            Element docArea = document.createElement("area");
            docArea.setTextContent(Long.toString(city.getArea()));
            documentCity.appendChild(docArea);

            Element docPopulation = document.createElement("population");
            docPopulation.setTextContent(Integer.toString(city.getPopulation()));
            documentCity.appendChild(docPopulation);

            Element docMetersAboveSeaLevel = document.createElement("metersAboveSeaLevel");
            docMetersAboveSeaLevel.setTextContent(Long.toString(city.getMetersAboveSeaLevel()));
            documentCity.appendChild(docMetersAboveSeaLevel);

            Element docAgglomeration = document.createElement("agglomeration");
            docAgglomeration.setTextContent(Double.toString(city.getAgglomeration()));
            documentCity.appendChild(docAgglomeration);

            Element docClimate = document.createElement("climate");
            docClimate.setTextContent((city.getClimate().toString()));
            documentCity.appendChild(docClimate);

            Element docGovernment = document.createElement("government");
            docGovernment.setTextContent(city.getGovernment().toString());
            documentCity.appendChild(docGovernment);

            Element docGovernorAge = document.createElement("governorAge");
            docGovernorAge.setTextContent(String.valueOf(city.getGovernor().getAge()));
            documentCity.appendChild(docGovernorAge);

            Element docGovernorBirthday = document.createElement("governorBirthday");
            docGovernorBirthday.setTextContent(String.valueOf(city.getGovernor().getBirthday()));
            documentCity.appendChild(docGovernorBirthday);




            root.appendChild(documentCity);
        }
        document.appendChild(root);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // для красивого вывода в консоль
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);

        //печатаем в консоль или файл
        StreamResult file = new StreamResult(trueFile);

        //записываем данные
        transformer.transform(source, file);

        System.out.println("Создание XML файла закончено");
        System.out.println("Записано в файл");


        return null;
    }

    @Override
    public String getName(){
        return "save";
    }
    @Override
    public String getDescription(){
        return "Сохраняет коллекцию в файл";
    }
}
