package androidx.compose.p109ui.modifier;

import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0090\u0002¢\u0006\u0002\b\fJ&\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000bH\u0090\u0002¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000b2\u0006\u0010\u0013\u001a\u0002H\u000eH\u0090\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "element", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "(Landroidx/compose/ui/modifier/ModifierLocalProvider;)V", "getElement", "()Landroidx/compose/ui/modifier/ModifierLocalProvider;", "setElement", "contains", "", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nModifierLocalModifierNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModifierLocalModifierNode.kt\nandroidx/compose/ui/modifier/BackwardsCompatLocalMap\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,253:1\n53#2,7:254\n*S KotlinDebug\n*F\n+ 1 ModifierLocalModifierNode.kt\nandroidx/compose/ui/modifier/BackwardsCompatLocalMap\n*L\n73#1:254,7\n*E\n"})
public final class BackwardsCompatLocalMap extends ModifierLocalMap {
    public static final int $stable = 8;

    @NotNull
    private ModifierLocalProvider<?> element;

    public BackwardsCompatLocalMap(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        super(null);
        this.element = modifierLocalProvider;
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(@NotNull ModifierLocal<?> key) {
        return key == this.element.getKey();
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    @Nullable
    public <T> T get$ui_release(@NotNull ModifierLocal<T> key) {
        if (!(key == this.element.getKey())) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        return (T) this.element.getValue();
    }

    @NotNull
    public final ModifierLocalProvider<?> getElement() {
        return this.element;
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo19961set$ui_release(@NotNull ModifierLocal<T> key, T value) {
        throw new IllegalStateException("Set is not allowed on a backwards compat provider");
    }

    public final void setElement(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        this.element = modifierLocalProvider;
    }
}
