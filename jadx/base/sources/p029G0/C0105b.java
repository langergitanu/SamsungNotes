package p029G0;

import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;

/* JADX INFO: renamed from: G0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0105b implements InterfaceC0122a, InterfaceC6683a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f348a;

    public /* synthetic */ C0105b(String str) {
        this.f348a = str;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady()");
        shareOldService.requestShare(this.f348a);
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        StringBuilder sb = new StringBuilder("result add attachment. path : ");
        String str = this.f348a;
        sb.append(str);
        sb.append(", onResult : ");
        sb.append(c0124c);
        MSLogger.m8632d("UpdateNote", sb.toString());
        FileUtils.deleteFile(str);
    }
}
