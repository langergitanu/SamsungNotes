package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SeslSeekBar;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.IContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.TemplateEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.C9884a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.TEAdjustPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.zoom.IZoomMenuView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.zoom.TEZoomPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.TemplateNameDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.TemplateEditorView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.animation.SeekBarProgressAnimation;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEMenuView implements IZoomMenuView {
    private static final float LANDSCAPE_MENU_WIDTH_RATIO = 0.5f;
    private static final float PORTRAIT_MENU_HEIGHT_RATIO = 0.2f;
    private static final float PORTRAIT_PHONE_POPUP_MENU_HEIGHT_RATIO = 0.4f;
    private static final String TAG = CTLogger.createTag("TEMenuView");
    private TEAdjustPresenter mAdjustPresenter;
    private Button mCancelBtn;
    private Context mContext;
    private Button mDoneBtn;
    private boolean mIsTracking;
    private ViewGroup mMenuLayout;
    private final View.OnTouchListener mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (TEMenuView.this.mProgressAnimation != null) {
                TEMenuView.this.mProgressAnimation.setOnTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action != 0 && action != 211) {
                return false;
            }
            view.performClick();
            return true;
        }
    };
    private TextView mOpacityTitle;
    private IContract.IView mParentView;
    private TextView mPercentText;
    private SeekBarProgressAnimation mProgressAnimation;
    private SeslSeekBar mSeekBar;
    private ImageView mZoomInBtn;
    private ImageView mZoomOutBtn;
    private final TEZoomPresenter mZoomPresenter;

    public TEMenuView(IContract.IView iView, TemplateEditorPresenter templateEditorPresenter) {
        this.mContext = iView.getRootView().getContext();
        this.mParentView = iView;
        templateEditorPresenter.getModel().getAdjustModel().addOpacityListener(new C9884a(this, 1));
        this.mAdjustPresenter = templateEditorPresenter.getAdjustPresenter();
        TEZoomPresenter zoomPresenter = templateEditorPresenter.getZoomPresenter();
        this.mZoomPresenter = zoomPresenter;
        zoomPresenter.attachView(this);
        this.mMenuLayout = (ViewGroup) iView.getRootView().findViewById(C9086R.id.te_menu_layout);
        initSeekBar();
        if (this.mContext.getResources().getConfiguration().orientation == 1) {
            initPortraitLayout();
        } else {
            initLandscapeLayout();
        }
    }

    private float getPopupWindowHeightRatio() {
        if (DeviceUtils.isTabletModel()) {
            return this.mContext.getResources().getInteger(C9086R.integer.template_editor_menu_height_ratio) / 100.0f;
        }
        return 0.4f;
    }

    private void initBottomButtonLayout() {
        Button button = (Button) this.mParentView.getRootView().findViewById(C9086R.id.te_done);
        this.mDoneBtn = button;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TEMenuView.this.onDoneBtnClicked();
                }
            });
            CharUtils.applyTextSizeUntilLargeSize(this.mContext, this.mDoneBtn, 18.0f);
            ButtonShapeUtil.setButtonShapeEnabled(this.mDoneBtn);
        }
        Button button2 = (Button) this.mParentView.getRootView().findViewById(C9086R.id.te_cancel);
        this.mCancelBtn = button2;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TEMenuView.this.onCancelBtnClicked();
                }
            });
            CharUtils.applyTextSizeUntilLargeSize(this.mContext, this.mCancelBtn, 18.0f);
            ButtonShapeUtil.setButtonShapeEnabled(this.mCancelBtn);
        }
    }

    private void initLandscapeLayout() {
        initZoomInOutLayout();
        updateMenuLayoutWidth();
    }

    private void initPortraitLayout() {
        updatePortraitLayout();
        initBottomButtonLayout();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initSeekBar() {
        SeslSeekBar seslSeekBar = (SeslSeekBar) this.mParentView.getRootView().findViewById(C9086R.id.template_editor_opacity_seekbar);
        this.mSeekBar = seslSeekBar;
        seslSeekBar.setProgress(this.mAdjustPresenter.getOpacity());
        this.mSeekBar.setOnTouchListener(this.mOnTouchListener);
        this.mSeekBar.setOnKeyListener(new View.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 21 || i == 22) {
                    if (keyEvent.getAction() == 0) {
                        TEMenuView.this.mIsTracking = true;
                        return false;
                    }
                    if (keyEvent.getAction() == 1) {
                        AbstractC0000a.m3D(i, "onKey() ACTION_UP ", TEMenuView.TAG);
                        TEMenuView.this.mIsTracking = false;
                    }
                }
                return false;
            }
        });
        this.mSeekBar.setOnSeekBarChangeListener(new SeslSeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.6
            private void updateOpacity(int i) {
                if (TEMenuView.this.mAdjustPresenter != null) {
                    TEMenuView.this.mAdjustPresenter.updateOpacity(i);
                }
            }

            @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeslSeekBar seslSeekBar2, int i, boolean z) {
                if (!z || TEMenuView.this.mProgressAnimation.isDragging()) {
                    updateOpacity(i);
                } else {
                    TEMenuView.this.mProgressAnimation.setStartProgress(TEMenuView.this.mAdjustPresenter.getOpacity());
                    TEMenuView.this.mProgressAnimation.setTarget(z, TEMenuView.this.mIsTracking, i);
                }
            }

            @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeslSeekBar seslSeekBar2) {
                Logger.m10999d(TEMenuView.TAG, "onStartTrackTouch()");
                TEMenuView.this.mIsTracking = true;
            }

            @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeslSeekBar seslSeekBar2) {
                Logger.m10999d(TEMenuView.TAG, "onStopTrackingTouch()");
                TEMenuView.this.mIsTracking = false;
            }
        });
        this.mProgressAnimation = new SeekBarProgressAnimation(this.mSeekBar);
        TextView textView = (TextView) this.mParentView.getRootView().findViewById(C9086R.id.opacity_title);
        this.mOpacityTitle = textView;
        CharUtils.applyTextSizeUntilLargeSize(this.mContext, textView, 18.0f);
        TextView textView2 = (TextView) this.mParentView.getRootView().findViewById(C9086R.id.template_editor_opacity_percent);
        this.mPercentText = textView2;
        CharUtils.applyTextSizeUntilLargeSize(this.mContext, textView2, 14.0f);
        CharUtils.applyTextSizeUntilLargeSize(this.mContext, (TextView) this.mParentView.getRootView().findViewById(C9086R.id.template_editor_opacity_percent_fixed), 14.0f);
        setPercentText();
        setContentDescriptionForOpacity();
    }

    private void initZoomInOutLayout() {
        ViewStub viewStub;
        if (!DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mContext) || (viewStub = (ViewStub) this.mParentView.getRootView().findViewById(C9086R.id.te_zoom_menu_viewstub)) == null) {
            return;
        }
        viewStub.setVisibility(0);
        ColorStateList colorStateList = this.mContext.getResources().getColorStateList(C9086R.color.template_editor_zoom_btn_color, null);
        ImageView imageView = (ImageView) this.mParentView.getRootView().findViewById(C9086R.id.te_zoom_in_button);
        this.mZoomInBtn = imageView;
        imageView.setImageTintList(colorStateList);
        this.mZoomInBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TEMenuView.this.mZoomPresenter != null) {
                    TEMenuView.this.mZoomPresenter.zoomIn();
                }
            }
        });
        ImageView imageView2 = (ImageView) this.mParentView.getRootView().findViewById(C9086R.id.te_zoom_out_button);
        this.mZoomOutBtn = imageView2;
        imageView2.setImageTintList(colorStateList);
        this.mZoomOutBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TEMenuView.this.mZoomPresenter != null) {
                    TEMenuView.this.mZoomPresenter.zoomOut();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancelBtnClicked() {
        if (!TEButtonChecker.isExecutable() || this.mAdjustPresenter == null) {
            return;
        }
        this.mParentView.finish(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDoneBtnClicked() {
        String resultPath = this.mAdjustPresenter.getNewPath().isEmpty() ? this.mAdjustPresenter.getResultPath() : this.mAdjustPresenter.getNewPath();
        TemplateNameDialog templateNameDialog = new TemplateNameDialog(this.mContext, FileUtils.getFileNameFromFilePath(resultPath), resultPath, false);
        templateNameDialog.setEditDialogResultListener(createTemplateEditDialogResult());
        if (this.mContext instanceof AppCompatActivity) {
            templateNameDialog.show(((TemplateEditorView) this.mParentView).getChildFragmentManager());
        }
    }

    private void setContentDescriptionForOpacity() {
        this.mSeekBar.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.8
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setContentDescription(TEMenuView.this.mSeekBar.getResources().getText(C9086R.string.template_editor_image_opacity));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPercentText() {
        TextView textView = this.mPercentText;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(this.mAdjustPresenter.getOpacity())));
        }
    }

    private void updateMenuLayoutHeight() {
        int totalHeight = (int) (this.mParentView.getTotalHeight() * (this.mParentView.isMultiWindowMode() ? getPopupWindowHeightRatio() : 0.2f));
        ViewGroup.LayoutParams layoutParams = this.mMenuLayout.getLayoutParams();
        layoutParams.height = totalHeight;
        this.mMenuLayout.setLayoutParams(layoutParams);
    }

    private void updateMenuLayoutWidth() {
        ViewGroup.LayoutParams layoutParams = this.mMenuLayout.getLayoutParams();
        layoutParams.width = (int) (this.mContext.getResources().getDisplayMetrics().widthPixels * 0.5f);
        this.mMenuLayout.setLayoutParams(layoutParams);
    }

    private void updateOpacitySeekbarParentMargins() {
        boolean z = DeviceUtils.isTabletModel() && !this.mParentView.isMultiWindowMode();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(z ? C9086R.dimen.template_editor_tablet_opacity_seekbar_start_margin : C9086R.dimen.template_editor_opacity_seekbar_start_margin);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(z ? C9086R.dimen.template_editor_tablet_opacity_layout_side_margin : C9086R.dimen.template_editor_opacity_layout_side_margin);
        RelativeLayout relativeLayout = (RelativeLayout) this.mParentView.getRootView().findViewById(C9086R.id.template_editor_opacity_seekbar_parent);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        marginLayoutParams.setMarginEnd(dimensionPixelSize2);
        relativeLayout.setLayoutParams(marginLayoutParams);
    }

    private void updateOpacityTitleMargins() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize((!DeviceUtils.isTabletModel() || this.mParentView.isMultiWindowMode()) ? C9086R.dimen.template_editor_opacity_layout_side_margin : C9086R.dimen.template_editor_tablet_opacity_layout_side_margin);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mOpacityTitle.getLayoutParams();
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        marginLayoutParams.setMarginEnd(dimensionPixelSize);
        this.mOpacityTitle.setLayoutParams(marginLayoutParams);
    }

    private void updatePortraitLayout() {
        updateMenuLayoutHeight();
        updateOpacityTitleMargins();
        updateOpacitySeekbarParentMargins();
    }

    public ITemplateEditDialogResult createTemplateEditDialogResult() {
        return new ITemplateEditDialogResult() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.menu.TEMenuView.9
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
            public void onEditDialogDismiss(String str) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
            public void onEditDialogResult(@Nullable String str) {
                if (!TEButtonChecker.isExecutable() || TEMenuView.this.mAdjustPresenter == null) {
                    return;
                }
                TEMenuView.this.mAdjustPresenter.setTemplateName(str);
                TEMenuView.this.mParentView.onApply();
                TEMenuView.this.mAdjustPresenter.apply();
            }
        };
    }

    public void onConfigurationChanged(Configuration configuration) {
        AbstractC8014b.m7195A(new StringBuilder("onConfigurationChanged, orientation : "), TAG, configuration.orientation);
        if (configuration.orientation == 1) {
            updatePortraitLayout();
        } else {
            updateMenuLayoutWidth();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            menuInflater.inflate(C9086R.menu.template_editor_menu, menu);
        }
    }

    public boolean onOptionsItemSelected(int i) {
        if (i == C9086R.id.te_done) {
            onDoneBtnClicked();
            return true;
        }
        if (i != C9086R.id.te_cancel && i != 16908332) {
            return false;
        }
        onCancelBtnClicked();
        return true;
    }

    public void release() {
        Button button = this.mDoneBtn;
        if (button != null) {
            button.setOnClickListener(null);
            this.mDoneBtn = null;
        }
        Button button2 = this.mCancelBtn;
        if (button2 != null) {
            button2.setOnClickListener(null);
            this.mCancelBtn = null;
        }
        ImageView imageView = this.mZoomInBtn;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.mZoomInBtn = null;
        }
        ImageView imageView2 = this.mZoomOutBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
            this.mZoomOutBtn = null;
        }
        this.mOpacityTitle = null;
        this.mMenuLayout = null;
        this.mParentView = null;
        this.mAdjustPresenter = null;
        this.mContext = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.zoom.IZoomMenuView
    public void update(boolean z, boolean z2) {
        ImageView imageView = this.mZoomInBtn;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        ImageView imageView2 = this.mZoomOutBtn;
        if (imageView2 != null) {
            imageView2.setEnabled(z2);
        }
    }
}
