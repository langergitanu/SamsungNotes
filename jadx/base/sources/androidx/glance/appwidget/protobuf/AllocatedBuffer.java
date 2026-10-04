package androidx.glance.appwidget.protobuf;

import java.nio.ByteBuffer;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() { // from class: androidx.glance.appwidget.protobuf.AllocatedBuffer.2
            private int position;

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public byte[] array() {
                return bArr;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return i;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int limit() {
                return i2;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int position() {
                return this.position;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int remaining() {
                return i2 - this.position;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i4) {
                if (i4 < 0 || i4 > i2) {
                    throw new IllegalArgumentException(AbstractC0000a.m11h(i4, "Invalid position: "));
                }
                this.position = i4;
                return this;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return wrapNoCheck(bArr, i, i2);
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: androidx.glance.appwidget.protobuf.AllocatedBuffer.1
            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public byte[] array() {
                return byteBuffer.array();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int limit() {
                return byteBuffer.limit();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int position() {
                return byteBuffer.position();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public int remaining() {
                return byteBuffer.remaining();
            }

            @Override // androidx.glance.appwidget.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i) {
                Java8Compatibility.position(byteBuffer, i);
                return this;
            }
        };
    }
}
