package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface OnItemActionListener {
    default void onAddTemplate(boolean z) {
    }

    void onDeleteDone(boolean z, boolean z2);

    default void onDeleteTemplate(List<TemplateItem> list) {
    }

    boolean onDownloadTemplate(Context context, TemplateItem templateItem);

    default void onItemClicked(int i) {
    }

    default boolean onItemLongPressed(int i) {
        return true;
    }

    void onSelectTemplate(int i, TemplateItem templateItem);

    default void onShowTemplatePreviewDialog(Context context, TemplateItem templateItem) {
    }
}
