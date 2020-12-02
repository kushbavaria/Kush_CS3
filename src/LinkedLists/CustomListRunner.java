package LinkedLists;


public class CustomListRunner { 
    public static void main(String[] args) {

        CustomList listy = new CustomList(1);
        listy.add(10);
        listy.add(5);
        listy.add(2);
        System.out.println("size = " + listy.size() + "  " + listy);
        listy.insertionSort(listy);


        System.out.println("size = " + listy.size() + "  " + listy);



    }
}
