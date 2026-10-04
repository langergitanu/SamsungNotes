package kotlinx.coroutines.test;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlinx.coroutines.AbstractCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0017J\u0006\u0010\r\u001a\u00020\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m13886d2 = {"Lkotlinx/coroutines/test/TestBodyCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/test/TestCoroutineScope;", "testScope", "<init>", "(Lkotlinx/coroutines/test/TestCoroutineScope;)V", "testScheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getTestScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "cleanupTestCoroutines", "", "cleanup", "tryGetCompletionCause", "", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
final class TestBodyCoroutine extends AbstractCoroutine<Unit> implements TestCoroutineScope {

    @NotNull
    private final TestCoroutineScope testScope;

    public TestBodyCoroutine(@NotNull TestCoroutineScope testCoroutineScope) {
        super(testCoroutineScope.getCoroutineContext(), true, true);
        this.testScope = testCoroutineScope;
    }

    public final void cleanup() {
        this.testScope.mo23776cleanupTestCoroutines();
    }

    @Override // kotlinx.coroutines.test.TestCoroutineScope
    @NotNull
    public TestCoroutineScheduler getTestScheduler() {
        return this.testScope.getTestScheduler();
    }

    @Nullable
    public final Throwable tryGetCompletionCause() {
        return getCompletionCause();
    }

    @Override // kotlinx.coroutines.test.TestCoroutineScope
    @Deprecated(level = DeprecationLevel.ERROR, message = "This deprecation is to prevent accidentally calling `cleanupTestCoroutines` in our own code.", replaceWith = @ReplaceWith(expression = "this.cleanup()", imports = {}))
    @NotNull
    /* JADX INFO: renamed from: cleanupTestCoroutines, reason: merged with bridge method [inline-methods] */
    public Void mo23776cleanupTestCoroutines() {
        throw new UnsupportedOperationException("Calling `cleanupTestCoroutines` inside `runTest` is prohibited: it will be called at the end of the test in any case.");
    }
}
