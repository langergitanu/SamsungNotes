package cz.msebera.android.httpclient.impl.p171io;

import cz.msebera.android.httpclient.MessageConstraintException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.p172io.BufferInfo;
import cz.msebera.android.httpclient.p172io.HttpTransportMetrics;
import cz.msebera.android.httpclient.p172io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream inStream;
    private final ByteArrayBuffer lineBuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i, int i2, MessageConstraints messageConstraints, CharsetDecoder charsetDecoder) {
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        Args.positive(i, "Buffer size");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new byte[i];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.minChunkLimit = i2 < 0 ? 512 : i2;
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.lineBuffer = new ByteArrayBuffer(i);
        this.decoder = charsetDecoder;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) {
        int iHandleDecodingResult = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
        }
        this.decoder.reset();
        while (byteBuffer.hasRemaining()) {
            iHandleDecodingResult += handleDecodingResult(this.decoder.decode(byteBuffer, this.cbuf, true), charArrayBuffer, byteBuffer);
        }
        int iHandleDecodingResult2 = iHandleDecodingResult + handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer, byteBuffer);
        this.cbuf.clear();
        return iHandleDecodingResult2;
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws CharacterCodingException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int iRemaining = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return iRemaining;
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) {
        int length = this.lineBuffer.length();
        if (length > 0) {
            if (this.lineBuffer.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.lineBuffer.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.decoder == null) {
            charArrayBuffer.append(this.lineBuffer, 0, length);
        } else {
            length = appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.lineBuffer.buffer(), 0, length));
        }
        this.lineBuffer.clear();
        return length;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i) {
        int i2 = this.bufferPos;
        this.bufferPos = i + 1;
        if (i > i2 && this.buffer[i - 1] == 13) {
            i--;
        }
        int i4 = i - i2;
        if (this.decoder != null) {
            return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i2, i4));
        }
        charArrayBuffer.append(this.buffer, i2, i4);
        return i4;
    }

    private int streamRead(byte[] bArr, int i, int i2) {
        Asserts.notNull(this.inStream, "Input stream");
        return this.inStream.read(bArr, i, i2);
    }

    @Override // cz.msebera.android.httpclient.p172io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(InputStream inputStream) {
        this.inStream = inputStream;
    }

    @Override // cz.msebera.android.httpclient.p172io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.bufferPos = 0;
        this.bufferLen = 0;
    }

    public int fillBuffer() {
        int i = this.bufferPos;
        if (i > 0) {
            int i2 = this.bufferLen - i;
            if (i2 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            this.bufferPos = 0;
            this.bufferLen = i2;
        }
        int i4 = this.bufferLen;
        byte[] bArr2 = this.buffer;
        int iStreamRead = streamRead(bArr2, i4, bArr2.length - i4);
        if (iStreamRead == -1) {
            return -1;
        }
        this.bufferLen = i4 + iStreamRead;
        this.metrics.incrementBytesTransferred(iStreamRead);
        return iStreamRead;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        return this.bufferPos < this.bufferLen;
    }

    public boolean isBound() {
        return this.inStream != null;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public boolean isDataAvailable(int i) {
        return hasBufferedData();
    }

    @Override // cz.msebera.android.httpclient.p172io.BufferInfo
    public int length() {
        return this.bufferLen - this.bufferPos;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read() {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i] & 255;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) throws MessageConstraintException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int maxLineLength = this.constraints.getMaxLineLength();
        boolean z = true;
        int iFillBuffer = 0;
        while (z) {
            int i = this.bufferPos;
            while (true) {
                if (i >= this.bufferLen) {
                    i = -1;
                    break;
                }
                if (this.buffer[i] == 10) {
                    break;
                }
                i++;
            }
            if (maxLineLength > 0) {
                if ((this.lineBuffer.length() + (i >= 0 ? i : this.bufferLen)) - this.bufferPos >= maxLineLength) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
            }
            if (i == -1) {
                if (hasBufferedData()) {
                    int i2 = this.bufferLen;
                    int i4 = this.bufferPos;
                    this.lineBuffer.append(this.buffer, i4, i2 - i4);
                    this.bufferPos = this.bufferLen;
                }
                iFillBuffer = fillBuffer();
                if (iFillBuffer == -1) {
                }
            } else {
                if (this.lineBuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, i);
                }
                int i5 = i + 1;
                int i6 = this.bufferPos;
                this.lineBuffer.append(this.buffer, i6, i5 - i6);
                this.bufferPos = i5;
            }
            z = false;
        }
        if (iFillBuffer == -1 && this.lineBuffer.isEmpty()) {
            return -1;
        }
        return lineFromLineBuffer(charArrayBuffer);
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 0;
        }
        if (hasBufferedData()) {
            int iMin = Math.min(i2, this.bufferLen - this.bufferPos);
            System.arraycopy(this.buffer, this.bufferPos, bArr, i, iMin);
            this.bufferPos += iMin;
            return iMin;
        }
        if (i2 > this.minChunkLimit) {
            int iStreamRead = streamRead(bArr, i, i2);
            if (iStreamRead > 0) {
                this.metrics.incrementBytesTransferred(iStreamRead);
            }
            return iStreamRead;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        int iMin2 = Math.min(i2, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, bArr, i, iMin2);
        this.bufferPos += iMin2;
        return iMin2;
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i) {
        this(httpTransportMetricsImpl, i, i, null, null);
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public String readLine() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }
}
