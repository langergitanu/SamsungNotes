package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RectKt;
import androidx.compose.p109ui.hapticfeedback.HapticFeedback;
import androidx.compose.p109ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.platform.ClipEntry;
import androidx.compose.p109ui.platform.ClipboardManager;
import androidx.compose.p109ui.platform.TextToolbar;
import androidx.compose.p109ui.platform.TextToolbarStatus;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0006«\u0001¬\u0001\u00ad\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020\tJ\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010Z\u001a\u00020\tJ\u0006\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020\\2\b\b\u0002\u0010^\u001a\u00020\tJ\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u00020\\J\u0006\u0010a\u001a\u00020\\J\b\u0010b\u001a\u00020cH\u0002J\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\tH\u0000¢\u0006\u0002\bgJ\u0006\u0010h\u001a\u00020cJ\u001d\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001d\u0010m\u001a\u00020e2\u0006\u0010j\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0000¢\u0006\u0002\bnJ<\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u0002032\u0006\u0010r\u001a\u0002032\b\u0010s\u001a\u0004\u0018\u00010p2\u0006\u0010j\u001a\u00020\t2\u0006\u0010t\u001a\u00020uH\u0002ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\b\u0010x\u001a\u00020\\H\u0002J\b\u0010y\u001a\u00020\tH\u0002J\b\u0010z\u001a\u00020\\H\u0002J1\u0010{\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010<2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010|\u001a\u00020P2\u000e\b\u0004\u0010}\u001a\b\u0012\u0004\u0012\u00020\\0<H\u0082\bJ\u000e\u0010~\u001a\u00020\\H\u0086@¢\u0006\u0002\u0010\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020\\H\u0082@¢\u0006\u0002\u0010\u007fJ\u000f\u0010\u0081\u0001\u001a\u00020\\H\u0082@¢\u0006\u0002\u0010\u007fJ\u0007\u0010\u0082\u0001\u001a\u00020\\J\t\u0010\u0083\u0001\u001a\u00020\\H\u0002J\u001e\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020\\J\u0012\u0010\u0089\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020cH\u0002J?\u0010\u008b\u0001\u001a\u00020\\2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ%\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020\u001d2\u0007\u0010\u008e\u0001\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001JZ\u0010\u0091\u0001\u001a\u00020p2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u0002032\u0007\u0010\u0095\u0001\u001a\u0002032\u0006\u0010j\u001a\u00020\t2\u0006\u0010t\u001a\u00020u2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0097\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u00020\\2\u0006\u0010Q\u001a\u00020PJ\u0015\u0010\u009b\u0001\u001a\u00020\\*\u00030\u009c\u0001H\u0086@¢\u0006\u0003\u0010\u009d\u0001J\u0015\u0010\u009e\u0001\u001a\u00020\\*\u00030\u009c\u0001H\u0082@¢\u0006\u0003\u0010\u009d\u0001J\u001d\u0010\u009f\u0001\u001a\u00020\\*\u00030\u009c\u00012\u0006\u0010j\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010 \u0001J?\u0010¡\u0001\u001a\u00020\\*\u00030\u009c\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\\0<2\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\\0<H\u0086@¢\u0006\u0003\u0010¦\u0001J\u0015\u0010§\u0001\u001a\u00020\\*\u00030\u009c\u0001H\u0086@¢\u0006\u0003\u0010\u009d\u0001J\u001d\u0010¨\u0001\u001a\u00020\\*\u00030\u009c\u00012\u0006\u0010j\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010 \u0001J$\u0010©\u0001\u001a\u00020\\*\u00030\u009c\u00012\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\\0<H\u0086@¢\u0006\u0003\u0010ª\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010&\"\u0004\b+\u0010,R+\u0010-\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010&\"\u0004\b.\u0010,R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00106\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b:\u0010\u001c\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010B\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001c\u001a\u0004\bC\u0010&\"\u0004\bD\u0010,R1\u0010F\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bI\u0010\u001c\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010Q\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020P8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010\u001c\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006®\u0001"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentTextLayoutPositionInWindow", "Landroidx/compose/ui/geometry/Offset;", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "()J", "<set-?>", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "editable", "getEditable", "()Z", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "receiveContentConfiguration", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "()Lkotlin/jvm/functions/Function0;", "setReceiveContentConfiguration", "(Lkotlin/jvm/functions/Function0;)V", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "setStartTextLayoutPositionInWindow-k-4lQ0M", "startTextLayoutPositionInWindow$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "canCopy", "canCut", "canPaste", "canSelectAll", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation_release", "getCursorRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getSelectionHandleState$foundation_release", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "isCursorHandleInVisibleBounds", "markStartContentVisibleOffset", "menuItem", "desiredState", "operation", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "pasteAsPlainText", "placeCursorAtNearestOffset", TypedValues.Cycle.S_WAVE_OFFSET, "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "selectAll", "showTextToolbar", "contentRect", Constants.ARG_UPDATE, "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextFieldSelectionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextFieldSelectionState.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 5 TransformedTextFieldState.kt\nandroidx/compose/foundation/text/input/internal/TransformedTextFieldStateKt\n*L\n1#1,1542:1\n1409#1,6:1597\n1409#1,6:1603\n1409#1,6:1609\n1409#1,6:1615\n81#2:1543\n107#2,2:1544\n81#2:1546\n107#2,2:1547\n81#2:1549\n107#2,2:1550\n81#2:1552\n107#2,2:1553\n81#2:1555\n107#2,2:1556\n81#2:1558\n107#2,2:1559\n81#2:1561\n107#2,2:1562\n1#3:1564\n602#4,8:1565\n653#5,24:1573\n*S KotlinDebug\n*F\n+ 1 TextFieldSelectionState.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState\n*L\n1396#1:1597,6\n1397#1:1603,6\n1398#1:1609,6\n1399#1:1615,6\n130#1:1543\n130#1:1544,2\n146#1:1546\n146#1:1547,2\n166#1:1549\n166#1:1550,2\n199#1:1552\n199#1:1553,2\n208#1:1555\n208#1:1556,2\n213#1:1558\n213#1:1559,2\n219#1:1561\n219#1:1562,2\n299#1:1565,8\n545#1:1573,24\n*E\n"})
public final class TextFieldSelectionState {
    public static final int $stable = 8;

    @Nullable
    private ClipboardManager clipboardManager;

    @NotNull
    private Density density;

    /* JADX INFO: renamed from: directDragGestureInitiator$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState directDragGestureInitiator;

    /* JADX INFO: renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState draggingHandle;
    private boolean enabled;

    @Nullable
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;

    /* JADX INFO: renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    private boolean isPassword;

    @Nullable
    private PressInteraction.Press pressInteraction;
    private int previousRawDragOffset;

    @Nullable
    private SelectionLayout previousSelectionLayout;

    /* JADX INFO: renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState rawHandleDragPosition;
    private boolean readOnly;

    @Nullable
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;

    /* JADX INFO: renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState showCursorHandle;

    /* JADX INFO: renamed from: startTextLayoutPositionInWindow$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState startTextLayoutPositionInWindow;

    @NotNull
    private final TransformedTextFieldState textFieldState;

    @NotNull
    private final TextLayoutState textLayoutState;

    @Nullable
    private TextToolbar textToolbar;

    /* JADX INFO: renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState textToolbarState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum InputType {
        None,
        Touch,
        Mouse
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "updateSelection-r1Wruf4", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTextFieldSelectionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextFieldSelectionState.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1542:1\n1#2:1543\n*E\n"})
    public final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();

        @NotNull
        private final Function0<Unit> requestFocus;

        public TextFieldMouseSelectionObserver(@NotNull Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        /* JADX INFO: renamed from: updateSelection-r1Wruf4, reason: not valid java name */
        private final long m16440updateSelectionr1Wruf4(long dragPosition, SelectionAdjustment adjustment, boolean isStartOfSelection) {
            Integer numValueOf = Integer.valueOf(this.dragBeginOffsetInText);
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m16385getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            int iM16385getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m16385getOffsetForPosition3MmeM6k(dragPosition, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jM16436updateSelectionSsLRf8 = textFieldSelectionState.m16436updateSelectionSsLRf8(textFieldSelectionState.textFieldState.getVisualText(), iIntValue, iM16385getOffsetForPosition3MmeM6k, false, adjustment, false, isStartOfSelection);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m20450getCollapsedimpl(jM16436updateSelectionSsLRf8)) {
                this.dragBeginOffsetInText = TextRange.m20456getStartimpl(jM16436updateSelectionSsLRf8);
            }
            if (TextRange.m20455getReversedimpl(jM16436updateSelectionSsLRf8)) {
                jM16436updateSelectionSsLRf8 = TextFieldSelectionStateKt.m16453reverse5zctL8(jM16436updateSelectionSsLRf8);
            }
            TextFieldSelectionState.this.textFieldState.m16402selectCharsIn5zctL8(jM16436updateSelectionSsLRf8);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return jM16436updateSelectionSsLRf8;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onDrag-3MmeM6k, reason: not valid java name */
        public boolean mo16441onDrag3MmeM6k(final long dragPosition, @NotNull SelectionAdjustment adjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "Mouse.onDrag " + ((Object) Offset.m18292toStringimpl(dragPosition));
                }
            });
            m16440updateSelectionr1Wruf4(dragPosition, adjustment, false);
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDragDone$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "Mouse.onDragDone";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onExtend-k-4lQ0M, reason: not valid java name */
        public boolean mo16442onExtendk4lQ0M(long downPosition) {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtend$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "Mouse.onExtend";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
        public boolean mo16443onExtendDragk4lQ0M(long dragPosition) {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtendDrag$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "Mouse.onExtendDrag";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onStart-3MmeM6k, reason: not valid java name */
        public boolean mo16444onStart3MmeM6k(long downPosition, @NotNull SelectionAdjustment adjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onStart$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "Mouse.onStart";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = downPosition;
            this.dragBeginOffsetInText = TextRange.m20456getStartimpl(m16440updateSelectionr1Wruf4(downPosition, adjustment, true));
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C13562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {368}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    this.label = 1;
                    if (textFieldSelectionState.detectTouchMode(pointerInputScope, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {371}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$this_cursorHandleGestures, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    this.label = 1;
                    if (textFieldSelectionState.detectCursorHandleDragGestures(pointerInputScope, this) == coroutine_suspended) {
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
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {374}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$this_cursorHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0;
                    Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.cursorHandleGestures.2.3.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m16445invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m16445invokek4lQ0M(long j) {
                            TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                            TextToolbarState textToolbarState = textFieldSelectionState2.getTextToolbarState();
                            TextToolbarState textToolbarState2 = TextToolbarState.Cursor;
                            if (textToolbarState == textToolbarState2) {
                                textToolbarState2 = TextToolbarState.None;
                            }
                            textFieldSelectionState2.setTextToolbarState(textToolbarState2);
                        }
                    };
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, function1, this, 7, null) == coroutine_suspended) {
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
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13562(PointerInputScope pointerInputScope, Continuation<? super C13562> continuation) {
            super(2, continuation);
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C13562 c13562 = TextFieldSelectionState.this.new C13562(this.$this_cursorHandleGestures, continuation);
            c13562.L$0 = obj;
            return c13562;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass1(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass2(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass3(this.$this_cursorHandleGestures, TextFieldSelectionState.this, null), 1, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
            return ((C13562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m14021f = "TextFieldSelectionState.kt", m14022i = {0, 0, 0}, m14023l = {614}, m14024m = "detectCursorHandleDragGestures", m14025n = {"this", "cursorDragStart", "cursorDragDelta"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C13571 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13571(Continuation<? super C13571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectCursorHandleDragGestures(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m14021f = "TextFieldSelectionState.kt", m14022i = {0, 0, 0, 0}, m14023l = {980}, m14024m = "detectSelectionHandleDragGestures", m14025n = {"this", "dragBeginPosition", "dragTotalDistance", "handle"}, m14026s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class C13621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13621(Continuation<? super C13621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectSelectionHandleDragGestures(null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {491}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C13682 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13682(MutableInteractionSource mutableInteractionSource, TextFieldSelectionState textFieldSelectionState, Continuation<? super C13682> continuation) {
            super(3, continuation);
            this.$interactionSource = mutableInteractionSource;
            this.this$0 = textFieldSelectionState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m16450invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m16450invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j, @Nullable Continuation<? super Unit> continuation) {
            C13682 c13682 = new C13682(this.$interactionSource, this.this$0, continuation);
            c13682.L$0 = pressGestureScope;
            c13682.J$0 = j;
            return c13682.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                if (mutableInteractionSource != null) {
                    TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(pressGestureScope, this.this$0, j, mutableInteractionSource, null);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(textFieldSelectionState$detectTextFieldTapGestures$2$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", m14021f = "TextFieldSelectionState.kt", m14022i = {0}, m14023l = {455}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope"}, m14026s = {"L$0"})
    public static final class C13712 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C13712(Continuation<? super C13712> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C13712 c13712 = TextFieldSelectionState.this.new C13712(continuation);
            c13712.L$0 = obj;
            return c13712;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C13712) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r4.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p109ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L30
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                java.lang.Object r5 = r4.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.p109ui.input.pointer.AwaitPointerEventScope) r5
                r1 = r5
            L23:
                androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.p109ui.input.pointer.PointerEventPass.Initial
                r4.L$0 = r1
                r4.label = r2
                java.lang.Object r5 = r1.awaitPointerEvent(r5, r4)
                if (r5 != r0) goto L30
                return r0
            L30:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.p109ui.input.pointer.PointerEvent) r5
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r3 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                boolean r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r5)
                r5 = r5 ^ r2
                r3.setInTouchMode(r5)
                goto L23
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C13712.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m14021f = "TextFieldSelectionState.kt", m14022i = {0}, m14023l = {423}, m14024m = "observeChanges", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C13731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13731(Continuation<? super C13731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.observeChanges(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C13742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$1", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {424}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    this.label = 1;
                    if (textFieldSelectionState.observeTextChanges(this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {TypedValues.Cycle.TYPE_WAVE_PHASE}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    this.label = 1;
                    if (textFieldSelectionState.observeTextToolbarVisibility(this) == coroutine_suspended) {
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
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C13742(Continuation<? super C13742> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C13742 c13742 = TextFieldSelectionState.this.new C13742(continuation);
            c13742.L$0 = obj;
            return c13742;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(TextFieldSelectionState.this, null), 3, null);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(TextFieldSelectionState.this, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
            return ((C13742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class C13763 extends FunctionReferenceImpl implements Function2<TextFieldCharSequence, CharSequence, Boolean> {
        public static final C13763 INSTANCE = new C13763();

        public C13763() {
            super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final Boolean invoke(@NotNull TextFieldCharSequence textFieldCharSequence, @NotNull CharSequence charSequence) {
            return Boolean.valueOf(textFieldCharSequence.contentEquals(charSequence));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C13802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {391}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    this.label = 1;
                    if (textFieldSelectionState.detectTouchMode(pointerInputScope, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {394}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, boolean z, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_selectionHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0;
                    final boolean z = this.$isStartHandle;
                    TapOnPosition tapOnPosition = new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.1
                        @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
                        /* JADX INFO: renamed from: onEvent-k-4lQ0M */
                        public final void mo16409onEventk4lQ0M(long j) {
                            textFieldSelectionState.markStartContentVisibleOffset();
                            TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                            boolean z2 = z;
                            textFieldSelectionState2.m16439updateHandleDraggingUv8p0NA(z2 ? Handle.SelectionStart : Handle.SelectionEnd, SelectionHandlesKt.m16511getAdjustedCoordinatesk4lQ0M(textFieldSelectionState2.m16429getHandlePositiontuRUvjQ(z2)));
                        }
                    };
                    final TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.2
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
                            textFieldSelectionState2.clearHandleDragging();
                        }
                    };
                    this.label = 1;
                    if (PressDownGestureKt.detectPressDownGesture(pointerInputScope, tapOnPosition, function0, this) == coroutine_suspended) {
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
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {412}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    boolean z = this.$isStartHandle;
                    this.label = 1;
                    if (textFieldSelectionState.detectSelectionHandleDragGestures(pointerInputScope, z, this) == coroutine_suspended) {
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
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13802(PointerInputScope pointerInputScope, boolean z, Continuation<? super C13802> continuation) {
            super(2, continuation);
            this.$this_selectionHandleGestures = pointerInputScope;
            this.$isStartHandle = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C13802 c13802 = TextFieldSelectionState.this.new C13802(this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            c13802.L$0 = obj;
            return c13802;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass1(TextFieldSelectionState.this, this.$this_selectionHandleGestures, null), 1, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass2(this.$this_selectionHandleGestures, TextFieldSelectionState.this, this.$isStartHandle, null), 1, null);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass3(TextFieldSelectionState.this, this.$this_selectionHandleGestures, this.$isStartHandle, null), 1, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
            return ((C13802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public TextFieldSelectionState(@NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextLayoutState textLayoutState, @NotNull Density density, boolean z, boolean z2, boolean z3, boolean z4) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
        this.isPassword = z4;
        Offset.Companion companion = Offset.INSTANCE;
        this.startTextLayoutPositionInWindow = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m18273boximpl(companion.m18299getUnspecifiedF1C5BW0()), null, 2, null);
        this.rawHandleDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m18273boximpl(companion.m18299getUnspecifiedF1C5BW0()), null, 2, null);
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.directDragGestureInitiator = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        this.showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.textToolbarState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.previousRawDragOffset = -1;
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectCursorHandleDragGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) throws Throwable {
        C13571 c13571;
        TextFieldSelectionState textFieldSelectionState;
        Ref.LongRef longRef;
        Throwable th;
        Ref.LongRef longRef2;
        if (continuation instanceof C13571) {
            c13571 = (C13571) continuation;
            int i = c13571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13571.label = i - Integer.MIN_VALUE;
            } else {
                c13571 = new C13571(continuation);
            }
        }
        C13571 c135712 = c13571;
        Object obj = c135712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c135712.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef2 = (Ref.LongRef) c135712.L$2;
            longRef = (Ref.LongRef) c135712.L$1;
            textFieldSelectionState = (TextFieldSelectionState) c135712.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        Offset.Companion companion = Offset.INSTANCE;
        longRef3.element = companion.m18299getUnspecifiedF1C5BW0();
        final Ref.LongRef longRef4 = new Ref.LongRef();
        longRef4.element = companion.m18299getUnspecifiedF1C5BW0();
        try {
            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m16446invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m16446invokek4lQ0M(long j) {
                    longRef3.element = SelectionHandlesKt.m16511getAdjustedCoordinatesk4lQ0M(this.getCursorRect().m18311getBottomCenterF1C5BW0());
                    longRef4.element = Offset.INSTANCE.m18300getZeroF1C5BW0();
                    this.setInTouchMode(true);
                    this.markStartContentVisibleOffset();
                    this.m16439updateHandleDraggingUv8p0NA(Handle.Cursor, longRef3.element);
                }
            };
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(longRef3, longRef4, this);
                }
            };
            Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(longRef3, longRef4, this);
                }
            };
            Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m16447invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m16447invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j) {
                    Ref.LongRef longRef5 = longRef4;
                    longRef5.element = Offset.m18289plusMKHz9U(longRef5.element, j);
                    this.m16439updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m18289plusMKHz9U(longRef3.element, longRef4.element));
                    TextFieldSelectionState textFieldSelectionState2 = this;
                    if (textFieldSelectionState2.m16433placeCursorAtNearestOffsetk4lQ0M(textFieldSelectionState2.m16438getHandleDragPositionF1C5BW0())) {
                        pointerInputChange.consume();
                        HapticFeedback hapticFeedback = this.hapticFeedBack;
                        if (hapticFeedback != null) {
                            hapticFeedback.mo19247performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m19256getTextHandleMove5zf0vsI());
                        }
                    }
                }
            };
            c135712.L$0 = this;
            c135712.L$1 = longRef3;
            c135712.L$2 = longRef4;
            c135712.label = 1;
            if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, c135712) == coroutine_suspended) {
                return coroutine_suspended;
            }
            textFieldSelectionState = this;
            longRef = longRef3;
            longRef2 = longRef4;
            detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            textFieldSelectionState = this;
            longRef = longRef3;
            th = th3;
            longRef2 = longRef4;
            detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if (OffsetKt.m18303isSpecifiedk4lQ0M(longRef.element)) {
            Offset.Companion companion = Offset.INSTANCE;
            longRef.element = companion.m18299getUnspecifiedF1C5BW0();
            longRef2.element = companion.m18299getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, final boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C13621 c13621;
        TextFieldSelectionState textFieldSelectionState;
        final Handle handle;
        Ref.LongRef longRef;
        Ref.LongRef longRef2;
        if (continuation instanceof C13621) {
            c13621 = (C13621) continuation;
            int i = c13621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13621.label = i - Integer.MIN_VALUE;
            } else {
                c13621 = new C13621(continuation);
            }
        }
        C13621 c136212 = c13621;
        Object obj = c136212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c136212.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            handle = (Handle) c136212.L$3;
            longRef2 = (Ref.LongRef) c136212.L$2;
            longRef = (Ref.LongRef) c136212.L$1;
            textFieldSelectionState = (TextFieldSelectionState) c136212.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                    }
                });
                if (textFieldSelectionState.getDraggingHandle() == handle) {
                    detectSelectionHandleDragGestures$onDragStop$5(longRef, textFieldSelectionState, longRef2);
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                    }
                });
                if (textFieldSelectionState.getDraggingHandle() == handle) {
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        Offset.Companion companion = Offset.INSTANCE;
        longRef3.element = companion.m18299getUnspecifiedF1C5BW0();
        final Ref.LongRef longRef4 = new Ref.LongRef();
        longRef4.element = companion.m18300getZeroF1C5BW0();
        final Handle handle2 = z ? Handle.SelectionStart : Handle.SelectionEnd;
        try {
            try {
                Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                        m16448invokek4lQ0M(offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m16448invokek4lQ0M(long j) {
                        longRef3.element = SelectionHandlesKt.m16511getAdjustedCoordinatesk4lQ0M(this.m16429getHandlePositiontuRUvjQ(z));
                        this.m16439updateHandleDraggingUv8p0NA(handle2, longRef3.element);
                        longRef4.element = Offset.INSTANCE.m18300getZeroF1C5BW0();
                        this.previousRawDragOffset = -1;
                    }
                };
                handle2 = handle2;
                longRef3 = longRef3;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$5(longRef3, this, longRef4);
                    }
                };
                Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$5(longRef3, this, longRef4);
                    }
                };
                try {
                    Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m16449invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m16449invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j) {
                            Ref.LongRef longRef5 = longRef4;
                            longRef5.element = Offset.m18289plusMKHz9U(longRef5.element, j);
                            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            this.m16439updateHandleDraggingUv8p0NA(handle2, Offset.m18289plusMKHz9U(longRef3.element, longRef4.element));
                            int iM20428getOffsetForPositionk4lQ0M = z ? layoutResult.m20428getOffsetForPositionk4lQ0M(this.m16438getHandleDragPositionF1C5BW0()) : TextRange.m20456getStartimpl(this.textFieldState.getVisualText().getSelection());
                            int iM20451getEndimpl = z ? TextRange.m20451getEndimpl(this.textFieldState.getVisualText().getSelection()) : layoutResult.m20428getOffsetForPositionk4lQ0M(this.m16438getHandleDragPositionF1C5BW0());
                            long selection = this.textFieldState.getVisualText().getSelection();
                            TextFieldSelectionState textFieldSelectionState2 = this;
                            long jM16437updateSelectionSsLRf8$default = TextFieldSelectionState.m16437updateSelectionSsLRf8$default(textFieldSelectionState2, textFieldSelectionState2.textFieldState.getVisualText(), iM20428getOffsetForPositionk4lQ0M, iM20451getEndimpl, z, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, false, 96, null);
                            if (TextRange.m20450getCollapsedimpl(selection) || !TextRange.m20450getCollapsedimpl(jM16437updateSelectionSsLRf8$default)) {
                                this.textFieldState.m16402selectCharsIn5zctL8(jM16437updateSelectionSsLRf8$default);
                            }
                        }
                    };
                    longRef4 = longRef4;
                    c136212.L$0 = this;
                    c136212.L$1 = longRef3;
                    c136212.L$2 = longRef4;
                    c136212.L$3 = handle2;
                    c136212.label = 1;
                    if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, c136212) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    textFieldSelectionState = this;
                    handle = handle2;
                    longRef = longRef3;
                    longRef2 = longRef4;
                    TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                        }
                    });
                    if (textFieldSelectionState.getDraggingHandle() == handle) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    longRef4 = longRef4;
                    textFieldSelectionState = this;
                    handle = handle2;
                    longRef = longRef3;
                    longRef2 = longRef4;
                    TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                        }
                    });
                    if (textFieldSelectionState.getDraggingHandle() == handle) {
                        detectSelectionHandleDragGestures$onDragStop$5(longRef, textFieldSelectionState, longRef2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                handle2 = handle2;
                longRef3 = longRef3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$5(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if (OffsetKt.m18303isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            Offset.Companion companion = Offset.INSTANCE;
            longRef.element = companion.m18299getUnspecifiedF1C5BW0();
            longRef2.element = companion.m18300getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float fM18285getYimpl;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m20450getCollapsedimpl(visualText.getSelection())) {
            Rect cursorRect3 = getCursorRect();
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m18324Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.mo19866localToRootMKHz9U(cursorRect3.m18319getTopLeftF1C5BW0()) : Offset.INSTANCE.m18300getZeroF1C5BW0(), cursorRect3.m18317getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long jMo19866localToRootMKHz9U = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo19866localToRootMKHz9U(m16429getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m18300getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long jMo19866localToRootMKHz9U2 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo19866localToRootMKHz9U(m16429getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m18300getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float fM18285getYimpl2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            fM18285getYimpl = Offset.m18285getYimpl(textLayoutCoordinates4.mo19866localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m20456getStartimpl(visualText.getSelection()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            fM18285getYimpl = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            fM18285getYimpl2 = Offset.m18285getYimpl(textLayoutCoordinates5.mo19866localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m20451getEndimpl(visualText.getSelection()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m18284getXimpl(jMo19866localToRootMKHz9U), Offset.m18284getXimpl(jMo19866localToRootMKHz9U2)), Math.min(fM18285getYimpl, fM18285getYimpl2), Math.max(Offset.m18284getXimpl(jMo19866localToRootMKHz9U), Offset.m18284getXimpl(jMo19866localToRootMKHz9U2)), Math.max(Offset.m18285getYimpl(jMo19866localToRootMKHz9U), Offset.m18285getYimpl(jMo19866localToRootMKHz9U2)));
    }

    /* JADX INFO: renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m16428getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
    }

    private final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m16429getHandlePositiontuRUvjQ(boolean isStartHandle) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, isStartHandle ? TextRange.m20456getStartimpl(selection) : TextRange.m20451getEndimpl(selection), isStartHandle, TextRange.m20455getReversedimpl(selection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m16430getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition.getValue()).getPackedValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getStartTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m16431getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m16432getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m20461getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout selectionLayoutM16514getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m16514getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m20461getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !selectionLayoutM16514getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long jM16503toTextRanged9O1mEE = adjustment.adjust(selectionLayoutM16514getTextFieldSelectionLayoutRcvTLA).m16503toTextRanged9O1mEE();
        this.previousSelectionLayout = selectionLayoutM16514getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return jM16503toTextRanged9O1mEE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Rect rectVisibleBounds;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long jM18311getBottomCenterF1C5BW0 = getCursorRect().m18311getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m16548containsInclusiveUv8p0NA(rectVisibleBounds, jM18311getBottomCenterF1C5BW0);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m16435setStartTextLayoutPositionInWindowk4lQ0M(m16428getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    private final Function0<Unit> menuItem(boolean enabled, final TextToolbarState desiredState, final Function0<Unit> operation) {
        if (enabled) {
            return new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.menuItem.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    operation.invoke();
                    this.updateTextToolbarState(desiredState);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextChanges.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextFieldCharSequence invoke() {
                return TextFieldSelectionState.this.textFieldState.getVisualText();
            }
        }), C13763.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextChanges.4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((TextFieldCharSequence) obj, (Continuation<? super Unit>) continuation2);
            }

            @Nullable
            public final Object emit(@NotNull TextFieldCharSequence textFieldCharSequence, @NotNull Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Rect invoke() {
                Rect rectIntersect;
                boolean zM20450getCollapsedimpl = TextRange.m20450getCollapsedimpl(TextFieldSelectionState.this.textFieldState.getVisualText().getSelection());
                if (((!zM20450getCollapsedimpl || TextFieldSelectionState.this.getTextToolbarState() != TextToolbarState.Cursor) && (zM20450getCollapsedimpl || TextFieldSelectionState.this.getTextToolbarState() != TextToolbarState.Selection)) || TextFieldSelectionState.this.getDraggingHandle() != null || !TextFieldSelectionState.this.isInTouchMode()) {
                    return Rect.INSTANCE.getZero();
                }
                LayoutCoordinates textLayoutCoordinates = TextFieldSelectionState.this.getTextLayoutCoordinates();
                Rect rectVisibleBounds = textLayoutCoordinates != null ? SelectionManagerKt.visibleBounds(textLayoutCoordinates) : null;
                if (rectVisibleBounds == null) {
                    return Rect.INSTANCE.getZero();
                }
                LayoutCoordinates textLayoutCoordinates2 = TextFieldSelectionState.this.getTextLayoutCoordinates();
                Offset offsetM18273boximpl = textLayoutCoordinates2 != null ? Offset.m18273boximpl(textLayoutCoordinates2.mo19866localToRootMKHz9U(rectVisibleBounds.m18319getTopLeftF1C5BW0())) : null;
                Intrinsics.checkNotNull(offsetM18273boximpl);
                Rect rectM18324Recttz77jQw = RectKt.m18324Recttz77jQw(offsetM18273boximpl.getPackedValue(), rectVisibleBounds.m18317getSizeNHjbRc());
                Rect contentRect = TextFieldSelectionState.this.getContentRect();
                Rect rect = rectM18324Recttz77jQw.overlaps(contentRect) ? contentRect : null;
                return (rect == null || (rectIntersect = rect.intersect(rectM18324Recttz77jQw)) == null) ? Rect.INSTANCE.getZero() : rectIntersect;
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            @Nullable
            public final Object emit(@NotNull Rect rect, @NotNull Continuation<? super Unit> continuation2) {
                if (Intrinsics.areEqual(rect, Rect.INSTANCE.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    TextFieldSelectionState.this.showTextToolbar(rect);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    private final void pasteAsPlainText() {
        AnnotatedString text;
        String text2;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null || (text2 = text.getText()) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, text2, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeCursorAtNearestOffset-k-4lQ0M, reason: not valid java name */
    public final boolean m16433placeCursorAtNearestOffsetk4lQ0M(long offset) {
        int iM20428getOffsetForPositionk4lQ0M;
        int iM20456getStartimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (iM20428getOffsetForPositionk4lQ0M = layoutResult.m20428getOffsetForPositionk4lQ0M(offset)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long jM16397mapFromTransformedjx7JFs = transformedTextFieldState.m16397mapFromTransformedjx7JFs(iM20428getOffsetForPositionk4lQ0M);
        long jM16400mapToTransformedGEjPoXI = transformedTextFieldState.m16400mapToTransformedGEjPoXI(jM16397mapFromTransformedjx7JFs);
        int i = WhenMappings.$EnumSwitchMapping$0[((TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) && TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? IndexTransformationType.Untransformed : (TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) || TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? (!TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) || TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? IndexTransformationType.Deletion : IndexTransformationType.Insertion : IndexTransformationType.Replacement).ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity = null;
        if (i == 1 || i == 2) {
            iM20456getStartimpl = TextRange.m20456getStartimpl(jM16397mapFromTransformedjx7JFs);
        } else if (i == 3) {
            selectionWedgeAffinity = MathUtilsKt.m16345findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m20456getStartimpl(jM16400mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m20451getEndimpl(jM16400mapToTransformedGEjPoXI))) < 0 ? new SelectionWedgeAffinity(WedgeAffinity.Start) : new SelectionWedgeAffinity(WedgeAffinity.End);
            iM20456getStartimpl = TextRange.m20456getStartimpl(jM16397mapFromTransformedjx7JFs);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            iM20456getStartimpl = MathUtilsKt.m16345findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m20456getStartimpl(jM16400mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m20451getEndimpl(jM16400mapToTransformedGEjPoXI))) < 0 ? TextRange.m20456getStartimpl(jM16397mapFromTransformedjx7JFs) : TextRange.m20451getEndimpl(jM16397mapFromTransformedjx7JFs);
        }
        long jTextRange = TextRangeKt.TextRange(iM20456getStartimpl);
        if (TextRange.m20449equalsimpl0(jTextRange, this.textFieldState.getUntransformedText().getSelection()) && (selectionWedgeAffinity == null || Intrinsics.areEqual(selectionWedgeAffinity, this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m16403selectUntransformedCharsIn5zctL8(jTextRange);
        if (selectionWedgeAffinity != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity);
        }
        return true;
    }

    /* JADX INFO: renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m16434setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition.setValue(Offset.m18273boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M, reason: not valid java name */
    private final void m16435setStartTextLayoutPositionInWindowk4lQ0M(long j) {
        this.startTextLayoutPositionInWindow.setValue(Offset.m18273boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTextToolbar(Rect contentRect) {
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            boolean zCanCopy = canCopy();
            final TextToolbarState textToolbarState = TextToolbarState.None;
            Function0<Unit> function0 = !zCanCopy ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    TextFieldSelectionState.copy$default(this, false, 1, null);
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState);
                }
            };
            Function0<Unit> function02 = !canPaste() ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    this.paste();
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState);
                }
            };
            Function0<Unit> function03 = !canCut() ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    this.cut();
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState);
                }
            };
            boolean zCanSelectAll = canSelectAll();
            final TextToolbarState textToolbarState2 = TextToolbarState.Selection;
            textToolbar.showMenu(contentRect, function0, function02, function03, zCanSelectAll ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    this.selectAll();
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState2);
                }
            } : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateSelection-SsL-Rf8, reason: not valid java name */
    public final long m16436updateSelectionSsLRf8(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed, boolean isStartOfSelection) {
        HapticFeedback hapticFeedback;
        TextRange textRangeM20444boximpl = TextRange.m20444boximpl(textFieldCharSequence.getSelection());
        long packedValue = textRangeM20444boximpl.getPackedValue();
        if (isStartOfSelection || (!allowPreviousSelectionCollapsed && TextRange.m20450getCollapsedimpl(packedValue))) {
            textRangeM20444boximpl = null;
        }
        long jM16432getTextFieldSelectionqeG_v_k = m16432getTextFieldSelectionqeG_v_k(startOffset, endOffset, textRangeM20444boximpl, isStartHandle, adjustment);
        if (!TextRange.m20449equalsimpl0(jM16432getTextFieldSelectionqeG_v_k, textFieldCharSequence.getSelection())) {
            boolean z = TextRange.m20455getReversedimpl(jM16432getTextFieldSelectionqeG_v_k) != TextRange.m20455getReversedimpl(textFieldCharSequence.getSelection()) && TextRange.m20449equalsimpl0(TextRangeKt.TextRange(TextRange.m20451getEndimpl(jM16432getTextFieldSelectionqeG_v_k), TextRange.m20456getStartimpl(jM16432getTextFieldSelectionqeG_v_k)), textFieldCharSequence.getSelection());
            if (isInTouchMode() && !z && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo19247performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m19256getTextHandleMove5zf0vsI());
            }
        }
        return jM16432getTextFieldSelectionqeG_v_k;
    }

    /* JADX INFO: renamed from: updateSelection-SsL-Rf8$default, reason: not valid java name */
    public static /* synthetic */ long m16437updateSelectionSsLRf8$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            z2 = false;
        }
        if ((i4 & 64) != 0) {
            z3 = false;
        }
        return textFieldSelectionState.m16436updateSelectionSsLRf8(textFieldCharSequence, i, i2, z, selectionAdjustment, z2, z3);
    }

    public final boolean canCopy() {
        return (TextRange.m20450getCollapsedimpl(this.textFieldState.getVisualText().getSelection()) || this.isPassword) ? false : true;
    }

    public final boolean canCut() {
        return (TextRange.m20450getCollapsedimpl(this.textFieldState.getVisualText().getSelection()) || !getEditable() || this.isPassword) ? false : true;
    }

    public final boolean canPaste() {
        if (!getEditable()) {
            return false;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null && clipboardManager.hasText()) {
            return true;
        }
        Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
        if ((function0 != null ? function0.invoke() : null) != null) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if ((clipboardManager2 != null ? clipboardManager2.getClip() : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean canSelectAll() {
        return TextRange.m20452getLengthimpl(this.textFieldState.getVisualText().getSelection()) != this.textFieldState.getVisualText().length();
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        Offset.Companion companion = Offset.INSTANCE;
        m16434setRawHandleDragPositionk4lQ0M(companion.m18299getUnspecifiedF1C5BW0());
        m16435setStartTextLayoutPositionInWindowk4lQ0M(companion.m18299getUnspecifiedF1C5BW0());
    }

    public final void copy(boolean cancelSelection) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m20450getCollapsedimpl(visualText.getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), null, null, 6, null));
        }
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
    }

    @Nullable
    public final Object cursorHandleGestures(@NotNull PointerInputScope pointerInputScope, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C13562(pointerInputScope, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final void cut() {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m20450getCollapsedimpl(visualText.getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), null, null, 6, null));
        }
        this.textFieldState.deleteSelectedText();
    }

    public final void deselect() {
        if (!TextRange.m20450getCollapsedimpl(this.textFieldState.getVisualText().getSelection())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    @Nullable
    public final Object detectTextFieldTapGestures(@NotNull PointerInputScope pointerInputScope, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function0<Unit> function0, @NotNull final Function0<Unit> function02, @NotNull Continuation<? super Unit> continuation) {
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new C13682(mutableInteractionSource, this, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m16451invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m16451invokek4lQ0M(long j) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3.1
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                if (this.enabled && this.getIsFocused()) {
                    if (!this.readOnly) {
                        function02.invoke();
                        if (this.textFieldState.getVisualText().length() > 0) {
                            this.setShowCursorHandle(true);
                        }
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    long jM16383coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release = this.textLayoutState.m16383coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j);
                    TextFieldSelectionState textFieldSelectionState = this;
                    textFieldSelectionState.m16433placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m16390fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.textLayoutState, jM16383coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release));
                }
            }
        }, continuation);
        return objDetectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndPress : Unit.INSTANCE;
    }

    @Nullable
    public final Object detectTouchMode(@NotNull PointerInputScope pointerInputScope, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C13712(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    @NotNull
    public final TextFieldHandleState getCursorHandleState$foundation_release(boolean includePosition) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (showCursorHandle && z && TextRange.m20450getCollapsedimpl(visualText.getSelection()) && visualText.shouldShowSelection() && visualText.length() > 0 && (draggingHandle == Handle.Cursor || isCursorHandleInVisibleBounds())) {
            return new TextFieldHandleState(true, includePosition ? getCursorRect().m18311getBottomCenterF1C5BW0() : Offset.INSTANCE.m18299getUnspecifiedF1C5BW0(), ResolvedTextDirection.Ltr, false, null);
        }
        return TextFieldHandleState.INSTANCE.getHidden();
    }

    @NotNull
    public final Rect getCursorRect() {
        float right;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.INSTANCE.getZero();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.m20450getCollapsedimpl(visualText.getSelection())) {
            return Rect.INSTANCE.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.m20456getStartimpl(visualText.getSelection()));
        float fMo15546toPx0680j_4 = this.density.mo15546toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            right = (fMo15546toPx0680j_4 / 2) + cursorRect.getLeft();
        } else {
            right = cursorRect.getRight() - (fMo15546toPx0680j_4 / 2);
        }
        float f = fMo15546toPx0680j_4 / 2;
        float fCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, IntSize.m21138getWidthimpl(layoutResult.getSize()) - f), f);
        return new Rect(fCoerceAtLeast - f, cursorRect.getTop(), fCoerceAtLeast + f, cursorRect.getBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX INFO: renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m16438getHandleDragPositionF1C5BW0() {
        return OffsetKt.m18305isUnspecifiedk4lQ0M(m16430getRawHandleDragPositionF1C5BW0()) ? Offset.INSTANCE.m18299getUnspecifiedF1C5BW0() : OffsetKt.m18305isUnspecifiedk4lQ0M(m16431getStartTextLayoutPositionInWindowF1C5BW0()) ? TextLayoutStateKt.m16390fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m16430getRawHandleDragPositionF1C5BW0()) : Offset.m18289plusMKHz9U(m16430getRawHandleDragPositionF1C5BW0(), Offset.m18288minusMKHz9U(m16431getStartTextLayoutPositionInWindowF1C5BW0(), m16428getCurrentTextLayoutPositionInWindowF1C5BW0()));
    }

    @Nullable
    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TextFieldHandleState getSelectionHandleState$foundation_release(boolean isStartHandle, boolean includePosition) {
        boolean z;
        Rect rectVisibleBounds;
        Rect rectVisibleBounds2;
        Handle handle = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        if (TextRange.m20450getCollapsedimpl(selection)) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long jM16429getHandlePositiontuRUvjQ = m16429getHandlePositiontuRUvjQ(isStartHandle);
        if (getDirectDragGestureInitiator() != InputType.None) {
            z = false;
        } else {
            if (getDraggingHandle() != handle) {
                LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
                if ((textLayoutCoordinates == null || (rectVisibleBounds2 = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m16548containsInclusiveUv8p0NA(rectVisibleBounds2, jM16429getHandlePositiontuRUvjQ)) {
                }
            }
            z = true;
        }
        if (!z) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        if (!this.textFieldState.getVisualText().shouldShowSelection()) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(isStartHandle ? TextRange.m20456getStartimpl(selection) : Math.max(TextRange.m20451getEndimpl(selection) - 1, 0));
        boolean zM20455getReversedimpl = TextRange.m20455getReversedimpl(selection);
        if (includePosition) {
            LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
            if (textLayoutCoordinates2 != null && (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
                jM16429getHandlePositiontuRUvjQ = TextLayoutStateKt.m16389coerceIn3MmeM6k(jM16429getHandlePositiontuRUvjQ, rectVisibleBounds);
            }
        } else {
            jM16429getHandlePositiontuRUvjQ = Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
        }
        return new TextFieldHandleState(true, jM16429getHandlePositiontuRUvjQ, bidiRunDirection, zM20455getReversedimpl, null);
    }

    /* JADX INFO: renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observeChanges(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        C13731 c13731;
        TextFieldSelectionState textFieldSelectionState;
        if (continuation instanceof C13731) {
            c13731 = (C13731) continuation;
            int i = c13731.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13731.label = i - Integer.MIN_VALUE;
            } else {
                c13731 = new C13731(continuation);
            }
        }
        Object obj = c13731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13731.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            textFieldSelectionState = (TextFieldSelectionState) c13731.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                textFieldSelectionState.setShowCursorHandle(false);
                if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                    textFieldSelectionState.hideTextToolbar();
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                textFieldSelectionState.setShowCursorHandle(false);
                if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            C13742 c13742 = new C13742(null);
            c13731.L$0 = this;
            c13731.label = 1;
            if (CoroutineScopeKt.coroutineScope(c13742, c13731) == coroutine_suspended) {
                return coroutine_suspended;
            }
            textFieldSelectionState = this;
            textFieldSelectionState.setShowCursorHandle(false);
            if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            textFieldSelectionState = this;
            textFieldSelectionState.setShowCursorHandle(false);
            if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                textFieldSelectionState.hideTextToolbar();
            }
            throw th;
        }
    }

    public final void paste() {
        ReceiveContentConfiguration receiveContentConfigurationInvoke;
        ClipEntry clip;
        ClipEntry clipEntry;
        String plainText;
        Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
        if (function0 == null || (receiveContentConfigurationInvoke = function0.invoke()) == null) {
            pasteAsPlainText();
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (clip = clipboardManager.getClip()) == null) {
            pasteAsPlainText();
            return;
        }
        TransferableContent transferableContentOnReceive = receiveContentConfigurationInvoke.getReceiveContentListener().onReceive(new TransferableContent(clip, clip.getClipMetadata(), TransferableContent.Source.INSTANCE.m15509getClipboardkB6V9T0(), null, 8, null));
        if (transferableContentOnReceive == null || (clipEntry = transferableContentOnReceive.getClipEntry()) == null || (plainText = TransferableContent_androidKt.readPlainText(clipEntry)) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, plainText, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    @Nullable
    public final Object selectionHandleGestures(@NotNull PointerInputScope pointerInputScope, boolean z, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C13802(pointerInputScope, z, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final void setDirectDragGestureInitiator(@NotNull InputType inputType) {
        this.directDragGestureInitiator.setValue(inputType);
    }

    public final void setDraggingHandle(@Nullable Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    public final void setReceiveContentConfiguration(@Nullable Function0<? extends ReceiveContentConfiguration> function0) {
        this.receiveContentConfiguration = function0;
    }

    @Nullable
    public final Object textFieldSelectionGestures(@NotNull PointerInputScope pointerInputScope, @NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) {
        Object objSelectionGesturePointerInputBtf2 = SelectionGesturesKt.selectionGesturePointerInputBtf2(pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return objSelectionGesturePointerInputBtf2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSelectionGesturePointerInputBtf2 : Unit.INSTANCE;
    }

    public final void update(@NotNull HapticFeedback hapticFeedBack, @NotNull ClipboardManager clipboardManager, @NotNull TextToolbar textToolbar, @NotNull Density density, boolean enabled, boolean readOnly, boolean isPassword) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isPassword = isPassword;
    }

    /* JADX INFO: renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m16439updateHandleDraggingUv8p0NA(@NotNull Handle handle, long position) {
        setDraggingHandle(handle);
        m16434setRawHandleDragPositionk4lQ0M(position);
    }

    public final void updateTextToolbarState(@NotNull TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0012J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "onCancel", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onDragStop", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTextFieldSelectionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextFieldSelectionState.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1542:1\n1#2:1543\n*E\n"})
    public final class TextFieldTextDragObserver implements TextDragObserver {

        @NotNull
        private Handle actingHandle;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition;
        private long dragTotalDistance;

        @NotNull
        private final Function0<Unit> requestFocus;

        public TextFieldTextDragObserver(@NotNull Function0<Unit> function0) {
            this.requestFocus = function0;
            Offset.Companion companion = Offset.INSTANCE;
            this.dragBeginPosition = companion.m18299getUnspecifiedF1C5BW0();
            this.dragTotalDistance = companion.m18300getZeroF1C5BW0();
            this.actingHandle = Handle.SelectionEnd;
        }

        private final void onDragStop() {
            if (OffsetKt.m18303isSpecifiedk4lQ0M(this.dragBeginPosition)) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDragStop$1
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "Touch.onDragStop";
                    }
                });
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                Offset.Companion companion = Offset.INSTANCE;
                this.dragBeginPosition = companion.m18299getUnspecifiedF1C5BW0();
                this.dragTotalDistance = companion.m18300getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onDrag-k-4lQ0M */
        public void mo16231onDragk4lQ0M(long delta) {
            int iIntValue;
            int iM16385getOffsetForPosition3MmeM6k;
            SelectionAdjustment word;
            Handle handle;
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return;
            }
            long jM18289plusMKHz9U = Offset.m18289plusMKHz9U(this.dragTotalDistance, delta);
            this.dragTotalDistance = jM18289plusMKHz9U;
            final long jM18289plusMKHz9U2 = Offset.m18289plusMKHz9U(this.dragBeginPosition, jM18289plusMKHz9U);
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "Touch.onDrag at " + ((Object) Offset.m18292toStringimpl(jM18289plusMKHz9U2));
                }
            });
            if (this.dragBeginOffsetInText >= 0 || TextFieldSelectionState.this.textLayoutState.m16386isPositionOnTextk4lQ0M(jM18289plusMKHz9U2)) {
                Integer numValueOf = Integer.valueOf(this.dragBeginOffsetInText);
                if (numValueOf.intValue() < 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m16385getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                iM16385getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m16385getOffsetForPosition3MmeM6k(jM18289plusMKHz9U2, false);
                if (this.dragBeginOffsetInText < 0 && iIntValue == iM16385getOffsetForPosition3MmeM6k) {
                    return;
                }
                word = SelectionAdjustment.INSTANCE.getWord();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            } else {
                iIntValue = TextLayoutState.m16382getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, this.dragBeginPosition, false, 2, null);
                iM16385getOffsetForPosition3MmeM6k = TextLayoutState.m16382getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, jM18289plusMKHz9U2, false, 2, null);
                word = iIntValue == iM16385getOffsetForPosition3MmeM6k ? SelectionAdjustment.INSTANCE.getNone() : SelectionAdjustment.INSTANCE.getWord();
            }
            int i = iIntValue;
            int i2 = iM16385getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment = word;
            long selection = TextFieldSelectionState.this.textFieldState.getVisualText().getSelection();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jM16437updateSelectionSsLRf8$default = TextFieldSelectionState.m16437updateSelectionSsLRf8$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), i, i2, false, selectionAdjustment, false, false, 64, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m20450getCollapsedimpl(jM16437updateSelectionSsLRf8$default)) {
                this.dragBeginOffsetInText = TextRange.m20456getStartimpl(jM16437updateSelectionSsLRf8$default);
            }
            if (TextRange.m20455getReversedimpl(jM16437updateSelectionSsLRf8$default)) {
                jM16437updateSelectionSsLRf8$default = TextFieldSelectionStateKt.m16453reverse5zctL8(jM16437updateSelectionSsLRf8$default);
            }
            if (!TextRange.m20449equalsimpl0(jM16437updateSelectionSsLRf8$default, selection)) {
                if (TextRange.m20456getStartimpl(jM16437updateSelectionSsLRf8$default) != TextRange.m20456getStartimpl(selection) && TextRange.m20451getEndimpl(jM16437updateSelectionSsLRf8$default) == TextRange.m20451getEndimpl(selection)) {
                    handle = Handle.SelectionStart;
                } else if (TextRange.m20456getStartimpl(jM16437updateSelectionSsLRf8$default) != TextRange.m20456getStartimpl(selection) || TextRange.m20451getEndimpl(jM16437updateSelectionSsLRf8$default) == TextRange.m20451getEndimpl(selection)) {
                    handle = ((float) (TextRange.m20451getEndimpl(jM16437updateSelectionSsLRf8$default) + TextRange.m20456getStartimpl(jM16437updateSelectionSsLRf8$default))) / 2.0f > ((float) (TextRange.m20451getEndimpl(selection) + TextRange.m20456getStartimpl(selection))) / 2.0f ? Handle.SelectionEnd : Handle.SelectionStart;
                } else {
                    handle = Handle.SelectionEnd;
                }
                this.actingHandle = handle;
            }
            if (TextRange.m20450getCollapsedimpl(selection) || !TextRange.m20450getCollapsedimpl(jM16437updateSelectionSsLRf8$default)) {
                TextFieldSelectionState.this.textFieldState.m16402selectCharsIn5zctL8(jM16437updateSelectionSsLRf8$default);
            }
            TextFieldSelectionState.this.m16439updateHandleDraggingUv8p0NA(this.actingHandle, jM18289plusMKHz9U2);
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onStart-k-4lQ0M */
        public void mo16232onStartk4lQ0M(final long startPoint) {
            if (TextFieldSelectionState.this.enabled) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onStart$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "Touch.onDragStart after longPress at " + ((Object) Offset.m18292toStringimpl(startPoint));
                    }
                });
                TextFieldSelectionState.this.m16439updateHandleDraggingUv8p0NA(this.actingHandle, startPoint);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = startPoint;
                this.dragTotalDistance = Offset.INSTANCE.m18300getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                if (!TextFieldSelectionState.this.textLayoutState.m16386isPositionOnTextk4lQ0M(startPoint)) {
                    int iM16382getOffsetForPosition3MmeM6k$default = TextLayoutState.m16382getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, startPoint, false, 2, null);
                    HapticFeedback hapticFeedback = TextFieldSelectionState.this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo19247performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m19256getTextHandleMove5zf0vsI());
                    }
                    TextFieldSelectionState.this.textFieldState.placeCursorBeforeCharAt(iM16382getOffsetForPosition3MmeM6k$default);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                if (TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                    return;
                }
                int iM16382getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m16382getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, startPoint, false, 2, null);
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                long jM16437updateSelectionSsLRf8$default = TextFieldSelectionState.m16437updateSelectionSsLRf8$default(textFieldSelectionState, new TextFieldCharSequence(textFieldSelectionState.textFieldState.getVisualText(), TextRange.INSTANCE.m20461getZerod9O1mEE(), null, null, 12, null), iM16382getOffsetForPosition3MmeM6k$default2, iM16382getOffsetForPosition3MmeM6k$default2, false, SelectionAdjustment.INSTANCE.getWord(), false, false, 96, null);
                TextFieldSelectionState.this.textFieldState.m16402selectCharsIn5zctL8(jM16437updateSelectionSsLRf8$default);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                this.dragBeginOffsetInText = TextRange.m20456getStartimpl(jM16437updateSelectionSsLRf8$default);
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onDown-k-4lQ0M */
        public void mo16230onDownk4lQ0M(long point) {
        }
    }
}
