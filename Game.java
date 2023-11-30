import java.util.Random;
public class Game{
    public static void main(String[] args){
        Random rd = new Random(System.currentTimeMillis());
        Decks deck = new Decks();
        String[] BeforeGamerCards = new String[10]; // THIS IS FOR THE BEFORE RANDOM 4 CARDS
        String[] BeforeComputerCards = new String[10]; // THIS IS FOR THE BEFORE RANDOM 4 CARDS
        String[] PlayerCards = new String[4];
        String[] ComputerCards = new String[4];
        System.out.println("GAME İS STARTED");
        deck.CreateBeforeDeck();
        deck.Shuffle();
        System.out.println("\n The first card of the game will be drawn from the end,\n" 
                                + " the first card will be given to the player,\n" 
                                + " the second card will be drawn from the beginning and\n" 
                                + " the second card will be given to the computer and this process will be repeated 5 times.");
        int a = 39;                         // Access last card of Deck
        for(int i=0; i<5; i++){
            BeforeComputerCards[i]=deck.Deck[i];
            BeforeGamerCards[i]=deck.Deck[a];     //ŞUAN BURADA GELDİĞNDE İLK 5 KART DAĞITILDI
            a--;
        }
        String[] temp = new String[5];
        deck.GenerateCard(temp); // FONSKİYONA GECİCİ 5 LİK BİR ARRAY YOLLAYIP RANDOM CARDLARI ALDIM
        int counter2=0;
        int counter3=0;

        for(int i=5; i<10; i++){
            BeforeGamerCards[i] = temp[counter2]; //BURADA O RANDOM KARTLARI GAMER CARDINA EKLEDİM
            counter2++;
        }
        deck.GenerateCard(temp);
        for(int i=5; i<10; i++){
            BeforeComputerCards[i] = temp[counter3]; //BURADA O RANDOM KARTLARI GAMER CARDINA EKLEDİM
            counter3++;
        }
        System.out.println("PLAYER HANDS");
        for(int i=0; i<10; i++){
            System.out.print(BeforeGamerCards[i]+",");  // GAMER KARTLARI BASTIRILDI.
        }
        System.out.println("\nCOMPUTER HANDS");
        for(int i=0; i<10; i++){
            System.out.print(BeforeComputerCards[i]+","); // COMPUTER KARTLARI BASTIRILDI.
        }System.out.println();

        for(int i=0; i<4; i++){
            int select = rd.nextInt(0,10);
            int select2 = rd.nextInt(0,10); // This is to not open again loop for computer cards
            while(BeforeGamerCards[select]=="0"){
                select=rd.nextInt(0,10);
                continue;
            }
            PlayerCards[i] = BeforeGamerCards[select];
            BeforeGamerCards[select]="0";
            while(BeforeComputerCards[select2]=="0"){
                select2=rd.nextInt(0,10);
                continue;
            }
            ComputerCards[i] = BeforeComputerCards[select2];
            BeforeComputerCards[select2]="0";
        }
        System.out.println("PLAYER HANDS");
        for(int i=0; i<4; i++){
            System.out.print(PlayerCards[i]+",");  // YENİ PLAYER KARTLARI BASTIRILDI.
        }
        System.out.println("\nCOMPUTER HANDS");
        for(int i=0; i<4; i++){
            System.out.print(ComputerCards[i]+","); // YENİ COMPUTER KARTLARI BASTIRILDI.
        }System.out.println();

    }
}