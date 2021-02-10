

public class WordFunJoe {
    public static void main(String[] args) {

        String word = new String ("Hello World");
        String upper = new String();
        String hyphen = new String();
        System.out.println(word);
        upper = word.toUpperCase();
        System.out.println(upper);
        hyphen = word.replaceAll(" ", "-");
        System.out.println(hyphen);



    }
}
