package com.samsung.android.support.senl.addons.brush.util;

import androidx.annotation.IntRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0018H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020\u0003H&¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/ISystemLogManager;", "", "onPenClicked", "", "onColorSelected", "color", "", "onColorPickerSelected", "onSelectColorSetsOpened", "onDoneClicked", "onPaletteSwipePrev", "onPaletteSwipeNext", "onRedoClicked", "onUndoClicked", "onZoomIn", "onZoomOut", "onObjectAdded", "penName", "", "onSeekBarChanged", "type", "value", "onEraserClicked", "isEraserSelected", "", "onEraseAllClicked", "onBrushSettingOpen", "onBrushEraserSettingPopupClose", "onPenUpStart", "onPenUpPostingDone", "onPenUpPostingFail", "onEyeDropperClosed", "onEyeDropperOpened", "onEyeDropperHandlerTapped", "onTouchByEyedropper", "onColorGradationClose", "onColorGradationViewModeChange", "viewMode", "onShowHideBrushesClicked", "isOpen", "onPaletteChangeSelected", "onColorGradationChange", "onColorGradationSeekBarChange", "onColorGradationColorItemChange", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISystemLogManager {
    void onBrushEraserSettingPopupClose(int type, boolean isEraserSelected);

    void onBrushSettingOpen(@Nullable String penName);

    void onColorGradationChange();

    void onColorGradationClose();

    void onColorGradationColorItemChange();

    void onColorGradationSeekBarChange();

    void onColorGradationViewModeChange(int viewMode);

    void onColorPickerSelected();

    void onColorSelected(int color);

    void onDoneClicked();

    void onEraseAllClicked();

    void onEraserClicked(boolean isEraserSelected);

    void onEyeDropperClosed();

    void onEyeDropperHandlerTapped();

    void onEyeDropperOpened();

    void onObjectAdded(@Nullable String penName);

    void onPaletteChangeSelected(@NotNull String value);

    void onPaletteSwipeNext();

    void onPaletteSwipePrev();

    void onPenClicked();

    void onPenUpPostingDone();

    void onPenUpPostingFail();

    void onPenUpStart();

    void onRedoClicked();

    void onSeekBarChanged(int type, @IntRange(from = 1, m706to = 100) int value, @NotNull String penName);

    void onSelectColorSetsOpened();

    void onShowHideBrushesClicked(boolean isOpen);

    void onTouchByEyedropper();

    void onUndoClicked();

    void onZoomIn();

    void onZoomOut();
}
