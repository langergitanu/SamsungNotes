package com.samsung.android.vexfwk.param;

import android.graphics.Rect;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.vexfwk.imageclipper.VexFwkImageClipperResultCode;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkImageClipperInfo;", "", "objectsRect", "", "Landroid/graphics/Rect;", "singleRect", "resultCode", "Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;", "([Landroid/graphics/Rect;Landroid/graphics/Rect;Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;)V", "getObjectsRect", "()[Landroid/graphics/Rect;", "[Landroid/graphics/Rect;", "getResultCode", "()Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;", "getSingleRect", "()Landroid/graphics/Rect;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkImageClipperInfo {
    private static final int CLIPPER_INFO_OBJ_SIZE = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int RECT_SIZE = 16;

    @Nullable
    private final Rect[] objectsRect;

    @NotNull
    private final VexFwkImageClipperResultCode resultCode;

    @Nullable
    private final Rect singleRect;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkImageClipperInfo$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkImageClipperInfo;", "()V", "CLIPPER_INFO_OBJ_SIZE", "", "RECT_SIZE", "calculateSize", "value", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkImageClipperInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageClipperInfo.kt\ncom/samsung/android/vexfwk/param/VexFwkImageClipperInfo$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,82:1\n37#2,2:83\n13309#3,2:85\n*S KotlinDebug\n*F\n+ 1 VexFwkImageClipperInfo.kt\ncom/samsung/android/vexfwk/param/VexFwkImageClipperInfo$Companion\n*L\n32#1:83,2\n50#1:85,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkImageClipperInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int calculateSize(VexFwkImageClipperInfo value) {
            Rect[] objectsRect = value.getObjectsRect();
            int length = objectsRect != null ? (objectsRect.length * 16) + 4 : 4;
            if (value.getSingleRect() != null) {
                length += 16;
            }
            return length + 4;
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public VexFwkImageClipperInfo fromBuffer(@NotNull ByteBuffer buffer) {
            Rect[] rectArr;
            Rect rect;
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i = buffer.getInt();
            if (i != buffer.remaining()) {
                throw new IllegalStateException(AbstractC1038a.m1214o(i, buffer.remaining(), "buffer capacity must be ", ". buffer capacity is ").toString());
            }
            int i2 = buffer.getInt();
            if (i2 > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i4 = 0; i4 < i2; i4++) {
                    linkedList.add(new Rect(buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt()));
                }
                rectArr = (Rect[]) linkedList.toArray(new Rect[0]);
                rect = new Rect(buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt());
            } else {
                rectArr = null;
                rect = null;
            }
            return new VexFwkImageClipperInfo(rectArr, rect, VexFwkImageClipperResultCode.INSTANCE.fromInt(buffer.getInt()));
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkImageClipperInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int iCalculateSize = calculateSize(value);
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer(iCalculateSize + 4);
            byteBufferAllocateBuffer.putInt(iCalculateSize);
            Rect[] objectsRect = value.getObjectsRect();
            if (objectsRect != null) {
                byteBufferAllocateBuffer.putInt(objectsRect.length);
                for (Rect rect : objectsRect) {
                    byteBufferAllocateBuffer.putInt(rect.left);
                    byteBufferAllocateBuffer.putInt(rect.top);
                    byteBufferAllocateBuffer.putInt(rect.right);
                    byteBufferAllocateBuffer.putInt(rect.bottom);
                }
            } else {
                byteBufferAllocateBuffer.putInt(0);
            }
            Rect singleRect = value.getSingleRect();
            if (singleRect != null) {
                byteBufferAllocateBuffer.putInt(singleRect.left);
                byteBufferAllocateBuffer.putInt(singleRect.top);
                byteBufferAllocateBuffer.putInt(singleRect.right);
                byteBufferAllocateBuffer.putInt(singleRect.bottom);
            }
            byteBufferAllocateBuffer.putInt(value.getResultCode().getValue());
            return byteBufferAllocateBuffer;
        }
    }

    public VexFwkImageClipperInfo(@Nullable Rect[] rectArr, @Nullable Rect rect, @NotNull VexFwkImageClipperResultCode resultCode) {
        Intrinsics.checkNotNullParameter(resultCode, "resultCode");
        this.objectsRect = rectArr;
        this.singleRect = rect;
        this.resultCode = resultCode;
    }

    @Nullable
    public final Rect[] getObjectsRect() {
        return this.objectsRect;
    }

    @NotNull
    public final VexFwkImageClipperResultCode getResultCode() {
        return this.resultCode;
    }

    @Nullable
    public final Rect getSingleRect() {
        return this.singleRect;
    }
}
