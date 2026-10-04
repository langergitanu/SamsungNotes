package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0017\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H\u0081\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u001c\u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\t\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m13886d2 = {"DEBUG_PROPERTY_NAME", "", "STACKTRACE_RECOVERY_PROPERTY_NAME", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_ON", "DEBUG_PROPERTY_VALUE_OFF", "ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "DEBUG", "getDEBUG", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "()V", "getRECOVER_STACK_TRACES", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "resetCoroutineId", "", "assert", "value", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class DebugKt {
    private static final boolean ASSERTIONS_ENABLED = false;

    @NotNull
    private static final AtomicLong COROUTINE_ID;
    private static final boolean DEBUG;

    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";

    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";

    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";

    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    private static final boolean RECOVER_STACK_TRACES;

    @NotNull
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0.equals("on") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r0 = true;
     */
    static {
        boolean z;
        String strSystemProp = SystemPropsKt.systemProp(DEBUG_PROPERTY_NAME);
        if (strSystemProp == null) {
            z = false;
        } else {
            int iHashCode = strSystemProp.hashCode();
            if (iHashCode != 0) {
                if (iHashCode != 3551) {
                    if (iHashCode == 109935) {
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + strSystemProp + '\'').toString());
            }
        }
        DEBUG = z;
        RECOVER_STACK_TRACES = z && SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true);
        COROUTINE_ID = new AtomicLong(0L);
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return ASSERTIONS_ENABLED;
    }

    @NotNull
    public static final AtomicLong getCOROUTINE_ID() {
        return COROUTINE_ID;
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return RECOVER_STACK_TRACES;
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0L);
    }

    @PublishedApi
    public static /* synthetic */ void getRECOVER_STACK_TRACES$annotations() {
    }

    @InlineOnly
    /* JADX INFO: renamed from: assert, reason: not valid java name */
    private static final void m23693assert(Function0<Boolean> function0) {
    }
}
