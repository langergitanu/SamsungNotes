package com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader;

import android.content.Context;
import android.graphics.RuntimeShader;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import androidx.appcompat.animation.C0422b;
import androidx.compose.p109ui.text.input.ChoreographerFrameCallbackC2251a;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.pen.setting.colorpicker.ViewTreeObserverOnGlobalLayoutListenerC7542d;
import com.samsung.android.sesl.visualeffect.utils.WeakViewHashSet;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020.H\u0014J\b\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001fH\u0016J\u0010\u00107\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001fH\u0016J\u0010\u00108\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u001aH\u0016J\b\u0010:\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020\u001aH\u0016J\b\u0010<\u001a\u00020\u001aH\u0016J\u0012\u0010=\u001a\u00020\u001a2\b\b\u0002\u0010>\u001a\u00020\u0003H\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010?\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0007H\u0016J\u0018\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0016J\u0018\u0010E\u001a\u00020\u001a2\u000e\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0GH\u0004J\u000e\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000RW\u0010\u0014\u001aH\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00160\u0015j#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0016`\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR9\u0010\u001e\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u00160\u0015j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u0016`\u001b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "autoUpdate", "", "<init>", "(Z)V", "value", "", "requestedMaxFrameRate", "getRequestedMaxFrameRate", "()Ljava/lang/Float;", "setRequestedMaxFrameRate", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "shaderUpdated", "getShaderUpdated", "()Z", "setShaderUpdated$sesl_visualeffect_INTERNAL_2_1_10_release", "targetViewSet", "Lcom/samsung/android/sesl/visualeffect/utils/WeakViewHashSet;", "onUpdateListeners", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "invalidate", "", "Lkotlin/collections/ArrayList;", "getOnUpdateListeners", "()Ljava/util/ArrayList;", "onUpdateListenersEachView", "Landroid/view/View;", "getOnUpdateListenersEachView", "viewTreeObserverOnAdd", "Landroid/view/ViewTreeObserver;", "initializedWithContext", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase$State;", "runningState", "getRunningState", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase$State;", "invalidationListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "frameCallback", "Landroid/view/Choreographer$FrameCallback;", "initializeWithContext", "context", "Landroid/content/Context;", "onInitialize", StateHandler.KEY_APP_STATE, "attachFrameCallback", "updateOnFrameCallback", "removeFrameCallback", "hasVisibleView", "add", "view", "remove", "removeViewTreeObserverListener", "tryStart", "start", "stop", "destroy", Constants.ARG_UPDATE, "forceUpdate", "setViewAlpha", "alpha", "setSize", "width", "", "height", "updateShader", "updater", "Ljava/util/function/Consumer;", "Landroid/graphics/RuntimeShader;", "setFrameRate", "frameRate", "Companion", "State", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVibeRenderEffectBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VibeRenderEffectBase.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1863#2,2:230\n1863#2,2:232\n*S KotlinDebug\n*F\n+ 1 VibeRenderEffectBase.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase\n*L\n196#1:230,2\n202#1:232,2\n*E\n"})
public abstract class VibeRenderEffectBase implements VibeRenderEffect {

    @NotNull
    public static final String TAG = "VibeRenderEffectBase";
    private final boolean autoUpdate;

    @NotNull
    private final Choreographer.FrameCallback frameCallback;
    private boolean initializedWithContext;

    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener invalidationListener;

    @NotNull
    private final ArrayList<Function1<Boolean, Unit>> onUpdateListeners;

    @NotNull
    private final ArrayList<Function1<View, Unit>> onUpdateListenersEachView;

    @Nullable
    private Float requestedMaxFrameRate;

    @NotNull
    private State runningState;
    private boolean shaderUpdated;

    @NotNull
    private final WeakViewHashSet targetViewSet;

    @Nullable
    private ViewTreeObserver viewTreeObserverOnAdd;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase$State;", "", "<init>", "(Ljava/lang/String;I)V", "READY", DebugCoroutineInfoImplKt.RUNNING, "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State READY = new State("READY", 0);
        public static final State RUNNING = new State(DebugCoroutineInfoImplKt.RUNNING, 1);

        private static final /* synthetic */ State[] $values() {
            return new State[]{READY, RUNNING};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
        }

        private State(String str, int i) {
        }

        @NotNull
        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public VibeRenderEffectBase() {
        this(false, 1, null);
    }

    private final void attachFrameCallback() {
        if (this.runningState != State.READY) {
            Log.i(TAG, "effect is already in running state.");
            return;
        }
        this.runningState = State.RUNNING;
        Log.i(TAG, "attachFrameCallback");
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroy$lambda$6(VibeRenderEffectBase vibeRenderEffectBase, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        vibeRenderEffectBase.removeViewTreeObserverListener(it);
    }

    private final boolean hasVisibleView() {
        return this.targetViewSet.size() > 0 && this.targetViewSet.stream().filter(new C7233a(new C0348a(4), 1)).count() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasVisibleView$lambda$2(WeakReference weakReference) {
        View view;
        View view2 = (View) weakReference.get();
        return view2 != null && view2.getVisibility() == 0 && (view = (View) weakReference.get()) != null && view.getWindowVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasVisibleView$lambda$3(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private final void initializeWithContext(Context context) {
        if (this.initializedWithContext) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        onInitialize(applicationContext);
        this.initializedWithContext = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationListener$lambda$0(VibeRenderEffectBase vibeRenderEffectBase) {
        if (vibeRenderEffectBase.runningState == State.RUNNING && vibeRenderEffectBase.hasVisibleView()) {
            vibeRenderEffectBase.update(true);
        }
    }

    private final void removeFrameCallback() {
        if (this.runningState != State.RUNNING) {
            Log.i(TAG, "effect is already in ready state.");
            return;
        }
        this.runningState = State.READY;
        Log.i(TAG, "removeFrameCallback");
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
    }

    private final void removeViewTreeObserverListener(View view) {
        ViewTreeObserver viewTreeObserver;
        int iHashCode = view.getViewTreeObserver().hashCode();
        ViewTreeObserver viewTreeObserver2 = this.viewTreeObserverOnAdd;
        if (iHashCode != (viewTreeObserver2 != null ? viewTreeObserver2.hashCode() : 0)) {
            Log.w(TAG, "removeOnGlobalLayoutListener: viewTreeObserver " + view.getViewTreeObserver().hashCode() + " is changed, use saved one");
            ViewTreeObserver viewTreeObserver3 = this.viewTreeObserverOnAdd;
            if (viewTreeObserver3 != null && viewTreeObserver3.isAlive() && (viewTreeObserver = this.viewTreeObserverOnAdd) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.invalidationListener);
            }
        } else {
            ViewTreeObserver viewTreeObserver4 = this.viewTreeObserverOnAdd;
            Integer numValueOf = viewTreeObserver4 != null ? Integer.valueOf(viewTreeObserver4.hashCode()) : null;
            Log.i(TAG, "removeOnGlobalLayoutListener observer: " + numValueOf + " view: " + view.hashCode());
            if (view.getViewTreeObserver().isAlive()) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.invalidationListener);
            }
        }
        this.viewTreeObserverOnAdd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSize$lambda$10(VibeRenderEffectBase vibeRenderEffectBase, int i, int i2, RuntimeShader runtimeShader) {
        RuntimeShader shader = vibeRenderEffectBase.getShader();
        if (shader != null) {
            shader.setFloatUniform("uSize", i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$4(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stop$lambda$5(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setRenderEffect(null);
        it.invalidate();
    }

    public static /* synthetic */ void update$default(VibeRenderEffectBase vibeRenderEffectBase, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        vibeRenderEffectBase.update(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$9(VibeRenderEffectBase vibeRenderEffectBase, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        vibeRenderEffectBase.setSize(it.getWidth(), it.getHeight());
        vibeRenderEffectBase.setViewAlpha(it, it.getAlpha());
        Iterator<T> it2 = vibeRenderEffectBase.onUpdateListenersEachView.iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(it);
        }
        it.setRenderEffect(vibeRenderEffectBase.getRenderEffect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOnFrameCallback() {
        if (this.autoUpdate) {
            if (!hasVisibleView()) {
                Log.i(TAG, "there is no visible view state: " + this.runningState);
                removeFrameCallback();
                return;
            }
            update$default(this, false, 1, null);
            if (this.runningState == State.RUNNING) {
                Float requestedMaxFrameRate = getRequestedMaxFrameRate();
                if (requestedMaxFrameRate == null || Intrinsics.areEqual(requestedMaxFrameRate, 120.0f)) {
                    Choreographer.getInstance().postFrameCallback(this.frameCallback);
                } else {
                    Choreographer.getInstance().postFrameCallbackDelayed(this.frameCallback, (long) (1000 / requestedMaxFrameRate.floatValue()));
                }
            }
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void add(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initializeWithContext(context);
        if (this.targetViewSet.add(view) && this.viewTreeObserverOnAdd == null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.viewTreeObserverOnAdd = viewTreeObserver;
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                this.viewTreeObserverOnAdd = null;
                return;
            }
            ViewTreeObserver viewTreeObserver2 = this.viewTreeObserverOnAdd;
            if (viewTreeObserver2 != null) {
                viewTreeObserver2.addOnGlobalLayoutListener(this.invalidationListener);
            }
            ViewTreeObserver viewTreeObserver3 = this.viewTreeObserverOnAdd;
            Integer numValueOf = viewTreeObserver3 != null ? Integer.valueOf(viewTreeObserver3.hashCode()) : null;
            Log.i(TAG, "addOnGlobalLayoutListener observer: " + numValueOf + " view: " + view.hashCode());
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void destroy() {
        Log.i(TAG, "destroy Render Effect ");
        stop();
        this.targetViewSet.forEachAlive(new C7847b(this, 0));
        this.invalidationListener = null;
        this.targetViewSet.clear();
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
    }

    @NotNull
    public final ArrayList<Function1<Boolean, Unit>> getOnUpdateListeners() {
        return this.onUpdateListeners;
    }

    @NotNull
    public final ArrayList<Function1<View, Unit>> getOnUpdateListenersEachView() {
        return this.onUpdateListenersEachView;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    @Nullable
    public Float getRequestedMaxFrameRate() {
        return this.requestedMaxFrameRate;
    }

    @NotNull
    public final State getRunningState() {
        return this.runningState;
    }

    public final boolean getShaderUpdated() {
        return this.shaderUpdated;
    }

    public final void invalidate() {
        this.shaderUpdated = true;
    }

    public void onInitialize(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void remove(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.targetViewSet.remove(view)) {
            removeViewTreeObserverListener(view);
            view.setRenderEffect(null);
            if (this.targetViewSet.size() == 0) {
                removeFrameCallback();
            }
        }
    }

    public final void setFrameRate(float frameRate) {
        setRequestedMaxFrameRate(Float.valueOf(frameRate));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void setRequestedMaxFrameRate(@Nullable Float f) {
        this.requestedMaxFrameRate = f;
        Log.i(TAG, "Set FrameRate to " + f);
    }

    public final void setShaderUpdated$sesl_visualeffect_INTERNAL_2_1_10_release(boolean z) {
        this.shaderUpdated = z;
    }

    public void setSize(int width, int height) {
        updateShader(new C7846a(this, width, height));
    }

    public void setViewAlpha(@NotNull View view, float alpha) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void start() {
        Log.i(TAG, "start - runningState: " + this.runningState);
        if (this.runningState != State.RUNNING) {
            attachFrameCallback();
        }
        this.targetViewSet.forEachAlive(new C0422b(2));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void stop() {
        Log.i(TAG, "stop - runningState: " + this.runningState);
        if (this.runningState != State.READY) {
            removeFrameCallback();
        }
        this.targetViewSet.forEachAlive(new C0422b(1));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void tryStart() {
        if (this.runningState != State.RUNNING) {
            start();
        }
    }

    public void update(boolean forceUpdate) {
        boolean z = forceUpdate | this.shaderUpdated;
        Iterator<T> it = this.onUpdateListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(Boolean.valueOf(z));
        }
        if (z) {
            this.targetViewSet.forEachAlive(new C7847b(this, 1));
            this.shaderUpdated = false;
        }
    }

    public final void updateShader(@NotNull Consumer<RuntimeShader> updater) {
        Intrinsics.checkNotNullParameter(updater, "updater");
        invalidate();
        updater.accept(getShader());
    }

    public VibeRenderEffectBase(boolean z) {
        this.autoUpdate = z;
        this.shaderUpdated = true;
        this.targetViewSet = new WeakViewHashSet();
        this.onUpdateListeners = new ArrayList<>();
        this.onUpdateListenersEachView = new ArrayList<>();
        this.runningState = State.READY;
        this.invalidationListener = new ViewTreeObserverOnGlobalLayoutListenerC7542d(this, 2);
        this.frameCallback = new ChoreographerFrameCallbackC2251a(this, 1);
    }

    public /* synthetic */ VibeRenderEffectBase(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
