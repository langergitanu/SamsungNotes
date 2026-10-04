package kotlinx.coroutines.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineScopeImpl;", "Lkotlinx/coroutines/test/TestCoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lock", "", "exceptions", "", "", "cleanedUp", "", "reportException", "throwable", "testScheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getTestScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "initialJobs", "", "Lkotlinx/coroutines/Job;", "cleanupTestCoroutines", "", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestCoroutineScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestCoroutineScope.kt\nkotlinx/coroutines/test/TestCoroutineScopeImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 TestCoroutineScope.kt\nkotlinx/coroutines/test/TestCoroutineScopeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n27#2:201\n27#2:205\n16#3:202\n16#3:206\n168#4,2:203\n1863#5,2:207\n*S KotlinDebug\n*F\n+ 1 TestCoroutineScope.kt\nkotlinx/coroutines/test/TestCoroutineScopeImpl\n*L\n53#1:201\n83#1:205\n53#1:202\n83#1:206\n70#1:203,2\n89#1:207,2\n*E\n"})
final class TestCoroutineScopeImpl implements TestCoroutineScope {
    private boolean cleanedUp;

    @NotNull
    private final CoroutineContext coroutineContext;

    @NotNull
    private final Object lock = new Object();

    @NotNull
    private List<Throwable> exceptions = new ArrayList();

    @NotNull
    private final Set<Job> initialJobs = TestCoroutineScopeKt.activeJobs(getCoroutineContext());

    public TestCoroutineScopeImpl(@NotNull CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    @Override // kotlinx.coroutines.test.TestCoroutineScope
    @Deprecated(message = "Please call `runTest`, which automatically performs the cleanup, instead of using this function.")
    /* JADX INFO: renamed from: cleanupTestCoroutines */
    public void mo23776cleanupTestCoroutines() throws Throwable {
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
        TestCoroutineDispatcher testCoroutineDispatcher = continuationInterceptor instanceof TestCoroutineDispatcher ? (TestCoroutineDispatcher) continuationInterceptor : null;
        boolean z = false;
        if (testCoroutineDispatcher != null) {
            try {
                testCoroutineDispatcher.cleanupTestCoroutines();
            } catch (UncompletedCoroutinesError unused) {
                z = true;
            }
        } else {
            getTestScheduler().runCurrent();
            if (!getTestScheduler().isIdle$kotlinx_coroutines_test(false)) {
                z = true;
            }
        }
        CoroutineContext.Element element = getCoroutineContext().get(CoroutineExceptionHandler.INSTANCE);
        TestCoroutineExceptionHandler testCoroutineExceptionHandler = element instanceof TestCoroutineExceptionHandler ? (TestCoroutineExceptionHandler) element : null;
        if (testCoroutineExceptionHandler != null) {
            testCoroutineExceptionHandler.cleanupTestCoroutines();
        }
        synchronized (this.lock) {
            if (this.cleanedUp) {
                throw new IllegalStateException("Attempting to clean up a test coroutine scope more than once.");
            }
            this.cleanedUp = true;
            Unit unit = Unit.INSTANCE;
        }
        Throwable th = (Throwable) CollectionsKt.firstOrNull((List) this.exceptions);
        if (th != null) {
            Iterator it = CollectionsKt.drop(this.exceptions, 1).iterator();
            while (it.hasNext()) {
                ExceptionsKt.addSuppressed(th, (Throwable) it.next());
            }
            throw th;
        }
        if (z) {
            throw new UncompletedCoroutinesError("Unfinished coroutines during teardown. Ensure all coroutines are completed or cancelled by your test.");
        }
        Set<Job> setActiveJobs = TestCoroutineScopeKt.activeJobs(getCoroutineContext());
        if (SetsKt.minus((Set) setActiveJobs, (Iterable) this.initialJobs).isEmpty()) {
            return;
        }
        throw new UncompletedCoroutinesError("Test finished with active jobs: " + setActiveJobs);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // kotlinx.coroutines.test.TestCoroutineScope
    @NotNull
    public TestCoroutineScheduler getTestScheduler() {
        CoroutineContext.Element element = getCoroutineContext().get(TestCoroutineScheduler.INSTANCE);
        Intrinsics.checkNotNull(element);
        return (TestCoroutineScheduler) element;
    }

    public final boolean reportException(@NotNull Throwable throwable) {
        boolean z;
        synchronized (this.lock) {
            if (this.cleanedUp) {
                z = false;
            } else {
                this.exceptions.add(throwable);
                z = true;
            }
        }
        return z;
    }
}
