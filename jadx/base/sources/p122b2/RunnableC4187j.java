package p122b2;

import com.samsung.android.mcf.continuity.impl.ContinuitySendFile;

/* JADX INFO: renamed from: b2.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4187j implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1789a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuitySendFile f1790b;

    public /* synthetic */ RunnableC4187j(ContinuitySendFile continuitySendFile, int i) {
        this.f1789a = i;
        this.f1790b = continuitySendFile;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f1789a) {
            case 0:
                this.f1790b.lambda$read$2();
                break;
            case 1:
                this.f1790b.lambda$sendFileInfo$0();
                break;
            default:
                this.f1790b.lambda$sendFileData$1();
                break;
        }
    }
}
