package kotlinx.coroutines.test;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"kotlinx/coroutines/test/TestBuildersKt__TestBuildersDeprecatedKt", "kotlinx/coroutines/test/TestBuildersKt__TestBuildersKt"}, m13887k = 4, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TestBuildersKt {
    public static final long DEFAULT_DISPATCH_TIMEOUT_MS = 60000;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers. Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
    public static final void runBlockingTest(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runBlockingTest(coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers.")
    public static final void runBlockingTestOnTestScope(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runBlockingTestOnTestScope(coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Define a total timeout for the whole test instead of using dispatchTimeoutMs. Warning: the proposed replacement is not identical as it uses 'dispatchTimeoutMs' as the timeout for the whole test!", replaceWith = @ReplaceWith(expression = "runTest(context, timeout = dispatchTimeoutMs.milliseconds, testBody)", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static final void runTest(@NotNull CoroutineContext coroutineContext, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersKt.runTest(coroutineContext, j, function2);
    }

    /* JADX INFO: renamed from: runTest-8Mi8wO0, reason: not valid java name */
    public static final void m23777runTest8Mi8wO0(@NotNull CoroutineContext coroutineContext, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersKt.m23783runTest8Mi8wO0(coroutineContext, j, function2);
    }

    @Deprecated(message = "Used for support of legacy behavior")
    @Nullable
    /* JADX INFO: renamed from: runTestCoroutineLegacy-SYHnMyU, reason: not valid java name */
    public static final <T extends AbstractCoroutine<? super Unit>> Object m23781runTestCoroutineLegacySYHnMyU(@NotNull CoroutineScope coroutineScope, @NotNull T t, long j, @NotNull Function1<? super T, ? extends Throwable> function1, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function0<? extends List<? extends Throwable>> function0, @NotNull Continuation<? super Unit> continuation) {
        return TestBuildersKt__TestBuildersKt.m23787runTestCoroutineLegacySYHnMyU(coroutineScope, t, j, function1, function2, function0, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead.")
    @ExperimentalCoroutinesApi
    public static final void runTestWithLegacyScope(@NotNull CoroutineContext coroutineContext, long j, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runTestWithLegacyScope(coroutineContext, j, function2);
    }

    public static final void throwAll(@Nullable Throwable th, @NotNull List<? extends Throwable> list) {
        TestBuildersKt__TestBuildersKt.throwAll(th, list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers. Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
    public static final void runBlockingTest(@NotNull TestCoroutineDispatcher testCoroutineDispatcher, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runBlockingTest(testCoroutineDispatcher, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `TestScope.runTest` instead.")
    @ExperimentalCoroutinesApi
    public static final void runTest(@NotNull TestCoroutineScope testCoroutineScope, long j, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runTest(testCoroutineScope, j, function2);
    }

    /* JADX INFO: renamed from: runTest-8Mi8wO0, reason: not valid java name */
    public static final void m23778runTest8Mi8wO0(@NotNull TestScope testScope, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersKt.m23784runTest8Mi8wO0(testScope, j, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers. Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
    public static final void runBlockingTest(@NotNull TestCoroutineScope testCoroutineScope, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runBlockingTest(testCoroutineScope, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Define a total timeout for the whole test instead of using dispatchTimeoutMs. Warning: the proposed replacement is not identical as it uses 'dispatchTimeoutMs' as the timeout for the whole test!", replaceWith = @ReplaceWith(expression = "this.runTest(timeout = dispatchTimeoutMs.milliseconds, testBody)", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static final void runTest(@NotNull TestScope testScope, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersKt.runTest(testScope, j, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers.")
    public static final void runBlockingTest(@NotNull TestScope testScope, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt__TestBuildersDeprecatedKt.runBlockingTest(testScope, function2);
    }
}
