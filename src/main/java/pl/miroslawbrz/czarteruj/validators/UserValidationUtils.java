package pl.miroslawbrz.czarteruj.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidationUtils {

    public static boolean checkStringFromInput(String pattern, String inputString){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputString);
        return m.matches();
    }
}
