package com.samsung.android.sdk.composer.writing;

import com.samsung.android.sdk.pen.SpenSettingChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenRecentColorListener;
import com.samsung.android.sdk.pen.engine.SpenRemoverListener;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001c\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\n\u0010 \u001a\u00020!\"\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u001c\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00052\n\u0010 \u001a\u00020!\"\u00020\u0005H\u0016J0\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0016J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u0010-\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020(H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00101\u001a\u00020(H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020(H\u0016J,\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u0002072\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u000109j\n\u0012\u0004\u0012\u00020(\u0018\u0001`:H\u0016J4\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u0002072\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u000109j\n\u0012\u0004\u0012\u00020(\u0018\u0001`:2\u0006\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0017H\u0016J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0005H\u0016J\u0010\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0005H\u0016J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0005H\u0016J(\u0010E\u001a\u00020\u00172\u0006\u0010'\u001a\u0002072\u0006\u0010)\u001a\u0002072\u0006\u0010*\u001a\u0002072\u0006\u0010+\u001a\u000207H\u0016J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u000207H\u0016J\b\u0010H\u001a\u00020\u0017H\u0016J\b\u0010I\u001a\u00020\u0017H\u0016J\u0012\u0010J\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010KH\u0017J\u0012\u0010J\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u0017H\u0016J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u0005H\u0016J\u0012\u0010P\u001a\u00020\u00172\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020\u00172\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0012\u0010V\u001a\u00020\u00172\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0012\u0010Y\u001a\u00020\u00172\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\\\u001a\u00020\u00172\b\u0010]\u001a\u0004\u0018\u00010^H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006_"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManagerNoOp;", "Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "<init>", "()V", "isFbrDrawPadEnabled", "", "()Z", "isFbrDrawPadSupported", "isPredictionEnabled", "info", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "penSettingInfo", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "removerSettingInfo", "getRemoverSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "close", "", "setDocument", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setIsFbrSupportedFeature", "mIsFbrSupportedFeature", "setAnimationLayerEnabled", "enabled", "setFrontBufferRenderingEnabled", NotesSyncRpcProvider.FORCE_SYNC, "", "onAttachedToWindow", "setPredictionEnabled", "enable", "onLayout", "changed", "left", "", "top", "right", "bottom", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setSelectionType", "type", "setSelectionObjectType", "setSelectionLayer", "layer", "setSelectionPenStyle", "size", "", "colorList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSolidPen", "setSelectionPenStyleAsDefault", "setIntersectSelection", "intersect", "setConnectedSelection", "isConnected", "setNearByTimeSelection", "isNearByTime", "setFreeAreaSelection", "setLimitedAreaSelection", "setLimitedAreaPosition", "setMinZoomScale", WiggleAnimationConfig.KEY_SCALE, "pauseVectorCacheUpdate", "resumeVectorCacheUpdate", "setChangeStyleSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "requestReadyForSave", "setFocusSelectedObjects", "focus", "setColorPickerListener", "colorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "setRecentColorListener", "recentColorListener", "Lcom/samsung/android/sdk/pen/engine/SpenRecentColorListener;", "setSelectionChangeListener", "selectionChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenSelectionChangeListener;", "setToastActionListener", "toastActionListener", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "setRemoverListener", "removerListener", "Lcom/samsung/android/sdk/pen/engine/SpenRemoverListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteWritingViewManagerNoOp implements ISpenNoteWritingViewManager {
    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    @Nullable
    public SpenSettingPenInfo getPenSettingInfo() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    @Nullable
    public SpenSettingRemoverInfo getRemoverSettingInfo() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public int getToolTypeAction(int toolType) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean isFbrDrawPadEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean isFbrDrawPadSupported() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean isPredictionEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void onAttachedToWindow() {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void pauseVectorCacheUpdate() {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void requestReadyForSave() {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void resumeVectorCacheUpdate() {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean setAnimationLayerEnabled(boolean enabled) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setChangeStyleSettingInfo(@Nullable SpenSettingChangeStyleInfo info) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setColorPickerListener(@Nullable SpenColorPickerListener colorPickerListener) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setConnectedSelection(boolean isConnected) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean setDocument(@Nullable SpenWNote doc) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setFocusSelectedObjects(boolean focus) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setFreeAreaSelection(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public boolean setFrontBufferRenderingEnabled(boolean enabled, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setIntersectSelection(boolean intersect) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setIsFbrSupportedFeature(boolean mIsFbrSupportedFeature) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setLimitedAreaPosition(float left, float top, float right, float bottom) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setLimitedAreaSelection(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setMinZoomScale(float scale) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setNearByTimeSelection(boolean isNearByTime) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setPredictionEnabled(boolean enable, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setRecentColorListener(@Nullable SpenRecentColorListener recentColorListener) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setRemoverListener(@Nullable SpenRemoverListener removerListener) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setRemoverSettingInfo(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionChangeListener(@Nullable SpenSelectionChangeListener selectionChangeListener) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionLayer(int layer) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionObjectType(int type) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionPenStyle(float size, @Nullable ArrayList<Integer> colorList) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionPenStyleAsDefault() {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionType(int type) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setToastActionListener(@Nullable SpenToastActionListener toastActionListener) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setToolTypeAction(int toolType, int action) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    @Deprecated(message = "")
    public void setChangeStyleSettingInfo(@Nullable SpenSettingUIPenInfo info) {
    }

    @Override // com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager
    public void setSelectionPenStyle(float size, @Nullable ArrayList<Integer> colorList, boolean isSolidPen) {
    }
}
