package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.setting;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.richtext.TextStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtStyleListPopup {
    private static final String TAG = Logger.createTag("RtStyleListPopup");
    private Context mContext;
    private View mDialogContainer;
    private boolean mIsDeleteMode;
    private PopupWindow mPopupWindow;
    private RtToolbarPresenter mPresenter;
    private PreviewItemAdapter mPreviewItemAdapter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PreviewItemAdapter extends RecyclerView.Adapter<ViewHolder> {
        List<TextStyle> itemArray;

        public /* synthetic */ PreviewItemAdapter(RtStyleListPopup rtStyleListPopup, int i) {
            this();
        }

        private void bindItemView(RelativeLayout relativeLayout, TextStyle textStyle) {
            relativeLayout.setTag(Integer.valueOf(textStyle.getIndex()));
            updateTextView((TextView) relativeLayout.findViewById(C9086R.id.preview_text), textStyle, true);
            ((TextView) relativeLayout.findViewById(C9086R.id.preview_text_font_size)).setText(textStyle.getFontSize() + " pt");
            relativeLayout.findViewById(C9086R.id.comp_rt_style_list_item_delete_btn).setVisibility(RtStyleListPopup.this.mIsDeleteMode ? 0 : 8);
            relativeLayout.setClickable(RtStyleListPopup.this.mIsDeleteMode);
            relativeLayout.setOnClickListener(getOnClickListener(RtStyleListPopup.this.mIsDeleteMode));
        }

        private View.OnClickListener getOnClickListener(boolean z) {
            if (z) {
                return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup.PreviewItemAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int iIntValue = ((Integer) view.getTag()).intValue();
                        AbstractC8014b.m7217s(iIntValue, "onClick#, pos: ", RtStyleListPopup.TAG);
                        if (PreviewItemAdapter.this.itemArray.size() == 1) {
                            ToastHelper.show(view.getContext(), "can not delete the last one text style", 0, false);
                            return;
                        }
                        for (TextStyle textStyle : PreviewItemAdapter.this.itemArray) {
                            if (textStyle.getIndex() == iIntValue) {
                                PreviewItemAdapter.this.itemArray.remove(textStyle);
                                RtStyleListPopup.this.mPreviewItemAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                    }
                };
            }
            return null;
        }

        private void updateTextView(TextView textView, TextStyle textStyle, boolean z) {
            if (textView == null) {
                return;
            }
            textView.setText("Preview Text");
            ViewCompat.getInstance().setAutoHandwritingEnabled(textView, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) textView.getText().toString());
            int length = spannableStringBuilder.length();
            if (textStyle.isBold()) {
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, length, 33);
            }
            if (textStyle.isItalic()) {
                spannableStringBuilder.setSpan(new StyleSpan(2), 0, length, 33);
            }
            if (textStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, length, 33);
            }
            if (textStyle.isStrikethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), 0, length, 33);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(textStyle.getFontColor()), 0, length, 33);
            if (!z) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(textStyle.getFontSize()), 0, length, 33);
                spannableStringBuilder.setSpan(new BackgroundColorSpan(textStyle.getFontBgColor()), 0, length, 33);
            }
            textView.setText(spannableStringBuilder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<TextStyle> list = this.itemArray;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public List<TextStyle> getItems() {
            return this.itemArray;
        }

        public void init(List<TextStyle> list) {
            this.itemArray.addAll(list);
        }

        private PreviewItemAdapter() {
            this.itemArray = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            TextStyle textStyle = this.itemArray.get(i);
            if (textStyle == null) {
                return;
            }
            bindItemView((RelativeLayout) viewHolder.itemView, textStyle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return RtStyleListPopup.this.new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_rt_style_item_layout, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public RtStyleListPopup(Context context) {
        this.mContext = context;
    }

    private void dismissSubPopup() {
    }

    private void initAdapter(List<TextStyle> list, View view) {
        PreviewItemAdapter previewItemAdapter = new PreviewItemAdapter(this, 0);
        this.mPreviewItemAdapter = previewItemAdapter;
        previewItemAdapter.init(list);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C9086R.id.item_recycler_view);
        recyclerView.setAdapter(this.mPreviewItemAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMode(boolean z) {
        PreviewItemAdapter previewItemAdapter;
        if (this.mIsDeleteMode) {
            this.mDialogContainer.findViewById(C9086R.id.close_btn).setVisibility(8);
            this.mDialogContainer.findViewById(C9086R.id.delete_style_btn).setVisibility(8);
            this.mDialogContainer.findViewById(C9086R.id.delete_done_style_btn).setVisibility(0);
            this.mDialogContainer.findViewById(C9086R.id.add_style_btn).setVisibility(8);
        } else {
            this.mDialogContainer.findViewById(C9086R.id.close_btn).setVisibility(0);
            this.mDialogContainer.findViewById(C9086R.id.delete_style_btn).setVisibility(0);
            this.mDialogContainer.findViewById(C9086R.id.delete_done_style_btn).setVisibility(8);
            this.mDialogContainer.findViewById(C9086R.id.add_style_btn).setVisibility(8);
        }
        if (!z || (previewItemAdapter = this.mPreviewItemAdapter) == null) {
            return;
        }
        previewItemAdapter.notifyDataSetChanged();
    }

    public void dismiss() {
        Logger.m11003i(TAG, "dismiss()");
        dismissSubPopup();
        this.mPopupWindow.dismiss();
    }

    public void init(RtToolbarPresenter rtToolbarPresenter, List<TextStyle> list) {
        this.mDialogContainer = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_rt_style_list_popup, (ViewGroup) null);
        this.mPresenter = rtToolbarPresenter;
        PopupWindow popupWindow = new PopupWindow(this.mDialogContainer, -2, -2);
        this.mPopupWindow = popupWindow;
        OptionMenuPopupWindowHelper.setDefaultState(popupWindow, this.mDialogContainer.getContext());
        this.mDialogContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RtStyleListPopup.this.mDialogContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                RtStyleListPopup.this.mDialogContainer.requestFocus();
            }
        });
        initAdapter(list, this.mPopupWindow.getContentView());
        this.mDialogContainer.findViewById(C9086R.id.close_btn).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RtStyleListPopup.this.dismiss();
            }
        });
        this.mDialogContainer.findViewById(C9086R.id.delete_style_btn).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RtStyleListPopup.this.mIsDeleteMode = true;
                RtStyleListPopup.this.updateMode(true);
            }
        });
        this.mDialogContainer.findViewById(C9086R.id.delete_done_style_btn).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RtStyleListPopup.this.mIsDeleteMode = false;
                RtStyleListPopup.this.updateMode(true);
                if (RtStyleListPopup.this.mPresenter.getRtTextStylePresenter().saveData(RtStyleListPopup.this.mPreviewItemAdapter.getItems())) {
                    ToastHelper.show(view.getContext(), "saved text styles", 0, false);
                    RtStyleListPopup.this.mPresenter.updateTextStyles();
                }
            }
        });
        this.mDialogContainer.findViewById(C9086R.id.add_style_btn).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        updateMode(false);
    }

    public boolean isShowing() {
        boolean zIsShowing = this.mPopupWindow.isShowing();
        AbstractC8014b.m7220v("isShowing() : ", TAG, zIsShowing);
        return zIsShowing;
    }

    public void setTitle(@StringRes int i) {
        ((TextView) this.mDialogContainer.findViewById(C9086R.id.dialog_title)).setText(i);
    }

    public void show(View view) {
        Logger.m10999d(TAG, "show()");
        this.mPopupWindow.getContentView().measure(0, 0);
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(view.getContext(), 12.0f);
        int height = view.getHeight() + iConvertDpToPixel;
        if ((rect.height() / 2) + rect.top < rect2.top) {
            height = (this.mPopupWindow.getContentView().getMeasuredHeight() + iConvertDpToPixel) * (-1);
        }
        this.mPopupWindow.showAsDropDown(view, (view.getWidth() - this.mPopupWindow.getContentView().getMeasuredWidth()) / 2, height);
        this.mPopupWindow.getContentView().requestFocus();
    }
}
