package com.samsung.android.model.contractimpl;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestSCloudContract;
import p042J1.C0145c;
import p234q1.C14433b;
import p234q1.C14434c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RequestSCloudContractImpl implements RequestSCloudContract {
    private static final String TAG = "RequestSCloudContractImpl";
    private final Context mAppContext = BaseUtils.getApplicationContext();

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSCloudContract
    public String getAuthorizationSync(String str, String str2) {
        return C14433b.m15033p(this.mAppContext).m15039o(str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSCloudContract
    public String getServerUrl(String str) {
        return C14434c.m15043a().m15044b(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSCloudContract
    public boolean isDataNetworkAvailable() {
        return C0145c.m334s(this.mAppContext);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSCloudContract
    public boolean isWiFiAvailable() {
        return C0145c.m297E(this.mAppContext);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSCloudContract
    public void printDataNetworkLog() {
        C0145c.m301I(this.mAppContext);
    }
}
