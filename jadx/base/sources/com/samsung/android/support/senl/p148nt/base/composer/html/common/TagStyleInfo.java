package com.samsung.android.support.senl.p148nt.base.composer.html.common;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenSpacingAfterParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenSpacingBeforeParagraph;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0017HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/common/TagStyleInfo;", "", "fontSize", "", "lineHeight", "topMargin", "bottomMargin", "bold", "", "<init>", "(FFFFZ)V", "getFontSize", "()F", "getLineHeight", "getTopMargin", "getBottomMargin", "getBold", "()Z", "setMargin", "", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "start", "", "end", "setTopMargin", "setBottomMargin", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class TagStyleInfo {
    private final boolean bold;
    private final float bottomMargin;
    private final float fontSize;
    private final float lineHeight;
    private final float topMargin;

    public TagStyleInfo(float f, float f4, float f5, float f6, boolean z) {
        this.fontSize = f;
        this.lineHeight = f4;
        this.topMargin = f5;
        this.bottomMargin = f6;
        this.bold = z;
    }

    public static /* synthetic */ TagStyleInfo copy$default(TagStyleInfo tagStyleInfo, float f, float f4, float f5, float f6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = tagStyleInfo.fontSize;
        }
        if ((i & 2) != 0) {
            f4 = tagStyleInfo.lineHeight;
        }
        if ((i & 4) != 0) {
            f5 = tagStyleInfo.topMargin;
        }
        if ((i & 8) != 0) {
            f6 = tagStyleInfo.bottomMargin;
        }
        if ((i & 16) != 0) {
            z = tagStyleInfo.bold;
        }
        boolean z2 = z;
        float f7 = f5;
        return tagStyleInfo.copy(f, f4, f7, f6, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getTopMargin() {
        return this.topMargin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBottomMargin() {
        return this.bottomMargin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getBold() {
        return this.bold;
    }

    @NotNull
    public final TagStyleInfo copy(float fontSize, float lineHeight, float topMargin, float bottomMargin, boolean bold) {
        return new TagStyleInfo(fontSize, lineHeight, topMargin, bottomMargin, bold);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagStyleInfo)) {
            return false;
        }
        TagStyleInfo tagStyleInfo = (TagStyleInfo) other;
        return Float.compare(this.fontSize, tagStyleInfo.fontSize) == 0 && Float.compare(this.lineHeight, tagStyleInfo.lineHeight) == 0 && Float.compare(this.topMargin, tagStyleInfo.topMargin) == 0 && Float.compare(this.bottomMargin, tagStyleInfo.bottomMargin) == 0 && this.bold == tagStyleInfo.bold;
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final float getBottomMargin() {
        return this.bottomMargin;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final float getTopMargin() {
        return this.topMargin;
    }

    public int hashCode() {
        return Boolean.hashCode(this.bold) + AbstractC0622a.m1156b(this.bottomMargin, AbstractC0622a.m1156b(this.topMargin, AbstractC0622a.m1156b(this.lineHeight, Float.hashCode(this.fontSize) * 31, 31), 31), 31);
    }

    public final void setBottomMargin(@NotNull SpenObjectTextBox textBox, int start, int end) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        textBox.appendTextParagraph(new SpenSpacingAfterParagraph(start, end, this.bottomMargin));
    }

    public final void setMargin(@NotNull SpenObjectTextBox textBox, int start, int end) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        setTopMargin(textBox, start, end);
        setBottomMargin(textBox, start, end);
    }

    public final void setTopMargin(@NotNull SpenObjectTextBox textBox, int start, int end) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        textBox.appendTextParagraph(new SpenSpacingBeforeParagraph(start, end, this.topMargin));
    }

    @NotNull
    public String toString() {
        float f = this.fontSize;
        float f4 = this.lineHeight;
        float f5 = this.topMargin;
        float f6 = this.bottomMargin;
        boolean z = this.bold;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("TagStyleInfo(fontSize=", f, ", lineHeight=", f4, ", topMargin=");
        AbstractC11014a.m12337v(sbM1176v, f5, ", bottomMargin=", f6, ", bold=");
        return AbstractC0000a.m14k(sbM1176v, z, ")");
    }

    public /* synthetic */ TagStyleInfo(float f, float f4, float f5, float f6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, (i & 16) != 0 ? false : z);
    }
}
