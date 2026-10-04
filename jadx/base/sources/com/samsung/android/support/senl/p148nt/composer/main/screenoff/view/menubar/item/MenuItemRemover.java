package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemRemover;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItem;", "view", "Landroid/view/View;", "menuItemContract", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;", "settingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;", "writingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;)V", "onClick", "", "setToolType", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuItemRemover extends MenuItem {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuItemRemover");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemRemover(@NotNull View view, @NotNull MenuItemContract menuItemContract, @Nullable SettingViewManager settingViewManager, @Nullable WritingToolManager writingToolManager) {
        super(view, menuItemContract, settingViewManager, writingToolManager);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(menuItemContract, "menuItemContract");
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mView);
        if (SettingsCompat.INSTANCE.getInstance().isHighTextContrastEnabled(this.mView.getContext())) {
            this.mView.setBackgroundResource(C9086R.drawable.screenoff_oval_button_ripple_effect_high_contrast);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem
    public void onClick() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onClick");
        SAManager.INSTANCE.getINSTANCE().onRemoverClicked();
        if (!this.mView.isSelected()) {
            this.mMenuItemContract.onSelected(getViewId());
            return;
        }
        SettingViewManager mSettingViewManager = getMSettingViewManager();
        if (mSettingViewManager == null) {
            return;
        }
        if (mSettingViewManager.isShownSettingViews(4)) {
            mSettingViewManager.hide(true);
        } else {
            mSettingViewManager.show(4);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem
    public void setToolType() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setToolType");
        WritingToolManager mWritingToolManager = getMWritingToolManager();
        if (mWritingToolManager == null) {
            return;
        }
        mWritingToolManager.setToolTypeAction(2, 8);
        mWritingToolManager.setToolTypeAction(1, 1);
        mWritingToolManager.setToolTypeAction(0, 1);
        mWritingToolManager.setToolTypeAction(6, 8);
    }
}
