package kotlinx.coroutines.test;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "Use `TestScope` in combination with `runTest` instead.Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'R\u001a\u0010\u0004\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "cleanupTestCoroutines", "", "testScheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getTestScheduler$annotations", "()V", "getTestScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@ExperimentalCoroutinesApi
public interface TestCoroutineScope extends CoroutineScope {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please call `runTest`, which automatically performs the cleanup, instead of using this function.")
    @ExperimentalCoroutinesApi
    /* JADX INFO: renamed from: cleanupTestCoroutines */
    void mo23776cleanupTestCoroutines();

    @NotNull
    TestCoroutineScheduler getTestScheduler();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @ExperimentalCoroutinesApi
        public static /* synthetic */ void getTestScheduler$annotations() {
        }
    }
}
