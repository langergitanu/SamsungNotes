package p065P1;

import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;

/* JADX INFO: renamed from: P1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0196b implements CacheFileManager.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f611a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ BaseWidgetSettingPresenter f612b;

    public /* synthetic */ C0196b(BaseWidgetSettingPresenter baseWidgetSettingPresenter, int i) {
        this.f611a = i;
        this.f612b = baseWidgetSettingPresenter;
    }

    @Override // com.samsung.android.app.notes.widget.capture.CacheFileManager.Callback
    public final void onCacheCreated() {
        switch (this.f611a) {
            case 0:
                WidgetSingleGlanceSettingPresenter.mCreatedCallback$lambda$1((WidgetSingleGlanceSettingPresenter) this.f612b);
                break;
            default:
                WidgetSettingPresenter.mCreatedCallback$lambda$1((WidgetSettingPresenter) this.f612b);
                break;
        }
    }
}
