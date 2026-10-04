package com.samsung.android.vexfwk.param;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.firebase.messaging.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkLanguageDirection;", "", Constants.MessagePayloadKeys.FROM, "", "to", "(Ljava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getTo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkLanguageDirection {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String from;

    @NotNull
    private final String to;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkLanguageDirection$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageDirection;", "()V", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkLanguageDirection> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public VexFwkLanguageDirection fromBuffer(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            byte[] bArr = new byte[buffer.getInt()];
            buffer.get(bArr);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(bArr, UTF_8);
            byte[] bArr2 = new byte[buffer.getInt()];
            buffer.get(bArr2);
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new VexFwkLanguageDirection(str, new String(bArr2, UTF_8));
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @JvmStatic
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkLanguageDirection value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String from = value.getFrom();
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = from.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            int length = bytes.length + 8;
            String to = value.getTo();
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes2 = to.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            ByteBuffer byteBufferOrder = allocateBuffer(length + bytes2.length).order(ByteOrder.nativeOrder());
            byteBufferOrder.putInt(value.getFrom().length());
            String from2 = value.getFrom();
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes3 = from2.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            byteBufferOrder.put(bytes3);
            byteBufferOrder.putInt(value.getTo().length());
            String to2 = value.getTo();
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes4 = to2.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
            byteBufferOrder.put(bytes4);
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "apply(...)");
            return byteBufferOrder;
        }
    }

    public VexFwkLanguageDirection(@NotNull String from, @NotNull String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.from = from;
        this.to = to;
    }

    public static /* synthetic */ VexFwkLanguageDirection copy$default(VexFwkLanguageDirection vexFwkLanguageDirection, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vexFwkLanguageDirection.from;
        }
        if ((i & 2) != 0) {
            str2 = vexFwkLanguageDirection.to;
        }
        return vexFwkLanguageDirection.copy(str, str2);
    }

    @JvmStatic
    @NotNull
    public static VexFwkLanguageDirection fromBuffer(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.fromBuffer(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static ByteBuffer toBuffer(@NotNull VexFwkLanguageDirection vexFwkLanguageDirection) {
        return INSTANCE.toBuffer(vexFwkLanguageDirection);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    @NotNull
    public final VexFwkLanguageDirection copy(@NotNull String from, @NotNull String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        return new VexFwkLanguageDirection(from, to);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkLanguageDirection)) {
            return false;
        }
        VexFwkLanguageDirection vexFwkLanguageDirection = (VexFwkLanguageDirection) other;
        return Intrinsics.areEqual(this.from, vexFwkLanguageDirection.from) && Intrinsics.areEqual(this.to, vexFwkLanguageDirection.to);
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    public final String getTo() {
        return this.to;
    }

    public int hashCode() {
        return this.to.hashCode() + (this.from.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("VexFwkLanguageDirection(from=", this.from, ", to=", this.to, ")");
    }
}
