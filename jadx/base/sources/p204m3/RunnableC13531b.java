package p204m3;

import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCutTask;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: m3.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC13531b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9541a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9542b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9543c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f9544d;

    public /* synthetic */ RunnableC13531b(Object obj, int i, Object obj2, Object obj3) {
        this.f9541a = i;
        this.f9542b = obj;
        this.f9543c = obj2;
        this.f9544d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9541a) {
            case 0:
                AiResultCutTask.runOnThread$lambda$1((AiResultCutTask) this.f9542b, (Ref.ObjectRef) this.f9543c, (Ref.ObjectRef) this.f9544d);
                break;
            default:
                SettingsSyncWithSamsungAccountPrefFragment.C87751.onStart$lambda$0((WorkerTask) this.f9542b, (SettingsSyncWithSamsungAccountPrefFragment) this.f9543c, (SettingsSyncWithSamsungAccountPrefFragment.C87751) this.f9544d);
                break;
        }
    }
}
