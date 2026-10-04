package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class HpackEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int HUFF_CODE_THRESHOLD = 512;
    static final int NOT_FOUND = -1;
    private final byte hashMask;
    private final NameValueEntry head;
    private final HpackHuffmanEncoder hpackHuffmanEncoder;
    private final int huffCodeThreshold;
    private final boolean ignoreMaxHeaderListSize;
    private NameValueEntry latest;
    private long maxHeaderListSize;
    private long maxHeaderTableSize;
    private final NameEntry[] nameEntries;
    private final NameValueEntry[] nameValueEntries;
    private long size;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.HpackEncoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125981 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NameEntry {
        int counter;
        final int hash;
        final CharSequence name;
        NameEntry next;

        public NameEntry(int i, CharSequence charSequence, int i2, NameEntry nameEntry) {
            this.hash = i;
            this.name = charSequence;
            this.counter = i2;
            this.next = nameEntry;
        }

        public void unlink() {
            this.next = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NameValueEntry extends HpackHeaderField {
        NameValueEntry after;
        final int counter;
        final int hash;
        NameValueEntry next;

        public NameValueEntry(int i, CharSequence charSequence, CharSequence charSequence2, int i2, NameValueEntry nameValueEntry) {
            super(charSequence, charSequence2);
            this.next = nameValueEntry;
            this.hash = i;
            this.counter = i2;
        }

        public void unlink() {
            this.after = null;
            this.next = null;
        }
    }

    public HpackEncoder() {
        this(false);
    }

    private void addNameEntry(CharSequence charSequence, int i, int i2) {
        int iBucket = bucket(i);
        NameEntry[] nameEntryArr = this.nameEntries;
        nameEntryArr[iBucket] = new NameEntry(i, charSequence, i2, nameEntryArr[iBucket]);
    }

    private void addNameValueEntry(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i4) {
        int iHash = hash(i, i2);
        int iBucket = bucket(iHash);
        NameValueEntry nameValueEntry = new NameValueEntry(iHash, charSequence, charSequence2, i4, this.nameValueEntries[iBucket]);
        this.nameValueEntries[iBucket] = nameValueEntry;
        this.latest.after = nameValueEntry;
        this.latest = nameValueEntry;
    }

    private int bucket(int i) {
        return i & this.hashMask;
    }

    private void encodeAndAddEntries(ByteBuf byteBuf, CharSequence charSequence, int i, CharSequence charSequence2, int i2) {
        int index = HpackStaticTable.getIndex(charSequence);
        int iLatestCounter = latestCounter() - 1;
        if (index != -1) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, index);
            addNameValueEntry(HpackStaticTable.getEntry(index).name, charSequence2, i, i2, iLatestCounter);
            return;
        }
        NameEntry entry = getEntry(charSequence, i);
        if (entry == null) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, -1);
            addNameEntry(charSequence, i, iLatestCounter);
            addNameValueEntry(charSequence, charSequence2, i, i2, iLatestCounter);
        } else {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, getIndexPlusOffset(entry.counter));
            addNameValueEntry(entry.name, charSequence2, i, i2, iLatestCounter);
            entry.counter = iLatestCounter;
        }
    }

    private void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z, long j) {
        if (z) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NEVER, getNameIndex(charSequence));
            return;
        }
        long j2 = this.maxHeaderTableSize;
        if (j2 == 0) {
            int indexInsensitive = HpackStaticTable.getIndexInsensitive(charSequence, charSequence2);
            if (indexInsensitive != -1) {
                encodeInteger(byteBuf, 128, 7, indexInsensitive);
                return;
            } else {
                encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, HpackStaticTable.getIndex(charSequence));
                return;
            }
        }
        if (j > j2) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, getNameIndex(charSequence));
            return;
        }
        int iHashCode = AsciiString.hashCode(charSequence);
        int iHashCode2 = AsciiString.hashCode(charSequence2);
        NameValueEntry entryInsensitive = getEntryInsensitive(charSequence, iHashCode, charSequence2, iHashCode2);
        if (entryInsensitive != null) {
            encodeInteger(byteBuf, 128, 7, getIndexPlusOffset(entryInsensitive.counter));
            return;
        }
        int indexInsensitive2 = HpackStaticTable.getIndexInsensitive(charSequence, charSequence2);
        if (indexInsensitive2 != -1) {
            encodeInteger(byteBuf, 128, 7, indexInsensitive2);
            return;
        }
        ensureCapacity(j);
        encodeAndAddEntries(byteBuf, charSequence, iHashCode, charSequence2, iHashCode2);
        this.size += j;
    }

    private void encodeHeadersEnforceMaxHeaderListSize(int i, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        long jSizeOf = 0;
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            jSizeOf += HpackHeaderField.sizeOf(entry.getKey(), entry.getValue());
            long j = this.maxHeaderListSize;
            if (jSizeOf > j) {
                Http2CodecUtil.headerListSizeExceeded(i, j, false);
            }
        }
        encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
    }

    private void encodeHeadersIgnoreMaxHeaderListSize(ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            CharSequence key = entry.getKey();
            CharSequence value = entry.getValue();
            encodeHeader(byteBuf, key, value, sensitivityDetector.isSensitive(key, value), HpackHeaderField.sizeOf(key, value));
        }
    }

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, int i4) {
        encodeInteger(byteBuf, i, i2, i4);
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i) {
        boolean z = i != -1;
        int i2 = C125981.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i2 == 1) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 64, 6, i);
        } else if (i2 == 2) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 0, 4, i);
        } else {
            if (i2 != 3) {
                throw new Error("should not reach here");
            }
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 16, 4, i);
        }
        if (!z) {
            encodeStringLiteral(byteBuf, charSequence);
        }
        encodeStringLiteral(byteBuf, charSequence2);
    }

    private void encodeStringLiteral(ByteBuf byteBuf, CharSequence charSequence) {
        int encodedLength;
        if (charSequence.length() >= this.huffCodeThreshold && (encodedLength = this.hpackHuffmanEncoder.getEncodedLength(charSequence)) < charSequence.length()) {
            encodeInteger(byteBuf, 128, 7, encodedLength);
            this.hpackHuffmanEncoder.encode(byteBuf, charSequence);
            return;
        }
        encodeInteger(byteBuf, 0, 7, charSequence.length());
        if (!(charSequence instanceof AsciiString)) {
            byteBuf.writeCharSequence(charSequence, CharsetUtil.ISO_8859_1);
        } else {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
        }
    }

    private void ensureCapacity(long j) {
        while (this.maxHeaderTableSize - this.size < j) {
            remove();
        }
    }

    private NameEntry getEntry(CharSequence charSequence, int i) {
        for (NameEntry nameEntry = this.nameEntries[bucket(i)]; nameEntry != null; nameEntry = nameEntry.next) {
            if (nameEntry.hash == i && HpackUtil.equalsConstantTime(charSequence, nameEntry.name) != 0) {
                return nameEntry;
            }
        }
        return null;
    }

    private NameValueEntry getEntryInsensitive(CharSequence charSequence, int i, CharSequence charSequence2, int i2) {
        int iHash = hash(i, i2);
        for (NameValueEntry nameValueEntry = this.nameValueEntries[bucket(iHash)]; nameValueEntry != null; nameValueEntry = nameValueEntry.next) {
            if (nameValueEntry.hash == iHash && HpackUtil.equalsVariableTime(charSequence2, nameValueEntry.value) && HpackUtil.equalsVariableTime(charSequence, nameValueEntry.name)) {
                return nameValueEntry;
            }
        }
        return null;
    }

    private int getIndex(int i) {
        return (i - latestCounter()) + 1;
    }

    private int getIndexPlusOffset(int i) {
        return getIndex(i) + HpackStaticTable.length;
    }

    private int getNameIndex(CharSequence charSequence) {
        int index = HpackStaticTable.getIndex(charSequence);
        if (index != -1) {
            return index;
        }
        NameEntry entry = getEntry(charSequence, AsciiString.hashCode(charSequence));
        if (entry == null) {
            return -1;
        }
        return getIndexPlusOffset(entry.counter);
    }

    private static int hash(int i, int i2) {
        return (i * 31) + i2;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private int latestCounter() {
        return this.latest.counter;
    }

    private void remove() {
        NameValueEntry nameValueEntry = this.head.after;
        removeNameValueEntry(nameValueEntry);
        removeNameEntryMatchingCounter(nameValueEntry.name, nameValueEntry.counter);
        this.head.after = nameValueEntry.after;
        nameValueEntry.unlink();
        this.size -= (long) nameValueEntry.size();
        if (isEmpty()) {
            this.latest = this.head;
        }
    }

    private void removeNameEntryMatchingCounter(CharSequence charSequence, int i) {
        int iBucket = bucket(AsciiString.hashCode(charSequence));
        NameEntry[] nameEntryArr = this.nameEntries;
        NameEntry nameEntry = nameEntryArr[iBucket];
        if (nameEntry == null) {
            return;
        }
        if (i == nameEntry.counter) {
            nameEntryArr[iBucket] = nameEntry.next;
            nameEntry.unlink();
            return;
        }
        NameEntry nameEntry2 = nameEntry.next;
        while (true) {
            NameEntry nameEntry3 = nameEntry;
            nameEntry = nameEntry2;
            if (nameEntry == null) {
                return;
            }
            if (i == nameEntry.counter) {
                nameEntry3.next = nameEntry.next;
                nameEntry.unlink();
                return;
            }
            nameEntry2 = nameEntry.next;
        }
    }

    private void removeNameValueEntry(NameValueEntry nameValueEntry) {
        int iBucket = bucket(nameValueEntry.hash);
        NameValueEntry[] nameValueEntryArr = this.nameValueEntries;
        NameValueEntry nameValueEntry2 = nameValueEntryArr[iBucket];
        if (nameValueEntry2 == nameValueEntry) {
            nameValueEntryArr[iBucket] = nameValueEntry.next;
            return;
        }
        while (true) {
            NameValueEntry nameValueEntry3 = nameValueEntry2.next;
            if (nameValueEntry3 == nameValueEntry) {
                nameValueEntry2.next = nameValueEntry.next;
                return;
            }
            nameValueEntry2 = nameValueEntry3;
        }
    }

    public void encodeHeaders(int i, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        if (this.ignoreMaxHeaderListSize) {
            encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
        } else {
            encodeHeadersEnforceMaxHeaderListSize(i, byteBuf, http2Headers, sensitivityDetector);
        }
    }

    public HpackHeaderField getHeaderField(int i) {
        NameValueEntry nameValueEntry = this.head;
        while (true) {
            int i2 = i + 1;
            if (i >= length()) {
                return nameValueEntry;
            }
            nameValueEntry = nameValueEntry.after;
            i = i2;
        }
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.maxHeaderTableSize;
    }

    public int length() {
        if (isEmpty()) {
            return 0;
        }
        return getIndex(this.head.after.counter);
    }

    public void setMaxHeaderListSize(long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxHeaderListSize = j;
    }

    public void setMaxHeaderTableSize(ByteBuf byteBuf, long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        if (this.maxHeaderTableSize == j) {
            return;
        }
        this.maxHeaderTableSize = j;
        ensureCapacity(0L);
        encodeInteger(byteBuf, 32, 5, j);
    }

    public long size() {
        return this.size;
    }

    public HpackEncoder(boolean z) {
        this(z, 64, 512);
    }

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, long j) {
        int i4 = 255 >>> (8 - i2);
        long j2 = i4;
        if (j < j2) {
            byteBuf.writeByte((int) (((long) i) | j));
            return;
        }
        byteBuf.writeByte(i | i4);
        long j3 = j - j2;
        while (((-128) & j3) != 0) {
            byteBuf.writeByte((int) ((127 & j3) | 128));
            j3 >>>= 7;
        }
        byteBuf.writeByte((int) j3);
    }

    public HpackEncoder(boolean z, int i, int i2) {
        AsciiString asciiString = AsciiString.EMPTY_STRING;
        NameValueEntry nameValueEntry = new NameValueEntry(-1, asciiString, asciiString, Integer.MAX_VALUE, null);
        this.head = nameValueEntry;
        this.latest = nameValueEntry;
        this.hpackHuffmanEncoder = new HpackHuffmanEncoder();
        this.ignoreMaxHeaderListSize = z;
        this.maxHeaderTableSize = 4096L;
        this.maxHeaderListSize = 4294967295L;
        NameEntry[] nameEntryArr = new NameEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i, 128)))];
        this.nameEntries = nameEntryArr;
        this.nameValueEntries = new NameValueEntry[nameEntryArr.length];
        this.hashMask = (byte) (nameEntryArr.length - 1);
        this.huffCodeThreshold = i2;
    }
}
