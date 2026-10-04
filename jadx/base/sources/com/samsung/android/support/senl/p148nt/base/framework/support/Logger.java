package com.samsung.android.support.senl.p148nt.base.framework.support;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\"\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/support/Logger;", "", "<init>", "()V", "createTag", "", "tag", "getLogFiles", "", "Ljava/io/File;", "context", "Landroid/content/Context;", "d", "", "msg", "w", "e", "t", "", "i", "f", "pii", "str", "getEncode", "content", "getTimeString", "ms", "", "setupFileLogger", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Logger {

    @NotNull
    public static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    @JvmStatic
    @NotNull
    public static final String createTag(@Nullable String tag) {
        return LoggerBase.INSTANCE.createTag(String.valueOf(tag));
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8697d(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8698e(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7133e(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: f */
    public static final void m8700f(@NotNull String tag, @NotNull String msg) {
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
    @NotNull
    public static final List<File> getLogFiles(@Nullable Context context) {
        return LoggerBase.INSTANCE.getLogFiles(context);
    }

    @JvmStatic
    @NotNull
    public static final String getTimeString(long ms) {
        return LoggerBase.INSTANCE.getTimeString(ms);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m8702i(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7137i(tag, msg);
    }

    @JvmStatic
    @NotNull
    public static final String pii(@Nullable String str) {
        return LoggerBase.INSTANCE.pii(str);
    }

    @JvmStatic
    public static final void setupFileLogger(@Nullable Context context) {
        LoggerBase.INSTANCE.setupFileLogger(context);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m8703w(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8699e(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7134e(tag, msg, t);
    }

    @JvmStatic
    /* JADX INFO: renamed from: f */
    public static final void m8701f(@NotNull String tag, @NotNull String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7136f(tag, msg, t);
    }
}
