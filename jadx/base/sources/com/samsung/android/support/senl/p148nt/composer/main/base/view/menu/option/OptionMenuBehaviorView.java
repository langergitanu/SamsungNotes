package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuBehaviorView extends OptionMenuBehavior {
    private View convertTarget(OptionMenuParam optionMenuParam) {
        return optionMenuParam.getChildResId() == null ? (View) optionMenuParam.getTarget() : (View) findMenuItem(optionMenuParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void addMenu(OptionMenuParam optionMenuParam, int i, int i2, int i4, int i5, int i6) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public Object findMenuItem(OptionMenuParam optionMenuParam) {
        return ((View) optionMenuParam.getTarget()).findViewById(optionMenuParam.getChildResId().intValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public CharSequence getTitle(OptionMenuParam optionMenuParam) {
        View viewConvertTarget = convertTarget(optionMenuParam);
        return viewConvertTarget != null ? viewConvertTarget.getContentDescription() : "";
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void hideMenu(OptionMenuParam optionMenuParam) {
        View view = (View) findMenuItem(optionMenuParam);
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void removeMenu(OptionMenuParam optionMenuParam) {
        View view = (View) findMenuItem(optionMenuParam);
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setBadgeText(OptionMenuParam optionMenuParam) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setContentDescription(OptionMenuParam optionMenuParam, String str) {
        View view = (View) findMenuItem(optionMenuParam);
        if (view != null) {
            view.setContentDescription(str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setEnabledMenu(OptionMenuParam optionMenuParam, boolean z) {
        View view = (View) findMenuItem(optionMenuParam);
        if (view != null) {
            view.setEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setIcon(OptionMenuParam optionMenuParam, Drawable drawable) {
        View view = (View) findMenuItem(optionMenuParam);
        if (view != null) {
            ((ImageView) view).setImageDrawable(drawable);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void setTitle(OptionMenuParam optionMenuParam, int i) {
        View viewConvertTarget = convertTarget(optionMenuParam);
        if (viewConvertTarget != null) {
            viewConvertTarget.setContentDescription(viewConvertTarget.getResources().getString(i));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuBehavior
    public void showMenu(OptionMenuParam optionMenuParam) {
        View view = (View) findMenuItem(optionMenuParam);
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
