package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b¨\u0006*"}, m13886d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", TypedValues.Cycle.S_WAVE_OFFSET, "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", VPathDataCmd.RCurveTo, "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", TextConst.KEY_END_INDEX, "commonWriteUtf8CodePoint", "codePoint", "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
public final class RealBufferedSinkKt {
    public static final void commonClose(@NotNull RealBufferedSink commonClose) throws Throwable {
        Intrinsics.checkNotNullParameter(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        try {
            if (commonClose.bufferField.size() > 0) {
                Sink sink = commonClose.sink;
                Buffer buffer = commonClose.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            commonClose.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        commonClose.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink commonEmit) {
        Intrinsics.checkNotNullParameter(commonEmit, "$this$commonEmit");
        if (commonEmit.closed) {
            throw new IllegalStateException("closed");
        }
        long size = commonEmit.bufferField.size();
        if (size > 0) {
            commonEmit.sink.write(commonEmit.bufferField, size);
        }
        return commonEmit;
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink commonEmitCompleteSegments) {
        Intrinsics.checkNotNullParameter(commonEmitCompleteSegments, "$this$commonEmitCompleteSegments");
        if (commonEmitCompleteSegments.closed) {
            throw new IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = commonEmitCompleteSegments.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            commonEmitCompleteSegments.sink.write(commonEmitCompleteSegments.bufferField, jCompleteSegmentByteCount);
        }
        return commonEmitCompleteSegments;
    }

    public static final void commonFlush(@NotNull RealBufferedSink commonFlush) {
        Intrinsics.checkNotNullParameter(commonFlush, "$this$commonFlush");
        if (commonFlush.closed) {
            throw new IllegalStateException("closed");
        }
        if (commonFlush.bufferField.size() > 0) {
            Sink sink = commonFlush.sink;
            Buffer buffer = commonFlush.bufferField;
            sink.write(buffer, buffer.size());
        }
        commonFlush.sink.flush();
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink commonTimeout) {
        Intrinsics.checkNotNullParameter(commonTimeout, "$this$commonTimeout");
        return commonTimeout.sink.getTimeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink commonToString) {
        Intrinsics.checkNotNullParameter(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.sink + PropertyUtils.MAPPED_DELIM2;
    }

    public static final void commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull Buffer source, long j) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (commonWrite.closed) {
            throw new IllegalStateException("closed");
        }
        commonWrite.bufferField.write(source, j);
        commonWrite.emitCompleteSegments();
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink commonWriteAll, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(commonWriteAll, "$this$commonWriteAll");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(commonWriteAll.bufferField, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            commonWriteAll.emitCompleteSegments();
        }
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink commonWriteByte, int i) {
        Intrinsics.checkNotNullParameter(commonWriteByte, "$this$commonWriteByte");
        if (commonWriteByte.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteByte.bufferField.writeByte(i);
        return commonWriteByte.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink commonWriteDecimalLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (commonWriteDecimalLong.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteDecimalLong.bufferField.writeDecimalLong(j);
        return commonWriteDecimalLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink commonWriteHexadecimalUnsignedLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (commonWriteHexadecimalUnsignedLong.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteHexadecimalUnsignedLong.bufferField.writeHexadecimalUnsignedLong(j);
        return commonWriteHexadecimalUnsignedLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter(commonWriteInt, "$this$commonWriteInt");
        if (commonWriteInt.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteInt.bufferField.writeInt(i);
        return commonWriteInt.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink commonWriteIntLe, int i) {
        Intrinsics.checkNotNullParameter(commonWriteIntLe, "$this$commonWriteIntLe");
        if (commonWriteIntLe.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteIntLe.bufferField.writeIntLe(i);
        return commonWriteIntLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink commonWriteLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteLong, "$this$commonWriteLong");
        if (commonWriteLong.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteLong.bufferField.writeLong(j);
        return commonWriteLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink commonWriteLongLe, long j) {
        Intrinsics.checkNotNullParameter(commonWriteLongLe, "$this$commonWriteLongLe");
        if (commonWriteLongLe.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteLongLe.bufferField.writeLongLe(j);
        return commonWriteLongLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink commonWriteShort, int i) {
        Intrinsics.checkNotNullParameter(commonWriteShort, "$this$commonWriteShort");
        if (commonWriteShort.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteShort.bufferField.writeShort(i);
        return commonWriteShort.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink commonWriteShortLe, int i) {
        Intrinsics.checkNotNullParameter(commonWriteShortLe, "$this$commonWriteShortLe");
        if (commonWriteShortLe.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteShortLe.bufferField.writeShortLe(i);
        return commonWriteShortLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink commonWriteUtf8, @NotNull String string) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(string, "string");
        if (commonWriteUtf8.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteUtf8.bufferField.writeUtf8(string);
        return commonWriteUtf8.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink commonWriteUtf8CodePoint, int i) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (commonWriteUtf8CodePoint.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteUtf8CodePoint.bufferField.writeUtf8CodePoint(i);
        return commonWriteUtf8CodePoint.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!commonWrite.closed) {
            commonWrite.bufferField.write(byteString);
            return commonWrite.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink commonWriteUtf8, @NotNull String string, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!commonWriteUtf8.closed) {
            commonWriteUtf8.bufferField.writeUtf8(string, i, i2);
            return commonWriteUtf8.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!commonWrite.closed) {
            commonWrite.bufferField.write(byteString, i, i2);
            return commonWrite.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!commonWrite.closed) {
            commonWrite.bufferField.write(source);
            return commonWrite.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!commonWrite.closed) {
            commonWrite.bufferField.write(source, i, i2);
            return commonWrite.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull Source source, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long j2 = source.read(commonWrite.bufferField, j);
            if (j2 != -1) {
                j -= j2;
                commonWrite.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return commonWrite;
    }
}
