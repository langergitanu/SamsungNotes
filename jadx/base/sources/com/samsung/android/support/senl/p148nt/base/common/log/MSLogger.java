package com.samsung.android.support.senl.p148nt.base.common.log;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/log/MSLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "d", "", "tag", "msg", "e", "t", "", "i", "w", "getEncode", "content", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MSLogger {

    @NotNull
    public static final MSLogger INSTANCE = new MSLogger();

    @NotNull
    private static final String TAG = "Microsoft$";

    private MSLogger() {
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8632d(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8697d(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8633e(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8698e(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m8635i(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8702i(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m8636w(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8703w(TAG + tag, msg);
    }

    @Nullable
    public final String getEncode(@Nullable String content) {
        return Logger.getEncode(content);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8634e(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8699e(TAG + tag, msg, t);
    }
}
