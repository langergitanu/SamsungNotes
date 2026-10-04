package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i = this.position;
            if (i >= this.limit) {
                throw new NoSuchElementException();
            }
            byte[] bArr = BoundedByteString.this.bytes;
            this.position = i + 1;
            return bArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC4539a.m3197g(29, i, "Offset too small: "));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(AbstractC4539a.m3197g(29, i, "Length too small: "));
        }
        if (((long) i) + ((long) i2) <= bArr.length) {
            this.bytesOffset = i;
            this.bytesLength = i2;
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("Offset+Length too large: ");
        sb.append(i);
        sb.append(Marker.ANY_NON_NULL_MARKER);
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public byte byteAt(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC4539a.m3197g(28, i, "Index too small: "));
        }
        if (i < size()) {
            return this.bytes[this.bytesOffset + i];
        }
        int size = size();
        StringBuilder sb = new StringBuilder(41);
        sb.append("Index too large: ");
        sb.append(i);
        sb.append(SQLKeyword.COMMA);
        sb.append(size);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i4) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i, bArr, i2, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new BoundedByteIterator();
    }
}
