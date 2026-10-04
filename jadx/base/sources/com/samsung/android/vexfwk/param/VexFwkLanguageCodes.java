package com.samsung.android.vexfwk.param;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkLanguageCodes;", "Ljava/util/LinkedList;", "", "elements", "(Ljava/util/LinkedList;)V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkLanguageCodes extends LinkedList<String> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkLanguageCodes$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageCodes;", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkLanguageCodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkLanguageCodes.kt\ncom/samsung/android/vexfwk/param/VexFwkLanguageCodes$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n1#2:45\n1855#3,2:46\n*S KotlinDebug\n*F\n+ 1 VexFwkLanguageCodes.kt\ncom/samsung/android/vexfwk/param/VexFwkLanguageCodes$Companion\n*L\n32#1:46,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkLanguageCodes> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public VexFwkLanguageCodes fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            LinkedList linkedList = new LinkedList();
            int i = buffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                byte[] bArr = new byte[buffer.getInt()];
                buffer.get(bArr);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                linkedList.add(new String(bArr, UTF_8));
            }
            return new VexFwkLanguageCodes(linkedList);
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkLanguageCodes value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int length = 0;
            for (String str : value) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = str.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                length += bytes.length + 4;
            }
            ByteBuffer byteBufferPutInt = allocateBuffer(4 + length).order(ByteOrder.nativeOrder()).putInt(value.size());
            for (String str2 : value) {
                Charset UTF_82 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                byte[] bytes2 = str2.getBytes(UTF_82);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                byteBufferPutInt.putInt(bytes2.length);
                byteBufferPutInt.put(bytes2);
            }
            Intrinsics.checkNotNullExpressionValue(byteBufferPutInt, "apply(...)");
            return byteBufferPutInt;
        }
    }

    public VexFwkLanguageCodes(@NotNull LinkedList<String> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(elements);
    }

    @JvmStatic
    @NotNull
    public static VexFwkLanguageCodes fromBuffer(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.fromBuffer(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static ByteBuffer toBuffer(@NotNull VexFwkLanguageCodes vexFwkLanguageCodes) {
        return INSTANCE.toBuffer(vexFwkLanguageCodes);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return contains((String) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return indexOf((String) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return lastIndexOf((String) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ String remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ String removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(String str) {
        return super.contains((Object) str);
    }

    public /* bridge */ int indexOf(String str) {
        return super.indexOf((Object) str);
    }

    public /* bridge */ int lastIndexOf(String str) {
        return super.lastIndexOf((Object) str);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str) {
        return super.remove((Object) str);
    }
}
