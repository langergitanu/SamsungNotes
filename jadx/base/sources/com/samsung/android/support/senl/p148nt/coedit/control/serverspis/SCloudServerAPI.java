package com.samsung.android.support.senl.p148nt.coedit.control.serverspis;

import android.content.Context;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import java.util.Map;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0155m;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudServerAPI {
    protected String mAuthorization;
    protected String mGroupId;

    public void addNoteCommonHeaders(Map<String, String> map) {
        Context applicationContext = BaseUtils.getApplicationContext();
        map.put(SCloudServerConstants.APP_VERSION_HEADER, AbstractC0155m.m399n(applicationContext));
        map.put(SCloudServerConstants.SDK_VERSION_HEADER, Integer.toString(5400));
        map.put(SCloudServerConstants.XML_VERSION_HEADER, Integer.toString(2));
        map.put("x-sc-network", AbstractC0146d.m343b(applicationContext));
        map.put(SCloudServerConstants.MODEL_NAME_HEADER, DeviceUtils.getEncodedDeviceName(applicationContext));
    }

    public void addSCloudCommonHeaders(Map<String, String> map) {
        map.put("Authorization", this.mAuthorization);
        boolean z = AbstractC0146d.f417a;
        map.put(SCloudServerConstants.USER_AGENT_HEADER, SCloudPamHelper.getUserAgent());
    }
}
