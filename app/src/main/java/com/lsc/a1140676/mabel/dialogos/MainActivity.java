package com.lsc.a1140676.mabel.dialogos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText editFecha;
    private EditText editHora;
    private int año,mes,dia,hora,minuto;
    private Calendar calendario= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFecha=(EditText) findViewById(R.id.editFecha);
        editHora=(EditText) findViewById(R.id.editHora);

        año=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DAY_OF_MONTH);
        hora=calendario.get(Calendar.HOUR_OF_DAY);
        minuto=calendario.get(Calendar.MINUTE);

        editFecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    showDialog(1);
            }
        });
        editFecha.requestFocus();
        editHora.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean hasFocus){
                if(hasFocus)
                    showDialog(2);
            }
        });

    }
    public void colocarFecha() {
        editFecha.setText(dia+"-"+mes+"-"+año);
    }

    public void colocarHora(){
        editHora.setText(hora+":"+minuto);
    }

    private DatePickerDialog.OnDateSetListener dateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            año=year;
            mes=month;
            dia=dayOfMonth;
            colocarFecha();
        }
    };
    private TimePickerDialog.OnTimeSetListener timeListener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hora=hourOfDay;
            minuto=minute;
            colocarHora();
        }
    };
    protected Dialog onCreateDialog(int id){
        switch (id){
            case 1:
                return new DatePickerDialog(this, dateListener, año, mes, dia);
            case 2:
                return new TimePickerDialog(this, timeListener, hora, minuto,true);
        }
        return null;
    }
}
