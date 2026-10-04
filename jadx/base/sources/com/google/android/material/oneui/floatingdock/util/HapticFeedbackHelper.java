package com.google.android.material.oneui.floatingdock.util;

import android.view.View;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import com.google.android.material.oneui.floatingdock.FloatingDockLogTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000f\u001a\u00020\b*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/util/HapticFeedbackHelper;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "onEditGuide", "", "view", "Landroid/view/View;", "onEditGuideWithSnapping", "onLongPress", "onTap", "onTouchMinimizeThreshold", "semPerformHapticFeedback", "index", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class HapticFeedbackHelper implements FloatingDockLogTag {

    @NotNull
    public static final HapticFeedbackHelper INSTANCE = new HapticFeedbackHelper();

    @NotNull
    private static final String logTag = "HapticFeedbackHelper";

    private HapticFeedbackHelper() {
    }

    private final void semPerformHapticFeedback(View view, int i) {
        LogTagHelperKt.debug(this, "performHaptic index=" + i);
        view.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(i));
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return logTag;
    }

    public final void onEditGuide(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        semPerformHapticFeedback(view, 41);
    }

    public final void onEditGuideWithSnapping(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        semPerformHapticFeedback(view, 49);
    }

    public final void onLongPress(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        semPerformHapticFeedback(view, 108);
    }

    public final void onTap(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        semPerformHapticFeedback(view, 1);
    }

    public final void onTouchMinimizeThreshold(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        semPerformHapticFeedback(view, 23);
    }
}
