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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H&J\u001c\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\n\u0010\u001d\u001a\u00020\u001e\"\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0014H&J\u001c\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00032\n\u0010\u001d\u001a\u00020\u001e\"\u00020\u0003H&J0\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H&J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020%H&J\u0010\u0010,\u001a\u00020%2\u0006\u0010*\u001a\u00020%H&J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020%H&J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010.\u001a\u00020%H&J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020%H&J,\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u000106j\n\u0012\u0004\u0012\u00020%\u0018\u0001`7H&J4\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u000106j\n\u0012\u0004\u0012\u00020%\u0018\u0001`72\u0006\u00108\u001a\u00020\u0003H&J\b\u00109\u001a\u00020\u0014H&J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0003H&J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u0003H&J\u0010\u0010@\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0003H&J\u0010\u0010A\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0003H&J(\u0010B\u001a\u00020\u00142\u0006\u0010$\u001a\u0002042\u0006\u0010&\u001a\u0002042\u0006\u0010'\u001a\u0002042\u0006\u0010(\u001a\u000204H&J\u0010\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u000204H&J\b\u0010E\u001a\u00020\u0014H&J\b\u0010F\u001a\u00020\u0014H&J\u0012\u0010G\u001a\u00020\u00142\b\u0010H\u001a\u0004\u0018\u00010IH'J\u0012\u0010G\u001a\u00020\u00142\b\u0010H\u001a\u0004\u0018\u00010JH&J\b\u0010K\u001a\u00020\u0014H&J\u0010\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0003H&J\u0012\u0010N\u001a\u00020\u00142\b\u0010O\u001a\u0004\u0018\u00010PH&J\u0012\u0010Q\u001a\u00020\u00142\b\u0010R\u001a\u0004\u0018\u00010SH&J\u0012\u0010T\u001a\u00020\u00142\b\u0010U\u001a\u0004\u0018\u00010VH&J\u0012\u0010W\u001a\u00020\u00142\b\u0010X\u001a\u0004\u0018\u00010YH&J\u0012\u0010Z\u001a\u00020\u00142\b\u0010[\u001a\u0004\u0018\u00010\\H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "", "isFbrDrawPadEnabled", "", "()Z", "isFbrDrawPadSupported", "isPredictionEnabled", "penSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "removerSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "getRemoverSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "close", "", "setDocument", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setIsFbrSupportedFeature", "mIsFbrSupportedFeature", "setAnimationLayerEnabled", "enabled", "setFrontBufferRenderingEnabled", NotesSyncRpcProvider.FORCE_SYNC, "", "onAttachedToWindow", "setPredictionEnabled", "enable", "onLayout", "changed", "left", "", "top", "right", "bottom", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setSelectionType", "type", "setSelectionObjectType", "setSelectionLayer", "layer", "setSelectionPenStyle", "size", "", "colorList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSolidPen", "setSelectionPenStyleAsDefault", "setIntersectSelection", "intersect", "setConnectedSelection", "isConnected", "setNearByTimeSelection", "isNearByTime", "setFreeAreaSelection", "setLimitedAreaSelection", "setLimitedAreaPosition", "setMinZoomScale", WiggleAnimationConfig.KEY_SCALE, "pauseVectorCacheUpdate", "resumeVectorCacheUpdate", "setChangeStyleSettingInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "requestReadyForSave", "setFocusSelectedObjects", "focus", "setColorPickerListener", "colorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "setRecentColorListener", "recentColorListener", "Lcom/samsung/android/sdk/pen/engine/SpenRecentColorListener;", "setSelectionChangeListener", "selectionChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenSelectionChangeListener;", "setToastActionListener", "toastActionListener", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "setRemoverListener", "removerListener", "Lcom/samsung/android/sdk/pen/engine/SpenRemoverListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenNoteWritingViewManager {
    void close();

    @Nullable
    SpenSettingPenInfo getPenSettingInfo();

    @Nullable
    SpenSettingRemoverInfo getRemoverSettingInfo();

    int getToolTypeAction(int toolType);

    boolean isFbrDrawPadEnabled();

    boolean isFbrDrawPadSupported();

    boolean isPredictionEnabled();

    void onAttachedToWindow();

    void onLayout(boolean changed, int left, int top, int right, int bottom);

    void pauseVectorCacheUpdate();

    void requestReadyForSave();

    void resumeVectorCacheUpdate();

    boolean setAnimationLayerEnabled(boolean enabled);

    void setChangeStyleSettingInfo(@Nullable SpenSettingChangeStyleInfo info);

    @Deprecated(message = "")
    void setChangeStyleSettingInfo(@Nullable SpenSettingUIPenInfo info);

    void setColorPickerListener(@Nullable SpenColorPickerListener colorPickerListener);

    void setConnectedSelection(boolean isConnected);

    boolean setDocument(@Nullable SpenWNote doc);

    void setFocusSelectedObjects(boolean focus);

    void setFreeAreaSelection(boolean enable);

    boolean setFrontBufferRenderingEnabled(boolean enabled, @NotNull boolean... force);

    void setIntersectSelection(boolean intersect);

    void setIsFbrSupportedFeature(boolean mIsFbrSupportedFeature);

    void setLimitedAreaPosition(float left, float top, float right, float bottom);

    void setLimitedAreaSelection(boolean enable);

    void setMinZoomScale(float scale);

    void setNearByTimeSelection(boolean isNearByTime);

    void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo);

    void setPredictionEnabled(boolean enable, @NotNull boolean... force);

    void setRecentColorListener(@Nullable SpenRecentColorListener recentColorListener);

    void setRemoverListener(@Nullable SpenRemoverListener removerListener);

    void setRemoverSettingInfo(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo);

    void setSelectionChangeListener(@Nullable SpenSelectionChangeListener selectionChangeListener);

    void setSelectionLayer(int layer);

    void setSelectionObjectType(int type);

    void setSelectionPenStyle(float size, @Nullable ArrayList<Integer> colorList);

    void setSelectionPenStyle(float size, @Nullable ArrayList<Integer> colorList, boolean isSolidPen);

    void setSelectionPenStyleAsDefault();

    void setSelectionType(int type);

    void setToastActionListener(@Nullable SpenToastActionListener toastActionListener);

    void setToolTypeAction(int toolType, int action);
}
