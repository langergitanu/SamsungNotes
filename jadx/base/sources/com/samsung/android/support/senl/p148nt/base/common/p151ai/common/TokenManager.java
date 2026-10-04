package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0007J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0007J\b\u0010$\u001a\u00020\u001bH\u0007J\b\u0010%\u001a\u00020\u001bH\u0007J\u0012\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\tR\u0014\u0010!\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/TokenManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sTokenExpiredRequestAuthInfo", "", "getSTokenExpiredRequestAuthInfo", "()Z", "setSTokenExpiredRequestAuthInfo", "(Z)V", "sRequestAuthInfo", "getSRequestAuthInfo", "setSRequestAuthInfo", TokenManager.CHECK_DURATION_WEEK, "LAST_USE_CHECK_PERIOD", "", "LAST_USE_CHECK_MIN_PERIOD", "sCheckPeriod", "sContract", "Lcom/samsung/android/support/senl/nt/base/common/ai/common/TokenManager$Contract;", "mExecutor", "Ljava/util/concurrent/Executor;", "sAuthInfoReqListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/IAuthInfoReqListener;", "setTokenExpiredRequestAuthInfo", "", "requestAuthInfo", "reset", "isNetworkAvailable", "expired", "checkServerDataInvalidate", "checkPeriod", "getCheckPeriod", "()J", "setCheckPeriod", "checkTokenValidate", "setListener", "contract", "Contract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TokenManager {

    @NotNull
    private static final String CHECK_DURATION_WEEK = "CHECK_DURATION_WEEK";
    private static final long LAST_USE_CHECK_MIN_PERIOD = 1800000;
    public static final long LAST_USE_CHECK_PERIOD = 604800000;

    @NotNull
    private static final Executor mExecutor;

    @NotNull
    private static final IAuthInfoReqListener sAuthInfoReqListener;
    private static long sCheckPeriod;

    @Nullable
    private static Contract sContract;
    private static boolean sRequestAuthInfo;
    private static boolean sTokenExpiredRequestAuthInfo;

    @NotNull
    public static final TokenManager INSTANCE = new TokenManager();

    @NotNull
    private static final String TAG = "AI#TokenManager";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/TokenManager$Contract;", "", "onReceived", "", "onError", "errCode", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onError(@NotNull String errCode);

        void onReceived();
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory("AI#TokenManager"));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        mExecutor = executorServiceNewSingleThreadExecutor;
        sAuthInfoReqListener = new TokenManager$sAuthInfoReqListener$1();
    }

    private TokenManager() {
    }

    @JvmStatic
    public static final boolean checkServerDataInvalidate() {
        if (DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
            return false;
        }
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        return TextUtils.isEmpty(companion.getAccessToken()) || TextUtils.isEmpty(companion.getApiServerUrl());
    }

    @JvmStatic
    public static final void checkTokenValidate() {
        if (!Features.isSupportAiFunction()) {
            Logger.m8702i(TAG, "checkTokenValidate() - not support ai function.");
            return;
        }
        TokenManager tokenManager = INSTANCE;
        if (!tokenManager.isNetworkAvailable() || !RequestToSamsungAccountManager.INSTANCE.isLogined() || DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
            Logger.m8702i(TAG, "checkTokenValidate() - not avaliable state.");
            return;
        }
        long checkPeriod = tokenManager.getCheckPeriod();
        if (checkPeriod == 0) {
            Logger.m8702i(TAG, "checkTokenValidate() - ai check at the first app launch.");
            requestAuthInfo();
            return;
        }
        if (System.currentTimeMillis() - checkPeriod > 604800000) {
            Logger.m8702i(TAG, "checkTokenValidate() - this is a user who has not used the ai function for a week... So skip. " + checkPeriod);
            return;
        }
        if (System.currentTimeMillis() - sCheckPeriod >= LAST_USE_CHECK_MIN_PERIOD) {
            Logger.m8702i(TAG, "checkTokenValidate()");
            requestAuthInfo();
        } else {
            Logger.m8702i(TAG, "checkTokenValidate() - min period So skip. " + checkPeriod);
        }
    }

    private final long getCheckPeriod() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getLong(CHECK_DURATION_WEEK, 0L);
    }

    private final boolean isNetworkAvailable() {
        RequestToSCloudManager companion;
        RequestToSCloudManager.Companion companion2 = RequestToSCloudManager.INSTANCE;
        RequestToSCloudManager companion3 = companion2.getInstance();
        return (companion3 != null && companion3.isWiFiAvailable()) || ((companion = companion2.getInstance()) != null && companion.isDataNetworkAvailable());
    }

    @JvmStatic
    public static final synchronized void requestAuthInfo() {
        if (!sTokenExpiredRequestAuthInfo && !sRequestAuthInfo) {
            Logger.m8702i(TAG, "requestAuthInfo");
            sRequestAuthInfo = true;
            mExecutor.execute(new RunnableC0284b(1));
            return;
        }
        Logger.m8702i(TAG, "requestAuthInfo return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAuthInfo$lambda$1() {
        INSTANCE.requestAuthInfo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void reset() {
        sTokenExpiredRequestAuthInfo = false;
        sRequestAuthInfo = false;
    }

    @JvmStatic
    public static final void setCheckPeriod() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putLong(CHECK_DURATION_WEEK, System.currentTimeMillis());
    }

    @JvmStatic
    public static final void setListener(@Nullable Contract contract) {
        sContract = contract;
    }

    @JvmStatic
    public static final synchronized void setTokenExpiredRequestAuthInfo() {
        if (sTokenExpiredRequestAuthInfo) {
            Logger.m8702i(TAG, "setTokenExpiredRequestAuthInfo return");
            return;
        }
        Logger.m8702i(TAG, "setTokenExpiredRequestAuthInfo");
        sTokenExpiredRequestAuthInfo = true;
        if (sRequestAuthInfo) {
            RequestToSamsungAccountManager.INSTANCE.cancelAuthInfo(sAuthInfoReqListener);
        }
        RequestToSamsungAccountManager.INSTANCE.setAccessTokenExpired();
        mExecutor.execute(new RunnableC0284b(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTokenExpiredRequestAuthInfo$lambda$0() {
        INSTANCE.requestAuthInfo(true);
    }

    public final boolean getSRequestAuthInfo() {
        return sRequestAuthInfo;
    }

    public final boolean getSTokenExpiredRequestAuthInfo() {
        return sTokenExpiredRequestAuthInfo;
    }

    public final void setSRequestAuthInfo(boolean z) {
        sRequestAuthInfo = z;
    }

    public final void setSTokenExpiredRequestAuthInfo(boolean z) {
        sTokenExpiredRequestAuthInfo = z;
    }

    private final void requestAuthInfo(boolean expired) {
        if (!isNetworkAvailable()) {
            Logger.m8702i(TAG, "requestAuthInfo# requested. fail");
            reset();
            Contract contract = sContract;
            if (contract != null) {
                if (contract != null) {
                    contract.onError("");
                }
                sContract = null;
                return;
            }
            return;
        }
        Logger.m8702i(TAG, "requestAuthInfo# requested# " + expired);
        sCheckPeriod = System.currentTimeMillis();
        RequestToSamsungAccountManager.INSTANCE.requestAuthInfo(sAuthInfoReqListener);
    }
}
