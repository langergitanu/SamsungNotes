package androidx.compose.foundation;

import android.view.View;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatableNode_androidKt;
import androidx.compose.p109ui.node.DrawModifierNode;
import androidx.compose.p109ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.p109ui.node.ObserverModifierNode;
import androidx.compose.p109ui.node.ObserverModifierNodeKt;
import androidx.compose.p109ui.node.SemanticsModifierNode;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0099\u0001\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\b\u0010R\u001a\u00020\u000eH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020/H\u0016J\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0002J\u0092\u0001\u0010X\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\b\u0010[\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020\u000eH\u0002J\f\u0010]\u001a\u00020\u000e*\u00020^H\u0016J\f\u0010_\u001a\u00020\u000e*\u00020`H\u0016R\u001a\u0010\u001b\u001a\u00020\t8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0014\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010/8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u00020\rX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010GR+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\u0016\u0010K\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010HR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010!\"\u0004\bM\u0010#R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006a"}, m13886d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "()J", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "getClippingEnabled", "()Z", "setClippingEnabled", "(Z)V", "getCornerRadius-D9Ej5fM", "()F", "setCornerRadius-0680j_4", "(F)V", TokenizerME.NO_SPLIT, "density", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "getElevation-D9Ej5fM", "setElevation-0680j_4", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "getMagnifierCenter", "()Lkotlin/jvm/functions/Function1;", "setMagnifierCenter", "(Lkotlin/jvm/functions/Function1;)V", "getOnSizeChanged", "setOnSizeChanged", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-MYxV2XQ", "setSize-EaSLcWc", "(J)V", "J", "getSourceCenter", "setSourceCenter", "sourceCenterInRoot", "getUseTextDefault", "setUseTextDefault", "view", "Landroid/view/View;", "getZoom", "setZoom", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "onObservedReadsChanged", "recreateMagnifier", Constants.ARG_UPDATE, "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "updateMagnifier", "updateSizeIfNecessary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMagnifier.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Magnifier.android.kt\nandroidx/compose/foundation/MagnifierNode\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,494:1\n81#2:495\n107#2,2:496\n1#3:498\n*S KotlinDebug\n*F\n+ 1 Magnifier.android.kt\nandroidx/compose/foundation/MagnifierNode\n*L\n284#1:495\n284#1:496,2\n*E\n"})
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;

    @Nullable
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;

    @Nullable
    private Density density;

    @Nullable
    private Channel<Unit> drawSignalChannel;
    private float elevation;

    /* JADX INFO: renamed from: layoutCoordinates$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState layoutCoordinates;

    @Nullable
    private PlatformMagnifier magnifier;

    @Nullable
    private Function1<? super Density, Offset> magnifierCenter;

    @Nullable
    private Function1<? super DpSize, Unit> onSizeChanged;

    @NotNull
    private PlatformMagnifierFactory platformMagnifierFactory;

    @Nullable
    private IntSize previousSize;
    private long size;

    @NotNull
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;

    @Nullable
    private View view;
    private float zoom;

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierNode$onAttach$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.MagnifierNode$onAttach$1", m14021f = "Magnifier.android.kt", m14022i = {}, m14023l = {380, 384}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C08141(Continuation<? super C08141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return MagnifierNode.this.new C08141(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        
            if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r4) == r0) goto L20;
         */
        /* JADX WARN: Path cross not found for [B:13:0x0029, B:16:0x0032], limit reached: 23 */
        /* JADX WARN: Path cross not found for [B:16:0x0032, B:13:0x0029], limit reached: 23 */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0038 -> B:11:0x0021). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0042 -> B:21:0x0045). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                channel = MagnifierNode.this.drawSignalChannel;
                if (channel != null) {
                }
                if (MagnifierNode.this.magnifier == null) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                if (MagnifierNode.this.magnifier == null) {
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PlatformMagnifier platformMagnifier = MagnifierNode.this.magnifier;
            if (platformMagnifier != null) {
                platformMagnifier.updateContent();
            }
            channel = MagnifierNode.this.drawSignalChannel;
            if (channel != null) {
                this.label = 1;
                if (channel.receive(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (MagnifierNode.this.magnifier == null) {
                AnonymousClass1 anonymousClass1 = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.MagnifierNode.onAttach.1.1
                    public final void invoke(long j) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }
                };
                this.label = 2;
            } else {
                channel = MagnifierNode.this.drawSignalChannel;
                if (channel != null) {
                }
                if (MagnifierNode.this.magnifier == null) {
                }
            }
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f4, float f5, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f, z, j, f4, f5, z2, platformMagnifierFactory);
    }

    /* JADX INFO: renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    private final long m15466getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$anchorPositionInRoot$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m18273boximpl(m15474invokeF1C5BW0());
                }

                /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m15474invokeF1C5BW0() {
                    LayoutCoordinates layoutCoordinates = this.this$0.getLayoutCoordinates();
                    return layoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(layoutCoordinates) : Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
                }
            });
        }
        State<Offset> state = this.anchorPositionInRootState;
        return state != null ? state.getValue().getPackedValue() : Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates.getValue();
    }

    private final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View viewRequireView = this.view;
        if (viewRequireView == null) {
            viewRequireView = DelegatableNode_androidKt.requireView(this);
        }
        View view = viewRequireView;
        this.view = view;
        Density densityRequireDensity = this.density;
        if (densityRequireDensity == null) {
            densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        }
        Density density = densityRequireDensity;
        this.density = density;
        this.magnifier = this.platformMagnifierFactory.mo15500createnHHXs2Y(view, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density, this.zoom);
        updateSizeIfNecessary();
    }

    private final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates.setValue(layoutCoordinates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateMagnifier() {
        long jM18299getUnspecifiedF1C5BW0;
        Density densityRequireDensity = this.density;
        if (densityRequireDensity == null) {
            densityRequireDensity = DelegatableNodeKt.requireDensity(this);
            this.density = densityRequireDensity;
        }
        long packedValue = this.sourceCenter.invoke(densityRequireDensity).getPackedValue();
        if (!OffsetKt.m18303isSpecifiedk4lQ0M(packedValue) || !OffsetKt.m18303isSpecifiedk4lQ0M(m15466getAnchorPositionInRootF1C5BW0())) {
            this.sourceCenterInRoot = Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
            PlatformMagnifier platformMagnifier = this.magnifier;
            if (platformMagnifier != null) {
                platformMagnifier.dismiss();
                return;
            }
            return;
        }
        this.sourceCenterInRoot = Offset.m18289plusMKHz9U(m15466getAnchorPositionInRootF1C5BW0(), packedValue);
        Function1<? super Density, Offset> function1 = this.magnifierCenter;
        if (function1 != null) {
            Offset offsetM18273boximpl = Offset.m18273boximpl(function1.invoke(densityRequireDensity).getPackedValue());
            if (!OffsetKt.m18303isSpecifiedk4lQ0M(offsetM18273boximpl.getPackedValue())) {
                offsetM18273boximpl = null;
            }
            if (offsetM18273boximpl != null) {
                jM18299getUnspecifiedF1C5BW0 = Offset.m18289plusMKHz9U(m15466getAnchorPositionInRootF1C5BW0(), offsetM18273boximpl.getPackedValue());
            } else {
                jM18299getUnspecifiedF1C5BW0 = Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
            }
        }
        long j = jM18299getUnspecifiedF1C5BW0;
        if (this.magnifier == null) {
            recreateMagnifier();
        }
        PlatformMagnifier platformMagnifier2 = this.magnifier;
        if (platformMagnifier2 != null) {
            platformMagnifier2.mo15499updateWko1d7g(this.sourceCenterInRoot, j, this.zoom);
        }
        updateSizeIfNecessary();
    }

    private final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null || IntSize.m21135equalsimpl(platformMagnifier.mo15498getSizeYbymL2g(), this.previousSize)) {
            return;
        }
        Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
        if (function1 != null) {
            function1.invoke(DpSize.m21054boximpl(density.mo15544toDpSizekrfVVM(IntSizeKt.m21150toSizeozmzZPI(platformMagnifier.mo15498getSizeYbymL2g()))));
        }
        this.previousSize = IntSize.m21130boximpl(platformMagnifier.mo15498getSizeYbymL2g());
    }

    @Override // androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode.applySemantics.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m18273boximpl(m15475invokeF1C5BW0());
            }

            /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m15475invokeF1C5BW0() {
                return MagnifierNode.this.sourceCenterInRoot;
            }
        });
    }

    @Override // androidx.compose.p109ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Channel<Unit> channel = this.drawSignalChannel;
        if (channel != null) {
            ChannelResult.m23719boximpl(channel.mo23705trySendJP2dKIU(Unit.INSTANCE));
        }
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    @Nullable
    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    @Nullable
    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    @NotNull
    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    @NotNull
    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final float getZoom() {
        return this.zoom;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C08141(null), 3, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.p109ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        setLayoutCoordinates(coordinates);
    }

    @Override // androidx.compose.p109ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierNode.onObservedReadsChanged.1
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
                MagnifierNode.this.updateMagnifier();
            }
        });
    }

    public final void setClippingEnabled(boolean z) {
        this.clippingEnabled = z;
    }

    /* JADX INFO: renamed from: setCornerRadius-0680j_4, reason: not valid java name */
    public final void m15470setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* JADX INFO: renamed from: setElevation-0680j_4, reason: not valid java name */
    public final void m15471setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final void setMagnifierCenter(@Nullable Function1<? super Density, Offset> function1) {
        this.magnifierCenter = function1;
    }

    public final void setOnSizeChanged(@Nullable Function1<? super DpSize, Unit> function1) {
        this.onSizeChanged = function1;
    }

    public final void setPlatformMagnifierFactory(@NotNull PlatformMagnifierFactory platformMagnifierFactory) {
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    /* JADX INFO: renamed from: setSize-EaSLcWc, reason: not valid java name */
    public final void m15472setSizeEaSLcWc(long j) {
        this.size = j;
    }

    public final void setSourceCenter(@NotNull Function1<? super Density, Offset> function1) {
        this.sourceCenter = function1;
    }

    public final void setUseTextDefault(boolean z) {
        this.useTextDefault = z;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    /* JADX INFO: renamed from: update-5F03MCQ, reason: not valid java name */
    public final void m15473update5F03MCQ(@NotNull Function1<? super Density, Offset> sourceCenter, @Nullable Function1<? super Density, Offset> magnifierCenter, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, @Nullable Function1<? super DpSize, Unit> onSizeChanged, @NotNull PlatformMagnifierFactory platformMagnifierFactory) {
        float f = this.zoom;
        long j = this.size;
        float f4 = this.cornerRadius;
        boolean z = this.useTextDefault;
        float f5 = this.elevation;
        boolean z2 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        View view = this.view;
        Density density = this.density;
        this.sourceCenter = sourceCenter;
        this.magnifierCenter = magnifierCenter;
        this.zoom = zoom;
        this.useTextDefault = useTextDefault;
        this.size = size;
        this.cornerRadius = cornerRadius;
        this.elevation = elevation;
        this.clippingEnabled = clippingEnabled;
        this.onSizeChanged = onSizeChanged;
        this.platformMagnifierFactory = platformMagnifierFactory;
        View viewRequireView = DelegatableNode_androidKt.requireView(this);
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        if (this.magnifier != null && ((!Magnifier_androidKt.equalsIncludingNaN(zoom, f) && !platformMagnifierFactory.getCanUpdateZoom()) || !DpSize.m21063equalsimpl0(size, j) || !C2256Dp.m20973equalsimpl0(cornerRadius, f4) || !C2256Dp.m20973equalsimpl0(elevation, f5) || useTextDefault != z || clippingEnabled != z2 || !Intrinsics.areEqual(platformMagnifierFactory, platformMagnifierFactory2) || !Intrinsics.areEqual(viewRequireView, view) || !Intrinsics.areEqual(densityRequireDensity, density))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f4, float f5, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : function13, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? false : z, (i & 32) != 0 ? DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ() : j, (i & 64) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f4, (i & 128) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f5, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null);
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f4, float f5, boolean z2, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f4;
        this.elevation = f5;
        this.clippingEnabled = z2;
        this.platformMagnifierFactory = platformMagnifierFactory;
        this.layoutCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
    }
}
