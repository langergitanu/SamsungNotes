package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import android.content.Context;
import android.content.res.Configuration;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.composer.writing.SpenNoteWritingViewManager;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0010J\u0010\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010+\u001a\u00020\tH\u0002J\u0006\u0010,\u001a\u00020\u0016J\u0016\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;", "", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;)V", "writingViewManager", "Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;", "isSupportedSpenDisplay", "", "isNotDexModeOrStandAloneMode", "isSpenOnlyMode", "()Z", "setSpenOnlyMode", "(Z)V", "lastToolType", "", "Ljava/lang/Integer;", "lastToolAction", "getToolTypeAction", "toolType", "setOnlyToolTypeAction", "", "action", "setToolTypeAction", "setActionWithToolTypeSpen", "follow", "getDefaultPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "changeColor", "color", "getPenColor", "setPenSettingInfo", "penSettingInfo", "setRemoverSettingInfo", "removerSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setSelectionSettingInfo", "selectionSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "setChangeStyleSettingInfo", "changeStyleInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "canUseSpan", "release", "updateDeviceState", "context", "Landroid/content/Context;", "newConfig", "Landroid/content/res/Configuration;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmWritingControl {
    private boolean isNotDexModeOrStandAloneMode;
    private boolean isSpenOnlyMode;
    private boolean isSupportedSpenDisplay;

    @Nullable
    private Integer lastToolAction;

    @Nullable
    private Integer lastToolType;

    @NotNull
    private final SpenNoteWritingViewManager writingViewManager;

    public SmWritingControl(@NotNull SpenTextWritingView spenView) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        SpenNoteWritingViewManager noteWritingViewManager = spenView.getNoteWritingViewManager();
        this.writingViewManager = noteWritingViewManager;
        this.isSupportedSpenDisplay = SpenUtils.isSupportedSpenDisplay(spenView.getContext().getResources().getConfiguration());
        this.isNotDexModeOrStandAloneMode = DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(spenView.getContext());
        this.isSpenOnlyMode = true;
        noteWritingViewManager.setPenSettingInfo(getDefaultPenInfo());
    }

    private final boolean canUseSpan() {
        return ComposerSpenUtils.canUseSpen(this.isSupportedSpenDisplay, this.isNotDexModeOrStandAloneMode);
    }

    private final SpenSettingUIPenInfo getDefaultPenInfo() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
        spenSettingUIPenInfo.name = SpenPenManager.SPEN_FOUNTAIN_PEN;
        spenSettingUIPenInfo.color = -14342875;
        spenSettingUIPenInfo.size = 15.0f;
        spenSettingUIPenInfo.sizeLevel = 30;
        return spenSettingUIPenInfo;
    }

    private final void setActionWithToolTypeSpen(int action, boolean follow) {
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.writingViewManager;
        spenNoteWritingViewManager.setToolTypeAction(3, action);
        if (follow) {
            spenNoteWritingViewManager.setToolTypeAction(1, action);
            spenNoteWritingViewManager.setToolTypeAction(0, action);
        } else {
            spenNoteWritingViewManager.setToolTypeAction(1, 1);
            spenNoteWritingViewManager.setToolTypeAction(0, 1);
        }
    }

    public final void changeColor(int color) {
        SpenSettingUIPenInfo defaultPenInfo = getDefaultPenInfo();
        defaultPenInfo.color = color;
        this.writingViewManager.setPenSettingInfo(defaultPenInfo);
    }

    public final int getPenColor() {
        SpenSettingPenInfo penSettingInfo = this.writingViewManager.getPenSettingInfo();
        Intrinsics.checkNotNull(penSettingInfo);
        return penSettingInfo.color;
    }

    public final int getToolTypeAction(int toolType) {
        return this.writingViewManager.getToolTypeAction(toolType);
    }

    /* JADX INFO: renamed from: isSpenOnlyMode, reason: from getter */
    public final boolean getIsSpenOnlyMode() {
        return this.isSpenOnlyMode;
    }

    public final void release() {
        this.writingViewManager.close();
    }

    public final void setChangeStyleSettingInfo(@Nullable SpenSettingUIChangeStyleInfo changeStyleInfo) {
        this.writingViewManager.setChangeStyleSettingInfo(changeStyleInfo);
    }

    public final void setOnlyToolTypeAction(int toolType, int action) {
        this.writingViewManager.setToolTypeAction(toolType, action);
    }

    public final void setPenSettingInfo(@Nullable SpenSettingUIPenInfo penSettingInfo) {
        this.writingViewManager.setPenSettingInfo(penSettingInfo);
    }

    public final void setRemoverSettingInfo(@Nullable SpenSettingRemoverInfo removerSettingInfo) {
        this.writingViewManager.setRemoverSettingInfo(removerSettingInfo);
    }

    public final void setSelectionSettingInfo(@NotNull SpenSettingSelectionInfo selectionSettingInfo) {
        Intrinsics.checkNotNullParameter(selectionSettingInfo, "selectionSettingInfo");
        this.writingViewManager.setSelectionType(selectionSettingInfo.type);
        this.writingViewManager.setIntersectSelection(selectionSettingInfo.includePartiallySelected);
    }

    public final void setSpenOnlyMode(boolean z) {
        this.isSpenOnlyMode = z;
    }

    public final void setToolTypeAction(int toolType, int action) {
        this.writingViewManager.setToolTypeAction(toolType, action);
        if (toolType == 2) {
            setActionWithToolTypeSpen(action, (action == 16 || (canUseSpan() && this.isSpenOnlyMode)) ? false : true);
        } else if (toolType == 6) {
            this.writingViewManager.setToolTypeAction(4, 8);
        }
        this.lastToolType = Integer.valueOf(toolType);
        this.lastToolAction = Integer.valueOf(action);
    }

    public final void updateDeviceState(@NotNull Context context, @NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.isSupportedSpenDisplay = SpenUtils.isSupportedSpenDisplay(newConfig);
        this.isNotDexModeOrStandAloneMode = DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(context);
    }
}
