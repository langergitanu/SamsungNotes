package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuExport extends AbsOptionMenuShare {
    private static final String TAG = Logger.createTag("OptionMenuExport");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public void executeShareSaveNote(ShareMenuContract.Presenter presenter) {
        presenter.executeSaveDirectoryPicker();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getSALogEventId() {
        return ComposerSAConstants.EVENT_DIALOGS_SAVEAS_AS_DETAIL;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu
    public String getTitle(Activity activity) {
        return activity.getString(C9086R.string.composer_save_as_file_title);
    }

    public void setExportMenu(OptionMenuBehavior optionMenuBehavior, Activity activity, OptionMenuParam optionMenuParam, boolean z) {
        if ((!z || DeviceUtils.isSupportedFileProvider()) && !EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(activity)) {
            optionMenuBehavior.setEnabledMenu(optionMenuParam.setChildResId(C9086R.id.action_export), true);
        } else {
            optionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_export));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.AbsOptionMenuShare
    public /* bridge */ /* synthetic */ void showPopupMenu(Activity activity, OptionMenuSharePresenter optionMenuSharePresenter) {
        super.showPopupMenu(activity, optionMenuSharePresenter);
    }
}
