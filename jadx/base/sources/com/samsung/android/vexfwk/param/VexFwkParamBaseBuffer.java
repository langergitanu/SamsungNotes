package com.samsung.android.vexfwk.param;

import com.google.firebase.messaging.Constants;
import com.samsung.android.vexfwk.metadata.IVexFwkMetadataConverter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "T", "Lcom/samsung/android/vexfwk/metadata/IVexFwkMetadataConverter;", "()V", "allocateBuffer", "Ljava/nio/ByteBuffer;", "size", "", Constants.MessagePayloadKeys.FROM, "data", "", "([B)Ljava/lang/Object;", "fromBuffer", "buffer", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "to", "value", "(Ljava/lang/Object;)[B", "toBuffer", "(Ljava/lang/Object;)Ljava/nio/ByteBuffer;", "wrapBuffer", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class VexFwkParamBaseBuffer<T> implements IVexFwkMetadataConverter<T> {
    private final ByteBuffer wrapBuffer(byte[] data) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(data).order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        return byteBufferOrder;
    }

    @NotNull
    public final ByteBuffer allocateBuffer(int size) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(new byte[size]).order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        return byteBufferOrder;
    }

    @Override // com.samsung.android.vexfwk.metadata.IVexFwkMetadataConverter
    public T from(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return fromBuffer(wrapBuffer(data));
    }

    public abstract T fromBuffer(@NotNull ByteBuffer buffer);

    @Override // com.samsung.android.vexfwk.metadata.IVexFwkMetadataConverter
    @NotNull
    /* JADX INFO: renamed from: to */
    public byte[] mo12821to(T value) {
        Buffer bufferRewind = toBuffer(value).rewind();
        Intrinsics.checkNotNull(bufferRewind, "null cannot be cast to non-null type java.nio.ByteBuffer");
        byte[] bArrArray = ((ByteBuffer) bufferRewind).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    @NotNull
    public abstract ByteBuffer toBuffer(T value);
}
