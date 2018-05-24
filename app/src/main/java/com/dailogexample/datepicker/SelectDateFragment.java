package com.dailogexample.datepicker;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerDialog.OnDateSetListener externalListener;

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener listener) {
        this.externalListener = listener;
    }

    @Override
    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("TestDate", 0);
        SharedPreferences.Editor et = pref.edit();
        et.putString("SavedDate", String.valueOf(dd + "/" + mm + "/" + yy));
        et.commit();
        Log.d("SavedDate : ", String.valueOf(dd + "/" + mm + "/" + yy));
        if (externalListener != null)
            externalListener.onDateSet(view, yy, mm, dd);
    }
}
