package com.samsung.android.support.senl.addons.brush.util;

import androidx.annotation.IntRange;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u0006\u0010\"\u001a\u00020\u0006J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010)\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000fH\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0006H\u0016¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/SystemPhoneLogManager;", "Lcom/samsung/android/support/senl/addons/brush/util/ISystemLogManager;", "Lcom/samsung/android/support/senl/addons/brush/util/SystemLogConstants;", "<init>", "()V", "onColorPickerUsage", "", "type", "", "onDoneClicked", "onColorSelected", "color", "onSeekBarChanged", "value", "penName", "", "getSeekBarChangeIdForEraser", "getSeekBarChangeIdForPen", "onColorPickerSelected", "onEraseAllClicked", "onEyeDropperOpened", "onEyeDropperHandlerTapped", "onEyeDropperClosed", "onPenClicked", "onSelectColorSetsOpened", "onEraserClicked", "isEraserSelected", "", "onRedoClicked", "onUndoClicked", "onPaletteSwipeNext", "onPaletteSwipePrev", "onZoomIn", "onZoomOut", "clearAll", "onColorPickerDoneClicked", "onPenUpPostingDone", "onPenUpPostingFail", "onPenUpStart", "onTouchByEyedropper", "onBrushSettingOpen", "onObjectAdded", "onBrushEraserSettingPopupClose", "getPenDetails", "onColorGradationClose", "onColorGradationViewModeChange", "viewMode", "onShowHideBrushesClicked", "isOpen", "onPaletteChangeSelected", "onColorGradationChange", "onColorGradationSeekBarChange", "onColorGradationColorItemChange", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SystemPhoneLogManager implements ISystemLogManager, SystemLogConstants {
    private final String getPenDetails(String penName) {
        if (penName == null) {
            return null;
        }
        if (StringsKt.m14162r(penName, "WaterColorBrush")) {
            return "1";
        }
        if (StringsKt.m14162r(penName, "OilBrush")) {
            return "2";
        }
        if (StringsKt.m14162r(penName, "Smudge")) {
            return "6";
        }
        if (StringsKt.m14162r(penName, "ColoredPencil")) {
            return "5";
        }
        if (StringsKt.m14162r(penName, "Pencil")) {
            return "4";
        }
        if (StringsKt.m14162r(penName, "Crayon")) {
            return "9";
        }
        if (StringsKt.m14162r(penName, "AirBrushPen")) {
            return "7";
        }
        if (StringsKt.m14162r(penName, "BrushPen")) {
            return "3";
        }
        if (StringsKt.m14162r(penName, PerfConstants.CodeMarkerParameters.MARKER)) {
            return "8";
        }
        return null;
    }

    private final void onColorPickerDoneClicked() {
        PlatformUtil.insertLog("421", "4255");
    }

    public final void clearAll() {
        PlatformUtil.insertLog("421", "9942", "3");
    }

    @NotNull
    public final String getSeekBarChangeIdForEraser(int type) {
        return type == 0 ? "4222" : "4223";
    }

    @NotNull
    public String getSeekBarChangeIdForPen(int type) {
        return type == 0 ? "4211" : "4212";
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onBrushEraserSettingPopupClose(int type, boolean isEraserSelected) {
        if (type == 0) {
            if (isEraserSelected) {
                PlatformUtil.insertLog("421", "9942", "1");
                return;
            } else {
                PlatformUtil.insertLog("421", "9943", "1");
                return;
            }
        }
        if (type == 1) {
            if (isEraserSelected) {
                PlatformUtil.insertLog("421", "9942", "2");
                return;
            } else {
                PlatformUtil.insertLog("421", "9943", "2");
                return;
            }
        }
        if (type != 2) {
            return;
        }
        if (isEraserSelected) {
            PlatformUtil.insertLog("421", "9942", "3");
        } else {
            PlatformUtil.insertLog("421", "9943", "3");
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onBrushSettingOpen(@Nullable String penName) {
        String penDetails = getPenDetails(penName);
        if (penDetails == null) {
            return;
        }
        PlatformUtil.insertLog("421", "4201", penDetails);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorGradationChange() {
        PlatformUtil.insertLog("421", "4242");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorGradationClose() {
        PlatformUtil.insertLog("421", "4220");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorGradationColorItemChange() {
        PlatformUtil.insertLog("421", "4244");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorGradationSeekBarChange() {
        PlatformUtil.insertLog("421", "4243");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorGradationViewModeChange(int viewMode) {
        PlatformUtil.insertLog("421", "4296", viewMode);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorPickerSelected() {
        PlatformUtil.insertLog("421", "4202");
    }

    public final void onColorPickerUsage(int type) {
        if (type == 0) {
            PlatformUtil.insertLog("421", "9945", "1");
        } else if (type == 1) {
            PlatformUtil.insertLog("421", "9945", "2");
        }
        onColorPickerDoneClicked();
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorSelected(int color) {
        PlatformUtil.insertLog("421", "4205", Integer.toString(color));
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onDoneClicked() {
        PlatformUtil.insertLog("421", "4203");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onEraseAllClicked() {
        PlatformUtil.insertLog("421", "4224");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onEraserClicked(boolean isEraserSelected) {
        if (isEraserSelected) {
            PlatformUtil.insertLog("421", "4206", "2");
        } else {
            PlatformUtil.insertLog("421", "4206", "1");
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onEyeDropperClosed() {
        PlatformUtil.insertLog("421", "4260");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onEyeDropperHandlerTapped() {
        PlatformUtil.insertLog("421", "4259");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onEyeDropperOpened() {
        PlatformUtil.insertLog("421", "4258");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onObjectAdded(@Nullable String penName) {
        String penDetails = getPenDetails(penName);
        if (penDetails == null) {
            return;
        }
        PlatformUtil.insertLog("421", "9941", penDetails);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPaletteChangeSelected(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        PlatformUtil.insertLog("421", "0101", value);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPaletteSwipeNext() {
        PlatformUtil.insertLog("421", "4213");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPaletteSwipePrev() {
        PlatformUtil.insertLog("421", "4214");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPenClicked() {
        PlatformUtil.insertLog("421", "4210");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPenUpPostingDone() {
        PlatformUtil.insertLog("421", "9939", "1");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPenUpPostingFail() {
        PlatformUtil.insertLog("421", "9939", "2");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPenUpStart() {
        PlatformUtil.insertLog("421", "4209");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onRedoClicked() {
        PlatformUtil.insertLog("421", "4208");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onSeekBarChanged(int type, @IntRange(from = 1, m706to = 100) int value, @NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        PlatformUtil.insertLog("421", StringsKt.m14162r(penName, "Eraser") ? getSeekBarChangeIdForEraser(type) : getSeekBarChangeIdForPen(type), value);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onSelectColorSetsOpened() {
        PlatformUtil.insertLog("421", "4217");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onShowHideBrushesClicked(boolean isOpen) {
        PlatformUtil.insertLog("421", "4231", isOpen ? 1L : 0L);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onTouchByEyedropper() {
        PlatformUtil.insertLog("421", "4253");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onUndoClicked() {
        PlatformUtil.insertLog("421", "4207");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onZoomIn() {
        PlatformUtil.insertLog("421", "4215");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onZoomOut() {
        PlatformUtil.insertLog("421", "4216");
    }
}
