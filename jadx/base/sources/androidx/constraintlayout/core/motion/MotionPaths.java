package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* JADX INFO: renamed from: x */
    float f1216x;

    /* JADX INFO: renamed from: y */
    float f1217y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f, float f4) {
        return (Float.isNaN(f) || Float.isNaN(f4)) ? Float.isNaN(f) != Float.isNaN(f4) : Math.abs(f - f4) > 1.0E-6f;
    }

    private static final float xRotate(float f, float f4, float f5, float f6, float f7, float f8) {
        return (((f7 - f5) * f4) - ((f8 - f6) * f)) + f5;
    }

    private static final float yRotate(float f, float f4, float f5, float f6, float f7, float f8) {
        return ((f8 - f6) * f4) + ((f7 - f5) * f) + f6;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean zDiff = diff(this.f1216x, motionPaths.f1216x);
        boolean zDiff2 = diff(this.f1217y, motionPaths.f1217y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z2 = zDiff | zDiff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f1216x, this.f1217y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = fArr[r1];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i4 = iArr[i2];
            if (i4 == 3) {
                f = f5;
            } else if (i4 == 4) {
                f4 = f5;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f4;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fM5b = this.f1216x;
        float fCos = this.f1217y;
        float f = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i4 = iArr[i2];
            if (i4 == 1) {
                fM5b = f5;
            } else if (i4 == 2) {
                fCos = f5;
            } else if (i4 == 3) {
                f = f5;
            } else if (i4 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = fM5b;
            double d3 = fCos;
            fM5b = (float) (AbstractC0000a.m5b(d3, d2, f6) - ((double) (f / 2.0f)));
            fCos = (float) ((((double) f7) - (Math.cos(d3) * d2)) - ((double) (f4 / 2.0f)));
        }
        fArr[i] = (f / 2.0f) + fM5b + 0.0f;
        fArr[i + 1] = (f4 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fM5b = this.f1216x;
        float fCos = this.f1217y;
        float f = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i4 = iArr[i2];
            if (i4 == 1) {
                fM5b = f5;
            } else if (i4 == 2) {
                fCos = f5;
            } else if (i4 == 3) {
                f = f5;
            } else if (i4 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = fM5b;
            double d3 = fCos;
            fM5b = (float) (AbstractC0000a.m5b(d3, d2, f6) - ((double) (f / 2.0f)));
            fCos = (float) ((((double) f7) - (Math.cos(d3) * d2)) - ((double) (f4 / 2.0f)));
        }
        fArr[i] = (f / 2.0f) + fM5b + 0.0f;
        fArr[i + 1] = (f4 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i2 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i2 < iNumberOfInterpolatedValues) {
            dArr[i] = r2[i2];
            i2++;
            i++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float fM5b = this.f1216x;
        float fCos = this.f1217y;
        float f = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i4 = iArr[i2];
            if (i4 == 1) {
                fM5b = f5;
            } else if (i4 == 2) {
                fCos = f5;
            } else if (i4 == 3) {
                f = f5;
            } else if (i4 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = fM5b;
            double d2 = fCos;
            fM5b = (float) (AbstractC0000a.m5b(d2, d, centerX) - ((double) (f / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d2) * d)) - ((double) (f4 / 2.0f)));
        }
        float f6 = f + fM5b;
        float f7 = f4 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = fM5b + 0.0f;
        fArr[i + 1] = fCos + 0.0f;
        fArr[i + 2] = f6 + 0.0f;
        fArr[i + 3] = fCos + 0.0f;
        fArr[i + 4] = f6 + 0.0f;
        fArr[i + 5] = f7 + 0.0f;
        fArr[i + 6] = fM5b + 0.0f;
        fArr[i + 7] = f7 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.width;
        float f7 = motionPaths.width;
        float f8 = f6 - f7;
        float f9 = motionPaths2.height;
        float f10 = motionPaths.height;
        float f11 = f9 - f10;
        this.position = this.time;
        float f12 = motionPaths.f1216x;
        float f13 = motionPaths.f1217y;
        float f14 = f;
        float f15 = ((f6 / 2.0f) + motionPaths2.f1216x) - ((f7 / 2.0f) + f12);
        float f16 = ((f9 / 2.0f) + motionPaths2.f1217y) - ((f10 / 2.0f) + f13);
        float f17 = (f8 * f4) / 2.0f;
        this.f1216x = (int) (((f15 * f14) + f12) - f17);
        float f18 = (f11 * f5) / 2.0f;
        this.f1217y = (int) (((f16 * f14) + f13) - f18);
        this.width = (int) (f7 + r9);
        this.height = (int) (f10 + r12);
        float f19 = Float.isNaN(motionKeyPosition.mPercentX) ? f14 : motionKeyPosition.mPercentX;
        float f20 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f14 = motionKeyPosition.mPercentY;
        }
        float f21 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.f1216x = (int) (((f21 * f16) + ((f19 * f15) + motionPaths.f1216x)) - f17);
        this.f1217y = (int) (((f16 * f14) + ((f15 * f20) + motionPaths.f1217y)) - f18);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.width - motionPaths.width;
        float f7 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f = motionKeyPosition.mPercentX;
        }
        float f8 = motionPaths.f1216x;
        float f9 = motionPaths.width;
        float f10 = motionPaths.f1217y;
        float f11 = motionPaths.height;
        float f12 = f;
        float f13 = ((motionPaths2.width / 2.0f) + motionPaths2.f1216x) - ((f9 / 2.0f) + f8);
        float f14 = ((motionPaths2.height / 2.0f) + motionPaths2.f1217y) - ((f11 / 2.0f) + f10);
        float f15 = f13 * f12;
        float f16 = (f6 * f4) / 2.0f;
        this.f1216x = (int) ((f8 + f15) - f16);
        float f17 = f14 * f12;
        float f18 = (f7 * f5) / 2.0f;
        this.f1217y = (int) ((f10 + f17) - f18);
        this.width = (int) (f9 + r7);
        this.height = (int) (f11 + r8);
        float f19 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f20 = (int) ((motionPaths.f1216x + f15) - f16);
        float f21 = (int) ((motionPaths.f1217y + f17) - f18);
        this.f1216x = f20 + ((-f14) * f19);
        this.f1217y = f21 + (f13 * f19);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fM29z;
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.width;
        float f7 = motionPaths.width;
        float f8 = motionPaths2.height;
        float f9 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (((f6 - f7) * f4) + f7);
        this.height = (int) (((f8 - f9) * f5) + f9);
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            float f10 = Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX;
            float f11 = motionPaths2.f1216x;
            float f12 = motionPaths.f1216x;
            this.f1216x = AbstractC0000a.m29z(f11, f12, f10, f12);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f = motionKeyPosition.mPercentY;
            }
            float f13 = motionPaths2.f1217y;
            float f14 = motionPaths.f1217y;
            this.f1217y = AbstractC0000a.m29z(f13, f14, f, f14);
        } else if (i4 != 2) {
            float f15 = Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX;
            float f16 = motionPaths2.f1216x;
            float f17 = motionPaths.f1216x;
            this.f1216x = AbstractC0000a.m29z(f16, f17, f15, f17);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f = motionKeyPosition.mPercentY;
            }
            float f18 = motionPaths2.f1217y;
            float f19 = motionPaths.f1217y;
            this.f1217y = AbstractC0000a.m29z(f18, f19, f, f19);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f20 = motionPaths2.f1216x;
                float f21 = motionPaths.f1216x;
                fMin = AbstractC0000a.m29z(f20, f21, f, f21);
            } else {
                fMin = Math.min(f5, f4) * motionKeyPosition.mPercentX;
            }
            this.f1216x = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f22 = motionPaths2.f1217y;
                float f23 = motionPaths.f1217y;
                fM29z = AbstractC0000a.m29z(f22, f23, f, f23);
            } else {
                fM29z = motionKeyPosition.mPercentY;
            }
            this.f1217y = fM29z;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.width;
        float f7 = f6 - motionPaths.width;
        float f8 = motionPaths2.height;
        float f9 = f8 - motionPaths.height;
        this.position = this.time;
        float f10 = motionPaths.f1216x;
        float f11 = motionPaths.f1217y;
        float f12 = (f6 / 2.0f) + motionPaths2.f1216x;
        float f13 = (f8 / 2.0f) + motionPaths2.f1217y;
        float f14 = f7 * f4;
        this.f1216x = (int) ((((f12 - ((r8 / 2.0f) + f10)) * f) + f10) - (f14 / 2.0f));
        float f15 = f9 * f5;
        this.f1217y = (int) ((((f13 - ((r11 / 2.0f) + f11)) * f) + f11) - (f15 / 2.0f));
        this.width = (int) (r8 + f14);
        this.height = (int) (r11 + f15);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.f1216x = (int) (motionKeyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.f1217y = (int) (motionKeyPosition.mPercentY * ((int) (i2 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f4, float f5, float f6) {
        this.f1216x = f;
        this.f1217y = f4;
        this.width = f5;
        this.height = f6;
    }

    public void setDpDt(float f, float f4, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f9 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f5 = f9;
            } else if (i2 == 2) {
                f7 = f9;
            } else if (i2 == 3) {
                f6 = f9;
            } else if (i2 == 4) {
                f8 = f9;
            }
        }
        float f10 = f5 - ((0.0f * f6) / 2.0f);
        float f11 = f7 - ((0.0f * f8) / 2.0f);
        fArr[0] = (((f6 * 1.0f) + f10) * f) + ((1.0f - f) * f10) + 0.0f;
        fArr[1] = (((f8 * 1.0f) + f11) * f4) + ((1.0f - f4) * f11) + 0.0f;
    }

    public void setView(float f, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f4;
        float f5 = this.f1216x;
        float f6 = this.f1217y;
        float f7 = this.width;
        float f8 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            double[] dArr4 = this.mTempValue;
            int i4 = iArr[i2];
            dArr4[i4] = dArr[i2];
            this.mTempDelta[i4] = dArr2[i2];
        }
        float f9 = Float.NaN;
        int i5 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i5 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i5]) && (dArr3 == null || dArr3[i5] == 0.0d)) {
                f4 = f9;
            } else {
                double d = dArr3 != null ? dArr3[i5] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i5])) {
                    d = this.mTempValue[i5] + d;
                }
                f4 = f9;
                float f14 = (float) d;
                float f15 = (float) this.mTempDelta[i5];
                if (i5 == 1) {
                    f9 = f4;
                    f10 = f15;
                    f5 = f14;
                } else if (i5 == 2) {
                    f9 = f4;
                    f11 = f15;
                    f6 = f14;
                } else if (i5 == 3) {
                    f9 = f4;
                    f12 = f15;
                    f7 = f14;
                } else if (i5 == 4) {
                    f9 = f4;
                    f13 = f15;
                    f8 = f14;
                } else if (i5 == 5) {
                    f9 = f14;
                }
                i5++;
            }
            f9 = f4;
            i5++;
        }
        float f16 = f9;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f, fArr, fArr2);
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr2[0];
            float f20 = fArr2[1];
            double d2 = f17;
            double d3 = f5;
            double d4 = f6;
            float fM5b = (float) (AbstractC0000a.m5b(d4, d3, d2) - ((double) (f7 / 2.0f)));
            float fCos = (float) ((((double) f18) - (Math.cos(d4) * d3)) - ((double) (f8 / 2.0f)));
            double d5 = f19;
            double d6 = f10;
            double d7 = f11;
            float fCos2 = (float) ((Math.cos(d4) * d3 * d7) + AbstractC0000a.m5b(d4, d6, d5));
            float fSin = (float) ((Math.sin(d4) * d3 * d7) + (((double) f20) - (Math.cos(d4) * d6)));
            if (dArr2.length >= 2) {
                dArr2[0] = fCos2;
                dArr2[1] = fSin;
            }
            if (!Float.isNaN(f16)) {
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2(fSin, fCos2)) + ((double) f16)));
            }
            f5 = fM5b;
            f6 = fCos;
        } else if (!Float.isNaN(f16)) {
            motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2((f13 / 2.0f) + f11, (f12 / 2.0f) + f10)) + ((double) f16) + ((double) 0.0f)));
        }
        float f21 = f5 + 0.5f;
        float f22 = f6 + 0.5f;
        motionWidget.layout((int) f21, (int) f22, (int) (f21 + f7), (int) (f22 + f8));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (((this.width / 2.0f) + this.f1216x) - motionPaths.f1216x) - (motionPaths.width / 2.0f);
        double d2 = (((this.height / 2.0f) + this.f1217y) - motionPaths.f1217y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.f1216x = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.f1217y = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.f1217y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i4 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i2, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float fM5b = this.f1216x;
        float fCos = this.f1217y;
        float f4 = this.width;
        float f5 = this.height;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f10 = (float) dArr[i];
            float f11 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                fM5b = f10;
                f6 = f11;
            } else if (i2 == 2) {
                fCos = f10;
                f8 = f11;
            } else if (i2 == 3) {
                f4 = f10;
                f7 = f11;
            } else if (i2 == 4) {
                f5 = f10;
                f9 = f11;
            }
        }
        float f12 = (f7 / 2.0f) + f6;
        float fM5b2 = (f9 / 2.0f) + f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f13 = fArr3[0];
            float f14 = fArr3[1];
            float f15 = fArr4[0];
            float f16 = fArr4[1];
            f = 2.0f;
            double d2 = fM5b;
            double d3 = fCos;
            fM5b = (float) (AbstractC0000a.m5b(d3, d2, f13) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) f14) - (Math.cos(d3) * d2)) - ((double) (f5 / 2.0f)));
            double d4 = f6;
            double dM5b = AbstractC0000a.m5b(d3, d4, f15);
            double d5 = f8;
            float fCos2 = (float) ((Math.cos(d3) * d5) + dM5b);
            fM5b2 = (float) AbstractC0000a.m5b(d3, d5, ((double) f16) - (Math.cos(d3) * d4));
            f12 = fCos2;
        } else {
            f = 2.0f;
        }
        fArr[0] = (f4 / f) + fM5b + 0.0f;
        fArr[1] = (f5 / f) + fCos + 0.0f;
        fArr2[0] = f12;
        fArr2[1] = fM5b2;
    }
}
