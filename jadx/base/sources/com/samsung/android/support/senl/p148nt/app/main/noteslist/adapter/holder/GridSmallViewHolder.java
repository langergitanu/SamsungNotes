package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GridSmallViewHolder extends GridViewHolder {
    private static final String TAG = "GridSmallViewHolder";

    public GridSmallViewHolder(View view) {
        super(view, 4);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.GridViewHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.GridViewHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder, com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public int getViewMode() {
        return 4;
    }
}
