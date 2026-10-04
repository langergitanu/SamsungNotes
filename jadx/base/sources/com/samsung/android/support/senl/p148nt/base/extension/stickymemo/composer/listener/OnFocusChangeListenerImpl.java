package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001J\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnFocusChangeListenerImpl;", "Landroid/view/View$OnFocusChangeListener;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "listenerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFocusChange", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "hasFocus", "", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "release", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OnFocusChangeListenerImpl implements View.OnFocusChangeListener {

    @NotNull
    private static final String TAG = SmLogger.createTag("OnFocusChangeListenerImpl");

    @NotNull
    private final ArrayList<View.OnFocusChangeListener> listenerList;

    @NotNull
    private final SmControlManager smControlManager;

    public OnFocusChangeListenerImpl(@NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.smControlManager = smControlManager;
        this.listenerList = new ArrayList<>();
    }

    public final void addListener(@NotNull View.OnFocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listenerList.contains(listener)) {
            return;
        }
        this.listenerList.add(listener);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(@NotNull View v, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(v, "v");
        SmLogger.m8666i(TAG, "onFocusChange# " + hasFocus);
        Iterator<View.OnFocusChangeListener> it = this.listenerList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            View.OnFocusChangeListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onFocusChange(v, hasFocus);
        }
        if (hasFocus) {
            this.smControlManager.getClipboardController().setClipboardDefaultFilter("onFocusChange");
            FocusManager focusManager = this.smControlManager.getFocusManager();
            if (focusManager != null) {
                focusManager.updateFocusTarget(this.smControlManager.getFTarget());
            }
        } else {
            this.smControlManager.getClipboardController().clearFilter("onFocusChange");
            FocusManager focusManager2 = this.smControlManager.getFocusManager();
            if (focusManager2 != null) {
                focusManager2.updateFocusTarget(null);
            }
        }
        ToolShareControl toolShareControl = this.smControlManager.getToolShareControl();
        if (toolShareControl != null) {
            toolShareControl.setEnabled(hasFocus);
        }
        ToolShareControl toolShareControl2 = this.smControlManager.getToolShareControl();
        if (toolShareControl2 != null) {
            toolShareControl2.syncToolbar(hasFocus);
        }
    }

    public final void release() {
        this.listenerList.clear();
    }

    public final void removeListener(@NotNull View.OnFocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerList.remove(listener);
    }
}
