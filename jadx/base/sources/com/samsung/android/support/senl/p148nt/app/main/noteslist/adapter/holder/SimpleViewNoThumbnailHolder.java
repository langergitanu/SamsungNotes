package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SimpleViewNoThumbnailHolder extends SimpleViewHolder {
    private static final String TAG = "SimpleViewNoThumbnailHolder";

    public SimpleViewNoThumbnailHolder(View view) {
        super(view, 6);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SimpleViewHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder
    public void decorateThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        if (NotesUtils.isLock(this.mNotesHolderInfo.getLockType())) {
            this.mThumbnailHandler.inflateThumbnail(mainListDocumentData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SimpleViewHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SimpleViewHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder, com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public int getViewMode() {
        return 6;
    }
}
