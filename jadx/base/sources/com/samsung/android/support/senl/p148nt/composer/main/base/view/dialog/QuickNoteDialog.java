package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.SuggestionViewWrapper;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QuickNoteDialog implements DialogContract.IQuickNoteDialog {
    private static final String TAG = Logger.createTag("QuickNoteDialog");
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsHiding;
    private boolean mIsTabletLayout;
    private ItemAdapter mItemAdapter;
    private SuggestionViewWrapper mMenuView;
    private OnLayoutChangeListenerImpl mOnLayoutChangeListener;
    private PopupWindow mPopupWindow;
    private Runnable mPostShowPopupRunnable;
    private final QuickNoteDialogPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItemAdapter extends BaseAdapter {
        private List<Drawable> mItemList = new ArrayList(1);

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mItemList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mItemList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_quick_note_selection_menu_item, viewGroup, false);
            }
            ImageView imageView = (ImageView) view.findViewById(C9086R.id.quick_note_selection_menu_item_thumbnail);
            imageView.setImageDrawable(this.mItemList.get(i));
            imageView.setClipToOutline(true);
            AbstractC0000a.m3D(i, "position# ", QuickNoteDialog.TAG);
            return view;
        }

        public void setItemList(List<Drawable> list) {
            this.mItemList = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnLayoutChangeListenerImpl implements View.OnLayoutChangeListener {
        public /* synthetic */ OnLayoutChangeListenerImpl(QuickNoteDialog quickNoteDialog, int i) {
            this();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (QuickNoteDialog.this.isShowing() && i4 - i != i8 - i6) {
                int i10 = QuickNoteDialog.this.mMenuView.getLayoutParams().width;
                QuickNoteDialog quickNoteDialog = QuickNoteDialog.this;
                int adjustedWidth = quickNoteDialog.getAdjustedWidth(quickNoteDialog.mPresenter.getActivity(), (View) QuickNoteDialog.this.mMenuView.getParent());
                if (i10 != adjustedWidth) {
                    ViewGroup.LayoutParams layoutParams = QuickNoteDialog.this.mMenuView.getLayoutParams();
                    QuickNoteDialog.this.mMenuView.getLayoutParams().width = adjustedWidth;
                    QuickNoteDialog.this.mMenuView.setLayoutParams(layoutParams);
                }
                if (QuickNoteDialog.this.mPopupWindow == null || !QuickNoteDialog.this.mPopupWindow.isShowing()) {
                    return;
                }
                QuickNoteDialog.this.mPopupWindow.dismiss();
            }
        }

        private OnLayoutChangeListenerImpl() {
        }
    }

    public QuickNoteDialog(QuickNoteDialogPresenter quickNoteDialogPresenter) {
        this.mPresenter = quickNoteDialogPresenter;
    }

    private void addLayoutChangeListener() {
        if (this.mMenuView == null) {
            return;
        }
        if (this.mOnLayoutChangeListener == null) {
            this.mOnLayoutChangeListener = new OnLayoutChangeListenerImpl(this, 0);
        }
        ((ViewGroup) this.mMenuView.getParent()).addOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    private void cancelHideAnimationByDismiss() {
        if (this.mIsHiding) {
            this.mMenuView.animate().cancel();
            this.mMenuView.setAlpha(1.0f);
        }
    }

    private void clearListener() {
        SuggestionViewWrapper suggestionViewWrapper = this.mMenuView;
        if (suggestionViewWrapper == null) {
            Logger.m10999d(TAG, "clearListener# view is null");
            return;
        }
        suggestionViewWrapper.setOnButtonClickListener(null);
        this.mMenuView.setOnExpiredListener(null);
        this.mMenuView.setOnSwipeDismissListener(null);
    }

    private void clearShowPopupRunnable() {
        Runnable runnable = this.mPostShowPopupRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mPostShowPopupRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAdjustedWidth(Activity activity, View view) {
        int width = view.getWidth();
        float dimensionPixelSize = activity.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_window_side_margin) * 2;
        float dimensionPixelSize2 = activity.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_window_max_width);
        if (width - dimensionPixelSize <= dimensionPixelSize2) {
            return -1;
        }
        return (int) dimensionPixelSize2;
    }

    private Point getOffset(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Point point = new Point();
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_elevation);
        point.x = iArr[0] + view.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_window_side_margin);
        point.y = (iArr[1] - ((this.mItemAdapter.getCount() - 1) * this.mMenuView.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_window_height))) + dimensionPixelSize;
        return point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickEvent(@NonNull SuggestionInfo suggestionInfo, int i) {
        if (i == C9086R.id.quick_note_link_button) {
            if (this.mIsHiding) {
                Logger.m11004w(TAG, "onClickLink# called during hiding");
                return;
            } else {
                this.mPresenter.addLink(suggestionInfo);
                dismiss();
                return;
            }
        }
        if (i == C9086R.id.quick_note_content_button) {
            if (this.mIsHiding) {
                Logger.m11004w(TAG, "onClickContent# called during hiding");
                return;
            } else {
                this.mPresenter.addContent(suggestionInfo);
                dismiss();
                return;
            }
        }
        if (i == C9086R.id.quick_note_selection_menu_btn && this.mPresenter.hasCollapsedIcons()) {
            clearShowPopupRunnable();
            if (!hideSoftInput()) {
                showPopupWindow();
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.QuickNoteDialog.4
                @Override // java.lang.Runnable
                public void run() {
                    QuickNoteDialog.this.mPostShowPopupRunnable = null;
                    QuickNoteDialog.this.showPopupWindow();
                }
            };
            this.mPostShowPopupRunnable = runnable;
            this.mHandler.postDelayed(runnable, 500L);
        }
    }

    private boolean hideSoftInput() {
        if (this.mIsTabletLayout || this.mMenuView.getResources().getConfiguration().orientation != 2 || !this.mPresenter.isInputMethodShown()) {
            return false;
        }
        this.mPresenter.hideSoftInput();
        return true;
    }

    private List<Integer> initButton(RemoteViews remoteViews) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(C9086R.id.quick_note_link_button));
        arrayList.add(Integer.valueOf(C9086R.id.quick_note_content_button));
        if (this.mPresenter.isEnabledLinkButton()) {
            remoteViews.setViewVisibility(C9086R.id.quick_note_link_button, 0);
        } else {
            remoteViews.setViewVisibility(C9086R.id.quick_note_link_button, 8);
        }
        if (this.mPresenter.isEnabledContentButton()) {
            remoteViews.setViewVisibility(C9086R.id.quick_note_content_button, 0);
            remoteViews.setTextViewText(C9086R.id.quick_note_content_button, this.mMenuView.getContext().getString(this.mPresenter.getContentButtonStr()));
        } else {
            remoteViews.setViewVisibility(C9086R.id.quick_note_content_button, 8);
        }
        if (!this.mPresenter.hasCollapsedIcons()) {
            remoteViews.setViewVisibility(C9086R.id.quick_note_selection_menu_arrow, 8);
            return arrayList;
        }
        arrayList.add(Integer.valueOf(C9086R.id.quick_note_selection_menu_btn));
        remoteViews.setViewVisibility(C9086R.id.quick_note_selection_menu_arrow, 0);
        return arrayList;
    }

    private void initListener() {
        this.mMenuView.setOnButtonClickListener(new SuggestionViewWrapper.OnButtonClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.QuickNoteDialog.1
            @Override // com.samsung.android.support.senl.nt.model.contextawareness.SuggestionViewWrapper.OnButtonClickListener
            public void onClick(@NonNull SuggestionInfo suggestionInfo, int i) {
                Logger.m10999d(QuickNoteDialog.TAG, "onClick# " + suggestionInfo + " | " + i);
                QuickNoteDialog.this.handleClickEvent(suggestionInfo, i);
            }
        });
        this.mMenuView.setOnExpiredListener(new SuggestionViewWrapper.OnExpiredListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.QuickNoteDialog.2
            @Override // com.samsung.android.support.senl.nt.model.contextawareness.SuggestionViewWrapper.OnExpiredListener
            public void onExpired(@NonNull String str) {
                AbstractC8014b.m7196B("onExpired# ", str, QuickNoteDialog.TAG);
                QuickNoteDialog.this.dismiss();
            }
        });
        this.mMenuView.setOnSwipeDismissListener(new SuggestionViewWrapper.OnSwipeDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.QuickNoteDialog.3
            @Override // com.samsung.android.support.senl.nt.model.contextawareness.SuggestionViewWrapper.OnSwipeDismissListener
            public void onDismiss() {
                QuickNoteDialog.this.mPresenter.onCancel();
                QuickNoteDialog.this.onDismiss("OnSwipeDismissListener");
            }
        });
    }

    private void initMenu() {
        Activity activity = this.mPresenter.getActivity();
        SuggestionViewWrapper suggestionViewWrapper = (SuggestionViewWrapper) activity.findViewById(C9086R.id.quick_note_menu);
        this.mMenuView = suggestionViewWrapper;
        suggestionViewWrapper.setVisibility(0);
        initListener();
        initRemoteView();
        int adjustedWidth = getAdjustedWidth(activity, (View) this.mMenuView.getParent());
        if (this.mMenuView.getLayoutParams().width != adjustedWidth) {
            this.mMenuView.getLayoutParams().width = adjustedWidth;
        }
        initSelectionMenu(this.mMenuView);
        this.mMenuView.setSuggestionViewVisibility(0);
    }

    private void initRemoteView() {
        Bitmap bitmap;
        RemoteViews remoteViews = new RemoteViews(this.mMenuView.getContext().getPackageName(), C9086R.layout.comp_quick_note_layout);
        Drawable icon = this.mPresenter.getIcon();
        if (icon instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) icon).getBitmap();
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Path path = new Path();
            path.addOval(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), Path.Direction.CCW);
            canvas.clipPath(path);
            icon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            icon.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        remoteViews.setImageViewIcon(C9086R.id.quick_note_selection_menu_thumbnail, Icon.createWithBitmap(bitmap));
        this.mMenuView.updateSuggestionView(this.mPresenter.getContextAwarenessResult(), remoteViews, initButton(remoteViews), Collections.singletonList(this.mPresenter.getSelectedItemId()), this.mPresenter.getExcludedIds(), this.mMenuView.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_window_container_height));
    }

    private void initSelectionMenu(View view) {
        ListView listView = (ListView) View.inflate(view.getContext(), C9086R.layout.comp_quick_note_selection_menu_layout, null);
        PopupWindow popupWindow = new PopupWindow(listView, -2, -2);
        this.mPopupWindow = popupWindow;
        popupWindow.setWidth(view.getResources().getDimensionPixelSize(C9086R.dimen.quick_note_list_width));
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setInputMethodMode(2);
        this.mPopupWindow.setBackgroundDrawable(view.getContext().getDrawable(C9086R.drawable.quick_note_menu_bg));
        this.mPopupWindow.setElevation(12.0f);
        this.mPopupWindow.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
        this.mPopupWindow.setOverlapAnchor(true);
        ItemAdapter itemAdapter = new ItemAdapter();
        this.mItemAdapter = itemAdapter;
        itemAdapter.setItemList(this.mPresenter.getIconList());
        listView.setAdapter((ListAdapter) this.mItemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.QuickNoteDialog.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                AbstractC0000a.m3D(i, "onItemClick# ", QuickNoteDialog.TAG);
                QuickNoteDialog.this.mPresenter.onItemSelected(i);
                QuickNoteDialog.this.mPopupWindow.dismiss();
            }
        });
        this.mIsTabletLayout = ResourceUtils.isTabletLayout(this.mPresenter.getActivity());
        updateSelectionMenu();
    }

    private void removeLayoutChangeListener() {
        SuggestionViewWrapper suggestionViewWrapper = this.mMenuView;
        if (suggestionViewWrapper == null || this.mOnLayoutChangeListener == null) {
            return;
        }
        ((ViewGroup) suggestionViewWrapper.getParent()).removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    private void runHideAnimationByDismiss(View view) {
        Logger.m10999d(TAG, "runHideAnimationByDismiss#");
        this.mIsHiding = true;
        view.animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.QuickNoteDialog.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                QuickNoteDialog.this.mIsHiding = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (QuickNoteDialog.this.mMenuView != null) {
                    QuickNoteDialog.this.mMenuView.setAlpha(1.0f);
                }
                QuickNoteDialog.this.onDismiss("runHideAnimationByDismiss end");
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow() {
        Point offset = getOffset(this.mMenuView);
        this.mPopupWindow.showAtLocation(this.mMenuView, 0, offset.x, offset.y);
    }

    private void updateSelectionMenu() {
        if (this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
        this.mItemAdapter.setItemList(this.mPresenter.getIconList());
        this.mPopupWindow.getContentView().requestLayout();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void dismiss() {
        if (isShowing()) {
            runHideAnimationByDismiss(this.mMenuView);
            clearShowPopupRunnable();
            clearListener();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public boolean isShowing() {
        SuggestionViewWrapper suggestionViewWrapper = this.mMenuView;
        return (suggestionViewWrapper == null || !suggestionViewWrapper.isSuggestionViewVisible() || this.mIsHiding) ? false : true;
    }

    public void onDismiss(String str) {
        AbstractC8014b.m7196B("onDismiss# ", str, TAG);
        if (this.mMenuView == null) {
            return;
        }
        clearListener();
        clearShowPopupRunnable();
        removeLayoutChangeListener();
        this.mMenuView.setVisibility(8);
        this.mMenuView.setGoneState();
        this.mPresenter.onDismiss();
        this.mMenuView = null;
        this.mIsHiding = false;
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
        this.mPopupWindow = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void show() {
        if (this.mPresenter.getActivity() == null) {
            return;
        }
        this.mIsHiding = false;
        initMenu();
        cancelHideAnimationByDismiss();
        addLayoutChangeListener();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IQuickNoteDialog
    public void update() {
        cancelHideAnimationByDismiss();
        initRemoteView();
        if (this.mPopupWindow == null) {
            initSelectionMenu(this.mMenuView);
        } else {
            updateSelectionMenu();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IQuickNoteDialog
    public void dismiss(boolean z) {
        if (z) {
            cancelHideAnimationByDismiss();
            onDismiss("dismiss directly");
        } else {
            dismiss();
        }
    }
}
