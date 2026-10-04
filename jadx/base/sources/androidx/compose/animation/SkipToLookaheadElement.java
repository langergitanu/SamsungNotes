package androidx.compose.animation;

import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/animation/SkipToLookaheadElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SkipToLookaheadNode;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class SkipToLookaheadElement extends ModifierNodeElement<SkipToLookaheadNode> {

    @NotNull
    private final Function0<Boolean> isEnabled;

    @Nullable
    private final ScaleToBoundsImpl scaleToBounds;

    /* JADX WARN: Multi-variable type inference failed */
    public SkipToLookaheadElement() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkipToLookaheadElement copy$default(SkipToLookaheadElement skipToLookaheadElement, ScaleToBoundsImpl scaleToBoundsImpl, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            scaleToBoundsImpl = skipToLookaheadElement.scaleToBounds;
        }
        if ((i & 2) != 0) {
            function0 = skipToLookaheadElement.isEnabled;
        }
        return skipToLookaheadElement.copy(scaleToBoundsImpl, function0);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    @NotNull
    public final Function0<Boolean> component2() {
        return this.isEnabled;
    }

    @NotNull
    public final SkipToLookaheadElement copy(@Nullable ScaleToBoundsImpl scaleToBounds, @NotNull Function0<Boolean> isEnabled) {
        return new SkipToLookaheadElement(scaleToBounds, isEnabled);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkipToLookaheadElement)) {
            return false;
        }
        SkipToLookaheadElement skipToLookaheadElement = (SkipToLookaheadElement) other;
        return Intrinsics.areEqual(this.scaleToBounds, skipToLookaheadElement.scaleToBounds) && Intrinsics.areEqual(this.isEnabled, skipToLookaheadElement.isEnabled);
    }

    @Nullable
    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        ScaleToBoundsImpl scaleToBoundsImpl = this.scaleToBounds;
        return this.isEnabled.hashCode() + ((scaleToBoundsImpl == null ? 0 : scaleToBoundsImpl.hashCode()) * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("skipToLookahead");
        inspectorInfo.getProperties().set("scaleToBounds", this.scaleToBounds);
        inspectorInfo.getProperties().set("isEnabled", this.isEnabled);
    }

    @NotNull
    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        return "SkipToLookaheadElement(scaleToBounds=" + this.scaleToBounds + ", isEnabled=" + this.isEnabled + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ SkipToLookaheadElement(ScaleToBoundsImpl scaleToBoundsImpl, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : scaleToBoundsImpl, (i & 2) != 0 ? SharedTransitionScopeKt.DefaultEnabled : function0);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public SkipToLookaheadNode getNode() {
        return new SkipToLookaheadNode(this.scaleToBounds, this.isEnabled);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull SkipToLookaheadNode node) {
        node.setScaleToBounds(this.scaleToBounds);
        node.setEnabled(this.isEnabled);
    }

    public SkipToLookaheadElement(@Nullable ScaleToBoundsImpl scaleToBoundsImpl, @NotNull Function0<Boolean> function0) {
        this.scaleToBounds = scaleToBoundsImpl;
        this.isEnabled = function0;
    }
}
