package ekta.com.tictactoe_ekta.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Observable;
import java.util.Observer;

import ekta.com.tictactoe_ekta.R;
import ekta.com.tictactoe_ekta.databinding.ActivityMainBinding;
import ekta.com.tictactoe_ekta.viewmodel.GameViewModel;

public class GameActivity extends AppCompatActivity implements Observer{

    private static final String GAME_BEGIN_DIALOG_TAG = "game_dialog_tag";
    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";
    private ActivityMainBinding activityGameBinding;
    private GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        promptForPlayers();
    }

    public void promptForPlayers() {
        GameBeginDialog gameBeginDialog = GameBeginDialog.newInstance(this);
        gameBeginDialog.show(getFragmentManager(),GAME_BEGIN_DIALOG_TAG);
    }

    public void onPlayersSet(String player1,String player2){
        initDataBinding(player1,player2);
    }

    private void initDataBinding(String player1, String player2) {
        activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        gameViewModel = new GameViewModel(player1,player2);
        activityGameBinding.setGameViewModel(gameViewModel);
        gameViewModel.addObserver(this);

    }

    @Override
    public void update(Observable observable, Object o) {
        GameEndDialog dialog = GameEndDialog.newInstance(this, (String) o);
        dialog.show(getFragmentManager(), GAME_END_DIALOG_TAG);
    }
}
