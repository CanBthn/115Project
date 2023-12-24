import java.util.Scanner;
import java.util.Random;
public class Game{
    static Card[] playerDeck = new Card[4];
    static Card[] computerDeck = new Card[4];
    static Card[] playerBoard = new Card[10];
    static Card[] computerBoard = new Card[10];
    static Card[] gameDeck = new Card[30];
    static int sumScorePlayer = 0;
    static int sumScoreComputer = 0;
    static int sumValuePlayer = 0;
    static int sumValueComputer = 0;
    static int deckCardCounter = 0; //Destede kaçıncı kartın çekileceğini bize söyleyecek
    static int playerCardCounter = 1;
    static int computerCardCounter = 1;
    static int playerStop = 0; // oyuncu 3 e basarsa
    static int computerStop = 0; //artık kart atmayacaksa
    static int roundControl = 0;
    static int printControl = 0; 
    static int wrongControl=0;
    static int printCard = 0;

    public static void PrintCard(){
        if(printControl==0){
            playerBoard[0] = gameDeck[deckCardCounter];
            computerBoard[0] = gameDeck[deckCardCounter+1];
            sumValuePlayer+=gameDeck[deckCardCounter].getValue();
            sumValueComputer+=gameDeck[deckCardCounter+1].getValue();
            printControl++;
            deckCardCounter +=2;
        }
        System.out.println("\n************\nPlayer Deck\t\t\tPlayer Score = " + sumValuePlayer + "\t\t\tPlayer Score = " + sumScorePlayer);
        for(int i = 0; i<4; i++){
            if(playerDeck[i]==null) System.out.print(" ");
            else {
                if(playerDeck[i].getValue()<0) System.out.print(playerDeck[i].getSign()+playerDeck[i].getColor()+playerDeck[i].getValue()*-1 + ",");
                else System.out.print(playerDeck[i].getSign()+playerDeck[i].getColor()+playerDeck[i].getValue() + ",");
            }}System.out.println("\nPlayer Board");
        for(int i = 0; i<10; i++){
            if(playerBoard[i]==null) System.out.print(" ");
            else {
                if(playerBoard[i].getValue()<0) System.out.print(playerBoard[i].getSign()+playerBoard[i].getColor()+playerBoard[i].getValue()*-1 + ",");
                else System.out.print(playerBoard[i].getSign()+playerBoard[i].getColor()+playerBoard[i].getValue() + ",");
            }}System.out.println("\n************\nComputer Deck\t\t\tComputer Score = " + sumValueComputer + "\t\t\tComputer Score = " + sumScoreComputer);
        for(int i = 0; i<4; i++){
            if(computerDeck[i]==null) System.out.print(" ");
            else {
                if(computerDeck[i].getValue()<0) System.out.print(computerDeck[i].getSign()+computerDeck[i].getColor()+computerDeck[i].getValue()*-1 + ",");
                else System.out.print(computerDeck[i].getSign()+computerDeck[i].getColor()+computerDeck[i].getValue() + ",");
            }}System.out.println("\nComputer Board");
        for(int i = 0; i<10; i++){
            if(computerBoard[i]==null) System.out.print(" ");
            else {
                if(computerBoard[i].getValue()<0) System.out.print(computerBoard[i].getSign()+computerBoard[i].getColor()+computerBoard[i].getValue()*-1 + ",");
                else System.out.print(computerBoard[i].getSign()+computerBoard[i].getColor()+computerBoard[i].getValue() + ",");
            }}}
    public static void playerUseCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n************\nPlayer starts the game \nThe first card came from the deck\nPress 1 to draw a card, 2 to throw a card, 3 to pause.");
        try {
            int select = sc.nextInt();
            while(select>3 || select<1){
                System.out.println("Please enter valid value");
                select = sc.nextInt();
            }
            switch(select){
                case 1:
                    playerBoard[playerCardCounter] = gameDeck[deckCardCounter];
                    if(gameDeck[deckCardCounter].getColor()== "DOUBLE(X)") sumValuePlayer+=playerBoard[playerCardCounter-1].getValue();
                    else if(gameDeck[deckCardCounter].getColor()== "FLIP(X)") sumValuePlayer-=playerBoard[playerCardCounter-1].getValue();
                    else sumValuePlayer += gameDeck[deckCardCounter].getValue();
                    playerCardCounter++;
                    deckCardCounter++;
                    wrongControl=1;
                    break;
                case 2:
                    System.out.println("Which card do you want to discard?");
                    int selectCard = sc.nextInt();
                    if(selectCard>3 || selectCard<0){
                        while(selectCard>3 || selectCard<0){
                            System.out.println("Please enter valid value");
                            selectCard = sc.nextInt();
                            }
                    }else{
                        while(playerDeck[selectCard]==null){
                            System.out.println("Duplicate value.Please enter another value.");
                            selectCard = sc.nextInt();
                            while(selectCard>3 || selectCard<0){
                                System.out.println("Please enter valid value");
                                selectCard = sc.nextInt();
                            }
                        }
                        playerBoard[playerCardCounter]=playerDeck[selectCard];
                        if(playerDeck[selectCard].getColor()=="DOUBLE(X)") sumValuePlayer+=playerBoard[playerCardCounter-1].getValue();
                        else if(playerDeck[selectCard].getColor()=="FLIP(X)") sumValuePlayer-=playerBoard[playerCardCounter-1].getValue();
                        else sumValuePlayer+=playerDeck[selectCard].getValue();
                        playerDeck[selectCard]=null;
                        playerCardCounter++;
                    }
                    wrongControl=1;
                    break;
                case 3:
                    System.out.println("The player did not play a card. Waiting for the computer to finish.");
                    playerStop = 1;
                    wrongControl=1;
                    break;
                }
            }catch (Exception InputMismatchException) {
                System.out.println("Please Enter Valid Value");
                wrongControl=0;
            }}
    public static void computerUseCard(){
        int control=0;
        int control2=0;
        int control3=0;
        Random rd = new Random(System.currentTimeMillis());
        int select = rd.nextInt(0,2);
        if(sumValueComputer<20){
            for(int i = 0; i<4; i++){
                if(computerDeck[i]==null) System.out.println(" ");
                else if(computerDeck[i].getColor()=="B" & sumValueComputer+computerDeck[i].getValue()<=20){
                    for(int n = 0; n<4; n++){
                        if(computerDeck[n]==null) System.out.println(" ");
                        else if(computerDeck[n].getColor()=="B" & computerDeck[i].getValue()>computerDeck[n].getValue()){
                            control2=1;
                            control3=i;
                            break;
                        }}}}
            if(control2==1){
                computerBoard[computerCardCounter] = computerDeck[control3];
                sumValueComputer+=computerDeck[control3].getValue();
                computerDeck[control3]=null;
                computerCardCounter++;
                control=1;
            }
            if(control==0){
                if(select==0){ // burada kartı çekecek
                    computerBoard[computerCardCounter] = gameDeck[deckCardCounter];
                    if(gameDeck[deckCardCounter].getColor()=="DOUBLE(X)") sumValueComputer+=computerBoard[computerCardCounter-1].getValue();
                    else if(gameDeck[deckCardCounter].getColor()=="FLIP(X)") sumValueComputer-=computerBoard[computerCardCounter-1].getValue();
                    else sumValueComputer+=computerBoard[computerCardCounter].getValue();
                    deckCardCounter++;
                    computerCardCounter++;
                }else{  //burada kartı atacak
                    int selectCard = rd.nextInt(0,4);
                    while(computerDeck[selectCard]==null){
                        selectCard = rd.nextInt(0,4);
                    }
                    if(sumValueComputer+computerDeck[selectCard].getValue()<=20){
                    computerBoard[computerCardCounter]=computerDeck[selectCard];
                    if(computerDeck[selectCard].getColor()=="DOUBLE(X)") sumValueComputer+=computerBoard[computerCardCounter-1].getValue();
                    else if(computerDeck[selectCard].getColor()=="FLIP(X)") sumValueComputer-=computerBoard[computerCardCounter-1].getValue();
                    else sumValueComputer+=computerBoard[computerCardCounter].getValue();
                    computerDeck[selectCard]=null;
                    computerCardCounter++;
                        }
                    }
            }
        }
    else System.out.println("Computer does not send card");
    computerStop = 1;
    }
    public static void whoWinRound(){
        if(sumValueComputer==20 || sumValuePlayer==20){
            int sumComp = 0;
            for(int i = 0; i<computerCardCounter; i++){
                if(computerBoard[i].getColor()=="B") sumComp+=computerBoard[i].getValue();
            }if(sumComp==20) sumScoreComputer+=3;
            int sumPlayer = 0;
            for(int i = 0; i<playerCardCounter; i++){
                if(playerBoard[i].getColor()=="B") sumPlayer+=playerBoard[i].getValue();
            }if(sumPlayer==20) sumScorePlayer+=3;
        }
        if(sumValuePlayer>20 || sumValueComputer>20){  // 20 den herhangi biri büyük olursa bi anda bitir
            if(sumValuePlayer>20) {
                System.out.println("COMPUTER +1 SCORE");
                sumScoreComputer++;
            }
            else if(sumValueComputer>20){
                System.out.println("PLAYER +1 SCORE");
                sumScorePlayer++;
            }
            roundControl = 1;
            printCard=1;
            System.out.print("************\nRESULT DECK");
        }else if(playerStop==1 && computerStop==1){     //eğer ikisi de kart oynamyacaksa bak bakalım
            if(sumValuePlayer-sumValueComputer<0) sumScoreComputer++;
            else if(sumValuePlayer-sumValueComputer>0) sumScorePlayer++;
            else System.out.println("Scores equal score unchanged");
            roundControl = 1;
            printCard=1;
            System.out.print("************\nRESULT DECK");
        }}
    public static void roundChange(){
        if(roundControl == 1){
            for(int i = 0; i<computerCardCounter; i++){
                computerBoard[i]=null;
            }
            for(int i = 0; i<playerCardCounter; i++){
                playerBoard[i]=null;
            }
            computerCardCounter=1;
            playerCardCounter=1;
            sumValueComputer=0;
            sumValuePlayer=0;
            roundControl=0;
            computerStop=0;
            playerStop=0;
            printControl=0;
        }}
    public static void deckCounter(){
        if(deckCardCounter==29) System.out.println("ALL DECK IS FINISH");
            computerStop=0;
            playerStop=0;
        }
    public static void whoWinner(){
        if(sumScoreComputer==3) System.out.println("\n********\nCOMPUTER IS WINNER\n********");
        if(sumScorePlayer==3) System.out.println("\n********\nPLAYER IS WINNER\n********");
    }
    public static void main(String[] args){
            Deck deck = new Deck();
            computerDeck = deck.computerDeckRandom4;
            playerDeck = deck.playerDeckRandom4;
            gameDeck = deck.boardDeck;
            deck.PrintBeforeShuffle();
            deck.Shuffle();
            deck.DealCard();
            deck.randomCards();
            deck.SelectRandomCard();
            while(sumScoreComputer<3 && sumScorePlayer<3){
                printCard=0;
                PrintCard();
                playerUseCard();
                if(wrongControl==1){
                computerUseCard();
                whoWinRound();
                if(printCard==1){
                    PrintCard();
                    System.out.print("\n************\nNEW GAME DECK");}
                roundChange();
                whoWinner();
                deckCounter();
                }}}}