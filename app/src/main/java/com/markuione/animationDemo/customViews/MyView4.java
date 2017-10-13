package com.markuione.animationDemo.customViews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by anish on 13-10-2017.
 */

public class MyView4 extends View {
    Path path;
    private Paint paint;

    int iCurStep = 0;// current animation step
    private PathMeasure pm;

    public MyView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        path = new Path();
        path.moveTo(width / 4, height / 4);
        path.moveTo(width / 3, height / 3);
        path.moveTo(width / 2, height / 2);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        //Circle color
        paint.setColor(Color.RED);
        pm = new PathMeasure(path, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fSegmentLen = pm.getLength() / 20;//we'll get 20 points from path to animate the circle
        float afP[] = {0f, 0f};

        if (iCurStep <= 20) {
            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
            canvas.drawCircle(afP[0], afP[1], 20, paint);
            iCurStep++;
            invalidate();
        } else {
            iCurStep = 0;
        }
    }
}
