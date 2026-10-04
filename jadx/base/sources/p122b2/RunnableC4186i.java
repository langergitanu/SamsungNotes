package p122b2;

import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;

/* JADX INFO: renamed from: b2.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4186i implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1785a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuitySessionFileManager.FileInfoListener f1786b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ContinuityFileId f1787c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ byte[] f1788d;

    public /* synthetic */ RunnableC4186i(ContinuitySessionFileManager.FileInfoListener fileInfoListener, ContinuityFileId continuityFileId, byte[] bArr, int i) {
        this.f1785a = i;
        this.f1786b = fileInfoListener;
        this.f1787c = continuityFileId;
        this.f1788d = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1785a) {
            case 0:
                this.f1786b.onFileInfoReceived(this.f1787c, this.f1788d);
                break;
            default:
                this.f1786b.onFileInfoReceived(this.f1787c, this.f1788d);
                break;
        }
    }
}
