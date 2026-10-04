package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/IAuthInfoReqListener;", "", "onReceived", "", "userToken", "", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "onError", "errCode", "errMsg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IAuthInfoReqListener {
    void onError(@NotNull String errCode, @NotNull String errMsg);

    void onReceived(@NotNull String userToken, @Nullable String userId);
}
