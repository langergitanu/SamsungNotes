package com.samsung.android.support.senl.p148nt.base.widget.setting.view;

import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "", "updateWidgetPreviewAlpha", "", "alpha", "", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateWidgetBackgroundColor", "setPresenter", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface BaseWidgetSettingContract {
    void setPresenter(@Nullable BaseWidgetSettingPresenter presenter);

    void updateWidgetBackgroundColor();

    void updateWidgetPreviewAlpha(int alpha);

    void updateWidgetPreviewTheme();

    void updateWidgetSettingDarkMode();
}
