package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.PinnableContainer;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkotlin/jvm/functions/Function0;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getOnEnter$annotations", "()V", "onExit", "getOnRestoreFailed", "()Lkotlin/jvm/functions/Function0;", "setOnRestoreFailed", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onDetach", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;

    @Nullable
    private Function0<FocusRequester> onRestoreFailed;

    @Nullable
    private PinnableContainer.PinnedHandle pinnedHandle;

    @NotNull
    private final Function1<FocusDirection, FocusRequester> onExit = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onExit$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m18228invoke3ESFkO8(focusDirection.getValue());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m18228invoke3ESFkO8(int i) {
            FocusRequesterModifierNodeKt.saveFocusedChild(this.this$0);
            PinnableContainer.PinnedHandle pinnedHandle = this.this$0.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            FocusRestorerNode focusRestorerNode = this.this$0;
            focusRestorerNode.pinnedHandle = FocusRequesterModifierNodeKt.pinFocusedChild(focusRestorerNode);
            return FocusRequester.INSTANCE.getDefault();
        }
    };

    @NotNull
    private final Function1<FocusDirection, FocusRequester> onEnter = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onEnter$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m18227invoke3ESFkO8(focusDirection.getValue());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m18227invoke3ESFkO8(int i) {
            FocusRequester focusRequesterInvoke;
            if (FocusRequesterModifierNodeKt.restoreFocusedChild(this.this$0)) {
                focusRequesterInvoke = FocusRequester.INSTANCE.getCancel();
            } else {
                Function0<FocusRequester> onRestoreFailed = this.this$0.getOnRestoreFailed();
                focusRequesterInvoke = onRestoreFailed != null ? onRestoreFailed.invoke() : null;
            }
            PinnableContainer.PinnedHandle pinnedHandle = this.this$0.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            this.this$0.pinnedHandle = null;
            return focusRequesterInvoke == null ? FocusRequester.INSTANCE.getDefault() : focusRequesterInvoke;
        }
    };

    public FocusRestorerNode(@Nullable Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    @Override // androidx.compose.p109ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(@NotNull FocusProperties focusProperties) {
        focusProperties.setEnter(this.onEnter);
        focusProperties.setExit(this.onExit);
    }

    @Nullable
    public final Function0<FocusRequester> getOnRestoreFailed() {
        return this.onRestoreFailed;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.pinnedHandle = null;
        super.onDetach();
    }

    public final void setOnRestoreFailed(@Nullable Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    private static /* synthetic */ void getOnEnter$annotations() {
    }
}
