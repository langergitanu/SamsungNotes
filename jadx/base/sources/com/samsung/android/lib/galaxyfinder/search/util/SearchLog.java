package com.samsung.android.lib.galaxyfinder.search.util;

import android.util.Log;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.util.SemLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/util/SearchLog;", "", "()V", SearchConstants.TargetContents.TAG, "", "d", "", "tag", "msg", "tr", "", "e", "f", "i", VPathDataCmd.RCurveTo, "w", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SearchLog {

    @NotNull
    public static final SearchLog INSTANCE = new SearchLog();

    @NotNull
    private static final String TAG = "SamSearch_";

    private SearchLog() {
    }

    /* JADX INFO: renamed from: d */
    public final int m5532d(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return SemLog.d(TAG + tag, msg);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m5534e(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return SemLog.e(TAG + tag, msg);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: f */
    public final int m5536f(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return Log.d(TAG + tag, msg);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: i */
    public final int m5538i(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return SemLog.i(TAG + tag, msg);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: v */
    public final int m5540v(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return SemLog.v(TAG + tag, msg);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: w */
    public final int m5542w(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return SemLog.w(TAG + tag, msg);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m5533d(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        try {
            return SemLog.d(TAG + tag, msg, tr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m5535e(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        try {
            return SemLog.e(TAG + tag, msg, tr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: f */
    public final int m5537f(@NotNull String tag, @Nullable String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(tr, "tr");
        try {
            return Log.d(TAG + tag, msg, tr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: i */
    public final int m5539i(@NotNull String tag, @NotNull String msg, @Nullable Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            return SemLog.i(TAG + tag, msg, tr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: v */
    public final int m5541v(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        try {
            return SemLog.v(TAG + tag, msg, tr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: w */
    public final int m5543w(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        try {
            return SemLog.w(TAG + tag, msg, tr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: w */
    public final int m5544w(@NotNull String tag, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(tr, "tr");
        try {
            return SemLog.w(TAG + tag, tr);
        } catch (Exception unused) {
            return 0;
        }
    }
}
