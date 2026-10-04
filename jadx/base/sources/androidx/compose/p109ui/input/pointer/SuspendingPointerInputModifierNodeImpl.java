package androidx.compose.p109ui.input.pointer;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.poi.java.awt.GridBagConstraints;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001PB\\\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ=\u0010:\u001a\u0002H;\"\u0004\b\u0000\u0010;2'\u0010<\u001a#\b\u0001\u0012\u0004\u0012\u00020=\u0012\n\u0012\b\u0012\u0004\u0012\u0002H;0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000eH\u0096@¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020BH\u0002J-\u0010C\u001a\u00020\r2\u0006\u0010A\u001a\u00020B2\u001a\u0010<\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u001dR\u00020\u0000\u0012\u0004\u0012\u00020\r0DH\u0082\bJ\b\u0010E\u001a\u00020\rH\u0016J\b\u0010F\u001a\u00020\rH\u0016J\b\u0010G\u001a\u00020\rH\u0016J*\u0010H\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001a\u00020\rH\u0016J\b\u0010M\u001a\u00020\rH\u0016J`\u0010N\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000eH\u0000¢\u0006\u0004\bO\u0010\u000fR1\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u0013X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001dR\u00020\u00000\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001dR\u00020\u00000\u001cX\u0082\u0004¢\u0006\u0002\n\u0000Rf\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000e2'\u0010-\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u0010!R\u0014\u00106\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "key1", "", "key2", "keys", "", "pointerInputHandler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "_pointerInputHandler", "Lkotlin/jvm/functions/Function2;", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "[Ljava/lang/Object;", "lastPointerEvent", "pointerHandlers", "value", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "pointerInputJob", "Lkotlinx/coroutines/Job;", "size", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancelPointerInput", "onDensityChange", "onDetach", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onViewConfigurationChange", "resetPointerInputHandler", Constants.ARG_UPDATE, "update$ui_release", "PointerEventHandlerCoroutine", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuspendingPointerInputFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuspendingPointerInputFilter.kt\nandroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 JvmActuals.jvm.kt\nandroidx/compose/ui/platform/JvmActuals_jvmKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,809:1\n573#1:840\n574#1:842\n576#1,4:844\n582#1:859\n585#1,3:871\n1208#2:810\n1187#2,2:811\n1208#2:813\n1187#2,2:814\n36#3:816\n36#3:841\n36#3:913\n146#4:817\n460#4,11:818\n492#4,11:829\n146#4:843\n460#4,11:848\n492#4,11:860\n728#4,2:914\n86#5,2:874\n33#5,6:876\n88#5:882\n86#5,2:883\n33#5,6:885\n88#5:891\n416#5,3:892\n33#5,4:895\n419#5:899\n420#5:901\n38#5:902\n421#5:903\n1#6:900\n314#7,9:904\n323#7,2:916\n*S KotlinDebug\n*F\n+ 1 SuspendingPointerInputFilter.kt\nandroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl\n*L\n597#1:840\n597#1:842\n597#1:844,4\n597#1:859\n597#1:871,3\n489#1:810\n489#1:811,2\n498#1:813\n498#1:814,2\n573#1:816\n597#1:841\n665#1:913\n574#1:817\n579#1:818,11\n582#1:829,11\n597#1:843\n597#1:848,11\n597#1:860,11\n666#1:914,2\n623#1:874,2\n623#1:876,6\n623#1:882\n633#1:883,2\n633#1:885,6\n633#1:891\n636#1:892,3\n636#1:895,4\n636#1:899\n636#1:901\n636#1:902\n636#1:903\n636#1:900\n663#1:904,9\n663#1:916,2\n*E\n"})
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    public static final int $stable = 0;

    @NotNull
    private Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> _pointerInputHandler;
    private long boundsSize;

    @NotNull
    private PointerEvent currentEvent;

    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;

    @Nullable
    private Object key1;

    @Nullable
    private Object key2;

    @Nullable
    private Object[] keys;

    @Nullable
    private PointerEvent lastPointerEvent;

    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;

    @Nullable
    private Job pointerInputJob;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001b\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0002\u00100JE\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@¢\u0006\u0002\u00109JG\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@¢\u0006\u0002\u00109J\u0017\u0010;\u001a\u00020<*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0017\u0010;\u001a\u00020<*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020=*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010C\u001a\u00020=*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001a\u0010C\u001a\u00020=*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u0017\u0010I\u001a\u00020J*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u0012*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u0017\u0010M\u001a\u00020\u0012*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020\u0016*\u00020JH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u0017\u0010U\u001a\u00020@*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", "event", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSuspendingPointerInputFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuspendingPointerInputFilter.kt\nandroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine\n+ 2 JvmActuals.jvm.kt\nandroidx/compose/ui/platform/JvmActuals_jvmKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,809:1\n36#2:810\n735#3,2:811\n314#4,11:813\n*S KotlinDebug\n*F\n+ 1 SuspendingPointerInputFilter.kt\nandroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine\n*L\n735#1:810\n736#1:811,2\n743#1:813,11\n*E\n"})
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;

        @NotNull
        private final Continuation<R> completion;

        @Nullable
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;

        @NotNull
        private PointerEventPass awaitPass = PointerEventPass.Main;

        @NotNull
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(@NotNull Continuation<? super R> continuation) {
            this.completion = continuation;
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
        }

        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        @Nullable
        public Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public final void cancel(@Nullable Throwable cause) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(cause);
            }
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        @NotNull
        public PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.this.currentEvent;
        }

        @Override // androidx.compose.p109ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo19636getExtendedTouchPaddingNHjbRc() {
            return SuspendingPointerInputModifierNodeImpl.this.mo15537getExtendedTouchPaddingNHjbRc();
        }

        @Override // androidx.compose.p109ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getSize-YbymL2g */
        public long mo19637getSizeYbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.this.boundsSize;
        }

        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        @NotNull
        public ViewConfiguration getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        public final void offerPointerEvent(@NotNull PointerEvent event, @NotNull PointerEventPass pass) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (pass != this.awaitPass || (cancellableContinuation = this.pointerAwaiter) == null) {
                return;
            }
            this.pointerAwaiter = null;
            cancellableContinuation.resumeWith(Result.m22215constructorimpl(event));
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object result) {
            MutableVector mutableVector = SuspendingPointerInputModifierNodeImpl.this.pointerHandlers;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (mutableVector) {
                suspendingPointerInputModifierNodeImpl.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(result);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public int mo15539roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo15539roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public int mo15540roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo15540roundToPx0680j_4(f);
        }

        @Override // androidx.compose.p109ui.unit.FontScaling
        @Stable
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public float mo15541toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo15541toDpGaN1DYA(j);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo15542toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo15542toDpu2uoSUM(f);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public long mo15544toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo15544toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public float mo15545toPxR2X_6o(long j) {
            return this.$$delegate_0.mo15545toPxR2X_6o(j);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public float mo15546toPx0680j_4(float f) {
            return this.$$delegate_0.mo15546toPx0680j_4(f);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        @NotNull
        public Rect toRect(@NotNull DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public long mo15547toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo15547toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.p109ui.unit.FontScaling
        @Stable
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public long mo15548toSp0xMU5do(float f) {
            return this.$$delegate_0.mo15548toSp0xMU5do(f);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo15549toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo15549toSpkPz2Gy4(f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T> Object withTimeout(long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
            C2077x647a7347 c2077x647a7347;
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (continuation instanceof C2077x647a7347) {
                c2077x647a7347 = (C2077x647a7347) continuation;
                int i = c2077x647a7347.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c2077x647a7347.label = i - Integer.MIN_VALUE;
                } else {
                    c2077x647a7347 = new C2077x647a7347(this, continuation);
                }
            }
            Object objInvoke = c2077x647a7347.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c2077x647a7347.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objInvoke);
                    if (j <= 0 && (cancellableContinuation = this.pointerAwaiter) != null) {
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(j))));
                    }
                    Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(SuspendingPointerInputModifierNodeImpl.this.getCoroutineScope(), null, null, new C2078xf3489d20(j, this, null), 3, null);
                    c2077x647a7347.L$0 = jobLaunch$default;
                    c2077x647a7347.label = 1;
                    objInvoke = function2.invoke(this, c2077x647a7347);
                    j = jobLaunch$default;
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Job job = (Job) c2077x647a7347.L$0;
                    ResultKt.throwOnFailure(objInvoke);
                    j = job;
                }
                j.cancel(CancelTimeoutCancellationException.INSTANCE);
                return objInvoke;
            } catch (Throwable th) {
                j.cancel(CancelTimeoutCancellationException.INSTANCE);
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.compose.p109ui.input.pointer.AwaitPointerEventScope
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T> Object withTimeoutOrNull(long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
            C2079x2677a771 c2079x2677a771;
            if (continuation instanceof C2079x2677a771) {
                c2079x2677a771 = (C2079x2677a771) continuation;
                int i = c2079x2677a771.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c2079x2677a771.label = i - Integer.MIN_VALUE;
                } else {
                    c2079x2677a771 = new C2079x2677a771(this, continuation);
                }
            }
            Object obj = c2079x2677a771.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c2079x2677a771.label;
            try {
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                c2079x2677a771.label = 1;
                Object objWithTimeout = withTimeout(j, function2, c2079x2677a771);
                return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
            } catch (PointerEventTimeoutCancellationException unused) {
                return null;
            }
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo15543toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo15543toDpu2uoSUM(i);
        }

        @Override // androidx.compose.p109ui.unit.Density
        @Stable
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo15550toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo15550toSpkPz2Gy4(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : obj2, (i & 4) != 0 ? null : objArr, function2);
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int size;
        synchronized (this.pointerHandlers) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
            mutableVector2.addAll(mutableVector2.getSize(), this.pointerHandlers);
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    PointerEventHandlerCoroutine<?>[] content = mutableVector3.getContent();
                    int i2 = 0;
                    do {
                        content[i2].offerPointerEvent(pointerEvent, pass);
                        i2++;
                    } while (i2 < size2);
                }
            } else if (i == 3 && (size = (mutableVector = this.dispatchingPointerHandlers).getSize()) > 0) {
                int i4 = size - 1;
                PointerEventHandlerCoroutine<?>[] content2 = mutableVector.getContent();
                do {
                    content2[i4].offerPointerEvent(pointerEvent, pass);
                    i4--;
                } while (i4 >= 0);
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> block) {
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int size;
        synchronized (this.pointerHandlers) {
            try {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                mutableVector2.addAll(mutableVector2.getSize(), this.pointerHandlers);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    PointerEventHandlerCoroutine<?>[] content = mutableVector3.getContent();
                    int i2 = 0;
                    do {
                        block.invoke(content[i2]);
                        i2++;
                    } while (i2 < size2);
                }
            } else if (i == 3 && (size = (mutableVector = this.dispatchingPointerHandlers).getSize()) > 0) {
                int i4 = size - 1;
                PointerEventHandlerCoroutine<?>[] content2 = mutableVector.getContent();
                do {
                    block.invoke(content2[i4]);
                    i4--;
                } while (i4 >= 0);
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    @Override // androidx.compose.p109ui.input.pointer.PointerInputScope
    @Nullable
    public <R> Object awaitPointerEventScope(@NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.pointerHandlers) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            Continuation<Unit> continuationCreateCoroutine = ContinuationKt.createCoroutine(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.INSTANCE;
            continuationCreateCoroutine.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                pointerEventHandlerCoroutine.cancel(th);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getDensity();
    }

    @Override // androidx.compose.p109ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo15537getExtendedTouchPaddingNHjbRc() {
        long jMo15547toSizeXkaWNTQ = mo15547toSizeXkaWNTQ(getViewConfiguration().mo20011getMinimumTouchTargetSizeMYxV2XQ());
        long boundsSize = getBoundsSize();
        return SizeKt.Size(Math.max(0.0f, Size.m18353getWidthimpl(jMo15547toSizeXkaWNTQ) - IntSize.m21138getWidthimpl(boundsSize)) / 2.0f, Math.max(0.0f, Size.m18350getHeightimpl(jMo15547toSizeXkaWNTQ) - IntSize.m21137getHeightimpl(boundsSize)) / 2.0f);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getFontScale();
    }

    @Override // androidx.compose.p109ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.p109ui.input.pointer.SuspendingPointerInputModifierNode
    @NotNull
    public Function2<PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        return this._pointerInputHandler;
    }

    @Override // androidx.compose.p109ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getSize-YbymL2g, reason: from getter */
    public long getBoundsSize() {
        return this.boundsSize;
    }

    @Override // androidx.compose.p109ui.input.pointer.PointerInputScope
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(this).getViewConfiguration();
    }

    @Override // androidx.compose.p109ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (changes.get(i).getPressed()) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                ArrayList arrayList = new ArrayList(changes2.size());
                int size2 = changes2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PointerInputChange pointerInputChange = changes2.get(i2);
                    arrayList.add(new PointerInputChange(pointerInputChange.getId(), pointerInputChange.getUptimeMillis(), pointerInputChange.getPosition(), false, pointerInputChange.getPressure(), pointerInputChange.getUptimeMillis(), pointerInputChange.getPosition(), pointerInputChange.getPressed(), pointerInputChange.getPressed(), 0, 0L, GridBagConstraints.ABOVE_BASELINE_TRAILING, (DefaultConstructorMarker) null));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList);
                this.currentEvent = pointerEvent2;
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
                this.lastPointerEvent = null;
                return;
            }
        }
    }

    @Override // androidx.compose.p109ui.node.PointerInputModifierNode
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.p109ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo15382onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pass, long bounds) {
        this.boundsSize = bounds;
        if (pass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        if (this.pointerInputJob == null) {
            this.pointerInputJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
        }
        dispatchPointerEvent(pointerEvent, pass);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.p109ui.node.PointerInputModifierNode
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.p109ui.input.pointer.SuspendingPointerInputModifierNode
    public void resetPointerInputHandler() {
        Job job = this.pointerInputJob;
        if (job != null) {
            job.cancel((CancellationException) new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }

    @Override // androidx.compose.p109ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    @Override // androidx.compose.p109ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputHandler(@NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        resetPointerInputHandler();
        this._pointerInputHandler = function2;
    }

    public final void update$ui_release(@Nullable Object key1, @Nullable Object key2, @Nullable Object[] keys, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler) {
        boolean z = !Intrinsics.areEqual(this.key1, key1);
        this.key1 = key1;
        if (!Intrinsics.areEqual(this.key2, key2)) {
            z = true;
        }
        this.key2 = key2;
        Object[] objArr = this.keys;
        if (objArr != null && keys == null) {
            z = true;
        }
        if (objArr == null && keys != null) {
            z = true;
        }
        boolean z2 = (objArr == null || keys == null || Arrays.equals(keys, objArr)) ? z : true;
        this.keys = keys;
        if (z2) {
            resetPointerInputHandler();
        }
        this._pointerInputHandler = pointerInputHandler;
    }

    public SuspendingPointerInputModifierNodeImpl(@Nullable Object obj, @Nullable Object obj2, @Nullable Object[] objArr, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.key1 = obj;
        this.key2 = obj2;
        this.keys = objArr;
        this._pointerInputHandler = function2;
        this.currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.INSTANCE.m21143getZeroYbymL2g();
    }
}
