package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.composer;

import android.app.Activity;
import android.graphics.RectF;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/composer/ScreenOffComposerView;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/composer/ComposerView;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/config/Config;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/config/Config;)V", "setVisibility", "", "visibility", "", "initAttr", "initScrollManager", "getPageIndex", "touchedContentRect", "Landroid/graphics/RectF;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffComposerView extends ComposerView {
    private static final String TAG = Logger.createTag("ScreenOffComposerView");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOffComposerView(@Nullable Activity activity, @NotNull Config config) {
        super(activity, config);
        Intrinsics.checkNotNullParameter(config, "config");
        setVisibility(4);
    }

    private final void setVisibility(int visibility) {
        this.mView.setVisibility(visibility);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public int getPageIndex(@Nullable RectF touchedContentRect) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView
    public void initAttr() {
        Logger.m10999d(TAG, "initAttr#");
        this.mView.setInitBackgroundColor(Integer.valueOf(this.mActivity.getResources().getColor(C9086R.color.screenoff_main_background, null)));
        this.mFlashViewManager.getCoverView().setBackgroundColor(this.mActivity.getResources().getColor(C9086R.color.screenoff_main_background, null));
        setLongPressEnabled(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void initScrollManager() {
        super.initScrollManager();
        this.mScrollZoomManager.setScrollingEnabled(false);
        this.mScrollZoomManager.disableZoomLock();
    }
}
