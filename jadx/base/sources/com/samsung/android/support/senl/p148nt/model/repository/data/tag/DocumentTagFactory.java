package com.samsung.android.support.senl.p148nt.model.repository.data.tag;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentTagFactory {
    private static final String TAG = ModelLogger.createTag("DocumentTagFactory");

    public static TagData create(@NonNull String str) {
        DataLogger.m12307i(TAG, "create, tagName : " + DataLogger.getEncode(str));
        return create(str, 0);
    }

    public static List<TagData> createTagDataFromEntities(@NonNull List<NotesTagEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<NotesTagEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(create(it.next().getDisplayName()));
        }
        return arrayList;
    }

    public static TagData create(@NonNull String str, @ColorInt int i) {
        return new DocumentTag().setName(str).setColor(i);
    }
}
