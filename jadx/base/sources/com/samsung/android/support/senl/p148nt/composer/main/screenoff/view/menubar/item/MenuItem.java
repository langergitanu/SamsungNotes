package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewManager;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 '2\u00020\u0001:\u0001'B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u001fH\u0014J\b\u0010&\u001a\u00020\u001fH$R\u0010\u0010\f\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010$\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0010¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItem;", "", "view", "Landroid/view/View;", "menuItemContract", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;", "settingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;", "writingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;)V", "mView", "viewId", "", "getViewId$ntComposer_release", "()I", "setViewId$ntComposer_release", "(I)V", "mMenuItemContract", "mSettingViewManager", "getMSettingViewManager", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;", "setMSettingViewManager", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;)V", "mWritingToolManager", "getMWritingToolManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "setMWritingToolManager", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;)V", "setSelected", "", "selected", "", "setSelected$ntComposer_release", "setToolType", "toolType", "getToolType", "onClick", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class MenuItem {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuItem");

    @JvmField
    @NotNull
    protected final MenuItemContract mMenuItemContract;

    @Nullable
    private SettingViewManager mSettingViewManager;

    @JvmField
    @NotNull
    public final View mView;

    @Nullable
    private WritingToolManager mWritingToolManager;
    private int viewId;

    public MenuItem(@NotNull View view, @NotNull MenuItemContract menuItemContract, @Nullable SettingViewManager settingViewManager, @Nullable WritingToolManager writingToolManager) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(menuItemContract, "menuItemContract");
        SOLogger.INSTANCE.SOLoggerD(TAG, "MenuItem");
        this.mView = view;
        this.mMenuItemContract = menuItemContract;
        this.mSettingViewManager = settingViewManager;
        this.mWritingToolManager = writingToolManager;
        view.setOnClickListener(new ViewOnClickListenerC8556a(this, 24));
    }

    @Nullable
    public final SettingViewManager getMSettingViewManager() {
        return this.mSettingViewManager;
    }

    @Nullable
    public final WritingToolManager getMWritingToolManager() {
        return this.mWritingToolManager;
    }

    public final int getToolType() {
        WritingToolManager writingToolManager = this.mWritingToolManager;
        if (writingToolManager != null) {
            return writingToolManager.getToolTypeAction(2);
        }
        return 0;
    }

    /* JADX INFO: renamed from: getViewId$ntComposer_release, reason: from getter */
    public final int getViewId() {
        return this.viewId;
    }

    public abstract void onClick();

    public final void setMSettingViewManager(@Nullable SettingViewManager settingViewManager) {
        this.mSettingViewManager = settingViewManager;
    }

    public final void setMWritingToolManager(@Nullable WritingToolManager writingToolManager) {
        this.mWritingToolManager = writingToolManager;
    }

    public final void setSelected$ntComposer_release(boolean selected) {
        SettingViewManager settingViewManager;
        if (selected || (settingViewManager = this.mSettingViewManager) == null) {
            setToolType();
        } else if (settingViewManager != null) {
            settingViewManager.hide(true);
        }
        this.mView.setSelected(selected);
    }

    public void setToolType() {
    }

    public final void setViewId$ntComposer_release(int i) {
        this.viewId = i;
    }
}
