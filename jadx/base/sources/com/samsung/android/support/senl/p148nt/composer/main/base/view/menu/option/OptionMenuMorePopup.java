package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.ViewOnClickListenerC7066a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.C8971a;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.util.CaptionBarHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuMorePopup {
    private static final String TAG = Logger.createTag("OptionMenuMorePopup");
    private final Activity mActivity;
    private final int mMenuTypeCard;
    private final int mMenuTypeIcon;
    private final int mMenuTypeText;
    private final OptionMenuContract.IOptionMenuMorePopup mOptionMenu;
    private PopupWindow mPopupWindow;
    private final OptionMenuPresenter mPresenter;
    private ListPopupWindow mSubMenuPopup;
    private final List<MenuItem> mTextMenuItems = new ArrayList(1);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CardMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        List<MenuItem> itemArray;

        public /* synthetic */ CardMenuAdapter(OptionMenuMorePopup optionMenuMorePopup, int i) {
            this();
        }

        private View.OnClickListener getOnClickListener(boolean z) {
            if (z) {
                return new ViewOnClickListenerC10395a(0, this);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getOnClickListener$0(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            Logger.m11003i(OptionMenuMorePopup.TAG, "showListDialog$onClick, which: " + ((Object) this.itemArray.get(iIntValue).getTitle()));
            if (OptionMenuMorePopup.this.mOptionMenu.onOptionsItemSelected(new OptionMenuParam(this.itemArray.get(iIntValue)), view.getId())) {
                OptionMenuMorePopup.this.hidePopup();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MenuItem> list = this.itemArray;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void init(List<MenuItem> list) {
            for (MenuItem menuItem : list) {
                if (menuItem.isEnabled() || menuItem.getItemId() == C9086R.id.action_search) {
                    if (menuItem.isVisible() && menuItem.getOrder() >= OptionMenuMorePopup.this.mMenuTypeCard && menuItem.getOrder() < OptionMenuMorePopup.this.mMenuTypeText) {
                        this.itemArray.add(menuItem);
                    }
                }
            }
            Logger.m11003i(OptionMenuMorePopup.TAG, "CardMenuAdapter - init#" + list.size() + ", cardItem:" + this.itemArray.size());
        }

        private CardMenuAdapter() {
            this.itemArray = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            MenuItem menuItem = this.itemArray.get(i);
            if (menuItem == null) {
                return;
            }
            OptionMenuMorePopup.this.bindItemView((LinearLayout) viewHolder.itemView, menuItem, false);
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.itemView.setEnabled(menuItem.isEnabled());
            viewHolder.itemView.setOnClickListener(getOnClickListener(menuItem.isEnabled()));
            if (i == 0) {
                viewHolder.itemView.setBackgroundResource(C9086R.drawable.comp_ripple_effect_top);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_more_popup_text_list_item, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TextMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        List<MenuItem> itemArray;

        public /* synthetic */ TextMenuAdapter(OptionMenuMorePopup optionMenuMorePopup, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(View view) {
            MenuItem menuItem = this.itemArray.get(((Integer) view.getTag()).intValue());
            Logger.m11003i(OptionMenuMorePopup.TAG, "showListDialog$onClick, which: " + ((Object) menuItem.getTitle()));
            if (menuItem.hasSubMenu()) {
                OptionMenuMorePopup.this.showSubPopup(menuItem, view);
            } else if (OptionMenuMorePopup.this.mOptionMenu.onOptionsItemSelected(new OptionMenuParam(menuItem), view.getId())) {
                OptionMenuMorePopup.this.hidePopup();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MenuItem> list = this.itemArray;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void init(List<MenuItem> list, List<MenuItem> list2) {
            for (MenuItem menuItem : list) {
                if (menuItem.isEnabled() && menuItem.isVisible()) {
                    if (menuItem.hasSubMenu() && OptionMenuMorePopup.this.getSubMenuItems(menuItem).isEmpty()) {
                        Logger.m11003i(OptionMenuMorePopup.TAG, "TextMenuAdapter - init# subMenu is empty." + ((Object) menuItem.getTitle()));
                    } else if (menuItem.getOrder() >= OptionMenuMorePopup.this.mMenuTypeText && menuItem.getOrder() < OptionMenuMorePopup.this.mMenuTypeIcon) {
                        this.itemArray.add(menuItem);
                    }
                }
            }
            this.itemArray.addAll(list2);
            Logger.m11003i(OptionMenuMorePopup.TAG, "TextMenuAdapter - init#" + list.size() + ", TextItem:" + this.itemArray.size());
        }

        private TextMenuAdapter() {
            this.itemArray = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            OptionMenuMorePopup.this.bindItemView((LinearLayout) viewHolder.itemView, this.itemArray.get(i), !DeviceUtils.isShopDemoDevice(OptionMenuMorePopup.this.mActivity));
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC10395a(1, this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_more_popup_text_list_item, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public OptionMenuMorePopup(Activity activity, OptionMenuPresenter optionMenuPresenter, OptionMenuContract.IOptionMenuMorePopup iOptionMenuMorePopup) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter;
        this.mOptionMenu = iOptionMenuMorePopup;
        this.mMenuTypeCard = activity.getResources().getInteger(C9086R.integer.menu_type_card);
        this.mMenuTypeText = activity.getResources().getInteger(C9086R.integer.menu_type_text);
        this.mMenuTypeIcon = activity.getResources().getInteger(C9086R.integer.menu_type_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindItemView(LinearLayout linearLayout, MenuItem menuItem, boolean z) {
        linearLayout.setId(menuItem.getItemId());
        TextView textView = (TextView) linearLayout.findViewById(C9086R.id.item_text);
        textView.setText(menuItem.getTitle().toString());
        textView.setEnabled(menuItem.isEnabled());
        updateBadgeView(linearLayout, menuItem);
        if (!z) {
            ((ImageView) linearLayout.findViewById(C9086R.id.item_button)).setVisibility(8);
            return;
        }
        Drawable drawableUpdateButtonIcon = updateButtonIcon(menuItem.getIcon(), linearLayout, menuItem);
        ImageView imageView = (ImageView) linearLayout.findViewById(C9086R.id.item_button);
        if (drawableUpdateButtonIcon != null) {
            imageView.setImageDrawable(drawableUpdateButtonIcon);
            imageView.setVisibility(0);
        } else if (menuItem.hasSubMenu()) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void checkToChangeMenuCategory(List<MenuItem> list) {
        this.mTextMenuItems.clear();
        int size = list.size();
        if (size > 2 || size <= 0) {
            return;
        }
        for (MenuItem menuItem : list) {
            if (!DeviceUtils.isShopDemoDevice(this.mActivity)) {
                menuItem.setIcon((Drawable) null);
            }
            this.mTextMenuItems.add(menuItem);
        }
        list.clear();
    }

    @SuppressLint({"RestrictedApi"})
    private String getBadgeText(MenuItem menuItem) {
        return menuItem instanceof MenuItemImpl ? ((MenuItemImpl) menuItem).getBadgeText() : "";
    }

    private View getIconMenuView(ConstraintLayout constraintLayout, MenuItem menuItem) {
        View viewInflate = LayoutInflater.from(constraintLayout.getContext()).inflate(C9086R.layout.comp_more_popup_icon_list_item, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(C9086R.id.item_button);
        if (menuItem.getIcon() != null) {
            imageView.setImageDrawable(menuItem.getIcon());
            imageView.setVisibility(0);
            viewInflate.setContentDescription(menuItem.getTitle());
            ViewCompat.getInstance().setTooltipText(viewInflate, menuItem.getTitle());
            String string = constraintLayout.getResources().getString(C9086R.string.composer_remove_from_favorite);
            if (menuItem.getTitle() != null && menuItem.getTitle().equals(string)) {
                ImageViewCompat.setImageTintList(imageView, null);
            }
        } else {
            imageView.setVisibility(8);
        }
        View viewFindViewById = viewInflate.findViewById(C9086R.id.item_container);
        viewFindViewById.setId(menuItem.getItemId());
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC7066a(this, 1, menuItem, constraintLayout));
        return viewFindViewById;
    }

    private int getOffsetY(View view) {
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        if (companion.getInstance().isDexMode(this.mActivity)) {
            return companion.getInstance().isDexNewDexMode(this.mActivity) ? CaptionBarHelper.getCaptionBarHeight(this.mActivity) : view.getHeight();
        }
        return 0;
    }

    private AdapterView.OnItemClickListener getSubMenuItemClickListener(List<MenuItem> list) {
        return new C8971a(this, list, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<MenuItem> getSubMenuItems(MenuItem menuItem) {
        ArrayList arrayList = new ArrayList();
        SubMenu subMenu = menuItem.getSubMenu();
        if (subMenu == null) {
            return arrayList;
        }
        int size = subMenu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = subMenu.getItem(i);
            if (item.isEnabled() && item.isVisible()) {
                arrayList.add(item);
            }
        }
        Logger.m11003i(TAG, "getSubMenuItems#" + ((Object) menuItem.getTitle()) + ", SubMenuItem:" + arrayList.size());
        return arrayList;
    }

    private void hideCardMenu(View view) {
        ((RecyclerView) view.findViewById(C9086R.id.card_menu_recycler_view)).setVisibility(8);
        view.findViewById(C9086R.id.card_menu_divider).setVisibility(8);
    }

    private void hidePopupWindow() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    private void hideTextMenu(View view) {
        ((RecyclerView) view.findViewById(C9086R.id.text_menu_recycler_view)).setVisibility(8);
        view.findViewById(C9086R.id.card_menu_divider).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAdapter(List<MenuItem> list, View view) {
        initCardMenuAdapter(list, view);
        initIconMenuAdapter(list, view);
        initTextMenuAdapter(list, view);
    }

    private void initCardMenuAdapter(List<MenuItem> list, View view) {
        CardMenuAdapter cardMenuAdapter = new CardMenuAdapter(this, 0);
        cardMenuAdapter.init(list);
        if (cardMenuAdapter.getItemCount() <= 0) {
            hideCardMenu(view);
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C9086R.id.card_menu_recycler_view);
        recyclerView.setAdapter(cardMenuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity));
    }

    private void initIconMenuAdapter(List<MenuItem> list, View view) {
        int size;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C9086R.id.icon_menu_constraint_layout);
        ArrayList arrayList = new ArrayList();
        for (MenuItem menuItem : list) {
            if (menuItem.isEnabled() && menuItem.isVisible() && menuItem.getOrder() >= this.mMenuTypeIcon) {
                arrayList.add(menuItem);
            }
        }
        checkToChangeMenuCategory(arrayList);
        if (arrayList.isEmpty()) {
            view.findViewById(C9086R.id.icon_menu_constraint_layout_divider).setVisibility(8);
            constraintLayout.setVisibility(8);
            size = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                View iconMenuView = getIconMenuView(constraintLayout, (MenuItem) it.next());
                constraintLayout.addView(iconMenuView);
                arrayList2.add(iconMenuView);
            }
            updateIconConstraintLayout(constraintLayout, arrayList2);
            updateIconMenuChain(arrayList2);
            size = arrayList2.size();
        }
        Logger.m11003i(TAG, "initIconMenuAdapter#" + list.size() + ", viewsCount: " + size);
    }

    private ArrayAdapter<?> initSubMenuAdapter(final List<MenuItem> list) {
        return new ArrayAdapter<MenuItem>(this.mActivity, C9086R.layout.comp_listpopupwindow_item, list) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuMorePopup.2
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
                RelativeLayout relativeLayout = view instanceof RelativeLayout ? (RelativeLayout) view : (RelativeLayout) LayoutInflater.from(OptionMenuMorePopup.this.mActivity).inflate(C9086R.layout.comp_listpopupwindow_item, (ViewGroup) null);
                ((TextView) relativeLayout.findViewById(C9086R.id.item_text)).setText(((MenuItem) list.get(i)).getTitle());
                return relativeLayout;
            }
        };
    }

    private void initTextMenuAdapter(List<MenuItem> list, View view) {
        TextMenuAdapter textMenuAdapter = new TextMenuAdapter(this, 0);
        textMenuAdapter.init(list, this.mTextMenuItems);
        if (textMenuAdapter.getItemCount() <= 0) {
            hideTextMenu(view);
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C9086R.id.text_menu_recycler_view);
        recyclerView.setAdapter(textMenuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIconMenuView$0(MenuItem menuItem, ConstraintLayout constraintLayout, View view) {
        Logger.m11003i(TAG, "showListDialog$onClick, which: " + view.getId());
        if (this.mOptionMenu.onOptionsItemSelected(new OptionMenuParam(menuItem), view.getId())) {
            constraintLayout.removeAllViews();
            hidePopup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSubMenuItemClickListener$1(List list, AdapterView adapterView, View view, int i, long j) {
        MenuItem menuItem = (MenuItem) list.get(i);
        Logger.m11003i(TAG, "showSubPopup$onItemClick, which: " + ((Object) menuItem.getTitle()));
        if (this.mOptionMenu.onOptionsItemSelected(new OptionMenuParam(menuItem), menuItem.getItemId())) {
            hidePopup();
        }
    }

    private void updateBadgeView(LinearLayout linearLayout, MenuItem menuItem) {
        View viewFindViewById = linearLayout.findViewById(C9086R.id.item_badge);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(TextUtils.isEmpty(getBadgeText(menuItem)) ? 8 : 0);
    }

    private Drawable updateButtonIcon(Drawable drawable, LinearLayout linearLayout, MenuItem menuItem) {
        return (drawable == null && menuItem.getItemId() == C9086R.id.action_save) ? linearLayout.getContext().getDrawable(C9086R.drawable.comp_appbar_ic_save) : drawable;
    }

    private void updateIconConstraintLayout(ConstraintLayout constraintLayout, List<View> list) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) constraintLayout.getLayoutParams();
        int dimensionPixelSize = list.size() < 4 ? this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.more_menu_icon_item_side_margin_wide) : this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.more_menu_icon_item_side_margin);
        layoutParams.setMarginStart(dimensionPixelSize);
        layoutParams.setMarginEnd(dimensionPixelSize);
        constraintLayout.setLayoutParams(layoutParams);
    }

    private void updateIconMenuChain(List<View> list) {
        for (View view : list) {
            int iIndexOf = list.indexOf(view);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -1);
            layoutParams.horizontalChainStyle = 1;
            if (iIndexOf == 0) {
                layoutParams.startToStart = 0;
            } else {
                layoutParams.startToEnd = list.get(iIndexOf - 1).getId();
            }
            if (iIndexOf >= list.size() - 1) {
                layoutParams.endToEnd = 0;
            } else {
                layoutParams.endToStart = list.get(iIndexOf + 1).getId();
            }
            layoutParams.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutParams);
        }
    }

    public void hidePopup() {
        Logger.m11003i(TAG, "hidePopup#");
        ListPopupWindow listPopupWindow = this.mSubMenuPopup;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.mSubMenuPopup.dismiss();
        }
        hidePopupWindow();
    }

    public void showPopup(final List<MenuItem> list) {
        String str = TAG;
        Logger.m11003i(str, "showPopup#");
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11000e(str, "showPopup, isDestroyed");
            return;
        }
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            Logger.m11000e(str, "showPopup, isShowing()");
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
            return;
        }
        final View viewInflate = View.inflate(this.mActivity, C9086R.layout.comp_more_popup_container_layout, null);
        initAdapter(list, viewInflate);
        BackgroundColorUtil.setBlurInfoPopup(this.mActivity, viewInflate);
        PopupWindow popupWindow2 = new PopupWindow(-2, -2);
        this.mPopupWindow = popupWindow2;
        popupWindow2.setContentView(viewInflate);
        OptionMenuPopupWindowHelper.setDefaultState(this.mPopupWindow, this.mActivity);
        View anchorViewInToolbar = OptionMenuPopupWindowHelper.getAnchorViewInToolbar(this.mActivity, C9086R.id.action_more);
        if (Build.VERSION.SDK_INT <= 34 || LocaleUtils.isRTLMode()) {
            this.mPopupWindow.showAtLocation(anchorViewInToolbar, OptionMenuPopupWindowHelper.getPopupWindowGravity(), 0, getOffsetY(anchorViewInToolbar));
        } else {
            try {
                this.mPopupWindow.showAsDropDown(anchorViewInToolbar);
            } catch (RuntimeException e) {
                Logger.m11000e(TAG, "showPopup# " + e.getMessage());
                return;
            }
        }
        viewInflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuMorePopup.1
            private void updatePopupWidth() {
                int width = viewInflate.findViewById(C9086R.id.nested_scroll_view).getWidth();
                int width2 = viewInflate.findViewById(C9086R.id.horizontal_scroll_view).getWidth();
                if (width2 >= width) {
                    return;
                }
                View viewFindViewById = viewInflate.findViewById(C9086R.id.container_view);
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                layoutParams.width = width2;
                viewFindViewById.setLayoutParams(layoutParams);
                ((ViewGroup) viewInflate.findViewById(C9086R.id.container_frameView)).removeAllViewsInLayout();
                View viewInflate2 = View.inflate(OptionMenuMorePopup.this.mActivity, C9086R.layout.comp_more_popup_layout, null);
                OptionMenuMorePopup.this.initAdapter(list, viewInflate2);
                ((ViewGroup) viewInflate).addView(viewInflate2, 0);
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                viewInflate.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updatePopupWidth();
                viewInflate.requestFocus();
            }
        });
    }

    public void showSubPopup(MenuItem menuItem, View view) {
        String str = TAG;
        Logger.m11003i(str, "showSubPopup#");
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11000e(str, "showSubPopup, isDestroyed");
            return;
        }
        if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote() && (menuItem.getItemId() == C9086R.id.action_add_to || menuItem.getItemId() == C9086R.id.action_share_note)) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return;
        }
        ListPopupWindow listPopupWindow = this.mSubMenuPopup;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            Logger.m11000e(str, "showSubPopup, isShowing()");
            this.mSubMenuPopup.dismiss();
            this.mSubMenuPopup = null;
        } else {
            if (view == null) {
                Logger.m11000e(str, "showSubPopup# anchorView is null");
                return;
            }
            List<MenuItem> subMenuItems = getSubMenuItems(menuItem);
            ListPopupWindow listPopupWindow2 = new ListPopupWindow(this.mActivity);
            this.mSubMenuPopup = listPopupWindow2;
            listPopupWindow2.setAnchorView(view);
            OptionMenuPopupWindowHelper.setDefaultState(this.mSubMenuPopup, initSubMenuAdapter(subMenuItems), this.mActivity);
            this.mSubMenuPopup.setOnItemClickListener(getSubMenuItemClickListener(subMenuItems));
            this.mSubMenuPopup.show();
        }
    }
}
