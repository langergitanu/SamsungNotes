package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenHyperTextSpan;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "<init>", "()V", "startPosition", "", "endPosition", "expansionType", "(III)V", "hyperTextType", "getHyperTextType", "()I", "setHyperTextType", "(I)V", "type", "dateTimeType", "getDateTimeType", "setDateTimeType", "customData", "", "getCustomData", "()Ljava/lang/String;", "setCustomData", "(Ljava/lang/String;)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHyperTextSpan extends SpenTextSpanBase {
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
    public static final int FILTER_ADDRESS = 32;
    public static final int FILTER_ALL = 1023;
    public static final int FILTER_CUSTOM = 512;
    public static final int FILTER_DATE = 16;
    public static final int FILTER_DATETIME = 64;
    public static final int FILTER_EMAIL = 2;
    public static final int FILTER_FILE = 256;
    public static final int FILTER_FORMULA = 128;
    public static final int FILTER_TEL = 4;
    public static final int FILTER_URL = 8;
    public static final int TYPE_ADDRESS = 5;
    public static final int TYPE_CUSTOM = 9;
    public static final int TYPE_DATE = 4;
    public static final int TYPE_DATETIME = 6;
    public static final int TYPE_EMAIL = 1;
    public static final int TYPE_FILE = 8;
    public static final int TYPE_FORMULA = 7;
    public static final int TYPE_TEL = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 3;

    @NotNull
    private String customData;
    private int dateTimeType;
    private int hyperTextType;

    public SpenHyperTextSpan() {
        super(9);
        this.customData = "";
    }

    @NotNull
    public final String getCustomData() {
        return this.customData;
    }

    public final int getDateTimeType() {
        if (this.hyperTextType != 6) {
            return 0;
        }
        return this.dateTimeType;
    }

    public final int getHyperTextType() {
        return this.hyperTextType;
    }

    public final void setCustomData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customData = str;
    }

    public final void setDateTimeType(int i) {
        if (i < 0 || i > 21) {
            SpenError.ThrowUncheckedException(3);
        }
        if (this.hyperTextType == 6) {
            this.dateTimeType = i;
        }
    }

    public final void setHyperTextType(int i) {
        this.hyperTextType = i;
    }

    public SpenHyperTextSpan(int i, int i2, int i4) {
        super(9, i, i2, i4);
        this.customData = "";
    }
}
