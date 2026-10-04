package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0002J(\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010$\u001a\u00020\u001e*\u00020%H\u0016J\f\u0010&\u001a\u00020\u001e*\u00020'H\u0016R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Z)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "animationJob", "Lkotlinx/coroutines/Job;", "magnifierNode", "Landroidx/compose/foundation/MagnifierNode;", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "getMagnifierSize-YbymL2g", "()J", "setMagnifierSize-ozmzZPI", "(J)V", "magnifierSize$delegate", "Landroidx/compose/runtime/MutableState;", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "restartAnimationJob", Constants.ARG_UPDATE, "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidTextFieldMagnifier.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidTextFieldMagnifier.android.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n81#2:204\n107#2,2:205\n1#3:207\n*S KotlinDebug\n*F\n+ 1 AndroidTextFieldMagnifier.android.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28\n*L\n52#1:204\n52#1:205,2\n*E\n"})
public final class TextFieldMagnifierNodeImpl28 extends TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 0;

    @NotNull
    private final Animatable<Offset, AnimationVector2D> animatable;

    @Nullable
    private Job animationJob;

    @NotNull
    private TextFieldSelectionState textFieldSelectionState;

    @NotNull
    private TransformedTextFieldState textFieldState;

    @NotNull
    private TextLayoutState textLayoutState;
    private boolean visible;

    /* JADX INFO: renamed from: magnifierSize$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState magnifierSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m21130boximpl(IntSize.INSTANCE.m21143getZeroYbymL2g()), null, 2, null);

    @NotNull
    private final MagnifierNode magnifierNode = (MagnifierNode) delegate(new MagnifierNode(new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$magnifierNode$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Offset invoke(Density density) {
            return Offset.m18273boximpl(m16419invoketuRUvjQ(density));
        }

        /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m16419invoketuRUvjQ(@NotNull Density density) {
            return ((Offset) this.this$0.animatable.getValue()).getPackedValue();
        }
    }, null, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$magnifierNode$2
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DpSize dpSize) {
            m16420invokeEaSLcWc(dpSize.getPackedValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-EaSLcWc, reason: not valid java name */
        public final void m16420invokeEaSLcWc(long j) {
            TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = this.this$0;
            Density density = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldMagnifierNodeImpl28, CompositionLocalsKt.getLocalDensity());
            textFieldMagnifierNodeImpl28.m16418setMagnifierSizeozmzZPI(IntSizeKt.IntSize(density.mo15540roundToPx0680j_4(DpSize.m21066getWidthD9Ej5fM(j)), density.mo15540roundToPx0680j_4(DpSize.m21064getHeightD9Ej5fM(j))));
        }
    }, 0.0f, true, 0, 0.0f, 0.0f, false, null, 1002, null));

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1", m14021f = "AndroidTextFieldMagnifier.android.kt", m14022i = {}, m14023l = {134}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C13511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C13511(Continuation<? super C13511> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C13511 c13511 = TextFieldMagnifierNodeImpl28.this.new C13511(continuation);
            c13511.L$0 = obj;
            return c13511;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = TextFieldMagnifierNodeImpl28.this;
                Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Offset>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28.restartAnimationJob.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Offset invoke() {
                        return Offset.m18273boximpl(m16421invokeF1C5BW0());
                    }

                    /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
                    public final long m16421invokeF1C5BW0() {
                        return (textFieldMagnifierNodeImpl28.visible || textFieldMagnifierNodeImpl28.textFieldSelectionState.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.Touch) ? TextFieldMagnifierKt.m16414calculateSelectionMagnifierCenterAndroidhUlJWOE(textFieldMagnifierNodeImpl28.textFieldState, textFieldMagnifierNodeImpl28.textFieldSelectionState, textFieldMagnifierNodeImpl28.textLayoutState, textFieldMagnifierNodeImpl28.m16417getMagnifierSizeYbymL2g()) : Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
                    }
                });
                final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl282 = TextFieldMagnifierNodeImpl28.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28.restartAnimationJob.1.2

                    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1", m14021f = "AndroidTextFieldMagnifier.android.kt", m14022i = {}, m14023l = {148}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ long $targetValue;
                        int label;
                        final /* synthetic */ TextFieldMagnifierNodeImpl28 this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28, long j, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = textFieldMagnifierNodeImpl28;
                            this.$targetValue = j;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, this.$targetValue, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Animatable animatable = this.this$0.animatable;
                                Offset offsetM18273boximpl = Offset.m18273boximpl(this.$targetValue);
                                SpringSpec<Offset> magnifierSpringSpec = SelectionMagnifierKt.getMagnifierSpringSpec();
                                this.label = 1;
                                if (Animatable.animateTo$default(animatable, offsetM18273boximpl, magnifierSpringSpec, null, null, this, 12, null) == coroutine_suspended) {
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

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return m16422emit3MmeM6k(((Offset) obj2).getPackedValue(), continuation);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: emit-3MmeM6k, reason: not valid java name */
                    public final Object m16422emit3MmeM6k(long j, @NotNull Continuation<? super Unit> continuation) {
                        if (OffsetKt.m18303isSpecifiedk4lQ0M(((Offset) textFieldMagnifierNodeImpl282.animatable.getValue()).getPackedValue()) && OffsetKt.m18303isSpecifiedk4lQ0M(j) && Offset.m18285getYimpl(((Offset) textFieldMagnifierNodeImpl282.animatable.getValue()).getPackedValue()) != Offset.m18285getYimpl(j)) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(textFieldMagnifierNodeImpl282, j, null), 3, null);
                            return Unit.INSTANCE;
                        }
                        Object objSnapTo = textFieldMagnifierNodeImpl282.animatable.snapTo(Offset.m18273boximpl(j), continuation);
                        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowSnapshotFlow.collect(flowCollector, this) == coroutine_suspended) {
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
            return ((C13511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public TextFieldMagnifierNodeImpl28(@NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextFieldSelectionState textFieldSelectionState, @NotNull TextLayoutState textLayoutState, boolean z) {
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.textLayoutState = textLayoutState;
        this.visible = z;
        this.animatable = new Animatable<>(Offset.m18273boximpl(TextFieldMagnifierKt.m16414calculateSelectionMagnifierCenterAndroidhUlJWOE(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, m16417getMagnifierSizeYbymL2g())), SelectionMagnifierKt.getUnspecifiedSafeOffsetVectorConverter(), Offset.m18273boximpl(SelectionMagnifierKt.getOffsetDisplacementThreshold()), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMagnifierSize-YbymL2g, reason: not valid java name */
    public final long m16417getMagnifierSizeYbymL2g() {
        return ((IntSize) this.magnifierSize.getValue()).getPackedValue();
    }

    private final void restartAnimationJob() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null)) {
            this.animationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C13511(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setMagnifierSize-ozmzZPI, reason: not valid java name */
    public final void m16418setMagnifierSizeozmzZPI(long j) {
        this.magnifierSize.setValue(IntSize.m21130boximpl(j));
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.magnifierNode.applySemantics(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.p109ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        this.magnifierNode.draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        restartAnimationJob();
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.p109ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        this.magnifierNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void update(@NotNull TransformedTextFieldState textFieldState, @NotNull TextFieldSelectionState textFieldSelectionState, @NotNull TextLayoutState textLayoutState, boolean visible) {
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        TextFieldSelectionState textFieldSelectionState2 = this.textFieldSelectionState;
        TextLayoutState textLayoutState2 = this.textLayoutState;
        boolean z = this.visible;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.textLayoutState = textLayoutState;
        this.visible = visible;
        if (Intrinsics.areEqual(textFieldState, transformedTextFieldState) && Intrinsics.areEqual(textFieldSelectionState, textFieldSelectionState2) && Intrinsics.areEqual(textLayoutState, textLayoutState2) && visible == z) {
            return;
        }
        restartAnimationJob();
    }
}
