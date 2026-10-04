package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import android.graphics.RectF;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.PPTUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/LinkPPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;)V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "processItem", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LinkPPTController extends ItemController<XSLFSlide> {
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xSLFSlide, false);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.TAG = Logger.createTag("LinkPPTController");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        CTPictureNonVisual nvPicPr;
        CTNonVisualDrawingProps cNvPr;
        SpenObjectBase spenObjectBase = this.mObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 17) {
            return;
        }
        RectF rectFConvertRectF = convertRectF();
        try {
            int i = (int) rectFConvertRectF.left;
            OfficeParams officeParams = this.mView.mDocParams;
            int i2 = i + officeParams.marginLeft;
            int i4 = ((int) rectFConvertRectF.top) + officeParams.marginTop;
            int iWidth = (int) rectFConvertRectF.width();
            int iHeight = (int) rectFConvertRectF.height();
            OfficeView.Companion companion = OfficeView.INSTANCE;
            companion.increaseElementId();
            XSLFSlide xSLFSlide = (XSLFSlide) this.mElement;
            CTPicture cTPictureCreatePicture = xSLFSlide != null ? PPTUtils.INSTANCE.createPicture(xSLFSlide, i2, i4, iWidth, iHeight, OfficeView.mElementId) : null;
            String newName = getNewName(OfficeView.mElementId);
            companion.increaseElementId();
            SpenObjectBase spenObjectBase2 = this.mObject;
            Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLink");
            String option = ((SpenObjectLink) spenObjectBase2).getOption();
            if (TextUtils.isEmpty(option)) {
                return;
            }
            Intrinsics.checkNotNull(option);
            if (!StringsKt.m14145S(option, "http") || cTPictureCreatePicture == null || (nvPicPr = cTPictureCreatePicture.getNvPicPr()) == null || (cNvPr = nvPicPr.getCNvPr()) == null) {
                return;
            }
            CTHyperlink cTHyperlinkAddNewHlinkClick = cNvPr.addNewHlinkClick();
            String str = "rId" + OfficeView.mElementId;
            OfficeElement officeelement = this.mElement;
            Intrinsics.checkNotNull(officeelement);
            cTHyperlinkAddNewHlinkClick.setId(((XSLFSlide) officeelement).getPackagePart().addExternalRelationship(option, XSLFRelation.HYPERLINK.getRelation(), str).getId());
            HashMap<String, SpenObjectBase> imageHashMap = this.mView.mInsertHelper.getImageHashMap();
            Intrinsics.checkNotNull(imageHashMap);
            SpenObjectBase spenObjectBase3 = this.mObject;
            Intrinsics.checkNotNull(spenObjectBase3, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLink");
            imageHashMap.put(newName, (SpenObjectLink) spenObjectBase3);
        } catch (Exception e) {
            AbstractC8014b.m7207i("Error add link : ", e, this.TAG);
        }
    }
}
