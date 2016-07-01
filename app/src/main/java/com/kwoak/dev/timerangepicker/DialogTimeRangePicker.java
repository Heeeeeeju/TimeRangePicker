package com.kwoak.dev.timerangepicker;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by HEEJU on 2016-06-30.
 */
public class DialogTimeRangePicker extends Dialog {

    TextView buttonFrom;
    TextView buttonTo;
    TextView buttonCancel;
    TextView buttonOk;

    TimePicker pickerFrom;
    TimePicker pickerTo;

    onConfirmListener confirmListener;

    public DialogTimeRangePicker(Context context) {
        super(context, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
    }

    public DialogTimeRangePicker(Context context, int theme) {
        super(context, theme);
    }

    /**
     * method for change hour, minute of time picker 'from'
     * this should be called after DialogTimeRangePicker.show()
     * @param hour  hour
     * @param min   minute
     */
    public void setTimeFrom(int hour, int min) {
        if (Build.VERSION.SDK_INT < 23) {
            pickerFrom.setCurrentHour(hour);
            pickerFrom.setCurrentMinute(min);
        } else {
            pickerFrom.setHour(hour);
            pickerFrom.setMinute(min);
        }
    }

    /**
     * method for change hour, minute of time picker 'from'
     * this should be called after DialogTimeRangePicker.show()
     * same as DialogTimeRangePicker.setTimeFrom(int hour, int min)
     * @param calendar
     */
    public void setTimeFrom(Calendar calendar) {
        if (Build.VERSION.SDK_INT < 23) {
            pickerFrom.setCurrentHour(calendar.get(Calendar.HOUR));
            pickerFrom.setCurrentMinute(calendar.get(Calendar.MINUTE));
        } else {
            pickerFrom.setHour(calendar.get(Calendar.HOUR));
            pickerFrom.setMinute(calendar.get(Calendar.MINUTE));
        }
    }

    /**
     * method for change hour, minute of time picker 'to'
     * this should be called after DialogTimeRangePicker.show()
     * @param hour  hour
     * @param min   minute
     */
    public void setTimeTo(int hour, int min) {
        if (Build.VERSION.SDK_INT < 23) {
            pickerTo.setCurrentHour(hour);
            pickerTo.setCurrentMinute(min);
        } else {
            pickerTo.setHour(hour);
            pickerTo.setMinute(min);
        }
    }

    /**
     * method for change hour, minute of time picker 'to'
     * this should be called after DialogTimeRangePicker.show()
     * same as DialogTimeRangePicker.setTimeTo(int hour, int min)
     * @param calendar
     */
    public void setTimeTo(Calendar calendar) {
        if (Build.VERSION.SDK_INT < 23) {
            pickerTo.setCurrentHour(calendar.get(Calendar.HOUR));
            pickerTo.setCurrentMinute(calendar.get(Calendar.MINUTE));
        } else {
            pickerTo.setHour(calendar.get(Calendar.HOUR));
            pickerTo.setMinute(calendar.get(Calendar.MINUTE));
        }
    }

    public interface onConfirmListener {
        /**
         *
         * @param fromHour  time for start hour
         * @param fromMin   time for start minute
         * @param toHour    time for end hour
         * @param toMin     time for end minute
         */
        public void confirmEvent(int fromHour, int fromMin, int toHour, int toMin);
    }

    public void setConfirmListener(onConfirmListener confirmListener) {
        this.confirmListener = confirmListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.3f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.time_container_layout);

        buttonCancel = (TextView) findViewById(R.id.container_button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        buttonOk = (TextView) findViewById(R.id.container_button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23) {
                    confirmListener.confirmEvent(
                            pickerFrom.getCurrentHour(), pickerFrom.getCurrentMinute(),
                            pickerTo.getCurrentHour(), pickerTo.getCurrentMinute());
                } else {
                    confirmListener.confirmEvent(
                            pickerFrom.getHour(), pickerFrom.getMinute(),
                            pickerTo.getHour(), pickerTo.getMinute());
                }
                dismiss();
            }
        });

        buttonFrom = (TextView) findViewById(R.id.container_button_from);
        buttonFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerFrom.setVisibility(View.VISIBLE);
                pickerTo.setVisibility(View.INVISIBLE);
            }
        });

        buttonTo = (TextView) findViewById(R.id.container_button_to);
        buttonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerFrom.setVisibility(View.INVISIBLE);
                pickerTo.setVisibility(View.VISIBLE);
            }
        });

        pickerFrom = (TimePicker) findViewById(R.id.container_picker_from);
        pickerTo = (TimePicker) findViewById(R.id.container_picker_to);
    }
}
