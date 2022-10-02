package Rec4;

import java.util.LinkedList;
import java.util.Iterator;


public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(){
        this.red = this.green = this.blue = 0;
    }
    public Color(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    static public int rand(){
        return (int)(Math.random() * (256));
    }

    static public Color randColor(){
        return new Color(Color.rand(),Color.rand(), Color.rand() );
    }

    public  String toString(){
        return "[R="+this.red + " ,G="+ this.green + " ,B=" + this.blue+ "]";
    }


    public static void main(String[] args) {
        LinkedList<Color> colors = new LinkedList<Color>();
        for (int i = 0; i <10; i++)
            colors.add(Color.randColor());
        System.out.println("Randoom colors: ");
        for (Iterator it = colors.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}

