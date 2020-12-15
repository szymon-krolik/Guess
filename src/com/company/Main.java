package com.company;

import players.PlayerComp;

import statistic.WinStatistic;

public class Main {


    public static void main(String[] args) {

       Game game = new Game(new WinStatistic());
        //Game game = new Game(null);


        game.addPlayer(new PlayerComp("Tomek"));
        game.addPlayer(new PlayerComp("Kasia"));

        for (int i = 0; i < 100; ++i) {
            game.play();
        }



        game.printStats();

        //game.printPLayers();


    }
}