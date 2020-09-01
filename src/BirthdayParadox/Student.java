package BirthdayParadox;

public class Student{
    private int month;
    private int day;

    public Student(){
        month = (int)(Math.random() * 12) + 1;
        int days;
        if(month == 2){
            days =28;
        }
        else if(month == 11 || month == 9 ||month == 7|| month == 5|| month == 4){
            days =30;
        }
        else{
            days =31;
        }
        day = (int)(Math.random() * days) + 1;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public boolean equals(Student other){
        boolean first = this.getMonth() == other.getMonth();
        boolean second = this.getDay() == other.getDay();
        return first && second;
    }

    //Mr.Bonsall it worked for me without an @override so I did it without it
    public String toString(){
        return ", month = "+ getMonth() + ", day = " + getDay();
    }
}
