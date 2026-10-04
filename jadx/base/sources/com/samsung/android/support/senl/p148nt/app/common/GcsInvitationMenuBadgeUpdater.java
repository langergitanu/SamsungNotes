package com.samsung.android.support.senl.p148nt.app.common;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsInvitationMenuBadgeUpdater {
    public static boolean getInvitationListHasBadgePref() {
        return SharedPreferencesCompat.getInstance(GcsConstants.GCS_PREFS_NAME).getBoolean(GcsConstants.KEY_GCS_INVITATION_LIST_HAS_BADGE, false);
    }

    public static void setInvitationListHasBadgePref(boolean z) {
        if (z) {
            BadgeHelper.setGcsHasDrawerBadge(true);
            BadgeHelper.setGcsHasMoreBadge(true);
        }
        SharedPreferencesCompat.getInstance(GcsConstants.GCS_PREFS_NAME).putBoolean(GcsConstants.KEY_GCS_INVITATION_LIST_HAS_BADGE, z);
    }

    public static void updateBadge(Context context, MenuItem menuItem) {
        if (context == null) {
            return;
        }
        updateBadge(context, menuItem, getInvitationListHasBadgePref());
    }

    public static void updateBadge(Context context, MenuItem menuItem, boolean z) {
        View actionView;
        String str;
        if (context == null || menuItem == null || (actionView = menuItem.getActionView()) == null) {
            return;
        }
        AbstractC8014b.m7210l("updateBadge() hasBadge : ", "GcsInvitationMenuBadgeUpdater", z);
        View viewFindViewById = actionView.findViewById(C8003R.id.action_invitation_list_menu_layout);
        if (viewFindViewById != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getString(C8003R.string.gcs_invitations));
            sb.append(context.getString(C8003R.string.string_comma));
            sb.append(" ");
            if (z) {
                str = context.getString(C8003R.string.drawer_new_item_added_description) + context.getString(C8003R.string.string_comma) + " ";
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(context.getString(C8003R.string.button_string_button));
            viewFindViewById.setContentDescription(sb.toString());
        }
        View viewFindViewById2 = actionView.findViewById(C8003R.id.action_invitation_list_new_badge);
        if (viewFindViewById2 != null) {
            if (z) {
                viewFindViewById2.setVisibility(0);
            } else {
                viewFindViewById2.setVisibility(8);
            }
        }
    }
}
