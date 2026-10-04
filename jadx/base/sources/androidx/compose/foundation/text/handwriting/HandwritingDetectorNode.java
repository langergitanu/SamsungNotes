package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.node.DelegatableNode_androidKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.PointerInputModifierNode;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0005H\u0016J*\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/foundation/text/handwriting/HandwritingDetectorNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "getComposeImm", "()Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm$delegate", "Lkotlin/Lazy;", "pointerInputNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "getPointerInputNode", "()Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "onCancelPointerInput", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class HandwritingDetectorNode extends DelegatingNode implements PointerInputModifierNode {

    @NotNull
    private Function0<Unit> callback;

    /* JADX INFO: renamed from: composeImm$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy composeImm = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ComposeInputMethodManager>() { // from class: androidx.compose.foundation.text.handwriting.HandwritingDetectorNode$composeImm$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ComposeInputMethodManager invoke() {
            return ComposeInputMethodManager_androidKt.ComposeInputMethodManager(DelegatableNode_androidKt.requireView(this.this$0));
        }
    });

    @NotNull
    private final StylusHandwritingNodeWithNegativePadding pointerInputNode = (StylusHandwritingNodeWithNegativePadding) delegate(new StylusHandwritingNodeWithNegativePadding(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.handwriting.HandwritingDetectorNode$pointerInputNode$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            this.this$0.getCallback().invoke();
            this.this$0.getComposeImm().prepareStylusHandwritingDelegation();
            return Boolean.TRUE;
        }
    }));

    public HandwritingDetectorNode(@NotNull Function0<Unit> function0) {
        this.callback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeInputMethodManager getComposeImm() {
        return (ComposeInputMethodManager) this.composeImm.getValue();
    }

    @NotNull
    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    @NotNull
    public final StylusHandwritingNodeWithNegativePadding getPointerInputNode() {
        return this.pointerInputNode;
    }

    @Override // androidx.compose.p109ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.p109ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo15382onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pass, long bounds) {
        this.pointerInputNode.mo15382onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    public final void setCallback(@NotNull Function0<Unit> function0) {
        this.callback = function0;
    }
}
