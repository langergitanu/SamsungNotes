package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.StringRes;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuBehaviorAppbar extends OptionMenuBehavior {
    private static final String BADGE_TYPE_DOT = "0";

    private MenuItem convertTarget(OptionMenuParam optionMenuParam) {
        return optionMenuParam.getChildResId() == null ? (MenuItem) optionMenuParam.getTarget() : (MenuItem) findMenuItem(optionMenuParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void addMenu(OptionMenuParam optionMenuParam, int i, int i2, int i4, int i5, int i6) {
        ((Menu) optionMenuParam.getTarget()).add(i, i2, i4, i5).setShowAsAction(i6);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public Object findMenuItem(OptionMenuParam optionMenuParam) {
        return ((Menu) optionMenuParam.getTarget()).findItem(optionMenuParam.getChildResId().intValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public CharSequence getTitle(OptionMenuParam optionMenuParam) {
        MenuItem menuItemConvertTarget = convertTarget(optionMenuParam);
        return menuItemConvertTarget != null ? menuItemConvertTarget.getTitle() : "";
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void hideMenu(OptionMenuParam optionMenuParam) {
        MenuItem menuItem = (MenuItem) findMenuItem(optionMenuParam);
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void removeMenu(OptionMenuParam optionMenuParam) {
        ((Menu) optionMenuParam.getTarget()).removeItem(optionMenuParam.getChildResId().intValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    @SuppressLint({"RestrictedApi"})
    public void setBadgeText(OptionMenuParam optionMenuParam) {
        MenuItem menuItemConvertTarget = convertTarget(optionMenuParam);
        if (menuItemConvertTarget instanceof MenuItemImpl) {
            ((MenuItemImpl) menuItemConvertTarget).setBadgeText("0");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setContentDescription(OptionMenuParam optionMenuParam, String str) {
        MenuItem menuItem = (MenuItem) findMenuItem(optionMenuParam);
        if (menuItem != null) {
            menuItem.setContentDescription(str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setEnabledMenu(OptionMenuParam optionMenuParam, boolean z) {
        MenuItem menuItem = (MenuItem) findMenuItem(optionMenuParam);
        if (menuItem != null) {
            menuItem.setEnabled(z);
            if (menuItem.getIcon() != null) {
                menuItem.getIcon().setAlpha((int) ((z ? 1.0f : 0.4f) * 255.0f));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setIcon(OptionMenuParam optionMenuParam, Drawable drawable) {
        MenuItem menuItem = (MenuItem) findMenuItem(optionMenuParam);
        if (menuItem != null) {
            menuItem.setIcon(drawable);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setTitle(OptionMenuParam optionMenuParam, @StringRes int i) {
        MenuItem menuItemConvertTarget = convertTarget(optionMenuParam);
        if (menuItemConvertTarget != null) {
            menuItemConvertTarget.setTitle(i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void showMenu(OptionMenuParam optionMenuParam) {
        MenuItem menuItem = (MenuItem) findMenuItem(optionMenuParam);
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
    }
}
