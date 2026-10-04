package com.samsung.android.app.notes.widget.glance.setting.view;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0007J\u001a\u0010%\u001a\u00020\u00102\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0013J\u0010\u0010)\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u0013J\u0006\u0010*\u001a\u00020\u0007J\b\u0010+\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingBgShapeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mShapeItemContainer", "mShapeView", "Landroid/widget/ImageView;", "mCheckIcon", "mOnSelectListener", "Lkotlin/Function1;", "", "mResourceId", "mIsSelected", "", "mShapeDescriptionSelected", "", "mShapeDescriptionNotSelected", "value", "isSelectable", "()Z", "setSelectable", "(Z)V", "isShapeSelected", "setShapeSelected", "shapeResource", "getShapeResource", "()I", "setShapeResource", "(I)V", "setImageBg", "resourceId", "setOnSelectListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateState", "selected", "setDescription", "getShapeIdFromRes", "updateRippleMask", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorSettingBgShapeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorSettingBgShapeView.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingBgShapeView\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n*L\n1#1,131:1\n28#2:132\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorSettingBgShapeView.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingBgShapeView\n*L\n120#1:132\n*E\n"})
public final class WidgetCreatorSettingBgShapeView extends FrameLayout {
    public static final int $stable = 8;
    private boolean isSelectable;

    @NotNull
    private final ImageView mCheckIcon;
    private boolean mIsSelected;

    @Nullable
    private Function1<? super WidgetCreatorSettingBgShapeView, Unit> mOnSelectListener;
    private int mResourceId;

    @NotNull
    private final String mShapeDescriptionNotSelected;

    @NotNull
    private final String mShapeDescriptionSelected;

    @NotNull
    private final FrameLayout mShapeItemContainer;

    @NotNull
    private final ImageView mShapeView;

    public /* synthetic */ WidgetCreatorSettingBgShapeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView, View view) {
        Function1<? super WidgetCreatorSettingBgShapeView, Unit> function1;
        if (widgetCreatorSettingBgShapeView.isSelectable && (function1 = widgetCreatorSettingBgShapeView.mOnSelectListener) != null) {
            function1.invoke(widgetCreatorSettingBgShapeView);
        }
    }

    public static /* synthetic */ void setDescription$default(WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        widgetCreatorSettingBgShapeView.setDescription(z);
    }

    private final void updateRippleMask() {
        post(new RunnableC4617a(this, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRippleMask$lambda$5(WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView) {
        Drawable drawableMutate;
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        Drawable drawableMutate2;
        Drawable.ConstantState constantState2;
        Drawable drawableNewDrawable2;
        Drawable drawableNewDrawable3;
        Drawable drawable = widgetCreatorSettingBgShapeView.mShapeView.getDrawable();
        if (drawable != null) {
            Drawable.ConstantState constantState3 = drawable.getConstantState();
            Drawable drawable2 = null;
            Drawable drawableMutate3 = (constantState3 == null || (drawableNewDrawable3 = constantState3.newDrawable()) == null) ? null : drawableNewDrawable3.mutate();
            if (drawableMutate3 == null || (constantState2 = drawableMutate3.getConstantState()) == null || (drawableNewDrawable2 = constantState2.newDrawable()) == null || (drawableMutate = drawableNewDrawable2.mutate()) == null) {
                drawableMutate = null;
            } else {
                drawableMutate.setTint(ContextCompat.getColor(widgetCreatorSettingBgShapeView.getContext(), C6635R.color.widget_common_list_ripple_shape_color));
            }
            if (drawableMutate3 != null && (constantState = drawableMutate3.getConstantState()) != null && (drawableNewDrawable = constantState.newDrawable()) != null && (drawableMutate2 = drawableNewDrawable.mutate()) != null) {
                drawableMutate2.setTint(ContextCompat.getColor(widgetCreatorSettingBgShapeView.getContext(), C6635R.color.widget_common_list_ripple_shape_color));
                drawable2 = drawableMutate2;
            }
            ColorDrawable colorDrawable = new ColorDrawable(0);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableMutate);
            stateListDrawable.addState(new int[]{R.attr.state_hovered}, drawable2);
            stateListDrawable.addState(new int[0], colorDrawable);
            widgetCreatorSettingBgShapeView.mShapeItemContainer.setBackground(stateListDrawable);
        }
    }

    public final int getShapeIdFromRes() {
        int i = this.mResourceId;
        if (i == C6635R.drawable.widget_setting_preview_bg_shape_01) {
            return 2;
        }
        if (i == C6635R.drawable.widget_setting_preview_bg_shape_02) {
            return 3;
        }
        if (i == C6635R.drawable.widget_setting_preview_bg_shape_03) {
            return 4;
        }
        return i == C6635R.drawable.widget_setting_preview_bg_shape_04 ? 5 : 1;
    }

    /* JADX INFO: renamed from: getShapeResource, reason: from getter */
    public final int getMResourceId() {
        return this.mResourceId;
    }

    /* JADX INFO: renamed from: isSelectable, reason: from getter */
    public final boolean getIsSelectable() {
        return this.isSelectable;
    }

    /* JADX INFO: renamed from: isShapeSelected, reason: from getter */
    public final boolean getMIsSelected() {
        return this.mIsSelected;
    }

    public final void setDescription(boolean selected) {
        String string = getContext().getResources().getString(C6635R.string.base_widget_setting_background_shape_item, Integer.valueOf(getShapeIdFromRes()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mShapeView.setContentDescription(selected ? AbstractC0541b.m757C(this.mShapeDescriptionSelected, SQLKeyword.COMMA, string) : AbstractC0541b.m757C(this.mShapeDescriptionNotSelected, SQLKeyword.COMMA, string));
    }

    public final void setImageBg(int resourceId) {
        this.mResourceId = resourceId;
        this.mShapeView.setImageResource(resourceId);
        setDescription$default(this, false, 1, null);
        updateRippleMask();
    }

    public final void setOnSelectListener(@NotNull Function1<? super WidgetCreatorSettingBgShapeView, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnSelectListener = listener;
    }

    public final void setSelectable(boolean z) {
        this.isSelectable = z;
        this.mShapeItemContainer.setEnabled(z);
        this.mShapeItemContainer.setClickable(z);
        this.mShapeItemContainer.setFocusable(z);
    }

    public final void setShapeResource(int i) {
        this.mResourceId = i;
    }

    public final void setShapeSelected(boolean z) {
        this.mIsSelected = z;
    }

    public final void updateState(boolean selected) {
        this.mIsSelected = selected;
        if (selected) {
            this.mShapeView.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), C6635R.color.f3722x88fb1f7b), PorterDuff.Mode.SRC_IN));
            this.mCheckIcon.setVisibility(0);
        } else {
            this.mShapeView.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), C6635R.color.f3723xbf896f54), PorterDuff.Mode.SRC_IN));
            this.mCheckIcon.setVisibility(8);
        }
        setDescription(selected);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreatorSettingBgShapeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mResourceId = -1;
        String string = context.getResources().getString(C6635R.string.base_widget_setting_background_shape_item_selected);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mShapeDescriptionSelected = string;
        String string2 = context.getResources().getString(C6635R.string.base_widget_setting_background_shape_item_not_selected);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.mShapeDescriptionNotSelected = string2;
        this.isSelectable = true;
        View.inflate(context, C6635R.layout.widget_creator_glance_setting_control_background_shape_item, this);
        View viewFindViewById = findViewById(C6635R.id.shape_item_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        FrameLayout frameLayout = (FrameLayout) viewFindViewById;
        this.mShapeItemContainer = frameLayout;
        View viewFindViewById2 = findViewById(C6635R.id.widget_creator_bg_shape);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mShapeView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(C6635R.id.widget_creator_check_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mCheckIcon = (ImageView) viewFindViewById3;
        frameLayout.setOnClickListener(new ViewOnClickListenerC0157a(this, 7));
        updateState(false);
    }
}
