package com.samsung.android.sesl.outerGlow;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.gson.Gson;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import com.samsung.android.app.sdk.deepsky.common.AbstractC7019f;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.p196io.TextStreamsKt;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b*\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020sH\u0007J\b\u0010u\u001a\u00020\u0006H$J\n\u0010v\u001a\u0004\u0018\u00010wH\u0007J\u001c\u0010x\u001a\u0004\u0018\u00010w2\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020|H\u0003J\u0006\u0010}\u001a\u00020\u0015J\b\u0010~\u001a\u0004\u0018\u00010zJ\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020Q0PJ\u0010\u0010\u0080\u0001\u001a\u000b\u0012\u0004\u0012\u00020|\u0018\u00010\u0081\u0001J\n\u0010\u0082\u0001\u001a\u00030\u0083\u0001H$J\t\u0010\u0084\u0001\u001a\u00020oH\u0005J\t\u0010\u0085\u0001\u001a\u00020oH\u0002J\u0013\u0010\u0086\u0001\u001a\u00020o2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0087\u0001\u001a\u00020o2\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0088\u0001\u001a\u00020sH\u0007J\u0007\u0010\u0089\u0001\u001a\u00020\u0006J\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0088\u0001\u001a\u00020sJ\t\u0010\u008b\u0001\u001a\u00020oH\u0007J\u0007\u0010\u008c\u0001\u001a\u00020oJ6\u0010\u008d\u0001\u001a\u00020o2\u0007\u0010\u008e\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020s2\u0007\u0010\u0090\u0001\u001a\u00020s2\u0007\u0010\u0091\u0001\u001a\u00020s2\u0007\u0010\u0092\u0001\u001a\u00020sH\u0007J\u0007\u0010\u0093\u0001\u001a\u00020oJ\u0012\u0010\u0093\u0001\u001a\u00020o2\u0007\u0010\u0094\u0001\u001a\u00020CH\u0016J\t\u0010\u0095\u0001\u001a\u00020oH\u0014J\t\u0010\u0096\u0001\u001a\u00020oH\u0007J\u0012\u0010\u0096\u0001\u001a\u00020o2\u0007\u0010\u0094\u0001\u001a\u00020CH\u0017J\t\u0010\u0097\u0001\u001a\u00020oH\u0014J-\u0010\u0098\u0001\u001a\u00020o2\u0007\u0010\u0099\u0001\u001a\u00020s2\u0007\u0010\u009a\u0001\u001a\u00020s2\u0007\u0010\u009b\u0001\u001a\u00020s2\u0007\u0010\u009c\u0001\u001a\u00020sH\u0007J\u0012\u0010\u009d\u0001\u001a\u00020o2\u0007\u0010\u009e\u0001\u001a\u00020!H\u0007J\t\u0010\u009f\u0001\u001a\u00020\u0006H\u0007J\u0007\u0010 \u0001\u001a\u00020\u0006J\u0012\u0010¡\u0001\u001a\u00020o2\u0007\u0010¢\u0001\u001a\u00020\u0015H\u0007J\u0010\u0010£\u0001\u001a\u00020o2\u0007\u0010\u0094\u0001\u001a\u00020CJ\t\u0010¤\u0001\u001a\u00020oH\u0007J\u0012\u0010¤\u0001\u001a\u00020o2\u0007\u0010¥\u0001\u001a\u00020\u0015H\u0007J\u0012\u0010¦\u0001\u001a\u00020o2\u0007\u0010¥\u0001\u001a\u00020\u0015H\u0007J\u0007\u0010§\u0001\u001a\u00020oJ\u0007\u0010¨\u0001\u001a\u00020oJ\u0007\u0010©\u0001\u001a\u00020oJ\t\u0010ª\u0001\u001a\u00020oH\u0007J\t\u0010«\u0001\u001a\u00020oH\u0007J\u000f\u0010¬\u0001\u001a\u00020o2\u0006\u00102\u001a\u00020*R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0006\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0006\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001a\u00102\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001a\u00105\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001a\u00108\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\b\"\u0004\b9\u0010\nR\u001a\u0010:\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\b\"\u0004\b;\u0010\nR\u001a\u0010<\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\u001a\u0010?\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010\nR\"\u0010I\u001a\u0004\u0018\u00010H2\b\u0010G\u001a\u0004\u0018\u00010H@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\b\"\u0004\bN\u0010\nR \u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR,\u0010b\u001a\u001a\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020d0c0cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010#R\u001a\u0010f\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\b\"\u0004\bh\u0010\nR#\u0010i\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0P0c¢\u0006\b\n\u0000\u001a\u0004\bj\u0010#R\u001c\u0010k\u001a\u0004\u0018\u00010WX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010Y\"\u0004\bm\u0010[¨\u0006\u00ad\u0001"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/AGSLShaderBase;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "autoStartAnimation", "", "getAutoStartAnimation", "()Z", "setAutoStartAnimation", "(Z)V", "canvasData", "Lcom/samsung/android/sesl/outerGlow/CanvasLayer;", "getCanvasData", "()Lcom/samsung/android/sesl/outerGlow/CanvasLayer;", "setCanvasData", "(Lcom/samsung/android/sesl/outerGlow/CanvasLayer;)V", "clearRenderEffect", "getClearRenderEffect", "setClearRenderEffect", "frameIntervalNanos", "", "getFrameIntervalNanos", "()J", "setFrameIntervalNanos", "(J)V", "frameRate", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "hasSlowdownAnimationUniform", "", "", "getHasSlowdownAnimationUniform", "()Ljava/util/Map;", "setHasSlowdownAnimationUniform", "(Ljava/util/Map;)V", "hasStartAnimationUniform", "getHasStartAnimationUniform", "setHasStartAnimationUniform", "iSlowdownAnimationProgress", "", "getISlowdownAnimationProgress", "()F", "setISlowdownAnimationProgress", "(F)V", "iStartAnimationProgress", "getIStartAnimationProgress", "setIStartAnimationProgress", "iTime", "getITime", "setITime", "initFrameTimeNanos", "getInitFrameTimeNanos", "setInitFrameTimeNanos", "isCanvasDraw", "setCanvasDraw", "isUpdateRunnableWorking", "setUpdateRunnableWorking", "lastFrameTimeNanos", "getLastFrameTimeNanos", "setLastFrameTimeNanos", "lastStopTime", "getLastStopTime", "setLastStopTime", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "needInitDraw", "getNeedInitDraw", "setNeedInitDraw", "<set-?>", "Landroid/graphics/Paint;", "paint", "getPaint", "()Landroid/graphics/Paint;", "readyDraw", "getReadyDraw", "setReadyDraw", "shaderList", "", "Lcom/samsung/android/sesl/outerGlow/LayerShaderPair;", "getShaderList", "()Ljava/util/List;", "setShaderList", "(Ljava/util/List;)V", "slowStopRunnable", "Ljava/lang/Runnable;", "getSlowStopRunnable", "()Ljava/lang/Runnable;", "setSlowStopRunnable", "(Ljava/lang/Runnable;)V", "startValueAnimator", "Landroid/animation/ValueAnimator;", "getStartValueAnimator", "()Landroid/animation/ValueAnimator;", "setStartValueAnimator", "(Landroid/animation/ValueAnimator;)V", "staticUniformMap", "", "", "getStaticUniformMap", "stopAnimation", "getStopAnimation", "setStopAnimation", "uniformKeyList", "getUniformKeyList", "updateRunnable", "getUpdateRunnable", "setUpdateRunnable", "applyShaderEffect", "", "canvas", "Landroid/graphics/Canvas;", "viewWidth", "", "viewHeight", "canDrawCheck", "createRenderEffect", "Landroid/graphics/RenderEffect;", "createRenderEffectForLayer", "shader", "Landroid/graphics/RuntimeShader;", "layer", "Lcom/samsung/android/sesl/outerGlow/ShaderLayer;", "getFrameRate", "getRuntimeShader", "getRuntimeShaderList", "getShaders", "", "getView", "Landroid/view/View;", "initShader", "initUpdateRunnable", "initWithCanvasData", "initWithRaw", "resourceId", "isStopAnimation", "loadJSONFromRaw", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onPause", "owner", "onResetForNewCanvas", "onResume", "onShaderCreated", "onSizeChanged", "w", "h", "oldw", "oldh", "parseCanvasData", "jsonString", "requestInvalidate", "resetDrawStatus", "setFrameRate", "fps", "setLifecycleOwner", "startInitAnimation", XmlErrorCodes.DURATION, "startSlowDownAnimation", "startUpdateRunnable", "startWithClear", "stopUpdateRunnable", "stopWithClear", "updateDynamicUniforms", "updateITime", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAGSLShaderBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AGSLShaderBase.kt\ncom/samsung/android/sesl/outerGlow/AGSLShaderBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,753:1\n1#2:754\n1#2:799\n1#2:812\n1#2:825\n1#2:838\n1#2:851\n1#2:864\n1#2:884\n91#3,14:755\n91#3,14:769\n1855#4:783\n1855#4,2:784\n1856#4:786\n1855#4:787\n1855#4:788\n1603#4,9:789\n1855#4:798\n1856#4:800\n1612#4:801\n1603#4,9:815\n1855#4:824\n1856#4:826\n1612#4:827\n1603#4,9:841\n1855#4:850\n1856#4:852\n1612#4:853\n1856#4:867\n1856#4:870\n1864#4,3:871\n1603#4,9:874\n1855#4:883\n1856#4:885\n1612#4:886\n2661#4,7:887\n11383#5,9:802\n13309#5:811\n13310#5:813\n11392#5:814\n11383#5,9:828\n13309#5:837\n13310#5:839\n11392#5:840\n11383#5,9:854\n13309#5:863\n13310#5:865\n11392#5:866\n215#6,2:868\n*S KotlinDebug\n*F\n+ 1 AGSLShaderBase.kt\ncom/samsung/android/sesl/outerGlow/AGSLShaderBase\n*L\n433#1:799\n436#1:812\n451#1:825\n454#1:838\n469#1:851\n472#1:864\n702#1:884\n187#1:755,14\n208#1:769,14\n375#1:783\n378#1:784,2\n375#1:786\n387#1:787\n410#1:788\n433#1:789,9\n433#1:798\n433#1:800\n433#1:801\n451#1:815,9\n451#1:824\n451#1:826\n451#1:827\n469#1:841,9\n469#1:850\n469#1:852\n469#1:853\n410#1:867\n387#1:870\n631#1:871,3\n702#1:874,9\n702#1:883\n702#1:885\n702#1:886\n712#1:887,7\n436#1:802,9\n436#1:811\n436#1:813\n436#1:814\n454#1:828,9\n454#1:837\n454#1:839\n454#1:840\n472#1:854,9\n472#1:863\n472#1:865\n472#1:866\n500#1:868,2\n*E\n"})
public abstract class AGSLShaderBase implements DefaultLifecycleObserver {
    private boolean autoStartAnimation;

    @Nullable
    private CanvasLayer canvasData;
    private boolean clearRenderEffect;
    private long frameIntervalNanos;
    private long frameRate;

    @NotNull
    private final Handler handler;

    @Nullable
    private Map<String, Boolean> hasSlowdownAnimationUniform;

    @Nullable
    private Map<String, Boolean> hasStartAnimationUniform;
    private float iSlowdownAnimationProgress;
    private float iStartAnimationProgress;
    private float iTime;
    private long initFrameTimeNanos;
    private boolean isCanvasDraw;
    private boolean isUpdateRunnableWorking;
    private long lastFrameTimeNanos;
    private float lastStopTime;

    @Nullable
    private LifecycleOwner lifecycleOwner;
    private boolean needInitDraw;

    @Nullable
    private Paint paint;
    private boolean readyDraw;

    @NotNull
    private List<LayerShaderPair> shaderList;

    @Nullable
    private Runnable slowStopRunnable;

    @Nullable
    private ValueAnimator startValueAnimator;

    @NotNull
    private final Map<String, Map<String, Object>> staticUniformMap;
    private boolean stopAnimation;

    @NotNull
    private final Map<String, List<Object>> uniformKeyList;

    @Nullable
    private Runnable updateRunnable;

    public AGSLShaderBase(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoStartAnimation = true;
        this.frameRate = 60L;
        this.frameIntervalNanos = 1000000000 / 60;
        this.needInitDraw = true;
        this.shaderList = new ArrayList();
        this.uniformKeyList = new LinkedHashMap();
        this.staticUniformMap = new LinkedHashMap();
        this.handler = new Handler(Looper.getMainLooper());
    }

    @RequiresApi(33)
    private final RenderEffect createRenderEffectForLayer(RuntimeShader shader, ShaderLayer layer) {
        if (layer.isBlur() && layer.getRadiusX() == 0.0f && layer.getRadiusY() == 0.0f) {
            return null;
        }
        if (!layer.isBlur()) {
            Intrinsics.checkNotNull(shader);
            return RenderEffect.createRuntimeShaderEffect(shader, "composable");
        }
        float radiusX = layer.getRadiusX() * 500.0f;
        float radiusY = layer.getRadiusY() * 500.0f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return RenderEffect.createBlurEffect(radiusX, radiusY, Shader.TileMode.CLAMP);
    }

    private final void initUpdateRunnable() {
        this.updateRunnable = new Runnable() { // from class: com.samsung.android.sesl.outerGlow.AGSLShaderBase.initUpdateRunnable.1
            @Override // java.lang.Runnable
            @RequiresApi(31)
            public void run() {
                AGSLShaderBase.this.requestInvalidate();
                AGSLShaderBase.this.getHandler().postDelayed(this, AGSLShaderBase.this.getFrameIntervalNanos() / ((long) 1000000));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInitAnimation$lambda$9$lambda$6(AGSLShaderBase this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.iStartAnimationProgress = ((Float) animatedValue).floatValue();
        this$0.requestInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSlowDownAnimation$lambda$12$lambda$10(AGSLShaderBase this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.iSlowdownAnimationProgress = ((Float) animatedValue).floatValue();
        this$0.requestInvalidate();
    }

    @RequiresApi(33)
    public final void applyShaderEffect(@NotNull Canvas canvas, int viewWidth, int viewHeight) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.shaderList.isEmpty() || !this.readyDraw) {
            return;
        }
        updateDynamicUniforms();
        if (this.shaderList.size() == 1 && this.isCanvasDraw) {
            if (this.paint == null) {
                Paint paint = new Paint();
                paint.setShader(this.shaderList.get(0).getShader());
                paint.setAntiAlias(true);
                this.paint = paint;
            }
            Paint paint2 = this.paint;
            Intrinsics.checkNotNull(paint2);
            paint2.setShader(this.shaderList.get(0).getShader());
            Paint paint3 = this.paint;
            Intrinsics.checkNotNull(paint3);
            canvas.drawRect(0.0f, 0.0f, viewWidth, viewHeight, paint3);
        } else {
            RenderEffect renderEffectCreateRenderEffect = createRenderEffect();
            if (renderEffectCreateRenderEffect != null) {
                getView().setRenderEffect(renderEffectCreateRenderEffect);
            }
        }
        this.readyDraw = false;
    }

    public abstract boolean canDrawCheck();

    @RequiresApi(33)
    @Nullable
    public final RenderEffect createRenderEffect() {
        if (this.shaderList.isEmpty()) {
            return null;
        }
        List<LayerShaderPair> list = this.shaderList;
        ArrayList arrayList = new ArrayList();
        for (LayerShaderPair layerShaderPair : list) {
            RenderEffect renderEffectCreateRenderEffectForLayer = createRenderEffectForLayer(layerShaderPair.getShader(), layerShaderPair.getData());
            if (renderEffectCreateRenderEffectForLayer != null) {
                arrayList.add(renderEffectCreateRenderEffectForLayer);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return AbstractC7019f.m5353g(arrayList.get(0));
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = RenderEffect.createChainEffect(AbstractC7019f.m5353g(it.next()), AbstractC7019f.m5353g(next));
            Intrinsics.checkNotNullExpressionValue(next, "createChainEffect(...)");
        }
        return AbstractC7019f.m5353g(next);
    }

    public final boolean getAutoStartAnimation() {
        return this.autoStartAnimation;
    }

    @Nullable
    public final CanvasLayer getCanvasData() {
        return this.canvasData;
    }

    public final boolean getClearRenderEffect() {
        return this.clearRenderEffect;
    }

    public final long getFrameIntervalNanos() {
        return this.frameIntervalNanos;
    }

    public final long getFrameRate() {
        return this.frameRate;
    }

    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    @Nullable
    public final Map<String, Boolean> getHasSlowdownAnimationUniform() {
        return this.hasSlowdownAnimationUniform;
    }

    @Nullable
    public final Map<String, Boolean> getHasStartAnimationUniform() {
        return this.hasStartAnimationUniform;
    }

    public final float getISlowdownAnimationProgress() {
        return this.iSlowdownAnimationProgress;
    }

    public final float getIStartAnimationProgress() {
        return this.iStartAnimationProgress;
    }

    public final float getITime() {
        return this.iTime;
    }

    public final long getInitFrameTimeNanos() {
        return this.initFrameTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final float getLastStopTime() {
        return this.lastStopTime;
    }

    public final boolean getNeedInitDraw() {
        return this.needInitDraw;
    }

    @Nullable
    public final Paint getPaint() {
        return this.paint;
    }

    public final boolean getReadyDraw() {
        return this.readyDraw;
    }

    @Nullable
    public final RuntimeShader getRuntimeShader() {
        return this.shaderList.get(0).getShader();
    }

    @NotNull
    public final List<LayerShaderPair> getRuntimeShaderList() {
        return this.shaderList;
    }

    @NotNull
    public final List<LayerShaderPair> getShaderList() {
        return this.shaderList;
    }

    @Nullable
    public final List<ShaderLayer> getShaders() {
        CanvasLayer canvasLayer = this.canvasData;
        Intrinsics.checkNotNull(canvasLayer);
        return canvasLayer.getShaders();
    }

    @Nullable
    public final Runnable getSlowStopRunnable() {
        return this.slowStopRunnable;
    }

    @Nullable
    public final ValueAnimator getStartValueAnimator() {
        return this.startValueAnimator;
    }

    @NotNull
    public final Map<String, Map<String, Object>> getStaticUniformMap() {
        return this.staticUniformMap;
    }

    public final boolean getStopAnimation() {
        return this.stopAnimation;
    }

    @NotNull
    public final Map<String, List<Object>> getUniformKeyList() {
        return this.uniformKeyList;
    }

    @Nullable
    public final Runnable getUpdateRunnable() {
        return this.updateRunnable;
    }

    @NotNull
    public abstract View getView();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0277 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x027f A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02f4 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0333 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x033b A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03b0 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03e5 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0415 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x041d A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0492 A[Catch: Exception -> 0x01a4, TryCatch #6 {Exception -> 0x01a4, blocks: (B:64:0x018b, B:68:0x019a, B:111:0x026f, B:113:0x0277, B:146:0x02f4, B:148:0x02f7, B:150:0x0309, B:151:0x031d, B:114:0x027f, B:116:0x0283, B:117:0x0292, B:119:0x0298, B:121:0x02a0, B:124:0x02a6, B:127:0x02b2, B:128:0x02b6, B:129:0x02bb, B:131:0x02bf, B:133:0x02ce, B:135:0x02d4, B:138:0x02da, B:141:0x02e6, B:142:0x02e9, B:143:0x02ec, B:73:0x01a7, B:155:0x032b, B:157:0x0333, B:190:0x03b0, B:192:0x03b4, B:194:0x03c6, B:195:0x03d9, B:158:0x033b, B:160:0x033f, B:161:0x034e, B:163:0x0354, B:165:0x035c, B:168:0x0362, B:171:0x036e, B:172:0x0372, B:173:0x0377, B:175:0x037b, B:177:0x038a, B:179:0x0390, B:182:0x0396, B:185:0x03a2, B:186:0x03a5, B:187:0x03a8, B:76:0x01b1, B:199:0x040d, B:201:0x0415, B:234:0x0492, B:236:0x0495, B:238:0x04a7, B:239:0x04bb, B:202:0x041d, B:204:0x0421, B:205:0x0430, B:207:0x0436, B:209:0x043e, B:212:0x0444, B:215:0x0450, B:216:0x0454, B:217:0x0459, B:219:0x045d, B:221:0x046c, B:223:0x0472, B:226:0x0478, B:229:0x0484, B:230:0x0487, B:231:0x048a, B:79:0x01bb, B:94:0x01ed, B:96:0x01f5, B:98:0x0207, B:99:0x0221, B:82:0x01c5, B:85:0x01cf, B:88:0x01d9, B:91:0x01e3, B:100:0x0225, B:102:0x022d, B:104:0x0235, B:106:0x0247, B:107:0x0261, B:108:0x0265, B:152:0x0321, B:196:0x03dd, B:198:0x03e5), top: B:322:0x018b }] */
    @RequiresApi(35)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initShader() {
        List<ShaderLayer> shaders;
        LayerShaderPair layerShaderPair;
        Map<String, Object> map;
        Map<String, Object> map2;
        Object value;
        float[] floatArray;
        Map<String, Object> map3;
        Object value2;
        float[] floatArray2;
        Map<String, Object> map4;
        Object value3;
        float[] floatArray3;
        Map<String, Object> map5;
        List<ShaderLayer> shaders2;
        this.uniformKeyList.clear();
        this.hasStartAnimationUniform = new LinkedHashMap();
        this.hasSlowdownAnimationUniform = new LinkedHashMap();
        CanvasLayer canvasLayer = this.canvasData;
        if (canvasLayer != null && (shaders2 = canvasLayer.getShaders()) != null) {
            for (ShaderLayer shaderLayer : shaders2) {
                if (shaderLayer.getAgslShaderCode() != null && shaderLayer.getEnabled()) {
                    this.uniformKeyList.put(String.valueOf(shaderLayer.getId()), new ArrayList());
                    List<Uniform> uniforms = shaderLayer.getUniforms();
                    if (uniforms != null) {
                        for (Uniform uniform : uniforms) {
                            List<Object> list = this.uniformKeyList.get(String.valueOf(shaderLayer.getId()));
                            Intrinsics.checkNotNull(list);
                            list.add(uniform.getName());
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    this.staticUniformMap.put(String.valueOf(shaderLayer.getId()), new LinkedHashMap());
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
        CanvasLayer canvasLayer2 = this.canvasData;
        if (canvasLayer2 == null || (shaders = canvasLayer2.getShaders()) == null) {
            return;
        }
        for (ShaderLayer shaderLayer2 : shaders) {
            if (shaderLayer2.getAgslShaderCode() != null && shaderLayer2.getEnabled()) {
                if (shaderLayer2.isBlur()) {
                    layerShaderPair = new LayerShaderPair(shaderLayer2, null);
                } else {
                    AbstractC7011a.m5287q();
                    String agslShaderCode = shaderLayer2.getAgslShaderCode();
                    Intrinsics.checkNotNull(agslShaderCode);
                    layerShaderPair = new LayerShaderPair(shaderLayer2, AbstractC7011a.m5275e(agslShaderCode));
                }
                LayerShaderPair layerShaderPair2 = layerShaderPair;
                this.shaderList.add(layerShaderPair2);
                Map<String, Object> map6 = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()));
                if (map6 != null) {
                    map6.clear();
                    Unit unit3 = Unit.INSTANCE;
                }
                Map<String, Boolean> map7 = this.hasStartAnimationUniform;
                if (!TypeIntrinsics.isMutableMap(map7)) {
                    map7 = null;
                }
                if (map7 != null) {
                    map7.put(String.valueOf(shaderLayer2.getId()), Boolean.valueOf(this.uniformKeyList.containsKey("iStartAnimationProgress")));
                    Unit unit4 = Unit.INSTANCE;
                }
                Map<String, Boolean> map8 = this.hasSlowdownAnimationUniform;
                if (!TypeIntrinsics.isMutableMap(map8)) {
                    map8 = null;
                }
                if (map8 != null) {
                    map8.put(String.valueOf(shaderLayer2.getId()), Boolean.valueOf(this.uniformKeyList.containsKey("iSlowdownAnimationProgress")));
                    Unit unit5 = Unit.INSTANCE;
                }
                Intrinsics.checkNotNull(shaderLayer2);
                for (Uniform uniform2 : shaderLayer2.getUniforms()) {
                    if (Intrinsics.areEqual(uniform2.isCustom(), Boolean.TRUE) && !Intrinsics.areEqual(uniform2.getName(), "iStartAnimationProgress") && !Intrinsics.areEqual(uniform2.getName(), "iSlowdownAnimationProgress")) {
                        try {
                            String type = uniform2.getType();
                            switch (type.hashCode()) {
                                case -1271649962:
                                    if (type.equals("float2")) {
                                        value = uniform2.getValue();
                                        if (value instanceof float[]) {
                                            floatArray = (float[]) uniform2.getValue();
                                        } else if (value instanceof List) {
                                            Iterable iterable = (Iterable) uniform2.getValue();
                                            ArrayList arrayList = new ArrayList();
                                            for (Object obj : iterable) {
                                                Number number = obj instanceof Number ? (Number) obj : null;
                                                Float fValueOf = number != null ? Float.valueOf(number.floatValue()) : null;
                                                if (fValueOf != null) {
                                                    arrayList.add(fValueOf);
                                                }
                                            }
                                            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
                                        } else if (value instanceof Object[]) {
                                            Object[] objArr = (Object[]) uniform2.getValue();
                                            ArrayList arrayList2 = new ArrayList();
                                            for (Object obj2 : objArr) {
                                                Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
                                                Float fValueOf2 = number2 != null ? Float.valueOf(number2.floatValue()) : null;
                                                if (fValueOf2 != null) {
                                                    arrayList2.add(fValueOf2);
                                                }
                                            }
                                            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList2);
                                        } else {
                                            floatArray = null;
                                        }
                                        if (floatArray != null && floatArray.length >= 2 && (map3 = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()))) != null) {
                                            map3.put(uniform2.getName(), ArraysKt.sliceArray(floatArray, new IntRange(0, 1)));
                                            Unit unit6 = Unit.INSTANCE;
                                        }
                                        Unit unit7 = Unit.INSTANCE;
                                    } else {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit8 = Unit.INSTANCE;
                                    }
                                    break;
                                case -1271649961:
                                    if (!type.equals("float3")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit82 = Unit.INSTANCE;
                                    }
                                    value2 = uniform2.getValue();
                                    if (value2 instanceof float[]) {
                                        floatArray2 = (float[]) uniform2.getValue();
                                    } else if (value2 instanceof List) {
                                        Iterable iterable2 = (Iterable) uniform2.getValue();
                                        ArrayList arrayList3 = new ArrayList();
                                        for (Object obj3 : iterable2) {
                                            Number number3 = obj3 instanceof Number ? (Number) obj3 : null;
                                            Float fValueOf3 = number3 != null ? Float.valueOf(number3.floatValue()) : null;
                                            if (fValueOf3 != null) {
                                                arrayList3.add(fValueOf3);
                                            }
                                        }
                                        floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList3);
                                    } else if (value2 instanceof Object[]) {
                                        Object[] objArr2 = (Object[]) uniform2.getValue();
                                        ArrayList arrayList4 = new ArrayList();
                                        for (Object obj4 : objArr2) {
                                            Number number4 = obj4 instanceof Number ? (Number) obj4 : null;
                                            Float fValueOf4 = number4 != null ? Float.valueOf(number4.floatValue()) : null;
                                            if (fValueOf4 != null) {
                                                arrayList4.add(fValueOf4);
                                            }
                                        }
                                        floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList4);
                                    } else {
                                        floatArray2 = null;
                                    }
                                    if (floatArray2 != null && floatArray2.length >= 3 && (map4 = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()))) != null) {
                                        map4.put(uniform2.getName(), ArraysKt.sliceArray(floatArray2, new IntRange(0, 2)));
                                        Unit unit9 = Unit.INSTANCE;
                                    }
                                    Unit unit10 = Unit.INSTANCE;
                                    break;
                                case -1271649960:
                                    if (!type.equals("float4")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit822 = Unit.INSTANCE;
                                    }
                                    value3 = uniform2.getValue();
                                    if (value3 instanceof float[]) {
                                        floatArray3 = (float[]) uniform2.getValue();
                                    } else if (value3 instanceof List) {
                                        Iterable iterable3 = (Iterable) uniform2.getValue();
                                        ArrayList arrayList5 = new ArrayList();
                                        for (Object obj5 : iterable3) {
                                            Number number5 = obj5 instanceof Number ? (Number) obj5 : null;
                                            Float fValueOf5 = number5 != null ? Float.valueOf(number5.floatValue()) : null;
                                            if (fValueOf5 != null) {
                                                arrayList5.add(fValueOf5);
                                            }
                                        }
                                        floatArray3 = CollectionsKt___CollectionsKt.toFloatArray(arrayList5);
                                    } else if (value3 instanceof Object[]) {
                                        Object[] objArr3 = (Object[]) uniform2.getValue();
                                        ArrayList arrayList6 = new ArrayList();
                                        for (Object obj6 : objArr3) {
                                            Number number6 = obj6 instanceof Number ? (Number) obj6 : null;
                                            Float fValueOf6 = number6 != null ? Float.valueOf(number6.floatValue()) : null;
                                            if (fValueOf6 != null) {
                                                arrayList6.add(fValueOf6);
                                            }
                                        }
                                        floatArray3 = CollectionsKt___CollectionsKt.toFloatArray(arrayList6);
                                    } else {
                                        floatArray3 = null;
                                    }
                                    if (floatArray3 != null && floatArray3.length >= 4 && (map5 = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()))) != null) {
                                        map5.put(uniform2.getName(), ArraysKt.sliceArray(floatArray3, new IntRange(0, 3)));
                                        Unit unit11 = Unit.INSTANCE;
                                    }
                                    Unit unit12 = Unit.INSTANCE;
                                    break;
                                case 104431:
                                    if (type.equals(XmlErrorCodes.INT)) {
                                        if ((uniform2.getValue() instanceof Number) && (map = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()))) != null) {
                                            String name = uniform2.getName();
                                            Object value4 = uniform2.getValue();
                                            Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Number");
                                            map.put(name, Integer.valueOf(((Number) value4).intValue()));
                                            Unit unit13 = Unit.INSTANCE;
                                        }
                                        Unit unit14 = Unit.INSTANCE;
                                        break;
                                    }
                                    break;
                                case 3194931:
                                    if (!type.equals("half")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit8222 = Unit.INSTANCE;
                                    }
                                    if ((uniform2.getValue() instanceof Number) && (map2 = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()))) != null) {
                                        String name2 = uniform2.getName();
                                        Object value5 = uniform2.getValue();
                                        Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type kotlin.Number");
                                        map2.put(name2, Float.valueOf(((Number) value5).floatValue()));
                                        Unit unit15 = Unit.INSTANCE;
                                    }
                                    Unit unit16 = Unit.INSTANCE;
                                    break;
                                case 3615518:
                                    if (!type.equals("vec2")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit82222 = Unit.INSTANCE;
                                    }
                                    value = uniform2.getValue();
                                    if (value instanceof float[]) {
                                    }
                                    if (floatArray != null) {
                                        map3.put(uniform2.getName(), ArraysKt.sliceArray(floatArray, new IntRange(0, 1)));
                                        Unit unit62 = Unit.INSTANCE;
                                    }
                                    Unit unit72 = Unit.INSTANCE;
                                    break;
                                case 3615519:
                                    if (!type.equals("vec3")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit822222 = Unit.INSTANCE;
                                    }
                                    value2 = uniform2.getValue();
                                    if (value2 instanceof float[]) {
                                    }
                                    if (floatArray2 != null) {
                                        map4.put(uniform2.getName(), ArraysKt.sliceArray(floatArray2, new IntRange(0, 2)));
                                        Unit unit92 = Unit.INSTANCE;
                                    }
                                    Unit unit102 = Unit.INSTANCE;
                                    break;
                                case 3615520:
                                    if (!type.equals("vec4")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit8222222 = Unit.INSTANCE;
                                    }
                                    value3 = uniform2.getValue();
                                    if (value3 instanceof float[]) {
                                    }
                                    if (floatArray3 != null) {
                                        map5.put(uniform2.getName(), ArraysKt.sliceArray(floatArray3, new IntRange(0, 3)));
                                        Unit unit112 = Unit.INSTANCE;
                                    }
                                    Unit unit122 = Unit.INSTANCE;
                                    break;
                                case 97526364:
                                    if (!type.equals("float")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit82222222 = Unit.INSTANCE;
                                    }
                                    if (uniform2.getValue() instanceof Number) {
                                        String name22 = uniform2.getName();
                                        Object value52 = uniform2.getValue();
                                        Intrinsics.checkNotNull(value52, "null cannot be cast to non-null type kotlin.Number");
                                        map2.put(name22, Float.valueOf(((Number) value52).floatValue()));
                                        Unit unit152 = Unit.INSTANCE;
                                    }
                                    Unit unit162 = Unit.INSTANCE;
                                    break;
                                case 99042911:
                                    if (!type.equals("half2")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit822222222 = Unit.INSTANCE;
                                    }
                                    value = uniform2.getValue();
                                    if (value instanceof float[]) {
                                    }
                                    if (floatArray != null) {
                                    }
                                    Unit unit722 = Unit.INSTANCE;
                                    break;
                                case 99042912:
                                    if (!type.equals("half3")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit8222222222 = Unit.INSTANCE;
                                    }
                                    value2 = uniform2.getValue();
                                    if (value2 instanceof float[]) {
                                    }
                                    if (floatArray2 != null) {
                                    }
                                    Unit unit1022 = Unit.INSTANCE;
                                    break;
                                case 99042913:
                                    if (!type.equals("half4")) {
                                        Log.w("JSONShaderComponentView", "Unsupported uniform type: " + uniform2.getType() + " for " + uniform2.getName());
                                        Unit unit82222222222 = Unit.INSTANCE;
                                    }
                                    value3 = uniform2.getValue();
                                    if (value3 instanceof float[]) {
                                    }
                                    if (floatArray3 != null) {
                                    }
                                    Unit unit1222 = Unit.INSTANCE;
                                    break;
                            }
                        } catch (Exception e) {
                            Log.e("JSONShaderComponentView", "Error precomputing uniform " + uniform2.getName() + ": " + e.getMessage());
                        }
                    }
                }
                Map<String, Object> map9 = this.staticUniformMap.get(String.valueOf(shaderLayer2.getId()));
                if (map9 != null) {
                    for (Map.Entry<String, Object> entry : map9.entrySet()) {
                        String key = entry.getKey();
                        Object value6 = entry.getValue();
                        try {
                        } catch (Exception e2) {
                            e = e2;
                        }
                        if (value6 instanceof Integer) {
                            RuntimeShader shader = layerShaderPair2.getShader();
                            if (shader != null) {
                                shader.setIntUniform(key, ((Number) value6).intValue());
                                Unit unit17 = Unit.INSTANCE;
                            }
                        } else if (value6 instanceof Float) {
                            RuntimeShader shader2 = layerShaderPair2.getShader();
                            if (shader2 != null) {
                                shader2.setFloatUniform(key, ((Number) value6).floatValue());
                                Unit unit18 = Unit.INSTANCE;
                            }
                        } else if (value6 instanceof float[]) {
                            int length = ((float[]) value6).length;
                            if (length == 2) {
                                RuntimeShader shader3 = layerShaderPair2.getShader();
                                if (shader3 != null) {
                                    try {
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                    try {
                                        shader3.setFloatUniform(key, ((float[]) value6)[0], ((float[]) value6)[1]);
                                        Unit unit19 = Unit.INSTANCE;
                                    } catch (Exception e5) {
                                        e = e5;
                                        Log.e("JSONShaderComponentView", "Error setting static uniform " + key + ": " + e.getMessage());
                                    }
                                }
                            } else if (length == 3) {
                                RuntimeShader shader4 = layerShaderPair2.getShader();
                                if (shader4 != null) {
                                    shader4.setFloatUniform(key, ((float[]) value6)[0], ((float[]) value6)[1], ((float[]) value6)[2]);
                                    Unit unit20 = Unit.INSTANCE;
                                }
                            } else if (length != 4) {
                                Log.w("JSONShaderComponentView", "Unsupported uniform array size for " + key);
                                Unit unit21 = Unit.INSTANCE;
                            } else {
                                try {
                                    RuntimeShader shader5 = layerShaderPair2.getShader();
                                    if (shader5 != null) {
                                        try {
                                            try {
                                                shader5.setFloatUniform(key, ((float[]) value6)[0], ((float[]) value6)[1], ((float[]) value6)[2], ((float[]) value6)[3]);
                                                Unit unit22 = Unit.INSTANCE;
                                            } catch (Exception e6) {
                                                e = e6;
                                                key = key;
                                                Log.e("JSONShaderComponentView", "Error setting static uniform " + key + ": " + e.getMessage());
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                        }
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                }
                            }
                        } else {
                            Log.w("JSONShaderComponentView", "Unsupported uniform value type for " + key);
                        }
                    }
                    Unit unit23 = Unit.INSTANCE;
                }
            }
            onShaderCreated();
            requestInvalidate();
        }
        Unit unit24 = Unit.INSTANCE;
    }

    @RequiresApi(35)
    public final void initWithCanvasData(@Nullable CanvasLayer canvasData) {
        List<ShaderLayer> shaders;
        String agslShaderCode;
        this.stopAnimation = false;
        stopUpdateRunnable();
        Runnable runnable = this.slowStopRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.uniformKeyList.clear();
        this.staticUniformMap.clear();
        this.hasStartAnimationUniform = null;
        this.hasSlowdownAnimationUniform = null;
        this.iStartAnimationProgress = 0.0f;
        this.iSlowdownAnimationProgress = 0.0f;
        this.shaderList.clear();
        onResetForNewCanvas();
        this.canvasData = canvasData;
        if (canvasData == null) {
            this.readyDraw = true;
            getView().invalidate();
            return;
        }
        if (canvasData.getShaders() == null && (agslShaderCode = canvasData.getAgslShaderCode()) != null && agslShaderCode.length() > 0) {
            List<Uniform> uniforms = canvasData.getUniforms();
            Intrinsics.checkNotNull(uniforms);
            List listListOf = CollectionsKt.listOf(new ShaderLayer(1, uniforms, true, canvasData.getAgslShaderCode(), this.isCanvasDraw, false, 0.0f, 0.0f, null, 480, null));
            CanvasLayer canvasLayer = this.canvasData;
            this.canvasData = canvasLayer != null ? CanvasLayer.copy$default(canvasLayer, null, 0, 0, false, false, false, 0, 0, listListOf, null, null, 1791, null) : null;
        }
        boolean zM14162r = StringsKt.m14162r(String.valueOf(canvasData.getAgslShaderCode()), "composable.eval");
        CanvasLayer canvasLayer2 = this.canvasData;
        if (canvasLayer2 == null || (shaders = canvasLayer2.getShaders()) == null || shaders.size() != 1 || !zM14162r) {
            this.isCanvasDraw = false;
        } else {
            this.isCanvasDraw = true;
        }
        initShader();
        if (this.canvasData != null) {
            setFrameRate(r1.getFrameRate());
        }
        requestInvalidate();
    }

    @RequiresApi(35)
    public final void initWithRaw(@NotNull Context context, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strLoadJSONFromRaw = loadJSONFromRaw(context, resourceId);
        if (strLoadJSONFromRaw != null) {
            parseCanvasData(strLoadJSONFromRaw);
        }
    }

    /* JADX INFO: renamed from: isCanvasDraw, reason: from getter */
    public final boolean getIsCanvasDraw() {
        return this.isCanvasDraw;
    }

    public final boolean isStopAnimation() {
        if (this.frameRate == 0) {
            return true;
        }
        return this.stopAnimation;
    }

    /* JADX INFO: renamed from: isUpdateRunnableWorking, reason: from getter */
    public final boolean getIsUpdateRunnableWorking() {
        return this.isUpdateRunnableWorking;
    }

    @Nullable
    public final String loadJSONFromRaw(@NotNull Context context, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(resourceId);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, Charsets.UTF_8), 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } finally {
            }
        } catch (Exception e) {
            AbstractC2322a.m1636z("Error loading JSON from raw resource: ", e.getMessage(), "AGSLShaderView");
            return null;
        }
    }

    @RequiresApi(31)
    public final void onAttachedToWindow() {
        this.stopAnimation = false;
        this.needInitDraw = true;
        long jNanoTime = System.nanoTime();
        this.lastFrameTimeNanos = jNanoTime;
        this.initFrameTimeNanos = jNanoTime;
        requestInvalidate();
    }

    public final void onDetachedFromWindow() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        Runnable runnable = this.slowStopRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
    }

    @RequiresApi(31)
    public final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.needInitDraw = true;
        this.readyDraw = true;
        requestInvalidate();
    }

    public final void onPause() {
    }

    public void onResetForNewCanvas() {
        this.paint = null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    @RequiresApi(31)
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        startUpdateRunnable();
        onResume();
    }

    public void onShaderCreated() {
        this.paint = null;
    }

    @RequiresApi(31)
    public final void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.needInitDraw = true;
        this.readyDraw = true;
        requestInvalidate();
    }

    @RequiresApi(35)
    public final void parseCanvasData(@NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            initWithCanvasData((CanvasLayer) new Gson().fromJson(jsonString, CanvasLayer.class));
        } catch (Exception e) {
            AbstractC2322a.m1636z("Error parsing direct canvas data: ", e.getMessage(), "AGSLShaderView");
        }
    }

    @RequiresApi(31)
    public final boolean requestInvalidate() {
        if (this.clearRenderEffect) {
            getView().setRenderEffect(null);
            getView().invalidate();
            return false;
        }
        if (this.stopAnimation || !canDrawCheck() || (this.frameRate == 0 && !this.needInitDraw)) {
            return false;
        }
        long jNanoTime = System.nanoTime();
        long j = jNanoTime - this.lastFrameTimeNanos;
        if (!this.needInitDraw && j < this.frameIntervalNanos) {
            return true;
        }
        if (canDrawCheck()) {
            this.needInitDraw = false;
        }
        float f = (jNanoTime - this.initFrameTimeNanos) / 1.0E9f;
        if (this.isUpdateRunnableWorking) {
            updateITime(f);
        }
        this.lastFrameTimeNanos = jNanoTime;
        this.readyDraw = true;
        getView().invalidate();
        return true;
    }

    public final boolean resetDrawStatus() {
        this.needInitDraw = true;
        this.readyDraw = true;
        getView().invalidate();
        return true;
    }

    public final void setAutoStartAnimation(boolean z) {
        this.autoStartAnimation = z;
    }

    public final void setCanvasData(@Nullable CanvasLayer canvasLayer) {
        this.canvasData = canvasLayer;
    }

    public final void setCanvasDraw(boolean z) {
        this.isCanvasDraw = z;
    }

    public final void setClearRenderEffect(boolean z) {
        this.clearRenderEffect = z;
    }

    public final void setFrameIntervalNanos(long j) {
        this.frameIntervalNanos = j;
    }

    @RequiresApi(31)
    public final void setFrameRate(long fps) {
        CanvasLayer canvasLayer = this.canvasData;
        if (canvasLayer != null) {
            this.frameRate = fps;
            this.frameIntervalNanos = 1000000000 / (fps == 0 ? 1L : fps);
            if (fps > 0) {
                initUpdateRunnable();
                if (canvasLayer.getNeedInitAnimation() && this.autoStartAnimation) {
                    startInitAnimation(canvasLayer.getInitAnimationDuration());
                }
                if (canvasLayer.getNeedStopAfterDelay()) {
                    Runnable runnable = new Runnable() { // from class: com.samsung.android.sesl.outerGlow.AGSLShaderBase$setFrameRate$1$1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$0.getCanvasData() != null) {
                                this.this$0.startSlowDownAnimation(r0.getStopAnimationDuration());
                            }
                        }
                    };
                    this.slowStopRunnable = runnable;
                    this.handler.postDelayed(runnable, canvasLayer.getStopAfterDelay());
                }
            } else {
                Runnable runnable2 = this.updateRunnable;
                if (runnable2 != null) {
                    Handler handler = this.handler;
                    Intrinsics.checkNotNull(runnable2);
                    handler.removeCallbacks(runnable2);
                }
                this.iStartAnimationProgress = 1.0f;
                this.iSlowdownAnimationProgress = 1.0f;
            }
        }
        requestInvalidate();
    }

    public final void setHasSlowdownAnimationUniform(@Nullable Map<String, Boolean> map) {
        this.hasSlowdownAnimationUniform = map;
    }

    public final void setHasStartAnimationUniform(@Nullable Map<String, Boolean> map) {
        this.hasStartAnimationUniform = map;
    }

    public final void setISlowdownAnimationProgress(float f) {
        this.iSlowdownAnimationProgress = f;
    }

    public final void setIStartAnimationProgress(float f) {
        this.iStartAnimationProgress = f;
    }

    public final void setITime(float f) {
        this.iTime = f;
    }

    public final void setInitFrameTimeNanos(long j) {
        this.initFrameTimeNanos = j;
    }

    public final void setLastFrameTimeNanos(long j) {
        this.lastFrameTimeNanos = j;
    }

    public final void setLastStopTime(float f) {
        this.lastStopTime = f;
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this);
    }

    public final void setNeedInitDraw(boolean z) {
        this.needInitDraw = z;
    }

    public final void setReadyDraw(boolean z) {
        this.readyDraw = z;
    }

    public final void setShaderList(@NotNull List<LayerShaderPair> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.shaderList = list;
    }

    public final void setSlowStopRunnable(@Nullable Runnable runnable) {
        this.slowStopRunnable = runnable;
    }

    public final void setStartValueAnimator(@Nullable ValueAnimator valueAnimator) {
        this.startValueAnimator = valueAnimator;
    }

    public final void setStopAnimation(boolean z) {
        this.stopAnimation = z;
    }

    public final void setUpdateRunnable(@Nullable Runnable runnable) {
        this.updateRunnable = runnable;
    }

    public final void setUpdateRunnableWorking(boolean z) {
        this.isUpdateRunnableWorking = z;
    }

    @RequiresApi(31)
    public final void startInitAnimation() {
        if (this.canvasData != null) {
            startInitAnimation(r0.getInitAnimationDuration());
        }
    }

    @RequiresApi(31)
    public final void startSlowDownAnimation(long duration) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.addUpdateListener(new C7840b(this, 1));
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.outerGlow.AGSLShaderBase$startSlowDownAnimation$lambda$12$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                this.this$0.setStopAnimation(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
            }
        });
        valueAnimatorOfFloat.start();
    }

    public final void startUpdateRunnable() {
        this.initFrameTimeNanos = System.nanoTime() - ((long) (this.lastStopTime * 1.0E9f));
        Runnable runnable = this.updateRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.updateRunnable;
        if (runnable2 != null) {
            this.isUpdateRunnableWorking = true;
            this.handler.post(runnable2);
        }
    }

    public final void startWithClear() {
        this.clearRenderEffect = false;
        startUpdateRunnable();
    }

    public final void stopUpdateRunnable() {
        this.lastStopTime = this.iTime;
        this.lastFrameTimeNanos = System.nanoTime();
        this.isUpdateRunnableWorking = false;
        Runnable runnable = this.updateRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
    }

    @RequiresApi(31)
    public final void stopWithClear() {
        this.clearRenderEffect = true;
        stopUpdateRunnable();
        requestInvalidate();
    }

    @RequiresApi(33)
    public final void updateDynamicUniforms() {
        int i = 0;
        for (Object obj : this.shaderList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LayerShaderPair layerShaderPair = (LayerShaderPair) obj;
            RuntimeShader shader = layerShaderPair.getShader();
            if (shader != null) {
                shader.setFloatUniform("iTime", this.iTime);
            }
            RuntimeShader shader2 = layerShaderPair.getShader();
            if (shader2 != null) {
                shader2.setFloatUniform("iResolution", getView().getWidth(), getView().getHeight());
            }
            i = i2;
        }
    }

    public final void updateITime(float iTime) {
        this.iTime = iTime;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onPause(owner);
        stopUpdateRunnable();
        onPause();
    }

    @RequiresApi(31)
    public final void startInitAnimation(long duration) {
        ValueAnimator valueAnimator = this.startValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
        this.stopAnimation = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.addUpdateListener(new C7840b(this, 0));
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.outerGlow.AGSLShaderBase$startInitAnimation$lambda$9$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                CanvasLayer canvasData = this.this$0.getCanvasData();
                if (canvasData == null || !canvasData.getNeedStopAfterInitAnimation()) {
                    return;
                }
                this.this$0.setStopAnimation(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
            }
        });
        valueAnimatorOfFloat.start();
        this.startValueAnimator = valueAnimatorOfFloat;
    }

    @RequiresApi(31)
    public final void onResume() {
        this.stopAnimation = false;
        this.needInitDraw = true;
        requestInvalidate();
    }
}
