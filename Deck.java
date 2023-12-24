import java.util.Random;

public class Deck{
    Random rd = new Random(System.currentTimeMillis());
    private Card[] deck = new Card[40];
    private Card[] temp = new Card[40];
    private Card[] randomCards = new Card[5];
    private Card[] playerDeck = new Card[10];
    private Card[] computerDeck = new Card[10];
    Card[] boardDeck = new Card[30];
    Card[] playerDeckRandom4 = new Card[4];
    Card[] computerDeckRandom4 = new Card[4];

    private String[] colors = {"B", "B", "Y", "B"};  // RED GREEN YELLOW BLUE
    //private String[] colors = {"B", "B", "B", "B"};  // Control BlueJack(sumValue=20) Win Game
    private String[] signs = {"+", "-", ""};

    public Deck(){
        int counter = 0;
        for(int i = 0; i<4; i++){
            for(int n = 1; n<11; n++){
                deck[counter] = new Card(signs[0],colors[i], n);
                counter++;
            }
        }
    }        
    public void PrintBeforeShuffle(){
            System.out.println("Game Is Started\n**************\nBefore Shuffle Card");
            for(int i = 0; i<40; i++){
                System.out.print(deck[i].getSign()+deck[i].getColor()+deck[i].getValue() + " ");
            }
        }
    public void Shuffle(){
        int random = rd.nextInt(0,40);
        for(int i=0; i<40; i++){
            while(temp[random]!=null) random = rd.nextInt(0,40);
            temp[random] = deck[i];
            }
            System.out.print("\n**************\nThe first card of the game will be drawn from the end,\n" 
                                    + " the first card will be given to the player,\n" 
                                    + " the second card will be drawn from the beginning and\n" 
                                    + " the second card will be given to the computer and this process will be repeated 5 times.\n**************\nAfter Shuffle Card");
                                    System.out.println();
        for(int i=0; i<40; i++){
            deck[i] = temp[i];
            System.out.print(deck[i].getSign()+deck[i].getColor()+deck[i].getValue() + " ");
        }System.out.println();
    }
    public void DealCard(){
        int idx = 39;
        for(int i=0; i<5; i++){
            playerDeck[i]=deck[idx];
            computerDeck[i]=deck[i];
            idx--;
            }
    int counter =5;
    for(int i=0; i<30; i++){
        boardDeck[i] = deck[counter];
        counter++;
        }
    }
    public void randomCards(){
        for(int attemp = 0; attemp<2; attemp++){
            for(int i = 0; i<3; i++){
                int x = 0;
                int color = rd.nextInt(0,4);
                int value = rd.nextInt(1,7);
                int sign = rd.nextInt(0,2);
                if(sign == 0){value*=-1;
                    x =1;}
                randomCards[i] = new Card(signs[x],colors[color], value);
            }
            int counterCard = 3;
            for(int i = 0; i<2; i++){
                int x = 0;
                int random = rd.nextInt(1,101);
                if(random <= 80){
                    int color = rd.nextInt(0,4);
                    int value = rd.nextInt(1,7);
                    int sign = rd.nextInt(0,2);
                    if(sign == 0){value*=-1;
                        x =1;}
                    randomCards[counterCard] = new Card(signs[x],colors[color], value);
                    counterCard++;
                }else{
                    int DorF = rd.nextInt(0,2);
                    if(DorF==0) randomCards[counterCard] = new Card(signs[2],"DOUBLE(X)",2);
                    else {
                        randomCards[counterCard] = new Card(signs[2],"FLIP(X)", 1);
                        randomCards[counterCard].setValue(randomCards[counterCard].getValue()*-1);;
                    }
                    counterCard++;
                }
            }
            if(attemp==0){
                int counter = 0;
                for(int i = 5; i<10; i++){
                    playerDeck[i] = new Card(randomCards[counter].getSign(),randomCards[counter].getColor(),randomCards[counter].getValue());
                    counter++;
            }
            /*System.out.println();
            for(int i = 0; i<5; i++){
                System.out.print(randomCards[i].getColor()+randomCards[i].getValue() + ",");
            }*/
            }else{
                int counter = 0;
                for(int i = 5; i<10; i++){
                    computerDeck[i] = new Card(randomCards[counter].getSign(),randomCards[counter].getColor(),randomCards[counter].getValue());
                    counter++;
                }
                /*System.out.println();
                for(int i = 0; i<5; i++){
                    System.out.print(randomCards[i].getColor()+randomCards[i].getValue() + ",");
                }*/
            }   
        }
        System.out.print("**************\nCards Were Dealt\nRandom Cards Are Created");
    }
    public void SelectRandomCard(){
        int[] controlArray = {0,1,2,3,4,5,6,7,8,9};
        for(int attemp = 0; attemp<2; attemp++){
            if(attemp==0){
            for(int i = 0; i<4; i++){
                int random = rd.nextInt(0,10);
                while(controlArray[random]==-1) random = rd.nextInt(0,10);
                playerDeckRandom4[i] = playerDeck[random];
                controlArray[random]=-1;
            }
        }else{
            int[] controlArray2 = {0,1,2,3,4,5,6,7,8,9};
            for(int i = 0; i<4; i++){
                int random = rd.nextInt(0,4);
                while(controlArray2[random]==-1) random = rd.nextInt(0,10);
                computerDeckRandom4[i] =computerDeck[random];
                controlArray2[random]=-1;
                }
            }
        }System.out.println("Random cards were dealt 4 random cards were selected from 10 cards of each player.");
        /*System.out.println("\nPlayer Deck");
        for(int i = 0; i<10; i++){
            System.out.print(playerDeck[i].getColor()+playerDeck[i].getValue() + ",");
        }System.out.println("\nComputer Deck");
        for(int i = 0; i<10; i++){
            System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue() + ",");
        }System.out.println();
        */
    }}