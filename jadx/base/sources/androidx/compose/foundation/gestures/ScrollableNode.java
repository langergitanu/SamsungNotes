package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.p109ui.focus.FocusProperties;
import androidx.compose.p109ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p109ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.input.key.Key;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.input.key.KeyInputModifierNode;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerEventType;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.ObserverModifierNode;
import androidx.compose.p109ui.node.ObserverModifierNodeKt;
import androidx.compose.p109ui.node.SemanticsModifierNode;
import androidx.compose.p109ui.node.SemanticsModifierNodeKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000205H\u0002JM\u00109\u001a\u0002052=\u0010:\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002050;\u0012\n\u0012\b\u0012\u0004\u0012\u0002050(\u0012\u0006\u0012\u0004\u0018\u00010)0 H\u0096@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000205H\u0016J\u001a\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020FH\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010CJ\u001a\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u000205H\u0016J*\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bX\u0010LJ\"\u0010Y\u001a\u0002052\u0006\u0010I\u001a\u00020P2\u0006\u0010Z\u001a\u00020TH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u000205H\u0002J\b\u0010^\u001a\u00020\u0010H\u0016JN\u0010_\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010`\u001a\u000205H\u0002J\f\u0010a\u001a\u000205*\u00020bH\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u001f\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0010\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010&\u001a \b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0(\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, m13886d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "clearScrollSemanticsActions", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "processMouseWheelEvent", "size", "processMouseWheelEvent-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "setScrollSemanticsActions", "startDragImmediately", Constants.ARG_UPDATE, "updateDefaultFlingBehavior", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScrollable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scrollable.kt\nandroidx/compose/foundation/gestures/ScrollableNode\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,979:1\n101#2,2:980\n33#2,6:982\n103#2:988\n86#2,2:989\n33#2,6:991\n88#2:997\n33#2,6:998\n*S KotlinDebug\n*F\n+ 1 Scrollable.kt\nandroidx/compose/foundation/gestures/ScrollableNode\n*L\n497#1:980,2\n497#1:982,6\n497#1:988\n539#1:989,2\n539#1:991,6\n539#1:997\n556#1:998,6\n*E\n"})
final class ScrollableNode extends DragGestureNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, KeyInputModifierNode, SemanticsModifierNode {

    @NotNull
    private final ContentInViewNode contentInViewNode;

    @NotNull
    private final DefaultFlingBehavior defaultFlingBehavior;

    @Nullable
    private FlingBehavior flingBehavior;

    @NotNull
    private final ScrollableNestedScrollConnection nestedScrollConnection;

    @NotNull
    private final NestedScrollDispatcher nestedScrollDispatcher;

    @Nullable
    private OverscrollEffect overscrollEffect;

    @Nullable
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;

    @Nullable
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;

    @Nullable
    private ScrollConfig scrollConfig;

    @NotNull
    private final ScrollableContainerNode scrollableContainerNode;

    @NotNull
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", TypedValues.Cycle.S_WAVE_OFFSET}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2", m14021f = "Scrollable.kt", m14022i = {}, m14023l = {527}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C09142 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;

        public C09142(Continuation<? super C09142> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C09142 c09142 = ScrollableNode.this.new C09142(continuation);
            c09142.J$0 = ((Offset) obj).getPackedValue();
            return c09142;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Offset> continuation) {
            return m15658invoke3MmeM6k(offset.getPackedValue(), continuation);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m15658invoke3MmeM6k(long j, @Nullable Continuation<? super Offset> continuation) {
            return ((C09142) create(Offset.m18273boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            long j = this.J$0;
            ScrollingLogic scrollingLogic = ScrollableNode.this.scrollingLogic;
            this.label = 1;
            Object objM15654semanticsScrollByd4ec7I = ScrollableKt.m15654semanticsScrollByd4ec7I(scrollingLogic, j, this);
            return objM15654semanticsScrollByd4ec7I == coroutine_suspended ? coroutine_suspended : objM15654semanticsScrollByd4ec7I;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollableNode(@NotNull ScrollableState scrollableState, @Nullable OverscrollEffect overscrollEffect, @Nullable FlingBehavior flingBehavior, @NotNull Orientation orientation, boolean z, boolean z2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable BringIntoViewSpec bringIntoViewSpec) {
        super(ScrollableKt.CanDragCalculation, z, mutableInteractionSource, orientation);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableContainerNode = (ScrollableContainerNode) delegate(new ScrollableContainerNode(z));
        DefaultFlingBehavior defaultFlingBehavior = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.UnityDensity), null, 2, 0 == true ? 1 : 0);
        this.defaultFlingBehavior = defaultFlingBehavior;
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        FlingBehavior flingBehavior2 = this.flingBehavior;
        ScrollingLogic scrollingLogic = new ScrollingLogic(scrollableState, overscrollEffect2, flingBehavior2 == null ? defaultFlingBehavior : flingBehavior2, orientation, z2, nestedScrollDispatcher);
        this.scrollingLogic = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic, z);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        ContentInViewNode contentInViewNode = (ContentInViewNode) delegate(new ContentInViewNode(orientation, scrollingLogic, z2, bringIntoViewSpec));
        this.contentInViewNode = contentInViewNode;
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(scrollableNestedScrollConnection, nestedScrollDispatcher));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode());
        delegate(new BringIntoViewResponderNode(contentInViewNode));
        delegate(new FocusedBoundsObserverNode(new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable LayoutCoordinates layoutCoordinates) {
                ScrollableNode.this.contentInViewNode.onFocusBoundsChanged(layoutCoordinates);
            }
        }));
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }

    /* JADX INFO: renamed from: processMouseWheelEvent-O0kMr_c, reason: not valid java name */
    private final void m15657processMouseWheelEventO0kMr_c(PointerEvent event, long size) {
        List<PointerInputChange> changes = event.getChanges();
        int size2 = changes.size();
        for (int i = 0; i < size2; i++) {
            if (changes.get(i).isConsumed()) {
                return;
            }
        }
        ScrollConfig scrollConfig = this.scrollConfig;
        Intrinsics.checkNotNull(scrollConfig);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$processMouseWheelEvent$2$1(this, scrollConfig.mo15567calculateMouseWheelScroll8xgXZGE(DelegatableNodeKt.requireDensity(this), event, size), null), 3, null);
        List<PointerInputChange> changes2 = event.getChanges();
        int size3 = changes2.size();
        for (int i2 = 0; i2 < size3; i2++) {
            changes2.get(i2).consume();
        }
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.setScrollSemanticsActions.1

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1", m14021f = "Scrollable.kt", m14022i = {}, m14023l = {522}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: $x */
                final /* synthetic */ float f1011$x;

                /* JADX INFO: renamed from: $y */
                final /* synthetic */ float f1012$y;
                int label;
                final /* synthetic */ ScrollableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ScrollableNode scrollableNode, float f, float f4, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = scrollableNode;
                    this.f1011$x = f;
                    this.f1012$y = f4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.f1011$x, this.f1012$y, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ScrollingLogic scrollingLogic = this.this$0.scrollingLogic;
                        long jOffset = OffsetKt.Offset(this.f1011$x, this.f1012$y);
                        this.label = 1;
                        if (ScrollableKt.m15654semanticsScrollByd4ec7I(scrollingLogic, jOffset, this) == coroutine_suspended) {
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
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Float f, Float f4) {
                return invoke(f.floatValue(), f4.floatValue());
            }

            @NotNull
            public final Boolean invoke(float f, float f4) {
                BuildersKt__Builders_commonKt.launch$default(ScrollableNode.this.getCoroutineScope(), null, null, new AnonymousClass1(ScrollableNode.this, f, f4, null), 3, null);
                return Boolean.TRUE;
            }
        };
        this.scrollByOffsetAction = new C09142(null);
    }

    private final void updateDefaultFlingBehavior() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.updateDefaultFlingBehavior.1
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
                ScrollableNode.this.defaultFlingBehavior.setFlingDecay(SplineBasedDecayKt.splineBasedDecay((Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(ScrollableNode.this, CompositionLocalsKt.getLocalDensity())));
            }
        });
    }

    @Override // androidx.compose.p109ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(@NotNull FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
    }

    @Override // androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (getEnabled() && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            setScrollSemanticsActions();
        }
        Function2<? super Float, ? super Float, Boolean> function2 = this.scrollByAction;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, null, function2, 1, null);
        }
        Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function22 = this.scrollByOffsetAction;
        if (function22 != null) {
            SemanticsPropertiesKt.scrollByOffset(semanticsPropertyReceiver, function22);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    @Nullable
    public Object drag(@NotNull Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        Object objScroll = scrollingLogic.scroll(MutatePriority.UserInput, new ScrollableNode$drag$2$1(function2, scrollingLogic, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDefaultFlingBehavior();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-TH1AsA0 */
    public void mo15564onDragStoppedTH1AsA0(long velocity) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onDragStopped$1(this, velocity, null), 3, null);
    }

    @Override // androidx.compose.p109ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public boolean mo15381onKeyEventZmokQxo(@NotNull KeyEvent event) {
        long jOffset;
        if (!getEnabled()) {
            return false;
        }
        long jM19584getKeyZmokQxo = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
        Key.Companion companion = Key.INSTANCE;
        if ((!Key.m19276equalsimpl0(jM19584getKeyZmokQxo, companion.m19464getPageDownEK5gGoQ()) && !Key.m19276equalsimpl0(KeyEvent_androidKt.m19584getKeyZmokQxo(event), companion.m19465getPageUpEK5gGoQ())) || !KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(event), KeyEventType.INSTANCE.m19581getKeyDownCS__XNY()) || KeyEvent_androidKt.m19588isCtrlPressedZmokQxo(event)) {
            return false;
        }
        if (this.scrollingLogic.isVertical()) {
            int iM21137getHeightimpl = IntSize.m21137getHeightimpl(this.contentInViewNode.getViewportSize());
            jOffset = OffsetKt.Offset(0.0f, Key.m19276equalsimpl0(KeyEvent_androidKt.m19584getKeyZmokQxo(event), companion.m19465getPageUpEK5gGoQ()) ? iM21137getHeightimpl : -iM21137getHeightimpl);
        } else {
            int iM21138getWidthimpl = IntSize.m21138getWidthimpl(this.contentInViewNode.getViewportSize());
            jOffset = OffsetKt.Offset(Key.m19276equalsimpl0(KeyEvent_androidKt.m19584getKeyZmokQxo(event), companion.m19465getPageUpEK5gGoQ()) ? iM21138getWidthimpl : -iM21138getWidthimpl, 0.0f);
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, jOffset, null), 3, null);
        return true;
    }

    @Override // androidx.compose.p109ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateDefaultFlingBehavior();
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.p109ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo15382onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pass, long bounds) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (getCanDrag().invoke(changes.get(i)).booleanValue()) {
                super.mo15382onPointerEventH0pRuoY(pointerEvent, pass, bounds);
                break;
            }
            i++;
        }
        if (pass == PointerEventPass.Main && PointerEventType.m19675equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m19684getScroll7fucELk())) {
            m15657processMouseWheelEventO0kMr_c(pointerEvent, bounds);
        }
    }

    @Override // androidx.compose.p109ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo15383onPreKeyEventZmokQxo(@NotNull KeyEvent event) {
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately */
    public boolean getStartDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(@NotNull ScrollableState state, @NotNull Orientation orientation, @Nullable OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, @Nullable FlingBehavior flingBehavior, @Nullable MutableInteractionSource interactionSource, @Nullable BringIntoViewSpec bringIntoViewSpec) {
        boolean z;
        if (getEnabled() != enabled) {
            this.nestedScrollConnection.setEnabled(enabled);
            this.scrollableContainerNode.update(enabled);
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        boolean zUpdate = this.scrollingLogic.update(state, orientation, overscrollEffect, reverseDirection, flingBehavior == null ? this.defaultFlingBehavior : flingBehavior, this.nestedScrollDispatcher);
        this.contentInViewNode.update(orientation, reverseDirection, bringIntoViewSpec);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        update(ScrollableKt.CanDragCalculation, enabled, interactionSource, this.scrollingLogic.isVertical() ? Orientation.Vertical : Orientation.Horizontal, zUpdate);
        if (z2) {
            clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public void mo15563onDragStartedk4lQ0M(long startedPosition) {
    }
}
