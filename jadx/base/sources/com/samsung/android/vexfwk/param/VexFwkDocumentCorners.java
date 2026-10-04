package com.samsung.android.vexfwk.param;

import android.graphics.PointF;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u000eB\u0007\b\u0012¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0015\b\u0016\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0000H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "", "()V", "array", "", "([F)V", "points", "", "([Landroid/graphics/PointF;)V", "clone", "toString", "", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkDocumentCorners.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocumentCorners.kt\ncom/samsung/android/vexfwk/param/VexFwkDocumentCorners\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,54:1\n37#2,2:55\n*S KotlinDebug\n*F\n+ 1 VexFwkDocumentCorners.kt\ncom/samsung/android/vexfwk/param/VexFwkDocumentCorners\n*L\n50#1:55,2\n*E\n"})
public final class VexFwkDocumentCorners extends LinkedList<PointF> implements Cloneable {
    private static final int BUFFER_SIZE = 32;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int FLOAT_COUNT = 8;
    private static final int POINTF_COUNT = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;", "()V", "BUFFER_SIZE", "", "FLOAT_COUNT", "POINTF_COUNT", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkDocumentCorners.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocumentCorners.kt\ncom/samsung/android/vexfwk/param/VexFwkDocumentCorners$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n1855#2,2:55\n*S KotlinDebug\n*F\n+ 1 VexFwkDocumentCorners.kt\ncom/samsung/android/vexfwk/param/VexFwkDocumentCorners$Companion\n*L\n28#1:55,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkDocumentCorners> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public VexFwkDocumentCorners fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (buffer.capacity() != 32) {
                throw new IllegalStateException(AbstractC0000a.m11h(buffer.capacity(), "buffer capacity must be 32. buffer capacity is ").toString());
            }
            VexFwkDocumentCorners vexFwkDocumentCorners = new VexFwkDocumentCorners((DefaultConstructorMarker) null);
            for (int i = 0; i < 4; i++) {
                vexFwkDocumentCorners.add(new PointF(buffer.getFloat(), buffer.getFloat()));
            }
            return vexFwkDocumentCorners;
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkDocumentCorners value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer(32);
            for (PointF pointF : value) {
                byteBufferAllocateBuffer.putFloat(pointF.x);
                byteBufferAllocateBuffer.putFloat(pointF.y);
            }
            return byteBufferAllocateBuffer;
        }
    }

    public /* synthetic */ VexFwkDocumentCorners(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public /* bridge */ boolean contains(PointF pointF) {
        return super.contains((Object) pointF);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(PointF pointF) {
        return super.indexOf((Object) pointF);
    }

    public /* bridge */ int lastIndexOf(PointF pointF) {
        return super.lastIndexOf((Object) pointF);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ PointF remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ PointF removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        return CollectionsKt.m13955n(this, null, null, null, null, 63);
    }

    private VexFwkDocumentCorners() {
    }

    @Override // java.util.LinkedList
    @NotNull
    public VexFwkDocumentCorners clone() {
        return new VexFwkDocumentCorners((PointF[]) toArray(new PointF[0]));
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof PointF) {
            return contains((PointF) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof PointF) {
            return indexOf((PointF) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof PointF) {
            return lastIndexOf((PointF) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(PointF pointF) {
        return super.remove((Object) pointF);
    }

    public VexFwkDocumentCorners(@NotNull float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length != 8) {
            throw new IllegalStateException("Check failed.");
        }
        for (int i = 0; i < 4; i++) {
            int i2 = i * 2;
            add(new PointF(array[i2], array[i2 + 1]));
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof PointF) {
            return remove((PointF) obj);
        }
        return false;
    }

    public VexFwkDocumentCorners(@NotNull PointF[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        if (points.length == 4) {
            CollectionsKt__MutableCollectionsKt.addAll(this, points);
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}
