public class Card {
    private String color;
    private int value;

    Card(String color, int value){ // bu kısım herhangi bir değer almıyor
        this.color = color;
        this.value = value;
    }

    public Card(){   
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
}