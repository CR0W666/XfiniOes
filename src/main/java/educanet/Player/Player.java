package educanet.Player;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private String name;
    private String symbol;
    private final String ID;

    private ArrayList<String[]> playHistory = new ArrayList<>(); //UNUSED -> maybe can speed up the checkWin method later

    public Player(String name, String symbol, String ID) {
        this.name = name;
        this.symbol = symbol;
        this.ID = ID;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getID() {
        return ID;
    }

    public void savePlay(String[] pos) {
        playHistory.add(pos);
    }

    public ArrayList<String[]> getPlayHistory() {
        return playHistory;
    }

    public String[] getLastPlay() {
        if (playHistory == null || playHistory.size() == 0) {
            return null;
        }
        return playHistory.get(playHistory.size()-1);
    }

    public void savePlay(String x, String y) {
        savePlay(new String[]{x,y});
    }



}
