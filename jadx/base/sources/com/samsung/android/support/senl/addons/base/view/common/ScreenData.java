package com.samsung.android.support.senl.addons.base.view.common;

import android.util.DisplayMetrics;
import android.util.Size;
import android.view.Display;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenData;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/common/ScreenData;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenData;", "display", "Landroid/view/Display;", "naviBarHeight", "", "<init>", "(Landroid/view/Display;I)V", "mWindowSize", "Landroid/util/Size;", "mWindowResolution", "", "mDeviceScreenSize", "mDeviceScreenResolution", "mContentScreenSize", "mContentResolution", "setWindowSize", "", "getWindowSize", "getWindowResolution", "setDeviceScreenSize", "getScreenSize", "getScreenResolution", "setContentScreenSize", "getContentScreenSize", "getContentResolution", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenData implements IScreenData {
    private float mContentResolution;

    @NotNull
    private Size mContentScreenSize;
    private int mDeviceScreenResolution;

    @NotNull
    private Size mDeviceScreenSize;
    private float mWindowResolution;

    @NotNull
    private Size mWindowSize;

    public ScreenData(@NotNull Display display, int i) {
        Intrinsics.checkNotNullParameter(display, "display");
        this.mWindowSize = new Size(0, 0);
        this.mDeviceScreenSize = new Size(0, 0);
        this.mContentScreenSize = new Size(0, 0);
        setWindowSize(display);
        setDeviceScreenSize(display);
        setContentScreenSize(display, i);
    }

    private final void setContentScreenSize(Display display, int naviBarHeight) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (naviBarHeight > 0) {
            if (!TabletUtil.isTabletMode() && i >= i2) {
                i -= naviBarHeight;
            } else {
                i2 -= naviBarHeight;
            }
        }
        this.mContentScreenSize = new Size(i, i2);
        this.mContentResolution = displayMetrics.density;
    }

    private final void setDeviceScreenSize(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        this.mDeviceScreenSize = new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.mDeviceScreenResolution = displayMetrics.densityDpi;
    }

    private final void setWindowSize(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        this.mWindowSize = new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.mWindowResolution = displayMetrics.densityDpi;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getContentResolution, reason: from getter */
    public float getMContentResolution() {
        return this.mContentResolution;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getContentScreenSize, reason: from getter */
    public Size getMContentScreenSize() {
        return this.mContentScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getScreenResolution, reason: from getter */
    public int getMDeviceScreenResolution() {
        return this.mDeviceScreenResolution;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getScreenSize, reason: from getter */
    public Size getMDeviceScreenSize() {
        return this.mDeviceScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getWindowResolution, reason: from getter */
    public float getMWindowResolution() {
        return this.mWindowResolution;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getWindowSize, reason: from getter */
    public Size getMWindowSize() {
        return this.mWindowSize;
    }
}
