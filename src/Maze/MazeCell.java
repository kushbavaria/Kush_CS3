package Maze;

public class MazeCell
{
    private boolean blank;
    private boolean oldplace;
    private String wallBinary;
    private int x;
    private int y;

    public MazeCell(int a, int b, boolean pS, boolean bl){

        oldplace = pS;
        blank = bl;
        x = a;
        y = b;
        if(!blank){
            wallBinary = "1";
        }
        else{
            wallBinary = "0";
        }
    }

    public void setoldplace(){

        oldplace = true;
    }
    public boolean getBlank(){      

        return blank;
    }
    public boolean getoldplace(){

        return oldplace;
    }
    public void setwallBinary(String rep){

        wallBinary = rep;
    }
    public String coordinates(){

        return "{" + x + "," + y + "}";
    }
    public String toString(){

        return wallBinary;
    }
    public int getX(){

        return x;
    }
    public int getY(){

        return y;
    }
}
