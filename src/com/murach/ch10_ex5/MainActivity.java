package com.esparza.Project5_TestTimer;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView messageTextView;
    private Timer timer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        startTimer();
    }
    
    private void startTimer() {
        final long startMillis = System.currentTimeMillis();
        timer = new Timer(true);
        TimerTask task = new TimerTask() {
            
            @Override
            public void run() {
                long elapsedMillis = System.currentTimeMillis() - startMillis;
                updateView(elapsedMillis);
            }
        };
        timer.schedule(task, 0, 1000);
    }

    private void updateView(final long elapsedMillis) {
        // UI changes need to be run on the UI thread
        messageTextView.post(new Runnable() {

            int elapsedSeconds = (int) elapsedMillis/1000;

            @Override
            public void run() {
                messageTextView.setText("Seconds: " + elapsedSeconds + 10000);
            }
        });
    }

    private stopTimer()
    {
        timer.cancel();
    }

    @Override
    protected void onPause()
    {
        stopTimer();
        super.onPause();
    }
}