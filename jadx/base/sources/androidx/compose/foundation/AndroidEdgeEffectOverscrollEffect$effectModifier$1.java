package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerId;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(m14020c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", m14021f = "AndroidOverscroll.android.kt", m14022i = {}, m14023l = {638}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", m14021f = "AndroidOverscroll.android.kt", m14022i = {0, 1}, m14023l = {639, 643}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, m14026s = {"L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nAndroidOverscroll.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidOverscroll.android.kt\nandroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect$effectModifier$1$1\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,875:1\n235#2,3:876\n33#2,4:879\n238#2,2:883\n38#2:885\n240#2:886\n116#2,2:887\n33#2,6:889\n118#2:895\n*S KotlinDebug\n*F\n+ 1 AndroidOverscroll.android.kt\nandroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect$effectModifier$1$1\n*L\n643#1:876,3\n643#1:879,4\n643#1:883,2\n643#1:885\n643#1:886\n647#1:887,2\n647#1:889,6\n647#1:895\n*E\n"})
    public static final class C07611 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07611(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super C07611> continuation) {
            super(2, continuation);
            this.this$0 = androidEdgeEffectOverscrollEffect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C07611 c07611 = new C07611(this.this$0, continuation);
            c07611.L$0 = obj;
            return c07611;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C07611) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r14 != r0) goto L18;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0066 -> B:18:0x0069). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            C07611 c07611;
            AwaitPointerEventScope awaitPointerEventScope;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope2;
                this.label = 1;
                c07611 = this;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, c07611, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                c07611 = this;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                c07611 = this;
                List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                ArrayList arrayList = new ArrayList(changes.size());
                int size = changes.size();
                int i2 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    PointerInputChange pointerInputChange = changes.get(i4);
                    if (pointerInputChange.getPressed()) {
                        arrayList.add(pointerInputChange);
                    }
                }
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = c07611.this$0;
                int size2 = arrayList.size();
                while (true) {
                    if (i2 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = arrayList.get(i2);
                    if (PointerId.m19707equalsimpl(((PointerInputChange) obj2).getId(), androidEdgeEffectOverscrollEffect.pointerId)) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = (PointerInputChange) CollectionsKt.firstOrNull((List) arrayList);
                }
                if (pointerInputChange2 != null) {
                    c07611.this$0.pointerId = PointerId.m19705boximpl(pointerInputChange2.getId());
                    c07611.this$0.pointerPosition = Offset.m18273boximpl(pointerInputChange2.getPosition());
                }
                if (arrayList.isEmpty()) {
                    c07611.this$0.pointerId = null;
                    return Unit.INSTANCE;
                }
                c07611.L$0 = awaitPointerEventScope;
                c07611.label = 2;
                obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
            c07611.this$0.pointerId = PointerId.m19705boximpl(pointerInputChange3.getId());
            c07611.this$0.pointerPosition = Offset.m18273boximpl(pointerInputChange3.getPosition());
            c07611.L$0 = awaitPointerEventScope;
            c07611.label = 2;
            obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            C07611 c07611 = new C07611(this.this$0, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c07611, this) == coroutine_suspended) {
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
