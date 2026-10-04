package com.samsung.android.support.senl.p148nt.composer.main.cover.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateListAdapter extends RecyclerView.Adapter<TemplateViewHolder> {
    private static final String TAG = "TemplateListAdapter";
    private String mSelectedColor;
    private int mSelectedPosition = 0;
    private int mSelectedTypeIndex;
    private TemplateContract mTemplateContract;
    private final Map<Integer, List<String>> mTemplateMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TemplateContract {
        void onSelectTemplate(int i, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TemplateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "TemplateViewHolder";
        private Contract mContract;
        private final ImageView mCoverLine;
        private final ImageView mTemplate;
        private final View mTemplateBorder;
        private final View mTemplateContainer;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Contract {
            void setSelectTemplate(int i, String str);
        }

        public TemplateViewHolder(@NonNull View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C9086R.id.cover_editor_template_item_image_view);
            this.mTemplate = imageView;
            this.mCoverLine = (ImageView) view.findViewById(C9086R.id.cover_editor_template_item_cover_line);
            this.mTemplateContainer = view.findViewById(C9086R.id.cover_editor_template_item_container);
            this.mTemplateBorder = view.findViewById(C9086R.id.cover_editor_template_item_border);
            imageView.setOnClickListener(this);
        }

        private void setSelectedTemplate(boolean z) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTemplateContainer.getLayoutParams();
            int dimensionPixelSize = z ? this.itemView.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_new_template_item_margin_select) : this.itemView.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_new_template_item_margin_unselect);
            marginLayoutParams.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.mTemplateContainer.setLayoutParams(marginLayoutParams);
            this.mTemplateBorder.setVisibility(z ? 0 : 8);
            this.mTemplate.setSelected(z);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int absoluteAdapterPosition = getAbsoluteAdapterPosition();
            List list = (List) TemplateListAdapter.this.mTemplateMap.get(Integer.valueOf(TemplateListAdapter.this.mSelectedTypeIndex));
            if (list == null || absoluteAdapterPosition < 0 || absoluteAdapterPosition >= list.size()) {
                return;
            }
            AbstractC0000a.m3D(absoluteAdapterPosition, "onClick# position : ", TAG);
            setSelectedTemplate(true);
            this.mContract.setSelectTemplate(absoluteAdapterPosition, (String) list.get(absoluteAdapterPosition));
        }

        public void setContract(Contract contract) {
            this.mContract = contract;
        }

        public void setTemplateBackground(int i, int i2) {
            if (TemplateListAdapter.this.mSelectedTypeIndex == 0) {
                this.mTemplate.setBackground(CoverEditorUtils.getPatternDrawable(this.itemView.getContext(), (String) ((List) TemplateListAdapter.this.mTemplateMap.get(1)).get(i)));
                this.mTemplate.setClickable(false);
                this.mCoverLine.setVisibility(8);
                return;
            }
            this.mTemplate.setBackground(CoverEditorUtils.getTemplateDrawable(this.itemView.getContext(), (String) ((List) TemplateListAdapter.this.mTemplateMap.get(Integer.valueOf(TemplateListAdapter.this.mSelectedTypeIndex))).get(i), TemplateListAdapter.this.mSelectedColor));
            this.mTemplate.setSelected(i == i2);
            this.mTemplate.setContentDescription(this.itemView.getResources().getString(C9086R.string.ai_cover_style) + " " + (i + 1));
            ViewCompat.getInstance().setTooltipText(this.mTemplate);
            this.mTemplate.setClickable(true);
            setSelectedTemplate(i == i2);
            this.mCoverLine.setVisibility(3 != TemplateListAdapter.this.mSelectedTypeIndex ? 0 : 8);
        }
    }

    public TemplateListAdapter(Map<Integer, List<String>> map, String str, int i, String str2) {
        this.mTemplateMap = map;
        this.mSelectedTypeIndex = i;
        this.mSelectedColor = str2;
        initSelectedPosition(str);
    }

    private void initSelectedPosition(String str) {
        if (str == null || this.mSelectedTypeIndex == 0) {
            return;
        }
        if ("DEFAULT:///".equals(str)) {
            this.mSelectedPosition = 0;
        } else if (this.mTemplateMap.get(Integer.valueOf(this.mSelectedTypeIndex)).contains(str)) {
            this.mSelectedPosition = this.mTemplateMap.get(Integer.valueOf(this.mSelectedTypeIndex)).indexOf(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTemplateMap.get(Integer.valueOf(this.mSelectedTypeIndex)).size();
    }

    public void setTemplateContract(TemplateContract templateContract) {
        this.mTemplateContract = templateContract;
    }

    public void updateSelectedColor(String str) {
        this.mSelectedColor = str;
        notifyDataSetChanged();
    }

    public void updateSelectedTemplate(String str, String str2) {
        initSelectedPosition(str);
        this.mSelectedColor = str2;
        notifyDataSetChanged();
    }

    public void updateSelectedType(int i, String str) {
        if (this.mSelectedTypeIndex != i) {
            this.mSelectedTypeIndex = i;
            initSelectedPosition(str);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull TemplateViewHolder templateViewHolder, int i) {
        templateViewHolder.setContract(new TemplateViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TemplateListAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.TemplateListAdapter.TemplateViewHolder.Contract
            public void setSelectTemplate(int i2, String str) {
                TemplateListAdapter templateListAdapter = TemplateListAdapter.this;
                templateListAdapter.notifyItemChanged(templateListAdapter.mSelectedPosition);
                TemplateListAdapter.this.mSelectedPosition = i2;
                TemplateListAdapter.this.mTemplateContract.onSelectTemplate(i2, str);
            }
        });
        templateViewHolder.setTemplateBackground(i, this.mSelectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public TemplateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TemplateViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.cover_editor_new_template_list_item, viewGroup, false));
    }
}
