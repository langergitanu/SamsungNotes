package com.microsoft.identity.common.internal.p131ui.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsService;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrowserSelector {
    private static final String LOGGING_MSG_BROWSER = "Browser: ";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private static final String TAG = "BrowserSelector";

    public static List<Browser> getBrowsers(@NonNull Context context, @Nullable BrowserDescriptor browserDescriptor) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getBrowsers", new StringBuilder());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        if (browserDescriptor != null) {
            Logger.info(strM1170p, "Querying preferred browser: " + browserDescriptor.getPackageName());
            intent.setPackage(browserDescriptor.getPackageName());
        }
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65600);
        Logger.verbose(strM1170p, "Querying browsers. Got back " + listQueryIntentActivities.size() + " browsers.");
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (isFullBrowser(resolveInfo)) {
                try {
                    PackageInfo packageInfo = PackageHelper.getPackageInfo(packageManager, resolveInfo.activityInfo.packageName);
                    if (isCustomTabsServiceSupported(context, packageInfo)) {
                        Logger.verbose(strM1170p, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " supports custom tab.");
                        arrayList.add(new Browser(packageInfo, Boolean.TRUE));
                    } else {
                        Logger.verbose(strM1170p, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " does NOT support custom tab.");
                        arrayList.add(new Browser(packageInfo, Boolean.FALSE));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Logger.warn(strM1170p, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " cannot be generated without the package info.");
                }
            } else {
                Logger.verbose(strM1170p, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " is not a full browser app.");
            }
        }
        Logger.verbose(strM1170p, null, "Found " + arrayList.size() + " browsers.");
        return arrayList;
    }

    private static Browser getDefaultBrowser(@NonNull Context context, @NonNull List<BrowserDescriptor> list) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getDefaultBrowser", new StringBuilder());
        for (Browser browser : getBrowsers(context, null)) {
            Iterator<BrowserDescriptor> it = list.iterator();
            while (it.hasNext()) {
                if (matches(it.next(), browser)) {
                    Logger.info(strM1170p, "Browser's package name: " + browser.getPackageName() + " version: " + browser.getVersion());
                    return browser;
                }
            }
        }
        return null;
    }

    private static Browser getPreferredBrowser(@NonNull Context context, @NonNull BrowserDescriptor browserDescriptor) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getPreferredBrowser", new StringBuilder());
        for (Browser browser : getBrowsers(context, browserDescriptor)) {
            if (matches(browserDescriptor, browser)) {
                Logger.info(strM1170p, "Preferred Browser's package name: " + browser.getPackageName() + " version: " + browser.getVersion());
                return browser;
            }
        }
        return null;
    }

    private static boolean isCustomTabsServiceSupported(@NonNull Context context, @NonNull PackageInfo packageInfo) {
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    private static boolean isFullBrowser(ResolveInfo resolveInfo) {
        if (!resolveInfo.filter.hasAction("android.intent.action.VIEW") || !resolveInfo.filter.hasCategory("android.intent.category.BROWSABLE") || resolveInfo.filter.schemesIterator() == null || resolveInfo.filter.authoritiesIterator() != null) {
            return false;
        }
        Iterator<String> itSchemesIterator = resolveInfo.filter.schemesIterator();
        boolean zEquals = false;
        boolean zEquals2 = false;
        while (itSchemesIterator.hasNext()) {
            String next = itSchemesIterator.next();
            zEquals |= "http".equals(next);
            zEquals2 |= "https".equals(next);
            if (zEquals && zEquals2) {
                return true;
            }
        }
        return false;
    }

    private static boolean matches(@NonNull BrowserDescriptor browserDescriptor, @NonNull Browser browser) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":matches", new StringBuilder());
        if (!StringUtil.equalsIgnoreCase(browserDescriptor.getPackageName(), browser.getPackageName())) {
            return false;
        }
        if (!browserDescriptor.getSignatureHashes().equals(browser.getSignatureHashes())) {
            Logger.warn(strM1170p, LOGGING_MSG_BROWSER + browser.getPackageName() + " signature hash not match");
            return false;
        }
        if (!StringUtil.isNullOrEmpty(browserDescriptor.getVersionLowerBound()) && BrokerProtocolVersionUtil.compareSemanticVersion(browser.getVersion(), browserDescriptor.getVersionLowerBound()) == -1) {
            Logger.warn(strM1170p, LOGGING_MSG_BROWSER + browser.getPackageName() + " version too low (Expected: " + browserDescriptor.getVersionLowerBound() + " Get: " + browser.getVersion() + ")");
            return false;
        }
        if (StringUtil.isNullOrEmpty(browserDescriptor.getVersionUpperBound()) || BrokerProtocolVersionUtil.compareSemanticVersion(browser.getVersion(), browserDescriptor.getVersionUpperBound()) != 1) {
            return true;
        }
        Logger.warn(strM1170p, LOGGING_MSG_BROWSER + browser.getPackageName() + " version too high (Expected: " + browserDescriptor.getVersionUpperBound() + " Get: " + browser.getVersion() + ")");
        return false;
    }

    public static Browser select(@NonNull Context context, @NonNull List<BrowserDescriptor> list, @Nullable BrowserDescriptor browserDescriptor) throws ClientException {
        Browser preferredBrowser;
        String str = TAG + ":select";
        Logger.verbose(str, "Select the browser to launch.");
        if (browserDescriptor != null && (preferredBrowser = getPreferredBrowser(context, browserDescriptor)) != null) {
            return preferredBrowser;
        }
        Browser defaultBrowser = getDefaultBrowser(context, list);
        if (defaultBrowser != null) {
            return defaultBrowser;
        }
        Logger.error(str, ErrorStrings.NO_AVAILABLE_BROWSER_FOUND, null);
        throw new ClientException(ErrorStrings.NO_AVAILABLE_BROWSER_FOUND, ErrorStrings.NO_AVAILABLE_BROWSER_FOUND);
    }
}
