package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p128io.CharTypes;
import com.fasterxml.jackson.core.p128io.CharacterEscapes;
import com.fasterxml.jackson.core.p128io.IOContext;
import com.fasterxml.jackson.core.p128io.NumberOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class WriterBasedJsonGenerator extends JsonGeneratorImpl {
    protected static final char[] HEX_CHARS = CharTypes.copyHexChars();
    protected static final int SHORT_WRITE = 32;
    protected SerializableString _currentEscape;
    protected char[] _entityBuffer;
    protected char[] _outputBuffer;
    protected int _outputEnd;
    protected int _outputHead;
    protected int _outputTail;
    protected final Writer _writer;

    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer) {
        super(iOContext, i, objectCodec);
        this._outputHead = 0;
        this._outputTail = 0;
        this._writer = writer;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._outputBuffer = cArrAllocConcatBuffer;
        this._outputEnd = cArrAllocConcatBuffer.length;
    }

    private char[] _allocateEntityBuffer() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this._entityBuffer = cArr;
        return cArr;
    }

    private void _appendCharacterEscape(char c, int i) throws IOException {
        String value;
        int i2;
        if (i >= 0) {
            if (this._outputTail + 2 > this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i4 = this._outputTail;
            int i5 = i4 + 1;
            this._outputTail = i5;
            cArr[i4] = '\\';
            this._outputTail = i4 + 2;
            cArr[i5] = (char) i;
            return;
        }
        if (i == -2) {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                value = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                value = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = value.length();
            if (this._outputTail + length > this._outputEnd) {
                _flushBuffer();
                if (length > this._outputEnd) {
                    this._writer.write(value);
                    return;
                }
            }
            value.getChars(0, length, this._outputBuffer, this._outputTail);
            this._outputTail += length;
            return;
        }
        if (this._outputTail + 2 > this._outputEnd) {
            _flushBuffer();
        }
        int i6 = this._outputTail;
        char[] cArr2 = this._outputBuffer;
        cArr2[i6] = '\\';
        int i7 = i6 + 2;
        cArr2[i6 + 1] = 'u';
        if (c > 255) {
            int i8 = c >> '\b';
            int i9 = i6 + 3;
            char[] cArr3 = HEX_CHARS;
            cArr2[i7] = cArr3[(i8 & 255) >> 4];
            i2 = i6 + 4;
            cArr2[i9] = cArr3[i8 & 15];
            c = (char) (c & 255);
        } else {
            int i10 = i6 + 3;
            cArr2[i7] = '0';
            i2 = i6 + 4;
            cArr2[i10] = '0';
        }
        int i11 = i2 + 1;
        char[] cArr4 = HEX_CHARS;
        cArr2[i2] = cArr4[c >> 4];
        cArr2[i11] = cArr4[c & 15];
        this._outputTail = i11;
    }

    private void _prependOrWriteCharacterEscape(char c, int i) throws IOException {
        String value;
        int i2;
        if (i >= 0) {
            int i4 = this._outputTail;
            if (i4 >= 2) {
                int i5 = i4 - 2;
                this._outputHead = i5;
                char[] cArr = this._outputBuffer;
                cArr[i5] = '\\';
                cArr[i4 - 1] = (char) i;
                return;
            }
            char[] cArr_allocateEntityBuffer = this._entityBuffer;
            if (cArr_allocateEntityBuffer == null) {
                cArr_allocateEntityBuffer = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            cArr_allocateEntityBuffer[1] = (char) i;
            this._writer.write(cArr_allocateEntityBuffer, 0, 2);
            return;
        }
        if (i == -2) {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                value = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                value = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = value.length();
            int i6 = this._outputTail;
            if (i6 < length) {
                this._outputHead = i6;
                this._writer.write(value);
                return;
            } else {
                int i7 = i6 - length;
                this._outputHead = i7;
                value.getChars(0, length, this._outputBuffer, i7);
                return;
            }
        }
        int i8 = this._outputTail;
        if (i8 < 6) {
            char[] cArr_allocateEntityBuffer2 = this._entityBuffer;
            if (cArr_allocateEntityBuffer2 == null) {
                cArr_allocateEntityBuffer2 = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            if (c <= 255) {
                char[] cArr2 = HEX_CHARS;
                cArr_allocateEntityBuffer2[6] = cArr2[c >> 4];
                cArr_allocateEntityBuffer2[7] = cArr2[c & 15];
                this._writer.write(cArr_allocateEntityBuffer2, 2, 6);
                return;
            }
            int i9 = c >> '\b';
            char[] cArr3 = HEX_CHARS;
            cArr_allocateEntityBuffer2[10] = cArr3[(i9 & 255) >> 4];
            cArr_allocateEntityBuffer2[11] = cArr3[i9 & 15];
            cArr_allocateEntityBuffer2[12] = cArr3[(c & 255) >> 4];
            cArr_allocateEntityBuffer2[13] = cArr3[c & 15];
            this._writer.write(cArr_allocateEntityBuffer2, 8, 6);
            return;
        }
        char[] cArr4 = this._outputBuffer;
        int i10 = i8 - 6;
        this._outputHead = i10;
        cArr4[i10] = '\\';
        cArr4[i8 - 5] = 'u';
        if (c > 255) {
            int i11 = c >> '\b';
            char[] cArr5 = HEX_CHARS;
            cArr4[i8 - 4] = cArr5[(i11 & 255) >> 4];
            i2 = i8 - 3;
            cArr4[i2] = cArr5[i11 & 15];
            c = (char) (c & 255);
        } else {
            cArr4[i8 - 4] = '0';
            i2 = i8 - 3;
            cArr4[i2] = '0';
        }
        char[] cArr6 = HEX_CHARS;
        cArr4[i2 + 1] = cArr6[c >> 4];
        cArr4[i2 + 2] = cArr6[c & 15];
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

    private void _writeLongString(String str) throws IOException {
        _flushBuffer();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = this._outputEnd;
            if (i + i2 > length) {
                i2 = length - i;
            }
            int i4 = i + i2;
            str.getChars(i, i4, this._outputBuffer, 0);
            if (this._characterEscapes != null) {
                _writeSegmentCustom(i2);
            } else {
                int i5 = this._maximumNonEscapedChar;
                if (i5 != 0) {
                    _writeSegmentASCII(i2, i5);
                } else {
                    _writeSegment(i2);
                }
            }
            if (i4 >= length) {
                return;
            } else {
                i = i4;
            }
        }
    }

    private void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        int i = this._outputTail;
        char[] cArr = this._outputBuffer;
        cArr[i] = 'n';
        cArr[i + 1] = 'u';
        cArr[i + 2] = 'l';
        cArr[i + 3] = 'l';
        this._outputTail = i + 4;
    }

    private void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i2 = this._outputTail;
        int i4 = i2 + 1;
        this._outputTail = i4;
        cArr[i2] = '\"';
        int iOutputInt = NumberOutput.outputInt(i, cArr, i4);
        char[] cArr2 = this._outputBuffer;
        this._outputTail = iOutputInt + 1;
        cArr2[iOutputInt] = '\"';
    }

    private void _writeQuotedLong(long j) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        cArr[i] = '\"';
        int iOutputLong = NumberOutput.outputLong(j, cArr, i2);
        char[] cArr2 = this._outputBuffer;
        this._outputTail = iOutputLong + 1;
        cArr2[iOutputLong] = '\"';
    }

    private void _writeQuotedRaw(Object obj) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '\"';
        writeRaw(obj.toString());
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = '\"';
    }

    private void _writeSegment(int i) throws IOException {
        char[] cArr;
        char c;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        int i2 = 0;
        int i_prependOrWriteCharacterEscape = 0;
        while (i2 < i) {
            do {
                cArr = this._outputBuffer;
                c = cArr[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i2++;
                }
            } while (i2 < i);
            int i4 = i2 - i_prependOrWriteCharacterEscape;
            if (i4 > 0) {
                this._writer.write(cArr, i_prependOrWriteCharacterEscape, i4);
                if (i2 >= i) {
                    return;
                }
            }
            int i5 = i2 + 1;
            i_prependOrWriteCharacterEscape = _prependOrWriteCharacterEscape(this._outputBuffer, i5, i, c, iArr[c]);
            i2 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[PHI: r4
      0x001e: PHI (r4v7 int) = (r4v2 int), (r4v8 int) binds: [B:9:0x001a, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _writeSegmentASCII(int i, int i2) throws IOException {
        char[] cArr;
        char c;
        int[] iArr = this._outputEscapes;
        int iMin = Math.min(iArr.length, i2 + 1);
        int i4 = 0;
        int i_prependOrWriteCharacterEscape = 0;
        int i5 = 0;
        while (i4 < i) {
            while (true) {
                cArr = this._outputBuffer;
                c = cArr[i4];
                if (c < iMin) {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                    i4++;
                    if (i4 >= i) {
                        break;
                    }
                } else if (c > i2) {
                    i5 = -1;
                    break;
                }
            }
            int i6 = i5;
            int i7 = i4 - i_prependOrWriteCharacterEscape;
            if (i7 > 0) {
                this._writer.write(cArr, i_prependOrWriteCharacterEscape, i7);
                if (i4 >= i) {
                    return;
                }
            }
            int i8 = i4 + 1;
            i_prependOrWriteCharacterEscape = _prependOrWriteCharacterEscape(this._outputBuffer, i8, i, c, i6);
            i4 = i8;
            i5 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[PHI: r6
      0x0032: PHI (r6v8 int) = (r6v2 int), (r6v9 int) binds: [B:15:0x002e, B:10:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _writeSegmentCustom(int i) throws IOException {
        char c;
        int[] iArr = this._outputEscapes;
        int i2 = this._maximumNonEscapedChar;
        if (i2 < 1) {
            i2 = 65535;
        }
        int iMin = Math.min(iArr.length, i2 + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        int i4 = 0;
        int i_prependOrWriteCharacterEscape = 0;
        int i5 = 0;
        while (i4 < i) {
            while (true) {
                c = this._outputBuffer[i4];
                if (c < iMin) {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                    i4++;
                    if (i4 >= i) {
                        break;
                    }
                } else {
                    if (c > i2) {
                        i5 = -1;
                        break;
                    }
                    SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                    this._currentEscape = escapeSequence;
                    if (escapeSequence != null) {
                        i5 = -2;
                        break;
                    }
                }
            }
            int i6 = i5;
            int i7 = i4 - i_prependOrWriteCharacterEscape;
            if (i7 > 0) {
                this._writer.write(this._outputBuffer, i_prependOrWriteCharacterEscape, i7);
                if (i4 >= i) {
                    return;
                }
            }
            int i8 = i4 + 1;
            i_prependOrWriteCharacterEscape = _prependOrWriteCharacterEscape(this._outputBuffer, i8, i, c, i6);
            i4 = i8;
            i5 = i6;
        }
    }

    private void _writeString(String str) throws IOException {
        int length = str.length();
        int i = this._outputEnd;
        if (length > i) {
            _writeLongString(str);
            return;
        }
        if (this._outputTail + length > i) {
            _flushBuffer();
        }
        str.getChars(0, length, this._outputBuffer, this._outputTail);
        if (this._characterEscapes != null) {
            _writeStringCustom(length);
            return;
        }
        int i2 = this._maximumNonEscapedChar;
        if (i2 != 0) {
            _writeStringASCII(length, i2);
        } else {
            _writeString2(length);
        }
    }

    private void _writeString2(int i) throws IOException {
        int i2;
        int i4 = this._outputTail + i;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        while (this._outputTail < i4) {
            do {
                char[] cArr = this._outputBuffer;
                int i5 = this._outputTail;
                char c = cArr[i5];
                if (c >= length || iArr[c] == 0) {
                    i2 = i5 + 1;
                    this._outputTail = i2;
                } else {
                    int i6 = this._outputHead;
                    int i7 = i5 - i6;
                    if (i7 > 0) {
                        this._writer.write(cArr, i6, i7);
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i8 = this._outputTail;
                    this._outputTail = i8 + 1;
                    char c2 = cArr2[i8];
                    _prependOrWriteCharacterEscape(c2, iArr[c2]);
                }
            } while (i2 < i4);
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _writeStringASCII(int i, int i2) throws IOException {
        int i4;
        int i5;
        int i6;
        int i7 = this._outputTail + i;
        int[] iArr = this._outputEscapes;
        int iMin = Math.min(iArr.length, i2 + 1);
        while (this._outputTail < i7) {
            do {
                char[] cArr = this._outputBuffer;
                int i8 = this._outputTail;
                char c = cArr[i8];
                if (c < iMin) {
                    i4 = iArr[c];
                    if (i4 != 0) {
                        int i9 = this._outputHead;
                        i5 = i8 - i9;
                        if (i5 <= 0) {
                            this._writer.write(cArr, i9, i5);
                        }
                        this._outputTail++;
                        _prependOrWriteCharacterEscape(c, i4);
                    }
                    i6 = i8 + 1;
                    this._outputTail = i6;
                } else {
                    if (c > i2) {
                        i4 = -1;
                        int i92 = this._outputHead;
                        i5 = i8 - i92;
                        if (i5 <= 0) {
                        }
                        this._outputTail++;
                        _prependOrWriteCharacterEscape(c, i4);
                    }
                    i6 = i8 + 1;
                    this._outputTail = i6;
                }
            } while (i6 < i7);
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _writeStringCustom(int i) throws IOException {
        int i2;
        int i4;
        int i5;
        int i6 = this._outputTail + i;
        int[] iArr = this._outputEscapes;
        int i7 = this._maximumNonEscapedChar;
        if (i7 < 1) {
            i7 = 65535;
        }
        int iMin = Math.min(iArr.length, i7 + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (this._outputTail < i6) {
            do {
                char c = this._outputBuffer[this._outputTail];
                if (c < iMin) {
                    i2 = iArr[c];
                    if (i2 != 0) {
                        int i8 = this._outputTail;
                        int i9 = this._outputHead;
                        i4 = i8 - i9;
                        if (i4 <= 0) {
                            this._writer.write(this._outputBuffer, i9, i4);
                        }
                        this._outputTail++;
                        _prependOrWriteCharacterEscape(c, i2);
                    }
                    i5 = this._outputTail + 1;
                    this._outputTail = i5;
                } else {
                    if (c > i7) {
                        i2 = -1;
                    } else {
                        SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                        this._currentEscape = escapeSequence;
                        if (escapeSequence != null) {
                            i2 = -2;
                        }
                        i5 = this._outputTail + 1;
                        this._outputTail = i5;
                    }
                    int i82 = this._outputTail;
                    int i92 = this._outputHead;
                    i4 = i82 - i92;
                    if (i4 <= 0) {
                    }
                    this._outputTail++;
                    _prependOrWriteCharacterEscape(c, i2);
                }
            } while (i5 < i6);
            return;
        }
    }

    private void writeRawLong(String str) throws IOException {
        int i = this._outputEnd;
        int i2 = this._outputTail;
        int i4 = i - i2;
        str.getChars(0, i4, this._outputBuffer, i2);
        this._outputTail += i4;
        _flushBuffer();
        int length = str.length() - i4;
        while (true) {
            int i5 = this._outputEnd;
            if (length <= i5) {
                str.getChars(i4, i4 + length, this._outputBuffer, 0);
                this._outputHead = 0;
                this._outputTail = length;
                return;
            } else {
                int i6 = i4 + i5;
                str.getChars(i4, i6, this._outputBuffer, 0);
                this._outputHead = 0;
                this._outputTail = i5;
                _flushBuffer();
                length -= i5;
                i4 = i6;
            }
        }
    }

    public void _flushBuffer() throws IOException {
        int i = this._outputTail;
        int i2 = this._outputHead;
        int i4 = i - i2;
        if (i4 > 0) {
            this._outputHead = 0;
            this._outputTail = 0;
            this._writer.write(this._outputBuffer, i2, i4);
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
        char[] cArr = this._outputBuffer;
        if (cArr != null) {
            this._outputBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
    }

    public void _verifyPrettyValueWrite(String str, int i) {
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
    public void _verifyValueWrite(String str) throws IOException {
        char c;
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
            c = ',';
        } else {
            if (iWriteValue != 2) {
                if (iWriteValue == 3 && (serializableString = this._rootValueSeparator) != null) {
                    writeRaw(serializableString.getValue());
                    return;
                }
                return;
            }
            c = ':';
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        cArr[i] = c;
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
            char[] cArr = this._outputBuffer;
            int i9 = iEncodeBase64Chunk + 1;
            this._outputTail = i9;
            cArr[iEncodeBase64Chunk] = '\\';
            this._outputTail = iEncodeBase64Chunk + 2;
            cArr[i9] = 'n';
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

    public void _writeFieldName(String str, boolean z) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(str, z);
            return;
        }
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        if (z) {
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ',';
        }
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            _writeString(str);
            return;
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = '\"';
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        cArr3[i4] = '\"';
    }

    public void _writePPFieldName(String str, boolean z) throws IOException {
        if (z) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            _writeString(str);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '\"';
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = '\"';
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
        if (this._writer != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._writer.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._writer.flush();
            }
        }
        _releaseBuffers();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        _flushBuffer();
        if (this._writer == null || !isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this._writer.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._writer;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        cArr[i4] = '\"';
        _writeBinary(base64Variant, bArr, i, i2 + i);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        cArr2[i5] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        int i;
        _verifyValueWrite("write boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        int i2 = this._outputTail;
        char[] cArr = this._outputBuffer;
        if (z) {
            cArr[i2] = 't';
            cArr[i2 + 1] = 'r';
            cArr[i2 + 2] = 'u';
            i = i2 + 3;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            cArr[i2 + 1] = 'a';
            cArr[i2 + 2] = 'l';
            cArr[i2 + 3] = 's';
            i = i2 + 4;
            cArr[i] = 'e';
        }
        this._outputTail = i + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException {
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
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = PropertyUtils.INDEXED_DELIM2;
        }
        this._writeContext = this._writeContext.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException {
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
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = '}';
        }
        this._writeContext = this._writeContext.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(str);
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str, iWriteFieldName == 1);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write null value");
        _writeNull();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
            return;
        }
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        int length = str.length();
        int i = this._outputEnd - this._outputTail;
        if (i == 0) {
            _flushBuffer();
            i = this._outputEnd - this._outputTail;
        }
        if (i < length) {
            writeRawLong(str);
        } else {
            str.getChars(0, length, this._outputBuffer, this._outputTail);
            this._outputTail += length;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException {
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
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = PropertyUtils.INDEXED_DELIM;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException {
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
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        _verifyValueWrite("write text value");
        if (str == null) {
            _writeNull();
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '\"';
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString, iWriteFieldName == 1);
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

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        int i4 = this._outputEnd - this._outputTail;
        if (i4 < i2) {
            _flushBuffer();
            i4 = this._outputEnd - this._outputTail;
        }
        if (i4 >= i2) {
            str.getChars(i, i + i2, this._outputBuffer, this._outputTail);
            this._outputTail += i2;
        } else {
            writeRawLong(str.substring(i, i2 + i));
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr[i2] = '\"';
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
            char[] cArr2 = this._outputBuffer;
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            cArr2[i4] = '\"';
            return i;
        } catch (Throwable th) {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        cArr2[i4] = '\"';
        _writeString(cArr, i, i2);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        cArr3[i5] = '\"';
    }

    private void _writeString(char[] cArr, int i, int i2) throws IOException {
        if (this._characterEscapes != null) {
            _writeStringCustom(cArr, i, i2);
            return;
        }
        int i4 = this._maximumNonEscapedChar;
        if (i4 != 0) {
            _writeStringASCII(cArr, i, i2, i4);
            return;
        }
        int i5 = i2 + i;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        while (i < i5) {
            int i6 = i;
            do {
                char c = cArr[i6];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i6++;
                }
            } while (i6 < i5);
            int i7 = i6 - i;
            if (i7 < 32) {
                if (this._outputTail + i7 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i7 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i7);
                    this._outputTail += i7;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i7);
            }
            if (i6 >= i5) {
                return;
            }
            i = i6 + 1;
            char c2 = cArr[i6];
            _appendCharacterEscape(c2, iArr[c2]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[PHI: r2
      0x001b: PHI (r2v6 int) = (r2v3 int), (r2v7 int) binds: [B:10:0x0017, B:8:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _writeStringASCII(char[] cArr, int i, int i2, int i4) throws IOException {
        char c;
        int i5 = i2 + i;
        int[] iArr = this._outputEscapes;
        int iMin = Math.min(iArr.length, i4 + 1);
        int i6 = 0;
        while (i < i5) {
            int i7 = i;
            while (true) {
                c = cArr[i7];
                if (c < iMin) {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                    i7++;
                    if (i7 >= i5) {
                        break;
                    }
                } else if (c > i4) {
                    i6 = -1;
                    break;
                }
            }
            int i8 = i7 - i;
            if (i8 < 32) {
                if (this._outputTail + i8 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i8 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i8);
                    this._outputTail += i8;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i8);
            }
            if (i7 >= i5) {
                return;
            }
            i = i7 + 1;
            _appendCharacterEscape(c, i6);
        }
    }

    public void _writePPFieldName(SerializableString serializableString, boolean z) throws IOException {
        if (z) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        char[] cArrAsQuotedChars = serializableString.asQuotedChars();
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = '\"';
            writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            cArr2[i2] = '\"';
            return;
        }
        writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
    }

    public void _writeFieldName(SerializableString serializableString, boolean z) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(serializableString, z);
            return;
        }
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        if (z) {
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ',';
        }
        char[] cArrAsQuotedChars = serializableString.asQuotedChars();
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
            return;
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        int i4 = i2 + 1;
        this._outputTail = i4;
        cArr2[i2] = '\"';
        int length = cArrAsQuotedChars.length;
        if (i4 + length + 1 >= this._outputEnd) {
            writeRaw(cArrAsQuotedChars, 0, length);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr3 = this._outputBuffer;
            int i5 = this._outputTail;
            this._outputTail = i5 + 1;
            cArr3[i5] = '\"';
            return;
        }
        System.arraycopy(cArrAsQuotedChars, 0, cArr2, i4, length);
        int i6 = this._outputTail + length;
        char[] cArr4 = this._outputBuffer;
        this._outputTail = i6 + 1;
        cArr4[i6] = '\"';
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
    public void writeRaw(SerializableString serializableString) throws IOException {
        writeRaw(serializableString.getValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[PHI: r4
      0x002f: PHI (r4v6 int) = (r4v2 int), (r4v7 int) binds: [B:16:0x002b, B:11:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _writeStringCustom(char[] cArr, int i, int i2) throws IOException {
        char c;
        int i4 = i2 + i;
        int[] iArr = this._outputEscapes;
        int i5 = this._maximumNonEscapedChar;
        if (i5 < 1) {
            i5 = 65535;
        }
        int iMin = Math.min(iArr.length, i5 + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        int i6 = 0;
        while (i < i4) {
            int i7 = i;
            while (true) {
                c = cArr[i7];
                if (c < iMin) {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                    i7++;
                    if (i7 >= i4) {
                        break;
                    }
                } else {
                    if (c > i5) {
                        i6 = -1;
                        break;
                    }
                    SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                    this._currentEscape = escapeSequence;
                    if (escapeSequence != null) {
                        i6 = -2;
                        break;
                    }
                }
            }
            int i8 = i7 - i;
            if (i8 < 32) {
                if (this._outputTail + i8 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i8 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i8);
                    this._outputTail += i8;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i8);
            }
            if (i7 >= i4) {
                return;
            }
            i = i7 + 1;
            _appendCharacterEscape(c, i6);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 32) {
            if (i2 > this._outputEnd - this._outputTail) {
                _flushBuffer();
            }
            System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i2);
            this._outputTail += i2;
            return;
        }
        _flushBuffer();
        this._writer.write(cArr, i, i2);
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
                char[] cArr = this._outputBuffer;
                int i10 = iEncodeBase64Chunk + 1;
                this._outputTail = i10;
                cArr[iEncodeBase64Chunk] = '\\';
                this._outputTail = iEncodeBase64Chunk + 2;
                cArr[i10] = 'n';
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

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        if (!this._cfgNumbersAsStrings && ((!Double.isNaN(d) && !Double.isInfinite(d)) || !isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            _verifyValueWrite("write number");
            writeRaw(String.valueOf(d));
        } else {
            writeString(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '\"';
        char[] cArrAsQuotedChars = serializableString.asQuotedChars();
        int length = cArrAsQuotedChars.length;
        if (length < 32) {
            if (length > this._outputEnd - this._outputTail) {
                _flushBuffer();
            }
            System.arraycopy(cArrAsQuotedChars, 0, this._outputBuffer, this._outputTail, length);
            this._outputTail += length;
        } else {
            _flushBuffer();
            this._writer.write(cArrAsQuotedChars, 0, length);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = c;
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
                char[] cArr = this._outputBuffer;
                int i9 = iEncodeBase64Chunk + 1;
                this._outputTail = i9;
                cArr[iEncodeBase64Chunk] = '\\';
                this._outputTail = iEncodeBase64Chunk + 2;
                cArr[i9] = 'n';
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

    private int _prependOrWriteCharacterEscape(char[] cArr, int i, int i2, char c, int i4) throws IOException {
        String value;
        int i5;
        if (i4 >= 0) {
            if (i > 1 && i < i2) {
                int i6 = i - 2;
                cArr[i6] = '\\';
                cArr[i - 1] = (char) i4;
                return i6;
            }
            char[] cArr_allocateEntityBuffer = this._entityBuffer;
            if (cArr_allocateEntityBuffer == null) {
                cArr_allocateEntityBuffer = _allocateEntityBuffer();
            }
            cArr_allocateEntityBuffer[1] = (char) i4;
            this._writer.write(cArr_allocateEntityBuffer, 0, 2);
            return i;
        }
        if (i4 == -2) {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                value = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                value = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = value.length();
            if (i >= length && i < i2) {
                int i7 = i - length;
                value.getChars(0, length, cArr, i7);
                return i7;
            }
            this._writer.write(value);
            return i;
        }
        if (i > 5 && i < i2) {
            cArr[i - 6] = '\\';
            int i8 = i - 4;
            cArr[i - 5] = 'u';
            if (c > 255) {
                int i9 = c >> '\b';
                int i10 = i - 3;
                char[] cArr2 = HEX_CHARS;
                cArr[i8] = cArr2[(i9 & 255) >> 4];
                i5 = i - 2;
                cArr[i10] = cArr2[i9 & 15];
                c = (char) (c & 255);
            } else {
                int i11 = i - 3;
                cArr[i8] = '0';
                i5 = i - 2;
                cArr[i11] = '0';
            }
            char[] cArr3 = HEX_CHARS;
            cArr[i5] = cArr3[c >> 4];
            cArr[i5 + 1] = cArr3[c & 15];
            return i5 - 4;
        }
        char[] cArr_allocateEntityBuffer2 = this._entityBuffer;
        if (cArr_allocateEntityBuffer2 == null) {
            cArr_allocateEntityBuffer2 = _allocateEntityBuffer();
        }
        this._outputHead = this._outputTail;
        if (c > 255) {
            int i12 = c >> '\b';
            char[] cArr4 = HEX_CHARS;
            cArr_allocateEntityBuffer2[10] = cArr4[(i12 & 255) >> 4];
            cArr_allocateEntityBuffer2[11] = cArr4[i12 & 15];
            cArr_allocateEntityBuffer2[12] = cArr4[(c & 255) >> 4];
            cArr_allocateEntityBuffer2[13] = cArr4[c & 15];
            this._writer.write(cArr_allocateEntityBuffer2, 8, 6);
            return i;
        }
        char[] cArr5 = HEX_CHARS;
        cArr_allocateEntityBuffer2[6] = cArr5[c >> 4];
        cArr_allocateEntityBuffer2[7] = cArr5[c & 15];
        this._writer.write(cArr_allocateEntityBuffer2, 2, 6);
        return i;
    }
}
