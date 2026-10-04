package com.samsung.android.sesl.outerGlow;

import android.content.Context;
import android.graphics.RuntimeShader;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0013H&J\b\u0010\u0017\u001a\u00020\u0013H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\nH&J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\nH&J\b\u0010\u001f\u001a\u00020\nH&J\b\u0010 \u001a\u00020\nH&J\b\u0010!\u001a\u00020\nH&J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H&¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/IAGSLShaderView;", "", "getFrameRate", "", "getRuntimeShader", "Landroid/graphics/RuntimeShader;", "getRuntimeShaderList", "", "Lcom/samsung/android/sesl/outerGlow/LayerShaderPair;", "initWithCanvasData", "", "canvasData", "Lcom/samsung/android/sesl/outerGlow/CanvasLayer;", "initWithRaw", "context", "Landroid/content/Context;", "resourceId", "", "isStopAnimation", "", "onPause", "onResume", "requestInvalidate", "resetDrawStatus", "setLifecycleOwner", "owner", "Landroidx/lifecycle/LifecycleOwner;", "startInitAnimation", XmlErrorCodes.DURATION, "startSlowDownAnimation", "startUpdateRunnable", "startWithClear", "stopUpdateRunnable", "stopWithClear", "updateITime", "iTime", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public interface IAGSLShaderView {
    long getFrameRate();

    @Nullable
    RuntimeShader getRuntimeShader();

    @NotNull
    List<LayerShaderPair> getRuntimeShaderList();

    void initWithCanvasData(@Nullable CanvasLayer canvasData);

    void initWithRaw(@NotNull Context context, int resourceId);

    boolean isStopAnimation();

    void onPause();

    void onResume();

    boolean requestInvalidate();

    boolean resetDrawStatus();

    void setLifecycleOwner(@NotNull LifecycleOwner owner);

    void startInitAnimation();

    void startInitAnimation(long duration);

    void startSlowDownAnimation(long duration);

    void startUpdateRunnable();

    void startWithClear();

    void stopUpdateRunnable();

    void stopWithClear();

    void updateITime(float iTime);
}
