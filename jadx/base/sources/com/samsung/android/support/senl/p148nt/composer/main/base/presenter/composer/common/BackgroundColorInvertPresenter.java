package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common;

import android.text.format.DateFormat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BackgroundColorInvertPresenter {
    private static final String TAG = Logger.createTag("BackgroundColorInvertPresenter");
    private final ComposerModel mComposerModel;
    private final NoteManager mNoteManager;

    public BackgroundColorInvertPresenter(NoteManager noteManager, ComposerModel composerModel) {
        this.mNoteManager = noteManager;
        this.mComposerModel = composerModel;
    }

    private boolean isCreatedBeforeBgInvertBaseTime() {
        long createdTime = this.mComposerModel.getNotesDocEntityManager().getCreatedTime();
        long composerBgInvertBaseTimeForPDF = getComposerBgInvertBaseTimeForPDF();
        if (createdTime <= 0 || createdTime >= composerBgInvertBaseTimeForPDF) {
            return false;
        }
        Logger.m11003i(TAG, "isCreatedBeforeBgInvertBaseTime# The createTime is before " + DateFormat.format("yyyy/MM/dd HH:mm", new Date(composerBgInvertBaseTimeForPDF)).toString());
        return true;
    }

    public boolean canEnableInvertLayout() {
        if (BackgroundColorUtil.getSettingDarkModeNote() != 0) {
            return false;
        }
        if (isCreatedBeforeBgInvertBaseTime()) {
            return true;
        }
        if (!BackgroundColorUtil.hasBackgroundImage(this.mNoteManager.getNote().getPageList())) {
            Logger.m11003i(TAG, "canEnableInvertLayout# The doc does not have the backgroundImages.");
            return true;
        }
        if (!this.mComposerModel.isFirstBackgroundColorInverted()) {
            return false;
        }
        Logger.m11003i(TAG, "canEnableInvertLayout# isFirstBackgroundColorInverted is true.");
        return true;
    }

    public long getComposerBgInvertBaseTimeForPDF() {
        return SharedPreferencesCompat.getInstance("Settings").getLong(SettingsConstants.SETTINGS_COMPOSER_BG_INVERT_BASE_TIME_FOR_PDF, -1L);
    }

    public void invertBackgroundColor(boolean z) {
        String str = TAG;
        AbstractC8014b.m7224z("invertBackgroundColor# ", str, z);
        if (z) {
            if (isCreatedBeforeBgInvertBaseTime()) {
                Logger.m11002f(str, "invertBackgroundColor# isCreatedBeforeBgInvertBaseTime is true");
            } else if (this.mComposerModel.isFirstBackgroundColorInverted()) {
                Logger.m11002f(str, "invertBackgroundColor# isFirstBackgroundColorInverted is true.");
            }
        }
        this.mNoteManager.invertBackgroundColor(z);
        this.mComposerModel.getNotesDocEntityManager().invertBackgroundColor(z);
    }

    public boolean isBackgroundColorInverted() {
        return this.mNoteManager.isBackgroundColorInverted();
    }

    public void updateInvertBackgroundColor() {
        this.mNoteManager.updateInvertBackgroundColor();
    }
}
