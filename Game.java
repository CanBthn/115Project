import java.util.Scanner;
import java.util.Random;

public class Game{
    static int sumVComp=0; //Computer sum cards values
    static int sumVPlay=0; //Player sum cards values
    static int sumScoreComputer = 0; //Computer Score
    static int sumScorePlayer = 0; //Player Score
    static int cardCounter = 0;
    //THIS DECKS TO PLAY GAME
    static Card[] computerBoard = new Card[9];
    static Card[] playerBoard = new Card[9];
    static Card[] gameDeck;
    static Card[] playerDeck;
    static Card[] computerDeck;

    public static void plusScore(int sumVComp, int SumVPlay){
        int controlForComp = 20-sumVComp;
        int controlForPlay = 20-SumVPlay;
        if(controlForComp>controlForPlay){
            System.out.println("PLAYER SCORE +1");
            sumScorePlayer++;
        }if(controlForPlay>controlForComp){
            System.out.println("COMPUTER SCORE +1");
            sumScoreComputer++;
        }if(controlForComp=controlForPlay){
            System.out.println("TOTALS EQUAL SCORE UNCHANGED");
        }
        sumVComp=0;
        sumVPlay=0;
    }
    public static void PlayerUseCard(Card[] playerBoard){
        boolean a = true;
        while(a==true){
            try {
                if(playerBoard[8]==null){
                    int[] playerDeckControl = {1,1,1,1};
                    Scanner sc = new Scanner(System.in);
                    int i=0;
                System.out.println("PRESS 1 TO DRAW A CARD, 2 TO DISCARD YOUR CARD, 3 TO DISCONTINUE.");
                int which = sc.nextInt();
                while(which>=4 && which <=0){
                    System.out.println("PLEASE ENTER VALID VALUE");
                    which = sc.nextInt();
                }
                switch(which){
                    case 1:
                        while(playerDeckControl[which]==0){
                            System.out.println("CARD DISCARDED.PLEASE ENTER SELECT ANOTHER CARD");
                            which=sc.nextInt();
                            while(which>=4 && which <=0){
                                System.out.println("PLEASE ENTER VALID VALUE");
                                which = sc.nextInt();
                            }
                        }
                        playerBoard[i] = playerDeck[cardCounter];
                        playerDeckControl[which]=0;
                        playerDeck[cardCounter].setColor("X");
                        playerDeck[cardCounter].setValue(0);
                        cardCounter++;
                        i++;
                        a=false;
                        break;
                    case 2:
                        playerBoard[i]=gameDeck[cardCounter];
                        cardCounter++;
                        if(i-1!=0){
                            if(gameDeck[cardCounter].getColor()=="DOUBLE(X)"){
                                sumVPlay += playerBoard[i-1].getValue()*2;
                            }
                            else if(gameDeck[cardCounter].getColor()=="FLIP"){
                                playerBoard[i-1].setValue(playerBoard[i-1].getValue()*-1);
                            }else{
                                sumVPlay += playerBoard[i].getValue();
                            }
                        }else{
                        sumVPlay += playerBoard[i].getValue();
                        }
                        i++;
                        a=false;
                        break;
                    case 3:
                        while(i==0){
                            System.out.println("YOU CANNOT WITHDRAW FROM THE GAME WITHOUT DRAWING THE FIRST CARD.");
                            System.out.println("PLEASE ENTER AGAIN VALUE");
                            which=sc.nextInt();
                            if(which!=3) break;
                            continue;
                        }
                            a=false;
                            break;
                }
            }
            else{
                System.out.println("PLAYER CANNOT DRAW MORE CARDS");
            }  
        }
        catch (Exception InputMismatchException) {
                System.out.println("PLEASE ENTER VALID VALUE");
            }
        }
        gameDeck[cardCounter-1]=null;
    }
    public static void cardPrint(){
        for(int i = 0; i<4 ; i++){
            if(computerDeck[i].getValue()==0){
                System.out.print(computerDeck[i].getColor()+" ");
            }
            else{
                System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue()+ " ");
            }
        }
        System.out.println("PLAYER CARD\n************");
        for(int i = 0; i<4 ; i++){
            if(playerDeck[i].getValue()==0){
                System.out.print(playerDeck[i].getColor()+" ");
            }
            else{
            System.out.print(playerDeck[i].getColor()+playerDeck[i].getValue()+ " ");
                }
            }
            System.out.println("************");
        }
    
    public static void main(String[] args){
        Decks accessD = new Decks();
        computerDeck = accessD.computerDeck;
        playerDeck = accessD.playerDeck;
        gameDeck = accessD.tableDeck;
        accessD.PrintBeforeShuffle();
        accessD.Shuffle();
        accessD.dealCard();
        accessD.GameCards();
        PlayerUseCard(playerBoard);
        cardPrint();
    }
}