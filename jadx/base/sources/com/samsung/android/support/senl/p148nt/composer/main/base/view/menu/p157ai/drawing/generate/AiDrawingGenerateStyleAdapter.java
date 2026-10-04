package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingGenerateStyleHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingGenerateStyleAdapter extends RecyclerView.Adapter<AiDrawingGenerateStyleHolder> {
    private final Contract mContract;
    private final AiDrawingGenerateStyleHolder.Contract mHolderContract = new AiDrawingGenerateStyleHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingGenerateStyleAdapter.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingGenerateStyleHolder.Contract
        @SuppressLint({"NotifyDataSetChanged"})
        public void requestUpdateGenerateStyleIndex(int i) {
            if (AiDrawingGenerateStyleAdapter.this.mContract == null) {
                return;
            }
            AiDrawingGenerateStyleAdapter.this.mContract.requestUpdateGenerateStyleIndex(i);
            AiDrawingGenerateStyleAdapter.this.notifyDataSetChanged();
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_REQUEST, ComposerSAConstants.EVENT_AI_DRAWING_REQUEST_STYLE);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getGenerateStyleIndex();

        void requestUpdateGenerateStyleIndex(int i);
    }

    public AiDrawingGenerateStyleAdapter(Contract contract) {
        this.mContract = contract;
        setHasStableIds(true);
    }

    private boolean isStyleSelected(int i) {
        Contract contract = this.mContract;
        return contract != null && contract.getGenerateStyleIndex() == i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        return AiDrawingUtil.getImageStyleCount(applicationContext);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AiDrawingGenerateStyleHolder aiDrawingGenerateStyleHolder, int i) {
        aiDrawingGenerateStyleHolder.decorate(i, isStyleSelected(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public AiDrawingGenerateStyleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AiDrawingGenerateStyleHolder aiDrawingGenerateStyleHolder = new AiDrawingGenerateStyleHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_drawing_generate_style_item_layout, viewGroup, false));
        aiDrawingGenerateStyleHolder.setContract(this.mHolderContract);
        CharUtils.applyTextSizeUntilMediumSize(viewGroup.getContext(), (TextView) aiDrawingGenerateStyleHolder.itemView.findViewById(C9086R.id.ai_drawing_generate_style_item_name), 12.0f);
        return aiDrawingGenerateStyleHolder;
    }
}
