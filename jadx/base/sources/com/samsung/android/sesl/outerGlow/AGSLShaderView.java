package com.samsung.android.sesl.outerGlow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001d\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010,\u001a\u00020-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u000e\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0017J\u0018\u00108\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00109\u001a\u00020\bH\u0017J\b\u0010:\u001a\u00020\u0017H\u0016J\u0018\u0010;\u001a\u0004\u0018\u00010(2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00109\u001a\u00020\bJ\b\u0010<\u001a\u000205H\u0015J\b\u0010=\u001a\u000205H\u0014J\u0010\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020@H\u0015J0\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0015J\b\u0010G\u001a\u000205H\u0016J\b\u0010H\u001a\u000205H\u0017J(\u0010I\u001a\u0002052\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0015J\u0010\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020(H\u0007J\b\u0010P\u001a\u00020\u0017H\u0017J\b\u0010Q\u001a\u00020\u0017H\u0016J\u000e\u0010R\u001a\u0002052\u0006\u0010\n\u001a\u00020\u0017J\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020-H\u0007J\u0010\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u000205H\u0017J\u0010\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u00020-H\u0017J\u0010\u0010Z\u001a\u0002052\u0006\u0010Y\u001a\u00020-H\u0017J\b\u0010[\u001a\u000205H\u0016J\b\u0010\\\u001a\u000205H\u0016J\b\u0010]\u001a\u000205H\u0016J\b\u0010^\u001a\u000205H\u0017J\u0010\u0010_\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR0\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020 0\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R#\u0010&\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u001f0'8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006`"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/AGSLShaderView;", "Landroid/view/View;", "Lcom/samsung/android/sesl/outerGlow/IAGSLShaderView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "iSlowdownAnimationProgress", "getISlowdownAnimationProgress", "()F", "setISlowdownAnimationProgress", "(F)V", "iStartAnimationProgress", "getIStartAnimationProgress", "setIStartAnimationProgress", "iTime", "getITime", "setITime", "", "isUpdateRunnableWorking", "()Z", "setUpdateRunnableWorking", "(Z)V", "shaderBase", "com/samsung/android/sesl/outerGlow/AGSLShaderView$shaderBase$1", "Lcom/samsung/android/sesl/outerGlow/AGSLShaderView$shaderBase$1;", "", "Lcom/samsung/android/sesl/outerGlow/LayerShaderPair;", "shaderList", "getShaderList", "()Ljava/util/List;", "setShaderList", "(Ljava/util/List;)V", "uniformKeyList", "", "", "", "getUniformKeyList", "()Ljava/util/Map;", "getFrameRate", "", "getRuntimeShader", "Landroid/graphics/RuntimeShader;", "getRuntimeShaderList", "getShaders", "", "Lcom/samsung/android/sesl/outerGlow/ShaderLayer;", "initWithCanvasData", "", "canvasData", "Lcom/samsung/android/sesl/outerGlow/CanvasLayer;", "initWithRaw", "resourceId", "isStopAnimation", "loadJSONFromRaw", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "parseCanvasData", "jsonString", "requestInvalidate", "resetDrawStatus", "setAutoStartAnimation", "setFrameRate", "fps", "setLifecycleOwner", "owner", "Landroidx/lifecycle/LifecycleOwner;", "startInitAnimation", XmlErrorCodes.DURATION, "startSlowDownAnimation", "startUpdateRunnable", "startWithClear", "stopUpdateRunnable", "stopWithClear", "updateITime", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class AGSLShaderView extends View implements IAGSLShaderView {

    @NotNull
    private final AGSLShaderView$shaderBase$1 shaderBase;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AGSLShaderView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public long getFrameRate() {
        return getFrameRate();
    }

    public final float getISlowdownAnimationProgress() {
        return getISlowdownAnimationProgress();
    }

    public final float getIStartAnimationProgress() {
        return getIStartAnimationProgress();
    }

    public final float getITime() {
        return getITime();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @Nullable
    public RuntimeShader getRuntimeShader() {
        return getRuntimeShader();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @NotNull
    public List<LayerShaderPair> getRuntimeShaderList() {
        return getRuntimeShaderList();
    }

    @NotNull
    public final List<LayerShaderPair> getShaderList() {
        return getShaderList();
    }

    @Nullable
    public final List<ShaderLayer> getShaders() {
        return getShaders();
    }

    @NotNull
    public final Map<String, List<Object>> getUniformKeyList() {
        return getUniformKeyList();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(35)
    public void initWithCanvasData(@Nullable CanvasLayer canvasData) {
        initWithCanvasData(canvasData);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(35)
    public void initWithRaw(@NotNull Context context, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        initWithRaw(context, resourceId);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public boolean isStopAnimation() {
        return isStopAnimation();
    }

    public final boolean isUpdateRunnableWorking() {
        return getIsUpdateRunnableWorking();
    }

    @Nullable
    public final String loadJSONFromRaw(@NotNull Context context, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return loadJSONFromRaw(context, resourceId);
    }

    @Override // android.view.View
    @RequiresApi(31)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    @RequiresApi(35)
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        applyShaderEffect(canvas, getWidth(), getHeight());
    }

    @Override // android.view.View
    @RequiresApi(31)
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        onLayout(changed, left, top, right, bottom);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public void onPause() {
        onPause();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(31)
    public void onResume() {
        onResume();
    }

    @Override // android.view.View
    @RequiresApi(31)
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onSizeChanged(w, h, oldw, oldh);
    }

    @RequiresApi(35)
    public final void parseCanvasData(@NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        parseCanvasData(jsonString);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(31)
    public boolean requestInvalidate() {
        return requestInvalidate();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public boolean resetDrawStatus() {
        return resetDrawStatus();
    }

    public final void setAutoStartAnimation(boolean value) {
        setAutoStartAnimation(value);
    }

    @RequiresApi(31)
    public final void setFrameRate(long fps) {
        setFrameRate(fps);
    }

    public final void setISlowdownAnimationProgress(float f) {
        setISlowdownAnimationProgress(f);
    }

    public final void setIStartAnimationProgress(float f) {
        setIStartAnimationProgress(f);
    }

    public final void setITime(float f) {
        setITime(f);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public void setLifecycleOwner(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        setLifecycleOwner(owner);
    }

    public final void setShaderList(@NotNull List<LayerShaderPair> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setShaderList(value);
    }

    public final void setUpdateRunnableWorking(boolean z) {
        setUpdateRunnableWorking(z);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(31)
    public void startInitAnimation() {
        startInitAnimation();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(31)
    public void startSlowDownAnimation(long duration) {
        startSlowDownAnimation(duration);
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public void startUpdateRunnable() {
        startUpdateRunnable();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public void startWithClear() {
        startWithClear();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public void stopUpdateRunnable() {
        stopUpdateRunnable();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(31)
    public void stopWithClear() {
        stopWithClear();
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    public void updateITime(float iTime) {
        updateITime(iTime);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AGSLShaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.samsung.android.sesl.outerGlow.IAGSLShaderView
    @RequiresApi(31)
    public void startInitAnimation(long duration) {
        startInitAnimation(duration);
    }

    public /* synthetic */ AGSLShaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.samsung.android.sesl.outerGlow.AGSLShaderView$shaderBase$1] */
    @JvmOverloads
    public AGSLShaderView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shaderBase = new AGSLShaderBase(context) { // from class: com.samsung.android.sesl.outerGlow.AGSLShaderView$shaderBase$1
            @Override // com.samsung.android.sesl.outerGlow.AGSLShaderBase
            public boolean canDrawCheck() {
                return !getShaderList().isEmpty();
            }

            @Override // com.samsung.android.sesl.outerGlow.AGSLShaderBase
            @NotNull
            public View getView() {
                return this;
            }
        };
        setWillNotDraw(false);
        setBackgroundColor(0);
    }
}
