import java.util.Scanner;
import java.util.Random;

public class Game{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random(System.currentTimeMillis());
        Decks accessD = new Decks();
        accessD.PrintBeforeShuffle();
        accessD.Shuffle();
        accessD.dealCard();
        accessD.GameCards();

        int sumVComp=0; //Computer sum cards values
        int sumVPlay=0; //Player sum cards values
        int sumScoreComputer = 0; //Computer Score
        int sumScorePlayer = 0; //Player Score
        Card[] computerBoard = new Card[9];
        Card[] playerBoard = new Card[9];
    }
}