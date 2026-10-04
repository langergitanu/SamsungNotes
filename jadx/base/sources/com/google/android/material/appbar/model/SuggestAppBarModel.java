package com.google.android.material.appbar.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.model.AppBarModel;
import com.google.android.material.appbar.model.view.SuggestAppBarView;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001$Bg\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e¨\u0006%"}, m13886d2 = {"Lcom/google/android/material/appbar/model/SuggestAppBarModel;", "T", "Lcom/google/android/material/appbar/model/view/SuggestAppBarView;", "Lcom/google/android/material/appbar/model/AppBarModel;", "kclazz", "Lkotlin/reflect/KClass;", "context", "Landroid/content/Context;", "title", "", "titleMaxLine", "", "subTitle", "subTitleMaxLine", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "closeClickListener", "Lcom/google/android/material/appbar/model/AppBarModel$OnClickListener;", "buttonListModel", "Lcom/google/android/material/appbar/model/ButtonListModel;", "(Lkotlin/reflect/KClass;Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ILandroid/graphics/drawable/Drawable;Lcom/google/android/material/appbar/model/AppBarModel$OnClickListener;Lcom/google/android/material/appbar/model/ButtonListModel;)V", "getButtonListModel", "()Lcom/google/android/material/appbar/model/ButtonListModel;", "getCloseClickListener", "()Lcom/google/android/material/appbar/model/AppBarModel$OnClickListener;", "getImageDrawable", "()Landroid/graphics/drawable/Drawable;", "getSubTitle", "()Ljava/lang/String;", "getSubTitleMaxLine", "()I", DynamicActionBarProvider.METHOD_GET_DATA, "getTitleMaxLine", "init", "moduleView", "(Lcom/google/android/material/appbar/model/view/SuggestAppBarView;)Lcom/google/android/material/appbar/model/view/SuggestAppBarView;", "Builder", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class SuggestAppBarModel<T extends SuggestAppBarView> extends AppBarModel<T> {

    @NotNull
    private final ButtonListModel buttonListModel;

    @Nullable
    private final AppBarModel.OnClickListener closeClickListener;

    @Nullable
    private final Drawable imageDrawable;

    @Nullable
    private final String subTitle;
    private final int subTitleMaxLine;

    @Nullable
    private final String title;
    private final int titleMaxLine;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001b\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u001c\"\n\b\u0001\u0010!\u0018\u0001*\u00020\u001dH\u0082\bJ\"\u0010\"\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010#\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010$\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0015J\u001c\u0010&\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010'\u001a\u00020\rH\u0007J\u001c\u0010(\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010'\u001a\u00020\rH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/google/android/material/appbar/model/SuggestAppBarModel$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonStyle", "Lcom/google/android/material/appbar/model/ButtonStyle;", "buttons", "", "Lcom/google/android/material/appbar/model/ButtonModel;", "closeClickListener", "Lcom/google/android/material/appbar/model/AppBarModel$OnClickListener;", "default_sub_title_max_line_for_image_case", "", "default_sub_title_max_line_for_no_image_case", "default_title_max_line_with_sub_title_for_image_case", "default_title_max_line_with_sub_title_for_no_image_case", "default_title_max_line_without_sub_title", "default_total_max_line_limit_for_image_case", "default_total_max_line_limit_for_no_image_case", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "subTitle", "", "subTitleMaxLine", "title", "titleMaxLine", "build", "Lcom/google/android/material/appbar/model/SuggestAppBarModel;", "Lcom/google/android/material/appbar/model/view/SuggestAppBarView;", "checkMaxLine", "", "create", "T", "setButtons", "setCloseClickListener", "setImage", "drawable", "setSubTitle", "maxLine", "setTitle", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSuggestAppBarModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestAppBarModel.kt\ncom/google/android/material/appbar/model/SuggestAppBarModel$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n139#1,15:160\n1#2:159\n*S KotlinDebug\n*F\n+ 1 SuggestAppBarModel.kt\ncom/google/android/material/appbar/model/SuggestAppBarModel$Builder\n*L\n100#1:160,15\n*E\n"})
    public static final class Builder {

        @Nullable
        private ButtonStyle buttonStyle;

        @NotNull
        private List<? extends ButtonModel> buttons;

        @Nullable
        private AppBarModel.OnClickListener closeClickListener;

        @NotNull
        private final Context context;
        private final int default_sub_title_max_line_for_image_case;
        private final int default_sub_title_max_line_for_no_image_case;
        private final int default_title_max_line_with_sub_title_for_image_case;
        private final int default_title_max_line_with_sub_title_for_no_image_case;
        private final int default_title_max_line_without_sub_title;
        private final int default_total_max_line_limit_for_image_case;
        private final int default_total_max_line_limit_for_no_image_case;

        @Nullable
        private Drawable imageDrawable;

        @Nullable
        private String subTitle;
        private int subTitleMaxLine;

        @Nullable
        private String title;
        private int titleMaxLine;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.default_total_max_line_limit_for_image_case = 3;
            this.default_total_max_line_limit_for_no_image_case = 4;
            this.default_title_max_line_without_sub_title = 3;
            this.default_title_max_line_with_sub_title_for_image_case = 1;
            this.default_title_max_line_with_sub_title_for_no_image_case = 1;
            this.default_sub_title_max_line_for_no_image_case = 3;
            this.default_sub_title_max_line_for_image_case = 2;
            this.buttons = CollectionsKt.emptyList();
        }

        private final void checkMaxLine() {
            int i;
            int i2;
            if (TextUtils.isEmpty(this.subTitle)) {
                this.titleMaxLine = this.default_title_max_line_without_sub_title;
                return;
            }
            if (this.imageDrawable != null) {
                int i4 = this.titleMaxLine;
                if (i4 == 0 || (i2 = this.subTitleMaxLine) == 0) {
                    this.titleMaxLine = this.default_title_max_line_with_sub_title_for_image_case;
                    this.subTitleMaxLine = this.default_sub_title_max_line_for_image_case;
                    return;
                } else {
                    if (i4 + i2 > this.default_total_max_line_limit_for_image_case) {
                        this.titleMaxLine = this.default_title_max_line_with_sub_title_for_image_case;
                        this.subTitleMaxLine = this.default_sub_title_max_line_for_image_case;
                        return;
                    }
                    return;
                }
            }
            int i5 = this.titleMaxLine;
            if (i5 == 0 || (i = this.subTitleMaxLine) == 0) {
                this.titleMaxLine = this.default_title_max_line_with_sub_title_for_no_image_case;
                this.subTitleMaxLine = this.default_sub_title_max_line_for_no_image_case;
            } else if (i5 + i > this.default_total_max_line_limit_for_no_image_case) {
                this.titleMaxLine = this.default_title_max_line_with_sub_title_for_no_image_case;
                this.subTitleMaxLine = this.default_sub_title_max_line_for_no_image_case;
            }
        }

        private final /* synthetic */ <T extends SuggestAppBarView> SuggestAppBarModel<T> create() {
            checkMaxLine();
            Intrinsics.reifiedOperationMarker(4, "T");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SuggestAppBarView.class);
            Context context = this.context;
            String str = this.title;
            int i = this.titleMaxLine;
            String str2 = this.subTitle;
            int i2 = this.subTitleMaxLine;
            Drawable drawable = this.imageDrawable;
            AppBarModel.OnClickListener onClickListener = this.closeClickListener;
            ButtonStyle buttonStyle = this.buttonStyle;
            if (buttonStyle == null) {
                buttonStyle = new ButtonStyle(C4548R.style.Basic_CollapsingToolbar_Button_Light, C4548R.style.Basic_CollapsingToolbar_Button);
            }
            return new SuggestAppBarModel<>(orCreateKotlinClass, context, str, i, str2, i2, drawable, onClickListener, new ButtonListModel(buttonStyle, this.buttons));
        }

        public static /* synthetic */ Builder setButtons$default(Builder builder, List list, ButtonStyle buttonStyle, int i, Object obj) {
            if ((i & 2) != 0) {
                buttonStyle = null;
            }
            return builder.setButtons(list, buttonStyle);
        }

        public static /* synthetic */ Builder setSubTitle$default(Builder builder, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return builder.setSubTitle(str, i);
        }

        public static /* synthetic */ Builder setTitle$default(Builder builder, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return builder.setTitle(str, i);
        }

        @NotNull
        public final SuggestAppBarModel<SuggestAppBarView> build() {
            checkMaxLine();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SuggestAppBarView.class);
            Context context = this.context;
            String str = this.title;
            int i = this.titleMaxLine;
            String str2 = this.subTitle;
            int i2 = this.subTitleMaxLine;
            Drawable drawable = this.imageDrawable;
            AppBarModel.OnClickListener onClickListener = this.closeClickListener;
            ButtonStyle buttonStyle = this.buttonStyle;
            if (buttonStyle == null) {
                buttonStyle = new ButtonStyle(C4548R.style.Basic_CollapsingToolbar_Button_Light, C4548R.style.Basic_CollapsingToolbar_Button);
            }
            return new SuggestAppBarModel<>(orCreateKotlinClass, context, str, i, str2, i2, drawable, onClickListener, new ButtonListModel(buttonStyle, this.buttons));
        }

        @JvmOverloads
        @NotNull
        public final Builder setButtons(@NotNull List<? extends ButtonModel> buttons) {
            Intrinsics.checkNotNullParameter(buttons, "buttons");
            return setButtons$default(this, buttons, null, 2, null);
        }

        @NotNull
        public final Builder setCloseClickListener(@Nullable AppBarModel.OnClickListener closeClickListener) {
            this.closeClickListener = closeClickListener;
            return this;
        }

        @NotNull
        public final Builder setImage(@Nullable Drawable drawable) {
            this.imageDrawable = drawable;
            return this;
        }

        @JvmOverloads
        @NotNull
        public final Builder setSubTitle(@Nullable String str) {
            return setSubTitle$default(this, str, 0, 2, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder setTitle(@Nullable String str) {
            return setTitle$default(this, str, 0, 2, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder setButtons(@NotNull List<? extends ButtonModel> buttons, @Nullable ButtonStyle buttonStyle) {
            Intrinsics.checkNotNullParameter(buttons, "buttons");
            this.buttons = buttons;
            if (buttonStyle != null) {
                this.buttonStyle = buttonStyle;
            }
            return this;
        }

        @JvmOverloads
        @NotNull
        public final Builder setSubTitle(@Nullable String subTitle, int maxLine) {
            this.subTitle = subTitle;
            this.subTitleMaxLine = maxLine;
            return this;
        }

        @JvmOverloads
        @NotNull
        public final Builder setTitle(@Nullable String title, int maxLine) {
            this.title = title;
            this.titleMaxLine = maxLine;
            return this;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SuggestAppBarModel(KClass kClass, Context context, String str, int i, String str2, int i2, Drawable drawable, AppBarModel.OnClickListener onClickListener, ButtonListModel buttonListModel, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        ButtonListModel buttonListModel2;
        AppBarModel.OnClickListener onClickListener2;
        i = (i4 & 8) != 0 ? 0 : i;
        str2 = (i4 & 16) != 0 ? null : str2;
        i2 = (i4 & 32) != 0 ? 0 : i2;
        drawable = (i4 & 64) != 0 ? null : drawable;
        if ((i4 & 128) != 0) {
            buttonListModel2 = buttonListModel;
            onClickListener2 = null;
        } else {
            buttonListModel2 = buttonListModel;
            onClickListener2 = onClickListener;
        }
        this(kClass, context, str, i, str2, i2, drawable, onClickListener2, buttonListModel2);
    }

    @NotNull
    public final ButtonListModel getButtonListModel() {
        return this.buttonListModel;
    }

    @Nullable
    public final AppBarModel.OnClickListener getCloseClickListener() {
        return this.closeClickListener;
    }

    @Nullable
    public final Drawable getImageDrawable() {
        return this.imageDrawable;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    public final int getSubTitleMaxLine() {
        return this.subTitleMaxLine;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getTitleMaxLine() {
        return this.titleMaxLine;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestAppBarModel(@NotNull KClass<T> kclazz, @NotNull Context context, @Nullable String str, int i, @Nullable String str2, int i2, @Nullable Drawable drawable, @Nullable AppBarModel.OnClickListener onClickListener, @NotNull ButtonListModel buttonListModel) {
        super(kclazz, context);
        Intrinsics.checkNotNullParameter(kclazz, "kclazz");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buttonListModel, "buttonListModel");
        this.title = str;
        this.titleMaxLine = i;
        this.subTitle = str2;
        this.subTitleMaxLine = i2;
        this.imageDrawable = drawable;
        this.closeClickListener = onClickListener;
        this.buttonListModel = buttonListModel;
    }

    @Override // com.google.android.material.appbar.model.AppBarModel
    @NotNull
    public T init(@NotNull T moduleView) {
        Intrinsics.checkNotNullParameter(moduleView, "moduleView");
        moduleView.setModel(this);
        moduleView.setTitle(this.title, this.titleMaxLine);
        moduleView.setSubTitle(this.subTitle, this.subTitleMaxLine);
        moduleView.setImage(this.imageDrawable);
        moduleView.setCloseClickListener(this.closeClickListener);
        moduleView.setButtonModules(this.buttonListModel);
        Context context = moduleView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        moduleView.updateResource(context);
        return moduleView;
    }
}
