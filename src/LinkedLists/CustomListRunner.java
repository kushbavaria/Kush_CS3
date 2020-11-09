package LinkedLists;


public class CustomListRunner { 
    public static void main(String[] args) {

        CustomList listy = new CustomList("apple");
        listy.add("banana");
        listy.add("coconut");
        listy.add("dragonFruit");
        System.out.println("size = " + listy.size() + "  " + listy);
        
        System.out.println(listy.backWords());

        System.out.println("\nadding eggplant at position 0");
        listy.add(0, "eggplant");
        System.out.println("size = " + listy.size() + "  " + listy);
        System.out.println(listy.backWords());


        System.out.println("\nadding fruit at position 1");
        listy.add(1, "fruit");
        System.out.println("size = " + listy.size() + "  " + listy);
        System.out.println(listy.backWords());

        System.out.println("\nsetting position 1 to tomato");
        listy.set(1, "tomato");
        System.out.println("size = " + listy.size() + "  " + listy);
        System.out.println(listy.backWords());

        System.out.println("\ngetting position 1");
        System.out.println("position 1 = " + listy.get(1));
        System.out.println(listy.backWords());

        System.out.println("\nremoving position 0");
        listy.remove(0);
        System.out.println("size = " + listy.size() + "  " + listy);
        System.out.println(listy.backWords());

    }
}
