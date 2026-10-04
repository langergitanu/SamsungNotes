package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item;

import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.PdfTemplatePresenterUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomItemData extends ItemData {
    private static final String TAG = CTLogger.createTag("CustomItemData");

    public CustomItemData() {
        Logger.m10999d(TAG, "initCustomItem");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.ItemData
    public boolean isSelectedTemplateItem(String str, TemplateItem templateItem) {
        return PdfTemplatePresenterUtil.isSelectedTemplateItem(str, templateItem);
    }
}
