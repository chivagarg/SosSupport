package com.yatrigarg.shgar.sossupport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendMail(View v) throws Exception
    {
        TextView textView = (TextView)findViewById(R.id.textView);
        String content = textView.getText().toString();
       // Parse.Cl



        new asyncSend().execute();
        //new asyncSend().execute(new URL(), new Integer(0), new Long(1));
    }
}
