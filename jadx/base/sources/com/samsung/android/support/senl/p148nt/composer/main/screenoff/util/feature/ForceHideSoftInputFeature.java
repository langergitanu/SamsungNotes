package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature;

import android.content.Context;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/feature/ForceHideSoftInputFeature;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "needToForceHideSoftInput", "", "context", "Landroid/content/Context;", "hideSoftInput", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ForceHideSoftInputFeature {

    @NotNull
    public static final ForceHideSoftInputFeature INSTANCE = new ForceHideSoftInputFeature();

    @NotNull
    private static final String TAG = SOLogger.createTag("ForceHideSoftInputFeature");

    private ForceHideSoftInputFeature() {
    }

    public final void hideSoftInput(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SOLogger.INSTANCE.SOLoggerD(TAG, "hideSoftInput#");
        if (DeviceInfo.isSemDevice()) {
            InputMethodCompat.INSTANCE.getInstance().forceHideSoftInput(context);
            return;
        }
        try {
            Object systemService = context.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).toggleSoftInput(1, 0);
        } catch (Exception e) {
            AbstractC8014b.m7208j("hideSoftInput# ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    public final boolean needToForceHideSoftInput(@Nullable Context context) {
        boolean z = Build.VERSION.SDK_INT <= 29 || !KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(context);
        AbstractC8014b.m7211m("needToForceHideSoftInput# result ", z, SOLogger.INSTANCE, TAG);
        return z;
    }
}
