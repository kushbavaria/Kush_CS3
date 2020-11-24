package exceptions;

public class InputException
{
    public static void main(String[] args){
        String micheal = "Micheal";
           String atul = "Atul";
        try{
             System.out.println(friend(atul));
           System.out.println(friend(micheal));
        }
         catch(BadInputException e)
        {
                  System.out.println(e);
        }
    }
    
    public static String friend(String name) throws BadInputException{
          if(name.equals("Micheal")){
             throw new BadInputException(name);
        }
        return name + " is a good friend";
    }
}
