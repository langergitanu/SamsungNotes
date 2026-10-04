package com.samsung.android.sdk.pen.recogengine.hme;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Size;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRenderer;", "", "fontPath", "", "fontSize", "", "ppi", "<init>", "(Ljava/lang/String;FF)V", SettingsConstants.EXTRA_FROM_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS, "Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRendererSettings;", "(Ljava/lang/String;FFLcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRendererSettings;)V", "mNativeHandle", "", "close", "", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/util/Size;", "latexString", "render", "", "bitmap", "Landroid/graphics/Bitmap;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/graphics/PointF;", WiggleAnimationConfig.KEY_SCALE, "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenHmeRenderer";
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083 JK\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\nH\u0083 J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0083 J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0005H\u0083 J1\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRenderer$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "fontPath", "fontSize", "", "ppi", "Native_init_with_color", "textColor", "", "bgColor", "outline", "", "outlineColor", "outlineWidth", "Native_finalize", "", "nativeHandle", "Native_layout", "", "latexString", "Native_render", "bitmap", "Landroid/graphics/Bitmap;", "offsetX", "offsetY", WiggleAnimationConfig.KEY_SCALE, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenHmeRenderer.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(String fontPath, float fontSize, float ppi) {
            return SpenHmeRenderer.Native_init(fontPath, fontSize, ppi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init_with_color(String fontPath, float fontSize, float ppi, int textColor, int bgColor, boolean outline, int outlineColor, float outlineWidth) {
            return SpenHmeRenderer.Native_init_with_color(fontPath, fontSize, ppi, textColor, bgColor, outline, outlineColor, outlineWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] Native_layout(long nativeHandle, String latexString) {
            return SpenHmeRenderer.Native_layout(nativeHandle, latexString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_render(long nativeHandle, Bitmap bitmap, float offsetX, float offsetY, float scale) {
            return SpenHmeRenderer.Native_render(nativeHandle, bitmap, offsetX, offsetY, scale);
        }

        private Companion() {
        }
    }

    public SpenHmeRenderer(@Nullable String str, float f, float f4) {
        AbstractC2322a.m1609C("SpenHmeRenderer fontPath: ", str, TAG);
        this.mNativeHandle = INSTANCE.Native_init(str, f, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(String str, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init_with_color(String str, float f, float f4, int i, int i2, boolean z, int i4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int[] Native_layout(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_render(long j, Bitmap bitmap, float f, float f4, float f5);

    public final void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    @NotNull
    public final Size layout(@NotNull String latexString) {
        Intrinsics.checkNotNullParameter(latexString, "latexString");
        long j = this.mNativeHandle;
        if (j == 0) {
            return new Size(0, 0);
        }
        int[] iArrNative_layout = INSTANCE.Native_layout(j, latexString);
        return iArrNative_layout == null ? new Size(0, 0) : new Size(iArrNative_layout[0], iArrNative_layout[1]);
    }

    public final boolean render(@NotNull Bitmap bitmap, @NotNull PointF offset, float scale) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(offset, "offset");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_render(j, bitmap, offset.x, offset.y, scale);
    }

    public SpenHmeRenderer(@Nullable String str, float f, float f4, @NotNull SpenHmeRendererSettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        AbstractC2322a.m1609C("SpenHmeRenderer fontPath: ", str, TAG);
        this.mNativeHandle = INSTANCE.Native_init_with_color(str, f, f4, settings.getTextColor(), settings.getBgColor(), settings.getMOutline(), settings.getOutlineColor(), settings.getOutlineWidth());
    }
}
