package com.google.android.material.oneui.dividerbuttonlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MenuRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.oneui.common.BlurSupportable;
import androidx.appcompat.oneui.common.internal.policy.BlurInfoState;
import androidx.appcompat.oneui.common.internal.resource.OpenThemeResourceDrawableRes;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceDrawableRes;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateBuilder;
import androidx.appcompat.oneui.common.internal.util.MaxFontScaleRatio;
import androidx.appcompat.oneui.common.internal.util.TextViewHelperKt;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.TextViewCompat;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslTextViewReflector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.C4548R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.oneui.common.internal.MaterialLogTag;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004NOPQB/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010.\u001a\u00020*J\u0010\u0010/\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u0002012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u00102\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\f\u00106\u001a\b\u0012\u0004\u0012\u00020,07J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020107H\u0002J\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020\nH\u0016J\u0010\u0010<\u001a\u00020*2\b\b\u0001\u0010=\u001a\u00020\nJ\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\u0018\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0014J\u000e\u0010D\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0012\u0010E\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\nH\u0016J\u000e\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020!J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\nH\u0002J\u0006\u0010M\u001a\u00020*R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;", "Landroid/widget/LinearLayout;", "Landroidx/appcompat/view/menu/MenuView;", "Landroidx/appcompat/oneui/common/BlurSupportable;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "applyBlur", "", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "blurInfo", "Landroidx/core/oneui/common/internal/semblurinfo/SemBlurInfoState;", "blurMode", "logTag", "", "getLogTag", "()Ljava/lang/String;", "menuBuilder", "Landroidx/appcompat/view/menu/MenuBuilder;", "menuInflater", "Landroidx/appcompat/view/SupportMenuInflater;", "getMenuInflater", "()Landroidx/appcompat/view/SupportMenuInflater;", "menuInflater$delegate", "Lkotlin/Lazy;", "onMenuItemClickListener", "Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout$OnMenuItemClickListener;", "presenter", "Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonPresenter;", "getPresenter", "()Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonPresenter;", "presenter$delegate", "prevAvailableWidth", "syncLargestItemWidthConcept", "addButton", "", MarketingConstants.BUTTON, "Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout$DividerButton;", "applyBlurInfo", "buildMenuView", "clearBlurInfo", "createDivider", "Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout$Divider;", "createDividerButton", "menuItem", "Landroidx/appcompat/view/menu/MenuItemImpl;", "generateBlurInfo", "getDividerButtons", "", "getDividers", "getMenu", "Landroid/view/Menu;", "getWindowAnimations", "inflateMenu", "resId", "initialize", ExternalSettingsProvider.EXTRA_MENU, "isBlurApplied", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeButton", "setBackground", "background", "setBlurMode", "semBlurInfoMode", "setOnMenuItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateButtonSize", "availableWidth", "updateMenuView", "Companion", FolderConstants.Divider.DISPLAY_NAME, "DividerButton", "OnMenuItemClickListener", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDividerButtonLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DividerButtonLayout.kt\ncom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,460:1\n1855#2,2:461\n1864#2,3:463\n1549#2:466\n1620#2,3:467\n800#2,11:470\n1747#2,3:481\n1855#2,2:484\n1855#2,2:486\n1855#2,2:488\n1#3:490\n*S KotlinDebug\n*F\n+ 1 DividerButtonLayout.kt\ncom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout\n*L\n110#1:461,2\n124#1:463,3\n189#1:466\n189#1:467,3\n189#1:470,11\n190#1:481,3\n192#1:484,2\n210#1:486,2\n224#1:488,2\n*E\n"})
public final class DividerButtonLayout extends LinearLayout implements MenuView, BlurSupportable, MaterialLogTag {
    private static final int TYPE_WIDGET_DEFAULT = 2;
    private boolean applyBlur;

    @Nullable
    private Drawable backgroundDrawable;

    @Nullable
    private SemBlurInfoState blurInfo;
    private int blurMode;

    @NotNull
    private MenuBuilder menuBuilder;

    /* JADX INFO: renamed from: menuInflater$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy menuInflater;

    @Nullable
    private OnMenuItemClickListener onMenuItemClickListener;

    /* JADX INFO: renamed from: presenter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy presenter;
    private int prevAvailableWidth;
    private final boolean syncLargestItemWidthConcept;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout$Divider;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Divider extends View {
        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Divider(@NotNull Context context) {
            this(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Divider(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public /* synthetic */ Divider(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Divider(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            setBackgroundResource(new OpenThemeResourceDrawableRes(new ThemeResourceDrawableRes(C4548R.drawable.sesl_divider_button_layout_divider_background_light, C4548R.drawable.sesl_divider_button_layout_divider_background_dark), new ThemeResourceDrawableRes(C4548R.drawable.sesl_divider_button_layout_divider_background_for_theme, 0, 2, null)).getResource(context).intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout$DividerButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "itemData", "Landroidx/appcompat/view/menu/MenuItemImpl;", "maxWidth", "textBaseSizeDimenRes", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "getLayoutResId", "initialize", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setEnabled", "enabled", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DividerButton extends FrameLayout {

        @Nullable
        private MenuItemImpl itemData;
        private int maxWidth;
        private final int textBaseSizeDimenRes;

        @Nullable
        private TextView textView;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public DividerButton(@NotNull Context context) {
            this(context, null, 0, 0, 14, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        private final int getLayoutResId() {
            return C4548R.layout.sesl_divider_button_layout_divier_button;
        }

        @Nullable
        public final TextView getTextView() {
            return this.textView;
        }

        public final void initialize(@NotNull MenuItemImpl itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this.itemData = itemData;
            setId(itemData.getItemId());
            TextView textView = this.textView;
            if (textView != null) {
                textView.setVisibility(itemData.getActionView() == null ? 0 : 8);
            }
            setEnabled(itemData.isEnabled());
            if (!TextUtils.isEmpty(itemData.getContentDescription())) {
                setContentDescription(itemData.getContentDescription());
            }
            View actionView = itemData.getActionView();
            if (actionView == null) {
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    CharSequence title = itemData.getTitle();
                    textView2.setText(title != null ? title.toString() : null);
                    TextViewHelperKt.checkMaxFontScale(textView2, this.textBaseSizeDimenRes, MaxFontScaleRatio.LARGE);
                    SeslTextViewReflector.semSetButtonShapeEnabled(textView2, true);
                }
                this.maxWidth = getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_divider_button_layout_button_max_width);
                return;
            }
            if (actionView.getParent() != null) {
                ViewParent parent = actionView.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(actionView);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            addView(actionView, layoutParams);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(View.resolveSizeAndState(RangesKt.coerceIn(getMeasuredWidth(), getSuggestedMinimumWidth(), this.maxWidth), widthMeasureSpec, 0), getMeasuredHeight());
        }

        @Override // android.view.View
        public void setEnabled(boolean enabled) {
            super.setEnabled(enabled);
            TextView textView = this.textView;
            if (textView == null) {
                return;
            }
            textView.setEnabled(enabled);
        }

        public final void setTextView(@Nullable TextView textView) {
            this.textView = textView;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public DividerButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0, 0, 12, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public DividerButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
            this(context, attributeSet, i, 0, 8, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public /* synthetic */ DividerButton(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? SeslMisc.isLightTheme(context) ? C4548R.style.Widget_Design_DividerButtonLayout_DividerButton_Light : C4548R.style.Widget_Design_DividerButtonLayout_DividerButton : i2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public DividerButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
            super(context, attributeSet, i, i2);
            Intrinsics.checkNotNullParameter(context, "context");
            this.textBaseSizeDimenRes = C4548R.dimen.sesl_divider_button_layout_button_text_size;
            this.maxWidth = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_divider_button_layout_button_max_width);
            LayoutInflater.from(context).inflate(getLayoutResId(), (ViewGroup) this, true);
            TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C4548R.styleable.DividerButton, i, i2, new int[0]);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(\n…defStyleRes\n            )");
            CharSequence text = typedArrayObtainStyledAttributes.getText(C4548R.styleable.DividerButton_android_text);
            TextView textView = null;
            String string = text != null ? text.toString() : null;
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.DividerButton_android_textAppearance, -1);
            typedArrayObtainStyledAttributes.recycle();
            TextView textView2 = (TextView) findViewById(C4548R.id.textview);
            if (textView2 != null) {
                textView2.setText(string);
                if (resourceId != -1) {
                    TextViewCompat.setTextAppearance(textView2, resourceId);
                }
                if (!SeslMisc.isDefaultTheme(context)) {
                    textView2.setTextColor(AppCompatResources.getColorStateList(context, C4548R.color.sesl_divider_button_layout_button_text_for_theme));
                }
                SeslViewReflector.semSetHoverPopupType(textView2, 2);
                textView = textView2;
            }
            this.textView = textView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout$OnMenuItemClickListener;", "", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(@NotNull MenuItem item);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DividerButtonLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Divider createDivider(Context context) {
        Divider divider = new Divider(context, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.width = divider.getResources().getDimensionPixelSize(C4548R.dimen.sesl_divider_button_layout_divider_width);
        layoutParams.height = divider.getResources().getDimensionPixelSize(C4548R.dimen.sesl_divider_button_layout_divider_height);
        layoutParams.gravity = 17;
        divider.setLayoutParams(layoutParams);
        return divider;
    }

    private final DividerButton createDividerButton(Context context, MenuItemImpl menuItem) {
        DividerButton dividerButton = new DividerButton(context, null, 0, 0, 14, null);
        dividerButton.initialize(menuItem);
        dividerButton.setOnClickListener(new ViewOnClickListenerC0219a(this, menuItem, 3));
        return dividerButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDividerButton$lambda$6$lambda$5(DividerButtonLayout this$0, MenuItemImpl menuItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        OnMenuItemClickListener onMenuItemClickListener = this$0.onMenuItemClickListener;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onMenuItemClick(menuItem);
        }
    }

    @RequiresApi(35)
    private final SemBlurInfoState generateBlurInfo(Context context) {
        float dimension = context.getResources().getDimension(C4548R.dimen.sesl_divider_button_layout_background_radius);
        SemBlurInfoStateBuilder semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder = BlurInfoState.INSTANCE.generateFloatingComponentBlurInfoStateBuilder(context, this.blurMode);
        Drawable drawable = this.backgroundDrawable;
        if (drawable != null) {
            semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.nonBlurBackground(drawable);
        }
        semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.cornerRadius(dimension);
        return semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.build();
    }

    private final List<Divider> getDividers() {
        return SequencesKt.toList(SequencesKt.filterIsInstance(ViewGroupKt.getChildren(this), Divider.class));
    }

    private final SupportMenuInflater getMenuInflater() {
        return (SupportMenuInflater) this.menuInflater.getValue();
    }

    private final DividerButtonPresenter getPresenter() {
        return (DividerButtonPresenter) this.presenter.getValue();
    }

    private final boolean updateButtonSize(int availableWidth) {
        List<DividerButton> dividerButtons = getDividerButtons();
        int iMax = 0;
        for (DividerButton dividerButton : dividerButtons) {
            if (dividerButton.getVisibility() == 0) {
                iMax = Math.max(iMax, dividerButton.getMeasuredWidth());
            }
        }
        if (iMax == 0) {
            return false;
        }
        List<Divider> dividers = getDividers();
        Divider divider = (Divider) CollectionsKt.firstOrNull((List) getDividers());
        int iM1612b = AbstractC2322a.m1612b(dividers, divider != null ? divider.getMeasuredWidth() : 0, dividerButtons.size() * iMax);
        Iterator<T> it = dividerButtons.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ViewGroup.LayoutParams layoutParams = ((DividerButton) it.next()).getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                if (iM1612b <= availableWidth) {
                    if (layoutParams2.width != iMax) {
                        layoutParams2.width = iMax;
                        z = true;
                    }
                    layoutParams2.weight = 0.0f;
                } else {
                    layoutParams2.width = 0;
                    layoutParams2.weight = 1.0f;
                    z = true;
                }
            }
        }
        return z;
    }

    public final void addButton(@NotNull DividerButton button) {
        Intrinsics.checkNotNullParameter(button, "button");
        if (getChildCount() > 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            addView(createDivider(context));
        }
        addView(button, new LinearLayout.LayoutParams(-2, -1));
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean applyBlurInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 35) {
            return false;
        }
        clearBlurInfo(context);
        SemBlurInfoState semBlurInfoStateGenerateBlurInfo = generateBlurInfo(context);
        boolean zApplyBlurInfo = semBlurInfoStateGenerateBlurInfo.applyBlurInfo(this);
        if (!zApplyBlurInfo) {
            semBlurInfoStateGenerateBlurInfo = null;
        }
        this.blurInfo = semBlurInfoStateGenerateBlurInfo;
        return zApplyBlurInfo;
    }

    public final void buildMenuView() {
        removeAllViews();
        ArrayList<MenuItemImpl> visibleItems = this.menuBuilder.getVisibleItems();
        Intrinsics.checkNotNullExpressionValue(visibleItems, "menuBuilder.visibleItems");
        for (MenuItemImpl menuItem : visibleItems) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intrinsics.checkNotNullExpressionValue(menuItem, "menuItem");
            addButton(createDividerButton(context, menuItem));
        }
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void clearBlurInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SemBlurInfoState semBlurInfoState = this.blurInfo;
        if (semBlurInfoState != null) {
            semBlurInfoState.clearBlurInfo(this);
        }
        this.blurInfo = null;
    }

    @NotNull
    public final List<DividerButton> getDividerButtons() {
        return SequencesKt.toList(SequencesKt.filterIsInstance(ViewGroupKt.getChildren(this), DividerButton.class));
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return "DividerButtonLayout";
    }

    @NotNull
    public final Menu getMenu() {
        return this.menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public final void inflateMenu(@MenuRes int resId) {
        getPresenter().setUpdateSuspended(true);
        getMenuInflater().inflate(resId, this.menuBuilder);
        getPresenter().setUpdateSuspended(false);
        getPresenter().updateMenuView(true);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NotNull MenuBuilder menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean isBlurApplied() {
        return this.blurInfo != null;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C4548R.dimen.sesl_divider_button_layout_button_height);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + dimensionPixelSize, 1073741824);
            }
        } else if (View.MeasureSpec.getSize(heightMeasureSpec) >= dimensionPixelSize) {
            setMinimumHeight(dimensionPixelSize);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.syncLargestItemWidthConcept) {
            List<DividerButton> dividerButtons = getDividerButtons();
            int size = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight();
            List<DividerButton> list = dividerButtons;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((DividerButton) it.next()).getLayoutParams());
            }
            ArrayList<LinearLayout.LayoutParams> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof LinearLayout.LayoutParams) {
                    arrayList2.add(obj);
                }
            }
            boolean z = false;
            if (!arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((LinearLayout.LayoutParams) it2.next()).weight == 1.0f) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.prevAvailableWidth < size && z) {
                for (LinearLayout.LayoutParams layoutParams : arrayList2) {
                    layoutParams.weight = 0.0f;
                    layoutParams.width = -2;
                }
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                LogTagHelperKt.debug(this, "Size has increased, but it is layout_weight. remeasure(" + this.prevAvailableWidth + " -> " + size + PropertyUtils.MAPPED_DELIM2);
            }
            if (updateButtonSize(size)) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
            this.prevAvailableWidth = size;
        }
    }

    public final void removeButton(@NotNull DividerButton button) {
        Intrinsics.checkNotNullParameter(button, "button");
        int iIndexOfChild = indexOfChild(button);
        if (iIndexOfChild != -1) {
            removeViewAt(iIndexOfChild);
            if (iIndexOfChild > 0) {
                int i = iIndexOfChild - 1;
                if (getChildAt(i) instanceof Divider) {
                    removeViewAt(i);
                    return;
                }
            }
            if (iIndexOfChild >= getChildCount() || !(getChildAt(iIndexOfChild) instanceof Divider)) {
                return;
            }
            removeViewAt(iIndexOfChild);
        }
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable background) {
        super.setBackground(background);
        this.backgroundDrawable = background;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void setBlurMode(int semBlurInfoMode) {
        this.blurMode = semBlurInfoMode;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        applyBlurInfo(context);
    }

    public final void setOnMenuItemClickListener(@NotNull OnMenuItemClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onMenuItemClickListener = listener;
    }

    public final void updateMenuView() {
        getPresenter().setUpdateSuspended(true);
        List<DividerButton> dividerButtons = getDividerButtons();
        if (this.menuBuilder.getVisibleItems().size() != dividerButtons.size()) {
            LogTagHelperKt.debug(this, "updateMenuView size changed(" + this.menuBuilder.getVisibleItems().size() + " -> " + dividerButtons.size() + PropertyUtils.MAPPED_DELIM2);
            buildMenuView();
            return;
        }
        ArrayList<MenuItemImpl> visibleItems = this.menuBuilder.getVisibleItems();
        Intrinsics.checkNotNullExpressionValue(visibleItems, "menuBuilder.visibleItems");
        int i = 0;
        for (Object obj : visibleItems) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MenuItemImpl menuItem = (MenuItemImpl) obj;
            DividerButton dividerButton = dividerButtons.get(i);
            Intrinsics.checkNotNullExpressionValue(menuItem, "menuItem");
            dividerButton.initialize(menuItem);
            i = i2;
        }
        getPresenter().setUpdateSuspended(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DividerButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DividerButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DividerButtonLayout(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? SeslMisc.isLightTheme(context) ? C4548R.style.Widget_Design_DividerButtonLayout_Light : C4548R.style.Widget_Design_DividerButtonLayout : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DividerButtonLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.blurMode = 2;
        this.menuInflater = LazyKt.lazy(new Function0<SupportMenuInflater>() { // from class: com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout$menuInflater$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SupportMenuInflater invoke() {
                return new SupportMenuInflater(context);
            }
        });
        this.presenter = LazyKt.lazy(new Function0<DividerButtonPresenter>() { // from class: com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout$presenter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DividerButtonPresenter invoke() {
                return new DividerButtonPresenter();
            }
        });
        MenuBuilder menuBuilder = new MenuBuilder(context);
        getPresenter().setMenuView(this);
        menuBuilder.addMenuPresenter(getPresenter());
        this.menuBuilder = menuBuilder;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C4548R.styleable.DividerButtonLayout, i, 0, new int[0]);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(\n…tyleAttr, 0\n            )");
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.DividerButtonLayout_seslApplyBlur)) {
            this.applyBlur = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.DividerButtonLayout_seslApplyBlur, true);
        }
        if (!SeslMisc.isDefaultTheme(context)) {
            setBackgroundResource(C4548R.drawable.sesl_divider_button_layout_background_for_theme);
        }
        if (this.applyBlur) {
            applyBlurInfo(context);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
