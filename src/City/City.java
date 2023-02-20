package City;



public class City{

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private Integer population; //Значение поля должно быть больше 0, Поле не может быть null
    private Long metersAboveSeaLevel;
    private Double agglomeration;
    private Climate climate; //Поле может быть null
    private Government government; //Поле не может быть null
    private Human governor; //Поле может быть null


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }


    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Long getMetersAboveSeaLevel(){
        return metersAboveSeaLevel;
    }

    public void setMetersAboveSeaLevel(Long metersAboveSeaLevel){
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public double getAgglomeration() {
        return agglomeration;
    }

    public void setAgglomeration(double agglomeration) {
        this.agglomeration = agglomeration;
    }


    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public Government getGovernment() {
        return government;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }

    public Human getGovernor(){
        return governor;
    }

    public void setGovernor(Human governor){
        this.governor = governor;
    }



    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name = " + name +
                ", coordinates = " + coordinates +
                ", creationDate = " + creationDate +
                ", area = " + area +
                ", population = " + population +
                ", metersAboveSeaLevel = " + metersAboveSeaLevel +
                ", agglomeration = " + agglomeration +
                ", climate = " + climate +
                ", government = " + government +
                ", governor: " + governor +
                '}';
    }


}
