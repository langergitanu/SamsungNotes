package androidx.test.core.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.test.platform.graphics.HardwareRendererCompat;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a!\u0010\b\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a)\u0010\t\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0001H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m13886d2 = {"captureRegionToBitmap", "Landroid/graphics/Bitmap;", "Landroid/view/Window;", "boundsInWindow", "Landroid/graphics/Rect;", "(Landroid/view/Window;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureRegionToBitmapAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "generateBitmap", "generateBitmapFromPixelCopy", "destBitmap", "(Landroid/view/Window;Landroid/graphics/Rect;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_java_androidx_test_core-core_internal_kt"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = "WindowCapture")
@SourceDebugExtension({"SMAP\nWindowCapture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowCapture.kt\nandroidx/test/core/view/WindowCapture\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,114:1\n314#2,11:115\n*S KotlinDebug\n*F\n+ 1 WindowCapture.kt\nandroidx/test/core/view/WindowCapture\n*L\n95#1:115,11\n*E\n"})
public final class WindowCapture {

    /* JADX INFO: renamed from: androidx.test.core.view.WindowCapture$captureRegionToBitmap$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.view.WindowCapture", m14021f = "WindowCapture.kt", m14022i = {0, 0, 0, 1}, m14023l = {57, 58}, m14024m = "captureRegionToBitmap", m14025n = {"$this$captureRegionToBitmap", "boundsInWindow", "hardwareDrawingEnabled", "hardwareDrawingEnabled"}, m14026s = {"L$0", "L$1", "Z$0", "Z$0"})
    public static final class C39071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C39071(Continuation<? super C39071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WindowCapture.captureRegionToBitmap(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.test.core.view.WindowCapture$captureRegionToBitmapAsync$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.view.WindowCapture$captureRegionToBitmapAsync$1", m14021f = "WindowCapture.kt", m14022i = {}, m14023l = {69}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C39081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Rect $boundsInWindow;
        final /* synthetic */ Window $this_captureRegionToBitmapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C39081(Window window, Rect rect, Continuation<? super C39081> continuation) {
            super(2, continuation);
            this.$this_captureRegionToBitmapAsync = window;
            this.$boundsInWindow = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C39081(this.$this_captureRegionToBitmapAsync, this.$boundsInWindow, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Window window = this.$this_captureRegionToBitmapAsync;
            Rect rect = this.$boundsInWindow;
            this.label = 1;
            Object objCaptureRegionToBitmap = WindowCapture.captureRegionToBitmap(window, rect, this);
            return objCaptureRegionToBitmap == coroutine_suspended ? coroutine_suspended : objCaptureRegionToBitmap;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Bitmap> continuation) {
            return ((C39081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.test.core.view.WindowCapture$generateBitmap$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.test.core.view.WindowCapture", m14021f = "WindowCapture.kt", m14022i = {0}, m14023l = {84}, m14024m = "generateBitmap", m14025n = {"destBitmap"}, m14026s = {"L$0"})
    public static final class C39091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C39091(Continuation<? super C39091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WindowCapture.generateBitmap(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v7, types: [boolean] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object captureRegionToBitmap(@NotNull Window window, @Nullable Rect rect, @NotNull Continuation<? super Bitmap> continuation) throws Throwable {
        C39071 c39071;
        boolean zIsDrawingEnabled;
        Window window2;
        if (continuation instanceof C39071) {
            c39071 = (C39071) continuation;
            int i = c39071.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c39071.label = i - Integer.MIN_VALUE;
            } else {
                c39071 = new C39071(continuation);
            }
        }
        Object obj = c39071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c39071.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                zIsDrawingEnabled = HardwareRendererCompat.isDrawingEnabled();
                HardwareRendererCompat.setDrawingEnabled(true);
                try {
                    View decorView = window.getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
                    c39071.L$0 = window;
                    c39071.L$1 = rect;
                    c39071.Z$0 = zIsDrawingEnabled;
                    c39071.label = 1;
                    window2 = window;
                    if (ViewCapture.forceRedraw(decorView, c39071) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    window = zIsDrawingEnabled;
                    HardwareRendererCompat.setDrawingEnabled(window);
                    throw th;
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z = c39071.Z$0;
                ResultKt.throwOnFailure(obj);
                window = z;
                Bitmap bitmap = (Bitmap) obj;
                HardwareRendererCompat.setDrawingEnabled(window);
                Intrinsics.checkNotNull(bitmap);
                return bitmap;
            }
            boolean z2 = c39071.Z$0;
            rect = (Rect) c39071.L$1;
            Window window3 = (Window) c39071.L$0;
            ResultKt.throwOnFailure(obj);
            zIsDrawingEnabled = z2;
            window2 = window3;
            c39071.L$0 = null;
            c39071.L$1 = null;
            c39071.Z$0 = zIsDrawingEnabled;
            c39071.label = 2;
            Object objGenerateBitmap = generateBitmap(window2, rect, c39071);
            if (objGenerateBitmap != coroutine_suspended) {
                boolean z3 = zIsDrawingEnabled;
                obj = objGenerateBitmap;
                window = z3;
                Bitmap bitmap2 = (Bitmap) obj;
                HardwareRendererCompat.setDrawingEnabled(window);
                Intrinsics.checkNotNull(bitmap2);
                return bitmap2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ Object captureRegionToBitmap$default(Window window, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return captureRegionToBitmap(window, rect, continuation);
    }

    @NotNull
    public static final ListenableFuture<Bitmap> captureRegionToBitmapAsync(@NotNull Window window, @Nullable Rect rect) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        return SuspendToFutureAdapter.launchFuture$default(SuspendToFutureAdapter.INSTANCE, Dispatchers.getMain(), false, new C39081(window, rect, null), 2, null);
    }

    public static /* synthetic */ ListenableFuture captureRegionToBitmapAsync$default(Window window, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return captureRegionToBitmapAsync(window, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object generateBitmap(@NotNull Window window, @Nullable Rect rect, @NotNull Continuation<? super Bitmap> continuation) {
        C39091 c39091;
        if (continuation instanceof C39091) {
            c39091 = (C39091) continuation;
            int i = c39091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c39091.label = i - Integer.MIN_VALUE;
            } else {
                c39091 = new C39091(continuation);
            }
        }
        Object obj = c39091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c39091.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Bitmap bitmap = (Bitmap) c39091.L$0;
            ResultKt.throwOnFailure(obj);
            return bitmap;
        }
        ResultKt.throwOnFailure(obj);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect != null ? rect.width() : window.getDecorView().getWidth(), rect != null ? rect.height() : window.getDecorView().getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n      boun…p.Config.ARGB_8888,\n    )");
        c39091.L$0 = bitmapCreateBitmap;
        c39091.label = 1;
        return generateBitmapFromPixelCopy(window, rect, bitmapCreateBitmap, c39091) == coroutine_suspended ? coroutine_suspended : bitmapCreateBitmap;
    }

    public static /* synthetic */ Object generateBitmap$default(Window window, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return generateBitmap(window, rect, continuation);
    }

    @RequiresApi(26)
    @Nullable
    public static final Object generateBitmapFromPixelCopy(@NotNull Window window, @Nullable Rect rect, @NotNull final Bitmap bitmap, @NotNull Continuation<? super Bitmap> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        PixelCopy.request(window, rect, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.test.core.view.WindowCapture$generateBitmapFromPixelCopy$2$onCopyFinished$1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                if (i == 0) {
                    cancellableContinuationImpl.resume(bitmap, new Function1<Throwable, Unit>() { // from class: androidx.test.core.view.WindowCapture$generateBitmapFromPixelCopy$2$onCopyFinished$1.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new RuntimeException(AbstractC0000a.m11h(i, "PixelCopy failed: ")))));
            }
        }, new Handler(Looper.getMainLooper()));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object generateBitmapFromPixelCopy$default(Window window, Rect rect, Bitmap bitmap, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return generateBitmapFromPixelCopy(window, rect, bitmap, continuation);
    }
}
