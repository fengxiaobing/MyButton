package com.example.mybutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/16.
 */

public class MyUI extends View {
    public MyUI(Context context) {
        super(context);
    }

    public MyUI(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
