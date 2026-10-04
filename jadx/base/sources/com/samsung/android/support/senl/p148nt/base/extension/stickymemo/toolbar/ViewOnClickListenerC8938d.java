package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar.SmMorePopup;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC8938d implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6476a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6477b;

    public /* synthetic */ ViewOnClickListenerC8938d(Object obj, int i) {
        this.f6476a = i;
        this.f6477b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6476a) {
            case 0:
                SmMorePopup.MenuAdapter.viewOnClickListener$lambda$1((SmMorePopup.MenuAdapter) this.f6477b, view);
                break;
            default:
                SmMorePopup.initMenuList$lambda$3$lambda$2((SmMorePopup) this.f6477b, view);
                break;
        }
    }
}
