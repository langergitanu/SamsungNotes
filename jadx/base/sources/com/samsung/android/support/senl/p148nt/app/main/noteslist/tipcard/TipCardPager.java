package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.view.TipCardView;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsViewPager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardPager extends AbsViewPager {
    private static final String TAG = "TipCardPager";
    private final List<Integer> childHeights;

    public TipCardPager(@NonNull Context context) {
        super(context);
        this.childHeights = new ArrayList();
    }

    public int getChildHeight(int i) {
        if (this.childHeights.size() <= i) {
            return -1;
        }
        return this.childHeights.get(i).intValue();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            this.childHeights.clear();
            super.onMeasure(i, i2);
            int currentItem = getCurrentItem();
            int i4 = 0;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                this.childHeights.add(i5, Integer.valueOf(childAt.getMeasuredHeight()));
                if (((TipCardView) childAt).getPageTag() == currentItem) {
                    i4 = i5;
                }
            }
            if (this.childHeights.size() > i4) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.childHeights.get(i4).intValue(), 1073741824);
            }
            super.onMeasure(i, i2);
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, e.getMessage());
        }
    }

    public TipCardPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.childHeights = new ArrayList();
    }
}
