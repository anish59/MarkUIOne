package customWidgets.yearAndMonthPickers.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.markuione.R;

import java.util.Calendar;

/**
 * Created by anish on 29-11-2017.
 */

public class MaterialMonthYearPicker extends Dialog {
    private Context context;
    private int choosenYear;
    private android.widget.TextView txtTitle;
    private android.support.v7.widget.RecyclerView rvMonths;
    private MonthAdapter monthAdapter;
    private MonthYearSelectionListener mySelectionListener;//my > month year :p

    public MaterialMonthYearPicker(@NonNull Context context, MonthYearSelectionListener mySelectionListener) {
        super(context);
        this.context = context;
        this.mySelectionListener = mySelectionListener;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_month_picker, null, false);
        this.rvMonths = (RecyclerView) view.findViewById(R.id.rvMonths);
        this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        setDialogProperties(view);
        initAdapter();
        initListener();

        txtTitle.setText(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        show();
    }

    private void initAdapter() {
        rvMonths.setLayoutManager(new GridLayoutManager(context, 3));
        monthAdapter = new MonthAdapter(context, new MonthAdapter.MonthSelectionListener() {
            @Override
            public void onMonthSelected(String month) {
                int selectedYear = Integer.parseInt(txtTitle.getText().toString());
                mySelectionListener.onMonthYearSelected(month, selectedYear);
                dismiss();
            }
        });
        rvMonths.setAdapter(monthAdapter);
    }

    private void setDialogProperties(View view) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(view);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        getWindow().setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
    }

    private void initListener() {
        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialYearPicker(context, new MaterialYearPicker.YearSelectionListener() {
                    @Override
                    public void onYearSelected(int selectedYear) {
                        txtTitle.setText(String.valueOf(selectedYear));
                        if (selectedYear != Calendar.getInstance().get(Calendar.YEAR)) {
                            monthAdapter.setCurrentYear(false);
                        } else {
                            monthAdapter.setCurrentYear(true);
                        }
                    }
                });
            }
        });
    }

    public interface MonthYearSelectionListener {
        void onMonthYearSelected(String month, int year);
    }
}
