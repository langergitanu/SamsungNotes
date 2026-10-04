package com.sec.android.diagmonagent.log.provider;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class EventBuilder {
    private Context mContext;
    private String mLogPath = "";
    private String mServiceDefinedKey = "";
    private String mErrorCode = "";
    private String mDescription = "";
    private String mRelayClientVer = "";
    private String mRelayClientType = "";
    private JSONObject mExtData = null;

    public EventBuilder(Context context) {
        this.mContext = context;
    }

    public static long getAvailableInternalStorageSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    private JSONObject getNativeMemory() {
        long nativeHeapFreeSize = Debug.getNativeHeapFreeSize() >> 20;
        long nativeHeapSize = Debug.getNativeHeapSize() >> 20;
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() >> 20;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(nativeHeapSize, "[NativeHeap] nativeHeapSize : ", " nativeHeapFree : ");
        sbM1323p.append(nativeHeapFreeSize);
        sbM1323p.append(" nativeHeapAllocatedSize : ");
        sbM1323p.append(nativeHeapAllocatedSize);
        AppLog.m13140d(sbM1323p.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("HEAP_SIZE", nativeHeapSize);
            jSONObject.put("HEAP_FREE", nativeHeapFreeSize);
            jSONObject.put("HEAD_ALLOC", nativeHeapAllocatedSize);
            return jSONObject;
        } catch (JSONException e) {
            AppLog.m13141e(e.getMessage());
            return jSONObject;
        }
    }

    private static long getTotalInternalStorageSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
    }

    private JSONObject getVmMemory() {
        Runtime runtime = Runtime.getRuntime();
        long j = runtime.totalMemory() >> 20;
        long jFreeMemory = runtime.freeMemory() >> 20;
        long jMaxMemory = runtime.maxMemory() >> 20;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "[VM] TotalMemory : ", " FreeMemory : ");
        sbM1323p.append(jFreeMemory);
        sbM1323p.append(" maxMemory : ");
        sbM1323p.append(jMaxMemory);
        AppLog.m13140d(sbM1323p.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TOTAL", j);
            jSONObject.put("FREE", jFreeMemory);
            jSONObject.put("MAX", jMaxMemory);
            return jSONObject;
        } catch (JSONException e) {
            AppLog.m13141e(e.getMessage());
            return jSONObject;
        }
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getExtData() {
        JSONObject jSONObject = this.mExtData;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public JSONObject getInternalStorageSize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TOTAL", getTotalInternalStorageSize() >> 20);
            jSONObject.put("FREE", getAvailableInternalStorageSize() >> 20);
            return jSONObject;
        } catch (JSONException e) {
            AppLog.m13141e(e.getMessage());
            return jSONObject;
        }
    }

    public String getLogPath() {
        return this.mLogPath;
    }

    public JSONObject getMemory() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("VM", getVmMemory());
            jSONObject.put("NATIVE", getNativeMemory());
            AppLog.m13140d(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getRelayClientType() {
        return this.mRelayClientType;
    }

    public String getRelayClientVer() {
        return this.mRelayClientVer;
    }

    public String getServiceDefinedKey() {
        return this.mServiceDefinedKey;
    }

    public EventBuilder setDescription(String str) {
        this.mDescription = str;
        return this;
    }

    public EventBuilder setErrorCode(String str) {
        this.mErrorCode = str;
        return this;
    }

    public EventBuilder setExtData(JSONObject jSONObject) {
        this.mExtData = jSONObject;
        return this;
    }

    public EventBuilder setLogPath(String str) {
        this.mLogPath = str;
        return this;
    }

    public EventBuilder setRelayClientType(String str) {
        this.mRelayClientType = str;
        return this;
    }

    public EventBuilder setRelayClientVer(String str) {
        this.mRelayClientVer = str;
        return this;
    }

    public EventBuilder setServiceDefinedKey(String str) {
        if (DiagMonUtil.checkDMA(this.mContext) == 1 && !TextUtils.isEmpty(str) && str.contains("/")) {
            AppLog.m13144w("delimiter is included : ".concat(str));
            return this;
        }
        this.mServiceDefinedKey = str;
        return this;
    }
}
