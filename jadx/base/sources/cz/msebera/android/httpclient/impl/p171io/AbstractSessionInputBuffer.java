package cz.msebera.android.httpclient.impl.p171io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.p172io.BufferInfo;
import cz.msebera.android.httpclient.p172io.HttpTransportMetrics;
import cz.msebera.android.httpclient.p172io.SessionInputBuffer;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.CoreProtocolPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer, BufferInfo {
    private boolean ascii;
    private byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private Charset charset;
    private CharsetDecoder decoder;
    private InputStream inStream;
    private ByteArrayBuffer lineBuffer;
    private int maxLineLen;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) {
        int iHandleDecodingResult = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.decoder == null) {
            CharsetDecoder charsetDecoderNewDecoder = this.charset.newDecoder();
            this.decoder = charsetDecoderNewDecoder;
            charsetDecoderNewDecoder.onMalformedInput(this.onMalformedCharAction);
            this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
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
        if (this.ascii) {
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
        if (!this.ascii) {
            return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i2, i4));
        }
        charArrayBuffer.append(this.buffer, i2, i4);
        return i4;
    }

    private int locateLF() {
        for (int i = this.bufferPos; i < this.bufferLen; i++) {
            if (this.buffer[i] == 10) {
                return i;
            }
        }
        return -1;
    }

    @Override // cz.msebera.android.httpclient.p172io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    @Override // cz.msebera.android.httpclient.p172io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
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
        int i5 = this.inStream.read(bArr2, i4, bArr2.length - i4);
        if (i5 == -1) {
            return -1;
        }
        this.bufferLen = i4 + i5;
        this.metrics.incrementBytesTransferred(i5);
        return i5;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        return this.bufferPos < this.bufferLen;
    }

    public void init(InputStream inputStream, int i, HttpParams httpParams) {
        Args.notNull(inputStream, "Input stream");
        Args.notNegative(i, "Buffer size");
        Args.notNull(httpParams, "HTTP parameters");
        this.inStream = inputStream;
        this.buffer = new byte[i];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.lineBuffer = new ByteArrayBuffer(i);
        String str = (String) httpParams.getParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        Charset charsetForName = str != null ? Charset.forName(str) : Consts.ASCII;
        this.charset = charsetForName;
        this.ascii = charsetForName.equals(Consts.ASCII);
        this.decoder = null;
        this.maxLineLen = httpParams.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.minChunkLimit = httpParams.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
        this.metrics = createTransportMetrics();
        CodingErrorAction codingErrorAction = (CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.onMalformedCharAction = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.onUnmappableCharAction = codingErrorAction2;
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
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        boolean z = true;
        int iFillBuffer = 0;
        while (z) {
            int iLocateLF = locateLF();
            if (iLocateLF == -1) {
                if (hasBufferedData()) {
                    int i = this.bufferLen;
                    int i2 = this.bufferPos;
                    this.lineBuffer.append(this.buffer, i2, i - i2);
                    this.bufferPos = this.bufferLen;
                }
                iFillBuffer = fillBuffer();
                if (iFillBuffer == -1) {
                }
                if (this.maxLineLen <= 0 && this.lineBuffer.length() >= this.maxLineLen) {
                    throw new IOException("Maximum line length limit exceeded");
                }
            } else {
                if (this.lineBuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, iLocateLF);
                }
                int i4 = iLocateLF + 1;
                int i5 = this.bufferPos;
                this.lineBuffer.append(this.buffer, i5, i4 - i5);
                this.bufferPos = i4;
            }
            z = false;
            if (this.maxLineLen <= 0) {
            }
        }
        if (iFillBuffer == -1 && this.lineBuffer.isEmpty()) {
            return -1;
        }
        return lineFromLineBuffer(charArrayBuffer);
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read(byte[] bArr, int i, int i2) throws IOException {
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
            int i4 = this.inStream.read(bArr, i, i2);
            if (i4 > 0) {
                this.metrics.incrementBytesTransferred(i4);
            }
            return i4;
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
