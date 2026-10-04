package androidx.compose.p109ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.media.Image;
import android.media.ImageReader;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.core.os.HandlerCompat;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayerSnapshot.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayerSnapshot.android.kt\nandroidx/compose/ui/graphics/layer/LayerSnapshotV22\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,230:1\n314#2,11:231\n*S KotlinDebug\n*F\n+ 1 LayerSnapshot.android.kt\nandroidx/compose/ui/graphics/layer/LayerSnapshotV22\n*L\n90#1:231,11\n*E\n"})
public final class LayerSnapshotV22 implements LayerSnapshotImpl {

    @NotNull
    public static final LayerSnapshotV22 INSTANCE = new LayerSnapshotV22();

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.graphics.layer.LayerSnapshotV22", m14021f = "LayerSnapshot.android.kt", m14022i = {0, 0, 0, 0}, m14023l = {JPEG.APP7}, m14024m = "toBitmap", m14025n = {"graphicsLayer", "looper", "reader", "$completion$iv"}, m14026s = {"L$0", "L$1", "L$3", "L$4"})
    public static final class C20581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C20581(Continuation<? super C20581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayerSnapshotV22.this.toBitmap(null, this);
        }
    }

    private LayerSnapshotV22() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.p109ui.graphics.layer.LayerSnapshotImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object toBitmap(@NotNull GraphicsLayer graphicsLayer, @NotNull Continuation<? super Bitmap> continuation) {
        C20581 c20581;
        AutoCloseable autoCloseable;
        if (continuation instanceof C20581) {
            c20581 = (C20581) continuation;
            int i = c20581.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20581.label = i - Integer.MIN_VALUE;
            } else {
                c20581 = new C20581(continuation);
            }
        }
        Object result = c20581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20581.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(result);
            long size = graphicsLayer.getSize();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = Looper.getMainLooper();
            }
            ImageReader imageReaderNewInstance = ImageReader.newInstance(IntSize.m21138getWidthimpl(size), IntSize.m21137getHeightimpl(size), 1, 1);
            try {
                c20581.L$0 = graphicsLayer;
                c20581.L$1 = looperMyLooper;
                c20581.L$2 = imageReaderNewInstance;
                c20581.L$3 = imageReaderNewInstance;
                c20581.L$4 = c20581;
                c20581.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c20581), 1);
                cancellableContinuationImpl.initCancellability();
                imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader) {
                        CancellableContinuation<Image> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m22215constructorimpl(imageReader.acquireLatestImage()));
                    }
                }, HandlerCompat.createAsync(looperMyLooper));
                Surface surface = imageReaderNewInstance.getSurface();
                Canvas canvasLockCanvas = SurfaceUtils.INSTANCE.lockCanvas(surface);
                try {
                    canvasLockCanvas.drawColor(ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18551getBlack0d7_KjU()), PorterDuff.Mode.CLEAR);
                    graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(canvasLockCanvas), null);
                    surface.unlockCanvasAndPost(canvasLockCanvas);
                    result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c20581);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    autoCloseable = imageReaderNewInstance;
                } catch (Throwable th) {
                    surface.unlockCanvasAndPost(canvasLockCanvas);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                autoCloseable = imageReaderNewInstance;
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            autoCloseable = (AutoCloseable) c20581.L$2;
            try {
                ResultKt.throwOnFailure(result);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(autoCloseable, th);
                    throw th4;
                }
            }
        }
        Bitmap bitmap = LayerSnapshot_androidKt.toBitmap((Image) result);
        AutoCloseableKt.closeFinally(autoCloseable, null);
        return bitmap;
    }
}
