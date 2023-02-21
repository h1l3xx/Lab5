package City;

public class Human {
    private long age; //Значение поля должно быть больше 0
    private java.time.ZonedDateTime birthday;

    public long getAge(){
        return age;
    }

    public void setAge(long age){
        this.age = age;
    }

    public java.time.ZonedDateTime getBirthday(){
        return birthday;
    }
    public void setBirthday(java.time.ZonedDateTime birthday){
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return "Age = " + age + ", Birthday = " + birthday;
    }



}
