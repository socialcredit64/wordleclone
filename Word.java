import java.awt.Color;
import java.util.ArrayList;

public class Word {
    char letter;
    Color color;
    String[] wordlist;
    int red;
    int blue;
    int green;

    public Word(){
        letter = 'a';
        color = new Color(40,40,40);
        red = 70;
        green = 70;
        blue = 70;
        
    }
    
    public Word(char c, int r, int g, int b){
        letter = c;
        red = r;
        green = g;
        blue = b;
    }

    public char getLetter(){
        return letter;
    }
    public Color getColor(){
        return color;
    }
    public void setLetter(char c){
        letter = c;
    }
    public int getR(){
        return red;
    }
    public int getG(){
        return green;
    }
    public int getB(){
        return blue;
    }
    
    public void checkLetter(String answer, int column){ 
        if (letter == answer.charAt(column)){ //green
            red = 37;
            green = 163;
            blue = 0;
        } 
        else {
            if (letter == answer.charAt(0) || letter == answer.charAt(1)|| letter == answer.charAt(2)|| letter == answer.charAt(3)|| letter == answer.charAt(4)){
                red = 250;
                green = 250;
                blue = 0;
            }
            else {
                red = 70;
                green = 70;
                blue = 70;
            }
        }
        
    }
}

