package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "anchors", "", ""}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwipeableState$animateTo$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    public SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        SwipeableState$animateTo$2$emit$1 swipeableState$animateTo$2$emit$1;
        SwipeableState$animateTo$2<T> swipeableState$animateTo$2;
        Object objFirstOrNull;
        Object objFirstOrNull2;
        if (continuation instanceof SwipeableState$animateTo$2$emit$1) {
            swipeableState$animateTo$2$emit$1 = (SwipeableState$animateTo$2$emit$1) continuation;
            int i = swipeableState$animateTo$2$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                swipeableState$animateTo$2$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, continuation);
            }
        }
        Object obj = swipeableState$animateTo$2$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = swipeableState$animateTo$2$emit$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) swipeableState$animateTo$2$emit$1.L$1;
            swipeableState$animateTo$2 = (SwipeableState$animateTo$2) swipeableState$animateTo$2$emit$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                float fFloatValue = ((Number) ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset.getValue()).floatValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry : map.entrySet()) {
                    if (Math.abs(entry.getKey().floatValue() - fFloatValue) < 0.5f) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                objFirstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap.values());
                if (objFirstOrNull2 == null) {
                    objFirstOrNull2 = swipeableState$animateTo$2.this$0.getCurrentValue();
                }
                swipeableState$animateTo$2.this$0.setCurrentValue(objFirstOrNull2);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                float fFloatValue2 = ((Number) ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset.getValue()).floatValue();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (r7.hasNext()) {
                }
                objFirstOrNull = CollectionsKt.firstOrNull(linkedHashMap2.values());
                if (objFirstOrNull == null) {
                }
                swipeableState$animateTo$2.this$0.setCurrentValue(objFirstOrNull);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            Float offset = SwipeableKt.getOffset(map, this.$targetValue);
            if (offset == null) {
                throw new IllegalArgumentException("The target value must have an associated anchor.");
            }
            SwipeableState<T> swipeableState = this.this$0;
            float fFloatValue3 = offset.floatValue();
            AnimationSpec<Float> animationSpec = this.$anim;
            swipeableState$animateTo$2$emit$1.L$0 = this;
            swipeableState$animateTo$2$emit$1.L$1 = map;
            swipeableState$animateTo$2$emit$1.label = 1;
            if (swipeableState.animateInternalToOffset(fFloatValue3, animationSpec, swipeableState$animateTo$2$emit$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            swipeableState$animateTo$2 = this;
            float fFloatValue4 = ((Number) ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset.getValue()).floatValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            while (r7.hasNext()) {
            }
            objFirstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap3.values());
            if (objFirstOrNull2 == null) {
            }
            swipeableState$animateTo$2.this$0.setCurrentValue(objFirstOrNull2);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            swipeableState$animateTo$2 = this;
            float fFloatValue22 = ((Number) ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset.getValue()).floatValue();
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            for (Map.Entry<Float, ? extends T> entry2 : map.entrySet()) {
                if (Math.abs(entry2.getKey().floatValue() - fFloatValue22) < 0.5f) {
                    linkedHashMap22.put(entry2.getKey(), entry2.getValue());
                }
            }
            objFirstOrNull = CollectionsKt.firstOrNull(linkedHashMap22.values());
            if (objFirstOrNull == null) {
                objFirstOrNull = swipeableState$animateTo$2.this$0.getCurrentValue();
            }
            swipeableState$animateTo$2.this$0.setCurrentValue(objFirstOrNull);
            throw th;
        }
    }
}
