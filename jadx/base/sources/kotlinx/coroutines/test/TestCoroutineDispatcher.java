package kotlinx.coroutines.test;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "The execution order of `TestCoroutineDispatcher` can be confusing, and the mechanism of pausing is typically misunderstood. Please use `StandardTestDispatcher` or `UnconfinedTestDispatcher` instead.")
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0014j\u0002`\u0013H\u0016¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0014j\u0002`\u0013H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0018H\u0016J!\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0012\u001a\u00060\u0014j\u0002`\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u000fJ\u0006\u0010\"\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineDispatcher;", "Lkotlinx/coroutines/test/TestDispatcher;", "Lkotlinx/coroutines/Delay;", "scheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "<init>", "(Lkotlinx/coroutines/test/TestCoroutineScheduler;)V", "getScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "value", "", "dispatchImmediately", "setDispatchImmediately", "(Z)V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "toString", "", "post", "Lkotlinx/coroutines/DisposableHandle;", "(Ljava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "currentTime", "", "getCurrentTime", "()J", "advanceUntilIdle", "runCurrent", "cleanupTestCoroutines", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TestCoroutineDispatcher extends TestDispatcher implements Delay {
    private boolean dispatchImmediately;

    @NotNull
    private final TestCoroutineScheduler scheduler;

    /* JADX WARN: Multi-variable type inference failed */
    public TestCoroutineDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final DisposableHandle post(Runnable block, CoroutineContext context) {
        return getScheduler().registerEvent$kotlinx_coroutines_test(this, 0L, block, context, new C13484a(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean post$lambda$0(Runnable runnable) {
        return false;
    }

    private final void setDispatchImmediately(boolean z) {
        this.dispatchImmediately = z;
        if (z) {
            getScheduler().advanceUntilIdle();
        }
    }

    public final long advanceUntilIdle() {
        long currentTime = getScheduler().getCurrentTime();
        getScheduler().advanceUntilIdle();
        return getScheduler().getCurrentTime() - currentTime;
    }

    public final void cleanupTestCoroutines() {
        getScheduler().runCurrent();
        if (!getScheduler().isIdle$kotlinx_coroutines_test(false)) {
            throw new UncompletedCoroutinesError("Unfinished coroutines during tear-down. Ensure all coroutines are completed or cancelled by your test.");
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo23763dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        TestCoroutineSchedulerKt.checkSchedulerInContext(getScheduler(), context);
        if (!this.dispatchImmediately) {
            post(block, context);
        } else {
            getScheduler().sendDispatchEvent$kotlinx_coroutines_test(context);
            block.run();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        TestCoroutineSchedulerKt.checkSchedulerInContext(getScheduler(), context);
        post(block, context);
    }

    public final long getCurrentTime() {
        return getScheduler().getCurrentTime();
    }

    @Override // kotlinx.coroutines.test.TestDispatcher
    @NotNull
    public TestCoroutineScheduler getScheduler() {
        return this.scheduler;
    }

    public final void runCurrent() {
        getScheduler().runCurrent();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    /* JADX INFO: renamed from: toString */
    public String getName() {
        return "TestCoroutineDispatcher[scheduler=" + getScheduler() + PropertyUtils.INDEXED_DELIM2;
    }

    public /* synthetic */ TestCoroutineDispatcher(TestCoroutineScheduler testCoroutineScheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new TestCoroutineScheduler() : testCoroutineScheduler);
    }

    public TestCoroutineDispatcher(@NotNull TestCoroutineScheduler testCoroutineScheduler) {
        this.scheduler = testCoroutineScheduler;
        this.dispatchImmediately = true;
    }
}
