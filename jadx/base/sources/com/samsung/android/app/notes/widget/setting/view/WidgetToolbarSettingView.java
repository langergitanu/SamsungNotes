package com.samsung.android.app.notes.widget.setting.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetToolbarSettingPresenter;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J \u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/WidgetToolbarSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "parent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPresenter", "Lcom/samsung/android/app/notes/widget/setting/presenter/WidgetToolbarSettingPresenter;", "mPreview", "Landroid/widget/RelativeLayout;", "mAppName", "Landroid/widget/TextView;", "mBackground", "Landroid/widget/ImageView;", "mListBackground", "mAppIcon", "mText", "mPen", "mBrush", "mImage", "mVoice", "init", "", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "setPresenter", "initPreview", "initWidgetPreviewContainer", "widgetID", "", "oneUiWidgetSource", "", "updateWidgetBackground", "initImageResource", "updateWidgetPreview", "updateWidgetPreviewAlpha", "alpha", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateWidgetBackgroundColor", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetToolbarSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetToolbarSettingView.kt\ncom/samsung/android/app/notes/widget/setting/view/WidgetToolbarSettingView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
public final class WidgetToolbarSettingView extends BaseWidgetSettingView {

    @NotNull
    private static final String TAG = "WidgetToolbarSettingView";

    @Nullable
    private ImageView mAppIcon;

    @Nullable
    private TextView mAppName;

    @Nullable
    private ImageView mBackground;

    @Nullable
    private ImageView mBrush;

    @Nullable
    private ImageView mImage;

    @Nullable
    private ImageView mListBackground;

    @Nullable
    private ImageView mPen;

    @Nullable
    private WidgetToolbarSettingPresenter mPresenter;

    @Nullable
    private RelativeLayout mPreview;

    @Nullable
    private ImageView mText;

    @Nullable
    private ImageView mVoice;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetToolbarSettingView(@Nullable View view) {
        super(view);
        Intrinsics.checkNotNull(view);
    }

    private final void initImageResource() {
        ImageView imageView = this.mAppIcon;
        if (imageView != null) {
            imageView.setImageResource(C6635R.drawable.ic_widget_notes_line);
        }
        ImageView imageView2 = this.mText;
        if (imageView2 != null) {
            imageView2.setImageResource(C6635R.drawable.ic_widget_text);
        }
        ImageView imageView3 = this.mPen;
        if (imageView3 != null) {
            imageView3.setImageResource(C6635R.drawable.ic_widget_handwriting);
        }
        ImageView imageView4 = this.mBrush;
        if (imageView4 != null) {
            imageView4.setImageResource(C6635R.drawable.ic_widget_brush);
        }
        ImageView imageView5 = this.mImage;
        if (imageView5 != null) {
            imageView5.setImageResource(C6635R.drawable.ic_widget_image);
        }
        ImageView imageView6 = this.mVoice;
        if (imageView6 != null) {
            imageView6.setImageResource(C6635R.drawable.ic_widget_voice);
        }
    }

    private final void initPreview() {
        RelativeLayout relativeLayout = this.mPreview;
        this.mBackground = relativeLayout != null ? (ImageView) relativeLayout.findViewById(C6635R.id.background) : null;
        RelativeLayout relativeLayout2 = this.mPreview;
        TextView textView = relativeLayout2 != null ? (TextView) relativeLayout2.findViewById(C6635R.id.widget_app_name) : null;
        this.mAppName = textView;
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 34) {
                Intrinsics.checkNotNull(textView);
                textView.setText(C6635R.string.app_name_simple);
            } else {
                Intrinsics.checkNotNull(textView);
                textView.setText(getMParent().getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C6635R.string.notes_jp : C6635R.string.app_name));
            }
        }
        RelativeLayout relativeLayout3 = this.mPreview;
        this.mListBackground = relativeLayout3 != null ? (ImageView) relativeLayout3.findViewById(C6635R.id.inside_background) : null;
        RelativeLayout relativeLayout4 = this.mPreview;
        this.mAppIcon = relativeLayout4 != null ? (ImageView) relativeLayout4.findViewById(C6635R.id.widget_launch_note_icon) : null;
        RelativeLayout relativeLayout5 = this.mPreview;
        this.mText = relativeLayout5 != null ? (ImageView) relativeLayout5.findViewById(C6635R.id.widget_add_icon) : null;
        RelativeLayout relativeLayout6 = this.mPreview;
        this.mPen = relativeLayout6 != null ? (ImageView) relativeLayout6.findViewById(C6635R.id.widget_writing_icon) : null;
        RelativeLayout relativeLayout7 = this.mPreview;
        this.mBrush = relativeLayout7 != null ? (ImageView) relativeLayout7.findViewById(C6635R.id.widget_drawing_icon) : null;
        RelativeLayout relativeLayout8 = this.mPreview;
        this.mImage = relativeLayout8 != null ? (ImageView) relativeLayout8.findViewById(C6635R.id.widget_image_icon) : null;
        RelativeLayout relativeLayout9 = this.mPreview;
        this.mVoice = relativeLayout9 != null ? (ImageView) relativeLayout9.findViewById(C6635R.id.widget_voice_icon) : null;
        initImageResource();
        updateWidgetBackground();
        updateWidgetSettingDarkMode();
    }

    private final void initWidgetPreviewContainer(View parent, int widgetID, String oneUiWidgetSource) {
        View viewFindViewById = getMParent().findViewById(C6635R.id.widget_setting_preview_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (!companion.isFoldSettingLayout() && getMParent().getResources().getConfiguration().orientation == 1) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.height = relativeLayout.getResources().getDimensionPixelSize(C6635R.dimen.widget_setting_preview_container_widget_size_one_height);
            relativeLayout.setLayoutParams(layoutParams);
        }
        if (oneUiWidgetSource != null && oneUiWidgetSource.equals(BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(parent.getContext(), C6635R.color.widget_setting_background));
        }
        View viewFindViewById2 = getMParent().findViewById(C6635R.id.widget_setting_preview);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById2;
        ViewGroup.LayoutParams layoutParams2 = relativeLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (companion.isFoldSettingLayout()) {
            layoutParams2.width = getMParent().getResources().getDimensionPixelSize(C6635R.dimen.widget_setting_toolbar_preview_width_top);
            layoutParams2.height = getMParent().getResources().getDimensionPixelSize(C6635R.dimen.widget_setting_toolbar_preview_height_top);
        } else {
            layoutParams2.width = getMParent().getResources().getDimensionPixelSize(C6635R.dimen.widget_setting_toolbar_preview_width);
            layoutParams2.height = getMParent().getResources().getDimensionPixelSize(C6635R.dimen.widget_setting_toolbar_preview_height);
        }
        relativeLayout2.setLayoutParams(layoutParams2);
        View viewInflate = LayoutInflater.from(getMParent().getContext()).inflate(C6635R.layout.widget_toolbar_setting_preview, relativeLayout2);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mPreview = (RelativeLayout) viewInflate;
    }

    private final void updateWidgetBackground() {
        getMParent().findViewById(C6635R.id.widget_setting_background_color_container).setVisibility(0);
        int dimensionPixelSize = getMParent().getResources().getDimensionPixelSize(C6635R.dimen.widget_setting_bg_color_overlay);
        View viewFindViewById = getMParent().findViewById(C6635R.id.widget_setting_background_color_round_overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        updateRoundCornerViewHeight(viewFindViewById, dimensionPixelSize);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    @NotNull
    public BaseWidgetSettingPresenter getPresenter() {
        WidgetToolbarSettingPresenter widgetToolbarSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetToolbarSettingPresenter);
        return widgetToolbarSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void init() {
        super.init();
        View mParent = getMParent();
        WidgetToolbarSettingPresenter widgetToolbarSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetToolbarSettingPresenter);
        int widgetId = widgetToolbarSettingPresenter.getWidgetId();
        WidgetToolbarSettingPresenter widgetToolbarSettingPresenter2 = this.mPresenter;
        initWidgetPreviewContainer(mParent, widgetId, String.valueOf(widgetToolbarSettingPresenter2 != null ? widgetToolbarSettingPresenter2.getOneUiWidgetSource() : null));
        initPreview();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void setPresenter(@Nullable BaseWidgetSettingPresenter presenter) {
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetToolbarSettingPresenter");
        this.mPresenter = (WidgetToolbarSettingPresenter) presenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetBackgroundColor() {
        int color = isBlackBackground() ? ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_toolbar_background_color_dark_theme) : ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_toolbar_background_color_white_theme);
        AbstractC4539a.m3203m(color, "updateWidgetBackgroundColor# ", TAG);
        ImageView imageView = this.mBackground;
        if (imageView != null) {
            updateBackgroundColor(imageView, C6635R.drawable.widget_toolbar_background, color);
        }
        int color2 = isBlackBackground() ? ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_inside_background_color_black) : ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_inside_background_color_white);
        ImageView imageView2 = this.mListBackground;
        if (imageView2 != null) {
            updateBackgroundColor(imageView2, C6635R.drawable.widget_inside_background, color2);
        }
    }

    public final void updateWidgetPreview() {
        boolean zIsDarkTheme = isDarkTheme();
        Logger.m8697d(TAG, "updateWidgetPreview. darkTheme: " + zIsDarkTheme);
        int color = zIsDarkTheme ? ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_toolbar_icon_color_dark_theme) : ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_toolbar_icon_color_white_theme);
        ImageView imageView = this.mAppIcon;
        if (imageView != null) {
            imageView.setColorFilter(color);
        }
        ImageView imageView2 = this.mText;
        if (imageView2 != null) {
            imageView2.setColorFilter(color);
        }
        ImageView imageView3 = this.mPen;
        if (imageView3 != null) {
            imageView3.setColorFilter(color);
        }
        ImageView imageView4 = this.mBrush;
        if (imageView4 != null) {
            imageView4.setColorFilter(color);
        }
        ImageView imageView5 = this.mImage;
        if (imageView5 != null) {
            imageView5.setColorFilter(color);
        }
        ImageView imageView6 = this.mVoice;
        if (imageView6 != null) {
            imageView6.setColorFilter(color);
        }
        TextView textView = this.mAppName;
        if (textView != null) {
            Intrinsics.checkNotNull(textView);
            textView.setTextColor(color);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewAlpha(int alpha) {
        AbstractC4539a.m3203m(alpha, "updateWidgetPreviewAlpha. ", TAG);
        ImageView imageView = this.mBackground;
        if (imageView != null) {
            imageView.setImageAlpha(alpha);
        }
        ImageView imageView2 = this.mBackground;
        if (imageView2 != null) {
            imageView2.invalidate();
        }
        ImageView imageView3 = this.mListBackground;
        if (imageView3 != null) {
            imageView3.setImageAlpha(alpha);
        }
        ImageView imageView4 = this.mListBackground;
        if (imageView4 != null) {
            imageView4.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewTheme() {
        updateWidgetPreview();
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetSettingDarkMode() {
        menuEnableUpdate();
        updateWidgetPreview();
        updateWidgetBackgroundColor();
        updateWidgetPreviewAlpha(getPreviewAlpha());
    }
}
