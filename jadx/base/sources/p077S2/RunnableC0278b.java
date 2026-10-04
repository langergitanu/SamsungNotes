package p077S2;

import com.samsung.android.support.senl.p148nt.app.settings.about.AboutActivity;
import com.samsung.android.support.senl.p148nt.app.sync.providers.SDocProviderDump;

/* JADX INFO: renamed from: S2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC0278b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f729a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AboutActivity f730b;

    public /* synthetic */ RunnableC0278b(AboutActivity aboutActivity, int i) {
        this.f729a = i;
        this.f730b = aboutActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f729a) {
            case 0:
                AboutActivity.startProgress$lambda$8(this.f730b);
                break;
            case 1:
                SDocProviderDump.dumpStorageInfo(this.f730b);
                break;
            case 2:
                AboutActivity.stateChanged$lambda$10(this.f730b);
                break;
            default:
                AboutActivity.stopProgress$lambda$9(this.f730b);
                break;
        }
    }
}
