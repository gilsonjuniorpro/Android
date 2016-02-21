package br.gilsonjuniorpro.fragmentdatepicker.com.fragmentdatepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by gilsonjuniorpro on 21/02/16.
 */
@SuppressLint("ValidFragment")
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText txtdate;

    public DateDialog(View view) {
        txtdate = (EditText) view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the dialog
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //show to the selected date in the text box
        String date = dayOfMonth + "-" + (monthOfYear + 1)+"-"+year;
        txtdate.setText(date);
    }

}
