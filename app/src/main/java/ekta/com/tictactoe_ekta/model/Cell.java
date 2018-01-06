package ekta.com.tictactoe_ekta.model;

import ekta.com.tictactoe_ekta.utilities.StringUtility;

/**
 * Created by Ekta on 06-01-2018.
 */

public class Cell {
    public Player player;

    public Cell(Player player){ this.player = player;}

    public boolean isEmpty(){ return player==null || StringUtility.isNullOrEmpty(player.value);}
}
