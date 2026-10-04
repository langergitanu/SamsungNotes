package com.samsung.android.support.senl.addons.base.utils;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/Logger;", "", "<init>", "()V", "BASE_TAG", "", "getBASE_TAG", "()Ljava/lang/String;", "createTag", "tag", "createBrushTag", "d", "", "msg", "e", "t", "", "w", "i", "f", "getEncode", "content", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Logger {

    @NotNull
    public static final Logger INSTANCE = new Logger();

    @NotNull
    private static final String BASE_TAG = "Addons$";

    private Logger() {
    }

    @JvmStatic
    @NotNull
    public static final String createBrushTag(@Nullable String tag) {
        return AbstractC0541b.m757C(BASE_TAG, "Brush$", tag);
    }

    @JvmStatic
    @NotNull
    public static final String createTag(@Nullable String tag) {
        return AbstractC0541b.m757C(BASE_TAG, "Base$", tag);
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m7100d(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7101e(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7133e(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: f */
    public static final void m7103f(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7135f(tag, msg);
    }

    @JvmStatic
    @NotNull
    public static final String getEncode(@Nullable String content) {
        return LoggerBase.INSTANCE.getEncode(String.valueOf(content));
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m7104i(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7137i(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m7105w(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7138w(tag, msg);
    }

    @NotNull
    public final String getBASE_TAG() {
        return BASE_TAG;
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7102e(@NotNull String tag, @Nullable String msg, @NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(t, "t");
        LoggerBase.INSTANCE.m7134e(tag, msg, t);
    }
}
