package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineScopeExceptionHandler;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
interface TestCoroutineScopeExceptionHandler extends CoroutineExceptionHandler {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull TestCoroutineScopeExceptionHandler testCoroutineScopeExceptionHandler, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineExceptionHandler.DefaultImpls.fold(testCoroutineScopeExceptionHandler, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull TestCoroutineScopeExceptionHandler testCoroutineScopeExceptionHandler, @NotNull CoroutineContext.Key<E> key) {
            return (E) CoroutineExceptionHandler.DefaultImpls.get(testCoroutineScopeExceptionHandler, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull TestCoroutineScopeExceptionHandler testCoroutineScopeExceptionHandler, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineExceptionHandler.DefaultImpls.minusKey(testCoroutineScopeExceptionHandler, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull TestCoroutineScopeExceptionHandler testCoroutineScopeExceptionHandler, @NotNull CoroutineContext coroutineContext) {
            return CoroutineExceptionHandler.DefaultImpls.plus(testCoroutineScopeExceptionHandler, coroutineContext);
        }
    }
}
