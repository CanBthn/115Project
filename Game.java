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
    static int controlPlayerStop=0;
    static boolean controlPlayerStop2=true;
    static boolean controlComputerStop2=true;
    static boolean a = true; // For the player
    static boolean arrayNull=true;
    static int counterForArrayNullComputer = 0;
    static int counterForArrayNullPlayer = 0;
    static int controlRound = 0;
    static int controlRoundForFirst=0;
    
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
            controlRound++;
            boardCardCounter=1;
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
            }
            controlRound++;
            boardCardCounter=1;
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
                }
                controlRound++;
                boardCardCounter=1;
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
                        if(controlRoundForFirst==0){
                        System.out.println("Press 1 To Draw A Card, 2 To Discard Your Card, 3 To Dıscontinue"
                                            +"\nFirst round can not press 1");
                        }
                        else{
                        System.out.println("Press 1 To Draw A Card, 2 To Discard Your Card, 3 To Dıscontinue");
                        }
                        int which = sc.nextInt();
                        while(controlRoundForFirst==0){
                        while(which>=4 && which <=0){
                            System.out.println("Please Enter Valid Value");
                            which = sc.nextInt();
                        }
                        if(controlRoundForFirst==0 || which==1 || which==2 || which==3){
                            controlRoundForFirst++;
                            if(which==1){
                                controlRoundForFirst--;
                                while(controlRoundForFirst==0){
                                System.out.println("Please Enter Valid Value");
                                which = sc.nextInt();
                                if(which!=1){
                                    controlRoundForFirst++;
                                    break;
                                }
                    }
                }
            }
        }
                        switch(which){
                            case 1:
                            System.out.println("Which Card Do You Want To Dıscard?");
                            int which2=sc.nextInt();
                            while(which2>=4 && which2 <=0){
                                System.out.println("Please Enter Valid Value");
                                which2 = sc.nextInt();
                            }
                            while(playerDeckControl[which2]==0){
                                System.out.println("Card Dıscarded.Please Enter Select Another Card");
                                which2=sc.nextInt();
                                while(which2>=4 && which2<=0){
                                    System.out.println("Please Enter Valid Value");
                                which2 = sc.nextInt();
                                }
                            }
                            if(playerDeck[which2].getColor()=="FLIP"){
                                sumVPlay -= playerBoard[i-1].getValue();
                            }
                            else if(playerDeck[which2].getColor()=="DOUBLE(X)"){
                                sumVPlay += playerBoard[i-1].getValue();
                            }
                            else {
                                sumVPlay += playerDeck[which2].getValue();
                            }
                            playerBoard[i] = playerDeck[which2];
                            playerDeckControl[which2]=0;
                            playerDeck[which2]=null;
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
                            controlPlayerStop=1;
                            a=false;
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
            if(cardCounter==0){
                cardCounter++;
                gameDeck[cardCounter-1]=null;
            }else{
                gameDeck[cardCounter-1]=null;
            }
            }
        }
    public static void cardPrint(){
        if(sumScoreComputer>0 || sumScorePlayer>0){ //ilk round sonrası buraya girecek
            System.out.println("************\nCOMPUTER CARD");
            for(int i = 0; i<4 ; i++){
                if(computerDeck[i]==null){ System.out.print(" ");
                }
                else{
                    System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue()+ " ");
                }
            }
            System.out.print("\nCOMPUTER BOARD \t\t\tComputer Score " + sumVComp+ "\n");
            for(int i = 0; i<9 ; i++){
                    if(computerBoard[i]==null) System.out.print("x ");
                    else System.out.print(computerBoard[i].getColor()+computerBoard[i].getValue()+ " ");
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
    else{ //ilk round buraya girecek
        System.out.println("************\nCOMPUTER CARD");
        for(int i = 0; i<4 ; i++){
            if(computerDeck[i]==null){ System.out.print(" ");
            }
            else{
                System.out.print(computerDeck[i].getColor()+computerDeck[i].getValue()+ " ");
            }
        }
        System.out.print("\nCOMPUTER BOARD \t\t\tComputer Score " + sumVComp+ "\n");
        for(int i = 0; i<9 ; i++){
                if(computerBoard[i]==null) System.out.print("x ");
                else System.out.print(computerBoard[i].getColor()+computerBoard[i].getValue()+ " ");
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

        public static void arrayNull(int computer, int player){
            if(controlRound==1){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==2){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==3){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==4){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==5){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==6){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==7){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==8){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==8){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==9){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
        }
            if(controlRound==10){
                for(int i=0; i<computer; i++){
                    computerBoard[i]=null;
                }for(int i=0; i<player; i++){
                    playerBoard[i]=null;
            }counterForArrayNullComputer=0;
            counterForArrayNullPlayer=0;
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
        while(sumScoreComputer<3 && sumScorePlayer<3){
            //buradan
            if(a==0){ cardPrint(); 
                a++;
            }
            //buraya kadar tamam
            if(controlPlayerStop!=1){
                PlayerUseCard(playerBoard);
                counterForArrayNullPlayer++;
            } else controlPlayerStop2=false;
            if(sumVComp<20){
                ComputerUseCard(computerBoard);
                counterForArrayNullComputer++;
            } else controlComputerStop2=false;
            //buradan
            if(playerBoard[8]!=null){
                    cardPrint();
                        System.out.println("Player reaches maximum number of cards");
                        break;
                    }else{
                        cardPrint();
                    }
            //buraya kadar tamam
                controlWinner(sumVComp, sumVPlay);
                whoWin(sumScoreComputer, sumScorePlayer);
                arrayNull(counterForArrayNullComputer, counterForArrayNullPlayer);
                }
            }
}