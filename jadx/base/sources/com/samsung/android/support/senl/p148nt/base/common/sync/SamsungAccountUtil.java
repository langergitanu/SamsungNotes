package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/SamsungAccountUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "applicationRegion", "getApplicationRegion$annotations", "getApplicationRegion", "()Ljava/lang/String;", "getCountryCodeIso3", "context", "Landroid/content/Context;", "mcc", "getCountryCodeIso2", "getJSONArrayFromInputStream", "Lorg/json/JSONArray;", "stream", "Ljava/io/InputStream;", "regionMcc", "getRegionMcc$annotations", "getRegionMcc", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSamsungAccountUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SamsungAccountUtil.kt\ncom/samsung/android/support/senl/nt/base/common/sync/SamsungAccountUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
public final class SamsungAccountUtil {

    @NotNull
    public static final SamsungAccountUtil INSTANCE = new SamsungAccountUtil();

    @NotNull
    private static final String TAG = "SamsungAccountUtil";

    private SamsungAccountUtil() {
    }

    @Nullable
    public static final String getApplicationRegion() {
        String iSO3Country;
        Context applicationContext = BaseUtils.getApplicationContext();
        String regionMcc = getRegionMcc();
        if (TextUtils.isEmpty(regionMcc)) {
            iSO3Country = "";
        } else {
            iSO3Country = applicationContext != null ? INSTANCE.getCountryCodeIso3(applicationContext, regionMcc) : null;
            Debugger.INSTANCE.m8627i(TAG, AbstractC0541b.m774p("getApplicationRegion() : ", iSO3Country, " with regionMcc = ", regionMcc));
        }
        if (TextUtils.isEmpty(iSO3Country)) {
            try {
                iSO3Country = new Locale("", SystemPropertiesCompat.INSTANCE.getInstance().getCountryIsoCode()).getISO3Country();
            } catch (Exception e) {
                Debugger.INSTANCE.m8621e(TAG, "getApplicationRegion() : " + e);
            }
            Debugger.INSTANCE.m8627i(TAG, AbstractC0541b.m774p("getApplicationRegion() : ", iSO3Country, " from appLocale due to mcc = ", regionMcc));
        }
        return iSO3Country;
    }

    @JvmStatic
    public static /* synthetic */ void getApplicationRegion$annotations() {
    }

    private final String getCountryCodeIso3(Context context, String mcc) {
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getResources().getAssets().open("mcc/countries.json");
        } catch (IOException e) {
            Debugger.INSTANCE.m8622e(TAG, "getCountryCodeIso3() : ", e);
        }
        try {
            SamsungAccountUtil samsungAccountUtil = INSTANCE;
            Intrinsics.checkNotNull(inputStreamOpen);
            JSONArray jSONArrayFromInputStream = samsungAccountUtil.getJSONArrayFromInputStream(inputStreamOpen);
            if (jSONArrayFromInputStream != null) {
                int length = jSONArrayFromInputStream.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject = jSONArrayFromInputStream.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                        if (Intrinsics.areEqual(mcc, String.valueOf(jSONObject.getInt("mobileCountryCode")))) {
                            String string = jSONObject.getString("countryCodeIso3");
                            CloseableKt.closeFinally(inputStreamOpen, null);
                            return string;
                        }
                        continue;
                    } catch (Exception e2) {
                        Debugger.INSTANCE.m8622e(TAG, "getCountryCodeIso3() : ", e2);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(inputStreamOpen, null);
            return null;
        } finally {
        }
    }

    private final JSONArray getJSONArrayFromInputStream(InputStream stream) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            try {
                sb = new StringBuilder();
            } finally {
            }
        } catch (JSONException e) {
            Debugger.INSTANCE.m8621e(TAG, e.getMessage());
            return null;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                JSONArray jSONArray = new JSONArray(string);
                CloseableKt.closeFinally(bufferedReader, null);
                return jSONArray;
            }
            sb.append(line);
            sb.append('\n');
            Debugger.INSTANCE.m8621e(TAG, e.getMessage());
            return null;
        }
    }

    @Nullable
    public static final String getRegionMcc() {
        return RequestToSamsungAccountManager.INSTANCE.getRegionMcc();
    }

    @JvmStatic
    public static /* synthetic */ void getRegionMcc$annotations() {
    }

    @Nullable
    public final String getCountryCodeIso2(@NotNull Context context, @Nullable String mcc) {
        InputStream inputStreamOpen;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            inputStreamOpen = context.getResources().getAssets().open("mcc/countries.json");
        } catch (IOException e) {
            Debugger.INSTANCE.m8622e(TAG, "getCountryCodeIso2() : ", e);
        }
        try {
            SamsungAccountUtil samsungAccountUtil = INSTANCE;
            Intrinsics.checkNotNull(inputStreamOpen);
            JSONArray jSONArrayFromInputStream = samsungAccountUtil.getJSONArrayFromInputStream(inputStreamOpen);
            if (jSONArrayFromInputStream != null) {
                int length = jSONArrayFromInputStream.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject = jSONArrayFromInputStream.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                        if (Intrinsics.areEqual(mcc, String.valueOf(jSONObject.getInt("mobileCountryCode")))) {
                            String string = jSONObject.getString("countryCodeIso2");
                            CloseableKt.closeFinally(inputStreamOpen, null);
                            return string;
                        }
                        continue;
                    } catch (Exception e2) {
                        Debugger.INSTANCE.m8622e(TAG, "getCountryCodeIso2() : ", e2);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(inputStreamOpen, null);
            return null;
        } finally {
        }
    }
}
