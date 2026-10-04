package com.samsung.android.sdk.pen.view.context;

import android.R;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.TypedValue;
import android.view.WindowManager;
import com.samsung.android.sdk.pen.view.SpenAnimatorUpdateManager;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.view.gesture.SpenGestureFactory;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0014J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u001eH\u0002J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u000bJ\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R$\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/context/SpenContext;", "", "context", "Landroid/content/Context;", "msgQueueHandle", "", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "configuration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "rendererType", "", "<init>", "(Landroid/content/Context;JLcom/samsung/android/sdk/pen/view/SpenDisplay;Lcom/samsung/android/sdk/pen/view/SpenConfiguration;I)V", "value", "handle", "getHandle", "()J", "setHandle", "(J)V", "mContext", "mGestureFactory", "Lcom/samsung/android/sdk/pen/view/gesture/SpenGestureFactory;", "mDisplayManager", "Landroid/hardware/display/DisplayManager;", "mDisplayListener", "Landroid/hardware/display/DisplayManager$DisplayListener;", "mAnimatorUpdateManager", "Lcom/samsung/android/sdk/pen/view/SpenAnimatorUpdateManager;", "nativeInit", "", "close", "nativeFinalize", "setSystemDarkMode", "isSystemDarkMode", "", "updateRefreshRate", "setImageCacheQuality", "imageCacheQuality", "setPrimaryColor", "primaryColor", "getPrimaryColor", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    protected static final String TAG = "SpenContext";
    private long handle;

    @JvmField
    @Nullable
    protected SpenAnimatorUpdateManager mAnimatorUpdateManager;

    @JvmField
    @Nullable
    protected Context mContext;

    @JvmField
    @Nullable
    protected DisplayManager.DisplayListener mDisplayListener;

    @JvmField
    @Nullable
    protected DisplayManager mDisplayManager;

    @JvmField
    @Nullable
    protected SpenGestureFactory mGestureFactory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0083 J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 J\u0019\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0083 J\u0019\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\rH\u0083 J\u0019\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\rH\u0083 J\u0011\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/context/SpenContext$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "msgQueueHandle", "displayHandle", "configurationHandle", "gestureFactoryHandle", "rendererType", "", "animatorUpdateManagerHandle", "Native_setSystemDarkMode", "", "handle", "isSystemDarkMode", "", "Native_setDisplayRefreshRate", "refreshRate", "", "Native_setImageCacheQuality", "imageCacheQuality", "Native_setPrimaryColor", "primaryColor", "Native_finalize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenContext.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long msgQueueHandle, long displayHandle, long configurationHandle, long gestureFactoryHandle, int rendererType, long animatorUpdateManagerHandle) {
            return SpenContext.Native_init(msgQueueHandle, displayHandle, configurationHandle, gestureFactoryHandle, rendererType, animatorUpdateManagerHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDisplayRefreshRate(long handle, float refreshRate) {
            SpenContext.Native_setDisplayRefreshRate(handle, refreshRate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setImageCacheQuality(long handle, int imageCacheQuality) {
            SpenContext.Native_setImageCacheQuality(handle, imageCacheQuality);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPrimaryColor(long handle, int primaryColor) {
            SpenContext.Native_setPrimaryColor(handle, primaryColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSystemDarkMode(long handle, boolean isSystemDarkMode) {
            SpenContext.Native_setSystemDarkMode(handle, isSystemDarkMode);
        }

        private Companion() {
        }
    }

    public SpenContext(@Nullable Context context, long j, @NotNull SpenDisplay display, @NotNull SpenConfiguration configuration, int i) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.mAnimatorUpdateManager = new SpenAnimatorUpdateManager();
        this.mContext = context;
        this.mGestureFactory = new SpenGestureFactory(context);
        nativeInit(j, display, configuration, i);
        Context context2 = this.mContext;
        if (context2 != null) {
            Object systemService = context2 != null ? context2.getSystemService("display") : null;
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            this.mDisplayManager = displayManager;
            if (displayManager != null) {
                DisplayManager.DisplayListener displayListener = new DisplayManager.DisplayListener() { // from class: com.samsung.android.sdk.pen.view.context.SpenContext$1$1
                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayChanged(int displayId) {
                        SpenContext spenContext = this.this$0;
                        if (spenContext.mContext != null) {
                            spenContext.updateRefreshRate();
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayAdded(int displayId) {
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayRemoved(int displayId) {
                    }
                };
                this.mDisplayListener = displayListener;
                displayManager.registerDisplayListener(displayListener, null);
            }
            updateRefreshRate();
            setSystemDarkMode(SpenConfiguration.INSTANCE.isSystemDarkMode(this.mContext));
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3);
            setPrimaryColor(getPrimaryColor(context3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2, long j3, long j5, int i, long j6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDisplayRefreshRate(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setImageCacheQuality(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPrimaryColor(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSystemDarkMode(long j, boolean z);

    private final int getPrimaryColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    private final void setPrimaryColor(int primaryColor) {
        long j = this.handle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setPrimaryColor(j, primaryColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRefreshRate() {
        if (this.handle != 0) {
            Context context = this.mContext;
            Object systemService = context != null ? context.getSystemService("window") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            INSTANCE.Native_setDisplayRefreshRate(this.handle, ((WindowManager) systemService).getDefaultDisplay().getRefreshRate());
        }
    }

    public void close() {
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayListener);
        }
        this.mDisplayListener = null;
        this.mDisplayManager = null;
        this.mContext = null;
        SpenAnimatorUpdateManager spenAnimatorUpdateManager = this.mAnimatorUpdateManager;
        if (spenAnimatorUpdateManager != null) {
            spenAnimatorUpdateManager.close();
        }
        this.mAnimatorUpdateManager = null;
        nativeFinalize();
        SpenGestureFactory spenGestureFactory = this.mGestureFactory;
        if (spenGestureFactory != null) {
            spenGestureFactory.close();
        }
        this.mGestureFactory = null;
    }

    public final long getHandle() {
        return this.handle;
    }

    public void nativeFinalize() {
        long j = this.handle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.handle = 0L;
    }

    public void nativeInit(long msgQueueHandle, @NotNull SpenDisplay display, @NotNull SpenConfiguration configuration, int rendererType) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Companion companion = INSTANCE;
        long j = display.handle;
        long nativeHandle = configuration.getNativeHandle();
        SpenGestureFactory spenGestureFactory = this.mGestureFactory;
        Long lValueOf = spenGestureFactory != null ? Long.valueOf(spenGestureFactory.getNativeHandle()) : null;
        Intrinsics.checkNotNull(lValueOf);
        long jLongValue = lValueOf.longValue();
        SpenAnimatorUpdateManager spenAnimatorUpdateManager = this.mAnimatorUpdateManager;
        Long lValueOf2 = spenAnimatorUpdateManager != null ? Long.valueOf(spenAnimatorUpdateManager.getNativeHandle()) : null;
        Intrinsics.checkNotNull(lValueOf2);
        this.handle = companion.Native_init(msgQueueHandle, j, nativeHandle, jLongValue, rendererType, lValueOf2.longValue());
    }

    public final void setHandle(long j) {
        this.handle = j;
    }

    public final void setImageCacheQuality(int imageCacheQuality) {
        long j = this.handle;
        if (j != 0) {
            INSTANCE.Native_setImageCacheQuality(j, imageCacheQuality);
        }
    }

    public final void setSystemDarkMode(boolean isSystemDarkMode) {
        long j = this.handle;
        if (j != 0) {
            INSTANCE.Native_setSystemDarkMode(j, isSystemDarkMode);
        }
    }
}
