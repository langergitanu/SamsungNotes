package com.samsung.android.sdk.composer.document.sdoc.textspan;

import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.SpenError;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0001MB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\tJ(\u00107\u001a\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0016\u0010:\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003J\u0018\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0018J\u000e\u0010=\u001a\u00020,2\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u00182\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010?\u001a\u0002082\u0006\u0010+\u001a\u00020,H\u0007J\u0010\u0010@\u001a\u00020,2\b\u0010A\u001a\u0004\u0018\u00010\u0000J\u0010\u0010B\u001a\u00020,2\b\u0010C\u001a\u0004\u0018\u00010\u0000J\u000e\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020,2\u0006\u0010G\u001a\u00020HJ\u001a\u0010J\u001a\u0002082\u0006\u0010G\u001a\u00020H2\b\u0010K\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\u00182\u0006\u0010G\u001a\u00020HH\u0002R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0005R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u0005R&\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u0005R$\u0010(\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u0005R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u0005R&\u00104\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u0005R\u0011\u0010D\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bE\u0010\f¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/textspan/SpenTextSpan;", "", "type", "", "<init>", "(I)V", "startPosition", "endPosition", "expansionType", "(IIII)V", "value", "getType", "()I", "start", "getStart", "end", "getEnd", "expansion", "getExpansion", "setExpansion", "mArg1", "mArg2", "mCustomData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "color", "foregroundColor", "getForegroundColor", "setForegroundColor", "size", "", "fontSize", "getFontSize", "()F", "setFontSize", "(F)V", "hypertextType", "getHypertextType", "setHypertextType", "dateTimeType", "getDateTimeType", "setDateTimeType", "enable", "", "isPropertyEnabled", "()Z", "setPropertyEnabled", "(Z)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "composingBackgroundColor", "getComposingBackgroundColor", "setComposingBackgroundColor", "init", "", "startPosistion", "setPosition", "setCustomData", "key", "hasCustomData", "getCustomData", "setProrpertyEnabled", "isSame", "span", "copy", "source", "binarySize", "getBinarySize", "writeBinary", "raf", "Ljava/io/RandomAccessFile;", "readBinary", "writeString", "data", "readString", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextSpan {
    public static final int DATETIME_TYPE_ENGLISH_DATE = 5;
    public static final int DATETIME_TYPE_ENGLISH_DATE_TIME = 7;
    public static final int DATETIME_TYPE_ENGLISH_KEYWORD_DATE = 9;
    public static final int DATETIME_TYPE_ENGLISH_KEYWORD_TIME = 10;
    public static final int DATETIME_TYPE_ENGLISH_TIME = 6;
    public static final int DATETIME_TYPE_ENGLISH_TIME_DATE = 8;
    public static final int DATETIME_TYPE_KOREAN_DATE = 11;
    public static final int DATETIME_TYPE_KOREAN_DATE_TIME = 13;
    public static final int DATETIME_TYPE_KOREAN_KEYWORD_DATE = 15;
    public static final int DATETIME_TYPE_KOREAN_KEYWORD_TIME = 16;
    public static final int DATETIME_TYPE_KOREAN_TIME = 12;
    public static final int DATETIME_TYPE_KOREAN_TIME_DATE = 14;
    public static final int DATETIME_TYPE_NONE = 0;
    public static final int DATETIME_TYPE_STANDARD_DATE = 1;
    public static final int DATETIME_TYPE_STANDARD_DATE_TIME = 3;
    public static final int DATETIME_TYPE_STANDARD_TIME = 2;
    public static final int DATETIME_TYPE_STANDARD_TIME_DATE = 4;
    public static final int DATETIME_TYPE_WESTERN_DATE = 17;
    public static final int DATETIME_TYPE_WESTERN_DATE_TIME = 18;
    public static final int DATETIME_TYPE_WESTERN_KEYWORD_DATE = 20;
    public static final int DATETIME_TYPE_WESTERN_KEYWORD_TIME = 21;
    public static final int DATETIME_TYPE_WESTERN_TIME_DATE = 19;
    public static final int HYPERTEXT_TYPE_ADDRESS = 4;
    public static final int HYPERTEXT_TYPE_DATETIME = 5;
    public static final int HYPERTEXT_TYPE_EMAIL = 2;
    public static final int HYPERTEXT_TYPE_FORMULA = 6;
    public static final int HYPERTEXT_TYPE_NONE = 0;
    public static final int HYPERTEXT_TYPE_PHONE = 3;
    public static final int HYPERTEXT_TYPE_URL = 1;
    public static final int SPAN_EXCLUSIVE_EXCLUSIVE = 2;
    public static final int SPAN_EXCLUSIVE_INCLUSIVE = 3;
    public static final int SPAN_INCLUSIVE_EXCLUSIVE = 0;
    public static final int SPAN_INCLUSIVE_INCLUSIVE = 1;
    private static final int SPAN_VERSION = 1;
    public static final int TYPE_BACKGROUND_COLOR = 19;
    public static final int TYPE_BOLD = 11;
    public static final int TYPE_COMPOSING = 18;
    public static final int TYPE_COMPOSING_BACKGROUND_COLOR = 17;
    public static final int TYPE_COMPOSING_TAG = 20;
    public static final int TYPE_FONT_SIZE = 15;
    public static final int TYPE_FOREGROUND_COLOR = 14;
    public static final int TYPE_HYPERTEXT = 16;
    public static final int TYPE_ITALIC = 12;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_UNDERLINE = 13;
    private int end;
    private float fontSize;
    private int mArg1;
    private int mArg2;
    private int start;
    private int type;
    private int expansion = 3;

    @Nullable
    private HashMap<Integer, String> mCustomData = new HashMap<>();

    public SpenTextSpan(int i) {
        init(i, 0, 0, 3);
    }

    private final void init(int type, int startPosistion, int endPosition, int expansionType) {
        if (type < 11 || type > 20) {
            SpenError.ThrowUncheckedException(3);
        }
        if (expansionType < 0 || expansionType > 3) {
            SpenError.ThrowUncheckedException(3);
        }
        this.type = type;
        this.start = startPosistion;
        this.end = endPosition;
        setExpansion(expansionType);
        if (type != 18 && type != 20) {
            switch (type) {
            }
            return;
        }
        this.mArg1 = 1;
    }

    private final String readString(RandomAccessFile raf) throws IOException {
        StringBuilder sb;
        int i = raf.readInt();
        if (i > 0) {
            byte[] bArr = new byte[1026];
            sb = new StringBuilder(i);
            int i2 = i * 2;
            while (i2 > 1024) {
                int i4 = raf.read(bArr, 0, 1024);
                i2 -= 1024;
                if (((bArr[1022] & 255) >> 2) == 54 && i2 >= 2) {
                    int i5 = raf.read(bArr, 1024, 2);
                    i4 += i5;
                    i2 -= i5;
                }
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
                sb.append(new String(bArr, 0, i4, UTF_16BE));
            }
            if (i2 > 0) {
                int i6 = raf.read(bArr, 0, i2);
                Charset UTF_16BE2 = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE2, "UTF_16BE");
                sb.append(new String(bArr, 0, i6, UTF_16BE2));
            }
        } else {
            sb = null;
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    private final void writeString(RandomAccessFile raf, String data) throws IOException {
        int length = (data == null || data.length() <= 0) ? 0 : data.length();
        raf.writeInt(length);
        if (length > 0) {
            raf.writeChars(data);
        }
    }

    public final boolean copy(@Nullable SpenTextSpan source) {
        if (source == null || source.type != this.type) {
            return false;
        }
        setPosition(source.start, source.end);
        setExpansion(source.expansion);
        switch (source.type) {
            case 11:
            case 12:
            case 13:
            case 18:
            case 20:
                setPropertyEnabled(source.isPropertyEnabled());
                return true;
            case 14:
                setForegroundColor(source.getForegroundColor());
                return true;
            case 15:
                setFontSize(source.getFontSize());
                return true;
            case 16:
                setHypertextType(source.getHypertextType());
                setDateTimeType(source.getDateTimeType());
                return true;
            case 17:
                setComposingBackgroundColor(source.getComposingBackgroundColor());
                return true;
            case 19:
                setBackgroundColor(source.getBackgroundColor());
                return true;
            default:
                return false;
        }
    }

    @ColorInt
    public final int getBackgroundColor() {
        if (this.type != 19) {
            return -16777216;
        }
        return this.mArg1;
    }

    public final int getBinarySize() {
        HashMap<Integer, String> map = this.mCustomData;
        Intrinsics.checkNotNull(map);
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        int length = 36;
        while (it.hasNext()) {
            String value = it.next().getValue();
            Intrinsics.checkNotNull(value);
            length = length + 8 + (value.length() * 2);
        }
        return length;
    }

    @ColorInt
    public final int getComposingBackgroundColor() {
        if (this.type != 17) {
            return 0;
        }
        return this.mArg1;
    }

    @Nullable
    public final String getCustomData(int key) {
        HashMap<Integer, String> map = this.mCustomData;
        Intrinsics.checkNotNull(map);
        return map.get(Integer.valueOf(key));
    }

    public final int getDateTimeType() {
        if (this.type == 16 && this.mArg1 == 5) {
            return this.mArg2;
        }
        return 0;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getExpansion() {
        return this.expansion;
    }

    public final float getFontSize() {
        if (this.type != 15) {
            return 0.0f;
        }
        return this.fontSize;
    }

    @ColorInt
    public final int getForegroundColor() {
        if (this.type != 14) {
            return -16777216;
        }
        return this.mArg1;
    }

    public final int getHypertextType() {
        if (this.type != 16) {
            return 0;
        }
        return this.mArg1;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean hasCustomData(int key) {
        HashMap<Integer, String> map = this.mCustomData;
        Intrinsics.checkNotNull(map);
        return map.containsKey(Integer.valueOf(key));
    }

    public final boolean isPropertyEnabled() {
        int i = this.type;
        return ((i == 11 || i == 12 || i == 13 || i == 18 || i == 20) && this.mArg1 == 0) ? false : true;
    }

    public final boolean isSame(@Nullable SpenTextSpan span) {
        int i;
        if (span != null && (i = span.type) == this.type && span.start == this.start && span.end == this.end) {
            switch (i) {
                case 11:
                case 12:
                case 13:
                case 18:
                case 20:
                    if (span.isPropertyEnabled() == isPropertyEnabled()) {
                        return true;
                    }
                    break;
                case 14:
                    if (span.getForegroundColor() == getForegroundColor()) {
                        return true;
                    }
                    break;
                case 15:
                    if (span.getFontSize() == getFontSize()) {
                        return true;
                    }
                    break;
                case 16:
                    if (span.getHypertextType() == getHypertextType() && span.getDateTimeType() == getDateTimeType()) {
                        return true;
                    }
                    break;
                case 17:
                    if (span.getComposingBackgroundColor() == getComposingBackgroundColor()) {
                        return true;
                    }
                    break;
                case 19:
                    if (span.getBackgroundColor() == getBackgroundColor()) {
                        return true;
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }

    public final boolean readBinary(@NotNull RandomAccessFile raf) throws IOException {
        Intrinsics.checkNotNullParameter(raf, "raf");
        this.start = raf.readInt();
        this.end = raf.readInt();
        setExpansion(raf.readInt());
        int i = this.type;
        int i2 = this.start;
        int i4 = this.end;
        int i5 = this.expansion;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "readBinary() type : ", " / start : ", " / end : ");
        sbM1173s.append(i4);
        sbM1173s.append(" / extension : ");
        sbM1173s.append(i5);
        Log.d("SpenTextSpan", sbM1173s.toString());
        raf.readInt();
        if (this.type == 15) {
            setFontSize(raf.readFloat());
        } else {
            this.mArg1 = raf.readInt();
        }
        this.mArg2 = raf.readInt();
        Log.d("SpenTextSpan", "readBinary() FontSize : " + getFontSize() + " / mArg1 : " + this.mArg1 + " / mArg2 : " + this.mArg2);
        int i6 = raf.readInt();
        if (i6 <= 0) {
            return true;
        }
        if (this.mCustomData == null) {
            this.mCustomData = new HashMap<>();
        }
        HashMap<Integer, String> map = this.mCustomData;
        Intrinsics.checkNotNull(map);
        map.clear();
        Log.d("SpenTextSpan", "readBinary() customSize : " + i6);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = raf.readInt();
            String string = readString(raf);
            Integer numValueOf = Integer.valueOf(i8);
            HashMap<Integer, String> map2 = this.mCustomData;
            Intrinsics.checkNotNull(map2);
            map2.put(numValueOf, string);
        }
        return true;
    }

    public final void setBackgroundColor(@ColorInt int i) {
        if (this.type == 19) {
            this.mArg1 = i;
        }
    }

    public final void setComposingBackgroundColor(@ColorInt int i) {
        if (this.type == 17) {
            this.mArg1 = i;
        }
    }

    public final void setCustomData(int key, @Nullable String value) {
        Integer numValueOf = Integer.valueOf(key);
        HashMap<Integer, String> map = this.mCustomData;
        Intrinsics.checkNotNull(map);
        map.put(numValueOf, value);
    }

    public final void setDateTimeType(int i) {
        if (i < 0 || i > 21) {
            SpenError.ThrowUncheckedException(3);
        }
        if (this.type == 16 && this.mArg1 == 5) {
            this.mArg2 = i;
        }
    }

    public final void setExpansion(int i) {
        if (i < 0 || i > 3) {
            SpenError.ThrowUncheckedException(3);
        }
        this.expansion = i;
    }

    public final void setFontSize(float f) {
        if (f <= 0.0f) {
            SpenError.ThrowUncheckedException(3);
        } else if (this.type == 15) {
            this.fontSize = f;
        }
    }

    public final void setForegroundColor(@ColorInt int i) {
        if (this.type == 14) {
            this.mArg1 = i;
        }
    }

    public final void setHypertextType(int i) {
        if (i < 0 || i > 6) {
            SpenError.ThrowUncheckedException(3);
        }
        if (this.type == 16) {
            this.mArg1 = i;
        }
    }

    public final void setPosition(int startPosition, int endPosition) {
        if (startPosition > endPosition) {
            SpenError.ThrowUncheckedException(3);
        }
        this.start = startPosition;
        this.end = endPosition;
    }

    public final void setPropertyEnabled(boolean z) {
        int i = this.type;
        if (i == 11 || i == 12 || i == 13 || i == 18 || i == 20) {
            this.mArg1 = z ? 1 : 0;
        }
    }

    @Deprecated(message = "Please use [isPropertyEnabled] instead")
    public final void setProrpertyEnabled(boolean enable) {
        int i = this.type;
        if (i == 11 || i == 12 || i == 13 || i == 18 || i == 20) {
            this.mArg1 = enable ? 1 : 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean writeBinary(@NotNull RandomAccessFile raf) throws IOException {
        int size;
        Intrinsics.checkNotNullParameter(raf, "raf");
        raf.writeInt(this.type);
        raf.writeInt(this.start);
        raf.writeInt(this.end);
        raf.writeInt(this.expansion);
        raf.writeInt(1);
        int i = this.type;
        int i2 = this.start;
        int i4 = this.end;
        int i5 = this.expansion;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "writeBinary() type : ", " / start : ", " / end : ");
        sbM1173s.append(i4);
        sbM1173s.append(" / extension : ");
        sbM1173s.append(i5);
        Log.d("SpenTextSpan", sbM1173s.toString());
        if (this.type == 15) {
            raf.writeFloat(getFontSize());
        } else {
            raf.writeInt(this.mArg1);
        }
        raf.writeInt(this.mArg2);
        Log.d("SpenTextSpan", "writeBinary() mFontSize : " + getFontSize() + " / mArg1 : " + this.mArg1 + " / mArg2 : " + this.mArg2);
        HashMap<Integer, String> map = this.mCustomData;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.size() > 0) {
                HashMap<Integer, String> map2 = this.mCustomData;
                Intrinsics.checkNotNull(map2);
                size = map2.size();
            } else {
                size = 0;
            }
        }
        Log.d("SpenTextSpan", "writeBinary() customSize: " + size);
        raf.writeInt(size);
        HashMap<Integer, String> map3 = this.mCustomData;
        if (map3 != null) {
            Intrinsics.checkNotNull(map3);
            if (map3.size() > 0) {
                HashMap<Integer, String> map4 = this.mCustomData;
                Intrinsics.checkNotNull(map4);
                for (Map.Entry<Integer, String> entry : map4.entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    String value = entry.getValue();
                    raf.writeInt(iIntValue);
                    writeString(raf, value);
                }
            }
        }
        return true;
    }

    public SpenTextSpan(int i, int i2, int i4, int i5) {
        init(i, i2, i4, i5);
    }
}
