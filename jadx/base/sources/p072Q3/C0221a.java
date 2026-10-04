package p072Q3;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.AiSuggestionView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewManager;

/* JADX INFO: renamed from: Q3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0221a implements SpenPreTouchListenerImpl.PreTouchListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f660a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f661b;

    public /* synthetic */ C0221a(Object obj, int i) {
        this.f660a = i;
        this.f661b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f660a) {
            case 0:
                return GuidePresenter.makePreTouchListener$lambda$0((GuidePresenter) this.f661b, view, motionEvent);
            case 1:
                return AiSuggestionView.makePreTouchListener$lambda$0((AiSuggestionView) this.f661b, view, motionEvent);
            case 2:
                return QuickTool.initQuickTool$lambda$0((QuickTool) this.f661b, view, motionEvent);
            case 3:
                return MenuBarPresenter.makePreTouchListener$lambda$1((MenuBarPresenter) this.f661b, view, motionEvent);
            case 4:
                return ScrollPresenter.makePreTouchListener$lambda$0((ScrollPresenter) this.f661b, view, motionEvent);
            default:
                return SettingViewManager.makePreTouchListener$lambda$0((SettingViewManager) this.f661b, view, motionEvent);
        }
    }
}
