package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfTypeMenu extends AbsPopupMenu {
    private static final String TAG = Logger.createTag("PdfTypeMenu");
    TaskMakePdf.PdfShareType mPdfShareType;
    LinkedHashMap<TaskMakePdf.PdfShareType, String> mPdfShareTypeItems = null;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public ArrayList<String> getMenuItems() {
        return new ArrayList<>(this.mPdfShareTypeItems.values());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.PdfTypeMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue < PdfTypeMenu.this.mPdfShareTypeItems.size()) {
                    PdfTypeMenu pdfTypeMenu = PdfTypeMenu.this;
                    pdfTypeMenu.mPdfShareType = (TaskMakePdf.PdfShareType) pdfTypeMenu.mPdfShareTypeItems.keySet().toArray()[iIntValue];
                    String tag = PdfTypeMenu.this.getTag();
                    StringBuilder sb = new StringBuilder("onClick# which: ");
                    PdfTypeMenu pdfTypeMenu2 = PdfTypeMenu.this;
                    AbstractC8014b.m7213o(sb, pdfTypeMenu2.mPdfShareTypeItems.get(pdfTypeMenu2.mPdfShareType), tag);
                    UserInputSkipper.setHoldingEventTime(2000L, UserInputSkipper.Tag.ShareViaChooser);
                    AbsPopupMenu.OnItemClickListener onItemClickListener = PdfTypeMenu.this.mOnItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick();
                    }
                }
                PdfTypeMenu.this.mPopupMenu.dismiss();
            }
        };
    }

    public TaskMakePdf.PdfShareType getShareType() {
        return this.mPdfShareType;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public void initShareTypeItems(Activity activity) {
        if (this.mPdfShareTypeItems != null) {
            return;
        }
        LinkedHashMap<TaskMakePdf.PdfShareType, String> linkedHashMap = new LinkedHashMap<>();
        this.mPdfShareTypeItems = linkedHashMap;
        TaskMakePdf.PdfShareType pdfShareType = TaskMakePdf.PdfShareType.NOTES_COMPAT;
        linkedHashMap.put(pdfShareType, activity.getString(pdfShareType.resId));
        LinkedHashMap<TaskMakePdf.PdfShareType, String> linkedHashMap2 = this.mPdfShareTypeItems;
        TaskMakePdf.PdfShareType pdfShareType2 = TaskMakePdf.PdfShareType.STANDARD;
        linkedHashMap2.put(pdfShareType2, activity.getString(pdfShareType2.resId));
    }
}
