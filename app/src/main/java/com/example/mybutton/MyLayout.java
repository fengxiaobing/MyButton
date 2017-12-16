package com.example.mybutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/12/16.
 */

public class MyLayout extends ViewGroup{
    private int mTotalLength;
    private float totalWeight = 0;
    private Paint mPaint;
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //mOrientation == VERTICAL
        measureVertical(widthMeasureSpec, heightMeasureSpec);
    }

    private void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        final int count = getChildCount();
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height=0;
        int width = 0;
        //测量Children
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        // 遍历子View获取其高度，并记录下子View中最高的高度数值
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            // 子View不可见，直接跳过该View的measure过程，返回值恒为0
            // 注：若view的可见属性设置为VIEW.INVISIBLE，还是会计算该view大小
            if (child.getVisibility() == View.GONE) {
                i += 0;
                continue;
            }
            //for循环中测量Child
//            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            final int childHeight = child.getMeasuredHeight();
            final int childWidth = child.getMeasuredWidth();
            height += childHeight;
            width = Math.max(width,childWidth);

        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
    }
}
