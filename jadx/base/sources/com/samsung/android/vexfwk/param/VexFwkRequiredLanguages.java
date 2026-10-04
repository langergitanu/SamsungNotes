package com.samsung.android.vexfwk.param;

import com.samsung.android.vexfwk.imagetranslation.VexFwkLanguagePackInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkRequiredLanguages;", "Ljava/util/LinkedList;", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkLanguagePackInfo;", "elements", "(Ljava/util/LinkedList;)V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkRequiredLanguages extends LinkedList<VexFwkLanguagePackInfo> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkRequiredLanguages$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkRequiredLanguages;", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkRequiredLanguages.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkRequiredLanguages.kt\ncom/samsung/android/vexfwk/param/VexFwkRequiredLanguages$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1#2:46\n1855#3,2:47\n*S KotlinDebug\n*F\n+ 1 VexFwkRequiredLanguages.kt\ncom/samsung/android/vexfwk/param/VexFwkRequiredLanguages$Companion\n*L\n33#1:47,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkRequiredLanguages> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public VexFwkRequiredLanguages fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            LinkedList linkedList = new LinkedList();
            int i = buffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                byte[] bArr = new byte[buffer.getInt()];
                buffer.get(bArr);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                linkedList.add(new VexFwkLanguagePackInfo(new String(bArr, UTF_8)));
            }
            return new VexFwkRequiredLanguages(linkedList);
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkRequiredLanguages value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<VexFwkLanguagePackInfo> it = value.iterator();
            int length = 0;
            while (it.hasNext()) {
                String languagePackCode = it.next().getLanguagePackCode();
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = languagePackCode.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                length += bytes.length + 4;
            }
            ByteBuffer byteBufferPutInt = allocateBuffer(4 + length).order(ByteOrder.nativeOrder()).putInt(value.size());
            Iterator<VexFwkLanguagePackInfo> it2 = value.iterator();
            while (it2.hasNext()) {
                String languagePackCode2 = it2.next().getLanguagePackCode();
                Charset UTF_82 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                byte[] bytes2 = languagePackCode2.getBytes(UTF_82);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                byteBufferPutInt.putInt(bytes2.length);
                byteBufferPutInt.put(bytes2);
            }
            Intrinsics.checkNotNullExpressionValue(byteBufferPutInt, "apply(...)");
            return byteBufferPutInt;
        }
    }

    public VexFwkRequiredLanguages(@NotNull LinkedList<VexFwkLanguagePackInfo> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(elements);
    }

    @JvmStatic
    @NotNull
    public static VexFwkRequiredLanguages fromBuffer(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.fromBuffer(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static ByteBuffer toBuffer(@NotNull VexFwkRequiredLanguages vexFwkRequiredLanguages) {
        return INSTANCE.toBuffer(vexFwkRequiredLanguages);
    }

    public /* bridge */ boolean contains(VexFwkLanguagePackInfo vexFwkLanguagePackInfo) {
        return super.contains((Object) vexFwkLanguagePackInfo);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(VexFwkLanguagePackInfo vexFwkLanguagePackInfo) {
        return super.indexOf((Object) vexFwkLanguagePackInfo);
    }

    public /* bridge */ int lastIndexOf(VexFwkLanguagePackInfo vexFwkLanguagePackInfo) {
        return super.lastIndexOf((Object) vexFwkLanguagePackInfo);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ VexFwkLanguagePackInfo remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ VexFwkLanguagePackInfo removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof VexFwkLanguagePackInfo) {
            return contains((VexFwkLanguagePackInfo) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof VexFwkLanguagePackInfo) {
            return indexOf((VexFwkLanguagePackInfo) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof VexFwkLanguagePackInfo) {
            return lastIndexOf((VexFwkLanguagePackInfo) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(VexFwkLanguagePackInfo vexFwkLanguagePackInfo) {
        return super.remove((Object) vexFwkLanguagePackInfo);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof VexFwkLanguagePackInfo) {
            return remove((VexFwkLanguagePackInfo) obj);
        }
        return false;
    }
}
