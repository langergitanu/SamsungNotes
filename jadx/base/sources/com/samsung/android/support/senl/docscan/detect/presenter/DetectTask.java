package com.samsung.android.support.senl.docscan.detect.presenter;

import android.media.Image;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.detect.controller.DetectLibWrapper;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/presenter/DetectTask;", "Ljava/lang/Runnable;", "mImage", "Landroid/media/Image;", "mPreviewBuffer", "Ljava/nio/ByteBuffer;", "mContract", "Lcom/samsung/android/support/senl/docscan/detect/presenter/DetectTask$Contract;", "<init>", "(Landroid/media/Image;Ljava/nio/ByteBuffer;Lcom/samsung/android/support/senl/docscan/detect/presenter/DetectTask$Contract;)V", "run", "", "convertYuvToNV21", "", "src", "dst", "Contract", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DetectTask implements Runnable {

    @NotNull
    private static final String TAG = "DetectTask";

    @NotNull
    private final Contract mContract;

    @NotNull
    private final Image mImage;

    @NotNull
    private final ByteBuffer mPreviewBuffer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/presenter/DetectTask$Contract;", "", "isRunningDetectLib", "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        boolean isRunningDetectLib();
    }

    public DetectTask(@NotNull Image mImage, @NotNull ByteBuffer mPreviewBuffer, @NotNull Contract mContract) {
        Intrinsics.checkNotNullParameter(mImage, "mImage");
        Intrinsics.checkNotNullParameter(mPreviewBuffer, "mPreviewBuffer");
        Intrinsics.checkNotNullParameter(mContract, "mContract");
        this.mImage = mImage;
        this.mPreviewBuffer = mPreviewBuffer;
        this.mContract = mContract;
    }

    private final byte[] convertYuvToNV21(Image src, ByteBuffer dst) {
        Image.Plane[] planes = src.getPlanes();
        ByteBuffer[] byteBufferArr = new ByteBuffer[3];
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        int length = planes.length;
        for (int i = 0; i < length; i++) {
            byteBufferArr[i] = planes[i].getBuffer();
            iArr[i] = planes[i].getRowStride();
            iArr2[i] = planes[i].getPixelStride();
        }
        byte[] bArr = new byte[dst.remaining()];
        dst.get(bArr);
        DetectLibWrapper.convertYuvToNV21(byteBufferArr, bArr, src.getWidth(), src.getHeight(), iArr, iArr2);
        return bArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                int width = this.mImage.getWidth();
                int height = this.mImage.getHeight();
                ByteBuffer byteBufferAllocateDirectBuffer = DetectLibWrapper.allocateDirectBuffer(((width * height) * 3) / 2);
                if (byteBufferAllocateDirectBuffer == null) {
                    Logger.m7146e(TAG, "Failed to allocate native buffer");
                } else {
                    try {
                        byteBufferAllocateDirectBuffer.put(this.mPreviewBuffer);
                        byteBufferAllocateDirectBuffer.rewind();
                        byte[] bArrConvertYuvToNV21 = convertYuvToNV21(this.mImage, byteBufferAllocateDirectBuffer);
                        if (this.mContract.isRunningDetectLib()) {
                            DetectLibWrapper.tracking(width, height, bArrConvertYuvToNV21);
                        } else {
                            Logger.m7146e(TAG, "Detect library is not running");
                        }
                    } finally {
                        DetectLibWrapper.releaseDirectBuffer(byteBufferAllocateDirectBuffer);
                    }
                }
            } finally {
                this.mImage.close();
            }
        } catch (IllegalStateException e) {
            Logger.m7146e(TAG, "Image is already closed " + e);
        }
    }
}
