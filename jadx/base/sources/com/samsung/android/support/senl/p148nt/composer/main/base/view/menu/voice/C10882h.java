package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10882h implements PopupMenu.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7302a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VoiceRecordExpandOptionMenu f7303b;

    public /* synthetic */ C10882h(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, int i) {
        this.f7302a = i;
        this.f7303b = voiceRecordExpandOptionMenu;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.f7302a) {
            case 0:
                return VoiceRecordExpandOptionMenu.showOptionMenu$lambda$11(this.f7303b, menuItem);
            default:
                return VoiceRecordExpandOptionMenu.onEditMoreClick$lambda$9(this.f7303b, menuItem);
        }
    }
}
