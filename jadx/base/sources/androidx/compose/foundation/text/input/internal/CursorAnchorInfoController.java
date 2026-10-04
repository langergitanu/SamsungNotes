package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/CoroutineScope;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "monitorEnabled", "monitorJob", "Lkotlinx/coroutines/Job;", "calculateCursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "requestUpdates", "", "immediate", "monitor", "cursorUpdateMode", "", "startOrStopMonitoring", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCursorAnchorInfoController.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CursorAnchorInfoController.android.kt\nandroidx/compose/foundation/text/input/internal/CursorAnchorInfoController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n1#2:204\n*E\n"})
public final class CursorAnchorInfoController {
    public static final int $stable = 8;

    @NotNull
    private final ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private boolean monitorEnabled;

    @Nullable
    private Job monitorJob;

    @NotNull
    private final CoroutineScope monitorScope;

    @NotNull
    private final TransformedTextFieldState textFieldState;

    @NotNull
    private final TextLayoutState textLayoutState;

    @NotNull
    private final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();

    @NotNull
    private final float[] matrix = Matrix.m18756constructorimpl$default(null, 1, null);

    @NotNull
    private final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1", m14021f = "CursorAnchorInfoController.android.kt", m14022i = {}, m14023l = {155}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C13031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C13031(Continuation<? super C13031> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return CursorAnchorInfoController.this.new C13031(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CursorAnchorInfoController cursorAnchorInfoController = CursorAnchorInfoController.this;
                Flow flowFilterNotNull = FlowKt.filterNotNull(FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0<CursorAnchorInfo>() { // from class: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final CursorAnchorInfo invoke() {
                        return cursorAnchorInfoController.calculateCursorAnchorInfo();
                    }
                }), 1));
                final CursorAnchorInfoController cursorAnchorInfoController2 = CursorAnchorInfoController.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1.2
                    @Nullable
                    public final Object emit(@NotNull CursorAnchorInfo cursorAnchorInfo, @NotNull Continuation<? super Unit> continuation) {
                        cursorAnchorInfoController2.composeImm.updateCursorAnchorInfo(cursorAnchorInfo);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CursorAnchorInfo) obj2, (Continuation<? super Unit>) continuation);
                    }
                };
                this.label = 1;
                if (flowFilterNotNull.collect(flowCollector, this) == coroutine_suspended) {
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
            return ((C13031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public CursorAnchorInfoController(@NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextLayoutState textLayoutState, @NotNull ComposeInputMethodManager composeInputMethodManager, @NotNull CoroutineScope coroutineScope) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.composeImm = composeInputMethodManager;
        this.monitorScope = coroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CursorAnchorInfo calculateCursorAnchorInfo() {
        LayoutCoordinates coreNodeCoordinates;
        LayoutCoordinates decoratorNodeCoordinates;
        TextLayoutResult layoutResult;
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null && (coreNodeCoordinates = this.textLayoutState.getCoreNodeCoordinates()) != null) {
                if (!coreNodeCoordinates.isAttached()) {
                    coreNodeCoordinates = null;
                }
                if (coreNodeCoordinates != null && (decoratorNodeCoordinates = this.textLayoutState.getDecoratorNodeCoordinates()) != null) {
                    if (!decoratorNodeCoordinates.isAttached()) {
                        decoratorNodeCoordinates = null;
                    }
                    if (decoratorNodeCoordinates == null || (layoutResult = this.textLayoutState.getLayoutResult()) == null) {
                        return null;
                    }
                    TextFieldCharSequence visualText = this.textFieldState.getVisualText();
                    Matrix.m18765resetimpl(this.matrix);
                    textLayoutNodeCoordinates.mo19871transformToScreen58bKbWc(this.matrix);
                    AndroidMatrixConversions_androidKt.m18395setFromEL8BTi8(this.androidMatrix, this.matrix);
                    Rect rectVisibleBounds = SelectionManagerKt.visibleBounds(coreNodeCoordinates);
                    Offset.Companion companion = Offset.INSTANCE;
                    return CursorAnchorInfoBuilder_androidKt.m16309buildvxqZcH0(this.builder, visualText, visualText.getSelection(), visualText.getComposition(), layoutResult, this.androidMatrix, rectVisibleBounds.m18321translatek4lQ0M(textLayoutNodeCoordinates.mo19864localPositionOfR5De75A(coreNodeCoordinates, companion.m18300getZeroF1C5BW0())), SelectionManagerKt.visibleBounds(decoratorNodeCoordinates).m18321translatek4lQ0M(textLayoutNodeCoordinates.mo19864localPositionOfR5De75A(decoratorNodeCoordinates, companion.m18300getZeroF1C5BW0())), this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds);
                }
            }
        }
        return null;
    }

    private final void startOrStopMonitoring() {
        if (!this.monitorEnabled) {
            Job job = this.monitorJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.monitorJob = null;
            return;
        }
        Job job2 = this.monitorJob;
        if (job2 == null || !job2.isActive()) {
            this.monitorJob = BuildersKt__Builders_commonKt.launch$default(this.monitorScope, null, CoroutineStart.UNDISPATCHED, new C13031(null), 1, null);
        }
    }

    public final void requestUpdates(int cursorUpdateMode) {
        CursorAnchorInfoController cursorAnchorInfoController;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        boolean z6 = (cursorUpdateMode & 1) != 0;
        boolean z7 = (cursorUpdateMode & 2) != 0;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            boolean z8 = (cursorUpdateMode & 16) != 0;
            boolean z9 = (cursorUpdateMode & 8) != 0;
            boolean z10 = (cursorUpdateMode & 4) != 0;
            if (i >= 34 && (cursorUpdateMode & 32) != 0) {
                z5 = true;
            }
            if (z8 || z9 || z10 || z5) {
                z2 = z5;
                z = z10;
                z4 = z9;
                z3 = z8;
                cursorAnchorInfoController = this;
            } else {
                cursorAnchorInfoController = this;
                if (i >= 34) {
                    z3 = true;
                    z4 = true;
                    z = true;
                    z2 = true;
                } else {
                    z2 = z5;
                    z3 = true;
                    z4 = true;
                    z = true;
                }
            }
        } else {
            cursorAnchorInfoController = this;
            z = false;
            z2 = false;
            z3 = true;
            z4 = true;
        }
        cursorAnchorInfoController.requestUpdates(z6, z7, z3, z4, z, z2);
    }

    private final void requestUpdates(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        this.includeInsertionMarker = includeInsertionMarker;
        this.includeCharacterBounds = includeCharacterBounds;
        this.includeEditorBounds = includeEditorBounds;
        this.includeLineBounds = includeLineBounds;
        if (immediate) {
            this.hasPendingImmediateRequest = true;
            CursorAnchorInfo cursorAnchorInfoCalculateCursorAnchorInfo = calculateCursorAnchorInfo();
            if (cursorAnchorInfoCalculateCursorAnchorInfo != null) {
                this.composeImm.updateCursorAnchorInfo(cursorAnchorInfoCalculateCursorAnchorInfo);
            }
        }
        this.monitorEnabled = monitor;
        startOrStopMonitoring();
    }
}
