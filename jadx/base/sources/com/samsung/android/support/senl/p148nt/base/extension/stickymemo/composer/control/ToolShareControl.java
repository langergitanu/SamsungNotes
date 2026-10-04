package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontSize;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.SmFeatures;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.span.SmFontSize;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.span.SmSpanStates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0087\u00012\u00020\u0001:\u0006\u0087\u0001\u0088\u0001\u0089\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010A\u001a\u00020BJ\u0015\u0010C\u001a\u0004\u0018\u0001052\u0006\u0010D\u001a\u000205¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020B2\u0006\u0010D\u001a\u0002052\u0006\u0010G\u001a\u000205J\u000e\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020BJ\u000e\u0010U\u001a\u00020B2\u0006\u0010V\u001a\u00020/J\u000e\u0010W\u001a\u00020B2\u0006\u0010X\u001a\u000205J\u000e\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u000205J\u000e\u0010[\u001a\u00020B2\u0006\u0010Z\u001a\u000205J\u0016\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020/J\u0016\u0010_\u001a\u00020B2\u0006\u0010`\u001a\u0002052\u0006\u0010a\u001a\u00020/J\u0016\u0010b\u001a\u00020B2\u0006\u0010c\u001a\u0002052\u0006\u0010a\u001a\u00020/J\u0016\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u0002052\u0006\u0010^\u001a\u00020/J\u0006\u0010f\u001a\u00020BJ\u0006\u0010g\u001a\u00020BJ\u0006\u0010h\u001a\u00020BJ\u0006\u0010i\u001a\u00020/J\u0006\u0010j\u001a\u00020BJ\u0006\u0010k\u001a\u00020/J\u0006\u0010l\u001a\u00020BJ\u0006\u0010m\u001a\u00020BJ \u0010n\u001a\u00020B2\u0006\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020/2\b\b\u0002\u0010q\u001a\u00020/J\u0010\u0010r\u001a\u00020B2\b\b\u0002\u0010s\u001a\u00020/J\u0010\u0010t\u001a\u00020B2\u0006\u0010u\u001a\u00020vH\u0016J\u0006\u0010w\u001a\u00020BJ\u0006\u0010x\u001a\u00020BJ\b\u0010y\u001a\u0004\u0018\u00010zJ\u000e\u0010{\u001a\u00020B2\u0006\u0010|\u001a\u000205J\u000e\u0010}\u001a\u00020B2\u0006\u0010~\u001a\u00020/J\u0006\u0010\u007f\u001a\u00020BJ\u000f\u0010\u0080\u0001\u001a\u00020B2\u0006\u0010^\u001a\u00020/J\u001b\u0010\u0081\u0001\u001a\u00020/2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0007\u0010\u0086\u0001\u001a\u00020BR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020/2\u0006\u0010:\u001a\u00020/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00101\"\u0004\b@\u00103¨\u0006\u008a\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager$TextStateChangeListener;", "<init>", "()V", "toolbarControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$IToolbarControl;", "getToolbarControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$IToolbarControl;", "setToolbarControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$IToolbarControl;)V", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "getSpenView$ntBase_release", "()Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "setSpenView$ntBase_release", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;)V", "writingControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;", "getWritingControl$ntBase_release", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;", "setWritingControl$ntBase_release", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;)V", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "getTextManager$ntBase_release", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "setTextManager$ntBase_release", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;)V", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "getModeControl$ntBase_release", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "setModeControl$ntBase_release", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;)V", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "getObjectManager$ntBase_release", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "setObjectManager$ntBase_release", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;)V", "sipController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "getSipController$ntBase_release", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "setSipController$ntBase_release", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "fontDelta", "", "getFontDelta", "()I", "setFontDelta", "(I)V", "value", "isStartAnimating", "setStartAnimating", "pendingFunc", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$PendingFunc;", "isTouching", "setTouching", "init", "", "getToolTypeAction", "toolType", "(I)Ljava/lang/Integer;", "setToolTypeAction", "action", "setPenSettingInfo", "penSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setRemoverSettingInfo", "removerSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setSelectionSettingInfo", "selectionSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "setChangeStyleSettingInfo", "changeStyleInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "eraseAll", "syncToolbar", "sync", "setFontSize", "fontSize", "setTextColor", "color", "setTextBgColor", "setTask", "taskType", "enable", "setAlign", "align", "notify", "setTextFormat", "format", "setStyle", "style", "changeTextMode", "changeHwMode", "undo", "isUndoable", "redo", "isRedoable", "notifyOnUndoRedo", "release", "updateRedoUndoState", "redoable", "undoable", "unsync", "showFontColorPicker", "isBgColor", "onChangedState", "smSpanStates", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/span/SmSpanStates;", "changeReadMode", "updateIsSpenOnlyMode", "getLastState", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/SpanStates;", "selectHwToolbarItem", "itemId", "openToolSetting", "textToolbar", "requestTextMode", "setAutoBlinkOffOnWindowFocusChanged", "deliveryPreTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "requestToCancelTouch", "Companion", "IToolbarControl", "PendingFunc", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToolShareControl implements SmTextManager.TextStateChangeListener {

    @NotNull
    private static final String TAG = SmLogger.createTag("ToolShareControl");
    private boolean enabled;
    private int fontDelta;
    private boolean isStartAnimating;
    private boolean isTouching;

    @Nullable
    private SmModeControl modeControl;

    @Nullable
    private SmObjectManager objectManager;

    @Nullable
    private PendingFunc pendingFunc;

    @Nullable
    private SipController sipController;

    @Nullable
    private SpenTextWritingView spenView;

    @Nullable
    private SmTextManager textManager;

    @Nullable
    private IToolbarControl toolbarControl;

    @Nullable
    private SmWritingControl writingControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H&J \u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\bH&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0003H&¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$IToolbarControl;", "", "isReadOnlyMode", "", "isTextMode", "getSettingPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "syncPenSetting", "", "syncToolState", "updateUnsupportedMenus", "enable", "updateRedoUndoState", "redoable", "undoable", "unsync", "notifyOnUndoRedo", "updateTextToolbar", "spanStates", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/SpanStates;", "unSyncTextToolbar", "isSpenOnlyMode", "selectHwToolbarItem", "itemId", "", "openToolSetting", "isTextToolbar", "requestTextMode", "deliveryPreTouch", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "showFontColorPicker", "isBgColor", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IToolbarControl {
        boolean deliveryPreTouch(@NotNull View view, @NotNull MotionEvent motionEvent);

        @NotNull
        SpenSettingUIPenInfo getSettingPenInfo();

        boolean isReadOnlyMode();

        boolean isSpenOnlyMode();

        boolean isTextMode();

        void notifyOnUndoRedo();

        void openToolSetting(boolean isTextToolbar);

        void requestTextMode();

        void selectHwToolbarItem(int itemId);

        void showFontColorPicker(boolean isBgColor);

        void syncPenSetting();

        void syncToolState();

        void unSyncTextToolbar();

        void updateRedoUndoState(boolean redoable, boolean undoable, boolean unsync);

        void updateTextToolbar(@NotNull SpanStates spanStates);

        void updateUnsupportedMenus(boolean enable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$PendingFunc;", "", "funcCall", "Ljava/lang/Runnable;", "<init>", "(Ljava/lang/Runnable;)V", "getFuncCall", "()Ljava/lang/Runnable;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PendingFunc {

        @NotNull
        private final Runnable funcCall;

        public PendingFunc(@NotNull Runnable funcCall) {
            Intrinsics.checkNotNullParameter(funcCall, "funcCall");
            this.funcCall = funcCall;
        }

        @NotNull
        public final Runnable getFuncCall() {
            return this.funcCall;
        }
    }

    public static /* synthetic */ void showFontColorPicker$default(ToolShareControl toolShareControl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        toolShareControl.showFontColorPicker(z);
    }

    public static /* synthetic */ void updateRedoUndoState$default(ToolShareControl toolShareControl, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = false;
        }
        toolShareControl.updateRedoUndoState(z, z2, z3);
    }

    public final void changeHwMode() {
        SmModeControl smModeControl = this.modeControl;
        if (smModeControl != null) {
            smModeControl.setHwMode();
        }
        if (this.enabled) {
            syncToolbar(true);
        }
    }

    public final void changeReadMode() {
        SmModeControl smModeControl = this.modeControl;
        if (smModeControl != null) {
            smModeControl.setReadMode();
        }
    }

    public final void changeTextMode() {
        SmModeControl smModeControl = this.modeControl;
        if (smModeControl != null) {
            smModeControl.setTextMode();
        }
        if (this.enabled) {
            syncToolbar(true);
        }
    }

    public final boolean deliveryPreTouch(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        this.isTouching = true;
        IToolbarControl iToolbarControl = this.toolbarControl;
        boolean z = iToolbarControl != null && iToolbarControl.deliveryPreTouch(view, event);
        this.isTouching = false;
        return z;
    }

    public final void eraseAll() {
        SmLogger.m8661d(TAG, "eraseAll#");
        SmObjectManager smObjectManager = this.objectManager;
        if (smObjectManager != null) {
            smObjectManager.removeAllStroke();
        }
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getFontDelta() {
        return this.fontDelta;
    }

    @Nullable
    public final SpanStates getLastState() {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            return smTextManager.getSpanState();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: getModeControl$ntBase_release, reason: from getter */
    public final SmModeControl getModeControl() {
        return this.modeControl;
    }

    @Nullable
    /* JADX INFO: renamed from: getObjectManager$ntBase_release, reason: from getter */
    public final SmObjectManager getObjectManager() {
        return this.objectManager;
    }

    @Nullable
    /* JADX INFO: renamed from: getSipController$ntBase_release, reason: from getter */
    public final SipController getSipController() {
        return this.sipController;
    }

    @Nullable
    /* JADX INFO: renamed from: getSpenView$ntBase_release, reason: from getter */
    public final SpenTextWritingView getSpenView() {
        return this.spenView;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextManager$ntBase_release, reason: from getter */
    public final SmTextManager getTextManager() {
        return this.textManager;
    }

    @Nullable
    public final Integer getToolTypeAction(int toolType) {
        SmWritingControl smWritingControl = this.writingControl;
        if (smWritingControl != null) {
            return Integer.valueOf(smWritingControl.getToolTypeAction(toolType));
        }
        return null;
    }

    @Nullable
    public final IToolbarControl getToolbarControl() {
        return this.toolbarControl;
    }

    @Nullable
    /* JADX INFO: renamed from: getWritingControl$ntBase_release, reason: from getter */
    public final SmWritingControl getWritingControl() {
        return this.writingControl;
    }

    public final void init() {
        ToolShareControl toolShareControl;
        SpenWNote note;
        this.enabled = true;
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            SmObjectManager smObjectManager = this.objectManager;
            if (smObjectManager == null || (note = smObjectManager.getNote()) == null) {
                toolShareControl = this;
            } else {
                toolShareControl = this;
                updateRedoUndoState$default(toolShareControl, note.isRedoable(), note.isUndoable(), false, 4, null);
            }
            SmTextManager smTextManager = toolShareControl.textManager;
            if (smTextManager != null) {
                smTextManager.setTextStateChangeListener(this);
                FontSize bodyTextFontSize = smTextManager.getSpanState().getBodyTextFontSize();
                Intrinsics.checkNotNull(bodyTextFontSize, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.text.span.SmFontSize");
                ((SmFontSize) bodyTextFontSize).setSizeDelta(toolShareControl.fontDelta);
            }
            if (iToolbarControl.isReadOnlyMode()) {
                SmModeControl smModeControl = toolShareControl.modeControl;
                if (smModeControl != null) {
                    smModeControl.setReadMode();
                }
            } else if (iToolbarControl.isTextMode()) {
                SipController sipController = toolShareControl.sipController;
                if (sipController != null) {
                    sipController.blockToShow(true, "init");
                }
                requestTextMode();
                SipController sipController2 = toolShareControl.sipController;
                if (sipController2 != null) {
                    sipController2.blockToShow(false, "init");
                }
            } else {
                changeHwMode();
            }
            iToolbarControl.syncPenSetting();
            iToolbarControl.syncToolState();
            IToolbarControl iToolbarControl2 = toolShareControl.toolbarControl;
            if (iToolbarControl2 != null) {
                iToolbarControl2.updateUnsupportedMenus(false);
            }
        }
    }

    public final boolean isRedoable() {
        SpenWNote note;
        SmObjectManager smObjectManager = this.objectManager;
        return (smObjectManager == null || (note = smObjectManager.getNote()) == null || !note.isRedoable()) ? false : true;
    }

    /* JADX INFO: renamed from: isStartAnimating, reason: from getter */
    public final boolean getIsStartAnimating() {
        return this.isStartAnimating;
    }

    /* JADX INFO: renamed from: isTouching, reason: from getter */
    public final boolean getIsTouching() {
        return this.isTouching;
    }

    public final boolean isUndoable() {
        SpenWNote note;
        SmObjectManager smObjectManager = this.objectManager;
        return (smObjectManager == null || (note = smObjectManager.getNote()) == null || !note.isUndoable()) ? false : true;
    }

    public final void notifyOnUndoRedo() {
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.notifyOnUndoRedo();
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.text.SmTextManager.TextStateChangeListener
    public void onChangedState(@NotNull SmSpanStates smSpanStates) {
        Intrinsics.checkNotNullParameter(smSpanStates, "smSpanStates");
        if (this.isStartAnimating) {
            this.pendingFunc = new PendingFunc(new RunnableC8515c(this, smSpanStates, 17));
            return;
        }
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.updateTextToolbar(smSpanStates);
        }
    }

    public final void openToolSetting(boolean textToolbar) {
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.openToolSetting(textToolbar);
        }
    }

    public final void redo() {
        SmObjectManager smObjectManager = this.objectManager;
        if (smObjectManager == null || !smObjectManager.getNote().isRedoable()) {
            return;
        }
        smObjectManager.clearSelection();
        smObjectManager.getNote().redo();
    }

    public final void release() {
        this.enabled = false;
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.updateUnsupportedMenus(true);
        }
        updateRedoUndoState(false, false, true);
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setTextStateChangeListener(null);
        }
        this.toolbarControl = null;
        this.writingControl = null;
        this.textManager = null;
        this.modeControl = null;
        this.objectManager = null;
        this.sipController = null;
        this.spenView = null;
    }

    public final void requestTextMode() {
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.requestTextMode();
        }
    }

    public final void requestToCancelTouch() {
        SpenTextWritingView spenTextWritingView = this.spenView;
        if (spenTextWritingView != null) {
            spenTextWritingView.requestCancelTouch();
        }
    }

    public final void selectHwToolbarItem(int itemId) {
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.selectHwToolbarItem(itemId);
        }
    }

    public final void setAlign(int align, boolean notify) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setAlign(align, notify);
        }
    }

    public final void setAutoBlinkOffOnWindowFocusChanged(boolean enable) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setAutoBlinkOffOnWindowFocusChanged(enable);
        }
    }

    public final void setChangeStyleSettingInfo(@NotNull SpenSettingUIChangeStyleInfo changeStyleInfo) {
        Intrinsics.checkNotNullParameter(changeStyleInfo, "changeStyleInfo");
        SmWritingControl smWritingControl = this.writingControl;
        if (smWritingControl != null) {
            smWritingControl.setChangeStyleSettingInfo(changeStyleInfo);
        }
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setFontDelta(int i) {
        this.fontDelta = i;
    }

    public final void setFontSize(int fontSize) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            Integer numValueOf = smTextManager.isSelected() ? Integer.valueOf(smTextManager.getCursor()[1]) : null;
            SmTextManager.setFontSize$default(smTextManager, fontSize, false, 2, null);
            SpenTextWritingView spenTextWritingView = this.spenView;
            if (spenTextWritingView != null) {
                Context context = spenTextWritingView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (smTextManager.isOverHeight(context)) {
                    undo();
                    if (numValueOf != null) {
                        smTextManager.getTextBox().setCursorPosition(numValueOf.intValue());
                    }
                    smTextManager.setCursorBlink(true);
                    spenTextWritingView.post(new RunnableC8669a(smTextManager, 18));
                }
            }
        }
    }

    public final void setModeControl$ntBase_release(@Nullable SmModeControl smModeControl) {
        this.modeControl = smModeControl;
    }

    public final void setObjectManager$ntBase_release(@Nullable SmObjectManager smObjectManager) {
        this.objectManager = smObjectManager;
    }

    public final void setPenSettingInfo(@NotNull SpenSettingUIPenInfo penSettingInfo) {
        Intrinsics.checkNotNullParameter(penSettingInfo, "penSettingInfo");
        if (this.writingControl != null) {
            if (SmFeatures.UNSUPPORTED.INSTANCE.isPenSetting(penSettingInfo)) {
                SmLogger.m8662e(TAG, "setPenSettingInfo# marker pen is not supported");
                return;
            }
            SmWritingControl smWritingControl = this.writingControl;
            if (smWritingControl != null) {
                smWritingControl.setPenSettingInfo(penSettingInfo);
            }
        }
    }

    public final void setRemoverSettingInfo(@NotNull SpenSettingRemoverInfo removerSettingInfo) {
        Intrinsics.checkNotNullParameter(removerSettingInfo, "removerSettingInfo");
        SpenSettingRemoverInfo spenSettingRemoverInfo = new SpenSettingRemoverInfo();
        spenSettingRemoverInfo.target = 0;
        spenSettingRemoverInfo.type = removerSettingInfo.type;
        spenSettingRemoverInfo.size = removerSettingInfo.size;
        spenSettingRemoverInfo.isRemoveShapeEnabled = removerSettingInfo.isRemoveShapeEnabled;
        SmWritingControl smWritingControl = this.writingControl;
        if (smWritingControl != null) {
            smWritingControl.setRemoverSettingInfo(spenSettingRemoverInfo);
        }
    }

    public final void setSelectionSettingInfo(@NotNull SpenSettingSelectionInfo selectionSettingInfo) {
        Intrinsics.checkNotNullParameter(selectionSettingInfo, "selectionSettingInfo");
        SmWritingControl smWritingControl = this.writingControl;
        if (smWritingControl != null) {
            smWritingControl.setSelectionSettingInfo(selectionSettingInfo);
        }
    }

    public final void setSipController$ntBase_release(@Nullable SipController sipController) {
        this.sipController = sipController;
    }

    public final void setSpenView$ntBase_release(@Nullable SpenTextWritingView spenTextWritingView) {
        this.spenView = spenTextWritingView;
    }

    public final void setStartAnimating(boolean z) {
        PendingFunc pendingFunc;
        Runnable funcCall;
        boolean z2 = this.isStartAnimating && !z;
        this.isStartAnimating = z;
        if (!z2 || (pendingFunc = this.pendingFunc) == null || (funcCall = pendingFunc.getFuncCall()) == null) {
            return;
        }
        funcCall.run();
    }

    public final void setStyle(int style, boolean enable) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setStyle(style, enable);
        }
    }

    public final void setTask(int taskType, boolean enable) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setTask(taskType, enable);
        }
    }

    public final void setTextBgColor(int color) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setTextBgColor(color);
        }
    }

    public final void setTextColor(int color) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setTextColor(color);
        }
    }

    public final void setTextFormat(int format, boolean notify) {
        SmTextManager smTextManager = this.textManager;
        if (smTextManager != null) {
            smTextManager.setTextFormat(format, notify);
        }
    }

    public final void setTextManager$ntBase_release(@Nullable SmTextManager smTextManager) {
        this.textManager = smTextManager;
    }

    public final void setToolTypeAction(int toolType, int action) {
        SmWritingControl smWritingControl;
        if (SmFeatures.UNSUPPORTED.INSTANCE.isSpenAction(action) || (smWritingControl = this.writingControl) == null) {
            return;
        }
        smWritingControl.setOnlyToolTypeAction(toolType, action);
    }

    public final void setToolbarControl(@Nullable IToolbarControl iToolbarControl) {
        this.toolbarControl = iToolbarControl;
    }

    public final void setTouching(boolean z) {
        this.isTouching = z;
    }

    public final void setWritingControl$ntBase_release(@Nullable SmWritingControl smWritingControl) {
        this.writingControl = smWritingControl;
    }

    public final void showFontColorPicker(boolean isBgColor) {
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.showFontColorPicker(isBgColor);
        }
    }

    public final void syncToolbar(boolean sync) {
        ToolShareControl toolShareControl;
        SpenWNote note;
        IToolbarControl iToolbarControl;
        if (sync) {
            updateIsSpenOnlyMode();
            IToolbarControl iToolbarControl2 = this.toolbarControl;
            if (iToolbarControl2 != null) {
                iToolbarControl2.syncToolState();
            }
            SmTextManager smTextManager = this.textManager;
            if (smTextManager != null && (iToolbarControl = this.toolbarControl) != null) {
                Intrinsics.checkNotNull(smTextManager);
                iToolbarControl.updateTextToolbar(smTextManager.getSpanState());
            }
            SmObjectManager smObjectManager = this.objectManager;
            if (smObjectManager == null || (note = smObjectManager.getNote()) == null) {
                toolShareControl = this;
            } else {
                toolShareControl = this;
                updateRedoUndoState$default(toolShareControl, note.isRedoable(), note.isUndoable(), false, 4, null);
            }
        } else {
            toolShareControl = this;
            IToolbarControl iToolbarControl3 = toolShareControl.toolbarControl;
            if (iToolbarControl3 != null) {
                iToolbarControl3.unSyncTextToolbar();
            }
            updateRedoUndoState(false, false, true);
        }
        IToolbarControl iToolbarControl4 = toolShareControl.toolbarControl;
        if (iToolbarControl4 != null) {
            iToolbarControl4.updateUnsupportedMenus(!sync);
        }
    }

    public final void undo() {
        SmObjectManager smObjectManager = this.objectManager;
        if (smObjectManager == null || !smObjectManager.getNote().isUndoable()) {
            return;
        }
        smObjectManager.clearSelection();
        smObjectManager.getNote().undo();
    }

    public final void updateIsSpenOnlyMode() {
        boolean zIsSpenOnlyMode;
        SmWritingControl smWritingControl = this.writingControl;
        if (smWritingControl != null) {
            IToolbarControl iToolbarControl = this.toolbarControl;
            if (iToolbarControl != null) {
                Intrinsics.checkNotNull(iToolbarControl);
                zIsSpenOnlyMode = iToolbarControl.isSpenOnlyMode();
            } else {
                zIsSpenOnlyMode = true;
            }
            smWritingControl.setSpenOnlyMode(zIsSpenOnlyMode);
        }
    }

    public final void updateRedoUndoState(boolean redoable, boolean undoable, boolean unsync) {
        String str = TAG;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("updateRedoUndoState# ", " ", " ", redoable, undoable);
        sbM2230u.append(unsync);
        SmLogger.m8661d(str, sbM2230u.toString());
        IToolbarControl iToolbarControl = this.toolbarControl;
        if (iToolbarControl != null) {
            iToolbarControl.updateRedoUndoState(redoable, undoable, unsync);
        }
    }
}
