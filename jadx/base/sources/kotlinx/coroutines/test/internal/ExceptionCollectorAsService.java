package kotlinx.coroutines.test.internal;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J7\u0010\n\u001a\u0002H\u000b\"\n\b\u0000\u0010\u000b*\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u0002H\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0096\u0001J#\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0096\u0003J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0015\u0010\u001a\u001a\u00020\u00172\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0003R\r\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013X\u0096\u0005¨\u0006\u001c"}, m13886d2 = {"Lkotlinx/coroutines/test/internal/ExceptionCollectorAsService;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", NetworkConfig.CLIENTS_FOLD, "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "minusKey", "plus", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ExceptionCollectorAsService implements CoroutineExceptionHandler {
    private final /* synthetic */ ExceptionCollector $$delegate_0 = ExceptionCollector.INSTANCE;

    public boolean equals(@Nullable Object other) {
        return (other instanceof ExceptionCollectorAsService) || (other instanceof ExceptionCollector);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) this.$$delegate_0.fold(r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) this.$$delegate_0.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this.$$delegate_0.getKey();
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) throws ExceptionSuccessfullyProcessed {
        this.$$delegate_0.handleException(context, exception);
    }

    public int hashCode() {
        return ExceptionCollector.INSTANCE.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return this.$$delegate_0.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        return this.$$delegate_0.plus(context);
    }
}
