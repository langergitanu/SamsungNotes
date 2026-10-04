package androidx.constraintlayout.core.widgets;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    public WidgetFrame frame;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean horizontalSolvingPass;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;

    /* JADX INFO: renamed from: mX */
    protected int f1236mX;

    /* JADX INFO: renamed from: mY */
    protected int f1237mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    private boolean verticalSolvingPass;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C23051 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type */
        static final /* synthetic */ int[] f1238x6930e354;

        /* JADX INFO: renamed from: $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour */
        static final /* synthetic */ int[] f1239x6d00e4a2;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f1239x6d00e4a2 = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1239x6d00e4a2[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1239x6d00e4a2[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1239x6d00e4a2[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f1238x6930e354 = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1238x6930e354[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f1236mX = 0;
        this.f1237mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04a2 A[PHI: r7
      0x04a2: PHI (r7v13 int) = (r7v12 int), (r7v17 int), (r7v17 int), (r7v17 int) binds: [B:301:0x0492, B:303:0x0498, B:304:0x049a, B:306:0x049e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0519 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:382:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i4, int i5, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f4, boolean z11) {
        int i10;
        boolean z12;
        int i11;
        int iMin;
        int i12;
        SolverVariable solverVariable3;
        int i13;
        SolverVariable solverVariable4;
        int i14;
        boolean z13;
        boolean z14;
        int i15;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i16;
        char c;
        boolean z15;
        ConstraintAnchor constraintAnchor3;
        int i17;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        int i18;
        int i19;
        int i20;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        SolverVariable solverVariable11;
        SolverVariable solverVariable12;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        int i21;
        boolean z20;
        int iMin2;
        int i22;
        boolean z21;
        int i23;
        ConstraintWidget constraintWidget4;
        int i24;
        boolean z22;
        int i25;
        int i26;
        int i27;
        boolean z23;
        int i28;
        boolean z24;
        ConstraintWidget constraintWidget5;
        int i29;
        ConstraintWidget constraintWidget6;
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem2.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem2.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i30 = zIsConnected2 ? (zIsConnected ? 1 : 0) + 1 : zIsConnected ? 1 : 0;
        if (zIsConnected3) {
            i30++;
        }
        int i31 = z6 ? 3 : i6;
        int i32 = C23051.f1239x6d00e4a2[dimensionBehaviour.ordinal()];
        if (i32 != 1 && i32 != 2 && i32 != 3 && i32 == 4) {
            i10 = i31;
            z12 = i10 != 4;
            i11 = this.mWidthOverride;
            if (i11 == -1 && z) {
                this.mWidthOverride = -1;
                z12 = false;
            } else {
                i11 = i2;
            }
            iMin = this.mHeightOverride;
            if (iMin != -1 || z) {
                iMin = i11;
            } else {
                this.mHeightOverride = -1;
                z12 = false;
            }
            if (this.mVisibility == 8) {
                iMin = 0;
                z12 = false;
            }
            if (z11) {
                if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable3, i);
                } else if (zIsConnected && !zIsConnected2) {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                }
            }
            if (z12) {
                if (z5) {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                    if (i4 > 0) {
                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i4, 8);
                    }
                    if (i5 < Integer.MAX_VALUE) {
                        linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i5, 8);
                    }
                } else {
                    linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                }
                i15 = i9;
                solverVariable3 = solverVariableCreateObjectVariable4;
                i13 = i30;
                z13 = z12;
                solverVariable4 = solverVariableCreateObjectVariable6;
                z14 = z4;
            } else {
                if (i30 == 2 || z6 || !(i10 == 1 || i10 == 0)) {
                    int i33 = i8 == -2 ? iMin : i8;
                    int i34 = i9 == -2 ? iMin : i9;
                    if (iMin > 0 && i10 != 1) {
                        iMin = 0;
                    }
                    if (i33 > 0) {
                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i33, 8);
                        iMin = Math.max(iMin, i33);
                    }
                    if (i34 > 0) {
                        if (!z2 || i10 != 1) {
                            linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i34, 8);
                        }
                        iMin = Math.min(iMin, i34);
                    }
                    if (i10 == 1) {
                        if (z2) {
                            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                        } else if (z8) {
                            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                            linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                        } else {
                            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                            linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                        }
                        solverVariable3 = solverVariableCreateObjectVariable4;
                        z13 = z12;
                        solverVariable4 = solverVariableCreateObjectVariable6;
                        z14 = z4;
                        i14 = i33;
                        i15 = i34;
                        i13 = i30;
                    } else {
                        if (i10 == 2) {
                            ConstraintAnchor.Type type = constraintAnchor.getType();
                            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                            if (type == type2 || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                                solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(this.mParent.getAnchor(type2));
                                solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                            } else {
                                solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                            }
                            SolverVariable solverVariable14 = solverVariableCreateObjectVariable2;
                            solverVariable3 = solverVariableCreateObjectVariable4;
                            i12 = i34;
                            i13 = i30;
                            solverVariable4 = solverVariableCreateObjectVariable6;
                            linearSystem2.addConstraint(linearSystem2.createRow().createRowDimensionRatio(solverVariable3, solverVariableCreateObjectVariable3, solverVariable14, solverVariableCreateObjectVariable, f4));
                            if (z2) {
                                z12 = false;
                            }
                            i14 = i33;
                            z13 = z12;
                            z14 = z4;
                        } else {
                            i12 = i34;
                            solverVariable3 = solverVariableCreateObjectVariable4;
                            i13 = i30;
                            solverVariable4 = solverVariableCreateObjectVariable6;
                            i14 = i33;
                            z13 = z12;
                            z14 = true;
                        }
                        i15 = i12;
                    }
                    if (!z11) {
                        solverVariable5 = solverVariable;
                        solverVariable6 = solverVariable2;
                        i16 = 8;
                        c = 2;
                    } else {
                        if (!z8) {
                            if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                                solverVariable12 = solverVariable4;
                                i23 = 5;
                                z20 = z2;
                                i29 = i23;
                            } else if (!zIsConnected || zIsConnected2) {
                                if (!zIsConnected && zIsConnected2) {
                                    linearSystem2.addEquality(solverVariable3, solverVariable4, -constraintAnchor2.getMargin(), 8);
                                    if (z2) {
                                        if (this.OPTIMIZE_WRAP && solverVariableCreateObjectVariable3.isFinalValue && (constraintWidget5 = this.mParent) != null) {
                                            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget5;
                                            if (z) {
                                                constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                            } else {
                                                constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                            }
                                        } else {
                                            linearSystem2.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                                            i23 = 5;
                                            solverVariable12 = solverVariable4;
                                            z20 = z2;
                                            i29 = i23;
                                        }
                                    }
                                } else if (zIsConnected && zIsConnected2) {
                                    ConstraintWidget constraintWidget7 = constraintAnchor.mTarget.mOwner;
                                    ConstraintWidget constraintWidget8 = constraintAnchor2.mTarget.mOwner;
                                    ConstraintWidget parent = getParent();
                                    int i35 = 6;
                                    if (!z13) {
                                        i17 = 8;
                                        if (solverVariableCreateObjectVariable5.isFinalValue && solverVariable4.isFinalValue) {
                                            SolverVariable solverVariable15 = solverVariable4;
                                            linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f, solverVariable15, solverVariable3, constraintAnchor2.getMargin(), 8);
                                            if (z2 && z14) {
                                                int margin = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                                                if (solverVariable15 != solverVariable2) {
                                                    linearSystem.addGreaterThan(solverVariable2, solverVariable3, margin, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        linearSystem2 = linearSystem;
                                        solverVariable7 = solverVariableCreateObjectVariable3;
                                        solverVariable8 = solverVariable4;
                                        solverVariable9 = solverVariableCreateObjectVariable5;
                                        solverVariable10 = solverVariable2;
                                        i18 = 6;
                                        i19 = 4;
                                        i20 = 5;
                                        z16 = true;
                                        z17 = true;
                                        z18 = false;
                                    } else if (i10 == 0) {
                                        if (i15 != 0 || i14 != 0) {
                                            i27 = 8;
                                            z23 = false;
                                            i28 = 5;
                                            i19 = 5;
                                            z24 = true;
                                            z17 = true;
                                        } else {
                                            if (solverVariableCreateObjectVariable5.isFinalValue && solverVariable4.isFinalValue) {
                                                linearSystem2.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                                                linearSystem2.addEquality(solverVariable3, solverVariable4, -constraintAnchor2.getMargin(), 8);
                                                return;
                                            }
                                            i27 = 8;
                                            z24 = false;
                                            z17 = false;
                                            i28 = 8;
                                            i19 = 8;
                                            z23 = true;
                                        }
                                        if ((constraintWidget7 instanceof Barrier) || (constraintWidget8 instanceof Barrier)) {
                                            solverVariable7 = solverVariableCreateObjectVariable3;
                                            solverVariable8 = solverVariable4;
                                            z18 = z23;
                                            i19 = 4;
                                        } else {
                                            solverVariable7 = solverVariableCreateObjectVariable3;
                                            solverVariable8 = solverVariable4;
                                            z18 = z23;
                                        }
                                        solverVariable10 = solverVariable2;
                                        z16 = z24;
                                        i20 = i28;
                                        i17 = i27;
                                        solverVariable9 = solverVariableCreateObjectVariable5;
                                        i18 = 6;
                                    } else {
                                        i17 = 8;
                                        if (i10 == 2) {
                                            if ((constraintWidget7 instanceof Barrier) || (constraintWidget8 instanceof Barrier)) {
                                                solverVariable7 = solverVariableCreateObjectVariable3;
                                                solverVariable8 = solverVariable4;
                                                solverVariable9 = solverVariableCreateObjectVariable5;
                                                i18 = 6;
                                                i19 = 4;
                                            } else {
                                                solverVariable7 = solverVariableCreateObjectVariable3;
                                                solverVariable8 = solverVariable4;
                                                solverVariable9 = solverVariableCreateObjectVariable5;
                                                i18 = 6;
                                                i19 = 5;
                                            }
                                            i20 = 5;
                                        } else if (i10 == 1) {
                                            solverVariable7 = solverVariableCreateObjectVariable3;
                                            solverVariable8 = solverVariable4;
                                            solverVariable9 = solverVariableCreateObjectVariable5;
                                            i18 = 6;
                                            i20 = 8;
                                            i19 = 4;
                                        } else if (i10 == 3) {
                                            if (this.mResolvedDimensionRatioSide == -1) {
                                                if (z9) {
                                                    linearSystem2 = linearSystem;
                                                    solverVariable7 = solverVariableCreateObjectVariable3;
                                                    solverVariable8 = solverVariable4;
                                                    solverVariable9 = solverVariableCreateObjectVariable5;
                                                    i20 = 8;
                                                    i18 = z2 ? 5 : 4;
                                                } else {
                                                    linearSystem2 = linearSystem;
                                                    solverVariable7 = solverVariableCreateObjectVariable3;
                                                    solverVariable8 = solverVariable4;
                                                    solverVariable9 = solverVariableCreateObjectVariable5;
                                                    i18 = 8;
                                                    i20 = 8;
                                                }
                                                i19 = 5;
                                            } else {
                                                if (z6) {
                                                    if (i7 == 2 || i7 == 1) {
                                                        i25 = 5;
                                                        i26 = 4;
                                                    } else {
                                                        i25 = 8;
                                                        i26 = 5;
                                                    }
                                                    i20 = i25;
                                                    i19 = i26;
                                                    solverVariable7 = solverVariableCreateObjectVariable3;
                                                    solverVariable8 = solverVariable4;
                                                    solverVariable9 = solverVariableCreateObjectVariable5;
                                                    i18 = 6;
                                                } else {
                                                    if (i15 > 0) {
                                                        linearSystem2 = linearSystem;
                                                        solverVariable7 = solverVariableCreateObjectVariable3;
                                                        solverVariable8 = solverVariable4;
                                                        solverVariable9 = solverVariableCreateObjectVariable5;
                                                        i18 = 6;
                                                        i19 = 5;
                                                    } else if (i15 != 0 || i14 != 0) {
                                                        linearSystem2 = linearSystem;
                                                        solverVariable7 = solverVariableCreateObjectVariable3;
                                                        solverVariable8 = solverVariable4;
                                                        solverVariable9 = solverVariableCreateObjectVariable5;
                                                        i18 = 6;
                                                        i19 = 4;
                                                    } else if (z9) {
                                                        i20 = (constraintWidget7 == parent || constraintWidget8 == parent) ? 5 : 4;
                                                        solverVariable7 = solverVariableCreateObjectVariable3;
                                                        solverVariable8 = solverVariable4;
                                                        solverVariable9 = solverVariableCreateObjectVariable5;
                                                        i18 = 6;
                                                        i19 = 4;
                                                    } else {
                                                        linearSystem2 = linearSystem;
                                                        solverVariable7 = solverVariableCreateObjectVariable3;
                                                        solverVariable8 = solverVariable4;
                                                        solverVariable9 = solverVariableCreateObjectVariable5;
                                                        i18 = 6;
                                                        i19 = 8;
                                                    }
                                                    i20 = 5;
                                                }
                                                z16 = true;
                                                z17 = true;
                                                z18 = true;
                                                linearSystem2 = linearSystem;
                                                solverVariable10 = solverVariable2;
                                            }
                                            z16 = true;
                                            z17 = true;
                                            z18 = true;
                                            solverVariable10 = solverVariable2;
                                        } else {
                                            linearSystem2 = linearSystem;
                                            solverVariable7 = solverVariableCreateObjectVariable3;
                                            solverVariable8 = solverVariable4;
                                            solverVariable9 = solverVariableCreateObjectVariable5;
                                            i18 = 6;
                                            i19 = 4;
                                            i20 = 5;
                                            z16 = false;
                                            z17 = false;
                                            z18 = false;
                                            solverVariable10 = solverVariable2;
                                        }
                                        z16 = true;
                                        z17 = true;
                                        z18 = false;
                                        solverVariable10 = solverVariable2;
                                    }
                                    if (z17 && solverVariable9 == solverVariable8 && constraintWidget7 != parent) {
                                        z17 = false;
                                        z19 = false;
                                    } else {
                                        z19 = true;
                                    }
                                    if (z16) {
                                        if (z13 || z7 || z9 || solverVariable9 != solverVariable || solverVariable8 != solverVariable10) {
                                            constraintWidget4 = parent;
                                            i24 = i18;
                                            z22 = z2;
                                        } else {
                                            constraintWidget4 = parent;
                                            i24 = i17;
                                            i20 = i24;
                                            z22 = false;
                                            z19 = false;
                                        }
                                        solverVariable13 = solverVariable;
                                        constraintWidget = constraintWidget7;
                                        z2 = z22;
                                        i21 = i17;
                                        constraintWidget3 = constraintWidget4;
                                        constraintWidget2 = constraintWidget8;
                                        SolverVariable solverVariable16 = solverVariable3;
                                        linearSystem2.addCentering(solverVariable7, solverVariable9, constraintAnchor.getMargin(), f, solverVariable8, solverVariable16, constraintAnchor2.getMargin(), i24);
                                        SolverVariable solverVariable17 = solverVariable8;
                                        solverVariable11 = solverVariable7;
                                        solverVariable12 = solverVariable17;
                                        solverVariable3 = solverVariable16;
                                    } else {
                                        SolverVariable solverVariable18 = solverVariable8;
                                        solverVariable11 = solverVariable7;
                                        solverVariable12 = solverVariable18;
                                        solverVariable13 = solverVariable;
                                        constraintWidget = constraintWidget7;
                                        constraintWidget2 = constraintWidget8;
                                        constraintWidget3 = parent;
                                        i21 = i17;
                                    }
                                    z20 = z2;
                                    if (this.mVisibility == i21 && !constraintAnchor2.hasDependents()) {
                                        return;
                                    }
                                    if (z17) {
                                        int i36 = (!z20 || solverVariable9 == solverVariable12 || z13 || !((constraintWidget instanceof Barrier) || (constraintWidget2 instanceof Barrier))) ? i20 : 6;
                                        linearSystem2.addGreaterThan(solverVariable11, solverVariable9, constraintAnchor.getMargin(), i36);
                                        linearSystem2.addLowerThan(solverVariable3, solverVariable12, -constraintAnchor2.getMargin(), i36);
                                        i20 = i36;
                                    }
                                    if (!z20 || !z10 || (constraintWidget instanceof Barrier) || (constraintWidget2 instanceof Barrier) || constraintWidget2 == constraintWidget3) {
                                        iMin2 = i19;
                                        i22 = i20;
                                        z21 = z19;
                                    } else {
                                        iMin2 = 6;
                                        i22 = 6;
                                        z21 = true;
                                    }
                                    if (z21) {
                                        if (z18 && (!z9 || z3)) {
                                            if (constraintWidget != constraintWidget3 && constraintWidget2 != constraintWidget3) {
                                                i35 = iMin2;
                                            }
                                            if ((constraintWidget instanceof Guideline) || (constraintWidget2 instanceof Guideline)) {
                                                i35 = 5;
                                            }
                                            if ((constraintWidget instanceof Barrier) || (constraintWidget2 instanceof Barrier)) {
                                                i35 = 5;
                                            }
                                            iMin2 = Math.max(z9 ? 5 : i35, iMin2);
                                        }
                                        if (z20) {
                                            iMin2 = Math.min(i22, iMin2);
                                            int i37 = (z6 && !z9 && (constraintWidget == constraintWidget3 || constraintWidget2 == constraintWidget3)) ? 4 : iMin2;
                                            linearSystem2.addEquality(solverVariable11, solverVariable9, constraintAnchor.getMargin(), i37);
                                            linearSystem2.addEquality(solverVariable3, solverVariable12, -constraintAnchor2.getMargin(), i37);
                                        }
                                    }
                                    if (z20) {
                                        int margin2 = solverVariable13 == solverVariable9 ? constraintAnchor.getMargin() : 0;
                                        if (solverVariable9 != solverVariable13) {
                                            linearSystem2.addGreaterThan(solverVariable11, solverVariable13, margin2, 5);
                                        }
                                    }
                                    if (!z20 || !z13 || i4 != 0 || i14 != 0) {
                                        i23 = 5;
                                        i29 = i23;
                                    } else if (z13 && i10 == 3) {
                                        linearSystem2.addGreaterThan(solverVariable3, solverVariable11, 0, i21);
                                        i23 = 5;
                                        i29 = i23;
                                    } else {
                                        i23 = 5;
                                        linearSystem2.addGreaterThan(solverVariable3, solverVariable11, 0, 5);
                                        i29 = i23;
                                    }
                                }
                                solverVariable12 = solverVariable4;
                                i23 = 5;
                                z20 = z2;
                                i29 = i23;
                            } else {
                                z20 = z2;
                                solverVariable12 = solverVariable4;
                                i29 = (z2 && (constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 8 : 5;
                            }
                            if (z20 && z14) {
                                int margin3 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                                if (solverVariable12 != solverVariable2) {
                                    if (!this.OPTIMIZE_WRAP || !solverVariable3.isFinalValue || (constraintWidget6 = this.mParent) == null) {
                                        linearSystem2.addGreaterThan(solverVariable2, solverVariable3, margin3, i29);
                                        return;
                                    }
                                    ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget6;
                                    if (z) {
                                        constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                                        return;
                                    } else {
                                        constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        solverVariable5 = solverVariable;
                        solverVariable6 = solverVariable2;
                        c = 2;
                        i16 = 8;
                    }
                    if (i13 < c && z2 && z14) {
                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable5, 0, i16);
                        boolean z25 = z || this.mBaseline.mTarget == null;
                        if (z || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                            z15 = z25;
                        } else {
                            ConstraintWidget constraintWidget9 = constraintAnchor3.mOwner;
                            if (constraintWidget9.mDimensionRatio != 0.0f) {
                                DimensionBehaviour[] dimensionBehaviourArr = constraintWidget9.mListDimensionBehaviors;
                                DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                                DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                z15 = dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3;
                            }
                        }
                        if (z15) {
                            linearSystem2.addGreaterThan(solverVariable6, solverVariable3, 0, i16);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int iMax = Math.max(i8, iMin);
                if (i9 > 0) {
                    iMax = Math.min(i9, iMax);
                }
                linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax, 8);
                z14 = z4;
                i15 = i9;
                solverVariable3 = solverVariableCreateObjectVariable4;
                i13 = i30;
                solverVariable4 = solverVariableCreateObjectVariable6;
                z13 = false;
            }
            i14 = i8;
            if (!z11) {
            }
            if (i13 < c) {
                return;
            } else {
                return;
            }
        }
        i10 = i31;
        i11 = this.mWidthOverride;
        if (i11 == -1) {
            i11 = i2;
        }
        iMin = this.mHeightOverride;
        if (iMin != -1) {
            iMin = i11;
        }
        if (this.mVisibility == 8) {
        }
        if (z11) {
        }
        if (z12) {
        }
        i14 = i8;
        if (!z11) {
        }
        if (i13 < c) {
        }
    }

    private boolean isChainHead(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) ? false : true;
    }

    private void serializeAnchor(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(constraintAnchor.mGoneMargin);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void serializeAttribute(StringBuilder sb, String str, float f, float f4) {
        if (f == f4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f4);
        sb.append(",\n");
    }

    private void serializeCircle(StringBuilder sb, ConstraintAnchor constraintAnchor, float f) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append("circle : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(f);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void serializeDimensionRatio(StringBuilder sb, String str, float f, int i) {
        if (f == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f);
        sb.append(",");
        sb.append(i);
        sb.append("");
        sb.append("],\n");
    }

    private void serializeSize(StringBuilder sb, String str, int i, int i2, int i4, int i5, int i6, int i7, float f, float f4) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "size", i, -2.1474836E9f);
        serializeAttribute(sb, VElementFormulasCmd.FMIN, i2, 0.0f);
        serializeAttribute(sb, VElementFormulasCmd.FMAX, i4, 2.1474836E9f);
        serializeAttribute(sb, "matchMin", i6, 0.0f);
        float f5 = i7;
        serializeAttribute(sb, "matchDef", f5, 0.0f);
        serializeAttribute(sb, "matchPercent", f5, 1.0f);
        sb.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        int i;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        int i2;
        int i4;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        boolean z6;
        boolean z7;
        SolverVariable solverVariable3;
        boolean z8;
        SolverVariable solverVariable4;
        DimensionBehaviour dimensionBehaviour3;
        boolean z9;
        DimensionBehaviour dimensionBehaviour4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i8;
        boolean z10;
        boolean z11;
        boolean z12;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i9;
        char c;
        int i10;
        int i11;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        LinearSystem linearSystem2;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int i12;
        int i13;
        int i14;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun2;
        LinearSystem linearSystem3 = linearSystem;
        SolverVariable solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem3.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem3.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget4 = this.mParent;
        if (constraintWidget4 == null) {
            z2 = false;
            z3 = false;
        } else {
            z3 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            z2 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            int i15 = this.mWrapBehaviorInParent;
            if (i15 == 1) {
                z2 = false;
            } else if (i15 == 2) {
                z3 = false;
            } else if (i15 == 3) {
            }
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z13 = this.resolvedHorizontal;
        if (z13 || this.resolvedVertical) {
            if (z13) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable, this.f1236mX);
                linearSystem3.addEquality(solverVariableCreateObjectVariable2, this.f1236mX + this.mWidth);
                if (z3 && (constraintWidget2 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addHorizontalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget2.mRight), solverVariableCreateObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable3, this.f1237mY);
                linearSystem3.addEquality(solverVariableCreateObjectVariable4, this.f1237mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem3.addEquality(solverVariableCreateObjectVariable5, this.f1237mY + this.mBaselineDistance);
                }
                if (z2 && (constraintWidget = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget.mBottom), solverVariableCreateObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        Metrics metrics = LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.widgets++;
        }
        if (z && (horizontalWidgetRun2 = this.horizontalRun) != null && (verticalWidgetRun2 = this.verticalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun2.start;
            if (dependencyNode.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun2.start.resolved && verticalWidgetRun2.end.resolved) {
                if (metrics != null) {
                    metrics.graphSolved++;
                }
                linearSystem3.addEquality(solverVariableCreateObjectVariable, dependencyNode.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable2, this.horizontalRun.end.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable3, this.verticalRun.start.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable4, this.verticalRun.end.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable5, this.verticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                    }
                    if (z2 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 8);
                    }
                }
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        if (metrics != null) {
            metrics.linearSolved++;
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
                i14 = 1;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
                i14 = 1;
            }
            if (isChainHead(i14)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, i14);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (!zIsInHorizontalChain && z3 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 1);
            }
            if (!zIsInVerticalChain && z2 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 1);
            }
        } else {
            zIsInHorizontalChain = false;
            zIsInVerticalChain = false;
        }
        int i16 = this.mWidth;
        int i17 = this.mMinWidth;
        if (i16 >= i17) {
            i17 = i16;
        }
        int i18 = this.mHeight;
        int i19 = this.mMinHeight;
        if (i18 >= i19) {
            i19 = i18;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour6 = DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z14 = dimensionBehaviour5 != dimensionBehaviour6;
        DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[1];
        boolean z15 = zIsInHorizontalChain;
        boolean z16 = dimensionBehaviour7 != dimensionBehaviour6;
        boolean z17 = zIsInVerticalChain;
        int i20 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i20;
        int i21 = i19;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i22 = this.mMatchConstraintDefaultWidth;
        int i23 = this.mMatchConstraintDefaultHeight;
        if (f > 0.0f) {
            i = i17;
            if (this.mVisibility != 8) {
                i4 = (dimensionBehaviour5 == dimensionBehaviour6 && i22 == 0) ? 3 : i22;
                int i24 = (dimensionBehaviour7 == dimensionBehaviour6 && i23 == 0) ? 3 : i23;
                if (dimensionBehaviour5 == dimensionBehaviour6 && dimensionBehaviour7 == dimensionBehaviour6) {
                    solverVariable = solverVariableCreateObjectVariable2;
                    i13 = 3;
                    if (i4 == 3 && i24 == 3) {
                        setupDimensionRatio(z3, z2, z14, z16);
                    }
                    solverVariable2 = solverVariableCreateObjectVariable4;
                    i2 = i21;
                    z4 = true;
                    i5 = i24;
                    i6 = i;
                    int[] iArr = this.mResolvedMatchConstraintDefault;
                    iArr[0] = i4;
                    iArr[1] = i5;
                    this.mResolvedHasRatio = z4;
                    if (!z4) {
                        int i25 = this.mResolvedDimensionRatioSide;
                        i7 = -1;
                        z5 = i25 == 0 || i25 == -1;
                        boolean z18 = z4 && ((i12 = this.mResolvedDimensionRatioSide) == 1 || i12 == i7);
                        dimensionBehaviour = this.mListDimensionBehaviors[0];
                        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                        if (dimensionBehaviour == dimensionBehaviour2 && (this instanceof ConstraintWidgetContainer)) {
                            z6 = z5;
                            z7 = true;
                        } else {
                            z6 = z5;
                            z7 = false;
                        }
                        if (z7) {
                            i6 = 0;
                        }
                        boolean z19 = !this.mCenter.isConnected();
                        boolean[] zArr2 = this.mIsInBarrier;
                        boolean z20 = zArr2[0];
                        boolean z21 = zArr2[1];
                        if (this.mHorizontalResolution == 2 || this.resolvedHorizontal) {
                            solverVariable3 = solverVariableCreateObjectVariable;
                            z8 = z4;
                            solverVariable4 = solverVariable2;
                            dimensionBehaviour3 = dimensionBehaviour6;
                            z9 = z2;
                            dimensionBehaviour4 = dimensionBehaviour2;
                            z12 = z3;
                            solverVariable6 = solverVariableCreateObjectVariable3;
                            solverVariable5 = solverVariableCreateObjectVariable5;
                            z11 = z15;
                            z10 = z17;
                            i8 = i4;
                        } else {
                            if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
                                DependencyNode dependencyNode2 = horizontalWidgetRun.start;
                                if (dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
                                    if (z) {
                                        linearSystem3.addEquality(solverVariableCreateObjectVariable, dependencyNode2.value);
                                        SolverVariable solverVariable12 = solverVariable;
                                        linearSystem3.addEquality(solverVariable12, this.horizontalRun.end.value);
                                        if (this.mParent != null && z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                            linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariable12, 0, 8);
                                        }
                                        solverVariable3 = solverVariableCreateObjectVariable;
                                        z8 = z4;
                                        solverVariable4 = solverVariable2;
                                        dimensionBehaviour3 = dimensionBehaviour6;
                                        z9 = z2;
                                        dimensionBehaviour4 = dimensionBehaviour2;
                                        solverVariable = solverVariable12;
                                    }
                                    z12 = z3;
                                    solverVariable6 = solverVariableCreateObjectVariable3;
                                    solverVariable5 = solverVariableCreateObjectVariable5;
                                    z11 = z15;
                                    z10 = z17;
                                    i8 = i4;
                                }
                            }
                            SolverVariable solverVariable13 = solverVariable;
                            ConstraintWidget constraintWidget5 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable6 = constraintWidget5 != null ? linearSystem3.createObjectVariable(constraintWidget5.mRight) : null;
                            ConstraintWidget constraintWidget6 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable7 = constraintWidget6 != null ? linearSystem3.createObjectVariable(constraintWidget6.mLeft) : null;
                            boolean z22 = this.isTerminalWidget[0];
                            DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                            DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr2[0];
                            ConstraintAnchor constraintAnchor = this.mLeft;
                            i8 = i4;
                            ConstraintAnchor constraintAnchor2 = this.mRight;
                            z8 = z4;
                            z12 = z3;
                            int i26 = this.f1236mX;
                            boolean z23 = z6;
                            SolverVariable solverVariable14 = solverVariableCreateObjectVariable7;
                            int i27 = this.mMinWidth;
                            int i28 = this.mMaxDimension[0];
                            float f4 = this.mHorizontalBiasPercent;
                            boolean z24 = dimensionBehaviourArr2[1] == dimensionBehaviour6;
                            solverVariable3 = solverVariableCreateObjectVariable;
                            solverVariable4 = solverVariable2;
                            dimensionBehaviour3 = dimensionBehaviour6;
                            z9 = z2;
                            solverVariable5 = solverVariableCreateObjectVariable5;
                            z11 = z15;
                            z10 = z17;
                            dimensionBehaviour4 = dimensionBehaviour2;
                            solverVariable = solverVariable13;
                            solverVariable6 = solverVariableCreateObjectVariable3;
                            linearSystem3 = linearSystem;
                            applyConstraints(linearSystem3, true, z12, z9, z22, solverVariable14, solverVariableCreateObjectVariable6, dimensionBehaviour8, z7, constraintAnchor, constraintAnchor2, i26, i6, i27, i28, f4, z23, z24, z11, z10, z20, i8, i5, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z19);
                        }
                        if (!z || (verticalWidgetRun = this.verticalRun) == null) {
                            solverVariable7 = solverVariable6;
                            solverVariable8 = solverVariable4;
                            solverVariable9 = solverVariable5;
                            i9 = 0;
                            c = 1;
                            i10 = 8;
                            i11 = 1;
                        } else {
                            DependencyNode dependencyNode3 = verticalWidgetRun.start;
                            if (dependencyNode3.resolved && verticalWidgetRun.end.resolved) {
                                int i29 = dependencyNode3.value;
                                solverVariable7 = solverVariable6;
                                linearSystem3.addEquality(solverVariable7, i29);
                                solverVariable8 = solverVariable4;
                                linearSystem3.addEquality(solverVariable8, this.verticalRun.end.value);
                                solverVariable9 = solverVariable5;
                                linearSystem3.addEquality(solverVariable9, this.verticalRun.baseline.value);
                                ConstraintWidget constraintWidget7 = this.mParent;
                                if (constraintWidget7 == null || z10 || !z9) {
                                    i9 = 0;
                                    c = 1;
                                } else {
                                    c = 1;
                                    if (this.isTerminalWidget[1]) {
                                        i9 = 0;
                                        i10 = 8;
                                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget7.mBottom), solverVariable8, 0, 8);
                                        i11 = i9;
                                    } else {
                                        i9 = 0;
                                    }
                                }
                                i10 = 8;
                                i11 = i9;
                            }
                        }
                        if ((this.mVerticalResolution == 2 ? i9 : i11) == 0 || this.resolvedVertical) {
                            constraintWidget3 = this;
                            solverVariable10 = solverVariable7;
                            solverVariable11 = solverVariable8;
                        } else {
                            boolean z25 = (this.mListDimensionBehaviors[c] == dimensionBehaviour4 && (this instanceof ConstraintWidgetContainer)) ? c : i9;
                            int i30 = z25 != 0 ? i9 : i2;
                            ConstraintWidget constraintWidget8 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable8 = constraintWidget8 != null ? linearSystem3.createObjectVariable(constraintWidget8.mBottom) : null;
                            ConstraintWidget constraintWidget9 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable9 = constraintWidget9 != null ? linearSystem3.createObjectVariable(constraintWidget9.mTop) : null;
                            if (this.mBaselineDistance <= 0) {
                                boolean z26 = z19;
                                if (this.mVisibility == i10) {
                                    ConstraintAnchor constraintAnchor3 = this.mBaseline;
                                    if (constraintAnchor3.mTarget != null) {
                                        linearSystem3.addEquality(solverVariable9, solverVariable7, getBaselineDistance(), i10);
                                        linearSystem3.addEquality(solverVariable9, linearSystem3.createObjectVariable(this.mBaseline.mTarget), this.mBaseline.getMargin(), i10);
                                        if (z9) {
                                            linearSystem3.addGreaterThan(solverVariableCreateObjectVariable8, linearSystem3.createObjectVariable(this.mBottom), i9, 5);
                                        }
                                        z26 = i9;
                                    } else if (this.mVisibility == i10) {
                                        linearSystem3.addEquality(solverVariable9, solverVariable7, constraintAnchor3.getMargin(), i10);
                                        z26 = z19;
                                    } else {
                                        linearSystem3.addEquality(solverVariable9, solverVariable7, getBaselineDistance(), i10);
                                        z26 = z19;
                                    }
                                }
                                boolean z27 = this.isTerminalWidget[c];
                                DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                                int i31 = i9;
                                char c2 = c;
                                solverVariable10 = solverVariable7;
                                solverVariable11 = solverVariable8;
                                applyConstraints(linearSystem, false, z9, z12, z27, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr3[c], z25, this.mTop, this.mBottom, this.f1237mY, i30, this.mMinHeight, this.mMaxDimension[c2], this.mVerticalBiasPercent, z18, dimensionBehaviourArr3[i31] == dimensionBehaviour3 ? c2 : i31, z10, z11, z21, i5, i8, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z26);
                                constraintWidget3 = this;
                            }
                        }
                        if (!z8) {
                            linearSystem2 = linearSystem;
                        } else if (constraintWidget3.mResolvedDimensionRatioSide == 1) {
                            linearSystem.addRatio(solverVariable11, solverVariable10, solverVariable, solverVariable3, constraintWidget3.mResolvedDimensionRatio, 8);
                            linearSystem2 = linearSystem;
                        } else {
                            linearSystem.addRatio(solverVariable, solverVariable3, solverVariable11, solverVariable10, constraintWidget3.mResolvedDimensionRatio, 8);
                            linearSystem2 = linearSystem;
                        }
                        if (constraintWidget3.mCenter.isConnected()) {
                            linearSystem2.addCenterPoint(constraintWidget3, constraintWidget3.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget3.mCircleConstraintAngle + 90.0f), constraintWidget3.mCenter.getMargin());
                        }
                        constraintWidget3.resolvedHorizontal = false;
                        constraintWidget3.resolvedVertical = false;
                    }
                    i7 = -1;
                    if (z4) {
                    }
                    dimensionBehaviour = this.mListDimensionBehaviors[0];
                    dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour2) {
                        z6 = z5;
                        z7 = false;
                    }
                    if (z7) {
                    }
                    boolean z192 = !this.mCenter.isConnected();
                    boolean[] zArr22 = this.mIsInBarrier;
                    boolean z202 = zArr22[0];
                    boolean z212 = zArr22[1];
                    if (this.mHorizontalResolution == 2) {
                        solverVariable3 = solverVariableCreateObjectVariable;
                        z8 = z4;
                        solverVariable4 = solverVariable2;
                        dimensionBehaviour3 = dimensionBehaviour6;
                        z9 = z2;
                        dimensionBehaviour4 = dimensionBehaviour2;
                        z12 = z3;
                        solverVariable6 = solverVariableCreateObjectVariable3;
                        solverVariable5 = solverVariableCreateObjectVariable5;
                        z11 = z15;
                        z10 = z17;
                        i8 = i4;
                    }
                    if (z) {
                        solverVariable7 = solverVariable6;
                        solverVariable8 = solverVariable4;
                        solverVariable9 = solverVariable5;
                        i9 = 0;
                        c = 1;
                        i10 = 8;
                        i11 = 1;
                    }
                    if ((this.mVerticalResolution == 2 ? i9 : i11) == 0) {
                        constraintWidget3 = this;
                        solverVariable10 = solverVariable7;
                        solverVariable11 = solverVariable8;
                    }
                    if (!z8) {
                    }
                    if (constraintWidget3.mCenter.isConnected()) {
                    }
                    constraintWidget3.resolvedHorizontal = false;
                    constraintWidget3.resolvedVertical = false;
                }
                solverVariable = solverVariableCreateObjectVariable2;
                i13 = 3;
                if (dimensionBehaviour5 == dimensionBehaviour6 && i4 == i13) {
                    this.mResolvedDimensionRatioSide = 0;
                    int i32 = (int) (i18 * f);
                    if (dimensionBehaviour7 != dimensionBehaviour6) {
                        i4 = 4;
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        i2 = i21;
                        i5 = i24;
                        i6 = i32;
                    } else {
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        i2 = i21;
                        i5 = i24;
                        i6 = i32;
                        z4 = true;
                    }
                } else {
                    if (dimensionBehaviour7 == dimensionBehaviour6 && i24 == i13) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (i20 == -1) {
                            this.mResolvedDimensionRatio = 1.0f / f;
                        }
                        i2 = (int) (this.mResolvedDimensionRatio * i16);
                        if (dimensionBehaviour5 != dimensionBehaviour6) {
                            solverVariable2 = solverVariableCreateObjectVariable4;
                            i6 = i;
                            z4 = false;
                            i5 = 4;
                        } else {
                            solverVariable2 = solverVariableCreateObjectVariable4;
                        }
                    } else {
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        i2 = i21;
                    }
                    z4 = true;
                    i5 = i24;
                    i6 = i;
                }
                int[] iArr2 = this.mResolvedMatchConstraintDefault;
                iArr2[0] = i4;
                iArr2[1] = i5;
                this.mResolvedHasRatio = z4;
                if (!z4) {
                }
                if (z4) {
                }
                dimensionBehaviour = this.mListDimensionBehaviors[0];
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                }
                if (z7) {
                }
                boolean z1922 = !this.mCenter.isConnected();
                boolean[] zArr222 = this.mIsInBarrier;
                boolean z2022 = zArr222[0];
                boolean z2122 = zArr222[1];
                if (this.mHorizontalResolution == 2) {
                }
                if (z) {
                }
                if ((this.mVerticalResolution == 2 ? i9 : i11) == 0) {
                }
                if (!z8) {
                }
                if (constraintWidget3.mCenter.isConnected()) {
                }
                constraintWidget3.resolvedHorizontal = false;
                constraintWidget3.resolvedVertical = false;
            }
            z4 = false;
            int[] iArr22 = this.mResolvedMatchConstraintDefault;
            iArr22[0] = i4;
            iArr22[1] = i5;
            this.mResolvedHasRatio = z4;
            if (!z4) {
            }
            if (z4) {
            }
            dimensionBehaviour = this.mListDimensionBehaviors[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour2) {
            }
            if (z7) {
            }
            boolean z19222 = !this.mCenter.isConnected();
            boolean[] zArr2222 = this.mIsInBarrier;
            boolean z20222 = zArr2222[0];
            boolean z21222 = zArr2222[1];
            if (this.mHorizontalResolution == 2) {
            }
            if (z) {
            }
            if ((this.mVerticalResolution == 2 ? i9 : i11) == 0) {
            }
            if (!z8) {
            }
            if (constraintWidget3.mCenter.isConnected()) {
            }
            constraintWidget3.resolvedHorizontal = false;
            constraintWidget3.resolvedVertical = false;
        }
        i = i17;
        solverVariable = solverVariableCreateObjectVariable2;
        solverVariable2 = solverVariableCreateObjectVariable4;
        i2 = i21;
        i4 = i22;
        i5 = i23;
        i6 = i;
        z4 = false;
        int[] iArr222 = this.mResolvedMatchConstraintDefault;
        iArr222[0] = i4;
        iArr222[1] = i5;
        this.mResolvedHasRatio = z4;
        if (!z4) {
        }
        if (z4) {
        }
        dimensionBehaviour = this.mListDimensionBehaviors[0];
        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour2) {
        }
        if (z7) {
        }
        boolean z192222 = !this.mCenter.isConnected();
        boolean[] zArr22222 = this.mIsInBarrier;
        boolean z202222 = zArr22222[0];
        boolean z212222 = zArr22222[1];
        if (this.mHorizontalResolution == 2) {
        }
        if (z) {
        }
        if ((this.mVerticalResolution == 2 ? i9 : i11) == 0) {
        }
        if (!z8) {
        }
        if (constraintWidget3.mCenter.isConnected()) {
        }
        constraintWidget3.resolvedHorizontal = false;
        constraintWidget3.resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mParent = this.mParent == null ? null : map.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.f1236mX = constraintWidget.f1236mX;
        this.f1237mY = constraintWidget.f1237mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.mVerticalNextWidget;
        this.mVerticalNextWidget = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (C23051.f1238x6930e354[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = constraintAnchor != null ? constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getOptimizerWrapHeight() {
        int iMax = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                iMax = Math.max(this.mMatchConstraintMinHeight, iMax);
            } else {
                iMax = this.mMatchConstraintMinHeight;
                if (iMax > 0) {
                    this.mHeight = iMax;
                } else {
                    iMax = 0;
                }
            }
            int i = this.mMatchConstraintMaxHeight;
            if (i > 0 && i < iMax) {
                return i;
            }
        }
        return iMax;
    }

    public int getOptimizerWrapWidth() {
        int i = this.mWidth;
        int iMax = 0;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            iMax = Math.max(this.mMatchConstraintMinWidth, i);
        } else {
            int i2 = this.mMatchConstraintMinWidth;
            if (i2 > 0) {
                this.mWidth = i2;
                iMax = i2;
            }
        }
        int i4 = this.mMatchConstraintMaxWidth;
        return (i4 <= 0 || i4 >= iMax) ? iMax : i4;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.f1236mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.f1237mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = this.mLeft != null ? this.mTop.mMargin : 0;
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.f1236mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.f1236mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.f1237mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.f1237mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i) {
        if (i == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.mWidthOverride == -1 && this.mHeightOverride == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.hasFinalValue() && (constraintAnchor2 = this.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) {
                return (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.getMargin() + this.mLeft.mTarget.getFinalValue()) >= i2;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.hasFinalValue() && (constraintAnchor = this.mBottom.mTarget) != null && constraintAnchor.hasFinalValue()) {
                if ((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.getMargin() + this.mTop.mTarget.getFinalValue()) >= i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.horizontalSolvingPass;
    }

    public boolean isInBarrier(int i) {
        return this.mIsInBarrier[i];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        if (this.resolvedHorizontal) {
            return true;
        }
        return this.mLeft.hasFinalValue() && this.mRight.hasFinalValue();
    }

    public boolean isResolvedVertically() {
        if (this.resolvedVertical) {
            return true;
        }
        return this.mTop.hasFinalValue() && this.mBottom.hasFinalValue();
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.verticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.horizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.verticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        char c = i == 0 ? (char) 1 : (char) 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f1236mX = 0;
        this.f1237mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        sb.append("{\n");
        serializeAnchor(sb, "left", this.mLeft);
        serializeAnchor(sb, "top", this.mTop);
        serializeAnchor(sb, "right", this.mRight);
        serializeAnchor(sb, "bottom", this.mBottom);
        serializeAnchor(sb, "baseline", this.mBaseline);
        serializeAnchor(sb, "centerX", this.mCenterX);
        serializeAnchor(sb, "centerY", this.mCenterY);
        serializeCircle(sb, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(sb, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(sb, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        sb.append("}\n");
        return sb;
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariableCreateObjectVariable.setName(str + ".left");
        solverVariableCreateObjectVariable2.setName(str + ".top");
        solverVariableCreateObjectVariable3.setName(str + ".right");
        solverVariableCreateObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i4 = this.mMinWidth;
        if (i < i4) {
            this.mWidth = i4;
        }
        this.mHeight = i2;
        int i5 = this.mMinHeight;
        if (i2 < i5) {
            this.mHeight = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDimensionRatio(String str) {
        float fAbs;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i2 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            i2 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            i = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
            String strSubstring2 = str.substring(i);
            fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : i;
        } else {
            String strSubstring3 = str.substring(i, iIndexOf2);
            String strSubstring4 = str.substring(iIndexOf2 + 1);
            if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                float f = Float.parseFloat(strSubstring3);
                float f4 = Float.parseFloat(strSubstring4);
                if (f > 0.0f && f4 > 0.0f) {
                    fAbs = i2 == 1 ? Math.abs(f4 / f) : Math.abs(f / f4);
                }
            }
        }
        i = (fAbs > i ? 1 : (fAbs == i ? 0 : -1));
        if (i > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i2;
        }
    }

    public void setFinalBaseline(int i) {
        if (this.hasBaseline) {
            int i2 = i - this.mBaselineDistance;
            int i4 = this.mHeight + i2;
            this.f1237mY = i2;
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i4);
            this.mBaseline.setFinalValue(i);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i, int i2, int i4, int i5, int i6, int i7) {
        setFrame(i, i2, i4, i5);
        setBaselineDistance(i6);
        if (i7 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i7 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i7 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i, int i2) {
        if (this.resolvedHorizontal) {
            return;
        }
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.f1236mX = i;
        this.mWidth = i2 - i;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.f1236mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.f1237mY = i;
    }

    public void setFinalVertical(int i, int i2) {
        if (this.resolvedVertical) {
            return;
        }
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.f1237mY = i;
        this.mHeight = i2 - i;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int i, int i2, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i;
        int i9 = i5 - i2;
        this.f1236mX = i;
        this.f1237mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i8 < (i7 = this.mWidth)) {
            i8 = i7;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i9 < (i6 = this.mHeight)) {
            i9 = i6;
        }
        this.mWidth = i8;
        this.mHeight = i9;
        int i10 = this.mMinHeight;
        if (i9 < i10) {
            this.mHeight = i10;
        }
        int i11 = this.mMinWidth;
        if (i8 < i11) {
            this.mWidth = i11;
        }
        int i12 = this.mMatchConstraintMaxWidth;
        if (i12 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i12);
        }
        int i13 = this.mMatchConstraintMaxHeight;
        if (i13 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i13);
        }
        int i14 = this.mWidth;
        if (i8 != i14) {
            this.mWidthOverride = i14;
        }
        int i15 = this.mHeight;
        if (i9 != i15) {
            this.mHeightOverride = i15;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = C23051.f1238x6930e354[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
            return;
        }
        if (i2 == 2) {
            this.mTop.mGoneMargin = i;
            return;
        }
        if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        } else {
            if (i2 != 5) {
                return;
            }
            this.mBaseline.mGoneMargin = i;
        }
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.f1236mX = i;
        int i4 = i2 - i;
        this.mWidth = i4;
        int i5 = this.mMinWidth;
        if (i4 < i5) {
            this.mWidth = i5;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i4, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.mMatchConstraintMaxWidth = i4;
        this.mMatchConstraintPercentWidth = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtualLayout = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.mLastHorizontalMeasureSpec = i;
        this.mLastVerticalMeasureSpec = i2;
        setMeasureRequested(false);
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.f1236mX = i;
        this.f1237mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.f1237mY = i;
        int i4 = i2 - i;
        this.mHeight = i4;
        int i5 = this.mMinHeight;
        if (i4 < i5) {
            this.mHeight = i5;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i4, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.mMatchConstraintMaxHeight = i4;
        this.mMatchConstraintPercentHeight = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapBehaviorInParent(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mWrapBehaviorInParent = i;
    }

    public void setX(int i) {
        this.f1236mX = i;
    }

    public void setY(int i) {
        this.f1237mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                if (i != 0 || this.mMatchConstraintMinHeight <= 0) {
                    return;
                }
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String strM1170p;
        StringBuilder sb = new StringBuilder();
        String strM1170p2 = "";
        if (this.mType != null) {
            strM1170p = AbstractC0622a.m1170p(this.mType, " ", new StringBuilder("type: "));
        } else {
            strM1170p = "";
        }
        sb.append(strM1170p);
        if (this.mDebugName != null) {
            strM1170p2 = AbstractC0622a.m1170p(this.mDebugName, " ", new StringBuilder("id: "));
        }
        sb.append(strM1170p2);
        sb.append("(");
        sb.append(this.f1236mX);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.f1237mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return AbstractC2821a.m2223n(sb, ")", this.mHeight);
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean zIsResolved = z & this.horizontalRun.isResolved();
        boolean zIsResolved2 = z2 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i4 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i5 = verticalWidgetRun.start.value;
        int i6 = horizontalWidgetRun.end.value;
        int i7 = verticalWidgetRun.end.value;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (zIsResolved) {
            this.f1236mX = i4;
        }
        if (zIsResolved2) {
            this.f1237mY = i5;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (zIsResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i9 < (i2 = this.mWidth)) {
                i9 = i2;
            }
            this.mWidth = i9;
            int i11 = this.mMinWidth;
            if (i9 < i11) {
                this.mWidth = i11;
            }
        }
        if (zIsResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i10 < (i = this.mHeight)) {
                i10 = i;
            }
            this.mHeight = i10;
            int i12 = this.mMinHeight;
            if (i10 < i12) {
                this.mHeight = i12;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor anchor = getAnchor(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor anchor2 = getAnchor(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor anchor3 = getAnchor(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor anchor4 = getAnchor(type9);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(type6, constraintWidget, type6, 0);
                    connect(type7, constraintWidget, type7, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(type8, constraintWidget, type8, 0);
                    connect(type9, constraintWidget, type9, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                    return;
                }
                if (z) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                    return;
                } else {
                    if (z2) {
                        ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                        getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type13, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            connect(type12, constraintWidget, type2, 0);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor13 = getAnchor(type5);
                    if (anchor13.getTarget() != anchor10) {
                        anchor13.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor14 = getAnchor(type14);
                    if (anchor14.isConnected()) {
                        opposite.reset();
                        anchor14.reset();
                    }
                }
            } else {
                ConstraintAnchor anchor15 = getAnchor(type20);
                if (anchor15 != null) {
                    anchor15.reset();
                }
                ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type15);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i);
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public void setFrame(int i, int i2, int i4) {
        if (i4 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i4 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f1236mX = 0;
        this.f1237mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2, int i4, int i5) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.f1236mX = i;
        this.f1237mY = i2;
        this.mWidth = i4;
        this.mHeight = i5;
        addAnchors();
    }

    public ConstraintWidget(String str, int i, int i2, int i4, int i5) {
        this(i, i2, i4, i5);
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }
}
