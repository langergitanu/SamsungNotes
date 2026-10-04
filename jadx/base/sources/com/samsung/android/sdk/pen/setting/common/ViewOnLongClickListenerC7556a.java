package com.samsung.android.sdk.pen.setting.common;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportDocumentRecyclerViewAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapter;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.common.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnLongClickListenerC7556a implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5027a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5028b;

    public /* synthetic */ ViewOnLongClickListenerC7556a(Object obj, int i) {
        this.f5027a = i;
        this.f5028b = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f5027a) {
            case 0:
                return SPenSeekBarView.mButtonLongClickListener$lambda$0((SPenSeekBarView) this.f5028b, view);
            case 1:
                return ImportDocumentRecyclerViewAdapter.onCreateViewHolder$lambda$2$lambda$1((ImportDocumentRecyclerViewAdapter) this.f5028b, view);
            default:
                return ImportFolderAdapter.mLongClickListener$lambda$6((ImportFolderAdapter) this.f5028b, view);
        }
    }
}
