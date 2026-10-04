package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer();

    ByteBuf buffer(int i);

    ByteBuf buffer(int i, int i2);

    int calculateNewCapacity(int i, int i2);

    CompositeByteBuf compositeBuffer();

    CompositeByteBuf compositeBuffer(int i);

    CompositeByteBuf compositeDirectBuffer();

    CompositeByteBuf compositeDirectBuffer(int i);

    CompositeByteBuf compositeHeapBuffer();

    CompositeByteBuf compositeHeapBuffer(int i);

    ByteBuf directBuffer();

    ByteBuf directBuffer(int i);

    ByteBuf directBuffer(int i, int i2);

    ByteBuf heapBuffer();

    ByteBuf heapBuffer(int i);

    ByteBuf heapBuffer(int i, int i2);

    ByteBuf ioBuffer();

    ByteBuf ioBuffer(int i);

    ByteBuf ioBuffer(int i, int i2);

    boolean isDirectBufferPooled();
}
