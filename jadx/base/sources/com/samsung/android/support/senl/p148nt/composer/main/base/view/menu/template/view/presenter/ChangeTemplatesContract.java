package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ChangeTemplatesContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ItemPresenter {
        File getAddedTemplatesFolder();

        File getDefaultPdfTemplatesFolder();

        void loadItemData();

        void onOpenTemplateEditor(String str, int i, int i2);

        void updateAllItems();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface View {
        Fragment getFragment();

        DocumentPageRatio.PageRatioType getPageRatioType();

        void onAllItemUpdated();

        void onItemClicked(int i);

        boolean onItemLongPressed(int i);

        void onOpenChooser(int i, DocumentPageRatio.PageRatioType pageRatioType);

        void onOpenTemplateEditor(String str, String str2, int i, int i2, String str3);

        void onSelectItem(int i, TemplateItem templateItem);

        void scrollToPosition(int i, int i2);
    }
}
