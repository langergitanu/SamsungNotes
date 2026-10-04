package io.netty.buffer;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.collection.ScatterMapKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.yubico.yubikit.core.fido.CtapException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.Recycler;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ByteBufUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    private static final int MAX_CHAR_BUFFER_SIZE;
    static final int MAX_TL_ARRAY_LEN = 1024;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    static final int WRITE_CHUNK_SIZE = 8192;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final InternalLogger logger;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SWARByteSearch {
        private SWARByteSearch() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long compilePattern(byte b) {
            return (((long) b) & 255) * ScatterMapKt.BitmaskLsb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int firstAnyPattern(long j, long j2, boolean z) {
            long j3 = j ^ j2;
            long j5 = ~(j3 | ((j3 & 9187201950435737471L) + 9187201950435737471L) | 9187201950435737471L);
            return (z ? Long.numberOfLeadingZeros(j5) : Long.numberOfTrailingZeros(j5)) >>> 3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        });
        private final Recycler.EnhancedHandle<ThreadLocalDirectByteBuf> handle;

        public static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.resetRefCnt();
            return threadLocalDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        public void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.unguardedRecycle(this);
            }
        }

        private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = (Recycler.EnhancedHandle) handle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        });
        private final Recycler.EnhancedHandle<ThreadLocalUnsafeDirectByteBuf> handle;

        public static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.resetRefCnt();
            return threadLocalUnsafeDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        public void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.unguardedRecycle(this);
            }
        }

        private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = (Recycler.EnhancedHandle) handle;
        }
    }

    static {
        ByteBufAllocator byteBufAllocator;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ByteBufUtil.class);
        logger = internalLoggerFactory;
        BYTE_ARRAYS = new FastThreadLocal<byte[]>() { // from class: io.netty.buffer.ByteBufUtil.1
            @Override // io.netty.util.concurrent.FastThreadLocal
            public byte[] initialValue() {
                return PlatformDependent.allocateUninitializedArray(1024);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        String strTrim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(strTrim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else if ("pooled".equals(strTrim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: pooled (unknown: {})", strTrim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        THREAD_LOCAL_BUFFER_SIZE = i;
        internalLoggerFactory.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i));
        int i2 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i2;
        internalLoggerFactory.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i2));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b >= 0;
            }
        };
    }

    private ByteBufUtil() {
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf) {
        appendPrettyHexDump(sb, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static CharSequence checkCharSequenceBounds(CharSequence charSequence, int i, int i2) {
        if (!MathUtil.isOutOfBounds(i, i2 - i, charSequence.length())) {
            return charSequence;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "expected: 0 <= start(", ") <= end (", ") <= seq.length(");
        sbM1173s.append(charSequence.length());
        sbM1173s.append(PropertyUtils.MAPPED_DELIM2);
        throw new IndexOutOfBoundsException(sbM1173s.toString());
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == byteBuf2) {
            return 0;
        }
        int i = byteBuf.readableBytes();
        int i2 = byteBuf2.readableBytes();
        int iMin = Math.min(i, i2);
        int i4 = iMin >>> 2;
        int i5 = iMin & 3;
        int i6 = byteBuf.readerIndex();
        int i7 = byteBuf2.readerIndex();
        if (i4 > 0) {
            boolean z = byteBuf.order() == ByteOrder.BIG_ENDIAN;
            int i8 = i4 << 2;
            long jCompareUintBigEndian = byteBuf.order() == byteBuf2.order() ? z ? compareUintBigEndian(byteBuf, byteBuf2, i6, i7, i8) : compareUintLittleEndian(byteBuf, byteBuf2, i6, i7, i8) : z ? compareUintBigEndianA(byteBuf, byteBuf2, i6, i7, i8) : compareUintBigEndianB(byteBuf, byteBuf2, i6, i7, i8);
            if (jCompareUintBigEndian != 0) {
                return (int) Math.min(2147483647L, Math.max(-2147483648L, jCompareUintBigEndian));
            }
            i6 += i8;
            i7 += i8;
        }
        int i9 = i5 + i6;
        while (i6 < i9) {
            int unsignedByte = byteBuf.getUnsignedByte(i6) - byteBuf2.getUnsignedByte(i7);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            i6++;
            i7++;
        }
        return i - i2;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i4) {
        int i5 = i4 + i;
        while (i < i5) {
            long unsignedInt = byteBuf.getUnsignedInt(i) - byteBuf2.getUnsignedInt(i2);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i4) {
        int i5 = i4 + i;
        while (i < i5) {
            long unsignedInt = byteBuf.getUnsignedInt(i) - uintFromLE(byteBuf2.getUnsignedIntLE(i2));
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i4) {
        int i5 = i4 + i;
        while (i < i5) {
            long jUintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i)) - byteBuf2.getUnsignedInt(i2);
            if (jUintFromLE != 0) {
                return jUintFromLE;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i4) {
        int i5 = i4 + i;
        while (i < i5) {
            long jUintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i)) - uintFromLE(byteBuf2.getUnsignedIntLE(i2));
            if (jUintFromLE != 0) {
                return jUintFromLE;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString, ByteBuf byteBuf) {
        copy(asciiString, 0, byteBuf, asciiString.length());
    }

    public static byte decodeHexByte(CharSequence charSequence, int i) {
        return StringUtil.decodeHexByte(charSequence, i);
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return StringUtil.decodeHexDump(charSequence, 0, charSequence.length());
    }

    public static String decodeString(ByteBuf byteBuf, int i, int i2, Charset charset) {
        byte[] bArrThreadLocalTempArray;
        int iArrayOffset;
        if (i2 == 0) {
            return "";
        }
        if (byteBuf.hasArray()) {
            bArrThreadLocalTempArray = byteBuf.array();
            iArrayOffset = byteBuf.arrayOffset() + i;
        } else {
            bArrThreadLocalTempArray = threadLocalTempArray(i2);
            byteBuf.getBytes(i, bArrThreadLocalTempArray, 0, i2);
            iArrayOffset = 0;
        }
        return CharsetUtil.US_ASCII.equals(charset) ? new String(bArrThreadLocalTempArray, 0, iArrayOffset, i2) : new String(bArrThreadLocalTempArray, iArrayOffset, i2, charset);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, 0);
    }

    public static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z, CharBuffer charBuffer, Charset charset, int i) {
        CharsetEncoder charsetEncoderEncoder = CharsetUtil.encoder(charset);
        int iRemaining = ((int) (((double) charBuffer.remaining()) * ((double) charsetEncoderEncoder.maxBytesPerChar()))) + i;
        ByteBuf byteBufHeapBuffer = z ? byteBufAllocator.heapBuffer(iRemaining) : byteBufAllocator.buffer(iRemaining);
        try {
            try {
                ByteBuffer byteBufferInternalNioBuffer = byteBufHeapBuffer.internalNioBuffer(byteBufHeapBuffer.readerIndex(), iRemaining);
                int iPosition = byteBufferInternalNioBuffer.position();
                CoderResult coderResultEncode = charsetEncoderEncoder.encode(charBuffer, byteBufferInternalNioBuffer, true);
                if (!coderResultEncode.isUnderflow()) {
                    coderResultEncode.throwException();
                }
                CoderResult coderResultFlush = charsetEncoderEncoder.flush(byteBufferInternalNioBuffer);
                if (!coderResultFlush.isUnderflow()) {
                    coderResultFlush.throwException();
                }
                byteBufHeapBuffer.writerIndex((byteBufHeapBuffer.writerIndex() + byteBufferInternalNioBuffer.position()) - iPosition);
                return byteBufHeapBuffer;
            } catch (CharacterCodingException e) {
                throw new IllegalStateException(e);
            }
        } catch (Throwable th) {
            byteBufHeapBuffer.release();
            throw th;
        }
    }

    public static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (byteBuf.isAccessible()) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(byteBuf.refCnt());
    }

    public static boolean ensureWritableSuccess(int i) {
        return i == 0 || i == 2;
    }

    public static boolean equals(ByteBuf byteBuf, int i, ByteBuf byteBuf2, int i2, int i4) {
        ObjectUtil.checkNotNull(byteBuf, "a");
        ObjectUtil.checkNotNull(byteBuf2, "b");
        ObjectUtil.checkPositiveOrZero(i, "aStartIndex");
        ObjectUtil.checkPositiveOrZero(i2, "bStartIndex");
        ObjectUtil.checkPositiveOrZero(i4, "length");
        if (byteBuf.writerIndex() - i4 < i || byteBuf2.writerIndex() - i4 < i2) {
            return false;
        }
        int i5 = i4 >>> 3;
        if (byteBuf.order() == byteBuf2.order()) {
            while (i5 > 0) {
                if (byteBuf.getLong(i) != byteBuf2.getLong(i2)) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i5--;
            }
        } else {
            while (i5 > 0) {
                if (byteBuf.getLong(i) != swapLong(byteBuf2.getLong(i2))) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i5--;
            }
        }
        for (int i6 = i4 & 7; i6 > 0; i6--) {
            if (byteBuf.getByte(i) != byteBuf2.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static int firstIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        int iMax = Math.max(i, 0);
        if (iMax < i2 && abstractByteBuf.capacity() != 0) {
            int i4 = i2 - iMax;
            abstractByteBuf.checkIndex(iMax, i4);
            if (!PlatformDependent.isUnaligned()) {
                return linearFirstIndexOf(abstractByteBuf, iMax, i2, b);
            }
            int i5 = i4 & 7;
            if (i5 > 0) {
                int iUnrolledFirstIndexOf = unrolledFirstIndexOf(abstractByteBuf, iMax, i5, b);
                if (iUnrolledFirstIndexOf != -1) {
                    return iUnrolledFirstIndexOf;
                }
                iMax += i5;
                if (iMax == i2) {
                    return -1;
                }
            }
            int i6 = i4 >>> 3;
            ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
            boolean z = byteOrderNativeOrder == abstractByteBuf.order();
            boolean z2 = byteOrderNativeOrder == ByteOrder.LITTLE_ENDIAN;
            long jCompilePattern = SWARByteSearch.compilePattern(b);
            for (int i7 = 0; i7 < i6; i7++) {
                int iFirstAnyPattern = SWARByteSearch.firstAnyPattern(z2 ? abstractByteBuf._getLongLE(iMax) : abstractByteBuf._getLong(iMax), jCompilePattern, z);
                if (iFirstAnyPattern < 8) {
                    return iMax + iFirstAnyPattern;
                }
                iMax += 8;
            }
        }
        return -1;
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int hashCode(ByteBuf byteBuf) {
        int iSwapInt;
        int i = byteBuf.readableBytes();
        int i2 = i >>> 2;
        int i4 = i & 3;
        int i5 = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            iSwapInt = 1;
            while (i2 > 0) {
                iSwapInt = (iSwapInt * 31) + byteBuf.getInt(i5);
                i5 += 4;
                i2--;
            }
        } else {
            iSwapInt = 1;
            while (i2 > 0) {
                iSwapInt = (iSwapInt * 31) + swapInt(byteBuf.getInt(i5));
                i5 += 4;
                i2--;
            }
        }
        while (i4 > 0) {
            iSwapInt = (iSwapInt * 31) + byteBuf.getByte(i5);
            i4--;
            i5++;
        }
        if (iSwapInt == 0) {
            return 1;
        }
        return iSwapInt;
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 == null || byteBuf == null || byteBuf.readableBytes() > byteBuf2.readableBytes()) {
            return -1;
        }
        int i = byteBuf2.readableBytes();
        int i2 = byteBuf.readableBytes();
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return byteBuf2.indexOf(byteBuf2.readerIndex(), byteBuf2.writerIndex(), byteBuf.getByte(byteBuf.readerIndex()));
        }
        int i4 = byteBuf.readerIndex();
        int i5 = byteBuf2.readerIndex();
        long jMaxSuf = maxSuf(byteBuf, i2, i4, true);
        long jMaxSuf2 = maxSuf(byteBuf, i2, i4, false);
        int iMax = Math.max((int) (jMaxSuf >> 32), (int) (jMaxSuf2 >> 32));
        int iMax2 = Math.max((int) jMaxSuf, (int) jMaxSuf2);
        int i6 = i2 - iMax2;
        int i7 = iMax + 1;
        if (equals(byteBuf, i4, byteBuf, i4 + iMax2, Math.min(i6, i7))) {
            int i8 = -1;
            int i9 = 0;
            while (i9 <= i - i2) {
                int iMax3 = Math.max(iMax, i8) + 1;
                while (iMax3 < i2 && byteBuf.getByte(iMax3 + i4) == byteBuf2.getByte(iMax3 + i9 + i5)) {
                    iMax3++;
                }
                if (iMax3 > i) {
                    return -1;
                }
                if (iMax3 >= i2) {
                    int i10 = iMax;
                    while (i10 > i8 && byteBuf.getByte(i10 + i4) == byteBuf2.getByte(i10 + i9 + i5)) {
                        i10--;
                    }
                    if (i10 <= i8) {
                        return i9 + i5;
                    }
                    i9 += iMax2;
                    i8 = i6 - 1;
                } else {
                    i9 += iMax3 - iMax;
                    i8 = -1;
                }
            }
        } else {
            int iMax4 = Math.max(i7, (i2 - iMax) - 1) + 1;
            int i11 = 0;
            while (i11 <= i - i2) {
                int i12 = i7;
                while (i12 < i2 && byteBuf.getByte(i12 + i4) == byteBuf2.getByte(i12 + i11 + i5)) {
                    i12++;
                }
                if (i12 > i) {
                    return -1;
                }
                if (i12 >= i2) {
                    int i13 = iMax;
                    while (i13 >= 0 && byteBuf.getByte(i13 + i4) == byteBuf2.getByte(i13 + i11 + i5)) {
                        i13--;
                    }
                    if (i13 < 0) {
                        return i11 + i5;
                    }
                    i11 += iMax4;
                } else {
                    i11 += i12 - iMax;
                }
            }
        }
        return -1;
    }

    public static boolean isAccessible(ByteBuf byteBuf) {
        return byteBuf.isAccessible();
    }

    private static boolean isAscii(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.forEachByte(i, i2, FIND_NON_ASCII) == -1;
    }

    public static boolean isText(ByteBuf byteBuf, Charset charset) {
        return isText(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), charset);
    }

    private static boolean isUtf8(ByteBuf byteBuf, int i, int i2) {
        int i4;
        int i5;
        int i6 = i2 + i;
        while (i < i6) {
            int i7 = i + 1;
            byte b = byteBuf.getByte(i);
            if ((b & 128) == 0) {
                i = i7;
            } else if ((b & CtapException.ERR_EXTENSION_FIRST) == 192) {
                if (i7 >= i6) {
                    return false;
                }
                i += 2;
                if ((byteBuf.getByte(i7) & 192) != 128 || (b & 255) < 194) {
                    return false;
                }
            } else if ((b & CtapException.ERR_VENDOR_FIRST) == 224) {
                if (i7 > i6 - 2) {
                    return false;
                }
                int i8 = i + 2;
                byte b5 = byteBuf.getByte(i7);
                i += 3;
                byte b6 = byteBuf.getByte(i8);
                if ((b5 & 192) != 128 || (b6 & 192) != 128 || ((i4 = b & 15) == 0 && (b5 & 255) < 160)) {
                    return false;
                }
                if (i4 == 13 && (b5 & 255) > 159) {
                    return false;
                }
            } else {
                if ((b & 248) != 240 || i7 > i6 - 3) {
                    return false;
                }
                byte b7 = byteBuf.getByte(i7);
                int i9 = i + 3;
                byte b8 = byteBuf.getByte(i + 2);
                i += 4;
                byte b9 = byteBuf.getByte(i9);
                if ((b7 & 192) != 128 || (b8 & 192) != 128 || (b9 & 192) != 128 || (i5 = b & 255) > 244 || ((i5 == 240 && (b7 & 255) < 144) || (i5 == 244 && (b7 & 255) > 143))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int lastIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        int iCapacity = abstractByteBuf.capacity();
        int iMin = Math.min(i, iCapacity);
        if (iMin >= 0 && iCapacity != 0) {
            abstractByteBuf.checkIndex(i2, iMin - i2);
            for (int i4 = iMin - 1; i4 >= i2; i4--) {
                if (abstractByteBuf._getByte(i4) == b) {
                    return i4;
                }
            }
        }
        return -1;
    }

    private static int linearFirstIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        while (i < i2) {
            if (abstractByteBuf._getByte(i) == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long maxSuf(ByteBuf byteBuf, int i, int i2, boolean z) {
        int i4 = -1;
        while (true) {
            int i5 = 1;
            int i6 = 1;
            while (true) {
                int i7 = i2 + i5;
                if (i7 >= i) {
                    return (((long) i4) << 32) + ((long) i6);
                }
                byte b = byteBuf.getByte(i7);
                byte b5 = byteBuf.getByte(i4 + i5);
                if (z) {
                    if (b < b5) {
                        i6 = i7 - i4;
                        i5 = 1;
                        i2 = i7;
                    } else if (b != b5) {
                        if (i5 != i6) {
                            i5++;
                        } else {
                            i2 += i6;
                            i5 = 1;
                        }
                    }
                } else if (b > b5) {
                    i6 = i7 - i4;
                    i5 = 1;
                    i2 = i7;
                } else if (b != b5) {
                    break;
                }
            }
            i4 = i2;
            i2++;
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(i);
        try {
            byteBuf.readBytes(byteBufBuffer);
            return byteBufBuffer;
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i) {
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, charSequence.length(), i);
    }

    private static int reserveAndWriteUtf8Seq(ByteBuf byteBuf, CharSequence charSequence, int i, int i2, int i4) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(i4);
                    int iWriteUtf8 = writeUtf8(abstractByteBuf, abstractByteBuf.writerIndex, i4, charSequence, i, i2);
                    abstractByteBuf.writerIndex += iWriteUtf8;
                    return iWriteUtf8;
                }
                CharSequence charSequence2 = charSequence;
                int i5 = i;
                int i6 = i2;
                int i7 = i4;
                if (!(byteBuf instanceof WrappedByteBuf)) {
                    byte[] bytes = charSequence2.subSequence(i5, i6).toString().getBytes(CharsetUtil.UTF_8);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
                byteBuf = byteBuf.unwrap();
                i4 = i7;
                charSequence = charSequence2;
                i = i5;
                i2 = i6;
            }
        }
    }

    private static int safeArrayWriteUtf8(byte[] bArr, int i, CharSequence charSequence, int i2, int i4) {
        int i5 = i;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 128) {
                bArr[i5] = (byte) cCharAt;
                i5++;
            } else if (cCharAt < 2048) {
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((cCharAt >> 6) | 192);
                i5 += 2;
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    bArr[i5] = (byte) ((cCharAt >> '\f') | JPEG.APP0);
                    int i7 = i5 + 2;
                    bArr[i5 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    i5 += 3;
                    bArr[i7] = (byte) ((cCharAt & '?') | 128);
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i2++;
                    if (i2 == i4) {
                        bArr[i5] = 63;
                        i5++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i2);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        bArr[i5] = (byte) ((codePoint >> 18) | 240);
                        bArr[i5 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                        int i8 = i5 + 3;
                        bArr[i5 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                        i5 += 4;
                        bArr[i8] = (byte) ((codePoint & 63) | 128);
                    } else {
                        int i9 = i5 + 1;
                        bArr[i5] = 63;
                        i5 += 2;
                        bArr[i9] = (byte) (Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2);
                    }
                } else {
                    bArr[i5] = 63;
                    i5++;
                }
            }
            i2++;
        }
        return i5 - i;
    }

    private static int safeDirectWriteUtf8(ByteBuffer byteBuffer, int i, CharSequence charSequence, int i2, int i4) {
        int i5 = i;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 128) {
                byteBuffer.put(i5, (byte) cCharAt);
                i5++;
            } else if (cCharAt < 2048) {
                int i6 = i5 + 1;
                byteBuffer.put(i5, (byte) ((cCharAt >> 6) | 192));
                i5 += 2;
                byteBuffer.put(i6, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    byteBuffer.put(i5, (byte) ((cCharAt >> '\f') | JPEG.APP0));
                    int i7 = i5 + 2;
                    byteBuffer.put(i5 + 1, (byte) ((63 & (cCharAt >> 6)) | 128));
                    i5 += 3;
                    byteBuffer.put(i7, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i2++;
                    if (i2 == i4) {
                        byteBuffer.put(i5, (byte) 63);
                        i5++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i2);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        byteBuffer.put(i5, (byte) ((codePoint >> 18) | 240));
                        byteBuffer.put(i5 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i8 = i5 + 3;
                        byteBuffer.put(i5 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i5 += 4;
                        byteBuffer.put(i8, (byte) ((codePoint & 63) | 128));
                    } else {
                        int i9 = i5 + 1;
                        byteBuffer.put(i5, (byte) 63);
                        i5 += 2;
                        byteBuffer.put(i9, Character.isHighSurrogate(cCharAt2) ? (byte) 63 : (byte) cCharAt2);
                    }
                } else {
                    byteBuffer.put(i5, (byte) 63);
                    i5++;
                }
            }
            i2++;
        }
        return i5 - i;
    }

    private static int safeWriteUtf8(AbstractByteBuf abstractByteBuf, int i, CharSequence charSequence, int i2, int i4) {
        int i5 = i;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 128) {
                abstractByteBuf._setByte(i5, (byte) cCharAt);
                i5++;
            } else if (cCharAt < 2048) {
                int i6 = i5 + 1;
                abstractByteBuf._setByte(i5, (byte) ((cCharAt >> 6) | 192));
                i5 += 2;
                abstractByteBuf._setByte(i6, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    abstractByteBuf._setByte(i5, (byte) ((cCharAt >> '\f') | JPEG.APP0));
                    int i7 = i5 + 2;
                    abstractByteBuf._setByte(i5 + 1, (byte) ((63 & (cCharAt >> 6)) | 128));
                    i5 += 3;
                    abstractByteBuf._setByte(i7, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i2++;
                    if (i2 == i4) {
                        abstractByteBuf._setByte(i5, 63);
                        i5++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i2);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        abstractByteBuf._setByte(i5, (byte) ((codePoint >> 18) | 240));
                        abstractByteBuf._setByte(i5 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i8 = i5 + 3;
                        abstractByteBuf._setByte(i5 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i5 += 4;
                        abstractByteBuf._setByte(i8, (byte) ((codePoint & 63) | 128));
                    } else {
                        int i9 = i5 + 1;
                        abstractByteBuf._setByte(i5, 63);
                        i5 += 2;
                        abstractByteBuf._setByte(i9, Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2);
                    }
                } else {
                    abstractByteBuf._setByte(i5, 63);
                    i5++;
                }
            }
            i2++;
        }
        return i5 - i;
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.setShort(i, i2) : byteBuf.setShort(i, swapShort((short) i2));
    }

    public static int swapInt(int i) {
        return Integer.reverseBytes(i);
    }

    public static long swapLong(long j) {
        return Long.reverseBytes(j);
    }

    public static int swapMedium(int i) {
        int i2 = ((i >>> 16) & 255) | ((i << 16) & 16711680) | (65280 & i);
        return (8388608 & i2) != 0 ? i2 | (-16777216) : i2;
    }

    public static short swapShort(short s) {
        return Short.reverseBytes(s);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        return PlatformDependent.hasUnsafe() ? ThreadLocalUnsafeDirectByteBuf.newInstance() : ThreadLocalDirectByteBuf.newInstance();
    }

    public static byte[] threadLocalTempArray(int i) {
        return i <= 1024 ? BYTE_ARRAYS.get() : PlatformDependent.allocateUninitializedArray(i);
    }

    private static long uintFromLE(long j) {
        return Long.reverseBytes(j) >>> 32;
    }

    private static int unrolledFirstIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        if (abstractByteBuf._getByte(i) == b) {
            return i;
        }
        if (i2 == 1) {
            return -1;
        }
        int i4 = i + 1;
        if (abstractByteBuf._getByte(i4) == b) {
            return i4;
        }
        if (i2 == 2) {
            return -1;
        }
        int i5 = i + 2;
        if (abstractByteBuf._getByte(i5) == b) {
            return i5;
        }
        if (i2 == 3) {
            return -1;
        }
        int i6 = i + 3;
        if (abstractByteBuf._getByte(i6) == b) {
            return i6;
        }
        if (i2 == 4) {
            return -1;
        }
        int i7 = i + 4;
        if (abstractByteBuf._getByte(i7) == b) {
            return i7;
        }
        if (i2 == 5) {
            return -1;
        }
        int i8 = i + 5;
        if (abstractByteBuf._getByte(i8) == b) {
            return i8;
        }
        if (i2 == 6) {
            return -1;
        }
        int i9 = i + 6;
        if (abstractByteBuf._getByte(i9) == b) {
            return i9;
        }
        return -1;
    }

    private static int unsafeWriteUtf8(byte[] bArr, long j, int i, CharSequence charSequence, int i2, int i4) {
        long j2 = j + ((long) i);
        int i5 = i2;
        long j3 = j2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt < 128) {
                PlatformDependent.putByte(bArr, j3, (byte) cCharAt);
                j3 = 1 + j3;
            } else if (cCharAt < 2048) {
                long j5 = 1 + j3;
                PlatformDependent.putByte(bArr, j3, (byte) ((cCharAt >> 6) | 192));
                j3 += 2;
                PlatformDependent.putByte(bArr, j5, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    PlatformDependent.putByte(bArr, j3, (byte) ((cCharAt >> '\f') | JPEG.APP0));
                    long j6 = 2 + j3;
                    PlatformDependent.putByte(bArr, j3 + 1, (byte) (((cCharAt >> 6) & 63) | 128));
                    j3 += 3;
                    PlatformDependent.putByte(bArr, j6, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i5++;
                    if (i5 == i4) {
                        PlatformDependent.putByte(bArr, j3, (byte) 63);
                        j3++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i5);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        PlatformDependent.putByte(bArr, j3, (byte) ((codePoint >> 18) | 240));
                        PlatformDependent.putByte(bArr, j3 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        long j7 = j3 + 3;
                        PlatformDependent.putByte(bArr, 2 + j3, (byte) (((codePoint >> 6) & 63) | 128));
                        j3 += 4;
                        PlatformDependent.putByte(bArr, j7, (byte) ((codePoint & 63) | 128));
                    } else {
                        long j8 = j3 + 1;
                        PlatformDependent.putByte(bArr, j3, (byte) 63);
                        j3 += 2;
                        PlatformDependent.putByte(bArr, j8, (byte) (Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2));
                    }
                } else {
                    PlatformDependent.putByte(bArr, j3, (byte) 63);
                    j3++;
                }
            }
            i5++;
        }
        return (int) (j3 - j2);
    }

    private static int utf8ByteCount(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof AsciiString) {
            return i2 - i;
        }
        int i4 = i;
        while (i4 < i2 && charSequence.charAt(i4) < 128) {
            i4++;
        }
        return i4 < i2 ? (i4 - i) + utf8BytesNonAscii(charSequence, i4, i2) : i4 - i;
    }

    public static int utf8Bytes(CharSequence charSequence) {
        return utf8ByteCount(charSequence, 0, charSequence.length());
    }

    private static int utf8BytesNonAscii(CharSequence charSequence, int i, int i2) {
        int i4 = 0;
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i4 = ((127 - cCharAt) >>> 31) + 1 + i4;
            } else if (!StringUtil.isSurrogate(cCharAt)) {
                i4 += 3;
            } else if (Character.isHighSurrogate(cCharAt)) {
                i++;
                if (i == i2) {
                    return i4 + 1;
                }
                i4 = !Character.isLowSurrogate(charSequence.charAt(i)) ? i4 + 2 : i4 + 4;
            } else {
                i4++;
            }
            i++;
        }
        return i4;
    }

    public static int utf8MaxBytes(int i) {
        return i * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(charSequence.length());
        writeAscii(byteBufBuffer, charSequence);
        return byteBufBuffer;
    }

    private static int writeAsciiCharSequence(AbstractByteBuf abstractByteBuf, int i, CharSequence charSequence, int i2) {
        int i4 = 0;
        while (i4 < i2) {
            abstractByteBuf._setByte(i, AsciiString.c2b(charSequence.charAt(i4)));
            i4++;
            i++;
        }
        return i2;
    }

    public static void writeAsciiString(AbstractByteBuf abstractByteBuf, int i, AsciiString asciiString, int i2, int i4) {
        int iArrayOffset = asciiString.arrayOffset() + i2;
        int i5 = i4 - i2;
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                PlatformDependent.copyMemory(asciiString.array(), iArrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i, i5);
                return;
            } else if (abstractByteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(asciiString.array(), iArrayOffset, abstractByteBuf.memoryAddress() + ((long) i), i5);
                return;
            }
        }
        if (abstractByteBuf.hasArray()) {
            System.arraycopy(asciiString.array(), iArrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i, i5);
        } else {
            abstractByteBuf.setBytes(i, asciiString.array(), iArrayOffset, i5);
        }
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf, int i) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.writeMedium(i) : byteBuf.writeMedium(swapMedium(i));
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf, int i) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.writeShort(i) : byteBuf.writeShort(swapShort((short) i));
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(utf8MaxBytes(charSequence));
        writeUtf8(byteBufBuffer, charSequence);
        return byteBufBuffer;
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i, int i2) {
        HexUtil.appendPrettyHexDump(sb, byteBuf, i, i2);
    }

    public static void copy(AsciiString asciiString, int i, ByteBuf byteBuf, int i2, int i4) {
        if (!MathUtil.isOutOfBounds(i, i4, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i2, asciiString.array(), asciiString.arrayOffset() + i, i4);
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i4, "expected: 0 <= srcIdx(", ") <= srcIdx + length(", ") <= srcLen(");
        sbM1173s.append(asciiString.length());
        sbM1173s.append(PropertyUtils.MAPPED_DELIM2);
        throw new IndexOutOfBoundsException(sbM1173s.toString());
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i, int i2) {
        return StringUtil.decodeHexDump(charSequence, i, i2);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset, int i) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, i);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i, int i2) {
        return getBytes(byteBuf, i, i2, true);
    }

    public static String hexDump(ByteBuf byteBuf, int i, int i2) {
        return HexUtil.hexDump(byteBuf, i, i2);
    }

    public static boolean isText(ByteBuf byteBuf, int i, int i2, Charset charset) {
        ObjectUtil.checkNotNull(byteBuf, "buf");
        ObjectUtil.checkNotNull(charset, "charset");
        int i4 = byteBuf.readableBytes() + byteBuf.readerIndex();
        if (i < 0 || i2 < 0 || i > i4 - i2) {
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "index: ", " length: "));
        }
        if (charset.equals(CharsetUtil.UTF_8)) {
            return isUtf8(byteBuf, i, i2);
        }
        if (charset.equals(CharsetUtil.US_ASCII)) {
            return isAscii(byteBuf, i, i2);
        }
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        CharsetDecoder charsetDecoderDecoder = CharsetUtil.decoder(charset, codingErrorAction, codingErrorAction);
        try {
            if (byteBuf.nioBufferCount() == 1) {
                charsetDecoderDecoder.decode(byteBuf.nioBuffer(i, i2));
            } else {
                ByteBuf byteBufHeapBuffer = byteBuf.alloc().heapBuffer(i2);
                try {
                    byteBufHeapBuffer.writeBytes(byteBuf, i, i2);
                    charsetDecoderDecoder.decode(byteBufHeapBuffer.internalNioBuffer(byteBufHeapBuffer.readerIndex(), i2));
                } finally {
                    byteBufHeapBuffer.release();
                }
            }
            return true;
        } catch (CharacterCodingException unused) {
            return false;
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf, int i, int i2) {
        return HexUtil.prettyHexDump(byteBuf, i, i2);
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i, int i2, int i4) {
        return reserveAndWriteUtf8Seq(byteBuf, checkCharSequenceBounds(charSequence, i, i2), i, i2, i4);
    }

    public static int utf8Bytes(CharSequence charSequence, int i, int i2) {
        return utf8ByteCount(checkCharSequenceBounds(charSequence, i, i2), i, i2);
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? charSequence.length() : utf8MaxBytes(charSequence.length());
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i, int i2, boolean z) {
        int iCapacity = byteBuf.capacity();
        if (!MathUtil.isOutOfBounds(i, i2, iCapacity)) {
            if (byteBuf.hasArray()) {
                int iArrayOffset = byteBuf.arrayOffset() + i;
                byte[] bArrArray = byteBuf.array();
                return (!z && iArrayOffset == 0 && i2 == bArrArray.length) ? bArrArray : Arrays.copyOfRange(bArrArray, iArrayOffset, i2 + iArrayOffset);
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i2);
            byteBuf.getBytes(i, bArrAllocateUninitializedArray);
            return bArrAllocateUninitializedArray;
        }
        throw new IndexOutOfBoundsException(AbstractC0000a.m13j(AbstractC0622a.m1173s(i, i2, "expected: 0 <= start(", ") <= start + length(", ") <= buf.capacity("), iCapacity, PropertyUtils.MAPPED_DELIM2));
    }

    public static String hexDump(byte[] bArr) {
        return hexDump(bArr, 0, bArr.length);
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    int length = charSequence.length();
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(length);
                    if (charSequence instanceof AsciiString) {
                        writeAsciiString(abstractByteBuf, abstractByteBuf.writerIndex, (AsciiString) charSequence, 0, length);
                    } else {
                        writeAscii(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
                    }
                    abstractByteBuf.writerIndex += length;
                    return length;
                }
                if (byteBuf instanceof WrappedByteBuf) {
                    byteBuf = byteBuf.unwrap();
                } else {
                    byte[] bytes = charSequence.toString().getBytes(CharsetUtil.US_ASCII);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
            }
        }
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, length, utf8MaxBytes(length));
    }

    public static String hexDump(byte[] bArr, int i, int i2) {
        return HexUtil.hexDump(bArr, i, i2);
    }

    public static void readBytes(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i, int i2, OutputStream outputStream) throws IOException {
        if (byteBuffer.hasArray()) {
            outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            return;
        }
        int iMin = Math.min(i2, 8192);
        byteBuffer.clear().position(i);
        if (i2 > 1024 && byteBufAllocator.isDirectBufferPooled()) {
            ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer(iMin);
            try {
                getBytes(byteBuffer, byteBufHeapBuffer.array(), byteBufHeapBuffer.arrayOffset(), iMin, outputStream, i2);
                return;
            } finally {
                byteBufHeapBuffer.release();
            }
        }
        getBytes(byteBuffer, threadLocalTempArray(iMin), 0, iMin, outputStream, i2);
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence, int i, int i2) {
        checkCharSequenceBounds(charSequence, i, i2);
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, i, i2, utf8MaxBytes(i2 - i));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i = 0;
            for (int i2 = 0; i2 < 256; i2++) {
                char[] cArr = HEXDUMP_TABLE;
                int i4 = i2 << 1;
                cArr[i4] = charArray[(i2 >>> 4) & 15];
                cArr[i4 + 1] = charArray[i2 & 15];
            }
            int i5 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i5 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i5;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i6 = 0; i6 < length; i6++) {
                    sb.append("   ");
                }
                HEXPADDING[i5] = sb.toString();
                i5++;
            }
            int i7 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i7 >= strArr2.length) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(StringUtil.NEWLINE);
                sb2.append(Long.toHexString((((long) (i7 << 4)) & 4294967295L) | 4294967296L));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                strArr2[i7] = sb2.toString();
                i7++;
            }
            int i8 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i8 >= strArr3.length) {
                    break;
                }
                strArr3[i8] = " " + StringUtil.byteToHexStringPadded(i8);
                i8++;
            }
            int i9 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i9 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i9;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i10 = 0; i10 < length2; i10++) {
                    sb3.append(' ');
                }
                BYTEPADDING[i9] = sb3.toString();
                i9++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i >= cArr2.length) {
                    return;
                }
                if (i <= 31 || i >= 127) {
                    cArr2[i] = '.';
                } else {
                    cArr2[i] = (char) i;
                }
                i++;
            }
        }

        private HexUtil() {
        }

        private static void appendHexDumpRowPrefix(StringBuilder sb, int i, int i2) {
            String[] strArr = HEXDUMP_ROWPREFIXES;
            if (i < strArr.length) {
                sb.append(strArr[i]);
                return;
            }
            sb.append(StringUtil.NEWLINE);
            sb.append(Long.toHexString((((long) i2) & 4294967295L) | 4294967296L));
            sb.setCharAt(sb.length() - 9, '|');
            sb.append('|');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i, int i2) {
            if (MathUtil.isOutOfBounds(i, i2, byteBuf.capacity())) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "expected: 0 <= offset(", ") <= offset + length(", ") <= buf.capacity(");
                sbM1173s.append(byteBuf.capacity());
                sbM1173s.append(PropertyUtils.MAPPED_DELIM2);
                throw new IndexOutOfBoundsException(sbM1173s.toString());
            }
            if (i2 == 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder("         +-------------------------------------------------+");
            String str = StringUtil.NEWLINE;
            sb.append(AbstractC0541b.m776r(sb2, str, "         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |", str, "+--------+-------------------------------------------------+----------------+"));
            int i4 = i2 >>> 4;
            int i5 = i2 & 15;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 << 4) + i;
                appendHexDumpRowPrefix(sb, i6, i7);
                int i8 = i7 + 16;
                for (int i9 = i7; i9 < i8; i9++) {
                    sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i9)]);
                }
                sb.append(" |");
                while (i7 < i8) {
                    sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i7)]);
                    i7++;
                }
                sb.append('|');
            }
            if (i5 != 0) {
                int i10 = (i4 << 4) + i;
                appendHexDumpRowPrefix(sb, i4, i10);
                int i11 = i10 + i5;
                for (int i12 = i10; i12 < i11; i12++) {
                    sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i12)]);
                }
                sb.append(HEXPADDING[i5]);
                sb.append(" |");
                while (i10 < i11) {
                    sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i10)]);
                    i10++;
                }
                sb.append(BYTEPADDING[i5]);
                sb.append('|');
            }
            sb.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i, int i2) {
            ObjectUtil.checkPositiveOrZero(i2, "length");
            if (i2 == 0) {
                return "";
            }
            int i4 = i + i2;
            char[] cArr = new char[i2 << 1];
            int i5 = 0;
            while (i < i4) {
                System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i) << 1, cArr, i5, 2);
                i++;
                i5 += 2;
            }
            return new String(cArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf byteBuf, int i, int i2) {
            if (i2 == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(((i2 / 16) + ((i2 & 15) == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(sb, byteBuf, i, i2);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i, int i2) {
            ObjectUtil.checkPositiveOrZero(i2, "length");
            if (i2 == 0) {
                return "";
            }
            int i4 = i + i2;
            char[] cArr = new char[i2 << 1];
            int i5 = 0;
            while (i < i4) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i] & 255) << 1, cArr, i5, 2);
                i++;
                i5 += 2;
            }
            return new String(cArr);
        }
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i, int i2, CharSequence charSequence, int i4) {
        return writeUtf8(abstractByteBuf, i, i2, charSequence, 0, i4);
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i, int i2, CharSequence charSequence, int i4, int i5) {
        int i6;
        CharSequence charSequence2;
        int i7;
        int i8;
        if (charSequence instanceof AsciiString) {
            writeAsciiString(abstractByteBuf, i, (AsciiString) charSequence, i4, i5);
            return i5 - i4;
        }
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                return unsafeWriteUtf8(abstractByteBuf.array(), PlatformDependent.byteArrayBaseOffset(), abstractByteBuf.arrayOffset() + i, charSequence, i4, i5);
            }
            charSequence2 = charSequence;
            i7 = i4;
            i8 = i5;
            if (abstractByteBuf.hasMemoryAddress()) {
                return unsafeWriteUtf8(null, abstractByteBuf.memoryAddress(), i, charSequence2, i7, i8);
            }
            i6 = i;
        } else {
            i6 = i;
            charSequence2 = charSequence;
            i7 = i4;
            i8 = i5;
            if (abstractByteBuf.hasArray()) {
                return safeArrayWriteUtf8(abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i6, charSequence2, i7, i8);
            }
            if (abstractByteBuf.isDirect()) {
                ByteBuffer byteBufferInternalNioBuffer = abstractByteBuf.internalNioBuffer(i6, i2);
                return safeDirectWriteUtf8(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), charSequence2, i7, i8);
            }
        }
        return safeWriteUtf8(abstractByteBuf, i6, charSequence2, i7, i8);
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == byteBuf2) {
            return true;
        }
        int i = byteBuf.readableBytes();
        if (i != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), i);
    }

    public static void copy(AsciiString asciiString, int i, ByteBuf byteBuf, int i2) {
        if (!MathUtil.isOutOfBounds(i, i2, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), asciiString.arrayOffset() + i, i2);
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "expected: 0 <= srcIdx(", ") <= srcIdx + length(", ") <= srcLen(");
        sbM1173s.append(asciiString.length());
        sbM1173s.append(PropertyUtils.MAPPED_DELIM2);
        throw new IndexOutOfBoundsException(sbM1173s.toString());
    }

    public static int writeAscii(AbstractByteBuf abstractByteBuf, int i, CharSequence charSequence, int i2) {
        if (charSequence instanceof AsciiString) {
            writeAsciiString(abstractByteBuf, i, (AsciiString) charSequence, 0, i2);
            return i2;
        }
        writeAsciiCharSequence(abstractByteBuf, i, charSequence, i2);
        return i2;
    }

    public static int indexOf(ByteBuf byteBuf, int i, int i2, byte b) {
        return byteBuf.indexOf(i, i2, b);
    }

    private static void getBytes(ByteBuffer byteBuffer, byte[] bArr, int i, int i2, OutputStream outputStream, int i4) throws IOException {
        do {
            int iMin = Math.min(i2, i4);
            byteBuffer.get(bArr, i, iMin);
            outputStream.write(bArr, i, iMin);
            i4 -= iMin;
        } while (i4 > 0);
    }
}
