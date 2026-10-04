package com.samsung.android.support.senl.p148nt.word.word.controller;

import android.graphics.RectF;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.microsoft.schemas.vml.CTGroup;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.word.data.WordParams;
import com.samsung.android.support.senl.p148nt.word.word.utils.ParagraphAttrToWordHelper;
import com.samsung.android.support.senl.p148nt.word.word.utils.WordUtils;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0019BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/controller/TextBoxWordController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "mTextboxIndex", "", "paragraph", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;ILorg/apache/poi/xwpf/usermodel/XWPFParagraph;)V", "processItem", "", "processLine", "helper", "Lcom/samsung/android/support/senl/nt/word/word/utils/ParagraphAttrToWordHelper;", "content", "", "startP", "endP", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextBoxWordController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextBoxWordController.kt\ncom/samsung/android/support/senl/nt/word/word/controller/TextBoxWordController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,102:1\n739#2,9:103\n37#3:112\n36#3,3:113\n*S KotlinDebug\n*F\n+ 1 TextBoxWordController.kt\ncom/samsung/android/support/senl/nt/word/word/controller/TextBoxWordController\n*L\n47#1:103,9\n47#1:112\n47#1:113,3\n*E\n"})
public final class TextBoxWordController extends ItemController<XWPFParagraph> {
    private static final String TAG = Logger.createTag("TextBoxWordController");
    private final int mTextboxIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextBoxWordController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, int i, @Nullable XWPFParagraph xWPFParagraph) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xWPFParagraph, false);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.mTextboxIndex = i;
    }

    private final void processLine(XWPFParagraph paragraph, ParagraphAttrToWordHelper helper, String content, int startP, int endP) {
        if (helper.haveSpan()) {
            helper.addRunToParagraph(paragraph, startP, endP);
            return;
        }
        XWPFRun xWPFRunCreateRun = paragraph.createRun();
        String strSubstring = content.substring(startP, endP);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        xWPFRunCreateRun.setText(strSubstring);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        SpenObjectBase spenObjectBase;
        List listEmptyList;
        RectF rectFConvertRectF;
        SpenObjectBase spenObjectBase2 = this.mObject;
        if ((spenObjectBase2 == null || spenObjectBase2.getType() != 2) && ((spenObjectBase = this.mObject) == null || spenObjectBase.getType() != 7)) {
            return;
        }
        SpenObjectBase spenObjectBase3 = this.mObject;
        SpenObjectShape spenObjectShape = spenObjectBase3 instanceof SpenObjectShape ? (SpenObjectShape) spenObjectBase3 : null;
        if (spenObjectShape == null) {
            return;
        }
        String text = spenObjectShape.getText();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Intrinsics.checkNotNull(text);
        List<String> listSplit = new Regex("\n").split(text, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length == 0) {
            return;
        }
        SpenObjectShape spenObjectShape2 = (SpenObjectShape) this.mObject;
        RectF rect = spenObjectShape2 != null ? spenObjectShape2.getRect() : null;
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
        float f = rectFConvertRectF.left;
        double d = f;
        float f4 = rectFConvertRectF.top;
        double d2 = f4;
        double d3 = rectFConvertRectF.right - f;
        double d4 = rectFConvertRectF.bottom - f4;
        SpenObjectShape spenObjectShape3 = (SpenObjectShape) this.mObject;
        boolean z = !(spenObjectShape3 != null && spenObjectShape3.getType() == 7);
        OfficeElement officeelement = this.mElement;
        Intrinsics.checkNotNull(officeelement);
        XWPFRun xWPFRun = ((XWPFParagraph) officeelement).getRuns().get(0);
        CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
        WordUtils wordUtils = WordUtils.INSTANCE;
        Intrinsics.checkNotNull(cTGroupNewInstance);
        ConvertUtils convertUtils3 = ConvertUtils.INSTANCE;
        CTTxbxContent cTTxbxContentCreateCTTxbxContent = wordUtils.createCTTxbxContent(cTGroupNewInstance, convertUtils3.dpToPt(d - 42.0d), convertUtils3.dpToPt(d2 + 0.0d), convertUtils3.dpToPt(d3), convertUtils3.dpToPt(d4), 0.0f, true, z);
        OfficeParams officeParams3 = this.mView.mDocParams;
        Intrinsics.checkNotNull(officeParams3, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.data.WordParams");
        ParagraphAttrToWordHelper paragraphAttrToWordHelper = new ParagraphAttrToWordHelper((WordParams) officeParams3, spenObjectShape, this.mView);
        int length = strArr.length;
        int iM2212c = 0;
        for (int i8 = 0; i8 < length; i8++) {
            XWPFParagraph xWPFParagraph = new XWPFParagraph(cTTxbxContentCreateCTTxbxContent.addNewP(), xWPFRun.getDocument());
            xWPFParagraph.setSpacingBetween(0.0d, LineSpacingRule.AT_LEAST);
            xWPFParagraph.setSpacingBefore(0);
            xWPFParagraph.setSpacingAfter(0);
            processLine(xWPFParagraph, paragraphAttrToWordHelper, text, iM2212c, strArr[i8].length() + iM2212c);
            if (paragraphAttrToWordHelper.haveSpenTextParagraph()) {
                paragraphAttrToWordHelper.addSpenTextParagraph(i8, xWPFParagraph, true);
            }
            iM2212c = AbstractC2821a.m2212c(1, iM2212c, strArr[i8]);
        }
        try {
            CTPicture cTPicture = CTPicture.Factory.parse(cTGroupNewInstance.getDomNode());
            CTR ctr = xWPFRun.getCTR();
            ctr.addNewPict();
            ctr.setPictArray(this.mTextboxIndex, cTPicture);
        } catch (XmlException e) {
            Logger.m11000e(TAG, "Error text box : " + e);
        }
        this.mView.indexTextbox++;
    }
}
