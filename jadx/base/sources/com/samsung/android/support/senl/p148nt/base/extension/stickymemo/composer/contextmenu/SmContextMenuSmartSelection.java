package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import android.app.RemoteAction;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.RequiresApi;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuSmartSelection;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuItem;", "context", "Landroid/content/Context;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "getSmControlManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "executedMenuItem", "Landroid/view/MenuItem;", "getExecutedMenuItem", "()Landroid/view/MenuItem;", "setExecutedMenuItem", "(Landroid/view/MenuItem;)V", "smartSelection", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuSmartSelection$SmartSelection;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "SmartSelection", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmContextMenuSmartSelection extends SmContextMenuItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmContextMenuSmartSelection");

    @Nullable
    private MenuItem executedMenuItem;

    @NotNull
    private final SmControlManager smControlManager;

    @NotNull
    private final SmartSelection smartSelection;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuSmartSelection$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmContextMenuSmartSelection.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(30)
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuSmartSelection$SmartSelection;", "Lcom/samsung/android/support/senl/nt/base/composer/contextmenu/TextClassification;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;)V", "getContext", "()Ljava/lang/ref/WeakReference;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "getTag", "", "addItem", "Landroid/view/MenuItem;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "action", "Landroid/app/RemoteAction;", "index", "", "runAfterStartActivity", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SmartSelection extends TextClassification {

        @NotNull
        private final WeakReference<Context> context;

        @NotNull
        private final SmObjectManager objectManager;

        /* JADX WARN: Illegal instructions before constructor call */
        public SmartSelection(@NotNull WeakReference<Context> context, @NotNull SmObjectManager objectManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(objectManager, "objectManager");
            Context context2 = context.get();
            Intrinsics.checkNotNull(context2);
            super(context2);
            this.context = context;
            this.objectManager = objectManager;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification
        @NotNull
        public MenuItem addItem(@NotNull Menu menu, @NotNull RemoteAction action, int index) {
            Context context;
            Intrinsics.checkNotNullParameter(menu, "menu");
            Intrinsics.checkNotNullParameter(action, "action");
            if (index != 0) {
                MenuItem contentDescription = menu.add(0, 100, index + 100, action.getTitle()).setContentDescription(action.getContentDescription());
                Intrinsics.checkNotNullExpressionValue(contentDescription, "setContentDescription(...)");
                contentDescription.setShowAsAction(0);
                return contentDescription;
            }
            MenuItem menuItemAdd = menu.add(0, 16908353, SmContextMenuCode.CONTEXT_MENU_ID_FIRST.getId(), action.getTitle());
            Intrinsics.checkNotNullExpressionValue(menuItemAdd, "add(...)");
            if (action.shouldShowIcon() && (context = this.context.get()) != null) {
                menuItemAdd.setIcon(action.getIcon().loadDrawable(context));
            }
            return menuItemAdd;
        }

        @NotNull
        public final WeakReference<Context> getContext() {
            return this.context;
        }

        @NotNull
        public final SmObjectManager getObjectManager() {
            return this.objectManager;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification
        @NotNull
        public String getTag() {
            return SmContextMenuSmartSelection.INSTANCE.getTAG();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification
        public void runAfterStartActivity() {
            this.objectManager.clearSelection();
            this.objectManager.clearSelectObject();
        }
    }

    public SmContextMenuSmartSelection(@NotNull Context context, @NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.smControlManager = smControlManager;
        this.smartSelection = new SmartSelection(new WeakReference(context), smControlManager.getObjectManager());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        String selectedText;
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (this.smControlManager.getObjectManager().isFocusedTextBox() && this.smControlManager.getTextManager().isSelected() && (selectedText = this.smControlManager.getTextManager().getSelectedText()) != null) {
            this.smartSelection.addMenu(menu, selectedText);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public boolean canShow() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void executeMenu() {
        MenuItem menuItem = this.executedMenuItem;
        if (menuItem != null) {
            this.smartSelection.startActivity(menuItem);
        }
    }

    @Nullable
    public final MenuItem getExecutedMenuItem() {
        return this.executedMenuItem;
    }

    @NotNull
    public final SmControlManager getSmControlManager() {
        return this.smControlManager;
    }

    public final void setExecutedMenuItem(@Nullable MenuItem menuItem) {
        this.executedMenuItem = menuItem;
    }
}
