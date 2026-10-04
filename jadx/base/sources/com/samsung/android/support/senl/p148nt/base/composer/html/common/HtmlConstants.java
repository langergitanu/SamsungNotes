package com.samsung.android.support.senl.p148nt.base.composer.html.common;

import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/common/HtmlConstants;", "", "<init>", "()V", "DEF_FONT_SIZE", "", "TABLE_FONT_SIZE", "DEF_SPAN_EXPANSION", "", "LINE_BREAK", "", "HORIZONTAL_RULE", "LATEX", "DEF_FONT_COLOR_INNER", "Ljava/lang/Integer;", "DEF_FONT_COLOR", "getDEF_FONT_COLOR", "()I", "PARAGRAPH_STYLE", "Lcom/samsung/android/support/senl/nt/base/composer/html/common/TagStyleInfo;", "getPARAGRAPH_STYLE", "()Lcom/samsung/android/support/senl/nt/base/composer/html/common/TagStyleInfo;", "LIST_STYLE", "getLIST_STYLE", "setTypeBody1", "", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "start", "end", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HtmlConstants {

    @Nullable
    private static Integer DEF_FONT_COLOR_INNER = null;
    public static final float DEF_FONT_SIZE = 15.0f;
    public static final int DEF_SPAN_EXPANSION = 2;

    @NotNull
    public static final String HORIZONTAL_RULE = "\n───\n\n";

    @NotNull
    public static final String LATEX = "latex";

    @NotNull
    public static final String LINE_BREAK = "\n";
    public static final float TABLE_FONT_SIZE = 15.0f;

    @NotNull
    public static final HtmlConstants INSTANCE = new HtmlConstants();

    @NotNull
    private static final TagStyleInfo PARAGRAPH_STYLE = new TagStyleInfo(15.0f, 1.6f, 4.0f, 4.0f, false, 16, null);

    @NotNull
    private static final TagStyleInfo LIST_STYLE = new TagStyleInfo(15.0f, 1.0f, 10.0f, 10.0f, false, 16, null);

    private HtmlConstants() {
    }

    public final int getDEF_FONT_COLOR() {
        if (DEF_FONT_COLOR_INNER == null) {
            DEF_FONT_COLOR_INNER = Integer.valueOf(BaseUtils.getContext().getColor(C8875R.color.composer_def_font_color));
        }
        Integer num = DEF_FONT_COLOR_INNER;
        Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
        return num.intValue();
    }

    @NotNull
    public final TagStyleInfo getLIST_STYLE() {
        return LIST_STYLE;
    }

    @NotNull
    public final TagStyleInfo getPARAGRAPH_STYLE() {
        return PARAGRAPH_STYLE;
    }

    public final void setTypeBody1(@NotNull SpenObjectTextBox textBox, int start, int end) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        textBox.appendTextParagraph(new SpenPredefinedStyleParagraph(start, end, 3, 3));
    }
}
