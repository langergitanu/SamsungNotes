package com.fasterxml.jackson.core.json;

import androidx.compose.runtime.AbstractC1974b;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p128io.CharTypes;
import com.fasterxml.jackson.core.p128io.CharacterEscapes;
import com.fasterxml.jackson.core.p128io.IOContext;
import com.fasterxml.jackson.core.p128io.NumberOutput;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class UTF8JsonGenerator extends JsonGeneratorImpl {
    private static final byte BYTE_0 = 48;
    private static final byte BYTE_BACKSLASH = 92;
    private static final byte BYTE_COLON = 58;
    private static final byte BYTE_COMMA = 44;
    private static final byte BYTE_LBRACKET = 91;
    private static final byte BYTE_LCURLY = 123;
    private static final byte BYTE_QUOTE = 34;
    private static final byte BYTE_RBRACKET = 93;
    private static final byte BYTE_RCURLY = 125;
    private static final int MAX_BYTES_TO_BUFFER = 512;
    protected static final int SURR1_FIRST = 55296;
    protected static final int SURR1_LAST = 56319;
    protected static final int SURR2_FIRST = 56320;
    protected static final int SURR2_LAST = 57343;
    protected boolean _bufferRecyclable;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected byte[] _entityBuffer;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail;
    static final byte[] HEX_CHARS = CharTypes.copyHexBytes();
    private static final byte BYTE_u = 117;
    private static final byte[] NULL_BYTES = {110, BYTE_u, 108, 108};
    private static final byte[] TRUE_BYTES = {116, 114, BYTE_u, 101};
    private static final byte[] FALSE_BYTES = {102, SprAttributeBase.TYPE_ANIMATOR_SET, 108, 115, 101};

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream) {
        super(iOContext, i, objectCodec);
        this._outputTail = 0;
        this._outputStream = outputStream;
        this._bufferRecyclable = true;
        byte[] bArrAllocWriteEncodingBuffer = iOContext.allocWriteEncodingBuffer();
        this._outputBuffer = bArrAllocWriteEncodingBuffer;
        int length = bArrAllocWriteEncodingBuffer.length;
        this._outputEnd = length;
        this._outputMaxContiguous = length >> 3;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._charBuffer = cArrAllocConcatBuffer;
        this._charBufferLength = cArrAllocConcatBuffer.length;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    private int _handleLongCustomEscape(byte[] bArr, int i, int i2, byte[] bArr2, int i4) throws IOException {
        int length = bArr2.length;
        if (i + length > i2) {
            this._outputTail = i;
            _flushBuffer();
            int i5 = this._outputTail;
            if (length > bArr.length) {
                this._outputStream.write(bArr2, 0, length);
                return i5;
            }
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i = i5 + length;
        }
        if ((i4 * 6) + i <= i2) {
            return i;
        }
        _flushBuffer();
        return this._outputTail;
    }

    private int _outputMultiByteChar(int i, int i2) {
        byte[] bArr = this._outputBuffer;
        if (i < SURR1_FIRST || i > SURR2_LAST) {
            bArr[i2] = (byte) ((i >> 12) | JPEG.APP0);
            int i4 = i2 + 2;
            bArr[i2 + 1] = (byte) (((i >> 6) & 63) | 128);
            int i5 = i2 + 3;
            bArr[i4] = (byte) ((i & 63) | 128);
            return i5;
        }
        bArr[i2] = BYTE_BACKSLASH;
        bArr[i2 + 1] = BYTE_u;
        byte[] bArr2 = HEX_CHARS;
        bArr[i2 + 2] = bArr2[(i >> 12) & 15];
        bArr[i2 + 3] = bArr2[(i >> 8) & 15];
        int i6 = i2 + 5;
        bArr[i2 + 4] = bArr2[(i >> 4) & 15];
        int i7 = i2 + 6;
        bArr[i6] = bArr2[i & 15];
        return i7;
    }

    private int _outputRawMultiByteChar(int i, char[] cArr, int i2, int i4) throws IOException {
        if (i >= SURR1_FIRST && i <= SURR2_LAST) {
            if (i2 >= i4) {
                _reportError("Split surrogate on writeRaw() input (last character)");
            }
            _outputSurrogates(i, cArr[i2]);
            return i2 + 1;
        }
        byte[] bArr = this._outputBuffer;
        int i5 = this._outputTail;
        int i6 = i5 + 1;
        this._outputTail = i6;
        bArr[i5] = (byte) ((i >> 12) | JPEG.APP0);
        int i7 = i5 + 2;
        this._outputTail = i7;
        bArr[i6] = (byte) (((i >> 6) & 63) | 128);
        this._outputTail = i5 + 3;
        bArr[i7] = (byte) ((i & 63) | 128);
        return i2;
    }

    private int _readMore(InputStream inputStream, byte[] bArr, int i, int i2, int i4) throws IOException {
        int i5 = 0;
        while (i < i2) {
            bArr[i5] = bArr[i];
            i5++;
            i++;
        }
        int iMin = Math.min(i4, bArr.length);
        do {
            int i6 = inputStream.read(bArr, i5, iMin - i5);
            if (i6 < 0) {
                return i5;
            }
            i5 += i6;
        } while (i5 < 3);
        return i5;
    }

    private final void _writeBytes(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this._outputTail + length > this._outputEnd) {
            _flushBuffer();
            if (length > 512) {
                this._outputStream.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
        this._outputTail += length;
    }

    private int _writeCustomEscape(byte[] bArr, int i, SerializableString serializableString, int i2) {
        byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = bArrAsUnquotedUTF8.length;
        if (length > 6) {
            return _handleLongCustomEscape(bArr, i, this._outputEnd, bArrAsUnquotedUTF8, i2);
        }
        System.arraycopy(bArrAsUnquotedUTF8, 0, bArr, i, length);
        return i + length;
    }

    private void _writeCustomStringSegment2(char[] cArr, int i, int i2) throws IOException {
        if (AbstractC1974b.m1304A(i2, i, 6, this._outputTail) > this._outputEnd) {
            _flushBuffer();
        }
        int i_outputMultiByteChar = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i4 = this._maximumNonEscapedChar;
        if (i4 <= 0) {
            i4 = 65535;
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i2) {
            int i5 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                int i6 = iArr[c];
                if (i6 == 0) {
                    bArr[i_outputMultiByteChar] = (byte) c;
                    i = i5;
                    i_outputMultiByteChar++;
                } else if (i6 > 0) {
                    int i7 = i_outputMultiByteChar + 1;
                    bArr[i_outputMultiByteChar] = BYTE_BACKSLASH;
                    i_outputMultiByteChar += 2;
                    bArr[i7] = (byte) i6;
                } else if (i6 == -2) {
                    SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                    if (escapeSequence == null) {
                        _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c) + ", although was supposed to have one");
                    }
                    i_outputMultiByteChar = _writeCustomEscape(bArr, i_outputMultiByteChar, escapeSequence, i2 - i5);
                } else {
                    i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
                }
            } else if (c > i4) {
                i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
            } else {
                SerializableString escapeSequence2 = characterEscapes.getEscapeSequence(c);
                if (escapeSequence2 != null) {
                    i_outputMultiByteChar = _writeCustomEscape(bArr, i_outputMultiByteChar, escapeSequence2, i2 - i5);
                } else if (c <= 2047) {
                    int i8 = i_outputMultiByteChar + 1;
                    bArr[i_outputMultiByteChar] = (byte) ((c >> 6) | 192);
                    i_outputMultiByteChar += 2;
                    bArr[i8] = (byte) ((c & '?') | 128);
                } else {
                    i_outputMultiByteChar = _outputMultiByteChar(c, i_outputMultiByteChar);
                }
            }
            i = i5;
        }
        this._outputTail = i_outputMultiByteChar;
    }

    private int _writeGenericEscape(int i, int i2) {
        int i4;
        byte[] bArr = this._outputBuffer;
        bArr[i2] = BYTE_BACKSLASH;
        int i5 = i2 + 2;
        bArr[i2 + 1] = BYTE_u;
        if (i > 255) {
            int i6 = i >> 8;
            int i7 = i2 + 3;
            byte[] bArr2 = HEX_CHARS;
            bArr[i5] = bArr2[(i6 & 255) >> 4];
            i4 = i2 + 4;
            bArr[i7] = bArr2[i6 & 15];
            i &= 255;
        } else {
            int i8 = i2 + 3;
            bArr[i5] = 48;
            i4 = i2 + 4;
            bArr[i8] = 48;
        }
        int i9 = i4 + 1;
        byte[] bArr3 = HEX_CHARS;
        bArr[i4] = bArr3[i >> 4];
        int i10 = i4 + 2;
        bArr[i9] = bArr3[i & 15];
        return i10;
    }

    private void _writeLongString(String str) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = 34;
        _writeStringSegments(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = 34;
    }

    private void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
        this._outputTail += 4;
    }

    private void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        int i4 = i2 + 1;
        this._outputTail = i4;
        bArr[i2] = 34;
        int iOutputInt = NumberOutput.outputInt(i, bArr, i4);
        byte[] bArr2 = this._outputBuffer;
        this._outputTail = iOutputInt + 1;
        bArr2[iOutputInt] = 34;
    }

    private void _writeQuotedLong(long j) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        bArr[i] = 34;
        int iOutputLong = NumberOutput.outputLong(j, bArr, i2);
        byte[] bArr2 = this._outputBuffer;
        this._outputTail = iOutputLong + 1;
        bArr2[iOutputLong] = 34;
    }

    private void _writeQuotedRaw(Object obj) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = 34;
        writeRaw(obj.toString());
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = 34;
    }

    private final void _writeSegmentedRaw(char[] cArr, int i, int i2) throws IOException {
        int i4 = this._outputEnd;
        byte[] bArr = this._outputBuffer;
        while (i < i2) {
            do {
                char c = cArr[i];
                if (c >= 128) {
                    if (this._outputTail + 3 >= this._outputEnd) {
                        _flushBuffer();
                    }
                    int i5 = i + 1;
                    char c2 = cArr[i];
                    if (c2 < 2048) {
                        int i6 = this._outputTail;
                        int i7 = i6 + 1;
                        this._outputTail = i7;
                        bArr[i6] = (byte) ((c2 >> 6) | 192);
                        this._outputTail = i6 + 2;
                        bArr[i7] = (byte) ((c2 & '?') | 128);
                    } else {
                        _outputRawMultiByteChar(c2, cArr, i5, i2);
                    }
                    i = i5;
                } else {
                    if (this._outputTail >= i4) {
                        _flushBuffer();
                    }
                    int i8 = this._outputTail;
                    this._outputTail = i8 + 1;
                    bArr[i8] = (byte) c;
                    i++;
                }
            } while (i < i2);
            return;
        }
    }

    private final void _writeStringSegment(char[] cArr, int i, int i2) throws IOException {
        int i4 = i2 + i;
        int i5 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i4) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            bArr[i5] = (byte) c;
            i++;
            i5++;
        }
        this._outputTail = i5;
        if (i < i4) {
            if (this._characterEscapes != null) {
                _writeCustomStringSegment2(cArr, i, i4);
            } else if (this._maximumNonEscapedChar == 0) {
                _writeStringSegment2(cArr, i, i4);
            } else {
                _writeStringSegmentASCII2(cArr, i, i4);
            }
        }
    }

    private final void _writeStringSegment2(char[] cArr, int i, int i2) throws IOException {
        if (AbstractC1974b.m1304A(i2, i, 6, this._outputTail) > this._outputEnd) {
            _flushBuffer();
        }
        int i_outputMultiByteChar = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                int i5 = iArr[c];
                if (i5 == 0) {
                    bArr[i_outputMultiByteChar] = (byte) c;
                    i = i4;
                    i_outputMultiByteChar++;
                } else if (i5 > 0) {
                    int i6 = i_outputMultiByteChar + 1;
                    bArr[i_outputMultiByteChar] = BYTE_BACKSLASH;
                    i_outputMultiByteChar += 2;
                    bArr[i6] = (byte) i5;
                } else {
                    i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
                }
            } else if (c <= 2047) {
                int i7 = i_outputMultiByteChar + 1;
                bArr[i_outputMultiByteChar] = (byte) ((c >> 6) | 192);
                i_outputMultiByteChar += 2;
                bArr[i7] = (byte) ((c & '?') | 128);
            } else {
                i_outputMultiByteChar = _outputMultiByteChar(c, i_outputMultiByteChar);
            }
            i = i4;
        }
        this._outputTail = i_outputMultiByteChar;
    }

    private final void _writeStringSegmentASCII2(char[] cArr, int i, int i2) throws IOException {
        if (AbstractC1974b.m1304A(i2, i, 6, this._outputTail) > this._outputEnd) {
            _flushBuffer();
        }
        int i_outputMultiByteChar = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i4 = this._maximumNonEscapedChar;
        while (i < i2) {
            int i5 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                int i6 = iArr[c];
                if (i6 == 0) {
                    bArr[i_outputMultiByteChar] = (byte) c;
                    i = i5;
                    i_outputMultiByteChar++;
                } else if (i6 > 0) {
                    int i7 = i_outputMultiByteChar + 1;
                    bArr[i_outputMultiByteChar] = BYTE_BACKSLASH;
                    i_outputMultiByteChar += 2;
                    bArr[i7] = (byte) i6;
                } else {
                    i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
                }
            } else if (c > i4) {
                i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
            } else if (c <= 2047) {
                int i8 = i_outputMultiByteChar + 1;
                bArr[i_outputMultiByteChar] = (byte) ((c >> 6) | 192);
                i_outputMultiByteChar += 2;
                bArr[i8] = (byte) ((c & '?') | 128);
            } else {
                i_outputMultiByteChar = _outputMultiByteChar(c, i_outputMultiByteChar);
            }
            i = i5;
        }
        this._outputTail = i_outputMultiByteChar;
    }

    private final void _writeStringSegments(String str) throws IOException {
        int length = str.length();
        char[] cArr = this._charBuffer;
        int i = 0;
        while (length > 0) {
            int iMin = Math.min(this._outputMaxContiguous, length);
            int i2 = i + iMin;
            str.getChars(i, i2, cArr, 0);
            if (this._outputTail + iMin > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, 0, iMin);
            length -= iMin;
            i = i2;
        }
    }

    private void _writeUTF8Segment(byte[] bArr, int i, int i2) throws IOException {
        int[] iArr = this._outputEscapes;
        int i4 = i + i2;
        int i5 = i;
        while (i5 < i4) {
            int i6 = i5 + 1;
            byte b = bArr[i5];
            if (b >= 0 && iArr[b] != 0) {
                _writeUTF8Segment2(bArr, i, i2);
                return;
            }
            i5 = i6;
        }
        if (this._outputTail + i2 > this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i2);
        this._outputTail += i2;
    }

    private void _writeUTF8Segment2(byte[] bArr, int i, int i2) throws IOException {
        int i4;
        int i_writeGenericEscape = this._outputTail;
        if ((i2 * 6) + i_writeGenericEscape > this._outputEnd) {
            _flushBuffer();
            i_writeGenericEscape = this._outputTail;
        }
        byte[] bArr2 = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i5 = i2 + i;
        while (i < i5) {
            int i6 = i + 1;
            byte b = bArr[i];
            if (b < 0 || (i4 = iArr[b]) == 0) {
                bArr2[i_writeGenericEscape] = b;
                i = i6;
                i_writeGenericEscape++;
            } else {
                if (i4 > 0) {
                    int i7 = i_writeGenericEscape + 1;
                    bArr2[i_writeGenericEscape] = BYTE_BACKSLASH;
                    i_writeGenericEscape += 2;
                    bArr2[i7] = (byte) i4;
                } else {
                    i_writeGenericEscape = _writeGenericEscape(b, i_writeGenericEscape);
                }
                i = i6;
            }
        }
        this._outputTail = i_writeGenericEscape;
    }

    private void _writeUTF8Segments(byte[] bArr, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this._outputMaxContiguous, i2);
            _writeUTF8Segment(bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public final int _decodeSurrogate(int i, int i2) {
        if (i2 < 56320 || i2 > SURR2_LAST) {
            _reportError("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return (i2 - 56320) + ((i - SURR1_FIRST) << 10) + 65536;
    }

    public final void _flushBuffer() throws IOException {
        int i = this._outputTail;
        if (i > 0) {
            this._outputTail = 0;
            this._outputStream.write(this._outputBuffer, 0, i);
        }
    }

    public final void _outputSurrogates(int i, int i2) throws IOException {
        int i_decodeSurrogate = _decodeSurrogate(i, i2);
        if (this._outputTail + 4 > this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputTail;
        int i5 = i4 + 1;
        this._outputTail = i5;
        bArr[i4] = (byte) ((i_decodeSurrogate >> 18) | 240);
        int i6 = i4 + 2;
        this._outputTail = i6;
        bArr[i5] = (byte) (((i_decodeSurrogate >> 12) & 63) | 128);
        int i7 = i4 + 3;
        this._outputTail = i7;
        bArr[i6] = (byte) (((i_decodeSurrogate >> 6) & 63) | 128);
        this._outputTail = i4 + 4;
        bArr[i7] = (byte) ((i_decodeSurrogate & 63) | 128);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
        byte[] bArr = this._outputBuffer;
        if (bArr != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(bArr);
        }
        char[] cArr = this._charBuffer;
        if (cArr != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
    }

    public final void _verifyPrettyValueWrite(String str, int i) {
        if (i == 0) {
            if (this._writeContext.inArray()) {
                this._cfgPrettyPrinter.beforeArrayValues(this);
                return;
            } else {
                if (this._writeContext.inObject()) {
                    this._cfgPrettyPrinter.beforeObjectEntries(this);
                    return;
                }
                return;
            }
        }
        if (i == 1) {
            this._cfgPrettyPrinter.writeArrayValueSeparator(this);
            return;
        }
        if (i == 2) {
            this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
        } else if (i != 3) {
            _cantHappen();
        } else {
            this._cfgPrettyPrinter.writeRootValueSeparator(this);
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public final void _verifyValueWrite(String str) throws IOException {
        byte b;
        SerializableString serializableString;
        int iWriteValue = this._writeContext.writeValue();
        if (iWriteValue == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
        if (this._cfgPrettyPrinter != null) {
            _verifyPrettyValueWrite(str, iWriteValue);
            return;
        }
        if (iWriteValue == 1) {
            b = 44;
        } else {
            if (iWriteValue != 2) {
                if (iWriteValue == 3 && (serializableString = this._rootValueSeparator) != null) {
                    byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
                    if (bArrAsUnquotedUTF8.length > 0) {
                        _writeBytes(bArrAsUnquotedUTF8);
                        return;
                    }
                    return;
                }
                return;
            }
            b = 58;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        bArr[i] = b;
        this._outputTail = i + 1;
    }

    public void _writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        int iEncodeBase64Chunk;
        int i4 = i2 - 3;
        int i5 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength();
        loop0: while (true) {
            int i6 = maxLineLength >> 2;
            while (i <= i4) {
                if (this._outputTail > i5) {
                    _flushBuffer();
                }
                int i7 = i + 2;
                int i8 = ((bArr[i + 1] & 255) | (bArr[i] << 8)) << 8;
                i += 3;
                iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i8 | (bArr[i7] & 255), this._outputBuffer, this._outputTail);
                this._outputTail = iEncodeBase64Chunk;
                i6--;
                if (i6 <= 0) {
                    break;
                }
            }
            byte[] bArr2 = this._outputBuffer;
            int i9 = iEncodeBase64Chunk + 1;
            this._outputTail = i9;
            bArr2[iEncodeBase64Chunk] = BYTE_BACKSLASH;
            this._outputTail = iEncodeBase64Chunk + 2;
            bArr2[i9] = 110;
            maxLineLength = base64Variant.getMaxLineLength();
        }
        int i10 = i2 - i;
        if (i10 > 0) {
            if (this._outputTail > i5) {
                _flushBuffer();
            }
            int i11 = i + 1;
            int i12 = bArr[i] << 16;
            if (i10 == 2) {
                i12 |= (bArr[i11] & 255) << 8;
            }
            this._outputTail = base64Variant.encodeBase64Partial(i12, i10, this._outputBuffer, this._outputTail);
        }
    }

    public final void _writeFieldName(String str) throws IOException {
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            _writeStringSegments(str);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = 34;
        int length = str.length();
        if (length <= this._charBufferLength) {
            str.getChars(0, length, this._charBuffer, 0);
            if (length <= this._outputMaxContiguous) {
                if (this._outputTail + length > this._outputEnd) {
                    _flushBuffer();
                }
                _writeStringSegment(this._charBuffer, 0, length);
            } else {
                _writeStringSegments(this._charBuffer, 0, length);
            }
        } else {
            _writeStringSegments(str);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = 34;
    }

    public final void _writePPFieldName(String str, boolean z) throws IOException {
        if (z) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            _writeStringSegments(str);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = 34;
        int length = str.length();
        if (length <= this._charBufferLength) {
            str.getChars(0, length, this._charBuffer, 0);
            if (length <= this._outputMaxContiguous) {
                if (this._outputTail + length > this._outputEnd) {
                    _flushBuffer();
                }
                _writeStringSegment(this._charBuffer, 0, length);
            } else {
                _writeStringSegments(this._charBuffer, 0, length);
            }
        } else {
            _writeStringSegments(str);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonWriteContext outputContext = getOutputContext();
                if (!outputContext.inArray()) {
                    if (!outputContext.inObject()) {
                        break;
                    } else {
                        writeEndObject();
                    }
                } else {
                    writeEndArray();
                }
            }
        }
        _flushBuffer();
        if (this._outputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._outputStream.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._outputStream.flush();
            }
        }
        _releaseBuffers();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() throws IOException {
        _flushBuffer();
        if (this._outputStream == null || !isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this._outputStream.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._outputStream;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr2[i4] = 34;
        _writeBinary(base64Variant, bArr, i, i2 + i);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        bArr3[i5] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        _verifyValueWrite("write boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = z ? TRUE_BYTES : FALSE_BYTES;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
        this._outputTail += length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RBRACKET;
        }
        this._writeContext = this._writeContext.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RCURLY;
        }
        this._writeContext = this._writeContext.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(str);
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(str, iWriteFieldName == 1);
            return;
        }
        if (iWriteFieldName == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = 44;
        }
        _writeFieldName(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write null value");
        _writeNull();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._charBuffer;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            writeRaw(cArr, 0, length2);
            length -= length2;
            i = i2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr2[i4] = 34;
        _writeBytes(bArr, i, i2);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        bArr3[i5] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        _verifyValueWrite("write text value");
        if (str == null) {
            _writeNull();
            return;
        }
        int length = str.length();
        if (length > this._charBufferLength) {
            _writeLongString(str);
            return;
        }
        str.getChars(0, length, this._charBuffer, 0);
        if (length > this._outputMaxContiguous) {
            _writeLongString(this._charBuffer, 0, length);
            return;
        }
        if (this._outputTail + length >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = 34;
        _writeStringSegment(this._charBuffer, 0, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr2[i4] = 34;
        if (i2 <= this._outputMaxContiguous) {
            _writeUTF8Segment(bArr, i, i2);
        } else {
            _writeUTF8Segments(bArr, i, i2);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        bArr3[i5] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        while (i2 > 0) {
            char[] cArr = this._charBuffer;
            int length = cArr.length;
            if (i2 < length) {
                length = i2;
            }
            int i4 = i + length;
            str.getChars(i, i4, cArr, 0);
            writeRaw(cArr, 0, length);
            i2 -= length;
            i = i4;
        }
    }

    private final void _writeBytes(byte[] bArr, int i, int i2) throws IOException {
        if (this._outputTail + i2 > this._outputEnd) {
            _flushBuffer();
            if (i2 > 512) {
                this._outputStream.write(bArr, i, i2);
                return;
            }
        }
        System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i2);
        this._outputTail += i2;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j) throws IOException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(j);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(j, this._outputBuffer, this._outputTail);
    }

    private void _writeLongString(char[] cArr, int i, int i2) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr[i4] = 34;
        _writeStringSegments(this._charBuffer, 0, i2);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        bArr2[i5] = 34;
    }

    private final void _writeStringSegments(char[] cArr, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this._outputMaxContiguous, i2);
            if (this._outputTail + iMin > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = 34;
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            if (i < 0) {
                i = _writeBinary(base64Variant, inputStream, bArrAllocBase64Buffer);
            } else {
                int i_writeBinary = _writeBinary(base64Variant, inputStream, bArrAllocBase64Buffer, i);
                if (i_writeBinary > 0) {
                    _reportError("Too few bytes available: missing " + i_writeBinary + " bytes (out of " + i + ")");
                }
            }
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            bArr2[i4] = 34;
            return i;
        } catch (Throwable th) {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(serializableString, iWriteFieldName == 1);
            return;
        }
        if (iWriteFieldName == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = 44;
        }
        _writeFieldName(serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
        if (bArrAsUnquotedUTF8.length > 0) {
            _writeBytes(bArrAsUnquotedUTF8);
        }
    }

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream, byte[] bArr, int i2, boolean z) {
        super(iOContext, i, objectCodec);
        this._outputStream = outputStream;
        this._bufferRecyclable = z;
        this._outputTail = i2;
        this._outputBuffer = bArr;
        int length = bArr.length;
        this._outputEnd = length;
        this._outputMaxContiguous = length >> 3;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._charBuffer = cArrAllocConcatBuffer;
        this._charBufferLength = cArrAllocConcatBuffer.length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        _verifyValueWrite("write number");
        if (bigInteger == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigInteger);
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeRaw(char[] cArr, int i, int i2) throws IOException {
        int i4 = i2 + i2 + i2;
        int i5 = this._outputTail + i4;
        int i6 = this._outputEnd;
        if (i5 > i6) {
            if (i6 < i4) {
                _writeSegmentedRaw(cArr, i, i2);
                return;
            }
            _flushBuffer();
        }
        int i7 = i2 + i;
        while (i < i7) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    i++;
                    if (c < 2048) {
                        byte[] bArr = this._outputBuffer;
                        int i8 = this._outputTail;
                        int i9 = i8 + 1;
                        this._outputTail = i9;
                        bArr[i8] = (byte) ((c >> 6) | 192);
                        this._outputTail = i8 + 2;
                        bArr[i9] = (byte) ((c & '?') | 128);
                    } else {
                        _outputRawMultiByteChar(c, cArr, i, i7);
                    }
                } else {
                    byte[] bArr2 = this._outputBuffer;
                    int i10 = this._outputTail;
                    this._outputTail = i10 + 1;
                    bArr2[i10] = (byte) c;
                    i++;
                }
            } while (i < i7);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputTail;
        int i5 = i4 + 1;
        this._outputTail = i5;
        bArr[i4] = 34;
        if (i2 <= this._outputMaxContiguous) {
            if (i5 + i2 > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, i, i2);
        } else {
            _writeStringSegments(cArr, i, i2);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr2[i6] = 34;
    }

    public int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException {
        int i_readMore;
        int i2 = this._outputEnd - 6;
        int i4 = 2;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i5 = -3;
        int i6 = i;
        int i7 = 0;
        int i_readMore2 = 0;
        while (true) {
            if (i6 <= 2) {
                break;
            }
            if (i7 > i5) {
                i_readMore2 = _readMore(inputStream, bArr, i7, i_readMore2, i6);
                if (i_readMore2 < 3) {
                    i7 = 0;
                    break;
                }
                i5 = i_readMore2 - 3;
                i7 = 0;
            }
            if (this._outputTail > i2) {
                _flushBuffer();
            }
            int i8 = i7 + 2;
            int i9 = ((bArr[i7 + 1] & 255) | (bArr[i7] << 8)) << 8;
            i7 += 3;
            i6 -= 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i9 | (bArr[i8] & 255), this._outputBuffer, this._outputTail);
            this._outputTail = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this._outputBuffer;
                int i10 = iEncodeBase64Chunk + 1;
                this._outputTail = i10;
                bArr2[iEncodeBase64Chunk] = BYTE_BACKSLASH;
                this._outputTail = iEncodeBase64Chunk + 2;
                bArr2[i10] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i6 <= 0 || (i_readMore = _readMore(inputStream, bArr, i7, i_readMore2, i6)) <= 0) {
            return i6;
        }
        if (this._outputTail > i2) {
            _flushBuffer();
        }
        int i11 = bArr[0] << 16;
        if (1 < i_readMore) {
            i11 |= (bArr[1] & 255) << 8;
        } else {
            i4 = 1;
        }
        this._outputTail = base64Variant.encodeBase64Partial(i11, i4, this._outputBuffer, this._outputTail);
        return i6 - i4;
    }

    public final void _writeFieldName(SerializableString serializableString) throws IOException {
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            int iAppendQuotedUTF8 = serializableString.appendQuotedUTF8(this._outputBuffer, this._outputTail);
            if (iAppendQuotedUTF8 < 0) {
                _writeBytes(serializableString.asQuotedUTF8());
                return;
            } else {
                this._outputTail += iAppendQuotedUTF8;
                return;
            }
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        bArr[i] = 34;
        int iAppendQuotedUTF82 = serializableString.appendQuotedUTF8(bArr, i2);
        if (iAppendQuotedUTF82 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail += iAppendQuotedUTF82;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr2[i4] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        if (!this._cfgNumbersAsStrings && ((!Double.isNaN(d) && !Double.isInfinite(d)) || !isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            _verifyValueWrite("write number");
            writeRaw(String.valueOf(d));
        } else {
            writeString(String.valueOf(d));
        }
    }

    public final void _writePPFieldName(SerializableString serializableString, boolean z) throws IOException {
        if (z) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        boolean zIsEnabled = isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
        if (zIsEnabled) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = 34;
        }
        _writeBytes(serializableString.asQuotedUTF8());
        if (zIsEnabled) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = 34;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        if (c <= 127) {
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) c;
        } else {
            if (c < 2048) {
                int i2 = this._outputTail;
                int i4 = i2 + 1;
                this._outputTail = i4;
                bArr[i2] = (byte) ((c >> 6) | 192);
                this._outputTail = i2 + 2;
                bArr[i4] = (byte) ((c & '?') | 128);
                return;
            }
            _outputRawMultiByteChar(c, null, 0, 0);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        if (!this._cfgNumbersAsStrings && ((!Float.isNaN(f) && !Float.isInfinite(f)) || !isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            _verifyValueWrite("write number");
            writeRaw(String.valueOf(f));
        } else {
            writeString(String.valueOf(f));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        _verifyValueWrite("write number");
        if (bigDecimal == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigDecimal);
        } else {
            writeRaw(bigDecimal.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        bArr[i] = 34;
        int iAppendQuotedUTF8 = serializableString.appendQuotedUTF8(bArr, i2);
        if (iAppendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail += iAppendQuotedUTF8;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bArr2[i4] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(str);
        } else {
            writeRaw(str);
        }
    }

    public int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        int i = this._outputEnd - 6;
        int i2 = 2;
        int i4 = -3;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i5 = 0;
        int i_readMore = 0;
        int i6 = 0;
        while (true) {
            if (i5 > i4) {
                i_readMore = _readMore(inputStream, bArr2, i5, i_readMore, bArr2.length);
                if (i_readMore < 3) {
                    break;
                }
                i4 = i_readMore - 3;
                i5 = 0;
            }
            if (this._outputTail > i) {
                _flushBuffer();
            }
            int i7 = i5 + 2;
            int i8 = ((bArr[i5 + 1] & 255) | (bArr[i5] << 8)) << 8;
            i5 += 3;
            i6 += 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i8 | (bArr[i7] & 255), this._outputBuffer, this._outputTail);
            this._outputTail = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr3 = this._outputBuffer;
                int i9 = iEncodeBase64Chunk + 1;
                this._outputTail = i9;
                bArr3[iEncodeBase64Chunk] = BYTE_BACKSLASH;
                this._outputTail = iEncodeBase64Chunk + 2;
                bArr3[i9] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            bArr2 = bArr;
        }
        if (i_readMore <= 0) {
            return i6;
        }
        if (this._outputTail > i) {
            _flushBuffer();
        }
        int i10 = bArr[0] << 16;
        if (1 < i_readMore) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i2 = 1;
        }
        int i11 = i6 + i2;
        this._outputTail = base64Variant.encodeBase64Partial(i10, i2, this._outputBuffer, this._outputTail);
        return i11;
    }
}
