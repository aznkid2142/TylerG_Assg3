package lwtech.itad230.implicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void onSetAlarm(View view) {
        EditText hoursEditText = (EditText) findViewById(R.id.hour_text);
        int hourValue = Integer.parseInt(hoursEditText.getText().toString());

        EditText minuteEditText = (EditText) findViewById(R.id.minute_text);
        int minuteValue = Integer.parseInt(minuteEditText.getText().toString());

        EditText mEditText = (EditText) findViewById(R.id.message_text);
        String messageText = mEditText.getText().toString();

        // create an implicit intent with extras for a count down timer
        Intent alarmCountdown = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, messageText)
                .putExtra(AlarmClock.EXTRA_HOUR, hourValue)
                .putExtra(AlarmClock.EXTRA_MINUTES, minuteValue);
        if (alarmCountdown.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(alarmCountdown, 0);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int x = 0;
    }
}