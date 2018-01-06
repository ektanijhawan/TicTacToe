package ekta.com.tictactoe_ekta.model;

/**
 * Created by Ekta on 06-01-2018.
 */

public class Player {

    public String name;
    public String value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
