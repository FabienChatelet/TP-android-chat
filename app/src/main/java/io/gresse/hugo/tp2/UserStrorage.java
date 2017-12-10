package io.gresse.hugo.tp2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Dev on 09/12/2017.
 */

public class UserStrorage {

    private static final String USER_NAME = "USER_NAME";
    private static final String USER_EMAIL = "email@test.fr";
    private static SharedPreferences.Editor editor;
    private static SharedPreferences setting;


    // Instantiate singleton object
    private UserStrorage (){}


    public static void init(Context context)
    {
        if(editor == null)
            editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            setting = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
    }

    public static void saveUserInfo(String name, String email) {

        editor.putString(USER_NAME, name);
        editor.putString(USER_EMAIL, email);
        editor.apply();
    }

    public static String getUserMail() {
        String email = setting.getString(USER_EMAIL, null);
        return email;

    }

    public static String getUserName() {
        String name = setting.getString(USER_NAME, null);
        return name;

    }


}
