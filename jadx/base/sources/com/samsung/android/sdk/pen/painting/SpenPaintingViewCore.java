package com.samsung.android.sdk.pen.painting;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.engine.SpenViewCore;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewCore;", "Lcom/samsung/android/sdk/pen/engine/SpenViewCore;", "context", "Landroid/content/Context;", "nativeViewCore", "", "<init>", "(Landroid/content/Context;J)V", "eraserStyle", "", "getEraserStyle", "()Ljava/lang/String;", "eraserSize", "", "getEraserSize", "()F", "setEraserSettingInfo", "", "eraserInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPaintingViewCore extends SpenViewCore {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenPaintingViewCore";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0083 J!\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0083 J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewCore$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_construct", "", "nativeViewCore", "", "viewCore", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewCore;", "Native_setEraserSettingInfo", "eraserInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "displayHandle", "Native_getEraserStyle", "Native_getEraserSize", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeViewCore, SpenPaintingViewCore viewCore) {
            return SpenPaintingViewCore.Native_construct(nativeViewCore, viewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getEraserSize(long nativeViewCore) {
            return SpenPaintingViewCore.Native_getEraserSize(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getEraserStyle(long nativeViewCore) {
            return SpenPaintingViewCore.Native_getEraserStyle(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setEraserSettingInfo(long nativeViewCore, SpenSettingPenInfo eraserInfo, long displayHandle) {
            return SpenPaintingViewCore.Native_setEraserSettingInfo(nativeViewCore, eraserInfo, displayHandle);
        }

        private Companion() {
        }
    }

    public SpenPaintingViewCore(@Nullable Context context, long j) {
        super(context, j);
        Log.d(TAG, "SpenPaintingViewCore Native_construct start");
        INSTANCE.Native_construct(j, this);
        Log.d(TAG, "SpenPaintingViewCore Native_construct end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenPaintingViewCore spenPaintingViewCore);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getEraserSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getEraserStyle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setEraserSettingInfo(long j, SpenSettingPenInfo spenSettingPenInfo, long j2);

    public final float getEraserSize() {
        if (getNativeViewCore() == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getEraserSize(getNativeViewCore());
    }

    @Nullable
    public final String getEraserStyle() {
        if (getNativeViewCore() == 0) {
            return null;
        }
        return INSTANCE.Native_getEraserStyle(getNativeViewCore());
    }

    public final boolean setEraserSettingInfo(@NotNull SpenSettingPenInfo eraserInfo, @Nullable SpenDisplay display) {
        Intrinsics.checkNotNullParameter(eraserInfo, "eraserInfo");
        if (getNativeViewCore() == 0 || display == null) {
            return false;
        }
        AbstractC2322a.m1609C("setEraserSettingInfo style = ", eraserInfo.name, TAG);
        return INSTANCE.Native_setEraserSettingInfo(getNativeViewCore(), eraserInfo, display.handle);
    }
}
