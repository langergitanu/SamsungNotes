package com.samsung.android.sdk.handwriting.resources.impl;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.RemoteException;
import android.util.Log;
import com.samsung.android.sdk.handwriting.resources.impl.api.HWRResourceManagerContract;
import com.samsung.android.sdk.handwriting.resources.impl.listener.HWRLanguagePackListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRRMHelper {
    private static final String[] AVAILABLE_LANGUAGES;
    private static final String TAG = "HWRRMHelper";
    private static final Map<String, String[]> mMultiDB;
    private final Context mContext;
    private String mEngineVersion = "";
    private HWRLanguagePackListener mLanguagePackListener = null;
    private final HWRRMLauncher mRmLauncher;

    static {
        HashMap map = new HashMap();
        map.put("ko_KR", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("ko_KR_NoHanJa", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("ja_JP", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("zh_CN", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("zh_HK", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("zh_TW", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        mMultiDB = Collections.unmodifiableMap(map);
        AVAILABLE_LANGUAGES = new String[]{"af_ZA", "ar", "az_AZ", "be_BY", "bg_BG", "ca_ES", "cs_CZ", "da_DK", "de_AT", "de_DE", "el_GR", "en_AU", "en_CA", "en_GB", DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "es_ES", "es_MX", "es_US", "et_EE", "eu_ES", "fa_IR", "fi_FI", "fr_CA", "fr_FR", "ga_IE", "gl_ES", "he_IL", "hi_IN", "hr_HR", "hu_HU", "hy_AM", "id_ID", "is_IS", "it_IT", "ja_JP", "ka_GE", "kk_KZ", "ko_KR", "lt_LT", "lv_LV", "mk_MK", "mn_MN", "mr_IN", "ms_MY", "nb_NO", "nl_BE", "nl_NL", "pl_PL", "pt_BR", "pt_PT", "ro_RO", "ru_RU", "sk_SK", "sl_SI", "sq_AL", "sr_RS", "sv_SE", "th_TH", "tr_TR", "uk_UA", "ur_PK", "vi_VN", "zh_CN", "zh_HK", "zh_TW"};
    }

    public HWRRMHelper(Context context) {
        this.mContext = context;
        this.mRmLauncher = new HWRRMLauncher(context);
    }

    private synchronized void closeContentProviderClient(ContentProviderClient contentProviderClient) {
        Log.i(TAG, "Close ContentProviderClient");
        if (contentProviderClient == null) {
            Log.e(TAG, "[closeContentProviderClient] content provider client is null!");
        } else {
            contentProviderClient.close();
        }
    }

    private synchronized ContentProviderClient getContentProviderClient() {
        Log.i(TAG, "Get ContentProviderClient");
        ContentResolver contentResolver = this.mContext.getContentResolver();
        if (contentResolver == null) {
            Log.e(TAG, "[getContentProviderClient] content resolver is null!");
            return null;
        }
        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient("com.samsung.android.sdk.handwriting.resourcemanager");
        if (contentProviderClientAcquireContentProviderClient != null) {
            return contentProviderClientAcquireContentProviderClient;
        }
        Log.e(TAG, "[getContentProviderClient] content provider client is null!");
        return null;
    }

    @SuppressLint({"Range"})
    private synchronized void makeMapForLanguages(Cursor cursor, Map<String, HWRRMLanguageModel> map, boolean z) {
        while (cursor.moveToNext()) {
            try {
                String string = cursor.getString(cursor.getColumnIndex("lang"));
                HWRVersion hWRVersion = new HWRVersion(cursor.getString(cursor.getColumnIndex("version")));
                if (z) {
                    this.mEngineVersion = hWRVersion.toString();
                }
                map.put(string, new HWRRMLanguageModel(string, hWRVersion, cursor.getInt(cursor.getColumnIndex("preloaded")) == 1 ? "true" : "false", cursor.getString(cursor.getColumnIndex("latest"))));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z && map.size() == 0) {
            Log.w(TAG, "There are no languages in available list!");
            for (String str : AVAILABLE_LANGUAGES) {
                map.put(str, new HWRRMLanguageModel(str, new HWRVersion(""), "false", "true"));
            }
        }
    }

    public synchronized boolean awakeContentProvider() {
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            Log.e(TAG, "[awakeContentProvider] client is null");
            return false;
        }
        Log.i(TAG, "[awakeContentProvider] query to awake!");
        try {
            Cursor cursorQuery = contentProviderClient.query(HWRResourceManagerContract.Downloading.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                Log.e(TAG, "[awakeContentProvider] cursor is null!");
                closeContentProviderClient(contentProviderClient);
                return false;
            }
            Log.i(TAG, "[awakeContentProvider] cursor count = " + cursorQuery.getCount() + ", cp process is awakened!");
            cursorQuery.close();
            closeContentProviderClient(contentProviderClient);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return false;
        }
    }

    public synchronized boolean isContentProviderAvailable() {
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            return false;
        }
        closeContentProviderClient(contentProviderClient);
        return true;
    }

    public synchronized boolean queryToGetAvailableList() {
        boolean zOnUpdateAvailableLanguageList;
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            Log.e(TAG, "[queryToGetAvailableList] client is null");
            return false;
        }
        try {
            Cursor cursorQuery = contentProviderClient.query(HWRResourceManagerContract.Langs.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                Log.e(TAG, "[queryToGetAvailableList] cursor is null!");
                closeContentProviderClient(contentProviderClient);
                return false;
            }
            HashMap map = new HashMap();
            makeMapForLanguages(cursorQuery, map, true);
            HWRLanguagePackListener hWRLanguagePackListener = this.mLanguagePackListener;
            if (hWRLanguagePackListener == null) {
                Log.e(TAG, "[queryToGetAvailableList] mLanguagePackListener is null!");
                zOnUpdateAvailableLanguageList = false;
            } else {
                zOnUpdateAvailableLanguageList = hWRLanguagePackListener.onUpdateAvailableLanguageList(map);
            }
            cursorQuery.close();
            closeContentProviderClient(contentProviderClient);
            return zOnUpdateAvailableLanguageList;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return false;
        }
    }

    public synchronized boolean queryToGetDownloadingLangList() {
        boolean zOnUpdateDownloadingLanguageList;
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            Log.e(TAG, "[queryToGetDownloadingLangList] client is null");
            return false;
        }
        try {
            Cursor cursorQuery = contentProviderClient.query(HWRResourceManagerContract.Downloading.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                Log.e(TAG, "[queryToGetDownloadingLangList] cursor is null!");
                closeContentProviderClient(contentProviderClient);
                return false;
            }
            HashMap map = new HashMap();
            makeMapForLanguages(cursorQuery, map, false);
            HWRLanguagePackListener hWRLanguagePackListener = this.mLanguagePackListener;
            if (hWRLanguagePackListener == null) {
                Log.e(TAG, "[queryToGetDownloadingLangList] mLanguagePackListener is null!");
                zOnUpdateDownloadingLanguageList = false;
            } else {
                zOnUpdateDownloadingLanguageList = hWRLanguagePackListener.onUpdateDownloadingLanguageList(map);
            }
            cursorQuery.close();
            closeContentProviderClient(contentProviderClient);
            return zOnUpdateDownloadingLanguageList;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return false;
        }
    }

    public synchronized boolean queryToGetInstalledLangList() {
        boolean zOnUpdateInstalledLanguageList;
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            Log.e(TAG, "[queryToGetInstalledLangList] client is null");
            return false;
        }
        try {
            Cursor cursorQuery = contentProviderClient.query(HWRResourceManagerContract.Updates.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                Log.e(TAG, "[queryToGetInstalledLangList] cursor is null!");
                closeContentProviderClient(contentProviderClient);
                return false;
            }
            HashMap map = new HashMap();
            makeMapForLanguages(cursorQuery, map, false);
            HWRLanguagePackListener hWRLanguagePackListener = this.mLanguagePackListener;
            if (hWRLanguagePackListener == null) {
                Log.e(TAG, "[queryToGetInstalledLangList] mLanguagePackListener is null!");
                zOnUpdateInstalledLanguageList = false;
            } else {
                zOnUpdateInstalledLanguageList = hWRLanguagePackListener.onUpdateInstalledLanguageList(map);
            }
            cursorQuery.close();
            closeContentProviderClient(contentProviderClient);
            return zOnUpdateInstalledLanguageList;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return false;
        }
    }

    public void setOnLanguagePackListener(HWRLanguagePackListener hWRLanguagePackListener) {
        this.mLanguagePackListener = hWRLanguagePackListener;
    }

    public synchronized void updateResourceList() {
        this.mRmLauncher.launchUpdateByIntent("resList");
    }
}
