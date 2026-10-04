package com.google.android.material.oneui.dividerbuttonlayout;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006."}, m13886d2 = {"Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonPresenter;", "Landroidx/appcompat/view/menu/MenuPresenter;", "()V", "menuBuilder", "Landroidx/appcompat/view/menu/MenuBuilder;", "menuView", "Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;", "getMenuView", "()Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;", "setMenuView", "(Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;)V", "updateSuspended", "", "getUpdateSuspended", "()Z", "setUpdateSuspended", "(Z)V", "collapseItemActionView", ExternalSettingsProvider.EXTRA_MENU, "item", "Landroidx/appcompat/view/menu/MenuItemImpl;", "expandItemActionView", "flagActionItems", "getId", "", "Landroidx/appcompat/view/menu/MenuView;", "root", "Landroid/view/ViewGroup;", "initForMenu", "", "context", "Landroid/content/Context;", "onCloseMenu", "allMenusAreClosing", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "onSubMenuSelected", "subMenu", "Landroidx/appcompat/view/menu/SubMenuBuilder;", "setCallback", "cb", "Landroidx/appcompat/view/menu/MenuPresenter$Callback;", "updateMenuView", "cleared", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DividerButtonPresenter implements MenuPresenter {
    private MenuBuilder menuBuilder;
    public DividerButtonLayout menuView;
    private boolean updateSuspended;

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@NotNull MenuBuilder menu, @NotNull MenuItemImpl item) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(item, "item");
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@NotNull MenuBuilder menu, @NotNull MenuItemImpl item) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(item, "item");
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @NotNull
    public final DividerButtonLayout getMenuView() {
        DividerButtonLayout dividerButtonLayout = this.menuView;
        if (dividerButtonLayout != null) {
            return dividerButtonLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("menuView");
        return null;
    }

    public final boolean getUpdateSuspended() {
        return this.updateSuspended;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NotNull Context context, @NotNull MenuBuilder menu) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.menuBuilder = menu;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@NotNull MenuBuilder menu, boolean allMenusAreClosing) {
        Intrinsics.checkNotNullParameter(menu, "menu");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NotNull Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@NotNull SubMenuBuilder subMenu) {
        Intrinsics.checkNotNullParameter(subMenu, "subMenu");
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@NotNull MenuPresenter.Callback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
    }

    public final void setMenuView(@NotNull DividerButtonLayout dividerButtonLayout) {
        Intrinsics.checkNotNullParameter(dividerButtonLayout, "<set-?>");
        this.menuView = dividerButtonLayout;
    }

    public final void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean cleared) {
        if (this.updateSuspended) {
            return;
        }
        if (cleared) {
            getMenuView().buildMenuView();
        } else {
            getMenuView().updateMenuView();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup root) {
        return getMenuView();
    }
}
