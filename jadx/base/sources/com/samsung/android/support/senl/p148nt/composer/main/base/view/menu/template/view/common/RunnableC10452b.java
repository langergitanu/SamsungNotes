package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10452b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7187a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CommonTemplateStyleLayout f7188b;

    public /* synthetic */ RunnableC10452b(CommonTemplateStyleLayout commonTemplateStyleLayout, int i) {
        this.f7187a = i;
        this.f7188b = commonTemplateStyleLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7187a) {
            case 0:
                CommonTemplateStyleLayout.calculateTabWidth$lambda$6(this.f7188b);
                break;
            default:
                CommonTemplateStyleLayout.updatePagerHeight$lambda$7(this.f7188b);
                break;
        }
    }
}
