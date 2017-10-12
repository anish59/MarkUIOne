package com.markuione.animationDemo.customViews;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by anish on 12-10-2017.
 */

public class MyView3 extends View {
    private final Paint paint;
    Path path;


    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        path = new Path();
        path.moveTo(width / 4, height / 4);   // THIS TRANSFORMATIONS TO BE ANIMATED!!!!!!!!
        path.lineTo(width / 2, height / 2);
      /*  path.moveTo(40, 50);
        path.lineTo(50, 40);*/

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        //Circle color
        paint.setColor(Color.RED);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }
}
