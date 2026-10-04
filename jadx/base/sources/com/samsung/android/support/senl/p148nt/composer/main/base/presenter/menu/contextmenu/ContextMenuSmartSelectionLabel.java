package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import androidx.core.net.MailTo;
import androidx.core.util.Pair;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.AddressHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.UriLinkHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.link.LinkAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuSmartSelectionLabel {
    private static final String EXTRA_FROM_TEXT_CLASSIFIER = "android.view.textclassifier.extra.FROM_TEXT_CLASSIFIER";
    private static final int ICON_TINT_COLOR_DARK = -1710619;
    private static final String TAG = Logger.createTag("ContextMenuSmartSelectionLabel");

    private Pair<CharSequence, Drawable> getLabelActivityForAddress(Context context, String str) {
        CharSequence text = context.getResources().getText(C9086R.string.composer_ctx_menu_maps);
        Drawable drawableSearchIcon = searchIcon(context, new Intent("android.intent.action.VIEW", UriLinkHelper.makeMapUrl(AddressHelper.findAddress(str))));
        if (drawableSearchIcon == null) {
            drawableSearchIcon = Spr.getDrawable(context.getResources(), C9086R.drawable.copypaste_ic_quick_popup_location_mtrl, null);
            if (ContextUtils.isNightMode(context)) {
                drawableSearchIcon.setTint(ICON_TINT_COLOR_DARK);
            }
        }
        return new Pair<>(text, drawableSearchIcon);
    }

    private Pair<CharSequence, Drawable> getLabelActivityForCalculator(Context context, String str) {
        return searchIconNTitle(context, new LinkAction().getIntentForCalculator(context, str, false));
    }

    private Pair<CharSequence, Drawable> getLabelActivityForDate(Context context) {
        CharSequence text = context.getResources().getText(C9086R.string.composer_ctx_menu_calendar);
        Intent intent = new Intent("android.intent.action.EDIT");
        try {
            intent.setType("vnd.android.cursor.item/event");
        } catch (Exception e) {
            Logger.m11001e(TAG, "getLabelActivityForDate# " + e.getMessage(), e);
        }
        return new Pair<>(text, searchIcon(context, intent));
    }

    private Pair<CharSequence, Drawable> getLabelActivityForEmail(Context context, String str) {
        CharSequence text = context.getResources().getText(C9086R.string.composer_ctx_menu_email);
        Drawable drawableSearchIcon = searchIcon(context, new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME + str)));
        if (drawableSearchIcon == null) {
            drawableSearchIcon = Spr.getDrawable(context.getResources(), C9086R.drawable.copypaste_ic_quick_popup_email_mtrl, null);
            if (ContextUtils.isNightMode(context)) {
                drawableSearchIcon.setTint(ICON_TINT_COLOR_DARK);
            }
        }
        return new Pair<>(text, drawableSearchIcon);
    }

    private Pair<CharSequence, Drawable> getLabelActivityForHyperText(Context context, String str) {
        CharSequence text = context.getResources().getText(C9086R.string.composer_ctx_menu_browser);
        Drawable drawableSearchIcon = searchIcon(context, new Intent("android.intent.action.VIEW", Uri.parse(UriLinkHelper.makeUrl(str))));
        if (drawableSearchIcon == null) {
            drawableSearchIcon = Spr.getDrawable(context.getResources(), C9086R.drawable.copypaste_ic_quick_popup_web_mtrl, null);
            if (ContextUtils.isNightMode(context)) {
                drawableSearchIcon.setTint(ICON_TINT_COLOR_DARK);
            }
        }
        return new Pair<>(text, drawableSearchIcon);
    }

    private Pair<CharSequence, Drawable> getLabelActivityForPhone(Context context, String str) {
        Drawable drawableSearchIcon = searchIcon(context, new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + str)));
        return drawableSearchIcon == null ? getLabelActivityForPhoneDefault(context) : getLabelActivityForPhoneDefault(context, drawableSearchIcon);
    }

    private Pair<CharSequence, Drawable> getLabelActivityForPhoneDefault(Context context) {
        CharSequence text;
        Drawable drawable;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.isVoiceCapable()) {
            text = context.getResources().getText(C9086R.string.composer_ctx_menu_phone);
            drawable = Spr.getDrawable(context.getResources(), C9086R.drawable.copypaste_ic_quick_popup_phone_mtrl, null);
        } else {
            text = context.getResources().getText(C9086R.string.composer_ctx_menu_contacts);
            drawable = Spr.getDrawable(context.getResources(), C9086R.drawable.copypaste_ic_quick_popup_contact_mtrl, null);
        }
        if (ContextUtils.isNightMode(context)) {
            drawable.setTint(ICON_TINT_COLOR_DARK);
        }
        return new Pair<>(text, drawable);
    }

    private Drawable searchIcon(Context context, Intent intent) {
        Pair<CharSequence, Drawable> pairSearchIconNTitle = searchIconNTitle(context, intent);
        if (pairSearchIconNTitle != null) {
            return pairSearchIconNTitle.second;
        }
        return null;
    }

    private Pair<CharSequence, Drawable> searchIconNTitle(Context context, Intent intent) {
        Drawable drawableLoadDrawable;
        ActivityInfo activityInfo;
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra(EXTRA_FROM_TEXT_CLASSIFIER, Bundle.EMPTY);
        }
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
        String string = null;
        String str = (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName;
        if (str == null || TelemetryEventStrings.C6439Os.OS_NAME.equals(str)) {
            return null;
        }
        if (resolveInfoResolveActivity.activityInfo.getIconResource() != 0) {
            drawableLoadDrawable = Icon.createWithResource(str, resolveInfoResolveActivity.activityInfo.getIconResource()).loadDrawable(context);
            CharSequence charSequenceLoadLabel = resolveInfoResolveActivity.activityInfo.loadLabel(packageManager);
            if (charSequenceLoadLabel != null) {
                string = charSequenceLoadLabel.toString();
            }
        } else {
            drawableLoadDrawable = null;
        }
        return new Pair<>(string, drawableLoadDrawable);
    }

    public Pair<CharSequence, Drawable> getTitleIconByType(Context context, String str, int i) {
        AbstractC0000a.m3D(i, "getTitleIconByType : ", TAG);
        if (i == 1) {
            return getLabelActivityForEmail(context, str);
        }
        if (i == 2) {
            return getLabelActivityForPhone(context, str);
        }
        if (i == 3) {
            return getLabelActivityForHyperText(context, str);
        }
        if (i == 5) {
            return getLabelActivityForAddress(context, str);
        }
        if (i == 6) {
            return getLabelActivityForDate(context);
        }
        if (i != 7) {
            return null;
        }
        return getLabelActivityForCalculator(context, str);
    }

    private Pair<CharSequence, Drawable> getLabelActivityForPhoneDefault(Context context, Drawable drawable) {
        CharSequence text;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && !telephonyManager.isVoiceCapable()) {
            text = context.getResources().getText(C9086R.string.composer_ctx_menu_contacts);
        } else {
            text = context.getResources().getText(C9086R.string.composer_ctx_menu_phone);
        }
        return new Pair<>(text, drawable);
    }
}
