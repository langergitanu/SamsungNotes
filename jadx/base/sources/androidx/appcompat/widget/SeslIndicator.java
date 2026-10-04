package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019¨\u0006-"}, m13886d2 = {"Landroidx/appcompat/widget/SeslIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Landroid/graphics/drawable/Drawable;", "defaultCircle", "getDefaultCircle", "()Landroid/graphics/drawable/Drawable;", "setDefaultCircle", "(Landroid/graphics/drawable/Drawable;)V", "indicator", "", "Landroidx/appcompat/widget/SeslIndicator$PageIndicatorMarker;", "itemClickListener", "Landroidx/appcompat/widget/SeslIndicator$OnItemClickListener;", "selectCircle", "getSelectCircle", "setSelectCircle", "", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "size", "getSize", "addIndicator", "", "sizeType", "(Ljava/lang/Integer;)V", "generateDotIndicator", "(Ljava/lang/Integer;)Landroidx/appcompat/widget/SeslIndicator$PageIndicatorMarker;", "getAppBarViewPagerIndicatorOffColor", "getAppBarViewPagerIndicatorOnColor", "invalidateIndicator", "removeIndicator", "position", "setOnItemClickListener", "Companion", "OnItemClickListener", "PageIndicatorMarker", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSeslIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeslIndicator.kt\nandroidx/appcompat/widget/SeslIndicator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,237:1\n1855#2,2:238\n1855#2,2:240\n1855#2,2:242\n*S KotlinDebug\n*F\n+ 1 SeslIndicator.kt\nandroidx/appcompat/widget/SeslIndicator\n*L\n54#1:238,2\n65#1:240,2\n158#1:242,2\n*E\n"})
public final class SeslIndicator extends LinearLayout {
    public static final int SIZE_TYPE_LARGE = 1;
    public static final int SIZE_TYPE_SMALL = 0;

    @Nullable
    private Drawable defaultCircle;

    @NotNull
    private List<PageIndicatorMarker> indicator;

    @Nullable
    private OnItemClickListener itemClickListener;

    @Nullable
    private Drawable selectCircle;
    private int selectedPosition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/appcompat/widget/SeslIndicator$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onItemClick(@Nullable View view, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Landroidx/appcompat/widget/SeslIndicator$PageIndicatorMarker;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "sizeType", "", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/util/AttributeSet;)V", "value", "Landroid/graphics/drawable/Drawable;", "defaultCircle", "getDefaultCircle", "()Landroid/graphics/drawable/Drawable;", "setDefaultCircle", "(Landroid/graphics/drawable/Drawable;)V", "imageView", "Landroid/widget/ImageView;", "", "isActive", "()Z", "setActive", "(Z)V", "selectCircle", "getSelectCircle", "setSelectCircle", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class PageIndicatorMarker extends FrameLayout {

        @Nullable
        private Drawable defaultCircle;

        @NotNull
        private final ImageView imageView;
        private boolean isActive;

        @Nullable
        private Drawable selectCircle;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public PageIndicatorMarker(@NotNull Context context) {
            this(context, null, null, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Nullable
        public final Drawable getDefaultCircle() {
            return this.defaultCircle;
        }

        @Nullable
        public final Drawable getSelectCircle() {
            return this.selectCircle;
        }

        /* JADX INFO: renamed from: isActive, reason: from getter */
        public final boolean getIsActive() {
            return this.isActive;
        }

        public final void setActive(boolean z) {
            this.imageView.setImageDrawable(z ? this.selectCircle : this.defaultCircle);
            setSelected(z);
            this.isActive = z;
        }

        public final void setDefaultCircle(@Nullable Drawable drawable) {
            this.defaultCircle = drawable;
            setActive(this.isActive);
        }

        public final void setSelectCircle(@Nullable Drawable drawable) {
            this.selectCircle = drawable;
            setActive(this.isActive);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public PageIndicatorMarker(@NotNull Context context, @Nullable Integer num) {
            this(context, num, null, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public /* synthetic */ PageIndicatorMarker(Context context, Integer num, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? null : attributeSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public PageIndicatorMarker(@NotNull Context context, @Nullable Integer num, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(this.selectCircle);
            addView(imageView);
            if (num != null && num.intValue() == 1) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0419R.dimen.sesl_viewpager_indicator_size_lg);
                imageView.getLayoutParams().width = dimensionPixelSize;
                imageView.getLayoutParams().height = dimensionPixelSize;
            }
            this.imageView = imageView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SeslIndicator(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void addIndicator$default(SeslIndicator seslIndicator, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = 0;
        }
        seslIndicator.addIndicator(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addIndicator$lambda$5$lambda$4(SeslIndicator this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnItemClickListener onItemClickListener = this$0.itemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, CollectionsKt.indexOf((List<? extends View>) this$0.indicator, view));
        }
    }

    private final PageIndicatorMarker generateDotIndicator(Integer sizeType) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        PageIndicatorMarker pageIndicatorMarker = new PageIndicatorMarker(context, sizeType, null, 4, null);
        pageIndicatorMarker.setDefaultCircle(this.defaultCircle);
        pageIndicatorMarker.setSelectCircle(this.selectCircle);
        return pageIndicatorMarker;
    }

    public static /* synthetic */ PageIndicatorMarker generateDotIndicator$default(SeslIndicator seslIndicator, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = 0;
        }
        return seslIndicator.generateDotIndicator(num);
    }

    private final int getAppBarViewPagerIndicatorOffColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_off, C0419R.color.sesl_appbar_viewpager_indicator_off_dark), new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_off_for_theme, C0419R.color.sesl_appbar_viewpager_indicator_off_dark_for_theme)));
    }

    private final int getAppBarViewPagerIndicatorOnColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_on), new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_on_for_theme)));
    }

    private final void invalidateIndicator() {
        int size = this.indicator.size();
        int i = 0;
        while (i < size) {
            this.indicator.get(i).setActive(i == this.selectedPosition);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemClickListener$lambda$9$lambda$8(OnItemClickListener itemClickListener, SeslIndicator this$0, View view) {
        Intrinsics.checkNotNullParameter(itemClickListener, "$itemClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        itemClickListener.onItemClick(view, CollectionsKt.indexOf((List<? extends View>) this$0.indicator, view));
    }

    @JvmOverloads
    public final void addIndicator() {
        addIndicator$default(this, null, 1, null);
    }

    @Nullable
    public final Drawable getDefaultCircle() {
        return this.defaultCircle;
    }

    @Nullable
    public final Drawable getSelectCircle() {
        return this.selectCircle;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final int getSize() {
        return this.indicator.size();
    }

    public final void removeIndicator(int position) {
        if (position < 0 || position >= this.indicator.size()) {
            return;
        }
        removeView(this.indicator.remove(position));
        if (this.selectedPosition >= this.indicator.size()) {
            setSelectedPosition(this.selectedPosition - 1);
        } else {
            invalidateIndicator();
        }
    }

    public final void setDefaultCircle(@Nullable Drawable drawable) {
        Iterator<T> it = this.indicator.iterator();
        while (it.hasNext()) {
            ((PageIndicatorMarker) it.next()).setDefaultCircle(drawable);
        }
        this.defaultCircle = drawable;
    }

    public final void setOnItemClickListener(@NotNull final OnItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
        Iterator<T> it = this.indicator.iterator();
        while (it.hasNext()) {
            ((PageIndicatorMarker) it.next()).setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SeslIndicator.setOnItemClickListener$lambda$9$lambda$8(itemClickListener, this, view);
                }
            });
        }
    }

    public final void setSelectCircle(@Nullable Drawable drawable) {
        Iterator<T> it = this.indicator.iterator();
        while (it.hasNext()) {
            ((PageIndicatorMarker) it.next()).setSelectCircle(drawable);
        }
        this.selectCircle = drawable;
    }

    public final void setSelectedPosition(int i) {
        if (i < 0) {
            i = 0;
        } else if (i >= this.indicator.size()) {
            i = this.indicator.size() - 1;
        }
        this.selectedPosition = i;
        invalidateIndicator();
    }

    public /* synthetic */ SeslIndicator(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmOverloads
    public final void addIndicator(@Nullable Integer sizeType) {
        final PageIndicatorMarker pageIndicatorMarkerGenerateDotIndicator = generateDotIndicator(sizeType);
        pageIndicatorMarkerGenerateDotIndicator.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SeslIndicator.addIndicator$lambda$5$lambda$4(this.f949a, view);
            }
        });
        this.indicator.add(pageIndicatorMarkerGenerateDotIndicator);
        pageIndicatorMarkerGenerateDotIndicator.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: androidx.appcompat.widget.SeslIndicator.addIndicator.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                AccessibilityNodeInfoCompat.wrap(info).setContentDescription(SeslIndicator.this.getResources().getString(C0419R.string.sesl_appbar_suggest_pagination, Integer.valueOf(SeslIndicator.this.indicator.indexOf(pageIndicatorMarkerGenerateDotIndicator) + 1), Integer.valueOf(SeslIndicator.this.getSize())));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = ((sizeType != null && sizeType.intValue() == 1) ? getContext().getResources().getDimensionPixelSize(C0419R.dimen.sesl_viewpager_indicator_horizontal_padding_lg) : getContext().getResources().getDimensionPixelSize(C0419R.dimen.sesl_viewpager_indicator_horizontal_padding_sm)) / 2;
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(pageIndicatorMarkerGenerateDotIndicator, layoutParams);
        if (this.selectedPosition == -1) {
            setSelectedPosition(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SeslIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Drawable drawableMutate;
        Drawable drawableMutate2;
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.indicator = new ArrayList();
        Drawable drawable = context.getDrawable(C0419R.drawable.sesl_viewpager_indicator_on_off);
        Drawable drawable2 = null;
        if (drawable == null || (drawableMutate = drawable.mutate()) == null) {
            drawableMutate = null;
        } else {
            drawableMutate.setTint(getAppBarViewPagerIndicatorOffColor(context));
        }
        this.defaultCircle = drawableMutate;
        Drawable drawable3 = context.getDrawable(C0419R.drawable.sesl_viewpager_indicator_on_off);
        if (drawable3 != null && (drawableMutate2 = drawable3.mutate()) != null) {
            drawableMutate2.setTint(getAppBarViewPagerIndicatorOnColor(context));
            drawable2 = drawableMutate2;
        }
        this.selectCircle = drawable2;
        this.selectedPosition = -1;
    }
}
