package com.samsung.android.support.senl.p148nt.app.lock.utils;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/utils/LockLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "createTag", "tag", "getEncode", "content", "d", "", "msg", "e", "tr", "", "i", "w", "f", "t", "p", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockLogger {

    @NotNull
    public static final LockLogger INSTANCE = new LockLogger();

    @NotNull
    private static final String TAG = "LockLog$";

    private LockLogger() {
    }

    @JvmStatic
    @NotNull
    public static final String createTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return TAG + tag;
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m7356d(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7132d(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7357e(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7133e(tag, msg);
    }

    @JvmStatic
    @NotNull
    public static final String getEncode(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return LoggerBase.INSTANCE.getEncode(content);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m7358i(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7137i(tag, msg);
    }

    /* JADX INFO: renamed from: f */
    public final void m7360f(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7135f(tag, msg);
    }

    /* JADX INFO: renamed from: p */
    public final void m7362p(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7137i(tag, msg);
    }

    /* JADX INFO: renamed from: w */
    public final void m7363w(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7138w(tag, msg);
    }

    /* JADX INFO: renamed from: e */
    public final void m7359e(@NotNull String tag, @NotNull String msg, @Nullable Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7134e(tag, msg, tr);
    }

    /* JADX INFO: renamed from: f */
    public final void m7361f(@NotNull String tag, @NotNull String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LoggerBase.INSTANCE.m7136f(tag, msg, t);
    }
}
