package com.samsung.android.support.senl.p148nt.base.winset.view.palette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u00010B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J&\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0013J \u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0017J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020!H\u0002J\u0016\u0010)\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010*\u001a\u00020+J\u001e\u0010,\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+J \u0010,\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+H\u0014R\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaletteItemList", "", "Landroid/view/View;", "mContext", "mPaletteViewContract", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView$PaletteViewContract;", "mItemScale", "", "initPaletteView", "", "setPaletteViewContract", "paletteViewContract", "setPaletteItemInfo", "defaultSwipeItemCount", "width", "height", WiggleAnimationConfig.KEY_SCALE, "setColor", "index", "color", "name", "", "setResource", "bgPatten", "getPaletteItemBg", "Landroid/graphics/drawable/Drawable;", "setTooltipText", "view", "tooltipText", "updateSelector", "useDarkModeResource", "", "updatePaletteItem", "isSelected", "withAnimation", "paletteItem", "PaletteViewContract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPaletteContainerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PaletteContainerView.kt\ncom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n*L\n1#1,211:1\n28#2:212\n*S KotlinDebug\n*F\n+ 1 PaletteContainerView.kt\ncom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView\n*L\n108#1:212\n*E\n"})
public class PaletteContainerView extends RelativeLayout {

    @Nullable
    private Context mContext;
    private float mItemScale;

    @JvmField
    @Nullable
    protected List<View> mPaletteItemList;

    @Nullable
    private PaletteViewContract mPaletteViewContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView$PaletteViewContract;", "", "onPaletteClicked", "", "index", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface PaletteViewContract {
        void onPaletteClicked(int index);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaletteContainerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initPaletteView(context);
    }

    private final Drawable getPaletteItemBg(int index) {
        int i;
        int i2;
        if (this.mPaletteItemList == null) {
            return null;
        }
        if (LocaleUtils.isRTLMode()) {
            Context context = getContext();
            if (index <= 0) {
                i2 = C8875R.drawable.color_palette_item_last_bg;
            } else {
                List<View> list = this.mPaletteItemList;
                Intrinsics.checkNotNull(list);
                i2 = list.size() + (-1) <= index ? C8875R.drawable.color_palette_item_first_bg : C8875R.drawable.color_palette_item_bg;
            }
            return ContextCompat.getDrawable(context, i2);
        }
        Context context2 = getContext();
        if (index <= 0) {
            i = C8875R.drawable.color_palette_item_first_bg;
        } else {
            List<View> list2 = this.mPaletteItemList;
            Intrinsics.checkNotNull(list2);
            i = list2.size() + (-1) <= index ? C8875R.drawable.color_palette_item_last_bg : C8875R.drawable.color_palette_item_bg;
        }
        return ContextCompat.getDrawable(context2, i);
    }

    private final void initPaletteView(Context context) {
        this.mContext = context;
        this.mPaletteItemList = new ArrayList();
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        setLayoutDirection(3);
        setClipChildren(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPaletteItemInfo$lambda$0(PaletteContainerView paletteContainerView, View view) {
        PaletteViewContract paletteViewContract = paletteContainerView.mPaletteViewContract;
        if (paletteViewContract != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            paletteViewContract.onPaletteClicked(((Integer) tag).intValue());
        }
    }

    private final void setTooltipText(View view, String tooltipText) {
        if (Build.VERSION.SDK_INT > 26) {
            ViewCompat.INSTANCE.getInstance().setTooltipText(view, tooltipText);
        }
        view.setContentDescription(tooltipText);
    }

    public void setColor(int index, int color, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<View> list = this.mPaletteItemList;
        if (list == null || index < 0) {
            return;
        }
        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= index) {
            return;
        }
        List<View> list2 = this.mPaletteItemList;
        Intrinsics.checkNotNull(list2);
        View view = list2.get(index);
        setTooltipText(view, name);
        Drawable paletteItemBg = getPaletteItemBg(index);
        Drawable drawableMutate = paletteItemBg != null ? paletteItemBg.mutate() : null;
        LayerDrawable layerDrawable = drawableMutate instanceof LayerDrawable ? (LayerDrawable) drawableMutate : null;
        if (layerDrawable == null) {
            return;
        }
        layerDrawable.setDrawableByLayerId(C8875R.id.layer_overlay, new ColorDrawable(color));
        view.setBackground(layerDrawable);
    }

    public final void setPaletteItemInfo(int defaultSwipeItemCount, int width, int height, float scale) {
        this.mItemScale = scale;
        List<View> list = this.mPaletteItemList;
        if (list == null) {
            this.mPaletteItemList = new ArrayList();
        } else {
            list.clear();
        }
        removeAllViews();
        for (int i = 0; i < defaultSwipeItemCount; i++) {
            View viewInflate = LayoutInflater.from(this.mContext).inflate(C8875R.layout.background_color_palette_view_item, (ViewGroup) this, false);
            viewInflate.setId(View.generateViewId());
            viewInflate.setTag(Integer.valueOf(i));
            viewInflate.setOnClickListener(new ViewOnClickListenerC8556a(this, 11));
            ImageView imageView = (ImageView) viewInflate.findViewById(C8875R.id.palette_selector);
            imageView.setScaleX(0.0f);
            imageView.setScaleY(0.0f);
            ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (i > 0) {
                layoutParams2.addRule(17, getChildAt(i - 1).getId());
            }
            layoutParams2.width = width;
            layoutParams2.height = height;
            List<View> list2 = this.mPaletteItemList;
            if (list2 != null) {
                Intrinsics.checkNotNull(viewInflate);
                list2.add(viewInflate);
            }
            addView(viewInflate, i, layoutParams2);
        }
    }

    public final void setPaletteViewContract(@Nullable PaletteViewContract paletteViewContract) {
        this.mPaletteViewContract = paletteViewContract;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setResource(int index, int bgPatten, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<View> list = this.mPaletteItemList;
        if (list == null || index < 0) {
            return;
        }
        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= index) {
            return;
        }
        List<View> list2 = this.mPaletteItemList;
        Intrinsics.checkNotNull(list2);
        View view = list2.get(index);
        setTooltipText(view, name);
        Drawable paletteItemBg = getPaletteItemBg(index);
        Drawable drawableMutate = paletteItemBg != null ? paletteItemBg.mutate() : null;
        LayerDrawable layerDrawable = drawableMutate instanceof LayerDrawable ? (LayerDrawable) drawableMutate : null;
        if (layerDrawable == null) {
            return;
        }
        layerDrawable.setDrawableByLayerId(C8875R.id.layer_overlay, getContext().getDrawable(bgPatten));
        view.setBackground(layerDrawable);
    }

    public final void updatePaletteItem(int index, boolean isSelected, boolean withAnimation) {
        List<View> list = this.mPaletteItemList;
        if (list == null || index < 0) {
            return;
        }
        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= index) {
            return;
        }
        List<View> list2 = this.mPaletteItemList;
        Intrinsics.checkNotNull(list2);
        updatePaletteItem(list2.get(index), isSelected, withAnimation);
    }

    public final void updateSelector(int index, boolean useDarkModeResource) {
        List<View> list = this.mPaletteItemList;
        Intrinsics.checkNotNull(list);
        ((ImageView) list.get(index).findViewById(C8875R.id.palette_selector)).setColorFilter(useDarkModeResource ? -1 : -16777216);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaletteContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initPaletteView(context);
    }

    public void updatePaletteItem(@NotNull final View paletteItem, boolean isSelected, boolean withAnimation) {
        int dimensionPixelSize;
        ViewOutlineProvider viewOutlineProvider;
        Intrinsics.checkNotNullParameter(paletteItem, "paletteItem");
        float f = isSelected ? this.mItemScale : 1.0f;
        float f4 = isSelected ? 1.0f : 0.0f;
        ImageView imageView = (ImageView) paletteItem.findViewById(C8875R.id.palette_selector);
        paletteItem.bringToFront();
        if (isSelected) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            dimensionPixelSize = context.getResources().getDimensionPixelSize(C8875R.dimen.page_color_rect_elevation);
        } else {
            dimensionPixelSize = 0;
        }
        paletteItem.setElevation(dimensionPixelSize);
        if (isSelected) {
            viewOutlineProvider = new ViewOutlineProvider() { // from class: com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteContainerView.updatePaletteItem.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline != null) {
                        outline.setRoundRect(0, 0, paletteItem.getWidth(), paletteItem.getHeight(), this.getContext().getResources().getDimensionPixelSize(C8875R.dimen.background_color_palette_radius));
                    }
                }
            };
        } else {
            viewOutlineProvider = ViewOutlineProvider.BACKGROUND;
        }
        paletteItem.setOutlineProvider(viewOutlineProvider);
        paletteItem.setSelected(isSelected);
        if (withAnimation) {
            paletteItem.animate().scaleX(f).scaleY(f).start();
            imageView.animate().scaleX(f4).scaleY(f4).start();
        } else {
            paletteItem.setScaleX(f);
            paletteItem.setScaleY(f);
            imageView.setScaleX(f4);
            imageView.setScaleY(f4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaletteContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initPaletteView(context);
    }
}
