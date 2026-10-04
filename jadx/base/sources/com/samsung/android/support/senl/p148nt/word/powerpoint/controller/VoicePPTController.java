package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import android.graphics.RectF;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.PPTUtils;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.VoiceUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0010BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/VoicePPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;)V", "processItem", "", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoicePPTController extends ItemController<XSLFSlide> {
    private static final String TAG = Logger.createTag("VoicePPTController");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoicePPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xSLFSlide, false);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        SpenObjectBase spenObjectBase = this.mObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 10) {
            return;
        }
        RectF objectRectF = getObjectRectF();
        OfficeElement officeelement = this.mElement;
        Intrinsics.checkNotNull(officeelement);
        XMLSlideShow slideShow = ((XSLFSlide) officeelement).getSlideShow();
        try {
            float f = objectRectF.left;
            OfficeParams officeParams = this.mView.mDocParams;
            int i = ((int) f) + officeParams.marginLeft;
            float f4 = objectRectF.top;
            int i2 = ((int) f4) + officeParams.marginTop;
            int i4 = (int) (objectRectF.right - f);
            int i5 = (int) (objectRectF.bottom - f4);
            int i6 = i2 + i5;
            int i7 = officeParams.height;
            if (i6 > i7) {
                i2 = i7 - i5;
            }
            OfficeView.INSTANCE.increaseElementId();
            PPTUtils pPTUtils = PPTUtils.INSTANCE;
            OfficeElement officeelement2 = this.mElement;
            Intrinsics.checkNotNull(officeelement2);
            CTPicture cTPictureCreatePicture = pPTUtils.createPicture((XSLFSlide) officeelement2, i, i2, i4, i5, OfficeView.mElementId);
            String str = "image" + OfficeView.mElementId + ".png";
            VoiceUtils voiceUtils = VoiceUtils.INSTANCE;
            SpenObjectBase spenObjectBase2 = this.mObject;
            Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectVoice");
            String attachedFile = ((SpenObjectVoice) spenObjectBase2).getAttachedFile();
            Intrinsics.checkNotNull(attachedFile);
            Intrinsics.checkNotNull(slideShow);
            PackagePart packagePartWriteFile = voiceUtils.writeFile(attachedFile, slideShow, this.mView.mInsertHelper.getVoiceHashMap(), this.mView.mInsertHelper.getPartHashMap());
            if (packagePartWriteFile == null) {
                return;
            }
            OfficeElement officeelement3 = this.mElement;
            Intrinsics.checkNotNull(officeelement3);
            voiceUtils.addAudio((XSLFSlide) officeelement3, packagePartWriteFile, cTPictureCreatePicture, 0.0d);
            OfficeElement officeelement4 = this.mElement;
            Intrinsics.checkNotNull(officeelement4);
            voiceUtils.addTimingInfo((XSLFSlide) officeelement4, cTPictureCreatePicture);
            HashMap<String, SpenObjectBase> imageHashMap = this.mView.mInsertHelper.getImageHashMap();
            Intrinsics.checkNotNull(imageHashMap);
            SpenObjectBase spenObjectBase3 = this.mObject;
            Intrinsics.checkNotNull(spenObjectBase3, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectVoice");
            imageHashMap.put(str, (SpenObjectVoice) spenObjectBase3);
        } catch (Exception e) {
            Logger.m10999d(TAG, "Add sound into pptx error : " + e);
        }
    }
}
