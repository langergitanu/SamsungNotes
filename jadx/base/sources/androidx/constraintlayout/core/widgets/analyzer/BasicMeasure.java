package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0098 A[PHI: r10
      0x0098: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0062, B:34:0x0068, B:36:0x006c, B:54:0x0095, B:52:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ac A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        HorizontalWidgetRun horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun;
        int size = constraintWidgetContainer.mChildren.size();
        boolean zOptimizeFor = constraintWidgetContainer.optimizeFor(64);
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !constraintWidget.isInVirtualLayout() && (!zOptimizeFor || (horizontalWidgetRun = constraintWidget.horizontalRun) == null || (verticalWidgetRun = constraintWidget.verticalRun) == null || !horizontalWidgetRun.dimension.resolved || !verticalWidgetRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                boolean z = true;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight != 1;
                if (z2 || !constraintWidgetContainer.optimizeFor(1) || (constraintWidget instanceof VirtualLayout)) {
                    z = z2;
                    if (z) {
                        measure(measurer, constraintWidget, Measure.SELF_DIMENSIONS);
                        Metrics metrics = constraintWidgetContainer.mMetrics;
                        if (metrics != null) {
                            metrics.measuredWidgets++;
                        }
                    }
                } else {
                    if (dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour2 != dimensionBehaviour3 && !constraintWidget.isInHorizontalChain()) {
                        z2 = true;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour != dimensionBehaviour3 && !constraintWidget.isInHorizontalChain()) {
                        z2 = true;
                    }
                    if ((dimensionBehaviour != dimensionBehaviour3 && dimensionBehaviour2 != dimensionBehaviour3) || constraintWidget.mDimensionRatio <= 0.0f) {
                    }
                    if (z) {
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i, int i2, int i4) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setHeight(i4);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.setPass(i);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        long j;
        boolean zDirectMeasureWithOrientation;
        int i11;
        int i12;
        int i13;
        long j2;
        int i14;
        boolean z;
        int i15;
        int i16;
        int i17;
        Metrics metrics;
        BasicMeasure basicMeasure = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        int size = constraintWidgetContainer2.mChildren.size();
        int width = constraintWidgetContainer2.getWidth();
        int height = constraintWidgetContainer2.getHeight();
        boolean zEnabled = Optimizer.enabled(i, 128);
        boolean z2 = zEnabled || Optimizer.enabled(i, 64);
        if (z2) {
            for (int i18 = 0; i18 < size; i18++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i18);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z3 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z3) || ((constraintWidget.isInVerticalChain() && z3) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        boolean z4 = z2 & ((i5 == 1073741824 && i7 == 1073741824) || zEnabled);
        int i19 = 2;
        if (z4) {
            j = 1;
            int iMin = Math.min(constraintWidgetContainer2.getMaxWidth(), i6);
            int iMin2 = Math.min(constraintWidgetContainer2.getMaxHeight(), i8);
            if (i5 == 1073741824 && constraintWidgetContainer2.getWidth() != iMin) {
                constraintWidgetContainer2.setWidth(iMin);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i7 == 1073741824 && constraintWidgetContainer2.getHeight() != iMin2) {
                constraintWidgetContainer2.setHeight(iMin2);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i5 == 1073741824 && i7 == 1073741824) {
                zDirectMeasureWithOrientation = constraintWidgetContainer2.directMeasure(zEnabled);
                i11 = 2;
            } else {
                boolean zDirectMeasureSetup = constraintWidgetContainer2.directMeasureSetup(zEnabled);
                if (i5 == 1073741824) {
                    zDirectMeasureSetup &= constraintWidgetContainer2.directMeasureWithOrientation(zEnabled, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i7 == 1073741824) {
                    zDirectMeasureWithOrientation = constraintWidgetContainer2.directMeasureWithOrientation(zEnabled, 1) & zDirectMeasureSetup;
                    i11++;
                } else {
                    zDirectMeasureWithOrientation = zDirectMeasureSetup;
                }
            }
            if (zDirectMeasureWithOrientation) {
                constraintWidgetContainer2.updateFromRuns(i5 == 1073741824, i7 == 1073741824);
            }
        } else {
            j = 1;
            zDirectMeasureWithOrientation = false;
            i11 = 0;
        }
        if (zDirectMeasureWithOrientation && i11 == 2) {
            return 0L;
        }
        int optimizationLevel = constraintWidgetContainer2.getOptimizationLevel();
        if (size > 0) {
            measureChildren(constraintWidgetContainer);
        }
        updateHierarchy(constraintWidgetContainer);
        int size2 = basicMeasure.mVariableDimensionsWidgets.size();
        if (size > 0) {
            basicMeasure.solveLinearSystem(constraintWidgetContainer2, "First pass", 0, width, height);
            i12 = width;
            i13 = height;
        } else {
            i12 = width;
            i13 = height;
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer2.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z5 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
            boolean z6 = constraintWidgetContainer2.getVerticalDimensionBehaviour() == dimensionBehaviour2;
            int iMax = Math.max(constraintWidgetContainer2.getWidth(), basicMeasure.constraintWidgetContainer.getMinWidth());
            j2 = 0;
            int iMax2 = Math.max(constraintWidgetContainer2.getHeight(), basicMeasure.constraintWidgetContainer.getMinHeight());
            int i20 = 0;
            boolean zNeedSolverPass = false;
            while (i20 < size2) {
                ConstraintWidget constraintWidget2 = basicMeasure.mVariableDimensionsWidgets.get(i20);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    z = z4;
                    int height2 = constraintWidget2.getHeight();
                    i15 = i20;
                    boolean zMeasure = basicMeasure.measure(measurer, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS) | zNeedSolverPass;
                    Metrics metrics2 = constraintWidgetContainer2.mMetrics;
                    i16 = i12;
                    i17 = i13;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets += j;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z5 && constraintWidget2.getRight() > iMax) {
                            iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget2.getRight());
                        }
                        zMeasure = true;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z6 && constraintWidget2.getBottom() > iMax2) {
                            iMax2 = Math.max(iMax2, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget2.getBottom());
                        }
                        zMeasure = true;
                    }
                    zNeedSolverPass = zMeasure | ((VirtualLayout) constraintWidget2).needSolverPass();
                } else {
                    z = z4;
                    i15 = i20;
                    i16 = i12;
                    i17 = i13;
                }
                i20 = i15 + 1;
                i12 = i16;
                i13 = i17;
                z4 = z;
                i19 = 2;
            }
            boolean z7 = z4;
            int i21 = i12;
            int i22 = i13;
            int i23 = i19;
            int i24 = 0;
            while (true) {
                if (i24 >= i23) {
                    break;
                }
                int i25 = 0;
                while (i25 < size2) {
                    ConstraintWidget constraintWidget3 = basicMeasure.mVariableDimensionsWidgets.get(i25);
                    if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.getVisibility() == 8 || ((z7 && constraintWidget3.horizontalRun.dimension.resolved && constraintWidget3.verticalRun.dimension.resolved) || (constraintWidget3 instanceof VirtualLayout))) {
                        i14 = i25;
                    } else {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        int i26 = Measure.TRY_GIVEN_DIMENSIONS;
                        i14 = i25;
                        if (i24 == 1) {
                            i26 = Measure.USE_GIVEN_DIMENSIONS;
                        }
                        boolean zMeasure2 = basicMeasure.measure(measurer, constraintWidget3, i26) | zNeedSolverPass;
                        Metrics metrics3 = constraintWidgetContainer2.mMetrics;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets += j;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z5 && constraintWidget3.getRight() > iMax) {
                                iMax = Math.max(iMax, constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget3.getRight());
                            }
                            zMeasure2 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z6 && constraintWidget3.getBottom() > iMax2) {
                                iMax2 = Math.max(iMax2, constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget3.getBottom());
                            }
                            zMeasure2 = true;
                        }
                        zNeedSolverPass = (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) ? zMeasure2 : true;
                    }
                    i25 = i14 + 1;
                    basicMeasure = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
                if (!zNeedSolverPass) {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    break;
                }
                i24++;
                solveLinearSystem(constraintWidgetContainer, "intermediate pass", i24, i21, i22);
                basicMeasure = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
                i23 = 2;
                zNeedSolverPass = false;
            }
        } else {
            j2 = 0;
        }
        constraintWidgetContainer2.setOptimizationLevel(optimizationLevel);
        return j2;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
