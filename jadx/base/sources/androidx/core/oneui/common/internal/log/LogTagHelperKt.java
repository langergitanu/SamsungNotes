package androidx.core.oneui.common.internal.log;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\n\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\r\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, m13886d2 = {"IS_DEBUG_DEVICE", "", "getIS_DEBUG_DEVICE", "()Z", "debug", "", "Landroidx/core/oneui/common/internal/log/LogTag;", "msg", "", "debugTouch", "error", "info", "verbose", "warn", "core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLogTagHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogTagHelper.kt\nandroidx/core/oneui/common/internal/log/LogTagHelperKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class LogTagHelperKt {
    private static final boolean IS_DEBUG_DEVICE;

    static {
        String TYPE = Build.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        String lowerCase = TYPE.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        IS_DEBUG_DEVICE = Intrinsics.areEqual(lowerCase, "eng") || Intrinsics.areEqual(lowerCase, "userdebug");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void debug(@NotNull LogTag logTag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(logTag, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        String version = logTag.isDebugVersion() ? logTag.getVersion() : "";
        if (IS_DEBUG_DEVICE) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(version);
            sbM1324q.append(logTag.getPrefix());
            sbM1324q.append('.');
            sbM1324q.append(logTag.getLogTag());
            Log.d(sbM1324q.toString(), msg);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void debugTouch(@NotNull LogTag logTag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(logTag, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (logTag.isDebugTouch()) {
            debug(logTag, msg);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void error(@NotNull LogTag logTag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(logTag, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        StringBuilder sbM1324q = AbstractC1974b.m1324q(logTag.isDebugVersion() ? logTag.getVersion() : "");
        sbM1324q.append(logTag.getPrefix());
        sbM1324q.append('.');
        sbM1324q.append(logTag.getLogTag());
        Log.e(sbM1324q.toString(), msg);
    }

    public static final boolean getIS_DEBUG_DEVICE() {
        return IS_DEBUG_DEVICE;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void info(@NotNull LogTag logTag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(logTag, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        StringBuilder sbM1324q = AbstractC1974b.m1324q(logTag.isDebugVersion() ? logTag.getVersion() : "");
        sbM1324q.append(logTag.getPrefix());
        sbM1324q.append('.');
        sbM1324q.append(logTag.getLogTag());
        Log.i(sbM1324q.toString(), msg);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void verbose(@NotNull LogTag logTag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(logTag, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        String version = logTag.isDebugVersion() ? logTag.getVersion() : "";
        if (IS_DEBUG_DEVICE) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(version);
            sbM1324q.append(logTag.getPrefix());
            sbM1324q.append('.');
            sbM1324q.append(logTag.getLogTag());
            Log.v(sbM1324q.toString(), msg);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void warn(@NotNull LogTag logTag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(logTag, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        StringBuilder sbM1324q = AbstractC1974b.m1324q(logTag.isDebugVersion() ? logTag.getVersion() : "");
        sbM1324q.append(logTag.getPrefix());
        sbM1324q.append('.');
        sbM1324q.append(logTag.getLogTag());
        Log.w(sbM1324q.toString(), msg);
    }
}
