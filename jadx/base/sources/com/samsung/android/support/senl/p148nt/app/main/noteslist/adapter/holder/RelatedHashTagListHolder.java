package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.hashtag.HashTagListLayout;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RelatedHashTagListHolder extends CommonHolder implements HashTagListLayout.Contract {
    private static final String TAG = "RelatedHashTagListHolder";
    private final HashTagListLayout mHashTagListLayout;

    public RelatedHashTagListHolder(@NonNull View view, int i) {
        super(view, i);
        setHolderType(65536);
        HashTagListLayout hashTagListLayout = (HashTagListLayout) view.findViewById(C8003R.id.hash_tag_list_container);
        this.mHashTagListLayout = hashTagListLayout;
        hashTagListLayout.setContract(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        List<String> allTagsInUse = stateInfo.getSelectedTags().isEmpty() ? DataManager.getInstance().getAllTagsInUse() : DataManager.getInstance().getRelatedTags(stateInfo.getSelectedTags());
        MainLogger.m7254d(TAG, "decorate# tag size : " + allTagsInUse.size());
        this.mHashTagListLayout.reloadTags(allTagsInUse);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.hashtag.HashTagListLayout.Contract
    public boolean isSelectedTag(String str) {
        if (getMAdapterContract() == null) {
            return false;
        }
        return getMAdapterContract().getSelectedTags().contains(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.hashtag.HashTagListLayout.Contract
    public void onTagSelected(String str) {
        if (getMAdapterContract() == null) {
            return;
        }
        Set<String> selectedTags = getMAdapterContract().getSelectedTags();
        if (selectedTags.contains(str)) {
            selectedTags.remove(str);
        } else {
            selectedTags.add(str);
        }
        getMAdapterContract().onHashTagSelected(selectedTags);
    }
}
