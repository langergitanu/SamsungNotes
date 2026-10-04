package com.samsung.android.app.notes.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.app.notes.screenoffmemo.ScreenOffMemoService;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SPenEventBroadcastReceiver extends BroadcastReceiver {
    private static final String DOUBLE_TAP = "com.samsung.action.POPUP_NOTE_DOUBLETAB";
    private static final int PEN_DETACHMENT_OPTION_CREATE_NOTE = 3;
    private static final String TAG = "SPenEventBroadcastReceiver";

    private int getPenDetachmentOption(Context context) {
        int penDetachOption = !PackageManagerCompat.INSTANCE.getInstance().isKMemoPackage(context) ? SettingsCompat.getInstance().getPenDetachOption(context) : 0;
        AbstractC4539a.m3203m(penDetachOption, "getPenDetachmentOption result : ", TAG);
        return penDetachOption;
    }

    private boolean isAllowedReceiveCase(Intent intent) {
        if (intent == null) {
            Logger.m8697d(TAG, "isAllowedReceiveCase# invalid intent");
            return false;
        }
        if (!UserHandleCompat.getInstance().isUserOwner()) {
            Logger.m8697d(TAG, "isAllowedReceiveCase isUserOwner is false");
            return false;
        }
        if (!intent.getBooleanExtra("isBoot", false)) {
            return true;
        }
        Logger.m8697d(TAG, "isAllowedReceiveCase# isBoot");
        return false;
    }

    private boolean isAllowedStartPopupNoteService(Context context) {
        if (isPopupNoteStartedByDetachPen(context)) {
            Logger.m8697d(TAG, "isAllowedStartPopupNoteService PopupNoteService is started by DetachPen");
            return false;
        }
        if (Build.VERSION.SDK_INT < 36 && InputMethodCompat.getInstance().isPenDetectionSettingOn(context) && InputMethodCompat.getInstance().isInputMethodShown(context, null, false)) {
            Logger.m8697d(TAG, "isAllowedStartPopupNoteService penDetectionSetting of SIP is on and SIP is shown");
            return false;
        }
        boolean zIsInteractive = PowerManagerCompat.getInstance(context).isInteractive();
        int penDetachmentOption = getPenDetachmentOption(context);
        Logger.m8697d(TAG, "isAllowedStartPopupNoteService isInteractive/penDetachmentOption : " + zIsInteractive + "/" + penDetachmentOption);
        return zIsInteractive && 3 == penDetachmentOption;
    }

    private boolean isAllowedStartScreenOffMemo(Intent intent) {
        return !isScreenOffMemoStartedByFW(intent);
    }

    private boolean isPopupNoteStartedByDetachPen(Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().getMetaData(context, context.getPackageName(), "com.samsung.android.app.notes.disable.BR.com.samsung.pen.INSERT", false) && (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 50100);
    }

    private boolean isScreenOffMemoStartedByFW(Intent intent) {
        return intent.getBooleanExtra("isServiceOn", false);
    }

    private void setComponentDisabled(Context context, Intent intent) {
        boolean zIsScreenOffMemoStartedByFW = isScreenOffMemoStartedByFW(intent);
        boolean zIsPopupNoteStartedByDetachPen = isPopupNoteStartedByDetachPen(context);
        Logger.m8702i(TAG, "setComponentDisabled screenOffMemoStartedByFW/popupNoteServiceStartedByDetachPen : " + zIsScreenOffMemoStartedByFW + "/" + zIsPopupNoteStartedByDetachPen);
        if (zIsScreenOffMemoStartedByFW && zIsPopupNoteStartedByDetachPen) {
            SpenEventBroadcastReceiverSwitcher.disableSpenEventBroadcastReceiver(context);
        }
    }

    private void startPopupNoteService(Context context, Intent intent) {
        if (isAllowedStartPopupNoteService(context)) {
            Logger.m8697d(TAG, "startPopupNoteService");
            InputMethodCompat.getInstance().forceHideSoftInput(context);
            intent.setClassName(context.getApplicationContext(), PopupNoteService.class.getName());
            intent.setAction(DOUBLE_TAP);
            startServiceAsUser(context, intent);
        }
    }

    private void startScreenOffMemo(Context context, Intent intent) {
        if (isAllowedStartScreenOffMemo(intent)) {
            Logger.m8697d(TAG, "startScreenOffMemo");
            intent.setClassName(context.getApplicationContext(), ScreenOffMemoService.class.getName());
            intent.putExtra(Constants.StringExtraKey.PEN_INTENT_COM, Constants.StringExtra.PEN_ATTACH);
            startServiceAsUser(context, intent);
        }
    }

    private void startServiceAsUser(Context context, Intent intent) {
        ServiceManager.INSTANCE.getInstance().startServiceAsUser(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (isAllowedReceiveCase(intent)) {
            boolean booleanExtra = intent.getBooleanExtra("penInsert", true);
            Logger.m8697d(TAG, "onReceive action/penInsert : " + intent.getAction() + "/" + booleanExtra);
            if (booleanExtra) {
                startScreenOffMemo(context, intent);
            } else {
                startPopupNoteService(context, intent);
            }
            setComponentDisabled(context, intent);
        }
    }
}
