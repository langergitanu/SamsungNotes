package com.samsung.android.app.notes.widget.setting.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.setting.model.WidgetSettingModel;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter;
import com.samsung.android.app.notes.widget.setting.view.preview.IWidgetPreviewLayoutManager;
import com.samsung.android.app.notes.widget.setting.view.preview.TopWidgetPreviewLayoutManager;
import com.samsung.android.app.notes.widget.setting.view.preview.WidgetPreviewLayoutManager;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0012\u0010&\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\u0012\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\u001c\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u001b2\b\u00101\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u00102\u001a\u00020\u001eH\u0016J\b\u00103\u001a\u00020\u001eH\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u001eH\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u0019H\u0002J\b\u0010;\u001a\u00020\u001eH\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u00020\u001eH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/WidgetSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "Lcom/samsung/android/app/notes/widget/setting/view/WidgetSettingContract;", "parent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPreviewTitleContainer", "mPreviewTitle", "Landroid/widget/TextView;", "mNoteTitleView", "mPreview", "mProgressView", "mEmptyView", "mPreviewBackgroundView", "Landroid/widget/ImageView;", "mPreviewSettingView", "mPreviewVoiceView", "mPreviewOptionSettingView", "mPreviewOptionVoiceView", "mPresenter", "Lcom/samsung/android/app/notes/widget/setting/presenter/WidgetSettingPresenter;", "mPreviewManager", "Lcom/samsung/android/app/notes/widget/setting/view/preview/IWidgetPreviewLayoutManager;", "mIsShowNoteWidget", "", "mNormalPreviewBitmap", "Landroid/graphics/Bitmap;", "mDarkPreviewBitmap", "init", "", "initPreviewChild", "initPreviewSetting", "initChange", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "setPresenter", "updateEmptyPreview", "isDarkEmptyBackground", "()Z", "updateNoteTitleView", "title", "", "updatePreviewTitleView", "updateBgSettingMenu", "updatePreview", "whiteTheme", "blackTheme", "showLoadingView", "hideLoadingView", "updateWidgetPreviewAlpha", "alpha", "", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateOptionBackground", "isDarkTheme", "updateWidgetBackgroundColor", "updateTitleVoice", "voice", "updateShowNoteTileVoice", "hideEmptyView", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSettingView.kt\ncom/samsung/android/app/notes/widget/setting/view/WidgetSettingView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,328:1\n1#2:329\n*E\n"})
public final class WidgetSettingView extends BaseWidgetSettingView implements WidgetSettingContract {

    @NotNull
    protected static final String TAG = "WidgetSettingView";

    @Nullable
    private Bitmap mDarkPreviewBitmap;

    @Nullable
    private View mEmptyView;
    private boolean mIsShowNoteWidget;

    @Nullable
    private Bitmap mNormalPreviewBitmap;

    @Nullable
    private TextView mNoteTitleView;

    @Nullable
    private WidgetSettingPresenter mPresenter;

    @Nullable
    private View mPreview;

    @Nullable
    private ImageView mPreviewBackgroundView;

    @Nullable
    private IWidgetPreviewLayoutManager mPreviewManager;

    @Nullable
    private View mPreviewOptionSettingView;

    @Nullable
    private View mPreviewOptionVoiceView;

    @Nullable
    private ImageView mPreviewSettingView;

    @Nullable
    private TextView mPreviewTitle;

    @Nullable
    private View mPreviewTitleContainer;

    @Nullable
    private View mPreviewVoiceView;

    @Nullable
    private View mProgressView;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingView(@Nullable View view) {
        super(view);
        Intrinsics.checkNotNull(view);
    }

    private final void initChange() {
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_setting_control_change_note, (ViewGroup) null);
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 0);
        View viewFindViewById2 = viewInflate.findViewById(C11391R.id.widget_setting_change_title_text);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mNoteTitleView = (TextView) viewFindViewById2;
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        updateNoteTitleView(widgetSettingPresenter != null ? widgetSettingPresenter.getRecommendTitle() : null);
        View viewFindViewById3 = viewInflate.findViewById(C11391R.id.widget_setting_change_btn);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) viewFindViewById3;
        button.setOnClickListener(new ViewOnClickListenerC0157a(this, 11));
        CharUtils.applyTextSizeUntilLargeSize(getMParent().getContext(), button, 18.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initChange$lambda$1(WidgetSettingView widgetSettingView, View view) {
        WidgetSettingPresenter widgetSettingPresenter = widgetSettingView.mPresenter;
        if (widgetSettingPresenter != null) {
            widgetSettingPresenter.onChangeClicked();
        }
    }

    private final void initPreviewChild() {
        WidgetSettingModel mModel;
        View view = this.mPreview;
        String uuid = null;
        this.mProgressView = view != null ? view.findViewById(C11391R.id.widget_content_loading) : null;
        View view2 = this.mPreview;
        this.mEmptyView = view2 != null ? view2.findViewById(C11391R.id.widget_empty_view) : null;
        View view3 = this.mPreview;
        View viewFindViewById = view3 != null ? view3.findViewById(C11391R.id.background) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.mPreviewBackgroundView = (ImageView) viewFindViewById;
        View view4 = this.mPreview;
        this.mPreviewTitleContainer = view4 != null ? view4.findViewById(C11391R.id.widget_title_layout) : null;
        if (this.mIsShowNoteWidget) {
            View view5 = this.mPreview;
            View viewFindViewById2 = view5 != null ? view5.findViewById(C11391R.id.widget_title) : null;
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.mPreviewTitle = (TextView) viewFindViewById2;
            View view6 = this.mPreview;
            View viewFindViewById3 = view6 != null ? view6.findViewById(C11391R.id.widget_settings) : null;
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            this.mPreviewSettingView = (ImageView) viewFindViewById3;
            View view7 = this.mPreview;
            this.mPreviewOptionVoiceView = view7 != null ? view7.findViewById(C11391R.id.widget_overlap_voice) : null;
            View view8 = this.mPreview;
            this.mPreviewOptionSettingView = view8 != null ? view8.findViewById(C11391R.id.widget_overlap_setting) : null;
        } else {
            View view9 = this.mPreview;
            View viewFindViewById4 = view9 != null ? view9.findViewById(C11391R.id.widget_img_shortcut_title) : null;
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            this.mPreviewTitle = (TextView) viewFindViewById4;
        }
        View view10 = this.mPreview;
        View viewFindViewById5 = view10 != null ? view10.findViewById(C11391R.id.widget_voice) : null;
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.mPreviewVoiceView = (ImageView) viewFindViewById5;
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        if (widgetSettingPresenter != null && (mModel = widgetSettingPresenter.getMModel()) != null) {
            uuid = mModel.getUUID();
        }
        if (!Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            View view11 = this.mEmptyView;
            if (view11 != null) {
                view11.setVisibility(8);
            }
            initPreviewSetting();
            return;
        }
        hideLoadingView();
        updateWidgetBackgroundColor();
        View view12 = this.mEmptyView;
        if (view12 != null) {
            view12.setVisibility(0);
        }
    }

    private final void initPreviewSetting() {
        if (this.mIsShowNoteWidget) {
            ImageView imageView = this.mPreviewSettingView;
            if (imageView != null) {
                imageView.setImageResource(C11391R.drawable.widget_ic_setting);
            }
            if (WidgetUtils.INSTANCE.isSupportSettingByQuickOption()) {
                ImageView imageView2 = this.mPreviewSettingView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                View view = this.mPreviewOptionSettingView;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
            boolean zIsEmpty = TextUtils.isEmpty(widgetSettingPresenter != null ? widgetSettingPresenter.getTitle() : null);
            View view2 = this.mPreviewOptionSettingView;
            if (view2 != null) {
                view2.setVisibility(!zIsEmpty ? 8 : 0);
            }
            ImageView imageView3 = this.mPreviewSettingView;
            if (imageView3 != null) {
                imageView3.setVisibility(zIsEmpty ? 8 : 0);
            }
        }
    }

    private final boolean isDarkEmptyBackground() {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        Context context = getMParent().getContext();
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        Integer numValueOf = widgetSettingPresenter != null ? Integer.valueOf(widgetSettingPresenter.getDarkMode()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int currentBackgroundColor = companion.getCurrentBackgroundColor(context, 1, numValueOf.intValue());
        Context context2 = getMParent().getContext();
        WidgetSettingPresenter widgetSettingPresenter2 = this.mPresenter;
        Integer numValueOf2 = widgetSettingPresenter2 != null ? Integer.valueOf(widgetSettingPresenter2.getReverseTransparency()) : null;
        Intrinsics.checkNotNull(numValueOf2);
        return companion.checkTheme(context2, numValueOf2.intValue(), currentBackgroundColor) == 0;
    }

    private final void updateOptionBackground(boolean isDarkTheme) {
        int i = isDarkTheme ? C11391R.drawable.widget_option_dark_background : C11391R.drawable.widget_option_white_background;
        View view = this.mPreviewOptionSettingView;
        if (view != null) {
            view.setBackgroundResource(i);
        }
        View view2 = this.mPreviewOptionVoiceView;
        if (view2 != null) {
            view2.setBackgroundResource(i);
        }
    }

    private final void updateShowNoteTileVoice(boolean voice) {
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        if (TextUtils.isEmpty(widgetSettingPresenter != null ? widgetSettingPresenter.getTitle() : null)) {
            View view = this.mPreviewTitleContainer;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mPreviewVoiceView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.mPreviewOptionVoiceView;
            if (view3 != null) {
                view3.setVisibility(voice ? 0 : 8);
                return;
            }
            return;
        }
        View view4 = this.mPreviewTitleContainer;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        View view5 = this.mPreviewVoiceView;
        if (view5 != null) {
            view5.setVisibility(voice ? 0 : 8);
        }
        View view6 = this.mPreviewOptionVoiceView;
        if (view6 != null) {
            view6.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    @NotNull
    public BaseWidgetSettingPresenter getPresenter() {
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetSettingPresenter);
        return widgetSettingPresenter;
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void hideEmptyView() {
        View view;
        View view2 = this.mEmptyView;
        if (view2 == null || view2.getVisibility() != 0 || (view = this.mEmptyView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void hideLoadingView() {
        View view = this.mProgressView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void init() {
        IWidgetPreviewLayoutManager widgetPreviewLayoutManager;
        super.init();
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        boolean z = false;
        if (widgetSettingPresenter != null) {
            int widgetId = widgetSettingPresenter.getWidgetId();
            Context context = getMParent().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (ProviderUtils.isProviderWidget(context, widgetId)) {
                z = true;
            }
        }
        this.mIsShowNoteWidget = z;
        if (BaseWidgetUtils.INSTANCE.isFoldSettingLayout()) {
            Resources resources = getMParent().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            widgetPreviewLayoutManager = new TopWidgetPreviewLayoutManager(resources, this.mIsShowNoteWidget);
        } else {
            Resources resources2 = getMParent().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            widgetPreviewLayoutManager = new WidgetPreviewLayoutManager(resources2, this.mIsShowNoteWidget);
        }
        this.mPreviewManager = widgetPreviewLayoutManager;
        View mParent = getMParent();
        WidgetSettingPresenter widgetSettingPresenter2 = this.mPresenter;
        this.mPreview = widgetPreviewLayoutManager.initPreview(mParent, widgetSettingPresenter2 != null ? widgetSettingPresenter2.getOneUiWidgetSource() : null);
        initPreviewChild();
        WidgetSettingPresenter widgetSettingPresenter3 = this.mPresenter;
        updatePreviewTitleView(widgetSettingPresenter3 != null ? widgetSettingPresenter3.getTitle() : null);
        initChange();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void setPresenter(@Nullable BaseWidgetSettingPresenter presenter) {
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
        this.mPresenter = (WidgetSettingPresenter) presenter;
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void showLoadingView() {
        View view = this.mProgressView;
        TextView textView = view != null ? (TextView) view.findViewById(C11391R.id.widget_content_loading) : null;
        if (isBlackBackground()) {
            if (textView != null) {
                textView.setTextColor(ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_text_loading_color_white));
            }
        } else if (textView != null) {
            textView.setTextColor(ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_text_loading_color_black));
        }
        View view2 = this.mProgressView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mEmptyView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void updateBgSettingMenu() {
        int dimensionPixelSize;
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_background_color_container);
        WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
        Context context = getMParent().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        Integer numValueOf = widgetSettingPresenter != null ? Integer.valueOf(widgetSettingPresenter.getPageColor()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        WidgetSettingPresenter widgetSettingPresenter2 = this.mPresenter;
        Boolean boolValueOf = widgetSettingPresenter2 != null ? Boolean.valueOf(widgetSettingPresenter2.getIsBackgroundImage()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        if (companion.isWidgetBgDarkThemeColor(context, iIntValue, boolValueOf.booleanValue(), true)) {
            RadioGroup mBgColorRadioGroup = getMBgColorRadioGroup();
            if (mBgColorRadioGroup != null) {
                WidgetSettingPresenter widgetSettingPresenter3 = this.mPresenter;
                mBgColorRadioGroup.check((widgetSettingPresenter3 == null || widgetSettingPresenter3.getBackgroundColor() != 1) ? C11391R.id.radio_black : C11391R.id.radio_white);
            }
            viewFindViewById.setVisibility(0);
            dimensionPixelSize = getMParent().getResources().getDimensionPixelSize(C11391R.dimen.widget_setting_bg_color_overlay);
        } else {
            RadioGroup mBgColorRadioGroup2 = getMBgColorRadioGroup();
            if (mBgColorRadioGroup2 != null) {
                mBgColorRadioGroup2.check(C11391R.id.radio_white);
            }
            viewFindViewById.setVisibility(8);
            dimensionPixelSize = getMParent().getResources().getDimensionPixelSize(C11391R.dimen.widget_setting_item_height);
        }
        View viewFindViewById2 = getMParent().findViewById(C11391R.id.widget_setting_background_color_round_overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        updateRoundCornerViewHeight(viewFindViewById2, dimensionPixelSize);
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void updateEmptyPreview() {
        int color = isDarkEmptyBackground() ? ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_black_theme_text_color) : ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_white_theme_text_color);
        View view = this.mEmptyView;
        if (view instanceof TextView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) view).setTextColor(color);
        } else if (view instanceof ImageView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) view).setColorFilter(color);
        }
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void updateNoteTitleView(@Nullable String title) {
        Resources resources;
        if (TextUtils.isEmpty(title)) {
            TextView textView = this.mNoteTitleView;
            if (textView != null) {
                textView.setText((textView == null || (resources = textView.getResources()) == null) ? null : resources.getString(C11391R.string.base_string_no_title));
                return;
            }
            return;
        }
        TextView textView2 = this.mNoteTitleView;
        if (textView2 != null) {
            textView2.setText(title);
        }
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void updatePreview(@Nullable Bitmap whiteTheme, @Nullable Bitmap blackTheme) {
        ImageView imageView = this.mPreviewBackgroundView;
        if (imageView != null) {
            imageView.clearColorFilter();
        }
        Bitmap bitmap = this.mNormalPreviewBitmap;
        if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
            Bitmap bitmap2 = this.mNormalPreviewBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.mNormalPreviewBitmap = null;
        }
        Bitmap bitmap3 = this.mDarkPreviewBitmap;
        if (bitmap3 != null && bitmap3 != null && !bitmap3.isRecycled()) {
            Bitmap bitmap4 = this.mDarkPreviewBitmap;
            if (bitmap4 != null) {
                bitmap4.recycle();
            }
            this.mDarkPreviewBitmap = null;
        }
        this.mNormalPreviewBitmap = whiteTheme;
        this.mDarkPreviewBitmap = blackTheme;
        updateWidgetSettingDarkMode();
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void updatePreviewTitleView(@Nullable String title) {
        if (!TextUtils.isEmpty(title)) {
            TextView textView = this.mPreviewTitle;
            if (textView != null) {
                textView.setText(title);
            }
            TextView textView2 = this.mPreviewTitle;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            View view = this.mPreviewTitleContainer;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.mEmptyView;
        if (view2 == null || view2.getVisibility() != 8) {
            return;
        }
        TextView textView3 = this.mPreviewTitle;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        View view3 = this.mPreviewTitleContainer;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract
    public void updateTitleVoice(boolean voice) {
        View view;
        View view2;
        if (this.mIsShowNoteWidget) {
            updateShowNoteTileVoice(voice);
            return;
        }
        if (voice && (((view = this.mPreviewTitleContainer) == null || view.getVisibility() != 0) && (view2 = this.mPreviewTitleContainer) != null)) {
            view2.setVisibility(0);
        }
        View view3 = this.mPreviewVoiceView;
        if (view3 != null) {
            view3.setVisibility(voice ? 0 : 8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetBackgroundColor() {
        int color;
        ImageView imageView = this.mPreviewBackgroundView;
        if (imageView != null) {
            imageView.clearColorFilter();
        }
        ImageView imageView2 = this.mPreviewBackgroundView;
        if (imageView2 != null) {
            imageView2.setImageResource(this.mIsShowNoteWidget ? C11391R.drawable.widget_background_white : C11391R.drawable.widget_short_background_white);
        }
        View view = this.mEmptyView;
        if (view == null || view.getVisibility() != 8) {
            color = isBlackBackground() ? ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_bg_color_black) : ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_bg_color);
        } else {
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Context context = getMParent().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
            Integer numValueOf = widgetSettingPresenter != null ? Integer.valueOf(widgetSettingPresenter.getPageColor()) : null;
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            WidgetSettingPresenter widgetSettingPresenter2 = this.mPresenter;
            Boolean boolValueOf = widgetSettingPresenter2 != null ? Boolean.valueOf(widgetSettingPresenter2.getIsBackgroundImage()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            color = companion.getWidgetBgThemeColor(context, iIntValue, boolValueOf.booleanValue(), isBlackBackground());
        }
        AbstractC4539a.m3203m(color, "updateWidgetBackgroundColor#. ", TAG);
        ImageView imageView3 = this.mPreviewBackgroundView;
        if (imageView3 != null) {
            imageView3.setColorFilter(color);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewAlpha(int alpha) {
        AbstractC4539a.m3203m(alpha, "updateWidgetPreviewAlpha# alpha : ", TAG);
        ImageView imageView = this.mPreviewBackgroundView;
        if (imageView != null) {
            imageView.setImageAlpha(alpha);
        }
        ImageView imageView2 = this.mPreviewBackgroundView;
        if (imageView2 != null) {
            imageView2.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewTheme() {
        View view = this.mEmptyView;
        if (view != null && view.getVisibility() == 0) {
            Logger.m8702i(TAG, "updateWidgetPreviewTheme# empty view");
            updateEmptyPreview();
            return;
        }
        int currentTheme = getCurrentTheme();
        Logger.m8702i(TAG, "updateWidgetPreviewTheme# theme: " + currentTheme);
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_content);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewFindViewById;
        if (this.mIsShowNoteWidget) {
            View view2 = this.mPreview;
            ImageView imageView2 = view2 != null ? (ImageView) view2.findViewById(C11391R.id.widget_overlap_setting_icon) : null;
            if (currentTheme == 1) {
                ImageView imageView3 = this.mPreviewSettingView;
                if (imageView3 != null) {
                    imageView3.clearColorFilter();
                }
                if (imageView2 != null) {
                    imageView2.clearColorFilter();
                }
            } else {
                int color = ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_black_theme_text_color);
                ImageView imageView4 = this.mPreviewSettingView;
                if (imageView4 != null) {
                    imageView4.setColorFilter(color);
                }
                if (imageView2 != null) {
                    imageView2.setColorFilter(color);
                }
            }
            updateOptionBackground(currentTheme == 0);
        }
        WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
        Context context = getMParent().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WidgetSettingPresenter widgetSettingPresenter = this.mPresenter;
        Integer numValueOf = widgetSettingPresenter != null ? Integer.valueOf(widgetSettingPresenter.getPageColor()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        WidgetSettingPresenter widgetSettingPresenter2 = this.mPresenter;
        Boolean boolValueOf = widgetSettingPresenter2 != null ? Boolean.valueOf(widgetSettingPresenter2.getIsBackgroundImage()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        int color2 = companion.isWidgetTitleDarkThemeColor(context, iIntValue, boolValueOf.booleanValue(), currentTheme == 0) ? ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_black_theme_text_color) : ResourceUtils.getColor(getMParent().getContext(), C11391R.color.widget_white_theme_text_color);
        TextView textView = this.mPreviewTitle;
        if (textView != null) {
            textView.setTextColor(color2);
        }
        Context context2 = getMParent().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        WidgetSettingPresenter widgetSettingPresenter3 = this.mPresenter;
        Integer numValueOf2 = widgetSettingPresenter3 != null ? Integer.valueOf(widgetSettingPresenter3.getPageColor()) : null;
        Intrinsics.checkNotNull(numValueOf2);
        int iIntValue2 = numValueOf2.intValue();
        WidgetSettingPresenter widgetSettingPresenter4 = this.mPresenter;
        Boolean boolValueOf2 = widgetSettingPresenter4 != null ? Boolean.valueOf(widgetSettingPresenter4.getIsBackgroundImage()) : null;
        Intrinsics.checkNotNull(boolValueOf2);
        if (companion.isWidgetBgDarkThemeColor(context2, iIntValue2, boolValueOf2.booleanValue(), currentTheme == 0)) {
            imageView.setImageBitmap(this.mDarkPreviewBitmap);
        } else {
            imageView.setImageBitmap(this.mNormalPreviewBitmap);
        }
        imageView.invalidate();
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetSettingDarkMode() {
        menuEnableUpdate();
        updateWidgetPreviewTheme();
        updateWidgetPreviewAlpha(getPreviewAlpha());
    }
}
