package com.samsung.android.sdk.pen.setting.drawing;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\"J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J(\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J(\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H&¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "", "setPenList", "", "penNames", "", "", "resourceInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "setPenInfoList", "penInfoList", "", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenInfo", "", "penName", "color", "", "setUnselectedPen", "getSelectedPenPosition", "getPenCount", "close", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface$OnActionListener;", "setRoundedBackground", "radius", "bgColor", "strokeSize", "strokeColor", "setPenLayoutRatio", "penLayoutPercentWidth", "", "penLayoutPercentHeight", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenBrushPenLayoutInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface$OnActionListener;", "", "onPenClicked", "", "name", "", "isSelected", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onPenClicked(@NotNull String name, boolean isSelected);
    }

    void close();

    int getPenCount();

    int getSelectedPenPosition();

    void setActionListener(@Nullable OnActionListener listener);

    boolean setPenInfo(@Nullable String penName, int color);

    void setPenInfoList(@Nullable List<SpenSettingPenInfo> penInfoList);

    void setPenLayoutRatio(float penLayoutPercentWidth, float penLayoutPercentHeight);

    void setPenList(@Nullable List<String> penNames);

    void setPenList(@Nullable List<String> penNames, @Nullable List<SpenSettingPenResource> resourceInfo);

    void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor);

    void setUnselectedPen();
}
