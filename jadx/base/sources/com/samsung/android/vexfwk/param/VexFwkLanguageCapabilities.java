package com.samsung.android.vexfwk.param;

import com.samsung.android.vexfwk.imagetranslation.VexFwkAvailableLanguage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities;", "Ljava/util/LinkedList;", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkAvailableLanguage;", "elements", "(Ljava/util/LinkedList;)V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkLanguageCapabilities extends LinkedList<VexFwkAvailableLanguage> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities;", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkLanguageCapabilities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkLanguageCapabilities.kt\ncom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n1549#2:56\n1620#2,3:57\n1855#2,2:60\n*S KotlinDebug\n*F\n+ 1 VexFwkLanguageCapabilities.kt\ncom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities$Companion\n*L\n34#1:56\n34#1:57,3\n43#1:60,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkLanguageCapabilities> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public VexFwkLanguageCapabilities fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            LinkedList linkedList = new LinkedList();
            int i = buffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                byte[] bArr = new byte[buffer.getInt()];
                buffer.get(bArr);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                String str = new String(bArr, UTF_8);
                boolean z = true;
                if (buffer.get() != 1) {
                    z = false;
                }
                linkedList.add(new VexFwkAvailableLanguage(str, z));
            }
            return new VexFwkLanguageCapabilities(linkedList);
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkLanguageCapabilities value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(value));
            Iterator<VexFwkAvailableLanguage> it = value.iterator();
            while (it.hasNext()) {
                String lang = it.next().getLang();
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = lang.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                arrayList.add(Integer.valueOf(bytes.length + 5));
            }
            ByteBuffer byteBufferPutInt = allocateBuffer(CollectionsKt___CollectionsKt.sumOfInt(arrayList) + 4).order(ByteOrder.nativeOrder()).putInt(value.size());
            for (VexFwkAvailableLanguage vexFwkAvailableLanguage : value) {
                String lang2 = vexFwkAvailableLanguage.getLang();
                Charset UTF_82 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                byte[] bytes2 = lang2.getBytes(UTF_82);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                byteBufferPutInt.putInt(bytes2.length);
                String lang3 = vexFwkAvailableLanguage.getLang();
                Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                byte[] bytes3 = lang3.getBytes(UTF_82);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                byteBufferPutInt.put(bytes3);
                byteBufferPutInt.put(vexFwkAvailableLanguage.getDownloadRequired() ? (byte) 1 : (byte) 0);
            }
            Intrinsics.checkNotNullExpressionValue(byteBufferPutInt, "apply(...)");
            return byteBufferPutInt;
        }
    }

    public VexFwkLanguageCapabilities(@NotNull LinkedList<VexFwkAvailableLanguage> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(elements);
    }

    @JvmStatic
    @NotNull
    public static VexFwkLanguageCapabilities fromBuffer(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.fromBuffer(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static ByteBuffer toBuffer(@NotNull VexFwkLanguageCapabilities vexFwkLanguageCapabilities) {
        return INSTANCE.toBuffer(vexFwkLanguageCapabilities);
    }

    public /* bridge */ boolean contains(VexFwkAvailableLanguage vexFwkAvailableLanguage) {
        return super.contains((Object) vexFwkAvailableLanguage);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(VexFwkAvailableLanguage vexFwkAvailableLanguage) {
        return super.indexOf((Object) vexFwkAvailableLanguage);
    }

    public /* bridge */ int lastIndexOf(VexFwkAvailableLanguage vexFwkAvailableLanguage) {
        return super.lastIndexOf((Object) vexFwkAvailableLanguage);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ VexFwkAvailableLanguage remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ VexFwkAvailableLanguage removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof VexFwkAvailableLanguage) {
            return contains((VexFwkAvailableLanguage) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof VexFwkAvailableLanguage) {
            return indexOf((VexFwkAvailableLanguage) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof VexFwkAvailableLanguage) {
            return lastIndexOf((VexFwkAvailableLanguage) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(VexFwkAvailableLanguage vexFwkAvailableLanguage) {
        return super.remove((Object) vexFwkAvailableLanguage);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof VexFwkAvailableLanguage) {
            return remove((VexFwkAvailableLanguage) obj);
        }
        return false;
    }
}
