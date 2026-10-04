package com.samsung.android.support.senl.p148nt.data.repository.converter;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashtagDataConverter {
    public static final String ADDONS_DOCUMENT_DATA_HASHTAG = "addons_document_data_hashtag";

    public Set<String> convert(Collection<HashTagData> collection) {
        HashSet hashSet = new HashSet();
        if (collection != null) {
            Iterator<HashTagData> it = collection.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getName());
            }
        }
        return hashSet;
    }

    public void updateHashtag(Context context, String str, List<HashTagData> list) {
        Set<String> setConvert = convert(list);
        NotesTagRepository notesTagRepositoryCreateDocumentTagRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        List<NotesTagEntity> tagListByDocUuid = notesTagRepositoryCreateDocumentTagRepository.getTagListByDocUuid(str);
        if (tagListByDocUuid == null) {
            tagListByDocUuid = new ArrayList<>();
        }
        HashSet hashSet = new HashSet();
        Iterator<NotesTagEntity> it = tagListByDocUuid.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getDisplayName());
        }
        notesTagRepositoryCreateDocumentTagRepository.updateTagsByDocUuid(hashSet, setConvert, str, false);
    }
}
