package androidx.compose.p109ui.modifier;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0090\u0002¢\u0006\u0002\b\u0007J$\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0090\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\t0\u00062\u0006\u0010\u000e\u001a\u0002H\tH\u0090\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/modifier/EmptyMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "()V", "contains", "", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)Ljava/lang/Void;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class EmptyMap extends ModifierLocalMap {
    public static final int $stable = 0;

    @NotNull
    public static final EmptyMap INSTANCE = new EmptyMap();

    private EmptyMap() {
        super(null);
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(@NotNull ModifierLocal<?> key) {
        return false;
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(@NotNull ModifierLocal<T> key) {
        throw new IllegalStateException("");
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo19961set$ui_release(ModifierLocal modifierLocal, Object obj) {
        set$ui_release((ModifierLocal<Object>) modifierLocal, obj);
    }

    @NotNull
    public <T> Void set$ui_release(@NotNull ModifierLocal<T> key, T value) {
        throw new IllegalStateException("");
    }
}
