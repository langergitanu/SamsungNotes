package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.DragNDropControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenTextManagerActionListenerImpl;", "Lcom/samsung/android/sdk/pen/widget/listener/SpenTextManagerActionListener;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "dragNDropControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl;)V", "getTextManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "floatingControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenTextManagerActionListenerImpl$IFloatingControl;", "getFloatingControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenTextManagerActionListenerImpl$IFloatingControl;", "setFloatingControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenTextManagerActionListenerImpl$IFloatingControl;)V", "onItemClicked", "", "spenObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "type", "", "paragraphIndex", "onSelectionAreaLongPressed", "onBeforeTextChangedByKeyBoard", "release", "IFloatingControl", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenTextManagerActionListenerImpl extends SpenTextManagerActionListener {

    @NotNull
    private final DragNDropControl dragNDropControl;

    @Nullable
    private IFloatingControl floatingControl;

    @NotNull
    private final SmTextManager textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenTextManagerActionListenerImpl$IFloatingControl;", "", "moveIntoBounds", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IFloatingControl {
        void moveIntoBounds();
    }

    public SpenTextManagerActionListenerImpl(@NotNull SmTextManager textManager, @NotNull DragNDropControl dragNDropControl) {
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        Intrinsics.checkNotNullParameter(dragNDropControl, "dragNDropControl");
        this.textManager = textManager;
        this.dragNDropControl = dragNDropControl;
    }

    @Nullable
    public final IFloatingControl getFloatingControl() {
        return this.floatingControl;
    }

    @NotNull
    public final SmTextManager getTextManager() {
        return this.textManager;
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onBeforeTextChangedByKeyBoard() {
        IFloatingControl iFloatingControl = this.floatingControl;
        if (iFloatingControl != null) {
            iFloatingControl.moveIntoBounds();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onItemClicked(@Nullable SpenObjectShape spenObject, int type, int paragraphIndex) {
        if (type == 2) {
            SmTextManager smTextManager = this.textManager;
            Intrinsics.checkNotNull(spenObject);
            smTextManager.setTodoState(spenObject, paragraphIndex);
            this.textManager.getDoc().commitHistory();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onSelectionAreaLongPressed() {
        this.dragNDropControl.startDrag();
    }

    public final void release() {
        this.floatingControl = null;
    }

    public final void setFloatingControl(@Nullable IFloatingControl iFloatingControl) {
        this.floatingControl = iFloatingControl;
    }
}
