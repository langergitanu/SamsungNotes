package androidx.constraintlayout.core.widgets.analyzer;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.widgets) {
            int i = this.orientation;
            if (i == 0) {
                widgetRun.widget.horizontalChainRun = this;
            } else if (i == 1) {
                widgetRun.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl() && this.widgets.size() > 1) {
            this.widget = ((WidgetRun) AbstractC1974b.m1313f(1, this.widgets)).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            wrapDimension = ((long) widgetRun.end.margin) + widgetRun.getWrapDimension() + wrapDimension + ((long) widgetRun.start.margin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.widgets) {
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        int i;
        int i2;
        boolean z;
        float f;
        float f4;
        int i4;
        int i5;
        int i6;
        int i7;
        float f5;
        int i8;
        int i9;
        float f6;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i14 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i15 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i15 >= size) {
                    i15 = -1;
                    break;
                } else if (this.widgets.get(i15).widget.getVisibility() != 8) {
                    break;
                } else {
                    i15++;
                }
            }
            int i16 = size - 1;
            int i17 = i16;
            while (true) {
                if (i17 < 0) {
                    break;
                }
                if (this.widgets.get(i17).widget.getVisibility() != 8) {
                    i = i17;
                    break;
                }
                i17--;
            }
            int i18 = 0;
            while (i18 < 2) {
                int i19 = 0;
                i5 = 0;
                i6 = 0;
                int i20 = 0;
                f4 = 0.0f;
                while (i19 < size) {
                    WidgetRun widgetRun = this.widgets.get(i19);
                    if (widgetRun.widget.getVisibility() == i2) {
                        z2 = zIsRtl;
                    } else {
                        i20++;
                        if (i19 > 0 && i19 >= i15) {
                            i5 += widgetRun.start.margin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i21 = dimensionDependency.value;
                        boolean z3 = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z3) {
                            int i22 = this.orientation;
                            if (i22 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i22 == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            } else {
                                z2 = zIsRtl;
                            }
                        } else {
                            z2 = zIsRtl;
                            if (widgetRun.matchConstraintsType == 1 && i18 == 0) {
                                i21 = dimensionDependency.wrapValue;
                                i6++;
                            } else if (dimensionDependency.resolved) {
                            }
                            z3 = true;
                        }
                        if (z3) {
                            i5 += i21;
                        } else {
                            i6++;
                            float f7 = widgetRun.widget.mWeight[this.orientation];
                            if (f7 >= 0.0f) {
                                f4 += f7;
                            }
                        }
                        if (i19 < i16 && i19 < i) {
                            i5 += -widgetRun.end.margin;
                        }
                    }
                    i19++;
                    zIsRtl = z2;
                    i2 = 8;
                }
                z = zIsRtl;
                f = 0.0f;
                if (i5 < i14 || i6 == 0) {
                    i4 = i20;
                    break;
                } else {
                    i18++;
                    zIsRtl = z;
                    i2 = 8;
                }
            }
            z = zIsRtl;
            f = 0.0f;
            f4 = 0.0f;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            int i23 = this.start.value;
            if (z) {
                i23 = this.end.value;
            }
            float f8 = 0.5f;
            if (i5 > i14) {
                i23 = z ? i23 + ((int) (((i5 - i14) / 2.0f) + 0.5f)) : i23 - ((int) (((i5 - i14) / 2.0f) + 0.5f));
            }
            if (i6 > 0) {
                float f9 = i14 - i5;
                int i24 = (int) ((f9 / i6) + 0.5f);
                int i25 = 0;
                int i26 = 0;
                while (i25 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i25);
                    float f10 = f8;
                    int i27 = i23;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (dimensionDependency2.resolved) {
                            f6 = f9;
                            i10 = i24;
                            i13 = i25;
                            i26 = i26;
                        } else {
                            int i28 = f4 > f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f9) / f4) + f10) : i24;
                            f6 = f9;
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.widget;
                                i10 = i24;
                                i11 = constraintWidget.mMatchConstraintMaxWidth;
                                i12 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                i10 = i24;
                                ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                i11 = constraintWidget2.mMatchConstraintMaxHeight;
                                i12 = constraintWidget2.mMatchConstraintMinHeight;
                            }
                            i13 = i25;
                            int i29 = i26;
                            int iMax = Math.max(i12, widgetRun2.matchConstraintsType == 1 ? Math.min(i28, dimensionDependency2.wrapValue) : i28);
                            if (i11 > 0) {
                                iMax = Math.min(i11, iMax);
                            }
                            if (iMax != i28) {
                                i26 = i29 + 1;
                                i28 = iMax;
                            } else {
                                i26 = i29;
                            }
                            widgetRun2.dimension.resolve(i28);
                        }
                    }
                    i25 = i13 + 1;
                    f8 = f10;
                    i23 = i27;
                    f9 = f6;
                    i24 = i10;
                }
                i7 = i23;
                f5 = f8;
                int i30 = i26;
                if (i30 > 0) {
                    i6 -= i30;
                    i5 = 0;
                    for (int i31 = 0; i31 < size; i31++) {
                        WidgetRun widgetRun3 = this.widgets.get(i31);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i31 > 0 && i31 >= i15) {
                                i5 += widgetRun3.start.margin;
                            }
                            i5 += widgetRun3.dimension.value;
                            if (i31 < i16 && i31 < i) {
                                i5 += -widgetRun3.end.margin;
                            }
                        }
                    }
                }
                i9 = 2;
                if (this.chainStyle == 2 && i30 == 0) {
                    i8 = 0;
                    this.chainStyle = 0;
                } else {
                    i8 = 0;
                }
            } else {
                i7 = i23;
                f5 = 0.5f;
                i8 = 0;
                i9 = 2;
            }
            if (i5 > i14) {
                this.chainStyle = i9;
            }
            if (i4 > 0 && i6 == 0 && i15 == i) {
                this.chainStyle = i9;
            }
            int i32 = this.chainStyle;
            if (i32 == 1) {
                int i33 = i4 > 1 ? (i14 - i5) / (i4 - 1) : i4 == 1 ? (i14 - i5) / 2 : i8;
                if (i6 > 0) {
                    i33 = i8;
                }
                int i34 = i7;
                while (i8 < size) {
                    WidgetRun widgetRun4 = this.widgets.get(z ? size - (i8 + 1) : i8);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i34);
                        widgetRun4.end.resolve(i34);
                    } else {
                        if (i8 > 0) {
                            i34 = z ? i34 - i33 : i34 + i33;
                        }
                        if (i8 > 0 && i8 >= i15) {
                            i34 = z ? i34 - widgetRun4.start.margin : i34 + widgetRun4.start.margin;
                        }
                        if (z) {
                            widgetRun4.end.resolve(i34);
                        } else {
                            widgetRun4.start.resolve(i34);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i35 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i35 = dimensionDependency3.wrapValue;
                        }
                        i34 = z ? i34 - i35 : i34 + i35;
                        if (z) {
                            widgetRun4.start.resolve(i34);
                        } else {
                            widgetRun4.end.resolve(i34);
                        }
                        widgetRun4.resolved = true;
                        if (i8 < i16 && i8 < i) {
                            i34 = z ? i34 - (-widgetRun4.end.margin) : i34 + (-widgetRun4.end.margin);
                        }
                    }
                    i8++;
                }
                return;
            }
            if (i32 == 0) {
                int i36 = (i14 - i5) / (i4 + 1);
                if (i6 > 0) {
                    i36 = i8;
                }
                int i37 = i7;
                while (i8 < size) {
                    WidgetRun widgetRun5 = this.widgets.get(z ? size - (i8 + 1) : i8);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i37);
                        widgetRun5.end.resolve(i37);
                    } else {
                        int i38 = z ? i37 - i36 : i37 + i36;
                        if (i8 > 0 && i8 >= i15) {
                            i38 = z ? i38 - widgetRun5.start.margin : i38 + widgetRun5.start.margin;
                        }
                        if (z) {
                            widgetRun5.end.resolve(i38);
                        } else {
                            widgetRun5.start.resolve(i38);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int iMin = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                        }
                        i37 = z ? i38 - iMin : i38 + iMin;
                        if (z) {
                            widgetRun5.start.resolve(i37);
                        } else {
                            widgetRun5.end.resolve(i37);
                        }
                        if (i8 < i16 && i8 < i) {
                            i37 = z ? i37 - (-widgetRun5.end.margin) : i37 + (-widgetRun5.end.margin);
                        }
                    }
                    i8++;
                }
                return;
            }
            if (i32 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (z) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i39 = (int) (((i14 - i5) * horizontalBiasPercent) + f5);
                if (i39 < 0 || i6 > 0) {
                    i39 = i8;
                }
                int i40 = z ? i7 - i39 : i7 + i39;
                while (i8 < size) {
                    WidgetRun widgetRun6 = this.widgets.get(z ? size - (i8 + 1) : i8);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i40);
                        widgetRun6.end.resolve(i40);
                    } else {
                        if (i8 > 0 && i8 >= i15) {
                            i40 = z ? i40 - widgetRun6.start.margin : i40 + widgetRun6.start.margin;
                        }
                        if (z) {
                            widgetRun6.end.resolve(i40);
                        } else {
                            widgetRun6.start.resolve(i40);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i41 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i41 = dimensionDependency5.wrapValue;
                        }
                        i40 = z ? i40 - i41 : i40 + i41;
                        if (z) {
                            widgetRun6.start.resolve(i40);
                        } else {
                            widgetRun6.end.resolve(i40);
                        }
                        if (i8 < i16 && i8 < i) {
                            i40 = z ? i40 - (-widgetRun6.end.margin) : i40 + (-widgetRun6.end.margin);
                        }
                    }
                    i8++;
                }
            }
        }
    }
}
