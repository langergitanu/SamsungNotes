package com.samsung.android.support.senl.p148nt.app.updater.connector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.common.constants.AppUpdateConstants;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.stub.StubUtil;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.AppUpdateUtil;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.TargetInfo;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GalaxyAppsConnector implements IMarketConnector {
    private static final String DEFAULT_MCC = "";
    private static final String DEFAULT_MCC_PD = "";
    private static final String DEFAULT_MNC = "";
    public static final int MINIMUM_EXPECTED_NOTES_VERSION = 10;
    public static final int RESULT_CODE_NOT_AVAILABLE = 0;
    public static final int RESULT_CODE_NOT_NECESSARY_TO_UPDATE = 1;
    public static final int RESULT_CODE_NO_NETWORK = 3;
    public static final int RESULT_CODE_UPDATE_AVAILABLE = 2;
    private static final String STUB_UPDATE_CHECK_URL = "https://vas.samsungapps.com/stub/stubUpdateCheck.as";
    private static final String TAG = "GalaxyAppsConnector";
    private static final String XML_TAG_APP_ID = "appId";
    private static final String XML_TAG_RESULT_CODE = "resultCode";
    private static final String XML_TAG_RESULT_MSG = "resultMsg";
    private static final String XML_TAG_VERSION_CODE = "versionCode";
    private static final String XML_TAG_VERSION_NAME = "versionName";
    private INewVersionCheckResetListener mListener;

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentVersionCode() {
        Context applicationContext = BaseUtils.getApplicationContext();
        return Math.max(0, PackageManagerCompat.INSTANCE.getInstance().getVersionCode(applicationContext, applicationContext.getPackageName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMarketVersionCode() {
        String mcc;
        String mnc;
        int lastCheckedMarketVersionCode = UpdateManager.getInstance().getLastCheckedMarketVersionCode();
        if (lastCheckedMarketVersionCode > 0) {
            return lastCheckedMarketVersionCode;
        }
        int currentVersionCode = getCurrentVersionCode();
        String strReplaceFirst = Build.MODEL;
        if (strReplaceFirst.contains("SAMSUNG-")) {
            strReplaceFirst = strReplaceFirst.replaceFirst("SAMSUNG-", "");
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            MainLogger.m7258i(TAG, "Connection failed");
            return 3;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            mcc = AppUpdateUtil.getMcc();
            mnc = AppUpdateUtil.getMnc();
        } else {
            if (type != 1) {
                if (type != 4) {
                    if (type != 9 && type != 6 && type != 7) {
                        MainLogger.m7258i(TAG, "Connection failed");
                        return 3;
                    }
                }
                mcc = AppUpdateUtil.getMcc();
                mnc = AppUpdateUtil.getMnc();
            }
            mcc = "";
            mnc = mcc;
        }
        String str = AppUpdateUtil.isQaServerEnabled() ? "" : mcc;
        try {
            MainLogger.m7258i(TAG, "checkUpdate# ");
            Uri.Builder builderBuildUpon = Uri.parse(STUB_UPDATE_CHECK_URL).buildUpon();
            builderBuildUpon.appendQueryParameter("appId", applicationContext.getPackageName()).appendQueryParameter("callerId", applicationContext.getPackageName()).appendQueryParameter(XML_TAG_VERSION_CODE, String.valueOf(currentVersionCode)).appendQueryParameter("deviceId", strReplaceFirst).appendQueryParameter("mcc", str).appendQueryParameter("mnc", mnc).appendQueryParameter("csc", AppUpdateUtil.getCsc()).appendQueryParameter(LogBuilders.Property.COUNTRY_CODE, AppUpdateUtil.getISO3Country()).appendQueryParameter("sdkVer", AppUpdateUtil.getSdkVer()).appendQueryParameter("systemId", AppUpdateUtil.getSystemId()).appendQueryParameter("abiType", AppUpdateUtil.getAbiType()).appendQueryParameter("extuk", StubUtil.getExtuk()).appendQueryParameter("pd", AppUpdateUtil.getPd()).appendQueryParameter("updateType", AppUpdateConstants.UPDATE_TYPE.SELF).appendQueryParameter("oneUiVersion", String.valueOf(SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion()));
            MainLogger.m7258i(TAG, MainLogger.getEncode(builderBuildUpon.toString()));
            return getVersionCodeFromURL(new URL(builderBuildUpon.toString()));
        } catch (Throwable th) {
            MainLogger.m7256e(TAG, "getMarketVersionCode", th);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009b A[EXC_TOP_SPLITTER, PHI: r1 r10
      0x009b: PHI (r1v2 int) = (r1v1 int), (r1v5 int) binds: [B:37:0x00a8, B:31:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x009b: PHI (r10v4 java.io.InputStream) = (r10v3 java.io.InputStream), (r10v5 java.io.InputStream) binds: [B:37:0x00a8, B:31:0x0099] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getVersionCodeFromURL(URL url) {
        Throwable th;
        InputStream inputStreamOpenStream;
        int iIntValue = 0;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            inputStreamOpenStream = url.openStream();
            try {
                xmlPullParserNewPullParser.setInput(inputStreamOpenStream, null);
                StringBuilder sb = new StringBuilder();
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.next() == 4) {
                            if ("appId".equals(name) || "resultCode".equals(name) || XML_TAG_RESULT_MSG.equals(name) || XML_TAG_VERSION_NAME.equals(name)) {
                                sb.append(name);
                                sb.append(": ");
                                sb.append(xmlPullParserNewPullParser.getText());
                                sb.append('\n');
                            } else if (XML_TAG_VERSION_CODE.equals(name)) {
                                iIntValue = Integer.valueOf(xmlPullParserNewPullParser.getText()).intValue();
                                sb.append(name);
                                sb.append(": ");
                                sb.append(xmlPullParserNewPullParser.getText());
                                sb.append('\n');
                            }
                        }
                    }
                }
                MainLogger.m7258i(TAG, sb.toString());
            } catch (Throwable th2) {
                th = th2;
                try {
                    MainLogger.m7256e(TAG, "getVersionCodeFromURL", th);
                    if (inputStreamOpenStream != null) {
                    }
                } catch (Throwable th3) {
                    if (inputStreamOpenStream != null) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpenStream = null;
        }
        if (inputStreamOpenStream != null) {
            try {
                inputStreamOpenStream.close();
            } catch (IOException unused2) {
            }
        }
        return iIntValue;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector
    public void checkNewVersionOnMarket(INewVersionCheckResetListener iNewVersionCheckResetListener) {
        this.mListener = iNewVersionCheckResetListener;
        TargetInfo.setOnDeviceIdHelperForSamsungNotes(iNewVersionCheckResetListener, new TargetInfo.OnDeviceIdListener() { // from class: com.samsung.android.support.senl.nt.app.updater.connector.GalaxyAppsConnector.1
            @Override // com.samsung.android.support.senl.nt.app.updater.connector.TargetInfo.OnDeviceIdListener
            public void success() {
                new SenlThreadFactory(GalaxyAppsConnector.TAG).newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.updater.connector.GalaxyAppsConnector.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int currentVersionCode = GalaxyAppsConnector.this.getCurrentVersionCode();
                        int marketVersionCode = GalaxyAppsConnector.this.getMarketVersionCode();
                        MainLogger.m7258i(GalaxyAppsConnector.TAG, "currentVersionCode:" + currentVersionCode);
                        MainLogger.m7258i(GalaxyAppsConnector.TAG, "marketVersionCode:" + marketVersionCode);
                        synchronized (GalaxyAppsConnector.this) {
                            try {
                                if (GalaxyAppsConnector.this.mListener != null) {
                                    GalaxyAppsConnector.this.mListener.getResult(marketVersionCode);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }).start();
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector
    public void initLastCheckedMarketVersionCode() {
        UpdateManager.getInstance().initLastCheckedMarketVersionCode();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector
    public void moveToMarket() {
        UpdateManager.getInstance().goToGalaxyAppStore();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector
    public void setLastCheckedMarketVersionCode(int i) {
        if (i == 3) {
            return;
        }
        UpdateManager.getInstance().setLastCheckedMarketVersionCode(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector
    public synchronized void setListener(INewVersionCheckResetListener iNewVersionCheckResetListener) {
        if (iNewVersionCheckResetListener == null) {
            try {
                TargetInfo.release();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mListener = iNewVersionCheckResetListener;
    }
}
