package com.samsung.android.support.senl.p148nt.word.word.controller;

import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.word.utils.ParagraphAttrToWordHelper;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001Bi\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/controller/BodyTextWordController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "paragraph", "line", "", "startPosition", "endPosition", "helper", "Lcom/samsung/android/support/senl/nt/word/word/utils/ParagraphAttrToWordHelper;", "isNewLine", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;IIILcom/samsung/android/support/senl/nt/word/word/utils/ParagraphAttrToWordHelper;Z)V", "processItem", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BodyTextWordController extends ItemController<XWPFParagraph> {
    private final int endPosition;

    @NotNull
    private final ParagraphAttrToWordHelper helper;
    private final boolean isNewLine;
    private final int line;
    private final int startPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyTextWordController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XWPFParagraph xWPFParagraph, int i, int i2, int i4, @NotNull ParagraphAttrToWordHelper helper, boolean z) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xWPFParagraph, false);
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.line = i;
        this.startPosition = i2;
        this.endPosition = i4;
        this.helper = helper;
        this.isNewLine = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        SpenObjectBase spenObjectBase = this.mObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 2) {
            return;
        }
        SpenObjectBase spenObjectBase2 = this.mObject;
        Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
        SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBase2;
        if (this.helper.haveSpan()) {
            this.helper.addRunToParagraph(this.mElement, this.startPosition, this.endPosition);
        } else {
            OfficeElement officeelement = this.mElement;
            Intrinsics.checkNotNull(officeelement);
            XWPFRun xWPFRunCreateRun = ((XWPFParagraph) officeelement).createRun();
            String text = spenObjectTextBox.getText();
            Intrinsics.checkNotNull(text);
            String strSubstring = text.substring(this.startPosition, this.endPosition);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            xWPFRunCreateRun.setText(UnicodeUtils.removeObjectReplacementChar(strSubstring));
        }
        OfficeElement officeelement2 = this.mElement;
        Intrinsics.checkNotNull(officeelement2);
        if (((XWPFParagraph) officeelement2).getRuns().isEmpty()) {
            OfficeElement officeelement3 = this.mElement;
            Intrinsics.checkNotNull(officeelement3);
            XWPFRun xWPFRunCreateRun2 = ((XWPFParagraph) officeelement3).createRun();
            ParagraphAttrToWordHelper paragraphAttrToWordHelper = this.helper;
            Intrinsics.checkNotNull(xWPFRunCreateRun2);
            paragraphAttrToWordHelper.setFontSize(xWPFRunCreateRun2, this.mView.mDocParams.getFontSize(15));
            CTHpsMeasure sz = xWPFRunCreateRun2.getCTR().getRPr().getSz();
            if (sz != null) {
                BigInteger val = sz.getVal();
                xWPFRunCreateRun2.getCTR().getRPr().addNewSzCs().setVal(val);
                OfficeElement officeelement4 = this.mElement;
                Intrinsics.checkNotNull(officeelement4);
                CTPPr pPr = ((XWPFParagraph) officeelement4).getCTP().getPPr();
                if (pPr != null) {
                    CTParaRPr cTParaRPrAddNewRPr = pPr.addNewRPr();
                    cTParaRPrAddNewRPr.addNewSz().setVal(val);
                    cTParaRPrAddNewRPr.addNewSzCs().setVal(val);
                }
            }
        }
        if (this.helper.haveSpenTextParagraph()) {
            this.helper.addSpenTextParagraph(this.line, (XWPFParagraph) this.mElement, this.isNewLine);
        }
    }
}
