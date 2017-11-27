package customWidgets.yearAndMonthPickers.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.markuione.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by anish on 24-11-2017.
 */

public class YearAdapter extends RecyclerView.Adapter<YearAdapter.YearHolder> {
    private Context context;
    private List<Integer> yearList;
    private YearSelectionListener yearSelectionListener;
    private View view;
    private Calendar presentDay = Calendar.getInstance();

    public YearAdapter(Context context, YearSelectionListener yearSelectionListener) {
        this.context = context;
        this.yearSelectionListener = yearSelectionListener;
        keepDefaultList();
    }

    private void keepDefaultList() {
        yearList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int firstYear = currentYear - 4;
        Log.e("currentYear: ", "" + currentYear);
        setNineYears(firstYear);


    }

    public void setItems(List<Integer> yearList) {
        this.yearList = new ArrayList<>();
        this.yearList = yearList;
        notifyDataSetChanged();
    }

    @Override
    public YearHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_year, null, false);
        return new YearHolder(view);
    }

    @Override
    public void onBindViewHolder(final YearHolder holder, int position) {
        holder.txtYear.setText(String.valueOf(yearList.get(position)));
        if (yearList.get(position) == presentDay.get(Calendar.YEAR)) {
            holder.txtYear.setBackground(context.getResources().getDrawable(R.drawable.bg_rectangle));
        } else {
            holder.txtYear.setBackground(null);
        }
        holder.txtYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.txtYear.setBackground(context.getResources().getDrawable(R.drawable.bg_rectangle_filled));
                yearSelectionListener.onYearSelected(yearList.get(holder.getAdapterPosition()));
            }
        });

    }

    public void setYears(boolean isForward) {
        int firstItem = yearList.get(0);
        int lastItem = yearList.get(8);
        yearList = new ArrayList<>();
        if (isForward) {
            int firstYear = lastItem + 1;
            setNineYears(firstYear);
        } else {
            int firstYear = firstItem - 9;
            setNineYears(firstYear);
        }
    }

    private void setNineYears(int firstYear) {
        List<Integer> nineYears = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            nineYears.add(firstYear);
            firstYear++;
        }
        yearList.addAll(nineYears);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return yearList.size();
    }


    class YearHolder extends RecyclerView.ViewHolder {
        TextView txtYear;

        public YearHolder(View itemView) {
            super(itemView);
            txtYear = itemView.findViewById(R.id.txtYear);
        }
    }


    public interface YearSelectionListener {
        void onYearSelected(int selectedYear);
    }
}
