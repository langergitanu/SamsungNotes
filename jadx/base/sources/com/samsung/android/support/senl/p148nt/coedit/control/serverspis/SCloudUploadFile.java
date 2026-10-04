package com.samsung.android.support.senl.p148nt.coedit.control.serverspis;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.HttpRequestUtil;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.SCloudHttpClient;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.SCloudHttpResponse;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudUploadFile extends SCloudServerAPI {
    public static final int ERROR_CONNECTION_RESET_FAILED_TO_UPLOAD = -2;
    private static final String TAG = "NT/SCloudUploadFile";
    private final String mContentType;
    private final String mFilePath;
    private final long mFileSize;
    private final String mUrl;

    public SCloudUploadFile(String str, String str2, String str3, long j, String str4, String str5) {
        this.mAuthorization = str;
        this.mUrl = str2;
        this.mFilePath = str3;
        this.mFileSize = j;
        this.mContentType = str4;
        this.mGroupId = str5;
    }

    private Map<String, String> getRequestHeaders() {
        HashMap map = new HashMap();
        addSCloudCommonHeaders(map);
        addNoteCommonHeaders(map);
        map.put("Content-Type", this.mContentType);
        map.put("Range", "bytes=0-" + (this.mFileSize - 1));
        map.put("Content-Length", Long.toString(this.mFileSize));
        map.put(SCloudServerConstants.GROUP_ID_HEADER, this.mGroupId);
        return map;
    }

    public int perform() {
        CoeditLogger.m8923i(TAG, "[CS5] perform() start");
        Map<String, String> requestHeaders = getRequestHeaders();
        if (TextUtils.isEmpty(this.mFilePath)) {
            CoeditLogger.m8920e(TAG, "[CS5-2] perform : Empty file path!");
            return -1;
        }
        try {
            SCloudHttpResponse sCloudHttpResponsePut = new SCloudHttpClient().put(this.mUrl, null, requestHeaders, this.mFilePath);
            if (sCloudHttpResponsePut == null) {
                CoeditLogger.m8920e(TAG, "[CS5-2] perform : fail to upload a file!");
                return -2;
            }
            if (HttpRequestUtil.isFailedResponse(sCloudHttpResponsePut.statusCode)) {
                CoeditLogger.m8920e(TAG, "[CS5-2] perform : fail to upload a file, " + sCloudHttpResponsePut.responseStr);
                return -1;
            }
            CoeditLogger.m8923i(TAG, "[CS5-1] perform : succeed to upload a file : " + sCloudHttpResponsePut.responseStr);
            return 0;
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, "[CS5-2] perform : " + e.getMessage());
            CoeditLogger.m8920e(TAG, "[CS5-2] perform : fail to upload a file!");
            return -1;
        }
    }
}
