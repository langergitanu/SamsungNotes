package com.google.android.material.internal;

import android.view.View;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;

/* JADX INFO: renamed from: com.google.android.material.internal.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4738b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2310a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f2311b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f2312c;

    public /* synthetic */ RunnableC4738b(int i, View view, boolean z) {
        this.f2310a = i;
        this.f2312c = view;
        this.f2311b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2310a) {
            case 0:
                ViewUtils.showKeyboard(this.f2312c, this.f2311b);
                break;
            case 1:
                SpenQTPenItemVisibilityController.updateEdgeItemVisibility$lambda$20$lambda$19(this.f2311b, this.f2312c);
                break;
            default:
                HolderAnimation.decorateVoiceAnimation$lambda$6(this.f2312c, this.f2311b);
                break;
        }
    }

    public /* synthetic */ RunnableC4738b(View view, boolean z) {
        this.f2310a = 1;
        this.f2311b = z;
        this.f2312c = view;
    }
}
