package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0003J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingRemoverLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingLayout;", "mContainer", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mSettingLayout", "Landroid/view/ViewGroup;", "mContext", "Landroid/content/Context;", "mResource", "Landroid/content/res/Resources;", "mOrientation", "", "initEraseAllButton", "", "initPosition", "init", Constants.IntentExtraValue.SHOW, "hide", "isVisible", "", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "initialize", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingRemoverLayout extends SettingLayout {

    @NotNull
    private static final String TAG = SOLogger.createTag("SettingRemoverLayout");

    @NotNull
    private final View mContainer;

    @NotNull
    private final Context mContext;
    private final int mOrientation;

    @NotNull
    private final Resources mResource;
    private ViewGroup mSettingLayout;

    public SettingRemoverLayout(@NotNull View mContainer) {
        Intrinsics.checkNotNullParameter(mContainer, "mContainer");
        this.mContainer = mContainer;
        Context context = mContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mContext = context;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        this.mResource = resources;
        this.mOrientation = resources.getConfiguration().orientation;
        if (mContainer instanceof ViewGroup) {
            View viewInflate = LayoutInflater.from(context).inflate(C9086R.layout.screenoff_remover_setting_layout, (ViewGroup) mContainer, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            this.mSettingLayout = viewGroup;
            ViewGroup viewGroup2 = (ViewGroup) mContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
                viewGroup = null;
            }
            viewGroup2.addView(viewGroup);
        }
    }

    @SuppressLint({"DiscouragedApi"})
    private final void initEraseAllButton() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPosition#");
        int identifier = this.mResource.getIdentifier("remover_setting_view_erase_all", "id", this.mContext.getPackageName());
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        View viewFindViewById = viewGroup.findViewById(identifier);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) viewFindViewById;
        button.setOnClickListener(new ViewOnClickListenerC8556a(this, 26));
        Context context = this.mContext;
        CharUtils.applyTextSizeUntilLargeSize(context, button, ResourceUtils.convertPixelToSp(context, this.mResource.getDimension(C9086R.dimen.screenoff_remover_setting_view_text_size)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEraseAllButton$lambda$0(SettingRemoverLayout settingRemoverLayout, View view) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "SettingRemoverLayout# onClick");
        SAManager.INSTANCE.getINSTANCE().onEraseAll();
        ISettingViewManager mSettingViewManager = settingRemoverLayout.getMSettingViewManager();
        if (mSettingViewManager != null) {
            mSettingViewManager.onDeleteAllObject();
        }
    }

    private final void initPosition() {
        AbstractC8014b.m7206h("initPosition# orientation ", this.mOrientation, SOLogger.INSTANCE, TAG);
        ViewGroup viewGroup = this.mSettingLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.mOrientation == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            layoutParams2.gravity = 8388659;
            layoutParams2.setMarginStart((int) this.mResource.getDimension(C9086R.dimen.screenoff_remover_setting_view_margin_start_portrait));
            layoutParams2.topMargin = (int) this.mResource.getDimension(C9086R.dimen.screenoff_remover_setting_view_margin_top_portrait);
        } else {
            Object systemService = this.mContainer.getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            layoutParams2.gravity = 80;
            int dimension = (int) this.mResource.getDimension(C9086R.dimen.screenoff_remover_setting_view_margin_start_landscape);
            int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this.mContainer.getContext());
            if (zIsRTLMode) {
                if (rotation == 3) {
                    layoutParams2.setMarginEnd(dimension + navigationBarHeightIgnoreHasSoftKey);
                } else {
                    layoutParams2.setMarginEnd(dimension);
                }
            } else if (rotation == 3) {
                layoutParams2.setMarginStart(dimension + navigationBarHeightIgnoreHasSoftKey);
            } else {
                layoutParams2.setMarginStart(dimension);
            }
            layoutParams2.bottomMargin = (int) this.mResource.getDimension(C9086R.dimen.screenoff_remover_setting_view_margin_bottom_landscape);
        }
        ViewGroup viewGroup3 = this.mSettingLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.setLayoutParams(layoutParams2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void hide() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "hide#");
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void init() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        initEraseAllButton();
        initPosition();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        return viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void show() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "show#");
        SAManager.INSTANCE.getINSTANCE().onRemoverOpened();
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void update(boolean initialize) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "update#");
    }
}
