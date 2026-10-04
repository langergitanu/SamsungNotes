package p258y;

import com.samsung.android.app.notes.MemoApplication;

/* JADX INFO: renamed from: y.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC14515a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10344a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MemoApplication f10345b;

    public /* synthetic */ RunnableC14515a(MemoApplication memoApplication, int i) {
        this.f10344a = i;
        this.f10345b = memoApplication;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10344a) {
            case 0:
                this.f10345b.lambda$onCreate$6();
                break;
            case 1:
                this.f10345b.lambda$onCreate$7();
                break;
            case 2:
                this.f10345b.lambda$sendRestoreDocumentAction$8();
                break;
            case 3:
                this.f10345b.lambda$sendRestoreDocumentAction$9();
                break;
            case 4:
                this.f10345b.lambda$changeConfigurationToDisplayUtils$10();
                break;
            case 5:
                this.f10345b.lambda$onCreate$1();
                break;
            case 6:
                this.f10345b.lambda$onCreate$2();
                break;
            default:
                this.f10345b.lambda$onCreate$5();
                break;
        }
    }
}
