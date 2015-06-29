package com.yatrigarg.shgar.sossupport;

import java.util.Properties;
import java.util.Date;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class asyncSend extends AsyncTask<String, Void, Void>{
    private boolean success = false;
    private final Context mContext;

    asyncSend(Context context)
    {
        mContext = context;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, success ? "Mail sent successfully!" : "Mail delivery failed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(String... params) {
        Mail m = new Mail("postmaster@sandbox05ba2b4a8ba5489bb94ee9ec48fcd2f1.mailgun.org", "08137d2220452144f7eac66702922e2d");
        m.setHost("smtp.mailgun.org");
        m.setFrom(params[0]);
        //String[] toArr = {"chivagarg@gmail.com"};
        //String[] toArr = {"we_can_help@cable.comcast.com"};
        //String[] toArr = {"attcustomercare@att.com"};
        String[] toArr = new String[1];
        toArr[0] = params[1];
        m.setTo(toArr);
        //m.setFrom("blahblah@shivasapp.com");
       // m.setFrom("postmaster@sandbox05ba2b4a8ba5489bb94ee9ec48fcd2f1.mailgun.org");
        m.setSubject(params[2]);
        m.setBody(params[3]);
        //m.setSubject("Is this working?");
        //m.setBody("Are things broken?");
       // m.setPort("587");

        try {
            // m.addAttachment("/sdcard/filelocation");

            if(m.send()) {
                success = true;
                //Toast.makeText(asyncSend.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
            } else {
               // Toast.makeText(MainActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
            Log.e("MailApp", "Could not send email", e);
        }
        return null;
    }
}