package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\b\u0004\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH ¢\u0006\u0002\b\u0013R\u0018\u0010\u0006\u001a\u00028\u00008Ç\u0002¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0001\u0014¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/runtime/CompositionLocal;", "T", "", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent$annotations", "()V", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "defaultValueHolder", "Landroidx/compose/runtime/ValueHolder;", "getDefaultValueHolder$runtime_release", "()Landroidx/compose/runtime/ValueHolder;", "updatedStateOf", "value", "Landroidx/compose/runtime/ProvidedValue;", "previous", "updatedStateOf$runtime_release", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class CompositionLocal<T> {
    public static final int $stable = 0;

    @NotNull
    private final ValueHolder<T> defaultValueHolder;

    public /* synthetic */ CompositionLocal(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    @Composable
    @ReadOnlyComposable
    @JvmName(name = "getCurrent")
    public final T getCurrent(@Nullable Composer composer, int i) {
        return (T) composer.consume(this);
    }

    @NotNull
    public ValueHolder<T> getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }

    @NotNull
    public abstract ValueHolder<T> updatedStateOf$runtime_release(@NotNull ProvidedValue<T> value, @Nullable ValueHolder<T> previous);

    private CompositionLocal(Function0<? extends T> function0) {
        this.defaultValueHolder = new LazyValueHolder(function0);
    }

    public static /* synthetic */ void getCurrent$annotations() {
    }
}
