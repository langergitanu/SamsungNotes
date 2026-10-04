package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.dialog.MeridianDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.concurrent.ExecutorService;
import p012C1.RunnableC0045a;
import p042J1.C0145c;
import p044K.C0158a;
import p045K0.InterfaceC0160a;
import p192j1.C12936a;
import p207n1.C13540g;
import p207n1.C13541h;
import p212o1.C13573a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MicrosoftHelper {
    public static final String TAG = "MicrosoftHelper";
    private final IPresenter mIPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void addMicrosoftAccountLoginTipCard();

        AbsFragment getAbsFragment();

        int getModeIndex();

        void showMeridianDialog(MeridianDialogFragment.DialogListener dialogListener);

        void startMeridianSettingProcess();
    }

    public MicrosoftHelper(IPresenter iPresenter) {
        this.mIPresenter = iPresenter;
    }

    private boolean checkSkipTipcard(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
        long j = sharedPreferences != null ? sharedPreferences.getLong("PREF_VALUE_DISCARD", 0L) : 0L;
        if (j == 0) {
            MainLogger.m7258i(TAG, "checkMeridianDialog# false - skip. ");
            return true;
        }
        if (System.currentTimeMillis() - j >= 604800000) {
            return false;
        }
        MainLogger.m7258i(TAG, "checkMeridianDialog# false - operate only once a day. So skip. ");
        return true;
    }

    private boolean isMeridianAlreadyJoined(Context context) {
        C6785g c6785g = AbstractC6784f.f4180a;
        c6785g.m4946f();
        if (!c6785g.f4185e) {
            return false;
        }
        MainLogger.m7258i(TAG, "checkMeridianDialog# already login");
        C13573a.m14384j(context, false);
        return true;
    }

    private boolean isMeridianDialogExist() {
        MeridianDialogFragment meridianDialogFragment = (MeridianDialogFragment) this.mIPresenter.getAbsFragment().getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.MERIDIAN_DIALOG);
        if (meridianDialogFragment == null || !meridianDialogFragment.isResumed() || !meridianDialogFragment.isAdded()) {
            return false;
        }
        MainLogger.m7258i(TAG, "checkMeridianDialog# already showing");
        return true;
    }

    private void showMeridianDialog(final Context context) {
        CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_FEED_MS_SS_LINKED);
        if (isMeridianDialogExist() || isMeridianAlreadyJoined(context) || !((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return;
        }
        this.mIPresenter.showMeridianDialog(new MeridianDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.2
            @Override // com.samsung.android.support.senl.nt.app.common.dialog.MeridianDialogFragment.DialogListener
            public void onCancel() {
                C13573a.m14384j(context, false);
                Context context2 = context;
                long jCurrentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = context2.getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("PREF_VALUE_DISCARD", jCurrentTimeMillis).apply();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.common.dialog.MeridianDialogFragment.DialogListener
            public void onConfirm() {
                C13573a.m14384j(context, false);
                MicrosoftHelper.this.connectMsLoginProcessStarted();
            }
        });
    }

    private void showMeridianTipcardAfterMeridianDialog(Context context) {
        if (checkSkipTipcard(context)) {
            return;
        }
        C12936a.m13839c().getClass();
        if (!C12936a.m13842g() || !NotesUtils.isMsSyncSupported() || DeviceUtils.isDemoDevice(context)) {
            MainLogger.m7258i(TAG, "checkMeridianDialog# false - device condition");
            return;
        }
        if (TipCardUtil.isMicrosoftLoginTipcardCanceled()) {
            MainLogger.m7258i(TAG, "checkMeridianDialog# false - tipCard already shown");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("PREF_VALUE_DISCARD", jCurrentTimeMillis).apply();
        }
        C13573a c13573a = new C13573a(5, false);
        ExecutorService executorServiceM3201k = AbstractC4539a.m3201k("OnenoteAccountLinkingStatusManager");
        c13573a.f9635b = executorServiceM3201k;
        executorServiceM3201k.execute(new RunnableC0045a(c13573a, new InterfaceC0160a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.1
            @Override // p045K0.InterfaceC0160a
            public void onFinished(boolean z) {
                if (z) {
                    return;
                }
                MicrosoftHelper.this.mIPresenter.addMicrosoftAccountLoginTipCard();
            }
        }, 2));
    }

    public void checkMeridianDialog(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
        if (sharedPreferences != null ? sharedPreferences.getBoolean("PREF_VALUE_ACTIVATED", false) : false) {
            showMeridianDialog(context);
        } else {
            showMeridianTipcardAfterMeridianDialog(context);
        }
    }

    public void connectMsLoginProcessStarted() {
        if (C0158a.m407a().m416i()) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (!C0145c.m334s(applicationContext)) {
                ToastHandler.show(applicationContext, applicationContext.getResources().getString(C8003R.string.settings_sync_to_ms_network_connection_error_msg), 0, false);
                return;
            }
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_FEED_HALFSHEET_GET_STARTED);
            C13573a.m14385k(applicationContext, 1);
            CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_MS_LOGIN, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_GET_STARTED);
            this.mIPresenter.startMeridianSettingProcess();
        }
    }
}
