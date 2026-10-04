package com.samsung.android.support.senl.p148nt.app.common;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditInvitationMenuBadgeUpdater {
    private static final String TAG = "CoeditInvitationMenuBadgeUpdater";

    public static void clearInvitationListHasBadgePref() {
        MainCoeditLogger.m7250d(TAG, "clearInvitationListHasBadgePref#");
        SharedPreferencesCompat.getInstance(GcsConstants.COEDIT_PREFS_NAME).remove(GcsConstants.KEY_COEDIT_INVITATION_LIST);
    }

    public static void setInvitationListHasBadgePref(String str, boolean z) {
        Set<String> stringSet;
        MainCoeditLogger.m7250d(TAG, "setInvitationListHasBadgePref# groupId: " + str + ", hasBadge: " + z);
        if (TextUtils.isEmpty(str) || (stringSet = SharedPreferencesCompat.getInstance(GcsConstants.COEDIT_PREFS_NAME).getStringSet(GcsConstants.KEY_COEDIT_INVITATION_LIST, new HashSet())) == null) {
            return;
        }
        if (z) {
            stringSet.add(str);
        } else {
            stringSet.remove(str);
        }
        MainCoeditLogger.m7250d(TAG, "setInvitationListHasBadgePref# size: " + stringSet.size());
        SharedPreferencesCompat.getInstance(GcsConstants.COEDIT_PREFS_NAME).putStringSet(GcsConstants.KEY_COEDIT_INVITATION_LIST, stringSet);
        if (stringSet.size() > 0) {
            BadgeHelper.setCoeditHasBadge(true);
        }
    }
}
