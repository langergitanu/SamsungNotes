package com.samsung.android.support.senl.p148nt.word.word.controller;

import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import com.samsung.android.support.senl.p148nt.word.word.utils.WordUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/controller/ImageWordController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "paragraph", "isObjectSpan", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;Z)V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "processItem", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageWordController extends ItemController<XWPFParagraph> {
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWordController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable OfficeView<?, ?> officeView, @Nullable SpenWPage spenWPage, @Nullable XWPFParagraph xWPFParagraph, boolean z) {
        super(spenBodyTextContext, spenObjectBase, officeView, spenWPage, xWPFParagraph, z);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(officeView);
        Intrinsics.checkNotNull(spenWPage);
        this.TAG = Logger.createTag("ImageWordController");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        try {
            XWPFRun inlineImageRun = this.isObjectSpan ? WordView.INSTANCE.getInlineImageRun(CollectionsKt.indexOf((List<? extends SpenObjectBase>) this.mView.objectSpanOfPage, this.mObject)) : null;
            if (inlineImageRun == null) {
                OfficeElement officeelement = this.mElement;
                Intrinsics.checkNotNull(officeelement);
                inlineImageRun = ((XWPFParagraph) officeelement).getRuns().get(0);
            }
            XWPFRun xWPFRun = inlineImageRun;
            calculateSize();
            SpenObjectBase spenObjectBase = this.mObject;
            boolean z = spenObjectBase != null && spenObjectBase.getLayoutType() == 1;
            OfficeView.INSTANCE.increaseElementId();
            Intrinsics.checkNotNull(xWPFRun);
            CTDrawing cTDrawingAddImageToRun = WordUtils.addImageToRun(xWPFRun, this.left - 42.0d, this.top, this.width, this.height, false, z, this.isObjectSpan, OfficeView.mElementId, 0);
            if (!this.isObjectSpan) {
                Intrinsics.checkNotNull(cTDrawingAddImageToRun);
                cTDrawingAddImageToRun.removeInline(0);
            }
            if (this.mObject != null) {
                HashMap<String, SpenObjectBase> imageHashMap = this.mView.mInsertHelper.getImageHashMap();
                Intrinsics.checkNotNull(imageHashMap);
                String str = "image" + OfficeView.mElementId + ".png";
                SpenObjectBase spenObjectBase2 = this.mObject;
                Intrinsics.checkNotNull(spenObjectBase2);
                imageHashMap.put(str, spenObjectBase2);
            }
        } catch (Exception e) {
            AbstractC8014b.m7207i("process Image, e:", e, this.TAG);
        }
    }
}
