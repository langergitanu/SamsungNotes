package com.samsung.android.support.senl.p148nt.composer.main.cover.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StyleListAdapter extends RecyclerView.Adapter<StyleViewHolder> {
    private static final String TAG = Logger.createCoverTag("StyleListAdapter");
    private final List<Pair<String, Integer>> mColorList;
    private final View mPreview;
    private PreviewContract mPreviewContract;
    private int mSelectedPosition = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PreviewContract {
        void onSelectBackground(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StyleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        String mColorId;
        private Contract mContract;
        ImageView mImageView;
        private int mPosition;
        private final View mPreview;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Contract {
            void setSelectBackground(int i, String str);
        }

        public StyleViewHolder(@NonNull View view, View view2) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C9086R.id.style_view_holder);
            this.mImageView = imageView;
            this.mPreview = view2;
            imageView.setOnClickListener(this);
        }

        public Drawable getSelectedBackground(@ColorInt int i) {
            LayerDrawable layerDrawable = (LayerDrawable) this.itemView.getResources().getDrawable(C9086R.drawable.cover_editor_style_item_bg_select, null);
            layerDrawable.findDrawableByLayerId(C9086R.id.cover_style_bg_layer).setTint(i);
            return layerDrawable;
        }

        public Drawable getUnselectedBackground(@ColorInt int i) {
            LayerDrawable layerDrawable = (LayerDrawable) this.itemView.getResources().getDrawable(C9086R.drawable.cover_editor_style_item_bg_unselect, null);
            layerDrawable.findDrawableByLayerId(C9086R.id.cover_style_bg_layer).setTint(i);
            return layerDrawable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mPreview.setTag(this.mColorId);
            view.setSelected(true);
            view.setBackground(getSelectedBackground(((Integer) view.getTag()).intValue()));
            this.mContract.setSelectBackground(this.mPosition, this.mColorId);
        }

        public void setContract(Contract contract) {
            this.mContract = contract;
        }

        public void setImageResource(Pair<String, Integer> pair, int i, int i2) {
            int backgroundColor = CoverEditorUtils.getBackgroundColor(this.itemView.getContext(), (String) pair.first);
            if (i != i2) {
                this.mImageView.setBackground(getUnselectedBackground(backgroundColor));
                this.mImageView.setSelected(false);
            } else {
                this.mImageView.setBackground(getSelectedBackground(backgroundColor));
                this.mImageView.setSelected(true);
            }
            this.mImageView.setTag(Integer.valueOf(backgroundColor));
            this.mColorId = (String) pair.first;
            this.mPosition = i;
            this.mImageView.setContentDescription(this.itemView.getResources().getString(((Integer) pair.second).intValue()));
            ViewCompat.getInstance().setTooltipText(this.mImageView);
        }
    }

    public StyleListAdapter(List<Pair<String, Integer>> list, String str, View view) {
        this.mColorList = list;
        this.mPreview = view;
        initSelectedPosition(str);
    }

    private void initSelectedPosition(String str) {
        if (str == null) {
            return;
        }
        String strReplaceAll = str.replaceAll(" ", "");
        for (int i = 0; i < this.mColorList.size(); i++) {
            if (((String) this.mColorList.get(i).first).equalsIgnoreCase(strReplaceAll)) {
                this.mSelectedPosition = i;
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mColorList.size();
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void setPreviewContract(PreviewContract previewContract) {
        this.mPreviewContract = previewContract;
    }

    public void updateSelectedHolder(String str) {
        notifyItemChanged(this.mSelectedPosition);
        initSelectedPosition(str);
        notifyItemChanged(this.mSelectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull StyleViewHolder styleViewHolder, int i) {
        styleViewHolder.setContract(new StyleViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.StyleListAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.StyleListAdapter.StyleViewHolder.Contract
            public void setSelectBackground(int i2, String str) {
                String str2 = StyleListAdapter.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "setSelectBackground# position : ", ", mSelectedPosition : ");
                sbM778t.append(StyleListAdapter.this.mSelectedPosition);
                Logger.m10999d(str2, sbM778t.toString());
                if (StyleListAdapter.this.mSelectedPosition != -1) {
                    StyleListAdapter styleListAdapter = StyleListAdapter.this;
                    styleListAdapter.notifyItemChanged(styleListAdapter.mSelectedPosition);
                }
                StyleListAdapter.this.mSelectedPosition = i2;
                StyleListAdapter.this.mPreviewContract.onSelectBackground(str);
            }
        });
        styleViewHolder.setImageResource(this.mColorList.get(i), i, this.mSelectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public StyleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StyleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.cover_style_item_view, viewGroup, false), this.mPreview);
    }
}
