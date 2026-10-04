package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.scroll;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.ForceHideNavigationFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.scroll.Scroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/scroll/Scroll;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollContract$IView;", "container", "Landroid/view/ViewGroup;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;", "<init>", "(Landroid/view/ViewGroup;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;)V", "mContainer", "Landroid/view/View;", "mScrollLayout", "mScrollUp", "mScrollDown", "mPresenter", "init", "", "visibility", "", "halfWheelRotation", "", "onConfigurationChanged", "updateVisibility", "scrollUpVisibility", "scrollDownVisibility", "invalidate", "onDestroy", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Scroll implements ScrollContract.IView {

    @NotNull
    private static final String TAG = SOLogger.createTag("Scroll");

    @NotNull
    private final View mContainer;

    @NotNull
    private final ScrollPresenter mPresenter;

    @Nullable
    private View mScrollDown;

    @Nullable
    private View mScrollLayout;

    @Nullable
    private View mScrollUp;

    public Scroll(@NotNull ViewGroup container, @NotNull ScrollPresenter presenter) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mContainer = container;
        this.mPresenter = presenter;
        presenter.setView(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(Scroll scroll, View view) {
        SAManager.INSTANCE.getINSTANCE().onScrollUpClicked();
        scroll.mPresenter.onScrollUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(Scroll scroll, View view) {
        SAManager.INSTANCE.getINSTANCE().onScrollDownClicked();
        scroll.mPresenter.onScrollDown();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.scroll.ScrollContract.IView
    public void init(int visibility, boolean halfWheelRotation) {
        int rotation;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "init#");
        Resources resources = this.mContainer.getContext().getResources();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContainer.getContext());
        int i = C9086R.layout.screenoff_scroll_layout;
        View view = this.mContainer;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View viewInflate = layoutInflaterFrom.inflate(i, (ViewGroup) view, false);
        this.mScrollLayout = viewInflate;
        ViewGroup.LayoutParams layoutParams = viewInflate != null ? viewInflate.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        View view2 = this.mScrollLayout;
        this.mScrollUp = view2 != null ? view2.findViewById(C9086R.id.scroll_up_button) : null;
        View view3 = this.mScrollLayout;
        this.mScrollDown = view3 != null ? view3.findViewById(C9086R.id.scroll_down_button) : null;
        int dimension = (int) resources.getDimension(C9086R.dimen.screenoff_menu_bar_layout_width_height);
        int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this.mContainer.getContext());
        int dimension2 = (int) resources.getDimension(C9086R.dimen.screenoff_scroll_button_margin_top);
        int dimension3 = (int) resources.getDimension(C9086R.dimen.screenoff_scroll_button_margin_bottom);
        int dimension4 = (int) resources.getDimension(C9086R.dimen.screenoff_scroll_button_margin_end);
        int i2 = ForceHideNavigationFeature.INSTANCE.needToHideNavigationForcibly() ? 0 : navigationBarHeightIgnoreHasSoftKey;
        AbstractC8014b.m7206h("init# navigationHeight ", i2, sOLogger, str);
        int i4 = this.mContainer.getContext().getResources().getConfiguration().orientation;
        AbstractC8014b.m7206h("init# orientation ", i4, sOLogger, str);
        if (i4 == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            layoutParams2.topMargin = dimension2 + dimension;
            layoutParams2.bottomMargin = dimension3 + i2;
            layoutParams2.setMarginEnd(dimension4);
            layoutParams2.gravity = 8388613;
        } else {
            if (halfWheelRotation) {
                rotation = this.mPresenter.getRotation();
            } else {
                Object systemService = this.mContainer.getContext().getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            sOLogger.SOLoggerD(str, "init halfWheelRotation/rotation/isRTLMode # " + halfWheelRotation + "/" + rotation + "/" + zIsRTLMode);
            layoutParams2.topMargin = dimension2;
            layoutParams2.bottomMargin = dimension3;
            layoutParams2.gravity = 8388613;
            if (rotation != 3) {
                layoutParams2.setMarginEnd(dimension4 + i2);
            } else if (zIsRTLMode) {
                layoutParams2.setMarginEnd(dimension4 + dimension + i2);
            } else {
                layoutParams2.setMarginEnd(dimension4);
            }
        }
        View view4 = this.mScrollLayout;
        if (view4 != null) {
            view4.setVisibility(visibility);
        }
        ((ViewGroup) this.mContainer).addView(this.mScrollLayout, layoutParams2);
        View view5 = this.mScrollUp;
        if (view5 != null) {
            final int i5 = 0;
            view5.setOnClickListener(new View.OnClickListener(this) { // from class: T3.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Scroll f776b;

                {
                    this.f776b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    switch (i5) {
                        case 0:
                            Scroll.init$lambda$0(this.f776b, view6);
                            break;
                        default:
                            Scroll.init$lambda$1(this.f776b, view6);
                            break;
                    }
                }
            });
        }
        View view6 = this.mScrollDown;
        if (view6 != null) {
            final int i6 = 1;
            view6.setOnClickListener(new View.OnClickListener(this) { // from class: T3.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Scroll f776b;

                {
                    this.f776b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view62) {
                    switch (i6) {
                        case 0:
                            Scroll.init$lambda$0(this.f776b, view62);
                            break;
                        default:
                            Scroll.init$lambda$1(this.f776b, view62);
                            break;
                    }
                }
            });
        }
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setTooltipText(this.mScrollUp);
        companion.getInstance().setTooltipText(this.mScrollDown);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.scroll.ScrollContract.IView
    public void invalidate() {
        View view = this.mScrollLayout;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.scroll.ScrollContract.IView
    public void onConfigurationChanged(int visibility, boolean halfWheelRotation) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onConfigurationChanged#");
        onDestroy();
        init(visibility, halfWheelRotation);
        if (halfWheelRotation) {
            updateVisibility(this.mPresenter.getScrollUpVisibility(), 0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.scroll.ScrollContract.IView
    public void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        View view = this.mContainer;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view).removeView(this.mScrollLayout);
        View view2 = this.mScrollUp;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.mScrollUp = null;
        View view3 = this.mScrollDown;
        if (view3 != null) {
            view3.setOnClickListener(null);
        }
        this.mScrollDown = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.scroll.ScrollContract.IView
    public void updateVisibility(int scrollUpVisibility, int scrollDownVisibility) {
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC1038a.m1214o(scrollUpVisibility, scrollDownVisibility, "updateVisibility# scrollUpVisibility/scrollDownVisibility ", "/"));
        View view = this.mScrollUp;
        if (view != null) {
            view.setVisibility(scrollUpVisibility);
        }
        View view2 = this.mScrollDown;
        if (view2 != null) {
            view2.setVisibility(scrollDownVisibility);
        }
    }
}
