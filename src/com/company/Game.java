package com.company;

import players.Player;
import statistic.NullStatistic;
import statistic.WinStatistic;

import java.util.*;

public class Game {
    private List<Player> players = new ArrayList();
    private Random rand = new Random();

    private WinStatistic stats;

    public Game(WinStatistic stats){
        if (stats != null) {
            this.stats = stats;
        }else{
            this.stats = new NullStatistic();
        }

    }

    public void addPlayer(Player player) {

        for (Player user : players){
            if(player.getName().equals(user.getName())){
                findUniqueName(player.getName());
                player.setName(findUniqueName(player.getName()));
               // throw new IllegalArgumentException("Imie juz jest zajete");
            }
        }
        players.add(player);
    }

    public String findUniqueName(String name){
        name += rand.nextInt(10);
        return name;
    }

    public boolean playerExist(String name){
        for(Player user : players){
            if(user.getName().equals(name)){
                findUniqueName(name);
            }
        }
        return false;
    }


    public void removePLayer(String name) {
        Iterator<Player> iterator = players.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getName().equals(name)){
                iterator.remove();
            }
        }
    }

    public void printPLayers(){
        for (Player user : players){
            System.out.println(user.getName());
        }
    }


    public void play() {

        if (players.isEmpty()) {
            throw new IllegalArgumentException("Z kim mam grac?");
        } else {
            boolean tryAgain;
            do {

                System.out.println("---------------------");

                 int number = rand.nextInt(6) + 1;
                System.out.println("Kostka: " + number);

                tryAgain = true;

                for (Player user : players) {
                    int guess = user.guess();

                    System.out.println(user.getName() + " mowi, ze " + guess);

                    if (number == guess) {
                        System.out.println("Wygrana");
                        stats.updateScore(user.getName());
                        tryAgain = false;
                    } else {
                        System.out.println("ZLE!");
                    }
                }

            } while (tryAgain);
        }
    }

    public void printStats() {
        stats.print();
    }

}


