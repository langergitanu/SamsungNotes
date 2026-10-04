package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0099\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00101\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00102\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00103\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J\u00ad\u0001\u00108\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\b\u00109\u001a\u00020\u0002H\u0016J\u0013\u0010:\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020@HÖ\u0001J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0002H\u0016J\f\u0010D\u001a\u00020B*\u00020EH\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010#\"\u0004\b$\u0010%R2\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R2\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R2\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006F"}, m13886d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/EnterExitTransitionModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setOffsetAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeAnimation", "setSizeAnimation", "getSlideAnimation", "setSlideAnimation", "getTransition", "()Landroidx/compose/animation/core/Transition;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class EnterExitTransitionElement extends ModifierNodeElement<EnterExitTransitionModifierNode> {

    @NotNull
    private EnterTransition enter;

    @NotNull
    private ExitTransition exit;

    @NotNull
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;

    @NotNull
    private Function0<Boolean> isEnabled;

    @Nullable
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;

    @Nullable
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;

    @Nullable
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;

    @NotNull
    private final Transition<EnterExitState> transition;

    public EnterExitTransitionElement(@NotNull Transition<EnterExitState> transition, @Nullable Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, @Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, @Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3, @NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition, @NotNull Function0<Boolean> function0, @NotNull GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransition;
        this.exit = exitTransition;
        this.isEnabled = function0;
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnterExitTransitionElement copy$default(EnterExitTransitionElement enterExitTransitionElement, Transition transition, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, Function0 function0, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit, int i, Object obj) {
        if ((i & 1) != 0) {
            transition = enterExitTransitionElement.transition;
        }
        if ((i & 2) != 0) {
            deferredAnimation = enterExitTransitionElement.sizeAnimation;
        }
        if ((i & 4) != 0) {
            deferredAnimation2 = enterExitTransitionElement.offsetAnimation;
        }
        if ((i & 8) != 0) {
            deferredAnimation3 = enterExitTransitionElement.slideAnimation;
        }
        if ((i & 16) != 0) {
            enterTransition = enterExitTransitionElement.enter;
        }
        if ((i & 32) != 0) {
            exitTransition = enterExitTransitionElement.exit;
        }
        if ((i & 64) != 0) {
            function0 = enterExitTransitionElement.isEnabled;
        }
        if ((i & 128) != 0) {
            graphicsLayerBlockForEnterExit = enterExitTransitionElement.graphicsLayerBlock;
        }
        Function0 function02 = function0;
        GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit2 = graphicsLayerBlockForEnterExit;
        EnterTransition enterTransition2 = enterTransition;
        ExitTransition exitTransition2 = exitTransition;
        return enterExitTransitionElement.copy(transition, deferredAnimation, deferredAnimation2, deferredAnimation3, enterTransition2, exitTransition2, function02, graphicsLayerBlockForEnterExit2);
    }

    @NotNull
    public final Transition<EnterExitState> component1() {
        return this.transition;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> component2() {
        return this.sizeAnimation;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> component3() {
        return this.offsetAnimation;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> component4() {
        return this.slideAnimation;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final EnterTransition getEnter() {
        return this.enter;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ExitTransition getExit() {
        return this.exit;
    }

    @NotNull
    public final Function0<Boolean> component7() {
        return this.isEnabled;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    @NotNull
    public final EnterExitTransitionElement copy(@NotNull Transition<EnterExitState> transition, @Nullable Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation, @Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation, @Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation, @NotNull EnterTransition enter, @NotNull ExitTransition exit, @NotNull Function0<Boolean> isEnabled, @NotNull GraphicsLayerBlockForEnterExit graphicsLayerBlock) {
        return new EnterExitTransitionElement(transition, sizeAnimation, offsetAnimation, slideAnimation, enter, exit, isEnabled, graphicsLayerBlock);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) other;
        return Intrinsics.areEqual(this.transition, enterExitTransitionElement.transition) && Intrinsics.areEqual(this.sizeAnimation, enterExitTransitionElement.sizeAnimation) && Intrinsics.areEqual(this.offsetAnimation, enterExitTransitionElement.offsetAnimation) && Intrinsics.areEqual(this.slideAnimation, enterExitTransitionElement.slideAnimation) && Intrinsics.areEqual(this.enter, enterExitTransitionElement.enter) && Intrinsics.areEqual(this.exit, enterExitTransitionElement.exit) && Intrinsics.areEqual(this.isEnabled, enterExitTransitionElement.isEnabled) && Intrinsics.areEqual(this.graphicsLayerBlock, enterExitTransitionElement.graphicsLayerBlock);
    }

    @NotNull
    public final EnterTransition getEnter() {
        return this.enter;
    }

    @NotNull
    public final ExitTransition getExit() {
        return this.exit;
    }

    @NotNull
    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    @NotNull
    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = this.transition.hashCode() * 31;
        Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
        int iHashCode2 = (iHashCode + (deferredAnimation == null ? 0 : deferredAnimation.hashCode())) * 31;
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2 = this.offsetAnimation;
        int iHashCode3 = (iHashCode2 + (deferredAnimation2 == null ? 0 : deferredAnimation2.hashCode())) * 31;
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = this.slideAnimation;
        return this.graphicsLayerBlock.hashCode() + ((this.isEnabled.hashCode() + ((this.exit.hashCode() + ((this.enter.hashCode() + ((iHashCode3 + (deferredAnimation3 != null ? deferredAnimation3.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("enterExitTransition");
        inspectorInfo.getProperties().set("transition", this.transition);
        inspectorInfo.getProperties().set("sizeAnimation", this.sizeAnimation);
        inspectorInfo.getProperties().set("offsetAnimation", this.offsetAnimation);
        inspectorInfo.getProperties().set("slideAnimation", this.slideAnimation);
        inspectorInfo.getProperties().set("enter", this.enter);
        inspectorInfo.getProperties().set("exit", this.exit);
        inspectorInfo.getProperties().set("graphicsLayerBlock", this.graphicsLayerBlock);
    }

    @NotNull
    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(@NotNull Function0<Boolean> function0) {
        this.isEnabled = function0;
    }

    public final void setEnter(@NotNull EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final void setExit(@NotNull ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    public final void setGraphicsLayerBlock(@NotNull GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    public final void setOffsetAnimation(@Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.offsetAnimation = deferredAnimation;
    }

    public final void setSizeAnimation(@Nullable Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation) {
        this.sizeAnimation = deferredAnimation;
    }

    public final void setSlideAnimation(@Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.slideAnimation = deferredAnimation;
    }

    @NotNull
    public String toString() {
        return "EnterExitTransitionElement(transition=" + this.transition + ", sizeAnimation=" + this.sizeAnimation + ", offsetAnimation=" + this.offsetAnimation + ", slideAnimation=" + this.slideAnimation + ", enter=" + this.enter + ", exit=" + this.exit + ", isEnabled=" + this.isEnabled + ", graphicsLayerBlock=" + this.graphicsLayerBlock + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public EnterExitTransitionModifierNode getNode() {
        return new EnterExitTransitionModifierNode(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.isEnabled, this.graphicsLayerBlock);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull EnterExitTransitionModifierNode node) {
        node.setTransition(this.transition);
        node.setSizeAnimation(this.sizeAnimation);
        node.setOffsetAnimation(this.offsetAnimation);
        node.setSlideAnimation(this.slideAnimation);
        node.setEnter(this.enter);
        node.setExit(this.exit);
        node.setEnabled(this.isEnabled);
        node.setGraphicsLayerBlock(this.graphicsLayerBlock);
    }
}
