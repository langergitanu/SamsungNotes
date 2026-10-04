package com.samsung.android.sdk.pen.setting.common;

import android.view.View;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCurvedSwitchLayout;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.common.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7563h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5042a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f5043b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f5044c;

    public /* synthetic */ RunnableC7563h(View view, View view2, int i) {
        this.f5042a = i;
        this.f5043b = view;
        this.f5044c = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5042a) {
            case 0:
                SpenTouchDelegate.setDelegateToParent$lambda$1(this.f5043b, this.f5044c);
                break;
            case 1:
                SpenCurvedSwitchLayout.updateImageThumbContainer$lambda$2(this.f5043b, this.f5044c);
                break;
            default:
                QTCurvedSwitchLayout.updateImageThumbContainer$lambda$2(this.f5043b, this.f5044c);
                break;
        }
    }
}
