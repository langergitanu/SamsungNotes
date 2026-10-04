package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.scloud.lib.setting.RPCSettingStatusContract;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SettingSuggestionProviderClient implements ISettingSuggestion {
    private static final String DELIMTER = "_";
    private static String TAG = null;
    private static final int TAG_ID_IDX = 1;
    private Context context;

    public SettingSuggestionProviderClient(Context context, String str) {
        TAG = str;
        this.context = context;
    }

    private String getTagId(String str) {
        return str.split(DELIMTER)[1];
    }

    @Override // com.samsung.android.scloud.lib.setting.ISettingSuggestion
    public int getStatus(String str) {
        try {
            Log.i(TAG, "getStatus");
            Bundle bundle = new Bundle();
            bundle.putString(RPCSettingStatusContract.Parameter.TAG_ID, getTagId(str));
            bundle.putString("status_id", str);
            return this.context.getContentResolver().call(RPCSettingStatusContract.Method.CONTENT_URI, RPCSettingStatusContract.Method.GET_STATUS_BY_ID, (String) null, bundle).getInt(RPCSettingStatusContract.Parameter.STATUS_BY_ID, -1);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISettingSuggestion
    public int getStatusByTag(String str) {
        try {
            Log.i(TAG, "getStatusByTag");
            Bundle bundle = new Bundle();
            bundle.putString(RPCSettingStatusContract.Parameter.TAG_ID, str);
            return this.context.getContentResolver().call(RPCSettingStatusContract.Method.CONTENT_URI, RPCSettingStatusContract.Method.GET_STATUS_BY_TAG, (String) null, bundle).getInt(RPCSettingStatusContract.Parameter.STATUS_BY_TAG, -1);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISettingSuggestion
    public Uri getStatusChangedUri(String str) {
        try {
            Log.i(TAG, "getStatusChangedUri");
            Bundle bundle = new Bundle();
            bundle.putString(RPCSettingStatusContract.Parameter.TAG_ID, str);
            String string = this.context.getContentResolver().call(RPCSettingStatusContract.Method.CONTENT_URI, RPCSettingStatusContract.Method.GET_STATUS_CHANGED_URI, (String) null, bundle).getString(RPCSettingStatusContract.Parameter.STATUS_CHANGED_URI, null);
            if (string != null) {
                return Uri.parse(string);
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISettingSuggestion
    public ArrayList<String> getStatusIds(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Log.i(TAG, "getStatusIds");
            Bundle bundle = new Bundle();
            bundle.putString(RPCSettingStatusContract.Parameter.TAG_ID, str);
            return this.context.getContentResolver().call(RPCSettingStatusContract.Method.CONTENT_URI, RPCSettingStatusContract.Method.GET_STATUS_IDS, (String) null, bundle).getStringArrayList(RPCSettingStatusContract.Parameter.STATUS_IDS);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return arrayList;
        }
    }
}
