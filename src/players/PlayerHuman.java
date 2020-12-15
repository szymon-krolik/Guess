package players;

import java.util.Scanner;

public class PlayerHuman extends Player{
    public Scanner scan = new Scanner(System.in);

    public PlayerHuman(){}

    public PlayerHuman(String name){
        super(name);
    }

    @Override
    public int guess(){
        System.out.println("Podaj liczbe: ");
        return scan.nextInt();
    }
}
