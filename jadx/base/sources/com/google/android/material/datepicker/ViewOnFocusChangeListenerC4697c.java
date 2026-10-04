package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.GridViewHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewManager;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapter;

/* JADX INFO: renamed from: com.google.android.material.datepicker.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC4697c implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2306a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2307b;

    public /* synthetic */ ViewOnFocusChangeListenerC4697c(Object obj, int i) {
        this.f2306a = i;
        this.f2307b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f2306a) {
            case 0:
                DateSelector.lambda$showKeyboardWithAutoHideBehavior$0((EditText[]) this.f2307b, view, z);
                break;
            case 1:
                ((GridViewHolder) this.f2307b).lambda$setFocusListener$0(view, z);
                break;
            case 2:
                SubFolderHolder.initHolder$lambda$13$lambda$12((SubFolderHolderInfo) this.f2307b, view, z);
                break;
            case 3:
                ImportFolderAdapter.onBindViewHolder$lambda$7((ImportFolderHolder) this.f2307b, view, z);
                break;
            case 4:
                ImportFolderView.initLayout$lambda$0((ImportFolderView) this.f2307b, view, z);
                break;
            case 5:
                QuickToolPresenter.onFocusChangeListener$lambda$0((QuickToolPresenter) this.f2307b, view, z);
                break;
            case 6:
                CoverPreviewLayout.setSummaryView$lambda$4((CoverPreviewLayout) this.f2307b, view, z);
                break;
            case 7:
                ((TitleViewManager) this.f2307b).lambda$init$0(view, z);
                break;
            default:
                AiSTTListViewAdapter.initListener$lambda$0((AiSTTListViewAdapter.AiSTTListViewHolder) this.f2307b, view, z);
                break;
        }
    }
}
