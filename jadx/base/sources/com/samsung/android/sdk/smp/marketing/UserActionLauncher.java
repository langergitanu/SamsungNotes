package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.display.DisplayManager;
import com.samsung.android.sdk.smp.marketing.LandingIntentGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class UserActionLauncher {
    private static final String TAG = "UserActionLauncher";

    private static boolean handleClickAction(Context context, String str, MarketingLink marketingLink, boolean z, boolean z2) {
        MarketingLink marketingLink2;
        try {
            marketingLink2 = marketingLink;
        } catch (Exception e) {
            e = e;
            marketingLink2 = marketingLink;
        }
        try {
            Intent landingIntentByLinkType = new LandingIntentGenerator(LandingIntentGenerator.RunType.RUN_DIRECT).getLandingIntentByLinkType(context, str, NotificationButtonNumber.NONE, marketingLink2, false, z, z2);
            if (landingIntentByLinkType == null) {
                SmpLog.m6501w(TAG, "fail to launch " + marketingLink2.getType());
                return false;
            }
            context.startActivity(landingIntentByLinkType);
            SmpLog.m6498i(TAG, "success to launch " + marketingLink2.getType());
            return true;
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            SmpLog.m6501w(TAG, "fail to launch " + marketingLink2.getType() + ". " + exc.toString());
            return false;
        }
    }

    public static void onClear(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("mid");
        if (TextUtils.isEmpty(stringExtra)) {
            SmpLog.m6494e(TAG, "fail to handle clear. mid null");
            return;
        }
        String stringExtra2 = intent.getStringExtra(MarketingConstants.MARKETING_TYPE);
        int intExtra = intent.getIntExtra(Constants.EXTRA_KEY_DISPLAYID, -1);
        SmpLog.m6499i(TAG, stringExtra, "onClear. type:" + stringExtra2 + ", displayId : " + intExtra);
        DisplayManager displayManager = DisplayManager.getDisplayManager(stringExtra2);
        if (displayManager != null && intExtra > 0) {
            displayManager.clear(context, intExtra);
        }
        Marketing.setToGone(context, stringExtra, false);
        FeedbackManager.addFeedback(context, stringExtra, FeedbackEvent.IGNORED, null);
    }

    public static void onClick(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("mid");
        if (TextUtils.isEmpty(stringExtra)) {
            SmpLog.m6494e(TAG, "fail to handle click event. mid null");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("p_link", false);
        Marketing.setToGone(context, stringExtra, true);
        for (int i = 0; i < 5; i++) {
            Bundle bundleExtra = intent.getBundleExtra("click_link" + i);
            if (bundleExtra == null) {
                break;
            }
            MarketingLink marketingLink = MarketingLink.parse(bundleExtra);
            if (MarketingConstants.LINK_TYPE_IGNORE.equals(marketingLink.getType())) {
                FeedbackManager.addFeedback(context, stringExtra, FeedbackEvent.IGNORED, null);
                return;
            } else {
                if (handleClickAction(context, stringExtra, marketingLink, false, booleanExtra)) {
                    FeedbackManager.addFeedback(context, stringExtra, FeedbackEvent.CLICKED, marketingLink.getType());
                    return;
                }
            }
        }
        FeedbackManager.addFeedback(context, stringExtra, FeedbackEvent.CLICKED, FeedbackDetailConstants.FAIL_TO_CONNECT_TARGET);
    }

    public static void onClickNotificationButton(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("mid");
        if (TextUtils.isEmpty(stringExtra)) {
            SmpLog.m6494e(TAG, "fail to handle click event. mid null");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("p_link", false);
        FeedbackEvent feedbackEventFromInt = FeedbackEvent.fromInt(intent.getIntExtra(Constants.EXTRA_KEY_FEEDBACK_EVENT, 0));
        for (int i = 0; i < 5; i++) {
            Bundle bundleExtra = intent.getBundleExtra("click_link" + i);
            if (bundleExtra == null) {
                break;
            }
            MarketingLink marketingLink = MarketingLink.parse(bundleExtra);
            if (MarketingConstants.LINK_TYPE_IGNORE.equals(marketingLink.getType())) {
                FeedbackManager.addFeedback(context, stringExtra, FeedbackEvent.IGNORED, null);
                return;
            } else {
                if (handleClickAction(context, stringExtra, marketingLink, true, booleanExtra)) {
                    FeedbackManager.addFeedback(context, stringExtra, feedbackEventFromInt, marketingLink.getType());
                    return;
                }
            }
        }
        FeedbackManager.addFeedback(context, stringExtra, feedbackEventFromInt, FeedbackDetailConstants.FAIL_TO_CONNECT_TARGET);
    }
}
