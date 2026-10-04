package com.samsung.android.sesl.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.sesl.REImageFilter;
import com.samsung.android.sesl.widget.filters.Shaders;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001'\b\u0007\u0018\u00002\u00020\u0001:\u0001DB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ \u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0002J \u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0018H\u0002J\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0015J(\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0010\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020\u000eH\u0016J\u000e\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020\u000eJ\u0014\u0010=\u001a\u0002002\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010?\u001a\u0002002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\u000eJ\b\u0010B\u001a\u000200H\u0002J\b\u0010C\u001a\u000200H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/sesl/widget/TurbulentView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "MAXCIRCLENUM", SearchConstants.TargetContents.TAG, "", "blurRadius", "", "circles", "", "Lcom/samsung/android/sesl/widget/TurbulentView$CircleData;", "colors", "", "declareCode", "dirty", "", "frameRate", "", "handler", "Landroid/os/Handler;", "isRunning", "mainShaderCode", "positions", "radii", "reImageFilter", "Lcom/samsung/android/sesl/REImageFilter;", "runtimeShader", "Landroid/graphics/RuntimeShader;", "shaderCode", "speedFactor", "startTime", "timerRunnable", "com/samsung/android/sesl/widget/TurbulentView$timerRunnable$1", "Lcom/samsung/android/sesl/widget/TurbulentView$timerRunnable$1;", "uEdgeWidth", "warping", "clamp", "value", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "clear", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setAlpha", "alpha", "setBlurRadius", "radius", "setCircles", "circleList", "setFrameRate", "setSpeedFactor", "speed", Constants.ARG_UPDATE, "updateShaderUniforms", "CircleData", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTurbulentView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TurbulentView.kt\ncom/samsung/android/sesl/widget/TurbulentView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1864#2,3:231\n*S KotlinDebug\n*F\n+ 1 TurbulentView.kt\ncom/samsung/android/sesl/widget/TurbulentView\n*L\n177#1:231,3\n*E\n"})
public final class TurbulentView extends View {
    private final int MAXCIRCLENUM;

    @NotNull
    private final String TAG;
    private float blurRadius;

    @NotNull
    private List<CircleData> circles;

    @NotNull
    private float[] colors;

    @NotNull
    private final String declareCode;
    private boolean dirty;
    private long frameRate;

    @NotNull
    private final Handler handler;
    private boolean isRunning;

    @NotNull
    private final String mainShaderCode;

    @NotNull
    private float[] positions;

    @NotNull
    private float[] radii;

    @NotNull
    private final REImageFilter reImageFilter;

    @NotNull
    private final RuntimeShader runtimeShader;

    @NotNull
    private final String shaderCode;
    private float speedFactor;
    private long startTime;

    @NotNull
    private final TurbulentView$timerRunnable$1 timerRunnable;
    private float uEdgeWidth;

    @NotNull
    private float[] warping;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sesl/widget/TurbulentView$CircleData;", "", "x", "", "y", "radius", "color", "", "warping", "(FFF[FF)V", "getColor", "()[F", "getRadius", "()F", "getWarping", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class CircleData {

        @NotNull
        private final float[] color;
        private final float radius;
        private final float warping;
        private final float x;
        private final float y;

        public CircleData(float f, float f4, float f5, @NotNull float[] color, float f6) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.x = f;
            this.y = f4;
            this.radius = f5;
            this.color = color;
            this.warping = f6;
        }

        public static /* synthetic */ CircleData copy$default(CircleData circleData, float f, float f4, float f5, float[] fArr, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = circleData.x;
            }
            if ((i & 2) != 0) {
                f4 = circleData.y;
            }
            if ((i & 4) != 0) {
                f5 = circleData.radius;
            }
            if ((i & 8) != 0) {
                fArr = circleData.color;
            }
            if ((i & 16) != 0) {
                f6 = circleData.warping;
            }
            float f7 = f6;
            float f8 = f5;
            return circleData.copy(f, f4, f8, fArr, f7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float[] getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getWarping() {
            return this.warping;
        }

        @NotNull
        public final CircleData copy(float x, float y2, float radius, @NotNull float[] color, float warping) {
            Intrinsics.checkNotNullParameter(color, "color");
            return new CircleData(x, y2, radius, color, warping);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CircleData)) {
                return false;
            }
            CircleData circleData = (CircleData) other;
            return Float.compare(this.x, circleData.x) == 0 && Float.compare(this.y, circleData.y) == 0 && Float.compare(this.radius, circleData.radius) == 0 && Intrinsics.areEqual(this.color, circleData.color) && Float.compare(this.warping, circleData.warping) == 0;
        }

        @NotNull
        public final float[] getColor() {
            return this.color;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final float getWarping() {
            return this.warping;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.warping) + ((Arrays.hashCode(this.color) + AbstractC0622a.m1156b(this.radius, AbstractC0622a.m1156b(this.y, Float.hashCode(this.x) * 31, 31), 31)) * 31);
        }

        @NotNull
        public String toString() {
            float f = this.x;
            float f4 = this.y;
            float f5 = this.radius;
            String string = Arrays.toString(this.color);
            float f6 = this.warping;
            StringBuilder sbM1176v = AbstractC0622a.m1176v("CircleData(x=", f, ", y=", f4, ", radius=");
            sbM1176v.append(f5);
            sbM1176v.append(", color=");
            sbM1176v.append(string);
            sbM1176v.append(", warping=");
            return AbstractC1038a.m1217r(sbM1176v, ")", f6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.samsung.android.sesl.widget.TurbulentView$timerRunnable$1] */
    public TurbulentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MAXCIRCLENUM = 5;
        this.circles = CollectionsKt.emptyList();
        this.uEdgeWidth = 0.001f;
        this.blurRadius = 500.0f;
        this.speedFactor = 5.0f;
        this.frameRate = 60L;
        this.positions = new float[10];
        this.radii = new float[5];
        this.colors = new float[20];
        this.warping = new float[5];
        this.reImageFilter = new REImageFilter();
        this.handler = new Handler(Looper.getMainLooper());
        this.TAG = "TurbulentView";
        String strTrimIndent = StringsKt.trimIndent("\n        uniform float2 uResolution;\n        uniform float uTime;\n        uniform float uEdgeWidth;\n        uniform float uColorAlpha;\n        uniform int uCircleCount;\n        uniform float2 uPositions[5];\n        uniform float uRadii[5];\n        uniform float4 uColors[5];\n        uniform float uWarping[5];\n    ");
        this.declareCode = strTrimIndent;
        String strTrimIndent2 = StringsKt.trimIndent("\n        vec4 main(vec2 fragCoord) {\n            vec2 st = fragCoord.xy / uResolution;\n            st -= 0.5;\n            float aspectRatioX = uResolution.x / uResolution.y;            \n            float aspectRatio = aspectRatioX;         \n            st.x *= aspectRatio;\n            \n            vec4 color = vec4(0.0);\n            float circleSet = 0.0;\n            for(int i = 0; i < 5; i++) {\n                if(i >= uCircleCount) break;\n                vec2 warpedSt = warp(st, uWarping[i]);\n                vec2 center = uPositions[i];\n                float radius = uRadii[i];   \n\n                center.x *= aspectRatio;                \n                float dist = length(warpedSt - center);\n                float circle = smoothstep(radius + uEdgeWidth, radius - uEdgeWidth, dist);\n                circleSet += circle;\n                float alpha = circle * uColors[i].a;\n                color.rgb = mix(color.rgb, uColors[i].rgb, alpha);\n            }\n            color.a = uColorAlpha * clamp(0.0, 1.0, circleSet);            \n            return color;\n        }\n    ");
        this.mainShaderCode = strTrimIndent2;
        Shaders.Companion companion = Shaders.INSTANCE;
        String n31Code = companion.getN31Code();
        String warpingCode = companion.getWarpingCode();
        StringBuilder sbM16m = AbstractC0000a.m16m("\n        ", strTrimIndent, "\n        ", n31Code, "\n        ");
        sbM16m.append(warpingCode);
        sbM16m.append("\n        ");
        sbM16m.append(strTrimIndent2);
        sbM16m.append("\n    ");
        String strTrimIndent3 = StringsKt.trimIndent(sbM16m.toString());
        this.shaderCode = strTrimIndent3;
        AbstractC7011a.m5287q();
        this.runtimeShader = AbstractC7011a.m5275e(strTrimIndent3);
        this.startTime = System.currentTimeMillis();
        this.timerRunnable = new Runnable() { // from class: com.samsung.android.sesl.widget.TurbulentView$timerRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.frameRate <= 0) {
                    this.this$0.isRunning = false;
                    return;
                }
                this.this$0.isRunning = true;
                this.this$0.handler.postDelayed(this, ((long) 1000) / this.this$0.frameRate);
                this.this$0.invalidate();
            }
        };
        post(new RunnableC7599e(this, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(TurbulentView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reImageFilter.setBlurRadius(this$0.blurRadius);
        this$0.runtimeShader.setFloatUniform("uResolution", this$0.getWidth(), this$0.getHeight());
        this$0.runtimeShader.setFloatUniform("uColorAlpha", 0.8f);
        this$0.updateShaderUniforms();
        this$0.handler.post(this$0.timerRunnable);
    }

    private final float clamp(float value, float min, float max) {
        return Math.min(Math.max(value, min), max);
    }

    private final void update() {
        setRenderEffect(this.reImageFilter.build(getWidth(), getHeight()));
        invalidate();
    }

    private final void updateShaderUniforms() {
        this.runtimeShader.setIntUniform("uCircleCount", this.circles.size());
        int i = 0;
        for (Object obj : this.circles) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CircleData circleData = (CircleData) obj;
            int i4 = i * 2;
            this.positions[i4] = circleData.getX();
            this.positions[i4 + 1] = circleData.getY();
            this.radii[i] = clamp(circleData.getRadius(), 0.0f, 1.0f);
            this.warping[i] = clamp(circleData.getWarping() / 2.0f, 0.0f, 0.5f);
            int i5 = i * 4;
            this.colors[i5] = circleData.getColor()[0];
            this.colors[i5 + 1] = circleData.getColor()[1];
            this.colors[i5 + 2] = circleData.getColor()[2];
            this.colors[i5 + 3] = circleData.getColor()[3];
            i = i2;
        }
        this.runtimeShader.setFloatUniform("uPositions", this.positions);
        this.runtimeShader.setFloatUniform("uRadii", this.radii);
        this.runtimeShader.setFloatUniform("uColors", this.colors);
        this.runtimeShader.setFloatUniform("uWarping", this.warping);
        this.runtimeShader.setFloatUniform("uEdgeWidth", this.uEdgeWidth);
    }

    public final void clear() {
        this.uEdgeWidth = 0.001f;
        this.blurRadius = 500.0f;
        this.speedFactor = 5.0f;
        this.frameRate = 0L;
        this.circles = CollectionsKt.emptyList();
        int i = this.MAXCIRCLENUM;
        this.positions = new float[i * 2];
        this.radii = new float[i];
        this.colors = new float[i * 4];
        this.warping = new float[i];
        this.dirty = true;
        update();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.dirty) {
            canvas.drawColor(0);
            this.dirty = false;
            return;
        }
        this.runtimeShader.setFloatUniform("uTime", ((System.currentTimeMillis() - this.startTime) / 1000.0f) * this.speedFactor);
        Paint paint = new Paint();
        paint.setShader(this.runtimeShader);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.runtimeShader.setFloatUniform("uResolution", getWidth(), getHeight());
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        this.runtimeShader.setFloatUniform("uColorAlpha", alpha);
        update();
    }

    public final void setBlurRadius(float radius) {
        this.reImageFilter.setBlurRadius(radius);
        update();
    }

    public final void setCircles(@NotNull List<CircleData> circleList) {
        Intrinsics.checkNotNullParameter(circleList, "circleList");
        this.circles = circleList;
        updateShaderUniforms();
        update();
    }

    public final void setFrameRate(long frameRate) {
        this.frameRate = clamp(frameRate, 0L, 120L);
        if (!this.isRunning) {
            this.handler.post(this.timerRunnable);
        }
        update();
    }

    public final void setSpeedFactor(float speed) {
        this.speedFactor = speed;
        update();
    }

    private final long clamp(long value, long min, long max) {
        return Math.min(Math.max(value, min), max);
    }

    public /* synthetic */ TurbulentView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TurbulentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
