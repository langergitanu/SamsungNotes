package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PackageHelper {
    private static final String TAG = "CallerInfo";
    private final PackageManager mPackageManager;

    public PackageHelper(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    public static String getBrokerRedirectUri(Context context, String str) {
        return getBrokerRedirectUrl(str, new PackageHelper(context.getPackageManager()).getSha1SignatureForPackage(str));
    }

    public static String getBrokerRedirectUrl(String str, String str2) {
        if (!StringExtensions.isNullOrBlank(str) && !StringExtensions.isNullOrBlank(str2)) {
            try {
                return AuthenticationConstants.Broker.BROWSER_EXT_INSTALL_PREFIX + URLEncoder.encode(str, "UTF-8") + "/" + URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Logger.error("CallerInfo:getBrokerRedirectUrl", "", "Encoding is not supported", e);
            }
        }
        return "";
    }

    public static PackageInfo getPackageInfo(@NonNull PackageManager packageManager, @NonNull String str) {
        return packageManager.getPackageInfo(str, getPackageManagerSignaturesFlag());
    }

    public static int getPackageManagerSignaturesFlag() {
        return Build.VERSION.SDK_INT >= 28 ? 134217728 : 64;
    }

    public static Signature[] getSignatures(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return packageInfo.signatures;
        }
        if (packageInfo.signingInfo == null) {
            return null;
        }
        return packageInfo.signingInfo.hasMultipleSigners() ? packageInfo.signingInfo.getApkContentsSigners() : packageInfo.signingInfo.getSigningCertificateHistory();
    }

    private static String getSigningCertificateThumbprintForPackage(PackageInfo packageInfo, boolean z) {
        try {
            Signature[] signatures = getSignatures(packageInfo);
            if (signatures == null || signatures.length <= 0) {
                return null;
            }
            Signature signature = signatures[0];
            MessageDigest messageDigest = MessageDigest.getInstance(z ? "SHA-512" : "SHA");
            messageDigest.update(signature.toByteArray());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (NoSuchAlgorithmException e) {
            Logger.error("CallerInfo:getSigningCertificateThumbprintForPackage", "Digest SHA algorithm does not exists. ", "", e);
            return null;
        }
    }

    public String getSha1SignatureForPackage(String str) {
        try {
            return getSigningCertificateThumbprintForPackage(getPackageInfo(this.mPackageManager, str), false);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error("CallerInfo:getSha1SignatureForPackage", "Calling App's package does not exist in PackageManager. ", "", e);
            return null;
        }
    }

    public String getSha512SignatureForPackage(String str) {
        try {
            return getSigningCertificateThumbprintForPackage(getPackageInfo(this.mPackageManager, str), true);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error("CallerInfo:getSha512SignatureForPackage", "Calling App's package does not exist in PackageManager. ", "", e);
            return null;
        }
    }

    public int getUIDForPackage(String str) {
        try {
            ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error("CallerInfo:getUIDForPackage", "Package is not found. ", "Package name: " + str, e);
            return 0;
        }
    }

    public boolean isPackageInstalledAndEnabled(String str) {
        boolean z = false;
        try {
            ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                z = applicationInfo.enabled;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.verbose("CallerInfo:isPackageInstalledAndEnabled", str + " is not found");
        }
        Logger.verbose("CallerInfo:isPackageInstalledAndEnabled", str + " is installed. enabled? [" + z + "]");
        return z;
    }

    public boolean verifyIfValidTeamsPackage(String str) {
        if (!str.equals(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME) || !isPackageInstalledAndEnabled(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME)) {
            return false;
        }
        String sha1SignatureForPackage = getSha1SignatureForPackage(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME);
        return AuthenticationConstants.Broker.IPPHONE_APP_SIGNATURE.equals(sha1SignatureForPackage) || AuthenticationConstants.Broker.IPPHONE_APP_DEBUG_SIGNATURE.equals(sha1SignatureForPackage);
    }

    public PackageHelper(Context context) {
        this.mPackageManager = context.getPackageManager();
    }

    public static Signature[] getSignatures(@NonNull Context context) {
        return getSignatures(getPackageInfo(context.getPackageManager(), context.getPackageName()));
    }
}
