package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.translation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationLanguageMenu extends AbsAsyncInflater implements TlToolbarContract.IView {
    private static final String TAG = Logger.createTag("TranslationLanguageMenu");
    private static final String TL_TOOLBAR_SHOWN = "TL_Toolbar_Shown";
    private View mExpandBtn;
    private View mExpandContainer;
    private final FloaterContainer mFloatingArea;
    private View mItemContainer;
    private View mMinimizeBtn;
    private final TlToolbarPresenter mPresenter;
    private TranslationLanguageContainerLayout mTranslationLanguageContainerLayout;
    private boolean mTranslationLanguageToolbarShown;

    public TranslationLanguageMenu(Activity activity, ViewGroup viewGroup, IToolbarManager iToolbarManager, TlToolbarPresenter tlToolbarPresenter) {
        super(viewGroup.getContext());
        this.mTranslationLanguageToolbarShown = false;
        Logger.m10999d(TAG, "TranslationLanguageMenu#");
        this.mPresenter = tlToolbarPresenter;
        tlToolbarPresenter.setView(this);
        FloaterContainer floaterContainer = (FloaterContainer) viewGroup.findViewById(C9086R.id.floating_layout_container);
        this.mFloatingArea = floaterContainer;
        asyncInflate(C9086R.layout.comp_translation_language_floating_toolbar_menu, floaterContainer);
    }

    private String getScreenID() {
        ComposerModel composerModel = this.mPresenter.getComposerModel();
        ModeManager modeManager = composerModel.getModeManager();
        return ComposerSA.getScreenID(composerModel.isPDFReader(), modeManager.isEditMode(), modeManager.isMode(Mode.Writing), composerModel.isTabletLayout());
    }

    @SuppressLint({"UseSparseArrays"})
    private void initButtons() {
        Logger.m10999d(TAG, "initButtons#");
        View viewFindViewById = this.mTranslationLanguageContainerLayout.findViewById(C9086R.id.translation_language_toolbar_menu_item_expand);
        this.mExpandContainer = viewFindViewById;
        if (viewFindViewById != null) {
            View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.tl_expand);
            this.mExpandBtn = viewFindViewById2;
            if (viewFindViewById2 != null) {
                final int i = 0;
                viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.translation.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ TranslationLanguageMenu f7276b;

                    {
                        this.f7276b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i) {
                            case 0:
                                this.f7276b.lambda$initButtons$0(view);
                                break;
                            default:
                                this.f7276b.lambda$initButtons$1(view);
                                break;
                        }
                    }
                });
            }
        }
        View viewFindViewById3 = this.mTranslationLanguageContainerLayout.findViewById(C9086R.id.translation_minimize_btn);
        this.mMinimizeBtn = viewFindViewById3;
        if (viewFindViewById3 != null) {
            final int i2 = 1;
            viewFindViewById3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.translation.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ TranslationLanguageMenu f7276b;

                {
                    this.f7276b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f7276b.lambda$initButtons$0(view);
                            break;
                        default:
                            this.f7276b.lambda$initButtons$1(view);
                            break;
                    }
                }
            });
        }
    }

    private boolean isInvalidStatus() {
        return this.mTranslationLanguageContainerLayout == null || this.mItemContainer == null || this.mExpandContainer == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initButtons$0(View view) {
        if (isInvalidStatus()) {
            Logger.m10999d(TAG, "onClick# Ignored by invalid status.");
            return;
        }
        Logger.m10999d(TAG, "onClick# ExpandBtn.");
        this.mItemContainer.measure(0, 0);
        this.mExpandContainer.measure(0, 0);
        TranslationLanguageContainerLayout translationLanguageContainerLayout = this.mTranslationLanguageContainerLayout;
        translationLanguageContainerLayout.setX((translationLanguageContainerLayout.getX() + this.mExpandContainer.getMeasuredWidth()) - this.mItemContainer.getMeasuredWidth());
        this.mItemContainer.setVisibility(0);
        this.mExpandContainer.setVisibility(8);
        ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_TRANSLATE_COLLAPSE_EXPAND, "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initButtons$1(View view) {
        if (isInvalidStatus()) {
            Logger.m10999d(TAG, "onClick# Ignored by invalid status.");
            return;
        }
        Logger.m10999d(TAG, "onClick# MinimizeBtn.");
        this.mItemContainer.measure(0, 0);
        this.mExpandContainer.measure(0, 0);
        TranslationLanguageContainerLayout translationLanguageContainerLayout = this.mTranslationLanguageContainerLayout;
        translationLanguageContainerLayout.setX((translationLanguageContainerLayout.getX() + this.mItemContainer.getMeasuredWidth()) - this.mExpandContainer.getMeasuredWidth());
        this.mExpandContainer.setVisibility(0);
        this.mItemContainer.setVisibility(8);
        ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_TRANSLATE_COLLAPSE_EXPAND, "1");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarContract.IView
    public View getContainer() {
        return this.mTranslationLanguageContainerLayout;
    }

    public void hide() {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.translation.TranslationLanguageMenu.2
                @Override // java.lang.Runnable
                public void run() {
                    TranslationLanguageMenu.this.hide();
                }
            });
        } else if (this.mTranslationLanguageContainerLayout != null) {
            Logger.m10999d(TAG, "hide#");
            this.mTranslationLanguageContainerLayout.setVisibility(8);
            this.mTranslationLanguageToolbarShown = false;
        }
    }

    public boolean isShown() {
        return this.mTranslationLanguageToolbarShown;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void onInflated(View view) {
        Logger.m10999d(TAG, "onInflated#");
        this.mTranslationLanguageContainerLayout = (TranslationLanguageContainerLayout) view.findViewById(C9086R.id.translation_language_toolbar_menu_container);
        this.mItemContainer = view.findViewById(C9086R.id.translation_language_toolbar_menu_item_container);
        this.mFloatingArea.addFloater(this.mTranslationLanguageContainerLayout);
        this.mFloatingArea.setClipChildren(false);
        try {
            initButtons();
        } catch (NoSuchMethodException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarContract.IView
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putBoolean(TL_TOOLBAR_SHOWN, this.mTranslationLanguageToolbarShown);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarContract.IView
    public void restore(final Bundle bundle) {
        if (!this.mPresenter.isTranslated()) {
            Logger.m10999d(TAG, "restore# Ignored by invalid status.");
            return;
        }
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.translation.TranslationLanguageMenu.1
                @Override // java.lang.Runnable
                public void run() {
                    TranslationLanguageMenu.this.restore(bundle);
                }
            });
            return;
        }
        Logger.m10999d(TAG, "restore#");
        boolean z = bundle.getBoolean(TL_TOOLBAR_SHOWN, false);
        this.mTranslationLanguageToolbarShown = z;
        if (!z || this.mTranslationLanguageContainerLayout.isShowing()) {
            return;
        }
        show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarContract.IView
    public void show() {
        if (this.mFloatingArea == null || this.mTranslationLanguageContainerLayout == null) {
            return;
        }
        Logger.m10999d(TAG, "show#");
        this.mFloatingArea.setVisibility(0);
        this.mTranslationLanguageContainerLayout.setVisibility(0);
        this.mTranslationLanguageToolbarShown = true;
    }
}
