package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCopy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/shortcut/ShortCutAdbCopy;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/shortcut/ShortCutCopy;", "contextMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuCopy;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuCopy;)V", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShortCutAdbCopy extends ShortCutCopy {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortCutAdbCopy(@NotNull ContextMenuCopy contextMenu) {
        super(contextMenu);
        Intrinsics.checkNotNullParameter(contextMenu, "contextMenu");
        setShortcut(Shortcut.AdbCopy);
    }
}
