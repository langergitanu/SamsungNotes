package com.samsung.android.sesl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import com.samsung.android.graphics.SemGfxImageFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0018\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B?\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0018\u0010<\u001a\u00020:2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0005H\u0002J\b\u0010D\u001a\u00020:H\u0002J\b\u0010E\u001a\u00020:H\u0002J\u0010\u0010F\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0005H\u0002J\u0010\u0010G\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0005H\u0002J\u0010\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020JH\u0014J\u0016\u0010K\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tJ\u001e\u0010M\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tJ\u0016\u0010P\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tJ\u0016\u0010Q\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010R\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tJ\u0016\u0010S\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tJ\u0016\u0010T\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tJ\u0010\u0010U\u001a\u00020:2\u0006\u0010L\u001a\u00020\u0005H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR8\u0010\u001f\u001a*\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e\u0018\u0001  *\u0014\u0012\u000e\b\u0001\u0012\n  *\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u0010\u00103\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001d¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/sesl/MeshGradientView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "w", "", "h", "pos", "", "Landroid/graphics/PointF;", "col", "", "(Landroid/content/Context;II[Landroid/graphics/PointF;[I)V", "applyMeshGradientMethod", "Ljava/lang/reflect/Method;", "applyToBitmapMethod", "colors", "getColors", "()[I", "setColors", "([I)V", "imageFilter", "", "imageFilterClass", "Ljava/lang/Class;", "leadingControlPoints", "getLeadingControlPoints", "()[Landroid/graphics/PointF;", "setLeadingControlPoints", "([Landroid/graphics/PointF;)V", "[Landroid/graphics/PointF;", "methods", "kotlin.jvm.PlatformType", "[Ljava/lang/reflect/Method;", "numHeightPoints", "numWidthPoints", "pointColorUpdated", "", "getPointColorUpdated", "()[Z", "setPointColorUpdated", "([Z)V", "pointHandleUpdated", "getPointHandleUpdated", "setPointHandleUpdated", "pointPositionUpdated", "getPointPositionUpdated", "setPointPositionUpdated", "positions", "getPositions", "setPositions", "setIndexedColorMethod", "setIndexedMeshHandlesMethod", "setIndexedPointMethod", "topControlPoints", "getTopControlPoints", "setTopControlPoints", "checkIndexBounds", "", "index", "checkInitBounds", "findMethod", "name", "", "getBitmap", "Landroid/graphics/Bitmap;", "initControlPoints", "numPoints", "initGfxImageFilterMethods", "initNativeMeshGradient", "initNormalPositions", "initRandomColors", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setBottomControlPointPos", "idx", "setHandlesPos", "leftPos", "upPos", "setLeadingControlPointPos", "setPointColor", "setPointPos", "setTailingControlPointPos", "setTopContolPointPos", "updateNativePoint", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMeshGradientView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeshGradientView.kt\ncom/samsung/android/sesl/MeshGradientView\n+ 2 Point.kt\nandroidx/core/graphics/PointKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,279:1\n167#2:280\n154#2:282\n154#2:283\n167#2:284\n1#3:281\n*S KotlinDebug\n*F\n+ 1 MeshGradientView.kt\ncom/samsung/android/sesl/MeshGradientView\n*L\n138#1:280\n222#1:282\n238#1:283\n266#1:284\n*E\n"})
public final class MeshGradientView extends View {

    @Nullable
    private Method applyMeshGradientMethod;

    @Nullable
    private Method applyToBitmapMethod;
    public int[] colors;

    @Nullable
    private final Object imageFilter;

    @Nullable
    private final Class<?> imageFilterClass;
    public PointF[] leadingControlPoints;

    @Nullable
    private final Method[] methods;
    private int numHeightPoints;
    private int numWidthPoints;
    public boolean[] pointColorUpdated;
    public boolean[] pointHandleUpdated;
    public boolean[] pointPositionUpdated;
    public PointF[] positions;

    @Nullable
    private Method setIndexedColorMethod;

    @Nullable
    private Method setIndexedMeshHandlesMethod;

    @Nullable
    private Method setIndexedPointMethod;
    public PointF[] topControlPoints;

    public MeshGradientView(@Nullable Context context, int i, int i2, @Nullable PointF[] pointFArr, @Nullable int[] iArr) throws Exception {
        Object objM22215constructorimpl;
        Object objNewInstance;
        super(context);
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Class.forName("com.samsung.android.graphics.SemGfxImageFilter"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Class<?> cls = (Class) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
        this.imageFilterClass = cls;
        if (cls != null) {
            try {
                objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                Log.e("MeshGradientView", "Failed to create Instance for SemGfxImageFilter", e);
                throw e;
            }
        } else {
            objNewInstance = null;
        }
        this.imageFilter = objNewInstance;
        this.methods = cls != null ? cls.getDeclaredMethods() : null;
        initGfxImageFilterMethods();
        try {
            Method declaredMethod = View.class.getDeclaredMethod("semSetGfxImageFilter", SemGfxImageFilter.class);
            Intrinsics.checkNotNull(declaredMethod);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, objNewInstance);
            checkInitBounds(i, i2);
            this.numWidthPoints = i;
            this.numHeightPoints = i2;
            int i4 = i * i2;
            if (pointFArr == null) {
                initNormalPositions(i4);
            } else {
                if (pointFArr.length != i4) {
                    throw new IllegalArgumentException("The size of 'pos' array must be equal to the number of points (w * h).");
                }
                setPositions((PointF[]) pointFArr.clone());
            }
            if (iArr == null) {
                initRandomColors(i4);
            } else {
                if (iArr.length != i4) {
                    throw new IllegalArgumentException("The size of 'col' array must be equal to the number of points (w * h).");
                }
                setColors((int[]) iArr.clone());
            }
            initControlPoints(i4);
            initNativeMeshGradient();
            boolean[] zArr = new boolean[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                zArr[i5] = false;
            }
            setPointPositionUpdated(zArr);
            boolean[] zArr2 = new boolean[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                zArr2[i6] = false;
            }
            setPointColorUpdated(zArr2);
            boolean[] zArr3 = new boolean[i4];
            for (int i7 = 0; i7 < i4; i7++) {
                zArr3[i7] = false;
            }
            setPointHandleUpdated(zArr3);
        } catch (Exception e2) {
            Log.e("MeshGradientView", "Failed to call semSetGfxImageFilter using reflection", e2);
            throw e2;
        }
    }

    private final void checkIndexBounds(int index) {
        if (index < 0 || index >= this.numWidthPoints * this.numHeightPoints) {
            throw new IllegalArgumentException("The index must be between 0 and (w * h)- 1.");
        }
    }

    private final void checkInitBounds(int w, int h) {
        if (w < 2 || w > 6 || h < 2 || h > 6) {
            throw new IllegalArgumentException("The width and height must be between [2 , 6].");
        }
    }

    private final Method findMethod(String name) {
        Method[] methodArr = this.methods;
        Method method = null;
        if (methodArr != null) {
            int length = methodArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method2 = methodArr[i];
                if (Intrinsics.areEqual(method2.getName(), name)) {
                    method = method2;
                    break;
                }
                i++;
            }
        }
        if (method != null) {
            method.setAccessible(true);
            return method;
        }
        Log.w("MeshGradientView", name + " method not found");
        return method;
    }

    private final void initControlPoints(int numPoints) {
        PointF[] pointFArr = new PointF[numPoints];
        for (int i = 0; i < numPoints; i++) {
            pointFArr[i] = new PointF(0.0f, (-1.0f) / ((this.numHeightPoints - 1) * 3.0f));
        }
        setTopControlPoints(pointFArr);
        PointF[] pointFArr2 = new PointF[numPoints];
        for (int i2 = 0; i2 < numPoints; i2++) {
            pointFArr2[i2] = new PointF((-1.0f) / ((this.numWidthPoints - 1) * 3.0f), 0.0f);
        }
        setLeadingControlPoints(pointFArr2);
    }

    private final void initGfxImageFilterMethods() {
        this.applyMeshGradientMethod = findMethod("applyMeshGradient");
        this.setIndexedPointMethod = findMethod("setIndexedPoint");
        this.setIndexedColorMethod = findMethod("setIndexedColor");
        this.setIndexedMeshHandlesMethod = findMethod("setIndexedMeshHandles");
        this.applyToBitmapMethod = findMethod("applyToBitmap");
    }

    private final void initNativeMeshGradient() throws IllegalAccessException, InvocationTargetException {
        Method method = this.applyMeshGradientMethod;
        if (method != null) {
            method.invoke(this.imageFilter, Integer.valueOf(this.numWidthPoints), Integer.valueOf(this.numHeightPoints), getColors(), ArraysKt___ArraysKt.toCollection(getPositions(), new ArrayList()));
        }
        int i = this.numWidthPoints * this.numHeightPoints;
        for (int i2 = 0; i2 < i; i2++) {
            Method method2 = this.setIndexedMeshHandlesMethod;
            Intrinsics.checkNotNull(method2);
            Object obj = this.imageFilter;
            Integer numValueOf = Integer.valueOf(i2);
            PointF pointF = getTopControlPoints()[i2];
            PointF pointF2 = new PointF(pointF.x * 2.0f, pointF.y * 2.0f);
            PointF pointF3 = getLeadingControlPoints()[i2];
            method2.invoke(obj, numValueOf, pointF2, new PointF(pointF3.x * 2.0f, pointF3.y * 2.0f));
        }
    }

    private final void initNormalPositions(int numPoints) {
        float f = 1.0f / (this.numWidthPoints - 1);
        float f4 = 1.0f / (this.numHeightPoints - 1);
        PointF[] pointFArr = new PointF[numPoints];
        for (int i = 0; i < numPoints; i++) {
            int i2 = this.numWidthPoints;
            pointFArr[i] = new PointF((i % i2) * f, (i / i2) * f4);
        }
        setPositions(pointFArr);
    }

    private final void initRandomColors(int numPoints) {
        int[] iArr = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            Random random = new Random();
            iArr[i] = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
        setColors(iArr);
    }

    private final void updateNativePoint(int idx) throws IllegalAccessException, InvocationTargetException {
        if (getPointPositionUpdated()[idx]) {
            Method method = this.setIndexedPointMethod;
            if (method != null) {
                method.invoke(this.imageFilter, Integer.valueOf(idx), getPositions()[idx]);
            }
            getPointPositionUpdated()[idx] = false;
        }
        if (getPointColorUpdated()[idx]) {
            Method method2 = this.setIndexedColorMethod;
            if (method2 != null) {
                method2.invoke(this.imageFilter, Integer.valueOf(idx), Integer.valueOf(getColors()[idx]));
            }
            getPointColorUpdated()[idx] = false;
        }
        if (getPointHandleUpdated()[idx]) {
            Method method3 = this.setIndexedMeshHandlesMethod;
            Intrinsics.checkNotNull(method3);
            Object obj = this.imageFilter;
            Integer numValueOf = Integer.valueOf(idx);
            PointF pointF = getTopControlPoints()[idx];
            PointF pointF2 = new PointF(pointF.x * 2.0f, pointF.y * 2.0f);
            PointF pointF3 = getLeadingControlPoints()[idx];
            method3.invoke(obj, numValueOf, pointF2, new PointF(pointF3.x * 2.0f, pointF3.y * 2.0f));
            getPointHandleUpdated()[idx] = false;
        }
    }

    @NotNull
    public final Bitmap getBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Method method = this.applyToBitmapMethod;
        Object objInvoke = method != null ? method.invoke(this.imageFilter, bitmapCreateBitmap) : null;
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Bitmap");
        return (Bitmap) objInvoke;
    }

    @NotNull
    public final int[] getColors() {
        int[] iArr = this.colors;
        if (iArr != null) {
            return iArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("colors");
        return null;
    }

    @NotNull
    public final PointF[] getLeadingControlPoints() {
        PointF[] pointFArr = this.leadingControlPoints;
        if (pointFArr != null) {
            return pointFArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("leadingControlPoints");
        return null;
    }

    @NotNull
    public final boolean[] getPointColorUpdated() {
        boolean[] zArr = this.pointColorUpdated;
        if (zArr != null) {
            return zArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pointColorUpdated");
        return null;
    }

    @NotNull
    public final boolean[] getPointHandleUpdated() {
        boolean[] zArr = this.pointHandleUpdated;
        if (zArr != null) {
            return zArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pointHandleUpdated");
        return null;
    }

    @NotNull
    public final boolean[] getPointPositionUpdated() {
        boolean[] zArr = this.pointPositionUpdated;
        if (zArr != null) {
            return zArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pointPositionUpdated");
        return null;
    }

    @NotNull
    public final PointF[] getPositions() {
        PointF[] pointFArr = this.positions;
        if (pointFArr != null) {
            return pointFArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positions");
        return null;
    }

    @NotNull
    public final PointF[] getTopControlPoints() {
        PointF[] pointFArr = this.topControlPoints;
        if (pointFArr != null) {
            return pointFArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topControlPoints");
        return null;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i = this.numWidthPoints * this.numHeightPoints;
        for (int i2 = 0; i2 < i; i2++) {
            updateNativePoint(i2);
        }
        super.onDraw(canvas);
    }

    public final void setBottomControlPointPos(int idx, @NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        checkIndexBounds(idx);
        PointF pointF = getLeadingControlPoints()[idx];
        getTopControlPoints()[idx] = new PointF(-pos.x, -pos.y);
        getPointHandleUpdated()[idx] = true;
    }

    public final void setColors(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.colors = iArr;
    }

    public final void setHandlesPos(int idx, @NotNull PointF leftPos, @NotNull PointF upPos) {
        Intrinsics.checkNotNullParameter(leftPos, "leftPos");
        Intrinsics.checkNotNullParameter(upPos, "upPos");
        checkIndexBounds(idx);
        getTopControlPoints()[idx] = upPos;
        getLeadingControlPoints()[idx] = leftPos;
        getPointHandleUpdated()[idx] = true;
    }

    public final void setLeadingControlPointPos(int idx, @NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        checkIndexBounds(idx);
        PointF pointF = getTopControlPoints()[idx];
        getLeadingControlPoints()[idx] = pos;
        getPointHandleUpdated()[idx] = true;
    }

    public final void setLeadingControlPoints(@NotNull PointF[] pointFArr) {
        Intrinsics.checkNotNullParameter(pointFArr, "<set-?>");
        this.leadingControlPoints = pointFArr;
    }

    public final void setPointColor(int idx, int col) {
        checkIndexBounds(idx);
        getColors()[idx] = col;
        getPointColorUpdated()[idx] = true;
    }

    public final void setPointColorUpdated(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<set-?>");
        this.pointColorUpdated = zArr;
    }

    public final void setPointHandleUpdated(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<set-?>");
        this.pointHandleUpdated = zArr;
    }

    public final void setPointPos(int idx, @NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        checkIndexBounds(idx);
        getPositions()[idx] = pos;
        getPointPositionUpdated()[idx] = true;
    }

    public final void setPointPositionUpdated(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<set-?>");
        this.pointPositionUpdated = zArr;
    }

    public final void setPositions(@NotNull PointF[] pointFArr) {
        Intrinsics.checkNotNullParameter(pointFArr, "<set-?>");
        this.positions = pointFArr;
    }

    public final void setTailingControlPointPos(int idx, @NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        checkIndexBounds(idx);
        PointF pointF = getTopControlPoints()[idx];
        getLeadingControlPoints()[idx] = new PointF(-pos.x, -pos.y);
        getPointHandleUpdated()[idx] = true;
    }

    public final void setTopContolPointPos(int idx, @NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        checkIndexBounds(idx);
        PointF pointF = getLeadingControlPoints()[idx];
        getTopControlPoints()[idx] = pos;
        getPointHandleUpdated()[idx] = true;
    }

    public final void setTopControlPoints(@NotNull PointF[] pointFArr) {
        Intrinsics.checkNotNullParameter(pointFArr, "<set-?>");
        this.topControlPoints = pointFArr;
    }

    public /* synthetic */ MeshGradientView(Context context, int i, int i2, PointF[] pointFArr, int[] iArr, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, i2, (i4 & 8) != 0 ? null : pointFArr, (i4 & 16) != 0 ? null : iArr);
    }
}
