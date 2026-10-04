package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSelectionController {
    protected ModeManager mModeManager;
    protected ObjectManager mObjectManager;
    private PdfManager mPdfManager;
    protected TextManager mTextManager;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerSelectionController$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C91811 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$model$mode$Mode */
        static final /* synthetic */ int[] f6779xb41f9be;

        static {
            int[] iArr = new int[Mode.values().length];
            f6779xb41f9be = iArr;
            try {
                iArr[Mode.Writing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6779xb41f9be[Mode.Text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6779xb41f9be[Mode.View.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6779xb41f9be[Mode.Search.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public boolean clearSelection() {
        if (this.mPdfManager.hasSelectedPDF()) {
            this.mPdfManager.clearSelection();
            return true;
        }
        if (!this.mObjectManager.getSelectedObjectManager().isSelectedObject()) {
            return false;
        }
        boolean zIsFocusedTextBox = this.mObjectManager.isFocusedTextBox();
        boolean zIsSelectedBodyText = this.mObjectManager.isSelectedBodyText();
        boolean zIsSelected = zIsFocusedTextBox ? this.mTextManager.isSelected() : false;
        if (zIsSelectedBodyText && !zIsSelected) {
            return false;
        }
        int i = C91811.f6779xb41f9be[this.mModeManager.getMode().ordinal()];
        if (i == 1) {
            this.mObjectManager.clearSelectObject();
            return true;
        }
        if (i == 2) {
            clearSelectionInTextMode(zIsSelected);
            return true;
        }
        if (i != 3 && i != 4) {
            return false;
        }
        this.mObjectManager.clearSelectObject();
        return false;
    }

    public void clearSelectionInTextMode(boolean z) {
        if (z) {
            this.mTextManager.clearSelection();
        } else {
            this.mObjectManager.clearSelectObject();
        }
    }

    public void init(ModelManager modelManager, ModeManager modeManager) {
        this.mObjectManager = modelManager.getObjectManager();
        this.mTextManager = modelManager.getTextManager();
        this.mPdfManager = modelManager.getPdfManager();
        this.mModeManager = modeManager;
    }
}
