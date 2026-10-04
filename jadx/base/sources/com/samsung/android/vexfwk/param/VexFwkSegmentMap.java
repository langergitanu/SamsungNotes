package com.samsung.android.vexfwk.param;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkSegmentMap;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkSegmentMap {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int INT_SIZE = 4;
    private static final int STRING_LENGTH_SIZE = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkSegmentMap$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "", "", "", "()V", "INT_SIZE", "STRING_LENGTH_SIZE", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkSegmentMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSegmentMap.kt\ncom/samsung/android/vexfwk/param/VexFwkSegmentMap$Companion\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,38:1\n215#2,2:39\n215#2,2:41\n*S KotlinDebug\n*F\n+ 1 VexFwkSegmentMap.kt\ncom/samsung/android/vexfwk/param/VexFwkSegmentMap$Companion\n*L\n25#1:39,2\n29#1:41,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<Map<Integer, ? extends String>> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        public /* bridge */ /* synthetic */ ByteBuffer toBuffer(Map<Integer, ? extends String> map) {
            return toBuffer2((Map<Integer, String>) map);
        }

        private Companion() {
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public Map<Integer, ? extends String> fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (buffer.remaining() > 0) {
                int i = buffer.getInt();
                byte[] bArr = new byte[buffer.getInt()];
                buffer.get(bArr);
                linkedHashMap.put(Integer.valueOf(i), new String(bArr, Charsets.UTF_8));
            }
            return linkedHashMap;
        }

        @NotNull
        /* JADX INFO: renamed from: toBuffer, reason: avoid collision after fix types in other method */
        public ByteBuffer toBuffer2(@NotNull Map<Integer, String> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int size = value.size() * 8;
            for (Map.Entry<Integer, String> entry : value.entrySet()) {
                entry.getKey().intValue();
                byte[] bytes = entry.getValue().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer(size);
            for (Map.Entry<Integer, String> entry2 : value.entrySet()) {
                int iIntValue = entry2.getKey().intValue();
                String value2 = entry2.getValue();
                byteBufferAllocateBuffer.putInt(iIntValue);
                Charset charset = Charsets.UTF_8;
                byte[] bytes2 = value2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                byteBufferAllocateBuffer.putInt(bytes2.length);
                byte[] bytes3 = value2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                byteBufferAllocateBuffer.put(bytes3);
            }
            byteBufferAllocateBuffer.flip();
            return byteBufferAllocateBuffer;
        }
    }
}
