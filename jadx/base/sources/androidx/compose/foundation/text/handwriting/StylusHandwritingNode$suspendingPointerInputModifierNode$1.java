package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerId;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.PointerType;
import androidx.compose.p109ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1", m14021f = "StylusHandwriting.kt", m14022i = {}, m14023l = {132}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class StylusHandwritingNode$suspendingPointerInputModifierNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StylusHandwritingNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1", m14021f = "StylusHandwriting.kt", m14022i = {0, 1, 1, 1, 2, 2}, m14023l = {134, 158, 186}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "pass", "$this$awaitEachGesture", "firstDown"}, m14026s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nStylusHandwriting.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StylusHandwriting.kt\nandroidx/compose/foundation/text/handwriting/StylusHandwritingNode$suspendingPointerInputModifierNode$1$1\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,223:1\n116#2,2:224\n33#2,6:226\n118#2:232\n116#2,2:233\n33#2,6:235\n118#2:241\n*S KotlinDebug\n*F\n+ 1 StylusHandwriting.kt\nandroidx/compose/foundation/text/handwriting/StylusHandwritingNode$suspendingPointerInputModifierNode$1$1\n*L\n160#1:224,2\n160#1:226,6\n160#1:232\n187#1:233,2\n187#1:235,6\n187#1:241\n*E\n"})
    public static final class C12921 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ StylusHandwritingNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12921(StylusHandwritingNode stylusHandwritingNode, Continuation<? super C12921> continuation) {
            super(2, continuation);
            this.this$0 = stylusHandwritingNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C12921 c12921 = new C12921(this.this$0, continuation);
            c12921.L$0 = obj;
            return c12921;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C12921) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
        
            if (r8 == r1) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
        
            if (r9 != r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0180, code lost:
        
            if (r5 != r1) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0182, code lost:
        
            return r1;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e8 -> B:42:0x00ec). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0180 -> B:69:0x0183). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object objAwaitFirstDown;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerEventPass pointerEventPass;
            PointerInputChange pointerInputChange;
            Object objAwaitPointerEvent;
            PointerInputChange pointerInputChange2;
            PointerInputChange pointerInputChange3;
            AwaitPointerEventScope awaitPointerEventScope3;
            Object objAwaitPointerEvent2;
            PointerInputChange pointerInputChange4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 2;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, true, pointerEventPass2, this);
            } else if (i == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitFirstDown = obj;
            } else if (i == 2) {
                pointerEventPass = (PointerEventPass) this.L$2;
                pointerInputChange = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitPointerEvent = obj;
                List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
                int size = changes.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes.get(i4);
                    PointerInputChange pointerInputChange5 = pointerInputChange2;
                    if (!pointerInputChange5.isConsumed() && PointerId.m19708equalsimpl0(pointerInputChange5.getId(), pointerInputChange.getId()) && pointerInputChange5.getPressed()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange6 = pointerInputChange2;
                if (pointerInputChange6 == null || pointerInputChange6.getUptimeMillis() - pointerInputChange.getUptimeMillis() >= awaitPointerEventScope2.getViewConfiguration().getLongPressTimeoutMillis()) {
                    pointerInputChange6 = null;
                } else if (Offset.m18282getDistanceimpl(Offset.m18288minusMKHz9U(pointerInputChange6.getPosition(), pointerInputChange.getPosition())) <= awaitPointerEventScope2.getViewConfiguration().getHandwritingSlop()) {
                    i2 = 2;
                    this.L$0 = awaitPointerEventScope2;
                    this.L$1 = pointerInputChange;
                    this.L$2 = pointerEventPass;
                    this.label = i2;
                    objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
                }
                if (pointerInputChange6 == null || !this.this$0.getOnHandwritingSlopExceeded().invoke().booleanValue()) {
                    return Unit.INSTANCE;
                }
                pointerInputChange6.consume();
                pointerInputChange3 = pointerInputChange;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                PointerEventPass pointerEventPass3 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope3;
                this.L$1 = pointerInputChange3;
                this.L$2 = null;
                this.label = 3;
                objAwaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass3, this);
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pointerInputChange3 = (PointerInputChange) this.L$1;
                awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitPointerEvent2 = obj;
                List<PointerInputChange> changes2 = ((PointerEvent) objAwaitPointerEvent2).getChanges();
                int size2 = changes2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size2) {
                        pointerInputChange4 = null;
                        break;
                    }
                    pointerInputChange4 = changes2.get(i5);
                    PointerInputChange pointerInputChange7 = pointerInputChange4;
                    if (!pointerInputChange7.isConsumed() && PointerId.m19708equalsimpl0(pointerInputChange7.getId(), pointerInputChange3.getId()) && pointerInputChange7.getPressed()) {
                        break;
                    }
                    i5++;
                }
                PointerInputChange pointerInputChange8 = pointerInputChange4;
                if (pointerInputChange8 == null) {
                    return Unit.INSTANCE;
                }
                pointerInputChange8.consume();
                PointerEventPass pointerEventPass32 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope3;
                this.L$1 = pointerInputChange3;
                this.L$2 = null;
                this.label = 3;
                objAwaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass32, this);
            }
            PointerInputChange pointerInputChange9 = (PointerInputChange) objAwaitFirstDown;
            int type = pointerInputChange9.getType();
            PointerType.Companion companion = PointerType.INSTANCE;
            if (!PointerType.m19798equalsimpl0(type, companion.m19804getStylusT8wyACA()) && !PointerType.m19798equalsimpl0(pointerInputChange9.getType(), companion.m19802getEraserT8wyACA())) {
                return Unit.INSTANCE;
            }
            PointerEventPass pointerEventPass4 = (this.this$0.focused || (Offset.m18284getXimpl(pointerInputChange9.getPosition()) >= 0.0f && Offset.m18284getXimpl(pointerInputChange9.getPosition()) < ((float) IntSize.m21138getWidthimpl(awaitPointerEventScope.mo19637getSizeYbymL2g())) && Offset.m18285getYimpl(pointerInputChange9.getPosition()) >= 0.0f && Offset.m18285getYimpl(pointerInputChange9.getPosition()) < ((float) IntSize.m21137getHeightimpl(awaitPointerEventScope.mo19637getSizeYbymL2g())))) ? PointerEventPass.Initial : PointerEventPass.Main;
            awaitPointerEventScope2 = awaitPointerEventScope;
            pointerEventPass = pointerEventPass4;
            pointerInputChange = pointerInputChange9;
            this.L$0 = awaitPointerEventScope2;
            this.L$1 = pointerInputChange;
            this.L$2 = pointerEventPass;
            this.label = i2;
            objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StylusHandwritingNode$suspendingPointerInputModifierNode$1(StylusHandwritingNode stylusHandwritingNode, Continuation<? super StylusHandwritingNode$suspendingPointerInputModifierNode$1> continuation) {
        super(2, continuation);
        this.this$0 = stylusHandwritingNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StylusHandwritingNode$suspendingPointerInputModifierNode$1 stylusHandwritingNode$suspendingPointerInputModifierNode$1 = new StylusHandwritingNode$suspendingPointerInputModifierNode$1(this.this$0, continuation);
        stylusHandwritingNode$suspendingPointerInputModifierNode$1.L$0 = obj;
        return stylusHandwritingNode$suspendingPointerInputModifierNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StylusHandwritingNode$suspendingPointerInputModifierNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            C12921 c12921 = new C12921(this.this$0, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c12921, this) == coroutine_suspended) {
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
}
