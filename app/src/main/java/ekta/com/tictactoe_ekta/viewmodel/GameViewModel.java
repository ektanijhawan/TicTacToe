package ekta.com.tictactoe_ekta.viewmodel;

import java.util.Observable;

import android.databinding.ObservableArrayMap;

import ekta.com.tictactoe_ekta.model.Cell;
import ekta.com.tictactoe_ekta.model.Game;
import ekta.com.tictactoe_ekta.model.Player;

import static ekta.com.tictactoe_ekta.utilities.StringUtility.stringFromNumbers;

/**
 * Created by Ekta on 06-01-2018.
 */

public class GameViewModel extends Observable {

    private static final String TAG = GameViewModel.class.getSimpleName();
    private static final String NO_WINNER = "No one";
    public ObservableArrayMap<String, String> cells = new ObservableArrayMap<>();
    public Game game;

    public GameViewModel(String player1, String player2) {
        game = new Game();
        beginGame(new Player(player1, "x"), new Player(player2, "o"));
    }

    private void beginGame(Player player1, Player player2) {
        game.player1 = player1;
        game.player2 = player2;
        game.currentPlayer = player1;
    }

    public void onClickedCellAt(int row, int column) {
        game.cells[row][column] = new Cell(game.currentPlayer);
        cells.put(stringFromNumbers(row, column), game.currentPlayer.value);
        if (game.hasGameEnded())
            onGameHasEnded();
        game.switchPlayer();
    }

    private void onGameHasEnded() {
        setChanged();
        notifyObservers(game.winner == null ? NO_WINNER : game.winner.name);
        game.reset();
    }
}
