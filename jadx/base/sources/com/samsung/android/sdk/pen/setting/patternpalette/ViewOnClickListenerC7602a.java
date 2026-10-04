package com.samsung.android.sdk.pen.setting.patternpalette;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.RecentSearchView;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMiscHelper;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceNotificationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpicker.QTColorDetailLayout;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.patternpalette.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7602a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5071a;

    public /* synthetic */ ViewOnClickListenerC7602a(int i) {
        this.f5071a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5071a) {
            case 0:
                SpenMosaicPatternLayout.updateView$lambda$4$lambda$3(view);
                break;
            case 1:
                CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_VERIFY_PASSWORD_SCREEN, LockConstants.SA_LOG_VERIFY_PASSWORD_EVENT_USE_BIOMETRICS);
                break;
            case 2:
                RecentSearchView.mClearClickListener$lambda$0(view);
                break;
            case 3:
                SettingsMiscHelper.initTipCard$lambda$0(view);
                break;
            case 4:
                VoiceNotificationHelper.initializeButtons$lambda$6(view);
                break;
            case 5:
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TEXT_RECOGNITION, ComposerSAConstants.EVENT_DIALOGS_TEXT_RECOGNITION_INSERT_INFO, "a");
                break;
            case 6:
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TEXT_RECOGNITION, ComposerSAConstants.EVENT_DIALOGS_TEXT_RECOGNITION_INSERT_INFO, "b");
                break;
            case 7:
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TAG_RENAME, "7906");
                break;
            default:
                QTColorDetailLayout.setupColorPreview$lambda$1(view);
                break;
        }
    }
}
