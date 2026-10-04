package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultNoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewSTTSummarizationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = Logger.createTag("AiMenuResultViewSTTSummarizationAdapter", AiConstants.PREFIX_TAG);
    private Context mContext;
    private STTSummarizationAdapterContract mContract;
    private List<AiMenuResultViewSTTSummarizationItem> mSummaryItemList;
    private boolean mIsTranslateMode = false;
    private Set<ViewHolder> mBoundViewHolders = new HashSet();
    private boolean mIsSelectionMode = false;
    private TreeMap<Integer, Boolean> mSelectedMap = new TreeMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "AiMenuResultViewSTTSummarizationAdapter#ViewHolder";
        CheckBox checkBox;
        LinearLayout itemLayout;
        LinearLayout summaryContainer;
        TextView summaryTime;
        TextView summaryTitle;
        LinearLayout translatedContainer;
        LinearLayout translatedParentContainer;
        TextView translatedTime;
        TextView translatedTitle;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.itemLayout = (LinearLayout) view.findViewById(C9086R.id.ai_menu_result_stt_summary_item_layout);
            this.checkBox = (CheckBox) view.findViewById(C9086R.id.ai_menu_result_stt_summary_item_checkbox);
            this.summaryTitle = (TextView) view.findViewById(C9086R.id.ai_menu_result_stt_summary_item_text_title);
            this.summaryTime = (TextView) view.findViewById(C9086R.id.ai_menu_result_stt_summary_item_text_time);
            this.translatedTitle = (TextView) view.findViewById(C9086R.id.ai_menu_result_stt_summary_translated_item_text_title);
            this.translatedTime = (TextView) view.findViewById(C9086R.id.ai_menu_result_stt_summary_translated_item_text_time);
            this.summaryContainer = (LinearLayout) view.findViewById(C9086R.id.ai_menu_result_stt_summary_item_container);
            this.translatedContainer = (LinearLayout) view.findViewById(C9086R.id.ai_menu_result_stt_summary_translated_item_container);
            this.translatedParentContainer = (LinearLayout) view.findViewById(C9086R.id.ai_menu_result_stt_summary_translated_container);
        }
    }

    public AiMenuResultViewSTTSummarizationAdapter(List<AiMenuResultViewSTTSummarizationItem> list, STTSummarizationAdapterContract sTTSummarizationAdapterContract) {
        this.mSummaryItemList = list;
        this.mContract = sTTSummarizationAdapterContract;
    }

    private static String getStringByDuration(long j, boolean z) {
        long j2 = j / 1000;
        long j3 = (j / 100) - (10 * j2);
        long j5 = j2 / 3600;
        long j6 = (j2 / 60) % 60;
        long j7 = j2 % 60;
        return z ? j5 > 0 ? String.format(Locale.getDefault(), "%02d:%02d:%02d.%d", Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j3)) : String.format(Locale.getDefault(), "%02d:%02d.%d", Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j3)) : j5 > 0 ? String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)) : String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(j6), Long.valueOf(j7));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initListener(final ViewHolder viewHolder) {
        final GestureDetector gestureDetector = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarizationAdapter.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(@NonNull MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                if (!AiMenuResultViewSTTSummarizationAdapter.this.mIsSelectionMode) {
                    return false;
                }
                AiMenuResultViewSTTSummarizationAdapter.this.toggleSelectItem(viewHolder.getBindingAdapterPosition());
                return true;
            }
        });
        ((View) viewHolder.itemLayout.getParent()).setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarizationAdapter.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AiMenuResultViewSTTSummarizationAdapter.this.mIsSelectionMode) {
                    return false;
                }
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        ((View) viewHolder.itemLayout.getParent()).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarizationAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultViewSTTSummarizationAdapter.this.mIsSelectionMode) {
                    AiMenuResultViewSTTSummarizationAdapter.this.toggleSelectItem(viewHolder.getBindingAdapterPosition());
                }
            }
        });
    }

    private boolean isItemChecked(int i) {
        TreeMap<Integer, Boolean> treeMap = this.mSelectedMap;
        if (treeMap == null) {
            return false;
        }
        return Boolean.TRUE.equals(treeMap.get(Integer.valueOf(i)));
    }

    public Set<RecyclerView.ViewHolder> getAllBoundViewHolders() {
        return Collections.unmodifiableSet(this.mBoundViewHolders);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<AiMenuResultViewSTTSummarizationItem> list = this.mSummaryItemList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getSelectedItemCount() {
        return this.mSelectedMap.size();
    }

    public boolean isSelectionMode() {
        return this.mIsSelectionMode;
    }

    public void onModeChanged(STTMode sTTMode) {
        Logger.m11003i(TAG, "onModeChanged: " + sTTMode);
        if (sTTMode == STTMode.SELECTION_SUMMARY) {
            this.mIsSelectionMode = true;
        } else {
            this.mSelectedMap.clear();
            this.mIsSelectionMode = false;
        }
        notifyDataSetChanged();
    }

    public void restoreSelectionMode(TreeMap<Integer, Boolean> treeMap) {
        this.mIsSelectionMode = true;
        this.mSelectedMap = treeMap;
        this.mContract.onSummaryItemCheckedChanged(treeMap);
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setTranslateMode(boolean z) {
        this.mIsTranslateMode = z;
        notifyDataSetChanged();
    }

    public void toggleSelectAllItems(boolean z) {
        TreeMap<Integer, Boolean> treeMap;
        if (!this.mIsSelectionMode || (treeMap = this.mSelectedMap) == null) {
            return;
        }
        if (z) {
            for (int i = 0; i < this.mSummaryItemList.size(); i++) {
                this.mSelectedMap.put(Integer.valueOf(i), Boolean.TRUE);
            }
        } else {
            treeMap.clear();
        }
        this.mContract.onSummaryItemCheckedChanged(this.mSelectedMap);
        notifyDataSetChanged();
    }

    public void toggleSelectItem(int i) {
        TreeMap<Integer, Boolean> treeMap = this.mSelectedMap;
        if (treeMap != null) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(treeMap.get(Integer.valueOf(i)))) {
                this.mSelectedMap.remove(Integer.valueOf(i));
            } else {
                this.mSelectedMap.put(Integer.valueOf(i), bool);
            }
            this.mContract.onSummaryItemCheckedChanged(this.mSelectedMap);
            notifyItemChanged(i);
        }
    }

    public void updateMarginSize(ViewHolder viewHolder) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_stt_side_margin_size);
        LinearLayout linearLayout = viewHolder.itemLayout;
        if (linearLayout != null) {
            linearLayout.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    public void updateSummaryResultMargin() {
        Iterator<ViewHolder> it = this.mBoundViewHolders.iterator();
        while (it.hasNext()) {
            updateMarginSize(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (this.mIsSelectionMode) {
            viewHolder.checkBox.setVisibility(0);
        } else {
            viewHolder.checkBox.setVisibility(8);
        }
        AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = this.mSummaryItemList.get(i);
        if (aiMenuResultViewSTTSummarizationItem.isHidden()) {
            viewHolder.itemView.setVisibility(8);
            viewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            return;
        }
        boolean zHasRtlCharacters = AiViewUtils.hasRtlCharacters(aiMenuResultViewSTTSummarizationItem.getSummaryTitle());
        viewHolder.itemView.setVisibility(0);
        viewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        viewHolder.summaryTitle.setText(aiMenuResultViewSTTSummarizationItem.getSummaryTitle());
        viewHolder.itemLayout.setLayoutDirection(zHasRtlCharacters ? 1 : 0);
        if (aiMenuResultViewSTTSummarizationItem.getSummaryLines() == null) {
            return;
        }
        if (getItemCount() < 2 || aiMenuResultViewSTTSummarizationItem.getTimeStamp() < 0) {
            viewHolder.summaryTime.setVisibility(8);
            viewHolder.translatedTime.setVisibility(8);
        } else if (aiMenuResultViewSTTSummarizationItem.isStreamCompleted() || !aiMenuResultViewSTTSummarizationItem.getSummaryLines().isEmpty()) {
            viewHolder.summaryTime.setVisibility(0);
            viewHolder.translatedTime.setVisibility(0);
        } else {
            viewHolder.summaryTime.setVisibility(8);
        }
        if (aiMenuResultViewSTTSummarizationItem.getTimeStamp() >= 0) {
            viewHolder.summaryTime.setText(getStringByDuration(aiMenuResultViewSTTSummarizationItem.getTimeStamp(), false));
            viewHolder.translatedTime.setText(getStringByDuration(aiMenuResultViewSTTSummarizationItem.getTimeStamp(), false));
        }
        viewHolder.summaryContainer.removeAllViews();
        for (int i2 = 0; i2 < aiMenuResultViewSTTSummarizationItem.getSummaryLines().size(); i2++) {
            View viewInflate = ((LayoutInflater) viewHolder.summaryContainer.getContext().getSystemService("layout_inflater")).inflate(C9086R.layout.ai_menu_result_stt_summarization_list_item_bullet, (ViewGroup) viewHolder.summaryContainer, false);
            TextView textView = (TextView) viewInflate.findViewById(C9086R.id.ai_menu_result_stt_summary_item_text);
            textView.setTextSize(0, viewInflate.getResources().getDimension(C9086R.dimen.ai_stt_view_content_text_size));
            textView.setText(aiMenuResultViewSTTSummarizationItem.getSummaryLines().get(i2));
            if (!zHasRtlCharacters) {
                zHasRtlCharacters = AiViewUtils.hasRtlCharacters(aiMenuResultViewSTTSummarizationItem.getSummaryLines().get(i2));
            }
            if (i == this.mSummaryItemList.size() - 1 && i2 == aiMenuResultViewSTTSummarizationItem.getSummaryLines().size() - 1 && aiMenuResultViewSTTSummarizationItem.isStreamCompleted()) {
                textView.append(ResultNoteManager.getWatermarkSpannableString(viewInflate.getContext()));
            }
            viewInflate.setLayoutDirection(zHasRtlCharacters ? 1 : 0);
            viewHolder.summaryContainer.addView(viewInflate);
        }
        viewHolder.translatedContainer.removeAllViews();
        if (!this.mIsTranslateMode || aiMenuResultViewSTTSummarizationItem.getTranslatedLines().isEmpty()) {
            viewHolder.translatedParentContainer.setVisibility(8);
        } else {
            boolean zHasRtlCharacters2 = AiViewUtils.hasRtlCharacters(aiMenuResultViewSTTSummarizationItem.getTranslatedTitle());
            viewHolder.translatedTitle.setText(aiMenuResultViewSTTSummarizationItem.getTranslatedTitle());
            viewHolder.translatedParentContainer.setVisibility(0);
            viewHolder.translatedParentContainer.setLayoutDirection(zHasRtlCharacters2 ? 1 : 0);
            for (int i4 = 0; i4 < aiMenuResultViewSTTSummarizationItem.getTranslatedLines().size(); i4++) {
                View viewInflate2 = ((LayoutInflater) viewHolder.summaryContainer.getContext().getSystemService("layout_inflater")).inflate(C9086R.layout.ai_menu_result_stt_summarization_list_item_bullet, (ViewGroup) viewHolder.summaryContainer, false);
                TextView textView2 = (TextView) viewInflate2.findViewById(C9086R.id.ai_menu_result_stt_summary_item_text);
                textView2.setTextSize(0, viewInflate2.getResources().getDimension(C9086R.dimen.ai_stt_view_content_text_size));
                textView2.setText(aiMenuResultViewSTTSummarizationItem.getTranslatedLines().get(i4));
                if (!zHasRtlCharacters2) {
                    zHasRtlCharacters2 = AiViewUtils.hasRtlCharacters(aiMenuResultViewSTTSummarizationItem.getTranslatedLines().get(i4));
                }
                viewInflate2.setLayoutDirection(zHasRtlCharacters2 ? 1 : 0);
                viewHolder.translatedContainer.addView(viewInflate2);
            }
        }
        View view = (View) viewHolder.itemLayout.getParent();
        if (this.mIsSelectionMode) {
            boolean zIsItemChecked = isItemChecked(i);
            viewHolder.checkBox.setChecked(zIsItemChecked);
            if (zIsItemChecked) {
                view.setBackgroundColor(ContextCompat.getColor(this.mContext, C9086R.color.ai_page_selected_item_bg_color));
            } else {
                view.setBackgroundColor(0);
            }
        } else {
            view.setBackgroundColor(0);
        }
        updateMarginSize(viewHolder);
        this.mBoundViewHolders.add(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.mContext = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(C9086R.layout.ai_result_stt_summarization_list_item, viewGroup, false));
        initListener(viewHolder);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        this.mBoundViewHolders.remove(viewHolder);
    }
}
