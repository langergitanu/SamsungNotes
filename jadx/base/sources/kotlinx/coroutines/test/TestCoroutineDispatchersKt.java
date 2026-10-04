package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.test.internal.TestMainDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001e\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0007"}, m13886d2 = {"UnconfinedTestDispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "scheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "name", "", "StandardTestDispatcher", "kotlinx-coroutines-test"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TestCoroutineDispatchersKt {
    @NotNull
    public static final TestDispatcher StandardTestDispatcher(@Nullable TestCoroutineScheduler testCoroutineScheduler, @Nullable String str) {
        if (testCoroutineScheduler == null && (testCoroutineScheduler = TestMainDispatcher.INSTANCE.getCurrentTestScheduler$kotlinx_coroutines_test()) == null) {
            testCoroutineScheduler = new TestCoroutineScheduler();
        }
        return new StandardTestDispatcherImpl(testCoroutineScheduler, str);
    }

    public static /* synthetic */ TestDispatcher StandardTestDispatcher$default(TestCoroutineScheduler testCoroutineScheduler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            testCoroutineScheduler = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return StandardTestDispatcher(testCoroutineScheduler, str);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final TestDispatcher UnconfinedTestDispatcher(@Nullable TestCoroutineScheduler testCoroutineScheduler, @Nullable String str) {
        if (testCoroutineScheduler == null && (testCoroutineScheduler = TestMainDispatcher.INSTANCE.getCurrentTestScheduler$kotlinx_coroutines_test()) == null) {
            testCoroutineScheduler = new TestCoroutineScheduler();
        }
        return new UnconfinedTestDispatcherImpl(testCoroutineScheduler, str);
    }

    public static /* synthetic */ TestDispatcher UnconfinedTestDispatcher$default(TestCoroutineScheduler testCoroutineScheduler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            testCoroutineScheduler = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return UnconfinedTestDispatcher(testCoroutineScheduler, str);
    }
}
