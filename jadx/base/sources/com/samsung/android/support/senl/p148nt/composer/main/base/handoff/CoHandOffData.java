package com.samsung.android.support.senl.p148nt.composer.main.base.handoff;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoHandOffData {
    private static final String TAG = Logger.createTag("CoHandOffData");
    private JSONObject mJsonObject;

    public CoHandOffData() {
        this.mJsonObject = new JSONObject();
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return this.mJsonObject.getBoolean(str);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
            return z;
        }
    }

    public Double getDouble(String str) {
        try {
            return Double.valueOf(this.mJsonObject.getDouble(str));
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
            return null;
        }
    }

    public Integer getInt(String str) {
        try {
            return Integer.valueOf(this.mJsonObject.getInt(str));
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
            return null;
        }
    }

    public JSONObject getJsonObject() {
        return this.mJsonObject;
    }

    public Long getLong(String str) {
        try {
            return Long.valueOf(this.mJsonObject.getLong(str));
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
            return null;
        }
    }

    public String getString(String str) {
        try {
            return this.mJsonObject.getString(str);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
            return null;
        }
    }

    public void putBoolean(String str, boolean z) {
        try {
            this.mJsonObject.put(str, z);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    public void putDouble(String str, double d) {
        try {
            this.mJsonObject.put(str, d);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    public void putInt(String str, int i) {
        try {
            this.mJsonObject.put(str, i);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    public void putLong(String str, long j) {
        try {
            this.mJsonObject.put(str, j);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    public void putString(String str, String str2) {
        try {
            this.mJsonObject.put(str, str2);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    public CoHandOffData(String str) {
        try {
            this.mJsonObject = new JSONObject(str);
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }
}
