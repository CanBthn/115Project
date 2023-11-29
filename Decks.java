import java.util.Random;;
public class Decks {
    Random rd = new Random(System.currentTimeMillis());

    private String[] DeckColors = {"B", "R", "G", "Y"};     //BLUE,RED,GREEN,YELLOW
    private String[] DeckNumbers = {"1","2","3","4","5","6","7","8","9","10"};
    private String[] BeforeDeck = new String[40];           //FOR BEFORE SHUFFLE
    public String[] deck = new String[40];                  //FOR AFTER SHUFFLE
    
    public Deck(){
        int counter = 0;
        for(int i=0; i<4; i++){
            for(int i2=0; i2<10; i2++){
                BeforeDeck[counter] = DeckColors[i] + DeckNumbers[i2];
                counter++;
            }
        }
    }
    
    public Shuffle(){
        System.out.println("Deck Before Shuffle.");
        for(int i=0; i<BeforeDeck.length; i++){
          System.out.println(BeforeDeck[i]);
        }
        //THIS PART TO SHUFFLE
        for(int i= 0; i<deck.length; i++){
            int a = rd.nextInt(0,40);
            while(BeforeDeck[a]=="0"){
                a = rd.nextInt(0,40);
                continue;
            }
            deck[i]=BeforeDeck[a];
            BeforeDeck[a]="0";
        }
        System.out.println("*********\nDeck After Shuffle.");
        for(int i= 0; i<deck.length; i++){
            System.out.println(deck[i]);
        }
    }

    public void setDeckColors(String colors){
        DeckColors = colors;
    }
    public void setDeckNumbers(String numbers){
        DeckNumbers = numbers;
    }
    public  getDeckColors() {
        return DeckColors;
    }
    public getDeckNumbers(){
        return DeckNumbers;
    }
}