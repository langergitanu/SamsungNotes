package com.samsung.android.support.senl.docscan.common;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/common/Logger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "TIME_TAG", "TRACKING", "mTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "", "tag", "msg", "t", "e", "", "i", "w", "startTime", "hashCode", "endTime", "getEncode", "content", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Logger {

    @NotNull
    private static final String TAG = "DocumentScan$";

    @NotNull
    private static final String TIME_TAG = "[Performance]";

    @NotNull
    private static final String TRACKING = "[Tracking]";

    @NotNull
    public static final Logger INSTANCE = new Logger();

    @NotNull
    private static final HashMap<String, Long> mTimeMap = new HashMap<>();

    private Logger() {
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m7145d(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7146e(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7133e(TAG + tag, msg);
    }

    @JvmStatic
    public static final void endTime(@NotNull String hashCode, @NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(hashCode, "hashCode");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Long lRemove = mTimeMap.remove(hashCode);
        if (lRemove != null) {
            long jLongValue = lRemove.longValue();
            m7145d(AbstractC0541b.m756B(tag, TRACKING), "[Performance]" + msg + ": " + (System.currentTimeMillis() - jLongValue) + " ms");
        }
    }

    @JvmStatic
    @NotNull
    public static final String getEncode(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return LoggerBase.INSTANCE.getEncode(content);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m7148i(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7137i(TAG + tag, msg);
    }

    @JvmStatic
    public static final void startTime(@NotNull String hashCode, @NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(hashCode, "hashCode");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        mTimeMap.put(hashCode, Long.valueOf(System.currentTimeMillis()));
        m7145d(tag + TRACKING, "[Performance]" + msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: t */
    public static final void m7149t(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(TAG + tag + TRACKING, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m7150w(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7138w(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7147e(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7134e(TAG + tag, msg, t);
    }
}
