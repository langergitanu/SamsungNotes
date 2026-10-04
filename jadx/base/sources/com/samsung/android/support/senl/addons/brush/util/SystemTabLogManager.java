package com.samsung.android.support.senl.addons.brush.util;

import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0016H\u0016¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/SystemTabLogManager;", "Lcom/samsung/android/support/senl/addons/brush/util/SystemPhoneLogManager;", "<init>", "()V", "onColorSelected", "", "color", "", "onColorPickerSelected", "onSelectColorSetsOpened", "onDoneClicked", "onRedoClicked", "onUndoClicked", "onPaletteSwipeNext", "onPaletteSwipePrev", "onPenUpStart", "getSeekBarChangeIdForPen", "", "type", "onPenClicked", "onEraserClicked", "isEraserSelected", "", "onPaletteChangeSelected", "value", "onSeekBarChanged", "penName", "onShowHideBrushesClicked", "isOpen", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemTabLogManager extends SystemPhoneLogManager {
    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager
    @NotNull
    public String getSeekBarChangeIdForPen(int type) {
        return type == 0 ? "8034" : "8035";
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorPickerSelected() {
        PlatformUtil.insertLog("404", "8032");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onColorSelected(int color) {
        PlatformUtil.insertLog("404", "8029", String.valueOf(color));
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onDoneClicked() {
        PlatformUtil.insertLog("404", "8040");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onEraserClicked(boolean isEraserSelected) {
        if (isEraserSelected) {
            PlatformUtil.insertLog("404", "8037", "2");
        } else {
            PlatformUtil.insertLog("404", "8037", "1");
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPaletteChangeSelected(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        PlatformUtil.insertLog("404", "0101", value);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPaletteSwipeNext() {
        PlatformUtil.insertLog("404", "8030");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPaletteSwipePrev() {
        PlatformUtil.insertLog("404", "8031");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPenClicked() {
        PlatformUtil.insertLog("404", "8028");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onPenUpStart() {
        PlatformUtil.insertLog("404", "8036");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onRedoClicked() {
        PlatformUtil.insertLog("404", "8039");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onSeekBarChanged(int type, int value, @NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        PlatformUtil.insertLog("404", StringsKt.m14162r(penName, "Eraser") ? getSeekBarChangeIdForEraser(type) : getSeekBarChangeIdForPen(type), value);
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onSelectColorSetsOpened() {
        PlatformUtil.insertLog("404", "8033");
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onShowHideBrushesClicked(boolean isOpen) {
    }

    @Override // com.samsung.android.support.senl.addons.brush.util.SystemPhoneLogManager, com.samsung.android.support.senl.addons.brush.util.ISystemLogManager
    public void onUndoClicked() {
        PlatformUtil.insertLog("404", "8038");
    }
}
