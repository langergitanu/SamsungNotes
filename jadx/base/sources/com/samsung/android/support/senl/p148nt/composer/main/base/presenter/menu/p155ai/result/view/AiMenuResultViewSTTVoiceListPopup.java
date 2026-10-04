package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSelectTranscribeDialogFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({WarningType.NewApi})
public class AiMenuResultViewSTTVoiceListPopup {
    private Context mContext;
    private OnPopupListener mPopupListener;
    private PopupWindow mPopupWindow;
    private OnSelectListener mSelectVoiceItemListener;
    private View mView;
    private List<SpenVoiceData> mVoiceDataList = new ArrayList();
    private PopupVoiceItemAdapter mVoiceItemAdapter;
    private RecyclerView mVoiceItemRecyclerView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPopupListener {
        void onDismiss();

        void onShow();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSelectListener {
        void onSelectVoiceItem(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PopupVoiceItemAdapter extends STTSelectTranscribeDialogFragment.VoiceItemAdapter {
        public PopupVoiceItemAdapter(STTSelectTranscribeDialogFragment.AdapterContract adapterContract) {
            super(adapterContract);
        }

        @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTSelectTranscribeDialogFragment.VoiceItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull STTSelectTranscribeDialogFragment.ViewHolder viewHolder, int i) {
            super.onBindViewHolder(viewHolder, i);
            viewHolder.mRadioButton.setVisibility(8);
            viewHolder.itemView.setBackgroundResource(C9086R.drawable.comp_ripple_effect);
            viewHolder.itemView.setPadding((int) ResourceUtils.convertDpToPixel(viewHolder.itemView.getContext(), 18.0f), (int) ResourceUtils.convertDpToPixel(viewHolder.itemView.getContext(), i == 0 ? 10 : 6), (int) ResourceUtils.convertDpToPixel(viewHolder.itemView.getContext(), 24.0f), (int) ResourceUtils.convertDpToPixel(viewHolder.itemView.getContext(), i != getItemCount() + (-1) ? 6 : 10));
        }

        @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTSelectTranscribeDialogFragment.VoiceItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public STTSelectTranscribeDialogFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return super.onCreateViewHolder(viewGroup, i);
        }
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) this.mView.findViewById(C9086R.id.select_transcribe_recyclerview);
        this.mVoiceItemRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        PopupVoiceItemAdapter popupVoiceItemAdapter = new PopupVoiceItemAdapter(new STTSelectTranscribeDialogFragment.AdapterContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTVoiceListPopup.1
            @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTSelectTranscribeDialogFragment.AdapterContract
            public void onSelectItem(int i) {
                if (AiMenuResultViewSTTVoiceListPopup.this.mSelectVoiceItemListener != null) {
                    AiMenuResultViewSTTVoiceListPopup.this.mSelectVoiceItemListener.onSelectVoiceItem(i);
                }
            }
        });
        this.mVoiceItemAdapter = popupVoiceItemAdapter;
        popupVoiceItemAdapter.setVoiceDataList(this.mVoiceDataList);
        this.mVoiceItemRecyclerView.setAdapter(this.mVoiceItemAdapter);
    }

    private void initWindow() {
        PopupWindow popupWindow = new PopupWindow(this.mView, -2, -2);
        this.mPopupWindow = popupWindow;
        popupWindow.setTouchable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setClippingEnabled(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setInputMethodMode(2);
        this.mPopupWindow.setOverlapAnchor(true);
        this.mPopupWindow.setBackgroundDrawable(this.mContext.getDrawable(C9086R.drawable.ai_menu_toolbar_bg));
        this.mPopupWindow.setElevation(8.0f);
        this.mPopupWindow.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTVoiceListPopup.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AiMenuResultViewSTTVoiceListPopup.this.mPopupListener != null) {
                    AiMenuResultViewSTTVoiceListPopup.this.mPopupListener.onDismiss();
                }
            }
        });
    }

    public void hide() {
        if (this.mPopupWindow == null) {
            return;
        }
        OnPopupListener onPopupListener = this.mPopupListener;
        if (onPopupListener != null) {
            onPopupListener.onDismiss();
        }
        this.mPopupWindow.dismiss();
    }

    public void init(Context context, List<SpenVoiceData> list, OnSelectListener onSelectListener) {
        this.mContext = context;
        this.mVoiceDataList = list;
        this.mSelectVoiceItemListener = onSelectListener;
        this.mView = View.inflate(context, C9086R.layout.ai_menu_result_stt_select_transcribe_popup_layout, null);
        initView();
        initWindow();
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    public void setPopupListener(OnPopupListener onPopupListener) {
        this.mPopupListener = onPopupListener;
    }

    public void show(View view) {
        if (isShowing()) {
            hide();
        }
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.getContentView().measure(0, 0);
        view.getGlobalVisibleRect(new Rect());
        this.mPopupWindow.showAsDropDown(view, 0, view.getHeight());
        this.mVoiceItemAdapter.notifyDataSetChanged();
        OnPopupListener onPopupListener = this.mPopupListener;
        if (onPopupListener != null) {
            onPopupListener.onShow();
        }
    }
}
