package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\tJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "", "type", "", "<init>", "(I)V", "startPosistion", "endPosition", "expansionType", "(IIII)V", "value", "getType", "()I", "start", "getStart", "end", "getEnd", "expansion", "getExpansion", "setExpansion", "isIntervalTypeFixed", "", "()Z", "setIntervalTypeFixed", "(Z)V", "setPosition", "", "startPosition", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenTextSpanBase {
    public static final int FILTER_SPAN_ALL = 16777215;
    public static final int FILTER_SPAN_BACKGROUND_COLOR = 131072;
    public static final int FILTER_SPAN_BOLD = 32;
    public static final int FILTER_SPAN_COMPOSING = 65536;
    public static final int FILTER_SPAN_COMPOSING_BACKGROUND_COLOR = 32768;
    public static final int FILTER_SPAN_COMPOSING_TAG = 262144;
    public static final int FILTER_SPAN_FONT_NAME = 16;
    public static final int FILTER_SPAN_FONT_SIZE = 8;
    public static final int FILTER_SPAN_FOREGROUND_COLOR = 2;
    public static final int FILTER_SPAN_FORMULA = 8388608;
    public static final int FILTER_SPAN_HYPER_TEXT = 512;
    public static final int FILTER_SPAN_ITALIC = 64;
    public static final int FILTER_SPAN_SPELL_CORRECTION = 4194304;
    public static final int FILTER_SPAN_STRIKETHROUGH = 1048576;
    public static final int FILTER_SPAN_SUGGESTION = 2097152;
    public static final int FILTER_SPAN_TIME_STAMP = 524288;
    public static final int FILTER_SPAN_UNDERLINE = 128;
    public static final int SPAN_EXCLUSIVE_EXCLUSIVE = 2;
    public static final int SPAN_EXCLUSIVE_INCLUSIVE = 3;
    public static final int SPAN_INCLUSIVE_EXCLUSIVE = 0;
    public static final int SPAN_INCLUSIVE_INCLUSIVE = 1;
    public static final int TYPE_BACKGROUND_COLOR = 17;
    public static final int TYPE_BOLD = 5;
    public static final int TYPE_COMPOSING = 16;
    public static final int TYPE_COMPOSING_BACKGROUND_COLOR = 15;
    public static final int TYPE_COMPOSING_TAG = 18;
    public static final int TYPE_FONT_NAME = 4;
    public static final int TYPE_FONT_SIZE = 3;
    public static final int TYPE_FOREGROUND_COLOR = 1;
    public static final int TYPE_FORMULA = 23;
    public static final int TYPE_HYPER_TEXT = 9;
    public static final int TYPE_ITALIC = 6;
    public static final int TYPE_MAX = 24;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_SPELL_CORRECTION = 22;
    public static final int TYPE_STRIKETHROUGH = 20;
    public static final int TYPE_SUGGESTION = 21;
    public static final int TYPE_TIME_STAMP = 19;
    public static final int TYPE_UNDERLINE = 7;
    private int end;
    private int expansion = 3;
    private boolean isIntervalTypeFixed;
    private int start;
    private int type;

    public SpenTextSpanBase(int i) {
        if (i < 0 || i >= 24) {
            SpenError.ThrowUncheckedException(3);
        }
        this.type = i;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getExpansion() {
        return this.expansion;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isIntervalTypeFixed, reason: from getter */
    public final boolean getIsIntervalTypeFixed() {
        return this.isIntervalTypeFixed;
    }

    public final void setExpansion(int i) {
        if (i < 0 || i > 3) {
            SpenError.ThrowUncheckedException(3);
        }
        this.expansion = i;
    }

    public final void setIntervalTypeFixed(boolean z) {
        this.isIntervalTypeFixed = z;
    }

    public final void setPosition(int startPosition, int endPosition) {
        if (startPosition > endPosition) {
            SpenError.ThrowUncheckedException(3);
        }
        this.start = startPosition;
        this.end = endPosition;
    }

    public SpenTextSpanBase(int i, int i2, int i4, int i5) {
        if (i < 0 || i >= 24 || i4 < i2 || i5 < 0 || i5 > 3) {
            SpenError.ThrowUncheckedException(3);
        }
        this.type = i;
        this.start = i2;
        this.end = i4;
        setExpansion(i5);
    }
}
