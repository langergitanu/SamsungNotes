package com.samsung.scsp.odm.dos.common;

import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.framework.core.api.FileTransferableJob;
import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OdmDosDownloadFileJobImpl extends FileTransferableJob {
    public OdmDosDownloadFileJobImpl(HttpRequest.Method method, String str, String str2) {
        super(method, str, str2);
    }

    @Override // com.samsung.scsp.framework.core.api.SimpleJob, com.samsung.scsp.framework.core.api.Job
    public HttpRequest createRequest(ApiContext apiContext, Listeners listeners) {
        StringBuilder sb = new StringBuilder(getApiUrl(apiContext));
        if (apiContext.parameters.containsKey(OdmDosApiContract.Parameter.DOWNLOAD_API)) {
            sb.append(apiContext.parameters.getAsString(OdmDosApiContract.Parameter.DOWNLOAD_API));
        }
        return createRequest(apiContext, listeners, sb.toString(), apiContext.parameters.getAsString(OdmDosApiContract.Parameter.FILE_PATH));
    }
}
