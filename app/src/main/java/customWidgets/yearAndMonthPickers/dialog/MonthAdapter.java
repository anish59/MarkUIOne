package customWidgets.yearAndMonthPickers.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.markuione.R;
import com.markuione.helper.FunctionHelper;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by anish on 28-11-2017.
 */

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MonthHolder> {
    private Context context;
    private List<String> months;
    private String currentMonth;
    private int lastClickedPosition = -1;
    private boolean isCurrentYear = true;
    private MonthSelectionListener monthSelectionListener;

    public MonthAdapter(Context context, MonthSelectionListener monthSelectionListener) {
        this.context = context;
        this.monthSelectionListener = monthSelectionListener;
        Calendar calendar = Calendar.getInstance();
        currentMonth = FunctionHelper.formatDate(calendar.getTime(), "MMM");
        setDefaultMonths();
    }

    private void setDefaultMonths() {
        months = new ArrayList<>();
        months = getMonths();
    }

    @Override
    public MonthHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_month, parent, false);
        return new MonthHolder(view);
    }

    @Override
    public void onBindViewHolder(final MonthHolder holder, int position) {
        holder.txtMonth.setText(months.get(position));

        if (months.get(position).equalsIgnoreCase(currentMonth)) {
            if (isCurrentYear) {
                holder.txtMonth.setBackground(context.getResources().getDrawable(R.drawable.bg_rectangle));
            }
        } else {
            holder.txtMonth.setBackground(null);
        }

        if (position == lastClickedPosition) {
            holder.txtMonth.setBackground(context.getResources().getDrawable(R.drawable.bg_rectangle_filled));
            monthSelectionListener.onMonthSelected(months.get(position));
        }

        holder.txtMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastClickedPosition = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return months.size();
    }

    public class MonthHolder extends RecyclerView.ViewHolder {

        private TextView txtMonth;

        public MonthHolder(View itemView) {
            super(itemView);
            txtMonth = (TextView) itemView.findViewById(R.id.txtMonth);
        }
    }

    List<String> getMonths() {
        List<String> monthsList = new ArrayList<String>();
        String[] months = new DateFormatSymbols().getMonths();
        for (String month : months) {
            System.out.println("month = " + month);
            monthsList.add(month.substring(0, 3));
        }
        return monthsList;
    }

    public void setCurrentYear(boolean currentYear) {
        isCurrentYear = currentYear;
        notifyDataSetChanged();
    }

    public interface MonthSelectionListener {
        void onMonthSelected(String month);
    }
}
