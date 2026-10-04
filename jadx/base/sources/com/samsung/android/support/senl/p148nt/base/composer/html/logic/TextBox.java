package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import android.graphics.Color;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.ListStyle;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\"\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fH\u0002J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0003H\u0002J\u0010\u0010>\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J,\u0010?\u001a\u00020@2\u0006\u00108\u001a\u0002092\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fH\u0002J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J\t\u0010F\u001a\u00020\nHÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\u000eHÆ\u0003JK\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010J\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\fHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001dR.\u0010\u001e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\f0 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00101\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/¨\u0006O"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/DocumentElement;", "text", "", "spans", "", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StyleSpan;", "alignment", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Alignment;", "listStyle", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "indentLevel", "", "isBlockQuote", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Alignment;Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;IZ)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getSpans", "()Ljava/util/List;", "getAlignment", "()Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Alignment;", "getListStyle", "()Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "getIndentLevel", "()I", "()Z", "taskObjects", "", "Lkotlin/Pair;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TaskObject;", "getTaskObjects", "setTaskObjects", "(Ljava/util/List;)V", "fontSize", "", "getFontSize", "()F", "setFontSize", "(F)V", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "convertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "findStyleParagraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenPredefinedStyleParagraph;", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "begin", "end", "isTransparent", "color", "getParagraphEndIndex", "removeWhiteTextColor", "", "textColorSpans", "bgColorSpans", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDocumentElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,1110:1\n1#2:1111\n1869#3:1112\n1870#3:1114\n1869#3,2:1115\n1869#3:1117\n1869#3,2:1118\n1870#3:1121\n439#4:1113\n439#4:1120\n*S KotlinDebug\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox\n*L\n246#1:1112\n246#1:1114\n285#1:1115,2\n334#1:1117\n336#1:1118,2\n334#1:1121\n251#1:1113\n348#1:1120\n*E\n"})
public final /* data */ class TextBox extends DocumentElement {

    @NotNull
    private final Alignment alignment;

    @Nullable
    private Integer backgroundColor;
    private float fontSize;
    private final int indentLevel;
    private final boolean isBlockQuote;

    @NotNull
    private final ListStyle listStyle;

    @NotNull
    private final List<StyleSpan> spans;

    @Nullable
    private List<? extends Pair<? extends TaskObject, Integer>> taskObjects;

    @NotNull
    private String text;

    @Nullable
    private Integer textColor;

    public /* synthetic */ TextBox(String str, List list, Alignment alignment, ListStyle listStyle, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i2 & 4) != 0 ? Alignment.NONE : alignment, (i2 & 8) != 0 ? ListStyle.NONE.INSTANCE : listStyle, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextBox copy$default(TextBox textBox, String str, List list, Alignment alignment, ListStyle listStyle, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = textBox.text;
        }
        if ((i2 & 2) != 0) {
            list = textBox.spans;
        }
        if ((i2 & 4) != 0) {
            alignment = textBox.alignment;
        }
        if ((i2 & 8) != 0) {
            listStyle = textBox.listStyle;
        }
        if ((i2 & 16) != 0) {
            i = textBox.indentLevel;
        }
        if ((i2 & 32) != 0) {
            z = textBox.isBlockQuote;
        }
        int i4 = i;
        boolean z2 = z;
        return textBox.copy(str, list, alignment, listStyle, i4, z2);
    }

    private final SpenPredefinedStyleParagraph findStyleParagraph(SpenObjectTextBox textBox, int begin, int end) {
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = textBox.findTextParagraph(begin, end, 1024);
        if (arrayListFindTextParagraph == null || arrayListFindTextParagraph.isEmpty()) {
            return null;
        }
        SpenTextParagraphBase spenTextParagraphBase = arrayListFindTextParagraph.get(0);
        Intrinsics.checkNotNull(spenTextParagraphBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph");
        return (SpenPredefinedStyleParagraph) spenTextParagraphBase;
    }

    private final int getParagraphEndIndex(String text) {
        int length = text.length();
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = text.charAt(i2);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i++;
            }
        }
        return i;
    }

    private final boolean isTransparent(String color) {
        int length = color.length();
        float f = 1.0f;
        if (length != 7 && length == 9) {
            Intrinsics.checkNotNullExpressionValue(color.substring(1, 3), "substring(...)");
            f = Integer.parseInt(r5, CharsKt.checkRadix(16)) / 255.0f;
        }
        return f <= 0.0f;
    }

    private final void removeWhiteTextColor(SpenObjectTextBox textBox, List<StyleSpan> textColorSpans, List<StyleSpan> bgColorSpans) {
        for (StyleSpan styleSpan : textColorSpans) {
            boolean z = true;
            for (StyleSpan styleSpan2 : bgColorSpans) {
                if (styleSpan2.getStart() <= styleSpan.getStart() && styleSpan2.getEnd() >= styleSpan.getEnd()) {
                    z = false;
                }
            }
            if (z) {
                int start = styleSpan.getStart();
                int end = styleSpan.getEnd();
                String value = styleSpan.getValue();
                Intrinsics.checkNotNull(value);
                textBox.removeTextSpan(new SpenForegroundColorSpan(start, end, 2, Color.parseColor(value)));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<StyleSpan> component2() {
        return this.spans;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ListStyle getListStyle() {
        return this.listStyle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getIndentLevel() {
        return this.indentLevel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBlockQuote() {
        return this.isBlockQuote;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.DocumentElement
    @Nullable
    public SpenObjectBase convertObject() {
        if (this.text.length() == 0) {
            return null;
        }
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.setTextLimit(this.text.length());
        spenObjectTextBox.setFontSize(this.fontSize);
        Integer num = this.textColor;
        if (num != null) {
            spenObjectTextBox.setTextColor(num.intValue());
        }
        spenObjectTextBox.insertText(this.text, 0);
        int paragraphEndIndex = getParagraphEndIndex(StringsKt.trim((CharSequence) this.text).toString());
        HtmlConstants.INSTANCE.setTypeBody1(spenObjectTextBox, 0, paragraphEndIndex);
        if (this.alignment != Alignment.NONE) {
            spenObjectTextBox.appendTextParagraph(new SpenAlignmentParagraph(0, paragraphEndIndex, this.alignment.getSpenAlign()));
        }
        if (this.isBlockQuote) {
            spenObjectTextBox.appendTextParagraph(new SpenIndentLevelParagraph(0, paragraphEndIndex, this.indentLevel));
        } else {
            spenObjectTextBox.appendTextParagraph(new SpenIndentLevelParagraph(0, 1, RangesKt.coerceAtLeast(this.indentLevel - 1, 0)));
            if (paragraphEndIndex > 1) {
                spenObjectTextBox.appendTextParagraph(new SpenIndentLevelParagraph(1, paragraphEndIndex, this.indentLevel));
            }
        }
        ArrayList<StyleSpan> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        for (StyleSpan styleSpan : CollectionsKt.reversed(this.spans)) {
            if (styleSpan.getType() == SpanType.TEXT_COLOR) {
                if (styleSpan.getValue() != null) {
                    if (isTransparent(styleSpan.getValue())) {
                        arrayList.add(styleSpan);
                    } else if (this.backgroundColor == null && Color.parseColor(styleSpan.getValue()) == -1) {
                        arrayList2.add(styleSpan);
                    }
                }
            } else if (styleSpan.getType() == SpanType.BACKGROUND_COLOR) {
                arrayList3.add(styleSpan);
            }
            styleSpan.setSpan(spenObjectTextBox, this.text.length(), paragraphEndIndex);
            if (!z && styleSpan.isHeading()) {
                z = true;
            }
        }
        removeWhiteTextColor(spenObjectTextBox, arrayList2, arrayList3);
        this.listStyle.setParagraph(spenObjectTextBox, 0, 1, !z);
        int i = 2;
        if (paragraphEndIndex >= 2 && 2 <= paragraphEndIndex) {
            while (true) {
                int i2 = i - 2;
                int i4 = i - 1;
                SpenPredefinedStyleParagraph spenPredefinedStyleParagraphFindStyleParagraph = findStyleParagraph(spenObjectTextBox, i2, i4);
                SpenPredefinedStyleParagraph spenPredefinedStyleParagraphFindStyleParagraph2 = findStyleParagraph(spenObjectTextBox, i4, i);
                if (Intrinsics.areEqual(spenPredefinedStyleParagraphFindStyleParagraph != null ? Integer.valueOf(spenPredefinedStyleParagraphFindStyleParagraph.getType()) : null, spenPredefinedStyleParagraphFindStyleParagraph2 != null ? Integer.valueOf(spenPredefinedStyleParagraphFindStyleParagraph2.getType()) : null)) {
                    spenObjectTextBox.removeTextParagraph(i4, i, 256);
                    spenObjectTextBox.removeTextParagraph(i2, i4, 512);
                }
                if (i == paragraphEndIndex) {
                    break;
                }
                i++;
            }
        }
        for (StyleSpan styleSpan2 : arrayList) {
            spenObjectTextBox.removeText(styleSpan2.getStart(), styleSpan2.getEnd());
        }
        return spenObjectTextBox;
    }

    @NotNull
    public final TextBox copy(@NotNull String text, @NotNull List<StyleSpan> spans, @NotNull Alignment alignment, @NotNull ListStyle listStyle, int indentLevel, boolean isBlockQuote) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spans, "spans");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(listStyle, "listStyle");
        return new TextBox(text, spans, alignment, listStyle, indentLevel, isBlockQuote);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextBox)) {
            return false;
        }
        TextBox textBox = (TextBox) other;
        return Intrinsics.areEqual(this.text, textBox.text) && Intrinsics.areEqual(this.spans, textBox.spans) && this.alignment == textBox.alignment && Intrinsics.areEqual(this.listStyle, textBox.listStyle) && this.indentLevel == textBox.indentLevel && this.isBlockQuote == textBox.isBlockQuote;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Nullable
    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final int getIndentLevel() {
        return this.indentLevel;
    }

    @NotNull
    public final ListStyle getListStyle() {
        return this.listStyle;
    }

    @NotNull
    public final List<StyleSpan> getSpans() {
        return this.spans;
    }

    @Nullable
    public final List<Pair<TaskObject, Integer>> getTaskObjects() {
        return this.taskObjects;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final Integer getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isBlockQuote) + AbstractC0622a.m1157c(this.indentLevel, (this.listStyle.hashCode() + ((this.alignment.hashCode() + AbstractC0622a.m1159e(this.spans, this.text.hashCode() * 31, 31)) * 31)) * 31, 31);
    }

    public final boolean isBlockQuote() {
        return this.isBlockQuote;
    }

    public final void setBackgroundColor(@Nullable Integer num) {
        this.backgroundColor = num;
    }

    public final void setFontSize(float f) {
        this.fontSize = f;
    }

    public final void setTaskObjects(@Nullable List<? extends Pair<? extends TaskObject, Integer>> list) {
        this.taskObjects = list;
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void setTextColor(@Nullable Integer num) {
        this.textColor = num;
    }

    @NotNull
    public String toString() {
        return "TextBox(text=" + this.text + ", spans=" + this.spans + ", alignment=" + this.alignment + ", listStyle=" + this.listStyle + ", indentLevel=" + this.indentLevel + ", isBlockQuote=" + this.isBlockQuote + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextBox(@NotNull String text, @NotNull List<StyleSpan> spans, @NotNull Alignment alignment, @NotNull ListStyle listStyle, int i, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spans, "spans");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(listStyle, "listStyle");
        this.text = text;
        this.spans = spans;
        this.alignment = alignment;
        this.listStyle = listStyle;
        this.indentLevel = i;
        this.isBlockQuote = z;
        this.fontSize = 15.0f;
    }
}
