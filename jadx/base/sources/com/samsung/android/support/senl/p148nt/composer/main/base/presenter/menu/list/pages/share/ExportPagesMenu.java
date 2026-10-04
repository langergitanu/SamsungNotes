package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExportPagesMenu extends SharePagesMenu {
    private static final String TAG = Logger.createTag("ExportPagesPopupMenu");

    public ExportPagesMenu(SharePagesMenu.OptionMenuListener optionMenuListener) {
        super(optionMenuListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public void executeShareSaveNote(ShareMenuContract.Presenter presenter) {
        presenter.executeSaveDirectoryPicker();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu, com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getSALogEventId() {
        return ComposerSAConstants.EVENT_DIALOGS_SAVEAS_AS_DETAIL;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu, com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu, com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getTitle(Activity activity) {
        return activity.getString(C9086R.string.composer_save_as_file_title);
    }
}
