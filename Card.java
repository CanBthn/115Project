public class Card {
    private String signs;
    private String colors;
    private int values;
    
    public Card(String sign,String color, int value){
        colors = color;
        values = value;
        signs = sign;
    }
    public Card(){   
    }
    public String getColor(){
        return colors;
    }
    public void setColor(String color){
        colors = color;
    }
    public int getValue(){
        return values;
    }
    public void setValue(int value){
        values = value;
    }
    public String getSign(){
        return signs;
    }
    public void setSign(String sign){
        signs = sign;
    }
}