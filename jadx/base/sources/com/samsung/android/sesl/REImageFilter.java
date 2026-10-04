package com.samsung.android.sesl;

import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.app.sdk.deepsky.common.AbstractC7019f;
import com.samsung.android.sesl.renderEffectImageFilter.ImageFilterParams;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.context.sdk.samsunganalytics.internal.AbstractC11605a;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0007J\b\u0010!\u001a\u0004\u0018\u00010\u0001J\"\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010#2\u0006\u0010+\u001a\u00020%H\u0007J\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u0004\u0018\u00010\u0001J\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u001fJ\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u000207J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u000207J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u000207J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u000207J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u000207J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u00020\u00002\u0006\u00101\u001a\u00020FJ\u000e\u0010G\u001a\u00020\u00002\u0006\u00101\u001a\u00020'J\u000e\u0010H\u001a\u00020\u00002\u0006\u00101\u001a\u00020)J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u000207J\u0016\u0010K\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, m13886d2 = {"Lcom/samsung/android/sesl/REImageFilter;", "", "()V", SearchConstants.TargetContents.TAG, "", "buildMethod", "Ljava/lang/reflect/Method;", "clearMethod", "getRenderNodeMethod", "imageFilterClass", "Ljava/lang/Class;", "instance", "printParamsMethod", "setBGColorAdjustmentMethod", "setBlurPresetMethod", "setBlurRadiusMethod", "setCurveLevelMethod", "setCurveMaxXMethod", "setCurveMaxYMethod", "setCurveMinXMethod", "setCurveMinYMethod", "setDitherMethod", "setGradientBlurMethod", "setGradientColorMethod", "setOffsetMethod", "setProportionalSaturationMethod", "setSizeMethod", "toStringMethod", "build", "Landroid/graphics/RenderEffect;", "width", "", "height", "clear", "expandImage", "Landroid/graphics/RenderNode;", "srcImage", "Landroid/graphics/Bitmap;", "gcObj", "Lcom/samsung/android/sesl/renderEffectImageFilter/ImageFilterParams$GradientColor;", "offsetObj", "Lcom/samsung/android/sesl/renderEffectImageFilter/ImageFilterParams$OffsetTransition;", "getRenderNode", "src", "getShaderCode", "printMethods", "", "printParams", "setBGColorAdjustment", "obj", "Lcom/samsung/android/sesl/renderEffectImageFilter/ImageFilterParams$BGColorAdjustment;", "setBlurPreset", "present", "setBlurRadius", "radius", "", "setCurveLevel", "curveLevel", "setCurveMaxX", "maxX", "setCurveMaxY", "maxY", "setCurveMinX", "minX", "setCurveMinY", "minY", "setDither", "enable", "", "setGradientBlur", "Lcom/samsung/android/sesl/renderEffectImageFilter/ImageFilterParams$GradientBlur;", "setGradientColor", "setOffset", "setProportionalSaturation", "saturation", "setSize", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nREImageFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 REImageFilter.kt\ncom/samsung/android/sesl/REImageFilter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,376:1\n13309#2:377\n13309#2,2:378\n13310#2:380\n*S KotlinDebug\n*F\n+ 1 REImageFilter.kt\ncom/samsung/android/sesl/REImageFilter\n*L\n196#1:377\n198#1:378,2\n196#1:380\n*E\n"})
public final class REImageFilter {

    @NotNull
    private final String TAG;

    @Nullable
    private final Method buildMethod;

    @Nullable
    private final Method clearMethod;

    @Nullable
    private final Method getRenderNodeMethod;

    @Nullable
    private final Class<?> imageFilterClass;

    @Nullable
    private final Object instance;

    @Nullable
    private final Method printParamsMethod;

    @Nullable
    private final Method setBGColorAdjustmentMethod;

    @Nullable
    private final Method setBlurPresetMethod;

    @Nullable
    private final Method setBlurRadiusMethod;

    @Nullable
    private final Method setCurveLevelMethod;

    @Nullable
    private final Method setCurveMaxXMethod;

    @Nullable
    private final Method setCurveMaxYMethod;

    @Nullable
    private final Method setCurveMinXMethod;

    @Nullable
    private final Method setCurveMinYMethod;

    @Nullable
    private final Method setDitherMethod;

    @Nullable
    private final Method setGradientBlurMethod;

    @Nullable
    private final Method setGradientColorMethod;

    @Nullable
    private final Method setOffsetMethod;

    @Nullable
    private final Method setProportionalSaturationMethod;

    @Nullable
    private final Method setSizeMethod;

    @Nullable
    private final Method toStringMethod;

    /* JADX WARN: Removed duplicated region for block: B:248:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0397  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public REImageFilter() {
        Object objM22215constructorimpl;
        Object objNewInstance;
        Object objM22215constructorimpl2;
        Object objM22215constructorimpl3;
        Object objM22215constructorimpl4;
        Object objM22215constructorimpl5;
        Object objM22215constructorimpl6;
        Object objM22215constructorimpl7;
        Object objM22215constructorimpl8;
        Object objM22215constructorimpl9;
        Object objM22215constructorimpl10;
        Object objM22215constructorimpl11;
        Object objM22215constructorimpl12;
        Object objM22215constructorimpl13;
        Object objM22215constructorimpl14;
        Object objM22215constructorimpl15;
        Object objM22215constructorimpl16;
        Object objM22215constructorimpl17;
        Object objM22215constructorimpl18;
        Object objM22215constructorimpl19;
        Object objM22215constructorimpl20;
        Method declaredMethod;
        Method declaredMethod2;
        Method declaredMethod3;
        Method declaredMethod4;
        Method declaredMethod5;
        Method declaredMethod6;
        Method declaredMethod7;
        Method declaredMethod8;
        Method declaredMethod9;
        Method declaredMethod10;
        Method declaredMethod11;
        Method declaredMethod12;
        Method declaredMethod13;
        Method declaredMethod14;
        Method declaredMethod15;
        Method declaredMethod16;
        Method declaredMethod17;
        Class cls = Integer.TYPE;
        Class cls2 = Float.TYPE;
        this.TAG = "REImageFilter";
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Class.forName("com.samsung.android.graphics.RenderEffectImageFilter"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Class<?> cls3 = (Class) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
        this.imageFilterClass = cls3;
        if (cls3 != null) {
            try {
                objNewInstance = cls3.getDeclaredConstructor(null).newInstance(null);
            } catch (Exception unused) {
                objNewInstance = null;
            }
        } else {
            objNewInstance = null;
        }
        this.instance = objNewInstance;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Class<?> cls4 = this.imageFilterClass;
            if (cls4 == null || (declaredMethod17 = cls4.getDeclaredMethod("getRenderNode", Bitmap.class)) == null) {
                declaredMethod17 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod17);
                declaredMethod17.setAccessible(true);
            }
            objM22215constructorimpl2 = Result.m22215constructorimpl(declaredMethod17);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM22215constructorimpl2 = Result.m22215constructorimpl(ResultKt.createFailure(th2));
        }
        this.getRenderNodeMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl2) ? null : objM22215constructorimpl2);
        try {
            Class<?> cls5 = this.imageFilterClass;
            if (cls5 == null || (declaredMethod16 = cls5.getDeclaredMethod("setBlurRadius", cls2)) == null) {
                declaredMethod16 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod16);
                declaredMethod16.setAccessible(true);
            }
            objM22215constructorimpl3 = Result.m22215constructorimpl(declaredMethod16);
        } catch (Throwable th3) {
            Result.Companion companion5 = Result.INSTANCE;
            objM22215constructorimpl3 = Result.m22215constructorimpl(ResultKt.createFailure(th3));
        }
        this.setBlurRadiusMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl3) ? null : objM22215constructorimpl3);
        try {
            Class<?> cls6 = this.imageFilterClass;
            if (cls6 == null || (declaredMethod15 = cls6.getDeclaredMethod("setProportionalSaturation", cls2)) == null) {
                declaredMethod15 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod15);
                declaredMethod15.setAccessible(true);
            }
            objM22215constructorimpl4 = Result.m22215constructorimpl(declaredMethod15);
        } catch (Throwable th4) {
            Result.Companion companion6 = Result.INSTANCE;
            objM22215constructorimpl4 = Result.m22215constructorimpl(ResultKt.createFailure(th4));
        }
        this.setProportionalSaturationMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl4) ? null : objM22215constructorimpl4);
        try {
            Class<?> cls7 = this.imageFilterClass;
            if (cls7 == null || (declaredMethod14 = cls7.getDeclaredMethod("setCurveLevel", cls2)) == null) {
                declaredMethod14 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod14);
                declaredMethod14.setAccessible(true);
            }
            objM22215constructorimpl5 = Result.m22215constructorimpl(declaredMethod14);
        } catch (Throwable th5) {
            Result.Companion companion7 = Result.INSTANCE;
            objM22215constructorimpl5 = Result.m22215constructorimpl(ResultKt.createFailure(th5));
        }
        this.setCurveLevelMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl5) ? null : objM22215constructorimpl5);
        try {
            Class<?> cls8 = this.imageFilterClass;
            if (cls8 == null || (declaredMethod13 = cls8.getDeclaredMethod("setCurveMaxX", cls2)) == null) {
                declaredMethod13 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod13);
                declaredMethod13.setAccessible(true);
            }
            objM22215constructorimpl6 = Result.m22215constructorimpl(declaredMethod13);
        } catch (Throwable th6) {
            Result.Companion companion8 = Result.INSTANCE;
            objM22215constructorimpl6 = Result.m22215constructorimpl(ResultKt.createFailure(th6));
        }
        this.setCurveMaxXMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl6) ? null : objM22215constructorimpl6);
        try {
            Class<?> cls9 = this.imageFilterClass;
            if (cls9 == null || (declaredMethod12 = cls9.getDeclaredMethod("setCurveMinX", cls2)) == null) {
                declaredMethod12 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod12);
                declaredMethod12.setAccessible(true);
            }
            objM22215constructorimpl7 = Result.m22215constructorimpl(declaredMethod12);
        } catch (Throwable th7) {
            Result.Companion companion9 = Result.INSTANCE;
            objM22215constructorimpl7 = Result.m22215constructorimpl(ResultKt.createFailure(th7));
        }
        this.setCurveMinXMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl7) ? null : objM22215constructorimpl7);
        try {
            Class<?> cls10 = this.imageFilterClass;
            if (cls10 == null || (declaredMethod11 = cls10.getDeclaredMethod("setCurveMaxY", cls2)) == null) {
                declaredMethod11 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod11);
                declaredMethod11.setAccessible(true);
            }
            objM22215constructorimpl8 = Result.m22215constructorimpl(declaredMethod11);
        } catch (Throwable th8) {
            Result.Companion companion10 = Result.INSTANCE;
            objM22215constructorimpl8 = Result.m22215constructorimpl(ResultKt.createFailure(th8));
        }
        this.setCurveMaxYMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl8) ? null : objM22215constructorimpl8);
        try {
            Class<?> cls11 = this.imageFilterClass;
            if (cls11 == null || (declaredMethod10 = cls11.getDeclaredMethod("setCurveMinY", cls2)) == null) {
                declaredMethod10 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod10);
                declaredMethod10.setAccessible(true);
            }
            objM22215constructorimpl9 = Result.m22215constructorimpl(declaredMethod10);
        } catch (Throwable th9) {
            Result.Companion companion11 = Result.INSTANCE;
            objM22215constructorimpl9 = Result.m22215constructorimpl(ResultKt.createFailure(th9));
        }
        this.setCurveMinYMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl9) ? null : objM22215constructorimpl9);
        try {
            Class<?> cls12 = this.imageFilterClass;
            if (cls12 == null || (declaredMethod9 = cls12.getDeclaredMethod("setDither", Boolean.TYPE)) == null) {
                declaredMethod9 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod9);
                declaredMethod9.setAccessible(true);
            }
            objM22215constructorimpl10 = Result.m22215constructorimpl(declaredMethod9);
        } catch (Throwable th10) {
            Result.Companion companion12 = Result.INSTANCE;
            objM22215constructorimpl10 = Result.m22215constructorimpl(ResultKt.createFailure(th10));
        }
        this.setDitherMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl10) ? null : objM22215constructorimpl10);
        try {
            Class<?> cls13 = this.imageFilterClass;
            if (cls13 == null || (declaredMethod8 = cls13.getDeclaredMethod("setBlurPreset", cls)) == null) {
                declaredMethod8 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod8);
                declaredMethod8.setAccessible(true);
            }
            objM22215constructorimpl11 = Result.m22215constructorimpl(declaredMethod8);
        } catch (Throwable th11) {
            Result.Companion companion13 = Result.INSTANCE;
            objM22215constructorimpl11 = Result.m22215constructorimpl(ResultKt.createFailure(th11));
        }
        this.setBlurPresetMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl11) ? null : objM22215constructorimpl11);
        try {
            Class<?> cls14 = this.imageFilterClass;
            if (cls14 == null || (declaredMethod7 = cls14.getDeclaredMethod("setSize", cls, cls)) == null) {
                declaredMethod7 = null;
            } else {
                declaredMethod7.setAccessible(true);
            }
            objM22215constructorimpl12 = Result.m22215constructorimpl(declaredMethod7);
        } catch (Throwable th12) {
            Result.Companion companion14 = Result.INSTANCE;
            objM22215constructorimpl12 = Result.m22215constructorimpl(ResultKt.createFailure(th12));
        }
        this.setSizeMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl12) ? null : objM22215constructorimpl12);
        try {
            Class<?> cls15 = this.imageFilterClass;
            if (cls15 == null || (declaredMethod6 = cls15.getDeclaredMethod("build", cls, cls)) == null) {
                declaredMethod6 = null;
            } else {
                declaredMethod6.setAccessible(true);
            }
            objM22215constructorimpl13 = Result.m22215constructorimpl(declaredMethod6);
        } catch (Throwable th13) {
            Result.Companion companion15 = Result.INSTANCE;
            objM22215constructorimpl13 = Result.m22215constructorimpl(ResultKt.createFailure(th13));
        }
        this.buildMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl13) ? null : objM22215constructorimpl13);
        try {
            Class<?> cls16 = this.imageFilterClass;
            if (cls16 == null || (declaredMethod5 = cls16.getDeclaredMethod("clear", null)) == null) {
                declaredMethod5 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod5);
                declaredMethod5.setAccessible(true);
            }
            objM22215constructorimpl14 = Result.m22215constructorimpl(declaredMethod5);
        } catch (Throwable th14) {
            Result.Companion companion16 = Result.INSTANCE;
            objM22215constructorimpl14 = Result.m22215constructorimpl(ResultKt.createFailure(th14));
        }
        this.clearMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl14) ? null : objM22215constructorimpl14);
        try {
            Class<?> cls17 = this.imageFilterClass;
            if (cls17 == null || (declaredMethod4 = cls17.getDeclaredMethod("toString", null)) == null) {
                declaredMethod4 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod4);
                declaredMethod4.setAccessible(true);
            }
            objM22215constructorimpl15 = Result.m22215constructorimpl(declaredMethod4);
        } catch (Throwable th15) {
            Result.Companion companion17 = Result.INSTANCE;
            objM22215constructorimpl15 = Result.m22215constructorimpl(ResultKt.createFailure(th15));
        }
        this.toStringMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl15) ? null : objM22215constructorimpl15);
        try {
            Class<?> cls18 = this.imageFilterClass;
            if (cls18 == null || (declaredMethod3 = cls18.getDeclaredMethod("printParams", null)) == null) {
                declaredMethod3 = null;
            } else {
                Intrinsics.checkNotNull(declaredMethod3);
                declaredMethod3.setAccessible(true);
            }
            objM22215constructorimpl16 = Result.m22215constructorimpl(declaredMethod3);
        } catch (Throwable th16) {
            Result.Companion companion18 = Result.INSTANCE;
            objM22215constructorimpl16 = Result.m22215constructorimpl(ResultKt.createFailure(th16));
        }
        this.printParamsMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl16) ? null : objM22215constructorimpl16);
        try {
            Class<?> cls19 = this.imageFilterClass;
            if (cls19 != null) {
                Class cls20 = Float.TYPE;
                Method declaredMethod18 = cls19.getDeclaredMethod("setGradientBlur", cls20, cls20, cls20, cls20, cls20, Integer.TYPE);
                if (declaredMethod18 != null) {
                    declaredMethod18.setAccessible(true);
                } else {
                    declaredMethod18 = null;
                }
                objM22215constructorimpl17 = Result.m22215constructorimpl(declaredMethod18);
            }
        } catch (Throwable th17) {
            Result.Companion companion19 = Result.INSTANCE;
            objM22215constructorimpl17 = Result.m22215constructorimpl(ResultKt.createFailure(th17));
        }
        this.setGradientBlurMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl17) ? null : objM22215constructorimpl17);
        try {
            Class<?> cls21 = this.imageFilterClass;
            if (cls21 != null) {
                Class cls22 = Integer.TYPE;
                Class cls23 = Float.TYPE;
                Method declaredMethod19 = cls21.getDeclaredMethod("setGradientColor", cls22, cls23, cls23, cls23, cls23, cls23, int[].class);
                if (declaredMethod19 != null) {
                    declaredMethod19.setAccessible(true);
                } else {
                    declaredMethod19 = null;
                }
                objM22215constructorimpl18 = Result.m22215constructorimpl(declaredMethod19);
            }
        } catch (Throwable th18) {
            Result.Companion companion20 = Result.INSTANCE;
            objM22215constructorimpl18 = Result.m22215constructorimpl(ResultKt.createFailure(th18));
        }
        this.setGradientColorMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl18) ? null : objM22215constructorimpl18);
        try {
            Class<?> cls24 = this.imageFilterClass;
            if (cls24 == null || (declaredMethod2 = cls24.getDeclaredMethod("setOffset", cls, cls2)) == null) {
                declaredMethod2 = null;
            } else {
                declaredMethod2.setAccessible(true);
            }
            objM22215constructorimpl19 = Result.m22215constructorimpl(declaredMethod2);
        } catch (Throwable th19) {
            Result.Companion companion21 = Result.INSTANCE;
            objM22215constructorimpl19 = Result.m22215constructorimpl(ResultKt.createFailure(th19));
        }
        this.setOffsetMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl19) ? null : objM22215constructorimpl19);
        try {
            Class<?> cls25 = this.imageFilterClass;
            if (cls25 == null || (declaredMethod = cls25.getDeclaredMethod("setBGColorAdjustment", cls2, cls2, cls2)) == null) {
                declaredMethod = null;
            } else {
                declaredMethod.setAccessible(true);
            }
            objM22215constructorimpl20 = Result.m22215constructorimpl(declaredMethod);
        } catch (Throwable th20) {
            Result.Companion companion22 = Result.INSTANCE;
            objM22215constructorimpl20 = Result.m22215constructorimpl(ResultKt.createFailure(th20));
        }
        this.setBGColorAdjustmentMethod = (Method) (Result.m22221isFailureimpl(objM22215constructorimpl20) ? null : objM22215constructorimpl20);
    }

    @RequiresApi(api = 31)
    @Nullable
    public final RenderEffect build(int width, int height) {
        Object objM22215constructorimpl;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.buildMethod;
            Object objInvoke = method != null ? method.invoke(this.instance, Integer.valueOf(width), Integer.valueOf(height)) : null;
            objM22215constructorimpl = Result.m22215constructorimpl(AbstractC7019f.m5370x(objInvoke) ? AbstractC7019f.m5353g(objInvoke) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl == null) {
            obj = objM22215constructorimpl;
        } else {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return AbstractC7019f.m5353g(obj);
    }

    @Nullable
    public final Object clear() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.clearMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, null) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl == null) {
            return objM22215constructorimpl;
        }
        thM22218exceptionOrNullimpl.printStackTrace();
        return Unit.INSTANCE;
    }

    @RequiresApi(api = 29)
    @Nullable
    public final RenderNode expandImage(@NotNull Bitmap srcImage, @NotNull ImageFilterParams.GradientColor gcObj, @NotNull ImageFilterParams.OffsetTransition offsetObj) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(srcImage, "srcImage");
        Intrinsics.checkNotNullParameter(gcObj, "gcObj");
        Intrinsics.checkNotNullParameter(offsetObj, "offsetObj");
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setGradientColorMethod;
            if (method != null) {
                method.invoke(this.instance, Integer.valueOf(gcObj.direction.getNumericType()), Float.valueOf(gcObj.percent), Float.valueOf(gcObj.pivotPercent), Float.valueOf(gcObj.pivotAlphaPercent), Float.valueOf(gcObj.controlP1), Float.valueOf(gcObj.controlP2), gcObj.colors);
            }
            Method method2 = this.setOffsetMethod;
            if (method2 != null) {
                method2.invoke(this.instance, Integer.valueOf(offsetObj.direction.getNumericType()), Float.valueOf(offsetObj.percent));
            }
            Method method3 = this.getRenderNodeMethod;
            Object objInvoke = method3 != null ? method3.invoke(this.instance, srcImage) : null;
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.RenderNode");
            objM22215constructorimpl = Result.m22215constructorimpl(AbstractC11605a.m12869a(objInvoke));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl == null) {
            obj = objM22215constructorimpl;
        } else {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return AbstractC11605a.m12869a(obj);
    }

    @RequiresApi(api = 29)
    @Nullable
    public final RenderNode getRenderNode(@NotNull Bitmap src) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(src, "src");
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.getRenderNodeMethod;
            Object objInvoke = method != null ? method.invoke(this.instance, src) : null;
            objM22215constructorimpl = Result.m22215constructorimpl(AbstractC11605a.m12877i(objInvoke) ? AbstractC11605a.m12869a(objInvoke) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl == null) {
            obj = objM22215constructorimpl;
        } else {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return AbstractC11605a.m12869a(obj);
    }

    @Nullable
    public final String getShaderCode() {
        Object objM22215constructorimpl;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.toStringMethod;
            Object objInvoke = method != null ? method.invoke(this.instance, null) : null;
            objM22215constructorimpl = Result.m22215constructorimpl(objInvoke instanceof String ? (String) objInvoke : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl == null) {
            obj = objM22215constructorimpl;
        } else {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return (String) obj;
    }

    public final void printMethods() {
        Method[] declaredMethods = Class.forName("com.samsung.android.graphics.RenderEffectImageFilter").getDeclaredMethods();
        Intrinsics.checkNotNull(declaredMethods);
        for (Method method : declaredMethods) {
            Log.d(this.TAG, "Method: " + method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            for (Class<?> cls : parameterTypes) {
                Log.d(this.TAG, " Parameter: ".concat(cls.getName()));
            }
        }
    }

    @Nullable
    public final Object printParams() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.printParamsMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, null) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl == null) {
            return objM22215constructorimpl;
        }
        thM22218exceptionOrNullimpl.printStackTrace();
        return Unit.INSTANCE;
    }

    @NotNull
    public final REImageFilter setBGColorAdjustment(@NotNull ImageFilterParams.BGColorAdjustment obj) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setBGColorAdjustmentMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(obj.amount), Float.valueOf(obj.minLevel), Float.valueOf(obj.maxLevel)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setBlurPreset(int present) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setBlurPresetMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Integer.valueOf(present)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setBlurRadius(float radius) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setBlurRadiusMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(radius)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setCurveLevel(float curveLevel) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setCurveLevelMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(curveLevel)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setCurveMaxX(float maxX) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setCurveMaxXMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(maxX)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setCurveMaxY(float maxY) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setCurveMaxYMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(maxY)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setCurveMinX(float minX) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setCurveMinXMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(minX)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setCurveMinY(float minY) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setCurveMinYMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(minY)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setDither(boolean enable) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setDitherMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Boolean.valueOf(enable)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setGradientBlur(@NotNull ImageFilterParams.GradientBlur obj) {
        Object objM22215constructorimpl;
        float f;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            Result.Companion companion = Result.INSTANCE;
            f = obj.direction;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (((double) f) % 90.0d != 0.0d) {
            throw new Exception("Degree only support 0, 90, 180, 270");
        }
        Method method = this.setGradientBlurMethod;
        objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(f), Float.valueOf(obj.percent), Float.valueOf(obj.pivotPercent), Float.valueOf(obj.f5259p1), Float.valueOf(obj.f5260p2), Integer.valueOf(obj.overlayType.getNumericType())) : null);
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setGradientColor(@NotNull ImageFilterParams.GradientColor obj) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setGradientColorMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Integer.valueOf(obj.direction.getNumericType()), Float.valueOf(obj.percent), Float.valueOf(obj.pivotPercent), Float.valueOf(obj.pivotAlphaPercent), Float.valueOf(obj.controlP1), Float.valueOf(obj.controlP2), obj.colors) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setOffset(@NotNull ImageFilterParams.OffsetTransition obj) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setOffsetMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Integer.valueOf(obj.direction.getNumericType()), Float.valueOf(obj.percent)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setProportionalSaturation(float saturation) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setProportionalSaturationMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Float.valueOf(saturation)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final REImageFilter setSize(int width, int height) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = this.setSizeMethod;
            objM22215constructorimpl = Result.m22215constructorimpl(method != null ? method.invoke(this.instance, Integer.valueOf(width), Integer.valueOf(height)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        return this;
    }
}
