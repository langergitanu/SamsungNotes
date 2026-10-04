package com.samsung.android.support.senl.p148nt.word.word.utils;

import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper;
import com.samsung.android.support.senl.p148nt.word.common.ParagraphAttributes;
import com.samsung.android.support.senl.p148nt.word.common.SpanAttributes;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import com.samsung.android.support.senl.p148nt.word.word.data.WordParams;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNum;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 .2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001.B-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001a\u0010\u001e\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0014J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0014J\u001c\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010(H\u0014J\u001a\u0010)\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020-H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/utils/ParagraphAttrToWordHelper;", "Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttrToOfficeHelper;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "Lorg/apache/poi/xwpf/usermodel/XWPFRun;", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/nt/word/word/data/WordParams;", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "<init>", "(Lcom/samsung/android/support/senl/nt/word/word/data/WordParams;Lcom/samsung/android/sdk/pen/document/SpenObjectShape;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;)V", "lastBulletType", "", "lastParagraphAttributes", "Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttributes;", "num", "Lorg/apache/poi/xwpf/usermodel/XWPFNum;", "addSpenTextParagraph", "", "line", "paragraph", "isNewLine", "", "isDifferAttr", "attr", "lastAttr", "addBullet", "ctAbstractNum", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTAbstractNum;", "addAlignment", "align", "restartNumbering", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lorg/apache/poi/xwpf/usermodel/XWPFDocument;", "createRun", "start", "end", "addProperty", "run", "Lcom/samsung/android/support/senl/nt/word/common/SpanAttributes;", "setStyle", "size", "", "getTag", "", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nParagraphAttrToWordHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParagraphAttrToWordHelper.kt\ncom/samsung/android/support/senl/nt/word/word/utils/ParagraphAttrToWordHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1#2:226\n*E\n"})
public class ParagraphAttrToWordHelper extends ParagraphAttrToOfficeHelper<XWPFParagraph, XWPFRun> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FONT_FAMILY = "Arial";

    @NotNull
    private static final String TAG;
    private int lastBulletType;

    @Nullable
    private ParagraphAttributes lastParagraphAttributes;

    @Nullable
    private XWPFNum num;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/utils/ParagraphAttrToWordHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "FONT_FAMILY", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return ParagraphAttrToWordHelper.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("ParagraphAttrToWordHelper");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParagraphAttrToWordHelper(@Nullable WordParams wordParams, @Nullable SpenObjectShape spenObjectShape, @Nullable OfficeView<?, ?> officeView) {
        super(wordParams, spenObjectShape, officeView);
        Intrinsics.checkNotNull(wordParams);
        Intrinsics.checkNotNull(spenObjectShape);
        Intrinsics.checkNotNull(officeView);
    }

    private final void addBullet(ParagraphAttributes attr, boolean isNewLine, CTAbstractNum ctAbstractNum) {
        String strSubstring;
        OfficeView.Companion companion = OfficeView.INSTANCE;
        ctAbstractNum.setAbstractNumId(BigInteger.valueOf(companion.getMNumId()));
        companion.increaseNumId();
        CTLvl cTLvlAddNewLvl = ctAbstractNum.addNewLvl();
        int bulletType = attr.getBulletType();
        if (bulletType != 2) {
            if (bulletType != 4) {
                if (bulletType == 8 && isNewLine) {
                    cTLvlAddNewLvl.addNewStart().setVal(BigInteger.ONE);
                    cTLvlAddNewLvl.addNewNumFmt().setVal(STNumberFormat.BULLET);
                    cTLvlAddNewLvl.addNewLvlText().setVal("•");
                }
            } else if (isNewLine) {
                cTLvlAddNewLvl.addNewStart().setVal(BigInteger.valueOf(attr.getBulletNumber()));
                cTLvlAddNewLvl.addNewNumFmt().setVal(STNumberFormat.DECIMAL);
                cTLvlAddNewLvl.addNewLvlText().setVal("%1.");
            }
        } else if (attr.getIsChecked()) {
            if (isNewLine) {
                cTLvlAddNewLvl.addNewStart().setVal(BigInteger.ONE);
                cTLvlAddNewLvl.addNewNumFmt().setVal(STNumberFormat.BULLET);
                cTLvlAddNewLvl.addNewLvlText().setVal("☑");
            }
        } else if (isNewLine) {
            cTLvlAddNewLvl.addNewStart().setVal(BigInteger.ONE);
            cTLvlAddNewLvl.addNewNumFmt().setVal(STNumberFormat.BULLET);
            cTLvlAddNewLvl.addNewLvlText().setVal("☐");
        }
        CTFonts cTFontsAddNewRFonts = cTLvlAddNewLvl.addNewRPr().addNewRFonts();
        cTFontsAddNewRFonts.setAscii(FONT_FAMILY);
        cTFontsAddNewRFonts.setHAnsi(FONT_FAMILY);
        cTLvlAddNewLvl.getRPr().addNewSz().setVal(BigInteger.valueOf(attr.getFontSize() * 2));
        if (attr.getForegroundColor() != null) {
            CTColor cTColorAddNewColor = cTLvlAddNewLvl.getRPr().addNewColor();
            String foregroundColor = attr.getForegroundColor();
            if (foregroundColor != null) {
                strSubstring = foregroundColor.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            } else {
                strSubstring = null;
            }
            cTColorAddNewColor.setVal(strSubstring);
        }
    }

    private final boolean isDifferAttr(ParagraphAttributes attr, ParagraphAttributes lastAttr) {
        if (attr == null || lastAttr == null) {
            return false;
        }
        if (attr.getBulletType() != lastAttr.getBulletType() || (attr.getBulletNumber() == lastAttr.getBulletNumber() && attr.getIsChecked() == lastAttr.getIsChecked() && attr.getFontSize() == lastAttr.getFontSize())) {
            return (attr.getForegroundColor() == null || lastAttr.getForegroundColor() == null || attr.getBulletType() != lastAttr.getBulletType() || StringsKt.m14169y(attr.getForegroundColor(), lastAttr.getForegroundColor())) ? false : true;
        }
        return true;
    }

    private final void restartNumbering(XWPFDocument document, CTAbstractNum ctAbstractNum) {
        XWPFAbstractNum xWPFAbstractNum = new XWPFAbstractNum(ctAbstractNum);
        XWPFNumbering xWPFNumberingCreateNumbering = document.createNumbering();
        this.num = xWPFNumberingCreateNumbering.getNum(xWPFNumberingCreateNumbering.addNum(xWPFNumberingCreateNumbering.addAbstractNum(xWPFAbstractNum)));
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void addAlignment(@Nullable XWPFParagraph paragraph, int align) {
        if (align == 0) {
            if (paragraph != null) {
                paragraph.setAlignment(ParagraphAlignment.LEFT);
            }
        } else if (align == 1) {
            if (paragraph != null) {
                paragraph.setAlignment(ParagraphAlignment.RIGHT);
            }
        } else if (align == 2) {
            if (paragraph != null) {
                paragraph.setAlignment(ParagraphAlignment.CENTER);
            }
        } else if (align == 3 && paragraph != null) {
            paragraph.setAlignment(ParagraphAlignment.BOTH);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void addProperty(@Nullable XWPFRun run, @Nullable SpanAttributes attr) {
        CTR ctr;
        CTRPr cTRPrAddNewRPr;
        if (attr != null) {
            if (attr.getIsBold() && run != null) {
                run.setBold(true);
            }
            if (attr.getIsItalic() && run != null) {
                run.setItalic(true);
            }
            if (attr.getIsUnderline() && run != null) {
                run.setUnderline(UnderlinePatterns.SINGLE);
            }
            if (attr.getIsStrikethrough() && run != null) {
                run.setStrikeThrough(true);
            }
            if (attr.getFontSize() > 0.0d && run != null) {
                setFontSize(run, attr.getFontSize());
            }
            if (attr.getForegroundColor() != null && !Intrinsics.areEqual(attr.getForegroundColor(), "") && run != null) {
                String foregroundColor = attr.getForegroundColor();
                Intrinsics.checkNotNull(foregroundColor);
                String strSubstring = foregroundColor.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                run.setColor(strSubstring);
            }
            if (attr.getBackgroundColor() == null || Intrinsics.areEqual(attr.getBackgroundColor(), "")) {
                return;
            }
            CTShd cTShdAddNewShd = (run == null || (ctr = run.getCTR()) == null || (cTRPrAddNewRPr = ctr.addNewRPr()) == null) ? null : cTRPrAddNewRPr.addNewShd();
            if (cTShdAddNewShd != null) {
                cTShdAddNewShd.setVal(STShd.CLEAR);
            }
            if (cTShdAddNewShd != null) {
                cTShdAddNewShd.setColor(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            if (cTShdAddNewShd != null) {
                String backgroundColor = attr.getBackgroundColor();
                Intrinsics.checkNotNull(backgroundColor);
                String strSubstring2 = backgroundColor.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                cTShdAddNewShd.setFill(strSubstring2);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void addSpenTextParagraph(int line, @Nullable XWPFParagraph paragraph, boolean isNewLine) {
        XWPFDocument document;
        ParagraphAttributes paragraphAttributes = getParagraphs().get(Integer.valueOf(line));
        if (paragraphAttributes == null) {
            return;
        }
        if (paragraphAttributes.getIndentLevel() > 0) {
            int indentLevel = paragraphAttributes.getIndentLevel();
            AbstractC0000a.m3D(indentLevel, "addIndentation, level: ", getTag());
            if (paragraph != null) {
                paragraph.setIndentationLeft((indentLevel * 567) + paragraph.getIndentFromLeft());
            }
        }
        if (paragraphAttributes.getAlign() > 0) {
            int align = paragraphAttributes.getAlign();
            AbstractC0000a.m3D(align, "addAlignment, align: ", getTag());
            addAlignment(paragraph, align);
        }
        if (paragraphAttributes.getBulletType() <= 0) {
            return;
        }
        OfficeView<?, ?> officeView = this.mView;
        Intrinsics.checkNotNull(officeView, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.WordView");
        if (!((WordView) officeView).getHasBullet()) {
            OfficeView<?, ?> officeView2 = this.mView;
            Intrinsics.checkNotNull(officeView2, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.WordView");
            ((WordView) officeView2).setHasBullet(true);
            OfficeView.INSTANCE.increaseElementId();
        }
        int bulletType = paragraphAttributes.getBulletType();
        String tag = getTag();
        boolean isChecked = paragraphAttributes.getIsChecked();
        int bulletNumber = paragraphAttributes.getBulletNumber();
        int fontSize = paragraphAttributes.getFontSize();
        String foregroundColor = paragraphAttributes.getForegroundColor();
        StringBuilder sbM2226q = AbstractC2821a.m2226q("addBullet, type: ", bulletType, ", isChecked: ", isChecked, ", bulletNumber: ");
        AbstractC2821a.m2235z(sbM2226q, bulletNumber, fontSize, ", fontSize: ", ", foregroundColor: ");
        AbstractC8014b.m7213o(sbM2226q, foregroundColor, tag);
        if (bulletType == 2 && paragraphAttributes.getIsChecked()) {
            List<XWPFRun> runs = paragraph != null ? paragraph.getRuns() : null;
            if (runs != null) {
                Iterator<XWPFRun> it = runs.iterator();
                while (it.hasNext()) {
                    it.next().setStrike(true);
                }
            }
        }
        if (isNewLine) {
            CTAbstractNum cTAbstractNumNewInstance = CTAbstractNum.Factory.newInstance();
            CTMultiLevelType cTMultiLevelTypeNewInstance = CTMultiLevelType.Factory.newInstance();
            cTMultiLevelTypeNewInstance.setVal(STMultiLevelType.HYBRID_MULTILEVEL);
            cTAbstractNumNewInstance.setMultiLevelType(cTMultiLevelTypeNewInstance);
            Intrinsics.checkNotNull(cTAbstractNumNewInstance);
            addBullet(paragraphAttributes, isNewLine, cTAbstractNumNewInstance);
            if (((bulletType != 4 && (bulletType != this.lastBulletType || isDifferAttr(paragraphAttributes, this.lastParagraphAttributes))) || bulletType == 4) && paragraph != null && (document = paragraph.getDocument()) != null) {
                restartNumbering(document, cTAbstractNumNewInstance);
            }
            XWPFNum xWPFNum = this.num;
            if (xWPFNum != null && paragraph != null) {
                Intrinsics.checkNotNull(xWPFNum);
                paragraph.setNumID(xWPFNum.getCTNum().getNumId());
            }
            this.lastBulletType = bulletType;
            this.lastParagraphAttributes = paragraphAttributes;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    @Nullable
    public XWPFRun createRun(@Nullable XWPFParagraph paragraph, int start, int end) {
        String strSubstring = null;
        XWPFRun xWPFRunCreateRun = paragraph != null ? paragraph.createRun() : null;
        if (xWPFRunCreateRun != null) {
            xWPFRunCreateRun.setFontFamily(FONT_FAMILY);
        }
        if (xWPFRunCreateRun != null) {
            String str = this.mContent;
            if (str != null) {
                strSubstring = str.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            }
            xWPFRunCreateRun.setText(strSubstring);
        }
        return xWPFRunCreateRun;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper
    public void setStyle(@Nullable XWPFParagraph paragraph, double size) {
        CTP ctp;
        if (paragraph != null) {
            paragraph.setSpacingBetween(1.125d);
        }
        if (size > 0.0d) {
            CTPPr pPr = (paragraph == null || (ctp = paragraph.getCTP()) == null) ? null : ctp.getPPr();
            if (pPr != null) {
                CTParaRPr rPr = pPr.getRPr();
                if (rPr == null) {
                    rPr = pPr.addNewRPr();
                }
                Intrinsics.checkNotNull(rPr);
                CTFonts cTFontsAddNewRFonts = rPr.addNewRFonts();
                cTFontsAddNewRFonts.setAscii(FONT_FAMILY);
                cTFontsAddNewRFonts.setHAnsi(FONT_FAMILY);
                cTFontsAddNewRFonts.setCs(FONT_FAMILY);
                rPr.addNewSz().setVal(new BigDecimal(String.valueOf(size)).multiply(new BigDecimal("2")).toBigIntegerExact());
            }
        }
        if (paragraph != null) {
            paragraph.createRun();
        }
    }
}
