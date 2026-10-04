package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface HashTagContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Presenter {
        List<String> getTagList();

        View getView();

        void onHashTagAdded(String str);

        void onHashTagClicked(Context context, String str);

        void onHashTagRemoved(String str);

        void onHashTagRenamed(String str, String str2);

        void saveTagList(List<TagData> list);

        void setTagListToComposerView(List<String> list);

        void setView(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface View {
        void updateTagListView();
    }
}
