package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSamsungAccountManager;", "", "<init>", "()V", "mRequestSamsungAccountContract", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSamsungAccountContract;", "setRequestSamsungAccountContract", "", "requestSamsungAccountContract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RequestToSamsungAccountManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "RequestToSamsungAccountManager";

    @Nullable
    private static RequestToSamsungAccountManager mInstance;

    @Nullable
    private RequestSamsungAccountContract mRequestSamsungAccountContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010$\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010%J\u0010\u0010&\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010'J\u0018\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-J\u0018\u0010.\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-J\u0018\u0010/\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-J\u0018\u00100\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u0014\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u0013\u0010!\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0011\u0010#\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b#\u0010\r¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSamsungAccountManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSamsungAccountManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSamsungAccountManager;", "isLogined", "", "()Z", "requestAuthInfo", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/sync/IAuthInfoReqListener;", "cancelAuthInfo", "setAccessTokenExpired", "invalidLoggedIn", "getInvalidLoggedIn", "clearInvalidLoggedIn", "accessToken", "getAccessToken", "()Ljava/lang/String;", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUserId", "isB2BAccount", "userIdHash", "getUserIdHash", "regionMcc", "getRegionMcc", "apiServerUrl", "getApiServerUrl", "isChildAccount", "requestConsentInfo", "Lcom/samsung/android/support/senl/nt/base/common/sync/ConsentDataListener;", "requestCountryPolicy", "Lcom/samsung/android/support/senl/nt/base/common/sync/CountryPolicyListener;", "cancelCountryPolicy", "requestSystemAiPermission", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "loginRequestAccessToken", "loginPopupSamsungAccount", "requestPreventOnlineProcessingSettings", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void cancelAuthInfo(@Nullable IAuthInfoReqListener listener) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.cancelAuthInfo(listener);
        }

        public final void cancelCountryPolicy(@Nullable CountryPolicyListener listener) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.cancelCountryPolicy(listener);
        }

        public final void clearInvalidLoggedIn() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.clearInvalidLoggedIn();
        }

        @Nullable
        public final String getAccessToken() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return null;
            }
            return requestSamsungAccountContract.getAccessToken();
        }

        @Nullable
        public final String getApiServerUrl() {
            if (getInstance().mRequestSamsungAccountContract == null) {
                return "";
            }
            RequestSamsungAccountContract requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract;
            if (requestSamsungAccountContract != null) {
                return requestSamsungAccountContract.getApiServerUrl();
            }
            return null;
        }

        @NotNull
        public final synchronized RequestToSamsungAccountManager getInstance() {
            RequestToSamsungAccountManager requestToSamsungAccountManager;
            try {
                if (RequestToSamsungAccountManager.mInstance == null) {
                    RequestToSamsungAccountManager.mInstance = new RequestToSamsungAccountManager();
                }
                requestToSamsungAccountManager = RequestToSamsungAccountManager.mInstance;
                Intrinsics.checkNotNull(requestToSamsungAccountManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.sync.RequestToSamsungAccountManager");
            } catch (Throwable th) {
                throw th;
            }
            return requestToSamsungAccountManager;
        }

        public final boolean getInvalidLoggedIn() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            return (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null || !requestSamsungAccountContract.getInvalidLoggedIn()) ? false : true;
        }

        @Nullable
        public final String getRegionMcc() {
            if (getInstance().mRequestSamsungAccountContract == null) {
                return "";
            }
            RequestSamsungAccountContract requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract;
            if (requestSamsungAccountContract != null) {
                return requestSamsungAccountContract.getRegionMcc();
            }
            return null;
        }

        @Nullable
        public final String getUserId() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return null;
            }
            return requestSamsungAccountContract.getUserId();
        }

        @Nullable
        public final String getUserIdHash() {
            if (getInstance().mRequestSamsungAccountContract == null) {
                return "";
            }
            RequestSamsungAccountContract requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract;
            if (requestSamsungAccountContract != null) {
                return requestSamsungAccountContract.getUserIdHash();
            }
            return null;
        }

        public final boolean isB2BAccount() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            return (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null || !requestSamsungAccountContract.isB2BAccount()) ? false : true;
        }

        public final boolean isChildAccount() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            return (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null || !requestSamsungAccountContract.isChildAccount()) ? false : true;
        }

        public final boolean isLogined() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            return (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null || !requestSamsungAccountContract.isLogined()) ? false : true;
        }

        public final void loginPopupSamsungAccount(@Nullable Activity activity, int requestCode) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.loginPopupSamsungAccount(activity, requestCode);
        }

        public final void loginRequestAccessToken(@Nullable Activity activity, int requestCode) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.loginRequestAccessToken(activity, requestCode);
        }

        public final void requestAuthInfo(@Nullable IAuthInfoReqListener listener) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.requestAuthInfo(listener);
        }

        public final void requestConsentInfo(@Nullable ConsentDataListener listener) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.requestConsentInfo(listener);
        }

        public final void requestCountryPolicy(@Nullable CountryPolicyListener listener) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.requestCountryPolicy(listener);
        }

        public final void requestPreventOnlineProcessingSettings(@Nullable Activity activity, int requestCode) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.requestPreventOnlineProcessingSettings(activity, requestCode);
        }

        public final void requestSystemAiPermission(@Nullable Activity activity, int requestCode) {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.requestSystemAiPermission(activity, requestCode);
        }

        public final void setAccessTokenExpired() {
            RequestSamsungAccountContract requestSamsungAccountContract;
            if (getInstance().mRequestSamsungAccountContract == null || (requestSamsungAccountContract = getInstance().mRequestSamsungAccountContract) == null) {
                return;
            }
            requestSamsungAccountContract.setAccessTokenExpired();
        }

        private Companion() {
        }
    }

    public final void setRequestSamsungAccountContract(@Nullable RequestSamsungAccountContract requestSamsungAccountContract) {
        this.mRequestSamsungAccountContract = requestSamsungAccountContract;
    }
}
