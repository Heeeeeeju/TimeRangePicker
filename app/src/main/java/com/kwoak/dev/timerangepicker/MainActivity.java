package com.kwoak.dev.timerangepicker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by HEEJU on 2016-06-30.
 */
public class MainActivity extends Activity {

    DialogTimeRangePicker dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new DialogTimeRangePicker(MainActivity.this);
        dialog.show();
        dialog.setVisibleTo(true);
        dialog.setTimeFrom(5, 0);
        dialog.setTimeTo(6, 30);
        dialog.setConfirmListener(new DialogTimeRangePicker.onConfirmListener() {
            @Override
            public void confirmEvent(int fromHour, int fromMin, int toHour, int toMin) {
                Toast.makeText(getApplicationContext(),
                        String.format("%02d:%02d ~ %02d:%02d", fromHour, fromMin, toHour, toMin),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
