package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuDelete;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuItem;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "getSmControlManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmContextMenuDelete extends SmContextMenuItem {

    @NotNull
    private final SmControlManager smControlManager;

    public SmContextMenuDelete(@NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.smControlManager = smControlManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        SmContextMenuCode smContextMenuCode = SmContextMenuCode.CONTEXT_MENU_ID_OBJECT_DELETE;
        menu.add(0, smContextMenuCode.getId(), smContextMenuCode.getId(), C8875R.string.action_delete).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public boolean canShow() {
        return this.smControlManager.getModeControl().isEditMode() && !this.smControlManager.getTextManager().isSelected() && this.smControlManager.getObjectManager().isSelectedObject();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void executeMenu() {
        ArrayList<SpenObjectBase> selectedObjectList = this.smControlManager.getObjectManager().getSelectedObjectList();
        if (selectedObjectList.isEmpty()) {
            return;
        }
        this.smControlManager.getObjectManager().getNote().getPage(0).removeObjectList(selectedObjectList);
        this.smControlManager.getObjectManager().clearSelectObject();
    }

    @NotNull
    public final SmControlManager getSmControlManager() {
        return this.smControlManager;
    }
}
