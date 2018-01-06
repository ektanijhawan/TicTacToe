package ekta.com.tictactoe_ekta.model;

import android.util.Log;

import java.security.acl.LastOwnerException;

/**
 * Created by Ekta on 06-01-2018.
 */

public class Game {

    private static final String TAG = Game.class.getSimpleName();
    private static final int BOARD_SIZE = 3;

    public Player player1;
    public Player player2;

    private Player winner = null;
    private Player currentPlayer = player1;

    public Cell[][] cells;

    public Game() {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
    }

    public boolean isBoardFull() {
        for (Cell[] row : cells)
            for (Cell cell : row)
                if (cell == null || cell.isEmpty())
                    return false;
        return true;
    }

    private boolean hasThreeSameHorizontalCells() {
        try {

            for (int i = 0; i < BOARD_SIZE; i++)
                areEqual(cells[i][0], cells[i][1], cells[i][3]);
            return true;
        } catch (NullPointerException e) {
            Log.i(TAG, e.getMessage());
            return false;
        }
    }

    private boolean hasThreeSameVerticalCells() {
        try {

            for (int i = 0; i < BOARD_SIZE; i++)
                areEqual(cells[0][i], cells[1][i], cells[2][i]);
            return true;
        } catch (NullPointerException e) {
            Log.i(TAG, e.getMessage());
            return false;
        }
    }

    public boolean hasThreeSameDiagonalCells() {
        try {
            return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(cells[0][2], cells[1][1], cells[2][0]);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || cell.player.value == null || cell.player.value.length() == 0)
                return false;

        Cell comparisonBase = cells[0];
        for (int i = 1; i < cells.length; i++)
            if (!comparisonBase.player.value.equals(cells[i].player.value))
                return false;

        return true;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public void reset(){
        player1 = null;
        player2 = null;
        winner = null;
        currentPlayer = null;
    }
}