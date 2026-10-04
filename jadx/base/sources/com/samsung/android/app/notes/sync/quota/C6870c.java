package com.samsung.android.app.notes.sync.quota;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import p020E.C0073a;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.quota.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6870c implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4363a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C6871d f4364b;

    public C6870c(C6871d c6871d, int i) {
        this.f4364b = c6871d;
        this.f4363a = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        Debugger.m8609e("QT/QuotaHelper", "getQuota() : Fail to get AccessToken, errCode = " + str + " errMsg = " + str2);
        C6868a c6868a = (C6868a) this.f4364b.f4369d;
        if (c6868a != null) {
            synchronized (c6868a) {
                ((C6868a) this.f4364b.f4369d).mo5055a(201, 0L, 0L);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) {
        Debugger.m8615i("QT/QuotaHelper", "onReceived()");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Debugger.m8609e("QT/QuotaHelper", "onReceived() : userToken or userId is null!");
        } else {
            C14433b.m15033p(this.f4364b.f4366a).m15038n(str, str2, new C0073a(this, 8));
        }
    }
}
