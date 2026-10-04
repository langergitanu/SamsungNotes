package com.samsung.android.sdk.pen.engine.writingview;

import android.content.Context;
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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000b¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewContext;", "Lcom/samsung/android/sdk/pen/view/context/SpenContext;", "context", "Landroid/content/Context;", "msgQueueHandle", "", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "configuration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "rendererType", "", "<init>", "(Landroid/content/Context;JLcom/samsung/android/sdk/pen/view/SpenDisplay;Lcom/samsung/android/sdk/pen/view/SpenConfiguration;I)V", "nativeInit", "", "nativeFinalize", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWritingViewContext extends SpenContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenComposerContext";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0083 J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewContext$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "msgQueueHandle", "displayHandle", "configurationHandle", "gestureFactoryHandle", "rendererType", "", "animatorUpdateManagerHandle", "Native_finalize", "", "nativeContext", "Native_setColorTheme", BaseWidgetConstant.WIDGET_THEME, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeContext) {
            SpenWritingViewContext.Native_finalize(nativeContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long msgQueueHandle, long displayHandle, long configurationHandle, long gestureFactoryHandle, int rendererType, long animatorUpdateManagerHandle) {
            return SpenWritingViewContext.Native_init(msgQueueHandle, displayHandle, configurationHandle, gestureFactoryHandle, rendererType, animatorUpdateManagerHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setColorTheme(long nativeContext, int theme) {
            SpenWritingViewContext.Native_setColorTheme(nativeContext, theme);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenWritingViewContext(@Nullable Context context, long j, @NotNull SpenDisplay display, @NotNull SpenConfiguration configuration, int i) {
        super(context, j, display, configuration, i);
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2, long j3, long j5, int i, long j6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setColorTheme(long j, int i);

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
            setHandle(companion.Native_init(msgQueueHandle, j, nativeHandle, jLongValue, rendererType, lValueOf2.longValue()));
        }
    }

    public final void setColorTheme(int theme) {
        if (getHandle() != 0) {
            INSTANCE.Native_setColorTheme(getHandle(), theme);
        }
    }
}
