package com.samsung.android.model.contractimpl;

import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestCmsContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerConsentListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener;
import org.jetbrains.annotations.NotNull;
import p042J1.C0145c;
import p048L.C0166d;
import p048L.C0167e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RequestCmsContractImpl implements RequestCmsContract {
    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestCmsContract
    public void request(@NotNull ServerConsentListener serverConsentListener) {
        if (!C0145c.m334s(BaseUtils.getApplicationContext())) {
            serverConsentListener.onCanceled();
            return;
        }
        C0166d c0166d = new C0166d();
        c0166d.f508h = serverConsentListener;
        c0166d.m428j(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestCmsContract
    public void request(boolean z, @NotNull ServerResultListener serverResultListener) {
        if (!C0145c.m334s(BaseUtils.getApplicationContext())) {
            serverResultListener.onCanceled();
            return;
        }
        C0167e c0167e = new C0167e(z);
        c0167e.f511j = serverResultListener;
        c0167e.m428j(false);
    }
}
