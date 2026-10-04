package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.test.internal.TestMainDispatcher;
import kotlinx.coroutines.test.internal.TestMainDispatcherJvmKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0006"}, m13886d2 = {"setMain", "", "Lkotlinx/coroutines/Dispatchers;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "resetMain", "kotlinx-coroutines-test"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@JvmName(name = "TestDispatchers")
@SourceDebugExtension({"SMAP\nTestDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestDispatchers.kt\nkotlinx/coroutines/test/TestDispatchers\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
public final class TestDispatchers {
    @ExperimentalCoroutinesApi
    public static final void resetMain(@NotNull Dispatchers dispatchers) throws Throwable {
        TestMainDispatcherJvmKt.getTestMainDispatcher(dispatchers).resetDispatcher();
    }

    @ExperimentalCoroutinesApi
    public static final void setMain(@NotNull Dispatchers dispatchers, @NotNull CoroutineDispatcher coroutineDispatcher) throws Throwable {
        if (coroutineDispatcher instanceof TestMainDispatcher) {
            throw new IllegalArgumentException("Dispatchers.setMain(Dispatchers.Main) is prohibited, probably Dispatchers.resetMain() should be used instead");
        }
        TestMainDispatcherJvmKt.getTestMainDispatcher(dispatchers).setDispatcher(coroutineDispatcher);
    }
}
