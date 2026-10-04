package com.samsung.android.support.senl.p148nt.composer.main.base.model.hashtag;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagDataHelper {
    public static ArrayList<String> convertToTagStringList(@NonNull List<TagData> list) {
        ArrayList<String> arrayList = new ArrayList<>(list.size());
        Iterator<TagData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
