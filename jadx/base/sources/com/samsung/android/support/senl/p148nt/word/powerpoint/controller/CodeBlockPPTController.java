package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.PPTUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0010B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/CodeBlockPPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;)V", "processItem", "", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CodeBlockPPTController extends ItemController<XSLFSlide> {
    private static final String TAG = Logger.createTag("CodeBlockPPTController");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeBlockPPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @NotNull SpenObjectBase objectBase, @NotNull OfficeView<?, ?> view, @NotNull SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide) {
        super(spenBodyTextContext, objectBase, view, spenWPage, xSLFSlide, true);
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        Logger.m11003i(TAG, "processItem# CodeBlock");
        calculateSize();
        OfficeView.INSTANCE.increaseElementId();
        XSLFSlide xSLFSlide = (XSLFSlide) this.mElement;
        if (xSLFSlide != null) {
            PPTUtils.INSTANCE.createPicture(xSLFSlide, (int) this.left, (int) this.top, (int) this.width, (int) this.height, OfficeView.mElementId);
        }
        String strM767i = AbstractC0541b.m767i(OfficeView.mElementId, "image", ".png");
        HashMap<String, SpenObjectCodeBlock> codeBlockHashMap = this.mView.mInsertHelper.getCodeBlockHashMap();
        Intrinsics.checkNotNull(codeBlockHashMap);
        SpenObjectBase spenObjectBase = this.mObject;
        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectCodeBlock");
        codeBlockHashMap.put(strM767i, (SpenObjectCodeBlock) spenObjectBase);
    }
}
