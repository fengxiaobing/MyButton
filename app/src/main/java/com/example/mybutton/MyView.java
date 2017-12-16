package com.example.mybutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/16.
 */

public class MyView extends TextView {
    private Paint mPaint;
    private float size;
    private int myColor,myBackgroundColor;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

        initAttr(context,attrs);

    }

    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyView);
        size = typedArray.getFloat(R.styleable.MyView_text_size,37);
        myColor = typedArray.getColor(R.styleable.MyView_text_color,0xFF000000);
        myBackgroundColor = typedArray.getColor(R.styleable.MyView_text_back_ground,0xFF00FF00);
        super.setTextColor(myColor);
        super.setTextSize(size);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        width = 300;
        height = 300;
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(myBackgroundColor);

        super.onDraw(canvas);
//        canvas.drawCircle(100,100,100,mPaint);

    }
}
