package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;", "", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "contextMenuMap", "", "", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuItem;", "createContextMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "isActionMode", "", "setMenuItemClickListener", "canShowContextMenu", "executeMenuItem", "item", "Landroid/view/MenuItem;", "onPerformContextMenuAction", "id", "getPasteMenu", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuPaste;", "getMenu", "menuCode", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuCode;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmContextMenuManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmContextMenuManager");

    @NotNull
    private final Map<Integer, SmContextMenuItem> contextMenuMap;

    @NotNull
    private final SpenTextWritingView spenView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmContextMenuManager.TAG;
        }

        private Companion() {
        }
    }

    public SmContextMenuManager(@NotNull SpenTextWritingView spenView, @NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.spenView = spenView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.contextMenuMap = linkedHashMap;
        Integer numValueOf = Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_CUT.getId());
        Context context = spenView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        linkedHashMap.put(numValueOf, new SmContextMenuCut(context, smControlManager));
        Integer numValueOf2 = Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_COPY.getId());
        Context context2 = spenView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        linkedHashMap.put(numValueOf2, new SmContextMenuCopy(context2, smControlManager));
        Integer numValueOf3 = Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_PASTE.getId());
        Context context3 = spenView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        linkedHashMap.put(numValueOf3, new SmContextMenuPaste(context3, smControlManager));
        linkedHashMap.put(Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL.getId()), new SmContextMenuSelectAll(smControlManager));
        linkedHashMap.put(Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD.getId()), new SmContextMenuClipboard(spenView, smControlManager));
        Integer numValueOf4 = Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_SHARE.getId());
        Context context4 = spenView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        linkedHashMap.put(numValueOf4, new SmContextMenuShare(context4, smControlManager));
        linkedHashMap.put(Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_OBJECT_DELETE.getId()), new SmContextMenuDelete(smControlManager));
        if (Build.VERSION.SDK_INT >= 30) {
            Context context5 = spenView.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            linkedHashMap.put(16908353, new SmContextMenuSmartSelection(context5, smControlManager));
        }
        smControlManager.getClipboardController().setPasteAction(getPasteMenu());
    }

    private final void setMenuItemClickListener(Menu menu, boolean isActionMode) {
        if (isActionMode) {
            return;
        }
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            if (item.isEnabled()) {
                item.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC8924a(this, 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setMenuItemClickListener$lambda$0(SmContextMenuManager smContextMenuManager, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SmLogger.m8661d(TAG, "onMenuItemClick# " + item);
        smContextMenuManager.executeMenuItem(item);
        return true;
    }

    public final boolean canShowContextMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (menu.getItem(i).isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public final void createContextMenu(@NotNull Menu menu, boolean isActionMode) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        for (SmContextMenuItem smContextMenuItem : this.contextMenuMap.values()) {
            if (isActionMode || smContextMenuItem.canShow()) {
                smContextMenuItem.addMenu(menu);
            }
        }
        setMenuItemClickListener(menu, isActionMode);
    }

    public final void executeMenuItem(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SmLogger.m8666i(TAG, "executeMenuItem# " + item.getItemId());
        int itemId = item.getItemId();
        if (item.getItemId() == 100) {
            itemId = 16908353;
        }
        SmContextMenuItem smContextMenuItem = this.contextMenuMap.get(Integer.valueOf(itemId));
        if (smContextMenuItem != null) {
            if (Build.VERSION.SDK_INT >= 30 && (smContextMenuItem instanceof SmContextMenuSmartSelection)) {
                ((SmContextMenuSmartSelection) smContextMenuItem).setExecutedMenuItem(item);
            }
            smContextMenuItem.executeMenu();
            if (smContextMenuItem instanceof SmContextMenuSelectAll) {
                this.spenView.startActionMode();
            } else {
                this.spenView.stopActionMode();
            }
        }
    }

    @Nullable
    public final SmContextMenuItem getMenu(@NotNull SmContextMenuCode menuCode) {
        Intrinsics.checkNotNullParameter(menuCode, "menuCode");
        return this.contextMenuMap.get(Integer.valueOf(menuCode.getId()));
    }

    @NotNull
    public final SmContextMenuPaste getPasteMenu() {
        SmContextMenuItem smContextMenuItem = this.contextMenuMap.get(Integer.valueOf(SmContextMenuCode.CONTEXT_MENU_ID_PASTE.getId()));
        Intrinsics.checkNotNull(smContextMenuItem, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuPaste");
        return (SmContextMenuPaste) smContextMenuItem;
    }

    public final boolean onPerformContextMenuAction(int id) {
        int id2;
        switch (id) {
            case R.id.cut:
                id2 = SmContextMenuCode.CONTEXT_MENU_ID_CUT.getId();
                break;
            case R.id.copy:
                id2 = SmContextMenuCode.CONTEXT_MENU_ID_COPY.getId();
                break;
            case R.id.paste:
                id2 = SmContextMenuCode.CONTEXT_MENU_ID_PASTE.getId();
                break;
            default:
                id2 = SmContextMenuCode.CONTEXT_MENU_ID_NONE.getId();
                break;
        }
        AbstractC4539a.m3212v(id2, "onPerformContextMenuAction# ", TAG);
        SmContextMenuItem smContextMenuItem = this.contextMenuMap.get(Integer.valueOf(id2));
        if (smContextMenuItem == null || !smContextMenuItem.canShow()) {
            return false;
        }
        smContextMenuItem.executeMenu();
        return true;
    }
}
