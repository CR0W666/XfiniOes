package educanet.Logic;

import educanet.Player.Player;
import educanet.Presentation.Render;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public  Logic l = new Logic();
    public  Board b = new Board();
    public  Render r = new Render();

    public  ArrayList<Player> players = new ArrayList<>();
    public  ArrayList<String> usedSymbols = new ArrayList<>();
    public  ArrayList<String[]> board = new ArrayList<>();

    public  long turns = 0;
    public  int symbolWinCount = 4;

    public  String emptyChar = "-";


    public void init() {
        Scanner sc = new Scanner(System.in);
        l.charCreation(sc, this);
        r.showPlayers(players);

        //test(sc);
        gameLoop(sc);
        sc.close();
    }

    public void gameLoop(Scanner sc) {
        String wonID = "0"; //ID of player who has won !no player with ID 0!

        while(wonID.equals("0")) {
            for(Player player : players) {
                turns++;
                //Render.renderCycle(emptyChar);
                l.turn(player, sc, b, this);
                board = b.getBoardList();
                if(l.checkWinTwo(player,board, this)) wonID = player.getID();
            }
        }
        win(wonID);
    }


    /**
     winner method.
     * */
    public void win(String winnerID) {
        Player winner = l.getPlayerByID(players, winnerID);
        System.out.println(winner.getName() + " alias " + winner.getSymbol() + " has won the game in " + turns + " turns.");
    }

//------------- GETTERS ---------------------

    //region getters
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getUsedSymbols() {
        return usedSymbols;
    }

    public ArrayList<String[]> getBoard() {
        return board;
    }

    public String getEmptyChar() { return emptyChar; }
    //endregion

//-----------------------------------------


    //region testbed
    public void test(Scanner sc) {

        l.play("10", "10", new Player("test 1", "x", "1"), b);
        l.play("2", "4",   new Player("test 2", "o", "2"), b);
        l.play("0","0",    new Player("test 3", "z", "3"), b);
        l.play("30","0",   new Player("test 4", "s", "4"), b);
        l.play("15", "5",  new Player("test 5", "a", "5"), b);
        l.play("9", "10",  new Player("test 1", "x", "1"), b);
        l.play("8", "10",  new Player("test 1", "x", "1"), b);
        l.play("7", "10",  new Player("test 1", "x", "1"), b);


        System.out.println("----------------------");
        //r.printWholeBoard(b.getBoardList(), "-", l, this);

        System.exit(0);
    }
    //endregion
}
