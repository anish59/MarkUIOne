package com.markuione.animationDemo.customViews;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by anish on 12-10-2017.
 */

public class MyView2 extends View {
    private final Paint paint;
    private final RectF rect;
    Path path;


    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int x = width / 4;
        int y = height / 4;
        rect = new RectF(x, y, x + 200, y + 50);

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
       /* int w = canvas.getWidth();
        int h = canvas.getHeight();
        int w_2 = (w / 2);
        int h_2 = (h / 2);
        PointF mPoint1 = new PointF(0, 0); //starts at canvas left top
        PointF mPoint2 = new PointF(w_2, h_2);//mid of the canvas
        Path drawPath1 = drawCurve(mPoint1, mPoint2);*/
//        canvas.drawArc(rect, paint);


    }

}
