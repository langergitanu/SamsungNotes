package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i4;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i4 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i4 = 2;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i4, chainHead);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[PHI: r15 r16
      0x0033: PHI (r15v26 boolean) = (r15v1 boolean), (r15v28 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v5 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[PHI: r15 r16
      0x0035: PHI (r15v3 boolean) = (r15v1 boolean), (r15v28 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0495 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x038b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016a  */
    /* JADX WARN: Type inference failed for: r0v27, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.constraintlayout.core.SolverVariable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        float f;
        ?? r02;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget;
        int i4;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        ConstraintWidget constraintWidget2;
        int i5;
        SolverVariable solverVariable4;
        float f4;
        int size;
        float f5;
        ArrayList<ConstraintWidget> arrayList;
        boolean z4;
        boolean z5;
        int i6;
        int i7 = i;
        ConstraintWidget constraintWidget3 = chainHead.mFirst;
        ConstraintWidget constraintWidget4 = chainHead.mLast;
        ConstraintWidget constraintWidget5 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget6 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget7 = chainHead.mHead;
        float f6 = chainHead.mTotalWeight;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i7 == 0) {
            int i8 = constraintWidget7.mHorizontalChainStyle;
            z = i8 == 0;
            z2 = i8 == 1;
            z3 = i8 == 2;
        } else {
            int i9 = constraintWidget7.mVerticalChainStyle;
            z = i9 == 0;
            z2 = i9 == 1;
            if (i9 == 2) {
            }
        }
        ?? r14 = constraintWidget3;
        boolean z7 = false;
        while (true) {
            f = f6;
            if (z7) {
                break;
            }
            ConstraintAnchor constraintAnchor3 = r14.mListAnchors[i2];
            int i10 = z3 ? 1 : 4;
            int margin = constraintAnchor3.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r14.mListDimensionBehaviors[i7];
            boolean z8 = z6;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z9 = dimensionBehaviour == dimensionBehaviour2 && r14.mResolvedMatchConstraintDefault[i7] == 0;
            boolean z10 = z3;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && r14 != constraintWidget3) {
                margin = constraintAnchor4.getMargin() + margin;
            }
            int i11 = margin;
            if (z10 && r14 != constraintWidget3 && r14 != constraintWidget5) {
                i10 = 8;
            }
            boolean z11 = z9;
            ConstraintAnchor constraintAnchor5 = constraintAnchor3.mTarget;
            if (constraintAnchor5 != null) {
                if (r14 == constraintWidget5) {
                    z4 = z7;
                    z5 = z;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i11, 6);
                } else {
                    z4 = z7;
                    z5 = z;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i11, 8);
                }
                if (z11 && !z10) {
                    i10 = 5;
                }
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i11, (r14 == constraintWidget5 && z10 && r14.isInBarrier(i7)) ? 5 : i10);
            } else {
                z4 = z7;
                z5 = z;
            }
            if (z8) {
                if (r14.getVisibility() == 8 || r14.mListDimensionBehaviors[i7] != dimensionBehaviour2) {
                    i6 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r14.mListAnchors;
                    i6 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r14.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i6, 8);
            }
            ConstraintAnchor constraintAnchor6 = r14.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor6 != null) {
                ConstraintWidget constraintWidget8 = constraintAnchor6.mOwner;
                ConstraintAnchor constraintAnchor7 = constraintWidget8.mListAnchors[i2].mTarget;
                if (constraintAnchor7 != null && constraintAnchor7.mOwner == r14) {
                    obj = constraintWidget8;
                }
            }
            if (obj != null) {
                r14 = obj;
                z7 = z4;
            } else {
                z7 = true;
            }
            f6 = f;
            z6 = z8;
            z3 = z10;
            z = z5;
            r14 = r14;
        }
        boolean z12 = z6;
        boolean z13 = z3;
        boolean z14 = z;
        if (constraintWidget6 != null) {
            int i12 = i2 + 1;
            if (constraintWidget4.mListAnchors[i12].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget6.mListAnchors[i12];
                if (constraintWidget6.mListDimensionBehaviors[i7] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget6.mResolvedMatchConstraintDefault[i7] == 0 && !z13) {
                    ConstraintAnchor constraintAnchor9 = constraintAnchor8.mTarget;
                    if (constraintAnchor9.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor9.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                    }
                    linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget4.mListAnchors[i12].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                } else {
                    if (z13) {
                        ConstraintAnchor constraintAnchor10 = constraintAnchor8.mTarget;
                        if (constraintAnchor10.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor10.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                        }
                    }
                    linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget4.mListAnchors[i12].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                }
            }
        }
        if (z12) {
            int i13 = i2 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i13].mSolverVariable;
            ConstraintAnchor constraintAnchor11 = constraintWidget4.mListAnchors[i13];
            linearSystem.addGreaterThan(solverVariable5, constraintAnchor11.mSolverVariable, constraintAnchor11.getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f7 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f : chainHead.mWidgetsMatchCount;
            float f8 = 0.0f;
            float f9 = 0.0f;
            ConstraintWidget constraintWidget9 = null;
            int i14 = 0;
            while (i14 < size) {
                ConstraintWidget constraintWidget10 = arrayList2.get(i14);
                float f10 = constraintWidget10.mWeight[i7];
                if (f10 >= f8) {
                    f5 = f8;
                } else if (chainHead.mHasComplexMatchWeights) {
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget10.mListAnchors;
                    f5 = f8;
                    linearSystem.addEquality(constraintAnchorArr2[i2 + 1].mSolverVariable, constraintAnchorArr2[i2].mSolverVariable, 0, 4);
                    arrayList = arrayList2;
                    i14++;
                    f8 = f5;
                    arrayList2 = arrayList;
                } else {
                    f5 = f8;
                    f10 = 1.0f;
                }
                float f11 = f10;
                if (f11 == f5) {
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget10.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr3[i2 + 1].mSolverVariable, constraintAnchorArr3[i2].mSolverVariable, 0, 8);
                    arrayList = arrayList2;
                    i14++;
                    f8 = f5;
                    arrayList2 = arrayList;
                } else {
                    if (constraintWidget9 != null) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget9.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr4[i2].mSolverVariable;
                        int i15 = i2 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr4[i15].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget10.mListAnchors;
                        arrayList = arrayList2;
                        SolverVariable solverVariable8 = constraintAnchorArr5[i2].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr5[i15].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f9, f7, f11, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    } else {
                        arrayList = arrayList2;
                    }
                    constraintWidget9 = constraintWidget10;
                    f9 = f11;
                    i14++;
                    f8 = f5;
                    arrayList2 = arrayList;
                }
            }
        }
        if (constraintWidget5 != null && (constraintWidget5 == constraintWidget6 || z13)) {
            ConstraintAnchor constraintAnchor12 = constraintWidget3.mListAnchors[i2];
            int i16 = i2 + 1;
            ConstraintAnchor constraintAnchor13 = constraintWidget4.mListAnchors[i16];
            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
            SolverVariable solverVariable10 = constraintAnchor14 != null ? constraintAnchor14.mSolverVariable : null;
            ConstraintAnchor constraintAnchor15 = constraintAnchor13.mTarget;
            SolverVariable solverVariable11 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
            ConstraintAnchor constraintAnchor16 = constraintWidget5.mListAnchors[i2];
            if (constraintWidget6 != null) {
                constraintAnchor13 = constraintWidget6.mListAnchors[i16];
            }
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i7 == 0) {
                    f4 = constraintWidget7.mHorizontalBiasPercent;
                } else {
                    f4 = constraintWidget7.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable10, constraintAnchor16.getMargin(), f4, solverVariable11, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 7);
            }
        } else {
            if (!z14 || constraintWidget5 == null) {
                if (z2 && constraintWidget5 != null) {
                    int i17 = chainHead.mWidgetsMatchCount;
                    boolean z15 = i17 > 0 && chainHead.mWidgetsCount == i17;
                    ConstraintWidget constraintWidget11 = constraintWidget5;
                    ConstraintWidget constraintWidget12 = constraintWidget11;
                    while (constraintWidget11 != null) {
                        ConstraintWidget constraintWidget13 = constraintWidget11.mNextChainWidget[i];
                        while (constraintWidget13 != null && constraintWidget13.getVisibility() == 8) {
                            constraintWidget13 = constraintWidget13.mNextChainWidget[i];
                        }
                        if (constraintWidget11 != constraintWidget5 && constraintWidget11 != constraintWidget6 && constraintWidget13 != null) {
                            if (constraintWidget13 == constraintWidget6) {
                                constraintWidget13 = null;
                            }
                            ConstraintAnchor constraintAnchor17 = constraintWidget11.mListAnchors[i2];
                            SolverVariable solverVariable12 = constraintAnchor17.mSolverVariable;
                            ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                            if (constraintAnchor18 != null) {
                                SolverVariable solverVariable13 = constraintAnchor18.mSolverVariable;
                            }
                            int i18 = i2 + 1;
                            SolverVariable solverVariable14 = constraintWidget12.mListAnchors[i18].mSolverVariable;
                            int margin2 = constraintAnchor17.getMargin();
                            int margin3 = constraintWidget11.mListAnchors[i18].getMargin();
                            if (constraintWidget13 != null) {
                                constraintAnchor = constraintWidget13.mListAnchors[i2];
                                solverVariable = constraintAnchor.mSolverVariable;
                                ConstraintAnchor constraintAnchor19 = constraintAnchor.mTarget;
                                solverVariable2 = constraintAnchor19 != null ? constraintAnchor19.mSolverVariable : null;
                            } else {
                                constraintAnchor = constraintWidget6.mListAnchors[i2];
                                solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                                solverVariable2 = constraintWidget11.mListAnchors[i18].mSolverVariable;
                            }
                            if (constraintAnchor != null) {
                                margin3 += constraintAnchor.getMargin();
                            }
                            int margin4 = constraintWidget12.mListAnchors[i18].getMargin() + margin2;
                            SolverVariable solverVariable15 = solverVariable2;
                            int i19 = z15 ? 8 : 4;
                            if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable15 == null) {
                                constraintWidget = constraintWidget13;
                            } else {
                                constraintWidget = constraintWidget13;
                                linearSystem.addCentering(solverVariable12, solverVariable14, margin4, 0.5f, solverVariable, solverVariable15, margin3, i19);
                            }
                            constraintWidget13 = constraintWidget;
                        }
                        if (constraintWidget11.getVisibility() != 8) {
                            constraintWidget12 = constraintWidget11;
                        }
                        constraintWidget11 = constraintWidget13;
                    }
                    ConstraintAnchor constraintAnchor20 = constraintWidget5.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor21 = constraintWidget3.mListAnchors[i2].mTarget;
                    int i20 = i2 + 1;
                    ConstraintAnchor constraintAnchor22 = constraintWidget6.mListAnchors[i20];
                    ConstraintAnchor constraintAnchor23 = constraintWidget4.mListAnchors[i20].mTarget;
                    if (constraintAnchor21 == null) {
                        r02 = linearSystem;
                        if (constraintAnchor23 != null && constraintWidget5 != constraintWidget6) {
                            r02.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, -constraintAnchor22.getMargin(), 5);
                        }
                    } else {
                        if (constraintWidget5 != constraintWidget6) {
                            linearSystem.addEquality(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 5);
                        } else {
                            if (constraintAnchor23 != null) {
                                LinearSystem linearSystem2 = linearSystem;
                                linearSystem2.addCentering(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 0.5f, constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, constraintAnchor22.getMargin(), 5);
                                r02 = linearSystem2;
                            }
                            if (constraintAnchor23 != null) {
                                r02.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, -constraintAnchor22.getMargin(), 5);
                            }
                        }
                        r02 = linearSystem;
                        if (constraintAnchor23 != null) {
                        }
                    }
                }
                if ((z14 && !z2) || constraintWidget5 == null || constraintWidget5 == constraintWidget6) {
                    return;
                }
                ConstraintAnchor[] constraintAnchorArr6 = constraintWidget5.mListAnchors;
                ConstraintAnchor constraintAnchor24 = constraintAnchorArr6[i2];
                if (constraintWidget6 == null) {
                    constraintWidget6 = constraintWidget5;
                }
                int i21 = i2 + 1;
                ConstraintAnchor constraintAnchor25 = constraintWidget6.mListAnchors[i21];
                ConstraintAnchor constraintAnchor26 = constraintAnchor24.mTarget;
                solverVariable4 = constraintAnchor26 == null ? constraintAnchor26.mSolverVariable : null;
                ConstraintAnchor constraintAnchor27 = constraintAnchor25.mTarget;
                Object obj = constraintAnchor27 == null ? constraintAnchor27.mSolverVariable : null;
                if (constraintWidget4 != constraintWidget6) {
                    ConstraintAnchor constraintAnchor28 = constraintWidget4.mListAnchors[i21].mTarget;
                    obj = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
                }
                if (constraintWidget5 == constraintWidget6) {
                    constraintAnchor25 = constraintAnchorArr6[i21];
                }
                if (solverVariable4 != null || obj == null) {
                }
                r02.addCentering(constraintAnchor24.mSolverVariable, solverVariable4, constraintAnchor24.getMargin(), 0.5f, obj, constraintAnchor25.mSolverVariable, constraintWidget6.mListAnchors[i21].getMargin(), 5);
                return;
            }
            int i22 = chainHead.mWidgetsMatchCount;
            boolean z16 = i22 > 0 && chainHead.mWidgetsCount == i22;
            ConstraintWidget constraintWidget14 = constraintWidget5;
            ConstraintWidget constraintWidget15 = constraintWidget14;
            while (constraintWidget14 != null) {
                ConstraintWidget constraintWidget16 = constraintWidget14.mNextChainWidget[i7];
                while (true) {
                    if (constraintWidget16 == null) {
                        i4 = 8;
                        break;
                    }
                    i4 = 8;
                    if (constraintWidget16.getVisibility() != 8) {
                        break;
                    } else {
                        constraintWidget16 = constraintWidget16.mNextChainWidget[i7];
                    }
                }
                if (constraintWidget16 != null || constraintWidget14 == constraintWidget6) {
                    ConstraintAnchor constraintAnchor29 = constraintWidget14.mListAnchors[i2];
                    SolverVariable solverVariable16 = constraintAnchor29.mSolverVariable;
                    ConstraintAnchor constraintAnchor30 = constraintAnchor29.mTarget;
                    SolverVariable solverVariable17 = constraintAnchor30 != null ? constraintAnchor30.mSolverVariable : null;
                    if (constraintWidget15 != constraintWidget14) {
                        solverVariable17 = constraintWidget15.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget14 == constraintWidget5) {
                        ConstraintAnchor constraintAnchor31 = constraintWidget3.mListAnchors[i2].mTarget;
                        solverVariable17 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor29.getMargin();
                    int i23 = i2 + 1;
                    int margin6 = constraintWidget14.mListAnchors[i23].getMargin();
                    if (constraintWidget16 != null) {
                        constraintAnchor2 = constraintWidget16.mListAnchors[i2];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget4.mListAnchors[i23].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                    }
                    SolverVariable solverVariable18 = constraintWidget14.mListAnchors[i23].mSolverVariable;
                    if (constraintAnchor2 != null) {
                        margin6 += constraintAnchor2.getMargin();
                    }
                    int margin7 = constraintWidget15.mListAnchors[i23].getMargin() + margin5;
                    if (solverVariable16 == null || solverVariable17 == null || solverVariable3 == null || solverVariable18 == null) {
                        constraintWidget2 = constraintWidget16;
                        i5 = 8;
                    } else {
                        if (constraintWidget14 == constraintWidget5) {
                            margin7 = constraintWidget5.mListAnchors[i2].getMargin();
                        }
                        if (constraintWidget14 == constraintWidget6) {
                            margin6 = constraintWidget6.mListAnchors[i23].getMargin();
                        }
                        constraintWidget2 = constraintWidget16;
                        i5 = 8;
                        linearSystem.addCentering(solverVariable16, solverVariable17, margin7, 0.5f, solverVariable3, solverVariable18, margin6, z16 ? 8 : 5);
                        if (constraintWidget14.getVisibility() == i5) {
                            constraintWidget15 = constraintWidget14;
                        }
                        i7 = i;
                        constraintWidget14 = constraintWidget2;
                    }
                } else {
                    constraintWidget2 = constraintWidget16;
                    i5 = i4;
                }
                if (constraintWidget14.getVisibility() == i5) {
                }
                i7 = i;
                constraintWidget14 = constraintWidget2;
            }
        }
        r02 = linearSystem;
        if (z14) {
        }
        ConstraintAnchor[] constraintAnchorArr62 = constraintWidget5.mListAnchors;
        ConstraintAnchor constraintAnchor242 = constraintAnchorArr62[i2];
        if (constraintWidget6 == null) {
        }
        int i212 = i2 + 1;
        ConstraintAnchor constraintAnchor252 = constraintWidget6.mListAnchors[i212];
        ConstraintAnchor constraintAnchor262 = constraintAnchor242.mTarget;
        if (constraintAnchor262 == null) {
        }
        ConstraintAnchor constraintAnchor272 = constraintAnchor252.mTarget;
        if (constraintAnchor272 == null) {
        }
        if (constraintWidget4 != constraintWidget6) {
        }
        if (constraintWidget5 == constraintWidget6) {
        }
        if (solverVariable4 != null) {
        }
    }
}
