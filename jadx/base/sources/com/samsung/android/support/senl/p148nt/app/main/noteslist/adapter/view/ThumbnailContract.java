package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view;

import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ThumbnailContract {
    Context getContext();

    NotesHolderInfo getNotesHolderInfo();

    Resources getResources();

    String getTag();

    int getViewMode();
}
