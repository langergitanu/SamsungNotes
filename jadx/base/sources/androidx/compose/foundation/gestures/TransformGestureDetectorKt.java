package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u000f\u0010\u000b\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a~\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "zoom", Key.ROTATION, "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransformGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformGestureDetector.kt\nandroidx/compose/foundation/gestures/TransformGestureDetectorKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,255:1\n132#2,3:256\n33#2,4:259\n135#2,2:263\n38#2:265\n137#2:266\n33#2,6:267\n33#2,6:273\n33#2,6:279\n*S KotlinDebug\n*F\n+ 1 TransformGestureDetector.kt\nandroidx/compose/foundation/gestures/TransformGestureDetectorKt\n*L\n116#1:256,3\n116#1:259,4\n116#1:263,2\n116#1:265\n116#1:266\n131#1:267,6\n216#1:273,6\n242#1:279,6\n*E\n"})
public final class TransformGestureDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", m14021f = "TransformGestureDetector.kt", m14022i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m14023l = {59, 61}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, m14026s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
    @SourceDebugExtension({"SMAP\nTransformGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformGestureDetector.kt\nandroidx/compose/foundation/gestures/TransformGestureDetectorKt$detectTransformGestures$2\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,255:1\n101#2,2:256\n33#2,6:258\n103#2:264\n33#2,6:265\n101#2,2:271\n33#2,6:273\n103#2:279\n*S KotlinDebug\n*F\n+ 1 TransformGestureDetector.kt\nandroidx/compose/foundation/gestures/TransformGestureDetectorKt$detectTransformGestures$2\n*L\n62#1:256,2\n62#1:258,6\n62#1:264\n96#1:265,6\n103#1:271,2\n103#1:273,6\n103#1:279\n*E\n"})
    public static final class C09232 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C09232(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super C09232> continuation) {
            super(2, continuation);
            this.$panZoomLock = z;
            this.$onGesture = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C09232 c09232 = new C09232(this.$panZoomLock, this.$onGesture, continuation);
            c09232.L$0 = obj;
            return c09232;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C09232) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0093, code lost:
        
            if (r15 == r6) goto L16;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:58:0x015f  */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [int] */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0093 -> B:17:0x0096). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            int i;
            long jM18289plusMKHz9U;
            float f;
            AwaitPointerEventScope awaitPointerEventScope;
            float f4;
            float f5;
            int i2;
            Object objAwaitPointerEvent$default;
            ?? r7;
            float f6;
            float f7;
            int i4;
            int size;
            int i5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.label;
            float f8 = 1.0f;
            int i7 = 2;
            float f9 = 0.0f;
            boolean z = false;
            int i8 = 1;
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                long jM18300getZeroF1C5BW0 = Offset.INSTANCE.m18300getZeroF1C5BW0();
                float touchSlop = awaitPointerEventScope2.getViewConfiguration().getTouchSlop();
                this.L$0 = awaitPointerEventScope2;
                this.F$0 = 0.0f;
                this.F$1 = 1.0f;
                this.J$0 = jM18300getZeroF1C5BW0;
                this.I$0 = 0;
                this.F$2 = touchSlop;
                this.I$1 = 0;
                this.label = 1;
                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null) != coroutine_suspended) {
                    i = 0;
                    jM18289plusMKHz9U = jM18300getZeroF1C5BW0;
                    f = touchSlop;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    f4 = 1.0f;
                    f5 = 0.0f;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                f = this.F$2;
                i = this.I$0;
                jM18289plusMKHz9U = this.J$0;
                f4 = this.F$1;
                f5 = this.F$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitPointerEvent$default = obj;
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                float f10 = f8;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size2 = changes.size();
                float f11 = f9;
                ?? r9 = z;
                while (true) {
                    if (r9 >= size2) {
                        r7 = z;
                        break;
                    }
                    if (changes.get(r9).isConsumed()) {
                        r7 = i8;
                        break;
                    }
                    r9++;
                }
                if (r7 == 0) {
                    float fCalculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent);
                    float fCalculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent);
                    float f12 = f4;
                    long jCalculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent);
                    if (i == 0) {
                        f7 = f12 * fCalculateZoom;
                        f5 += fCalculateRotation;
                        jM18289plusMKHz9U = Offset.m18289plusMKHz9U(jM18289plusMKHz9U, jCalculatePan);
                        float fCalculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent, z);
                        int i9 = i2;
                        float fAbs = Math.abs(1 - f7) * fCalculateCentroidSize;
                        float fAbs2 = Math.abs(((3.1415927f * f5) * fCalculateCentroidSize) / 180.0f);
                        float fM18282getDistanceimpl = Offset.m18282getDistanceimpl(jM18289plusMKHz9U);
                        if (fAbs > f || fAbs2 > f || fM18282getDistanceimpl > f) {
                            i2 = (!this.$panZoomLock || fAbs2 >= f) ? 0 : 1;
                            i = 1;
                        } else {
                            i2 = i9;
                        }
                    } else {
                        f7 = f12;
                    }
                    if (i != 0) {
                        z = false;
                        long jCalculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent, false);
                        if (i2 != 0) {
                            fCalculateRotation = f11;
                        }
                        if (fCalculateRotation == f11 && fCalculateZoom == f10) {
                            i4 = i2;
                            f6 = f;
                            if (!Offset.m18281equalsimpl0(jCalculatePan, Offset.INSTANCE.m18300getZeroF1C5BW0())) {
                            }
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            size = changes2.size();
                            for (i5 = 0; i5 < size; i5++) {
                                PointerInputChange pointerInputChange = changes2.get(i5);
                                if (PointerEventKt.positionChanged(pointerInputChange)) {
                                    pointerInputChange.consume();
                                }
                            }
                        } else {
                            i4 = i2;
                            f6 = f;
                        }
                        this.$onGesture.invoke(Offset.m18273boximpl(jCalculateCentroid), Offset.m18273boximpl(jCalculatePan), Boxing.boxFloat(fCalculateZoom), Boxing.boxFloat(fCalculateRotation));
                        List<PointerInputChange> changes22 = pointerEvent.getChanges();
                        size = changes22.size();
                        while (i5 < size) {
                        }
                    } else {
                        i4 = i2;
                        f6 = f;
                        z = false;
                    }
                    i2 = i4;
                    f4 = f7;
                } else {
                    f6 = f;
                }
                if (r7 == 0) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    for (?? r8 = z; r8 < size3; r8++) {
                        if (changes3.get(r8).getPressed()) {
                            f8 = f10;
                            f9 = f11;
                            f = f6;
                            i7 = 2;
                            i8 = 1;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i2 = this.I$1;
            f = this.F$2;
            i = this.I$0;
            jM18289plusMKHz9U = this.J$0;
            f4 = this.F$1;
            f5 = this.F$0;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = awaitPointerEventScope;
            this.F$0 = f5;
            this.F$1 = f4;
            this.J$0 = jM18289plusMKHz9U;
            this.I$0 = i;
            this.F$2 = f;
            this.I$1 = i2;
            this.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, i8, null);
        }
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m15681anglek4lQ0M(long j) {
        if (Offset.m18284getXimpl(j) == 0.0f && Offset.m18285getYimpl(j) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Offset.m18284getXimpl(j), Offset.m18285getYimpl(j)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(@NotNull PointerEvent pointerEvent, boolean z) {
        long jM18300getZeroF1C5BW0 = Offset.INSTANCE.m18300getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                jM18300getZeroF1C5BW0 = Offset.m18289plusMKHz9U(jM18300getZeroF1C5BW0, z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition());
                i++;
            }
        }
        return i == 0 ? Offset.INSTANCE.m18299getUnspecifiedF1C5BW0() : Offset.m18279divtuRUvjQ(jM18300getZeroF1C5BW0, i);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final float calculateCentroidSize(@NotNull PointerEvent pointerEvent, boolean z) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, z);
        float fM18282getDistanceimpl = 0.0f;
        if (Offset.m18281equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m18299getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                i++;
                fM18282getDistanceimpl = Offset.m18282getDistanceimpl(Offset.m18288minusMKHz9U(z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition(), jCalculateCentroid)) + fM18282getDistanceimpl;
            }
        }
        return fM18282getDistanceimpl / i;
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final long calculatePan(@NotNull PointerEvent pointerEvent) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.INSTANCE;
        return Offset.m18281equalsimpl0(jCalculateCentroid, companion.m18299getUnspecifiedF1C5BW0()) ? companion.m18300getZeroF1C5BW0() : Offset.m18288minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(@NotNull PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i4 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i4 = 0;
            }
            i2 += i4;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f4 = 0.0f;
        for (int i5 = 0; i5 < size2; i5++) {
            PointerInputChange pointerInputChange2 = changes2.get(i5);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long position = pointerInputChange2.getPosition();
                long jM18288minusMKHz9U = Offset.m18288minusMKHz9U(pointerInputChange2.getPreviousPosition(), jCalculateCentroid2);
                long jM18288minusMKHz9U2 = Offset.m18288minusMKHz9U(position, jCalculateCentroid);
                float fM15681anglek4lQ0M = m15681anglek4lQ0M(jM18288minusMKHz9U2) - m15681anglek4lQ0M(jM18288minusMKHz9U);
                float fM18282getDistanceimpl = Offset.m18282getDistanceimpl(Offset.m18289plusMKHz9U(jM18288minusMKHz9U2, jM18288minusMKHz9U)) / 2.0f;
                if (fM15681anglek4lQ0M > 180.0f) {
                    fM15681anglek4lQ0M -= 360.0f;
                } else if (fM15681anglek4lQ0M < -180.0f) {
                    fM15681anglek4lQ0M += 360.0f;
                }
                f4 += fM15681anglek4lQ0M * fM18282getDistanceimpl;
                f += fM18282getDistanceimpl;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f4 / f;
    }

    public static final float calculateZoom(@NotNull PointerEvent pointerEvent) {
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f || fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    @Nullable
    public static final Object detectTransformGestures(@NotNull PointerInputScope pointerInputScope, boolean z, @NotNull Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C09232(z, function4, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }
}
