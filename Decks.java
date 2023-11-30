import java.util.Random;;
public class Decks {
    Random rd = new Random(System.currentTimeMillis());
    private String[] DeckColors = {"B", "R", "G", "Y"};     //BLUE,RED,GREEN,YELLOW
    private String[] DeckNumbers = {"1","2","3","4","5","6","7","8","9","10"};
    private String[] BeforeDeck = new String[40];           //FOR BEFORE SHUFFLE
    public String[] Deck = new String[40];                  //FOR AFTER SHUFFLE
    // THIS PLACE TO CREATE BEFOREDECK
    public void CreateBeforeDeck(){
        int counter = 0;
        for(int i=0; i<4; i++){
            for(int i2=0; i2<10; i2++){
                BeforeDeck[counter] = DeckColors[i] + DeckNumbers[i2];
                counter++;
            }
        }
    }
    // THIS PLACE TO SHUFFLE AND CREATE GAME DECK => Deck[i] AFTER PRINT THIS ARRAY
    public void Shuffle(){
        System.out.println("Deck Before Shuffle.");
        for(int i=0; i<BeforeDeck.length; i++){
          System.out.print(BeforeDeck[i]+",");
        }
        //THIS PART TO SHUFFLE
        for(int i= 0; i<Deck.length; i++){
            int a = rd.nextInt(0,40);
            while(BeforeDeck[a]=="0"){
                a = rd.nextInt(0,40);
                continue;
            }
            Deck[i]=BeforeDeck[a];
            BeforeDeck[a]="0";
        }
        System.out.println("\nDeck After Shuffle.");
        for(int i= 0; i<Deck.length; i++){
            System.out.print(Deck[i]+",");
        }
    }
    // THIS PART GENERATE RANDOM CARD OF LAST 5 CARDS
    public String[] GenerateCard(String[] randomCard){
        for(int i = 0; i<3; i++){
            int a = rd.nextInt(0,4); // FOR THE COLOR
            int b = rd.nextInt(1, 7); // FOR THE NUMBER
            randomCard[i] = DeckColors[a] + DeckNumbers[b];
            for(int m=0; m<1; m++){         //Thıs part what is the card sign.(+ or -)
                int r = rd.nextInt(0,2);
                if(r==0) randomCard[i] = "-" + randomCard[i];
                else randomCard[i] = "+" + randomCard[i];
            }
        }
        int n = 0;
        int countDot = 3;
        while(n<2){
            int[] control = {1,1,1,1,1,1,1,1,0,0}; // This array for the 80% lucky
            int c = rd.nextInt(0,10);
            if(control[c]==1){ // This part if 80% lucky
                for(int i = 3; i<5; i++){
                    int a = rd.nextInt(0,4); // FOR THE COLOR
                    int b = rd.nextInt(1, 7); // FOR THE NUMBER
                    randomCard[i] = DeckColors[a] + DeckNumbers[b];
                    for(int m=0; m<1; m++){         //Thıs part what is the card sign.(+ or -)
                        int r = rd.nextInt(0,2);
                        if(r==0) randomCard[i] = "-" + randomCard[i];
                        else randomCard[i] = "+" + randomCard[i];
                    }
                }countDot++;          
            } 
            else {                                     // this part if 20% lucky
                int lucky = rd.nextInt(0,2);
                if(lucky == 0){
                    randomCard[countDot]= "+/-"; // + number -,negation number will be positive
                }
                else {
                    randomCard[countDot]= "*2"; // will product with this card.
                }
                countDot++;
            }
            n++;
        }
        return randomCard;
    }
    //BURAYA OYUN BAŞLAMADAN TEKRARDAN BAKILACAK
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
    public void setBeforeDeck(int[] beforedeck){
        BeforeDeck = beforedeck;
    }
    public void setDeck(int[] deck){
        Deck = deck;
    }
    public String[] getBeforeDeck() {
        return BeforeDeck;
    }  
    public String[] getDeck(){
        return Deck;
    }
}