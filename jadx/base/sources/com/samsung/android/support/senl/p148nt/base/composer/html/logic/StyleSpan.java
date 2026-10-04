package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import android.graphics.Color;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StyleSpan;", "", "type", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpanType;", "start", "", "end", "value", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpanType;IILjava/lang/String;)V", "getType", "()Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpanType;", "getStart", "()I", "getEnd", "getValue", "()Ljava/lang/String;", "expansion", "setSpan", "", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "textLength", "paragraphEnd", "isHeading", "", "setParagraph", "styleType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDocumentElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/StyleSpan\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,1110:1\n439#2:1111\n*S KotlinDebug\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/StyleSpan\n*L\n390#1:1111\n*E\n"})
public final /* data */ class StyleSpan {
    private final int end;
    private final int expansion;
    private final int start;

    @NotNull
    private final SpanType type;

    @Nullable
    private final String value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpanType.values().length];
            try {
                iArr[SpanType.BOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpanType.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpanType.UNDERLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpanType.STRIKETHROUGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SpanType.TEXT_COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SpanType.BACKGROUND_COLOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SpanType.HREF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SpanType.SUBSCRIPT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SpanType.SUPERSCRIPT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SpanType.HEADING1.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SpanType.HEADING2.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SpanType.HEADING3.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SpanType.HEADING4.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SpanType.HEADING5.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SpanType.HEADING6.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[SpanType.Code.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[SpanType.Latex.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StyleSpan(@NotNull SpanType type, int i, int i2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.start = i;
        this.end = i2;
        this.value = str;
        this.expansion = 2;
    }

    public static /* synthetic */ StyleSpan copy$default(StyleSpan styleSpan, SpanType spanType, int i, int i2, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            spanType = styleSpan.type;
        }
        if ((i4 & 2) != 0) {
            i = styleSpan.start;
        }
        if ((i4 & 4) != 0) {
            i2 = styleSpan.end;
        }
        if ((i4 & 8) != 0) {
            str = styleSpan.value;
        }
        return styleSpan.copy(spanType, i, i2, str);
    }

    private final void setParagraph(SpenObjectTextBox textBox, int end, int styleType) {
        textBox.appendTextParagraph(new SpenPredefinedStyleParagraph(0, end, styleType, 3));
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SpanType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public final StyleSpan copy(@NotNull SpanType type, int start, int end, @Nullable String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new StyleSpan(type, start, end, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StyleSpan)) {
            return false;
        }
        StyleSpan styleSpan = (StyleSpan) other;
        return this.type == styleSpan.type && this.start == styleSpan.start && this.end == styleSpan.end && Intrinsics.areEqual(this.value, styleSpan.value);
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    @NotNull
    public final SpanType getType() {
        return this.type;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iM1157c = AbstractC0622a.m1157c(this.end, AbstractC0622a.m1157c(this.start, this.type.hashCode() * 31, 31), 31);
        String str = this.value;
        return iM1157c + (str == null ? 0 : str.hashCode());
    }

    public final boolean isHeading() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public final void setSpan(@NotNull SpenObjectTextBox textBox, int textLength, int paragraphEnd) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        if (textLength < this.end) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                textBox.appendTextSpan(new SpenBoldSpan(this.start, this.end, this.expansion, true));
                return;
            case 2:
                textBox.appendTextSpan(new SpenItalicSpan(this.start, this.end, this.expansion, true));
                return;
            case 3:
                textBox.appendTextSpan(new SpenUnderlineSpan(this.start, this.end, this.expansion, true));
                return;
            case 4:
                textBox.appendTextSpan(new SpenStrikethroughSpan(this.start, this.end, this.expansion, true));
                return;
            case 5:
                if (this.value != null) {
                    textBox.appendTextSpan(new SpenForegroundColorSpan(this.start, this.end, this.expansion, Color.parseColor(this.value)));
                    return;
                }
                return;
            case 6:
            case 8:
            case 9:
            case 16:
            case 17:
                return;
            case 7:
                if (this.value != null) {
                    SpenHyperTextSpan spenHyperTextSpan = new SpenHyperTextSpan(this.start, this.end, this.expansion);
                    spenHyperTextSpan.setHyperTextType(3);
                    spenHyperTextSpan.setCustomData(this.value);
                    textBox.appendTextSpan(spenHyperTextSpan);
                    return;
                }
                return;
            case 10:
                setParagraph(textBox, paragraphEnd, 0);
                return;
            case 11:
                setParagraph(textBox, paragraphEnd, 1);
                return;
            case 12:
            case 13:
            case 14:
            case 15:
                setParagraph(textBox, paragraphEnd, 2);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public String toString() {
        return "StyleSpan(type=" + this.type + ", start=" + this.start + ", end=" + this.end + ", value=" + this.value + ")";
    }

    public /* synthetic */ StyleSpan(SpanType spanType, int i, int i2, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanType, i, i2, (i4 & 8) != 0 ? null : str);
    }
}
