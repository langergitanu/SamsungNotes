package p016D0;

import com.microsoft.identity.client.IMultipleAccountPublicClientApplication;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;

/* JADX INFO: renamed from: D0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0056a implements IPublicClientApplication.IMultipleAccountApplicationCreatedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0059d f226a;

    public C0056a(C0059d c0059d) {
        this.f226a = c0059d;
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication.IMultipleAccountApplicationCreatedListener
    public final void onCreated(IMultipleAccountPublicClientApplication iMultipleAccountPublicClientApplication) {
        C0059d c0059d = this.f226a;
        c0059d.f232a = iMultipleAccountPublicClientApplication;
        C0059d.m136b(c0059d);
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication.IMultipleAccountApplicationCreatedListener
    public final void onError(MsalException msalException) {
        MSLogger.m8633e("AuthenticationHelper", "Error creating MSAL application" + msalException.getMessage());
    }
}
