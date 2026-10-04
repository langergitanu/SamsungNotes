package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller;

import android.os.Handler;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$objectEventListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$SpenObjectEventListener;", "onObjectRemoved", "", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "historyEventType", "", "onObjectChanged", "changedInfo", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplateController$objectEventListener$1 extends DynamicTemplateController.SpenObjectEventListener {
    final /* synthetic */ DynamicTemplateController this$0;

    public DynamicTemplateController$objectEventListener$1(DynamicTemplateController dynamicTemplateController) {
        this.this$0 = dynamicTemplateController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onObjectChanged$lambda$0(DynamicTemplateController dynamicTemplateController, SpenObjectChangedInfo spenObjectChangedInfo) {
        dynamicTemplateController.textController.onObjectChanged(spenObjectChangedInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController.SpenObjectEventListener, com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectChanged(SpenWPage page, SpenObjectChangedInfo changedInfo, int historyEventType) {
        ComposerViewPresenter composerViewPresenter;
        Handler handler;
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        super.onObjectChanged(page, changedInfo, historyEventType);
        SpenObjectBase spenObjectBase = changedInfo.objectBase;
        if (spenObjectBase instanceof SpenObjectImage) {
            this.this$0.imageController.onObjectChanged(spenObjectBase);
        } else {
            if (!(spenObjectBase instanceof SpenObjectTextBox) || (composerViewPresenter = this.this$0.composerViewPresenter) == null || (handler = composerViewPresenter.getHandler()) == null) {
                return;
            }
            handler.post(new RunnableC9844c(this.this$0, changedInfo, 3));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController.SpenObjectEventListener, com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectRemoved(SpenWPage page, ArrayList<SpenObjectBase> objectList, int historyEventType) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            TextUtils.isEmpty(next.getExtraDataString(Constant.KEY_OBJECT_ID));
        }
    }
}
