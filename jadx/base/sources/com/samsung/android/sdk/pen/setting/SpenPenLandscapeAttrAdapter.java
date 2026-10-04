package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 62\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000267B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0019J.\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fJ0\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002J(\u0010\"\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0017\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\u001c\u0010+\u001a\u00020\u00192\n\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010-\u001a\u00020\u0016H\u0016J&\u0010.\u001a\u00020\u00192\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenLandscapeAttrAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/sdk/pen/setting/SpenPenLandscapeAttrAdapter$PenViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "layoutManager", "Lcom/samsung/android/sdk/pen/setting/SpenPenLayoutManager;", "attrParent", "Landroid/widget/LinearLayout;", "attrGroup", "colorGroup", "Landroid/widget/FrameLayout;", "attached", "", "isAlphaVisible", "Ljava/lang/Boolean;", "isWidthVisible", "isDynamicSizeVisible", "isOpacityOptionVisible", "sizeTopMargin", "", "sizeTopMarginWithTogether", "setLayoutManager", "", "manager", "detachChild", "setAttributeVisibility", "isWidthVisibility", "isDynamicSizeVisibility", "isOpacityOptionVisibility", "animation", "adjustLayout", "getSizeTopMargin", "getVisibility", "isVisible", "(Ljava/lang/Boolean;)I", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "addAttributeView", "child", "Landroid/view/View;", "topMargin", "getPixelSize", "resources", "Landroid/content/res/Resources;", "dimenId", "Companion", "PenViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPenLandscapeAttrAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPenLandscapeAttrAdapter.kt\ncom/samsung/android/sdk/pen/setting/SpenPenLandscapeAttrAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
public final class SpenPenLandscapeAttrAdapter extends RecyclerView.Adapter<PenViewHolder> {

    @NotNull
    private static final String TAG = "SpenPenLandscapeAttrAdapter";
    private boolean attached;

    @Nullable
    private LinearLayout attrGroup;

    @Nullable
    private LinearLayout attrParent;

    @Nullable
    private FrameLayout colorGroup;

    @Nullable
    private Boolean isAlphaVisible;

    @Nullable
    private Boolean isDynamicSizeVisible;

    @Nullable
    private Boolean isOpacityOptionVisible;

    @Nullable
    private Boolean isWidthVisible;

    @Nullable
    private SpenPenLayoutManager layoutManager;
    private final int sizeTopMargin;
    private final int sizeTopMarginWithTogether;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenLandscapeAttrAdapter$PenViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/SpenPenLandscapeAttrAdapter;Landroid/view/View;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class PenViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SpenPenLandscapeAttrAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PenViewHolder(@NotNull SpenPenLandscapeAttrAdapter spenPenLandscapeAttrAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenPenLandscapeAttrAdapter;
        }
    }

    public SpenPenLandscapeAttrAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        this.sizeTopMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_landscape_size_default_margin_top);
        this.sizeTopMarginWithTogether = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_landscape_size_together_margin_top);
    }

    private final void addAttributeView(ViewGroup parent, View child, int topMargin) {
        if (child != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = topMargin;
            child.setVisibility(0);
            if (parent != null) {
                parent.addView(child, layoutParams);
            }
        }
    }

    public static /* synthetic */ void addAttributeView$default(SpenPenLandscapeAttrAdapter spenPenLandscapeAttrAdapter, ViewGroup viewGroup, View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            viewGroup = null;
        }
        spenPenLandscapeAttrAdapter.addAttributeView(viewGroup, view, i);
    }

    private final boolean adjustLayout(boolean isAlphaVisible, boolean isWidthVisibility, boolean isDynamicSizeVisibility, boolean isOpacityOptionVisibility, boolean animation) {
        SpenPenLayoutManager spenPenLayoutManager = this.layoutManager;
        if (spenPenLayoutManager == null) {
            return false;
        }
        spenPenLayoutManager.setAttributeVisibility(isAlphaVisible, isWidthVisibility, isDynamicSizeVisibility, isOpacityOptionVisibility, animation);
        int sizeTopMargin = getSizeTopMargin(isAlphaVisible, isWidthVisibility, isDynamicSizeVisibility, isOpacityOptionVisibility);
        View sizeView = spenPenLayoutManager.getSizeView();
        ViewGroup.LayoutParams layoutParams = sizeView != null ? sizeView.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2.topMargin == sizeTopMargin) {
            return true;
        }
        layoutParams2.topMargin = sizeTopMargin;
        View sizeView2 = spenPenLayoutManager.getSizeView();
        if (sizeView2 == null) {
            return true;
        }
        sizeView2.setLayoutParams(layoutParams2);
        return true;
    }

    private final int getPixelSize(Resources resources, int dimenId) {
        return resources.getDimensionPixelSize(dimenId);
    }

    private final int getSizeTopMargin(boolean isAlphaVisible, boolean isWidthVisibility, boolean isDynamicSizeVisibility, boolean isOpacityOptionVisibility) {
        return (isAlphaVisible || isWidthVisibility || isDynamicSizeVisibility || isOpacityOptionVisibility) ? this.sizeTopMarginWithTogether : this.sizeTopMargin;
    }

    private final int getVisibility(Boolean isVisible) {
        return (isVisible == null || !isVisible.booleanValue()) ? 8 : 0;
    }

    public final void detachChild() {
        LinearLayout linearLayout = this.attrGroup;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.attrGroup = null;
        FrameLayout frameLayout = this.colorGroup;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.colorGroup = null;
        LinearLayout linearLayout2 = this.attrParent;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        this.attrParent = null;
        this.attached = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.layoutManager != null ? 1 : 0;
    }

    public final boolean setAttributeVisibility(boolean isAlphaVisible, boolean isWidthVisibility, boolean isDynamicSizeVisibility, boolean isOpacityOptionVisibility, boolean animation) {
        AbstractC4539a.m3208r("setAttributeVisibility() attached=", TAG, this.attached);
        if (this.attached) {
            this.isAlphaVisible = null;
            this.isWidthVisible = null;
            this.isDynamicSizeVisible = null;
            this.isOpacityOptionVisible = null;
            return adjustLayout(isAlphaVisible, isWidthVisibility, isDynamicSizeVisibility, isOpacityOptionVisibility, animation);
        }
        this.isAlphaVisible = Boolean.valueOf(isAlphaVisible);
        this.isWidthVisible = Boolean.valueOf(isWidthVisibility);
        this.isDynamicSizeVisible = Boolean.valueOf(isDynamicSizeVisibility);
        this.isOpacityOptionVisible = Boolean.valueOf(isOpacityOptionVisibility);
        return true;
    }

    public final void setLayoutManager(@NotNull SpenPenLayoutManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.layoutManager = manager;
    }

    private final int getSizeTopMargin() {
        Boolean bool = this.isAlphaVisible;
        if (bool == null || this.isWidthVisible == null || this.isDynamicSizeVisible == null || this.isOpacityOptionVisible == null) {
            return C7932R.dimen.setting_pen_layout_size_margin_top_default;
        }
        Intrinsics.checkNotNull(bool);
        boolean zBooleanValue = bool.booleanValue();
        Boolean bool2 = this.isWidthVisible;
        Intrinsics.checkNotNull(bool2);
        boolean zBooleanValue2 = bool2.booleanValue();
        Boolean bool3 = this.isDynamicSizeVisible;
        Intrinsics.checkNotNull(bool3);
        boolean zBooleanValue3 = bool3.booleanValue();
        Boolean bool4 = this.isOpacityOptionVisible;
        Intrinsics.checkNotNull(bool4);
        return getSizeTopMargin(zBooleanValue, zBooleanValue2, zBooleanValue3, bool4.booleanValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull PenViewHolder holder, int position) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.i(TAG, "onBindViewHolder() position=" + position);
        if (!this.attached || (bool = this.isAlphaVisible) == null) {
            return;
        }
        Intrinsics.checkNotNull(bool);
        boolean zBooleanValue = bool.booleanValue();
        Boolean bool2 = this.isWidthVisible;
        Intrinsics.checkNotNull(bool2);
        boolean zBooleanValue2 = bool2.booleanValue();
        Boolean bool3 = this.isDynamicSizeVisible;
        Intrinsics.checkNotNull(bool3);
        boolean zBooleanValue3 = bool3.booleanValue();
        Boolean bool4 = this.isOpacityOptionVisible;
        Intrinsics.checkNotNull(bool4);
        adjustLayout(zBooleanValue, zBooleanValue2, zBooleanValue3, bool4.booleanValue(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public PenViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AbstractC4539a.m3208r("onCreateViewHolder() attached=", TAG, this.attached);
        if (this.attached) {
            Log.i(TAG, "onCreateViewHolder() Already attached child. so detach it.");
            detachChild();
        }
        Context context = parent.getContext();
        boolean z = false;
        View viewInflate = LayoutInflater.from(context).inflate(C7932R.layout.setting_pen_land_attr_item, parent, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        this.attrParent = linearLayout;
        this.attrGroup = linearLayout != null ? (LinearLayout) linearLayout.findViewById(C7932R.id.pen_attribute_group) : null;
        SpenPenLayoutManager spenPenLayoutManager = this.layoutManager;
        if (spenPenLayoutManager != null) {
            Resources resources = context.getResources();
            addAttributeView(this.attrGroup, spenPenLayoutManager.getSizeView(), getSizeTopMargin());
            LinearLayout linearLayout2 = this.attrGroup;
            View alphaView = spenPenLayoutManager.getAlphaView();
            Intrinsics.checkNotNull(resources);
            addAttributeView(linearLayout2, alphaView, getPixelSize(resources, C7932R.dimen.setting_pen_layout_landscape_opacity_margin_top));
            addAttributeView(this.attrGroup, spenPenLayoutManager.getWidthView(), getPixelSize(resources, C7932R.dimen.setting_pen_layout_landscape_width_margin_top));
            addAttributeView(this.attrGroup, spenPenLayoutManager.getDynamicSizeView(), getPixelSize(resources, C7932R.dimen.setting_pen_layout_landscape_dynamic_size_margin_top));
            addAttributeView(this.attrGroup, spenPenLayoutManager.getOpacityOptionView(), getPixelSize(resources, C7932R.dimen.setting_pen_layout_landscape_opacity_option_margin_top));
            if (spenPenLayoutManager.getColorView() != null && spenPenLayoutManager.getPatternView() != null) {
                z = true;
            }
            ViewGroup viewGroup = this.attrParent;
            Intrinsics.checkNotNull(viewGroup);
            if (z) {
                FrameLayout frameLayout = new FrameLayout(context);
                this.colorGroup = frameLayout;
                viewGroup.addView(frameLayout);
                viewGroup = this.colorGroup;
                Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type android.widget.FrameLayout");
            }
            View colorView = spenPenLayoutManager.getColorView();
            if (colorView != null) {
                viewGroup.addView(colorView);
            }
            View patternView = spenPenLayoutManager.getPatternView();
            if (patternView != null) {
                viewGroup.addView(patternView);
            }
        }
        this.attached = true;
        LinearLayout linearLayout3 = this.attrParent;
        Intrinsics.checkNotNull(linearLayout3);
        return new PenViewHolder(this, linearLayout3);
    }
}
