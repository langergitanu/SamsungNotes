package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BatteryManagerCompat;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getBatteryStatus", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BatteryManagerCompat {

    @NotNull
    public static final BatteryManagerCompat INSTANCE = new BatteryManagerCompat();

    @NotNull
    private static final String TAG = "BatteryManagerCompat";

    private BatteryManagerCompat() {
    }

    @JvmStatic
    @Nullable
    public static final Integer getBatteryStatus(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                return Integer.valueOf(intentRegisterReceiver.getIntExtra("status", 1));
            }
            return null;
        } catch (NullPointerException e) {
            LoggerBase.INSTANCE.m7132d(TAG, "getBatteryStatus() Failed " + e.getMessage());
            return 1;
        }
    }
}
