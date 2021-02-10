package FinalProject;

public class StringComparerJoe {
    public static void main(String[] args) {
        int compare = 0;
        String one = new String("abe");
        String two = new String("ape");
        compare = one.compareTo(two);
        if (compare < 0) {
            System.out.println(one + " should be placed before " + two + "\n");
        } else {
            System.out.println(one + " should be placed after " + two + "\n");
        }
    }
}

