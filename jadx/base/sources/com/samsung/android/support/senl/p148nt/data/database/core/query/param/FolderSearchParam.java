package com.samsung.android.support.senl.p148nt.data.database.core.query.param;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SearchWord;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderSearchParam extends BaseSearchParam<FolderSearchParam> {
    private final Set<String> mExcludedFolders = new HashSet();
    private boolean mSelectOnlyUuid;
    private boolean mWithDelimiter;
    private final List<SearchWord> mWords;

    public FolderSearchParam(@NonNull List<SearchWord> list) {
        this.mWords = list;
    }

    public FolderSearchParam addExcludedFolders(@NonNull Collection<String> collection) {
        this.mExcludedFolders.addAll(collection);
        return this;
    }

    public Set<String> getExcludedFolders() {
        return this.mExcludedFolders;
    }

    public boolean getSelectOnlyUuid() {
        return this.mSelectOnlyUuid;
    }

    public boolean getWithDelimiter() {
        return this.mWithDelimiter;
    }

    public List<SearchWord> getWords() {
        return this.mWords;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.param.BaseSearchParam
    public FolderSearchParam self() {
        return this;
    }

    public FolderSearchParam setSelectOnlyUuid(boolean z) {
        this.mSelectOnlyUuid = z;
        return this;
    }

    public FolderSearchParam setWithDelimiter(boolean z) {
        this.mWithDelimiter = z;
        return this;
    }
}
