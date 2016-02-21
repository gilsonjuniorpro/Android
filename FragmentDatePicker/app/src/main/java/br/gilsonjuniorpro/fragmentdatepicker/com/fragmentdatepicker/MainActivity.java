package br.gilsonjuniorpro.fragmentdatepicker.com.fragmentdatepicker;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, DialogInterface.OnCancelListener {

    private TextView tvTestDrive;
    private Button btTestDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTestDrive = (TextView) findViewById(R.id.tv_test_drive);
        btTestDrive = (Button) findViewById(R.id.bt_test_drive);
        btTestDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleTestDrive(v);
            }
        });
    }

    private int year, month, day, hour, minute;

    public void scheduleTestDrive(View view){
        initDateTimeData();
        Calendar cDefault = Calendar.getInstance();
        cDefault.set(year, month, day);

        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
            this,
            cDefault.get(Calendar.YEAR),
            cDefault.get(Calendar.MONTH),
            cDefault.get(Calendar.DAY_OF_MONTH)
        );

        Calendar cMin = Calendar.getInstance();
        Calendar cMax = Calendar.getInstance();
        cMax.set( cMax.get(Calendar.YEAR), 11, 31 );
        datePickerDialog.setMinDate(cMin);
        datePickerDialog.setMaxDate(cMax);

        List<Calendar> daysList = new LinkedList<>();
        Calendar[] daysArray;
        Calendar cAux = Calendar.getInstance();

        while( cAux.getTimeInMillis() <= cMax.getTimeInMillis() ){
            if( cAux.get( Calendar.DAY_OF_WEEK ) != 1 && cAux.get( Calendar.DAY_OF_WEEK ) != 7 ){
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis( cAux.getTimeInMillis() );

                daysList.add( c );
            }
            cAux.setTimeInMillis( cAux.getTimeInMillis() + ( 24 * 60 * 60 * 1000 ) );
        }
        daysArray = new Calendar[ daysList.size() ];
        for( int i = 0; i < daysArray.length; i++ ){
            daysArray[i] = daysList.get(i);
        }

        datePickerDialog.setSelectableDays( daysArray );
        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
    }

    private void initDateTimeData(){
        if( year == 0 ){
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        year = month = day = hour = minute = 0;
        tvTestDrive.setText("");
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        Calendar tDefault = Calendar.getInstance();
        tDefault.set(year, month, day, hour, minute);

        year = i;
        month = i1;
        day = i2;

        tvTestDrive.setText((day < 10 ? "0" + day : day) + "/" + (month + 1 < 10 ? "0" + (month + 1) : month + 1) + "/" + year);
    }
}