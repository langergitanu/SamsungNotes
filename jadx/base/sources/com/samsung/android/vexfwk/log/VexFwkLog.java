package com.samsung.android.vexfwk.log;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/log/VexFwkLog;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkLog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/log/VexFwkLog$Companion;", "", "()V", "d", "", "tag", "", "msg", "e", "i", "makeUpMessage", VPathDataCmd.RCurveTo, "w", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String makeUpMessage(String msg) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length <= 5) {
                return msg;
            }
            String fileName = stackTrace[4].getFileName();
            int lineNumber = stackTrace[4].getLineNumber();
            String methodName = stackTrace[4].getMethodName();
            StringBuilder sb = new StringBuilder();
            sb.append(fileName);
            sb.append(":");
            sb.append(lineNumber);
            sb.append(" ");
            sb.append(methodName);
            return AbstractC0622a.m1170p(": ", msg, sb);
        }

        @JvmStatic
        /* JADX INFO: renamed from: d */
        public final void m12816d(@Nullable String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.d(tag, makeUpMessage(msg));
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m12817e(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.e(tag, makeUpMessage(msg));
        }

        @JvmStatic
        /* JADX INFO: renamed from: i */
        public final void m12818i(@Nullable String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.i(tag, makeUpMessage(msg));
        }

        @JvmStatic
        /* JADX INFO: renamed from: v */
        public final void m12819v(@Nullable String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.v(tag, makeUpMessage(msg));
        }

        @JvmStatic
        /* JADX INFO: renamed from: w */
        public final void m12820w(@Nullable String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.w(tag, makeUpMessage(msg));
        }

        private Companion() {
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m12811d(@Nullable String str, @NotNull String str2) {
        INSTANCE.m12816d(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m12812e(@NotNull String str, @NotNull String str2) {
        INSTANCE.m12817e(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m12813i(@Nullable String str, @NotNull String str2) {
        INSTANCE.m12818i(str, str2);
    }

    @JvmStatic
    private static final String makeUpMessage(String str) {
        return INSTANCE.makeUpMessage(str);
    }

    @JvmStatic
    /* JADX INFO: renamed from: v */
    public static final void m12814v(@Nullable String str, @NotNull String str2) {
        INSTANCE.m12819v(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m12815w(@Nullable String str, @NotNull String str2) {
        INSTANCE.m12820w(str, str2);
    }
}
