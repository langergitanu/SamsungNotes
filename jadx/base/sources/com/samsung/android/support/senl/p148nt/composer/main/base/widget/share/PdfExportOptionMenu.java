package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfExportOptionMenu {
    private static final String TAG = Logger.createTag("PdfExportOptionMenu");
    protected PopupWindow.OnDismissListener mOnDismissListener;
    protected AbsPopupMenu.OnItemClickListener mOnItemClickListener;
    TaskMakePdf.PdfShareType mPdfShareType;
    protected PopupWindow mPopupMenu;

    /* JADX INFO: Access modifiers changed from: private */
    public String getTag() {
        return TAG;
    }

    private void initOnClickListener(final View view) {
        View viewFindViewById = view.findViewById(C9086R.id.format_standard);
        View viewFindViewById2 = view.findViewById(C9086R.id.format_notes_compatible);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.PdfExportOptionMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PdfExportOptionMenu pdfExportOptionMenu = PdfExportOptionMenu.this;
                pdfExportOptionMenu.mPdfShareType = TaskMakePdf.PdfShareType.STANDARD;
                Logger.m10999d(pdfExportOptionMenu.getTag(), "onClick# which: " + view.getContext().getString(PdfExportOptionMenu.this.mPdfShareType.resId));
                UserInputSkipper.setHoldingEventTime(2000L, UserInputSkipper.Tag.ShareViaChooser);
                AbsPopupMenu.OnItemClickListener onItemClickListener = PdfExportOptionMenu.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick();
                }
                PdfExportOptionMenu.this.mPopupMenu.dismiss();
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.PdfExportOptionMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PdfExportOptionMenu pdfExportOptionMenu = PdfExportOptionMenu.this;
                pdfExportOptionMenu.mPdfShareType = TaskMakePdf.PdfShareType.NOTES_COMPAT;
                Logger.m10999d(pdfExportOptionMenu.getTag(), "onClick# which: " + view.getContext().getString(PdfExportOptionMenu.this.mPdfShareType.resId));
                UserInputSkipper.setHoldingEventTime(2000L, UserInputSkipper.Tag.ShareViaChooser);
                AbsPopupMenu.OnItemClickListener onItemClickListener = PdfExportOptionMenu.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick();
                }
                PdfExportOptionMenu.this.mPopupMenu.dismiss();
            }
        });
    }

    private void initPopupMenu(Activity activity) {
        View viewInflate = View.inflate(activity, C9086R.layout.comp_pdf_export_option_popup_layout, null);
        BackgroundColorUtil.setBlurInfoPopup(activity, viewInflate);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        this.mPopupMenu = popupWindow;
        PopupWindowHelper.setDefaultState(popupWindow, activity);
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            this.mPopupMenu.setOnDismissListener(onDismissListener);
        }
        initOnClickListener((ViewGroup) viewInflate.findViewById(C9086R.id.pdf_export_option_container));
    }

    public TaskMakePdf.PdfShareType getShareType() {
        return this.mPdfShareType;
    }

    public void hidePopupMenu() {
        Logger.m11003i(getTag(), "hidePopupMenu#");
        if (isShowingPopupMenu()) {
            this.mPopupMenu.dismiss();
        }
    }

    public boolean isShowingPopupMenu() {
        PopupWindow popupWindow = this.mPopupMenu;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnItemClickListener(AbsPopupMenu.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void showPopupMenu(Activity activity, View view) {
        Logger.m11003i(getTag(), "showPopupMenu#");
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11000e(getTag(), "showPopupMenu# isDestroyed");
            return;
        }
        if (isShowingPopupMenu()) {
            Logger.m11000e(getTag(), "showPopupMenu# isShowing()");
            this.mPopupMenu.dismiss();
            this.mPopupMenu = null;
        } else {
            if (view == null) {
                Logger.m11000e(getTag(), "showPopupMenu# anchorView is null");
                return;
            }
            initPopupMenu(activity);
            if (this.mPopupMenu != null) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (view.getParent() instanceof BottomNavigationMenuView) {
                    this.mPopupMenu.showAtLocation(view, 8388691, iArr[0], 0);
                } else {
                    PopupWindow popupWindow = this.mPopupMenu;
                    popupWindow.showAtLocation(view, 0, iArr[0], iArr[1] - popupWindow.getHeight());
                }
            }
        }
    }
}
