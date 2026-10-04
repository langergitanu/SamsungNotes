package androidx.emoji2.text.flatbuffer;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: bb */
    ByteBuffer f1499bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i) {
            return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory) {
        this(i, byteBufferFactory, null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i = iCapacity == 0 ? 1 : iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferNewByteBuffer = byteBufferFactory.newByteBuffer(i);
        byteBufferNewByteBuffer.position(byteBufferNewByteBuffer.clear().capacity() - iCapacity);
        byteBufferNewByteBuffer.put(byteBuffer);
        return byteBufferNewByteBuffer;
    }

    public static boolean isFieldPresent(Table table, int i) {
        return table.__offset(i) != 0;
    }

    public void Nested(int i) {
        if (i != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z) {
        prep(1, 0);
        putBoolean(z);
    }

    public void addByte(byte b) {
        prep(1, 0);
        putByte(b);
    }

    public void addDouble(double d) {
        prep(8, 0);
        putDouble(d);
    }

    public void addFloat(float f) {
        prep(4, 0);
        putFloat(f);
    }

    public void addInt(int i) {
        prep(4, 0);
        putInt(i);
    }

    public void addLong(long j) {
        prep(8, 0);
        putLong(j);
    }

    public void addOffset(int i) {
        prep(4, 0);
        putInt((offset() - i) + 4);
    }

    public void addShort(short s) {
        prep(2, 0);
        putShort(s);
    }

    public void addStruct(int i, int i2, int i4) {
        if (i2 != i4) {
            Nested(i2);
            slot(i);
        }
    }

    public void clear() {
        this.space = this.f1499bb.capacity();
        this.f1499bb.clear();
        this.minalign = 1;
        while (true) {
            int i = this.vtable_in_use;
            if (i <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i2 = i - 1;
            this.vtable_in_use = i2;
            iArr[i2] = 0;
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - length;
        this.space = i;
        byteBuffer.position(i);
        this.f1499bb.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t, int[] iArr) {
        t.sortTables(iArr, this.f1499bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int iEncodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, iEncodedLength, 1);
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - iEncodedLength;
        this.space = i;
        byteBuffer.position(i);
        this.utf8.encodeUtf8(charSequence, this.f1499bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i, int i2, int i4) {
        int i5 = i * i2;
        startVector(i, i2, i4);
        ByteBuffer byteBuffer = this.f1499bb;
        int i6 = this.space - i5;
        this.space = i6;
        byteBuffer.position(i6);
        ByteBuffer byteBufferOrder = this.f1499bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i5);
        return byteBufferOrder;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f1499bb;
    }

    public int endTable() {
        int i;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int iOffset = offset();
        int i2 = this.vtable_in_use - 1;
        while (i2 >= 0 && this.vtable[i2] == 0) {
            i2--;
        }
        for (int i4 = i2; i4 >= 0; i4--) {
            int i5 = this.vtable[i4];
            addShort((short) (i5 != 0 ? iOffset - i5 : 0));
        }
        addShort((short) (iOffset - this.object_start));
        addShort((short) ((i2 + 3) * 2));
        int i6 = 0;
        loop2: while (true) {
            if (i6 >= this.num_vtables) {
                i = 0;
                break;
            }
            int iCapacity = this.f1499bb.capacity() - this.vtables[i6];
            int i7 = this.space;
            short s = this.f1499bb.getShort(iCapacity);
            if (s == this.f1499bb.getShort(i7)) {
                for (int i8 = 2; i8 < s; i8 += 2) {
                    if (this.f1499bb.getShort(iCapacity + i8) != this.f1499bb.getShort(i7 + i8)) {
                        break;
                    }
                }
                i = this.vtables[i6];
                break loop2;
            }
            i6++;
        }
        if (i != 0) {
            int iCapacity2 = this.f1499bb.capacity() - iOffset;
            this.space = iCapacity2;
            this.f1499bb.putInt(iCapacity2, i - iOffset);
        } else {
            int i9 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i9 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i9 * 2);
            }
            int[] iArr2 = this.vtables;
            int i10 = this.num_vtables;
            this.num_vtables = i10 + 1;
            iArr2[i10] = offset();
            ByteBuffer byteBuffer = this.f1499bb;
            byteBuffer.putInt(byteBuffer.capacity() - iOffset, offset() - iOffset);
        }
        this.nested = false;
        return iOffset;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finish(int i, boolean z) {
        prep(this.minalign, (z ? 4 : 0) + 4);
        addOffset(i);
        if (z) {
            addInt(this.f1499bb.capacity() - this.space);
        }
        this.f1499bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i) {
        finish(i, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z) {
        this.force_defaults = z;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.f1499bb = byteBuffer;
        byteBuffer.clear();
        this.f1499bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.f1499bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f1499bb.capacity() - this.space;
    }

    public void pad(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.f1499bb;
            int i4 = this.space - 1;
            this.space = i4;
            byteBuffer.put(i4, (byte) 0);
        }
    }

    public void prep(int i, int i2) {
        if (i > this.minalign) {
            this.minalign = i;
        }
        int i4 = ((~((this.f1499bb.capacity() - this.space) + i2)) + 1) & (i - 1);
        while (this.space < i4 + i + i2) {
            int iCapacity = this.f1499bb.capacity();
            ByteBuffer byteBuffer = this.f1499bb;
            ByteBuffer byteBufferGrowByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.f1499bb = byteBufferGrowByteBuffer;
            if (byteBuffer != byteBufferGrowByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space = (this.f1499bb.capacity() - iCapacity) + this.space;
        }
        pad(i4);
    }

    public void putBoolean(boolean z) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - 1;
        this.space = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - 1;
        this.space = i;
        byteBuffer.put(i, b);
    }

    public void putDouble(double d) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - 8;
        this.space = i;
        byteBuffer.putDouble(i, d);
    }

    public void putFloat(float f) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - 4;
        this.space = i;
        byteBuffer.putFloat(i, f);
    }

    public void putInt(int i) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i2 = this.space - 4;
        this.space = i2;
        byteBuffer.putInt(i2, i);
    }

    public void putLong(long j) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - 8;
        this.space = i;
        byteBuffer.putLong(i, j);
    }

    public void putShort(short s) {
        ByteBuffer byteBuffer = this.f1499bb;
        int i = this.space - 2;
        this.space = i;
        byteBuffer.putShort(i, s);
    }

    public void required(int i, int i2) {
        int iCapacity = this.f1499bb.capacity() - i;
        if (this.f1499bb.getShort((iCapacity - this.f1499bb.getInt(iCapacity)) + i2) == 0) {
            throw new AssertionError(AbstractC0541b.m767i(i2, "FlatBuffers: field ", " must be set"));
        }
    }

    public byte[] sizedByteArray(int i, int i2) {
        finished();
        byte[] bArr = new byte[i2];
        this.f1499bb.position(i);
        this.f1499bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer byteBufferDuplicate = this.f1499bb.duplicate();
        byteBufferDuplicate.position(this.space);
        byteBufferDuplicate.limit(this.f1499bb.capacity());
        return new ByteBufferBackedInputStream(byteBufferDuplicate);
    }

    public void slot(int i) {
        this.vtable[i] = offset();
    }

    public void startTable(int i) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i) {
            this.vtable = new int[i];
        }
        this.vtable_in_use = i;
        Arrays.fill(this.vtable, 0, i, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i, int i2, int i4) {
        notNested();
        this.vector_num_elems = i2;
        int i5 = i * i2;
        prep(4, i5);
        prep(i4, i5);
        this.nested = true;
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i = i <= 0 ? 1 : i;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.f1499bb = byteBuffer;
            byteBuffer.clear();
            this.f1499bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f1499bb = byteBufferFactory.newByteBuffer(i);
        }
        this.utf8 = utf8;
        this.space = this.f1499bb.capacity();
    }

    public void addBoolean(int i, boolean z, boolean z2) {
        if (this.force_defaults || z != z2) {
            addBoolean(z);
            slot(i);
        }
    }

    public void addByte(int i, byte b, int i2) {
        if (this.force_defaults || b != i2) {
            addByte(b);
            slot(i);
        }
    }

    public void addDouble(int i, double d, double d2) {
        if (this.force_defaults || d != d2) {
            addDouble(d);
            slot(i);
        }
    }

    public void addFloat(int i, float f, double d) {
        if (this.force_defaults || f != d) {
            addFloat(f);
            slot(i);
        }
    }

    public void addInt(int i, int i2, int i4) {
        if (this.force_defaults || i2 != i4) {
            addInt(i2);
            slot(i);
        }
    }

    public void addLong(int i, long j, long j2) {
        if (this.force_defaults || j != j2) {
            addLong(j);
            slot(i);
        }
    }

    public void addShort(int i, short s, int i2) {
        if (this.force_defaults || s != i2) {
            addShort(s);
            slot(i);
        }
    }

    public void finishSizePrefixed(int i, String str) {
        finish(i, str, true);
    }

    public void addOffset(int i, int i2, int i4) {
        if (this.force_defaults || i2 != i4) {
            addOffset(i2);
            slot(i);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.f1499bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i, int i2) {
        startVector(1, i2, 1);
        ByteBuffer byteBuffer = this.f1499bb;
        int i4 = this.space - i2;
        this.space = i4;
        byteBuffer.position(i4);
        this.f1499bb.put(bArr, i, i2);
        return endVector();
    }

    public void finish(int i) {
        finish(i, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f1499bb;
        int i = this.space - iRemaining;
        this.space = i;
        byteBuffer2.position(i);
        this.f1499bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i, String str, boolean z) {
        prep(this.minalign, (z ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i2 = 3; i2 >= 0; i2--) {
                addByte((byte) str.charAt(i2));
            }
            finish(i, z);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f1499bb;
        int i = this.space - iRemaining;
        this.space = i;
        byteBuffer2.position(i);
        this.f1499bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i, String str) {
        finish(i, str, false);
    }

    public FlatBufferBuilder(int i) {
        this(i, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }
}
