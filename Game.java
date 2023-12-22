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
    

    public static void PrintCard(){
        if(playerBoard[0] ==null && computerBoard[0] ==null){ // Burası her round 0 dan başlayınca deckten gelsin diye
            playerBoard[0] = gameDeck[deckCardCounter];
            computerBoard[0] = gameDeck[deckCardCounter+1];
            sumValuePlayer+=gameDeck[deckCardCounter].getValue();
            sumValueComputer+=gameDeck[deckCardCounter+1].getValue();
            System.out.println("************\nPlayer Deck\t\t\tPlayer Score = " + sumValuePlayer);
            for(int i = 0; i<4; i++){
                if(playerDeck[i]==null) System.out.print(" ");
                else System.out.print(playerDeck[i].getColor()+playerDeck[i].getValue() + ",");
            }System.out.println("\nPlayer Board");
            for(int i = 0; i<10; i++){
                if(playerBoard[i]==null) System.out.print(" ");
                else System.out.print(playerBoard[i].getColor()+playerBoard[i].getValue() + ",");
            }
            System.out.println("\n************\nComputer Deck\t\t\tComputer Score = " + sumValueComputer);
            for(int i = 0; i<4; i++){
                if(computerDeck[i]==null) System.out.print(" ");
                else System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue() + ",");
            }System.out.println("\nComputer Board");
            for(int i = 0; i<10; i++){
                if(computerBoard[i]==null) System.out.print(" ");
                else System.out.print(computerBoard[i].getColor()+computerBoard[i].getValue() + ",");
            }deckCardCounter +=2; //durmadan burada eklemeler yapacak
        }
        else{
            System.out.println("************\nPlayer Deck\t\t\tPlayer Score = " + sumValuePlayer);
            for(int i = 0; i<4; i++){
                if(playerDeck[i]==null) System.out.print(" ");
                else System.out.print(playerDeck[i].getColor()+playerDeck[i].getValue() + ",");
            }System.out.println("\nPlayer Board");
            for(int i = 0; i<10; i++){
                if(playerBoard[i]==null) System.out.print(" ");
                else System.out.print(playerBoard[i].getColor()+playerBoard[i].getValue() + ",");
            }
            System.out.println("\n************\nComputer Deck\t\t\tComputer Score = " + sumValueComputer);
            for(int i = 0; i<4; i++){
                if(computerDeck[i]==null) System.out.print(" ");
                else System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue() + ",");
            }System.out.println("\nComputer Board");
            for(int i = 0; i<10; i++){
                if(computerBoard[i]==null) System.out.print(" ");
                else System.out.print(computerBoard[i].getColor()+computerBoard[i].getValue() + ",");
            }
        }
    }
    public static void playerUseCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n************\nPlayer starts the game \nThe first card came from the deck\nPress 1 to draw a card, 2 to throw a card, 3 to pause.");
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
                break;
            case 3:
                System.out.println("The player did not play a card. Waiting for the computer to finish.");
                break;
        }
    }
    public static void computerUseCard(){
        Random rd = new Random(System.currentTimeMillis());
        int select = rd.nextInt(0,2);
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
            computerBoard[computerCardCounter]=computerDeck[selectCard];
            if(computerDeck[selectCard].getColor()=="DOUBLE(X)") sumValueComputer+=computerBoard[computerCardCounter-1].getValue();
            else if(computerDeck[selectCard].getColor()=="FLIP(X)") sumValueComputer-=computerBoard[computerCardCounter-1].getValue();
            else sumValueComputer+=computerBoard[computerCardCounter].getValue();
            computerDeck[selectCard]=null;
            computerCardCounter++;
        }
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
        PrintCard();
        int i = 0;
        while(i<10){
        playerUseCard();
        computerUseCard();
        PrintCard();
        i++;
        }
        }
    }