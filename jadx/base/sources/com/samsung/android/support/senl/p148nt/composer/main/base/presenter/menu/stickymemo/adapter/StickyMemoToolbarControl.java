package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.SmFeatures;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0016H\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0018\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoToolbarControl;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl$IToolbarControl;", "toolbarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/ToolbarPresenter;", "hwToolbar", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;", "rtToolbar", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/richtext/RtToolbarPresenter;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/ToolbarPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/richtext/RtToolbarPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "isReadOnlyMode", "", "isTextMode", "getSettingPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "syncPenSetting", "", "syncToolState", "setToolTypeAction", "toolType", "", "updateUnsupportedMenus", "enable", "updateRedoUndoState", "redoable", "undoable", "unsync", "notifyOnUndoRedo", "updateTextToolbar", "spanStates", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/SpanStates;", "unSyncTextToolbar", "isSpenOnlyMode", "selectHwToolbarItem", "itemId", "openToolSetting", "isTextToolbar", "requestTextMode", "deliveryPreTouch", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "showFontColorPicker", "isBgColor", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoToolbarControl implements ToolShareControl.IToolbarControl {

    @NotNull
    private final ComposerViewPresenter composerViewPresenter;

    @NotNull
    private final HwToolbarPresenter hwToolbar;

    @NotNull
    private final RtToolbarPresenter rtToolbar;

    @NotNull
    private final ToolbarPresenter toolbarPresenter;

    public StickyMemoToolbarControl(@NotNull ToolbarPresenter toolbarPresenter, @NotNull HwToolbarPresenter hwToolbar, @NotNull RtToolbarPresenter rtToolbar, @NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(toolbarPresenter, "toolbarPresenter");
        Intrinsics.checkNotNullParameter(hwToolbar, "hwToolbar");
        Intrinsics.checkNotNullParameter(rtToolbar, "rtToolbar");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.toolbarPresenter = toolbarPresenter;
        this.hwToolbar = hwToolbar;
        this.rtToolbar = rtToolbar;
        this.composerViewPresenter = composerViewPresenter;
    }

    private final void setToolTypeAction(int toolType) {
        this.composerViewPresenter.getWritingToolManager().setToolTypeActionWrap(toolType, this.composerViewPresenter.getWritingToolManager().getToolTypeAction(toolType));
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public boolean deliveryPreTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        SpenPreTouchListenerImpl.PreTouchListener preTouchListener = this.toolbarPresenter.getPreTouchListener();
        return preTouchListener != null && preTouchListener.onTouch(view, motionEvent);
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    @NotNull
    public SpenSettingUIPenInfo getSettingPenInfo() {
        SpenSettingUIPenInfo settingPenInfoSelected = this.hwToolbar.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected();
        Intrinsics.checkNotNullExpressionValue(settingPenInfoSelected, "getSettingPenInfoSelected(...)");
        return settingPenInfoSelected;
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public boolean isReadOnlyMode() {
        return this.composerViewPresenter.getComposerModel().getModeManager().isMode(Mode.ReadOnly);
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public boolean isSpenOnlyMode() {
        return this.composerViewPresenter.getWritingToolManager().isSpenOnlyMode();
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public boolean isTextMode() {
        return this.hwToolbar.isTextMode();
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void notifyOnUndoRedo() {
        this.hwToolbar.notifyOnUndoRedo();
        this.rtToolbar.notifyOnUndoRedo();
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void openToolSetting(boolean isTextToolbar) {
        if (isTextToolbar) {
            this.rtToolbar.executeTextStyle();
        } else {
            this.hwToolbar.executePenSetting();
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void requestTextMode() {
        this.hwToolbar.changeTextMode();
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void selectHwToolbarItem(int itemId) {
        if (this.hwToolbar.isSelected(itemId)) {
            return;
        }
        this.hwToolbar.onSelected(itemId);
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void showFontColorPicker(boolean isBgColor) {
        this.rtToolbar.showTextColor(isBgColor);
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void syncPenSetting() {
        this.hwToolbar.getMRemoteHwSettingPresenter().updateSettingInfo();
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void syncToolState() {
        boolean z;
        Iterator<Integer> it = SmFeatures.UNSUPPORTED.INSTANCE.getHW_MENUS().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Integer next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            int iIntValue = next.intValue();
            if (this.hwToolbar.isSelected(iIntValue)) {
                if (iIntValue == 2048) {
                    ToastHandler.show(this.composerViewPresenter.getActivity(), C9086R.string.unsupported_highlighter_pen, 0);
                }
                if (iIntValue != 4096) {
                    this.hwToolbar.onSelected(2);
                }
                z = false;
            }
        }
        SmFeatures.UNSUPPORTED unsupported = SmFeatures.UNSUPPORTED.INSTANCE;
        if (unsupported.getHW_MENUS().contains(64)) {
            this.hwToolbar.unselect(64);
        }
        if (unsupported.getHW_MENUS().contains(4096)) {
            this.hwToolbar.unselect(4096);
        }
        if (z) {
            setToolTypeAction(0);
            setToolTypeAction(1);
            setToolTypeAction(2);
            setToolTypeAction(3);
            setToolTypeAction(4);
            setToolTypeAction(6);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void unSyncTextToolbar() {
        this.rtToolbar.updateState(this.composerViewPresenter.getTextManager().getLastTextState());
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void updateRedoUndoState(boolean redoable, boolean undoable, boolean unsync) {
        if (CommonUtil.isAvailableActivity(this.composerViewPresenter.getActivity())) {
            if (!unsync) {
                this.hwToolbar.updateUndoRedo(redoable, undoable);
                this.rtToolbar.updateUndoRedo(redoable, undoable);
                return;
            }
            SpenWNote doc = this.composerViewPresenter.getDoc();
            boolean zIsUndoable = doc.isUndoable();
            boolean zIsRedoable = doc.isRedoable();
            this.hwToolbar.updateUndoRedo(zIsRedoable, zIsUndoable);
            this.rtToolbar.updateUndoRedo(zIsRedoable, zIsUndoable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void updateTextToolbar(@NotNull SpanStates spanStates) {
        Intrinsics.checkNotNullParameter(spanStates, "spanStates");
        this.rtToolbar.updateState(spanStates);
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.ToolShareControl.IToolbarControl
    public void updateUnsupportedMenus(boolean enable) {
        if (CommonUtil.isAvailableActivity(this.composerViewPresenter.getActivity())) {
            HwToolbarPresenter hwToolbarPresenter = this.hwToolbar;
            SmFeatures.UNSUPPORTED unsupported = SmFeatures.UNSUPPORTED.INSTANCE;
            hwToolbarPresenter.enableMenus(enable, unsupported.getHW_MENUS());
            this.hwToolbar.setConnectionStickyMemo(enable);
            this.rtToolbar.enableMenus(enable, unsupported.getTEXT_MENUS());
        }
    }
}
