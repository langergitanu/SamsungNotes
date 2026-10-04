package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u001a\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/CountryPolicyItem;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "errorCode", "", NetworkConfig.ACK_ERROR_MSG, "(Ljava/lang/String;Ljava/lang/String;)V", "mJsonObject", "getMJsonObject", "()Lorg/json/JSONObject;", "setMJsonObject", "value", "", "childAccountSupported", "getChildAccountSupported", "()Z", "", "minorAge", "getMinorAge", "()I", "isError", "getErrorCode", "()Ljava/lang/String;", "getErrorMsg", "setErrorMsg", "(Ljava/lang/String;)V", "parse", "getCountryCodeIso2", "context", "Landroid/content/Context;", "mcc", "checkMcc", "", "countrieJsonObject", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCountryPolicyItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CountryPolicyItem.kt\ncom/samsung/android/support/senl/nt/base/common/sync/CountryPolicyItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public final class CountryPolicyItem {

    @NotNull
    private static final String TAG = "CountryPolicyItem";
    private boolean childAccountSupported;

    @Nullable
    private String errorCode;

    @Nullable
    private String errorMsg;
    private boolean isError;

    @Nullable
    private JSONObject mJsonObject;
    private int minorAge;

    public CountryPolicyItem(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.mJsonObject = jsonObject;
    }

    private final void checkMcc(JSONObject countrieJsonObject, String mcc) {
        try {
            JSONArray jSONArray = countrieJsonObject.getJSONArray("mcc");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (Intrinsics.areEqual(string, mcc)) {
                    Debugger.INSTANCE.m8627i(TAG, "checkMcc() : Matched");
                    return;
                }
            }
        } catch (JSONException e) {
            Debugger.INSTANCE.m8627i(TAG, "checkMcc() : " + e);
        }
        Debugger.INSTANCE.m8621e(TAG, "checkMcc() : Not matched!");
    }

    private final String getCountryCodeIso2(Context context, String mcc) {
        String upperCase;
        String upperCase2 = null;
        if (TextUtils.isEmpty(mcc)) {
            upperCase = null;
        } else {
            String countryCodeIso2 = SamsungAccountUtil.INSTANCE.getCountryCodeIso2(context, mcc);
            if (countryCodeIso2 != null) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                upperCase = countryCodeIso2.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            Debugger.INSTANCE.m8627i(TAG, AbstractC0541b.m774p("getCountryCodeIso2() : ", upperCase == null ? "null" : upperCase, " with regionMcc = ", mcc == null ? "null" : mcc));
        }
        if (upperCase == null) {
            String countryIsoCode = SystemPropertiesCompat.INSTANCE.getInstance().getCountryIsoCode();
            if (countryIsoCode != null) {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                upperCase2 = countryIsoCode.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            }
            Debugger.Companion companion = Debugger.INSTANCE;
            if (mcc == null) {
                mcc = "null";
            }
            companion.m8627i(TAG, AbstractC0541b.m774p("getCountryCodeIso2() : ", upperCase2, " from appLocale due to mcc = ", mcc));
            upperCase = upperCase2;
        }
        return String.valueOf(upperCase);
    }

    public final boolean getChildAccountSupported() {
        return this.childAccountSupported;
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    public final JSONObject getMJsonObject() {
        return this.mJsonObject;
    }

    public final int getMinorAge() {
        return this.minorAge;
    }

    /* JADX INFO: renamed from: isError, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final boolean parse() {
        JSONObject jSONObject = this.mJsonObject;
        if (jSONObject == null) {
            Debugger.INSTANCE.m8621e(TAG, "fail to parse()");
            return false;
        }
        try {
            Intrinsics.checkNotNull(jSONObject);
            String string = jSONObject.getString("version");
            JSONObject jSONObject2 = this.mJsonObject;
            Intrinsics.checkNotNull(jSONObject2);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("countries");
            Context applicationContext = BaseUtils.getApplicationContext();
            String regionMcc = SamsungAccountUtil.getRegionMcc();
            JSONObject jSONObject4 = jSONObject3.getJSONObject(applicationContext != null ? getCountryCodeIso2(applicationContext, regionMcc) : null);
            Intrinsics.checkNotNull(jSONObject4);
            checkMcc(jSONObject4, regionMcc);
            JSONObject jSONObject5 = jSONObject4.getJSONObject("childAccount");
            this.childAccountSupported = jSONObject5.getBoolean("childAccountSupported");
            int i = jSONObject5.getInt("minorAge");
            this.minorAge = i;
            Debugger.INSTANCE.m8627i(TAG, "version : " + string + ", minorAge = " + i);
            return true;
        } catch (JSONException e) {
            Debugger.INSTANCE.m8621e(TAG, "parse() : " + e);
            return false;
        }
    }

    public final void setErrorMsg(@Nullable String str) {
        this.errorMsg = str;
    }

    public final void setMJsonObject(@Nullable JSONObject jSONObject) {
        this.mJsonObject = jSONObject;
    }

    public CountryPolicyItem(@Nullable String str, @Nullable String str2) {
        this.isError = true;
        this.errorCode = str;
        this.errorMsg = str2;
    }
}
