package com.samsung.android.support.senl.p148nt.base.winset.smarttip;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH\u0007J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/smarttip/SmartTipsPreferenceManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ERASER_SMART_TIPS_PREF", "SHOW_ERASER_SMART_TIPS_DELAY", "", "ERASER_SMART_TIPS_SHOW_COUNT", "", "getERASER_SMART_TIPS_SHOW_COUNT", "()[I", "setERASER_SMART_TIPS_SHOW_COUNT", "([I)V", "getSmartTipsPreference", "context", "Landroid/content/Context;", "key", "defaultValue", "setSmartTipsPreference", "", "value", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmartTipsPreferenceManager {

    @NotNull
    public static final String ERASER_SMART_TIPS_PREF = "EraserSmartTipsPref";
    public static final int SHOW_ERASER_SMART_TIPS_DELAY = 1000;

    @NotNull
    private static final String TAG = "SmartTipsPreferenceManager";

    @NotNull
    public static final SmartTipsPreferenceManager INSTANCE = new SmartTipsPreferenceManager();

    @NotNull
    private static int[] ERASER_SMART_TIPS_SHOW_COUNT = {5, 10, 15};

    private SmartTipsPreferenceManager() {
    }

    @JvmStatic
    public static final int getSmartTipsPreference(@NotNull Context context, @NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        int i = context.getSharedPreferences(key, 0).getInt(key, defaultValue);
        Logger.m8697d(TAG, "getSmartTipsPreference context/key/defaultValue : " + context + "/" + key + "/" + defaultValue + "/" + i);
        return i;
    }

    @JvmStatic
    public static final void setSmartTipsPreference(@NotNull Context context, @NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Logger.m8697d(TAG, "setSmartTipsPreference context/key/value : " + context + "/" + key + "/" + value);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(key, 0).edit();
        editorEdit.putInt(key, value);
        editorEdit.apply();
    }

    @NotNull
    public final int[] getERASER_SMART_TIPS_SHOW_COUNT() {
        return ERASER_SMART_TIPS_SHOW_COUNT;
    }

    public final void setERASER_SMART_TIPS_SHOW_COUNT(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        ERASER_SMART_TIPS_SHOW_COUNT = iArr;
    }
}
