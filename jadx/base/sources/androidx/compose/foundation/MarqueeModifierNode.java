package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusEventModifierNode;
import androidx.compose.p109ui.focus.FocusState;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DrawModifierNode;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020;H\u0002J\u000e\u0010A\u001a\u00020;H\u0082@¢\u0006\u0002\u0010BJ@\u0010C\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\f\u0010F\u001a\u00020;*\u00020GH\u0016J\u001c\u0010H\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u001c\u0010M\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0006H\u0016J&\u0010O\u001a\u00020P*\u00020Q2\u0006\u0010J\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001c\u0010W\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u001c\u0010X\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0006H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R+\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R+\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00105\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b6\u0010\u0014R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00109\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, m13886d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animationJob", "Lkotlinx/coroutines/Job;", "<set-?>", "getAnimationMode-ZbEOnfQ", "()I", "setAnimationMode-97h66l8", "(I)V", "animationMode$delegate", "Landroidx/compose/runtime/MutableState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "contentWidth", "getContentWidth", "setContentWidth", "contentWidth$delegate", "direction", "", "getDirection", "()F", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", TokenizerME.NO_SPLIT, "onAttach", "", "onDetach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.ARG_UPDATE, "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicMarquee.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicMarquee.kt\nandroidx/compose/foundation/MarqueeModifierNode\n+ 2 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 4 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,508:1\n78#2:509\n111#2,2:510\n78#2:512\n111#2,2:513\n81#3:515\n107#3,2:516\n81#3:518\n107#3,2:519\n81#3:521\n107#3,2:522\n81#3:524\n225#4,8:525\n272#4,9:533\n123#4,12:542\n282#4,4:554\n*S KotlinDebug\n*F\n+ 1 BasicMarquee.kt\nandroidx/compose/foundation/MarqueeModifierNode\n*L\n214#1:509\n214#1:510,2\n215#1:512\n215#1:513,2\n216#1:515\n216#1:516,2\n218#1:518\n218#1:519,2\n219#1:521\n219#1:522,2\n227#1:524\n326#1:525,8\n326#1:533,9\n336#1:542,12\n326#1:554,4\n*E\n"})
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {

    @Nullable
    private Job animationJob;

    /* JADX INFO: renamed from: animationMode$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState animationMode;

    /* JADX INFO: renamed from: containerWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableIntState containerWidth;

    /* JADX INFO: renamed from: contentWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableIntState contentWidth;
    private int delayMillis;

    /* JADX INFO: renamed from: hasFocus$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState hasFocus;
    private int initialDelayMillis;
    private int iterations;

    @NotNull
    private final Animatable<Float, AnimationVector1D> offset;

    /* JADX INFO: renamed from: spacing$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState spacing;

    /* JADX INFO: renamed from: spacingPx$delegate, reason: from kotlin metadata */
    @NotNull
    private final State spacingPx;
    private float velocity;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1", m14021f = "BasicMarquee.kt", m14022i = {}, m14023l = {349, 350}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $oldJob;
        int label;
        final /* synthetic */ MarqueeModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C08161(Job job, MarqueeModifierNode marqueeModifierNode, Continuation<? super C08161> continuation) {
            super(2, continuation);
            this.$oldJob = job;
            this.this$0 = marqueeModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C08161(this.$oldJob, this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        
            if (r5.runAnimation(r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$oldJob;
                if (job != null) {
                    this.label = 1;
                    if (job.join(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            MarqueeModifierNode marqueeModifierNode = this.this$0;
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", m14021f = "BasicMarquee.kt", m14022i = {}, m14023l = {371}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "contentWithSpacingWidth", ""}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", m14021f = "BasicMarquee.kt", m14022i = {0, 0}, m14023l = {384, 386, 390, 390}, m14024m = "invokeSuspend", m14025n = {"contentWithSpacingWidth", "spec"}, m14026s = {"L$0", "L$1"})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ MarqueeModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(MarqueeModifierNode marqueeModifierNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = marqueeModifierNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@Nullable Float f, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(f, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x00bb, code lost:
            
                if (r0.snapTo(r1, r20) != r8) goto L31;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                Float f;
                AnimationSpec animationSpec;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                } catch (Throwable th) {
                    Animatable animatable = this.this$0.offset;
                    Float fBoxFloat = Boxing.boxFloat(0.0f);
                    this.L$0 = th;
                    this.L$1 = null;
                    this.label = 4;
                    if (animatable.snapTo(fBoxFloat, this) != coroutine_suspended) {
                        throw th;
                    }
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    f = (Float) this.L$0;
                    if (f == null) {
                        return Unit.INSTANCE;
                    }
                    AnimationSpec animationSpecM15416createMarqueeAnimationSpecZ4HSEVQ = BasicMarqueeKt.m15416createMarqueeAnimationSpecZ4HSEVQ(this.this$0.iterations, f.floatValue(), this.this$0.initialDelayMillis, this.this$0.delayMillis, this.this$0.velocity, DelegatableNodeKt.requireDensity(this.this$0));
                    Animatable animatable2 = this.this$0.offset;
                    Float fBoxFloat2 = Boxing.boxFloat(0.0f);
                    this.L$0 = f;
                    this.L$1 = animationSpecM15416createMarqueeAnimationSpecZ4HSEVQ;
                    this.label = 1;
                    if (animatable2.snapTo(fBoxFloat2, this) != coroutine_suspended) {
                        animationSpec = animationSpecM15416createMarqueeAnimationSpecZ4HSEVQ;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    AnimationSpec animationSpec2 = (AnimationSpec) this.L$1;
                    Float f4 = (Float) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    animationSpec = animationSpec2;
                    f = f4;
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th2 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th2;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable3 = this.this$0.offset;
                    Float fBoxFloat3 = Boxing.boxFloat(0.0f);
                    this.label = 3;
                }
                Animatable animatable4 = this.this$0.offset;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (Animatable.animateTo$default(animatable4, f, animationSpec, null, null, this, 12, null) != coroutine_suspended) {
                    Animatable animatable32 = this.this$0.offset;
                    Float fBoxFloat32 = Boxing.boxFloat(0.0f);
                    this.label = 3;
                }
                return coroutine_suspended;
            }
        }

        public C08172(Continuation<? super C08172> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return MarqueeModifierNode.this.new C08172(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final MarqueeModifierNode marqueeModifierNode = MarqueeModifierNode.this;
                Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Float>() { // from class: androidx.compose.foundation.MarqueeModifierNode.runAnimation.2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Float invoke() {
                        if (marqueeModifierNode.getContentWidth() <= marqueeModifierNode.getContainerWidth()) {
                            return null;
                        }
                        if (!MarqueeAnimationMode.m15483equalsimpl0(marqueeModifierNode.m15494getAnimationModeZbEOnfQ(), MarqueeAnimationMode.INSTANCE.m15488getWhileFocusedZbEOnfQ()) || marqueeModifierNode.getHasFocus()) {
                            return Float.valueOf(marqueeModifierNode.getContentWidth() + marqueeModifierNode.getSpacingPx());
                        }
                        return null;
                    }
                });
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(MarqueeModifierNode.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(flowSnapshotFlow, anonymousClass2, this) == coroutine_suspended) {
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
            return ((C08172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ MarqueeModifierNode(int i, int i2, int i4, int i5, MarqueeSpacing marqueeSpacing, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i4, i5, marqueeSpacing, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContainerWidth() {
        return this.containerWidth.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContentWidth() {
        return this.contentWidth.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getDirection() {
        float fSignum = Math.signum(this.velocity);
        int i = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
        int i2 = 1;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = -1;
        }
        return fSignum * i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx.getValue()).intValue();
    }

    private final void restartAnimation() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (getIsAttached()) {
            this.animationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C08161(job, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runAnimation(Continuation<? super Unit> continuation) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        Object objWithContext = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new C08172(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final void setContainerWidth(int i) {
        this.containerWidth.setIntValue(i);
    }

    private final void setContentWidth(int i) {
        this.contentWidth.setIntValue(i);
    }

    private final void setHasFocus(boolean z) {
        this.hasFocus.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.p109ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        float fFloatValue = this.offset.getValue().floatValue() * getDirection();
        boolean z = getDirection() != 1.0f ? this.offset.getValue().floatValue() < ((float) getContainerWidth()) : this.offset.getValue().floatValue() < ((float) getContentWidth());
        boolean z2 = getDirection() != 1.0f ? this.offset.getValue().floatValue() > ((float) getSpacingPx()) : this.offset.getValue().floatValue() > ((float) ((getContentWidth() + getSpacingPx()) - getContainerWidth()));
        float contentWidth = getDirection() == 1.0f ? getContentWidth() + getSpacingPx() : (-getContentWidth()) - getSpacingPx();
        float containerWidth = fFloatValue + getContainerWidth();
        float fM18350getHeightimpl = Size.m18350getHeightimpl(contentDrawScope.mo19076getSizeNHjbRc());
        int iM18514getIntersectrtfAjoo = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19000clipRectN_I0leg(fFloatValue, 0.0f, containerWidth, fM18350getHeightimpl, iM18514getIntersectrtfAjoo);
            if (z) {
                contentDrawScope.drawContent();
            }
            if (z2) {
                contentDrawScope.getDrawContext().getTransform().translate(contentWidth, 0.0f);
                try {
                    contentDrawScope.drawContent();
                    contentDrawScope.getDrawContext().getTransform().translate(-contentWidth, -0.0f);
                } catch (Throwable th) {
                    contentDrawScope.getDrawContext().getTransform().translate(-contentWidth, -0.0f);
                    throw th;
                }
            }
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
        } catch (Throwable th2) {
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getAnimationMode-ZbEOnfQ, reason: not valid java name */
    public final int m15494getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode.getValue()).getValue();
    }

    @NotNull
    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing.getValue();
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        setContainerWidth(ConstraintsKt.m20938constrainWidthK40F9xA(j, placeableMo19855measureBRTryo0.getWidth()));
        setContentWidth(placeableMo19855measureBRTryo0.getWidth());
        return MeasureScope.layout$default(measureScope, getContainerWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.MarqueeModifierNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo19855measureBRTryo0, MathKt.roundToInt((-((Number) this.offset.getValue()).floatValue()) * this.getDirection()), 0, 0.0f, (Function1) null, 12, (Object) null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        restartAnimation();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
    }

    @Override // androidx.compose.p109ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        setHasFocus(focusState.getHasFocus());
    }

    /* JADX INFO: renamed from: setAnimationMode-97h66l8, reason: not valid java name */
    public final void m15495setAnimationMode97h66l8(int i) {
        this.animationMode.setValue(MarqueeAnimationMode.m15480boximpl(i));
    }

    public final void setSpacing(@NotNull MarqueeSpacing marqueeSpacing) {
        this.spacing.setValue(marqueeSpacing);
    }

    /* JADX INFO: renamed from: update-lWfNwf4, reason: not valid java name */
    public final void m15496updatelWfNwf4(int iterations, int animationMode, int delayMillis, int initialDelayMillis, @NotNull MarqueeSpacing spacing, float velocity) {
        setSpacing(spacing);
        m15495setAnimationMode97h66l8(animationMode);
        if (this.iterations == iterations && this.delayMillis == delayMillis && this.initialDelayMillis == initialDelayMillis && C2256Dp.m20973equalsimpl0(this.velocity, velocity)) {
            return;
        }
        this.iterations = iterations;
        this.delayMillis = delayMillis;
        this.initialDelayMillis = initialDelayMillis;
        this.velocity = velocity;
        restartAnimation();
    }

    private MarqueeModifierNode(int i, int i2, int i4, int i5, final MarqueeSpacing marqueeSpacing, float f) {
        this.iterations = i;
        this.delayMillis = i4;
        this.initialDelayMillis = i5;
        this.velocity = f;
        this.contentWidth = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth = SnapshotIntStateKt.mutableIntStateOf(0);
        this.hasFocus = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.spacing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(marqueeSpacing, null, 2, null);
        this.animationMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m15480boximpl(i2), null, 2, null);
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.spacingPx = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.compose.foundation.MarqueeModifierNode$spacingPx$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                MarqueeSpacing marqueeSpacing2 = marqueeSpacing;
                MarqueeModifierNode marqueeModifierNode = this;
                return Integer.valueOf(marqueeSpacing2.calculateSpacing(DelegatableNodeKt.requireDensity(marqueeModifierNode), marqueeModifierNode.getContentWidth(), marqueeModifierNode.getContainerWidth()));
            }
        });
    }
}
