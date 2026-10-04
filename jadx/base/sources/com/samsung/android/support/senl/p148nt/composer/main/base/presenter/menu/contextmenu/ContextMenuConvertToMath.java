package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ClipboardUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConvertToMath;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskConvertToMath;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuConvertToMath extends ContextMenuItem {
    private static final boolean ENABLED = true;
    private static final int MAX_OBJECT_COUNT_CONVERT_TO_MATH = 200;
    private static final String TAG = Logger.createTag("ContextMenuConvertToMath");
    private final ComposerViewPresenter mComposerViewPresenter;
    private ConvertToMathPopup mConvertToMathPopup;
    private final HwToolbarPresenter mHwToolbarPresenter;
    private final TaskController mTaskController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ConvertToMathPopup {
        private static final String TAG = Logger.createTag("ConvertToMathPopup");
        private Bitmap mBitmap;
        private Bitmap mBitmapForDialog;
        private final ComposerViewPresenter mComposerViewPresenter;
        private PopupWindow mPopupWindow;
        private String mRecognizedFormula;
        private RectF mTargetRect;
        private long mTimeShowed = 0;

        public ConvertToMathPopup(ComposerViewPresenter composerViewPresenter) {
            this.mComposerViewPresenter = composerViewPresenter;
        }

        private void convert() {
            boolean z;
            Logger.m10999d(TAG, "convert# " + this.mComposerViewPresenter.getObjectManager().getSelectedObjectList().size());
            SpenWNote doc = this.mComposerViewPresenter.getDoc();
            if (doc.isGroupingHistory()) {
                z = false;
            } else {
                doc.beginHistoryGroup();
                z = true;
            }
            Bitmap resultBitmap = getResultBitmap();
            RectF rectSelectedObjectList = this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().getRectSelectedObjectList();
            rectSelectedObjectList.bottom = ((rectSelectedObjectList.width() * resultBitmap.getHeight()) / resultBitmap.getWidth()) + rectSelectedObjectList.top;
            this.mComposerViewPresenter.getObjectManager().deleteSelectedObject();
            this.mComposerViewPresenter.getObjectManager().insertImageInBound(resultBitmap, rectSelectedObjectList);
            if (z) {
                doc.endHistoryGroup();
            }
        }

        private Drawable createGradientDrawable(Context context, int i, int i2, float f) {
            float fConvertDpToPixel = ResourceUtils.convertDpToPixel(context, 18.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(fConvertDpToPixel);
            gradientDrawable.setColor(i);
            gradientDrawable.setStroke((int) f, i2);
            return gradientDrawable;
        }

        private String getRecognizedFormula() {
            return this.mRecognizedFormula;
        }

        private Bitmap getResultBitmap() {
            return this.mBitmap;
        }

        private Bitmap getResultBitmapForDialog() {
            return this.mBitmapForDialog;
        }

        private Point getShowPosition(Context context) {
            int iMax = Math.max(this.mPopupWindow.getWidth(), context.getResources().getDimensionPixelSize(C9086R.dimen.math_convert_to_min_width));
            this.mComposerViewPresenter.getView().getGlobalVisibleRect(new Rect());
            RectF targetRect = getTargetRect();
            RectF rectF = targetRect == null ? new RectF() : this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller().convertContentRectIntoViewRect(targetRect);
            rectF.offset(r0.left, r0.top);
            int iWidth = (int) (((int) ((rectF.width() - iMax) / 2.0f)) + rectF.left);
            if (iWidth < 0) {
                iWidth = 0;
            } else if (iWidth > this.mComposerViewPresenter.getView().getWidth()) {
                iWidth = this.mComposerViewPresenter.getView().getWidth() - iMax;
            }
            return new Point(iWidth, (int) rectF.bottom);
        }

        private RectF getTargetRect() {
            return this.mTargetRect;
        }

        private void initWindow(Context context) {
            boolean z = false;
            final ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.comp_hw_convert_to_math_popup_layout, (ViewGroup) null, false);
            boolean z2 = this.mComposerViewPresenter.getBackgroundColor() == context.getResources().getColor(C9086R.color.composer_main_background_dark, null);
            if (ContextUtils.isNightMode(context)) {
                if (z2 || this.mComposerViewPresenter.isComposerViewDarkTheme()) {
                    viewGroup.findViewById(C9086R.id.background_layout).setBackground(createGradientDrawable(context, this.mComposerViewPresenter.getBackgroundThemeColor(), VUtilString.GRAY, 1.0f));
                } else {
                    viewGroup.findViewById(C9086R.id.background_layout).setBackground(createGradientDrawable(context, this.mComposerViewPresenter.getBackgroundThemeColor(), VUtilString.GRAY, 0.0f));
                    z = true;
                }
            }
            final int i = 0;
            viewGroup.findViewById(C9086R.id.close_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ ContextMenuConvertToMath.ConvertToMathPopup f6998b;

                {
                    this.f6998b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.f6998b.lambda$initWindow$0(view);
                            break;
                        case 1:
                            this.f6998b.lambda$initWindow$2(view);
                            break;
                        default:
                            this.f6998b.lambda$initWindow$3(view);
                            break;
                    }
                }
            });
            if (z) {
                ((ImageView) viewGroup.findViewById(C9086R.id.close_btn_image)).setColorFilter(-16777216);
            }
            ImageView imageView = (ImageView) viewGroup.findViewById(C9086R.id.math_image);
            imageView.setImageBitmap(getResultBitmapForDialog());
            imageView.setContentDescription(getRecognizedFormula());
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = getResultBitmapForDialog().getWidth();
            layoutParams.height = getResultBitmapForDialog().getHeight();
            imageView.setLayoutParams(layoutParams);
            final int i2 = 1;
            viewGroup.findViewById(C9086R.id.copy_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ ContextMenuConvertToMath.ConvertToMathPopup f6998b;

                {
                    this.f6998b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f6998b.lambda$initWindow$0(view);
                            break;
                        case 1:
                            this.f6998b.lambda$initWindow$2(view);
                            break;
                        default:
                            this.f6998b.lambda$initWindow$3(view);
                            break;
                    }
                }
            });
            if (z) {
                ((TextView) viewGroup.findViewById(C9086R.id.copy_text)).setTextColor(-16777216);
            }
            final int i4 = 2;
            viewGroup.findViewById(C9086R.id.convert_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ ContextMenuConvertToMath.ConvertToMathPopup f6998b;

                {
                    this.f6998b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            this.f6998b.lambda$initWindow$0(view);
                            break;
                        case 1:
                            this.f6998b.lambda$initWindow$2(view);
                            break;
                        default:
                            this.f6998b.lambda$initWindow$3(view);
                            break;
                    }
                }
            });
            if (z) {
                ((TextView) viewGroup.findViewById(C9086R.id.convert_text)).setTextColor(-16777216);
            }
            int width = this.mComposerViewPresenter.getActivity().getWindow().getDecorView().getWidth();
            int dimensionPixelSize = (viewGroup.getResources().getDimensionPixelSize(C9086R.dimen.math_convert_to_padding) * 8) + getResultBitmapForDialog().getWidth();
            int iMax = Math.max(Math.min((width * 2) / 3, dimensionPixelSize), viewGroup.getResources().getDimensionPixelSize(C9086R.dimen.nativecomposer_minwidth));
            if (this.mComposerViewPresenter.getComposerModel().isTabletLayout() || dimensionPixelSize < iMax) {
                PopupWindow popupWindow = new PopupWindow(viewGroup, -2, -2);
                this.mPopupWindow = popupWindow;
                popupWindow.setWidth(iMax);
            } else {
                this.mPopupWindow = new PopupWindow(viewGroup, -1, -2);
            }
            OptionMenuPopupWindowHelper.setDefaultState(this.mPopupWindow, viewGroup.getContext());
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConvertToMath.ConvertToMathPopup.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    viewGroup.requestFocus();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isShowing() {
            PopupWindow popupWindow = this.mPopupWindow;
            return popupWindow != null && popupWindow.isShowing();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initWindow$0(View view) {
            Logger.m10999d(TAG, "onClick# close");
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_DIALOG_CONVERT_TO_MATH_CLOSE);
            hide(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initWindow$1() {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_DIALOG_CONVERT_TO_MATH_COPY);
            ClipboardUtil.copyImageToClipboard(getResultBitmap(), Bitmap.CompressFormat.PNG);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initWindow$2(View view) {
            this.mComposerViewPresenter.getKeyguardPresenter().dismissKeyguard(this.mComposerViewPresenter.getActivity(), new RunnableC9767a(this, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initWindow$3(View view) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_DIALOG_CONVERT_TO_MATH_CONVERT);
            convert();
            hide(false);
        }

        public void hide(boolean z) {
            if (isShowing()) {
                this.mPopupWindow.dismiss();
            }
            Logger.m10999d(TAG, "hide#");
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
            Bitmap bitmap2 = this.mBitmapForDialog;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.mBitmapForDialog = null;
            }
            if (z) {
                this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().clearSelectObject();
            }
        }

        public boolean isInOneSecondTimeShowed() {
            return System.currentTimeMillis() - this.mTimeShowed < 1000;
        }

        public void setResultBitmap(Bitmap bitmap, Bitmap bitmap2, String str, RectF rectF) {
            this.mBitmap = bitmap;
            this.mBitmapForDialog = bitmap2;
            this.mRecognizedFormula = str;
            this.mTargetRect = rectF;
        }

        public void show() {
            Logger.m10999d(TAG, "show# ");
            if (isShowing()) {
                this.mPopupWindow.dismiss();
            }
            Activity activity = this.mComposerViewPresenter.getActivity();
            initWindow(activity);
            Point showPosition = getShowPosition(activity);
            this.mPopupWindow.showAtLocation(activity.getWindow().getDecorView(), 0, showPosition.x, showPosition.y);
            this.mTimeShowed = System.currentTimeMillis();
        }
    }

    public ContextMenuConvertToMath(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter, TaskController taskController) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mTaskController = taskController;
    }

    private boolean canExecuteConvertToMathWithMaxCount() {
        if (this.mComposerViewPresenter.getDoc().getSelectedObject().size() <= 200) {
            return true;
        }
        ToastHandler.show(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getQuantityString(C9086R.plurals.convert_to_math_toast_max_restriction, 200, 200), 0);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ConvertToMathPopup convertToMathPopup = this.mConvertToMathPopup;
        if (convertToMathPopup != null && convertToMathPopup.isShowing() && !this.mConvertToMathPopup.isInOneSecondTimeShowed()) {
            this.mConvertToMathPopup.hide(false);
        }
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_MATH;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.hw_toolbar_convert_to_math).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        ArrayList<SpenObjectBase> selectedObject;
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader() || this.mComposerViewPresenter.getComposerModel().getMdeInfo().isMde() || !this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing) || (selectedObject = this.mComposerViewPresenter.getDoc().getSelectedObject()) == null || selectedObject.isEmpty()) {
            return false;
        }
        Iterator<SpenObjectBase> it = selectedObject.iterator();
        while (it.hasNext()) {
            if (it.next().getType() != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m10999d(str, "executeMenu#" + this.mComposerViewPresenter.getObjectManager().getSelectedObjectList().size());
        if (!canExecuteConvertToMathWithMaxCount()) {
            Logger.m11000e(str, "executeMenu# canExecuteConvertToMathWithMaxCount false");
            return;
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_CONTEXT_MENU_CONVERT_TO_MATH);
        try {
            this.mTaskController.execute(new TaskConvertToMath(), new TaskConvertToMath.InputValues(this.mComposerViewPresenter.getObjectManager(), ((SpenComposer) this.mComposerViewPresenter.getView()).getMathManager(), this.mComposerViewPresenter.getDoc(), this.mComposerViewPresenter.isComposerViewDarkTheme()), new Task.Callback<TaskConvertToMath.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConvertToMath.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskConvertToMath.ResultValues resultValues) {
                    ToastHandler.show(ContextMenuConvertToMath.this.mActivity, C9086R.string.composer_could_not_find_any_handwriting, 1);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskConvertToMath.ResultValues resultValues) {
                    if (ContextMenuConvertToMath.this.mConvertToMathPopup != null && ContextMenuConvertToMath.this.mConvertToMathPopup.isShowing()) {
                        ContextMenuConvertToMath.this.mConvertToMathPopup.hide(false);
                    }
                    ContextMenuConvertToMath.this.mHwToolbarPresenter.offEasyWritingPad();
                    ContextMenuConvertToMath.this.mConvertToMathPopup = new ConvertToMathPopup(ContextMenuConvertToMath.this.mComposerViewPresenter);
                    ContextMenuConvertToMath.this.mConvertToMathPopup.setResultBitmap(resultValues.getResultBitmap(), resultValues.getResultBitmapForDialog(), resultValues.getRecognizedFormula(), resultValues.getTargetRect());
                    ContextMenuConvertToMath.this.mConvertToMathPopup.show();
                }
            }, false);
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("executeMenu#, e : "), TAG);
        }
    }
}
