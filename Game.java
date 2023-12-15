import java.util.Scanner;
import java.util.Random;

public class Game{
    static int sumVComp=0; //Computer sum cards values
    static int sumVPlay=0; //Player sum cards values
    static int sumScoreComputer = 0; //Computer Score
    static int sumScorePlayer = 0; //Player Score
    static int computerCCounter=0;
    static int cardCounter = 0;
    static int boardCardCounter=0;
    static int i = 0;
    static int controlComputerNo=0;
    static int controlPlayerNo=0;
    static boolean a = true;
    //THIS DECKS TO PLAY GAME
    static Card[] computerBoard = new Card[9];
    static Card[] playerBoard = new Card[9];
    static Card[] gameDeck;
    static Card[] playerDeck;
    static Card[] computerDeck;

    public static void controlWinner(int controlForComp, int controlForPlay){
        if(controlForComp>20 || controlForPlay >20){
            if(controlForPlay>20){
                System.out.println("Computer Score +1");
                sumScoreComputer++;
            }if(controlForComp>20){
                System.out.println("Player Score +1");
                sumScorePlayer++;
            }
            for(int i=0; i<9; i++){
                computerBoard[i]=null;
                playerBoard[i]=null;
            }boardCardCounter=1;
            sumVComp=0;
            sumVPlay=0;
        }else if(controlComputerNo==1 && controlPlayerNo==1){
            if(controlForComp>controlForPlay){
                System.out.println("Computer Score +1");
                sumScoreComputer++;
            }if(controlForPlay>controlForComp){
                System.out.println("Player Score +1");
                sumScorePlayer++;
            }if(controlForComp==controlForPlay){
                System.out.println("Totals Equal Score Unchanged.");
            }for(int i=0; i<9; i++){
                computerBoard[i]=null;
                playerBoard[i]=null;
            }boardCardCounter=1;
            sumVComp=0;
            sumVPlay=0;
        }else if(playerBoard[8]!=null && computerBoard[8]!=null){
            if(controlForComp>controlForPlay){
                System.out.println("Computer Score +1");
                sumScoreComputer++;
            }if(controlForPlay>controlForComp){
                System.out.println("Player Score +1");
                sumScorePlayer++;
            }if(controlForComp==controlForPlay){
                System.out.println("Totals Equal Score Unchanged.");
                }for(int i=0; i<9; i++){
                    computerBoard[i]=null;
                    playerBoard[i]=null;
                }boardCardCounter=1;
            }
            System.out.println("COMPUTER SCORE = " + sumScoreComputer + " / PLAYER SCORE = " + sumScorePlayer);
        }
    public static void whoWin(int sumScoreComputer, int sumScorePlayer){
        if(sumScoreComputer==3 || sumScorePlayer==3){
            if(sumScoreComputer>sumScorePlayer){
                System.out.println("COMPUTER WIN");
            }
            if(sumScorePlayer>sumScoreComputer){
                System.out.println("PLAYER WIN");
            }
        }
    }
    public static void PlayerUseCard(Card[] playerBoard){
        if(sumVPlay<20){
            a = true;
            while(a==true){
                try {
                    if(playerBoard[8]==null){
                        int[] playerDeckControl = {1,1,1,1};
                        Scanner sc = new Scanner(System.in);
                    System.out.println("Press 1 To Draw A Card, 2 To Discard Your Card, 3 To Dıscontinue");
                    int which = sc.nextInt();
                    while(which>=4 && which <=0){
                        System.out.println("Please Enter Valid Value");
                        which = sc.nextInt();
                    }
                    switch(which){
                        case 1:
                        System.out.println("Which Card Do You Want To Dıscard?");
                        which=sc.nextInt();
                        while(which>=4 && which <=0){
                            System.out.println("Please Enter Valid Value");
                            which = sc.nextInt();
                        }
                        while(playerDeckControl[which]==0){
                            System.out.println("Card Dıscarded.Please Enter Select Another Card");
                            which=sc.nextInt();
                            while(which>=4 && which <=0){
                                System.out.println("Please Enter Valid Value");
                                which = sc.nextInt();
                                }
                            }
                            if(playerDeck[which].getColor()=="FLIP"){
                                sumVPlay -= playerBoard[i-1].getValue();
                            }
                            else if(playerDeck[which].getColor()=="DOUBLE(X)"){
                                sumVPlay += playerBoard[i-1].getValue();
                            }
                            else {
                                sumVPlay += playerDeck[which].getValue();
                            }
                            playerBoard[i] = playerDeck[which];
                            playerDeckControl[which]=0;
                            playerDeck[which]=null;
                            cardCounter++;
                            i++;
                            a=false;
                            break;
                        case 2:
                            playerBoard[i]=gameDeck[cardCounter];
                            cardCounter++;
                                if(gameDeck[cardCounter].getColor()=="DOUBLE(X)"){
                                    sumVPlay += playerBoard[i-1].getValue();
                                }
                                else if(gameDeck[cardCounter].getColor()=="FLIP"){
                                    sumVPlay -= playerBoard[i-1].getValue();
                                }else {
                                    sumVPlay += playerBoard[i].getValue();
                                }
                            i++;
                            a=false;
                            break;
                        case 3:
                            while(i==0){
                                System.out.println("You Cannot Withdraw From The Game Without The First Card.");
                                System.out.println("Please Enter Valid Value");
                                which=sc.nextInt();
                                if(which!=3) break;
                                continue;
                            }
                                a=false;
                                controlPlayerNo=1;
                                break;
                    }
                }
                else{
                    a=false;
                }  
            }
            catch (Exception InputMismatchException) {
                    System.out.println("Please Enter Valid Value");
                }
            }
            gameDeck[cardCounter-1]=null;
            }
        else{
            //System.out.println("Player lost.Computer Win +1 Point");
            a=false;
            }
        }
    public static void cardPrint(){
        System.out.println("************\nCOMPUTER CARD");
        for(int i = 0; i<4 ; i++){
            if(computerDeck[i]==null){ System.out.print(" ");
            }
            else{
                System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue()+ " ");
            }
        }
        System.out.print("\nCOMPUTER BOARD \t\t\tComputer Score " + sumVComp+ "\n");
        int deneme=0;
        for(int i = 0; i<9 ; i++){
            if(boardCardCounter==1){
                if(computerBoard[deneme]==null) System.out.print("x ");
                else System.out.print(computerBoard[i].getColor() + computerBoard[i].getValue()+ " ");
                deneme++;
            }
            else{
            if(computerBoard[i]==null) System.out.print("x ");
            else System.out.print(computerBoard[i].getColor()+computerBoard[i].getValue()+ " ");
        }
    }
        System.out.println("\n************\nPLAYER CARD");
        for(int i = 0; i<4 ; i++){
            if(playerDeck[i]==null){ System.out.print(" ");
            }
            else{
            System.out.print(playerDeck[i].getColor()+playerDeck[i].getValue()+ " ");
                }
            }
            System.out.println("\nPLAYER BOARD \t\t\tPlayer Score " + sumVPlay);
            for(int i = 0; i<9 ; i++){
                if(playerBoard[i]==null) System.out.print("x ");
                else System.out.print(playerBoard[i].getColor()+playerBoard[i].getValue()+ " ");
            }        System.out.println("\n************");
        }
        public static void ComputerUseCard(Card[] comptCards){
            boolean a = true; // a true iken
            boolean control =true;
            if(sumVComp<20){
                for(int i =0; i<4; i++){
                    if(computerDeck[i]==null){
                        continue;
                    }
                    if(computerDeck[i].getColor()=="B"){
                        if(computerDeck[i].getValue()+sumVComp<20){
                            computerBoard[computerCCounter]=computerDeck[i];
                            sumVComp+=computerDeck[i].getValue();
                            computerDeck[i]=null;
                            computerCCounter++;
                            a = false;
                            control=false;
                            i+=4;
                        }
                    }
                }while(a==true){
                    for(int i =0; i<4; i++){
                        if(i==3) a=false;
                        if(computerDeck[i]==null){
                            continue;
                        }
                        if(computerDeck[i].getColor()=="DOUBLE(X)" && computerCCounter!=0){
                            if(computerDeck[i].getValue()+sumVComp<20){
                                computerBoard[computerCCounter]=computerDeck[i];
                                sumVComp+=computerBoard[computerCCounter-1].getValue();
                                computerDeck[i]=null;
                                computerCCounter++;
                                control=false;
                                i+=4;
                            }
                        }
                    }
                }  
                while(control==true){
                    int d = 0;
                    int min =0;
                    for(int i = 0; i<4; i++){
                        if(computerDeck[i]==null){
                            if(i==3){ 
                                control=false;
                                break;
                        }
                            else continue;
                        }if(computerDeck[i].getValue()>0){
                            if(20-computerDeck[i].getValue()>min){ // - lerde sorun var
                                d=i;
                                computerBoard[computerCCounter]=computerDeck[d];
                                sumVComp+=computerDeck[d].getValue();
                                computerCCounter++;
                                computerDeck[d]=null;
                                control=false;
                                i+=4;
                        }
                    }else{
                        if(20+computerDeck[i].getValue()>min){
                            d=i;
                            computerBoard[computerCCounter]=computerDeck[d];
                            sumVComp+=computerDeck[d].getValue();
                            computerCCounter++;
                            computerDeck[d]=null;
                            control=false;
                            i+=4;
                        }
                    }
                    }
                }if(computerDeck[0]==null && computerDeck[1]==null && computerDeck[2]==null && computerDeck[3]==null){
                    if(sumVComp+gameDeck[cardCounter].getValue()<=20){
                        sumVComp+=gameDeck[cardCounter].getValue();
                        computerBoard[computerCCounter]=gameDeck[cardCounter];
                        computerCCounter++;
                        cardCounter++;
                    }
                }
            }
                else{
                    boolean c = true;
                    for(int i =0; i<4; i++){
                        if(i==3) a=false;
                        if(computerDeck[i]==null){
                            continue;
                        }
                        if(computerDeck[i].getColor()=="FLIP"){
                            if((computerDeck[i].getValue()*-1)+sumVPlay<20){
                                computerBoard[computerCCounter]=computerDeck[i];
                                sumVComp-=computerBoard[computerCCounter-1].getValue();
                                computerDeck[i]=null;
                                computerCCounter++;
                                c = false;
                                i+=4;
                                }
                            }
                        }
                        while(c ==false){
                            System.out.println("Computer Did Not Play Cards");
                            c=true;
                            controlComputerNo=1;
                            break;
                        }
                    }
                }
            
        public static void main(String[] args){
        Decks accessD = new Decks();
        //Bu kısım deckte hazırladığım oyun arraylerini burada rahat kullanmak için aktardığım kısım.
        computerDeck = accessD.computerDeck;
        playerDeck = accessD.playerDeck;
        gameDeck = accessD.tableDeck;
        accessD.PrintBeforeShuffle();
        accessD.Shuffle();
        accessD.dealCard();
        accessD.GameCards();
        int a = 0;
        while(true){
            if(a==0){ cardPrint(); 
                a++;
            }
                PlayerUseCard(playerBoard);
                ComputerUseCard(computerBoard);
                if(playerBoard[8]!=null){
                        cardPrint();
                        System.out.println("Player reaches maximum number of cards");
                        break;
                    }else{
                        cardPrint();
                    }  
                controlWinner(sumVComp, sumVPlay);
                whoWin(sumScoreComputer, sumScorePlayer);
                }
            }   
        }
    