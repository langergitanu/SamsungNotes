package com.samsung.android.support.senl.p148nt.word.word.controller;

import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0012BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/controller/WebWordController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/word/WordView;", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "paragraph", "isObjectSpan", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/word/WordView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;Z)V", "processItem", "", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WebWordController extends ItemController<XWPFParagraph> {
    private static final String TAG = Logger.createTag("WebWordController");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebWordController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @Nullable WordView wordView, @Nullable SpenWPage spenWPage, @Nullable XWPFParagraph xWPFParagraph, boolean z) {
        super(spenBodyTextContext, spenObjectBase, wordView, spenWPage, xWPFParagraph, z);
        Intrinsics.checkNotNull(spenObjectBase);
        Intrinsics.checkNotNull(wordView);
        Intrinsics.checkNotNull(spenWPage);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        CTNonVisualDrawingProps docPr;
        try {
            ItemController.XWPFRunData xWPFRun = getXWPFRun(getObjectRectF());
            CTDrawing ctDrawing = xWPFRun.getCtDrawing();
            HashMap<String, SpenObjectBase> imageHashMap = this.mView.mInsertHelper.getImageHashMap();
            Intrinsics.checkNotNull(imageHashMap);
            String str = "image" + OfficeView.mElementId + ".png";
            SpenObjectBase spenObjectBase = this.mObject;
            Intrinsics.checkNotNull(spenObjectBase);
            imageHashMap.put(str, spenObjectBase);
            Intrinsics.checkNotNull(ctDrawing);
            CTAnchor anchorArray = ctDrawing.getAnchorArray(0);
            if (anchorArray == null || (docPr = anchorArray.getDocPr()) == null) {
                return;
            }
            OfficeView.INSTANCE.increaseElementId();
            String str2 = "rId" + OfficeView.mElementId;
            PackagePart packagePart = xWPFRun.getRun().getDocument().getPackagePart();
            SpenObjectBase spenObjectBase2 = this.mObject;
            Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectWeb");
            packagePart.addExternalRelationship(((SpenObjectWeb) spenObjectBase2).getUri(), XWPFRelation.HYPERLINK.getRelation(), str2);
            docPr.addNewHlinkClick().setId(str2);
            ctDrawing.setAnchorArray(new CTAnchor[]{anchorArray});
            if (this.isObjectSpan) {
                return;
            }
            ctDrawing.removeInline(0);
        } catch (Exception e) {
            AbstractC8014b.m7207i("process Web, e:", e, TAG);
        }
    }
}
