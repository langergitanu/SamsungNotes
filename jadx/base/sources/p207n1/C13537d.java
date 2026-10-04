package p207n1;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.cms.SamsungAccountConsentHelper;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: renamed from: n1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13537d {

    /* JADX INFO: renamed from: a */
    public final String f9567a;

    /* JADX INFO: renamed from: b */
    public final String f9568b;

    /* JADX INFO: renamed from: c */
    public final String f9569c;

    /* JADX INFO: renamed from: d */
    public final String f9570d;

    /* JADX INFO: renamed from: e */
    public final String f9571e;

    /* JADX INFO: renamed from: f */
    public String f9572f;

    /* JADX INFO: renamed from: g */
    public String f9573g;

    /* JADX INFO: renamed from: h */
    public final String f9574h;

    public C13537d() {
        Context applicationContext = BaseUtils.getApplicationContext();
        this.f9567a = applicationContext.getPackageName();
        if (SyncState.isCmsTest()) {
            this.f9568b = CommonUtils.getAppServiceIdForStageAccount();
        } else {
            this.f9568b = CommonUtils.getAppServiceId();
        }
        this.f9569c = PackageManagerCompat.INSTANCE.getApkVersionName(applicationContext, this.f9567a);
        SamsungAccountConsentHelper samsungAccountConsentHelper = new SamsungAccountConsentHelper();
        this.f9571e = samsungAccountConsentHelper.getRegion();
        this.f9570d = samsungAccountConsentHelper.getLanguage();
        this.f9574h = "galaxystore.openapi";
    }
}
