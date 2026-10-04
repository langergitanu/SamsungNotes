package com.samsung.android.sdk.pen.setting;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandMenu;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7522c implements PopupMenu.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5005a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5006b;

    public /* synthetic */ C7522c(Object obj, int i) {
        this.f5005a = i;
        this.f5006b = obj;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.f5005a) {
            case 0:
                return SpenFavoritePenMiniLayoutControl.showPopupMenu$lambda$1((SpenFavoritePenMiniLayoutControl) this.f5006b, menuItem);
            case 1:
                return ((NotesSearchView) this.f5006b).lambda$setOverFlowMenu$7(menuItem);
            default:
                return VoiceRecordExpandMenu.showPopUpMenu$lambda$6((VoiceRecordExpandMenu) this.f5006b, menuItem);
        }
    }
}
