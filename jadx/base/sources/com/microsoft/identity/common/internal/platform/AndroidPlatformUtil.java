package com.microsoft.identity.common.internal.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.net.DefaultConnectionService;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.IntuneMAMEnrollmentIdGateway;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.p131ui.webview.WebViewUtil;
import com.microsoft.identity.common.java.commands.ICommand;
import com.microsoft.identity.common.java.commands.InteractiveTokenCommand;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import com.microsoft.identity.common.java.util.IPlatformUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.net.ssl.KeyManagerFactory;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidPlatformUtil implements IPlatformUtil {
    private static final String TAG = "AndroidPlatformUtil";

    @Nullable
    private final Activity mActivity;

    @NonNull
    private final Context mContext;

    public AndroidPlatformUtil(@NonNull Context context, @Nullable Activity activity) {
        if (context == null) {
            throw new NullPointerException("mContext is marked non-null but is null");
        }
        this.mContext = context;
        this.mActivity = activity;
    }

    private static boolean hasTaskAffinity(@NonNull Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":hasTaskAffinity", new StringBuilder());
        PackageManager packageManager = activity.getPackageManager();
        try {
            ComponentName componentName = activity.getComponentName();
            ActivityInfo activityInfo = componentName != null ? packageManager.getActivityInfo(componentName, 0) : null;
            if (activityInfo == null) {
                return false;
            }
            return activityInfo.taskAffinity != null;
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn(strM1170p, "Unable to get ActivityInfo for activity provided to start authorization.");
            return true;
        }
    }

    private boolean isValidHubRedirectURIForNAATests(String str) {
        return false;
    }

    private void optionallyReorderTasks(@NonNull ICommand<?> iCommand) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":optionallyReorderTasks", new StringBuilder());
        if (iCommand instanceof InteractiveTokenCommand) {
            if (this.mActivity == null) {
                throw new IllegalStateException("Activity cannot be null in an interactive session.");
            }
            if (!((InteractiveTokenCommandParameters) ((InteractiveTokenCommand) iCommand).getParameters()).getHandleNullTaskAffinity() || hasTaskAffinity(this.mActivity)) {
                return;
            }
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            if (activityManager != null) {
                activityManager.moveTaskToFront(this.mActivity.getTaskId(), 0);
            } else {
                Logger.warn(strM1170p, "ActivityManager was null; Unable to bring task for the foreground.");
            }
        }
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public List<BrowserDescriptor> getBrowserSafeListForBroker() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.add("7fmduHKTdHHrlMvldlEqAIlSfii1tl35bxj1OXN5Ve8c4lU6URVu4xtSHc3BVZxS6WWJnxMDhIfQN0N0K2NDJg==");
        arrayList.add(new BrowserDescriptor(MsalUtils.CHROME_PACKAGE, hashSet, (String) null, (String) null));
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    @Nullable
    public String getEnrollmentId(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("userId is marked non-null but is null");
        }
        if (str2 != null) {
            return IntuneMAMEnrollmentIdGateway.getInstance().getEnrollmentId(this.mContext, str, str2);
        }
        throw new NullPointerException("packageName is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    @Nullable
    public String getInstalledCompanyPortalVersion() {
        try {
            return this.mContext.getPackageManager().getPackageInfo(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public long getNanosecondTime() {
        return SystemClock.elapsedRealtimeNanos();
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    @Nullable
    public String getPackageNameFromUid(int i) {
        return this.mContext.getPackageManager().getNameForUid(i);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public KeyManagerFactory getSslContextKeyManagerFactory() {
        return KeyManagerFactory.getInstance("X509");
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public boolean isValidCallingApp(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isValidCallingApp", new StringBuilder());
        if (isValidHubRedirectURIForNAATests(str)) {
            Logger.warn(strM1170p, "Bypassing RedirectUri Check. This should not be enabled in PROD. ".concat(str));
            return true;
        }
        String brokerRedirectUri = PackageHelper.getBrokerRedirectUri(this.mContext, str2);
        boolean zEqualsIgnoreCase = StringUtil.equalsIgnoreCase(str, brokerRedirectUri);
        if (str2.equals(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME)) {
            String sha512SignatureForPackage = new PackageHelper(this.mContext.getPackageManager()).getSha512SignatureForPackage(str2);
            if (BrokerData.getProdMicrosoftAuthenticator().getSigningCertificateThumbprint().equals(sha512SignatureForPackage) || BrokerData.getDebugMicrosoftAuthenticator().getSigningCertificateThumbprint().equals(sha512SignatureForPackage)) {
                zEqualsIgnoreCase |= StringUtil.equalsIgnoreCase(str, "urn:ietf:wg:oauth:2.0:oob");
            }
        }
        if (!zEqualsIgnoreCase) {
            com.microsoft.identity.common.logging.Logger.error(strM1170p, AbstractC0541b.m774p("Broker redirect uri is invalid. Expected: ", brokerRedirectUri, " Actual: ", str), null);
        }
        return zEqualsIgnoreCase;
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void onReturnCommandResult(@NonNull ICommand<?> iCommand) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        optionallyReorderTasks(iCommand);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void postCommandResult(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable is marked non-null but is null");
        }
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void removeCookiesFromWebView() {
        WebViewUtil.removeCookiesFromWebView(this.mContext);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void throwIfNetworkNotAvailable(boolean z) throws ClientException {
        DefaultConnectionService defaultConnectionService = new DefaultConnectionService(this.mContext);
        if (z && defaultConnectionService.isNetworkDisabledFromOptimizations()) {
            throw new ClientException(ErrorStrings.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION, "Connection is not available to refresh token because power optimization is enabled. And the device is in doze mode or the app is standby");
        }
        if (!defaultConnectionService.isConnectionAvailable()) {
            throw new ClientException("device_network_not_available", "Connection is not available to refresh token");
        }
    }
}
