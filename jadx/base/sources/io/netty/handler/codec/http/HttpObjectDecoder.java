package io.netty.handler.codec.http;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEFAULT_ALLOW_DUPLICATE_CONTENT_LENGTHS = false;
    public static final boolean DEFAULT_ALLOW_PARTIAL_CHUNKS = true;
    public static final boolean DEFAULT_CHUNKED_SUPPORTED = true;
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
    public static final int DEFAULT_MAX_INITIAL_LINE_LENGTH = 4096;
    public static final boolean DEFAULT_VALIDATE_HEADERS = true;
    private static final boolean[] ISO_CONTROL_OR_WHITESPACE;
    private static final boolean[] LATIN_WHITESPACE;
    private static final ByteProcessor SKIP_CONTROL_CHARS_BYTES;
    private static final boolean[] SP_LENIENT_BYTES;
    private final boolean allowDuplicateContentLengths;
    private final boolean allowPartialChunks;
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private AsciiString name;
    private final ByteBuf parserScratchBuffer;
    private final AtomicBoolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private String value;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpObjectDecoder$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125302 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderParser {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected final int maxLength;
        protected final ByteBuf seq;
        int size;

        public HeaderParser(ByteBuf byteBuf, int i) {
            this.seq = byteBuf;
            this.maxLength = i;
        }

        public TooLongFrameException newException(int i) {
            return new TooLongHttpHeaderException(AbstractC0541b.m767i(i, "HTTP header is larger than ", " bytes."));
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ByteBuf parse(ByteBuf byteBuf) {
            int i;
            int i2 = byteBuf.readableBytes();
            int i4 = byteBuf.readerIndex();
            int i5 = this.maxLength - this.size;
            int iIndexOf = byteBuf.indexOf(i4, ((int) Math.min(((long) i5) + 2, i2)) + i4, (byte) 10);
            if (iIndexOf == -1) {
                if (i2 <= i5) {
                    return null;
                }
                throw newException(this.maxLength);
            }
            if (iIndexOf > i4) {
                i = iIndexOf - 1;
                if (byteBuf.getByte(i) != 13) {
                    i = iIndexOf;
                }
            }
            int i6 = i - i4;
            if (i6 == 0) {
                this.seq.clear();
                byteBuf.readerIndex(iIndexOf + 1);
                return this.seq;
            }
            int i7 = this.size + i6;
            int i8 = this.maxLength;
            if (i7 > i8) {
                throw newException(i8);
            }
            this.size = i7;
            this.seq.clear();
            this.seq.writeBytes(byteBuf, i4, i6);
            byteBuf.readerIndex(iIndexOf + 1);
            return this.seq;
        }

        public void reset() {
            this.size = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class LineParser extends HeaderParser {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public LineParser(ByteBuf byteBuf, int i) {
            super(byteBuf, i);
        }

        private boolean skipControlChars(ByteBuf byteBuf, int i, int i2) {
            int iMin = Math.min(this.maxLength, i);
            int iForEachByte = byteBuf.forEachByte(i2, iMin, HttpObjectDecoder.SKIP_CONTROL_CHARS_BYTES);
            if (iForEachByte != -1) {
                byteBuf.readerIndex(iForEachByte);
                HttpObjectDecoder.this.currentState = State.READ_INITIAL;
                return false;
            }
            byteBuf.skipBytes(iMin);
            int i4 = this.maxLength;
            if (i <= i4) {
                return true;
            }
            throw newException(i4);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public TooLongFrameException newException(int i) {
            return new TooLongHttpLineException(AbstractC0541b.m767i(i, "An HTTP line is larger than ", " bytes."));
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public ByteBuf parse(ByteBuf byteBuf) {
            reset();
            int i = byteBuf.readableBytes();
            if (i == 0) {
                return null;
            }
            int i2 = byteBuf.readerIndex();
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS && skipControlChars(byteBuf, i, i2)) {
                return null;
            }
            return super.parse(byteBuf);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    static {
        boolean[] zArr = new boolean[256];
        SP_LENIENT_BYTES = zArr;
        zArr[160] = true;
        zArr[137] = true;
        zArr[139] = true;
        zArr[140] = true;
        zArr[141] = true;
        LATIN_WHITESPACE = new boolean[256];
        for (byte b = -128; b < 127; b = (byte) (b + 1)) {
            LATIN_WHITESPACE[b + 128] = Character.isWhitespace(b);
        }
        ISO_CONTROL_OR_WHITESPACE = new boolean[256];
        for (byte b5 = -128; b5 < 127; b5 = (byte) (b5 + 1)) {
            ISO_CONTROL_OR_WHITESPACE[b5 + 128] = Character.isISOControl(b5) || isWhitespace(b5);
        }
        SKIP_CONTROL_CHARS_BYTES = new ByteProcessor() { // from class: io.netty.handler.codec.http.HttpObjectDecoder.1
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b6) {
                return HttpObjectDecoder.ISO_CONTROL_OR_WHITESPACE[b6 + 128];
            }
        };
    }

    public HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private static int findEndOfString(byte[] bArr, int i, int i2) {
        for (int i4 = i2 - 1; i4 > i; i4--) {
            if (!isWhitespace(bArr[i4])) {
                return i4 + 1;
            }
        }
        return 0;
    }

    private static int findNonSPLenient(byte[] bArr, int i, int i2) {
        while (i < i2) {
            byte b = bArr[i];
            if (!isSPLenient(b)) {
                if (isWhitespace(b)) {
                    throw new IllegalArgumentException("Invalid separator");
                }
                return i;
            }
            i++;
        }
        return i2;
    }

    private static int findNonWhitespace(byte[] bArr, int i, int i2) {
        while (i < i2) {
            byte b = bArr[i];
            if (!isWhitespace(b)) {
                return i;
            }
            if (!isOWS(b)) {
                StringBuilder sbM778t = AbstractC0541b.m778t(b, "Invalid separator, only a single space or horizontal tab allowed, but received a '", "' (0x");
                sbM778t.append(Integer.toHexString(b));
                sbM778t.append(")");
                throw new IllegalArgumentException(sbM778t.toString());
            }
            i++;
        }
        return i2;
    }

    private static int findSPLenient(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (isSPLenient(bArr[i])) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static int getChunkSize(byte[] bArr, int i, int i2) {
        int iSkipWhiteSpaces = skipWhiteSpaces(bArr, i, i2);
        if (iSkipWhiteSpaces == i2) {
            throw new NumberFormatException();
        }
        int i4 = i + iSkipWhiteSpaces;
        int i5 = i2 - iSkipWhiteSpaces;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i5) {
                break;
            }
            int i8 = i4 + i6;
            int iDecodeHexNibble = StringUtil.decodeHexNibble(bArr[i8]);
            if (iDecodeHexNibble == -1) {
                byte b = bArr[i8];
                if (b != 59 && !isControlOrWhitespaceAsciiChar(b)) {
                    throw new NumberFormatException();
                }
                if (i6 == 0) {
                    throw new NumberFormatException();
                }
            } else {
                i7 = (i7 * 16) + iDecodeHexNibble;
                i6++;
            }
        }
        return i7;
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        if (this.message == null) {
            this.message = createInvalidMessage();
        }
        this.message.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private static boolean isControlOrWhitespaceAsciiChar(byte b) {
        return ISO_CONTROL_OR_WHITESPACE[b + 128];
    }

    private static boolean isOWS(byte b) {
        return b == 32 || b == 9;
    }

    private static boolean isSPLenient(byte b) {
        return SP_LENIENT_BYTES[b + 128];
    }

    private static boolean isWhitespace(byte b) {
        return LATIN_WHITESPACE[b + 128];
    }

    private static String langAsciiString(byte[] bArr, int i, int i2) {
        return i2 == 0 ? "" : i == 0 ? i2 == bArr.length ? new String(bArr, 0, 0, bArr.length) : new String(bArr, 0, 0, i2) : new String(bArr, 0, i, i2);
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders httpHeadersHeaders = httpMessage.headers();
        HeaderParser headerParser = this.headerParser;
        ByteBuf byteBuf2 = headerParser.parse(byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        int i = byteBuf2.readableBytes();
        while (i > 0) {
            byte[] bArrArray = byteBuf2.array();
            int iArrayOffset = byteBuf2.readerIndex() + byteBuf2.arrayOffset();
            byte b = bArrArray[iArrayOffset];
            AsciiString asciiString = this.name;
            if (asciiString == null || !(b == 32 || b == 9)) {
                if (asciiString != null) {
                    httpHeadersHeaders.add(asciiString, this.value);
                }
                splitHeader(bArrArray, iArrayOffset, i);
            } else {
                this.value = AbstractC1038a.m1212m(' ', this.value, langAsciiString(bArrArray, iArrayOffset, i).trim());
            }
            byteBuf2 = headerParser.parse(byteBuf);
            if (byteBuf2 == null) {
                return null;
            }
            i = byteBuf2.readableBytes();
        }
        AsciiString asciiString2 = this.name;
        if (asciiString2 != null) {
            httpHeadersHeaders.add(asciiString2, this.value);
        }
        this.name = null;
        this.value = null;
        httpMessage.setDecoderResult(new HttpMessageDecoderResult(this.lineParser.size, headerParser.size));
        AsciiString asciiString3 = HttpHeaderNames.CONTENT_LENGTH;
        List<String> all = httpHeadersHeaders.getAll(asciiString3);
        if (!all.isEmpty()) {
            HttpVersion httpVersionProtocolVersion = httpMessage.protocolVersion();
            long jNormalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, httpVersionProtocolVersion.majorVersion() < 1 || (httpVersionProtocolVersion.majorVersion() == 1 && httpVersionProtocolVersion.minorVersion() == 0), this.allowDuplicateContentLengths);
            this.contentLength = jNormalizeAndGetContentLength;
            if (jNormalizeAndGetContentLength != -1) {
                String strTrim = all.get(0).trim();
                if (all.size() > 1 || !strTrim.equals(Long.toString(this.contentLength))) {
                    httpHeadersHeaders.set(asciiString3, Long.valueOf(this.contentLength));
                }
            }
        }
        if (isContentAlwaysEmpty(httpMessage)) {
            HttpUtil.setTransferEncodingChunked(httpMessage, false);
            return State.SKIP_CONTROL_CHARS;
        }
        if (!HttpUtil.isTransferEncodingChunked(httpMessage)) {
            return contentLength() >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
        }
        if (!all.isEmpty() && httpMessage.protocolVersion() == HttpVersion.HTTP_1_1) {
            handleTransferEncodingChunkedWithContentLength(httpMessage);
        }
        return State.READ_CHUNK_SIZE;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        HeaderParser headerParser = this.headerParser;
        ByteBuf byteBuf2 = headerParser.parse(byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        LastHttpContent defaultLastHttpContent = this.trailer;
        int i = byteBuf2.readableBytes();
        if (i == 0 && defaultLastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (defaultLastHttpContent == null) {
            defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = defaultLastHttpContent;
        }
        AsciiString asciiString = null;
        while (i > 0) {
            byte[] bArrArray = byteBuf2.array();
            int iArrayOffset = byteBuf2.readerIndex() + byteBuf2.arrayOffset();
            byte b = bArrArray[iArrayOffset];
            if (asciiString == null || !(b == 32 || b == 9)) {
                splitHeader(bArrArray, iArrayOffset, i);
                AsciiString asciiString2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(asciiString2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(asciiString2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(asciiString2)) {
                    defaultLastHttpContent.trailingHeaders().add(asciiString2, this.value);
                }
                asciiString = this.name;
                this.name = null;
                this.value = null;
            } else {
                List<String> all = defaultLastHttpContent.trailingHeaders().getAll(asciiString);
                if (!all.isEmpty()) {
                    int size = all.size() - 1;
                    String strTrim = langAsciiString(bArrArray, iArrayOffset, byteBuf2.readableBytes()).trim();
                    all.set(size, all.get(size) + strTrim);
                }
            }
            byteBuf2 = headerParser.parse(byteBuf);
            if (byteBuf2 == null) {
                return null;
            }
            i = byteBuf2.readableBytes();
        }
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
        } else {
            this.resetRequested.lazySet(false);
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    private static int skipWhiteSpaces(byte[] bArr, int i, int i2) {
        for (int i4 = 0; i4 < i2; i4++) {
            if (!isWhitespace(bArr[i + i4])) {
                return i4;
            }
        }
        return i2;
    }

    private void splitHeader(byte[] bArr, int i, int i2) {
        byte b;
        int i4 = i2 + i;
        int iFindNonWhitespace = findNonWhitespace(bArr, i, i4);
        boolean zIsDecodingRequest = isDecodingRequest();
        int i5 = iFindNonWhitespace;
        while (i5 < i4 && (b = bArr[i5]) != 58 && (zIsDecodingRequest || !isOWS(b))) {
            i5++;
        }
        if (i5 == i4) {
            throw new IllegalArgumentException("No colon found");
        }
        int i6 = i5;
        while (true) {
            if (i6 >= i4) {
                break;
            }
            if (bArr[i6] == 58) {
                i6++;
                break;
            }
            i6++;
        }
        this.name = splitHeaderName(bArr, iFindNonWhitespace, i5 - iFindNonWhitespace);
        int iFindNonWhitespace2 = findNonWhitespace(bArr, i6, i4);
        if (iFindNonWhitespace2 == i4) {
            this.value = "";
        } else {
            this.value = langAsciiString(bArr, iFindNonWhitespace2, findEndOfString(bArr, i, i4) - iFindNonWhitespace2);
        }
    }

    private String[] splitInitialLine(ByteBuf byteBuf) {
        byte[] bArrArray = byteBuf.array();
        int iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        int i = byteBuf.readableBytes() + iArrayOffset;
        int iFindNonSPLenient = findNonSPLenient(bArrArray, iArrayOffset, i);
        int iFindSPLenient = findSPLenient(bArrArray, iFindNonSPLenient, i);
        int iFindNonSPLenient2 = findNonSPLenient(bArrArray, iFindSPLenient, i);
        int iFindSPLenient2 = findSPLenient(bArrArray, iFindNonSPLenient2, i);
        int iFindNonSPLenient3 = findNonSPLenient(bArrArray, iFindSPLenient2, i);
        int iFindEndOfString = findEndOfString(bArrArray, Math.max(iFindNonSPLenient3 - 1, iArrayOffset), i);
        return new String[]{splitFirstWordInitialLine(bArrArray, iFindNonSPLenient, iFindSPLenient - iFindNonSPLenient), splitSecondWordInitialLine(bArrArray, iFindNonSPLenient2, iFindSPLenient2 - iFindNonSPLenient2), iFindNonSPLenient3 < iFindEndOfString ? splitThirdWordInitialLine(bArrArray, iFindNonSPLenient3, iFindEndOfString - iFindNonSPLenient3) : ""};
    }

    public abstract HttpMessage createInvalidMessage();

    public abstract HttpMessage createMessage(String[] strArr);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0152 A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:74:0x014b, B:77:0x0152, B:81:0x0160, B:85:0x016e, B:90:0x0177, B:92:0x0180, B:94:0x0183, B:96:0x0191, B:98:0x0195, B:100:0x019b, B:101:0x01a2, B:102:0x01a3), top: B:112:0x014b }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        State headers;
        int iWriterIndex;
        int i;
        int i2;
        int iMin;
        if (this.resetRequested.get()) {
            resetNow();
        }
        int[] iArr = C125302.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;
        switch (iArr[this.currentState.ordinal()]) {
            case 1:
            case 3:
                try {
                    ByteBuf byteBuf2 = this.lineParser.parse(byteBuf);
                    if (byteBuf2 == null) {
                        return;
                    }
                    this.message = createMessage(splitInitialLine(byteBuf2));
                    this.currentState = State.READ_HEADER;
                    try {
                        headers = readHeaders(byteBuf);
                        if (headers != null) {
                            return;
                        }
                        this.currentState = headers;
                        int i4 = iArr[headers.ordinal()];
                        if (i4 == 1) {
                            list.add(this.message);
                            list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                            resetNow();
                            return;
                        }
                        if (i4 == 2) {
                            if (!this.chunkedSupported) {
                                throw new IllegalArgumentException("Chunked messages not supported");
                            }
                            list.add(this.message);
                            return;
                        }
                        long jContentLength = contentLength();
                        if (jContentLength != 0 && (jContentLength != -1 || !isDecodingRequest())) {
                            list.add(this.message);
                            if (headers == State.READ_FIXED_LENGTH_CONTENT) {
                                this.chunkSize = jContentLength;
                                return;
                            }
                            return;
                        }
                        list.add(this.message);
                        list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                        resetNow();
                        return;
                    } catch (Exception e) {
                        list.add(invalidMessage(byteBuf, e));
                        return;
                    }
                } catch (Exception e2) {
                    list.add(invalidMessage(byteBuf, e2));
                    return;
                }
            case 2:
                try {
                    ByteBuf byteBuf3 = this.lineParser.parse(byteBuf);
                    if (byteBuf3 == null) {
                        return;
                    }
                    int chunkSize = getChunkSize(byteBuf3.array(), byteBuf3.arrayOffset() + byteBuf3.readerIndex(), byteBuf3.readableBytes());
                    this.chunkSize = chunkSize;
                    if (chunkSize == 0) {
                        this.currentState = State.READ_CHUNK_FOOTER;
                        return;
                    }
                    this.currentState = State.READ_CHUNKED_CONTENT;
                    int iMin2 = Math.min((int) this.chunkSize, this.maxChunkSize);
                    if ((!this.allowPartialChunks || byteBuf.readableBytes() >= iMin2) && (iMin = Math.min(iMin2, byteBuf.readableBytes())) != 0) {
                        DefaultHttpContent defaultHttpContent = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                        this.chunkSize -= (long) iMin;
                        list.add(defaultHttpContent);
                        if (this.chunkSize == 0) {
                            return;
                        }
                        this.currentState = State.READ_CHUNK_DELIMITER;
                        iWriterIndex = byteBuf.writerIndex();
                        i = byteBuf.readerIndex();
                        while (true) {
                            if (iWriterIndex <= i) {
                                i2 = i + 1;
                                if (byteBuf.getByte(i) == 10) {
                                    this.currentState = State.READ_CHUNK_SIZE;
                                    i = i2;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                        byteBuf.readerIndex(i);
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    list.add(invalidChunk(byteBuf, e3));
                    return;
                }
            case 4:
                headers = readHeaders(byteBuf);
                if (headers != null) {
                }
                break;
            case 5:
                int iMin3 = Math.min(byteBuf.readableBytes(), this.maxChunkSize);
                if (iMin3 > 0) {
                    list.add(new DefaultHttpContent(byteBuf.readRetainedSlice(iMin3)));
                    return;
                }
                return;
            case 6:
                int i5 = byteBuf.readableBytes();
                if (i5 == 0) {
                    return;
                }
                int iMin4 = Math.min(i5, this.maxChunkSize);
                long j = iMin4;
                long j2 = this.chunkSize;
                if (j > j2) {
                    iMin4 = (int) j2;
                }
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(iMin4);
                long j3 = this.chunkSize - ((long) iMin4);
                this.chunkSize = j3;
                if (j3 != 0) {
                    list.add(new DefaultHttpContent(retainedSlice));
                    return;
                } else {
                    list.add(new DefaultLastHttpContent(retainedSlice, this.validateHeaders));
                    resetNow();
                    return;
                }
            case 7:
                int iMin22 = Math.min((int) this.chunkSize, this.maxChunkSize);
                if (this.allowPartialChunks) {
                }
                DefaultHttpContent defaultHttpContent2 = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                this.chunkSize -= (long) iMin;
                list.add(defaultHttpContent2);
                if (this.chunkSize == 0) {
                }
                break;
            case 8:
                iWriterIndex = byteBuf.writerIndex();
                i = byteBuf.readerIndex();
                while (true) {
                    if (iWriterIndex <= i) {
                    }
                    i = i2;
                }
                byteBuf.readerIndex(i);
                return;
            case 9:
                try {
                    LastHttpContent trailingHeaders = readTrailingHeaders(byteBuf);
                    if (trailingHeaders == null) {
                        return;
                    }
                    list.add(trailingHeaders);
                    resetNow();
                    return;
                } catch (Exception e5) {
                    list.add(invalidChunk(byteBuf, e5));
                    return;
                }
            case 10:
                byteBuf.skipBytes(byteBuf.readableBytes());
                return;
            case 11:
                int i6 = byteBuf.readableBytes();
                if (i6 > 0) {
                    list.add(byteBuf.readBytes(i6));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested.get()) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean zIsTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !zIsTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else {
                if (this.currentState == State.READ_HEADER) {
                    list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                    resetNow();
                    return;
                }
                if (!isDecodingRequest() && !zIsTransferEncodingChunked && contentLength() <= 0) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    public void handleTransferEncodingChunkedWithContentLength(HttpMessage httpMessage) {
        httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
        try {
            this.parserScratchBuffer.release();
        } finally {
            super.handlerRemoved0(channelHandlerContext);
        }
    }

    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (!(httpMessage instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
        int iCode = httpResponseStatusStatus.code();
        return httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL ? (iCode == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true : iCode == 204 || iCode == 304;
    }

    public abstract boolean isDecodingRequest();

    public boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        if (str != null) {
            return (str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text())) ? false : true;
        }
        return true;
    }

    public void reset() {
        this.resetRequested.lazySet(true);
    }

    public String splitFirstWordInitialLine(byte[] bArr, int i, int i2) {
        return langAsciiString(bArr, i, i2);
    }

    public AsciiString splitHeaderName(byte[] bArr, int i, int i2) {
        return new AsciiString(bArr, i, i2, true);
    }

    public String splitSecondWordInitialLine(byte[] bArr, int i, int i2) {
        return langAsciiString(bArr, i, i2);
    }

    public String splitThirdWordInitialLine(byte[] bArr, int i, int i2) {
        return langAsciiString(bArr, i, i2);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        int i;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i = C125302.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i == 5 || i == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    public HttpObjectDecoder(int i, int i2, int i4, boolean z) {
        this(i, i2, i4, z, true);
    }

    public HttpObjectDecoder(int i, int i2, int i4, boolean z, boolean z2) {
        this(i, i2, i4, z, z2, 128);
    }

    public HttpObjectDecoder(int i, int i2, int i4, boolean z, boolean z2, int i5) {
        this(i, i2, i4, z, z2, i5, false);
    }

    public HttpObjectDecoder(int i, int i2, int i4, boolean z, boolean z2, int i5, boolean z3) {
        this(i, i2, i4, z, z2, i5, z3, true);
    }

    public HttpObjectDecoder(int i, int i2, int i4, boolean z, boolean z2, int i5, boolean z3, boolean z4) {
        this.contentLength = Long.MIN_VALUE;
        this.resetRequested = new AtomicBoolean();
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i, "maxInitialLineLength");
        ObjectUtil.checkPositive(i2, "maxHeaderSize");
        ObjectUtil.checkPositive(i4, "maxChunkSize");
        ByteBuf byteBufBuffer = Unpooled.buffer(i5);
        this.parserScratchBuffer = byteBufBuffer;
        this.lineParser = new LineParser(byteBufBuffer, i);
        this.headerParser = new HeaderParser(byteBufBuffer, i2);
        this.maxChunkSize = i4;
        this.chunkedSupported = z;
        this.validateHeaders = z2;
        this.allowDuplicateContentLengths = z3;
        this.allowPartialChunks = z4;
    }
}
