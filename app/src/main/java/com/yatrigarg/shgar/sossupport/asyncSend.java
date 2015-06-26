package com.yatrigarg.shgar.sossupport;

import java.util.Properties;
import java.util.Date;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class asyncSend extends AsyncTask<Void, Void, Void>{
    @Override
    protected Void doInBackground(Void... params) {
        Mail m = new Mail("postmaster@sandbox05ba2b4a8ba5489bb94ee9ec48fcd2f1.mailgun.org", "08137d2220452144f7eac66702922e2d");
        m.setHost("smtp.mailgun.org");
        String[] toArr = {"chivagarg@gmail.com"};
        //String[] toArr = {"we_can_help@cable.comcast.com"};
        //String[] toArr = {"attcustomercare@att.com"};
                m.setTo(toArr);
        //m.setFrom("blahblah@shivasapp.com");
        m.setFrom("postmaster@sandbox05ba2b4a8ba5489bb94ee9ec48fcd2f1.mailgun.org");
        m.setSubject("Is this working?");
        m.setBody("Are things broken?");
       // m.setPort("587");

        try {
            // m.addAttachment("/sdcard/filelocation");

            if(m.send()) {
                //Toast.makeText(MainActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
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