package ekta.com.tictactoe_ekta.utilities;

/**
 * Created by Ekta on 06-01-2018.
 */

public class StringUtility {

    public static String stringFromNumbers(int... numbers){
        StringBuilder sNumbers = new StringBuilder();
        for(int number : numbers)
            sNumbers.append(number);
        return sNumbers.toString();
    }

    public static boolean isNullOrEmpty(String value){
        return value==null || value.length()==0;
    }
}
