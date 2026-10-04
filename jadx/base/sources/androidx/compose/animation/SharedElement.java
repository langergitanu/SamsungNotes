package androidx.compose.animation;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RectKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#J\b\u0010/\u001a\u00020\u0013H\u0002J\u0006\u00100\u001a\u00020\u0013J(\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#J\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010;\u001a\u00020\u001eR/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR/\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\nR\"\u0010(\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010#@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0,X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, m13886d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "<set-?>", "Landroidx/compose/ui/geometry/Rect;", "_targetBounds", "get_targetBounds", "()Landroidx/compose/ui/geometry/Rect;", "set_targetBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "_targetBounds$delegate", "Landroidx/compose/runtime/MutableState;", "currentBounds", "getCurrentBounds", "setCurrentBounds", "currentBounds$delegate", "", "foundMatch", "getFoundMatch", "()Z", "setFoundMatch", "(Z)V", "foundMatch$delegate", "getKey", "()Ljava/lang/Object;", "observingVisibilityChange", "Lkotlin/Function0;", "", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/SharedElementInternalState;", "getStates", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "targetBounds", "getTargetBounds", "targetBoundsProvider", "getTargetBoundsProvider$animation_release", "()Landroidx/compose/animation/SharedElementInternalState;", "updateMatch", "Lkotlin/Function1;", "addState", "sharedElementState", "hasVisibleContent", "isAnimating", "onLookaheadResult", "state", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "onLookaheadResult-v_w8tDc", "(Landroidx/compose/animation/SharedElementInternalState;JJ)V", "onSharedTransitionFinished", "removeState", "updateTargetBoundsProvider", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSharedElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedElement.kt\nandroidx/compose/animation/SharedElement\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,254:1\n101#2,2:255\n33#2,6:257\n103#2:263\n33#2,6:273\n101#2,2:279\n33#2,6:281\n103#2:287\n51#2,6:288\n81#3:264\n107#3,2:265\n81#3:267\n107#3,2:268\n81#3:270\n107#3,2:271\n*S KotlinDebug\n*F\n+ 1 SharedElement.kt\nandroidx/compose/animation/SharedElement\n*L\n43#1:255,2\n43#1:257,6\n43#1:263\n97#1:273,6\n115#1:279,2\n115#1:281,6\n115#1:287\n127#1:288,6\n45#1:264\n45#1:265,2\n79#1:267\n79#1:268,2\n83#1:270\n83#1:271,2\n*E\n"})
public final class SharedElement {
    public static final int $stable = 8;

    @NotNull
    private final Object key;

    @NotNull
    private final SharedTransitionScopeImpl scope;

    @Nullable
    private SharedElementInternalState targetBoundsProvider;

    /* JADX INFO: renamed from: _targetBounds$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState _targetBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: foundMatch$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState foundMatch = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: currentBounds$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState currentBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    @NotNull
    private final SnapshotStateList<SharedElementInternalState> states = SnapshotStateKt.mutableStateListOf();

    @NotNull
    private final Function1<SharedElement, Unit> updateMatch = new Function1<SharedElement, Unit>() { // from class: androidx.compose.animation.SharedElement.updateMatch.1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SharedElement sharedElement) {
            invoke2(sharedElement);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SharedElement sharedElement) {
            SharedElement.this.updateMatch();
        }
    };

    @NotNull
    private final Function0<Unit> observingVisibilityChange = new Function0<Unit>() { // from class: androidx.compose.animation.SharedElement$observingVisibilityChange$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.hasVisibleContent();
        }
    };

    public SharedElement(@NotNull Object obj, @NotNull SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.key = obj;
        this.scope = sharedTransitionScopeImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Rect get_targetBounds() {
        return (Rect) this._targetBounds.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasVisibleContent() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            if (snapshotStateList.get(i).getBoundsAnimation().getTarget()) {
                return true;
            }
        }
        return false;
    }

    private final void setFoundMatch(boolean z) {
        this.foundMatch.setValue(Boolean.valueOf(z));
    }

    private final void set_targetBounds(Rect rect) {
        this._targetBounds.setValue(rect);
    }

    public final void addState(@NotNull SharedElementInternalState sharedElementState) {
        this.states.add(sharedElementState);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Rect getCurrentBounds() {
        return (Rect) this.currentBounds.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getFoundMatch() {
        return ((Boolean) this.foundMatch.getValue()).booleanValue();
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    @NotNull
    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    @NotNull
    public final SnapshotStateList<SharedElementInternalState> getStates() {
        return this.states;
    }

    @Nullable
    public final Rect getTargetBounds() {
        SharedElementInternalState sharedElementInternalState = this.targetBoundsProvider;
        set_targetBounds(sharedElementInternalState != null ? RectKt.m18324Recttz77jQw(sharedElementInternalState.m15281calculateLookaheadOffsetF1C5BW0(), sharedElementInternalState.m15282getNonNullLookaheadSizeNHjbRc()) : null);
        return get_targetBounds();
    }

    @Nullable
    /* JADX INFO: renamed from: getTargetBoundsProvider$animation_release, reason: from getter */
    public final SharedElementInternalState getTargetBoundsProvider() {
        return this.targetBoundsProvider;
    }

    public final boolean isAnimating() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (!snapshotStateList.get(i).getBoundsAnimation().isRunning()) {
                i++;
            } else if (getFoundMatch()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: onLookaheadResult-v_w8tDc, reason: not valid java name */
    public final void m15280onLookaheadResultv_w8tDc(@NotNull SharedElementInternalState state, long lookaheadSize, long topLeft) {
        if (state.getBoundsAnimation().getTarget()) {
            this.targetBoundsProvider = state;
            Rect rect = get_targetBounds();
            Offset offsetM18273boximpl = rect != null ? Offset.m18273boximpl(rect.m18319getTopLeftF1C5BW0()) : null;
            if (offsetM18273boximpl == null ? false : Offset.m18281equalsimpl0(offsetM18273boximpl.getPackedValue(), topLeft)) {
                Rect rect2 = get_targetBounds();
                Size sizeM18341boximpl = rect2 != null ? Size.m18341boximpl(rect2.m18317getSizeNHjbRc()) : null;
                if (sizeM18341boximpl == null ? false : Size.m18349equalsimpl0(sizeM18341boximpl.getPackedValue(), lookaheadSize)) {
                    return;
                }
            }
            Rect rectM18324Recttz77jQw = RectKt.m18324Recttz77jQw(topLeft, lookaheadSize);
            set_targetBounds(rectM18324Recttz77jQw);
            SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
            int size = snapshotStateList.size();
            for (int i = 0; i < size; i++) {
                BoundsAnimation boundsAnimation = snapshotStateList.get(i).getBoundsAnimation();
                Rect currentBounds = getCurrentBounds();
                Intrinsics.checkNotNull(currentBounds);
                boundsAnimation.animate(currentBounds, rectM18324Recttz77jQw);
            }
        }
    }

    public final void onSharedTransitionFinished() {
        setFoundMatch(this.states.size() > 1 && hasVisibleContent());
        set_targetBounds(null);
    }

    public final void removeState(@NotNull SharedElementInternalState sharedElementState) {
        this.states.remove(sharedElementState);
        if (!this.states.isEmpty()) {
            SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
        } else {
            updateMatch();
            SharedTransitionScopeKt.getSharedTransitionObserver().clear(this);
        }
    }

    public final void setCurrentBounds(@Nullable Rect rect) {
        this.currentBounds.setValue(rect);
    }

    public final void updateMatch() {
        boolean zHasVisibleContent = hasVisibleContent();
        if (this.states.size() > 1 && zHasVisibleContent) {
            setFoundMatch(true);
        } else if (!this.scope.isTransitionActive() || !zHasVisibleContent) {
            setFoundMatch(false);
        }
        if (this.states.isEmpty()) {
            return;
        }
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final void updateTargetBoundsProvider() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size() - 1;
        SharedElementInternalState sharedElementInternalState = null;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                SharedElementInternalState sharedElementInternalState2 = snapshotStateList.get(size);
                if (sharedElementInternalState2.getBoundsAnimation().getTarget()) {
                    sharedElementInternalState = sharedElementInternalState2;
                }
                if (i < 0) {
                    break;
                } else {
                    size = i;
                }
            }
        }
        if (Intrinsics.areEqual(sharedElementInternalState, this.targetBoundsProvider)) {
            return;
        }
        this.targetBoundsProvider = sharedElementInternalState;
        set_targetBounds(null);
    }
}
