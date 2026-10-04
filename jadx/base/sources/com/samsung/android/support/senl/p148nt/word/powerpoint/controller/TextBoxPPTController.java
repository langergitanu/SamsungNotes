package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import android.graphics.RectF;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.data.PowerPointParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.ParagraphAttrToPPTHelper;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.VerticalAlignment;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BK\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/TextBoxPPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", ExternalDataConstants.Column.TEXT_BOX, "Lorg/apache/poi/xslf/usermodel/XSLFTextBox;", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;Lorg/apache/poi/xslf/usermodel/XSLFTextBox;)V", "processItem", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextBoxPPTController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextBoxPPTController.kt\ncom/samsung/android/support/senl/nt/word/powerpoint/controller/TextBoxPPTController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,88:1\n739#2,9:89\n37#3:98\n36#3,3:99\n*S KotlinDebug\n*F\n+ 1 TextBoxPPTController.kt\ncom/samsung/android/support/senl/nt/word/powerpoint/controller/TextBoxPPTController\n*L\n44#1:89,9\n44#1:98\n44#1:99,3\n*E\n"})
public final class TextBoxPPTController extends ItemController<XSLFSlide> {

    @Nullable
    private XSLFTextBox textBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextBoxPPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide, @Nullable XSLFTextBox xSLFTextBox) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xSLFSlide, false);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.textBox = xSLFTextBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        SpenObjectBase spenObjectBase;
        List listEmptyList;
        RectF rectFConvertRectF;
        int i;
        XSLFTextBox xSLFTextBox;
        Double dValueOf = Double.valueOf(50.0d);
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
            int i2 = officeView.prevHeight;
            int width = this.mSpenWPage.getWidth();
            OfficeView<?, ?> officeView2 = this.mView;
            int i4 = officeView2.cropHeight;
            OfficeParams officeParams = officeView2.mDocParams;
            int i5 = officeParams.width;
            int i6 = officeParams.height;
            Intrinsics.checkNotNull(rect);
            rectFConvertRectF = convertUtils.convertRectContinuousPage(i2, width, i4, i5, i6, rect, this.mSpenWPage.hasPDF());
        } else {
            RectF rectF = rect;
            ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
            SpenWPage spenWPage = this.mSpenWPage;
            OfficeParams officeParams2 = officeView.mDocParams;
            int i7 = officeParams2.width;
            int i8 = officeParams2.height;
            Intrinsics.checkNotNull(rectF);
            rectFConvertRectF = convertUtils2.convertRectF(spenWPage, i7, i8, rectF);
        }
        XSLFSlide xSLFSlide = (XSLFSlide) this.mElement;
        this.textBox = xSLFSlide != null ? xSLFSlide.createTextBox() : null;
        OfficeView.INSTANCE.increaseElementId();
        float f = rectFConvertRectF.left;
        OfficeParams officeParams3 = this.mView.mDocParams;
        double d = officeParams3.marginLeft + f;
        float f4 = rectFConvertRectF.top;
        double d2 = officeParams3.marginTop + f4;
        double d3 = rectFConvertRectF.right - f;
        double d4 = rectFConvertRectF.bottom - f4;
        XSLFTextBox xSLFTextBox2 = this.textBox;
        if (xSLFTextBox2 != null) {
            xSLFTextBox2.setAnchor(new Rectangle2D.Double(d, d2, d3, d4));
        }
        XSLFTextBox xSLFTextBox3 = this.textBox;
        if (xSLFTextBox3 != null) {
            xSLFTextBox3.setRotation(((SpenObjectShape) this.mObject) != null ? r6.getRotation() : 0.0d);
        }
        SpenObjectShape spenObjectShape3 = (SpenObjectShape) this.mObject;
        if (spenObjectShape3 != null && spenObjectShape3.getType() == 7 && (xSLFTextBox = this.textBox) != null) {
            xSLFTextBox.setVerticalAlignment(VerticalAlignment.MIDDLE);
        }
        OfficeParams officeParams4 = this.mView.mDocParams;
        Intrinsics.checkNotNull(officeParams4, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.powerpoint.data.PowerPointParams");
        ParagraphAttrToPPTHelper paragraphAttrToPPTHelper = new ParagraphAttrToPPTHelper((PowerPointParams) officeParams4, spenObjectShape, this.mView);
        int length = strArr.length;
        int iM2212c = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int length2 = strArr[i9].length() + iM2212c;
            XSLFTextBox xSLFTextBox4 = this.textBox;
            XSLFTextParagraph xSLFTextParagraphAddNewTextParagraph = xSLFTextBox4 != null ? xSLFTextBox4.addNewTextParagraph() : null;
            if (paragraphAttrToPPTHelper.haveSpan()) {
                paragraphAttrToPPTHelper.addRunToParagraph(xSLFTextParagraphAddNewTextParagraph, iM2212c, length2);
            } else {
                XSLFTextRun xSLFTextRunAddNewTextRun = xSLFTextParagraphAddNewTextParagraph != null ? xSLFTextParagraphAddNewTextParagraph.addNewTextRun() : null;
                if (xSLFTextRunAddNewTextRun != null) {
                    xSLFTextRunAddNewTextRun.setFontSize(dValueOf);
                }
                if (xSLFTextRunAddNewTextRun != null) {
                    String strSubstring = text.substring(iM2212c, length2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    xSLFTextRunAddNewTextRun.setText(strSubstring);
                }
            }
            List<XSLFTextRun> textRuns = xSLFTextParagraphAddNewTextParagraph != null ? xSLFTextParagraphAddNewTextParagraph.getTextRuns() : null;
            Intrinsics.checkNotNull(textRuns);
            if (textRuns.isEmpty()) {
                XSLFTextRun xSLFTextRunAddNewTextRun2 = xSLFTextParagraphAddNewTextParagraph.addNewTextRun();
                xSLFTextRunAddNewTextRun2.setFontSize(dValueOf);
                xSLFTextRunAddNewTextRun2.setText(Constant.WHITE_SPACE_FOR_LINK_ICON);
            }
            if (paragraphAttrToPPTHelper.haveSpenTextParagraph()) {
                i = 1;
                paragraphAttrToPPTHelper.addSpenTextParagraph(i9, xSLFTextParagraphAddNewTextParagraph, true);
            } else {
                i = 1;
            }
            iM2212c = AbstractC2821a.m2212c(i, iM2212c, strArr[i9]);
        }
    }
}
