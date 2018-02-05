package com.bitcamp.app.scheduler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateToday = findViewById(R.id.date_today);
        final CalendarView calendarView = findViewById(R.id.calendar_view);
        final TimePicker timePicker = findViewById(R.id.time_picker);
        final TextView dateYear = findViewById(R.id.date_year);
        final TextView dateMonth = findViewById(R.id.date_month);
        final TextView dateDay = findViewById(R.id.date_day);
        final TextView dateHour = findViewById(R.id.date_hour);
        final TextView dateMin = findViewById(R.id.date_min);
        timePicker.setVisibility(View.INVISIBLE);
        dateToday.setText(String.valueOf(new SimpleDateFormat("현재시간 : yyyy-MM-dd HH:mm").format(new Date())));
        findViewById(R.id.date_radio_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.time_radio_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.reservation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arr = date.split("-");
                dateYear.setText(arr[0]);
                dateMonth.setText(arr[1]);
                dateDay.setText(arr[2]);
                dateHour.setText(String.valueOf(timePicker.getHour()));
                dateMin.setText(String.valueOf(timePicker.getMinute()));
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                date = year + "-" + (month+1) +"-"+day;
            }
        });
    }
}
