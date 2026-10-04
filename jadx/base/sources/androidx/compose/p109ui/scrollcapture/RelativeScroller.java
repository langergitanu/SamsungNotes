package androidx.compose.p109ui.scrollcapture;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "viewportSize", "", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function2;)V", "<set-?>", "scrollAmount", "getScrollAmount", "()F", "Lkotlin/jvm/functions/Function2;", "mapOffsetToViewport", TypedValues.Cycle.S_WAVE_OFFSET, "reset", "", "delta", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollRangeIntoView", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposeScrollCaptureCallback.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeScrollCaptureCallback.android.kt\nandroidx/compose/ui/scrollcapture/RelativeScroller\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,319:1\n1#2:320\n*E\n"})
final class RelativeScroller {
    private float scrollAmount;

    @NotNull
    private final Function2<Float, Continuation<? super Float>, Object> scrollBy;
    private final int viewportSize;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.scrollcapture.RelativeScroller", m14021f = "ComposeScrollCaptureCallback.android.kt", m14022i = {0}, m14023l = {306}, m14024m = "scrollBy", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C22191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C22191(Continuation<? super C22191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RelativeScroller.this.scrollBy(0.0f, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeScroller(int i, @NotNull Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> function2) {
        this.viewportSize = i;
        this.scrollBy = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scrollBy(float f, Continuation<? super Unit> continuation) {
        C22191 c22191;
        RelativeScroller relativeScroller;
        if (continuation instanceof C22191) {
            c22191 = (C22191) continuation;
            int i = c22191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22191.label = i - Integer.MIN_VALUE;
            } else {
                c22191 = new C22191(continuation);
            }
        }
        Object objInvoke = c22191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22191.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            Function2<Float, Continuation<? super Float>, Object> function2 = this.scrollBy;
            Float fBoxFloat = Boxing.boxFloat(f);
            c22191.L$0 = this;
            c22191.label = 1;
            objInvoke = function2.invoke(fBoxFloat, c22191);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            relativeScroller = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            relativeScroller = (RelativeScroller) c22191.L$0;
            ResultKt.throwOnFailure(objInvoke);
        }
        relativeScroller.scrollAmount += ((Number) objInvoke).floatValue();
        return Unit.INSTANCE;
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final int mapOffsetToViewport(int offset) {
        return RangesKt.coerceIn(offset - MathKt.roundToInt(this.scrollAmount), 0, this.viewportSize);
    }

    public final void reset() {
        this.scrollAmount = 0.0f;
    }

    @Nullable
    public final Object scrollRangeIntoView(int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        if (i > i2) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "Expected min=", " ≤ max=").toString());
        }
        int i4 = i2 - i;
        int i5 = this.viewportSize;
        if (i4 > i5) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i4, "Expected range (", ") to be ≤ viewportSize=");
            sbM778t.append(this.viewportSize);
            throw new IllegalArgumentException(sbM778t.toString().toString());
        }
        float f = i;
        float f4 = this.scrollAmount;
        if (f >= f4 && i2 <= i5 + f4) {
            return Unit.INSTANCE;
        }
        if (f >= f4) {
            i = i2 - i5;
        }
        Object objScrollTo = scrollTo(i, continuation);
        return objScrollTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollTo : Unit.INSTANCE;
    }

    @Nullable
    public final Object scrollTo(float f, @NotNull Continuation<? super Unit> continuation) {
        Object objScrollBy = scrollBy(f - this.scrollAmount, continuation);
        return objScrollBy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollBy : Unit.INSTANCE;
    }
}
