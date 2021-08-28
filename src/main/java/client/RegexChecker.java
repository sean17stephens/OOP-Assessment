package client;
/* This class should contain static methods to verify input in the application
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexChecker
{
    public static boolean checkRegister(String num, String b){
        boolean match = false;
        try{
            String s = String.valueOf(num);
            Pattern pattern = Pattern.compile(b);
            Matcher matcher = pattern.matcher(s);
            match = matcher.find();
        }catch (PatternSyntaxException e){
            e.printStackTrace();
        }
        return match;
    }

    public static void checkUser(int user_id) {

        String pattern = "[0-9]{1,8}$";
        String check = String.valueOf(user_id);
        if (!RegexChecker.checkRegister(check, pattern)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkEmail(String email) {

        String pattern = "[a-zA-Z0-9]{8,}$";
        String check = String.valueOf(email);
        if (!RegexChecker.checkRegister(check, pattern)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkPassword(String password) {
        String pattern = "[a-zA-Z0-9]{8,}$";
        String check = String.valueOf(password);
        if (!RegexChecker.checkRegister(check, pattern))
        {
            throw new IllegalArgumentException();
        }

    }
}

