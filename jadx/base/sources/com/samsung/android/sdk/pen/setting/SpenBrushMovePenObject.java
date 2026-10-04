package com.samsung.android.sdk.pen.setting;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenBrushMoveObject;
import com.samsung.android.sdk.pen.setting.common.SettingViewLongClickListener;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenListLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMovePenObject;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject;", "view", "Landroid/view/View;", "alignment", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$LongClickListener;", "<init>", "(Landroid/view/View;ILcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$LongClickListener;)V", "getNextMovement", "Lcom/samsung/android/sdk/pen/setting/SpenBrushNextMovement;", "getViewType", "Lcom/samsung/android/sdk/pen/setting/SpenBrushViewType;", "getTagName", "", "setViewLongClickListener", "", "Lcom/samsung/android/sdk/pen/setting/common/SettingViewLongClickListener;", "getCurrentGuideView", "guideControl", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideControl;", "notifyActionPositionChanged", "needUpdatePartner", "", "notifyActionLongClicked", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushMovePenObject extends SpenBrushMoveObject {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushMovePenObject(@NotNull View view, int i, @Nullable SpenBrushMoveObject.LongClickListener longClickListener) {
        super(view, i, longClickListener);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    @Nullable
    public View getCurrentGuideView(@NotNull SpenBrushGuideControl guideControl) {
        Intrinsics.checkNotNullParameter(guideControl, "guideControl");
        return guideControl.getPenGuideView(getMAlignment());
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    @NotNull
    public SpenBrushNextMovement getNextMovement() {
        return new SpenBrushPenNextMovement(getMView());
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    @NotNull
    public String getTagName() {
        return "PEN";
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    @NotNull
    public SpenBrushViewType getViewType() {
        return SpenBrushViewType.PEN;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    public void notifyActionLongClicked() {
        SpenBrushMoveObject.ActionListener mActionListener = getMActionListener();
        if (mActionListener != null) {
            mActionListener.onPenLongClicked();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    public void notifyActionPositionChanged(boolean needUpdatePartner) {
        SpenBrushMoveObject.ActionListener mActionListener = getMActionListener();
        if (mActionListener != null) {
            mActionListener.onPenPositionChanged(getMAlignment(), needUpdatePartner);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject
    public void setViewLongClickListener(@Nullable View view, @Nullable SettingViewLongClickListener listener) {
        SpenBrushPenListLayout spenBrushPenListLayout = (SpenBrushPenListLayout) view;
        if (spenBrushPenListLayout != null) {
            spenBrushPenListLayout.setSettingViewLongClickListener(listener);
        }
    }
}
