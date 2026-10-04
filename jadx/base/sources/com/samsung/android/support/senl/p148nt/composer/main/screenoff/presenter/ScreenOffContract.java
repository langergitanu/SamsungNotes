package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.CompContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffContract;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/CompContract;", "IScreenOffView", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ScreenOffContract extends CompContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffContract$IScreenOffView;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/CompContract$IView;", "attachMenuBar", "", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;", "attachGuide", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuidePresenter;", "attachScroll", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;", "attachCovered", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;", "requestRelayout", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IScreenOffView extends CompContract.IView {
        void attachCovered(@NotNull CoveredPresenter presenter);

        void attachGuide(@NotNull GuidePresenter presenter);

        void attachMenuBar(@NotNull MenuBarPresenter presenter);

        void attachScroll(@NotNull ScrollPresenter presenter);

        void requestRelayout();
    }
}
