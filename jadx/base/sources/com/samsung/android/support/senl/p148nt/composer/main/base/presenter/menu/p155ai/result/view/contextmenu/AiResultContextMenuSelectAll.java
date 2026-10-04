package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuSelectAll;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuItem;", "view", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "getView", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultContextMenuSelectAll extends AiResultContextMenuItem {

    @NotNull
    private final SimpleEditView view;

    public AiResultContextMenuSelectAll(@NotNull SimpleEditView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        int id = AiResultContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL.getId();
        menu.add(0, id, id, C8875R.string.ctx_menu_select_all).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public boolean canShow() {
        String text;
        int length;
        SpenObjectTextBox textBox = this.view.getTextBox();
        if (textBox == null || (text = textBox.getText()) == null || (length = text.length()) == 0) {
            return false;
        }
        int[] cursor = this.view.getCursor();
        return (cursor[0] == 0 && cursor[1] == length) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void executeMenu() {
        String text;
        SpenObjectTextBox textBox = this.view.getTextBox();
        if (textBox == null || (text = textBox.getText()) == null) {
            return;
        }
        textBox.setSelection(0, text.length());
    }

    @NotNull
    public final SimpleEditView getView() {
        return this.view;
    }
}
