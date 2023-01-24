package com.sarthi.myapplication.abstracts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class NonScrollListView extends ListView {
    public NonScrollListView(Context context) {
        super(context);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    public NonScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NonScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
