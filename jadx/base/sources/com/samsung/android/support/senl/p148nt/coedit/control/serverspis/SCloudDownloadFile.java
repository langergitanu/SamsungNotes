package com.samsung.android.support.senl.p148nt.coedit.control.serverspis;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.HttpRequestUtil;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.SCloudHttpClient;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.SCloudHttpResponse;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudDownloadFile extends SCloudServerAPI {
    private static final String TAG = "NT/SCloudDownloadFile";
    private final String mUrl;

    public SCloudDownloadFile(String str, String str2) {
        this.mUrl = str;
        this.mGroupId = str2;
    }

    private Map<String, String> getRequestHeaders() {
        HashMap map = new HashMap();
        addSCloudCommonHeaders(map);
        addNoteCommonHeaders(map);
        map.put(SCloudServerConstants.GROUP_ID_HEADER, this.mGroupId);
        return map;
    }

    private String getTempFilePath() {
        File file;
        String path = BaseUtils.getApplicationContext().getFilesDir().getPath();
        int i = 1;
        while (true) {
            file = new File(path, AbstractC0000a.m11h(i, "coedit_attachments_"));
            int i2 = i + 1;
            if (i > 5) {
                CoeditLogger.m8920e(TAG, "[CS7-2] temp folder was not created");
                return null;
            }
            if (file.exists() || file.mkdirs()) {
                break;
            }
            i = i2;
        }
        return file.getPath();
    }

    public String perform() {
        String tempFilePath;
        CoeditLogger.m8923i(TAG, "[CS7] perform() start");
        Map<String, String> requestHeaders = getRequestHeaders();
        try {
            tempFilePath = getTempFilePath();
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("[CS7-2] perform : "), TAG);
        }
        if (tempFilePath == null) {
            return null;
        }
        SCloudHttpResponse sCloudHttpResponse = new SCloudHttpClient().get(this.mUrl, null, requestHeaders, tempFilePath);
        if (sCloudHttpResponse == null) {
            CoeditLogger.m8920e(TAG, "[CS7-2] perform : fail to download!");
            return null;
        }
        if (HttpRequestUtil.isFailedResponse(sCloudHttpResponse.statusCode)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] perform : fail to download, " + sCloudHttpResponse.responseStr);
            return null;
        }
        if (!TextUtils.isEmpty(sCloudHttpResponse.responseStr)) {
            return sCloudHttpResponse.responseStr;
        }
        CoeditLogger.m8920e(TAG, "[CS7-2] perform : filePath is empty!");
        CoeditLogger.m8920e(TAG, "[CS7-2] perform() fail");
        return null;
    }
}
