package kotlinx.coroutines.test.internal;

import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0096\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lkotlinx/coroutines/test/internal/ExceptionCollector;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "lock", "", "enabled", "", "unprocessedExceptions", "", "", "callbacks", "", "Lkotlin/Function1;", "", "addOnExceptionCallback", "owner", Profile.PhoneNumberData.TYPE_CALLBACK, "removeOnExceptionCallback", "handleException", "exception", "reportException", "context", "Lkotlin/coroutines/CoroutineContext;", "equals", "other", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nExceptionCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionCollector.kt\nkotlinx/coroutines/test/internal/ExceptionCollector\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n27#2:98\n27#2:102\n27#2:104\n16#3:99\n16#3:103\n16#3:105\n1863#4,2:100\n*S KotlinDebug\n*F\n+ 1 ExceptionCollector.kt\nkotlinx/coroutines/test/internal/ExceptionCollector\n*L\n29#1:98\n41#1:102\n54#1:104\n29#1:99\n41#1:103\n54#1:105\n34#1:100,2\n*E\n"})
public final class ExceptionCollector extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private static boolean enabled;

    @NotNull
    public static final ExceptionCollector INSTANCE = new ExceptionCollector();

    @NotNull
    private static final Object lock = new Object();

    @NotNull
    private static final List<Throwable> unprocessedExceptions = new ArrayList();

    @NotNull
    private static final Map<Object, Function1<Throwable, Unit>> callbacks = new LinkedHashMap();

    private ExceptionCollector() {
        super(CoroutineExceptionHandler.INSTANCE);
    }

    private final boolean reportException(Throwable exception) {
        Iterator<Function1<Throwable, Unit>> it = callbacks.values().iterator();
        boolean z = false;
        while (it.hasNext()) {
            it.next().invoke(exception);
            z = true;
        }
        return z;
    }

    public final void addOnExceptionCallback(@NotNull Object owner, @NotNull Function1<? super Throwable, Unit> callback) {
        synchronized (lock) {
            try {
                enabled = true;
                if (callbacks.put(owner, callback) != null) {
                    throw new IllegalStateException("Check failed.");
                }
                Iterator<T> it = unprocessedExceptions.iterator();
                while (it.hasNext()) {
                    INSTANCE.reportException((Throwable) it.next());
                }
                unprocessedExceptions.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof ExceptionCollector) || (other instanceof ExceptionCollectorAsService);
    }

    public final boolean handleException(@NotNull Throwable exception) {
        synchronized (lock) {
            if (!enabled) {
                return false;
            }
            if (INSTANCE.reportException(exception)) {
                return true;
            }
            unprocessedExceptions.add(exception);
            return false;
        }
    }

    public final void removeOnExceptionCallback(@NotNull Object owner) {
        synchronized (lock) {
            try {
                if (enabled && callbacks.remove(owner) == null) {
                    throw new IllegalStateException("Check failed.");
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) throws ExceptionSuccessfullyProcessed {
        if (handleException(exception)) {
            throw ExceptionSuccessfullyProcessed.INSTANCE;
        }
    }
}
