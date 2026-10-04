package p055M2;

import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: M2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class CallableC0178a implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f562a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LockTask f563b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ LockTask.DocumentInfo f564c;

    public /* synthetic */ CallableC0178a(LockTask lockTask, LockTask.DocumentInfo documentInfo, int i) {
        this.f562a = i;
        this.f563b = lockTask;
        this.f564c = documentInfo;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f562a) {
            case 0:
                return LockTask.toCallableSetUnLockNotes$lambda$1(this.f563b, this.f564c);
            default:
                return LockTask.toCallableSetLockNotes$lambda$0(this.f563b, this.f564c);
        }
    }
}
