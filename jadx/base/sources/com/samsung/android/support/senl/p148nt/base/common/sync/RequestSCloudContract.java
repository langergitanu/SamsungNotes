package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSCloudContract;", "", "isDataNetworkAvailable", "", "()Z", "isWiFiAvailable", "getAuthorizationSync", "", "accessToken", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getServerUrl", "restApi", "printDataNetworkLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface RequestSCloudContract {
    @Nullable
    String getAuthorizationSync(@Nullable String accessToken, @Nullable String userId);

    @Nullable
    String getServerUrl(@Nullable String restApi);

    boolean isDataNetworkAvailable();

    boolean isWiFiAvailable();

    void printDataNetworkLog();
}
