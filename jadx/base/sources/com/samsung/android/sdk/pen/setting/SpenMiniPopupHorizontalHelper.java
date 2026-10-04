package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u001c\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupHorizontalHelper;", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupLayoutInterface;", "mLayoutId", "", "<init>", "(I)V", "getChildLayoutLayoutId", "getDefaultButtonParams", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "adjustOverlapMargin", "", "margin", "firstView", "Landroid/view/View;", "secondView", "adjustFront", "view", "frontId", "addView", "parent", "Landroid/view/ViewGroup;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenMiniPopupHorizontalHelper implements SpenMiniPopupLayoutInterface {

    @NotNull
    private static final String TAG = "SpenMiniSettingHorizontalHelper";
    private final int mLayoutId;

    @JvmOverloads
    public SpenMiniPopupHorizontalHelper() {
        this(0, 1, null);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPopupLayoutInterface
    public void addView(@Nullable ViewGroup parent, @Nullable View view) {
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -1);
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        ((ConstraintLayout) parent).addView(view, layoutParams);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPopupLayoutInterface
    public void adjustFront(@Nullable View view, int frontId) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.startToEnd = frontId;
        view.setLayoutParams(layoutParams2);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPopupLayoutInterface
    public void adjustOverlapMargin(int margin, @Nullable View firstView, @Nullable View secondView) {
        AbstractC2322a.m1631u(margin, "adjustOverlapMargin() margin=", TAG);
        if (firstView == null || secondView == null || firstView.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = firstView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginEnd(margin);
        firstView.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = secondView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.setMarginStart(-margin);
        secondView.setLayoutParams(layoutParams4);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPopupLayoutInterface
    /* JADX INFO: renamed from: getChildLayoutLayoutId, reason: from getter */
    public int getMLayoutId() {
        return this.mLayoutId;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPopupLayoutInterface
    @NotNull
    public LinearLayout.LayoutParams getDefaultButtonParams(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C7932R.dimen.mini_popup_button_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C7932R.dimen.mini_popup_button_space);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMarginStart(dimensionPixelSize2);
        layoutParams.setMarginEnd(dimensionPixelSize2);
        return layoutParams;
    }

    @JvmOverloads
    public SpenMiniPopupHorizontalHelper(int i) {
        this.mLayoutId = i;
    }

    public /* synthetic */ SpenMiniPopupHorizontalHelper(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C7932R.layout.setting_mini_popup_land_layout : i);
    }
}
