package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.ParagraphAttrToPPTHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001Bq\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/BodyTextPPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", ExternalDataConstants.Column.TEXT_BOX, "Lorg/apache/poi/xslf/usermodel/XSLFTextBox;", "startContent", "", "endContent", "indexLine", "helper", "Lcom/samsung/android/support/senl/nt/word/powerpoint/utils/ParagraphAttrToPPTHelper;", "isNewLine", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;Lorg/apache/poi/xslf/usermodel/XSLFTextBox;IIILcom/samsung/android/support/senl/nt/word/powerpoint/utils/ParagraphAttrToPPTHelper;Z)V", "processItem", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BodyTextPPTController extends ItemController<XSLFSlide> {
    private int endContent;

    @NotNull
    private ParagraphAttrToPPTHelper helper;
    private int indexLine;
    private boolean isNewLine;
    private int startContent;

    @NotNull
    private XSLFTextBox textBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyTextPPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide, @NotNull XSLFTextBox textBox, int i, int i2, int i4, @NotNull ParagraphAttrToPPTHelper helper, boolean z) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xSLFSlide, false);
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.textBox = textBox;
        this.startContent = i;
        this.endContent = i2;
        this.indexLine = i4;
        this.helper = helper;
        this.isNewLine = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        Double dValueOf = Double.valueOf(50.0d);
        SpenObjectBase spenObjectBase = this.mObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 2) {
            return;
        }
        SpenObjectBase spenObjectBase2 = this.mObject;
        Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
        SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBase2;
        XSLFTextParagraph xSLFTextParagraphAddNewTextParagraph = this.textBox.addNewTextParagraph();
        if (this.helper.haveSpan()) {
            this.helper.addRunToParagraph(xSLFTextParagraphAddNewTextParagraph, this.startContent, this.endContent);
        } else {
            XSLFTextRun xSLFTextRunAddNewTextRun = xSLFTextParagraphAddNewTextParagraph.addNewTextRun();
            xSLFTextRunAddNewTextRun.setFontSize(dValueOf);
            String text = spenObjectTextBox.getText();
            Intrinsics.checkNotNull(text);
            String strSubstring = text.substring(this.startContent, this.endContent);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            xSLFTextRunAddNewTextRun.setText(UnicodeUtils.removeObjectReplacementChar(strSubstring));
        }
        if (xSLFTextParagraphAddNewTextParagraph.getTextRuns().isEmpty()) {
            XSLFTextRun xSLFTextRunAddNewTextRun2 = xSLFTextParagraphAddNewTextParagraph.addNewTextRun();
            xSLFTextRunAddNewTextRun2.setFontSize(dValueOf);
            xSLFTextRunAddNewTextRun2.setText(Constant.WHITE_SPACE_FOR_LINK_ICON);
        }
        if (this.helper.haveSpenTextParagraph()) {
            this.helper.addSpenTextParagraph(this.indexLine, xSLFTextParagraphAddNewTextParagraph, this.isNewLine);
        }
    }
}
