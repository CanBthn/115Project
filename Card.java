public class Card {
    private String colors;
    private int values;
    
    public Card(String color, int value){
        colors = color;
        values = value;
    }
    public Card(){   
    }
    public String getColor(){
        return colors;
    }
    public void setColor(String color){
        color = colors;
    }
    public int getValue(){
        return values;
    }
    public void setValue(int value){
        values = value;
    }
}