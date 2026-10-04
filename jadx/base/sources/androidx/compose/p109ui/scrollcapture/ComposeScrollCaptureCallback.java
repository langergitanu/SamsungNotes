package androidx.compose.p109ui.scrollcapture;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.contentcapture.AbstractC2027a;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.RectHelper_androidKt;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u001f\u001a\u00020\u0010*\u00020 H\u0002J\f\u0010!\u001a\u00020\u0010*\u00020 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;)V", "requestCount", "", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "onScrollCaptureEnd", "", "onReady", "Ljava/lang/Runnable;", "onScrollCaptureImageRequest", "session", "Landroid/view/ScrollCaptureSession;", "signal", "Landroid/os/CancellationSignal;", "captureArea", "Landroid/graphics/Rect;", "onComplete", "Ljava/util/function/Consumer;", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScrollCaptureSearch", "onScrollCaptureStart", "drawDebugBackground", "Landroid/graphics/Canvas;", "drawDebugOverlay", "ScrollCaptureSessionListener", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    public static final int $stable = 8;

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private final ScrollCaptureSessionListener listener;

    @NotNull
    private final SemanticsNode node;
    private int requestCount;

    @NotNull
    private final RelativeScroller scrollTracker;

    @NotNull
    private final IntRect viewportBoundsInWindow;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "", "onSessionEnded", "", "onSessionStarted", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface ScrollCaptureSessionListener {
        void onSessionEnded();

        void onSessionStarted();
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1", m14021f = "ComposeScrollCaptureCallback.android.kt", m14022i = {}, m14023l = {190}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C22141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Runnable $onReady;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22141(Runnable runnable, Continuation<? super C22141> continuation) {
            super(2, continuation);
            this.$onReady = runnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ComposeScrollCaptureCallback.this.new C22141(this.$onReady, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RelativeScroller relativeScroller = ComposeScrollCaptureCallback.this.scrollTracker;
                this.label = 1;
                if (relativeScroller.scrollTo(0.0f, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ComposeScrollCaptureCallback.this.listener.onSessionEnded();
            this.$onReady.run();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C22141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1", m14021f = "ComposeScrollCaptureCallback.android.kt", m14022i = {}, m14023l = {116}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C22151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $captureArea;
        final /* synthetic */ Consumer<Rect> $onComplete;
        final /* synthetic */ ScrollCaptureSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22151(ScrollCaptureSession scrollCaptureSession, Rect rect, Consumer<Rect> consumer, Continuation<? super C22151> continuation) {
            super(2, continuation);
            this.$session = scrollCaptureSession;
            this.$captureArea = rect;
            this.$onComplete = consumer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ComposeScrollCaptureCallback.this.new C22151(this.$session, this.$captureArea, this.$onComplete, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ComposeScrollCaptureCallback composeScrollCaptureCallback = ComposeScrollCaptureCallback.this;
                ScrollCaptureSession scrollCaptureSession = this.$session;
                IntRect composeIntRect = RectHelper_androidKt.toComposeIntRect(this.$captureArea);
                this.label = 1;
                obj = composeScrollCaptureCallback.onScrollCaptureImageRequest(scrollCaptureSession, composeIntRect, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$onComplete.accept(RectHelper_androidKt.toAndroidRect((IntRect) obj));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C22151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback", m14021f = "ComposeScrollCaptureCallback.android.kt", m14022i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m14023l = {129, 132}, m14024m = "onScrollCaptureImageRequest", m14025n = {"this", "session", "captureArea", "targetMin", "targetMax", "this", "session", "captureArea", "targetMin", "targetMax"}, m14026s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    public static final class C22162 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C22162(Continuation<? super C22162> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ComposeScrollCaptureCallback.this.onScrollCaptureImageRequest(null, null, this);
        }
    }

    public ComposeScrollCaptureCallback(@NotNull SemanticsNode semanticsNode, @NotNull IntRect intRect, @NotNull CoroutineScope coroutineScope, @NotNull ScrollCaptureSessionListener scrollCaptureSessionListener) {
        this.node = semanticsNode;
        this.viewportBoundsInWindow = intRect;
        this.listener = scrollCaptureSessionListener;
        this.coroutineScope = CoroutineScopeKt.plus(coroutineScope, DisableAnimationMotionDurationScale.INSTANCE);
        this.scrollTracker = new RelativeScroller(intRect.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    private final void drawDebugBackground(Canvas canvas) {
        canvas.drawColor(ColorKt.m18579toArgb8_81llA(Color.Companion.m18549hslJlNiLsg$default(Color.INSTANCE, Random.INSTANCE.nextFloat() * 360.0f, 0.75f, 0.5f, 1.0f, null, 16, null)));
    }

    private final void drawDebugOverlay(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setTextSize(48.0f);
        canvas.drawCircle(0.0f, 0.0f, 20.0f, paint);
        canvas.drawCircle(canvas.getWidth(), 0.0f, 20.0f, paint);
        canvas.drawCircle(canvas.getWidth(), canvas.getHeight(), 20.0f, paint);
        canvas.drawCircle(0.0f, canvas.getHeight(), 20.0f, paint);
        canvas.drawText(String.valueOf(this.requestCount), canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, paint);
        this.requestCount++;
    }

    public void onScrollCaptureEnd(@NotNull Runnable onReady) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new C22141(onReady, null), 2, null);
    }

    public void onScrollCaptureImageRequest(@NotNull ScrollCaptureSession session, @NotNull CancellationSignal signal, @NotNull Rect captureArea, @NotNull Consumer<Rect> onComplete) {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal(this.coroutineScope, signal, new C22151(session, captureArea, onComplete, null));
    }

    public void onScrollCaptureSearch(@NotNull CancellationSignal signal, @NotNull Consumer<Rect> onReady) {
        onReady.accept(RectHelper_androidKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public void onScrollCaptureStart(@NotNull ScrollCaptureSession session, @NotNull CancellationSignal signal, @NotNull Runnable onReady) {
        this.scrollTracker.reset();
        this.requestCount = 0;
        this.listener.onSessionStarted();
        onReady.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, IntRect intRect, Continuation<? super IntRect> continuation) {
        C22162 c22162;
        int top;
        int bottom;
        ComposeScrollCaptureCallback composeScrollCaptureCallback;
        IntRect intRect2;
        int i;
        ComposeScrollCaptureCallback composeScrollCaptureCallback2;
        ScrollCaptureSession scrollCaptureSession2;
        int i2;
        int iMapOffsetToViewport;
        int iMapOffsetToViewport2;
        if (continuation instanceof C22162) {
            c22162 = (C22162) continuation;
            int i4 = c22162.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c22162.label = i4 - Integer.MIN_VALUE;
            } else {
                c22162 = new C22162(continuation);
            }
        }
        Object obj = c22162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c22162.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            top = intRect.getTop();
            bottom = intRect.getBottom();
            RelativeScroller relativeScroller = this.scrollTracker;
            c22162.L$0 = this;
            c22162.L$1 = scrollCaptureSession;
            c22162.L$2 = intRect;
            c22162.I$0 = top;
            c22162.I$1 = bottom;
            c22162.label = 1;
            if (relativeScroller.scrollRangeIntoView(top, bottom, c22162) != coroutine_suspended) {
                composeScrollCaptureCallback = this;
            }
            return coroutine_suspended;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = c22162.I$1;
            i = c22162.I$0;
            intRect2 = (IntRect) c22162.L$2;
            ScrollCaptureSession scrollCaptureSessionM1353j = AbstractC2027a.m1353j(c22162.L$1);
            composeScrollCaptureCallback2 = (ComposeScrollCaptureCallback) c22162.L$0;
            ResultKt.throwOnFailure(obj);
            scrollCaptureSession2 = scrollCaptureSessionM1353j;
            iMapOffsetToViewport = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i);
            iMapOffsetToViewport2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i2);
            IntRect intRectCopy$default = IntRect.copy$default(intRect2, 0, iMapOffsetToViewport, 0, iMapOffsetToViewport2, 5, null);
            if (iMapOffsetToViewport != iMapOffsetToViewport2) {
                return IntRect.INSTANCE.getZero();
            }
            NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = composeScrollCaptureCallback2.node.findCoordinatorToGetBounds$ui_release();
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release == null) {
                throw new IllegalStateException("Could not find coordinator for semantics node.");
            }
            Canvas canvasLockHardwareCanvas = scrollCaptureSession2.getSurface().lockHardwareCanvas();
            try {
                BlendMode unused = BlendMode.CLEAR;
                canvasLockHardwareCanvas.drawColor(0, BlendMode.CLEAR);
                androidx.compose.p109ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(canvasLockHardwareCanvas);
                Canvas.translate(-intRectCopy$default.getLeft(), -intRectCopy$default.getTop());
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release.draw(Canvas, null);
                scrollCaptureSession2.getSurface().unlockCanvasAndPost(canvasLockHardwareCanvas);
                return intRectCopy$default.translate(0, MathKt.roundToInt(composeScrollCaptureCallback2.scrollTracker.getScrollAmount()));
            } catch (Throwable th) {
                scrollCaptureSession2.getSurface().unlockCanvasAndPost(canvasLockHardwareCanvas);
                throw th;
            }
        }
        int i6 = c22162.I$1;
        int i7 = c22162.I$0;
        IntRect intRect3 = (IntRect) c22162.L$2;
        ScrollCaptureSession scrollCaptureSessionM1353j2 = AbstractC2027a.m1353j(c22162.L$1);
        composeScrollCaptureCallback = (ComposeScrollCaptureCallback) c22162.L$0;
        ResultKt.throwOnFailure(obj);
        top = i7;
        intRect = intRect3;
        bottom = i6;
        scrollCaptureSession = scrollCaptureSessionM1353j2;
        C22173 c22173 = new Function1<Long, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.onScrollCaptureImageRequest.3
            public final void invoke(long j) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }
        };
        c22162.L$0 = composeScrollCaptureCallback;
        c22162.L$1 = scrollCaptureSession;
        c22162.L$2 = intRect;
        c22162.I$0 = top;
        c22162.I$1 = bottom;
        c22162.label = 2;
        if (MonotonicFrameClockKt.withFrameNanos(c22173, c22162) != coroutine_suspended) {
            intRect2 = intRect;
            i = top;
            composeScrollCaptureCallback2 = composeScrollCaptureCallback;
            scrollCaptureSession2 = scrollCaptureSession;
            i2 = bottom;
            iMapOffsetToViewport = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i);
            iMapOffsetToViewport2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i2);
            IntRect intRectCopy$default2 = IntRect.copy$default(intRect2, 0, iMapOffsetToViewport, 0, iMapOffsetToViewport2, 5, null);
            if (iMapOffsetToViewport != iMapOffsetToViewport2) {
            }
        }
        return coroutine_suspended;
    }
}
