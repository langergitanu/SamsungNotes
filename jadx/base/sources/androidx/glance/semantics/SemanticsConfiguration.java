package androidx.glance.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H\u0086\u0002¢\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\b0\r¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005¢\u0006\u0002\u0010\nJ*\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\u0006\u0010\u0012\u001a\u0002H\bH\u0096\u0002¢\u0006\u0002\u0010\u0013R \u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/semantics/SemanticsConfiguration;", "Landroidx/glance/semantics/SemanticsPropertyReceiver;", "()V", "props", "", "Landroidx/glance/semantics/SemanticsPropertyKey;", "", "get", "T", "key", "(Landroidx/glance/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElseNullable", "defaultValue", "Lkotlin/Function0;", "(Landroidx/glance/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "value", "(Landroidx/glance/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SemanticsConfiguration implements SemanticsPropertyReceiver {
    public static final int $stable = 8;

    @NotNull
    private final Map<SemanticsPropertyKey<?>, Object> props = new LinkedHashMap();

    public final <T> T get(@NotNull SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this.props.get(key);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Key not present: " + key);
    }

    @Nullable
    public final <T> T getOrElseNullable(@NotNull SemanticsPropertyKey<T> key, @NotNull Function0<? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) this.props.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    @Nullable
    public final <T> T getOrNull(@NotNull SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) getOrElseNullable(key, new Function0<T>() { // from class: androidx.glance.semantics.SemanticsConfiguration.getOrNull.1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final T invoke() {
                return null;
            }
        });
    }

    @Override // androidx.glance.semantics.SemanticsPropertyReceiver
    public <T> void set(@NotNull SemanticsPropertyKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.props.put(key, value);
    }
}
