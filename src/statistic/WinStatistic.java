package statistic;
import java.util.HashMap;
import java.util.Map;

public class WinStatistic implements Statistic {
    Map<String, Integer> scoreTable = new HashMap<>();

    public void updateScore(String playerName) {
        int score = scoreTable.getOrDefault(playerName,0);
        score++;
        scoreTable.put(playerName,score);
    }

    public void print() {
       for(Map.Entry<String,Integer> score : scoreTable.entrySet()) {
           System.out.println("Gracz: " + score.getKey() + " zdobył: " + score.getValue());
       }
    }

}


