package com.samsung.android.sdk.smp.display;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.C7794R;
import com.samsung.android.sdk.smp.SmpPopupActivity;
import com.samsung.android.sdk.smp.SmpPopupService;
import com.samsung.android.sdk.smp.SmpReceiver;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PopupDisplayManager extends DisplayManager {
    private static final String TAG = "PopupDisplayManager";

    public static void broadcastFailButRetryResult(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        intent.setAction(Constants.ACTION_HANDLE_POPUP_DISPLAY_RESULT);
        intent.putExtra(Constants.EXTRA_KEY_POPUP_DISPLAY_RESULT, Constants.EXTRA_DISPLAY_RESULT_FAIL_BUT_RETRY);
        intent.putExtra("mid", str);
        intent.putExtra(Constants.EXTRA_KEY_IS_FIRST_DISPLAY, z);
        context.sendBroadcast(intent);
    }

    public static void broadcastFailResult(Context context, String str, FeedbackEvent feedbackEvent, String str2) {
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        intent.setAction(Constants.ACTION_HANDLE_POPUP_DISPLAY_RESULT);
        intent.putExtra(Constants.EXTRA_KEY_POPUP_DISPLAY_RESULT, "fail");
        intent.putExtra("mid", str);
        intent.putExtra(Constants.EXTRA_KEY_FEEDBACK_EVENT, feedbackEvent.value());
        intent.putExtra(Constants.EXTRA_KEY_FEEDBACK_DETAIL, str2);
        context.sendBroadcast(intent);
    }

    public static void broadcastNoActionResult(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        intent.setAction(Constants.ACTION_HANDLE_POPUP_DISPLAY_RESULT);
        intent.putExtra(Constants.EXTRA_KEY_POPUP_DISPLAY_RESULT, Constants.EXTRA_DISPLAY_RESULT_NO_ACTION);
        intent.putExtra("mid", str);
        context.sendBroadcast(intent);
    }

    public static void broadcastSuccessResult(Context context, String str, long j, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        intent.setAction(Constants.ACTION_HANDLE_POPUP_DISPLAY_RESULT);
        intent.putExtra(Constants.EXTRA_KEY_POPUP_DISPLAY_RESULT, "success");
        intent.putExtra("mid", str);
        intent.putExtra(Constants.EXTRA_KEY_CLEAR_TIME, j);
        intent.putExtra(Constants.EXTRA_KEY_IS_FIRST_DISPLAY, z);
        context.sendBroadcast(intent);
    }

    private void delayDisplayNotToDisturb(Context context, DisplayResultHandler displayResultHandler) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen != null) {
            int marketingFailCount = dBHandlerOpen.getMarketingFailCount(displayResultHandler.getMid());
            dBHandlerOpen.updateMarketingFailCount(displayResultHandler.getMid(), marketingFailCount + 1);
            dBHandlerOpen.close();
            if (marketingFailCount < 5) {
                displayResultHandler.setAlarmForRetryDisplay(context);
            } else {
                SmpLog.m6495e(TAG, displayResultHandler.getMid(), "fail to display. currently busy");
                displayResultHandler.onFail(context, FeedbackEvent.BUSY, null);
            }
        }
    }

    public static int getCurrentDisplayID(Context context) {
        return SharedMemoryVariableManager.getInstance(context).getCurrentDisplayId();
    }

    public static int getLayoutResID(int i) throws InternalException.NotSupportedTypeException {
        if (i == 1) {
            return C7794R.layout.pop_text_only;
        }
        if (i == 2) {
            return C7794R.layout.pop_image_only;
        }
        if (i == 3) {
            return C7794R.layout.pop_image_text;
        }
        if (i == 4) {
            return C7794R.layout.pop_web_view;
        }
        throw new InternalException.NotSupportedTypeException();
    }

    public static void setCurrentDisplayID(Context context, int i) {
        SharedMemoryVariableManager.getInstance(context).setCurrentDisplayId(i);
    }

    @Override // com.samsung.android.sdk.smp.display.DisplayManager
    public boolean clear(Context context, int i) {
        if (getCurrentDisplayID(context) == i) {
            try {
                Intent intent = new Intent();
                intent.putExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR, true);
                if (Build.VERSION.SDK_INT >= 29) {
                    intent.setClass(context.getApplicationContext(), SmpPopupService.class);
                    context.startForegroundService(intent);
                } else {
                    intent.setClass(context.getApplicationContext(), SmpPopupActivity.class);
                    intent.setFlags(1140850688);
                    PendingIntent.getActivity(context.getApplicationContext(), 0, intent, 1140850688).send();
                }
            } catch (Exception e) {
                AbstractC6670b.m4737B(e, AbstractC0541b.m778t(i, "fail to clear:", ". "), TAG);
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.sdk.smp.display.DisplayManager
    public void display(Context context, Bundle bundle, DisplayResultHandler displayResultHandler) {
        if (bundle == null) {
            SmpLog.m6494e(TAG, "fail to display. data null");
            displayResultHandler.onFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return;
        }
        printBundle(bundle);
        String string = bundle.getString("mid");
        int i = bundle.getInt("template_type", -1);
        if (!MarketingConstants.PopupConst.isSupportType(i)) {
            SmpLog.m6495e(TAG, string, "not supported type. type:" + i);
            displayResultHandler.onFail(context, FeedbackEvent.UNSUPPORTED_TYPE, null);
            return;
        }
        if (!bundle.getBoolean("disturb") && DeviceInfoUtil.isScreenOn(context)) {
            SmpLog.m6499i(TAG, string, "delay display not to disturb");
            delayDisplayNotToDisturb(context, displayResultHandler);
            return;
        }
        int currentDisplayID = getCurrentDisplayID(context);
        if (currentDisplayID != -1) {
            clear(context, currentDisplayID);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(MarketingConstants.DisplayConst.KEY_EXTRA_POPUP_DATA, bundle);
            intent.putExtra(MarketingConstants.DisplayConst.KEY_EXTRA_IS_FIRST_DISPLAY, displayResultHandler.isFirstDisplay());
            intent.putExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR_TIME, displayResultHandler.getClearTime());
            if (Build.VERSION.SDK_INT >= 29) {
                intent.putExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CHANNEL_ID, getNotificationChannelId(context, bundle.getInt(MarketingConstants.DisplayConst.CHANNEL_TYPE, -1)));
                intent.setClass(context.getApplicationContext(), SmpPopupService.class);
                context.startForegroundService(intent);
            } else {
                intent.setClass(context.getApplicationContext(), SmpPopupActivity.class);
                intent.setFlags(1140850688);
                PendingIntent.getActivity(context.getApplicationContext(), 0, intent, 1140850688).send();
            }
        } catch (InternalException.IllegalPushChannelException unused) {
            SmpLog.m6495e(TAG, string, "fail to display. channel not created");
            displayResultHandler.onFail(context, FeedbackEvent.PUSH_CHANNEL_NOT_CREATED, null);
        } catch (Exception e) {
            SmpLog.m6495e(TAG, string, "fail to display. " + e.toString());
            displayResultHandler.onFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
        }
    }
}
