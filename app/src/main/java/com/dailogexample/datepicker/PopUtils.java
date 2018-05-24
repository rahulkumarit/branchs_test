package com.dailogexample.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class PopUtils {

    public static void showDatePicker(final Context context, final DatePickerDialog.OnDateSetListener dateSetListener) {
        int mYear, mMonth, mDay, mHour, mMinute;
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateSetListener.onDateSet(view, year, monthOfYear, dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        c.add(Calendar.DATE, 60);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

}
