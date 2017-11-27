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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.markuione.R;

/**
 * Created by anish on 24-11-2017.
 */

public class MaterialYearPicker extends Dialog {
    private Context context;
    private android.support.v7.widget.RecyclerView rvYears;
    private YearAdapter yearAdapter;
    private android.widget.ImageView imgLeft;
    private android.widget.TextView txtTitle;
    private android.widget.ImageView imgRight;

    public MaterialYearPicker(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_year_picker, null, false);
        this.imgRight = (ImageView) view.findViewById(R.id.imgRight);
        this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        this.imgLeft = (ImageView) view.findViewById(R.id.imgLeft);
        this.rvYears = (RecyclerView) view.findViewById(R.id.rvYears);
        setDialogProperties(view);

        initAdapter();
        initListener();
        show();
    }

    private void initListener() {
        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearAdapter.setYears(false);
            }
        });
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearAdapter.setYears(true);
            }
        });

    }

    private void initAdapter() {
        yearAdapter = new YearAdapter(context, new YearAdapter.YearSelectionListener() {
            @Override
            public void onYearSelected(int selectedYear) {
                Toast.makeText(context, "selected Year :" + selectedYear, Toast.LENGTH_SHORT).show();
//                dismiss();
            }
        });
        rvYears.setLayoutManager(new GridLayoutManager(context, 3));
        rvYears.setAdapter(yearAdapter);
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
