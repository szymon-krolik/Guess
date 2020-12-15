 package players;

import java.util.Random;

public abstract class Player {

    private Random brain = new Random();
    private String name;

    public Player(){}

    public Player(String name){
        setName(name);
    }


    public final void setName(String name){
        if( name != null && name.matches("^[a-zA-Z0-9$_\\-]{5,}$")){
            this.name = name;
        }else{
           throw new IllegalArgumentException("Zle imie");
        }
    }

    public final String getName(){
        return name;
    }

    public abstract int guess();

}
