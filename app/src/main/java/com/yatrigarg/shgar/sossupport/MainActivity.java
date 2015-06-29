package com.yatrigarg.shgar.sossupport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "A5Zs7r9hVA05tzRfMhvL62r8jQrNUDN1BHX61nzE", "8Mii6JsnI3AbpDFM6vk6xo2pNxQ5cZatoOXl0UnU");
    }

    public void SendMail(View v) throws Exception
    {
        String senderTxt = ((TextView)findViewById(R.id.senderTxt)).getText().toString();
        String recipientTxt = ((TextView)findViewById(R.id.recipientTxt)).getText().toString();
        String subjectTxt = ((TextView)findViewById(R.id.subjectTxt)).getText().toString();
        String bodyTxt = ((TextView)findViewById(R.id.bodyTxt)).getText().toString();

        new asyncSend(this).execute(senderTxt, recipientTxt, subjectTxt, bodyTxt);
    }
}
