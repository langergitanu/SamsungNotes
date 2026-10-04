package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Menu;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuChangeStyle extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuChangeStyle");
    private HwToolbarPresenter mHwToolbarPresenter;
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;

    public ContextMenuChangeStyle(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    private void executeSelectionChangeStyle() {
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = new SpenSettingUIChangeStyleInfo();
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        boolean z = true;
        if (selectedObjectList.size() == 1) {
            SpenObjectBase spenObjectBase = selectedObjectList.get(0);
            if (spenObjectBase instanceof SpenObjectShape) {
                SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
                SpenObjectShape spenObjectShape = (SpenObjectShape) spenObjectBase;
                spenObjectShape.getLineColorEffect(spenLineColorEffect);
                spenSettingUIChangeStyleInfo.color = spenLineColorEffect.getSolidColor();
                SpenFillColorEffect spenFillColorEffect = new SpenFillColorEffect();
                spenObjectShape.getFillEffect(spenFillColorEffect);
                spenSettingUIChangeStyleInfo.fillColor = spenFillColorEffect.getSolidColor();
                if (spenFillColorEffect.getColorType() == 0 && spenSettingUIChangeStyleInfo.fillColor != 0) {
                    z = false;
                }
                spenSettingUIChangeStyleInfo.isBlankShape = z;
                SpenLineStyleEffect spenLineStyleEffect = new SpenLineStyleEffect();
                spenObjectShape.getLineStyleEffect(spenLineStyleEffect);
                spenSettingUIChangeStyleInfo.sizeLevel = CommonUtil.convertLinePixelToSizeLevel(this.mActivity, spenLineStyleEffect.getWidth());
            } else if (spenObjectBase instanceof SpenObjectStroke) {
                SpenObjectStroke spenObjectStroke = (SpenObjectStroke) spenObjectBase;
                int iConvertSizeToSizeLevel = SpenPenUtil.convertSizeToSizeLevel(this.mActivity, spenObjectStroke.getPenName(), spenObjectStroke.getPenSize(), this.mHwToolbarPresenter.getWritingToolManager().getWNoteWidth(), this.mHwToolbarPresenter.getWritingToolManager().getWNoteHeight());
                spenSettingUIChangeStyleInfo.color = spenObjectStroke.getColor();
                spenSettingUIChangeStyleInfo.isBlankShape = true;
                spenSettingUIChangeStyleInfo.sizeLevel = iConvertSizeToSizeLevel;
            }
        } else {
            spenSettingUIChangeStyleInfo.color = -14342875;
            spenSettingUIChangeStyleInfo.isBlankShape = true;
            spenSettingUIChangeStyleInfo.sizeLevel = 30;
        }
        this.mHwToolbarPresenter.openSelectionChangeStyle(spenSettingUIChangeStyleInfo, isSelectedObjectOfClosedCurveShapeType(), new AnchorInfo(getObjectGroupRect(selectedObjectList), this.mActivity.findViewById(C9086R.id.floating_layout_container)));
    }

    private Rect getObjectGroupRect(List<SpenObjectBase> list) {
        RectF rectF = new RectF();
        Iterator<SpenObjectBase> it = list.iterator();
        while (it.hasNext()) {
            rectF.union(it.next().getRect());
        }
        RectF rectFConvertContentRectIntoViewRect = this.mObjectManager.getNoteZoomScroller().convertContentRectIntoViewRect(rectF);
        Rect rect = new Rect();
        rectFConvertContentRectIntoViewRect.round(rect);
        return rect;
    }

    private boolean isSelectedObjectOfClosedCurveShapeType() {
        int shapeType;
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.isEmpty()) {
            return false;
        }
        for (SpenObjectBase spenObjectBase : selectedObjectList) {
            if (!(spenObjectBase instanceof SpenObjectShape) || (shapeType = ((SpenObjectShape) spenObjectBase).getShapeType()) == 88 || shapeType == 90) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_CHANGE_STYLE;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.hw_toolbar_quick_highlighter).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList;
        if (!this.mModeManager.isEditMode() || (selectedObjectList = this.mObjectManager.getSelectedObjectList()) == null) {
            return false;
        }
        for (SpenObjectBase spenObjectBase : selectedObjectList) {
            if (spenObjectBase.getType() == 7 && (spenObjectBase.getExtraDataInt("extra_key_converted_type") == 1 || this.mObjectManager.isFocusedTextBox())) {
                return false;
            }
            if (!VMetaDataKey.META_KEY_SHAPE.equals(spenObjectBase.getExtraDataString("action_link")) && ObjectTypeUtil.isStrokeType(spenObjectBase.getType())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m11003i(TAG, "executeChangeStyleMenu#");
        executeSelectionChangeStyle();
        ComposerSA.insertLog("411", "4318");
    }
}
