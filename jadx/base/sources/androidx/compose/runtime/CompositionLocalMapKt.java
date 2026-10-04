package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0000\u001a=\u0010\r\u001a\u00020\u0001*\u00020\u00012.\u0010\u000e\u001a*\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u0010\u0012\u0004\u0012\u00020\u00130\u000fH\u0080\b\u001a%\u0010\u0014\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0000¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"updateCompositionMap", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "previous", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/PersistentCompositionLocalMap;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "contains", "", "T", "key", "Landroidx/compose/runtime/CompositionLocal;", "mutate", "mutator", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/ValueHolder;", "", "read", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCompositionLocalMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositionLocalMap.kt\nandroidx/compose/runtime/CompositionLocalMapKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,113:1\n1#2:114\n*E\n"})
public final class CompositionLocalMapKt {
    public static final <T> boolean contains(@NotNull PersistentCompositionLocalMap persistentCompositionLocalMap, @NotNull CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return persistentCompositionLocalMap.containsKey(compositionLocal);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    @NotNull
    public static final PersistentCompositionLocalMap mutate(@NotNull PersistentCompositionLocalMap persistentCompositionLocalMap, @NotNull Function1<? super Map<CompositionLocal<Object>, ValueHolder<Object>>, Unit> function1) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder = persistentCompositionLocalMap.builder2();
        function1.invoke(builder);
        return builder.build2();
    }

    public static final <T> T read(@NotNull PersistentCompositionLocalMap persistentCompositionLocalMap, @NotNull CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        ValueHolder defaultValueHolder$runtime_release = persistentCompositionLocalMap.get((Object) compositionLocal);
        if (defaultValueHolder$runtime_release == null) {
            defaultValueHolder$runtime_release = compositionLocal.getDefaultValueHolder$runtime_release();
        }
        return (T) defaultValueHolder$runtime_release.readValue(persistentCompositionLocalMap);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    @NotNull
    public static final PersistentCompositionLocalMap updateCompositionMap(@NotNull ProvidedValue<?>[] providedValueArr, @NotNull PersistentCompositionLocalMap persistentCompositionLocalMap, @NotNull PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder2();
        for (ProvidedValue<?> providedValue : providedValueArr) {
            CompositionLocal<?> compositionLocal = providedValue.getCompositionLocal();
            Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
            ProvidableCompositionLocal providableCompositionLocal = (ProvidableCompositionLocal) compositionLocal;
            if (providedValue.getCanOverride() || !contains(persistentCompositionLocalMap, providableCompositionLocal)) {
                ValueHolder<Object> valueHolder = (ValueHolder) persistentCompositionLocalMap2.get((Object) providableCompositionLocal);
                Intrinsics.checkNotNull(providedValue, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
                builder.put(providableCompositionLocal, providableCompositionLocal.updatedStateOf$runtime_release(providedValue, valueHolder));
            }
        }
        return builder.build2();
    }

    public static /* synthetic */ PersistentCompositionLocalMap updateCompositionMap$default(ProvidedValue[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2, int i, Object obj) {
        if ((i & 4) != 0) {
            persistentCompositionLocalMap2 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        }
        return updateCompositionMap(providedValueArr, persistentCompositionLocalMap, persistentCompositionLocalMap2);
    }
}
