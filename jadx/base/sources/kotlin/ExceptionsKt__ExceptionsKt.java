package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlOptions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\b\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0007\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0007\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00028F¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m13886d2 = {"printStackTrace", "", "", "writer", "Ljava/io/PrintWriter;", "stream", "Ljava/io/PrintStream;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "stackTraceToString", "", "addSuppressed", "exception", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "kotlin-stdlib"}, m13887k = 5, m13888mv = {2, 1, 0}, m13890xi = 49, m13891xs = "kotlin/ExceptionsKt")
public class ExceptionsKt__ExceptionsKt {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void addSuppressed(@NotNull Throwable th, @NotNull Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, exception);
        }
    }

    @NotNull
    public static final StackTraceElement[] getStackTrace(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    @NotNull
    public static final List<Throwable> getSuppressedExceptions(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th);
    }

    @InlineOnly
    private static final void printStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        th.printStackTrace();
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    @NotNull
    public static String stackTraceToString(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @InlineOnly
    private static final void printStackTrace(Throwable th, PrintWriter writer) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        th.printStackTrace(writer);
    }

    @InlineOnly
    private static final void printStackTrace(Throwable th, PrintStream stream) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        th.printStackTrace(stream);
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }
}
