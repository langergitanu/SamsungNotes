package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.p152hw;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/hw/SmShortcutTextMode;", "Lcom/samsung/android/support/senl/nt/base/composer/shortcut/AbsShortCutAction;", "toolShareControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "sipControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;)V", "doAction", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmShortcutTextMode extends AbsShortCutAction {

    @NotNull
    private final SmModeControl modeControl;

    @NotNull
    private final SipController sipControl;

    @NotNull
    private final ToolShareControl toolShareControl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmShortcutTextMode(@NotNull ToolShareControl toolShareControl, @NotNull SmModeControl modeControl, @NotNull SipController sipControl) {
        super(Shortcut.TextMode);
        Intrinsics.checkNotNullParameter(toolShareControl, "toolShareControl");
        Intrinsics.checkNotNullParameter(modeControl, "modeControl");
        Intrinsics.checkNotNullParameter(sipControl, "sipControl");
        this.toolShareControl = toolShareControl;
        this.modeControl = modeControl;
        this.sipControl = sipControl;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        if (this.modeControl.isWritingMode()) {
            this.toolShareControl.requestTextMode();
        } else if (this.modeControl.isTextMode() && !this.sipControl.isInputMethodShown()) {
            this.sipControl.show(true);
        }
        return super.doAction();
    }
}
