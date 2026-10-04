package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.TemplateEditorModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image.InitialImageCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.IContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.TemplateEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.adjust.TEAdjustView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.menu.TEMenuView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateEditorView extends Fragment implements IContract.IView {
    private static final int MIN_EDITABLE_HEIGHT_DP = 320;
    private static final int MIN_EDITABLE_WIDTH_DP = 380;
    public static final String TAG = CTLogger.createTag("TemplateEditorView");
    private TEAdjustView mAdjustView;
    private final View.OnLayoutChangeListener mAdjustViewLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.TemplateEditorView.2
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            TemplateEditorView.this.updateBlockDialog();
        }
    };
    private Dialog mBlockDialog;
    private boolean mIsCtrlPressed;
    private boolean mIsMultiWindowMode;
    private TEMenuView mMenuView;
    private boolean mOnApplying;
    private TemplateEditorPresenter mPresenter;
    private DialogUtils.ProgressDialog mProgressDialog;
    private View mRootView;

    private TemplateEditorModel createModel() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_PATH);
        Bitmap bitmapCreate = new InitialImageCreator(stringExtra).create();
        if (bitmapCreate == null) {
            return null;
        }
        return new TemplateEditorModel(bitmapCreate, stringExtra, intent.getIntExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_WIDTH, 0), intent.getIntExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_HEIGHT, 0), intent.getStringExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_NEW_PATH));
    }

    private void dismissBlockDialog() {
        Dialog dialog = this.mBlockDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mBlockDialog.dismiss();
        }
        this.mBlockDialog = null;
    }

    private void dismissProgressDialog() {
        DialogUtils.ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
    }

    private void initLayout(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(C9086R.layout.template_editor_fragment, viewGroup, false);
        this.mRootView = viewInflate;
        TEAdjustView tEAdjustView = (TEAdjustView) viewInflate.findViewById(C9086R.id.template_editor_adjust_view);
        this.mAdjustView = tEAdjustView;
        tEAdjustView.setPresenter(this.mPresenter.getAdjustPresenter(), this);
        this.mAdjustView.addOnLayoutChangeListener(this.mAdjustViewLayoutChangeListener);
        this.mMenuView = new TEMenuView(this, this.mPresenter);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        Toolbar toolbar = (Toolbar) activity.getWindow().getDecorView().findViewById(C9086R.id.toolbar);
        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setTint(getActivity().getColor(C9086R.color.composer_default_text_color));
        }
    }

    private boolean isEditable() {
        if (!this.mIsMultiWindowMode) {
            return true;
        }
        float f = getResources().getDisplayMetrics().density;
        return getResources().getConfiguration().orientation == 1 ? ((float) getResources().getDisplayMetrics().heightPixels) / f >= 320.0f : ((float) getResources().getDisplayMetrics().widthPixels) / f >= 380.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlockDialog() {
        if (this.mAdjustView == null || getContext() == null) {
            return;
        }
        dismissBlockDialog();
        if (isEditable() && this.mAdjustView.isEditable()) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Dialog dialog = new Dialog(getContext());
        this.mBlockDialog = dialog;
        dialog.requestWindowFeature(1);
        this.mBlockDialog.setCancelable(false);
        this.mBlockDialog.setCanceledOnTouchOutside(false);
        this.mBlockDialog.setContentView(C9086R.layout.template_editor_block_layout);
        Window window = this.mBlockDialog.getWindow();
        if (window != null) {
            window.addFlags(1024);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, displayMetrics.heightPixels);
        }
        CharUtils.applyTextSizeUntilLargeSize(getContext(), (TextView) this.mBlockDialog.findViewById(C9086R.id.template_editor_block_text), 20.0f);
        this.mBlockDialog.show();
        this.mBlockDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.TemplateEditorView.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                Logger.m11003i(TemplateEditorView.TAG, "onKey# onBackPressed");
                TemplateEditorView.this.onBackPressed();
                return false;
            }
        });
    }

    private void updateMultiWindowMode() {
        boolean zIsMultiWindowMode = WindowManagerCompat.getInstance().isMultiWindowMode(getActivity());
        Logger.m11003i(TAG, "updateMultiWindowMode, old/new = " + this.mIsMultiWindowMode + "/" + zIsMultiWindowMode);
        if (this.mIsMultiWindowMode != zIsMultiWindowMode) {
            this.mIsMultiWindowMode = zIsMultiWindowMode;
            TemplateEditorPresenter templateEditorPresenter = this.mPresenter;
            if (templateEditorPresenter != null) {
                templateEditorPresenter.storeData();
            }
        }
    }

    public void dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mIsCtrlPressed && DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext()) && this.mPresenter != null && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            this.mPresenter.getZoomPresenter().scrollZoom(Float.compare(motionEvent.getAxisValue(9), 0.0f) > 0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.IContract.IView
    public void finish(boolean z) {
        Logger.m11003i(TAG, "finish, isSaved : " + z);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (z) {
            Intent intent = activity.getIntent();
            intent.putExtra(TemplateConstants.TEMPLATE_EDITOR_IMAGE_NEW_NAME, this.mPresenter.getAdjustPresenter().getTemplateName());
            activity.setResult(-1, intent);
        } else {
            activity.setResult(0, activity.getIntent());
        }
        dismissProgressDialog();
        activity.finish();
    }

    public TEMenuView getMenuView() {
        return this.mMenuView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.IContract.IView
    public View getRootView() {
        return this.mRootView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.IContract.IView
    public int getTotalHeight() {
        return getResources().getDisplayMetrics().heightPixels - (getResources().getDimensionPixelSize(C9086R.dimen.template_editor_bottom_menu_height) * 2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.IContract.IView
    public boolean isMultiWindowMode() {
        return this.mIsMultiWindowMode;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.IContract.IView
    public void onApply() {
        this.mOnApplying = true;
    }

    public void onBackPressed() {
        finish(false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateMultiWindowMode();
        this.mMenuView.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.mMenuView.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String str = TAG;
        Logger.m11003i(str, "onCreateView()");
        boolean z = bundle != null && bundle.getBoolean(ChangeTemplateConstants.KEY_TE_ON_APPLYING);
        this.mOnApplying = z;
        if (z) {
            Logger.m11004w(str, "onCreateView, fail to edit an image");
            finish(false);
            return new View(getContext());
        }
        DisplayUtils.init(getContext());
        updateMultiWindowMode();
        TemplateEditorModel templateEditorModelCreateModel = createModel();
        if (templateEditorModelCreateModel == null) {
            Logger.m11000e(str, "onCreateView : failed create model");
            finish(false);
            return new View(getContext());
        }
        this.mPresenter = new TemplateEditorPresenter(this, templateEditorModelCreateModel);
        setHasOptionsMenu(true);
        initLayout(layoutInflater, viewGroup);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        dismissBlockDialog();
        TEMenuView tEMenuView = this.mMenuView;
        if (tEMenuView != null) {
            tEMenuView.release();
            this.mMenuView = null;
        }
        TEAdjustView tEAdjustView = this.mAdjustView;
        if (tEAdjustView != null) {
            tEAdjustView.removeOnLayoutChangeListener(this.mAdjustViewLayoutChangeListener);
            this.mAdjustView = null;
        }
        this.mRootView = null;
        TemplateEditorPresenter templateEditorPresenter = this.mPresenter;
        if (templateEditorPresenter != null) {
            templateEditorPresenter.close();
            this.mPresenter = null;
        }
        super.onDestroyView();
        Logger.m10999d(TAG, "onDestroyView");
    }

    public void onKeyDown(KeyEvent keyEvent) {
        this.mIsCtrlPressed = keyEvent.isCtrlPressed();
    }

    public void onKeyUp() {
        this.mIsCtrlPressed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mMenuView.onOptionsItemSelected(menuItem.getItemId()) || super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mPresenter.onSaveInstanceState(bundle);
        bundle.putBoolean(ChangeTemplateConstants.KEY_TE_ON_APPLYING, this.mOnApplying);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (this.mOnApplying || bundle == null) {
            return;
        }
        this.mPresenter.onRestoreInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.IContract.IView
    public void showProgressDialog() {
        DialogUtils.ProgressDialog progressDialog = new DialogUtils.ProgressDialog(getContext());
        this.mProgressDialog = progressDialog;
        if (progressDialog.getWindow() != null) {
            this.mProgressDialog.getWindow().setWindowAnimations(0);
        }
        this.mProgressDialog.setMessage(getResources().getString(C9086R.string.base_string_please_wait));
        this.mProgressDialog.show();
    }
}
