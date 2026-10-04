package com.fasterxml.jackson.core.json;

import androidx.appcompat.widget.AbstractC0541b;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.p128io.IOContext;
import com.fasterxml.jackson.core.p128io.MergedStream;
import com.fasterxml.jackson.core.p128io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ByteSourceJsonBootstrapper {
    static final byte UTF8_BOM_1 = -17;
    static final byte UTF8_BOM_2 = -69;
    static final byte UTF8_BOM_3 = -65;
    protected boolean _bigEndian;
    private final boolean _bufferRecyclable;
    protected int _bytesPerChar;
    protected final IOContext _context;
    protected final InputStream _in;
    protected final byte[] _inputBuffer;
    private int _inputEnd;
    protected int _inputProcessed;
    private int _inputPtr;

    /* JADX INFO: renamed from: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C44731 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonEncoding;

        static {
            int[] iArr = new int[JsonEncoding.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonEncoding = iArr;
            try {
                iArr[JsonEncoding.UTF32_BE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonEncoding[JsonEncoding.UTF32_LE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonEncoding[JsonEncoding.UTF16_BE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonEncoding[JsonEncoding.UTF16_LE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonEncoding[JsonEncoding.UTF8.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this._bigEndian = true;
        this._bytesPerChar = 0;
        this._context = iOContext;
        this._in = inputStream;
        this._inputBuffer = iOContext.allocReadIOBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._inputProcessed = 0;
        this._bufferRecyclable = true;
    }

    private boolean checkUTF16(int i) {
        if ((65280 & i) == 0) {
            this._bigEndian = true;
        } else {
            if ((i & 255) != 0) {
                return false;
            }
            this._bigEndian = false;
        }
        this._bytesPerChar = 2;
        return true;
    }

    private boolean checkUTF32(int i) throws CharConversionException {
        if ((i >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & i) == 0) {
            this._bigEndian = false;
        } else if (((-16711681) & i) == 0) {
            reportWeirdUCS4("3412");
        } else {
            if ((i & VUtilString.MAGENTA) != 0) {
                return false;
            }
            reportWeirdUCS4("2143");
        }
        this._bytesPerChar = 4;
        return true;
    }

    private boolean handleBOM(int i) throws CharConversionException {
        if (i == -16842752) {
            reportWeirdUCS4("3412");
        } else {
            if (i == -131072) {
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                this._bigEndian = false;
                return true;
            }
            if (i == 65279) {
                this._bigEndian = true;
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                return true;
            }
            if (i == 65534) {
                reportWeirdUCS4("2143");
                reportWeirdUCS4("3412");
            }
        }
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = true;
            return true;
        }
        if (i2 == 65534) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = false;
            return true;
        }
        if ((i >>> 8) != 15711167) {
            return false;
        }
        this._inputPtr += 3;
        this._bytesPerChar = 1;
        this._bigEndian = true;
        return true;
    }

    public static MatchStrength hasJSONFormat(InputAccessor inputAccessor) {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte bNextByte = inputAccessor.nextByte();
        if (bNextByte == -17) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            bNextByte = inputAccessor.nextByte();
        }
        int iSkipSpace = skipSpace(inputAccessor, bNextByte);
        if (iSkipSpace < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (iSkipSpace == 123) {
            int iSkipSpace2 = skipSpace(inputAccessor);
            return iSkipSpace2 < 0 ? MatchStrength.INCONCLUSIVE : (iSkipSpace2 == 34 || iSkipSpace2 == 125) ? MatchStrength.SOLID_MATCH : MatchStrength.NO_MATCH;
        }
        if (iSkipSpace == 91) {
            int iSkipSpace3 = skipSpace(inputAccessor);
            return iSkipSpace3 < 0 ? MatchStrength.INCONCLUSIVE : (iSkipSpace3 == 93 || iSkipSpace3 == 91) ? MatchStrength.SOLID_MATCH : MatchStrength.SOLID_MATCH;
        }
        MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
        if (iSkipSpace != 34 && (iSkipSpace > 57 || iSkipSpace < 48)) {
            if (iSkipSpace != 45) {
                return iSkipSpace == 110 ? tryMatch(inputAccessor, "ull", matchStrength) : iSkipSpace == 116 ? tryMatch(inputAccessor, "rue", matchStrength) : iSkipSpace == 102 ? tryMatch(inputAccessor, "alse", matchStrength) : MatchStrength.NO_MATCH;
            }
            int iSkipSpace4 = skipSpace(inputAccessor);
            if (iSkipSpace4 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (iSkipSpace4 > 57 || iSkipSpace4 < 48) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    private void reportWeirdUCS4(String str) throws CharConversionException {
        throw new CharConversionException(AbstractC0541b.m773o("Unsupported UCS-4 endianness (", str, ") detected"));
    }

    private static int skipSpace(InputAccessor inputAccessor) {
        if (inputAccessor.hasMoreBytes()) {
            return skipSpace(inputAccessor, inputAccessor.nextByte());
        }
        return -1;
    }

    private static MatchStrength tryMatch(InputAccessor inputAccessor, String str, MatchStrength matchStrength) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != str.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    public JsonParser constructParser(int i, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2) {
        if (detectEncoding() != JsonEncoding.UTF8 || !z) {
            return new ReaderBasedJsonParser(this._context, i, constructReader(), objectCodec, charsToNameCanonicalizer.makeChild(z, z2));
        }
        return new UTF8StreamJsonParser(this._context, i, this._in, objectCodec, bytesToNameCanonicalizer.makeChild(z, z2), this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }

    public Reader constructReader() {
        JsonEncoding encoding = this._context.getEncoding();
        int i = C44731.$SwitchMap$com$fasterxml$jackson$core$JsonEncoding[encoding.ordinal()];
        if (i == 1 || i == 2) {
            IOContext iOContext = this._context;
            return new UTF32Reader(iOContext, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, iOContext.getEncoding().isBigEndian());
        }
        if (i != 3 && i != 4 && i != 5) {
            throw new RuntimeException(IErrors.ERROR_MESSAGE_SMP_0401);
        }
        InputStream mergedStream = this._in;
        if (mergedStream == null) {
            mergedStream = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
        } else if (this._inputPtr < this._inputEnd) {
            mergedStream = new MergedStream(this._context, mergedStream, this._inputBuffer, this._inputPtr, this._inputEnd);
        }
        return new InputStreamReader(mergedStream, encoding.getJavaName());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonEncoding detectEncoding() {
        JsonEncoding jsonEncoding;
        if (ensureLoaded(4)) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            int i2 = (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            if (handleBOM(i2) || checkUTF32(i2) || checkUTF16(i2 >>> 16)) {
                int i4 = this._bytesPerChar;
                if (i4 == 1) {
                    jsonEncoding = JsonEncoding.UTF8;
                } else if (i4 == 2) {
                    jsonEncoding = this._bigEndian ? JsonEncoding.UTF16_BE : JsonEncoding.UTF16_LE;
                } else {
                    if (i4 != 4) {
                        throw new RuntimeException(IErrors.ERROR_MESSAGE_SMP_0401);
                    }
                    jsonEncoding = this._bigEndian ? JsonEncoding.UTF32_BE : JsonEncoding.UTF32_LE;
                }
            } else {
                jsonEncoding = JsonEncoding.UTF8;
            }
        } else {
            if (ensureLoaded(2)) {
                byte[] bArr2 = this._inputBuffer;
                int i5 = this._inputPtr;
                if (checkUTF16((bArr2[i5 + 1] & 255) | ((bArr2[i5] & 255) << 8))) {
                }
            }
            jsonEncoding = JsonEncoding.UTF8;
        }
        this._context.setEncoding(jsonEncoding);
        return jsonEncoding;
    }

    public boolean ensureLoaded(int i) throws IOException {
        int i2;
        int i4 = this._inputEnd - this._inputPtr;
        while (i4 < i) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                i2 = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i5 = this._inputEnd;
                i2 = inputStream.read(bArr, i5, bArr.length - i5);
            }
            if (i2 < 1) {
                return false;
            }
            this._inputEnd += i2;
            i4 += i2;
        }
        return true;
    }

    private static int skipSpace(InputAccessor inputAccessor, byte b) {
        while (true) {
            int i = b & 255;
            if (i != 32 && i != 13 && i != 10 && i != 9) {
                return i;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return -1;
            }
            b = inputAccessor.nextByte();
        }
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, byte[] bArr, int i, int i2) {
        this._bigEndian = true;
        this._bytesPerChar = 0;
        this._context = iOContext;
        this._in = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputEnd = i2 + i;
        this._inputProcessed = -i;
        this._bufferRecyclable = false;
    }
}
