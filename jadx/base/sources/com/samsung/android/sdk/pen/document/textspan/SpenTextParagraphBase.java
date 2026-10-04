package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "", "type", "", "<init>", "(I)V", "startPosistion", "endPosition", "(III)V", "value", "getType", "()I", "start", "getStart", "end", "getEnd", "setPosition", "", "startPosition", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenTextParagraphBase {
    public static final int FILTER_PARAGRAPH_ALIGN = 8;
    public static final int FILTER_PARAGRAPH_ALL = 2047;
    public static final int FILTER_PARAGRAPH_BULLET = 32;
    public static final int FILTER_PARAGRAPH_INDENTLEVEL = 4;
    public static final int FILTER_PARAGRAPH_LINE_SPACING = 16;
    public static final int FILTER_PARAGRAPH_NONE = 1;
    public static final int FILTER_PARAGRAPH_PARSING_STATE = 64;
    public static final int FILTER_PARAGRAPH_PREDEFINED_STYLE = 1024;
    public static final int FILTER_PARAGRAPH_PREDEFINED_STYLE_SET = 1808;
    public static final int FILTER_PARAGRAPH_SPACING_AFTER = 512;
    public static final int FILTER_PARAGRAPH_SPACING_BEFORE = 256;
    public static final int TYPE_ALIGN = 3;
    public static final int TYPE_BULLET = 5;
    public static final int TYPE_INDENTLEVEL = 2;
    public static final int TYPE_LINE_SPACING = 4;
    public static final int TYPE_MAX = 11;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_PARSING_STATE = 6;
    public static final int TYPE_PREDEFINED_STYLE = 10;
    public static final int TYPE_SPACING_AFTER = 9;
    public static final int TYPE_SPACING_BEFORE = 8;
    private int end;
    private int start;
    private int type;

    public SpenTextParagraphBase(int i) {
        if (i < 0 || i >= 11) {
            SpenError.ThrowUncheckedException(3);
        }
        this.type = i;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getType() {
        return this.type;
    }

    public final void setPosition(int startPosition, int endPosition) {
        if (startPosition > endPosition) {
            SpenError.ThrowUncheckedException(3);
        }
        this.start = startPosition;
        this.end = endPosition;
    }

    public SpenTextParagraphBase(int i, int i2, int i4) {
        if (i < 0 || i >= 11 || i4 < i2) {
            SpenError.ThrowUncheckedException(3);
        }
        this.type = i;
        this.start = i2;
        this.end = i4;
    }
}
