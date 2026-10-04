package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnMouseDragListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MouseDragEvent {
    private OnMouseDragListener mOnMouseDragListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MouseDragEventListener {
        int getSubFoldersSpan();

        boolean isDragAndDropEnabledPosition(int i, boolean z);

        void startDragAndDrop(int i, boolean z);
    }

    public MouseDragEvent(final MouseDragEventListener mouseDragEventListener) {
        this.mOnMouseDragListener = new OnMouseDragListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.MouseDragEvent.1
            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnMouseDragListener
            public int getSubFoldersSpan() {
                return mouseDragEventListener.getSubFoldersSpan();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnMouseDragListener
            public boolean isDragAndDropEnabledPosition(int i, boolean z) {
                return mouseDragEventListener.isDragAndDropEnabledPosition(i, z);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnMouseDragListener
            public void startDragAndDrop(int i, boolean z) {
                mouseDragEventListener.startDragAndDrop(i, z);
            }
        };
    }

    public OnMouseDragListener getOnMouseDragListenerListener() {
        return this.mOnMouseDragListener;
    }

    public void reset() {
        this.mOnMouseDragListener = null;
    }
}
