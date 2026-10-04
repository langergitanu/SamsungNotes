package androidx.constraintlayout.core.motion;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class Motion {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    MotionWidget mView;
    Rect mTempRect = new Rect();
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f4 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.mStaggerScale;
            if (f5 != 1.0d) {
                float f6 = this.mStaggerOffset;
                if (f < f6) {
                    f = 0.0f;
                }
                if (f > f6 && f < 1.0d) {
                    f = Math.min((f - f6) * f5, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f7 = Float.NaN;
        for (MotionPaths motionPaths : this.mMotionPaths) {
            Easing easing2 = motionPaths.mKeyFrameEasing;
            if (easing2 != null) {
                float f8 = motionPaths.time;
                if (f8 < f) {
                    easing = easing2;
                    f4 = f8;
                } else if (Float.isNaN(f7)) {
                    f7 = motionPaths.time;
                }
            }
        }
        if (easing != null) {
            float f9 = (Float.isNaN(f7) ? 1.0f : f7) - f4;
            double d = (f - f4) / f9;
            f = (((float) easing.get(d)) * f9) + f4;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f;
    }

    private static DifferentialInterpolator getInterpolator(int i, String str, int i2) {
        if (i != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1

            /* JADX INFO: renamed from: mX */
            float f1213mX;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f) {
                this.f1213mX = f;
                return (float) interpolator.get(f);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) interpolator.getDiff(this.f1213mX);
            }
        };
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        float fHypot = 0.0f;
        while (i < 100) {
            float f4 = i * f;
            double d3 = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f5 = Float.NaN;
            float f6 = 0.0f;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = motionPaths.mKeyFrameEasing;
                float f7 = f;
                if (easing2 != null) {
                    float f8 = motionPaths.time;
                    if (f8 < f4) {
                        f6 = f8;
                        easing = easing2;
                    } else if (Float.isNaN(f5)) {
                        f5 = motionPaths.time;
                    }
                }
                f = f7;
            }
            float f9 = f;
            if (easing != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                d3 = (((float) easing.get((f4 - f6) / r16)) * (f5 - f6)) + f6;
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            int i2 = i;
            float f10 = fHypot;
            this.mStartMotionPath.getCenter(d3, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            fHypot = i2 > 0 ? (float) (Math.hypot(d2 - ((double) fArr[1]), d - ((double) fArr[0])) + ((double) f10)) : f10;
            d = fArr[0];
            d2 = fArr[1];
            i = i2 + 1;
            f = f9;
        }
        return fHypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        MotionPaths motionPaths2 = null;
        for (MotionPaths motionPaths3 : this.mMotionPaths) {
            if (motionPaths.position == motionPaths3.position) {
                motionPaths2 = motionPaths3;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i2 = 0; i2 < i; i2++) {
            float fMin = i2 * f;
            float f4 = this.mStaggerScale;
            float f5 = 0.0f;
            if (f4 != 1.0f) {
                float f6 = this.mStaggerOffset;
                if (fMin < f6) {
                    fMin = 0.0f;
                }
                if (fMin > f6 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f6) * f4, 1.0f);
                }
            }
            double d = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f7 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = motionPaths.mKeyFrameEasing;
                if (easing2 != null) {
                    float f8 = motionPaths.time;
                    if (f8 < fMin) {
                        easing = easing2;
                        f5 = f8;
                    } else if (Float.isNaN(f7)) {
                        f7 = motionPaths.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d = (((float) easing.get((fMin - f5) / r12)) * (f7 - f5)) + f5;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 2);
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
        }
        int i2 = 0;
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
        }
        if (iArr2 != null) {
            Iterator<MotionPaths> it2 = this.mMotionPaths.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr2[i2] = (int) (it2.next().position * 100.0f);
                i2++;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < timePoints.length; i5++) {
            this.mSpline[0].getPos(timePoints[i5], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i5], this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
            i4 += 2;
        }
        return i4 / 2;
    }

    public void buildPath(float[] fArr, int i) {
        int i2 = i;
        float f = 1.0f;
        float f4 = 1.0f / (i2 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map4 != null ? map4.get("translationY") : null;
        int i4 = 0;
        while (i4 < i2) {
            float fMin = i4 * f4;
            float f5 = this.mStaggerScale;
            float f6 = 0.0f;
            if (f5 != f) {
                float f7 = this.mStaggerOffset;
                if (fMin < f7) {
                    fMin = 0.0f;
                }
                if (fMin > f7 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f7) * f5, f);
                }
            }
            double d = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f8 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = motionPaths.mKeyFrameEasing;
                if (easing2 != null) {
                    float f9 = motionPaths.time;
                    if (f9 < fMin) {
                        f6 = f9;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = motionPaths.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d = (((float) easing.get((fMin - f6) / r16)) * (f8 - f6)) + f6;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i5 = i4 * 2;
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
            if (keyCycleOscillator != null) {
                fArr[i5] = keyCycleOscillator.get(fMin) + fArr[i5];
            } else if (splineSet != null) {
                fArr[i5] = splineSet.get(fMin) + fArr[i5];
            }
            if (keyCycleOscillator2 != null) {
                int i6 = i5 + 1;
                fArr[i6] = keyCycleOscillator2.get(fMin) + fArr[i6];
            } else if (splineSet2 != null) {
                int i7 = i5 + 1;
                fArr[i7] = splineSet2.get(fMin) + fArr[i7];
            }
            i4++;
            i2 = i;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    public void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].getPos(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = splineSet.get(i2 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d, dArr);
        this.mSpline[0].getSlope(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f, float f4, float f5, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f6 = motionPaths.f1216x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f7 = f6 - motionPaths2.f1216x;
            float f8 = motionPaths.f1217y - motionPaths2.f1217y;
            float f9 = motionPaths.width - motionPaths2.width;
            float f10 = (motionPaths.height - motionPaths2.height) + f8;
            fArr[0] = ((f9 + f7) * f4) + ((1.0f - f4) * f7);
            fArr[1] = (f10 * f5) + ((1.0f - f5) * f8);
            return;
        }
        double d = adjustedPosition;
        curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d, this.mInterpolateData);
        float f11 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * ((double) f11);
            i++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f4, f5, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d, dArr2);
            this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f4, f5, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.f1216x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f1217y;
    }

    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        int i2 = 0;
        int i4 = 0;
        for (MotionKey motionKey : this.mKeyList) {
            int i5 = motionKey.mType;
            if (i5 == i || i != -1) {
                iArr[i4] = 0;
                iArr[i4 + 1] = i5;
                int i6 = motionKey.mFramePosition;
                iArr[i4 + 2] = i6;
                double d = i6 / 100.0f;
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i4 + 3] = Float.floatToIntBits(fArr[0]);
                int i7 = i4 + 4;
                iArr[i7] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i4 + 5] = motionKeyPosition.mPositionType;
                    iArr[i4 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i7 = i4 + 7;
                    iArr[i7] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i8 = i7 + 1;
                iArr[i4] = i8 - i4;
                i2++;
                i4 = i8;
            }
        }
        return i2;
    }

    public float getKeyFrameParameter(int i, float f, float f4) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f5 = motionPaths.f1216x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f6 = motionPaths2.f1216x;
        float f7 = f5 - f6;
        float f8 = motionPaths.f1217y;
        float f9 = motionPaths2.f1217y;
        float f10 = f8 - f9;
        float f11 = (motionPaths2.width / 2.0f) + f6;
        float f12 = (motionPaths2.height / 2.0f) + f9;
        float fHypot = (float) Math.hypot(f7, f10);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f13 = f - f11;
        float f14 = f4 - f12;
        if (((float) Math.hypot(f13, f14)) == 0.0f) {
            return 0.0f;
        }
        float f15 = (f14 * f10) + (f13 * f7);
        if (i == 0) {
            return f15 / fHypot;
        }
        if (i == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f15 * f15));
        }
        if (i == 2) {
            return f13 / f7;
        }
        if (i == 3) {
            return f14 / f7;
        }
        if (i == 4) {
            return f13 / f10;
        }
        if (i != 5) {
            return 0.0f;
        }
        return f14 / f10;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        int i = 0;
        int i2 = 0;
        for (MotionKey motionKey : this.mKeyList) {
            int i4 = motionKey.mFramePosition;
            iArr[i] = (motionKey.mType * 1000) + i4;
            double d = i4 / 100.0f;
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public double[] getPos(double d) {
        this.mSpline[0].getPos(d, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public MotionKeyPosition getPositionKeyframe(int i, int i2, float f, float f4) {
        int i4;
        int i5;
        float f5;
        float f6;
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f7 = motionPaths.f1216x;
        floatRect.left = f7;
        float f8 = motionPaths.f1217y;
        floatRect.top = f8;
        floatRect.right = f7 + motionPaths.width;
        floatRect.bottom = f8 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f9 = motionPaths2.f1216x;
        floatRect2.left = f9;
        float f10 = motionPaths2.f1217y;
        floatRect2.top = f10;
        floatRect2.right = f9 + motionPaths2.width;
        floatRect2.bottom = f10 + motionPaths2.height;
        for (MotionKey motionKey : this.mKeyList) {
            if (motionKey instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                i4 = i;
                i5 = i2;
                f5 = f;
                f6 = f4;
                if (motionKeyPosition.intersects(i4, i5, floatRect, floatRect2, f5, f6)) {
                    return motionKeyPosition;
                }
            } else {
                i4 = i;
                i5 = i2;
                f5 = f;
                f6 = f4;
            }
            i = i4;
            i2 = i5;
            f = f5;
            f4 = f6;
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i, int i2, float f4, float f5, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, SplineSet> map3 = this.mAttributesMap;
        SplineSet splineSet3 = map3 == null ? null : map3.get("rotationZ");
        HashMap<String, SplineSet> map4 = this.mAttributesMap;
        SplineSet splineSet4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, SplineSet> map5 = this.mAttributesMap;
        SplineSet splineSet5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, KeyCycleOscillator> map6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, KeyCycleOscillator> map7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, KeyCycleOscillator> map8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = map8 == null ? null : map8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> map9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, KeyCycleOscillator> map10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f4, f5, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f4, f5, i, i2, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f6 = motionPaths.f1216x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f7 = f6 - motionPaths2.f1216x;
            float f8 = motionPaths.f1217y - motionPaths2.f1217y;
            float f9 = motionPaths.width - motionPaths2.width;
            float f10 = f8 + (motionPaths.height - motionPaths2.height);
            fArr[0] = ((f9 + f7) * f4) + ((1.0f - f4) * f7);
            fArr[1] = (f10 * f5) + ((1.0f - f5) * f8);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f4, f5, i, i2, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f11 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i4 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f4, f5, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f4, f5, i, i2, fArr);
                return;
            } else {
                dArr2[i4] = dArr2[i4] * ((double) f11);
                i4++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.f1216x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f1217y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f, null);
        int i = this.mQuantizeMotionSteps;
        if (i != -1) {
            float f4 = 1.0f / i;
            float fFloor = ((float) Math.floor(adjustedPosition / f4)) * f4;
            float f5 = (adjustedPosition % f4) / f4;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f5 = (f5 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f5) : ((double) f5) > 0.5d ? 1.0f : 0.0f) * f4) + fFloor;
        }
        float f6 = adjustedPosition;
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            Iterator<SplineSet> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(motionWidget2, f6);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d = f6;
            curveFitArr[0].getPos(d, this.mInterpolateData);
            this.mSpline[0].getSlope(d, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                this.mStartMotionPath.setView(f6, motionWidget2, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                f6 = f6;
                motionWidget2 = motionWidget2;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget2.getParent().findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (motionWidget2.getRight() - motionWidget2.getLeft() > 0 && motionWidget2.getBottom() - motionWidget2.getTop() > 0) {
                        motionWidget2.setPivotX(right - motionWidget2.getLeft());
                        motionWidget2.setPivotY(bottom - motionWidget2.getTop());
                    }
                }
            }
            int i2 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i2 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i2].getPos(d, this.mValuesBuff);
                this.mStartMotionPath.customAttributes.get(this.mAttributeNames[i2 - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
                i2++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f6 <= 0.0f) {
                    motionWidget2.setVisibility(motionConstrainedPoint.visibility);
                } else if (f6 >= 1.0f) {
                    motionWidget2.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i4 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i4 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i4].conditionallyFire(f6, motionWidget2);
                    i4++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f7 = motionPaths.f1216x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fM29z = AbstractC0000a.m29z(motionPaths2.f1216x, f7, f6, f7);
            float f8 = motionPaths.f1217y;
            float fM29z2 = AbstractC0000a.m29z(motionPaths2.f1217y, f8, f6, f8);
            float f9 = motionPaths.width;
            float fM29z3 = AbstractC0000a.m29z(motionPaths2.width, f9, f6, f9);
            float f10 = motionPaths.height;
            float f11 = fM29z + 0.5f;
            float f12 = fM29z2 + 0.5f;
            motionWidget2.layout((int) f11, (int) f12, (int) (f11 + fM29z3), (int) (f12 + AbstractC0000a.m29z(motionPaths2.height, f10, f6, f10)));
        }
        HashMap<String, KeyCycleOscillator> map2 = this.mCycleMap;
        if (map2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : map2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget2, f6, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget2, f6);
                }
            }
        }
        return false;
    }

    public String name() {
        return this.mView.getName();
    }

    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f, float f4, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f5 = motionPaths.f1216x;
        floatRect.left = f5;
        float f6 = motionPaths.f1217y;
        floatRect.top = f6;
        floatRect.right = f5 + motionPaths.width;
        floatRect.bottom = f6 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f7 = motionPaths2.f1216x;
        floatRect2.left = f7;
        float f8 = motionPaths2.f1217y;
        floatRect2.top = f8;
        floatRect2.right = f7 + motionPaths2.width;
        floatRect2.bottom = f8 + motionPaths2.height;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f, f4, strArr, fArr);
    }

    public void rotate(Rect rect, Rect rect2, int i, int i2, int i4) {
        if (i == 1) {
            int i5 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i4 - ((rect.height() + i5) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i == 2) {
            int i6 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i == 3) {
            int i7 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i7 / 2);
            rect2.top = i4 - ((rect.height() + i7) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i != 4) {
            return;
        }
        int i8 = rect.left + rect.right;
        rect2.left = i2 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i8 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i, int i2, int i4) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        Rect rect = new Rect();
        if (i == 1) {
            int i5 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i2 - ((viewState.height() + i5) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        } else if (i == 2) {
            int i6 = viewState.left + viewState.right;
            rect.left = i4 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
            rect.top = (i6 - viewState.height()) / 2;
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setup(int i, int i2, float f, long j) {
        ArrayList arrayList;
        int i4;
        String[] strArr;
        int i5;
        int i6;
        CustomVariable customVariable;
        SplineSet splineSetMakeSpline;
        CustomVariable customVariable2;
        Integer num;
        int i7;
        SplineSet splineSetMakeSpline2;
        CustomVariable customVariable3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i8 = this.mPathMotionArc;
        if (i8 != -1) {
            this.mStartMotionPath.mPathMotionArc = i8;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            arrayList = null;
            for (MotionKey motionKey : arrayList2) {
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    insertKey(new MotionPaths(i, i2, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i9 = motionKeyPosition.mCurveFit;
                    if (i9 != -1) {
                        this.mCurveFitType = i9;
                    }
                } else if (motionKey instanceof MotionKeyCycle) {
                    motionKey.getAttributeNames(hashSet3);
                } else if (motionKey instanceof MotionKeyTimeCycle) {
                    motionKey.getAttributeNames(hashSet);
                } else if (motionKey instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) motionKey);
                } else {
                    motionKey.setInterpolation(map);
                    motionKey.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        int i10 = 1;
        if (hashSet2.isEmpty()) {
            i4 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str2 = str.split(",")[i10];
                    i7 = i10;
                    for (MotionKey motionKey2 : this.mKeyList) {
                        HashMap<String, CustomVariable> map2 = motionKey2.mCustom;
                        if (map2 != null && (customVariable3 = map2.get(str2)) != null) {
                            customVar.append(motionKey2.mFramePosition, customVariable3);
                        }
                    }
                    splineSetMakeSpline2 = SplineSet.makeCustomSplineSet(str, customVar);
                } else {
                    i7 = i10;
                    splineSetMakeSpline2 = SplineSet.makeSpline(str, j);
                }
                if (splineSetMakeSpline2 != null) {
                    splineSetMakeSpline2.setType(str);
                    this.mAttributesMap.put(str, splineSetMakeSpline2);
                }
                i10 = i7;
            }
            i4 = i10;
            ArrayList<MotionKey> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                for (MotionKey motionKey3 : arrayList3) {
                    if (motionKey3 instanceof MotionKeyAttributes) {
                        motionKey3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str3 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.mAttributesMap.get(str3);
                if (splineSet != null) {
                    splineSet.setup(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.mTimeCycleAttributesMap.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str5 = str4.split(",")[i4];
                        for (MotionKey motionKey4 : this.mKeyList) {
                            HashMap<String, CustomVariable> map3 = motionKey4.mCustom;
                            if (map3 != null && (customVariable2 = map3.get(str5)) != null) {
                                customVar2.append(motionKey4.mFramePosition, customVariable2);
                            }
                        }
                        splineSetMakeSpline = SplineSet.makeCustomSplineSet(str4, customVar2);
                    } else {
                        splineSetMakeSpline = SplineSet.makeSpline(str4, j);
                    }
                    if (splineSetMakeSpline != null) {
                        splineSetMakeSpline.setType(str4);
                    }
                }
            }
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                for (MotionKey motionKey5 : arrayList4) {
                    if (motionKey5 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey5).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str6 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str6).setup(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int size = this.mMotionPaths.size();
        int i11 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i11];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        int i12 = i4;
        while (it.hasNext()) {
            motionPathsArr[i12] = it.next();
            i12++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.mEndMotionPath.customAttributes.keySet()) {
            if (this.mStartMotionPath.customAttributes.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i13 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i13 >= strArr.length) {
                break;
            }
            String str8 = strArr[i13];
            this.mAttributeInterpolatorCount[i13] = 0;
            int i14 = 0;
            while (true) {
                if (i14 >= i11) {
                    break;
                }
                if (motionPathsArr[i14].customAttributes.containsKey(str8) && (customVariable = motionPathsArr[i14].customAttributes.get(str8)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i13] = customVariable.numberOfInterpolatedValues() + iArr[i13];
                    break;
                }
                i14++;
            }
            i13++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != -1 ? i4 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i15 = i4; i15 < i11; i15++) {
            motionPathsArr[i15].different(motionPathsArr[i15 - 1], zArr, this.mAttributeNames, z);
        }
        int i16 = 0;
        for (int i17 = i4; i17 < length; i17++) {
            if (zArr[i17]) {
                i16++;
            }
        }
        this.mInterpolateVariables = new int[i16];
        int i18 = 2;
        int iMax = Math.max(2, i16);
        this.mInterpolateData = new double[iMax];
        this.mInterpolateVelocity = new double[iMax];
        int i19 = 0;
        for (int i20 = i4; i20 < length; i20++) {
            if (zArr[i20]) {
                this.mInterpolateVariables[i19] = i20;
                i19++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i4] = this.mInterpolateVariables.length;
        iArr2[0] = i11;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i11];
        for (int i21 = 0; i21 < i11; i21++) {
            motionPathsArr[i21].fillStandard(dArr[i21], this.mInterpolateVariables);
            dArr2[i21] = motionPathsArr[i21].time;
        }
        int i22 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i22 >= iArr3.length) {
                break;
            }
            if (iArr3[i22] < MotionPaths.names.length) {
                String strM1170p = AbstractC0622a.m1170p(MotionPaths.names[this.mInterpolateVariables[i22]], " [", new StringBuilder());
                for (int i23 = 0; i23 < i11; i23++) {
                    StringBuilder sbM1324q = AbstractC1974b.m1324q(strM1170p);
                    sbM1324q.append(dArr[i23][i22]);
                    strM1170p = sbM1324q.toString();
                }
            }
            i22++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i24 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i24 >= strArr3.length) {
                break;
            }
            String str9 = strArr3[i24];
            int i25 = 0;
            int i26 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i25 < i11) {
                if (motionPathsArr[i25].hasCustomData(str9)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i11];
                        int[] iArr4 = new int[i18];
                        iArr4[i4] = motionPathsArr[i25].getCustomDataCount(str9);
                        i6 = 0;
                        iArr4[0] = i11;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i6 = 0;
                    }
                    MotionPaths motionPaths = motionPathsArr[i25];
                    i5 = i24;
                    dArr3[i26] = motionPaths.time;
                    motionPaths.getCustomData(str9, dArr4[i26], i6);
                    i26++;
                } else {
                    i5 = i24;
                }
                i25++;
                i24 = i5;
                i18 = 2;
            }
            int i27 = i24 + 1;
            this.mSpline[i27] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i26), (double[][]) Arrays.copyOf(dArr4, i26));
            i24 = i27;
            i18 = 2;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr5 = new int[i11];
            double[] dArr5 = new double[i11];
            int[] iArr6 = new int[2];
            iArr6[i4] = 2;
            iArr6[0] = i11;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i28 = 0; i28 < i11; i28++) {
                iArr5[i28] = motionPathsArr[i28].mPathMotionArc;
                dArr5[i28] = r7.time;
                double[] dArr7 = dArr6[i28];
                dArr7[0] = r7.f1216x;
                dArr7[i4] = r7.f1217y;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            float preCycleDistance = Float.NaN;
            for (String str10 : hashSet3) {
                KeyCycleOscillator keyCycleOscillatorMakeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(str10);
                if (keyCycleOscillatorMakeWidgetCycle != null) {
                    if (keyCycleOscillatorMakeWidgetCycle.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    keyCycleOscillatorMakeWidgetCycle.setType(str10);
                    this.mCycleMap.put(str10, keyCycleOscillatorMakeWidgetCycle);
                }
            }
            for (MotionKey motionKey6 : this.mKeyList) {
                if (motionKey6 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey6).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it2 = this.mCycleMap.values().iterator();
            while (it2.hasNext()) {
                it2.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motion, motion.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f1216x + " y: " + this.mStartMotionPath.f1217y + " end: x: " + this.mEndMotionPath.f1216x + " y: " + this.mEndMotionPath.f1217y;
    }

    public void endTrigger(boolean z) {
    }
}
