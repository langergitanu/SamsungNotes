package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PenMultiSelectionEvent {
    private OnPenMultiSelectionListener mOnPenMultiSelectionListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PenMultiSelectionEventListener {
        void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4, boolean z);
    }

    public PenMultiSelectionEvent(final PenMultiSelectionEventListener penMultiSelectionEventListener) {
        this.mOnPenMultiSelectionListener = new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.PenMultiSelectionEvent.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
            public void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4) {
                PenMultiSelectionEventListener penMultiSelectionEventListener2 = penMultiSelectionEventListener;
                if (penMultiSelectionEventListener2 != null) {
                    penMultiSelectionEventListener2.onSelectedItemPosition(arrayList, i, i2, i4, true);
                }
            }
        };
    }

    public OnPenMultiSelectionListener getOnPenMultiSelectionListener() {
        return this.mOnPenMultiSelectionListener;
    }

    public void reset() {
        this.mOnPenMultiSelectionListener = null;
    }
}
