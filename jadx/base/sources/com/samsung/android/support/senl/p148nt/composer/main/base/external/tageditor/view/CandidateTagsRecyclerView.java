package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CandidateTagsRecyclerView extends RecyclerView {
    public CandidateTagsRecyclerView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        if (computeVerticalScrollRange() - computeVerticalScrollExtent() == 0) {
            return false;
        }
        if (i < 0) {
            return iComputeVerticalScrollOffset > 0;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        return layoutManager instanceof FlexboxLayoutManager ? ((FlexboxLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1 : super.canScrollVertically(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i4 = (int) (((double) point.y) * 0.25d);
        boolean z = (WindowManagerCompat.getInstance().getMultiWindowMode(getResources().getConfiguration()) & 2) != 0;
        if (defaultDisplay.getRotation() % 2 != 0 || z) {
            i4 = (int) (((double) point.y) * 0.14d);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE));
    }

    public CandidateTagsRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandidateTagsRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
