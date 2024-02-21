import java.awt.Color;

public class Word {
    char letter;
    Color color;
    String[] wordlist;

    public Word(){
        letter = 'a';
        color = new Color(40,40,40);
        
        
    }
    
    public Word(char c, int r, int g, int b){
        letter = c;
        color = new Color(r,g,b);
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
}
