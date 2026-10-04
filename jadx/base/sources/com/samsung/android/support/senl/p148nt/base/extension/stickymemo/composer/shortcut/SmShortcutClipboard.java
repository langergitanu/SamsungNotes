package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuClipboard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutClipboard;", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/AbsShortCutAction;", "clipboardAction", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuClipboard;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuClipboard;)V", "doAction", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmShortcutClipboard extends AbsShortCutAction {

    @NotNull
    private final SmContextMenuClipboard clipboardAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmShortcutClipboard(@NotNull SmContextMenuClipboard clipboardAction) {
        super(Shortcut.Clipboard);
        Intrinsics.checkNotNullParameter(clipboardAction, "clipboardAction");
        this.clipboardAction = clipboardAction;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        if (!this.clipboardAction.canShow()) {
            return false;
        }
        this.clipboardAction.executeMenu();
        return true;
    }
}
