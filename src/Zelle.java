import java.util.Random;

public class Zelle {
    private int x, y;
    private boolean zustand;
    static Random rnd = new Random();

    Zelle(int x, int y, boolean zustand) {
        this.x = x;
        this.y = y;
        this.zustand = zustand;
    }

    Zelle(int x, int y) {
        this.x = x;
        this.y = y;
        zustand = rnd.nextBoolean();
    }

    public void setZustand(boolean zustand) {
        this.zustand = zustand;
    }

    public boolean getZustand() {
        return zustand;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }

    public String toString()
    {
        if(zustand) {
            return ".";
        }else{
            return "X";
        }
    }
}
