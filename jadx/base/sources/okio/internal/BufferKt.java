package okio.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0000\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0080\b\u001a\r\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\r\u0010\u0017\u001a\u00020\u0013*\u00020\u0013H\u0080\b\u001a%\u0010\u0018\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\u0017\u0010\u001c\u001a\u00020\n*\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0005*\u00020\u00152\u0006\u0010 \u001a\u00020\bH\u0080\b\u001a\u0015\u0010!\u001a\u00020\"*\u00020\u00132\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\r\u0010$\u001a\u00020\b*\u00020\u0013H\u0080\b\u001a%\u0010%\u001a\u00020\u0005*\u00020\u00132\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0005*\u00020\u00132\u0006\u0010+\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0005H\u0080\b\u001a\r\u0010,\u001a\u00020\b*\u00020\u0015H\u0080\b\u001a-\u0010-\u001a\u00020\n*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0080\b\u001a\u0015\u0010.\u001a\u00020\b*\u00020\u00132\u0006\u0010/\u001a\u00020\u0001H\u0080\b\u001a%\u0010.\u001a\u00020\b*\u00020\u00132\u0006\u0010/\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0080\b\u001a\u001d\u0010.\u001a\u00020\u0005*\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0005*\u00020\u00132\u0006\u0010/\u001a\u000201H\u0080\b\u001a\u0014\u00102\u001a\u00020\u0015*\u00020\u00132\u0006\u00103\u001a\u00020\u0015H\u0000\u001a\r\u00104\u001a\u00020\"*\u00020\u0013H\u0080\b\u001a\r\u00105\u001a\u00020\u0001*\u00020\u0013H\u0080\b\u001a\u0015\u00105\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\r\u00106\u001a\u00020)*\u00020\u0013H\u0080\b\u001a\u0015\u00106\u001a\u00020)*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\r\u00107\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\u0015\u00108\u001a\u00020\u0012*\u00020\u00132\u0006\u0010/\u001a\u00020\u0001H\u0080\b\u001a\u001d\u00108\u001a\u00020\u0012*\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\r\u00109\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\r\u0010:\u001a\u00020\b*\u00020\u0013H\u0080\b\u001a\r\u0010;\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\r\u0010<\u001a\u00020=*\u00020\u0013H\u0080\b\u001a\u0014\u0010>\u001a\u00020\u0015*\u00020\u00132\u0006\u00103\u001a\u00020\u0015H\u0000\u001a\u0015\u0010?\u001a\u00020@*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\r\u0010A\u001a\u00020\b*\u00020\u0013H\u0080\b\u001a\u000f\u0010B\u001a\u0004\u0018\u00010@*\u00020\u0013H\u0080\b\u001a\u0015\u0010C\u001a\u00020@*\u00020\u00132\u0006\u0010D\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010E\u001a\u00020\u0005*\u00020\u00152\u0006\u0010F\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010G\u001a\u00020\b*\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010H\u001a\u00020\b*\u00020\u00132\u0006\u0010I\u001a\u00020JH\u0080\b\u001a\u0015\u0010K\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\r\u0010L\u001a\u00020)*\u00020\u0013H\u0080\b\u001a\u0015\u0010L\u001a\u00020)*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\bH\u0080\b\u001a\u0015\u0010M\u001a\u00020\f*\u00020\u00132\u0006\u0010N\u001a\u00020\bH\u0080\b\u001a\u0015\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010P\u001a\u00020\u0001H\u0080\b\u001a%\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010P\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0080\b\u001a\u001d\u0010O\u001a\u00020\u0012*\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a)\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010Q\u001a\u00020)2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0080\b\u001a\u001d\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010P\u001a\u00020R2\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010S\u001a\u00020\u0005*\u00020\u00132\u0006\u0010P\u001a\u00020RH\u0080\b\u001a\u0015\u0010T\u001a\u00020\u0013*\u00020\u00132\u0006\u0010&\u001a\u00020\bH\u0080\b\u001a\u0015\u0010U\u001a\u00020\u0013*\u00020\u00132\u0006\u0010V\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010W\u001a\u00020\u0013*\u00020\u00132\u0006\u0010V\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010X\u001a\u00020\u0013*\u00020\u00132\u0006\u0010Y\u001a\u00020\bH\u0080\b\u001a\u0015\u0010Z\u001a\u00020\u0013*\u00020\u00132\u0006\u0010V\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010[\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\\\u001a\u00020\bH\u0080\b\u001a%\u0010]\u001a\u00020\u0013*\u00020\u00132\u0006\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0080\b\u001a\u0015\u0010a\u001a\u00020\u0013*\u00020\u00132\u0006\u0010b\u001a\u00020\bH\u0080\b\u001a\u0014\u0010c\u001a\u00020@*\u00020\u00132\u0006\u0010d\u001a\u00020\u0005H\u0000\u001a?\u0010e\u001a\u0002Hf\"\u0004\b\u0000\u0010f*\u00020\u00132\u0006\u0010'\u001a\u00020\u00052\u001a\u0010g\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002Hf0hH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010i\u001a\u001e\u0010j\u001a\u00020\b*\u00020\u00132\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010k\u001a\u00020\nH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006l"}, m13886d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", TypedValues.Cycle.S_WAVE_OFFSET, "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", VPathDataCmd.RCurveTo, "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", TextConst.KEY_END_INDEX, "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
public final class BufferKt {

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer commonClear) throws EOFException {
        Intrinsics.checkNotNullParameter(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.size());
    }

    public static final void commonClose(@NotNull Buffer.UnsafeCursor commonClose) {
        Intrinsics.checkNotNullParameter(commonClose, "$this$commonClose");
        if (!(commonClose.buffer != null)) {
            throw new IllegalStateException("not attached to a buffer");
        }
        commonClose.buffer = null;
        commonClose.setSegment$okio(null);
        commonClose.offset = -1L;
        commonClose.data = null;
        commonClose.start = -1;
        commonClose.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer commonCompleteSegmentByteCount) {
        Intrinsics.checkNotNullParameter(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long size = commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = commonCompleteSegmentByteCount.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        int i = segment2.limit;
        return (i >= 8192 || !segment2.owner) ? size : size - ((long) (i - segment2.pos));
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer commonCopy) {
        Intrinsics.checkNotNullParameter(commonCopy, "$this$commonCopy");
        Buffer buffer = new Buffer();
        if (commonCopy.size() == 0) {
            return buffer;
        }
        Segment segment = commonCopy.head;
        Intrinsics.checkNotNull(segment);
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = segmentSharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(commonCopy.size());
        return buffer;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer commonCopyTo, @NotNull Buffer out, long j, long j2) {
        Intrinsics.checkNotNullParameter(commonCopyTo, "$this$commonCopyTo");
        Intrinsics.checkNotNullParameter(out, "out");
        long j3 = j;
        Util.checkOffsetAndCount(commonCopyTo.size(), j3, j2);
        if (j2 != 0) {
            out.setSize$okio(out.size() + j2);
            Segment segment = commonCopyTo.head;
            while (true) {
                Intrinsics.checkNotNull(segment);
                int i = segment.limit;
                int i2 = segment.pos;
                if (j3 < i - i2) {
                    break;
                }
                j3 -= (long) (i - i2);
                segment = segment.next;
            }
            Segment segment2 = segment;
            long j5 = j2;
            while (j5 > 0) {
                Intrinsics.checkNotNull(segment2);
                Segment segmentSharedCopy = segment2.sharedCopy();
                int i4 = segmentSharedCopy.pos + ((int) j3);
                segmentSharedCopy.pos = i4;
                segmentSharedCopy.limit = Math.min(i4 + ((int) j5), segmentSharedCopy.limit);
                Segment segment3 = out.head;
                if (segment3 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    out.head = segmentSharedCopy;
                } else {
                    Intrinsics.checkNotNull(segment3);
                    Segment segment4 = segment3.prev;
                    Intrinsics.checkNotNull(segment4);
                    segment4.push(segmentSharedCopy);
                }
                j5 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                segment2 = segment2.next;
                j3 = 0;
            }
        }
        return commonCopyTo;
    }

    public static final boolean commonEquals(@NotNull Buffer commonEquals, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (commonEquals.size() != buffer.size()) {
            return false;
        }
        if (commonEquals.size() == 0) {
            return true;
        }
        Segment segment = commonEquals.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = buffer.head;
        Intrinsics.checkNotNull(segment2);
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < commonEquals.size()) {
            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.limit) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
                i2 = segment2.pos;
            }
            j += jMin;
        }
        return true;
    }

    public static final long commonExpandBuffer(@NotNull Buffer.UnsafeCursor commonExpandBuffer, int i) {
        Intrinsics.checkNotNullParameter(commonExpandBuffer, "$this$commonExpandBuffer");
        if (!(i > 0)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "minByteCount <= 0: ").toString());
        }
        if (!(i <= 8192)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "minByteCount > Segment.SIZE: ").toString());
        }
        Buffer buffer = commonExpandBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!commonExpandBuffer.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        long size = buffer.size();
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
        int i2 = 8192 - segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = 8192;
        long j = i2;
        buffer.setSize$okio(size + j);
        commonExpandBuffer.setSegment$okio(segmentWritableSegment$okio);
        commonExpandBuffer.offset = size;
        commonExpandBuffer.data = segmentWritableSegment$okio.data;
        commonExpandBuffer.start = 8192 - i2;
        commonExpandBuffer.end = 8192;
        return j;
    }

    public static final byte commonGet(@NotNull Buffer commonGet, long j) {
        Intrinsics.checkNotNullParameter(commonGet, "$this$commonGet");
        Util.checkOffsetAndCount(commonGet.size(), j, 1L);
        Segment segment = commonGet.head;
        if (segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        if (commonGet.size() - j < j) {
            long size = commonGet.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                Intrinsics.checkNotNull(segment);
                return segment.data[(int) ((((long) segment.pos) + j) - j2)];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j2 = j3;
        }
    }

    public static final int commonHashCode(@NotNull Buffer commonHashCode) {
        Intrinsics.checkNotNullParameter(commonHashCode, "$this$commonHashCode");
        Segment segment = commonHashCode.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i4 = segment.pos; i4 < i2; i4++) {
                i = (i * 31) + segment.data[i4];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != commonHashCode.head);
        return i;
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, byte b, long j, long j2) {
        Segment segment;
        int i;
        Intrinsics.checkNotNullParameter(commonIndexOf, "$this$commonIndexOf");
        long size = 0;
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("size=" + commonIndexOf.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > commonIndexOf.size()) {
            j2 = commonIndexOf.size();
        }
        if (j == j2 || (segment = commonIndexOf.head) == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j < j) {
            size = commonIndexOf.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            while (size < j2) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - size);
                i = (int) ((((long) segment.pos) + j) - size);
                while (i < iMin) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = size;
            }
            return -1L;
        }
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + size;
            if (j3 > j) {
                break;
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            size = j3;
        }
        while (size < j2) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - size);
            i = (int) ((((long) segment.pos) + j) - size);
            while (i < iMin2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j = size;
        }
        return -1L;
        return ((long) (i - segment.pos)) + size;
    }

    public static final long commonIndexOfElement(@NotNull Buffer commonIndexOfElement, @NotNull ByteString targetBytes, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(commonIndexOfElement, "$this$commonIndexOfElement");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long size = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("fromIndex < 0: ", j).toString());
        }
        Segment segment = commonIndexOfElement.head;
        if (segment == null) {
            return -1L;
        }
        if (commonIndexOfElement.size() - j < j) {
            size = commonIndexOfElement.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            if (targetBytes.size() == 2) {
                byte b = targetBytes.getByte(0);
                byte b5 = targetBytes.getByte(1);
                while (size < commonIndexOfElement.size()) {
                    byte[] bArr = segment.data;
                    i = (int) ((((long) segment.pos) + j) - size);
                    int i4 = segment.limit;
                    while (i < i4) {
                        byte b6 = bArr[i];
                        if (b6 == b || b6 == b5) {
                            i2 = segment.pos;
                        } else {
                            i++;
                        }
                    }
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = size;
                }
            } else {
                byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
                while (size < commonIndexOfElement.size()) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - size);
                    int i5 = segment.limit;
                    while (i < i5) {
                        byte b7 = bArr2[i];
                        for (byte b8 : bArrInternalArray$okio) {
                            if (b7 == b8) {
                                i2 = segment.pos;
                            }
                        }
                        i++;
                    }
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = size;
                }
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (segment.limit - segment.pos)) + size;
            if (j2 > j) {
                break;
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            size = j2;
        }
        if (targetBytes.size() == 2) {
            byte b9 = targetBytes.getByte(0);
            byte b10 = targetBytes.getByte(1);
            while (size < commonIndexOfElement.size()) {
                byte[] bArr3 = segment.data;
                i = (int) ((((long) segment.pos) + j) - size);
                int i6 = segment.limit;
                while (i < i6) {
                    byte b11 = bArr3[i];
                    if (b11 == b9 || b11 == b10) {
                        i2 = segment.pos;
                    } else {
                        i++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = size;
            }
        } else {
            byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
            while (size < commonIndexOfElement.size()) {
                byte[] bArr4 = segment.data;
                i = (int) ((((long) segment.pos) + j) - size);
                int i7 = segment.limit;
                while (i < i7) {
                    byte b12 = bArr4[i];
                    for (byte b13 : bArrInternalArray$okio2) {
                        if (b12 == b13) {
                            i2 = segment.pos;
                        }
                    }
                    i++;
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = size;
            }
        }
        return -1L;
        return ((long) (i - i2)) + size;
    }

    public static final int commonNext(@NotNull Buffer.UnsafeCursor commonNext) {
        Intrinsics.checkNotNullParameter(commonNext, "$this$commonNext");
        long j = commonNext.offset;
        Buffer buffer = commonNext.buffer;
        Intrinsics.checkNotNull(buffer);
        if (!(j != buffer.size())) {
            throw new IllegalStateException("no more bytes");
        }
        long j2 = commonNext.offset;
        return commonNext.seek(j2 == -1 ? 0L : j2 + ((long) (commonNext.end - commonNext.start)));
    }

    public static final boolean commonRangeEquals(@NotNull Buffer commonRangeEquals, long j, @NotNull ByteString bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || commonRangeEquals.size() - j < i2 || bytes.size() - i < i2) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (commonRangeEquals.getByte(((long) i4) + j) != bytes.getByte(i + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(commonRead, "$this$commonRead");
        Intrinsics.checkNotNullParameter(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@NotNull Buffer commonReadAll, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(commonReadAll, "$this$commonReadAll");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = commonReadAll.size();
        if (size > 0) {
            sink.write(commonReadAll, size);
        }
        return size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@NotNull Buffer commonReadAndWriteUnsafe, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(commonReadAndWriteUnsafe, "$this$commonReadAndWriteUnsafe");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = commonReadAndWriteUnsafe;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    public static final byte commonReadByte(@NotNull Buffer commonReadByte) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.size() == 0) {
            throw new EOFException();
        }
        Segment segment = commonReadByte.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        int i4 = i + 1;
        byte b = segment.data[i];
        commonReadByte.setSize$okio(commonReadByte.size() - 1);
        if (i4 != i2) {
            segment.pos = i4;
            return b;
        }
        commonReadByte.head = segment.pop();
        SegmentPool.recycle(segment);
        return b;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray) {
        Intrinsics.checkNotNullParameter(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.readByteArray(commonReadByteArray.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString) {
        Intrinsics.checkNotNullParameter(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.readByteString(commonReadByteString.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[EDGE_INSN: B:48:0x00b2->B:38:0x00b2 BREAK  A[LOOP:0: B:5:0x0016->B:50:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadDecimalLong(@NotNull Buffer commonReadDecimalLong) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadDecimalLong, "$this$commonReadDecimalLong");
        if (commonReadDecimalLong.size() == 0) {
            throw new EOFException();
        }
        int i = 0;
        boolean z = false;
        long j = -7;
        long j2 = 0;
        boolean z2 = false;
        do {
            Segment segment = commonReadDecimalLong.head;
            Intrinsics.checkNotNull(segment);
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i4 = segment.limit;
            while (i2 < i4) {
                byte b = bArr[i2];
                byte b5 = (byte) 48;
                if (b >= b5 && b <= ((byte) 57)) {
                    int i5 = b5 - b;
                    if (j2 < OVERFLOW_ZONE || (j2 == OVERFLOW_ZONE && i5 < j)) {
                        Buffer bufferWriteByte = new Buffer().writeDecimalLong(j2).writeByte((int) b);
                        if (!z) {
                            bufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
                    }
                    j2 = (j2 * 10) + ((long) i5);
                } else if (b == ((byte) 45) && i == 0) {
                    j--;
                    z = true;
                } else {
                    if (i == 0) {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(b));
                    }
                    z2 = true;
                    if (i2 != i4) {
                        commonReadDecimalLong.head = segment.pop();
                        SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i2;
                    }
                    if (!z2) {
                        break;
                    }
                }
                i2++;
                i++;
            }
            if (i2 != i4) {
            }
            if (!z2) {
            }
        } while (commonReadDecimalLong.head != null);
        commonReadDecimalLong.setSize$okio(commonReadDecimalLong.size() - ((long) i));
        return z ? j2 : -j2;
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadFully, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int i2 = commonReadFully.read(sink, i, sink.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad A[EDGE_INSN: B:43:0x00ad->B:37:0x00ad BREAK  A[LOOP:0: B:5:0x0012->B:45:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadHexadecimalUnsignedLong(@NotNull Buffer commonReadHexadecimalUnsignedLong) throws EOFException {
        int i;
        Intrinsics.checkNotNullParameter(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        if (commonReadHexadecimalUnsignedLong.size() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = commonReadHexadecimalUnsignedLong.head;
            Intrinsics.checkNotNull(segment);
            byte[] bArr = segment.data;
            int i4 = segment.pos;
            int i5 = segment.limit;
            while (i4 < i5) {
                byte b = bArr[i4];
                byte b5 = (byte) 48;
                if (b < b5 || b > ((byte) 57)) {
                    byte b6 = (byte) 97;
                    if ((b >= b6 && b <= ((byte) 102)) || (b >= (b6 = (byte) 65) && b <= ((byte) 70))) {
                        i = (b - b6) + 10;
                    } else {
                        if (i2 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(b));
                        }
                        z = true;
                        if (i4 != i5) {
                            commonReadHexadecimalUnsignedLong.head = segment.pop();
                            SegmentPool.recycle(segment);
                        } else {
                            segment.pos = i4;
                        }
                        if (!z) {
                            break;
                        }
                    }
                } else {
                    i = b - b5;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | ((long) i);
                i4++;
                i2++;
            }
            if (i4 != i5) {
            }
            if (!z) {
            }
        } while (commonReadHexadecimalUnsignedLong.head != null);
        commonReadHexadecimalUnsignedLong.setSize$okio(commonReadHexadecimalUnsignedLong.size() - ((long) i2));
        return j;
    }

    public static final int commonReadInt(@NotNull Buffer commonReadInt) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.size() < 4) {
            throw new EOFException();
        }
        Segment segment = commonReadInt.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i4 = i + 3;
        int i5 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i6 = i + 4;
        int i7 = (bArr[i4] & 255) | i5;
        commonReadInt.setSize$okio(commonReadInt.size() - 4);
        if (i6 != i2) {
            segment.pos = i6;
            return i7;
        }
        commonReadInt.head = segment.pop();
        SegmentPool.recycle(segment);
        return i7;
    }

    public static final long commonReadLong(@NotNull Buffer commonReadLong) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.size() < 8) {
            throw new EOFException();
        }
        Segment segment = commonReadLong.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) commonReadLong.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) commonReadLong.readInt()));
        }
        byte[] bArr = segment.data;
        int i4 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i5 = i + 8;
        long j2 = j | (((long) bArr[i4]) & 255);
        commonReadLong.setSize$okio(commonReadLong.size() - 8);
        if (i5 != i2) {
            segment.pos = i5;
            return j2;
        }
        commonReadLong.head = segment.pop();
        SegmentPool.recycle(segment);
        return j2;
    }

    public static final short commonReadShort(@NotNull Buffer commonReadShort) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.size() < 2) {
            throw new EOFException();
        }
        Segment segment = commonReadShort.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i4 = i + 1;
        int i5 = (bArr[i] & 255) << 8;
        int i6 = i + 2;
        int i7 = (bArr[i4] & 255) | i5;
        commonReadShort.setSize$okio(commonReadShort.size() - 2);
        if (i6 == i2) {
            commonReadShort.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i6;
        }
        return (short) i7;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadUnsafe(@NotNull Buffer commonReadUnsafe, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(commonReadUnsafe, "$this$commonReadUnsafe");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = commonReadUnsafe;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer commonReadUtf8, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadUtf8, "$this$commonReadUtf8");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("byteCount: ", j).toString());
        }
        if (commonReadUtf8.size() < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = commonReadUtf8.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(commonReadUtf8.readByteArray(j), 0, 0, 3, null);
        }
        int i2 = (int) j;
        String strCommonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i, i + i2);
        segment.pos += i2;
        commonReadUtf8.setSize$okio(commonReadUtf8.size() - j);
        if (segment.pos == segment.limit) {
            commonReadUtf8.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer commonReadUtf8CodePoint) throws EOFException {
        int i;
        int i2;
        int i4;
        Intrinsics.checkNotNullParameter(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.size() == 0) {
            throw new EOFException();
        }
        byte b = commonReadUtf8CodePoint.getByte(0L);
        if ((b & 128) == 0) {
            i = b & 127;
            i4 = 0;
            i2 = 1;
        } else if ((b & CtapException.ERR_EXTENSION_FIRST) == 192) {
            i = b & 31;
            i2 = 2;
            i4 = 128;
        } else if ((b & CtapException.ERR_VENDOR_FIRST) == 224) {
            i = b & 15;
            i2 = 3;
            i4 = 2048;
        } else {
            if ((b & 248) != 240) {
                commonReadUtf8CodePoint.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = b & 7;
            i2 = 4;
            i4 = 65536;
        }
        long j = i2;
        if (commonReadUtf8CodePoint.size() < j) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i2, "size < ", ": ");
            sbM778t.append(commonReadUtf8CodePoint.size());
            sbM778t.append(" (to read code point prefixed 0x");
            sbM778t.append(Util.toHexString(b));
            sbM778t.append(PropertyUtils.MAPPED_DELIM2);
            throw new EOFException(sbM778t.toString());
        }
        for (int i5 = 1; i5 < i2; i5++) {
            long j2 = i5;
            byte b5 = commonReadUtf8CodePoint.getByte(j2);
            if ((b5 & 192) != 128) {
                commonReadUtf8CodePoint.skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
        }
        commonReadUtf8CodePoint.skip(j);
        return i > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i && 57343 >= i) || i < i4) ? Utf8.REPLACEMENT_CODE_POINT : i;
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer commonReadUtf8Line) {
        Intrinsics.checkNotNullParameter(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long jIndexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(commonReadUtf8Line, jIndexOf);
        }
        if (commonReadUtf8Line.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer commonReadUtf8LineStrict, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("limit < 0: ", j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b = (byte) 10;
        long jIndexOf = commonReadUtf8LineStrict.indexOf(b, 0L, j2);
        if (jIndexOf != -1) {
            return readUtf8Line(commonReadUtf8LineStrict, jIndexOf);
        }
        if (j2 < commonReadUtf8LineStrict.size() && commonReadUtf8LineStrict.getByte(j2 - 1) == ((byte) 13) && commonReadUtf8LineStrict.getByte(j2) == b) {
            return readUtf8Line(commonReadUtf8LineStrict, j2);
        }
        Buffer buffer = new Buffer();
        commonReadUtf8LineStrict.copyTo(buffer, 0L, Math.min(32, commonReadUtf8LineStrict.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.size(), j) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
    }

    public static final long commonResizeBuffer(@NotNull Buffer.UnsafeCursor commonResizeBuffer, long j) {
        Intrinsics.checkNotNullParameter(commonResizeBuffer, "$this$commonResizeBuffer");
        Buffer buffer = commonResizeBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!commonResizeBuffer.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long size = buffer.size();
        int i = 1;
        if (j <= size) {
            if (!(j >= 0)) {
                throw new IllegalArgumentException(AbstractC0622a.m1169o("newSize < 0: ", j).toString());
            }
            long j2 = size - j;
            while (true) {
                if (j2 <= 0) {
                    break;
                }
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                int i2 = segment2.limit;
                long j3 = i2 - segment2.pos;
                if (j3 > j2) {
                    segment2.limit = i2 - ((int) j2);
                    break;
                }
                buffer.head = segment2.pop();
                SegmentPool.recycle(segment2);
                j2 -= j3;
            }
            commonResizeBuffer.setSegment$okio(null);
            commonResizeBuffer.offset = j;
            commonResizeBuffer.data = null;
            commonResizeBuffer.start = -1;
            commonResizeBuffer.end = -1;
        } else if (j > size) {
            long j5 = j - size;
            boolean z = true;
            while (j5 > 0) {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
                int iMin = (int) Math.min(j5, 8192 - segmentWritableSegment$okio.limit);
                segmentWritableSegment$okio.limit += iMin;
                j5 -= (long) iMin;
                if (z) {
                    commonResizeBuffer.setSegment$okio(segmentWritableSegment$okio);
                    commonResizeBuffer.offset = size;
                    commonResizeBuffer.data = segmentWritableSegment$okio.data;
                    int i4 = segmentWritableSegment$okio.limit;
                    commonResizeBuffer.start = i4 - iMin;
                    commonResizeBuffer.end = i4;
                    z = false;
                }
                i = 1;
            }
        }
        buffer.setSize$okio(j);
        return size;
    }

    public static final int commonSeek(@NotNull Buffer.UnsafeCursor commonSeek, long j) {
        Segment segmentPush;
        Intrinsics.checkNotNullParameter(commonSeek, "$this$commonSeek");
        Buffer buffer = commonSeek.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j < -1 || j > buffer.size()) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "offset=", " > size=");
            sbM1323p.append(buffer.size());
            throw new ArrayIndexOutOfBoundsException(sbM1323p.toString());
        }
        if (j == -1 || j == buffer.size()) {
            commonSeek.setSegment$okio(null);
            commonSeek.offset = j;
            commonSeek.data = null;
            commonSeek.start = -1;
            commonSeek.end = -1;
            return -1;
        }
        long size = buffer.size();
        Segment segment = buffer.head;
        long j2 = 0;
        if (commonSeek.getSegment() != null) {
            long j3 = commonSeek.offset;
            int i = commonSeek.start;
            Segment segment2 = commonSeek.getSegment();
            Intrinsics.checkNotNull(segment2);
            long j5 = j3 - ((long) (i - segment2.pos));
            if (j5 > j) {
                segmentPush = segment;
                segment = commonSeek.getSegment();
                size = j5;
            } else {
                segmentPush = commonSeek.getSegment();
                j2 = j5;
            }
        } else {
            segmentPush = segment;
        }
        if (size - j > j - j2) {
            while (true) {
                Intrinsics.checkNotNull(segmentPush);
                int i2 = segmentPush.limit;
                int i4 = segmentPush.pos;
                if (j < ((long) (i2 - i4)) + j2) {
                    break;
                }
                j2 += (long) (i2 - i4);
                segmentPush = segmentPush.next;
            }
        } else {
            while (size > j) {
                Intrinsics.checkNotNull(segment);
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            j2 = size;
            segmentPush = segment;
        }
        if (commonSeek.readWrite) {
            Intrinsics.checkNotNull(segmentPush);
            if (segmentPush.shared) {
                Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                if (buffer.head == segmentPush) {
                    buffer.head = segmentUnsharedCopy;
                }
                segmentPush = segmentPush.push(segmentUnsharedCopy);
                Segment segment3 = segmentPush.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.pop();
            }
        }
        commonSeek.setSegment$okio(segmentPush);
        commonSeek.offset = j;
        Intrinsics.checkNotNull(segmentPush);
        commonSeek.data = segmentPush.data;
        int i5 = segmentPush.pos + ((int) (j - j2));
        commonSeek.start = i5;
        int i6 = segmentPush.limit;
        commonSeek.end = i6;
        return i6 - i5;
    }

    public static final int commonSelect(@NotNull Buffer commonSelect, @NotNull Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(commonSelect, "$this$commonSelect");
        Intrinsics.checkNotNullParameter(options, "options");
        int iSelectPrefix$default = selectPrefix$default(commonSelect, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        commonSelect.skip(options.getByteStrings()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer commonSkip, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonSkip, "$this$commonSkip");
        while (j > 0) {
            Segment segment = commonSkip.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            commonSkip.setSize$okio(commonSkip.size() - j2);
            j -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                commonSkip.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot) {
        Intrinsics.checkNotNullParameter(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.size() <= ((long) Integer.MAX_VALUE)) {
            return commonSnapshot.snapshot((int) commonSnapshot.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.size()).toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer commonWritableSegment, int i) {
        Intrinsics.checkNotNullParameter(commonWritableSegment, "$this$commonWritableSegment");
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = commonWritableSegment.head;
        if (segment != null) {
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        commonWritableSegment.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(commonWrite, i, i2);
        return commonWrite;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer commonWrite, ByteString byteString, int i, int i2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(commonWrite, i, i2);
        return commonWrite;
    }

    public static final long commonWriteAll(@NotNull Buffer commonWriteAll, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(commonWriteAll, "$this$commonWriteAll");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(commonWriteAll, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer commonWriteByte, int i) {
        Intrinsics.checkNotNullParameter(commonWriteByte, "$this$commonWriteByte");
        Segment segmentWritableSegment$okio = commonWriteByte.writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        commonWriteByte.setSize$okio(commonWriteByte.size() + 1);
        return commonWriteByte;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer commonWriteDecimalLong, long j) {
        boolean z;
        Intrinsics.checkNotNullParameter(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < AnimationKt.MillisToNanos ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment segmentWritableSegment$okio = commonWriteDecimalLong.writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i;
        commonWriteDecimalLong.setSize$okio(commonWriteDecimalLong.size() + ((long) i));
        return commonWriteDecimalLong;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer commonWriteHexadecimalUnsignedLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j5 = j3 | (j3 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = commonWriteHexadecimalUnsignedLong.writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i4 = (i2 + i) - 1; i4 >= i2; i4--) {
            bArr[i4] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        commonWriteHexadecimalUnsignedLong.setSize$okio(commonWriteHexadecimalUnsignedLong.size() + ((long) i));
        return commonWriteHexadecimalUnsignedLong;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter(commonWriteInt, "$this$commonWriteInt");
        Segment segmentWritableSegment$okio = commonWriteInt.writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 4;
        commonWriteInt.setSize$okio(commonWriteInt.size() + 4);
        return commonWriteInt;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer commonWriteLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteLong, "$this$commonWriteLong");
        Segment segmentWritableSegment$okio = commonWriteLong.writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i = segmentWritableSegment$okio.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        segmentWritableSegment$okio.limit = i + 8;
        commonWriteLong.setSize$okio(commonWriteLong.size() + 8);
        return commonWriteLong;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer commonWriteShort, int i) {
        Intrinsics.checkNotNullParameter(commonWriteShort, "$this$commonWriteShort");
        Segment segmentWritableSegment$okio = commonWriteShort.writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 2;
        commonWriteShort.setSize$okio(commonWriteShort.size() + 2);
        return commonWriteShort;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer commonWriteUtf8, @NotNull String string, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "beginIndex < 0: ").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i2, i, "endIndex < beginIndex: ", " < ").toString());
        }
        if (!(i2 <= string.length())) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i2, "endIndex > string.length: ", " > ");
            sbM778t.append(string.length());
            throw new IllegalArgumentException(sbM778t.toString().toString());
        }
        while (i < i2) {
            char cCharAt = string.charAt(i);
            if (cCharAt < 128) {
                Segment segmentWritableSegment$okio = commonWriteUtf8.writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i4 = segmentWritableSegment$okio.limit - i;
                int iMin = Math.min(i2, 8192 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) cCharAt;
                while (i5 < iMin) {
                    char cCharAt2 = string.charAt(i5);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) cCharAt2;
                    i5++;
                }
                int i6 = segmentWritableSegment$okio.limit;
                int i7 = (i4 + i5) - i6;
                segmentWritableSegment$okio.limit = i6 + i7;
                commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + ((long) i7));
                i = i5;
            } else {
                if (cCharAt < 2048) {
                    Segment segmentWritableSegment$okio2 = commonWriteUtf8.writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i8 = segmentWritableSegment$okio2.limit;
                    bArr2[i8] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio2.limit = i8 + 2;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    Segment segmentWritableSegment$okio3 = commonWriteUtf8.writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i9 = segmentWritableSegment$okio3.limit;
                    bArr3[i9] = (byte) ((cCharAt >> '\f') | JPEG.APP0);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio3.limit = i9 + 3;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 3);
                } else {
                    int i10 = i + 1;
                    char cCharAt3 = i10 < i2 ? string.charAt(i10) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        commonWriteUtf8.writeByte(63);
                        i = i10;
                    } else {
                        int i11 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = commonWriteUtf8.writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i12 = segmentWritableSegment$okio4.limit;
                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i12 + 4;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return commonWriteUtf8;
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer commonWriteUtf8CodePoint, int i) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            commonWriteUtf8CodePoint.writeByte(i);
            return commonWriteUtf8CodePoint;
        }
        if (i < 2048) {
            Segment segmentWritableSegment$okio = commonWriteUtf8CodePoint.writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 2);
            return commonWriteUtf8CodePoint;
        }
        if (55296 <= i && 57343 >= i) {
            commonWriteUtf8CodePoint.writeByte(63);
            return commonWriteUtf8CodePoint;
        }
        if (i < 65536) {
            Segment segmentWritableSegment$okio2 = commonWriteUtf8CodePoint.writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i4 = segmentWritableSegment$okio2.limit;
            bArr2[i4] = (byte) ((i >> 12) | JPEG.APP0);
            bArr2[i4 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i4 + 3;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 3);
            return commonWriteUtf8CodePoint;
        }
        if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i));
        }
        Segment segmentWritableSegment$okio3 = commonWriteUtf8CodePoint.writableSegment$okio(4);
        byte[] bArr3 = segmentWritableSegment$okio3.data;
        int i5 = segmentWritableSegment$okio3.limit;
        bArr3[i5] = (byte) ((i >> 18) | 240);
        bArr3[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i5 + 3] = (byte) ((i & 63) | 128);
        segmentWritableSegment$okio3.limit = i5 + 4;
        commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 4);
        return commonWriteUtf8CodePoint;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i, @NotNull byte[] bytes, int i2, int i4) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i5 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i4) {
            if (i == i5) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i5 = segment.limit;
            }
            if (bArr[i] != bytes[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer readUtf8Line, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(readUtf8Line, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (readUtf8Line.getByte(j2) == ((byte) 13)) {
                String utf8 = readUtf8Line.readUtf8(j2);
                readUtf8Line.skip(2L);
                return utf8;
            }
        }
        String utf82 = readUtf8Line.readUtf8(j);
        readUtf8Line.skip(1L);
        return utf82;
    }

    public static final <T> T seek(@NotNull Buffer seek, long j, @NotNull Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.checkNotNullParameter(seek, "$this$seek");
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        Segment segment = seek.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (seek.size() - j < j) {
            long size = seek.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                return lambda.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j2 = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (r19 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1 A[LOOP:0: B:5:0x0022->B:43:0x00a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int selectPrefix(@NotNull Buffer selectPrefix, @NotNull Options options, boolean z) {
        int i;
        int i2;
        Segment segment;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(selectPrefix, "$this$selectPrefix");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = selectPrefix.head;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i6 = segment2.pos;
        int i7 = segment2.limit;
        int[] trie$okio = options.getTrie();
        Segment segment3 = segment2;
        int i8 = -1;
        int i9 = 0;
        loop0: while (true) {
            int i10 = i9 + 1;
            int i11 = trie$okio[i9];
            int i12 = i9 + 2;
            int i13 = trie$okio[i10];
            if (i13 != -1) {
                i8 = i13;
            }
            if (segment3 == null) {
                break;
            }
            if (i11 >= 0) {
                i = i6 + 1;
                int i14 = bArr[i6] & 255;
                int i15 = i12 + i11;
                while (i12 != i15) {
                    if (i14 == trie$okio[i12]) {
                        i2 = trie$okio[i12 + i11];
                        if (i == i7) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            i = segment3.pos;
                            bArr = segment3.data;
                            i7 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                        if (i2 < 0) {
                        }
                    } else {
                        i12++;
                    }
                }
                break loop0;
            }
            int i16 = (i11 * (-1)) + i12;
            while (true) {
                int i17 = i6 + 1;
                int i18 = i12 + 1;
                if ((bArr[i6] & 255) != trie$okio[i12]) {
                    break loop0;
                }
                boolean z2 = i18 == i16;
                if (i17 == i7) {
                    Intrinsics.checkNotNull(segment3);
                    Segment segment4 = segment3.next;
                    Intrinsics.checkNotNull(segment4);
                    i5 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i4 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    i4 = i7;
                    i5 = i17;
                }
                if (z2) {
                    i2 = trie$okio[i18];
                    i = i5;
                    i7 = i4;
                    segment3 = segment;
                    break;
                }
                i6 = i5;
                i7 = i4;
                segment3 = segment;
                i12 = i18;
            }
            if (i2 < 0) {
                return i2;
            }
            i9 = -i2;
            i6 = i;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonRead, "$this$commonRead");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = commonRead.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i4 = segment.pos;
        ArraysKt.copyInto(bArr, sink, i, i4, i4 + iMin);
        segment.pos += iMin;
        commonRead.setSize$okio(commonRead.size() - ((long) iMin));
        if (segment.pos == segment.limit) {
            commonRead.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadByteArray, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("byteCount: ", j).toString());
        }
        if (commonReadByteArray.size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        commonReadByteArray.readFully(bArr);
        return bArr;
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadByteString, "$this$commonReadByteString");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("byteCount: ", j).toString());
        }
        if (commonReadByteString.size() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(commonReadByteString.readByteArray(j));
        }
        ByteString byteStringSnapshot = commonReadByteString.snapshot((int) j);
        commonReadByteString.skip(j);
        return byteStringSnapshot;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        Util.checkOffsetAndCount(source.length, i, j);
        int i4 = i2 + i;
        while (i < i4) {
            Segment segmentWritableSegment$okio = commonWrite.writableSegment$okio(1);
            int iMin = Math.min(i4 - i, 8192 - segmentWritableSegment$okio.limit);
            int i5 = i + iMin;
            ArraysKt.copyInto(source, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i, i5);
            segmentWritableSegment$okio.limit += iMin;
            i = i5;
        }
        commonWrite.setSize$okio(commonWrite.size() + j);
        return commonWrite;
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull Buffer sink, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadFully, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (commonReadFully.size() >= j) {
            sink.write(commonReadFully, j);
        } else {
            sink.write(commonReadFully, commonReadFully.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot, int i) {
        Intrinsics.checkNotNullParameter(commonSnapshot, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(commonSnapshot.size(), 0L, i);
        Segment segment = commonSnapshot.head;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            Intrinsics.checkNotNull(segment);
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        Segment segment2 = commonSnapshot.head;
        int i8 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i8] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i8] = Math.min(i2, i);
            iArr[i8 + i5] = segment2.pos;
            segment2.shared = true;
            i8++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull Source source, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long j2 = source.read(commonWrite, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return commonWrite;
    }

    public static final long commonRead(@NotNull Buffer commonRead, @NotNull Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(commonRead, "$this$commonRead");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("byteCount < 0: ", j).toString());
        }
        if (commonRead.size() == 0) {
            return -1L;
        }
        if (j > commonRead.size()) {
            j = commonRead.size();
        }
        sink.write(commonRead, j);
        return j;
    }

    public static final void commonWrite(@NotNull Buffer commonWrite, @NotNull Buffer source, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != commonWrite) {
            Util.checkOffsetAndCount(source.size(), 0L, j);
            while (j > 0) {
                Segment segment2 = source.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment2.limit;
                Intrinsics.checkNotNull(source.head);
                if (j < i - r2.pos) {
                    Segment segment3 = commonWrite.head;
                    if (segment3 != null) {
                        Intrinsics.checkNotNull(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                            Segment segment4 = source.head;
                            Intrinsics.checkNotNull(segment4);
                            segment4.writeTo(segment, (int) j);
                            source.setSize$okio(source.size() - j);
                            commonWrite.setSize$okio(commonWrite.size() + j);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    Intrinsics.checkNotNull(segment5);
                    source.head = segment5.split((int) j);
                }
                Segment segment6 = source.head;
                Intrinsics.checkNotNull(segment6);
                long j2 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = commonWrite.head;
                if (segment7 == null) {
                    commonWrite.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    Intrinsics.checkNotNull(segment7);
                    Segment segment8 = segment7.prev;
                    Intrinsics.checkNotNull(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j2);
                commonWrite.setSize$okio(commonWrite.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, @NotNull ByteString bytes, long j) {
        long j2 = j;
        Intrinsics.checkNotNullParameter(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j3 = 0;
        if (j2 >= 0) {
            Segment segment = commonIndexOf.head;
            if (segment == null) {
                return -1L;
            }
            if (commonIndexOf.size() - j2 < j2) {
                long size = commonIndexOf.size();
                while (size > j2) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    size -= (long) (segment.limit - segment.pos);
                }
                byte[] bArrInternalArray$okio = bytes.internalArray$okio();
                byte b = bArrInternalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (commonIndexOf.size() - ((long) size2)) + 1;
                while (size < size3) {
                    byte[] bArr = segment.data;
                    int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                    for (int i = (int) ((((long) segment.pos) + j2) - size); i < iMin; i++) {
                        if (bArr[i] == b && rangeEquals(segment, i + 1, bArrInternalArray$okio, 1, size2)) {
                            return ((long) (i - segment.pos)) + size;
                        }
                    }
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j2 = size;
                }
                return -1L;
            }
            while (true) {
                long j5 = ((long) (segment.limit - segment.pos)) + j3;
                if (j5 > j2) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j5;
            }
            byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
            byte b5 = bArrInternalArray$okio2[0];
            int size4 = bytes.size();
            long size5 = (commonIndexOf.size() - ((long) size4)) + 1;
            while (j3 < size5) {
                byte[] bArr2 = segment.data;
                long j6 = j3;
                int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - j3);
                for (int i2 = (int) ((((long) segment.pos) + j2) - j6); i2 < iMin2; i2++) {
                    if (bArr2[i2] == b5 && rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size4)) {
                        return ((long) (i2 - segment.pos)) + j6;
                    }
                }
                j3 = j6 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(AbstractC0622a.m1169o("fromIndex < 0: ", j2).toString());
    }
}
