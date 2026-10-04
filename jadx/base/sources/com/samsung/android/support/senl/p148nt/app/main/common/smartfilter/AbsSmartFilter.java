package com.samsung.android.support.senl.p148nt.app.main.common.smartfilter;

import android.content.Context;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsSmartFilter {
    private MainListDocumentDataRepository mMainListRepository;

    public abstract int getCount();

    public abstract long getID();

    public abstract String getKey();

    @Nullable
    public MainListDocumentDataRepository getMainListRepository() {
        if (this.mMainListRepository == null) {
            this.mMainListRepository = RepositoryManager.getInstance().getMainListRepository();
        }
        return this.mMainListRepository;
    }

    public abstract ArrayList<String> getNotesUUIDPreference();

    public String getSelection() {
        return "";
    }

    public abstract String getTitle(Context context);

    public abstract void setNotesUUIDPreference(Set<String> set);
}
