package com.samsung.android.vexfwk.param;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.vexfwk.param.VexFwkWineBoxInfo;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkWineInfo;", "Ljava/util/LinkedList;", "Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo;", "()V", "array", "(Ljava/util/LinkedList;)V", "toString", "", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkWineInfo extends LinkedList<VexFwkWineBoxInfo> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int WINE_ARRAY_SIZE = 4;
    private static final int WINE_MEMBERS_SIZE = 36;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkWineInfo$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkWineInfo;", "()V", "WINE_ARRAY_SIZE", "", "WINE_MEMBERS_SIZE", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkWineInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkWineInfo.kt\ncom/samsung/android/vexfwk/param/VexFwkWineInfo$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1855#2,2:66\n*S KotlinDebug\n*F\n+ 1 VexFwkWineInfo.kt\ncom/samsung/android/vexfwk/param/VexFwkWineInfo$Companion\n*L\n35#1:66,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkWineInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public VexFwkWineInfo fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i = buffer.getInt();
            if (i * 36 != buffer.remaining()) {
                throw new IllegalStateException("Check failed.");
            }
            VexFwkWineInfo vexFwkWineInfo = new VexFwkWineInfo();
            for (int i2 = 0; i2 < i; i2++) {
                vexFwkWineInfo.add(new VexFwkWineBoxInfo(buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getFloat(), VexFwkWineBoxInfo.Tag.INSTANCE.toTag(buffer.getInt()), buffer.getInt(), buffer.getInt(), buffer.getInt()));
            }
            return vexFwkWineInfo;
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkWineInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer((value.size() * 36) + 4);
            byteBufferAllocateBuffer.putInt(value.size());
            for (VexFwkWineBoxInfo vexFwkWineBoxInfo : value) {
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getLeft());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getTop());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getRight());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getBottom());
                byteBufferAllocateBuffer.putFloat(vexFwkWineBoxInfo.getScore());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getTag().getValue());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getHeight());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getWidth());
                byteBufferAllocateBuffer.putInt(vexFwkWineBoxInfo.getTrackId());
            }
            return byteBufferAllocateBuffer;
        }
    }

    public VexFwkWineInfo() {
    }

    public /* bridge */ boolean contains(VexFwkWineBoxInfo vexFwkWineBoxInfo) {
        return super.contains((Object) vexFwkWineBoxInfo);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(VexFwkWineBoxInfo vexFwkWineBoxInfo) {
        return super.indexOf((Object) vexFwkWineBoxInfo);
    }

    public /* bridge */ int lastIndexOf(VexFwkWineBoxInfo vexFwkWineBoxInfo) {
        return super.lastIndexOf((Object) vexFwkWineBoxInfo);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ VexFwkWineBoxInfo remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ VexFwkWineBoxInfo removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (VexFwkWineBoxInfo vexFwkWineBoxInfo : this) {
            int left = vexFwkWineBoxInfo.getLeft();
            int top = vexFwkWineBoxInfo.getTop();
            int right = vexFwkWineBoxInfo.getRight();
            int bottom = vexFwkWineBoxInfo.getBottom();
            float score = vexFwkWineBoxInfo.getScore();
            int value = vexFwkWineBoxInfo.getTag().getValue();
            int height = vexFwkWineBoxInfo.getHeight();
            int width = vexFwkWineBoxInfo.getWidth();
            int trackId = vexFwkWineBoxInfo.getTrackId();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(left, top, "left: ", ", top: ", ", right: ");
            AbstractC2821a.m2235z(sbM1173s, right, bottom, ", bottom: ", ", score: ");
            sbM1173s.append(score);
            sbM1173s.append(", tag: ");
            sbM1173s.append(value);
            sbM1173s.append(", height: ");
            AbstractC2821a.m2235z(sbM1173s, height, width, ", width: ", ", trackId: ");
            sbM1173s.append(trackId);
            sbM1173s.append(SequenceUtils.SPACE_EOL);
            sb.append(sbM1173s.toString());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public VexFwkWineInfo(@NotNull LinkedList<VexFwkWineBoxInfo> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        addAll(array);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof VexFwkWineBoxInfo) {
            return contains((VexFwkWineBoxInfo) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof VexFwkWineBoxInfo) {
            return indexOf((VexFwkWineBoxInfo) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof VexFwkWineBoxInfo) {
            return lastIndexOf((VexFwkWineBoxInfo) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(VexFwkWineBoxInfo vexFwkWineBoxInfo) {
        return super.remove((Object) vexFwkWineBoxInfo);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof VexFwkWineBoxInfo) {
            return remove((VexFwkWineBoxInfo) obj);
        }
        return false;
    }
}
