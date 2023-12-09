import java.util.Random;

public class Game{
    public static void main(String[] args){
        Random rd = new Random(System.currentTimeMillis());
        Decks accessD = new Decks();
        accessD.PrintBeforeShuffle();
        accessD.Shuffle();
        accessD.dealCard();
        accessD.GameCards();
    }
}