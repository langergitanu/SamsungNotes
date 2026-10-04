package com.samsung.android.vexfwk.imagetranslation;

import com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities;", "Ljava/util/LinkedList;", "", "elements", "(Ljava/util/LinkedList;)V", "", "([I)V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkIImageTranslatorCapabilities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkIImageTranslatorCapabilities.kt\ncom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,35:1\n13330#2,2:36\n*S KotlinDebug\n*F\n+ 1 VexFwkIImageTranslatorCapabilities.kt\ncom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities\n*L\n32#1:36,2\n*E\n"})
public final class VexFwkIImageTranslatorCapabilities extends LinkedList<Integer> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities;", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkIImageTranslatorCapabilities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkIImageTranslatorCapabilities.kt\ncom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1855#2,2:36\n*S KotlinDebug\n*F\n+ 1 VexFwkIImageTranslatorCapabilities.kt\ncom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities$Companion\n*L\n23#1:36,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkIImageTranslatorCapabilities> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public VexFwkIImageTranslatorCapabilities fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            LinkedList linkedList = new LinkedList();
            int i = buffer.getInt();
            if (buffer.remaining() != i * 4) {
                throw new IllegalStateException("Check failed.");
            }
            for (int i2 = 0; i2 < i; i2++) {
                linkedList.add(Integer.valueOf(buffer.getInt()));
            }
            return new VexFwkIImageTranslatorCapabilities((LinkedList<Integer>) linkedList);
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkIImageTranslatorCapabilities value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer((value.size() + 1) * 4);
            byteBufferAllocateBuffer.putInt(value.size());
            Iterator<Integer> it = value.iterator();
            while (it.hasNext()) {
                byteBufferAllocateBuffer.putInt(it.next().intValue());
            }
            return byteBufferAllocateBuffer;
        }
    }

    public VexFwkIImageTranslatorCapabilities(@NotNull LinkedList<Integer> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(elements);
    }

    public /* bridge */ boolean contains(Integer num) {
        return super.contains((Object) num);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(Integer num) {
        return super.indexOf((Object) num);
    }

    public /* bridge */ int lastIndexOf(Integer num) {
        return super.lastIndexOf((Object) num);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ Integer remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ Integer removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return contains((Integer) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return indexOf((Integer) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return lastIndexOf((Integer) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(Integer num) {
        return super.remove((Object) num);
    }

    public VexFwkIImageTranslatorCapabilities(@NotNull int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (int i : elements) {
            add(Integer.valueOf(i));
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof Integer) {
            return remove((Integer) obj);
        }
        return false;
    }
}
