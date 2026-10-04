package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectTranslateLanguageAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Activity mActivity;
    private RadioButton mCheckedCheckBox;
    private List<AiLanguageHelper.Language> mLanguageList;
    private AiLanguageHelper.Language mSelectedLanguage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View mDivider;
        TextView mLanguageName;
        RadioButton mSelectLanguageCheckBox;
        LinearLayout mSelectLanguageLayout;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.mSelectLanguageLayout = (LinearLayout) view.findViewById(C9086R.id.item_select_language_layout);
            this.mSelectLanguageCheckBox = (RadioButton) view.findViewById(C9086R.id.select_language_check_box);
            this.mSelectLanguageLayout.setOnClickListener(this);
            this.mSelectLanguageLayout.setAccessibilityDelegate(new VoiceAssistAsButton());
            this.mDivider = view.findViewById(C9086R.id.item_divider);
            this.mLanguageName = (TextView) view.findViewById(C9086R.id.language_name);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int absoluteAdapterPosition = getAbsoluteAdapterPosition();
            SelectTranslateLanguageAdapter selectTranslateLanguageAdapter = SelectTranslateLanguageAdapter.this;
            selectTranslateLanguageAdapter.mSelectedLanguage = (AiLanguageHelper.Language) selectTranslateLanguageAdapter.mLanguageList.get(absoluteAdapterPosition);
            if (SelectTranslateLanguageAdapter.this.mSelectedLanguage.getIsData()) {
                if (SelectTranslateLanguageAdapter.this.mCheckedCheckBox != null) {
                    SelectTranslateLanguageAdapter.this.mCheckedCheckBox.setChecked(false);
                }
                SelectTranslateLanguageAdapter.this.mCheckedCheckBox = this.mSelectLanguageCheckBox;
                RadioButton radioButton = this.mSelectLanguageCheckBox;
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
            }
        }
    }

    public SelectTranslateLanguageAdapter(Activity activity, List<AiLanguageHelper.Language> list, AiLanguageHelper.Language language) {
        this.mLanguageList = list;
        this.mActivity = activity;
        this.mSelectedLanguage = language;
    }

    private boolean isSelectedLangauge(AiLanguageHelper.Language language) {
        AiLanguageHelper.Language language2 = this.mSelectedLanguage;
        if (language2 == null || language2.getLocale() == null || this.mSelectedLanguage.getLocale().toLanguageTag() == null || !this.mSelectedLanguage.getIsData() || language == null || language.getLocale() == null || language.getLocale().toLanguageTag() == null || !language.getIsData()) {
            return false;
        }
        return language.equals(this.mSelectedLanguage);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mLanguageList.size();
    }

    public AiLanguageHelper.Language getSelectedLanguage() {
        return this.mSelectedLanguage;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AiLanguageHelper.Language language = this.mLanguageList.get(i);
        if (!language.getIsData()) {
            viewHolder.mSelectLanguageLayout.setVisibility(8);
            viewHolder.mDivider.setVisibility(0);
            return;
        }
        viewHolder.mDivider.setVisibility(8);
        viewHolder.mSelectLanguageLayout.setVisibility(0);
        viewHolder.mLanguageName.setText(language.getName());
        if (isSelectedLangauge(language)) {
            viewHolder.mSelectLanguageCheckBox.setChecked(true);
            this.mCheckedCheckBox = viewHolder.mSelectLanguageCheckBox;
        } else {
            viewHolder.mSelectLanguageCheckBox.setChecked(false);
        }
        viewHolder.mSelectLanguageLayout.setContentDescription(language.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.mActivity).inflate(C9086R.layout.select_language_item_recyclerview_layout, viewGroup, false));
    }
}
