package p019D3;

import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.p161ai.cover.LsAiCoverMenuViewPresenter;

/* JADX INFO: renamed from: D3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0072a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f250a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LsAiCoverMenuViewPresenter f251b;

    public /* synthetic */ RunnableC0072a(LsAiCoverMenuViewPresenter lsAiCoverMenuViewPresenter, int i) {
        this.f250a = i;
        this.f251b = lsAiCoverMenuViewPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f250a) {
            case 0:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter*/.onClickOptionMenu();
                break;
            default:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter*/.onClickButton();
                break;
        }
    }
}
