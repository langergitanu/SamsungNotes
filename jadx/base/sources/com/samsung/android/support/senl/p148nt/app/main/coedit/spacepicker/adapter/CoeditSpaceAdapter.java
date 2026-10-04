package com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.CoeditSpaceMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceAdapter extends RecyclerView.Adapter<CoeditSpaceHolder> {
    private static final int HOLDER_TYPE_ADD = 8193;
    private final CoeditSpaceMap mCoeditSpaceMap;
    private final SpacePickerSelectListener mSelectListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditSpaceAddHolder extends CoeditSpaceHolder {
        public CoeditSpaceAddHolder(@NonNull View view, int i) {
            super(view, i);
            setHolderType(CoeditSpaceAdapter.HOLDER_TYPE_ADD);
            view.findViewById(C8003R.id.space_item_container).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.adapter.CoeditSpaceAdapter.CoeditSpaceAddHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    CoeditSpaceAdapter.this.mSelectListener.createNewSpace();
                }
            });
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder, com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
        public void decorate(Common common, StateInfo stateInfo) {
        }
    }

    public CoeditSpaceAdapter(SpacePickerSelectListener spacePickerSelectListener, CoeditSpaceMap coeditSpaceMap) {
        this.mSelectListener = spacePickerSelectListener;
        this.mCoeditSpaceMap = coeditSpaceMap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCoeditSpaceMap.getSpaceDisplayList().size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return HOLDER_TYPE_ADD;
        }
        return 8192;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull CoeditSpaceHolder coeditSpaceHolder, int i) {
        Common spaceDisplayData;
        if ((coeditSpaceHolder instanceof CoeditSpaceAddHolder) || (spaceDisplayData = this.mCoeditSpaceMap.getSpaceDisplayData(i - 1)) == null) {
            return;
        }
        coeditSpaceHolder.decorate(spaceDisplayData, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public CoeditSpaceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == HOLDER_TYPE_ADD ? new CoeditSpaceAddHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_coedit_space_add_holder, viewGroup, false), -1) : new CoeditSpaceHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_coedit_space_holder, viewGroup, false), -1, this.mSelectListener);
    }
}
