package ekta.com.tictactoe_ekta.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ekta.com.tictactoe_ekta.R;

public class GameEndDialog extends DialogFragment {



    private View rootView;
    private GameActivity activity;
    private String winnerName;

    public static GameEndDialog newInstance(GameActivity activity, String winnerName) {
        GameEndDialog dialog = new GameEndDialog();
        dialog.activity = activity;
        dialog.winnerName = winnerName;
        return dialog;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initViews();
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setView(rootView)
                .setCancelable(false)
                .setPositiveButton(R.string.done, ((dialog, which) -> onNewGame()))
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }


    private void initViews() {
        rootView = LayoutInflater.from(getActivity())
                .inflate(R.layout.activity_game_end_dialog, null, false);
        ((TextView) rootView.findViewById(R.id.tv_winner)).setText(winnerName);
    }


    private void onNewGame() {
        dismiss();
        activity.promptForPlayers();
    }
}
