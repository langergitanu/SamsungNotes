package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupNetworkUtils {
    private static final String TAG = "GcsGroupNetworkUtils";
    private static final Map<Integer, Boolean> mIsGoToSettingDialogShowing = new HashMap();

    public static boolean checkCoeditNetworkConnection(Activity activity, GcsConstants.RequestType requestType, boolean z) {
        if (!checkNetworkConnection(activity.getApplicationContext(), requestType, z)) {
            return false;
        }
        if (!CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
            return true;
        }
        MainCoeditLogger.m7253i(TAG, "checkCoeditNetworkConnection# return - wifi only");
        if (requestType != GcsConstants.RequestType.None) {
            showGoToSettingsDialog(new WeakReference(activity));
        }
        return false;
    }

    public static boolean checkCoeditSessionConnection(Activity activity, GcsConstants.RequestType requestType, boolean z) {
        if (!checkCoeditNetworkConnection(activity, requestType, z)) {
            return false;
        }
        if (C6715o.m4808q().m4801j()) {
            return true;
        }
        showUnknownFailToast(activity.getApplicationContext(), requestType, z);
        return false;
    }

    public static boolean checkNetworkConnection(Context context, GcsConstants.RequestType requestType, boolean z) {
        if (C0145c.m334s(context)) {
            return true;
        }
        showDisplayMessageToast(context, z ? requestType.standaloneNetworkFail : requestType.spaceNetworkFail);
        return false;
    }

    public static void showDisplayMessageToast(Context context, int i) {
        if (i < 0) {
            return;
        }
        showDisplayMessageToast(context, context.getString(i));
    }

    public static void showGoToSettingsDialog(final WeakReference<Activity> weakReference) {
        if (weakReference == null) {
            return;
        }
        final Activity activity = weakReference.get();
        if (Boolean.TRUE.equals(mIsGoToSettingDialogShowing.get(Integer.valueOf(activity.hashCode())))) {
            MainCoeditLogger.m7251e(TAG, "showGoToSettingsDialog# is already showing");
            weakReference.clear();
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(300L, tag);
                    if (CommonUtil.isNotAvailableActivity(activity)) {
                        MainCoeditLogger.m7251e(GcsGroupNetworkUtils.TAG, "showGoToSettingsDialog[1]# isNotAvailableActivity");
                        return;
                    }
                    NotesSamsungAnalytics.insertLog(null, NotesSAConstants.EVENT_COEDIT_GO_TO_SETTINGS);
                    try {
                        Intent intent = new Intent(BaseUtils.getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
                        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
                        intent.putExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE);
                        PopOverActivityWrapper.startActivity(activity, intent, 4);
                    } catch (NullPointerException e) {
                        MainCoeditLogger.m7251e(GcsGroupNetworkUtils.TAG, "showGoToSettingsDialog# " + e.getMessage());
                    }
                }
            }
        };
        final AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(activity);
        alertDialogBuilderForAppCompat.setMessage(C8003R.string.co_edit_connect_to_wifi_or_allow_mobile_data);
        alertDialogBuilderForAppCompat.setPositiveButton(C8003R.string.co_edit_go_to_settings, onClickListener);
        activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils.3
            @Override // java.lang.Runnable
            public void run() {
                if (CommonUtil.isNotAvailableActivity(activity)) {
                    MainCoeditLogger.m7251e(GcsGroupNetworkUtils.TAG, "showGoToSettingsDialog[2]# isNotAvailableActivity");
                    return;
                }
                AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
                alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils.3.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        GcsGroupNetworkUtils.mIsGoToSettingDialogShowing.put(Integer.valueOf(activity.hashCode()), Boolean.FALSE);
                        weakReference.clear();
                    }
                });
                alertDialogCreate.show();
                NotesSamsungAnalytics.insertLog(null, NotesSAConstants.EVENT_COEDIT_WI_FI_NETWORK_PROBLEM);
                GcsGroupNetworkUtils.mIsGoToSettingDialogShowing.put(Integer.valueOf(activity.hashCode()), Boolean.TRUE);
            }
        });
    }

    public static void showUnknownFailToast(Context context, GcsConstants.RequestType requestType, boolean z, int i) {
        if (i == 302) {
            showDisplayMessageToast(context, context.getString(C8003R.string.unable_to_create_note));
        } else {
            showDisplayMessageToast(context, z ? requestType.standaloneServerFail : requestType.spaceServerFail);
        }
    }

    public static void showDisplayMessageToast(final Context context, final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(context, str, 1);
            }
        });
    }

    public static void showUnknownFailToast(Context context, GcsConstants.RequestType requestType, boolean z) {
        showUnknownFailToast(context, requestType, z, -1);
    }
}
