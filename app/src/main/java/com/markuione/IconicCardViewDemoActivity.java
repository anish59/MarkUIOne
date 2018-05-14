package com.markuione;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.markuione.helper.FunctionHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import customWidgets.IconicCardView;
import customWidgets.yearAndMonthPickers.dialog.MaterialMonthPicker;
import customWidgets.yearAndMonthPickers.dialog.MaterialMonthYearPicker;
import customWidgets.yearAndMonthPickers.dialog.MaterialYearPicker;

public class IconicCardViewDemoActivity extends AppCompatActivity {

    private customWidgets.IconicCardView iconicCV;
    private Context context;
    private android.widget.Button btnShowYearPicker;
    private Button btnShowMonthPicker;
    private Button btnMyPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = IconicCardViewDemoActivity.this;
        setContentView(R.layout.activity_iconic_card_view_demo);
        this.btnShowYearPicker = (Button) findViewById(R.id.btnShowYearPicker);
        this.btnShowMonthPicker = (Button) findViewById(R.id.btnShowMonthPicker);
        this.btnMyPicker = (Button) findViewById(R.id.btnMyPicker);
        iconicCV = (IconicCardView) findViewById(R.id.iconicCV);
        View view = LayoutInflater.from(context).inflate(R.layout.dummy_layout, null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
        view.setLayoutParams(layoutParams);
        iconicCV.addInsideView(view);

        Calendar firstDate = Calendar.getInstance();

        Calendar lastDate = (Calendar) firstDate.clone();
        lastDate.add(Calendar.DAY_OF_MONTH, 7);

        List<String> stringDates = new ArrayList<>();
        stringDates = FunctionHelper.getDaysBetweenDates(firstDate.getTime(), lastDate.getTime(), "EEE, dd MMM");
        for (int i = 0; i < stringDates.size(); i++) {
            System.out.println("StringDate(" + i + ") = " + stringDates.get(i));
        }

        initListener();
    }

    private void initListener() {
        btnShowYearPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialYearPicker(context, new MaterialYearPicker.YearSelectionListener() {
                    @Override
                    public void onYearSelected(int selectedYear) {
                        Toast.makeText(context, "selected Year: " + selectedYear, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnShowMonthPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialMonthPicker(context);

            }
        });

        btnMyPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialMonthYearPicker(context, new MaterialMonthYearPicker.MonthYearSelectionListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onMonthYearSelected(String month, int year) {
                        btnMyPicker.setText(String.format("%s,%d", month, year));
                    }
                });
            }
        });
    }
}
