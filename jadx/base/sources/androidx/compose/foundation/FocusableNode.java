package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.ScrollIntoView__ScrollIntoViewRequesterKt;
import androidx.compose.p109ui.focus.FocusEventModifierNode;
import androidx.compose.p109ui.focus.FocusRequesterModifierNode;
import androidx.compose.p109ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.p109ui.focus.FocusState;
import androidx.compose.p109ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.p109ui.node.SemanticsModifierNode;
import androidx.compose.p109ui.node.SemanticsModifierNodeKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\f\u0010\u001b\u001a\u00020\u0016*\u00020\u001cH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/foundation/FocusableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "focusState", "Landroidx/compose/ui/focus/FocusState;", "focusableInteractionNode", "Landroidx/compose/foundation/FocusableInteractionNode;", "focusablePinnableContainer", "Landroidx/compose/foundation/FocusablePinnableContainerNode;", "focusedBoundsNode", "Landroidx/compose/foundation/FocusedBoundsNode;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "onFocusEvent", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", Constants.ARG_UPDATE, "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusableNode extends DelegatingNode implements FocusEventModifierNode, SemanticsModifierNode, GlobalPositionAwareModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;

    @Nullable
    private FocusState focusState;

    @NotNull
    private final FocusableInteractionNode focusableInteractionNode;

    @NotNull
    private final FocusablePinnableContainerNode focusablePinnableContainer = (FocusablePinnableContainerNode) delegate(new FocusablePinnableContainerNode());

    @NotNull
    private final FocusedBoundsNode focusedBoundsNode = (FocusedBoundsNode) delegate(new FocusedBoundsNode());
    private final boolean shouldAutoInvalidate;

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$onFocusEvent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.FocusableNode$onFocusEvent$1", m14021f = "Focusable.kt", m14022i = {}, m14023l = {JPEG.APP0}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C08061(Continuation<? super C08061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return FocusableNode.this.new C08061(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FocusableNode focusableNode = FocusableNode.this;
                this.label = 1;
                if (ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView$default(focusableNode, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FocusableNode(@Nullable MutableInteractionSource mutableInteractionSource) {
        this.focusableInteractionNode = (FocusableInteractionNode) delegate(new FocusableInteractionNode(mutableInteractionSource));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode());
    }

    @Override // androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        FocusState focusState = this.focusState;
        boolean z = false;
        if (focusState != null && focusState.isFocused()) {
            z = true;
        }
        SemanticsPropertiesKt.setFocused(semanticsPropertyReceiver, z);
        SemanticsPropertiesKt.requestFocus$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableNode.applySemantics.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FocusRequesterModifierNodeKt.requestFocus(FocusableNode.this));
            }
        }, 1, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.p109ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        if (Intrinsics.areEqual(this.focusState, focusState)) {
            return;
        }
        boolean zIsFocused = focusState.isFocused();
        if (zIsFocused) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C08061(null), 3, null);
        }
        if (getIsAttached()) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        this.focusableInteractionNode.setFocus(zIsFocused);
        this.focusedBoundsNode.setFocus(zIsFocused);
        this.focusablePinnableContainer.setFocus(zIsFocused);
        this.focusState = focusState;
    }

    @Override // androidx.compose.p109ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        this.focusedBoundsNode.onGloballyPositioned(coordinates);
    }

    public final void update(@Nullable MutableInteractionSource interactionSource) {
        this.focusableInteractionNode.update(interactionSource);
    }
}
