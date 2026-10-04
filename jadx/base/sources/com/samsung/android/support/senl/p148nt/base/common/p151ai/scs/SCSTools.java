package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.common.base.CharMatcher;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslationTokenInfo;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.visual.VisualAppInfo;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0005H\u0007J$\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005H\u0007J\u0010\u0010'\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u001e\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00050\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTools;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "KEY_TARGET_LANG", "HASH_API_KEY", "HASH_SIGNING_KEY", "RESULT_CACHE", "", "Landroid/util/Pair;", "CACHING_DELAY_MS", "", TextConst.KEY_PARAM_REQUEST_TYPE, "Lcom/samsung/android/sdk/scs/ai/language/AppInfo$RequestType;", "getRequestType$annotations", "getRequestType", "()Lcom/samsung/android/sdk/scs/ai/language/AppInfo$RequestType;", "setRequestType", "(Lcom/samsung/android/sdk/scs/ai/language/AppInfo$RequestType;)V", "sLock", "makeOndeviceAppInfo", "Lcom/samsung/android/sdk/scs/ai/language/AppInfo;", "makeAppInfo", "streaming", "", "makeVisualAppInfo", "Lcom/samsung/android/sdk/scs/ai/visual/VisualAppInfo;", "makeTranslationAppInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "getExtraPrompt", "content", "getAppInfoErrMsg", "addResultToCache", "", "key", "input", "result", "deleteResultCache", "getResultFromCache", "isDetectableLanguage", "equalsRequestType", "getTimeOut", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSTools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSTools.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTools\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n1#2:218\n*E\n"})
public final class SCSTools {
    public static final long CACHING_DELAY_MS = 1000;

    @NotNull
    private static final String HASH_API_KEY = "716b27cbf48c0270187c6ac158edd22338868508a9cbd34b8d3d49f14e6ee263";

    @NotNull
    private static final String HASH_SIGNING_KEY = "34DF0E7A9F1CF1892E45C056B4973CD81CCF148A4050D11AEA4AC5A65F900A42";

    @NotNull
    private static final String KEY_TARGET_LANG = "target_language";

    @NotNull
    private static final String TAG = "Ai$SCSTools";

    @NotNull
    public static final SCSTools INSTANCE = new SCSTools();

    @NotNull
    private static final Map<String, Pair<String, String>> RESULT_CACHE = new HashMap();

    @NotNull
    private static AppInfo.RequestType requestType = AppInfo.RequestType.CLOUD;

    @NotNull
    private static final Object sLock = new Object();

    private SCSTools() {
    }

    @JvmStatic
    public static final void addResultToCache(@Nullable String key, @Nullable String input, @NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(input) || TextUtils.isEmpty(result)) {
            return;
        }
        Pair<String, String> pair = new Pair<>(input, result);
        synchronized (sLock) {
            if (key != null) {
                RESULT_CACHE.put(key, pair);
            }
        }
        AbstractC4539a.m3188B("addResultToCache : ", key, TAG);
    }

    @JvmStatic
    @NotNull
    public static final String getAppInfoErrMsg() {
        Resources resources;
        Context applicationContext = BaseUtils.getApplicationContext();
        return String.valueOf((applicationContext == null || (resources = applicationContext.getResources()) == null) ? null : resources.getString(C8875R.string.base_something_wrong_try_again));
    }

    @NotNull
    public static final AppInfo.RequestType getRequestType() {
        return requestType;
    }

    @JvmStatic
    public static /* synthetic */ void getRequestType$annotations() {
    }

    @JvmStatic
    @Nullable
    public static final String getResultFromCache(@Nullable String key, @Nullable String input) {
        Pair<String, String> pair;
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(input)) {
            return null;
        }
        synchronized (sLock) {
            pair = RESULT_CACHE.get(key);
            Unit unit = Unit.INSTANCE;
        }
        if (pair != null) {
            Pair<String, String> pair2 = pair;
            Object obj = pair2.first;
            if (((String) obj) != null) {
                String str = (String) obj;
                if (Intrinsics.areEqual(str != null ? Integer.valueOf(str.length()) : null, input != null ? Integer.valueOf(input.length()) : null) && Intrinsics.areEqual((String) pair2.first, input)) {
                    AbstractC4539a.m3188B("getResultFromCache : ", key, TAG);
                    return (String) pair2.second;
                }
            }
        }
        return null;
    }

    private final boolean isDetectableLanguage(String content) {
        String strRemoveFrom = CharMatcher.anyOf("!\"#$%&(){}@`*:+;-.<>,^~|'[]/?_=\\").removeFrom(new Regex("[0-9]").replace(content, ""));
        Intrinsics.checkNotNullExpressionValue(strRemoveFrom, "removeFrom(...)");
        String strReplaceAll = Pattern.compile("[\\uD800-\\uDBFF\\uDC00-\\uDFFF]").matcher(strRemoveFrom).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "replaceAll(...)");
        return new Regex("\\s").replace(strReplaceAll, "").length() > 0;
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final AppInfo makeAppInfo(@NotNull AppInfo.RequestType requestType2) {
        Intrinsics.checkNotNullParameter(requestType2, "requestType");
        return makeAppInfo$default(requestType2, false, 2, null);
    }

    public static /* synthetic */ AppInfo makeAppInfo$default(AppInfo.RequestType requestType2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return makeAppInfo(requestType2, z);
    }

    @JvmStatic
    @NotNull
    public static final AppInfo makeOndeviceAppInfo() {
        AppInfo appInfoBuild = new AppInfo.Builder().setAppId(CommonUtils.getAppServiceId()).setRequestType(AppInfo.RequestType.ONDEVICE).setApiKey(HASH_API_KEY).setSigningKey(HASH_SIGNING_KEY).build();
        Intrinsics.checkNotNullExpressionValue(appInfoBuild, "build(...)");
        return appInfoBuild;
    }

    @JvmStatic
    @NotNull
    public static final TranslationTokenInfo makeTranslationAppInfo() {
        return new TranslationTokenInfo(HASH_API_KEY, HASH_SIGNING_KEY, CommonUtils.getAppServiceId(), "", "");
    }

    public static final void setRequestType(@NotNull AppInfo.RequestType requestType2) {
        Intrinsics.checkNotNullParameter(requestType2, "<set-?>");
        requestType = requestType2;
    }

    public final void deleteResultCache(@Nullable String key) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        synchronized (sLock) {
        }
        AbstractC4539a.m3188B("deleteResultCache : ", key, TAG);
    }

    public final boolean equalsRequestType(@NotNull AppInfo.RequestType requestType2) {
        Intrinsics.checkNotNullParameter(requestType2, "requestType");
        return requestType == requestType2;
    }

    @NotNull
    public final Map<String, String> getExtraPrompt(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        HashMap map = new HashMap();
        if (isDetectableLanguage(content)) {
            Logger.m8697d(TAG, "getExtraPrompt : nothing to add ");
            return map;
        }
        map.put(KEY_TARGET_LANG, Locale.getDefault().toLanguageTag());
        return map;
    }

    public final int getTimeOut(boolean streaming) {
        if (!equalsRequestType(AppInfo.RequestType.CLOUD)) {
            return 60;
        }
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            return streaming ? 100 : 40;
        }
        return 30;
    }

    @Nullable
    public final VisualAppInfo makeVisualAppInfo() {
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        companion.isB2BAccount();
        if (companion.isB2BAccount()) {
            Debugger.Companion companion2 = Debugger.INSTANCE;
            companion2.m8627i(TAG, AbstractC2322a.m1616f(UserHandleCompat.INSTANCE.getInstance().getUserId(0), "[SA] makeVisualAppInfo : userId = ", ", accessToken in B2B, ", companion2.pii(companion.getAccessToken())));
            VisualAppInfo.Builder appId = new VisualAppInfo.Builder().setAppId(CommonUtils.getAppB2BServiceId());
            Context applicationContext = BaseUtils.getApplicationContext();
            return appId.setPackageName(applicationContext != null ? applicationContext.getPackageName() : null).setApiKey(HASH_API_KEY).setSigningKey(HASH_SIGNING_KEY).setAccessToken(companion.getAccessToken()).setServerUrl(companion.getApiServerUrl()).setAccountType("B2B").build();
        }
        Debugger.Companion companion3 = Debugger.INSTANCE;
        companion3.m8627i(TAG, AbstractC2322a.m1616f(UserHandleCompat.INSTANCE.getInstance().getUserId(0), "[SA] makeVisualAppInfo : userId = ", ", accessToken in B2C, ", companion3.pii(companion.getAccessToken())));
        VisualAppInfo.Builder appId2 = new VisualAppInfo.Builder().setAppId(CommonUtils.getAppServiceId());
        Context applicationContext2 = BaseUtils.getApplicationContext();
        return appId2.setPackageName(applicationContext2 != null ? applicationContext2.getPackageName() : null).setApiKey(HASH_API_KEY).setSigningKey(HASH_SIGNING_KEY).setAccessToken(companion.getAccessToken()).setServerUrl(companion.getApiServerUrl()).setAccountType("B2C").build();
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final AppInfo makeAppInfo(@NotNull AppInfo.RequestType requestType2, boolean streaming) {
        Intrinsics.checkNotNullParameter(requestType2, "requestType");
        if (requestType2 == AppInfo.RequestType.CLOUD && TokenManager.checkServerDataInvalidate()) {
            TokenManager.requestAuthInfo();
            return null;
        }
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        companion.isB2BAccount();
        if (companion.isB2BAccount()) {
            Debugger.Companion companion2 = Debugger.INSTANCE;
            companion2.m8627i(TAG, AbstractC2322a.m1616f(UserHandleCompat.INSTANCE.getInstance().getUserId(0), "[SA] makeAppInfo : userId = ", ", accessToken in B2B, ", companion2.pii(companion.getAccessToken())));
            return new AppInfo.Builder().setAppId(CommonUtils.getAppB2BServiceId()).setAccessToken(companion.getAccessToken()).setServerUrl(companion.getApiServerUrl()).setRequestType(requestType2).setStreamingMode(streaming).setApiKey(HASH_API_KEY).setSigningKey(HASH_SIGNING_KEY).setAccountType("B2B").build();
        }
        Debugger.Companion companion3 = Debugger.INSTANCE;
        companion3.m8627i(TAG, AbstractC2322a.m1616f(UserHandleCompat.INSTANCE.getInstance().getUserId(0), "[SA] makeAppInfo : userId = ", ", accessToken in B2C, ", companion3.pii(companion.getAccessToken())));
        return new AppInfo.Builder().setAppId(CommonUtils.getAppServiceId()).setAccessToken(companion.getAccessToken()).setServerUrl(companion.getApiServerUrl()).setRequestType(requestType2).setStreamingMode(streaming).setApiKey(HASH_API_KEY).setSigningKey(HASH_SIGNING_KEY).build();
    }
}
