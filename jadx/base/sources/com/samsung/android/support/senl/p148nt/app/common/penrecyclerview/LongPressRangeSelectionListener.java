package com.samsung.android.support.senl.p148nt.app.common.penrecyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LongPressRangeSelectionListener extends PenRecyclerView.LongPressMultiSelectionListener implements OnLongPressMultiSelectionListener {
    protected boolean mIsTouchMoved = false;

    public boolean isTouchMoved() {
        return this.mIsTouchMoved;
    }

    @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
    public void onItemSelected(RecyclerView recyclerView, View view, int i, long j) {
        super.onItemSelected(recyclerView, view, i, j);
        this.mIsTouchMoved = true;
    }

    @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
    public void onLongPressMultiSelectionEnded(int i, int i2) {
        super.onLongPressMultiSelectionEnded(i, i2);
        this.mIsTouchMoved = false;
    }

    @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
    public void onLongPressMultiSelectionStarted(int i, int i2) {
        super.onLongPressMultiSelectionStarted(i, i2);
        this.mIsTouchMoved = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnLongPressMultiSelectionListener
    public boolean onTouchEvent(float f, float f4) {
        return true;
    }
}
