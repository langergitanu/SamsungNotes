package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share;

import android.app.Activity;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SharePagesMenu extends AbsShareMenu {
    private static final String TAG = Logger.createTag("SharePagesPopupMenu");
    protected final OptionMenuListener mOptionMenuListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OptionMenuListener {
        void onDismiss(boolean z);
    }

    public SharePagesMenu(@Nullable OptionMenuListener optionMenuListener) {
        this.mOptionMenuListener = optionMenuListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public PopupWindow.OnDismissListener getOnDismissListener() {
        return new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                SharePagesMenu sharePagesMenu = SharePagesMenu.this;
                OptionMenuListener optionMenuListener = sharePagesMenu.mOptionMenuListener;
                if (optionMenuListener != null) {
                    optionMenuListener.onDismiss(((AbsShareMenu) sharePagesMenu).mPdfPopupMenu == null || !((AbsShareMenu) SharePagesMenu.this).mPdfPopupMenu.isShowingPopupMenu());
                }
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getSALogEventId() {
        return ComposerSAConstants.EVENT_DIALOGS_SHARE_AS_DETAIL;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getTitle(Activity activity) {
        return activity.getString(C9086R.string.composer_share_title);
    }
}
