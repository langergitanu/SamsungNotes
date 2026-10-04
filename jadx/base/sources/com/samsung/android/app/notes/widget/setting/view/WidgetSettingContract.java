package com.samsung.android.app.notes.widget.setting.view;

import android.graphics.Bitmap;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/WidgetSettingContract;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "updateEmptyPreview", "", "updateNoteTitleView", "title", "", "updatePreviewTitleView", "updateBgSettingMenu", "updatePreview", "whiteTheme", "Landroid/graphics/Bitmap;", "blackTheme", "updateTitleVoice", "voice", "", "showLoadingView", "hideLoadingView", "hideEmptyView", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface WidgetSettingContract extends BaseWidgetSettingContract {
    void hideEmptyView();

    void hideLoadingView();

    void showLoadingView();

    void updateBgSettingMenu();

    void updateEmptyPreview();

    void updateNoteTitleView(@Nullable String title);

    void updatePreview(@Nullable Bitmap whiteTheme, @Nullable Bitmap blackTheme);

    void updatePreviewTitleView(@Nullable String title);

    void updateTitleVoice(boolean voice);
}
