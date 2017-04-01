package com.delaroystudios.MatchFood.application;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.interceptors.ParseLogInterceptor;

import android.app.Application;
import android.util.Log;

/**
 * Created by erick on 31/03/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("myAppId") // should correspond to APP_ID env variable
                .clientKey("ESR32319667MF")  // set explicitly unless clientKey is explicitly configured on Parse server
                .addNetworkInterceptor(new ParseLogInterceptor())
                .server("https://sharefoodproject.herokuapp.com/parse/").build());

        login("lucasc", "password");

    }

    public void signUp(String username, String password, String email){
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

// other fields can be set just like with ParseObject

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("USER", "CRIADO");
                } else {

                }
            }
        });
    }

    public void login(String name, String password){
        ParseUser.logInInBackground(name, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    Log.d("USER", "LOGADO");
                } else {
                }
            }
        });
    }
}