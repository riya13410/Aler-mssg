package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify(View view) {
        EditText E1=(EditText)findViewById(R.id.editTextTextMultiLine) ;
        Intent intent=new Intent(this,resultactivity.class) ;
        PendingIntent pending=PendingIntent.getActivity(this,0,intent,0) ;
        Notification noti=new Notification.Builder(this)
                .setContentTitle("New Message")
                .setContentText(E1.getText().toString()).setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pending).build() ;
        NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE) ;
        noti.flags |=Notification.FLAG_AUTO_CANCEL ;
        manager.notify(0,noti);
    }
}