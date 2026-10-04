package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependencyNode) {
        WidgetRun widgetRun = this.run;
        ((VerticalWidgetRun) widgetRun).baseline.margin = widgetRun.widget.getBaselineDistance();
        this.resolved = true;
    }
}
