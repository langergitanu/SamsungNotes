package androidx.compose.p109ui.modifier;

import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0090\u0002¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0013J&\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0003H\u0090\u0002¢\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0018\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00152\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00032\u0006\u0010\u0007\u001a\u0002H\u0015H\u0090\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, m13886d2 = {"Landroidx/compose/ui/modifier/SingleLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "(Landroidx/compose/ui/modifier/ModifierLocal;)V", "<set-?>", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "contains", "", "contains$ui_release", "forceValue", "", "forceValue$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nModifierLocalModifierNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModifierLocalModifierNode.kt\nandroidx/compose/ui/modifier/SingleLocalMap\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,253:1\n81#2:254\n107#2,2:255\n53#3,7:257\n53#3,7:264\n*S KotlinDebug\n*F\n+ 1 ModifierLocalModifierNode.kt\nandroidx/compose/ui/modifier/SingleLocalMap\n*L\n44#1:254\n44#1:255,2\n51#1:257,7\n57#1:264,7\n*E\n"})
public final class SingleLocalMap extends ModifierLocalMap {
    public static final int $stable = 0;

    @NotNull
    private final ModifierLocal<?> key;

    /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState value;

    public SingleLocalMap(@NotNull ModifierLocal<?> modifierLocal) {
        super(null);
        this.key = modifierLocal;
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final Object getValue() {
        return this.value.getValue();
    }

    private final void setValue(Object obj) {
        this.value.setValue(obj);
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(@NotNull ModifierLocal<?> key) {
        return key == this.key;
    }

    public final void forceValue$ui_release(@Nullable Object value) {
        setValue(value);
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    @Nullable
    public <T> T get$ui_release(@NotNull ModifierLocal<T> key) {
        if (!(key == this.key)) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        T t = (T) getValue();
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo19961set$ui_release(@NotNull ModifierLocal<T> key, T value) {
        if (!(key == this.key)) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        setValue(value);
    }
}
