package com.applications.pulsus.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.applications.pulsus.R;
import com.applications.pulsus.utils.MyAppPrefsManager;


public class SplashActivity extends Activity {
  public static int SPLASH_TIME_OUT = 3000;
  MyAppPrefsManager myAppPrefsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
*/
        myAppPrefsManager=new MyAppPrefsManager(this);

       new Handler().postDelayed(() -> {


           Intent intent = new Intent(getBaseContext(), HomeActivity.class);
           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
           startActivity(intent);
           finish();
          /* if (ConstantValues.IS_USER_LOGGED_IN = myAppPrefsManager.isUserLoggedIn()) {

               String conf_id=myAppPrefsManager.getUserConfId();
               String title=myAppPrefsManager.getUserConfTitle();
               Intent intent = new Intent(getBaseContext(), DashBoardActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
               intent.putExtra("id",conf_id);
               intent.putExtra("title",title);
               startActivity(intent);
               finish();

           } else {

               Intent intent = new Intent(getBaseContext(), HomeActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(intent);
               finish();
           }*/


       },SPLASH_TIME_OUT);
    }
}
