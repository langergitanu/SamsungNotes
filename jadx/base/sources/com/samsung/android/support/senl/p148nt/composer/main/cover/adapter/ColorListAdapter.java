package com.samsung.android.support.senl.p148nt.composer.main.cover.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ColorListAdapter extends RecyclerView.Adapter<ColorViewHolder> {
    private static final String TAG = "ColorListAdapter";
    private ColorContract mColorContract;
    private final List<Pair<String, Integer>> mColorList;
    private int mSelectedPosition = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ColorContract {
        void onSelectColor(int i, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ColorViewHolder";
        private final ImageView mColorView;
        private Contract mContract;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Contract {
            void setSelectColor(int i, String str);
        }

        public ColorViewHolder(@NonNull View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C9086R.id.cover_editor_color_item_image_view);
            this.mColorView = imageView;
            imageView.setOnClickListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorBackground(int i, int i2) {
            this.mColorView.setBackground(setSelectedBackground(i, (String) ((Pair) ColorListAdapter.this.mColorList.get(i)).first, i == i2));
            this.mColorView.setSelected(i == i2);
            this.mColorView.setContentDescription(this.itemView.getResources().getString(((Integer) ((Pair) ColorListAdapter.this.mColorList.get(i)).second).intValue()));
            ViewCompat.getInstance().setTooltipText(this.mColorView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContract(Contract contract) {
            this.mContract = contract;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int absoluteAdapterPosition = getAbsoluteAdapterPosition();
            if (ColorListAdapter.this.mColorList == null || absoluteAdapterPosition < 0 || absoluteAdapterPosition >= ColorListAdapter.this.mColorList.size()) {
                return;
            }
            String str = (String) ((Pair) ColorListAdapter.this.mColorList.get(absoluteAdapterPosition)).first;
            Logger.m10999d(TAG, "onClick# position : " + absoluteAdapterPosition + ", colorUuid : " + str);
            this.mColorView.setSelected(true);
            this.mColorView.setBackground(setSelectedBackground(absoluteAdapterPosition, str, true));
            this.mContract.setSelectColor(absoluteAdapterPosition, str);
        }

        public Drawable setSelectedBackground(int i, String str, boolean z) {
            LayerDrawable layerDrawable = z ? (LayerDrawable) this.itemView.getResources().getDrawable(C9086R.drawable.cover_editor_new_color_item_bg_select, null) : (LayerDrawable) this.itemView.getResources().getDrawable(C9086R.drawable.cover_editor_new_color_item_bg_unselect, null);
            layerDrawable.mutate();
            if (!str.contains(CoverConstants.COLOR_SET)) {
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_color_bg_layer).setTint(CoverEditorUtils.getBackgroundColor(this.itemView.getContext(), str));
                return layerDrawable;
            }
            int[] colorSet = CoverEditorUtils.getColorSet(str);
            LayerDrawable layerDrawable2 = (LayerDrawable) layerDrawable.findDrawableByLayerId(C9086R.id.cover_color_bg_layer);
            layerDrawable2.findDrawableByLayerId(C9086R.id.cover_color_set_first).setTint(ContextCompat.getColor(this.itemView.getContext(), colorSet[0]));
            layerDrawable2.findDrawableByLayerId(C9086R.id.cover_color_set_second).setTint(ContextCompat.getColor(this.itemView.getContext(), colorSet[1]));
            layerDrawable2.findDrawableByLayerId(C9086R.id.cover_color_set_third).setTint(ContextCompat.getColor(this.itemView.getContext(), colorSet[2]));
            return layerDrawable;
        }
    }

    public ColorListAdapter(List<Pair<String, Integer>> list, String str) {
        this.mColorList = list;
        initSelectedPosition(str);
    }

    private void initSelectedPosition(String str) {
        if (str == null) {
            return;
        }
        String strReplace = str.replace(" ", "");
        if ("DEFAULT:///".equals(strReplace)) {
            if (NotesDocumentCoverUtils.getVersion(CoverConstants.VERSION) != 2) {
                this.mSelectedPosition = 0;
                return;
            } else {
                this.mSelectedPosition = 6;
                return;
            }
        }
        for (int i = 0; i < this.mColorList.size(); i++) {
            if (((String) this.mColorList.get(i).first).equalsIgnoreCase(strReplace)) {
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

    public void setColorContract(ColorContract colorContract) {
        this.mColorContract = colorContract;
    }

    public void updateSelectedColor(String str) {
        initSelectedPosition(str);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ColorViewHolder colorViewHolder, int i) {
        colorViewHolder.setContract(new ColorViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.ColorListAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.ColorListAdapter.ColorViewHolder.Contract
            public void setSelectColor(int i2, String str) {
                ColorListAdapter colorListAdapter = ColorListAdapter.this;
                colorListAdapter.notifyItemChanged(colorListAdapter.mSelectedPosition);
                ColorListAdapter.this.mSelectedPosition = i2;
                ColorListAdapter.this.mColorContract.onSelectColor(i2, str);
            }
        });
        colorViewHolder.setColorBackground(i, this.mSelectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ColorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.cover_editor_new_color_list_item, viewGroup, false));
    }
}
