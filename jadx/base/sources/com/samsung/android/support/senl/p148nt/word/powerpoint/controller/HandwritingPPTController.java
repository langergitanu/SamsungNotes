package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.HandwritingOfficeController;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.PPTUtils;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000fB#\u0012\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/HandwritingPPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/HandwritingOfficeController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "xslfShapes", "<init>", "(Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lorg/apache/poi/xslf/usermodel/XSLFSlide;)V", "addHandwritingToView", "", "width", "", "height", "indexPage", "getTag", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HandwritingPPTController extends HandwritingOfficeController<XSLFSlide> {

    @NotNull
    private static final String TAG = "HandwritingPPTController";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandwritingPPTController(@Nullable OfficeView<?, ?> officeView, @Nullable XSLFSlide xSLFSlide) {
        super(officeView, xSLFSlide);
        Intrinsics.checkNotNull(officeView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.HandwritingOfficeController
    @NotNull
    public String addHandwritingToView(int width, int height, int indexPage) throws IOException {
        Logger.m10999d(getTag(), "addHandwritingToView()");
        OfficeView.INSTANCE.increaseElementId();
        XSLFSlide xSLFSlide = (XSLFSlide) this.mElement;
        if (xSLFSlide != null) {
            PPTUtils pPTUtils = PPTUtils.INSTANCE;
            OfficeParams officeParams = this.mView.mDocParams;
            int i = officeParams.marginLeft;
            pPTUtils.createPicture(xSLFSlide, i, officeParams.marginTop, (officeParams.width - i) - officeParams.marginRight, officeParams.height, OfficeView.mElementId);
        }
        String strM767i = AbstractC0541b.m767i(OfficeView.mElementId, "image", ".png");
        Integer numValueOf = Integer.valueOf(indexPage);
        HashMap<String, Integer> hwHashMap = this.mView.mInsertHelper.getHwHashMap();
        Intrinsics.checkNotNull(hwHashMap);
        hwHashMap.put(strM767i, numValueOf);
        return strM767i;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.HandwritingOfficeController
    @NotNull
    public String getTag() {
        return TAG;
    }
}
