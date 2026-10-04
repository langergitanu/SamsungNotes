package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p109ui.input.pointer.PointerId;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.PointerType;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0082Hø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\f\u001aa\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aY\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010\f\u001aM\u0010'\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)2\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u0019H\u0082Hø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aY\u0010-\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010$\u001a!\u0010/\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b0\u0010\f\u001aa\u00101\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b2\u0010 \u001aY\u00103\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b4\u0010$\u001a\u0080\u0001\u00105\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001aà\u0001\u00105\u001a\u00020\u001e*\u0002062K\u00107\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001e0>2!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0\u000f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e092\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0010092\b\u0010C\u001a\u0004\u0018\u00010)26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010E\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a\u0080\u0001\u0010F\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010G\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a\u0080\u0001\u0010H\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010I\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a3\u0010J\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u0012\u001aS\u0010J\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0080Hø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a3\u0010O\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0012\u001a\u001e\u0010Q\u001a\u00020\u0010*\u00020R2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010U\u001a\u00020\u0005*\u00020V2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a3\u0010Y\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0012\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, m13886d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDragGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,964:1\n757#1,9:965\n766#1,4:983\n770#1,23:994\n713#1,4:1017\n717#1,2:1030\n719#1,8:1039\n757#1,9:1047\n766#1,4:1065\n770#1,23:1076\n757#1,9:1099\n766#1,4:1117\n770#1,23:1128\n671#1,6:1151\n713#1,4:1157\n717#1,2:1170\n719#1,7:1179\n677#1,7:1186\n726#1:1193\n684#1,12:1194\n713#1,4:1206\n717#1,2:1219\n719#1,8:1228\n757#1,9:1236\n766#1,4:1254\n770#1,23:1265\n757#1,9:1288\n766#1,4:1306\n770#1,23:1317\n671#1,6:1340\n713#1,4:1346\n717#1,2:1359\n719#1,7:1368\n677#1,7:1375\n726#1:1382\n684#1,12:1383\n713#1,4:1395\n717#1,2:1408\n719#1,8:1417\n713#1,4:1425\n717#1,2:1438\n719#1,8:1447\n713#1,4:1455\n717#1,2:1468\n719#1,8:1477\n116#2,2:974\n33#2,6:976\n118#2:982\n33#2,6:987\n118#2:993\n116#2,2:1021\n33#2,6:1023\n118#2:1029\n33#2,6:1032\n118#2:1038\n116#2,2:1056\n33#2,6:1058\n118#2:1064\n33#2,6:1069\n118#2:1075\n116#2,2:1108\n33#2,6:1110\n118#2:1116\n33#2,6:1121\n118#2:1127\n116#2,2:1161\n33#2,6:1163\n118#2:1169\n33#2,6:1172\n118#2:1178\n116#2,2:1210\n33#2,6:1212\n118#2:1218\n33#2,6:1221\n118#2:1227\n116#2,2:1245\n33#2,6:1247\n118#2:1253\n33#2,6:1258\n118#2:1264\n116#2,2:1297\n33#2,6:1299\n118#2:1305\n33#2,6:1310\n118#2:1316\n116#2,2:1350\n33#2,6:1352\n118#2:1358\n33#2,6:1361\n118#2:1367\n116#2,2:1399\n33#2,6:1401\n118#2:1407\n33#2,6:1410\n118#2:1416\n116#2,2:1429\n33#2,6:1431\n118#2:1437\n33#2,6:1440\n118#2:1446\n116#2,2:1459\n33#2,6:1461\n118#2:1467\n33#2,6:1470\n118#2:1476\n116#2,2:1485\n33#2,6:1487\n118#2:1493\n116#2,2:1494\n33#2,6:1496\n118#2:1502\n116#2,2:1503\n33#2,6:1505\n118#2:1511\n116#2,2:1512\n33#2,6:1514\n118#2:1520\n116#2,2:1521\n33#2,6:1523\n118#2:1529\n116#2,2:1530\n33#2,6:1532\n118#2:1538\n159#3:1539\n149#3:1540\n78#4:1541\n*S KotlinDebug\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt\n*L\n78#1:965,9\n78#1:983,4\n78#1:994,23\n142#1:1017,4\n142#1:1030,2\n142#1:1039,8\n376#1:1047,9\n376#1:1065,4\n376#1:1076,23\n387#1:1099,9\n387#1:1117,4\n387#1:1128,23\n413#1:1151,6\n413#1:1157,4\n413#1:1170,2\n413#1:1179,7\n413#1:1186,7\n413#1:1193\n413#1:1194,12\n443#1:1206,4\n443#1:1219,2\n443#1:1228,8\n527#1:1236,9\n527#1:1254,4\n527#1:1265,23\n538#1:1288,9\n538#1:1306,4\n538#1:1317,23\n561#1:1340,6\n561#1:1346,4\n561#1:1359,2\n561#1:1368,7\n561#1:1375,7\n561#1:1382\n561#1:1383,12\n591#1:1395,4\n591#1:1408,2\n591#1:1417,8\n676#1:1425,4\n676#1:1438,2\n676#1:1447,8\n676#1:1455,4\n676#1:1468,2\n676#1:1477,8\n78#1:974,2\n78#1:976,6\n78#1:982\n78#1:987,6\n78#1:993\n142#1:1021,2\n142#1:1023,6\n142#1:1029\n142#1:1032,6\n142#1:1038\n376#1:1056,2\n376#1:1058,6\n376#1:1064\n376#1:1069,6\n376#1:1075\n387#1:1108,2\n387#1:1110,6\n387#1:1116\n387#1:1121,6\n387#1:1127\n413#1:1161,2\n413#1:1163,6\n413#1:1169\n413#1:1172,6\n413#1:1178\n443#1:1210,2\n443#1:1212,6\n443#1:1218\n443#1:1221,6\n443#1:1227\n527#1:1245,2\n527#1:1247,6\n527#1:1253\n527#1:1258,6\n527#1:1264\n538#1:1297,2\n538#1:1299,6\n538#1:1305\n538#1:1310,6\n538#1:1316\n561#1:1350,2\n561#1:1352,6\n561#1:1358\n561#1:1361,6\n561#1:1367\n591#1:1399,2\n591#1:1401,6\n591#1:1407\n591#1:1410,6\n591#1:1416\n676#1:1429,2\n676#1:1431,6\n676#1:1437\n676#1:1440,6\n676#1:1446\n676#1:1459,2\n676#1:1461,6\n676#1:1467\n676#1:1470,6\n676#1:1476\n716#1:1485,2\n716#1:1487,6\n716#1:1493\n718#1:1494,2\n718#1:1496,6\n718#1:1502\n765#1:1503,2\n765#1:1505,6\n765#1:1511\n769#1:1512,2\n769#1:1514,6\n769#1:1520\n891#1:1521,2\n891#1:1523,6\n891#1:1529\n944#1:1530,2\n944#1:1532,6\n944#1:1538\n950#1:1539\n951#1:1540\n952#1:1541\n*E\n"})
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", m14021f = "DragGestureDetector.kt", m14022i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, m14023l = {247, 253, 972, 1014, 1025}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "orientation$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, m14026s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3", "L$4"})
    @SourceDebugExtension({"SMAP\nDragGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt$detectDragGestures$9\n+ 2 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,964:1\n757#2,9:965\n766#2,4:983\n770#2,23:994\n671#2,6:1017\n713#2,4:1023\n717#2,2:1036\n719#2,7:1045\n677#2,7:1052\n726#2:1059\n684#2,12:1060\n116#3,2:974\n33#3,6:976\n118#3:982\n33#3,6:987\n118#3:993\n116#3,2:1027\n33#3,6:1029\n118#3:1035\n33#3,6:1038\n118#3:1044\n*S KotlinDebug\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt$detectDragGestures$9\n*L\n259#1:965,9\n259#1:983,4\n259#1:994,23\n275#1:1017,6\n275#1:1023,4\n275#1:1036,2\n275#1:1045,7\n275#1:1052,7\n275#1:1059\n275#1:1060,12\n259#1:974,2\n259#1:976,6\n259#1:982\n259#1:987,6\n259#1:993\n275#1:1027,2\n275#1:1029,6\n275#1:1035\n275#1:1038,6\n275#1:1044\n*E\n"})
    public static final class C08759 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Orientation $orientationLock;
        final /* synthetic */ Ref.LongRef $overSlop;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08759(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super C08759> continuation) {
            super(2, continuation);
            this.$shouldAwaitTouchSlop = function0;
            this.$overSlop = longRef;
            this.$orientationLock = orientation;
            this.$onDragStart = function3;
            this.$onDrag = function2;
            this.$onDragCancel = function02;
            this.$onDragEnd = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08759 c08759 = new C08759(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            c08759.L$0 = obj;
            return c08759;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08759) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:124:0x02fb, code lost:
        
            if (((r2 != null ? r2 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.p109ui.geometry.Offset.m18285getYimpl(r7) : androidx.compose.p109ui.geometry.Offset.m18284getXimpl(r7) : androidx.compose.p109ui.geometry.Offset.m18282getDistanceimpl(r7)) == 0.0f) == false) goto L125;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00f9, code lost:
        
            if (r0 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x024e, code lost:
        
            if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m15597isPointerUpDmW0f2w(r2.getCurrentEvent(), r0) != false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0275, code lost:
        
            if (r10 != r6) goto L90;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:102:0x02b2, B:113:0x02db], limit reached: 134 */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0171 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0145 A[PHI: r0 r1 r2 r4 r5 r13 r14 r15
          0x0145: PHI (r0v9 float) = (r0v10 float), (r0v30 float) binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r1v8 androidx.compose.ui.input.pointer.PointerInputChange) = 
          (r1v10 androidx.compose.ui.input.pointer.PointerInputChange)
          (r1v26 androidx.compose.ui.input.pointer.PointerInputChange)
         binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r2v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r2v13 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r2v29 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r4v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r4v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r4v18 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r5v3 androidx.compose.foundation.gestures.TouchSlopDetector) = 
          (r5v4 androidx.compose.foundation.gestures.TouchSlopDetector)
          (r5v14 androidx.compose.foundation.gestures.TouchSlopDetector)
         binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r13v4 java.lang.Object) = (r13v9 java.lang.Object), (r13v20 java.lang.Object) binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r14v2 kotlin.jvm.internal.Ref$LongRef) = (r14v4 kotlin.jvm.internal.Ref$LongRef), (r14v16 kotlin.jvm.internal.Ref$LongRef) binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0145: PHI (r15v0 kotlin.jvm.internal.Ref$LongRef) = (r15v1 kotlin.jvm.internal.Ref$LongRef), (r15v10 kotlin.jvm.internal.Ref$LongRef) binds: [B:33:0x0141, B:13:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0209  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0218  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0224  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0111 -> B:76:0x0207). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x017b -> B:45:0x017d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x01cb -> B:76:0x0207). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x01f7 -> B:73:0x01fd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0275 -> B:90:0x0278). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object objAwaitFirstDown;
            Object objAwaitFirstDown$default;
            AwaitPointerEventScope awaitPointerEventScope2;
            boolean z;
            PointerInputChange pointerInputChange;
            PointerInputChange pointerInputChange2;
            long id;
            Function2<PointerInputChange, Offset, Unit> function2;
            Orientation orientation;
            Ref.LongRef longRef;
            Ref.LongRef longRef2;
            Object objAwaitPointerEvent$default;
            TouchSlopDetector touchSlopDetector;
            AwaitPointerEventScope awaitPointerEventScope3;
            float fM15598pointerSlopE8SPZFQ;
            PointerEvent pointerEvent;
            int size;
            int i;
            PointerEvent pointerEvent2;
            PointerInputChange pointerInputChange3;
            PointerInputChange pointerInputChange4;
            char c;
            PointerInputChange pointerInputChange5;
            PointerInputChange pointerInputChange6;
            PointerEvent pointerEvent3;
            PointerInputChange pointerInputChange7;
            PointerInputChange pointerInputChange8;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            char c2 = 4;
            int i4 = 3;
            int i5 = 1;
            PointerEventPass pointerEventPass = null;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, pointerEventPass2, this);
                if (objAwaitFirstDown != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitFirstDown = obj;
            } else if (i2 == 2) {
                z = this.Z$0;
                PointerInputChange pointerInputChange9 = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = pointerInputChange9;
                objAwaitFirstDown$default = obj;
                pointerInputChange2 = (PointerInputChange) objAwaitFirstDown$default;
                this.$overSlop.element = Offset.INSTANCE.m18300getZeroF1C5BW0();
            } else {
                if (i2 == 3) {
                    fM15598pointerSlopE8SPZFQ = this.F$0;
                    TouchSlopDetector touchSlopDetector2 = (TouchSlopDetector) this.L$5;
                    Ref.LongRef longRef3 = (Ref.LongRef) this.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) this.L$3;
                    AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$2;
                    PointerInputChange pointerInputChange10 = (PointerInputChange) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    longRef2 = longRef4;
                    awaitPointerEventScope3 = awaitPointerEventScope5;
                    longRef = longRef3;
                    awaitPointerEventScope2 = awaitPointerEventScope4;
                    touchSlopDetector = touchSlopDetector2;
                    pointerInputChange2 = pointerInputChange10;
                    objAwaitPointerEvent$default = obj;
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i = 0;
                    while (true) {
                        if (i < size) {
                        }
                        i++;
                        pointerEvent = pointerEvent2;
                    }
                    pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 != null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                        }
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = pointerInputChange2;
                        this.L$2 = awaitPointerEventScope2;
                        this.L$3 = longRef2;
                        this.L$4 = longRef;
                        this.L$5 = touchSlopDetector;
                        this.L$6 = pointerEventPass;
                        this.F$0 = fM15598pointerSlopE8SPZFQ;
                        this.label = i4;
                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, this, i5, pointerEventPass);
                        if (objAwaitPointerEvent$default != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    c = 4;
                    pointerInputChange = 0;
                    if (pointerInputChange != 0) {
                    }
                    if (pointerInputChange != 0) {
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.LongRef longRef5 = (Ref.LongRef) this.L$4;
                    AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$3;
                    Orientation orientation2 = (Orientation) this.L$2;
                    function2 = (Function2) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Object objAwaitPointerEvent$default2 = obj;
                    PointerEvent pointerEvent4 = (PointerEvent) objAwaitPointerEvent$default2;
                    List<PointerInputChange> changes2 = pointerEvent4.getChanges();
                    int size2 = changes2.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size2) {
                            pointerEvent3 = pointerEvent4;
                            pointerInputChange7 = null;
                            break;
                        }
                        pointerInputChange7 = changes2.get(i6);
                        pointerEvent3 = pointerEvent4;
                        if (PointerId.m19708equalsimpl0(pointerInputChange7.getId(), longRef5.element)) {
                            break;
                        }
                        i6++;
                        pointerEvent4 = pointerEvent3;
                    }
                    PointerInputChange pointerInputChange11 = pointerInputChange7;
                    if (pointerInputChange11 == null) {
                        pointerInputChange11 = null;
                    } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange11)) {
                        List<PointerInputChange> changes3 = pointerEvent3.getChanges();
                        int size3 = changes3.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size3) {
                                pointerInputChange8 = null;
                                break;
                            }
                            pointerInputChange8 = changes3.get(i7);
                            if (pointerInputChange8.getPressed()) {
                                break;
                            }
                            i7++;
                        }
                        PointerInputChange pointerInputChange12 = pointerInputChange8;
                        if (pointerInputChange12 != null) {
                            longRef5.element = pointerInputChange12.getId();
                            this.L$0 = awaitPointerEventScope7;
                            this.L$1 = function2;
                            this.L$2 = orientation2;
                            this.L$3 = awaitPointerEventScope6;
                            this.L$4 = longRef5;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.label = 5;
                            objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope6, null, this, 1, null);
                        }
                    } else {
                        long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange11);
                    }
                    if (pointerInputChange11 == null || pointerInputChange11.isConsumed()) {
                        pointerInputChange6 = null;
                    } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange11)) {
                        pointerInputChange6 = pointerInputChange11;
                    } else {
                        function2.invoke(pointerInputChange11, Offset.m18273boximpl(PointerEventKt.positionChange(pointerInputChange11)));
                        pointerInputChange11.consume();
                        id = pointerInputChange11.getId();
                        AwaitPointerEventScope awaitPointerEventScope8 = awaitPointerEventScope7;
                        orientation = orientation2;
                        awaitPointerEventScope2 = awaitPointerEventScope8;
                        Ref.LongRef longRef6 = new Ref.LongRef();
                        longRef6.element = id;
                        awaitPointerEventScope6 = awaitPointerEventScope2;
                        longRef5 = longRef6;
                        orientation2 = orientation;
                        awaitPointerEventScope7 = awaitPointerEventScope6;
                        this.L$0 = awaitPointerEventScope7;
                        this.L$1 = function2;
                        this.L$2 = orientation2;
                        this.L$3 = awaitPointerEventScope6;
                        this.L$4 = longRef5;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.label = 5;
                        objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope6, null, this, 1, null);
                    }
                    if (pointerInputChange6 == null) {
                        this.$onDragCancel.invoke();
                    } else {
                        this.$onDragEnd.invoke(pointerInputChange6);
                    }
                    return Unit.INSTANCE;
                }
                fM15598pointerSlopE8SPZFQ = this.F$0;
                PointerInputChange pointerInputChange13 = (PointerInputChange) this.L$6;
                TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) this.L$5;
                Ref.LongRef longRef7 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef8 = (Ref.LongRef) this.L$3;
                AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) this.L$2;
                PointerInputChange pointerInputChange14 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                longRef = longRef7;
                awaitPointerEventScope3 = awaitPointerEventScope10;
                Ref.LongRef longRef9 = longRef8;
                c = 4;
                touchSlopDetector = touchSlopDetector3;
                awaitPointerEventScope2 = awaitPointerEventScope9;
                if (!pointerInputChange13.isConsumed()) {
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    pointerInputChange2 = pointerInputChange14;
                    pointerInputChange = 0;
                    if (pointerInputChange != 0 && !pointerInputChange.isConsumed()) {
                        c2 = c;
                        i4 = 3;
                        i5 = 1;
                        pointerEventPass = null;
                        long id2 = pointerInputChange2.getId();
                        int type = pointerInputChange2.getType();
                        Orientation orientation3 = this.$orientationLock;
                        longRef2 = this.$overSlop;
                        if (!DragGestureDetectorKt.m15597isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id2)) {
                            c = c2;
                            pointerInputChange = pointerEventPass;
                            if (pointerInputChange != 0) {
                                c2 = c;
                                i4 = 3;
                                i5 = 1;
                                pointerEventPass = null;
                                long id22 = pointerInputChange2.getId();
                                int type2 = pointerInputChange2.getType();
                                Orientation orientation32 = this.$orientationLock;
                                longRef2 = this.$overSlop;
                                if (!DragGestureDetectorKt.m15597isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id22)) {
                                    fM15598pointerSlopE8SPZFQ = DragGestureDetectorKt.m15598pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), type2);
                                    longRef = new Ref.LongRef();
                                    longRef.element = id22;
                                    touchSlopDetector = new TouchSlopDetector(orientation32);
                                    awaitPointerEventScope3 = awaitPointerEventScope2;
                                    this.L$0 = awaitPointerEventScope3;
                                    this.L$1 = pointerInputChange2;
                                    this.L$2 = awaitPointerEventScope2;
                                    this.L$3 = longRef2;
                                    this.L$4 = longRef;
                                    this.L$5 = touchSlopDetector;
                                    this.L$6 = pointerEventPass;
                                    this.F$0 = fM15598pointerSlopE8SPZFQ;
                                    this.label = i4;
                                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, this, i5, pointerEventPass);
                                    if (objAwaitPointerEvent$default != coroutine_suspended) {
                                        pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                                        List<PointerInputChange> changes4 = pointerEvent.getChanges();
                                        size = changes4.size();
                                        i = 0;
                                        while (true) {
                                            if (i < size) {
                                                pointerEvent2 = pointerEvent;
                                                pointerInputChange3 = null;
                                                break;
                                            }
                                            pointerInputChange3 = changes4.get(i);
                                            pointerEvent2 = pointerEvent;
                                            if (PointerId.m19708equalsimpl0(pointerInputChange3.getId(), longRef.element)) {
                                                break;
                                            }
                                            i++;
                                            pointerEvent = pointerEvent2;
                                        }
                                        pointerInputChange4 = pointerInputChange3;
                                        if (pointerInputChange4 != null && !pointerInputChange4.isConsumed()) {
                                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                                                List<PointerInputChange> changes5 = pointerEvent2.getChanges();
                                                int size4 = changes5.size();
                                                int i8 = 0;
                                                while (true) {
                                                    if (i8 >= size4) {
                                                        pointerInputChange5 = null;
                                                        break;
                                                    }
                                                    pointerInputChange5 = changes5.get(i8);
                                                    if (pointerInputChange5.getPressed()) {
                                                        break;
                                                    }
                                                    i8++;
                                                }
                                                PointerInputChange pointerInputChange15 = pointerInputChange5;
                                                if (pointerInputChange15 != null) {
                                                    longRef.element = pointerInputChange15.getId();
                                                    i4 = 3;
                                                    i5 = 1;
                                                    pointerEventPass = null;
                                                }
                                            } else {
                                                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector.m15677addPointerInputChangeGcwITfU(pointerInputChange4, fM15598pointerSlopE8SPZFQ);
                                                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                                                    long packedValue = offsetM15677addPointerInputChangeGcwITfU.getPackedValue();
                                                    pointerInputChange4.consume();
                                                    longRef2.element = packedValue;
                                                    if (pointerInputChange4.isConsumed()) {
                                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                                        pointerInputChange = pointerInputChange4;
                                                        c = 4;
                                                        if (pointerInputChange != 0) {
                                                        }
                                                    } else {
                                                        touchSlopDetector.reset();
                                                        i4 = 3;
                                                        i5 = 1;
                                                        pointerEventPass = null;
                                                    }
                                                } else {
                                                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                                    this.L$0 = awaitPointerEventScope3;
                                                    this.L$1 = pointerInputChange2;
                                                    this.L$2 = awaitPointerEventScope2;
                                                    this.L$3 = longRef2;
                                                    this.L$4 = longRef;
                                                    this.L$5 = touchSlopDetector;
                                                    this.L$6 = pointerInputChange4;
                                                    this.F$0 = fM15598pointerSlopE8SPZFQ;
                                                    c = 4;
                                                    this.label = 4;
                                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, this) != coroutine_suspended) {
                                                        Ref.LongRef longRef10 = longRef2;
                                                        pointerInputChange14 = pointerInputChange2;
                                                        pointerInputChange13 = pointerInputChange4;
                                                        longRef9 = longRef10;
                                                        if (!pointerInputChange13.isConsumed()) {
                                                            pointerInputChange2 = pointerInputChange14;
                                                            i4 = 3;
                                                            i5 = 1;
                                                            pointerEventPass = null;
                                                            longRef2 = longRef9;
                                                        }
                                                    }
                                                }
                                            }
                                            this.L$0 = awaitPointerEventScope3;
                                            this.L$1 = pointerInputChange2;
                                            this.L$2 = awaitPointerEventScope2;
                                            this.L$3 = longRef2;
                                            this.L$4 = longRef;
                                            this.L$5 = touchSlopDetector;
                                            this.L$6 = pointerEventPass;
                                            this.F$0 = fM15598pointerSlopE8SPZFQ;
                                            this.label = i4;
                                            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, this, i5, pointerEventPass);
                                            if (objAwaitPointerEvent$default != coroutine_suspended) {
                                            }
                                        }
                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                        c = 4;
                                        pointerInputChange = 0;
                                        if (pointerInputChange != 0) {
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    if (pointerInputChange != 0) {
                        this.$onDragStart.invoke(pointerInputChange2, pointerInputChange, Offset.m18273boximpl(this.$overSlop.element));
                        this.$onDrag.invoke(pointerInputChange, Offset.m18273boximpl(this.$overSlop.element));
                        id = pointerInputChange.getId();
                        function2 = this.$onDrag;
                        orientation = this.$orientationLock;
                    }
                    return Unit.INSTANCE;
                }
            }
            PointerInputChange pointerInputChange16 = (PointerInputChange) objAwaitFirstDown;
            boolean zBooleanValue = this.$shouldAwaitTouchSlop.invoke().booleanValue();
            if (!zBooleanValue) {
                pointerInputChange16.consume();
            }
            this.L$0 = awaitPointerEventScope;
            this.L$1 = pointerInputChange16;
            this.Z$0 = zBooleanValue;
            this.label = 2;
            objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 2, null);
            if (objAwaitFirstDown$default != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                z = zBooleanValue;
                pointerInputChange = pointerInputChange16;
                pointerInputChange2 = (PointerInputChange) objAwaitFirstDown$default;
                this.$overSlop.element = Offset.INSTANCE.m18300getZeroF1C5BW0();
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", m14021f = "DragGestureDetector.kt", m14022i = {0, 1, 2}, m14023l = {323, 324, 329}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, m14026s = {"L$0", "L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nDragGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt$detectDragGesturesAfterLongPress$5\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,964:1\n33#2,6:965\n*S KotlinDebug\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt$detectDragGesturesAfterLongPress$5\n*L\n335#1:965,6\n*E\n"})
    public static final class C08795 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08795(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super C08795> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08795 c08795 = new C08795(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
            c08795.L$0 = obj;
            return c08795;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08795) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: CancellationException -> 0x00b3, PHI: r1 r8 r12
          0x0064: PHI (r1v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r1v4 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r1v9 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:16:0x002f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE]
          0x0064: PHI (r8v6 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) = 
          (r8v2 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5)
          (r8v7 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5)
         binds: [B:16:0x002f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE]
          0x0064: PHI (r12v12 java.lang.Object) = (r12v0 java.lang.Object), (r12v18 java.lang.Object) binds: [B:16:0x002f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {CancellationException -> 0x00b3, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a3, B:42:0x00af, B:45:0x00b6, B:46:0x00b9, B:47:0x00bf, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[Catch: CancellationException -> 0x00b3, TryCatch #2 {CancellationException -> 0x00b3, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a3, B:42:0x00af, B:45:0x00b6, B:46:0x00b9, B:47:0x00bf, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0094 A[Catch: CancellationException -> 0x00b3, TryCatch #2 {CancellationException -> 0x00b3, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a3, B:42:0x00af, B:45:0x00b6, B:46:0x00b9, B:47:0x00bf, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00bf A[Catch: CancellationException -> 0x00b3, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x00b3, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a3, B:42:0x00af, B:45:0x00b6, B:46:0x00b9, B:47:0x00bf, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            CancellationException cancellationException;
            C08795 c08795;
            AwaitPointerEventScope awaitPointerEventScope;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                try {
                    this.L$0 = awaitPointerEventScope3;
                    this.label = 1;
                    c08795 = this;
                } catch (CancellationException e) {
                    e = e;
                    c08795 = this;
                }
                try {
                    obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, c08795, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope = awaitPointerEventScope3;
                    long id = ((PointerInputChange) obj).getId();
                    c08795.L$0 = awaitPointerEventScope;
                    c08795.label = 2;
                    obj = DragGestureDetectorKt.m15587awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (CancellationException e2) {
                    e = e2;
                    cancellationException = e;
                    c08795.$onDragCancel.invoke();
                    throw cancellationException;
                }
            }
            try {
                if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    c08795 = this;
                    long id2 = ((PointerInputChange) obj).getId();
                    c08795.L$0 = awaitPointerEventScope;
                    c08795.label = 2;
                    obj = DragGestureDetectorKt.m15587awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id2, this);
                    if (obj == coroutine_suspended) {
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 2) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    c08795 = this;
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                        c08795.$onDragStart.invoke(Offset.m18273boximpl(pointerInputChange.getPosition()));
                        long id3 = pointerInputChange.getId();
                        final Function2<PointerInputChange, Offset, Unit> function2 = c08795.$onDrag;
                        Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                invoke2(pointerInputChange2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                                function2.invoke(pointerInputChange2, Offset.m18273boximpl(PointerEventKt.positionChange(pointerInputChange2)));
                                pointerInputChange2.consume();
                            }
                        };
                        c08795.L$0 = awaitPointerEventScope;
                        c08795.label = 3;
                        obj = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id3, function1, this);
                        if (obj != coroutine_suspended) {
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            if (((Boolean) obj).booleanValue()) {
                            }
                        }
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    c08795 = this;
                    if (((Boolean) obj).booleanValue()) {
                        c08795.$onDragCancel.invoke();
                    } else {
                        List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        int size = changes.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            PointerInputChange pointerInputChange2 = changes.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                        }
                        c08795.$onDragEnd.invoke();
                    }
                }
            } catch (CancellationException e3) {
                cancellationException = e3;
                c08795 = this;
                c08795.$onDragCancel.invoke();
                throw cancellationException;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", m14021f = "DragGestureDetector.kt", m14022i = {0, 1, 1}, m14023l = {627, 629, 640}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m14026s = {"L$0", "L$0", "L$1"})
    public static final class C08835 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08835(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C08835> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onHorizontalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08835 c08835 = new C08835(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c08835.L$0 = obj;
            return c08835;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08835) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        
            if (r13 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            C08835 c08835;
            AwaitPointerEventScope awaitPointerEventScope;
            final Ref.FloatRef floatRef;
            C08835 c088352;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                c08835 = this;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, c08835, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    c088352 = this;
                    if (((Boolean) obj).booleanValue()) {
                        c088352.$onDragEnd.invoke();
                    } else {
                        c088352.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                }
                floatRef = (Ref.FloatRef) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                c088352 = this;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    c088352.$onDragStart.invoke(Offset.m18273boximpl(pointerInputChange.getPosition()));
                    c088352.$onHorizontalDrag.invoke(pointerInputChange, Boxing.boxFloat(floatRef.element));
                    long id = pointerInputChange.getId();
                    final Function2<PointerInputChange, Float, Unit> function2 = c088352.$onHorizontalDrag;
                    Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                            invoke2(pointerInputChange2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                            function2.invoke(pointerInputChange2, Float.valueOf(Offset.m18284getXimpl(PointerEventKt.positionChange(pointerInputChange2))));
                            pointerInputChange2.consume();
                        }
                    };
                    c088352.L$0 = null;
                    c088352.L$1 = null;
                    c088352.label = 3;
                    obj = DragGestureDetectorKt.m15596horizontalDragjO51t88(awaitPointerEventScope2, id, function1, this);
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            c08835 = this;
            awaitPointerEventScope = awaitPointerEventScope4;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            floatRef = new Ref.FloatRef();
            C08835 c088353 = c08835;
            long id2 = pointerInputChange2.getId();
            int type = pointerInputChange2.getType();
            Function2<PointerInputChange, Float, Unit> function22 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3, Float f) {
                    invoke(pointerInputChange3, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull PointerInputChange pointerInputChange3, float f) {
                    pointerInputChange3.consume();
                    floatRef.element = f;
                }
            };
            c088353.L$0 = awaitPointerEventScope;
            c088353.L$1 = floatRef;
            c088353.label = 2;
            obj = DragGestureDetectorKt.m15585awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, id2, type, function22, c088353);
            c088352 = c088353;
            if (obj != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", m14021f = "DragGestureDetector.kt", m14022i = {0, 1, 1}, m14023l = {479, 481, 489}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m14026s = {"L$0", "L$0", "L$1"})
    public static final class C08875 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08875(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C08875> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onVerticalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08875 c08875 = new C08875(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c08875.L$0 = obj;
            return c08875;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08875) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        
            if (r13 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            C08875 c08875;
            AwaitPointerEventScope awaitPointerEventScope;
            final Ref.FloatRef floatRef;
            C08875 c088752;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                c08875 = this;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, c08875, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    c088752 = this;
                    if (((Boolean) obj).booleanValue()) {
                        c088752.$onDragEnd.invoke();
                    } else {
                        c088752.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                }
                floatRef = (Ref.FloatRef) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                c088752 = this;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    c088752.$onDragStart.invoke(Offset.m18273boximpl(pointerInputChange.getPosition()));
                    c088752.$onVerticalDrag.invoke(pointerInputChange, Boxing.boxFloat(floatRef.element));
                    long id = pointerInputChange.getId();
                    final Function2<PointerInputChange, Float, Unit> function2 = c088752.$onVerticalDrag;
                    Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                            invoke2(pointerInputChange2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                            function2.invoke(pointerInputChange2, Float.valueOf(Offset.m18285getYimpl(PointerEventKt.positionChange(pointerInputChange2))));
                            pointerInputChange2.consume();
                        }
                    };
                    c088752.L$0 = null;
                    c088752.L$1 = null;
                    c088752.label = 3;
                    obj = DragGestureDetectorKt.m15599verticalDragjO51t88(awaitPointerEventScope2, id, function1, this);
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            c08875 = this;
            awaitPointerEventScope = awaitPointerEventScope4;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            floatRef = new Ref.FloatRef();
            C08875 c088753 = c08875;
            long id2 = pointerInputChange2.getId();
            int type = pointerInputChange2.getType();
            Function2<PointerInputChange, Float, Unit> function22 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3, Float f) {
                    invoke(pointerInputChange3, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull PointerInputChange pointerInputChange3, float f) {
                    pointerInputChange3.consume();
                    floatRef.element = f;
                }
            };
            c088753.L$0 = awaitPointerEventScope;
            c088753.L$1 = floatRef;
            c088753.label = 2;
            obj = DragGestureDetectorKt.m15591awaitVerticalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, id2, type, function22, c088753);
            c088752 = c088753;
            if (obj != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl((float) 0.125d);
        mouseSlop = fM20968constructorimpl;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(18);
        defaultTouchSlop = fM20968constructorimpl2;
        mouseToTouchSlopRatio = fM20968constructorimpl / fM20968constructorimpl2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
    
        if (androidx.compose.p109ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15582awaitDragOrCancellationrnUCldI(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            int i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i5 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i5);
                if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i5++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i4 >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i4);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i4++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i42 = 0;
                int i52 = 0;
                while (true) {
                    if (i52 < size3) {
                    }
                    i52++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m15583awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            int i = 0;
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange3 = null;
            Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.getId();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d4, code lost:
    
        if ((androidx.compose.p109ui.geometry.Offset.m18284getXimpl(androidx.compose.p109ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15584awaitHorizontalDragOrCancellationrnUCldI(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) continuation;
            int i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i4);
                if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i4++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i42 = 0;
                while (true) {
                    if (i42 < size3) {
                    }
                    i42++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x016b -> B:63:0x0171). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15585awaitHorizontalPointerSlopOrCancellationgDDlDlE(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, int i, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        float fM15598pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
        Ref.LongRef longRef2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i4;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            int i5 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
        int i7 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj3);
            Orientation orientation = Orientation.Horizontal;
            if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM15598pointerSlopE8SPZFQ = m15598pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            longRef = new Ref.LongRef();
            longRef.element = j;
            function22 = function2;
            touchSlopDetector = new TouchSlopDetector(orientation);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i6 == 1) {
            float f4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f4;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector3;
            function22 = function23;
            longRef2 = longRef3;
            DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2 = i4 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            pointerEventPass2 = pointerEventPass;
            i7 = 1;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i6 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f5 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector = touchSlopDetector4;
        pointerEventPass = null;
        fM15598pointerSlopE8SPZFQ = f5;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return pointerEventPass;
        }
        function22 = function24;
        pointerEventPass2 = pointerEventPass;
        i7 = 1;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i7;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i7, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            longRef2 = longRef;
            f = fM15598pointerSlopE8SPZFQ;
            DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i2);
                pointerEventPass = pointerEventPass2;
                i4 = i2;
                if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                    break;
                }
                i2 = i4 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i8);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i8++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef2.element = pointerInputChange3.getId();
                touchSlopDetector = touchSlopDetector2;
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132;
                fM15598pointerSlopE8SPZFQ = f;
                longRef = longRef2;
            } else {
                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector2.m15677addPointerInputChangeGcwITfU(pointerInputChange, f);
                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m18284getXimpl(offsetM15677addPointerInputChangeGcwITfU.getPackedValue())));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    touchSlopDetector2.reset();
                    touchSlopDetector = touchSlopDetector2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132;
                    fM15598pointerSlopE8SPZFQ = f;
                    longRef = longRef2;
                } else {
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.L$2 = longRef2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.F$0 = f;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132) != coroutine_suspended) {
                        function24 = function22;
                        touchSlopDetector = touchSlopDetector2;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$132;
                        pointerInputChange2 = pointerInputChange;
                        fM15598pointerSlopE8SPZFQ = f;
                        longRef = longRef2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            pointerEventPass2 = pointerEventPass;
            i7 = 1;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0170 -> B:62:0x0176). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15586awaitHorizontalTouchSlopOrCancellationjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
        float f;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.LongRef longRef2;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13;
        float f4;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) continuation;
            int i4 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label = i4 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
        int i6 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM19805getTouchT8wyACA = PointerType.INSTANCE.m19805getTouchT8wyACA();
            Orientation orientation = Orientation.Horizontal;
            if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            float fM15598pointerSlopE8SPZFQ = m15598pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM19805getTouchT8wyACA);
            longRef = new Ref.LongRef();
            longRef.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation);
            function22 = function2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
            f = fM15598pointerSlopE8SPZFQ;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            float f5 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f4 = f5;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector4;
            function22 = function23;
            longRef2 = longRef3;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (true) {
                if (i < size) {
                }
                i = i2 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            pointerEventPass2 = pointerEventPass;
            i6 = 1;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f6 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector = touchSlopDetector5;
        pointerEventPass = null;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        f = f6;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return pointerEventPass;
        }
        function22 = function24;
        pointerEventPass2 = pointerEventPass;
        i6 = 1;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i6;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i6, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            float f7 = f;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            longRef2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
            f4 = f7;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = i;
                if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                    break;
                }
                i = i2 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i7);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i7++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef2.element = pointerInputChange3.getId();
                touchSlopDetector = touchSlopDetector2;
                f = f4;
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13;
                longRef = longRef2;
            } else {
                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector2.m15677addPointerInputChangeGcwITfU(pointerInputChange, f4);
                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m18284getXimpl(offsetM15677addPointerInputChangeGcwITfU.getPackedValue())));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    touchSlopDetector2.reset();
                    touchSlopDetector = touchSlopDetector2;
                    f = f4;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13;
                    longRef = longRef2;
                } else {
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.L$2 = longRef2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.F$0 = f4;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13) != coroutine_suspended) {
                        function24 = function22;
                        touchSlopDetector = touchSlopDetector2;
                        f = f4;
                        pointerInputChange2 = pointerInputChange;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13;
                        longRef = longRef2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            pointerEventPass2 = pointerEventPass;
            i6 = 1;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    @Nullable
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15587awaitLongPressOrCancellationrnUCldI(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.ObjectRef objectRef;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            int i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
            pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return null;
            } catch (PointerEventTimeoutCancellationException unused) {
                PointerInputChange pointerInputChange3 = (PointerInputChange) objectRef.element;
                return pointerInputChange3 != null ? pointerInputChange2 : pointerInputChange3;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
        int size = changes.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i4);
            if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i4++;
        }
        pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 == 0) {
            return null;
        }
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = pointerInputChange2;
        long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
        try {
            DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(objectRef3, objectRef2, null);
            dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange2;
            dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef2;
            dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
            if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return null;
        } catch (PointerEventTimeoutCancellationException unused2) {
            objectRef = objectRef2;
            PointerInputChange pointerInputChange32 = (PointerInputChange) objectRef.element;
            if (pointerInputChange32 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m15588awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        int i2;
        PointerEvent pointerEvent;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM15598pointerSlopE8SPZFQ = m15598pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation);
        while (true) {
            int i4 = 0;
            InlineMarker.mark(0);
            int i5 = 1;
            Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent2.getChanges();
            int size = changes.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    i2 = i5;
                    pointerEvent = pointerEvent2;
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i6);
                i2 = i5;
                pointerEvent = pointerEvent2;
                if (Boolean.valueOf(PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i6++;
                i5 = i2;
                pointerEvent2 = pointerEvent;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
            } else {
                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector.m15677addPointerInputChangeGcwITfU(pointerInputChange3, fM15598pointerSlopE8SPZFQ);
                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                    function2.invoke(pointerInputChange3, offsetM15677addPointerInputChangeGcwITfU);
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    touchSlopDetector.reset();
                } else {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass, continuation);
                    InlineMarker.mark(i2);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0163 -> B:62:0x0169). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15589awaitTouchSlopOrCancellationjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function2<? super PointerInputChange, ? super Offset, Unit> function2, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
        float f;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.LongRef longRef2;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$13;
        float f4;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) continuation;
            int i4 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label = i4 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
        int i6 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM19805getTouchT8wyACA = PointerType.INSTANCE.m19805getTouchT8wyACA();
            if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            float fM15598pointerSlopE8SPZFQ = m15598pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM19805getTouchT8wyACA);
            Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.element = j;
            function22 = function2;
            longRef = longRef3;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
            f = fM15598pointerSlopE8SPZFQ;
            touchSlopDetector = new TouchSlopDetector(null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            float f5 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Offset, Unit> function23 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f4 = f5;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector3;
            function22 = function23;
            longRef2 = longRef4;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (true) {
                if (i < size) {
                }
                i = i2 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            pointerEventPass2 = pointerEventPass;
            i6 = 1;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f6 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector = touchSlopDetector4;
        pointerEventPass = null;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        f = f6;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return pointerEventPass;
        }
        function22 = function24;
        pointerEventPass2 = pointerEventPass;
        i6 = 1;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i6;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i6, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            float f7 = f;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            longRef2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
            f4 = f7;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = i;
                if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                    break;
                }
                i = i2 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i7);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i7++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef2.element = pointerInputChange3.getId();
                touchSlopDetector = touchSlopDetector2;
                f = f4;
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$13;
                longRef = longRef2;
            } else {
                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector2.m15677addPointerInputChangeGcwITfU(pointerInputChange, f4);
                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                    function22.invoke(pointerInputChange, offsetM15677addPointerInputChangeGcwITfU);
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    touchSlopDetector2.reset();
                    touchSlopDetector = touchSlopDetector2;
                    f = f4;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$13;
                    longRef = longRef2;
                } else {
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.L$2 = longRef2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.F$0 = f4;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitTouchSlopOrCancellation$13) != coroutine_suspended) {
                        function24 = function22;
                        touchSlopDetector = touchSlopDetector2;
                        f = f4;
                        pointerInputChange2 = pointerInputChange;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$13;
                        longRef = longRef2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            pointerEventPass2 = pointerEventPass;
            i6 = 1;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d4, code lost:
    
        if ((androidx.compose.p109ui.geometry.Offset.m18285getYimpl(androidx.compose.p109ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15590awaitVerticalDragOrCancellationrnUCldI(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) continuation;
            int i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i4);
                if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i4++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i42 = 0;
                while (true) {
                    if (i42 < size3) {
                    }
                    i42++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x016b -> B:63:0x0171). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15591awaitVerticalPointerSlopOrCancellationgDDlDlE(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, int i, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        float fM15598pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
        Ref.LongRef longRef2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i4;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) continuation;
            int i5 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
        int i7 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj3);
            Orientation orientation = Orientation.Vertical;
            if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM15598pointerSlopE8SPZFQ = m15598pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            longRef = new Ref.LongRef();
            longRef.element = j;
            function22 = function2;
            touchSlopDetector = new TouchSlopDetector(orientation);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i6 == 1) {
            float f4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f4;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector3;
            function22 = function23;
            longRef2 = longRef3;
            DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2 = i4 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            pointerEventPass2 = pointerEventPass;
            i7 = 1;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i6 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f5 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector = touchSlopDetector4;
        pointerEventPass = null;
        fM15598pointerSlopE8SPZFQ = f5;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return pointerEventPass;
        }
        function22 = function24;
        pointerEventPass2 = pointerEventPass;
        i7 = 1;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i7;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i7, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            longRef2 = longRef;
            f = fM15598pointerSlopE8SPZFQ;
            DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i2);
                pointerEventPass = pointerEventPass2;
                i4 = i2;
                if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                    break;
                }
                i2 = i4 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i8);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i8++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef2.element = pointerInputChange3.getId();
                touchSlopDetector = touchSlopDetector2;
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132;
                fM15598pointerSlopE8SPZFQ = f;
                longRef = longRef2;
            } else {
                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector2.m15677addPointerInputChangeGcwITfU(pointerInputChange, f);
                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m18285getYimpl(offsetM15677addPointerInputChangeGcwITfU.getPackedValue())));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    touchSlopDetector2.reset();
                    touchSlopDetector = touchSlopDetector2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132;
                    fM15598pointerSlopE8SPZFQ = f;
                    longRef = longRef2;
                } else {
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.L$2 = longRef2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.F$0 = f;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132) != coroutine_suspended) {
                        function24 = function22;
                        touchSlopDetector = touchSlopDetector2;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$132;
                        pointerInputChange2 = pointerInputChange;
                        fM15598pointerSlopE8SPZFQ = f;
                        longRef = longRef2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            pointerEventPass2 = pointerEventPass;
            i7 = 1;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM15598pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0170 -> B:62:0x0176). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15592awaitVerticalTouchSlopOrCancellationjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
        float f;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.LongRef longRef2;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13;
        float f4;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) continuation;
            int i4 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label = i4 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
        int i6 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM19805getTouchT8wyACA = PointerType.INSTANCE.m19805getTouchT8wyACA();
            Orientation orientation = Orientation.Vertical;
            if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            float fM15598pointerSlopE8SPZFQ = m15598pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM19805getTouchT8wyACA);
            longRef = new Ref.LongRef();
            longRef.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation);
            function22 = function2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
            f = fM15598pointerSlopE8SPZFQ;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            float f5 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f4 = f5;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
            touchSlopDetector2 = touchSlopDetector4;
            function22 = function23;
            longRef2 = longRef3;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (true) {
                if (i < size) {
                }
                i = i2 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            pointerEventPass2 = pointerEventPass;
            i6 = 1;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f6 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector = touchSlopDetector5;
        pointerEventPass = null;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        f = f6;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return pointerEventPass;
        }
        function22 = function24;
        pointerEventPass2 = pointerEventPass;
        i6 = 1;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i6;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i6, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            float f7 = f;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            longRef2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
            f4 = f7;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = i;
                if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                    break;
                }
                i = i2 + 1;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i7);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i7++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef2.element = pointerInputChange3.getId();
                touchSlopDetector = touchSlopDetector2;
                f = f4;
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13;
                longRef = longRef2;
            } else {
                Offset offsetM15677addPointerInputChangeGcwITfU = touchSlopDetector2.m15677addPointerInputChangeGcwITfU(pointerInputChange, f4);
                if (offsetM15677addPointerInputChangeGcwITfU != null) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m18285getYimpl(offsetM15677addPointerInputChangeGcwITfU.getPackedValue())));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    touchSlopDetector2.reset();
                    touchSlopDetector = touchSlopDetector2;
                    f = f4;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13;
                    longRef = longRef2;
                } else {
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.L$2 = longRef2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.F$0 = f4;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13) != coroutine_suspended) {
                        function24 = function22;
                        touchSlopDetector = touchSlopDetector2;
                        f = f4;
                        pointerInputChange2 = pointerInputChange;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13;
                        longRef = longRef2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            pointerEventPass2 = pointerEventPass;
            i6 = 1;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i6, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    @Nullable
    public static final Object detectDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull final Function1<? super Offset, Unit> function1, @NotNull final Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function2<? super PointerInputChange, ? super Offset, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objDetectDragGestures = detectDragGestures(pointerInputScope, new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                m15601invoke0AR0LA0(pointerInputChange, pointerInputChange2, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-0AR0LA0, reason: not valid java name */
            public final void m15601invoke0AR0LA0(@NotNull PointerInputChange pointerInputChange, @NotNull PointerInputChange pointerInputChange2, long j) {
                function1.invoke(Offset.m18273boximpl(pointerInputChange2.getPosition()));
            }
        }, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                invoke2(pointerInputChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PointerInputChange pointerInputChange) {
                function0.invoke();
            }
        }, function02, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        }, null, function2, continuation);
        return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m15600invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m15600invokek4lQ0M(long j) {
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    @Nullable
    public static final Object detectDragGesturesAfterLongPress(@NotNull PointerInputScope pointerInputScope, @NotNull Function1<? super Offset, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function2<? super PointerInputChange, ? super Offset, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C08795(function1, function0, function02, function2, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m15602invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m15602invokek4lQ0M(long j) {
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    @Nullable
    public static final Object detectHorizontalDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull Function1<? super Offset, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C08835(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m15603invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m15603invokek4lQ0M(long j) {
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    @Nullable
    public static final Object detectVerticalDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull Function1<? super Offset, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C08875(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m15604invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m15604invokek4lQ0M(long j) {
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x011a, code lost:
    
        if (((r3 != null ? r3 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.p109ui.geometry.Offset.m18285getYimpl(r4) : androidx.compose.p109ui.geometry.Offset.m18284getXimpl(r4) : androidx.compose.p109ui.geometry.Offset.m18282getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00d0, B:46:0x00fa], limit reached: 69 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008d -> B:23:0x0093). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15593dragVnAYq1g(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function1<? super PointerInputChange, Unit> function1, @Nullable Orientation orientation, @NotNull Function1<? super PointerInputChange, Boolean> function12, @NotNull Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$2;
        long id;
        AwaitPointerEventScope awaitPointerEventScope2;
        Orientation orientation2;
        Function1<? super PointerInputChange, Boolean> function13;
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$22;
        Function1<? super PointerInputChange, Unit> function14;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object objAwaitPointerEvent$default;
        PointerEventPass pointerEventPass;
        Object obj;
        Object obj2;
        int i;
        if (continuation instanceof DragGestureDetectorKt$drag$2) {
            dragGestureDetectorKt$drag$2 = (DragGestureDetectorKt$drag$2) continuation;
            int i2 = dragGestureDetectorKt$drag$2.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$2.label = i2 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$drag$2 = new DragGestureDetectorKt$drag$2(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$drag$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = dragGestureDetectorKt$drag$2.label;
        int i5 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            id = j;
            if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                return null;
            }
            awaitPointerEventScope2 = awaitPointerEventScope;
            orientation2 = orientation;
            function13 = function12;
            dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
            function14 = function1;
            longRef = new Ref.LongRef();
            longRef.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$1 = function14;
            dragGestureDetectorKt$drag$22.L$2 = orientation2;
            dragGestureDetectorKt$drag$22.L$3 = function13;
            dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
            dragGestureDetectorKt$drag$22.L$5 = longRef;
            dragGestureDetectorKt$drag$22.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$drag$2.L$5;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$4;
            Function1<? super PointerInputChange, Boolean> function15 = (Function1) dragGestureDetectorKt$drag$2.L$3;
            Orientation orientation3 = (Orientation) dragGestureDetectorKt$drag$2.L$2;
            Function1<? super PointerInputChange, Unit> function16 = (Function1) dragGestureDetectorKt$drag$2.L$1;
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$0;
            ResultKt.throwOnFailure(obj3);
            dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
            function14 = function16;
            Ref.LongRef longRef3 = longRef2;
            orientation2 = orientation3;
            function13 = function15;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i6 = 0;
            while (true) {
                if (i6 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes.get(i6);
                pointerEventPass = pointerEventPass2;
                i = i6;
                if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef3.element)) {
                    break;
                }
                i6 = i + 1;
                pointerEventPass2 = pointerEventPass;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange == 0) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size2) {
                            obj2 = pointerEventPass;
                            break;
                        }
                        obj2 = changes2.get(i7);
                        if (((PointerInputChange) obj2).getPressed()) {
                            break;
                        }
                        i7++;
                    }
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                    if (pointerInputChange2 != null) {
                        longRef3.element = pointerInputChange2.getId();
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        pointerEventPass2 = pointerEventPass;
                        i5 = 1;
                        longRef = longRef3;
                        dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$drag$22.L$1 = function14;
                        dragGestureDetectorKt$drag$22.L$2 = orientation2;
                        dragGestureDetectorKt$drag$22.L$3 = function13;
                        dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                        dragGestureDetectorKt$drag$22.L$5 = longRef;
                        dragGestureDetectorKt$drag$22.label = i5;
                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i5, pointerEventPass2);
                        if (objAwaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.LongRef longRef4 = longRef;
                        awaitPointerEventScope4 = awaitPointerEventScope2;
                        obj3 = objAwaitPointerEvent$default;
                        longRef3 = longRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj3;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i62 = 0;
                        while (true) {
                            if (i62 < size3) {
                            }
                            i62 = i + 1;
                            pointerEventPass2 = pointerEventPass;
                        }
                        PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                        if (pointerInputChange3 == 0) {
                            pointerInputChange3 = pointerEventPass;
                        }
                    }
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3);
                }
            }
            if (pointerInputChange3 == 0 || function13.invoke(pointerInputChange3).booleanValue()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                return pointerInputChange3;
            }
            function14.invoke(pointerInputChange3);
            id = pointerInputChange3.getId();
            awaitPointerEventScope2 = awaitPointerEventScope4;
            pointerEventPass2 = pointerEventPass;
            i5 = 1;
            longRef = new Ref.LongRef();
            longRef.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$1 = function14;
            dragGestureDetectorKt$drag$22.L$2 = orientation2;
            dragGestureDetectorKt$drag$22.L$3 = function13;
            dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
            dragGestureDetectorKt$drag$22.L$5 = longRef;
            dragGestureDetectorKt$drag$22.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m15594dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long id = j;
        if (m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = id;
            while (true) {
                InlineMarker.mark(0);
                Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                InlineMarker.mark(1);
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.getId();
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(((orientation == null ? Offset.m18282getDistanceimpl(jPositionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Offset.m18285getYimpl(jPositionChangeIgnoreConsumed) : Offset.m18284getXimpl(jPositionChangeIgnoreConsumed)) == 0.0f ? 1 : 0) ^ 1).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            id = pointerInputChange2.getId();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15595dragjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function1<? super PointerInputChange, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        PointerInputChange pointerInputChange;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            int i = dragGestureDetectorKt$drag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
            }
        }
        Object objM15582awaitDragOrCancellationrnUCldI = dragGestureDetectorKt$drag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$drag$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM15582awaitDragOrCancellationrnUCldI);
            dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
            dragGestureDetectorKt$drag$1.L$1 = function1;
            dragGestureDetectorKt$drag$1.label = 1;
            objM15582awaitDragOrCancellationrnUCldI = m15582awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
            if (objM15582awaitDragOrCancellationrnUCldI == coroutine_suspended) {
            }
            pointerInputChange = (PointerInputChange) objM15582awaitDragOrCancellationrnUCldI;
            if (pointerInputChange == null) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function1<? super PointerInputChange, Unit> function12 = (Function1) dragGestureDetectorKt$drag$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$1.L$0;
            ResultKt.throwOnFailure(objM15582awaitDragOrCancellationrnUCldI);
            function1 = function12;
            awaitPointerEventScope = awaitPointerEventScope2;
            pointerInputChange = (PointerInputChange) objM15582awaitDragOrCancellationrnUCldI;
            if (pointerInputChange == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    return Boxing.boxBoolean(true);
                }
                function1.invoke(pointerInputChange);
                j = pointerInputChange.getId();
                dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                dragGestureDetectorKt$drag$1.L$1 = function1;
                dragGestureDetectorKt$drag$1.label = 1;
                objM15582awaitDragOrCancellationrnUCldI = m15582awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                if (objM15582awaitDragOrCancellationrnUCldI == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pointerInputChange = (PointerInputChange) objM15582awaitDragOrCancellationrnUCldI;
                if (pointerInputChange == null) {
                    return Boxing.boxBoolean(false);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x010b, code lost:
    
        if (((r8 != null ? r8 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.p109ui.geometry.Offset.m18285getYimpl(r4) : androidx.compose.p109ui.geometry.Offset.m18284getXimpl(r4) : androidx.compose.p109ui.geometry.Offset.m18282getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00c2, B:46:0x00eb], limit reached: 72 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0083 -> B:23:0x0089). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15596horizontalDragjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function1<? super PointerInputChange, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$1;
        long id;
        Orientation orientation;
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object objAwaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$horizontalDrag$1) {
            dragGestureDetectorKt$horizontalDrag$1 = (DragGestureDetectorKt$horizontalDrag$1) continuation;
            int i = dragGestureDetectorKt$horizontalDrag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$horizontalDrag$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$horizontalDrag$1 = new DragGestureDetectorKt$horizontalDrag$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$horizontalDrag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$horizontalDrag$1.label;
        int i4 = 1;
        PointerInputChange pointerInputChange3 = null;
        PointerEventPass pointerEventPass = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation3 = Orientation.Horizontal;
            id = j;
            if (!m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                orientation = orientation3;
                dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                awaitPointerEventScope2 = awaitPointerEventScope;
                function12 = function1;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = id;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                orientation2 = orientation;
                longRef = longRef2;
                dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                dragGestureDetectorKt$horizontalDrag$12.label = i4;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i4, pointerEventPass);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                }
            }
            return Boxing.boxBoolean(pointerInputChange3 == null);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef = (Ref.LongRef) dragGestureDetectorKt$horizontalDrag$1.L$4;
        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$3;
        orientation2 = (Orientation) dragGestureDetectorKt$horizontalDrag$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$1;
        Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$horizontalDrag$1.L$0;
        ResultKt.throwOnFailure(obj);
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$1;
        function12 = function13;
        PointerEvent pointerEvent = (PointerEvent) obj;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i5);
            awaitPointerEventScope4 = awaitPointerEventScope3;
            if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                break;
            }
            i5++;
            awaitPointerEventScope3 = awaitPointerEventScope4;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange;
        if (pointerInputChange4 == null) {
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i6);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 != null) {
                    longRef.element = pointerInputChange5.getId();
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
                    i4 = 1;
                    pointerEventPass = null;
                    dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                    dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                    dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                    dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                    dragGestureDetectorKt$horizontalDrag$12.label = i4;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i4, pointerEventPass);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$14 = dragGestureDetectorKt$horizontalDrag$12;
                    awaitPointerEventScope5 = awaitPointerEventScope2;
                    obj = objAwaitPointerEvent$default;
                    dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$14;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i52 = 0;
                    while (true) {
                        if (i52 < size3) {
                        }
                        i52++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
            } else {
                long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange42);
            }
        }
        if (pointerInputChange42 == null || pointerInputChange42.isConsumed()) {
            pointerInputChange3 = null;
        } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
            pointerInputChange3 = pointerInputChange42;
        } else {
            function12.invoke(pointerInputChange42);
            orientation = orientation2;
            id = pointerInputChange42.getId();
            awaitPointerEventScope2 = awaitPointerEventScope5;
            dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
            i4 = 1;
            pointerEventPass = null;
            Ref.LongRef longRef22 = new Ref.LongRef();
            longRef22.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            orientation2 = orientation;
            longRef = longRef22;
            dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
            dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
            dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
            dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
            dragGestureDetectorKt$horizontalDrag$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i4, pointerEventPass);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(pointerInputChange3 == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m15597isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m15598pointerSlopE8SPZFQ(@NotNull ViewConfiguration viewConfiguration, int i) {
        return PointerType.m19798equalsimpl0(i, PointerType.INSTANCE.m19803getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x010b, code lost:
    
        if (((r8 != null ? r8 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.p109ui.geometry.Offset.m18285getYimpl(r4) : androidx.compose.p109ui.geometry.Offset.m18284getXimpl(r4) : androidx.compose.p109ui.geometry.Offset.m18282getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00c2, B:46:0x00eb], limit reached: 72 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0083 -> B:23:0x0089). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m15599verticalDragjO51t88(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function1<? super PointerInputChange, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$1;
        long id;
        Orientation orientation;
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object objAwaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$verticalDrag$1) {
            dragGestureDetectorKt$verticalDrag$1 = (DragGestureDetectorKt$verticalDrag$1) continuation;
            int i = dragGestureDetectorKt$verticalDrag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$verticalDrag$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$verticalDrag$1 = new DragGestureDetectorKt$verticalDrag$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$verticalDrag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$verticalDrag$1.label;
        int i4 = 1;
        PointerInputChange pointerInputChange3 = null;
        PointerEventPass pointerEventPass = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation3 = Orientation.Vertical;
            id = j;
            if (!m15597isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                orientation = orientation3;
                dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                awaitPointerEventScope2 = awaitPointerEventScope;
                function12 = function1;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = id;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                orientation2 = orientation;
                longRef = longRef2;
                dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                dragGestureDetectorKt$verticalDrag$12.label = i4;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i4, pointerEventPass);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                }
            }
            return Boxing.boxBoolean(pointerInputChange3 == null);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef = (Ref.LongRef) dragGestureDetectorKt$verticalDrag$1.L$4;
        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$3;
        orientation2 = (Orientation) dragGestureDetectorKt$verticalDrag$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$1;
        Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$verticalDrag$1.L$0;
        ResultKt.throwOnFailure(obj);
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$1;
        function12 = function13;
        PointerEvent pointerEvent = (PointerEvent) obj;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i5);
            awaitPointerEventScope4 = awaitPointerEventScope3;
            if (PointerId.m19708equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                break;
            }
            i5++;
            awaitPointerEventScope3 = awaitPointerEventScope4;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange;
        if (pointerInputChange4 == null) {
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i6);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 != null) {
                    longRef.element = pointerInputChange5.getId();
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
                    i4 = 1;
                    pointerEventPass = null;
                    dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                    dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                    dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                    dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                    dragGestureDetectorKt$verticalDrag$12.label = i4;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i4, pointerEventPass);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$14 = dragGestureDetectorKt$verticalDrag$12;
                    awaitPointerEventScope5 = awaitPointerEventScope2;
                    obj = objAwaitPointerEvent$default;
                    dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$14;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i52 = 0;
                    while (true) {
                        if (i52 < size3) {
                        }
                        i52++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
            } else {
                long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange42);
            }
        }
        if (pointerInputChange42 == null || pointerInputChange42.isConsumed()) {
            pointerInputChange3 = null;
        } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
            pointerInputChange3 = pointerInputChange42;
        } else {
            function12.invoke(pointerInputChange42);
            orientation = orientation2;
            id = pointerInputChange42.getId();
            awaitPointerEventScope2 = awaitPointerEventScope5;
            dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
            i4 = 1;
            pointerEventPass = null;
            Ref.LongRef longRef22 = new Ref.LongRef();
            longRef22.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            orientation2 = orientation;
            longRef = longRef22;
            dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
            dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
            dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
            dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
            dragGestureDetectorKt$verticalDrag$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i4, pointerEventPass);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(pointerInputChange3 == null);
    }

    @Nullable
    public static final Object detectDragGestures(@NotNull PointerInputScope pointerInputScope, @NotNull Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, @NotNull Function1<? super PointerInputChange, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Boolean> function02, @Nullable Orientation orientation, @NotNull Function2<? super PointerInputChange, ? super Offset, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C08759(function02, new Ref.LongRef(), orientation, function3, function2, function0, function1, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }
}
