package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemPenColor;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItem;", "view", "Landroid/view/View;", "menuItemContract", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;", "settingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;", "writingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;)V", "onClick", "", "setToolType", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuItemPenColor extends MenuItem {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuItemPenColor");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemPenColor(@NotNull View view, @NotNull MenuItemContract menuItemContract, @NotNull SettingViewManager settingViewManager, @NotNull WritingToolManager writingToolManager) {
        super(view, menuItemContract, settingViewManager, writingToolManager);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(menuItemContract, "menuItemContract");
        Intrinsics.checkNotNullParameter(settingViewManager, "settingViewManager");
        Intrinsics.checkNotNullParameter(writingToolManager, "writingToolManager");
        this.mView.findViewById(C9086R.id.pen_color_item).setEnabled(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem
    public void onClick() {
        try {
            int toolType = getToolType();
            Drawable background = this.mView.findViewById(C9086R.id.pen_color_item).getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ColorStateList color = ((GradientDrawable) background).getColor();
            Integer numValueOf = color != null ? Integer.valueOf(color.getDefaultColor()) : null;
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            sOLogger.SOLoggerD(str, "onClick# toolType/color " + toolType + "/" + Integer.toHexString(numValueOf != null ? numValueOf.intValue() : 0));
        } catch (Error e) {
            AbstractC0000a.m24u("onClick, exception : ", e.getMessage(), SOLogger.INSTANCE, TAG);
        } catch (Exception e2) {
            AbstractC0000a.m24u("onClick, exception : ", e2.getMessage(), SOLogger.INSTANCE, TAG);
        }
        if (getToolType() == 8) {
            setToolType();
            this.mMenuItemContract.onSelected(4);
            return;
        }
        SettingViewManager mSettingViewManager = getMSettingViewManager();
        if (mSettingViewManager == null) {
            return;
        }
        if (mSettingViewManager.isShownSettingViews(1)) {
            mSettingViewManager.hide(true);
        } else if (!mSettingViewManager.isShownSettingViews(2)) {
            mSettingViewManager.show(1);
        } else {
            mSettingViewManager.hide(true);
            mSettingViewManager.show(1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem
    public void setToolType() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setToolType#");
        WritingToolManager mWritingToolManager = getMWritingToolManager();
        if (mWritingToolManager == null) {
            return;
        }
        mWritingToolManager.setToolTypeAction(2, 2);
        mWritingToolManager.setToolTypeAction(1, 1);
        mWritingToolManager.setToolTypeAction(0, 1);
        mWritingToolManager.setToolTypeAction(6, 8);
    }
}
