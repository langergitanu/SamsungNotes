package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.Menu;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuStickyMemo;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuItem;", "stickyMemoManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;", "composerPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "objectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "kotlin.jvm.PlatformType", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/TextManager;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContextMenuStickyMemo extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuStickyMemo");
    private final ComposerModel composerModel;

    @NotNull
    private final ComposerViewPresenter composerPresenter;
    private final ObjectManager objectManager;

    @NotNull
    private final StickyMemoManager stickyMemoManager;
    private final TextManager textManager;

    public ContextMenuStickyMemo(@NotNull StickyMemoManager stickyMemoManager, @NotNull ComposerViewPresenter composerPresenter) {
        Intrinsics.checkNotNullParameter(stickyMemoManager, "stickyMemoManager");
        Intrinsics.checkNotNullParameter(composerPresenter, "composerPresenter");
        this.stickyMemoManager = stickyMemoManager;
        this.composerPresenter = composerPresenter;
        this.objectManager = composerPresenter.getObjectManager();
        this.textManager = composerPresenter.getTextManager();
        this.composerModel = composerPresenter.getComposerModel();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_STICKY_MEMO;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.sticky_memo).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.stickyMemoManager.isEnabled() || !this.composerModel.getModeManager().isEditModeWithoutReadOnly()) {
            return false;
        }
        if (this.objectManager.getSelectedObjectManager().isSelectedObject()) {
            return this.objectManager.isSelectedBodyText() && !this.textManager.isSelected();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        PointF pastePosition;
        boolean z;
        if (this.objectManager.isSelectedBodyText()) {
            TextManager textManager = this.textManager;
            ISpenNoteTextManager spenNoteTextManager = textManager.getSpenNoteTextManager();
            SpenObjectShape textBox = textManager.getTextBox();
            Intrinsics.checkNotNullExpressionValue(textBox, "getTextBox(...)");
            RectF cursorRect = spenNoteTextManager.getCursorRect(textBox, textManager.getCursor(textManager.getTextBox())[0]);
            pastePosition = cursorRect != null ? new PointF(cursorRect.right, cursorRect.bottom) : null;
            z = false;
        } else {
            pastePosition = this.objectManager.getPastePosition();
            z = true;
        }
        String str = TAG;
        Logger.m10999d(str, "executeMenu# " + pastePosition + " " + z);
        this.composerPresenter.getSoftInputManager().blockToHide(str, true, str);
        this.stickyMemoManager.addStickyMemo(pastePosition);
        this.composerPresenter.getSoftInputManager().blockToHide(str, false, str);
    }
}
