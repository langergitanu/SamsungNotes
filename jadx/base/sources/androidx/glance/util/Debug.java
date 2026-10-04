package androidx.glance.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/util/Debug;", "", "()V", "getCaller", "", "callStack", "", "Ljava/lang/StackTraceElement;", DBSchema.CategoryTreeClosure.DEPTH, "", "([Ljava/lang/StackTraceElement;I)Ljava/lang/String;", "getCallers", "printStackTrace", "", "tag", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Debug {
    public static final int $stable = 0;

    @NotNull
    public static final Debug INSTANCE = new Debug();

    private Debug() {
    }

    private final String getCaller(StackTraceElement[] callStack, int depth) {
        int i = depth + 4;
        if (i >= callStack.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = callStack[i];
        return stackTraceElement.getClassName() + Extension.DOT + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
    }

    @Nullable
    public final String getCallers(int depth) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        int iM2213d = 0;
        while (iM2213d < depth) {
            Intrinsics.checkNotNull(stackTrace);
            iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, getCaller(stackTrace, iM2213d), " ");
        }
        return sb.toString();
    }

    public final void printStackTrace(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        for (int i = 3; i < length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            int lineNumber = stackTraceElement.getLineNumber();
            StringBuilder sbM2228s = AbstractC2821a.m2228s(className, Extension.DOT, methodName, "(", fileName);
            sbM2228s.append(":");
            sbM2228s.append(lineNumber);
            sbM2228s.append(")");
            Log.w(tag, "    at " + sbM2228s.toString());
        }
    }
}
