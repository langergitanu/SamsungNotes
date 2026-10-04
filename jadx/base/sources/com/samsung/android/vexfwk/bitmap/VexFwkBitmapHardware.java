package com.samsung.android.vexfwk.bitmap;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J.\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0007R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/bitmap/VexFwkBitmapHardware;", "Ljava/lang/AutoCloseable;", "width", "", "height", "format", "pixels", "", "(III[I)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "getHeight", "()I", "getWidth", "close", "", "toBitmapCropped", "left", "top", "right", "bottom", ExternalDataConstants.EmbeddingConfig.KEY, "Landroid/graphics/Bitmap$Config;", "toIntArray", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkBitmapHardware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkBitmapHardware.kt\ncom/samsung/android/vexfwk/bitmap/VexFwkBitmapHardware\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class VexFwkBitmapHardware implements AutoCloseable {

    @SuppressLint({"NewAPi"})
    @NotNull
    private final Bitmap bitmap;

    @NotNull
    private final HardwareBuffer hardwareBuffer;
    private final int height;
    private final int width;

    public VexFwkBitmapHardware(int i, int i2, int i4, @Nullable int[] iArr) {
        HardwareBuffer hardwareBufferCreate = HardwareBuffer.create(i, i2, i4, 1, 307L);
        Intrinsics.checkNotNullExpressionValue(hardwareBufferCreate, "create(...)");
        this.hardwareBuffer = hardwareBufferCreate;
        Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBufferCreate, null);
        Intrinsics.checkNotNull(bitmapWrapHardwareBuffer);
        this.bitmap = bitmapWrapHardwareBuffer;
        this.width = bitmapWrapHardwareBuffer.getWidth();
        this.height = bitmapWrapHardwareBuffer.getHeight();
        if (iArr != null) {
            VexFwkBitmap.INSTANCE.copyBitmap(iArr, bitmapWrapHardwareBuffer);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.bitmap.recycle();
        this.hardwareBuffer.close();
    }

    @NotNull
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final HardwareBuffer getHardwareBuffer() {
        return this.hardwareBuffer;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public final Bitmap toBitmapCropped(int left, int top, int right, int bottom, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(right - left, bottom - top, config);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        VexFwkBitmap.INSTANCE.copyBitmap(this.bitmap, bitmapCreateBitmap, left, top, right, bottom);
        return bitmapCreateBitmap;
    }

    @NotNull
    public final int[] toIntArray() {
        int[] iArr = new int[this.width * this.height];
        VexFwkBitmap.INSTANCE.copyBitmap(this.bitmap, iArr);
        return iArr;
    }
}
