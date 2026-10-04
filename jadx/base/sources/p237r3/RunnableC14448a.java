package p237r3;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;

/* JADX INFO: renamed from: r3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC14448a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10234a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RtToolbarPresenter f10235b;

    public /* synthetic */ RunnableC14448a(RtToolbarPresenter rtToolbarPresenter, int i) {
        this.f10234a = i;
        this.f10235b = rtToolbarPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10234a) {
            case 0:
                this.f10235b.lambda$updateState$0();
                break;
            default:
                this.f10235b.lambda$onShowWindow$1();
                break;
        }
    }
}
