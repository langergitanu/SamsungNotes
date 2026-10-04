package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.SmComposerView;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0005+,-./B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010%\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020'J\u0016\u0010(\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup;", "", "smComposerView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView;)V", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "textMenuList", "", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$MoreTextMenu;", "smDeleteConfirmDialog", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmDeleteConfirmDialog;", "setMenuList", "", "menuList", Constants.IntentExtraValue.SHOW, "anchorView", "Landroid/view/View;", "init", "context", "Landroid/content/Context;", "initMenuList", "layoutView", "initBackgroundColorMenu", "setTooltip", "view", "tooltipText", "", "hideCheckIcon", "bgColorGroupView", "Landroid/view/ViewGroup;", "initPopupWindow", "hide", "isShowing", "", "showDeleteConfirmDialog", "deleteClickListener", "Landroid/content/DialogInterface$OnClickListener;", "Companion", "MoreTextMenu", "MenuAdapter", "TextMenuItemHolder", "CustomAccessibilityDelegate", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmMorePopup {

    @NotNull
    private static final String TAG = SmLogger.createTag("SmMorePopup");

    @Nullable
    private PopupWindow popupWindow;

    @NotNull
    private final SmComposerView smComposerView;

    @NotNull
    private final SmDeleteConfirmDialog smDeleteConfirmDialog;

    @Nullable
    private List<? extends MoreTextMenu> textMenuList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$CustomAccessibilityDelegate;", "Landroid/view/View$AccessibilityDelegate;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "selectedString", "", "notSelectedString", "canControlTooltip", "", "onInitializeAccessibilityEvent", "", "host", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CustomAccessibilityDelegate extends View.AccessibilityDelegate {
        private final boolean canControlTooltip;

        @Nullable
        private String notSelectedString;

        @Nullable
        private String selectedString;

        public CustomAccessibilityDelegate(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.canControlTooltip = Build.VERSION.SDK_INT > 28;
            this.selectedString = context.getResources().getString(C8875R.string.selectall_voice_ass_selected);
            this.notSelectedString = context.getResources().getString(C8875R.string.selectall_voice_ass_not_selected);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(@NotNull View host, @NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(event, "event");
            super.onInitializeAccessibilityEvent(host, event);
            event.setClassName("android.widget.Button");
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setClassName("android.widget.Button");
            if (!host.isSelected()) {
                info.setContentDescription(this.notSelectedString + SQLKeyword.COMMA + ((Object) host.getContentDescription()));
            }
            if (this.canControlTooltip) {
                info.setTooltipText(null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$TextMenuItemHolder;", "itemList", "", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$MoreTextMenu;", "clickListener", "Landroid/view/View$OnClickListener;", "<init>", "(Ljava/util/List;Landroid/view/View$OnClickListener;)V", "viewOnClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MenuAdapter extends RecyclerView.Adapter<TextMenuItemHolder> {

        @NotNull
        private final View.OnClickListener clickListener;

        @NotNull
        private final List<MoreTextMenu> itemList;

        @NotNull
        private final View.OnClickListener viewOnClickListener;

        /* JADX WARN: Multi-variable type inference failed */
        public MenuAdapter(@NotNull List<? extends MoreTextMenu> itemList, @NotNull View.OnClickListener clickListener) {
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.itemList = itemList;
            this.clickListener = clickListener;
            this.viewOnClickListener = new ViewOnClickListenerC8938d(this, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void viewOnClickListener$lambda$1(MenuAdapter menuAdapter, View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Object tag = v.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            menuAdapter.itemList.get(((Integer) tag).intValue()).executeMenu();
            menuAdapter.clickListener.onClick(v);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull TextMenuItemHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            holder.getItemNameView().setText(this.itemList.get(position).getTitle());
            itemView.setTag(Integer.valueOf(position));
            if (position == this.itemList.size() - 1) {
                itemView.setBackgroundResource(C8875R.drawable.sticky_memo_ripple_effect_bottom);
            } else {
                itemView.setBackgroundResource(C8875R.drawable.sticky_memo_ripple_effect);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public TextMenuItemHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C8875R.layout.sticky_memo_more_popup_text_item_layout, parent, false);
            viewInflate.setOnClickListener(this.viewOnClickListener);
            Intrinsics.checkNotNull(viewInflate);
            return new TextMenuItemHolder(viewInflate);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$MoreTextMenu;", "", "<init>", "()V", DynamicActionBarProvider.METHOD_GET_DATA, "", "executeMenu", "", "canShow", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class MoreTextMenu {
        public final boolean canShow() {
            return true;
        }

        public abstract void executeMenu();

        @StringRes
        public abstract int getTitle();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$TextMenuItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemNameView", "Landroid/widget/TextView;", "getItemNameView", "()Landroid/widget/TextView;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TextMenuItemHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final TextView itemNameView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextMenuItemHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C8875R.id.item_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.itemNameView = (TextView) viewFindViewById;
        }

        @NotNull
        public final TextView getItemNameView() {
            return this.itemNameView;
        }
    }

    public SmMorePopup(@NotNull SmComposerView smComposerView) {
        Intrinsics.checkNotNullParameter(smComposerView, "smComposerView");
        this.smComposerView = smComposerView;
        this.smDeleteConfirmDialog = new SmDeleteConfirmDialog();
    }

    private final void hideCheckIcon(ViewGroup bgColorGroupView) {
        int childCount = bgColorGroupView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bgColorGroupView.getChildAt(i);
            childAt.findViewById(C8875R.id.check_icon).setVisibility(8);
            childAt.setSelected(false);
        }
    }

    private final void initBackgroundColorMenu(View layoutView) {
        final ViewGroup viewGroup = (ViewGroup) layoutView.findViewById(C8875R.id.background_color_button_group);
        Resources resources = layoutView.getResources();
        int[] intArray = resources.getIntArray(C8875R.array.sticky_memo_background_color);
        Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
        final List<Integer> list = ArraysKt.toList(intArray);
        String[] stringArray = resources.getStringArray(C8875R.array.sticky_memo_background_color_string);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        List list2 = ArraysKt.toList(stringArray);
        int iIndexOf = list.indexOf(Integer.valueOf(this.smComposerView.getBackgroundColor()));
        int childCount = viewGroup.getChildCount();
        for (final int i = 0; i < childCount; i++) {
            final View childAt = viewGroup.getChildAt(i);
            childAt.findViewById(C8875R.id.color_icon).setBackgroundTintList(ColorStateList.valueOf(list.get(i).intValue()));
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmMorePopup.initBackgroundColorMenu$lambda$4(this.f6471a, list, i, viewGroup, childAt, view);
                }
            });
            if (iIndexOf == i) {
                childAt.findViewById(C8875R.id.check_icon).setVisibility(0);
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
            Intrinsics.checkNotNull(childAt);
            Object obj = list2.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            setTooltip(childAt, (CharSequence) obj);
            childAt.setContentDescription((CharSequence) list2.get(i));
            Context context = layoutView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            childAt.setAccessibilityDelegate(new CustomAccessibilityDelegate(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundColorMenu$lambda$4(SmMorePopup smMorePopup, List list, int i, ViewGroup viewGroup, View view, View view2) {
        if (smMorePopup.smComposerView.getBackgroundColor() == ((Number) list.get(i)).intValue()) {
            return;
        }
        SmLogger.m8661d(TAG, "initBackgroundColorMenu# " + ((Object) view2.getContentDescription()));
        Intrinsics.checkNotNull(viewGroup);
        smMorePopup.hideCheckIcon(viewGroup);
        view.findViewById(C8875R.id.check_icon).setVisibility(0);
        view.setSelected(true);
        smMorePopup.smComposerView.setBackgroundColor(((Number) list.get(i)).intValue());
        NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE_MORE_OPTION, "406", StickyMemoSAConstants.INSTANCE.getDETAIL_BG_COLOR_ARRAY()[i]);
    }

    private final void initMenuList(View layoutView) {
        RecyclerView recyclerView = (RecyclerView) layoutView.findViewById(C8875R.id.menu_recycler_view);
        List<? extends MoreTextMenu> list = this.textMenuList;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (MoreTextMenu moreTextMenu : list) {
                if (moreTextMenu.canShow()) {
                    arrayList.add(moreTextMenu);
                }
            }
            recyclerView.setAdapter(new MenuAdapter(arrayList, new ViewOnClickListenerC8938d(this, 1)));
            recyclerView.setLayoutManager(new LinearLayoutManager(layoutView.getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMenuList$lambda$3$lambda$2(SmMorePopup smMorePopup, View view) {
        PopupWindow popupWindow = smMorePopup.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private final void initPopupWindow(PopupWindow popupWindow, Context context) {
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(true);
        popupWindow.setFocusable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setOverlapAnchor(true);
        Drawable drawable = context.getDrawable(C8875R.drawable.sticky_memo_popup_menu_background);
        if (drawable != null) {
            drawable.setTint(context.getColor(C8875R.color.sticky_memo_more_popup_bg_color));
        }
        popupWindow.setBackgroundDrawable(context.getDrawable(C8875R.drawable.sticky_memo_popup_menu_background));
        popupWindow.setElevation(12.0f);
        popupWindow.setAnimationStyle(C8875R.style.MorePopupEnterExitAnimation);
    }

    private final void setTooltip(View view, CharSequence tooltipText) {
        if (Build.VERSION.SDK_INT > 26) {
            ViewCompat.INSTANCE.getInstance().setTooltipText(view, tooltipText);
        }
    }

    @Nullable
    public final PopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    public final void hide() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.smDeleteConfirmDialog.dismiss();
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = View.inflate(context, C8875R.layout.sticky_memo_more_popup_layout, null);
        Intrinsics.checkNotNull(viewInflate);
        initBackgroundColorMenu(viewInflate);
        initMenuList(viewInflate);
        PopupWindow popupWindow = new PopupWindow(-2, -2);
        popupWindow.setContentView(viewInflate);
        initPopupWindow(popupWindow, context);
        this.popupWindow = popupWindow;
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.popupWindow;
        return (popupWindow != null && popupWindow.isShowing()) || this.smDeleteConfirmDialog.isShowing();
    }

    public final void setMenuList(@NotNull List<? extends MoreTextMenu> menuList) {
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        this.textMenuList = menuList;
    }

    public final void setPopupWindow(@Nullable PopupWindow popupWindow) {
        this.popupWindow = popupWindow;
    }

    public final void show(@NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            Logger.m8698e(TAG, "show# isShowing");
            PopupWindow popupWindow2 = this.popupWindow;
            Intrinsics.checkNotNull(popupWindow2);
            popupWindow2.dismiss();
            return;
        }
        Context context = anchorView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        init(context);
        int dimensionPixelSize = anchorView.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_more_popup_menu_min_width);
        int dimensionPixelSize2 = anchorView.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_more_button_padding_end) / 2;
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.showAsDropDown(anchorView, (anchorView.getWidth() - dimensionPixelSize2) - dimensionPixelSize, 0);
        }
    }

    public final void showDeleteConfirmDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener deleteClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deleteClickListener, "deleteClickListener");
        this.smDeleteConfirmDialog.showDialog(context, deleteClickListener);
    }
}
