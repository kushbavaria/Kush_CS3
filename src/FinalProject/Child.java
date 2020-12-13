package FinalProject;

public class Child implements Comparable<Child>
{
    private int age;
    private int niceornaughty;
    private String address;
    private String name;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child(int k, String n, String s){
        age = k;
        niceornaughty = 0;
        name = n;
        address = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNiceornaughty() {
        return niceornaughty;
    }

    public void setNiceornaughty(int niceornaughty) {
        this.niceornaughty = niceornaughty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int compareTo(Child student){
        if(niceornaughty > student.getNiceornaughty()){
            return -1;
        }
        else if(niceornaughty == student.getNiceornaughty()){
            return 0;
        }
        else{
            return 1;
        }
           
    }
    public String toString(){
        return name + " (" + age + " years old) is nice level = " + niceornaughty + ", " + address;
    }
}
