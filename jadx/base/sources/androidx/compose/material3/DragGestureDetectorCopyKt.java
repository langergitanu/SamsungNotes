package androidx.compose.material3;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerId;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerType;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a]\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018H\u0082Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, m13886d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl((float) 0.125d);
        mouseSlop = fM20968constructorimpl;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(18);
        defaultTouchSlop = fM20968constructorimpl2;
        mouseToTouchSlopRatio = fM20968constructorimpl / fM20968constructorimpl2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0123 -> B:47:0x012b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0163 -> B:54:0x0165). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0180 -> B:47:0x012b). Please report as a decompilation issue!!! */
    @Nullable
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m17135awaitHorizontalPointerSlopOrCancellationgDDlDlE(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, int i, @NotNull Function2<? super PointerInputChange, ? super Float, Unit> function2, @NotNull Continuation<? super PointerInputChange> continuation) {
        C1757x2966ccbb c1757x2966ccbb;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        Ref.LongRef longRef;
        C1757x2966ccbb c1757x2966ccbb2;
        float f;
        float fM18284getXimpl;
        Ref.LongRef longRef2;
        C1757x2966ccbb c1757x2966ccbb3;
        float f4;
        float f5;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i4;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof C1757x2966ccbb) {
            c1757x2966ccbb = (C1757x2966ccbb) continuation;
            int i5 = c1757x2966ccbb.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1757x2966ccbb.label = i5 - Integer.MIN_VALUE;
            } else {
                c1757x2966ccbb = new C1757x2966ccbb(continuation);
            }
        }
        Object obj3 = c1757x2966ccbb.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = c1757x2966ccbb.label;
        int i7 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj3);
            if (m17137isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            float fM17138pointerSlopE8SPZFQ = m17138pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.element = j;
            awaitPointerEventScope2 = awaitPointerEventScope;
            function22 = function2;
            longRef = longRef3;
            c1757x2966ccbb2 = c1757x2966ccbb;
            f = fM17138pointerSlopE8SPZFQ;
            fM18284getXimpl = 0.0f;
            c1757x2966ccbb2.L$0 = function22;
            c1757x2966ccbb2.L$1 = awaitPointerEventScope2;
            c1757x2966ccbb2.L$2 = longRef;
            c1757x2966ccbb2.L$3 = pointerEventPass2;
            c1757x2966ccbb2.F$0 = f;
            c1757x2966ccbb2.F$1 = fM18284getXimpl;
            c1757x2966ccbb2.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, c1757x2966ccbb2, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            float f6 = c1757x2966ccbb.F$1;
            float f7 = c1757x2966ccbb.F$0;
            PointerInputChange pointerInputChange2 = (PointerInputChange) c1757x2966ccbb.L$3;
            Ref.LongRef longRef4 = (Ref.LongRef) c1757x2966ccbb.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) c1757x2966ccbb.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) c1757x2966ccbb.L$0;
            ResultKt.throwOnFailure(obj3);
            fM18284getXimpl = f6;
            pointerEventPass = null;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            longRef2 = longRef4;
            c1757x2966ccbb3 = c1757x2966ccbb;
            f = f7;
            function22 = function23;
            if (pointerInputChange2.isConsumed()) {
                return pointerEventPass;
            }
            c1757x2966ccbb2 = c1757x2966ccbb3;
            longRef = longRef2;
            pointerEventPass2 = pointerEventPass;
            i7 = 1;
            c1757x2966ccbb2.L$0 = function22;
            c1757x2966ccbb2.L$1 = awaitPointerEventScope2;
            c1757x2966ccbb2.L$2 = longRef;
            c1757x2966ccbb2.L$3 = pointerEventPass2;
            c1757x2966ccbb2.F$0 = f;
            c1757x2966ccbb2.F$1 = fM18284getXimpl;
            c1757x2966ccbb2.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, c1757x2966ccbb2, i7, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
                float f8 = f;
                f5 = fM18284getXimpl;
                obj3 = objAwaitPointerEvent$default;
                longRef2 = longRef;
                c1757x2966ccbb3 = c1757x2966ccbb2;
                f4 = f8;
                PointerEvent pointerEvent = (PointerEvent) obj3;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                        pointerEventPass = pointerEventPass2;
                        obj = pointerEventPass;
                        break;
                    }
                    obj = changes.get(i2);
                    pointerEventPass = pointerEventPass2;
                    i4 = i2;
                    if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                        break;
                    }
                    i2 = i4 + 1;
                    pointerEventPass2 = pointerEventPass;
                }
                Intrinsics.checkNotNull(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange.isConsumed()) {
                    return pointerEventPass;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i8 = 0;
                    while (true) {
                        if (i8 >= size2) {
                            obj2 = pointerEventPass;
                            break;
                        }
                        obj2 = changes2.get(i8);
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
                    fM18284getXimpl = f5;
                    f = f4;
                } else {
                    fM18284getXimpl = (Offset.m18284getXimpl(pointerInputChange.getPosition()) - Offset.m18284getXimpl(pointerInputChange.getPreviousPosition())) + f5;
                    if (Math.abs(fM18284getXimpl) < f4) {
                        PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                        c1757x2966ccbb3.L$0 = function22;
                        c1757x2966ccbb3.L$1 = awaitPointerEventScope2;
                        c1757x2966ccbb3.L$2 = longRef2;
                        c1757x2966ccbb3.L$3 = pointerInputChange;
                        c1757x2966ccbb3.F$0 = f4;
                        c1757x2966ccbb3.F$1 = fM18284getXimpl;
                        c1757x2966ccbb3.label = 2;
                        if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, c1757x2966ccbb3) != coroutine_suspended) {
                            f = f4;
                            pointerInputChange2 = pointerInputChange;
                            if (pointerInputChange2.isConsumed()) {
                            }
                        }
                    } else {
                        function22.invoke(pointerInputChange, Boxing.boxFloat(fM18284getXimpl - (Math.signum(fM18284getXimpl) * f4)));
                        if (pointerInputChange.isConsumed()) {
                            return pointerInputChange;
                        }
                        f = f4;
                        fM18284getXimpl = 0.0f;
                    }
                }
                c1757x2966ccbb2 = c1757x2966ccbb3;
                longRef = longRef2;
                pointerEventPass2 = pointerEventPass;
                i7 = 1;
                c1757x2966ccbb2.L$0 = function22;
                c1757x2966ccbb2.L$1 = awaitPointerEventScope2;
                c1757x2966ccbb2.L$2 = longRef;
                c1757x2966ccbb2.L$3 = pointerEventPass2;
                c1757x2966ccbb2.F$0 = f;
                c1757x2966ccbb2.F$1 = fM18284getXimpl;
                c1757x2966ccbb2.label = i7;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, c1757x2966ccbb2, i7, pointerEventPass2);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        float f9 = c1757x2966ccbb.F$1;
        float f10 = c1757x2966ccbb.F$0;
        Ref.LongRef longRef5 = (Ref.LongRef) c1757x2966ccbb.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) c1757x2966ccbb.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) c1757x2966ccbb.L$0;
        ResultKt.throwOnFailure(obj3);
        C1757x2966ccbb c1757x2966ccbb4 = c1757x2966ccbb;
        f5 = f9;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        c1757x2966ccbb3 = c1757x2966ccbb4;
        f4 = f10;
        function22 = function24;
        longRef2 = longRef5;
        PointerEvent pointerEvent2 = (PointerEvent) obj3;
        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
        size = changes3.size();
        i2 = 0;
        while (true) {
            if (i2 < size) {
            }
            i2 = i4 + 1;
            pointerEventPass2 = pointerEventPass;
        }
        Intrinsics.checkNotNull(obj);
        pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange.isConsumed()) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d1, code lost:
    
        r22.invoke(r15, java.lang.Float.valueOf(r8 - (java.lang.Math.signum(r8) * r3)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e4, code lost:
    
        if (r15.isConsumed() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
    
        return r15;
     */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Object m17136awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        PointerEventPass pointerEventPass;
        Object obj;
        Object obj2;
        long id = j;
        PointerEventPass pointerEventPass2 = null;
        if (m17137isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        float fM17138pointerSlopE8SPZFQ = m17138pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        while (true) {
            float fFloatValue = 0.0f;
            while (true) {
                int i2 = 0;
                InlineMarker.mark(0);
                Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass2, continuation, 1, pointerEventPass2);
                InlineMarker.mark(1);
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        pointerEventPass = pointerEventPass2;
                        obj = pointerEventPass;
                        break;
                    }
                    obj = changes.get(i4);
                    pointerEventPass = pointerEventPass2;
                    if (PointerId.m19708equalsimpl0(((PointerInputChange) obj).getId(), id)) {
                        break;
                    }
                    i4++;
                    pointerEventPass2 = pointerEventPass;
                }
                Intrinsics.checkNotNull(obj);
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange.isConsumed()) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    fFloatValue += function1.invoke(Offset.m18273boximpl(pointerInputChange.getPosition())).floatValue() - function1.invoke(Offset.m18273boximpl(pointerInputChange.getPreviousPosition())).floatValue();
                    if (Math.abs(fFloatValue) >= fM17138pointerSlopE8SPZFQ) {
                        break;
                    }
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass3, continuation);
                    InlineMarker.mark(1);
                    if (pointerInputChange.isConsumed()) {
                        return pointerEventPass;
                    }
                } else {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i2 >= size2) {
                            obj2 = pointerEventPass;
                            break;
                        }
                        obj2 = changes2.get(i2);
                        if (((PointerInputChange) obj2).getPressed()) {
                            break;
                        }
                        i2++;
                    }
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                    if (pointerInputChange2 == null) {
                        return pointerEventPass;
                    }
                    id = pointerInputChange2.getId();
                }
                pointerEventPass2 = pointerEventPass;
            }
            pointerEventPass2 = pointerEventPass;
        }
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m17137isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
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
    public static final float m17138pointerSlopE8SPZFQ(@NotNull ViewConfiguration pointerSlop, int i) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        return PointerType.m19798equalsimpl0(i, PointerType.INSTANCE.m19803getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }
}
