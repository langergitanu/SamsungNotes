package p079T;

import android.content.Context;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p148nt.app.updater.RevisionOperationExecutor;
import com.samsung.android.support.senl.p148nt.app.updater.migration.CoverDataMigrationManager;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;

/* JADX INFO: renamed from: T.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0286d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f744a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f745b;

    public /* synthetic */ RunnableC0286d(Context context, int i) {
        this.f744a = i;
        this.f745b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f744a) {
            case 0:
                ToastHandler.show(this.f745b, C7943R.string.sync_tipcard_fail_to_network_error_body, 0);
                break;
            case 1:
                ProfileInstallerInitializer.writeInBackground(this.f745b);
                break;
            case 2:
                ProfileInstaller.writeProfile(this.f745b);
                break;
            case 3:
                RevisionOperationExecutor.lambda$checkSdocXInOldFolder$2(this.f745b);
                break;
            case 4:
                RevisionOperationExecutor.lambda$removeSesSkipItems$5(this.f745b);
                break;
            case 5:
                DummyDocumentDetector.deleteDummyFile(this.f745b);
                break;
            case 6:
                RevisionOperationExecutor.lambda$deleteDummyDbData$3(this.f745b);
                break;
            default:
                CoverDataMigrationManager.execute(this.f745b);
                break;
        }
    }
}
