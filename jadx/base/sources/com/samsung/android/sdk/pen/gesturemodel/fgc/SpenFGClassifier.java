package com.samsung.android.sdk.pen.gesturemodel.fgc;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/gesturemodel/fgc/SpenFGClassifier;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "", "nativeFGClassifier", "getNativeFGClassifier", "()J", "init", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFGClassifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFGClassifier.kt\ncom/samsung/android/sdk/pen/gesturemodel/fgc/SpenFGClassifier\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class SpenFGClassifier {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG;
    private long nativeFGClassifier;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\t\u0010\f\u001a\u00020\rH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/gesturemodel/fgc/SpenFGClassifier$Companion;", "", "<init>", "()V", "LOG_TAG", "", "Native_construct", "", "modelBuffer", "", "displayDensity", "", "Native_isGestureModelSupport", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_construct(byte[] modelBuffer, float displayDensity) {
            return SpenFGClassifier.Native_construct(modelBuffer, displayDensity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isGestureModelSupport() {
            return SpenFGClassifier.Native_isGestureModelSupport();
        }

        private Companion() {
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SpenFGClassifier", "getSimpleName(...)");
        LOG_TAG = "SpenFGClassifier";
    }

    public SpenFGClassifier(@Nullable Context context) {
        if (INSTANCE.Native_isGestureModelSupport()) {
            init(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_construct(byte[] bArr, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isGestureModelSupport();

    private final void init(Context context) {
        SpenFGCModelLoader spenFGCModelLoader = context != null ? new SpenFGCModelLoader(context) : null;
        byte[] defaultModelBuffer = spenFGCModelLoader != null ? spenFGCModelLoader.getDefaultModelBuffer() : null;
        Object systemService = context != null ? context.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        long jNative_construct = INSTANCE.Native_construct(defaultModelBuffer, displayMetrics.density);
        this.nativeFGClassifier = jNative_construct;
        if (jNative_construct != 0) {
            Log.i(LOG_TAG, "NativeFGClassifier construct success");
        }
    }

    public final long getNativeFGClassifier() {
        return this.nativeFGClassifier;
    }
}
