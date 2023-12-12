import java.util.Random;
public class Decks {
    Random rd = new Random(System.currentTimeMillis());
    Card[] deck;
    Card[] tempDeck;
    Card[] firstComputerCards = new Card[10]; // BEFORE SELECT 4 RANDOM CARDS
    Card[] firstPlayerCards = new Card[10]; //BEFORE SELECT 4 RANDOM CARDS
    String[] colors = {"R", "G", "Y", "B"};
    int idx = 0;

    Card[] playerDeck = new Card[4];
    Card[] computerDeck= new Card[4];
    Card[] tableDeck = new Card[30];


    //TO CREATE DECK
    public Decks(){
        deck = new Card[40];
        tempDeck= new Card[40];
        for(int i = 0; i<4; i++){
            for(int n = 0; n<10; n++){
                deck[idx] = new Card();
                deck[idx].setColor(colors[i]);
                deck[idx].setValue(n+1);
                tempDeck[idx] = new Card();
                tempDeck[idx].setColor(colors[i]);
                tempDeck[idx].setValue(n+1);
                idx++;
            }
        }
    }
    //TO SHOW BEFORE SHUFFLE
    public void PrintBeforeShuffle(){
        System.out.println("GAME İS STARTED\n**************");
        System.out.println("BEFORE SHUFFLE CARD");
        for(int i = 0; i<40; i++){
            System.out.print(deck[i].getColor()+deck[i].getValue() + " ");
        }System.out.print("\n");
    }
    //TO SHUFFLE AND SHOW AFTER SHUFFLE
    public void Shuffle(){
        System.out.println("CARDS ARE SHUFFLED");
        int a = rd.nextInt(0,40);
        String[] tempS = new String[40];
        int[] tempI = new int[40];
        for(int i=0; i<40; i++){
            tempS[i] = deck[i].getColor();
            tempI[i] = deck[i].getValue();
        }
        for(int i=0; i<40; i++){
            while(tempS[a]==null && tempI[a]==0){
                a = rd.nextInt(0,40);
            }
            deck[i].setColor(tempS[a]);
            deck[i].setValue(tempI[a]);
            tempDeck[i].setColor(tempS[a]);
            tempDeck[i].setValue(tempI[a]);
            tempS[a]=null;
            tempI[a]=0;
        }
        System.out.println("AFTER SHUFFLE CARD");
        for(int i = 0; i<40; i++){
            System.out.print(deck[i].getColor()+deck[i].getValue() + " ");
        }System.out.println();
        System.out.println("**************");
        System.out.print(" The first card of the game will be drawn from the end,\n" 
                                + " the first card will be given to the player,\n" 
                                + " the second card will be drawn from the beginning and\n" 
                                + " the second card will be given to the computer and this process will be repeated 5 times.\n**************");
                                System.out.println();
    }
    //TO CREATE RANDOM 5 CARD
    public void dealCard(){
        String[] tempRC1 = new String[5];
        int[] tempRV1 = new int[5];
        int idx=39;
        //THIS PART FOR FIRST 5 CARD
        for(int i=0; i<5; i++){
            firstComputerCards[i] = deck[i];
            firstPlayerCards[i] = deck[idx];
            idx--;
        }
        String[] tempTDC = new String[5];
        int[] tempTDV = new int[5];
        int counter = 5;
        for(int i=0; i<5; i++){
            tempTDC[i]=deck[counter].getColor();
            tempTDV[i]=deck[counter].getValue();
            counter++;
        }
        System.out.println("CARDS WERE DEALT \nRANDOM CARDS ARE CREATED");
        //FIRST RANDOM CARD
        for(int i = 0; i<3; i++){
            int a = rd.nextInt(0,4);
            int b = rd.nextInt(1, 7);
            tempRC1[i] = colors[a];
            tempRV1[i] = b;
            for(int m=0; m<1; m++){
                int r = rd.nextInt(0,2);
                if(r==0) {
                    tempRV1[i] = (tempRV1[i]*=-1);
                }
        }
    }
        int countDot = 0;
        int countCardsOrder=3;
        while(countDot <=1){
            int c = rd.nextInt(0,10);
            int[] control = {1,1,1,1,1,1,1,1,0,0};
            if(control[c]==1){
                for(int i = 3; i<5; i++){
                    int a = rd.nextInt(0,4);
                    int b = rd.nextInt(1, 7);
                    tempRC1[i] = colors[a];
                    tempRV1[i] = b;
                    for(int m=0; m<1; m++){
                        int r = rd.nextInt(0,2);
                        if(r==0) {
                            tempRV1[i] *= -1;
                        }
                    }
                }countDot++;
                countCardsOrder++;        
            } 
            else {
                int lucky = rd.nextInt(0,2);
                if(lucky == 0){
                    tempRV1[countCardsOrder] = (tempRV1[countCardsOrder]*0)-1;
                    tempRC1[countCardsOrder]= "FLIP";
                }
                else {
                    tempRV1[countCardsOrder]= (tempRV1[countCardsOrder]*0)+2;
                    tempRC1[countCardsOrder]= "DOUBLE(X)";
                }
                countDot++;
                countCardsOrder++;
            }
        }
        for(int i=5; i<10; i++){
            firstComputerCards[i] = deck[i];
            firstPlayerCards[i] = deck[idx];
            idx--;
        }
        int a=0;
        for(int i=5; i<10; i++){
            firstComputerCards[i].setColor(tempRC1[a]);
            firstComputerCards[i].setValue(tempRV1[a]);
            a++;
        }
        
        
        //SECOND RANDOM CARD
        String[] tempRC2 = new String[5];
        int[] tempRV2 = new int[5];
        for(int i = 0; i<3; i++){
            a = rd.nextInt(0,4);
            int b = rd.nextInt(1, 7);
            tempRC2[i] = colors[a];
            tempRV2[i] = b;
            for(int m=0; m<1; m++){
                int r = rd.nextInt(0,2);
                if(r==0) {
                    tempRV2[i] = (tempRV2[i]*=-1);
                }
        }
    }
        countDot = 0;
        countCardsOrder=3;
        while(countDot <=1){
            int c = rd.nextInt(0,10);
            int[] control = {1,1,1,1,1,1,1,1,0,0};
            if(control[c]==1){
                for(int i = 3; i<5; i++){
                    a = rd.nextInt(0,4);
                    int b = rd.nextInt(1, 7);
                    tempRC2[i] = colors[a];
                    tempRV2[i] = b;
                    for(int m=0; m<1; m++){
                        int r = rd.nextInt(0,2);
                        if(r==0) {
                            tempRV2[i] *= -1;
                        }
                    }
                }countDot++;
                countCardsOrder++;        
            } 
            else {
                int lucky = rd.nextInt(0,2);
                if(lucky == 0){
                    tempRV2[countCardsOrder] = (tempRV2[countCardsOrder]*0)-1;
                    tempRC2[countCardsOrder]= "FLIP";
                }
                else {
                    tempRV2[countCardsOrder]= (tempRV2[countCardsOrder]*0)+2;
                    tempRC2[countCardsOrder]= "DOUBLE(X)";
                }
                countDot++;
                countCardsOrder++;
            }
        }
        a = 0;
        for(int i=5; i<10; i++){
            firstPlayerCards[i].setColor(tempRC2[a]);
            firstPlayerCards[i].setValue(tempRV2[a]);
            a++;
        }
    }
    //TO SELECT RANDOM GAME CARDS AND AFTER DEAL DECK
    public void GameCards(){
        
        /*System.out.print("**************\nCOMPUTER CARDS\n");
        for(int i=0; i<10; i++){
            System.out.print(firstComputerCards[i].getColor()+firstComputerCards[i].getValue()+",");
        }
        System.out.println();
        System.out.print("**************\nPLAYER CARDS\n");
        for(int i=0; i<10; i++){
            System.out.print(firstPlayerCards[i].getColor()+firstPlayerCards[i].getValue()+",");
        }*/
        
        int random = rd.nextInt(0,10);
        int[] controlarray = {1,1,1,1,1,1,1,1,1,1};
        for(int i = 0; i<4; i++){
            random = rd.nextInt(0,10);
            while(controlarray[random]==0){
                random = rd.nextInt(0,10);
                continue;
            }
            computerDeck[i] = firstComputerCards[random];
            controlarray[random]=0;
            }
        random = rd.nextInt(0,10);
        int[] controlarray2 = {1,1,1,1,1,1,1,1,1,1};
        for(int i = 0; i<4; i++){
            random = rd.nextInt(0,10);
            while(controlarray2[random]==0){
                random = rd.nextInt(0,10);
                continue;
            }
            playerDeck[i] = firstPlayerCards[random];
            controlarray2[random]=0;
            }
        /*System.out.println("**************\nCOMPUTER DECK");
        for(int i=0; i<4; i++){
            System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue()+",");
        }
        System.out.println("\n**************\nPLAYER DECK");
        for(int i=0; i<4; i++){
            System.out.print(playerDeck[i].getColor()+playerDeck[i].getValue()+",");
        }
        System.out.println("**************\nDECK");*/
        System.out.println("PLAYERS IS STARTED\n**************");
        int counter3=5;
        for(int i = 0; i<30; i++){
            tableDeck[i]=tempDeck[counter3];
            counter3++;
        }
        /*
        for(int i=0; i<30; i++){
            System.out.print(tableDeck[i].getColor()+tableDeck[i].getValue()+",");
        }
        System.out.println();*/
    }
}