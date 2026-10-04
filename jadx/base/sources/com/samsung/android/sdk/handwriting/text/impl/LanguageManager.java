package com.samsung.android.sdk.handwriting.text.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.handwriting.LanguageID;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LanguageManager {
    private final String TAG = "LanguageManager";
    private Context mContext;
    private LanguageRMHelper mRmHelper;

    public LanguageManager(Context context) {
        this.mContext = null;
        this.mRmHelper = null;
        this.mContext = context.getApplicationContext();
        this.mRmHelper = new LanguageRMHelper(this.mContext);
    }

    private List<String> getSupportedListWithLanguageCodeOnly(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Log.i(this.TAG, "raw supported languages = " + LanguageID.getIDs(list));
            for (String str : list) {
                String languageCodeFrom = LanguageID.getLanguageCodeFrom(str);
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                if (!arrayList.contains(languageCodeFrom)) {
                    arrayList.add(languageCodeFrom);
                }
            }
        }
        return arrayList;
    }

    public void close() {
        LanguageRMHelper languageRMHelper = this.mRmHelper;
        if (languageRMHelper != null) {
            languageRMHelper.close();
        }
        this.mContext = null;
    }

    public String getDefaultLocale(String str) {
        Log.i(this.TAG, "getDefaultLocale : input language code = [" + LanguageID.getID(str) + "]");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("ar".equals(str) || "sw".equals(str) || "ceb".equals(str)) {
            return str;
        }
        if (str.length() != 2) {
            return HwrLanguageMap.getInternalLocale(str);
        }
        List<String> priorityLocaleList = LanguageID.getPriorityLocaleList(str);
        Log.i(this.TAG, "getDefaultLocale : priority locale list = " + LanguageID.getIDs(priorityLocaleList));
        if (priorityLocaleList != null && priorityLocaleList.size() > 0) {
            if (this.mRmHelper == null) {
                this.mRmHelper = new LanguageRMHelper(this.mContext);
            }
            List<String> installedLanguageListByQuery = this.mRmHelper.getInstalledLanguageListByQuery();
            Log.i(this.TAG, "getDefaultLocale : installed list = " + LanguageID.getIDs(installedLanguageListByQuery));
            if (installedLanguageListByQuery != null && installedLanguageListByQuery.size() > 0) {
                for (String str2 : priorityLocaleList) {
                    if (installedLanguageListByQuery.contains(str2)) {
                        Log.i(this.TAG, "getDefaultLocale : returned locale [" + LanguageID.getID(str2) + "] for input language code [" + LanguageID.getID(str) + "]");
                        return str2;
                    }
                }
            }
        }
        String defaultLanguageCode = LanguageID.getDefaultLanguageCode(str);
        Log.i(this.TAG, "getDefaultLocale : returned primary locale [" + LanguageID.getID(defaultLanguageCode) + "] for input language code [" + LanguageID.getID(str) + "]");
        return defaultLanguageCode;
    }

    public String getMD5String(String str) {
        if (this.mRmHelper != null) {
            return this.mRmHelper.getMD5StringOf(getDefaultLocale(str));
        }
        Log.e(this.TAG, "getMD5String : RMHelper is null");
        return "";
    }

    public String[] getResources(String str) {
        if (this.mRmHelper == null) {
            Log.e(this.TAG, "getResources : RMHelper is null");
            return new String[0];
        }
        String[] resources = this.mRmHelper.getResources(getDefaultLocale(str), "text");
        Log.i(this.TAG, "resources = " + LanguageID.getIDs(resources));
        return resources;
    }

    public byte[][] getResourcesByBuffer(String str) {
        if (this.mRmHelper != null) {
            return this.mRmHelper.getResourcesByBuffer(getDefaultLocale(str), "text");
        }
        Log.e(this.TAG, "getResourcesByBuffer : RMHelper is null");
        return null;
    }

    public String[] getSupportedLanguages() {
        if (this.mRmHelper == null) {
            this.mRmHelper = new LanguageRMHelper(this.mContext);
        }
        List<String> supportedListWithLanguageCodeOnly = getSupportedListWithLanguageCodeOnly(HwrLanguageMap.getModifiedLanguageList(this.mRmHelper.getInstalledLanguageListByQuery()));
        if (supportedListWithLanguageCodeOnly != null && supportedListWithLanguageCodeOnly.size() > 0) {
            String[] strArr = (String[]) supportedListWithLanguageCodeOnly.toArray(new String[supportedListWithLanguageCodeOnly.size()]);
            Log.i(this.TAG, "supported languages = " + LanguageID.getIDs(strArr));
            return strArr;
        }
        if (supportedListWithLanguageCodeOnly == null) {
            Log.e(this.TAG, "installed list is null");
        } else if (supportedListWithLanguageCodeOnly.size() <= 0) {
            Log.e(this.TAG, "size of installed list = " + LanguageID.getIDs(supportedListWithLanguageCodeOnly));
        }
        return new String[0];
    }

    public boolean isSupportedLanguage(String str) {
        if (this.mRmHelper == null) {
            this.mRmHelper = new LanguageRMHelper(this.mContext);
        }
        List<String> supportedListWithLanguageCodeOnly = getSupportedListWithLanguageCodeOnly(HwrLanguageMap.getModifiedLanguageList(this.mRmHelper.getInstalledLanguageListByQuery()));
        if (supportedListWithLanguageCodeOnly == null || supportedListWithLanguageCodeOnly.size() <= 0) {
            return false;
        }
        return supportedListWithLanguageCodeOnly.contains(str);
    }
}
