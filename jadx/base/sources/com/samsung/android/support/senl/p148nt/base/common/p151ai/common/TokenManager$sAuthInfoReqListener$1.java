package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p079T.RunnableC0284b;
import p127c3.RunnableC4208a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/common/ai/common/TokenManager$sAuthInfoReqListener$1", "Lcom/samsung/android/support/senl/nt/base/common/sync/IAuthInfoReqListener;", "onReceived", "", "userToken", "", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "onError", "errCode", "errMsg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TokenManager$sAuthInfoReqListener$1 implements IAuthInfoReqListener {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$1(String str) {
        TokenManager.INSTANCE.reset();
        if (TokenManager.sContract != null) {
            TokenManager.Contract contract = TokenManager.sContract;
            if (contract != null) {
                contract.onError(str);
            }
            TokenManager.sContract = null;
        }
        Logger.m8702i(TokenManager.TAG, "requestAuthInfo# onError");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceived$lambda$0() {
        TokenManager.INSTANCE.reset();
        if (TokenManager.sContract != null) {
            TokenManager.Contract contract = TokenManager.sContract;
            if (contract != null) {
                contract.onReceived();
            }
            TokenManager.sContract = null;
        }
        Logger.m8702i(TokenManager.TAG, "requestAuthInfo# onReceived");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onError(String errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        TokenManager.mExecutor.execute(new RunnableC4208a(errCode, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onReceived(String userToken, String userId) {
        Intrinsics.checkNotNullParameter(userToken, "userToken");
        TokenManager.mExecutor.execute(new RunnableC0284b(3));
    }
}
