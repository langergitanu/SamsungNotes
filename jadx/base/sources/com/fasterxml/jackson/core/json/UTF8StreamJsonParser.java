package com.fasterxml.jackson.core.json;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p128io.CharTypes;
import com.fasterxml.jackson.core.p128io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okio.Utf8;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class UTF8StreamJsonParser extends ParserBase {
    static final byte BYTE_LF = 10;
    protected boolean _bufferRecyclable;
    protected byte[] _inputBuffer;
    protected InputStream _inputStream;
    protected ObjectCodec _objectCodec;
    private int _quad1;
    protected int[] _quadBuffer;
    protected final BytesToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete;
    private static final int[] sInputCodesUtf8 = CharTypes.getInputCodeUtf8();
    private static final int[] sInputCodesLatin1 = CharTypes.getInputCodeLatin1();

    /* JADX INFO: renamed from: com.fasterxml.jackson.core.json.UTF8StreamJsonParser$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C44751 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr;
            try {
                iArr[JsonToken.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public UTF8StreamJsonParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, byte[] bArr, int i2, int i4, boolean z) {
        super(iOContext, i);
        this._quadBuffer = new int[16];
        this._tokenIncomplete = false;
        this._inputStream = inputStream;
        this._objectCodec = objectCodec;
        this._symbols = bytesToNameCanonicalizer;
        this._inputBuffer = bArr;
        this._inputPtr = i2;
        this._inputEnd = i4;
        this._bufferRecyclable = z;
    }

    private int _decodeUtf8_2(int i) throws JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i4);
        }
        return ((i & 31) << 6) | (b & Utf8.REPLACEMENT_BYTE);
    }

    private int _decodeUtf8_3(int i) throws JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        int i2 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i4 = this._inputPtr;
        int i5 = i4 + 1;
        this._inputPtr = i5;
        byte b = bArr[i4];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i5);
        }
        int i6 = (i2 << 6) | (b & Utf8.REPLACEMENT_BYTE);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i7 = this._inputPtr;
        int i8 = i7 + 1;
        this._inputPtr = i8;
        byte b5 = bArr2[i7];
        if ((b5 & 192) != 128) {
            _reportInvalidOther(b5 & 255, i8);
        }
        return (i6 << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
    }

    private int _decodeUtf8_3fast(int i) throws JsonParseException {
        int i2 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i4 = this._inputPtr;
        int i5 = i4 + 1;
        this._inputPtr = i5;
        byte b = bArr[i4];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i5);
        }
        int i6 = (i2 << 6) | (b & Utf8.REPLACEMENT_BYTE);
        byte[] bArr2 = this._inputBuffer;
        int i7 = this._inputPtr;
        int i8 = i7 + 1;
        this._inputPtr = i8;
        byte b5 = bArr2[i7];
        if ((b5 & 192) != 128) {
            _reportInvalidOther(b5 & 255, i8);
        }
        return (i6 << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
    }

    private int _decodeUtf8_4(int i) throws JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i4);
        }
        int i5 = ((i & 7) << 6) | (b & Utf8.REPLACEMENT_BYTE);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i6 = this._inputPtr;
        int i7 = i6 + 1;
        this._inputPtr = i7;
        byte b5 = bArr2[i6];
        if ((b5 & 192) != 128) {
            _reportInvalidOther(b5 & 255, i7);
        }
        int i8 = (i5 << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i9 = this._inputPtr;
        int i10 = i9 + 1;
        this._inputPtr = i10;
        byte b6 = bArr3[i9];
        if ((b6 & 192) != 128) {
            _reportInvalidOther(b6 & 255, i10);
        }
        return ((i8 << 6) | (b6 & Utf8.REPLACEMENT_BYTE)) - 65536;
    }

    private void _finishString2(char[] cArr, int i) throws JsonParseException {
        int[] iArr = sInputCodesUtf8;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i2 = this._inputPtr;
            if (i2 >= this._inputEnd) {
                loadMoreGuaranteed();
                i2 = this._inputPtr;
            }
            int i4 = 0;
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int iMin = Math.min(this._inputEnd, (cArr.length - i) + i2);
            while (true) {
                if (i2 >= iMin) {
                    this._inputPtr = i2;
                    break;
                }
                int i5 = i2 + 1;
                int i_decodeEscaped = bArr[i2] & 255;
                int i6 = iArr[i_decodeEscaped];
                if (i6 != 0) {
                    this._inputPtr = i5;
                    if (i_decodeEscaped == 34) {
                        this._textBuffer.setCurrentLength(i);
                        return;
                    }
                    if (i6 == 1) {
                        i_decodeEscaped = _decodeEscaped();
                    } else if (i6 == 2) {
                        i_decodeEscaped = _decodeUtf8_2(i_decodeEscaped);
                    } else if (i6 == 3) {
                        i_decodeEscaped = this._inputEnd - i5 >= 2 ? _decodeUtf8_3fast(i_decodeEscaped) : _decodeUtf8_3(i_decodeEscaped);
                    } else if (i6 == 4) {
                        int i_decodeUtf8_4 = _decodeUtf8_4(i_decodeEscaped);
                        int i7 = i + 1;
                        cArr[i] = (char) ((i_decodeUtf8_4 >> 10) | 55296);
                        if (i7 >= cArr.length) {
                            cArr = this._textBuffer.finishCurrentSegment();
                            i = 0;
                        } else {
                            i = i7;
                        }
                        i_decodeEscaped = (i_decodeUtf8_4 & 1023) | Utf8.LOG_SURROGATE_HEADER;
                    } else if (i_decodeEscaped < 32) {
                        _throwUnquotedSpace(i_decodeEscaped, "string value");
                    } else {
                        _reportInvalidChar(i_decodeEscaped);
                    }
                    if (i >= cArr.length) {
                        cArr = this._textBuffer.finishCurrentSegment();
                    } else {
                        i4 = i;
                    }
                    i = i4 + 1;
                    cArr[i4] = (char) i_decodeEscaped;
                } else {
                    cArr[i] = (char) i_decodeEscaped;
                    i2 = i5;
                    i++;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean _isNextTokenNameMaybe(int i, SerializableString serializableString) throws JsonParseException {
        JsonToken numberText;
        String name = _parseFieldName(i).getName();
        this._parsingContext.setCurrentName(name);
        boolean zEquals = name.equals(serializableString.getValue());
        this._currToken = JsonToken.FIELD_NAME;
        int i_skipWS = _skipWS();
        if (i_skipWS != 58) {
            _reportUnexpectedChar(i_skipWS, "was expecting a colon to separate field name and value");
        }
        int i_skipWS2 = _skipWS();
        if (i_skipWS2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return zEquals;
        }
        if (i_skipWS2 == 45) {
            numberText = parseNumberText(i_skipWS2);
        } else if (i_skipWS2 == 91) {
            numberText = JsonToken.START_ARRAY;
        } else if (i_skipWS2 == 93) {
            _reportUnexpectedChar(i_skipWS2, "expected a value");
            _matchToken("true", 1);
            numberText = JsonToken.VALUE_TRUE;
        } else if (i_skipWS2 == 102) {
            _matchToken("false", 1);
            numberText = JsonToken.VALUE_FALSE;
        } else if (i_skipWS2 == 110) {
            _matchToken("null", 1);
            numberText = JsonToken.VALUE_NULL;
        } else if (i_skipWS2 == 116) {
            _matchToken("true", 1);
            numberText = JsonToken.VALUE_TRUE;
        } else if (i_skipWS2 != 123) {
            if (i_skipWS2 != 125) {
                switch (i_skipWS2) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        numberText = _handleUnexpectedValue(i_skipWS2);
                        break;
                }
            }
            _reportUnexpectedChar(i_skipWS2, "expected a value");
            _matchToken("true", 1);
            numberText = JsonToken.VALUE_TRUE;
        } else {
            numberText = JsonToken.START_OBJECT;
        }
        this._nextToken = numberText;
        return zEquals;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _isNextTokenNameYes() throws JsonParseException {
        int i_skipColon;
        int i = this._inputPtr;
        if (i < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            if (bArr[i] == 58) {
                this._inputPtr = i + 2;
                byte b = bArr[i + 1];
                if (b == 34) {
                    this._tokenIncomplete = true;
                    this._nextToken = JsonToken.VALUE_STRING;
                    return;
                } else {
                    if (b == 123) {
                        this._nextToken = JsonToken.START_OBJECT;
                        return;
                    }
                    if (b == 91) {
                        this._nextToken = JsonToken.START_ARRAY;
                        return;
                    }
                    i_skipColon = b & 255;
                    if (i_skipColon <= 32 || i_skipColon == 47) {
                        this._inputPtr = i + 1;
                        i_skipColon = _skipWS();
                    }
                }
            } else {
                i_skipColon = _skipColon();
            }
        }
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return;
        }
        if (i_skipColon != 45) {
            if (i_skipColon == 91) {
                this._nextToken = JsonToken.START_ARRAY;
                return;
            }
            if (i_skipColon == 93) {
                _reportUnexpectedChar(i_skipColon, "expected a value");
            } else {
                if (i_skipColon == 102) {
                    _matchToken("false", 1);
                    this._nextToken = JsonToken.VALUE_FALSE;
                    return;
                }
                if (i_skipColon == 110) {
                    _matchToken("null", 1);
                    this._nextToken = JsonToken.VALUE_NULL;
                    return;
                } else if (i_skipColon != 116) {
                    if (i_skipColon == 123) {
                        this._nextToken = JsonToken.START_OBJECT;
                        return;
                    }
                    if (i_skipColon != 125) {
                        switch (i_skipColon) {
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                                break;
                            default:
                                this._nextToken = _handleUnexpectedValue(i_skipColon);
                                break;
                        }
                        return;
                    }
                    _reportUnexpectedChar(i_skipColon, "expected a value");
                }
            }
            _matchToken("true", 1);
            this._nextToken = JsonToken.VALUE_TRUE;
            return;
        }
        this._nextToken = parseNumberText(i_skipColon);
    }

    private JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = jsonToken;
        return jsonToken;
    }

    private JsonToken _nextTokenNotInObject(int i) throws JsonParseException {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        }
        if (i != 45) {
            if (i == 91) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this._currToken = jsonToken2;
                return jsonToken2;
            }
            if (i == 93) {
                _reportUnexpectedChar(i, "expected a value");
            } else {
                if (i == 102) {
                    _matchToken("false", 1);
                    JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                    this._currToken = jsonToken3;
                    return jsonToken3;
                }
                if (i == 110) {
                    _matchToken("null", 1);
                    JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                    this._currToken = jsonToken4;
                    return jsonToken4;
                }
                if (i != 116) {
                    if (i == 123) {
                        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                        JsonToken jsonToken5 = JsonToken.START_OBJECT;
                        this._currToken = jsonToken5;
                        return jsonToken5;
                    }
                    if (i != 125) {
                        switch (i) {
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                                break;
                            default:
                                JsonToken jsonToken_handleUnexpectedValue = _handleUnexpectedValue(i);
                                this._currToken = jsonToken_handleUnexpectedValue;
                                return jsonToken_handleUnexpectedValue;
                        }
                    }
                    _reportUnexpectedChar(i, "expected a value");
                }
            }
            _matchToken("true", 1);
            JsonToken jsonToken6 = JsonToken.VALUE_TRUE;
            this._currToken = jsonToken6;
            return jsonToken6;
        }
        JsonToken numberText = parseNumberText(i);
        this._currToken = numberText;
        return numberText;
    }

    private JsonToken _parseFloatText(char[] cArr, int i, int i2, boolean z, int i4) {
        int i5;
        boolean z2;
        int i6 = 0;
        if (i2 == 46) {
            cArr[i] = (char) i2;
            i++;
            i5 = 0;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    z2 = true;
                    break;
                }
                byte[] bArr = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                i2 = bArr[i7] & 255;
                if (i2 < 48 || i2 > 57) {
                    break;
                }
                i5++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                cArr[i] = (char) i2;
                i++;
            }
            z2 = false;
            if (i5 == 0) {
                reportUnexpectedNumberChar(i2, "Decimal point not followed by a digit");
            }
        } else {
            i5 = 0;
            z2 = false;
        }
        if (i2 == 101 || i2 == 69) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i8 = i + 1;
            cArr[i] = (char) i2;
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i9 = this._inputPtr;
            this._inputPtr = i9 + 1;
            int i10 = bArr2[i9] & 255;
            if (i10 == 45 || i10 == 43) {
                if (i8 >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i8 = 0;
                }
                int i11 = i8 + 1;
                cArr[i8] = (char) i10;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i12 = this._inputPtr;
                this._inputPtr = i12 + 1;
                i10 = bArr3[i12] & 255;
                i8 = i11;
            }
            int i13 = 0;
            while (true) {
                if (i10 <= 57 && i10 >= 48) {
                    i13++;
                    if (i8 >= cArr.length) {
                        cArr = this._textBuffer.finishCurrentSegment();
                        i8 = 0;
                    }
                    int i14 = i8 + 1;
                    cArr[i8] = (char) i10;
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        z2 = true;
                        i8 = i14;
                        break;
                    }
                    byte[] bArr4 = this._inputBuffer;
                    int i15 = this._inputPtr;
                    this._inputPtr = i15 + 1;
                    i10 = bArr4[i15] & 255;
                    i8 = i14;
                } else {
                    break;
                }
            }
            i6 = i13;
            if (i6 == 0) {
                reportUnexpectedNumberChar(i10, "Exponent indicator not followed by a digit");
            }
            i = i8;
        }
        if (!z2) {
            this._inputPtr--;
        }
        this._textBuffer.setCurrentLength(i);
        return resetFloat(z, i4, i5, i6);
    }

    private JsonToken _parserNumber2(char[] cArr, int i, boolean z, int i2) {
        int i4;
        int i5;
        char[] cArrFinishCurrentSegment = cArr;
        int i6 = i;
        int i7 = i2;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                this._textBuffer.setCurrentLength(i6);
                return resetInt(z, i7);
            }
            byte[] bArr = this._inputBuffer;
            i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            i5 = bArr[i4] & 255;
            if (i5 > 57 || i5 < 48) {
                break;
            }
            if (i6 >= cArrFinishCurrentSegment.length) {
                i6 = 0;
                cArrFinishCurrentSegment = this._textBuffer.finishCurrentSegment();
            }
            cArrFinishCurrentSegment[i6] = (char) i5;
            i7++;
            i6++;
        }
        if (i5 == 46 || i5 == 101 || i5 == 69) {
            return _parseFloatText(cArrFinishCurrentSegment, i6, i5, z, i7);
        }
        this._inputPtr = i4;
        this._textBuffer.setCurrentLength(i6);
        return resetInt(z, i7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        _reportInvalidEOF(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _skipCComment() throws JsonParseException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            int i2 = i + 1;
            this._inputPtr = i2;
            int i4 = bArr[i] & 255;
            int i5 = inputCodeComment[i4];
            if (i5 != 0) {
                if (i5 == 2) {
                    _skipUtf8_2(i4);
                } else if (i5 == 3) {
                    _skipUtf8_3(i4);
                } else if (i5 == 4) {
                    _skipUtf8_4(i4);
                } else if (i5 == 10) {
                    _skipLF();
                } else if (i5 == 13) {
                    _skipCR();
                } else if (i5 == 42) {
                    if (i2 >= this._inputEnd && !loadMore()) {
                        break;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i6 = this._inputPtr;
                    if (bArr2[i6] == 47) {
                        this._inputPtr = i6 + 1;
                        return;
                    }
                } else {
                    _reportInvalidChar(i4);
                }
            }
        }
    }

    private int _skipColon() throws JsonParseException {
        int i;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        byte b = bArr[i2];
        if (b != 58) {
            int i5 = b & 255;
            while (true) {
                if (i5 != 9) {
                    if (i5 == 10) {
                        _skipLF();
                    } else if (i5 == 13) {
                        _skipCR();
                    } else if (i5 != 32) {
                        if (i5 != 47) {
                            break;
                        }
                        _skipComment();
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr2 = this._inputBuffer;
                int i6 = this._inputPtr;
                this._inputPtr = i6 + 1;
                i5 = bArr2[i6] & 255;
            }
            if (i5 < 32) {
                _throwInvalidSpace(i5);
            }
            if (i5 != 58) {
                _reportUnexpectedChar(i5, "was expecting a colon to separate field name and value");
            }
        } else if (i4 < this._inputEnd && (i = bArr[i4] & 255) > 32 && i != 47) {
            this._inputPtr = i2 + 2;
            return i;
        }
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
            }
            byte[] bArr3 = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            int i8 = bArr3[i7] & 255;
            if (i8 > 32) {
                if (i8 != 47) {
                    return i8;
                }
                _skipComment();
            } else if (i8 != 32) {
                if (i8 == 10) {
                    _skipLF();
                } else if (i8 == 13) {
                    _skipCR();
                } else if (i8 != 9) {
                    _throwInvalidSpace(i8);
                }
            }
        }
    }

    private void _skipComment() throws JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in a comment");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 47) {
            _skipCppComment();
        } else if (i2 == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private void _skipCppComment() throws JsonParseException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            int i4 = inputCodeComment[i2];
            if (i4 != 0) {
                if (i4 == 2) {
                    _skipUtf8_2(i2);
                } else if (i4 == 3) {
                    _skipUtf8_3(i2);
                } else if (i4 == 4) {
                    _skipUtf8_4(i2);
                } else if (i4 == 10) {
                    _skipLF();
                    return;
                } else if (i4 == 13) {
                    _skipCR();
                    return;
                } else if (i4 != 42) {
                    _reportInvalidChar(i2);
                }
            }
        }
    }

    private void _skipUtf8_2(int i) throws JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i4);
        }
    }

    private void _skipUtf8_3(int i) throws JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i4);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        int i6 = i5 + 1;
        this._inputPtr = i6;
        byte b5 = bArr2[i5];
        if ((b5 & 192) != 128) {
            _reportInvalidOther(b5 & 255, i6);
        }
    }

    private void _skipUtf8_4(int i) throws JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, i4);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        int i6 = i5 + 1;
        this._inputPtr = i6;
        byte b5 = bArr2[i5];
        if ((b5 & 192) != 128) {
            _reportInvalidOther(b5 & 255, i6);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i7 = this._inputPtr;
        int i8 = i7 + 1;
        this._inputPtr = i8;
        byte b6 = bArr3[i7];
        if ((b6 & 192) != 128) {
            _reportInvalidOther(b6 & 255, i8);
        }
    }

    private int _skipWS() throws JsonParseException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 != 47) {
                    return i2;
                }
                _skipComment();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    _skipLF();
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                }
            }
        }
    }

    private int _skipWSOrEnd() throws JsonParseException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _handleEOF();
                return -1;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 != 47) {
                    return i2;
                }
                _skipComment();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    _skipLF();
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                }
            }
        }
    }

    private int _verifyNoLeadingZeroes() {
        int i;
        if ((this._inputPtr >= this._inputEnd && !loadMore()) || (i = this._inputBuffer[this._inputPtr] & 255) < 48 || i > 57) {
            return 48;
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (i != 48) {
            return i;
        }
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return i;
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            i = bArr[i2] & 255;
            if (i < 48 || i > 57) {
                return 48;
            }
            this._inputPtr = i2 + 1;
        } while (i == 48);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Name addName(int[] iArr, int i, int i2) throws JsonParseException {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = ((i << 2) - 4) + i2;
        int i10 = 3;
        if (i2 < 4) {
            int i11 = i - 1;
            i4 = iArr[i11];
            iArr[i11] = i4 << ((4 - i2) << 3);
        } else {
            i4 = 0;
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i12 = 0;
        int i13 = 0;
        while (i12 < i9) {
            int i14 = iArr[i12 >> 2] >> ((3 - (i12 & 3)) << i10);
            int i15 = i14 & 255;
            int i16 = i12 + 1;
            if (i15 > 127) {
                i5 = i10;
                if ((i14 & JPEG.APP0) == 192) {
                    i6 = i14 & 31;
                    i7 = 1;
                } else if ((i14 & 240) == 224) {
                    i6 = i14 & 15;
                    i7 = 2;
                } else if ((i14 & 248) == 240) {
                    i6 = i14 & 7;
                    i7 = i5;
                } else {
                    _reportInvalidInitial(i15);
                    i6 = 1;
                    i7 = 1;
                }
                if (i16 + i7 > i9) {
                    _reportInvalidEOF(" in field name");
                }
                int i17 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                i16 = i12 + 2;
                if ((i17 & 192) != 128) {
                    _reportInvalidOther(i17);
                }
                int i18 = (i6 << 6) | (i17 & 63);
                if (i7 > 1) {
                    int i19 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                    i16 = i12 + 3;
                    if ((i19 & 192) != 128) {
                        _reportInvalidOther(i19);
                    }
                    int i20 = (i19 & 63) | (i18 << 6);
                    i8 = 2;
                    if (i7 > 2) {
                        int i21 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                        i16 = i12 + 4;
                        if ((i21 & 192) != 128) {
                            _reportInvalidOther(i21 & 255);
                        }
                        i15 = (i20 << 6) | (i21 & 63);
                    } else {
                        i15 = i20;
                        if (i7 > i8) {
                            int i22 = i15 - 65536;
                            if (i13 >= cArrEmptyAndGetCurrentSegment.length) {
                                cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
                            }
                            cArrEmptyAndGetCurrentSegment[i13] = (char) ((i22 >> 10) + 55296);
                            i15 = (i22 & 1023) | Utf8.LOG_SURROGATE_HEADER;
                            i13++;
                        }
                    }
                } else {
                    i15 = i18;
                }
                i8 = 2;
                if (i7 > i8) {
                }
            } else {
                i5 = i10;
            }
            i12 = i16;
            if (i13 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
            }
            cArrEmptyAndGetCurrentSegment[i13] = (char) i15;
            i13++;
            i10 = i5;
        }
        String str = new String(cArrEmptyAndGetCurrentSegment, 0, i13);
        if (i2 < 4) {
            iArr[i - 1] = i4;
        }
        return this._symbols.addName(str, iArr, i);
    }

    private Name findName(int i, int i2) {
        Name nameFindName = this._symbols.findName(i);
        if (nameFindName != null) {
            return nameFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        return addName(iArr, 1, i2);
    }

    public static int[] growArrayBy(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[i + length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private int nextByte() {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & 255;
    }

    private Name parseFieldName(int i, int i2, int i4) {
        return parseEscapedFieldName(this._quadBuffer, 0, i, i2, i4);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _closeInput() throws IOException {
        if (this._inputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._inputStream.close();
            }
            this._inputStream = null;
        }
    }

    public byte[] _decodeBase64(Base64Variant base64Variant) {
        ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(i2);
                if (iDecodeBase64Char < 0) {
                    if (i2 == 34) {
                        return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, i2, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr2 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                int i5 = bArr2[i4] & 255;
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(i5);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, i5, 1);
                }
                int i6 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                int i8 = bArr3[i7] & 255;
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(i8);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (i8 == 34 && !base64Variant.usesPadding()) {
                            byteArrayBuilder_getByteArrayBuilder.append(i6 >> 4);
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, i8, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr4 = this._inputBuffer;
                        int i9 = this._inputPtr;
                        this._inputPtr = i9 + 1;
                        int i10 = bArr4[i9] & 255;
                        if (!base64Variant.usesPaddingChar(i10)) {
                            throw reportInvalidBase64Char(base64Variant, i10, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        byteArrayBuilder_getByteArrayBuilder.append(i6 >> 4);
                    }
                }
                int i11 = (i6 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr5 = this._inputBuffer;
                int i12 = this._inputPtr;
                this._inputPtr = i12 + 1;
                int i13 = bArr5[i12] & 255;
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(i13);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (i13 == 34 && !base64Variant.usesPadding()) {
                            byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i11 >> 2);
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, i13, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i11 >> 2);
                    }
                }
                byteArrayBuilder_getByteArrayBuilder.appendThreeBytes((i11 << 6) | iDecodeBase64Char4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int _decodeCharForError(int i) throws JsonParseException {
        char c;
        int iNextByte;
        if (i >= 0) {
            return i;
        }
        if ((i & JPEG.APP0) != 192) {
            if ((i & 240) == 224) {
                i &= 15;
                c = 2;
            } else if ((i & 248) == 240) {
                i &= 7;
                c = 3;
            } else {
                _reportInvalidInitial(i & 255);
            }
            iNextByte = nextByte();
            if ((iNextByte & 192) != 128) {
                _reportInvalidOther(iNextByte & 255);
            }
            int i2 = (i << 6) | (iNextByte & 63);
            if (c > 1) {
                return i2;
            }
            int iNextByte2 = nextByte();
            if ((iNextByte2 & 192) != 128) {
                _reportInvalidOther(iNextByte2 & 255);
            }
            int i4 = (i2 << 6) | (iNextByte2 & 63);
            if (c <= 2) {
                return i4;
            }
            int iNextByte3 = nextByte();
            if ((iNextByte3 & 192) != 128) {
                _reportInvalidOther(iNextByte3 & 255);
            }
            return (i4 << 6) | (iNextByte3 & 63);
        }
        i &= 31;
        c = 1;
        iNextByte = nextByte();
        if ((iNextByte & 192) != 128) {
        }
        int i22 = (i << 6) | (iNextByte & 63);
        if (c > 1) {
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public char _decodeEscaped() throws JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in character escape sequence");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (b == 34 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(b));
        }
        int i2 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in character escape sequence");
            }
            byte[] bArr2 = this._inputBuffer;
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            byte b5 = bArr2[i5];
            int iCharToHex = CharTypes.charToHex(b5);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(b5, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | iCharToHex;
        }
        return (char) i2;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _finishString() throws JsonParseException {
        int i = this._inputPtr;
        if (i >= this._inputEnd) {
            loadMoreGuaranteed();
            i = this._inputPtr;
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = sInputCodesUtf8;
        int iMin = Math.min(this._inputEnd, cArrEmptyAndGetCurrentSegment.length + i);
        byte[] bArr = this._inputBuffer;
        int i2 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            int i4 = bArr[i] & 255;
            if (iArr[i4] == 0) {
                i++;
                cArrEmptyAndGetCurrentSegment[i2] = (char) i4;
                i2++;
            } else if (i4 == 34) {
                this._inputPtr = i + 1;
                this._textBuffer.setCurrentLength(i2);
                return;
            }
        }
        this._inputPtr = i;
        _finishString2(cArrEmptyAndGetCurrentSegment, i2);
    }

    public String _getText2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int i = C44751.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4) ? this._textBuffer.contentsAsString() : jsonToken.asString() : this._parsingContext.getCurrentName();
    }

    public JsonToken _handleApostropheValue() throws JsonParseException {
        int i;
        int i_decodeEscaped;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = sInputCodesUtf8;
        byte[] bArr = this._inputBuffer;
        int i2 = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            if (i2 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i2 = 0;
            }
            int i4 = this._inputEnd;
            int length = (cArrEmptyAndGetCurrentSegment.length - i2) + this._inputPtr;
            if (length < i4) {
                i4 = length;
            }
            while (true) {
                int i5 = this._inputPtr;
                if (i5 < i4) {
                    i = i5 + 1;
                    this._inputPtr = i;
                    i_decodeEscaped = bArr[i5] & 255;
                    if (i_decodeEscaped == 39 || iArr[i_decodeEscaped] != 0) {
                        break;
                    }
                    cArrEmptyAndGetCurrentSegment[i2] = (char) i_decodeEscaped;
                    i2++;
                }
            }
            if (i_decodeEscaped == 39) {
                this._textBuffer.setCurrentLength(i2);
                return JsonToken.VALUE_STRING;
            }
            int i6 = iArr[i_decodeEscaped];
            if (i6 != 1) {
                if (i6 == 2) {
                    i_decodeEscaped = _decodeUtf8_2(i_decodeEscaped);
                } else if (i6 == 3) {
                    i_decodeEscaped = this._inputEnd - i >= 2 ? _decodeUtf8_3fast(i_decodeEscaped) : _decodeUtf8_3(i_decodeEscaped);
                } else if (i6 != 4) {
                    if (i_decodeEscaped < 32) {
                        _throwUnquotedSpace(i_decodeEscaped, "string value");
                    }
                    _reportInvalidChar(i_decodeEscaped);
                } else {
                    int i_decodeUtf8_4 = _decodeUtf8_4(i_decodeEscaped);
                    int i7 = i2 + 1;
                    cArrEmptyAndGetCurrentSegment[i2] = (char) ((i_decodeUtf8_4 >> 10) | 55296);
                    if (i7 >= cArrEmptyAndGetCurrentSegment.length) {
                        cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                        i2 = 0;
                    } else {
                        i2 = i7;
                    }
                    i_decodeEscaped = 56320 | (i_decodeUtf8_4 & 1023);
                }
            } else if (i_decodeEscaped != 34) {
                i_decodeEscaped = _decodeEscaped();
            }
            if (i2 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i2 = 0;
            }
            cArrEmptyAndGetCurrentSegment[i2] = (char) i_decodeEscaped;
            i2++;
        }
    }

    public JsonToken _handleInvalidNumberStart(int i, boolean z) throws JsonParseException {
        if (i == 73) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOFInValue();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            i = bArr[i2];
            if (i == 78) {
                String str = z ? "-INF" : "+INF";
                _matchToken(str, 3);
                if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return resetAsNaN(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                _reportError("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == 110) {
                String str2 = z ? "-Infinity" : "+Infinity";
                _matchToken(str2, 3);
                if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return resetAsNaN(str2, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                _reportError("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    public JsonToken _handleUnexpectedValue(int i) throws JsonParseException {
        if (i != 39) {
            if (i == 43) {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    _reportInvalidEOFInValue();
                }
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                return _handleInvalidNumberStart(bArr[i2] & 255, false);
            }
            if (i == 78) {
                _matchToken("NaN", 1);
                if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return resetAsNaN("NaN", Double.NaN);
                }
                _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        } else if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return _handleApostropheValue();
        }
        _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    public Name _handleUnusualFieldName(int i) throws JsonParseException {
        if (i == 39 && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return _parseApostropheFieldName();
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        }
        int[] inputCodeUtf8JsNames = CharTypes.getInputCodeUtf8JsNames();
        if (inputCodeUtf8JsNames[i] != 0) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArrGrowArrayBy = this._quadBuffer;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i2 < 4) {
                i2++;
                i |= i5 << 8;
            } else {
                if (i4 >= iArrGrowArrayBy.length) {
                    iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                    this._quadBuffer = iArrGrowArrayBy;
                }
                iArrGrowArrayBy[i4] = i5;
                i4++;
                i2 = 1;
            }
            i5 = i;
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in field name");
            }
            byte[] bArr = this._inputBuffer;
            int i6 = this._inputPtr;
            i = bArr[i6] & 255;
            if (inputCodeUtf8JsNames[i] != 0) {
                break;
            }
            this._inputPtr = i6 + 1;
        }
        if (i2 > 0) {
            if (i4 >= iArrGrowArrayBy.length) {
                iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                this._quadBuffer = iArrGrowArrayBy;
            }
            iArrGrowArrayBy[i4] = i5;
            i4++;
        }
        Name nameFindName = this._symbols.findName(iArrGrowArrayBy, i4);
        return nameFindName == null ? addName(iArrGrowArrayBy, i4, i2) : nameFindName;
    }

    public boolean _loadToHaveAtLeast(int i) throws IOException {
        if (this._inputStream == null) {
            return false;
        }
        int i2 = this._inputEnd;
        int i4 = this._inputPtr;
        int i5 = i2 - i4;
        if (i5 <= 0 || i4 <= 0) {
            this._inputEnd = 0;
        } else {
            this._currInputProcessed += (long) i4;
            this._currInputRowStart -= i4;
            byte[] bArr = this._inputBuffer;
            System.arraycopy(bArr, i4, bArr, 0, i5);
            this._inputEnd = i5;
        }
        this._inputPtr = 0;
        while (true) {
            int i6 = this._inputEnd;
            if (i6 >= i) {
                return true;
            }
            InputStream inputStream = this._inputStream;
            byte[] bArr2 = this._inputBuffer;
            int i7 = inputStream.read(bArr2, i6, bArr2.length - i6);
            if (i7 < 1) {
                _closeInput();
                if (i7 != 0) {
                    return false;
                }
                throw new IOException(AbstractC0541b.m767i(i5, "InputStream.read() returned 0 characters when trying to read ", " bytes"));
            }
            this._inputEnd += i7;
        }
    }

    public void _matchToken(String str, int i) throws JsonParseException {
        int i2;
        int i4;
        int length = str.length();
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in a value");
            }
            if (this._inputBuffer[this._inputPtr] != str.charAt(i)) {
                _reportInvalidToken(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            i2 = this._inputPtr + 1;
            this._inputPtr = i2;
            i++;
        } while (i < length);
        if ((i2 < this._inputEnd || loadMore()) && (i4 = this._inputBuffer[this._inputPtr] & 255) >= 48 && i4 != 93 && i4 != 125 && Character.isJavaIdentifierPart((char) _decodeCharForError(i4))) {
            this._inputPtr++;
            _reportInvalidToken(str.substring(0, i), "'null', 'true', 'false' or NaN");
        }
    }

    public Name _parseApostropheFieldName() throws JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(": was expecting closing ''' for name");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i_decodeEscaped = bArr[i] & 255;
        if (i_decodeEscaped == 39) {
            return BytesToNameCanonicalizer.getEmptyName();
        }
        int[] iArrGrowArrayBy = this._quadBuffer;
        int[] iArr = sInputCodesLatin1;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i_decodeEscaped != 39) {
            if (i_decodeEscaped != 34 && iArr[i_decodeEscaped] != 0) {
                if (i_decodeEscaped != 92) {
                    _throwUnquotedSpace(i_decodeEscaped, "name");
                } else {
                    i_decodeEscaped = _decodeEscaped();
                }
                if (i_decodeEscaped > 127) {
                    if (i2 >= 4) {
                        if (i4 >= iArrGrowArrayBy.length) {
                            iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                            this._quadBuffer = iArrGrowArrayBy;
                        }
                        iArrGrowArrayBy[i4] = i5;
                        i5 = 0;
                        i4++;
                        i2 = 0;
                    }
                    if (i_decodeEscaped < 2048) {
                        i5 = (i5 << 8) | (i_decodeEscaped >> 6) | 192;
                        i2++;
                    } else {
                        int i6 = (i5 << 8) | (i_decodeEscaped >> 12) | JPEG.APP0;
                        int i7 = i2 + 1;
                        if (i7 >= 4) {
                            if (i4 >= iArrGrowArrayBy.length) {
                                iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                                this._quadBuffer = iArrGrowArrayBy;
                            }
                            iArrGrowArrayBy[i4] = i6;
                            i6 = 0;
                            i4++;
                            i7 = 0;
                        }
                        i5 = (i6 << 8) | ((i_decodeEscaped >> 6) & 63) | 128;
                        i2 = i7 + 1;
                    }
                    i_decodeEscaped = (i_decodeEscaped & 63) | 128;
                }
            }
            if (i2 < 4) {
                i2++;
                i_decodeEscaped |= i5 << 8;
            } else {
                if (i4 >= iArrGrowArrayBy.length) {
                    iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                    this._quadBuffer = iArrGrowArrayBy;
                }
                iArrGrowArrayBy[i4] = i5;
                i4++;
                i2 = 1;
            }
            i5 = i_decodeEscaped;
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in field name");
            }
            byte[] bArr2 = this._inputBuffer;
            int i8 = this._inputPtr;
            this._inputPtr = i8 + 1;
            i_decodeEscaped = bArr2[i8] & 255;
        }
        if (i2 > 0) {
            if (i4 >= iArrGrowArrayBy.length) {
                iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                this._quadBuffer = iArrGrowArrayBy;
            }
            iArrGrowArrayBy[i4] = i5;
            i4++;
        }
        Name nameFindName = this._symbols.findName(iArrGrowArrayBy, i4);
        return nameFindName == null ? addName(iArrGrowArrayBy, i4, i2) : nameFindName;
    }

    public Name _parseFieldName(int i) {
        if (i != 34) {
            return _handleUnusualFieldName(i);
        }
        int i2 = this._inputPtr;
        if (i2 + 9 > this._inputEnd) {
            return slowParseFieldName();
        }
        byte[] bArr = this._inputBuffer;
        int[] iArr = sInputCodesLatin1;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        int i5 = bArr[i2] & 255;
        if (iArr[i5] != 0) {
            return i5 == 34 ? BytesToNameCanonicalizer.getEmptyName() : parseFieldName(0, i5, 0);
        }
        int i6 = i2 + 2;
        this._inputPtr = i6;
        int i7 = bArr[i4] & 255;
        if (iArr[i7] != 0) {
            return i7 == 34 ? findName(i5, 1) : parseFieldName(i5, i7, 1);
        }
        int i8 = i7 | (i5 << 8);
        int i9 = i2 + 3;
        this._inputPtr = i9;
        int i10 = bArr[i6] & 255;
        if (iArr[i10] != 0) {
            return i10 == 34 ? findName(i8, 2) : parseFieldName(i8, i10, 2);
        }
        int i11 = (i8 << 8) | i10;
        int i12 = i2 + 4;
        this._inputPtr = i12;
        int i13 = bArr[i9] & 255;
        if (iArr[i13] != 0) {
            return i13 == 34 ? findName(i11, 3) : parseFieldName(i11, i13, 3);
        }
        int i14 = (i11 << 8) | i13;
        this._inputPtr = i2 + 5;
        int i15 = bArr[i12] & 255;
        if (iArr[i15] != 0) {
            return i15 == 34 ? findName(i14, 4) : parseFieldName(i14, i15, 4);
        }
        this._quad1 = i14;
        return parseMediumFieldName(i15, iArr);
    }

    public int _readBinary(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length - 3;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            int i5 = bArr2[i4] & 255;
            if (i5 > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(i5);
                if (iDecodeBase64Char < 0) {
                    if (i5 == 34) {
                        break;
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, i5, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (i > length) {
                    i2 += i;
                    outputStream.write(bArr, 0, i);
                    i = 0;
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i6 = this._inputPtr;
                this._inputPtr = i6 + 1;
                int i7 = bArr3[i6] & 255;
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(i7);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, i7, 1);
                }
                int i8 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr4 = this._inputBuffer;
                int i9 = this._inputPtr;
                this._inputPtr = i9 + 1;
                int i10 = bArr4[i9] & 255;
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(i10);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (i10 == 34 && !base64Variant.usesPadding()) {
                            bArr[i] = (byte) (i8 >> 4);
                            i++;
                            break;
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, i10, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr5 = this._inputBuffer;
                        int i11 = this._inputPtr;
                        this._inputPtr = i11 + 1;
                        int i12 = bArr5[i11] & 255;
                        if (!base64Variant.usesPaddingChar(i12)) {
                            throw reportInvalidBase64Char(base64Variant, i12, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        bArr[i] = (byte) (i8 >> 4);
                        i++;
                    }
                }
                int i13 = (i8 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr6 = this._inputBuffer;
                int i14 = this._inputPtr;
                this._inputPtr = i14 + 1;
                int i15 = bArr6[i14] & 255;
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(i15);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (i15 == 34 && !base64Variant.usesPadding()) {
                            int i16 = i + 1;
                            bArr[i] = (byte) (i13 >> 10);
                            i += 2;
                            bArr[i16] = (byte) (i13 >> 2);
                            break;
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, i15, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        int i17 = i + 1;
                        bArr[i] = (byte) (i13 >> 10);
                        i += 2;
                        bArr[i17] = (byte) (i13 >> 2);
                    }
                }
                int i18 = (i13 << 6) | iDecodeBase64Char4;
                bArr[i] = (byte) (i18 >> 16);
                int i19 = i + 2;
                bArr[i + 1] = (byte) (i18 >> 8);
                i += 3;
                bArr[i19] = (byte) i18;
            }
        }
        this._tokenIncomplete = false;
        if (i <= 0) {
            return i2;
        }
        int i20 = i2 + i;
        outputStream.write(bArr, 0, i);
        return i20;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() {
        byte[] bArr;
        super._releaseBuffers();
        if (!this._bufferRecyclable || (bArr = this._inputBuffer) == null) {
            return;
        }
        this._inputBuffer = null;
        this._ioContext.releaseReadIOBuffer(bArr);
    }

    public void _reportInvalidChar(int i) throws JsonParseException {
        if (i < 32) {
            _throwInvalidSpace(i);
        }
        _reportInvalidInitial(i);
    }

    public void _reportInvalidInitial(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    public void _reportInvalidOther(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    public void _reportInvalidToken(String str, String str2) throws JsonParseException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c_decodeCharForError = (char) _decodeCharForError(bArr[i]);
            if (!Character.isJavaIdentifierPart(c_decodeCharForError)) {
                break;
            } else {
                sb.append(c_decodeCharForError);
            }
        }
        _reportError("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }

    public void _skipCR() {
        if (this._inputPtr < this._inputEnd || loadMore()) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            if (bArr[i] == 10) {
                this._inputPtr = i + 1;
            }
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    public void _skipLF() {
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    public void _skipString() throws JsonParseException {
        this._tokenIncomplete = false;
        int[] iArr = sInputCodesUtf8;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i >= i2) {
                loadMoreGuaranteed();
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            while (true) {
                if (i >= i2) {
                    this._inputPtr = i;
                    break;
                }
                int i4 = i + 1;
                int i5 = bArr[i] & 255;
                int i6 = iArr[i5];
                if (i6 != 0) {
                    this._inputPtr = i4;
                    if (i5 == 34) {
                        return;
                    }
                    if (i6 == 1) {
                        _decodeEscaped();
                    } else if (i6 == 2) {
                        _skipUtf8_2(i5);
                    } else if (i6 == 3) {
                        _skipUtf8_3(i5);
                    } else if (i6 == 4) {
                        _skipUtf8_4(i5);
                    } else if (i5 < 32) {
                        _throwUnquotedSpace(i5, "string value");
                    } else {
                        _reportInvalidChar(i5);
                    }
                } else {
                    i = i4;
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this._symbols.release();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(base64Variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException e) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), byteArrayBuilder_getByteArrayBuilder, base64Variant);
            this._binaryValue = byteArrayBuilder_getByteArrayBuilder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._inputStream;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return _getText2(jsonToken);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return null;
        }
        int i = C44751.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    return this._currToken.asCharArray();
                }
            } else if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.getTextBuffer();
        }
        if (!this._nameCopied) {
            String currentName = this._parsingContext.getCurrentName();
            int length = currentName.length();
            char[] cArr = this._nameCopyBuffer;
            if (cArr == null) {
                this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
            } else if (cArr.length < length) {
                this._nameCopyBuffer = new char[length];
            }
            currentName.getChars(0, length, this._nameCopyBuffer, 0);
            this._nameCopied = true;
        }
        return this._nameCopyBuffer;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        int i = C44751.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()];
        if (i == 1) {
            return this._parsingContext.getCurrentName().length();
        }
        if (i != 2) {
            if (i != 3 && i != 4) {
                return this._currToken.asCharArray().length;
            }
        } else if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 4) goto L16;
     */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getTextOffset() throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            int i = C44751.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()];
            if (i != 2) {
                if (i != 3) {
                }
            } else if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.getTextOffset();
        }
        return 0;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return super.getValueAsString(null);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public boolean loadMore() throws IOException {
        long j = this._currInputProcessed;
        int i = this._inputEnd;
        this._currInputProcessed = j + ((long) i);
        this._currInputRowStart -= i;
        InputStream inputStream = this._inputStream;
        if (inputStream != null) {
            byte[] bArr = this._inputBuffer;
            int i2 = inputStream.read(bArr, 0, bArr.length);
            if (i2 > 0) {
                this._inputPtr = 0;
                this._inputEnd = i2;
                return true;
            }
            _closeInput();
            if (i2 == 0) {
                throw new IOException(AbstractC2821a.m2223n(new StringBuilder("InputStream.read() returned 0 characters when trying to read "), " bytes", this._inputBuffer.length));
            }
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Boolean nextBooleanValue() {
        if (this._currToken != JsonToken.FIELD_NAME) {
            int i = C44751.$SwitchMap$com$fasterxml$jackson$core$JsonToken[nextToken().ordinal()];
            if (i == 5) {
                return Boolean.TRUE;
            }
            if (i != 6) {
                return null;
            }
            return Boolean.FALSE;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (jsonToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean nextFieldName(SerializableString serializableString) throws JsonParseException {
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return false;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return false;
        }
        long j = this._currInputProcessed;
        int i = this._inputPtr;
        this._tokenInputTotal = (j + ((long) i)) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (i - this._currInputRowStart) - 1;
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i_skipWSOrEnd, '}');
            }
            this._parsingContext = this._parsingContext.getParent();
            this._currToken = JsonToken.END_ARRAY;
            return false;
        }
        if (i_skipWSOrEnd == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i_skipWSOrEnd, PropertyUtils.INDEXED_DELIM2);
            }
            this._parsingContext = this._parsingContext.getParent();
            this._currToken = JsonToken.END_OBJECT;
            return false;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
        }
        if (!this._parsingContext.inObject()) {
            _nextTokenNotInObject(i_skipWSOrEnd);
            return false;
        }
        if (i_skipWSOrEnd == 34) {
            byte[] bArrAsQuotedUTF8 = serializableString.asQuotedUTF8();
            int length = bArrAsQuotedUTF8.length;
            int i2 = this._inputPtr;
            if (i2 + length < this._inputEnd) {
                int i4 = i2 + length;
                if (this._inputBuffer[i4] == 34) {
                    for (int i5 = 0; i5 != length; i5++) {
                        if (bArrAsQuotedUTF8[i5] == this._inputBuffer[i2 + i5]) {
                        }
                    }
                    this._inputPtr = i4 + 1;
                    this._parsingContext.setCurrentName(serializableString.getValue());
                    this._currToken = JsonToken.FIELD_NAME;
                    _isNextTokenNameYes();
                    return true;
                }
            }
        }
        return _isNextTokenNameMaybe(i_skipWSOrEnd, serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int nextIntValue(int i) {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : i;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return i;
        }
        if (jsonToken != JsonToken.START_OBJECT) {
            return i;
        }
        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        return i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long nextLongValue(long j) {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : j;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return j;
        }
        if (jsonToken != JsonToken.START_OBJECT) {
            return j;
        }
        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        return j;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextTextValue() throws JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            if (nextToken() == JsonToken.VALUE_STRING) {
                return getText();
            }
            return null;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonToken nextToken() throws JsonParseException {
        JsonToken numberText;
        this._numTypesValid = 0;
        JsonToken jsonToken = this._currToken;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return _nextAfterName();
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return null;
        }
        long j = this._currInputProcessed;
        int i = this._inputPtr;
        this._tokenInputTotal = (j + ((long) i)) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (i - this._currInputRowStart) - 1;
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i_skipWSOrEnd, '}');
            }
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken3 = JsonToken.END_ARRAY;
            this._currToken = jsonToken3;
            return jsonToken3;
        }
        if (i_skipWSOrEnd == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i_skipWSOrEnd, PropertyUtils.INDEXED_DELIM2);
            }
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken4 = JsonToken.END_OBJECT;
            this._currToken = jsonToken4;
            return jsonToken4;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
        }
        if (!this._parsingContext.inObject()) {
            return _nextTokenNotInObject(i_skipWSOrEnd);
        }
        this._parsingContext.setCurrentName(_parseFieldName(i_skipWSOrEnd).getName());
        this._currToken = jsonToken2;
        int i_skipWS = _skipWS();
        if (i_skipWS != 58) {
            _reportUnexpectedChar(i_skipWS, "was expecting a colon to separate field name and value");
        }
        int i_skipWS2 = _skipWS();
        if (i_skipWS2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return this._currToken;
        }
        if (i_skipWS2 == 45) {
            numberText = parseNumberText(i_skipWS2);
        } else if (i_skipWS2 == 91) {
            numberText = JsonToken.START_ARRAY;
        } else if (i_skipWS2 == 93) {
            _reportUnexpectedChar(i_skipWS2, "expected a value");
            _matchToken("true", 1);
            numberText = JsonToken.VALUE_TRUE;
        } else if (i_skipWS2 == 102) {
            _matchToken("false", 1);
            numberText = JsonToken.VALUE_FALSE;
        } else if (i_skipWS2 == 110) {
            _matchToken("null", 1);
            numberText = JsonToken.VALUE_NULL;
        } else if (i_skipWS2 == 116) {
            _matchToken("true", 1);
            numberText = JsonToken.VALUE_TRUE;
        } else if (i_skipWS2 != 123) {
            if (i_skipWS2 != 125) {
                switch (i_skipWS2) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        numberText = _handleUnexpectedValue(i_skipWS2);
                        break;
                }
            }
            _reportUnexpectedChar(i_skipWS2, "expected a value");
            _matchToken("true", 1);
            numberText = JsonToken.VALUE_TRUE;
        } else {
            numberText = JsonToken.START_OBJECT;
        }
        this._nextToken = numberText;
        return this._currToken;
    }

    public Name parseEscapedFieldName(int[] iArr, int i, int i2, int i4, int i5) throws JsonParseException {
        int[] iArr2 = sInputCodesLatin1;
        while (true) {
            if (iArr2[i4] != 0) {
                if (i4 == 34) {
                    break;
                }
                if (i4 != 92) {
                    _throwUnquotedSpace(i4, "name");
                } else {
                    i4 = _decodeEscaped();
                }
                if (i4 > 127) {
                    int i6 = 0;
                    if (i5 >= 4) {
                        if (i >= iArr.length) {
                            iArr = growArrayBy(iArr, iArr.length);
                            this._quadBuffer = iArr;
                        }
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i5 = 0;
                    }
                    if (i4 < 2048) {
                        i2 = (i2 << 8) | (i4 >> 6) | 192;
                        i5++;
                    } else {
                        int i7 = (i2 << 8) | (i4 >> 12) | JPEG.APP0;
                        int i8 = i5 + 1;
                        if (i8 >= 4) {
                            if (i >= iArr.length) {
                                iArr = growArrayBy(iArr, iArr.length);
                                this._quadBuffer = iArr;
                            }
                            iArr[i] = i7;
                            i++;
                            i8 = 0;
                        } else {
                            i6 = i7;
                        }
                        i2 = (i6 << 8) | ((i4 >> 6) & 63) | 128;
                        i5 = i8 + 1;
                    }
                    i4 = (i4 & 63) | 128;
                }
            }
            if (i5 < 4) {
                i5++;
                i2 = (i2 << 8) | i4;
            } else {
                if (i >= iArr.length) {
                    iArr = growArrayBy(iArr, iArr.length);
                    this._quadBuffer = iArr;
                }
                iArr[i] = i2;
                i2 = i4;
                i++;
                i5 = 1;
            }
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in field name");
            }
            byte[] bArr = this._inputBuffer;
            int i9 = this._inputPtr;
            this._inputPtr = i9 + 1;
            i4 = bArr[i9] & 255;
        }
        if (i5 > 0) {
            if (i >= iArr.length) {
                iArr = growArrayBy(iArr, iArr.length);
                this._quadBuffer = iArr;
            }
            iArr[i] = i2;
            i++;
        }
        Name nameFindName = this._symbols.findName(iArr, i);
        return nameFindName == null ? addName(iArr, i, i5) : nameFindName;
    }

    public Name parseLongFieldName(int i) {
        int[] iArr = sInputCodesLatin1;
        int i2 = i;
        int i4 = 2;
        while (true) {
            int i5 = this._inputEnd;
            int i6 = this._inputPtr;
            if (i5 - i6 < 4) {
                return parseEscapedFieldName(this._quadBuffer, i4, 0, i2, 0);
            }
            byte[] bArr = this._inputBuffer;
            int i7 = i6 + 1;
            this._inputPtr = i7;
            int i8 = bArr[i6] & 255;
            if (iArr[i8] != 0) {
                return i8 == 34 ? findName(this._quadBuffer, i4, i2, 1) : parseEscapedFieldName(this._quadBuffer, i4, i2, i8, 1);
            }
            int i9 = (i2 << 8) | i8;
            int i10 = i6 + 2;
            this._inputPtr = i10;
            int i11 = bArr[i7] & 255;
            if (iArr[i11] != 0) {
                return i11 == 34 ? findName(this._quadBuffer, i4, i9, 2) : parseEscapedFieldName(this._quadBuffer, i4, i9, i11, 2);
            }
            int i12 = (i9 << 8) | i11;
            int i13 = i6 + 3;
            this._inputPtr = i13;
            int i14 = bArr[i10] & 255;
            if (iArr[i14] != 0) {
                return i14 == 34 ? findName(this._quadBuffer, i4, i12, 3) : parseEscapedFieldName(this._quadBuffer, i4, i12, i14, 3);
            }
            int i15 = (i12 << 8) | i14;
            this._inputPtr = i6 + 4;
            int i16 = bArr[i13] & 255;
            if (iArr[i16] != 0) {
                return i16 == 34 ? findName(this._quadBuffer, i4, i15, 4) : parseEscapedFieldName(this._quadBuffer, i4, i15, i16, 4);
            }
            int[] iArr2 = this._quadBuffer;
            if (i4 >= iArr2.length) {
                this._quadBuffer = growArrayBy(iArr2, i4);
            }
            this._quadBuffer[i4] = i15;
            i4++;
            i2 = i16;
        }
    }

    public Name parseMediumFieldName(int i, int[] iArr) {
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        int i4 = i2 + 1;
        this._inputPtr = i4;
        int i5 = bArr[i2] & 255;
        if (iArr[i5] != 0) {
            return i5 == 34 ? findName(this._quad1, i, 1) : parseFieldName(this._quad1, i, i5, 1);
        }
        int i6 = (i << 8) | i5;
        int i7 = i2 + 2;
        this._inputPtr = i7;
        int i8 = bArr[i4] & 255;
        if (iArr[i8] != 0) {
            return i8 == 34 ? findName(this._quad1, i6, 2) : parseFieldName(this._quad1, i6, i8, 2);
        }
        int i9 = (i6 << 8) | i8;
        int i10 = i2 + 3;
        this._inputPtr = i10;
        int i11 = bArr[i7] & 255;
        if (iArr[i11] != 0) {
            return i11 == 34 ? findName(this._quad1, i9, 3) : parseFieldName(this._quad1, i9, i11, 3);
        }
        int i12 = (i9 << 8) | i11;
        this._inputPtr = i2 + 4;
        int i13 = bArr[i10] & 255;
        if (iArr[i13] != 0) {
            return i13 == 34 ? findName(this._quad1, i12, 4) : parseFieldName(this._quad1, i12, i13, 4);
        }
        int[] iArr2 = this._quadBuffer;
        iArr2[0] = this._quad1;
        iArr2[1] = i12;
        return parseLongFieldName(i13);
    }

    public JsonToken parseNumberText(int i) {
        int i2;
        int i4;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i5 = 1;
        int i6 = 0;
        boolean z = i == 45;
        if (z) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            i = bArr[i7] & 255;
            if (i < 48 || i > 57) {
                return _handleInvalidNumberStart(i, true);
            }
            i6 = 1;
        }
        if (i == 48) {
            i = _verifyNoLeadingZeroes();
        }
        int i8 = i6 + 1;
        cArrEmptyAndGetCurrentSegment[i6] = (char) i;
        int length = this._inputPtr + cArrEmptyAndGetCurrentSegment.length;
        int i9 = this._inputEnd;
        if (length > i9) {
            length = i9;
        }
        while (true) {
            i2 = this._inputPtr;
            if (i2 >= length) {
                return _parserNumber2(cArrEmptyAndGetCurrentSegment, i8, z, i5);
            }
            byte[] bArr2 = this._inputBuffer;
            this._inputPtr = i2 + 1;
            i4 = bArr2[i2] & 255;
            if (i4 < 48 || i4 > 57) {
                break;
            }
            i5++;
            cArrEmptyAndGetCurrentSegment[i8] = (char) i4;
            i8++;
        }
        if (i4 == 46 || i4 == 101 || i4 == 69) {
            return _parseFloatText(cArrEmptyAndGetCurrentSegment, i8, i4, z, i5);
        }
        this._inputPtr = i2;
        this._textBuffer.setCurrentLength(i8);
        return resetInt(z, i5);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] binaryValue = getBinaryValue(base64Variant);
            outputStream.write(binaryValue);
            return binaryValue.length;
        }
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            return _readBinary(base64Variant, outputStream, bArrAllocBase64Buffer);
        } finally {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i = this._inputEnd;
        int i2 = this._inputPtr;
        int i4 = i - i2;
        if (i4 < 1) {
            return 0;
        }
        outputStream.write(this._inputBuffer, i2, i4);
        return i4;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    public Name slowParseFieldName() throws JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(": was expecting closing '\"' for name");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & 255;
        return i2 == 34 ? BytesToNameCanonicalizer.getEmptyName() : parseEscapedFieldName(this._quadBuffer, 0, 0, i2, 0);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return CoreVersion.instance.version();
    }

    private Name parseFieldName(int i, int i2, int i4, int i5) {
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        return parseEscapedFieldName(iArr, 1, i2, i4, i5);
    }

    public void _reportInvalidOther(int i, int i2) throws JsonParseException {
        this._inputPtr = i2;
        _reportInvalidOther(i);
    }

    private Name findName(int i, int i2, int i4) {
        Name nameFindName = this._symbols.findName(i, i2);
        if (nameFindName != null) {
            return nameFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i2;
        return addName(iArr, 2, i4);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws JsonParseException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        return super.getValueAsString(str);
    }

    private Name findName(int[] iArr, int i, int i2, int i4) {
        if (i >= iArr.length) {
            iArr = growArrayBy(iArr, iArr.length);
            this._quadBuffer = iArr;
        }
        int i5 = i + 1;
        iArr[i] = i2;
        Name nameFindName = this._symbols.findName(iArr, i5);
        return nameFindName == null ? addName(iArr, i5, i4) : nameFindName;
    }
}
