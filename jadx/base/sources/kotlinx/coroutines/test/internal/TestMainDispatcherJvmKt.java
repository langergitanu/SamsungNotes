package kotlinx.coroutines.test.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m13886d2 = {"getTestMainDispatcher", "Lkotlinx/coroutines/test/internal/TestMainDispatcher;", "Lkotlinx/coroutines/Dispatchers;", "kotlinx-coroutines-test"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestMainDispatcherJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestMainDispatcherJvm.kt\nkotlinx/coroutines/test/internal/TestMainDispatcherJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,27:1\n1#2:28\n*E\n"})
public final class TestMainDispatcherJvmKt {
    @NotNull
    public static final TestMainDispatcher getTestMainDispatcher(@NotNull Dispatchers dispatchers) {
        MainCoroutineDispatcher main = Dispatchers.getMain();
        if (main instanceof TestMainDispatcher) {
            return (TestMainDispatcher) main;
        }
        throw new IllegalArgumentException(("TestMainDispatcher is not set as main dispatcher, have " + main + " instead.").toString());
    }
}
