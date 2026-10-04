package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.YieldContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u0010\u001a\u00060\u0012j\u0002`\u0011H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lkotlinx/coroutines/test/UnconfinedTestDispatcherImpl;", "Lkotlinx/coroutines/test/TestDispatcher;", "scheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "name", "", "<init>", "(Lkotlinx/coroutines/test/TestCoroutineScheduler;Ljava/lang/String;)V", "getScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "isDispatchNeeded", "", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatch", "", "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "toString", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
final class UnconfinedTestDispatcherImpl extends TestDispatcher {

    @Nullable
    private final String name;

    @NotNull
    private final TestCoroutineScheduler scheduler;

    public /* synthetic */ UnconfinedTestDispatcherImpl(TestCoroutineScheduler testCoroutineScheduler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(testCoroutineScheduler, (i & 2) != 0 ? null : str);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo23763dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        TestCoroutineSchedulerKt.checkSchedulerInContext(getScheduler(), context);
        getScheduler().sendDispatchEvent$kotlinx_coroutines_test(context);
        YieldContext yieldContext = (YieldContext) context.get(YieldContext.INSTANCE);
        if (yieldContext == null) {
            throw new UnsupportedOperationException("Function UnconfinedTestCoroutineDispatcher.dispatch can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        yieldContext.dispatcherWasUnconfined = true;
    }

    @Override // kotlinx.coroutines.test.TestDispatcher
    @NotNull
    public TestCoroutineScheduler getScheduler() {
        return this.scheduler;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext context) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    /* JADX INFO: renamed from: toString */
    public String getName() {
        StringBuilder sb = new StringBuilder();
        String str = this.name;
        if (str == null) {
            str = "UnconfinedTestDispatcher";
        }
        sb.append(str);
        sb.append("[scheduler=");
        sb.append(getScheduler());
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public UnconfinedTestDispatcherImpl(@NotNull TestCoroutineScheduler testCoroutineScheduler, @Nullable String str) {
        this.scheduler = testCoroutineScheduler;
        this.name = str;
    }
}
