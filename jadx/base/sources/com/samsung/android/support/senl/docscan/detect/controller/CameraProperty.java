package com.samsung.android.support.senl.docscan.detect.controller;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import androidx.annotation.UiThread;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty;", "", "<init>", "()V", "mCameraState", "Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty$CameraState;", "getMCameraState", "()Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty$CameraState;", "setMCameraState", "(Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty$CameraState;)V", "mOrientation", "", "getMOrientation", "()I", "setMOrientation", "(I)V", "mJpegOrientation", "getMJpegOrientation", "setMJpegOrientation", "setNavigationBarFlag", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "clearNavigationBarFlag", "reloadNavigationBarFlag", "flashMode", "getFlashMode", "setFlashMode", "CameraState", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CameraProperty {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FLASH_UNAVAILABLE = -1;
    public static final float RATIO_TOLERANCE_PICTURE = 0.2f;

    @NotNull
    private CameraState mCameraState = CameraState.CLOSED;
    private int mJpegOrientation;
    private int mOrientation;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty$CameraState;", "", "<init>", "(Ljava/lang/String;I)V", "OPENED", "CLOSED", "PREVIEW", "FOCUSING", "CAPTURING", "WAIT_CONVERGENCE", "FINISH_DETECT", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CameraState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CameraState[] $VALUES;
        public static final CameraState OPENED = new CameraState("OPENED", 0);
        public static final CameraState CLOSED = new CameraState("CLOSED", 1);
        public static final CameraState PREVIEW = new CameraState("PREVIEW", 2);
        public static final CameraState FOCUSING = new CameraState("FOCUSING", 3);
        public static final CameraState CAPTURING = new CameraState("CAPTURING", 4);
        public static final CameraState WAIT_CONVERGENCE = new CameraState("WAIT_CONVERGENCE", 5);
        public static final CameraState FINISH_DETECT = new CameraState("FINISH_DETECT", 6);

        private static final /* synthetic */ CameraState[] $values() {
            return new CameraState[]{OPENED, CLOSED, PREVIEW, FOCUSING, CAPTURING, WAIT_CONVERGENCE, FINISH_DETECT};
        }

        static {
            CameraState[] cameraStateArr$values = $values();
            $VALUES = cameraStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(cameraStateArr$values);
        }

        private CameraState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<CameraState> getEntries() {
            return $ENTRIES;
        }

        public static CameraState valueOf(String str) {
            return (CameraState) Enum.valueOf(CameraState.class, str);
        }

        public static CameraState[] values() {
            return (CameraState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty$Companion;", "", "<init>", "()V", "FLASH_UNAVAILABLE", "", "RATIO_TOLERANCE_PICTURE", "", "isTranslucentNavigationBar", "", "context", "Landroid/content/Context;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isTranslucentNavigationBar(@Nullable Context context) {
            return ResourceUtils.isTabletLayout(context);
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final boolean isTranslucentNavigationBar(@Nullable Context context) {
        return INSTANCE.isTranslucentNavigationBar(context);
    }

    @UiThread
    public final void clearNavigationBarFlag(@Nullable Activity activity) {
        Window window;
        if (!INSTANCE.isTranslucentNavigationBar(activity) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(134217728);
    }

    public final int getFlashMode() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constant.PREF_DOCUMENT_SCAN).getInt(Constant.PREF_KEY_CAMERA_FLASH_MODE, 1);
    }

    @NotNull
    public final CameraState getMCameraState() {
        return this.mCameraState;
    }

    public final int getMJpegOrientation() {
        return this.mJpegOrientation;
    }

    public final int getMOrientation() {
        return this.mOrientation;
    }

    @UiThread
    public final void reloadNavigationBarFlag(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().clearFlags(134217728);
        if (INSTANCE.isTranslucentNavigationBar(activity)) {
            activity.getWindow().addFlags(134217728);
        }
    }

    public final void setFlashMode(int i) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constant.PREF_DOCUMENT_SCAN).putInt(Constant.PREF_KEY_CAMERA_FLASH_MODE, i);
    }

    public final void setMCameraState(@NotNull CameraState cameraState) {
        Intrinsics.checkNotNullParameter(cameraState, "<set-?>");
        this.mCameraState = cameraState;
    }

    public final void setMJpegOrientation(int i) {
        this.mJpegOrientation = i;
    }

    public final void setMOrientation(int i) {
        this.mOrientation = i;
    }

    @UiThread
    public final void setNavigationBarFlag(@Nullable Activity activity) {
        Window window;
        if (!INSTANCE.isTranslucentNavigationBar(activity) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(134217728);
    }
}
