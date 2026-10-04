package com.samsung.android.support.senl.p148nt.app.common.penrecyclerview;

import android.content.Context;
import android.view.MotionEvent;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerViewContract;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PenRecyclerViewModel extends BasePenRecyclerViewModel {
    private OnLongPressMultiSelectionListener mOnLongPressMultiSelectionListener;
    private final PenRecyclerViewContract.PenRecyclerView mView;

    public PenRecyclerViewModel(PenRecyclerViewContract.PenRecyclerView penRecyclerView) {
        super(penRecyclerView);
        this.mOnLongPressMultiSelectionListener = null;
        this.mView = penRecyclerView;
    }

    public OnLongPressMultiSelectionListener getOnLongPressMultiSelectionListener() {
        return this.mOnLongPressMultiSelectionListener;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        if (this.mOnLongPressMultiSelectionListener == null) {
            return;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (this.mView.isLongPressed() && action == 2) {
            this.mOnLongPressMultiSelectionListener.onTouchEvent(x, y2);
        }
    }

    public void removeOnLongPressMultiSelectionListener() {
        this.mOnLongPressMultiSelectionListener = null;
    }

    public void setOnLongPressMultiSelectionListener(OnLongPressMultiSelectionListener onLongPressMultiSelectionListener) {
        this.mOnLongPressMultiSelectionListener = onLongPressMultiSelectionListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel
    public void processTouchEvent(Context context, MotionEvent motionEvent, boolean z) {
        processTouchEvent(motionEvent);
        super.processTouchEvent(context, motionEvent, z);
    }
}
