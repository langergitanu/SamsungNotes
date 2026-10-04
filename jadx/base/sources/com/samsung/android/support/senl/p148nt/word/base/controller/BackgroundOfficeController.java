package com.samsung.android.support.senl.p148nt.word.base.controller;

import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.OfficeCropHeight;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\nH$J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\"\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H$R\u001a\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00028\u00008\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/controller/BackgroundOfficeController;", "OfficeElement", "", "mView", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "mElement", "<init>", "(Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getTag", "", "addBackground", "", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "indexPage", "", "currentHeight", "addBackgroundToView", "width", "height", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BackgroundOfficeController<OfficeElement> {

    @JvmField
    protected OfficeElement mElement;

    @JvmField
    @NotNull
    protected OfficeView<?, ?> mView;

    public BackgroundOfficeController(@NotNull OfficeView<?, ?> mView, OfficeElement officeelement) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.mElement = officeelement;
    }

    public final void addBackground(@NotNull SpenWPage spenWPage, int indexPage, int currentHeight) {
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
        Logger.m10999d(getTag(), "addBackground()");
        try {
            OfficeParams officeParams = this.mView.mDocParams;
            int width = officeParams.height;
            int i = officeParams.width;
            if (spenWPage.hasPDF()) {
                int height = spenWPage.getHeight();
                OfficeView<?, ?> officeView = this.mView;
                if (officeView.isContinuousPage) {
                    height = currentHeight - officeView.prevHeight;
                }
                int width2 = (spenWPage.getWidth() * width) / height;
                int i2 = this.mView.mDocParams.width;
                if (width2 > i2) {
                    width = (height * i2) / spenWPage.getWidth();
                    i = i2;
                } else {
                    i = width2;
                }
            }
            String strAddBackgroundToView = addBackgroundToView(i, width, indexPage);
            OfficeView<?, ?> officeView2 = this.mView;
            if (officeView2.isContinuousPage) {
                HashMap<String, OfficeCropHeight> cropBg = officeView2.mInsertHelper.getCropBg();
                Intrinsics.checkNotNull(cropBg);
                Intrinsics.checkNotNull(strAddBackgroundToView);
                cropBg.put(strAddBackgroundToView, new OfficeCropHeight(this.mView.prevHeight, currentHeight));
            }
            Logger.m10999d(getTag(), "End background, height : " + currentHeight);
        } catch (Exception e) {
            AbstractC8014b.m7207i("Add background error : ", e, getTag());
        }
    }

    @Nullable
    public abstract String addBackgroundToView(int width, int height, int indexPage);

    @NotNull
    public abstract String getTag();
}
