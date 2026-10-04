package com.samsung.android.sdk.composer.view.context;

import android.content.Context;
import com.samsung.android.sdk.pen.util.SpenAnalyticsUtil;
import com.samsung.android.sdk.pen.view.SpenAnimatorUpdateManager;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.view.context.SpenContext;
import com.samsung.android.sdk.pen.view.gesture.SpenGestureFactory;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0012R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001a¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext;", "Lcom/samsung/android/sdk/pen/view/context/SpenContext;", "context", "Landroid/content/Context;", "msgQueueHandle", "", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "configuration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "rendererType", "", "<init>", "(Landroid/content/Context;JLcom/samsung/android/sdk/pen/view/SpenDisplay;Lcom/samsung/android/sdk/pen/view/SpenConfiguration;I)V", "mMode", "mEditMode", "mColorTheme", "nativeInit", "", "nativeFinalize", "close", "setEditMode", "mode", "getMode", "()I", "setMode", "(I)V", "setDesktopMode", "desktopMode", "", BaseWidgetConstant.WIDGET_THEME, "colorTheme", "getColorTheme", "setColorTheme", "onViewDetachedFromWindow", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerContext extends SpenContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenComposerContext";
    private int mColorTheme;
    private int mEditMode;
    private int mMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0083 J\u0019\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0083 J\u0019\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0083 J\u0019\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "context", "Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext;", "displayHandle", "configurationHandle", "msgQueueHandle", "gestureFactoryHandle", "rendererType", "", "animatorUpdateManagerHandle", "Native_finalize", "", "nativeContext", "Native_setMode", "mode", "Native_setEditMode", "Native_setDesktopMode", "desktopMode", "", "Native_setColorTheme", BaseWidgetConstant.WIDGET_THEME, "Native_setRefreshRate", "refreshRate", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeContext) {
            SpenComposerContext.Native_finalize(nativeContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenComposerContext context, long displayHandle, long configurationHandle, long msgQueueHandle, long gestureFactoryHandle, int rendererType, long animatorUpdateManagerHandle) {
            return SpenComposerContext.Native_init(context, displayHandle, configurationHandle, msgQueueHandle, gestureFactoryHandle, rendererType, animatorUpdateManagerHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setColorTheme(long nativeContext, int theme) {
            SpenComposerContext.Native_setColorTheme(nativeContext, theme);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDesktopMode(long nativeContext, boolean desktopMode) {
            SpenComposerContext.Native_setDesktopMode(nativeContext, desktopMode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setEditMode(long nativeContext, int mode) {
            SpenComposerContext.Native_setEditMode(nativeContext, mode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setMode(long nativeContext, int mode) {
            SpenComposerContext.Native_setMode(nativeContext, mode);
        }

        @JvmStatic
        private final void Native_setRefreshRate(long nativeContext, float refreshRate) {
            SpenComposerContext.Native_setRefreshRate(nativeContext, refreshRate);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposerContext(@Nullable Context context, long j, @NotNull SpenDisplay display, @NotNull SpenConfiguration configuration, int i) {
        super(context, j, display, configuration, i);
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenComposerContext spenComposerContext, long j, long j2, long j3, long j5, int i, long j6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setColorTheme(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDesktopMode(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setEditMode(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setMode(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRefreshRate(long j, float f);

    @Override // com.samsung.android.sdk.pen.view.context.SpenContext
    public void close() {
        super.close();
        SpenAnalyticsUtil.INSTANCE.getInstance().setListener(null);
    }

    /* JADX INFO: renamed from: getColorTheme, reason: from getter */
    public final int getMColorTheme() {
        return this.mColorTheme;
    }

    /* JADX INFO: renamed from: getMode, reason: from getter */
    public final int getMMode() {
        return this.mMode;
    }

    @Override // com.samsung.android.sdk.pen.view.context.SpenContext
    public void nativeFinalize() {
        if (getHandle() != 0) {
            INSTANCE.Native_finalize(getHandle());
            setHandle(0L);
        }
    }

    @Override // com.samsung.android.sdk.pen.view.context.SpenContext
    public void nativeInit(long msgQueueHandle, @NotNull SpenDisplay display, @NotNull SpenConfiguration configuration, int rendererType) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (this.mContext != null) {
            this.mAnimatorUpdateManager = new SpenAnimatorUpdateManager();
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
            setHandle(companion.Native_init(this, j, nativeHandle, msgQueueHandle, jLongValue, rendererType, lValueOf2.longValue()));
            SpenConfiguration.Companion companion2 = SpenConfiguration.INSTANCE;
            setDesktopMode(companion2.isDesktopMode(this.mContext));
            boolean zIsSystemDarkMode = companion2.isSystemDarkMode(this.mContext);
            setSystemDarkMode(zIsSystemDarkMode);
            setColorTheme(zIsSystemDarkMode ? 1 : 0);
            SpenAnalyticsUtil.INSTANCE.getInstance().init();
        }
    }

    public final void onViewDetachedFromWindow() {
        SpenAnimatorUpdateManager spenAnimatorUpdateManager;
        if (getHandle() == 0 || (spenAnimatorUpdateManager = this.mAnimatorUpdateManager) == null) {
            return;
        }
        spenAnimatorUpdateManager.onViewDetachedFromWindow();
    }

    public final void setColorTheme(int i) {
        if (getHandle() != 0) {
            this.mColorTheme = i;
            INSTANCE.Native_setColorTheme(getHandle(), i);
        }
    }

    public final void setDesktopMode(boolean desktopMode) {
        if (getHandle() != 0) {
            INSTANCE.Native_setDesktopMode(getHandle(), desktopMode);
        }
    }

    public final void setEditMode(int mode) {
        if (getHandle() == 0 || this.mEditMode == mode) {
            return;
        }
        this.mEditMode = mode;
        INSTANCE.Native_setEditMode(getHandle(), mode);
    }

    public final void setMode(int i) {
        if (getHandle() == 0 || this.mMode == i) {
            return;
        }
        this.mMode = i;
        INSTANCE.Native_setMode(getHandle(), i);
    }
}
