package com.samsung.android.sesl.renderEffectImageFilter;

import android.graphics.Bitmap;
import android.graphics.HardwareRenderer;
import android.graphics.RenderNode;
import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.pen.engine.drawLoop.AbstractC7448b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sesl/renderEffectImageFilter/Utils;", "", "()V", SearchConstants.TargetContents.TAG, "", "captureRenderNodeWithImageReader", "Landroid/graphics/Bitmap;", "renderNode", "Landroid/graphics/RenderNode;", "imageToBitmap", "image", "Landroid/media/Image;", "width", "", "height", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/samsung/android/sesl/renderEffectImageFilter/Utils\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,77:1\n90#2,6:78\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/samsung/android/sesl/renderEffectImageFilter/Utils\n*L\n69#1:78,6\n*E\n"})
public final class Utils {

    @NotNull
    public static final Utils INSTANCE = new Utils();

    @NotNull
    private static final String TAG = "Utils";

    private Utils() {
    }

    private final Bitmap imageToBitmap(Image image, int width, int height) {
        Image.Plane plane = image.getPlanes()[0];
        ByteBuffer buffer = plane.getBuffer();
        int pixelStride = plane.getPixelStride();
        int rowStride = plane.getRowStride() - (pixelStride * width);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((rowStride / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
        if (rowStride == 0) {
            return bitmapCreateBitmap;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        return bitmapCreateBitmap2;
    }

    @RequiresApi(api = 29)
    @Nullable
    public final Bitmap captureRenderNodeWithImageReader(@NotNull RenderNode renderNode) {
        Bitmap bitmapImageToBitmap;
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        try {
            int width = renderNode.getWidth();
            int height = renderNode.getHeight();
            if (width > 0 && height > 0) {
                ImageReader imageReaderNewInstance = ImageReader.newInstance(width, height, 1, 3);
                Intrinsics.checkNotNullExpressionValue(imageReaderNewInstance, "newInstance(...)");
                Surface surface = imageReaderNewInstance.getSurface();
                AbstractC7448b.m5855D();
                HardwareRenderer hardwareRendererM5860e = AbstractC7448b.m5860e();
                hardwareRendererM5860e.setSurface(surface);
                hardwareRendererM5860e.setContentRoot(renderNode);
                HardwareRenderer.FrameRenderRequest frameRenderRequestCreateRenderRequest = hardwareRendererM5860e.createRenderRequest();
                Intrinsics.checkNotNullExpressionValue(frameRenderRequestCreateRenderRequest, "createRenderRequest(...)");
                frameRenderRequestCreateRenderRequest.setWaitForPresent(true);
                frameRenderRequestCreateRenderRequest.syncAndDraw();
                Image imageAcquireLatestImage = imageReaderNewInstance.acquireLatestImage();
                if (imageAcquireLatestImage != null) {
                    bitmapImageToBitmap = imageToBitmap(imageAcquireLatestImage, width, height);
                    imageAcquireLatestImage.close();
                } else {
                    bitmapImageToBitmap = null;
                }
                imageReaderNewInstance.close();
                surface.release();
                hardwareRendererM5860e.destroy();
                return bitmapImageToBitmap;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
