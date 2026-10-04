package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import androidx.picker.widget.SeslNumberPicker;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.TableDialogFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC8137b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6129a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6130b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6131c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f6132d;

    public /* synthetic */ DialogInterfaceOnClickListenerC8137b(Object obj, int i, Object obj2, Object obj3) {
        this.f6129a = i;
        this.f6130b = obj;
        this.f6131c = obj2;
        this.f6132d = obj3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f6129a) {
            case 0:
                ((VerifyIrisView) this.f6130b).lambda$showRetryDialog$2((Handler) this.f6131c, (Context) this.f6132d, dialogInterface, i);
                break;
            case 1:
                HandoffUtils.showWiFiSyncOnlyAndNotWiFiConnected$lambda$5((DialogInterface.OnClickListener) this.f6130b, (Activity) this.f6131c, (WeakReference) this.f6132d, dialogInterface, i);
                break;
            default:
                ((TableDialogFragment) this.f6130b).lambda$onCreateDialog$0((SeslNumberPicker) this.f6131c, (SeslNumberPicker) this.f6132d, dialogInterface, i);
                break;
        }
    }
}
