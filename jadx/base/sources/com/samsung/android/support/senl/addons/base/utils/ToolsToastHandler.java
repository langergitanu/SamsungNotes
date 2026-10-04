package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ToolsToastHandler;", "", "<init>", "()V", "mApplicationContext", "Landroid/content/Context;", "setApplicationContext", "", "context", "showLong", "content", "", "showShort", "id", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToolsToastHandler {

    @NotNull
    public static final ToolsToastHandler INSTANCE = new ToolsToastHandler();

    @Nullable
    private static Context mApplicationContext;

    private ToolsToastHandler() {
    }

    public final void setApplicationContext(@Nullable Context context) {
        mApplicationContext = context;
    }

    public final void showLong(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Context context = mApplicationContext;
        if (context != null) {
            PlatformUtil.showToast(context, content, 1);
        }
    }

    public final void showShort(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Context context = mApplicationContext;
        if (context != null) {
            PlatformUtil.showToast(context, content, 0);
        }
    }

    @JvmStatic
    public static final void showLong(int id) {
        Context context = mApplicationContext;
        if (context != null) {
            PlatformUtil.showToast(context, id, 1);
        }
    }

    public final void showShort(int id) {
        Context context = mApplicationContext;
        if (context != null) {
            PlatformUtil.showToast(context, id, 0);
        }
    }
}
