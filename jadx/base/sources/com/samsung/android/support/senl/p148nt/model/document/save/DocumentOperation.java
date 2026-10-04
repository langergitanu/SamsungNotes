package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class DocumentOperation<Entity extends NotesDocumentEntity> {
    private final Context mContext;

    public DocumentOperation(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    public abstract boolean apply(Entity entity);

    @NonNull
    public Context getContext() {
        return this.mContext;
    }
}
