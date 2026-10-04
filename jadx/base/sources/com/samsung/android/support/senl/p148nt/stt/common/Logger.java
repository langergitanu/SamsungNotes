package com.samsung.android.support.senl.p148nt.stt.common;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/common/Logger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "createTag", "tag", "d", "", "msg", "e", "t", "", "i", "w", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Logger {

    @NotNull
    public static final Logger INSTANCE = new Logger();

    @NotNull
    private static final String TAG = "STT$";

    private Logger() {
    }

    @JvmStatic
    @NotNull
    public static final String createTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return LoggerBase.INSTANCE.createTag(TAG + tag);
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m12710d(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m12711e(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7133e(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m12713i(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7137i(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m12714w(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7138w(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m12712e(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7134e(TAG + tag, msg, t);
    }
}
