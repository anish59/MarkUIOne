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
import android.widget.Toast;

import com.markuione.R;

/**
 * Created by anish on 28-11-2017.
 */

public class MaterialMonthPicker extends Dialog {
    private Context context;
    private TextView txtTitle;
    private RecyclerView rvMonths;
    private MonthAdapter monthAdapter;

    public MaterialMonthPicker(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
        show();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_month_picker, null, false);
        this.rvMonths = (RecyclerView) view.findViewById(R.id.rvMonths);
        this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        setDialogProperties(view);

        initAdapter();
    }

    private void initAdapter() {
        rvMonths.setLayoutManager(new GridLayoutManager(context, 3));
        monthAdapter = new MonthAdapter(context, new MonthAdapter.MonthSelectionListener() {
            @Override
            public void onMonthSelected(String month) {
                Toast.makeText(context, "MonthSelected: " + month, Toast.LENGTH_SHORT).show();
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

}
