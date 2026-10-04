package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface RecyclerViewMotionEventListener {
    void checkAutoScroll();

    void dragFolderSelectState(int i, boolean z, int i2);

    void dragNoteSelectState(int i, boolean z);

    int getTipCardHolderCount();

    boolean isDragAndDropEnabledPosition(int i, boolean z);

    boolean isSOMRecognizedCardHolder(int i);

    void selectAllNotes(boolean z);

    void setLastCheckedItemViewBottom();

    void startDragAndDrop(int i, boolean z);

    void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z);

    void updateFolderExpandBarHolder();

    void updateSubHeaderCheckBox(long j);

    void updateTimeSubHeaderCheckBox();
}
