package androidx.compose.p109ui.scrollcapture;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.semantics.ScrollAxisRange;
import androidx.compose.p109ui.semantics.SemanticsProperties;
import androidx.compose.runtime.AbstractC1974b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "", "delta"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$scrollTracker$1", m14021f = "ComposeScrollCaptureCallback.android.kt", m14022i = {0}, m14023l = {85}, m14024m = "invokeSuspend", m14025n = {"reverseScrolling"}, m14026s = {"Z$0"})
@SourceDebugExtension({"SMAP\nComposeScrollCaptureCallback.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeScrollCaptureCallback.android.kt\nandroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$scrollTracker$1\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,319:1\n81#2,9:320\n*S KotlinDebug\n*F\n+ 1 ComposeScrollCaptureCallback.android.kt\nandroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$scrollTracker$1\n*L\n74#1:320,9\n*E\n"})
public final class ComposeScrollCaptureCallback$scrollTracker$1 extends SuspendLambda implements Function2<Float, Continuation<? super Float>, Object> {
    /* synthetic */ float F$0;
    boolean Z$0;
    int label;
    final /* synthetic */ ComposeScrollCaptureCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeScrollCaptureCallback$scrollTracker$1(ComposeScrollCaptureCallback composeScrollCaptureCallback, Continuation<? super ComposeScrollCaptureCallback$scrollTracker$1> continuation) {
        super(2, continuation);
        this.this$0 = composeScrollCaptureCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ComposeScrollCaptureCallback$scrollTracker$1 composeScrollCaptureCallback$scrollTracker$1 = new ComposeScrollCaptureCallback$scrollTracker$1(this.this$0, continuation);
        composeScrollCaptureCallback$scrollTracker$1.F$0 = ((Number) obj).floatValue();
        return composeScrollCaptureCallback$scrollTracker$1;
    }

    @Nullable
    public final Object invoke(float f, @Nullable Continuation<? super Float> continuation) {
        return ((ComposeScrollCaptureCallback$scrollTracker$1) create(Float.valueOf(f), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float f = this.F$0;
            Function2<Offset, Continuation<? super Offset>, Object> scrollCaptureScrollByAction = ScrollCapture_androidKt.getScrollCaptureScrollByAction(this.this$0.node);
            if (scrollCaptureScrollByAction == null) {
                throw AbstractC1974b.m1327t("Required value was null.");
            }
            boolean reverseScrolling = ((ScrollAxisRange) this.this$0.node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())).getReverseScrolling();
            if (reverseScrolling) {
                f = -f;
            }
            Offset offsetM18273boximpl = Offset.m18273boximpl(OffsetKt.Offset(0.0f, f));
            this.Z$0 = reverseScrolling;
            this.label = 1;
            obj = scrollCaptureScrollByAction.invoke(offsetM18273boximpl, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = reverseScrolling;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        float fM18285getYimpl = Offset.m18285getYimpl(((Offset) obj).getPackedValue());
        if (z) {
            fM18285getYimpl = -fM18285getYimpl;
        }
        return Boxing.boxFloat(fM18285getYimpl);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Float f, Continuation<? super Float> continuation) {
        return invoke(f.floatValue(), continuation);
    }
}
