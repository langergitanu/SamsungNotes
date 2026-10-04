package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenColorPaletteModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u001aH\u0016R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemManager;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager$IMenuItemManager;", "container", "Landroid/view/View;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;", "menuItemState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemState;", "settingViewState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewState;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemState;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewState;)V", "mContainer", "mPresenter", "mWritingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "mSettingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;", "mMenuItemState", "mBtnMap", "Ljava/util/LinkedHashMap;", "", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItem;", "Lkotlin/collections/LinkedHashMap;", "initSettingViewManager", "", "initItems", "onWindowFocusChanged", "hasFocus", "", "onDestroy", "onSelected", "key", "onPin", Constants.ARG_UPDATE, "type", "visibility", "onSave", "addPreTouchListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "removePreTouchListener", "onUpdatedPenColor", "color", "onDeleteAllObject", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuItemManager implements MenuItemContract, SettingViewManager.IMenuItemManager {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuItemManager");

    @Nullable
    private LinkedHashMap<Integer, MenuItem> mBtnMap;

    @NotNull
    private final View mContainer;

    @NotNull
    private final MenuItemState mMenuItemState;

    @NotNull
    private final MenuBarPresenter mPresenter;

    @NotNull
    private final SettingViewManager mSettingViewManager;

    @NotNull
    private final WritingToolManager mWritingToolManager;

    public MenuItemManager(@NotNull View container, @NotNull MenuBarPresenter presenter, @NotNull MenuItemState menuItemState, @NotNull SettingViewState settingViewState) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(menuItemState, "menuItemState");
        Intrinsics.checkNotNullParameter(settingViewState, "settingViewState");
        SOLogger.INSTANCE.SOLoggerD(TAG, "MenuItemManager");
        this.mContainer = container;
        this.mPresenter = presenter;
        this.mWritingToolManager = presenter.getWritingToolManager();
        this.mMenuItemState = menuItemState;
        this.mSettingViewManager = new SettingViewManager();
        initSettingViewManager(settingViewState);
        initItems();
    }

    private final void initItems() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initItems");
        LinkedHashMap<Integer, MenuItem> linkedHashMap = this.mBtnMap;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        LinkedHashMap<Integer, MenuItem> linkedHashMap2 = new LinkedHashMap<>();
        View viewFindViewById = this.mContainer.findViewById(C9086R.id.som_pen_color_0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        linkedHashMap2.put(2, new MenuItemPenColor(viewFindViewById, this, this.mSettingViewManager, this.mWritingToolManager));
        View viewFindViewById2 = this.mContainer.findViewById(C9086R.id.pen_size_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        linkedHashMap2.put(4, new MenuItemPenSize(viewFindViewById2, this, this.mSettingViewManager, this.mWritingToolManager));
        View viewFindViewById3 = this.mContainer.findViewById(C9086R.id.remover_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        linkedHashMap2.put(8, new MenuItemRemover(viewFindViewById3, this, this.mSettingViewManager, this.mWritingToolManager));
        View viewFindViewById4 = this.mContainer.findViewById(C9086R.id.pin_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        linkedHashMap2.put(16, new MenuItemPin(viewFindViewById4, this));
        View viewFindViewById5 = this.mContainer.findViewById(C9086R.id.save_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        linkedHashMap2.put(32, new MenuItemSave(viewFindViewById5, this));
        for (Map.Entry<Integer, MenuItem> entry : linkedHashMap2.entrySet()) {
            entry.getValue().setViewId$ntComposer_release(entry.getKey().intValue());
        }
        this.mBtnMap = linkedHashMap2;
        onUpdatedPenColor(PenInfoModel.INSTANCE.getColor());
        onSelected(this.mMenuItemState.getMenuItemKey());
    }

    private final void initSettingViewManager(SettingViewState settingViewState) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initSettingViewManager");
        this.mSettingViewManager.init(this.mContainer, this, this.mWritingToolManager, settingViewState);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingViewManager.IMenuItemManager
    public void addPreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "addPreTouchListener");
        this.mPresenter.addPreTouchListener(listener);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingViewManager.IMenuItemManager
    public void onDeleteAllObject() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDeleteAllObject");
        this.mPresenter.onDeleteAllObject();
        onSelected(4);
    }

    public final void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy");
        this.mSettingViewManager.onDestroy();
        LinkedHashMap<Integer, MenuItem> linkedHashMap = this.mBtnMap;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        this.mBtnMap = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItemContract
    public void onPin() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPin");
        this.mPresenter.onPin();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItemContract
    public void onSave() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onSave");
        this.mPresenter.onSave();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItemContract
    public void onSelected(int key) {
        MenuItem menuItem;
        MenuItem menuItem2;
        AbstractC8014b.m7206h("onSelected key ", key, SOLogger.INSTANCE, TAG);
        if (this.mMenuItemState.getMenuItemKey() != key) {
            LinkedHashMap<Integer, MenuItem> linkedHashMap = this.mBtnMap;
            if (linkedHashMap != null && (menuItem2 = linkedHashMap.get(Integer.valueOf(this.mMenuItemState.getMenuItemKey()))) != null) {
                menuItem2.setSelected$ntComposer_release(false);
            }
            this.mMenuItemState.setMenuItemKey(key);
        }
        LinkedHashMap<Integer, MenuItem> linkedHashMap2 = this.mBtnMap;
        if (linkedHashMap2 == null || (menuItem = linkedHashMap2.get(Integer.valueOf(key))) == null) {
            return;
        }
        menuItem.setSelected$ntComposer_release(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingViewManager.IMenuItemManager
    public void onUpdatedPenColor(int color) {
        int defaultColor;
        MenuItem menuItem;
        LinkedHashMap<Integer, MenuItem> linkedHashMap = this.mBtnMap;
        View view = (linkedHashMap == null || (menuItem = linkedHashMap.get(2)) == null) ? null : menuItem.mView;
        if (view != null) {
            View viewFindViewById = view.findViewById(C9086R.id.pen_color_item);
            Drawable background = viewFindViewById != null ? viewFindViewById.getBackground() : null;
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            ColorStateList color2 = gradientDrawable.getColor();
            int defaultColor2 = color2 != null ? color2.getDefaultColor() : -1;
            gradientDrawable.mutate();
            gradientDrawable.setColor(color);
            view.invalidate();
            view.postInvalidateOnAnimation();
            ColorStateList color3 = gradientDrawable.getColor();
            defaultColor = color3 != null ? color3.getDefaultColor() : -1;
            i = defaultColor2;
        } else {
            defaultColor = -1;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("onUpdatedPenColor before/after ", Integer.toHexString(i), "/", Integer.toHexString(defaultColor)));
        ViewCompat.INSTANCE.getInstance().setTooltipText(view, PenColorPaletteModel.INSTANCE.getSettingPenDescription(color));
    }

    public final void onWindowFocusChanged(boolean hasFocus) {
        AbstractC8014b.m7211m("onWindowFocusChanged ", hasFocus, SOLogger.INSTANCE, TAG);
        this.mSettingViewManager.onWindowFocusChanged(hasFocus);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingViewManager.IMenuItemManager
    public void removePreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "removePreTouchListener");
        this.mPresenter.removePreTouchListener(listener);
    }

    public final void update(int type, int visibility) {
        if (type == 16) {
            LinkedHashMap<Integer, MenuItem> linkedHashMap = this.mBtnMap;
            MenuItemPin menuItemPin = (MenuItemPin) (linkedHashMap != null ? linkedHashMap.get(16) : null);
            if (menuItemPin != null) {
                menuItemPin.setVisibility(visibility);
            }
        }
    }
}
