package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0082@¢\u0006\u0002\u0010\u000b\u001a<\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, m13886d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "", NetworkConfig.CLIENTS_CHANNEL, "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransformable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transformable.kt\nandroidx/compose/foundation/gestures/TransformableKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,277:1\n101#2,2:278\n33#2,6:280\n103#2:286\n33#2,6:287\n101#2,2:293\n33#2,6:295\n103#2:301\n101#2,2:302\n33#2,6:304\n103#2:310\n*S KotlinDebug\n*F\n+ 1 Transformable.kt\nandroidx/compose/foundation/gestures/TransformableKt\n*L\n219#1:278,2\n219#1:280,6\n219#1:286\n253#1:287,6\n264#1:293,2\n264#1:295,6\n264#1:301\n265#1:302,2\n265#1:304,6\n265#1:310\n*E\n"})
public final class TransformableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.TransformableKt", m14021f = "Transformable.kt", m14022i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m14023l = {JPEG.SOI, JPEG.SOS, 262}, m14024m = "detectZoom", m14025n = {"$this$detectZoom", NetworkConfig.CLIENTS_CHANNEL, "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", NetworkConfig.CLIENTS_CHANNEL, "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", NetworkConfig.CLIENTS_CHANNEL, "canPan", "event", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, m14026s = {"L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"})
    public static final class C09241 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C09241(Continuation<? super C09241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, false, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02b2, code lost:
    
        if (r6 != 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02b4, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02b9 A[EDGE_INSN: B:103:0x02b9->B:92:0x02b9 BREAK  A[LOOP:0: B:86:0x02a4->B:91:0x02b6], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0288 -> B:85:0x0297). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        C09241 c09241;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z2;
        float f;
        long j;
        int i;
        int i2;
        float f4;
        float f5;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super Offset, Boolean> function13;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f6;
        float f7;
        Channel<TransformEvent> channel3;
        int size;
        int i4;
        int i5;
        C09241 c092412;
        float f8;
        long j2;
        int i6;
        int i7;
        Object objAwaitPointerEvent;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerEvent pointerEvent;
        float f9;
        int i8;
        int i9;
        Channel<TransformEvent> channel4;
        long j3;
        float f10;
        long j5;
        int size2;
        int i10;
        int size3;
        int i11;
        int size4;
        int i12;
        if (continuation instanceof C09241) {
            c09241 = (C09241) continuation;
            int i13 = c09241.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                c09241.label = i13 - Integer.MIN_VALUE;
            } else {
                c09241 = new C09241(continuation);
            }
        }
        C09241 c092413 = c09241;
        Object objAwaitPointerEvent$default = c092413.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i14 = c092413.label;
        if (i14 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            long jM18300getZeroF1C5BW0 = Offset.INSTANCE.m18300getZeroF1C5BW0();
            float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
            c092413.L$0 = awaitPointerEventScope;
            channel2 = channel;
            c092413.L$1 = channel2;
            function12 = function1;
            c092413.L$2 = function12;
            z2 = z;
            c092413.Z$0 = z2;
            c092413.F$0 = 0.0f;
            c092413.F$1 = 1.0f;
            c092413.J$0 = jM18300getZeroF1C5BW0;
            c092413.I$0 = 0;
            c092413.F$2 = touchSlop;
            c092413.I$1 = 0;
            c092413.label = 1;
            if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, c092413, 2, null) != coroutine_suspended) {
                f = touchSlop;
                j = jM18300getZeroF1C5BW0;
                i = 0;
                i2 = 0;
                f4 = 1.0f;
                f5 = 0.0f;
                awaitPointerEventScope2 = awaitPointerEventScope;
            }
            return coroutine_suspended;
        }
        if (i14 != 1) {
            if (i14 != 2) {
                if (i14 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i5 = c092413.I$2;
                i8 = c092413.I$1;
                f9 = c092413.F$2;
                i9 = c092413.I$0;
                j3 = c092413.J$0;
                float f11 = c092413.F$1;
                f5 = c092413.F$0;
                boolean z3 = c092413.Z$0;
                pointerEvent = (PointerEvent) c092413.L$3;
                Function1<? super Offset, Boolean> function14 = (Function1) c092413.L$2;
                Channel<TransformEvent> channel5 = (Channel) c092413.L$1;
                AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) c092413.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                f4 = f11;
                channel4 = channel5;
                awaitPointerEventScope4 = awaitPointerEventScope5;
                function12 = function14;
                z2 = z3;
                objAwaitPointerEvent = objAwaitPointerEvent$default;
                List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
                size3 = changes.size();
                Object obj = coroutine_suspended;
                i11 = 0;
                while (true) {
                    if (i11 >= size3) {
                        break;
                    }
                    if (changes.get(i11).isConsumed()) {
                        break;
                    }
                    i11++;
                }
                boolean z4 = false;
                if (i5 == 0 && !z4) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    size4 = changes2.size();
                    for (i12 = 0; i12 < size4; i12++) {
                        if (changes2.get(i12).getPressed()) {
                            i = i8;
                            f = f9;
                            i2 = i9;
                            channel2 = channel4;
                            j = j3;
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            coroutine_suspended = obj;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i = c092413.I$1;
            f = c092413.F$2;
            i2 = c092413.I$0;
            j = c092413.J$0;
            float f12 = c092413.F$1;
            float f13 = c092413.F$0;
            boolean z5 = c092413.Z$0;
            Function1<? super Offset, Boolean> function15 = (Function1) c092413.L$2;
            Channel<TransformEvent> channel6 = (Channel) c092413.L$1;
            AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) c092413.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            f7 = f12;
            channel3 = channel6;
            z2 = z5;
            f6 = f13;
            function13 = function15;
            awaitPointerEventScope3 = awaitPointerEventScope6;
            PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
            size = changes3.size();
            int i15 = i;
            i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i5 = 0;
                    break;
                }
                if (changes3.get(i4).isConsumed()) {
                    i5 = 1;
                    break;
                }
                i4++;
            }
            if (i5 != 0) {
                float fCalculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                float fCalculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                float f14 = f7;
                float f15 = f6;
                long jCalculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                if (i2 == 0) {
                    f8 = f14 * fCalculateZoom;
                    float f16 = f15 + fCalculateRotation;
                    long jM18289plusMKHz9U = Offset.m18289plusMKHz9U(j, jCalculatePan);
                    int i16 = i2;
                    float fCalculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                    float fAbs = Math.abs(1 - f8) * fCalculateCentroidSize;
                    float fAbs2 = Math.abs(((3.1415927f * f16) * fCalculateCentroidSize) / 180.0f);
                    float fM18282getDistanceimpl = Offset.m18282getDistanceimpl(jM18289plusMKHz9U);
                    if (fAbs > f || fAbs2 > f || (fM18282getDistanceimpl > f && function13.invoke(Offset.m18273boximpl(jCalculatePan)).booleanValue())) {
                        i6 = (!z2 || fAbs2 >= f) ? 0 : 1;
                        channel3.mo23705trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        j5 = jM18289plusMKHz9U;
                        i7 = 1;
                    } else {
                        i6 = i15;
                        j5 = jM18289plusMKHz9U;
                        i7 = i16;
                    }
                    f10 = f16;
                } else {
                    f8 = f14;
                    f10 = f15;
                    j5 = j;
                    i6 = i15;
                    i7 = i2;
                }
                if (i7 == 0) {
                    c092412 = c092413;
                } else {
                    float f17 = i6 != 0 ? 0.0f : fCalculateRotation;
                    if (f17 == 0.0f && fCalculateZoom == 1.0f) {
                        c092412 = c092413;
                        if (!Offset.m18281equalsimpl0(jCalculatePan, Offset.INSTANCE.m18300getZeroF1C5BW0()) && function13.invoke(Offset.m18273boximpl(jCalculatePan)).booleanValue()) {
                        }
                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                        size2 = changes4.size();
                        for (i10 = 0; i10 < size2; i10++) {
                            PointerInputChange pointerInputChange = changes4.get(i10);
                            if (PointerEventKt.positionChanged(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                        }
                    } else {
                        c092412 = c092413;
                    }
                    channel3.mo23705trySendJP2dKIU(new TransformEvent.TransformDelta(fCalculateZoom, jCalculatePan, f17, null));
                    List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                    size2 = changes42.size();
                    while (i10 < size2) {
                    }
                }
                j2 = j5;
                f5 = f10;
            } else {
                int i17 = i2;
                c092412 = c092413;
                channel3.mo23705trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                f8 = f7;
                f5 = f6;
                j2 = j;
                i6 = i15;
                i7 = i17;
            }
            PointerEventPass pointerEventPass = PointerEventPass.Final;
            C09241 c092414 = c092412;
            c092414.L$0 = awaitPointerEventScope3;
            c092414.L$1 = channel3;
            c092414.L$2 = function13;
            c092414.L$3 = pointerEvent2;
            c092414.Z$0 = z2;
            c092414.F$0 = f5;
            c092414.F$1 = f8;
            c092414.J$0 = j2;
            c092414.I$0 = i7;
            c092414.F$2 = f;
            c092414.I$1 = i6;
            c092414.I$2 = i5;
            c092414.label = 3;
            objAwaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, c092414);
            if (objAwaitPointerEvent != coroutine_suspended) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                function12 = function13;
                pointerEvent = pointerEvent2;
                long j6 = j2;
                f9 = f;
                i8 = i6;
                i9 = i7;
                channel4 = channel3;
                c092413 = c092414;
                f4 = f8;
                j3 = j6;
                List<PointerInputChange> changes5 = ((PointerEvent) objAwaitPointerEvent).getChanges();
                size3 = changes5.size();
                Object obj2 = coroutine_suspended;
                i11 = 0;
                while (true) {
                    if (i11 >= size3) {
                    }
                    i11++;
                }
                boolean z42 = false;
                if (i5 == 0) {
                    List<PointerInputChange> changes22 = pointerEvent.getChanges();
                    size4 = changes22.size();
                    while (i12 < size4) {
                    }
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        i = c092413.I$1;
        f = c092413.F$2;
        i2 = c092413.I$0;
        j = c092413.J$0;
        f4 = c092413.F$1;
        f5 = c092413.F$0;
        boolean z6 = c092413.Z$0;
        function12 = (Function1) c092413.L$2;
        Channel<TransformEvent> channel7 = (Channel) c092413.L$1;
        awaitPointerEventScope2 = (AwaitPointerEventScope) c092413.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent$default);
        z2 = z6;
        channel2 = channel7;
        c092413.L$0 = awaitPointerEventScope2;
        c092413.L$1 = channel2;
        c092413.L$2 = function12;
        c092413.L$3 = null;
        c092413.Z$0 = z2;
        c092413.F$0 = f5;
        c092413.F$1 = f4;
        c092413.J$0 = j;
        c092413.I$0 = i2;
        c092413.F$2 = f;
        c092413.I$1 = i;
        c092413.label = 2;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, c092413, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            float f18 = f5;
            f7 = f4;
            channel3 = channel2;
            f6 = f18;
            AwaitPointerEventScope awaitPointerEventScope7 = awaitPointerEventScope2;
            function13 = function12;
            awaitPointerEventScope3 = awaitPointerEventScope7;
            PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes32 = pointerEvent22.getChanges();
            size = changes32.size();
            int i152 = i;
            i4 = 0;
            while (true) {
                if (i4 >= size) {
                }
                i4++;
            }
            if (i5 != 0) {
            }
            PointerEventPass pointerEventPass2 = PointerEventPass.Final;
            C09241 c0924142 = c092412;
            c0924142.L$0 = awaitPointerEventScope3;
            c0924142.L$1 = channel3;
            c0924142.L$2 = function13;
            c0924142.L$3 = pointerEvent22;
            c0924142.Z$0 = z2;
            c0924142.F$0 = f5;
            c0924142.F$1 = f8;
            c0924142.J$0 = j2;
            c0924142.I$0 = i7;
            c0924142.F$2 = f;
            c0924142.I$1 = i6;
            c0924142.I$2 = i5;
            c0924142.label = 3;
            objAwaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, c0924142);
            if (objAwaitPointerEvent != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    @NotNull
    public static final Modifier transformable(@NotNull Modifier modifier, @NotNull TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1<Offset, Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableKt.transformable.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Offset offset) {
                return m15684invokek4lQ0M(offset.getPackedValue());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final Boolean m15684invokek4lQ0M(long j) {
                return Boolean.TRUE;
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier transformable(@NotNull Modifier modifier, @NotNull TransformableState transformableState, @NotNull Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }
}
