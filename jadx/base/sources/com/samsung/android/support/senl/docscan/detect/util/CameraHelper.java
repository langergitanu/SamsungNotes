package com.samsung.android.support.senl.docscan.detect.util;

import android.graphics.Point;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0007J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0007J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0007J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/util/CameraHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ORIENTATIONS", "Landroid/util/SparseIntArray;", "getORIENTATIONS", "()Landroid/util/SparseIntArray;", "clamp", "", "x", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "transformEventByScreenOrientation", "", "event", "Landroid/view/MotionEvent;", "screenOrientation", "surfaceWidth", "surfaceHeight", "getCameraOrientation", "sensorOrientation", "modeContains", "", "modes", "", "mode", "getAspectRatio", "Landroid/util/Size;", "displaySize", "Landroid/graphics/Point;", "previewWidth", "previewHeight", "isLandscape", "orientation", "viewWidth", "viewHeight", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CameraHelper {

    @NotNull
    public static final CameraHelper INSTANCE = new CameraHelper();

    @NotNull
    private static final SparseIntArray ORIENTATIONS;

    @NotNull
    public static final String TAG = "CameraHelper";

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ORIENTATIONS = sparseIntArray;
        sparseIntArray.append(0, 0);
        sparseIntArray.append(1, 90);
        sparseIntArray.append(2, 180);
        sparseIntArray.append(3, 270);
    }

    private CameraHelper() {
    }

    @JvmStatic
    public static final int clamp(int x, int min, int max) {
        return x > max ? max : x < min ? min : x;
    }

    @JvmStatic
    @NotNull
    public static final Size getAspectRatio(@NotNull Point displaySize, int previewWidth, int previewHeight) {
        Intrinsics.checkNotNullParameter(displaySize, "displaySize");
        int i = displaySize.x;
        int i2 = displaySize.y;
        if (i < (i2 * previewWidth) / previewHeight) {
            displaySize.y = (i * previewHeight) / previewWidth;
        } else {
            displaySize.x = (i2 * previewWidth) / previewHeight;
        }
        return new Size(displaySize.x, displaySize.y);
    }

    @JvmStatic
    public static final int getCameraOrientation(int screenOrientation, int sensorOrientation) {
        return ((sensorOrientation - screenOrientation) + PopOverActivityWrapper.DEFAULT_WIDTH) % PopOverActivityWrapper.DEFAULT_WIDTH;
    }

    @JvmStatic
    public static final boolean isLandscape(int viewWidth, int viewHeight) {
        return viewWidth > viewHeight;
    }

    @JvmStatic
    public static final boolean modeContains(@Nullable int[] modes, int mode) {
        if (modes == null) {
            return false;
        }
        for (int i : modes) {
            if (i == mode) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final void transformEventByScreenOrientation(@NotNull MotionEvent event, int screenOrientation, int surfaceWidth, int surfaceHeight) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (screenOrientation == 0) {
            event.setLocation(event.getY(), surfaceWidth - event.getX());
        } else if (screenOrientation == 2) {
            event.setLocation(surfaceHeight - event.getY(), event.getX());
        } else {
            if (screenOrientation != 3) {
                return;
            }
            event.setLocation(surfaceWidth - event.getX(), surfaceHeight - event.getY());
        }
    }

    @NotNull
    public final SparseIntArray getORIENTATIONS() {
        return ORIENTATIONS;
    }

    @JvmStatic
    public static final boolean isLandscape(int orientation) {
        return 90 == orientation || -90 == orientation || orientation == ORIENTATIONS.get(3);
    }
}
