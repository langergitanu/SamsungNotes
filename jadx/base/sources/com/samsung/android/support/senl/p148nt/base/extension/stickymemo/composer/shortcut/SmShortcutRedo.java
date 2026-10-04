package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutRedo;", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/AbsShortCutAction;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;)V", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "doAction", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmShortcutRedo extends AbsShortCutAction {

    @NotNull
    private final SmObjectManager objectManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmShortcutRedo(@NotNull SmObjectManager objectManager) {
        super(Shortcut.Redo);
        Intrinsics.checkNotNullParameter(objectManager, "objectManager");
        this.objectManager = objectManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        if (!this.objectManager.getNote().isRedoable()) {
            return false;
        }
        this.objectManager.getNote().redo();
        return true;
    }

    @NotNull
    public final SmObjectManager getObjectManager() {
        return this.objectManager;
    }
}
