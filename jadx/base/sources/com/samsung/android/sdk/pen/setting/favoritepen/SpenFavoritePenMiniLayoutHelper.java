package com.samsung.android.sdk.pen.setting.favoritepen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper;
import com.samsung.android.sdk.pen.setting.widget.SpenRecyclerView;
import com.samsung.android.spen.C7932R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0005J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u001a\u0010 \u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010!\u001a\u0004\u0018\u00010\"J0\u0010\u001e\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010\u0015R\u0013\u0010'\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutHelper;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "context", "Landroid/content/Context;", "orientation", "", "<init>", "(Landroid/content/Context;I)V", "mViewModeLayoutMinHeight", "mEditModeLayoutMinHeight", "mEditModeLayoutMinWidth", "mDefaultRadius", "mEditRadius", "", "mViewRadius", "mVerticalFirstItemTopMargin", "mFavoriteView", "Lcom/samsung/android/sdk/pen/setting/widget/SpenRecyclerView;", "close", "", "getOrientation", "()I", "setOrientation", "(I)V", "favoriteParams", "Landroid/view/ViewGroup$LayoutParams;", "getFavoriteParams", "()Landroid/view/ViewGroup$LayoutParams;", "setFavoriteView", "favoriteView", "setRadius", "mode", "updateFavoriteMinSize", "adapter", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter;", "target", "Landroid/view/View;", "layoutOrientation", "getLayoutOrientation", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "radius", "lt", "", "rt", "rb", "lb", "applyRadius", "decideRadius", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoritePenMiniLayoutHelper extends SpenLayoutConfigHelper {
    private final int mDefaultRadius;
    private final int mEditModeLayoutMinHeight;
    private final int mEditModeLayoutMinWidth;

    @NotNull
    private final float[] mEditRadius;

    @Nullable
    private SpenRecyclerView mFavoriteView;
    private final int mVerticalFirstItemTopMargin;
    private final int mViewModeLayoutMinHeight;

    @NotNull
    private final float[] mViewRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenMiniLayoutHelper(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEditRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.mViewRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        Resources resources = context.getResources();
        this.mViewModeLayoutMinHeight = resources.getDimensionPixelSize(C7932R.dimen.mini_favorite_setting_list_min_height);
        this.mEditModeLayoutMinHeight = resources.getDimensionPixelSize(C7932R.dimen.mini_favorite_setting_edit_content_min_height);
        this.mEditModeLayoutMinWidth = resources.getDimensionPixelSize(C7932R.dimen.mini_favorite_setting_edit_content_min_width);
        this.mDefaultRadius = resources.getDimensionPixelSize(C7932R.dimen.mini_popup_radius);
        this.mVerticalFirstItemTopMargin = resources.getDimensionPixelSize(C7932R.dimen.mini_favorite_setting_first_item_margin);
        decideRadius();
    }

    private final void applyRadius(float[] radius) {
        SpenRecyclerView spenRecyclerView = this.mFavoriteView;
        if (spenRecyclerView != null) {
            spenRecyclerView.setRadius(radius[0], radius[1], radius[2], radius[3]);
        }
    }

    private final void decideRadius() {
        SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper;
        if (isVertical()) {
            float[] fArr = this.mViewRadius;
            int i = this.mDefaultRadius;
            setRadius(fArr, i, i, 0.0f, 0.0f);
            spenFavoritePenMiniLayoutHelper = this;
        } else {
            spenFavoritePenMiniLayoutHelper = this;
            float[] fArr2 = spenFavoritePenMiniLayoutHelper.mViewRadius;
            int i2 = spenFavoritePenMiniLayoutHelper.mDefaultRadius;
            spenFavoritePenMiniLayoutHelper.setRadius(fArr2, i2, 0.0f, 0.0f, i2);
        }
        spenFavoritePenMiniLayoutHelper.setRadius(spenFavoritePenMiniLayoutHelper.mEditRadius, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void close() {
        this.mFavoriteView = null;
    }

    @NotNull
    public final ViewGroup.LayoutParams getFavoriteParams() {
        if (isVertical()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(14);
            return layoutParams;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(15);
        return layoutParams2;
    }

    @Nullable
    public final RecyclerView.ItemDecoration getItemDecoration() {
        if (isHorizontal()) {
            return null;
        }
        return new RecyclerView.ItemDecoration() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutHelper$itemDecoration$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = this.this$0.mVerticalFirstItemTopMargin;
                }
            }
        };
    }

    public final int getLayoutOrientation() {
        return getMOrientation() == 0 ? 0 : 1;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper
    /* JADX INFO: renamed from: getOrientation */
    public int getMOrientation() {
        return super.getMOrientation();
    }

    public final void setFavoriteView(@Nullable SpenRecyclerView favoriteView) {
        this.mFavoriteView = favoriteView;
        setRadius(1);
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper
    public void setOrientation(int i) {
        super.setOrientation(i);
        decideRadius();
    }

    public final void setRadius(int mode) {
        if (mode == 1) {
            applyRadius(this.mViewRadius);
        } else {
            if (mode != 2) {
                return;
            }
            applyRadius(this.mEditRadius);
        }
    }

    @Deprecated(message = "")
    public final void updateFavoriteMinSize(@Nullable SpenFavoritePenMiniAdapter adapter) {
        updateFavoriteMinSize(this.mFavoriteView, adapter);
    }

    public final void updateFavoriteMinSize(@Nullable View target, @Nullable SpenFavoritePenMiniAdapter adapter) {
        if (this.mFavoriteView == null || target == null) {
            return;
        }
        int i = this.mViewModeLayoutMinHeight;
        if (adapter != null && adapter.getMode() == 2) {
            i = isVertical() ? this.mEditModeLayoutMinHeight : this.mEditModeLayoutMinWidth;
        }
        if (isVertical()) {
            target.setMinimumHeight(i);
        } else {
            target.setMinimumWidth(i);
        }
    }

    private final void setRadius(float[] radius, float lt, float rt, float rb, float lb) {
        radius[0] = lt;
        radius[1] = rt;
        radius[2] = rb;
        radius[3] = lb;
    }
}
