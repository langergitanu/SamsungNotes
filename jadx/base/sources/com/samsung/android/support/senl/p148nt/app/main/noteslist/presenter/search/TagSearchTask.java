package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.hashtag.HashTagListPreferenceHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TagSearchTask extends AbsSearchTask {
    public static final String TAG = "TagSearchTask";

    public TagSearchTask(SearchUpdateListener searchUpdateListener) {
        super(searchUpdateListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.AbsSearchTask
    public void invoke(@NonNull Set<String> set, FilterInfo filterInfo, long j) {
        if (FeatureUtils.isHashTagMode(getModeIndex())) {
            if (!canInvokeSearch(j)) {
                MainLogger.m7254d(TAG, "invokeTagSearch, searchId is same");
                return;
            }
            if (set.isEmpty()) {
                this.notesResult = DataManager.getInstance().getAllWithTag();
            } else {
                this.notesResult = DataManager.getInstance().getAllByTagNormalizedNames(set);
            }
            HashTagListPreferenceHelper.getInstance().setSelectedTags(set);
            queryLogging(TAG, this.notesResult.size());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResultListener
    public void postViewUpdate(String str) {
        if (FeatureUtils.isHashTagMode(getModeIndex())) {
            this.mSearchUpdateListener.postViewUpdate(TAG, getDocumentMap().initNoteMapWithoutFolder(this.notesResult) && !this.notesResult.isEmpty());
        }
    }
}
