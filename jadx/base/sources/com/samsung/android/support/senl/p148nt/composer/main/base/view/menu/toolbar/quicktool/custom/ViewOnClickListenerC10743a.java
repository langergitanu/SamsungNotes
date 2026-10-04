package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.custom.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10743a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7234a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QuickToolAiMenu f7235b;

    public /* synthetic */ ViewOnClickListenerC10743a(QuickToolAiMenu quickToolAiMenu, int i) {
        this.f7234a = i;
        this.f7235b = quickToolAiMenu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7234a) {
            case 0:
                QuickToolAiMenu.setupAutoFormat$lambda$4(this.f7235b, view);
                break;
            case 1:
                QuickToolAiMenu.setupTranscribe$lambda$9(this.f7235b, view);
                break;
            case 2:
                QuickToolAiMenu.setupSummarize$lambda$5(this.f7235b, view);
                break;
            case 3:
                QuickToolAiMenu.setupTranslate$lambda$7(this.f7235b, view);
                break;
            case 4:
                QuickToolAiMenu.setupSpellingCorrection$lambda$6(this.f7235b, view);
                break;
            default:
                QuickToolAiMenu.setupCreateImage$lambda$8(this.f7235b, view);
                break;
        }
    }
}
