package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bHÆ\u0001J\b\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\f\u0010,\u001a\u00020**\u00020-H\u0016R%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, m13886d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/RenderInTransitionOverlayNode;", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getSharedTransitionScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedTransitionScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getZIndexInOverlay", "()F", "component1", "component2", "component3", "component4", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class RenderInTransitionOverlayNodeElement extends ModifierNodeElement<RenderInTransitionOverlayNode> {
    public static final int $stable = 0;

    @NotNull
    private final Function2<LayoutDirection, Density, Path> clipInOverlay;

    @NotNull
    private Function0<Boolean> renderInOverlay;

    @NotNull
    private SharedTransitionScopeImpl sharedTransitionScope;
    private final float zIndexInOverlay;

    /* JADX WARN: Multi-variable type inference failed */
    public RenderInTransitionOverlayNodeElement(@NotNull SharedTransitionScopeImpl sharedTransitionScopeImpl, @NotNull Function0<Boolean> function0, float f, @NotNull Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        this.sharedTransitionScope = sharedTransitionScopeImpl;
        this.renderInOverlay = function0;
        this.zIndexInOverlay = f;
        this.clipInOverlay = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RenderInTransitionOverlayNodeElement copy$default(RenderInTransitionOverlayNodeElement renderInTransitionOverlayNodeElement, SharedTransitionScopeImpl sharedTransitionScopeImpl, Function0 function0, float f, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            sharedTransitionScopeImpl = renderInTransitionOverlayNodeElement.sharedTransitionScope;
        }
        if ((i & 2) != 0) {
            function0 = renderInTransitionOverlayNodeElement.renderInOverlay;
        }
        if ((i & 4) != 0) {
            f = renderInTransitionOverlayNodeElement.zIndexInOverlay;
        }
        if ((i & 8) != 0) {
            function2 = renderInTransitionOverlayNodeElement.clipInOverlay;
        }
        return renderInTransitionOverlayNodeElement.copy(sharedTransitionScopeImpl, function0, f, function2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SharedTransitionScopeImpl getSharedTransitionScope() {
        return this.sharedTransitionScope;
    }

    @NotNull
    public final Function0<Boolean> component2() {
        return this.renderInOverlay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay;
    }

    @NotNull
    public final Function2<LayoutDirection, Density, Path> component4() {
        return this.clipInOverlay;
    }

    @NotNull
    public final RenderInTransitionOverlayNodeElement copy(@NotNull SharedTransitionScopeImpl sharedTransitionScope, @NotNull Function0<Boolean> renderInOverlay, float zIndexInOverlay, @NotNull Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay) {
        return new RenderInTransitionOverlayNodeElement(sharedTransitionScope, renderInOverlay, zIndexInOverlay, clipInOverlay);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (other instanceof RenderInTransitionOverlayNodeElement) {
            RenderInTransitionOverlayNodeElement renderInTransitionOverlayNodeElement = (RenderInTransitionOverlayNodeElement) other;
            if (Intrinsics.areEqual(this.sharedTransitionScope, renderInTransitionOverlayNodeElement.sharedTransitionScope) && this.renderInOverlay == renderInTransitionOverlayNodeElement.renderInOverlay && this.zIndexInOverlay == renderInTransitionOverlayNodeElement.zIndexInOverlay && this.clipInOverlay == renderInTransitionOverlayNodeElement.clipInOverlay) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    @NotNull
    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    @NotNull
    public final SharedTransitionScopeImpl getSharedTransitionScope() {
        return this.sharedTransitionScope;
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return this.clipInOverlay.hashCode() + AbstractC0622a.m1156b(this.zIndexInOverlay, (this.renderInOverlay.hashCode() + (this.sharedTransitionScope.hashCode() * 31)) * 31, 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("renderInSharedTransitionOverlay");
        inspectorInfo.getProperties().set("sharedTransitionScope", this.sharedTransitionScope);
        inspectorInfo.getProperties().set("renderInOverlay", this.renderInOverlay);
        inspectorInfo.getProperties().set("zIndexInOverlay", Float.valueOf(this.zIndexInOverlay));
        inspectorInfo.getProperties().set("clipInOverlayDuringTransition", this.clipInOverlay);
    }

    public final void setRenderInOverlay(@NotNull Function0<Boolean> function0) {
        this.renderInOverlay = function0;
    }

    public final void setSharedTransitionScope(@NotNull SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.sharedTransitionScope = sharedTransitionScopeImpl;
    }

    @NotNull
    public String toString() {
        return "RenderInTransitionOverlayNodeElement(sharedTransitionScope=" + this.sharedTransitionScope + ", renderInOverlay=" + this.renderInOverlay + ", zIndexInOverlay=" + this.zIndexInOverlay + ", clipInOverlay=" + this.clipInOverlay + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public RenderInTransitionOverlayNode getNode() {
        return new RenderInTransitionOverlayNode(this.sharedTransitionScope, this.renderInOverlay, this.zIndexInOverlay, this.clipInOverlay);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull RenderInTransitionOverlayNode node) {
        node.setSharedScope(this.sharedTransitionScope);
        node.setRenderInOverlay(this.renderInOverlay);
        node.setZIndexInOverlay(this.zIndexInOverlay);
        node.setClipInOverlay(this.clipInOverlay);
    }
}
