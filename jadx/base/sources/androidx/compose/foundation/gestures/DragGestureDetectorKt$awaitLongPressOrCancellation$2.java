package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerId;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", m14021f = "DragGestureDetector.kt", m14022i = {0, 0, 1, 1, 1}, m14023l = {901, 918}, m14024m = "invokeSuspend", m14025n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, m14026s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
@SourceDebugExtension({"SMAP\nDragGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt$awaitLongPressOrCancellation$2\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,964:1\n86#2,2:965\n33#2,6:967\n88#2:973\n101#2,2:974\n33#2,6:976\n103#2:982\n101#2,2:983\n33#2,6:985\n103#2:991\n116#2,2:992\n33#2,6:994\n118#2:1000\n116#2,2:1001\n33#2,6:1003\n118#2:1009\n*S KotlinDebug\n*F\n+ 1 DragGestureDetector.kt\nandroidx/compose/foundation/gestures/DragGestureDetectorKt$awaitLongPressOrCancellation$2\n*L\n902#1:965,2\n902#1:967,6\n902#1:973\n908#1:974,2\n908#1:976,6\n908#1:982\n919#1:983,2\n919#1:985,6\n919#1:991\n923#1:992,2\n923#1:994,6\n923#1:1000\n933#1:1001,2\n933#1:1003,6\n933#1:1009\n*E\n"})
public final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cd A[EDGE_INSN: B:65:0x00cd->B:41:0x00cd BREAK  A[LOOP:0: B:36:0x00ba->B:40:0x00ca], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7, types: [T, androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ac -> B:35:0x00af). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        int i;
        Object objAwaitPointerEvent;
        int size;
        int i2;
        int size2;
        int i4;
        Object objAwaitPointerEvent2;
        T t;
        PointerInputChange pointerInputChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        Object obj2 = null;
        int i6 = 1;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            i = 0;
            if (i != 0) {
            }
        } else {
            if (i5 == 1) {
                i = this.I$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitPointerEvent = obj;
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i2 = 0;
                while (true) {
                    if (i2 >= size) {
                    }
                    i2++;
                }
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                size2 = changes2.size();
                while (i4 < size2) {
                }
                PointerEventPass pointerEventPass = PointerEventPass.Final;
                this.L$0 = awaitPointerEventScope;
                this.L$1 = pointerEvent;
                this.I$0 = i;
                this.label = 2;
                objAwaitPointerEvent2 = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, this);
                if (objAwaitPointerEvent2 != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            PointerEvent pointerEvent2 = (PointerEvent) this.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objAwaitPointerEvent2 = obj;
            List<PointerInputChange> changes3 = ((PointerEvent) objAwaitPointerEvent2).getChanges();
            int size3 = changes3.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size3) {
                    break;
                }
                if (changes3.get(i7).isConsumed()) {
                    i = i6;
                    break;
                }
                i7++;
            }
            if (!DragGestureDetectorKt.m15597isPointerUpDmW0f2w(pointerEvent2, this.$currentDown.element.getId())) {
                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                int size4 = changes4.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size4) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes4.get(i8);
                    if (pointerInputChange.getPressed()) {
                        break;
                    }
                    i8++;
                }
                PointerInputChange pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == 0) {
                    i = i6;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    obj2 = null;
                    if (i != 0) {
                        return Unit.INSTANCE;
                    }
                    PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = obj2;
                    this.I$0 = i;
                    this.label = i6;
                    objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, this);
                    if (objAwaitPointerEvent != coroutine_suspended) {
                        PointerEvent pointerEvent3 = (PointerEvent) objAwaitPointerEvent;
                        List<PointerInputChange> changes5 = pointerEvent3.getChanges();
                        size = changes5.size();
                        i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = i6;
                                break;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(changes5.get(i2))) {
                                break;
                            }
                            i2++;
                        }
                        List<PointerInputChange> changes22 = pointerEvent3.getChanges();
                        size2 = changes22.size();
                        for (i4 = 0; i4 < size2; i4++) {
                            PointerInputChange pointerInputChange3 = changes22.get(i4);
                            if (pointerInputChange3.isConsumed() || PointerEventKt.m19671isOutOfBoundsjwHxaWs(pointerInputChange3, awaitPointerEventScope.mo19637getSizeYbymL2g(), awaitPointerEventScope.mo19636getExtendedTouchPaddingNHjbRc())) {
                                break;
                            }
                        }
                        PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerEvent3;
                        this.I$0 = i;
                        this.label = 2;
                        objAwaitPointerEvent2 = awaitPointerEventScope.awaitPointerEvent(pointerEventPass3, this);
                        if (objAwaitPointerEvent2 != coroutine_suspended) {
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            pointerEvent2 = pointerEvent3;
                            List<PointerInputChange> changes32 = ((PointerEvent) objAwaitPointerEvent2).getChanges();
                            int size32 = changes32.size();
                            int i72 = 0;
                            while (true) {
                                if (i72 >= size32) {
                                }
                                i72++;
                            }
                            if (!DragGestureDetectorKt.m15597isPointerUpDmW0f2w(pointerEvent2, this.$currentDown.element.getId())) {
                                Ref.ObjectRef<PointerInputChange> objectRef = this.$longPress;
                                List<PointerInputChange> changes6 = pointerEvent2.getChanges();
                                Ref.ObjectRef<PointerInputChange> objectRef2 = this.$currentDown;
                                int size5 = changes6.size();
                                int i9 = 0;
                                while (true) {
                                    if (i9 >= size5) {
                                        t = 0;
                                        break;
                                    }
                                    t = changes6.get(i9);
                                    Ref.ObjectRef<PointerInputChange> objectRef3 = objectRef2;
                                    if (PointerId.m19708equalsimpl0(((PointerInputChange) t).getId(), objectRef2.element.getId())) {
                                        break;
                                    }
                                    i9++;
                                    objectRef2 = objectRef3;
                                }
                                objectRef.element = t;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                this.$currentDown.element = pointerInputChange2;
                this.$longPress.element = pointerInputChange2;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj2 = null;
            i6 = 1;
            if (i != 0) {
            }
        }
    }
}
