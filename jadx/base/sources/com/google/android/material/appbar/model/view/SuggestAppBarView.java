package com.google.android.material.appbar.model.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.appcompat.util.theme.resource.SeslThemeResourceDrawable;
import androidx.appcompat.widget.TooltipCompat;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslHoverPopupWindowReflector;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.model.AppBarModel;
import com.google.android.material.appbar.model.ButtonListModel;
import com.google.android.material.appbar.model.ButtonModel;
import com.google.android.material.appbar.model.ButtonStyle;
import com.google.android.material.appbar.model.SuggestAppBarModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u00104\u001a\u00020*H\u0016J\u000e\u00105\u001a\u00020*2\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010;\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u000103J\u0016\u0010=\u001a\u00020*2\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0019J\u0018\u0010>\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020/J\u0018\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020/J\u0010\u0010D\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, m13886d2 = {"Lcom/google/android/material/appbar/model/view/SuggestAppBarView;", "Lcom/google/android/material/appbar/model/view/AppBarView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomLayout", "Landroid/view/ViewGroup;", "getBottomLayout", "()Landroid/view/ViewGroup;", "setBottomLayout", "(Landroid/view/ViewGroup;)V", "buttons", "", "Landroid/widget/Button;", "getButtons", "()Ljava/util/List;", "close", "Landroid/widget/ImageButton;", "getClose", "()Landroid/widget/ImageButton;", "setClose", "(Landroid/widget/ImageButton;)V", "model", "Lcom/google/android/material/appbar/model/SuggestAppBarModel;", "subTitleView", "Landroid/widget/TextView;", "getSubTitleView", "()Landroid/widget/TextView;", "setSubTitleView", "(Landroid/widget/TextView;)V", "titleView", "getTitleView", "setTitleView", "topImageView", "Landroid/widget/ImageView;", "getTopImageView", "()Landroid/widget/ImageView;", "setTopImageView", "(Landroid/widget/ImageView;)V", "addMargin", "", "generateButton", "buttonModel", "Lcom/google/android/material/appbar/model/ButtonModel;", "style", "", "getAppBarSuggestSubTitleColor", "getAppBarSuggestTitleColor", "getCloseDrawable", "Landroid/graphics/drawable/Drawable;", "inflate", "setButtonModules", "buttonModels", "Lcom/google/android/material/appbar/model/ButtonListModel;", "setCloseClickListener", "closeClickListener", "Lcom/google/android/material/appbar/model/AppBarModel$OnClickListener;", "setImage", "drawable", "setModel", "setSubTitle", "subTitle", "", "count", "setTitle", "title", "updateResource", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuggestAppBarView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestAppBarView.kt\ncom/google/android/material/appbar/model/view/SuggestAppBarView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,228:1\n1864#2,3:229\n1#3:232\n*S KotlinDebug\n*F\n+ 1 SuggestAppBarView.kt\ncom/google/android/material/appbar/model/view/SuggestAppBarView\n*L\n134#1:229,3\n*E\n"})
public class SuggestAppBarView extends AppBarView {

    @Nullable
    private ViewGroup bottomLayout;

    @NotNull
    private final List<Button> buttons;

    @Nullable
    private ImageButton close;
    private SuggestAppBarModel<? extends SuggestAppBarView> model;

    @Nullable
    private TextView subTitleView;

    @Nullable
    private TextView titleView;

    @Nullable
    private ImageView topImageView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SuggestAppBarView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void addMargin() {
        View view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(view.getResources().getDimensionPixelOffset(C4548R.dimen.sesl_appbar_button_side_margin), -1));
        ViewGroup viewGroup = this.bottomLayout;
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    private final Button generateButton(ButtonModel buttonModel, int style) {
        Button button = new Button(getContext(), null, 0, style);
        button.setText(buttonModel.getText());
        String contentDescription = buttonModel.getContentDescription();
        if (contentDescription != null) {
            button.setContentDescription(contentDescription);
        }
        button.setOnClickListener(new ViewOnClickListenerC0219a(buttonModel, this, 1));
        return button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateButton$lambda$11$lambda$10(ButtonModel buttonModel, SuggestAppBarView this$0, View it) {
        Intrinsics.checkNotNullParameter(buttonModel, "$buttonModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppBarModel.OnClickListener clickListener = buttonModel.getClickListener();
        if (clickListener != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            SuggestAppBarModel<? extends SuggestAppBarView> suggestAppBarModel = this$0.model;
            if (suggestAppBarModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                suggestAppBarModel = null;
            }
            clickListener.onClick(it, suggestAppBarModel);
        }
    }

    private final int getAppBarSuggestSubTitleColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_suggest_sub_title, C4548R.color.sesl_appbar_suggest_sub_title_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_suggest_sub_title, C4548R.color.sesl_appbar_suggest_sub_title_dark)));
    }

    private final int getAppBarSuggestTitleColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_suggest_title, C4548R.color.sesl_appbar_suggest_title_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_suggest_title, C4548R.color.sesl_appbar_suggest_title_dark_for_theme)));
    }

    private final Drawable getCloseDrawable(Context context) {
        return Build.VERSION.SDK_INT >= 29 ? SeslThemeResourceHelper.INSTANCE.getDrawable(context, new SeslThemeResourceDrawable.OpenThemeResourceDrawable(new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_close_button_recoil_background, C4548R.drawable.sesl_close_button_recoil_background_dark), new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_close_button_recoil_background_for_theme, C4548R.drawable.sesl_close_button_recoil_background_dark_for_theme))) : SeslThemeResourceHelper.INSTANCE.getDrawable(context, new SeslThemeResourceDrawable.OpenThemeResourceDrawable(new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_ic_close, C4548R.drawable.sesl_ic_close_dark), new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_ic_close_for_theme, C4548R.drawable.sesl_ic_close_dark_for_theme)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCloseClickListener$lambda$6$lambda$5(AppBarModel.OnClickListener onClickListener, SuggestAppBarView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (onClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            SuggestAppBarModel<? extends SuggestAppBarView> suggestAppBarModel = this$0.model;
            if (suggestAppBarModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                suggestAppBarModel = null;
            }
            onClickListener.onClick(it, suggestAppBarModel);
        }
    }

    @Nullable
    public final ViewGroup getBottomLayout() {
        return this.bottomLayout;
    }

    @NotNull
    public final List<Button> getButtons() {
        return this.buttons;
    }

    @Nullable
    public final ImageButton getClose() {
        return this.close;
    }

    @Nullable
    public final TextView getSubTitleView() {
        return this.subTitleView;
    }

    @Nullable
    public final TextView getTitleView() {
        return this.titleView;
    }

    @Nullable
    public final ImageView getTopImageView() {
        return this.topImageView;
    }

    @Override // com.google.android.material.appbar.model.view.AppBarView
    public void inflate() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_app_bar_suggest, (ViewGroup) this, false);
        ImageButton imageButton = null;
        ViewGroup viewGroup = viewInflate instanceof ViewGroup ? (ViewGroup) viewInflate : null;
        if (viewGroup == null) {
            return;
        }
        this.topImageView = (ImageView) viewGroup.findViewById(C4548R.id.suggest_app_bar_top_image);
        this.titleView = (TextView) viewGroup.findViewById(C4548R.id.suggest_app_bar_title);
        this.subTitleView = (TextView) viewGroup.findViewById(C4548R.id.suggest_app_bar_sub_title);
        ImageButton imageButton2 = (ImageButton) viewGroup.findViewById(C4548R.id.suggest_app_bar_close);
        if (imageButton2 != null) {
            SeslViewReflector.semSetHoverPopupType(imageButton2, SeslHoverPopupWindowReflector.getField_TYPE_NONE());
            imageButton = imageButton2;
        }
        this.close = imageButton;
        this.bottomLayout = (ViewGroup) viewGroup.findViewById(C4548R.id.suggest_app_bar_bottom_layout);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        updateResource(context);
        addView(viewGroup);
    }

    public final void setBottomLayout(@Nullable ViewGroup viewGroup) {
        this.bottomLayout = viewGroup;
    }

    public final void setButtonModules(@NotNull ButtonListModel buttonModels) {
        Intrinsics.checkNotNullParameter(buttonModels, "buttonModels");
        ViewGroup viewGroup = this.bottomLayout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.buttons.clear();
        List<ButtonModel> buttonModels2 = buttonModels.getButtonModels();
        ButtonStyle buttonStyle = buttonModels.getButtonStyle();
        int i = 0;
        for (Object obj : buttonModels2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Button buttonGenerateButton = generateButton((ButtonModel) obj, SeslMisc.isLightTheme(getContext()) ? buttonStyle.getDefStyleRes() : buttonStyle.getDefStyleResDark());
            buttonGenerateButton.setMaxWidth(buttonGenerateButton.getResources().getDimensionPixelSize(buttonModels2.size() > 1 ? C4548R.dimen.sesl_appbar_button_max_width : C4548R.dimen.sesl_appbar_button_max_width_multi));
            if (i != 0) {
                addMargin();
            }
            this.buttons.add(buttonGenerateButton);
            ViewGroup viewGroup2 = this.bottomLayout;
            if (viewGroup2 != null) {
                viewGroup2.addView(buttonGenerateButton);
            }
            i = i2;
        }
    }

    public final void setClose(@Nullable ImageButton imageButton) {
        this.close = imageButton;
    }

    public final void setCloseClickListener(@Nullable AppBarModel.OnClickListener closeClickListener) {
        ImageButton imageButton = this.close;
        if (imageButton != null) {
            imageButton.setVisibility(closeClickListener == null ? 8 : 0);
            imageButton.setOnClickListener(new ViewOnClickListenerC0219a(closeClickListener, this, 2));
        }
    }

    public final void setImage(@Nullable Drawable drawable) {
        ImageView imageView = this.topImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            imageView.setVisibility(drawable != null ? 0 : 8);
        }
    }

    public final void setModel(@NotNull SuggestAppBarModel<? extends SuggestAppBarView> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
    }

    public final void setSubTitle(@Nullable String subTitle, int count) {
        TextView textView = this.subTitleView;
        if (textView != null) {
            textView.setText(subTitle);
            textView.setVisibility(TextUtils.isEmpty(subTitle) ? 8 : 0);
            if (count > 0) {
                textView.setMaxLines(count);
            }
        }
    }

    public final void setSubTitleView(@Nullable TextView textView) {
        this.subTitleView = textView;
    }

    public final void setTitle(@Nullable String title, int count) {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(title);
            textView.setVisibility(TextUtils.isEmpty(title) ? 8 : 0);
            if (count > 0) {
                textView.setMaxLines(count);
            }
        }
    }

    public final void setTitleView(@Nullable TextView textView) {
        this.titleView = textView;
    }

    public final void setTopImageView(@Nullable ImageView imageView) {
        this.topImageView = imageView;
    }

    @Override // com.google.android.material.appbar.model.view.AppBarView
    public void updateResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setTextColor(getAppBarSuggestTitleColor(context));
        }
        TextView textView2 = this.subTitleView;
        if (textView2 != null) {
            textView2.setTextColor(getAppBarSuggestSubTitleColor(context));
        }
        ImageButton imageButton = this.close;
        if (imageButton != null) {
            String string = imageButton.getResources().getString(C0419R.string.sesl_appbar_suggest_dismiss);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(andr…l_appbar_suggest_dismiss)");
            TooltipCompat.setTooltipText(imageButton, string);
            imageButton.setContentDescription(string);
            imageButton.setBackground(getCloseDrawable(context));
        }
    }

    public /* synthetic */ SuggestAppBarView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuggestAppBarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.buttons = new ArrayList();
        inflate();
    }
}
