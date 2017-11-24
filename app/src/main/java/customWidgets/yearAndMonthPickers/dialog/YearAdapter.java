package customWidgets.yearAndMonthPickers.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public YearAdapter(Context context) {
        this.context = context;
        keepDefaultList();
    }

    private void keepDefaultList() {
        yearList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        Log.e("", "");
    }

    public void setItems(List<Integer> yearList) {
        this.yearList = new ArrayList<>();
        this.yearList = yearList;
        notifyDataSetChanged();
    }

    @Override
    public YearHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_year, null, false);
        return new YearHolder(view);
    }

    @Override
    public void onBindViewHolder(YearHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    class YearHolder extends RecyclerView.ViewHolder {
        public YearHolder(View itemView) {
            super(itemView);
        }
    }
}
