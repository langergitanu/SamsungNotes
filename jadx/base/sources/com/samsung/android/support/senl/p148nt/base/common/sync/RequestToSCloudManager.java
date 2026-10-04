package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\f\u001a\u00020\u0007J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSCloudManager;", "", "<init>", "()V", "mRequestSCloudContract", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSCloudContract;", "setRequestSCloudContract", "", "requestSCloudContract", "isDataNetworkAvailable", "", "()Z", "printDataNetworkLog", "isWiFiAvailable", "getAuthorizationSync", "", "accessToken", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getServerUrl", "restApi", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RequestToSCloudManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "RequestToSCloudManager";

    @Nullable
    private static RequestToSCloudManager mInstance;

    @Nullable
    private RequestSCloudContract mRequestSCloudContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSCloudManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSCloudManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSCloudManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized RequestToSCloudManager getInstance() {
            RequestToSCloudManager requestToSCloudManager;
            try {
                if (RequestToSCloudManager.mInstance == null) {
                    RequestToSCloudManager.mInstance = new RequestToSCloudManager();
                }
                requestToSCloudManager = RequestToSCloudManager.mInstance;
                Intrinsics.checkNotNull(requestToSCloudManager);
            } catch (Throwable th) {
                throw th;
            }
            return requestToSCloudManager;
        }

        private Companion() {
        }
    }

    @Nullable
    public final String getAuthorizationSync(@Nullable String accessToken, @Nullable String userId) {
        RequestSCloudContract requestSCloudContract = this.mRequestSCloudContract;
        if (requestSCloudContract == null) {
            Debugger.INSTANCE.m8621e(TAG, "getAuthorization() : No contract!");
            return null;
        }
        Intrinsics.checkNotNull(requestSCloudContract);
        return requestSCloudContract.getAuthorizationSync(accessToken, userId);
    }

    @Nullable
    public final String getServerUrl(@Nullable String restApi) {
        RequestSCloudContract requestSCloudContract = this.mRequestSCloudContract;
        if (requestSCloudContract == null) {
            Debugger.INSTANCE.m8621e(TAG, "getServerUrl() : No contract!");
            return null;
        }
        Intrinsics.checkNotNull(requestSCloudContract);
        return requestSCloudContract.getServerUrl(restApi);
    }

    public final boolean isDataNetworkAvailable() {
        RequestSCloudContract requestSCloudContract = this.mRequestSCloudContract;
        if (requestSCloudContract == null) {
            Debugger.INSTANCE.m8621e(TAG, "isDataNetworkAvailable() : No contract!");
            return false;
        }
        Intrinsics.checkNotNull(requestSCloudContract);
        return requestSCloudContract.isDataNetworkAvailable();
    }

    public final boolean isWiFiAvailable() {
        RequestSCloudContract requestSCloudContract = this.mRequestSCloudContract;
        if (requestSCloudContract == null) {
            Debugger.INSTANCE.m8621e(TAG, "isWiFiAvailable() : No contract!");
            return false;
        }
        Intrinsics.checkNotNull(requestSCloudContract);
        return requestSCloudContract.isWiFiAvailable();
    }

    public final void printDataNetworkLog() {
        RequestSCloudContract requestSCloudContract = this.mRequestSCloudContract;
        if (requestSCloudContract == null) {
            Debugger.INSTANCE.m8621e(TAG, "printDataNetworkLog() : No contract!");
        } else {
            Intrinsics.checkNotNull(requestSCloudContract);
            requestSCloudContract.printDataNetworkLog();
        }
    }

    public final void setRequestSCloudContract(@Nullable RequestSCloudContract requestSCloudContract) {
        this.mRequestSCloudContract = requestSCloudContract;
    }
}
