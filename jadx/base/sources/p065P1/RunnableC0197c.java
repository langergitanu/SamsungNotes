package p065P1;

import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;

/* JADX INFO: renamed from: P1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0197c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f613a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetSingleGlanceSettingPresenter f614b;

    public /* synthetic */ RunnableC0197c(WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter, int i) {
        this.f613a = i;
        this.f614b = widgetSingleGlanceSettingPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f613a) {
            case 0:
                WidgetSingleGlanceSettingPresenter.updatePreviewAndSetting$lambda$3(this.f614b);
                break;
            default:
                WidgetSingleGlanceSettingPresenter.mCreatedCallback$lambda$1$lambda$0(this.f614b);
                break;
        }
    }
}
