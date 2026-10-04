package p016D0;

import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;

/* JADX INFO: renamed from: D0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0057b implements IPublicClientApplication.ISingleAccountApplicationCreatedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0059d f227a;

    public C0057b(C0059d c0059d) {
        this.f227a = c0059d;
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication.ISingleAccountApplicationCreatedListener
    public final void onCreated(ISingleAccountPublicClientApplication iSingleAccountPublicClientApplication) {
        C0059d c0059d = this.f227a;
        c0059d.f232a = iSingleAccountPublicClientApplication;
        C0059d.m136b(c0059d);
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication.ISingleAccountApplicationCreatedListener
    public final void onError(MsalException msalException) {
        MSLogger.m8633e("AuthenticationHelper", "Error creating MSAL application" + msalException.getMessage());
        C0059d.m136b(this.f227a);
    }
}
