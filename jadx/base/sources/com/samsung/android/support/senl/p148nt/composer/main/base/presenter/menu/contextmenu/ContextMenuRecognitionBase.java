package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContextMenuRecognitionBase extends ContextMenuItem {
    protected ModeManager mModeManager;
    protected ObjectManager mObjectManager;

    public ContextMenuRecognitionBase(ObjectManager objectManager, ModeManager modeManager) {
        this.mObjectManager = objectManager;
        this.mModeManager = modeManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList;
        if (!isAvailableFeature() || !isAvailableMode() || (selectedObjectList = this.mObjectManager.getSelectedObjectList()) == null) {
            return false;
        }
        for (SpenObjectBase spenObjectBase : selectedObjectList) {
            if (!VMetaDataKey.META_KEY_SHAPE.equals(spenObjectBase.getExtraDataString("action_link")) && spenObjectBase.getType() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isAvailableFeature() {
        return RecognitionUtil.isSupported(this.mActivity);
    }

    public boolean isAvailableMode() {
        return this.mModeManager.isEditMode();
    }
}
