package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnMouseMultiSelectionListener;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MouseMultiSelectionEvent {
    private OnMouseMultiSelectionListener mOnMouseMultiSelectionListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MouseMultiSelectionEventListener {
        void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4, boolean z);
    }

    public MouseMultiSelectionEvent(final MouseMultiSelectionEventListener mouseMultiSelectionEventListener) {
        this.mOnMouseMultiSelectionListener = new OnMouseMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.MouseMultiSelectionEvent.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnMouseMultiSelectionListener
            public void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4) {
                MouseMultiSelectionEventListener mouseMultiSelectionEventListener2 = mouseMultiSelectionEventListener;
                if (mouseMultiSelectionEventListener2 != null) {
                    mouseMultiSelectionEventListener2.onSelectedItemPosition(arrayList, i, i2, i4, true);
                }
            }
        };
    }

    public OnMouseMultiSelectionListener getOnPenMultiSelectionListener() {
        return this.mOnMouseMultiSelectionListener;
    }

    public void reset() {
        this.mOnMouseMultiSelectionListener = null;
    }
}
