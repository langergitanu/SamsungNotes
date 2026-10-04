package com.samsung.android.vexfwk.param;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkParamIntegerArray;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkParamIntegerArray {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkParamIntegerArray$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkParamIntegerArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkParamIntegerArray.kt\ncom/samsung/android/vexfwk/param/VexFwkParamIntegerArray$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,16:1\n1#2:17\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<int[]> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public int[] fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            IntBuffer intBufferAsIntBuffer = buffer.asIntBuffer();
            int[] iArr = new int[intBufferAsIntBuffer.capacity()];
            intBufferAsIntBuffer.get(iArr);
            return iArr;
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull int[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ByteBuffer byteBufferAllocateBuffer = allocateBuffer(value.length * 4);
            byteBufferAllocateBuffer.asIntBuffer().put(value);
            return byteBufferAllocateBuffer;
        }
    }
}
