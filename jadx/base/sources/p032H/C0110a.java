package p032H;

import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.util.List;
import p021E0.InterfaceC0074a;
import p024F.InterfaceC0085b;

/* JADX INFO: renamed from: H.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0110a implements InterfaceC0085b, InterfaceC6683a, InterfaceC0074a {

    /* JADX INFO: renamed from: a */
    public static C0110a f358a;

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady()");
        shareOldService.stopImport();
    }

    @Override // p021E0.InterfaceC0074a
    public void onCancel(List list) {
        StringBuilder sb = new StringBuilder("requestSubmitNotesInFolder, onCancel submited : ");
        sb.append(list == null ? 0 : list.size());
        MSLogger.m8632d("GraphManager", sb.toString());
    }

    @Override // p024F.InterfaceC0085b
    public void onDeleteLocalSharedSdocFinished() {
    }

    @Override // p021E0.InterfaceC0074a
    public void onResult(List list) {
        StringBuilder sb = new StringBuilder("requestSubmitNotesInFolder onResult submited :");
        sb.append(list == null ? 0 : list.size());
        MSLogger.m8632d("GraphManager", sb.toString());
    }
}
