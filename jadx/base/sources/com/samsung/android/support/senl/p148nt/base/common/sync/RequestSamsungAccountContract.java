package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010 H&J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010 H&J\u001a\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H&J\u001a\u0010'\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H&J\u001a\u0010(\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H&J\u001a\u0010)\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSamsungAccountContract;", "", "isLogined", "", "()Z", "requestAuthInfo", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/sync/IAuthInfoReqListener;", "cancelAuthInfo", "setAccessTokenExpired", "invalidLoggedIn", "getInvalidLoggedIn", "clearInvalidLoggedIn", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUserId", "userIdHash", "getUserIdHash", "regionMcc", "getRegionMcc", "apiServerUrl", "getApiServerUrl", "isChildAccount", "isB2BAccount", "requestConsentInfo", "Lcom/samsung/android/support/senl/nt/base/common/sync/ConsentDataListener;", "cancelConsentInfo", "requestCountryPolicy", "Lcom/samsung/android/support/senl/nt/base/common/sync/CountryPolicyListener;", "cancelCountryPolicy", "requestSystemAiPermission", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "loginPopupSamsungAccount", "loginRequestAccessToken", "requestPreventOnlineProcessingSettings", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface RequestSamsungAccountContract {
    void cancelAuthInfo(@Nullable IAuthInfoReqListener listener);

    void cancelConsentInfo(@Nullable ConsentDataListener listener);

    void cancelCountryPolicy(@Nullable CountryPolicyListener listener);

    void clearInvalidLoggedIn();

    @Nullable
    String getAccessToken();

    @Nullable
    String getApiServerUrl();

    boolean getInvalidLoggedIn();

    @Nullable
    String getRegionMcc();

    @Nullable
    String getUserId();

    @Nullable
    String getUserIdHash();

    boolean isB2BAccount();

    boolean isChildAccount();

    boolean isLogined();

    void loginPopupSamsungAccount(@Nullable Activity activity, int requestCode);

    void loginRequestAccessToken(@Nullable Activity activity, int requestCode);

    void requestAuthInfo(@Nullable IAuthInfoReqListener listener);

    void requestConsentInfo(@Nullable ConsentDataListener listener);

    void requestCountryPolicy(@Nullable CountryPolicyListener listener);

    void requestPreventOnlineProcessingSettings(@Nullable Activity activity, int requestCode);

    void requestSystemAiPermission(@Nullable Activity activity, int requestCode);

    void setAccessTokenExpired();
}
