package customWidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.markuione.R;

/**
 * Created by anish on 13-11-2017.
 */

public class IconicCardView extends LinearLayout {
    private int cardElevation;
    private Drawable imgSrc;
    private int imgWidth;
    private int imgHeight;
    private Context context;
    private LinearLayout insideContainer;

    public IconicCardView(Context context) {
        super(context);
        this.context = context;
    }

    public IconicCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicCardView, 0, 0);
        try {
            imgWidth = (int) a.getDimension(R.styleable.IconicCardView_imgWidth, getResources().getDimension(R.dimen.img_dimens));
            imgHeight = (int) a.getDimension(R.styleable.IconicCardView_imgHeight, getResources().getDimension(R.dimen.img_dimens));
            cardElevation = (int) a.getDimension(R.styleable.IconicCardView_cardElevation, getResources().getDimension(R.dimen.card_elevation));
            imgSrc = a.getDrawable(R.styleable.IconicCardView_imgSrc);
        } finally {
            a.recycle();
        }

        initializeViews(context);
    }


    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        inflater.inflate(R.layout.iconic_card, this);

        SetUpViews();
    }

    private void SetUpViews() {
        CircleImageView imgHolder = (CircleImageView) getRootView().findViewById(R.id.imgHolder);
        imgHolder.getLayoutParams().width = imgWidth;
        imgHolder.getLayoutParams().height = imgHeight;
        imgHolder.setImageDrawable(imgSrc);

        CardView cardView = (CardView) getRootView().findViewById(R.id.cardHolder);
        cardView.setMinimumHeight(((imgHeight * 50) / 100) + imgHeight);

        int sumHeight = ((imgHeight * 50) / 100) + imgHeight;
        System.out.println("imgMin_ht: " + sumHeight + "    " + imgHeight);

        insideContainer = (LinearLayout) getRootView().findViewById(R.id.insideContainer);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
        marginLayoutParams.setMargins((imgWidth / 2) - cardElevation, 0, 0, 0);

        cardView.setCardElevation(cardElevation);
        ((FrameLayout.LayoutParams) insideContainer.getLayoutParams()).setMargins(imgWidth / 2, 0, 0, 0);
    }

    public void addInsideView(View view) {
        insideContainer.removeAllViews();
        insideContainer.addView(view);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //you can manipulate the view here also
    }

}