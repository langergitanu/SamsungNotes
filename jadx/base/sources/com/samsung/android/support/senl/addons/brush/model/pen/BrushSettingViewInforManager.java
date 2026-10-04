package com.samsung.android.support.senl.addons.brush.model.pen;

import android.content.SharedPreferences;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PreferenceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007J+\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/BrushSettingViewInforManager;", "", "<init>", "()V", "mSharedPreferences", "Landroid/content/SharedPreferences;", "mPenInfoList", "Ljava/util/Hashtable;", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mSelectedPenIndex", "", "close", "", "loadData", "makePenInfoList", "isHsv", "", "count", "data", "", "(ZI[Ljava/lang/String;)V", "getSelectedPenIndex", "getPenKey", "name", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBrushSettingViewInforManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrushSettingViewInforManager.kt\ncom/samsung/android/support/senl/addons/brush/model/pen/BrushSettingViewInforManager\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,151:1\n37#2:152\n36#2,3:153\n37#2:156\n36#2,3:157\n*S KotlinDebug\n*F\n+ 1 BrushSettingViewInforManager.kt\ncom/samsung/android/support/senl/addons/brush/model/pen/BrushSettingViewInforManager\n*L\n70#1:152\n70#1:153,3\n143#1:156\n143#1:157,3\n*E\n"})
public final class BrushSettingViewInforManager {
    private static final boolean DBG = false;

    @NotNull
    private static final String KEY_SETTING_PEN_INFO = "KEY_SETTING_PEN_INFO";
    private static final int PEN_INFO_ITEM_COUNT = 6;
    private static final int PEN_INFO_ITEM_COUNT_ADD = 9;

    @NotNull
    private static final String PREFERENCE_NAME = "_spensettings_drawing_v5";

    @NotNull
    private Hashtable<String, SpenSettingUIPenInfo> mPenInfoList = new Hashtable<>();
    private int mSelectedPenIndex;

    @Nullable
    private SharedPreferences mSharedPreferences;

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushSettingViewInforManager");

    @JvmField
    @NotNull
    public static BrushSettingViewInforManager INSTANCE = new BrushSettingViewInforManager();

    private BrushSettingViewInforManager() {
    }

    private final String getPenKey(String name) {
        String str = ((String[]) AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, name).toArray(new String[0]))[r4.length - 1];
        if (!new Regex(".*[0-9]*.").matches(str)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final void makePenInfoList(boolean isHsv, int count, String[] data) {
        int i = isHsv ? 9 : 6;
        for (int i2 = 0; i2 < count; i2++) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
            int i4 = i2 * i;
            spenSettingUIPenInfo.color = Integer.parseInt(data[i4 + 2]);
            spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(data[i4 + 4]);
            String str = data[i4 + 5];
            spenSettingUIPenInfo.name = str;
            if (StringsKt.m14162r(str, "OilBrush2")) {
                String strReplace$default = StringsKt__StringsJVMKt.replace$default(spenSettingUIPenInfo.name, '2', '3', false, 4, (Object) null);
                spenSettingUIPenInfo.name = strReplace$default;
                AbstractC6670b.m4763x("convert OilBrush version 2 -> 3 : ", strReplace$default, TAG);
            } else if (StringsKt.m14162r(spenSettingUIPenInfo.name, "Pencil2")) {
                String strReplace$default2 = StringsKt__StringsJVMKt.replace$default(spenSettingUIPenInfo.name, '2', '3', false, 4, (Object) null);
                spenSettingUIPenInfo.name = strReplace$default2;
                AbstractC6670b.m4763x("convert Pencil version 2 -> 3 : ", strReplace$default2, TAG);
            } else if (StringsKt.m14162r(spenSettingUIPenInfo.name, "Crayon")) {
                spenSettingUIPenInfo.name = SpenPenManager.SPEN_CRAYON2;
                Logger.m7100d(TAG, "convert Crayon version 1 -> 2 : com.samsung.android.sdk.pen.pen.preload.Crayon2");
            }
            spenSettingUIPenInfo.size = Float.parseFloat(data[i4 + 6]);
            spenSettingUIPenInfo.isEraserEnabled = Boolean.parseBoolean(data[i4 + 7]);
            if (isHsv) {
                spenSettingUIPenInfo.hsv[0] = Float.parseFloat(data[i4 + 8]);
                spenSettingUIPenInfo.hsv[1] = Float.parseFloat(data[i4 + 9]);
                spenSettingUIPenInfo.hsv[2] = Float.parseFloat(data[i4 + 10]);
            } else {
                ColorCompat.colorToHSV(spenSettingUIPenInfo.color, spenSettingUIPenInfo.hsv);
            }
            this.mPenInfoList.put(getPenKey(spenSettingUIPenInfo.name), spenSettingUIPenInfo);
        }
        if (count < 10) {
            String str2 = PenDefaultInfo.INSTANCE.getINFO_PREV_PEN_NAMES()[this.mSelectedPenIndex];
            for (int i5 = 0; i5 < 10; i5++) {
                if (Intrinsics.areEqual(PenDefaultInfo.INSTANCE.getINFO_PEN_NAMES()[i5], str2)) {
                    this.mSelectedPenIndex = i5;
                    return;
                }
            }
        }
    }

    public final void close() {
        this.mPenInfoList.clear();
        this.mSharedPreferences = null;
    }

    public final int getSelectedPenIndex() {
        int i = this.mSelectedPenIndex;
        if (i >= 9 || i < 0) {
            return 0;
        }
        return i;
    }

    @Nullable
    public final Hashtable<String, SpenSettingUIPenInfo> loadData() {
        SharedPreferences preference = PreferenceUtils.getPreference(PREFERENCE_NAME);
        this.mSharedPreferences = preference;
        if (preference == null) {
            Logger.m7100d(TAG, "loadData(), mSharedPreferences is null");
            return null;
        }
        Intrinsics.checkNotNull(preference);
        String string = preference.getString("KEY_SETTING_PEN_INFO", "");
        Intrinsics.checkNotNull(string);
        StringBuilder sb = new StringBuilder(string);
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        Logger.m7100d(TAG, "buf : " + string2);
        char c = 2;
        if (string2.length() == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb.append("10:0:");
            float[] fArr = new float[3];
            int i = 0;
            while (i < 10) {
                PenDefaultInfo penDefaultInfo = PenDefaultInfo.INSTANCE;
                ColorCompat.colorToHSV(penDefaultInfo.getINFO_PEN_COLORS()[i], fArr);
                sb2.append(penDefaultInfo.getINFO_PEN_COLORS()[i] + "::true:" + penDefaultInfo.getINFO_PEN_NAMES()[i] + ":" + penDefaultInfo.getINFO_PEN_SIZES()[i] + ":false:" + fArr[0] + ":" + fArr[1] + ":" + fArr[c] + ":");
                i++;
                c = c;
            }
            sb.append(sb2.toString());
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        String[] strArr = (String[]) new Regex(":").split(string3, 0).toArray(new String[0]);
        int i2 = Integer.parseInt(strArr[0]);
        this.mSelectedPenIndex = Integer.parseInt(strArr[1]);
        Logger.m7100d(TAG, "count = " + i2);
        if (i2 * 6 == strArr.length - 2) {
            makePenInfoList(false, i2, strArr);
        } else if (i2 * 9 == strArr.length - 2) {
            makePenInfoList(true, i2, strArr);
        }
        return this.mPenInfoList;
    }
}
