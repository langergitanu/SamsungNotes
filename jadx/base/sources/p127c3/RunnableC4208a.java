package p127c3;

import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager$sAuthInfoReqListener$1;

/* JADX INFO: renamed from: c3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4208a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1852a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1853b;

    public /* synthetic */ RunnableC4208a(String str, int i) {
        this.f1852a = i;
        this.f1853b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1852a) {
            case 0:
                TokenManager$sAuthInfoReqListener$1.onError$lambda$1(this.f1853b);
                break;
            case 1:
                DummyDocumentDetector.lambda$findRestorePath$1(this.f1853b);
                break;
            default:
                RecentSearchDatabaseHelper.AsyncExecutor.insertSearchKeyword$lambda$0(this.f1853b);
                break;
        }
    }
}
