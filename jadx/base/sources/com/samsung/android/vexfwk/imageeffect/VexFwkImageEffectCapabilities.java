package com.samsung.android.vexfwk.imageeffect;

import com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities;", "Ljava/util/LinkedList;", "Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "()V", "capabilities", "", "([I)V", "", "(Ljava/util/List;)V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkImageEffectCapabilities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageEffectCapabilities.kt\ncom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,36:1\n13330#2,2:37\n*S KotlinDebug\n*F\n+ 1 VexFwkImageEffectCapabilities.kt\ncom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities\n*L\n29#1:37,2\n*E\n"})
public final class VexFwkImageEffectCapabilities extends LinkedList<ImageEffectType> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities;", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkImageEffectCapabilities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageEffectCapabilities.kt\ncom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1855#2,2:37\n*S KotlinDebug\n*F\n+ 1 VexFwkImageEffectCapabilities.kt\ncom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities$Companion\n*L\n22#1:37,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkImageEffectCapabilities> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public VexFwkImageEffectCapabilities fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i = buffer.getInt();
            if (buffer.remaining() != i * 4) {
                throw new IllegalStateException("Check failed.");
            }
            VexFwkImageEffectCapabilities vexFwkImageEffectCapabilities = new VexFwkImageEffectCapabilities();
            for (int i2 = 0; i2 < i; i2++) {
                vexFwkImageEffectCapabilities.add(ImageEffectType.INSTANCE.fromInt(buffer.getInt()));
            }
            return vexFwkImageEffectCapabilities;
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkImageEffectCapabilities value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer((value.size() + 1) * 4);
            byteBufferAllocateBuffer.putInt(value.size());
            Iterator<ImageEffectType> it = value.iterator();
            while (it.hasNext()) {
                byteBufferAllocateBuffer.putInt(it.next().getValue());
            }
            return byteBufferAllocateBuffer;
        }
    }

    public VexFwkImageEffectCapabilities() {
    }

    public /* bridge */ boolean contains(ImageEffectType imageEffectType) {
        return super.contains((Object) imageEffectType);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(ImageEffectType imageEffectType) {
        return super.indexOf((Object) imageEffectType);
    }

    public /* bridge */ int lastIndexOf(ImageEffectType imageEffectType) {
        return super.lastIndexOf((Object) imageEffectType);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ ImageEffectType remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ ImageEffectType removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    public VexFwkImageEffectCapabilities(@NotNull int[] capabilities) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        for (int i : capabilities) {
            add(ImageEffectType.INSTANCE.fromInt(i));
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ImageEffectType) {
            return contains((ImageEffectType) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ImageEffectType) {
            return indexOf((ImageEffectType) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ImageEffectType) {
            return lastIndexOf((ImageEffectType) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(ImageEffectType imageEffectType) {
        return super.remove((Object) imageEffectType);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof ImageEffectType) {
            return remove((ImageEffectType) obj);
        }
        return false;
    }

    public VexFwkImageEffectCapabilities(@NotNull List<? extends ImageEffectType> capabilities) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        addAll(capabilities);
    }
}
