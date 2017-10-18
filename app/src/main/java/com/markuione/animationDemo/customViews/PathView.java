package com.markuione.animationDemo.customViews;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.util.Log;

import com.markuione.helper.FunctionHelper;

public class PathView extends View {
    private Path path, path1;
    private Paint paint;
    private float length;
    private float width;
    private float height;
    private Context mContext;
    private float dpWidth, dpHeight;
    public static final int TRIANGLE = 3;
    public static final int CIRCLE = 0;
    public static final int HEART = 0;


    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();
        path1 = new Path();
        mContext = context;

    }


    public void init(int shapeType, int durationInSec, final PathViewAnimListener pathViewAnimListener) {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);


        if (shapeType == TRIANGLE) {
            path.moveTo(FunctionHelper.dpToPixel(50, mContext), FunctionHelper.dpToPixel(10, mContext));
            path.lineTo(FunctionHelper.dpToPixel(10, mContext), FunctionHelper.dpToPixel(80, mContext));
            path.lineTo(FunctionHelper.dpToPixel(50, mContext), FunctionHelper.dpToPixel(80, mContext));

            path1.moveTo(FunctionHelper.dpToPixel(50, mContext), FunctionHelper.dpToPixel(10, mContext));
            path1.lineTo(FunctionHelper.dpToPixel(90, mContext), FunctionHelper.dpToPixel(80, mContext));
            path1.lineTo(FunctionHelper.dpToPixel(50, mContext), FunctionHelper.dpToPixel(80, mContext));

            // Measure the path
            PathMeasure measure = new PathMeasure(path, false);
            length = measure.getLength();

            float[] intervals = new float[]{length, length};

            ObjectAnimator animator = ObjectAnimator.ofFloat(PathView.this, "phase", 1.0f, 0.0f);
            animator.setDuration(durationInSec);
            animator.start();


            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    pathViewAnimListener.onAnimStart(animator);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    pathViewAnimListener.onAnimationOver(animator);
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    pathViewAnimListener.onAnimCanceled(animator);
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                    pathViewAnimListener.onAnimRepeat(animator);
                }
            });
        } else {
        }

    }

    //is called by animtor object
    public void setPhase(float phase) {
        Log.d("pathview", "setPhase called with:" + String.valueOf(phase));
        paint.setPathEffect(createPathEffect(length, phase, 0.0f));
        invalidate();//will calll onDraw
    }

    private static PathEffect createPathEffect(float pathLength, float phase, float offset) {
        return new DashPathEffect(new float[]{pathLength, pathLength},
                Math.max(phase * pathLength, offset));
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        c.drawPath(path, paint);
        c.drawPath(path1, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        dpWidth = FunctionHelper.pixelToDp(width, mContext);
        dpHeight = FunctionHelper.pixelToDp(height, mContext);
        System.out.println("width: " + width + "|| height: " + height);
        this.setMeasuredDimension((int) width, (int) height);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public interface PathViewAnimListener {
        void onAnimationOver(Animator animator);

        void onAnimStart(Animator animator);

        void onAnimCanceled(Animator animator);

        void onAnimRepeat(Animator animator);
    }
}