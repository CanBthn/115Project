import java.util.Random;
public class Decks {
    Random rd = new Random(System.currentTimeMillis());
    public Card[] deck;
    String[] colors = {"R", "G", "Y", "B"};
    int idx = 0;

    Decks(){
        deck = new Card[40];
        for(int i = 0; i<4; i++){
            for(int n = 0; n<10; n++){
                deck[idx] = new Card();
                deck[idx].setColor(colors[i]);
                deck[idx].setValue(n+1);
                idx++;
            }
        }
    }
    public void PrintBeforeShuffle(){
        System.out.println("GAME İS STARTED");
        System.out.println("BEFORE SHUFFLE CARD");
        for(int i = 0; i<40; i++){
            System.out.print(deck[i].getColor()+deck[i].getValue() + ",");
        }System.out.print("\n");
    }
    public void Shuffle(){
        System.out.println("CARDS ARE SHUFFLED");
        Card[] TempDeck = deck;
        int[] controlArray = new int[40];

        for(int i = 0; i<40; i++){ 
            controlArray[i]=i;
        }

        for(int i= 0; i<deck.length; i++){
            int a = rd.nextInt(0,40);
            while(controlArray[a]==0){
                a=rd.nextInt(0, 40);
                if(i==39){
                    break;
                }
                continue;
            }
            deck[i].setColor(TempDeck[a].getColor());
            deck[i].setValue(TempDeck[a].getValue());
            controlArray[a]=0;
            } 

        System.out.println("AFTER SHUFFLE CARD");
        for(int i = 0; i<40; i++){
            System.out.print(deck[i].getColor()+deck[i].getValue() + " ");
        }System.out.println();
    }
}