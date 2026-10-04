package io.grpc.netty;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.handler.codec.ByteToMessageDecoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyAdaptiveCumulator implements ByteToMessageDecoder.Cumulator {
    private final int composeMinSize;

    public NettyAdaptiveCumulator(int i) {
        Preconditions.checkArgument(i >= 0, "composeMinSize must be non-negative");
        this.composeMinSize = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [io.netty.buffer.ByteBufAllocator] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [io.netty.buffer.ByteBuf] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v0, types: [io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf, io.netty.buffer.CompositeByteBuf] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.netty.util.ReferenceCounted] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    @VisibleForTesting
    public static void mergeWithCompositeTail(ByteBufAllocator byteBufAllocator, CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) throws Throwable {
        int i = byteBuf.readableBytes();
        int iNumComponents = compositeByteBuf.numComponents() - 1;
        int byteIndex = compositeByteBuf.toByteIndex(iNumComponents);
        int iWriterIndex = compositeByteBuf.writerIndex() - byteIndex;
        int i2 = i + iWriterIndex;
        ByteBuf byteBufComponent = compositeByteBuf.component(iNumComponents);
        ?? r7 = 0;
        r7 = 0;
        try {
            try {
                if (byteBufComponent.refCnt() != 1 || byteBufComponent.isReadOnly() || i2 > byteBufComponent.maxCapacity()) {
                    ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBufAllocator.calculateNewCapacity(i2, Integer.MAX_VALUE));
                    byteBufBuffer.setBytes(0, (ByteBuf) compositeByteBuf, byteIndex, iWriterIndex).setBytes(iWriterIndex, byteBuf, byteBuf.readerIndex(), i).writerIndex(i2);
                    byteBuf.readerIndex(byteBuf.writerIndex());
                    byteBufAllocator = byteBufBuffer;
                } else {
                    ByteBuf byteBufRetain = byteBufComponent.retain();
                    ByteBuf byteBufDuplicate = compositeByteBuf.internalComponent(iNumComponents).duplicate();
                    byteBufRetain.setIndex(byteBufDuplicate.readerIndex(), byteBufDuplicate.writerIndex());
                    byteBufRetain.writeBytes(byteBuf);
                    byteBufAllocator = byteBufRetain;
                }
                int i4 = compositeByteBuf.readerIndex();
                compositeByteBuf.removeComponent(iNumComponents).setIndex(0, byteIndex);
                compositeByteBuf.addFlattenedComponents(true, byteBufAllocator);
                byteBuf.release();
                try {
                    compositeByteBuf.readerIndex(i4);
                } catch (Throwable th) {
                    th = th;
                    byteBuf = null;
                    if (byteBuf != null) {
                        byteBuf.release();
                    }
                    if (r7 != 0) {
                        r7.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r7 = byteBufAllocator;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @VisibleForTesting
    public static boolean shouldCompose(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf, int i) {
        int iNumComponents = compositeByteBuf.numComponents();
        if (compositeByteBuf.numComponents() == 0) {
            return true;
        }
        return (compositeByteBuf.writerIndex() - compositeByteBuf.toByteIndex(iNumComponents - 1)) + byteBuf.readableBytes() >= i;
    }

    @VisibleForTesting
    public void addInput(ByteBufAllocator byteBufAllocator, CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) throws Throwable {
        if (shouldCompose(compositeByteBuf, byteBuf, this.composeMinSize)) {
            compositeByteBuf.addFlattenedComponents(true, byteBuf);
        } else {
            mergeWithCompositeTail(byteBufAllocator, compositeByteBuf, byteBuf);
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
    public final ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        if (!byteBuf.isReadable()) {
            byteBuf.release();
            return byteBuf2;
        }
        CompositeByteBuf compositeByteBufAddFlattenedComponents = null;
        try {
            if ((byteBuf instanceof CompositeByteBuf) && byteBuf.refCnt() == 1) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
                try {
                    if (compositeByteBuf.writerIndex() != compositeByteBuf.capacity()) {
                        compositeByteBuf.capacity(compositeByteBuf.writerIndex());
                    }
                    compositeByteBufAddFlattenedComponents = compositeByteBuf;
                } catch (Throwable th) {
                    th = th;
                    compositeByteBufAddFlattenedComponents = compositeByteBuf;
                    if (byteBuf2 != null) {
                        byteBuf2.release();
                        if (compositeByteBufAddFlattenedComponents != null && compositeByteBufAddFlattenedComponents != byteBuf) {
                            compositeByteBufAddFlattenedComponents.release();
                        }
                    }
                    throw th;
                }
            } else {
                compositeByteBufAddFlattenedComponents = byteBufAllocator.compositeBuffer(Integer.MAX_VALUE).addFlattenedComponents(true, byteBuf);
            }
            addInput(byteBufAllocator, compositeByteBufAddFlattenedComponents, byteBuf2);
            return compositeByteBufAddFlattenedComponents;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
