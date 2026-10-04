package com.google.android.material.oneui.floatingdock.util;

import android.content.Context;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m13886d2 = {"scaledTouchSlop", "", "Landroid/content/Context;", "getScaledTouchSlop", "(Landroid/content/Context;)I", "isPhoneSize", "", "material_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PolicyHelperKt {
    public static final int getScaledTouchSlop(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public static final boolean isPhoneSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getConfiguration().smallestScreenWidthDp < 600;
    }
}
