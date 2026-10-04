package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.SmShortcutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnKeyListenerImpl;", "Landroid/view/View$OnKeyListener;", "shortcutManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;)V", "onKey", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "keyCode", "", "event", "Landroid/view/KeyEvent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OnKeyListenerImpl implements View.OnKeyListener {

    @NotNull
    private final SmShortcutManager shortcutManager;

    public OnKeyListenerImpl(@NotNull SmShortcutManager shortcutManager) {
        Intrinsics.checkNotNullParameter(shortcutManager, "shortcutManager");
        this.shortcutManager = shortcutManager;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(@NotNull View v, int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        return this.shortcutManager.onKey(v, keyCode, event);
    }
}
