package com.samsung.scsp.odm.dos.common;

import android.util.Pair;
import com.samsung.scsp.common.Invoker;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.ApiControl;
import com.samsung.scsp.framework.core.decorator.AbstractDecorator;
import com.samsung.scsp.framework.core.decorator.SdkFeature;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OdmDosDecorator extends AbstractDecorator {
    public OdmDosDecorator(Class<? extends ApiControl> cls, SdkFeature... sdkFeatureArr) {
        super(cls, sdkFeatureArr);
    }

    public boolean downloadInternal(String str, String str2, String str3, Invoker invoker) throws ScspException {
        ScspException.throwIfEmpty(str2, "downloadApi is null or empty.");
        ScspException.throwIfEmpty(str3, "path is null or empty.");
        execute(str, null, null, invoker, new Pair(OdmDosApiContract.Parameter.DOWNLOAD_API, str2), new Pair(OdmDosApiContract.Parameter.FILE_PATH, str3));
        return new File(str3).length() > 0;
    }

    public <T> T listForTargetDeviceInternal(String str, String str2, String str3, OdmDosTargetHeader odmDosTargetHeader, Invoker invoker) throws ScspException {
        ScspException.throwIfEmpty(str2, "contentKey is null or empty.");
        OdmDosTargetHeader.verify(odmDosTargetHeader);
        return (T) execute(str, null, str3, invoker, new Pair(OdmDosApiContract.Parameter.CONTENT_KEY, str2), new Pair(OdmDosApiContract.Parameter.TARGET_DEVICE, odmDosTargetHeader));
    }

    public <T> T listInternal(String str, String str2, String str3, Invoker invoker) throws ScspException {
        ScspException.throwIfEmpty(str2, "contentKey is null or empty.");
        return (T) execute(str, null, str3, invoker, new Pair(OdmDosApiContract.Parameter.CONTENT_KEY, str2));
    }
}
