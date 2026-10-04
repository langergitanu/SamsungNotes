package p016D0;

import android.app.Activity;
import android.content.Context;
import com.microsoft.identity.client.AcquireTokenParameters;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IMultipleAccountPublicClientApplication;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClientFactory;
import com.microsoft.identity.common.java.authorities.Authority;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p025F0.AbstractC0089d;
import p234q1.RunnableC14432a;

/* JADX INFO: renamed from: D0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0059d {

    /* JADX INFO: renamed from: f */
    public static C0059d f231f;

    /* JADX INFO: renamed from: d */
    public List f235d;

    /* JADX INFO: renamed from: a */
    public IPublicClientApplication f232a = null;

    /* JADX INFO: renamed from: b */
    public final String[] f233b = {"User.Read", "Notes.ReadWrite"};

    /* JADX INFO: renamed from: c */
    public final ThreadPoolExecutor f234c = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(2), new SenlThreadFactory("AuthenticationHelper"), new ThreadPoolExecutor.DiscardPolicy());

    /* JADX INFO: renamed from: e */
    public final ArrayList f236e = new ArrayList();

    public C0059d(Context context) {
        int iM137e = m137e(context);
        BrokerDiscoveryClientFactory.setNewBrokerDiscoveryEnabled(true);
        if (m138f(context) == AccountMode.MULTIPLE) {
            PublicClientApplication.createMultipleAccountPublicClientApplication(context, iM137e, new C0056a(this));
        } else {
            PublicClientApplication.createSingleAccountPublicClientApplication(context, iM137e, new C0057b(this));
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m135a(C0059d c0059d) {
        c0059d.getClass();
        MSLogger.m8632d("AuthenticationHelper", "getAccounts start");
        IPublicClientApplication iPublicClientApplication = c0059d.f232a;
        if (iPublicClientApplication instanceof IMultipleAccountPublicClientApplication) {
            try {
                c0059d.f235d = ((IMultipleAccountPublicClientApplication) iPublicClientApplication).getAccounts();
            } catch (MsalException e) {
                MSLogger.m8633e("AuthenticationHelper", "failed to get account 2" + e);
            } catch (InterruptedException e2) {
                MSLogger.m8633e("AuthenticationHelper", "failed to get account 1" + e2);
            }
        }
        List list = c0059d.f235d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public static void m136b(C0059d c0059d) {
        synchronized (c0059d.f236e) {
            try {
                Iterator it = c0059d.f236e.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                c0059d.f236e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static int m137e(Context context) {
        DeviceUtils.isSepMainSignature(context);
        return (DeviceInfo.isEngMode() || DeviceInfo.isUserDebugMode()) ? C7943R.raw.msal_config_eng : !DeviceUtils.isSepLiteModel(context) ? C7943R.raw.msal_config_user : DeviceUtils.isSepMainSignature(context) ? C7943R.raw.msal_config_user : C7943R.raw.msal_config_sep_light_user;
    }

    /* JADX INFO: renamed from: f */
    public static AccountMode m138f(Context context) {
        StringBuilder sb;
        InputStream inputStreamOpenRawResource;
        AccountMode accountMode = AccountMode.MULTIPLE;
        try {
            sb = new StringBuilder();
            try {
                inputStreamOpenRawResource = context.getResources().openRawResource(m137e(context));
            } catch (Exception e) {
                MSLogger.m8633e("AuthenticationHelper", "Failed to get json string. " + e.getMessage());
            }
        } catch (Exception e2) {
            AbstractC6670b.m4753n(e2, new StringBuilder("Failed. "), "AuthenticationHelper");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, "UTF-8"));
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    sb.append(line);
                }
                bufferedReader.close();
                if (inputStreamOpenRawResource != null) {
                    inputStreamOpenRawResource.close();
                }
                String string = new JSONObject(sb.toString()).getString("account_mode");
                MSLogger.m8632d("AuthenticationHelper", "accountMode : " + string);
                if ("SINGLE".equals(string)) {
                    accountMode = AccountMode.SINGLE;
                }
                MSLogger.m8632d("AuthenticationHelper", "getDefaultAccountMode : " + accountMode);
                return accountMode;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: g */
    public static synchronized C0059d m139g(Context context) {
        try {
            if (f231f == null) {
                f231f = new C0059d(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f231f;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m140c(Activity activity, AuthenticationCallback authenticationCallback) {
        IPublicClientApplication iPublicClientApplication = this.f232a;
        if (iPublicClientApplication == null) {
            return false;
        }
        boolean z = iPublicClientApplication instanceof IMultipleAccountPublicClientApplication;
        String[] strArr = this.f233b;
        if (z) {
            this.f232a.acquireToken(new AcquireTokenParameters.Builder().startAuthorizationFromActivity(activity).withCallback(authenticationCallback).withScopes(Arrays.asList(strArr)).build());
            return true;
        }
        if (!(iPublicClientApplication instanceof ISingleAccountPublicClientApplication)) {
            return false;
        }
        ((ISingleAccountPublicClientApplication) iPublicClientApplication).signIn(activity, null, strArr, authenticationCallback);
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m141d(AuthenticationCallback authenticationCallback) {
        Authority defaultAuthority;
        IPublicClientApplication iPublicClientApplication = this.f232a;
        if (iPublicClientApplication == null || (defaultAuthority = iPublicClientApplication.getConfiguration().getDefaultAuthority()) == null) {
            return false;
        }
        String strM229a = AbstractC0089d.m229a();
        IPublicClientApplication iPublicClientApplication2 = this.f232a;
        if (iPublicClientApplication2 instanceof IMultipleAccountPublicClientApplication) {
            this.f234c.execute(new RunnableC14432a(this, defaultAuthority, authenticationCallback, strM229a));
            return true;
        }
        if (!(iPublicClientApplication2 instanceof ISingleAccountPublicClientApplication)) {
            return false;
        }
        ((ISingleAccountPublicClientApplication) this.f232a).acquireTokenSilentAsync(this.f233b, defaultAuthority.getAuthorityURL().toString(), authenticationCallback);
        return true;
    }
}
