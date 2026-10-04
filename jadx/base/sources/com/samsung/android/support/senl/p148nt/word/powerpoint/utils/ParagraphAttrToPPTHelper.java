package com.samsung.android.support.senl.p148nt.word.powerpoint.utils;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper;
import com.samsung.android.support.senl.p148nt.word.common.ParagraphAttributes;
import com.samsung.android.support.senl.p148nt.word.common.SpanAttributes;
import com.samsung.android.support.senl.p148nt.word.powerpoint.data.PowerPointParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.Color;
import org.apache.poi.p226sl.usermodel.AutoNumberingScheme;
import org.apache.poi.p226sl.usermodel.TextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 $2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001$B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0014J(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0014J\u001c\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u001a\u0010\u001f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0014¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/utils/ParagraphAttrToPPTHelper;", "Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttrToOfficeHelper;", "Lorg/apache/poi/xslf/usermodel/XSLFTextParagraph;", "Lorg/apache/poi/xslf/usermodel/XSLFTextRun;", "mParams", "Lcom/samsung/android/support/senl/nt/word/powerpoint/data/PowerPointParams;", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "<init>", "(Lcom/samsung/android/support/senl/nt/word/powerpoint/data/PowerPointParams;Lcom/samsung/android/sdk/pen/document/SpenObjectShape;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;)V", "addSpenTextParagraph", "", "line", "", "paragraph", "isNewLine", "", "addAlignment", "align", "addBullet", "type", "isChecked", "createRun", "start", "end", "addProperty", "run", "attr", "Lcom/samsung/android/support/senl/nt/word/common/SpanAttributes;", "setStyle", "size", "", "getTag", "", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ParagraphAttrToPPTHelper extends ParagraphAttrToOfficeHelper<XSLFTextParagraph, XSLFTextRun> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int INDENT_LEVEL_MAX = 8;

    @NotNull
    private static final String TAG;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/utils/ParagraphAttrToPPTHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "INDENT_LEVEL_MAX", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return ParagraphAttrToPPTHelper.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("ParagraphAttrToPPTHelper");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParagraphAttrToPPTHelper(@NotNull PowerPointParams mParams, @Nullable SpenObjectShape spenObjectShape, @Nullable OfficeView<?, ?> officeView) {
        super(mParams, spenObjectShape, officeView);
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        Intrinsics.checkNotNull(spenObjectShape);
        Intrinsics.checkNotNull(officeView);
    }

    private final void addBullet(XSLFTextParagraph paragraph, int type, boolean isChecked, boolean isNewLine) {
        if (type != 2) {
            if (type == 4) {
                if (isNewLine) {
                    paragraph.setBulletAutoNumber(AutoNumberingScheme.arabicPeriod, 1);
                    return;
                }
                return;
            } else {
                if (type == 8 && isNewLine) {
                    paragraph.setBullet(true);
                    return;
                }
                return;
            }
        }
        if (!isChecked) {
            if (isNewLine) {
                paragraph.setBullet(true);
                paragraph.setBulletCharacter("□");
                return;
            }
            return;
        }
        List<XSLFTextRun> textRuns = paragraph.getTextRuns();
        if (textRuns != null) {
            Iterator<XSLFTextRun> it = textRuns.iterator();
            while (it.hasNext()) {
                it.next().setStrikethrough(true);
            }
        }
        if (isNewLine) {
            paragraph.setBullet(true);
            paragraph.setBulletCharacter("■");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void setStyle(@Nullable XSLFTextParagraph paragraph, double size) {
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void addAlignment(@Nullable XSLFTextParagraph paragraph, int align) {
        if (align == 0) {
            if (paragraph != null) {
                paragraph.setTextAlign(TextParagraph.TextAlign.LEFT);
            }
        } else if (align == 1) {
            if (paragraph != null) {
                paragraph.setTextAlign(TextParagraph.TextAlign.RIGHT);
            }
        } else if (align == 2) {
            if (paragraph != null) {
                paragraph.setTextAlign(TextParagraph.TextAlign.CENTER);
            }
        } else if (align == 3 && paragraph != null) {
            paragraph.setTextAlign(TextParagraph.TextAlign.JUSTIFY);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void addProperty(@Nullable XSLFTextRun run, @Nullable SpanAttributes attr) {
        if (attr != null) {
            if (attr.getIsBold() && run != null) {
                run.setBold(true);
            }
            if (attr.getIsItalic() && run != null) {
                run.setItalic(true);
            }
            if (attr.getIsUnderline() && run != null) {
                run.setUnderlined(true);
            }
            if (attr.getIsStrikethrough() && run != null) {
                run.setStrikethrough(true);
            }
            if (attr.getFontSize() > 0.0d && run != null) {
                run.setFontSize(Double.valueOf(attr.getFontSize()));
            }
            if (attr.getForegroundColor() == null || Intrinsics.areEqual(attr.getForegroundColor(), "") || run == null) {
                return;
            }
            run.setFontColor(Color.decode(attr.getForegroundColor()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void addSpenTextParagraph(int line, @Nullable XSLFTextParagraph paragraph, boolean isNewLine) {
        ParagraphAttributes paragraphAttributes = getParagraphs().get(Integer.valueOf(line));
        if (paragraphAttributes == null) {
            return;
        }
        if (paragraphAttributes.getIndentLevel() > 0) {
            int indentLevel = paragraphAttributes.getIndentLevel();
            if (indentLevel > 8) {
                indentLevel = 8;
            }
            AbstractC0000a.m3D(indentLevel, "addIndentation, level: ", getTag());
            if (paragraph != null) {
                paragraph.setIndentLevel(indentLevel);
            }
        }
        if (paragraphAttributes.getAlign() > 0) {
            int align = paragraphAttributes.getAlign();
            AbstractC0000a.m3D(align, "addAlignment, align: ", getTag());
            addAlignment(paragraph, align);
        }
        if (paragraphAttributes.getBulletType() > 0) {
            int bulletType = paragraphAttributes.getBulletType();
            boolean isChecked = paragraphAttributes.getIsChecked();
            Logger.m10999d(getTag(), "addBullet, type: " + bulletType + ", isChecked: " + isChecked);
            if (paragraph != null) {
                addBullet(paragraph, bulletType, isChecked, isNewLine);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    @Nullable
    public XSLFTextRun createRun(@Nullable XSLFTextParagraph paragraph, int start, int end) {
        String strSubstring = null;
        XSLFTextRun xSLFTextRunAddNewTextRun = paragraph != null ? paragraph.addNewTextRun() : null;
        if (xSLFTextRunAddNewTextRun != null) {
            xSLFTextRunAddNewTextRun.setFontSize(Double.valueOf(50.0d));
        }
        if (xSLFTextRunAddNewTextRun != null) {
            String str = this.mContent;
            if (str != null) {
                strSubstring = str.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            }
            xSLFTextRunAddNewTextRun.setText(strSubstring);
        }
        return xSLFTextRunAddNewTextRun;
    }
}
