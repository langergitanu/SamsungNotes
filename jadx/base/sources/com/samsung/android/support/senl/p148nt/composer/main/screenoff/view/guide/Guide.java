package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.guide;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuideContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/guide/Guide;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuideContract$IView;", "container", "Landroid/view/ViewGroup;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuidePresenter;", "<init>", "(Landroid/view/ViewGroup;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuidePresenter;)V", "mContainer", "Landroid/view/View;", "mGuideLayout", "mSupportAOPMode", "", "init", "", "visibility", "", "supportAOPMode", "onConfigurationChanged", "halfWheelRotation", "updateVisibility", "onDestroy", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Guide implements GuideContract.IView {

    @NotNull
    private static final String TAG = SOLogger.createTag("Guide");

    @NotNull
    private final View mContainer;

    @Nullable
    private View mGuideLayout;
    private boolean mSupportAOPMode;

    public Guide(@NotNull ViewGroup container, @NotNull GuidePresenter presenter) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mContainer = container;
        presenter.setView(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.guide.GuideContract.IView
    public void init(int visibility, boolean supportAOPMode) {
        Configuration configuration;
        TextView textView;
        TextView textView2;
        TextView textView3;
        this.mSupportAOPMode = supportAOPMode;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContainer.getContext());
        int i = C9086R.layout.screenoff_guide_layout;
        View view = this.mContainer;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View viewInflate = layoutInflaterFrom.inflate(i, (ViewGroup) view, false);
        this.mGuideLayout = viewInflate;
        Integer numValueOf = null;
        ViewGroup.LayoutParams layoutParams = viewInflate != null ? viewInflate.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        ((ViewGroup) this.mContainer).addView(this.mGuideLayout, layoutParams2);
        this.mGuideLayout = this.mContainer.findViewById(C9086R.id.guide_layout_supported_AOP);
        if (!this.mSupportAOPMode) {
            this.mGuideLayout = this.mContainer.findViewById(C9086R.id.guide_layout_not_supported_AOP);
        }
        if (LocaleUtils.isJapaneseLanguage()) {
            Typeface typefaceCreate = Typeface.create("sec-roboto-light", 0);
            if (this.mSupportAOPMode) {
                View view2 = this.mGuideLayout;
                if (view2 != null && (textView3 = (TextView) view2.findViewById(C9086R.id.guide_tips_supported_AOP_write_memo_on_screen)) != null) {
                    textView3.setTypeface(typefaceCreate);
                }
                View view3 = this.mGuideLayout;
                if (view3 != null && (textView2 = (TextView) view3.findViewById(C9086R.id.guide_tips_supported_AOP_xxx)) != null) {
                    textView2.setTypeface(typefaceCreate);
                }
            } else {
                View view4 = this.mGuideLayout;
                if (view4 != null && (textView = (TextView) view4.findViewById(C9086R.id.guide_tips_not_supported_AOP_write_memo_on_screen)) != null) {
                    textView.setTypeface(typefaceCreate);
                }
            }
        }
        View view5 = this.mGuideLayout;
        Resources resources = view5 != null ? view5.getResources() : null;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            numValueOf = Integer.valueOf(configuration.orientation);
        }
        if (!ConfigurationModel.INSTANCE.isSupportNavigationRotation() && numValueOf != null && numValueOf.intValue() == 2) {
            int dimension = (int) resources.getDimension(C9086R.dimen.screenoff_menu_bar_layout_width_height);
            layoutParams2.setMarginStart(dimension);
            layoutParams2.setMarginEnd(dimension);
        }
        View view6 = this.mGuideLayout;
        if (view6 != null) {
            view6.setVisibility(visibility);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.guide.GuideContract.IView
    public void onConfigurationChanged(int visibility, boolean halfWheelRotation) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onConfigurationChanged#");
        onDestroy();
        init(visibility, this.mSupportAOPMode);
        if (halfWheelRotation) {
            updateVisibility(visibility);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.guide.GuideContract.IView
    public void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        View view = this.mContainer;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view;
        View view2 = this.mGuideLayout;
        Object parent = view2 != null ? view2.getParent() : null;
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        viewGroup.removeView((View) parent);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.guide.GuideContract.IView
    public void updateVisibility(int visibility) {
        AbstractC8014b.m7206h("updateVisibility# ", visibility, SOLogger.INSTANCE, TAG);
        View view = this.mGuideLayout;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }
}
