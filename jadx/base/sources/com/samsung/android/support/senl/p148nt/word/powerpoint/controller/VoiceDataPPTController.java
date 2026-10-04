package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import android.graphics.RectF;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.PPTUtils;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.VoiceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/VoiceDataPPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;)V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "processItem", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceDataPPTController extends ItemController<XSLFSlide> {
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceDataPPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @NotNull SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xSLFSlide, false);
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
        Intrinsics.checkNotNull(officeView);
        this.TAG = Logger.createTag("VoiceDataPPT");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        RectF rectFConvertRectF;
        VoiceUtils voiceUtils;
        PackagePart packagePartWriteFile;
        ArrayList<SpenVoiceData> voiceDataList = this.mView.wNoteData.getSpenWNoteP().getVoiceDataList();
        if (voiceDataList != null) {
            int i = this.mView.mDocParams.contentTextSize;
            RectF rectF = new RectF();
            Iterator<SpenVoiceData> it = voiceDataList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            RectF rectF2 = rectF;
            int i2 = 0;
            while (it.hasNext()) {
                SpenVoiceData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenVoiceData spenVoiceData = next;
                rectF2.set(this.mSpenWPage.getWidth(), 0.0f, (this.mSpenWPage.getWidth() / 3) + this.mSpenWPage.getWidth(), i * 4.375f);
                OfficeView<?, ?> officeView = this.mView;
                if (officeView.isContinuousPage) {
                    ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                    int i4 = officeView.prevHeight;
                    int width = this.mSpenWPage.getWidth();
                    OfficeView<?, ?> officeView2 = this.mView;
                    int i5 = officeView2.cropHeight;
                    OfficeParams officeParams = officeView2.mDocParams;
                    rectFConvertRectF = convertUtils.convertRectContinuousPage(i4, width, i5, officeParams.width, officeParams.height, rectF2, this.mSpenWPage.hasPDF());
                } else {
                    ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
                    SpenWPage spenWPage = this.mSpenWPage;
                    OfficeParams officeParams2 = officeView.mDocParams;
                    rectFConvertRectF = convertUtils2.convertRectF(spenWPage, officeParams2.width, officeParams2.height, rectF2);
                }
                rectF2 = rectFConvertRectF;
                OfficeElement officeelement = this.mElement;
                Intrinsics.checkNotNull(officeelement);
                XMLSlideShow slideShow = ((XSLFSlide) officeelement).getSlideShow();
                try {
                    voiceUtils = VoiceUtils.INSTANCE;
                    String attachedFile = spenVoiceData.getAttachedFile();
                    Intrinsics.checkNotNull(attachedFile);
                    Intrinsics.checkNotNull(slideShow);
                    packagePartWriteFile = voiceUtils.writeFile(attachedFile, slideShow, this.mView.mInsertHelper.getVoiceHashMap(), this.mView.mInsertHelper.getPartHashMap());
                } catch (Exception e) {
                    Logger.m10999d(this.TAG, "Add voice recording into pptx error : " + e);
                }
                if (packagePartWriteFile == null) {
                    return;
                }
                int i6 = (int) (rectF2.right - rectF2.left);
                int i7 = (int) (rectF2.bottom - rectF2.top);
                int i8 = this.mView.mDocParams.width - i6;
                OfficeView.INSTANCE.increaseElementId();
                CTPicture cTPictureCreatePicture = PPTUtils.INSTANCE.createPicture((XSLFSlide) this.mElement, i8, i2 + 10, i6, i7, OfficeView.mElementId);
                String str = "image" + OfficeView.mElementId + ".png";
                voiceUtils.addAudio((XSLFSlide) this.mElement, packagePartWriteFile, cTPictureCreatePicture, 0.0d);
                voiceUtils.addTimingInfo((XSLFSlide) this.mElement, cTPictureCreatePicture);
                i2 += i7;
                HashMap<String, SpenVoiceData> voiceData = this.mView.mInsertHelper.getVoiceData();
                Intrinsics.checkNotNull(voiceData);
                voiceData.put(str, spenVoiceData);
            }
        }
    }
}
