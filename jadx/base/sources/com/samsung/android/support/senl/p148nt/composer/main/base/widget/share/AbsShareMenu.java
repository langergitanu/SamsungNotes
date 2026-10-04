package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsShareMenu {
    protected View mAnchorView;
    protected PdfExportOptionMenu mPdfExportOptionMenu;
    protected AbsPopupMenu mPdfPopupMenu;
    protected AbsPopupMenu mSharePopupMenu;
    protected AbsPopupMenu mWordPopupMenu;

    private void sendSALog(ShareMenuContract.ShareType shareType) {
        ComposerSA.insertLog("741", getSALogEventId(), shareType == ShareMenuContract.ShareType.SDOC ? "1" : shareType == ShareMenuContract.ShareType.PDF ? "2" : shareType == ShareMenuContract.ShareType.DOC ? "3" : shareType == ShareMenuContract.ShareType.PPTX ? "4" : shareType == ShareMenuContract.ShareType.IMAGE ? "5" : shareType == ShareMenuContract.ShareType.TEXT ? "6" : "");
    }

    public void executeShareSaveNote(ShareMenuContract.Presenter presenter) {
        presenter.executeShareNote();
    }

    public PopupWindow.OnDismissListener getOnDismissListener() {
        return null;
    }

    public abstract String getSALogEventId();

    public abstract String getTag();

    public String getTitle(Activity activity) {
        return "";
    }

    public void hidePopupMenu() {
        Logger.m11003i(getTag(), "hidePopupMenu#");
        AbsPopupMenu absPopupMenu = this.mSharePopupMenu;
        if (absPopupMenu != null) {
            absPopupMenu.hidePopupMenu();
        }
        AbsPopupMenu absPopupMenu2 = this.mPdfPopupMenu;
        if (absPopupMenu2 != null) {
            absPopupMenu2.hidePopupMenu();
        }
        PdfExportOptionMenu pdfExportOptionMenu = this.mPdfExportOptionMenu;
        if (pdfExportOptionMenu != null) {
            pdfExportOptionMenu.hidePopupMenu();
        }
        AbsPopupMenu absPopupMenu3 = this.mWordPopupMenu;
        if (absPopupMenu3 != null) {
            absPopupMenu3.hidePopupMenu();
        }
    }

    public void onItemClick(Activity activity, ShareMenuContract.Presenter presenter, ShareMenuContract.ShareType shareType) {
        presenter.stopRecordAndAudio();
        presenter.setShareType(shareType);
        if (shareType == ShareMenuContract.ShareType.DOC) {
            shareWord(activity, presenter);
        } else if (shareType == ShareMenuContract.ShareType.PDF) {
            showPdfExportOptionMenu(activity, presenter);
        } else {
            executeShareSaveNote(presenter);
        }
        sendSALog(shareType);
    }

    public void shareWord(Activity activity, ShareMenuContract.Presenter presenter) {
        if (presenter.canShowWordExportOption()) {
            showWordPopupMenu(activity, presenter);
        } else {
            SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_EXPORT, 1);
            executeShareSaveNote(presenter);
        }
    }

    public void showPdfExportOptionMenu(Activity activity, final ShareMenuContract.Presenter presenter) {
        Logger.m11003i(getTag(), "showPdfExportOptionMenu#");
        if (this.mPdfExportOptionMenu == null) {
            this.mPdfExportOptionMenu = new PdfExportOptionMenu();
        }
        this.mPdfExportOptionMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsShareMenu.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                TaskMakePdf.PdfShareType shareType = AbsShareMenu.this.mPdfExportOptionMenu.getShareType();
                presenter.setPdfShareType(shareType);
                AbsShareMenu.this.executeShareSaveNote(presenter);
                if (shareType == TaskMakePdf.PdfShareType.NOTES_COMPAT) {
                    ComposerSA.insertLog("401", "COMP0001", "a");
                } else if (shareType == TaskMakePdf.PdfShareType.STANDARD) {
                    ComposerSA.insertLog("401", "COMP0001", "b");
                }
            }
        });
        this.mPdfExportOptionMenu.setOnDismissListener(getOnDismissListener());
        this.mPdfExportOptionMenu.showPopupMenu(activity, this.mAnchorView);
    }

    public void showPdfPopupMenu(Activity activity, final ShareMenuContract.Presenter presenter) {
        Logger.m11003i(getTag(), "showPdfPopupMenu#");
        if (this.mPdfPopupMenu == null) {
            this.mPdfPopupMenu = new PdfTypeMenu();
        }
        this.mPdfPopupMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsShareMenu.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                presenter.setPdfShareType(((PdfTypeMenu) AbsShareMenu.this.mPdfPopupMenu).getShareType());
                AbsShareMenu.this.executeShareSaveNote(presenter);
            }
        });
        this.mPdfPopupMenu.setOnDismissListener(getOnDismissListener());
        this.mPdfPopupMenu.showPopupMenu(activity, this.mAnchorView, getTitle(activity));
    }

    @SuppressLint({"RestrictedApi"})
    public void showPopupMenu(final Activity activity, final ShareMenuContract.Presenter presenter, View view) {
        Logger.m11003i(getTag(), "showPopupMenu#");
        this.mAnchorView = view;
        if (this.mSharePopupMenu == null) {
            this.mSharePopupMenu = new ShareTypeMenu();
        }
        ((ShareTypeMenu) this.mSharePopupMenu).setMenuList(presenter.getShareMenuList());
        this.mSharePopupMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsShareMenu.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                AbsShareMenu absShareMenu = AbsShareMenu.this;
                absShareMenu.onItemClick(activity, presenter, ((ShareTypeMenu) absShareMenu.mSharePopupMenu).getShareType());
            }
        });
        this.mSharePopupMenu.setOnDismissListener(getOnDismissListener());
        this.mSharePopupMenu.showPopupMenu(activity, view, getTitle(activity));
    }

    public void showWordPopupMenu(Activity activity, final ShareMenuContract.Presenter presenter) {
        Logger.m11003i(getTag(), "showWordPopupMenu#");
        if (this.mWordPopupMenu == null) {
            this.mWordPopupMenu = new WordTypeMenu();
        }
        this.mWordPopupMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsShareMenu.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                AbsShareMenu.this.executeShareSaveNote(presenter);
            }
        });
        ((WordTypeMenu) this.mWordPopupMenu).showPopupMenu(activity, this.mAnchorView);
    }
}
