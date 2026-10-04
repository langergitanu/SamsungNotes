package com.samsung.android.support.senl.p148nt.word.word.controller;

import android.graphics.RectF;
import com.microsoft.schemas.vml.CTGroup;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectFormula;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import com.samsung.android.support.senl.p148nt.word.word.utils.WordUtils;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleEngine;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/controller/FormulaWordController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "paragraph", "indexTextbox", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;I)V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "processItem", "", "getOMML", "Lorg/openxmlformats/schemas/officeDocument/x2006/math/CTOMath;", "wordView", "Lcom/samsung/android/support/senl/nt/word/word/WordView;", "mathML", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FormulaWordController extends ItemController<XWPFParagraph> {
    private final String TAG;
    private final int indexTextbox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormulaWordController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XWPFParagraph xWPFParagraph, int i) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xWPFParagraph, false);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.indexTextbox = i;
        this.TAG = Logger.createTag("FormulaWordController");
    }

    @NotNull
    public final CTOMath getOMML(@Nullable WordView wordView, @Nullable String mathML) throws TransformerException, IOException {
        Transformer transformer;
        StreamSource streamSource = new StreamSource(new StringReader(mathML));
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        if (wordView != null && (transformer = wordView.transformer) != null) {
            transformer.transform(streamSource, streamResult);
        }
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        stringWriter.close();
        CTOMath oMathArray = CTOMath.Factory.parse(string).getOMathArray(0);
        Intrinsics.checkNotNullExpressionValue(oMathArray, "getOMathArray(...)");
        return oMathArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        RectF rectFConvertRectF;
        SpenObjectBase spenObjectBase = this.mObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 11) {
            return;
        }
        SpenObjectBase spenObjectBase2 = this.mObject;
        Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectFormula");
        SpenObjectFormula spenObjectFormula = (SpenObjectFormula) spenObjectBase2;
        ArrayList<String> latex = spenObjectFormula.getLatex();
        if (latex == null || latex.isEmpty()) {
            return;
        }
        SpenObjectFormula spenObjectFormula2 = (SpenObjectFormula) this.mObject;
        RectF rect = spenObjectFormula2 != null ? spenObjectFormula2.getRect() : null;
        OfficeView<?, ?> officeView = this.mView;
        if (officeView.isContinuousPage) {
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            int i = officeView.prevHeight;
            int width = this.mSpenWPage.getWidth();
            OfficeView<?, ?> officeView2 = this.mView;
            int i2 = officeView2.cropHeight;
            OfficeParams officeParams = officeView2.mDocParams;
            int i4 = officeParams.width;
            int i5 = officeParams.height;
            Intrinsics.checkNotNull(rect);
            rectFConvertRectF = convertUtils.convertRectContinuousPage(i, width, i2, i4, i5, rect, this.mSpenWPage.hasPDF());
        } else {
            ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
            SpenWPage spenWPage = this.mSpenWPage;
            OfficeParams officeParams2 = officeView.mDocParams;
            int i6 = officeParams2.width;
            int i7 = officeParams2.height;
            Intrinsics.checkNotNull(rect);
            rectFConvertRectF = convertUtils2.convertRectF(spenWPage, i6, i7, rect);
        }
        OfficeElement officeelement = this.mElement;
        Intrinsics.checkNotNull(officeelement);
        List<XWPFRun> runs = ((XWPFParagraph) officeelement).getRuns();
        OfficeElement officeelement2 = this.mElement;
        Intrinsics.checkNotNull(officeelement2);
        XWPFRun xWPFRun = runs.get(((XWPFParagraph) officeelement2).getRuns().size() - 1);
        CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
        WordUtils wordUtils = WordUtils.INSTANCE;
        Intrinsics.checkNotNull(cTGroupNewInstance);
        ConvertUtils convertUtils3 = ConvertUtils.INSTANCE;
        double dDpToPt = convertUtils3.dpToPt(rectFConvertRectF.left);
        double dDpToPt2 = convertUtils3.dpToPt(rectFConvertRectF.top);
        double dDpToPt3 = convertUtils3.dpToPt(rectFConvertRectF.right - rectFConvertRectF.left);
        float f = rectFConvertRectF.bottom - rectFConvertRectF.top;
        int i8 = 1;
        CTTxbxContent cTTxbxContentCreateCTTxbxContent = wordUtils.createCTTxbxContent(cTGroupNewInstance, dDpToPt, dDpToPt2, dDpToPt3, convertUtils3.dpToPt(f), 0.0f, false, true);
        ArrayList<String> latexResult = spenObjectFormula.getLatexResult();
        int size = latex.size();
        int i9 = 0;
        while (i9 < size) {
            StringBuilder sb = new StringBuilder(latex.get(i9));
            String str = latexResult.get(i9);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            String str2 = str;
            if (StringsKt.m14162r(str2, "\\color{blue}")) {
                String strSubstring = str2.substring(StringsKt.m14129C("\\color{blue}{", 0, 6, str2), str2.length() - i8);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb.append(StringsKt.m14139M(StringsKt.m14139M(strSubstring, "\\color{blue}{", ""), "}", ""));
            }
            sb.insert(0, '$').append('$');
            XWPFParagraph xWPFParagraph = new XWPFParagraph(cTTxbxContentCreateCTTxbxContent.addNewP(), xWPFRun.getDocument());
            xWPFParagraph.setSpacingAfterLines(i8);
            xWPFParagraph.setSpacingBeforeLines(i8);
            SnuggleSession snuggleSessionCreateSession = new SnuggleEngine().createSession();
            try {
                snuggleSessionCreateSession.parseInput(new SnuggleInput(sb.toString()));
                String strBuildXMLString = snuggleSessionCreateSession.buildXMLString();
                if (strBuildXMLString != null) {
                    OfficeView<?, ?> officeView3 = this.mView;
                    Intrinsics.checkNotNull(officeView3, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.WordView");
                    xWPFParagraph.getCTP().setOMathArray(new CTOMath[]{getOMML((WordView) officeView3, strBuildXMLString)});
                }
            } catch (Exception e) {
                AbstractC8014b.m7207i("Parser latex error : ", e, this.TAG);
            }
            i9++;
            i8 = 1;
        }
        try {
            CTPicture cTPicture = CTPicture.Factory.parse(cTGroupNewInstance.getDomNode());
            CTR ctr = xWPFRun.getCTR();
            ctr.addNewPict();
            ctr.setPictArray(this.indexTextbox, cTPicture);
        } catch (XmlException e2) {
            Logger.m11000e(this.TAG, "Add text box latex error : " + e2);
        }
        this.mView.indexTextbox++;
    }
}
