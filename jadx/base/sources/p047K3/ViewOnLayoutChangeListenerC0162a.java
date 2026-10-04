package p047K3;

import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.DefaultTemplateStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.common.AiDrawingRequestPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.tab.TemplateTabView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.PopupNoteActivity;

/* JADX INFO: renamed from: K3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnLayoutChangeListenerC0162a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f496a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f497b;

    public /* synthetic */ ViewOnLayoutChangeListenerC0162a(Object obj, int i) {
        this.f496a = i;
        this.f497b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        switch (this.f496a) {
            case 0:
                PopupNoteActivity.onCreate$lambda$0((PopupNoteActivity) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 1:
                ((CarouselLayoutManager) this.f497b).lambda$new$0(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 2:
                SpenColorSpoidLayout.mLayoutChangeListener$lambda$0((SpenColorSpoidLayout) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 3:
                BaseFragmentView.onCreateView$lambda$0((BaseFragmentView) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 4:
                DefaultTemplateStylePresenter.onResume$lambda$1((DefaultTemplateStylePresenter) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 5:
                ((AiDrawingRequestPopup) this.f497b).lambda$new$0(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 6:
                BaseTemplateStyleFragment.onResume$lambda$0((BaseTemplateStyleFragment) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 7:
                ((TitleEditor) this.f497b).lambda$init$1(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 8:
                ((TitleViewManager) this.f497b).lambda$init$2(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 9:
                QuickTool.initCoverView$lambda$2((QuickTool) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 10:
                QuickToolContainer.setCoverAndContainer$lambda$1((QuickToolContainer) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            default:
                TemplateTabView.initLayout$lambda$0((TemplateTabView) this.f497b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
        }
    }
}
