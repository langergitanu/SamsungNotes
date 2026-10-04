package com.samsung.android.app.notes.sync.quota;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.quota.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6869b implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Context f4361a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C6871d f4362b;

    public C6869b(C6871d c6871d, Context context) {
        this.f4362b = c6871d;
        this.f4361a = context;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        Debugger.m8609e("QT/QuotaHelper", "initQuotaUi() : Fail to get AccessToken, errCode = " + str + " errMsg = " + str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) {
        Debugger.m8615i("QT/QuotaHelper", "onReceived()");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Debugger.m8609e("QT/QuotaHelper", "onReceived() : userToken or userId is null!");
        } else {
            C14433b.m15033p(this.f4362b.f4366a).m15038n(str, str2, new C14433b(this, 9));
        }
    }
}
