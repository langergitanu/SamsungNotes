package com.samsung.android.support.senl.p148nt.app.main.common.handoff;

import android.app.Activity;
import android.content.DialogInterface;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.handoff.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DialogInterfaceOnDismissListenerC8211a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6152a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6153b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6154c;

    public /* synthetic */ DialogInterfaceOnDismissListenerC8211a(Object obj, Object obj2, int i) {
        this.f6152a = i;
        this.f6153b = obj;
        this.f6154c = obj2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f6152a) {
            case 0:
                HandoffLaunchManager.handleComposer$lambda$2((HandoffLaunchManager) this.f6153b, (JSONObject) this.f6154c, dialogInterface);
                break;
            default:
                PermissionHelper.showGotoSettingsDialog$lambda$9((Runnable) this.f6153b, (Activity) this.f6154c, dialogInterface);
                break;
        }
    }
}
