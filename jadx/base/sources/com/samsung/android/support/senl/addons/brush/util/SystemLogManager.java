package com.samsung.android.support.senl.addons.brush.util;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 22\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000bJ\u000e\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020 J\u0010\u0010-\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0007J\u0006\u00101\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/SystemLogManager;", "Lcom/samsung/android/support/senl/addons/brush/util/SystemLogConstants;", "<init>", "()V", "mLogManager", "Lcom/samsung/android/support/senl/addons/brush/util/ISystemLogManager;", "updateLogManager", "", "onPenClicked", "onColorSelected", "color", "", "onColorPickerSelected", "onSelectColorSetsOpened", "onDoneClicked", "onPaletteSwipePrev", "onPaletteSwipeNext", "onRedoClicked", "onUndoClicked", "onZoomIn", "onZoomOut", "onObjectAdded", "penName", "", "onSeekBarChanged", "type", "value", "onPenUpPostingFail", "onPenUpStart", "onPenUpPostingDone", "onEraserClicked", "isEraserSelected", "", "onEraseAllClicked", "onBrushEraserSettingPopupClose", "visible", "onEyeDropperClosed", "onEyeDropperHandlerTapped", "onEyeDropperOpened", "onTouchByEyedropper", "onColorGradationClose", "onColorGradationViewModeChange", "viewMode", "onShowHideBrushesClicked", "isOpen", "onBrushSettingOpen", "onPaletteChangeSelected", "onColorGradationChange", "onColorGradationColorItemChange", "onColorGradationSeekBarChange", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemLogManager implements SystemLogConstants {

    @JvmField
    @SuppressLint({"StaticFieldLeak"})
    @NotNull
    public static final SystemLogManager INSTANCE = new SystemLogManager();

    @Nullable
    private ISystemLogManager mLogManager;

    private SystemLogManager() {
        updateLogManager();
    }

    public final void onBrushEraserSettingPopupClose(int type, boolean visible) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onBrushEraserSettingPopupClose(type, visible);
    }

    public final void onBrushSettingOpen(@Nullable String penName) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onBrushSettingOpen(penName);
    }

    public final void onColorGradationChange() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        if (iSystemLogManager != null) {
            iSystemLogManager.onColorGradationChange();
        }
    }

    public final void onColorGradationClose() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onColorGradationClose();
    }

    public final void onColorGradationColorItemChange() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        if (iSystemLogManager != null) {
            iSystemLogManager.onColorGradationColorItemChange();
        }
    }

    public final void onColorGradationSeekBarChange() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        if (iSystemLogManager != null) {
            iSystemLogManager.onColorGradationSeekBarChange();
        }
    }

    public final void onColorGradationViewModeChange(int viewMode) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onColorGradationViewModeChange(viewMode);
    }

    public final void onColorPickerSelected() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onColorPickerSelected();
    }

    public final void onColorSelected(int color) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onColorSelected(color);
    }

    public final void onDoneClicked() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onDoneClicked();
    }

    public final void onEraseAllClicked() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onEraseAllClicked();
    }

    public final void onEraserClicked(boolean isEraserSelected) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onEraserClicked(isEraserSelected);
    }

    public final void onEyeDropperClosed() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onEyeDropperClosed();
    }

    public final void onEyeDropperHandlerTapped() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onEyeDropperHandlerTapped();
    }

    public final void onEyeDropperOpened() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onEyeDropperOpened();
    }

    public final void onObjectAdded(@Nullable String penName) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onObjectAdded(penName);
    }

    public final void onPaletteChangeSelected(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ISystemLogManager iSystemLogManager = this.mLogManager;
        if (iSystemLogManager != null) {
            iSystemLogManager.onPaletteChangeSelected(value);
        }
    }

    public final void onPaletteSwipeNext() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onPaletteSwipeNext();
    }

    public final void onPaletteSwipePrev() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onPaletteSwipePrev();
    }

    public final void onPenClicked() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onPenClicked();
    }

    public final void onPenUpPostingDone() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onPenUpPostingDone();
    }

    public final void onPenUpPostingFail() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onPenUpPostingFail();
    }

    public final void onPenUpStart() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onPenUpStart();
    }

    public final void onRedoClicked() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onRedoClicked();
    }

    public final void onSeekBarChanged(int type, @IntRange(from = 1, m706to = 100) int value, @NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onSeekBarChanged(type, value, penName);
    }

    public final void onSelectColorSetsOpened() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onSelectColorSetsOpened();
    }

    public final void onShowHideBrushesClicked(boolean isOpen) {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onShowHideBrushesClicked(isOpen);
    }

    public final void onTouchByEyedropper() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onTouchByEyedropper();
    }

    public final void onUndoClicked() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onUndoClicked();
    }

    public final void onZoomIn() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onZoomIn();
    }

    public final void onZoomOut() {
        ISystemLogManager iSystemLogManager = this.mLogManager;
        Intrinsics.checkNotNull(iSystemLogManager);
        iSystemLogManager.onZoomOut();
    }

    public final void updateLogManager() {
        this.mLogManager = TabletUtil.isTabletMode() ? new SystemTabLogManager() : new SystemPhoneLogManager();
    }
}
