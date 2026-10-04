package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.link;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.location.Address;
import android.net.Uri;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.net.MailTo;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.AddressHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.DateTimeLinkify;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.UriLinkHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LinkAction {
    private static final String CALCULATOR_CLASS = "com.sec.android.app.popupcalculator.Calculator";
    private static final String CALCULATOR_EXTRA_NAME = "Formula";
    private static final String CALCULATOR_PACKAGE = "com.sec.android.app.popupcalculator";
    private static final int CALCULATOR_PACKAGE_MIN_VERSIONCODE = 606024000;
    private static final String TAG = Logger.createTag("LinkActionHelper");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TaskGeocoderAddress extends AsyncTask<String, Void, Address> {
        private Context mContext;
        private boolean mWithNewTaskFlag;

        public TaskGeocoderAddress(Context context, boolean z) {
            this.mContext = context;
            this.mWithNewTaskFlag = z;
        }

        @Override // android.os.AsyncTask
        public Address doInBackground(String... strArr) {
            return AddressHelper.findAddressByGeocoder(this.mContext, strArr[0]);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Address address) {
            Intent intent = new Intent("android.intent.action.VIEW", UriLinkHelper.makeMapUrl(address != null ? AddressHelper.normalAddressText(address) : ""));
            if (this.mWithNewTaskFlag) {
                intent.addFlags(335544320);
            }
            IntentUtil.startActivity(this.mContext, intent);
        }
    }

    private Intent getIntentForEmail(String str) {
        return new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME + str));
    }

    private Intent getIntentForPhone(Context context, String str) {
        TelephonyManager telephonyManager;
        ActivityInfo activityInfo;
        Intent data = new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + str));
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(data, 0);
        String str2 = (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName;
        return ((str2 != null && !TelemetryEventStrings.C6439Os.OS_NAME.equals(str2)) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || telephonyManager.isVoiceCapable()) ? data : new Intent("android.intent.action.INSERT_OR_EDIT").setType("vnd.android.cursor.item/contact").putExtra("phone", str);
    }

    private Intent getIntentForWeb(String str) {
        String strMakeUrl = UriLinkHelper.makeUrl(str);
        if (TextUtils.isEmpty(strMakeUrl)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(strMakeUrl));
        intent.addFlags(268435456);
        return intent;
    }

    private boolean isVietnamese(@NonNull Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return false;
        }
        return language.endsWith(LangPackConfigConstants.LANGUAGE_CODE_VI);
    }

    private void startActivityForAddress(Context context, String str, boolean z) {
        String strFindAddress = AddressHelper.findAddress(str);
        if (TextUtils.isEmpty(strFindAddress)) {
            new TaskGeocoderAddress(context, z).execute(str);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", UriLinkHelper.makeMapUrl(strFindAddress));
        if (z) {
            intent.addFlags(335544320);
        }
        IntentUtil.startActivity(context, intent);
    }

    public Intent getIntentForCalculator(@NonNull Context context, String str, boolean z) {
        String string = context.getString(C9086R.string.composer_link_application_calculator);
        PackageManagerCompat.Companion companion = PackageManagerCompat.INSTANCE;
        if (!companion.getInstance().isPackageInstalled(context, "com.sec.android.app.popupcalculator")) {
            ToastHandler.show(context, context.getResources().getString(C9086R.string.composer_unable_to_open_application, string), 0);
            return null;
        }
        if (!companion.getInstance().isPackageInstalled(context, "com.sec.android.app.popupcalculator", 606024000)) {
            ToastHandler.show(context, context.getResources().getString(C9086R.string.composer_need_to_update_version, string), 0);
            return null;
        }
        int iIndexOf = str.indexOf(61);
        if (iIndexOf <= 0) {
            return null;
        }
        String strReplace = str.substring(0, iIndexOf).replace('/', (char) 247).replace('*', Typography.times);
        if (isVietnamese(context)) {
            strReplace = strReplace.replace('.', ',');
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.putExtra(CALCULATOR_EXTRA_NAME, strReplace);
        if (z) {
            intent.addFlags(335544320);
        }
        intent.setComponent(new ComponentName("com.sec.android.app.popupcalculator", CALCULATOR_CLASS));
        return intent;
    }

    public boolean startActivityHyperTextByType(Context context, String str, int i) {
        return startActivityHyperTextByType(context, str, i, false);
    }

    public boolean startActivityHyperTextByType(Context context, String str, int i, boolean z) {
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "startActivityHyperTextByType# : ", " / ");
        sbM778t.append(Logger.getLength(str));
        sbM778t.append(" / ");
        sbM778t.append(z);
        Logger.m10999d(str2, sbM778t.toString());
        Intent intentForEmail = null;
        try {
            if (i == 1) {
                intentForEmail = getIntentForEmail(str);
            } else if (i == 2) {
                intentForEmail = getIntentForPhone(context, str);
            } else if (i == 3) {
                intentForEmail = getIntentForWeb(str);
            } else {
                if (i == 5) {
                    startActivityForAddress(context, str, z);
                    return true;
                }
                if (i == 6) {
                    intentForEmail = new DateTimeLinkify(context).getIntentForDate(str);
                } else if (i != 7) {
                    Logger.m11004w(str2, "startActivityHyperTextByType# unexpected hypertextType: " + i);
                } else {
                    intentForEmail = getIntentForCalculator(context, str, z);
                }
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "startActivityHyperTextByType#" + e.getMessage(), e);
        }
        if (intentForEmail != null && z) {
            intentForEmail.addFlags(268435456);
        }
        return IntentUtil.startActivity(context, intentForEmail);
    }
}
