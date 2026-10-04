package com.fasterxml.jackson.core.base;

import androidx.appcompat.widget.AbstractC0541b;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.p128io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.VersionUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ParserMinimalBase extends JsonParser {
    protected static final int INT_APOSTROPHE = 39;
    protected static final int INT_ASTERISK = 42;
    protected static final int INT_BACKSLASH = 92;
    protected static final int INT_COLON = 58;
    protected static final int INT_COMMA = 44;
    protected static final int INT_CR = 13;
    protected static final int INT_LBRACKET = 91;
    protected static final int INT_LCURLY = 123;
    protected static final int INT_LF = 10;
    protected static final int INT_QUOTE = 34;
    protected static final int INT_RBRACKET = 93;
    protected static final int INT_RCURLY = 125;
    protected static final int INT_SLASH = 47;
    protected static final int INT_SPACE = 32;
    protected static final int INT_TAB = 9;
    protected static final int INT_b = 98;
    protected static final int INT_f = 102;
    protected static final int INT_n = 110;
    protected static final int INT_r = 114;
    protected static final int INT_t = 116;
    protected static final int INT_u = 117;
    protected JsonToken _currToken;
    protected JsonToken _lastClearedToken;

    /* JADX INFO: renamed from: com.fasterxml.jackson.core.base.ParserMinimalBase$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C44721 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public ParserMinimalBase() {
    }

    public static final String _getCharDesc(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return AbstractC0541b.m767i(i, "(CTRL-CHAR, code ", ")");
        }
        if (i <= 255) {
            return "'" + c + "' (code " + i + ")";
        }
        return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
    }

    public final JsonParseException _constructError(String str, Throwable th) {
        return new JsonParseException(str, getCurrentLocation(), th);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r5 >= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        _reportInvalidBase64(r14, r4, 0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r3 < r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r4 = r2 + 2;
        r3 = r12.charAt(r3);
        r7 = r14.decodeBase64Char(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r7 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        _reportInvalidBase64(r14, r3, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        r3 = (r5 << 6) | r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r4 < r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r14.usesPadding() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        r13.append(r3 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        r5 = r2 + 3;
        r4 = r12.charAt(r4);
        r7 = r14.decodeBase64Char(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        if (r7 >= 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r7 == (-2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        _reportInvalidBase64(r14, r4, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r5 < r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        r2 = r2 + 4;
        r4 = r12.charAt(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r14.usesPaddingChar(r4) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        _reportInvalidBase64(r14, r4, 3, "expected padding character '" + r14.getPaddingChar() + "'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        r13.append(r3 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
    
        r3 = (r3 << 6) | r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        if (r5 < r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
    
        if (r14.usesPadding() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
    
        r13.appendTwoBytes(r3 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a0, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
    
        r2 = r2 + 4;
        r4 = r12.charAt(r5);
        r5 = r14.decodeBase64Char(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
    
        if (r5 >= 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
    
        if (r5 == (-2)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
    
        _reportInvalidBase64(r14, r4, 3, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b4, code lost:
    
        r13.appendTwoBytes(r3 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        r13.appendThreeBytes((r3 << 6) | r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        r5 = r14.decodeBase64Char(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void _decodeBase64(String str, ByteArrayBuilder byteArrayBuilder, Base64Variant base64Variant) throws JsonParseException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                char cCharAt = str.charAt(i);
                if (i2 >= length) {
                    return;
                }
                if (cCharAt > ' ') {
                    break;
                } else {
                    i = i2;
                }
            }
        }
    }

    public abstract void _handleEOF();

    public char _handleUnrecognizedCharacterEscape(char c) throws JsonParseException {
        if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c == '\'' && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
            return c;
        }
        _reportError("Unrecognized character escape " + _getCharDesc(c));
        return c;
    }

    public void _reportBase64EOF() throws JsonParseException {
        throw _constructError("Unexpected end-of-String in base64 content");
    }

    public final void _reportError(String str) throws JsonParseException {
        throw _constructError(str);
    }

    public void _reportInvalidBase64(Base64Variant base64Variant, char c, int i, String str) throws JsonParseException {
        String strM757C;
        if (c <= ' ') {
            strM757C = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.usesPaddingChar(c)) {
            strM757C = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            strM757C = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            strM757C = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            strM757C = AbstractC0541b.m757C(strM757C, ": ", str);
        }
        throw _constructError(strM757C);
    }

    public void _reportInvalidEOF() throws JsonParseException {
        _reportInvalidEOF(" in " + this._currToken);
    }

    public void _reportInvalidEOFInValue() throws JsonParseException {
        _reportInvalidEOF(" in a value");
    }

    public void _reportUnexpectedChar(int i, String str) throws JsonParseException {
        String strM757C = "Unexpected character (" + _getCharDesc(i) + ")";
        if (str != null) {
            strM757C = AbstractC0541b.m757C(strM757C, ": ", str);
        }
        _reportError(strM757C);
    }

    public final void _throwInternal() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    public void _throwInvalidSpace(int i) throws JsonParseException {
        _reportError("Illegal character (" + _getCharDesc((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    public void _throwUnquotedSpace(int i, String str) throws JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            _reportError("Illegal unquoted character (" + _getCharDesc((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    public final void _wrapError(String str, Throwable th) throws JsonParseException {
        throw _constructError(str, th);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            this._lastClearedToken = jsonToken;
            this._currToken = null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract byte[] getBinaryValue(Base64Variant base64Variant);

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String getCurrentName();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this._lastClearedToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonStreamContext getParsingContext();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String getText();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract char[] getTextCharacters();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int getTextLength();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int getTextOffset();

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean(boolean z) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            switch (C44721.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
                case 5:
                    return getIntValue() != 0;
                case 6:
                    return true;
                case 7:
                case 8:
                    return false;
                case 9:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Boolean) {
                        return ((Boolean) embeddedObject).booleanValue();
                    }
                case 10:
                    if ("true".equals(getText().trim())) {
                        return true;
                    }
                default:
                    return z;
            }
        }
        return z;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble(double d) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return d;
        }
        switch (C44721.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
            case 5:
            case 11:
                return getDoubleValue();
            case 6:
                return 1.0d;
            case 7:
            case 8:
                return 0.0d;
            case 9:
                Object embeddedObject = getEmbeddedObject();
                return embeddedObject instanceof Number ? ((Number) embeddedObject).doubleValue() : d;
            case 10:
                return NumberInput.parseAsDouble(getText(), d);
            default:
                return d;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return i;
        }
        switch (C44721.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
            case 5:
            case 11:
                return getIntValue();
            case 6:
                return 1;
            case 7:
            case 8:
                return 0;
            case 9:
                Object embeddedObject = getEmbeddedObject();
                return embeddedObject instanceof Number ? ((Number) embeddedObject).intValue() : i;
            case 10:
                return NumberInput.parseAsInt(getText(), i);
            default:
                return i;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return j;
        }
        switch (C44721.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
            case 5:
            case 11:
                return getLongValue();
            case 6:
                return 1L;
            case 7:
            case 8:
                return 0L;
            case 9:
                Object embeddedObject = getEmbeddedObject();
                return embeddedObject instanceof Number ? ((Number) embeddedObject).longValue() : j;
            case 10:
                return NumberInput.parseAsLong(getText(), j);
            default:
                return j;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) {
        JsonToken jsonToken = this._currToken;
        return (jsonToken == JsonToken.VALUE_STRING || !(jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue())) ? getText() : str;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract boolean hasTextCharacters();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract boolean isClosed();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonToken nextToken();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() {
        JsonToken jsonTokenNextToken = nextToken();
        return jsonTokenNextToken == JsonToken.FIELD_NAME ? nextToken() : jsonTokenNextToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract void overrideCurrentName(String str);

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken jsonTokenNextToken = nextToken();
                if (jsonTokenNextToken == null) {
                    _handleEOF();
                    return this;
                }
                int i2 = C44721.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonTokenNextToken.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    i++;
                } else if (i2 == 3 || i2 == 4) {
                    i--;
                    if (i == 0) {
                        break;
                    }
                }
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public ParserMinimalBase(int i) {
        super(i);
    }

    public void _reportInvalidEOF(String str) throws JsonParseException {
        _reportError("Unexpected end-of-input" + str);
    }
}
