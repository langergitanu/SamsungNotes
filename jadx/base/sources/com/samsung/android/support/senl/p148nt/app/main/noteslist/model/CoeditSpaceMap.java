package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import androidx.annotation.Nullable;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMapContract;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SpaceEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceMap {
    private static final String TAG = "CoeditSpaceMap";
    private final DocumentMapContract.Coedit mDocMapContract;
    private final LinkedHashMap<String, SpaceEntry> mSpaceMap = new LinkedHashMap<>();
    private final LinkedHashMap<String, CoeditMainListEntry> mNoteDataMap = new LinkedHashMap<>();
    private final LinkedHashMap<String, CoeditMainListEntry> mFakeDataMap = new LinkedHashMap<>();
    private final LinkedHashMap<String, GroupInvitationListResult.GroupInvitation> mInvitationMap = new LinkedHashMap<>();
    private final List<Common> mSpaceDisplayList = new ArrayList();

    public CoeditSpaceMap(DocumentMapContract.Coedit coedit) {
        this.mDocMapContract = coedit;
    }

    private void initFakeDisplayData(Map<String, MainListDocumentData> map, List<Common> list) {
        for (CoeditMainListEntry coeditMainListEntry : this.mFakeDataMap.values()) {
            list.add(new Common.Coedit(coeditMainListEntry));
            map.put(coeditMainListEntry.getMainListDocumentData().getUuid(), coeditMainListEntry.getMainListDocumentData());
        }
    }

    public int getInvitationDisplayListSize() {
        return this.mInvitationMap.size();
    }

    @Nullable
    public CoeditMainListEntry getNote(String str) {
        CoeditMainListEntry coeditMainListEntry = this.mFakeDataMap.get(str);
        return coeditMainListEntry != null ? coeditMainListEntry : this.mNoteDataMap.get(str);
    }

    public Common getSpaceDisplayData(int i) {
        if (i < 0 || this.mSpaceDisplayList.size() <= i) {
            return null;
        }
        return this.mSpaceDisplayList.get(i);
    }

    public List<Common> getSpaceDisplayList() {
        return this.mSpaceDisplayList;
    }

    public void initCoeditDisplayData(Map<String, MainListDocumentData> map, List<Common> list) {
        for (CoeditMainListEntry coeditMainListEntry : this.mNoteDataMap.values()) {
            list.add(new Common.Coedit(coeditMainListEntry));
            map.put(coeditMainListEntry.getMainListDocumentData().getUuid(), coeditMainListEntry.getMainListDocumentData());
        }
        initFakeDisplayData(map, list);
        MainCoeditLogger.m7253i(TAG, "initCoeditDisplayData# StandaloneMap : " + list.size());
    }

    public void initCoeditInvitationDisplayData(List<Common> list) {
        Iterator<GroupInvitationListResult.GroupInvitation> it = this.mInvitationMap.values().iterator();
        while (it.hasNext()) {
            list.add(new Common.CoeditInvitation(it.next()));
        }
        MainCoeditLogger.m7253i(TAG, "initCoeditInvitationDisplayData# commonDisplayList : " + list.size());
    }

    public void initCoeditInvitationMap(List<GroupInvitationListResult.GroupInvitation> list) {
        MainCoeditLogger.m7253i(TAG, "initCoeditInvitationMap# invitations : " + list.size());
        Collections.sort(list, new Comparator<GroupInvitationListResult.GroupInvitation>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.CoeditSpaceMap.1
            @Override // java.util.Comparator
            public int compare(GroupInvitationListResult.GroupInvitation groupInvitation, GroupInvitationListResult.GroupInvitation groupInvitation2) {
                return Long.compare(groupInvitation2.getRequestedTime(), groupInvitation.getRequestedTime());
            }
        });
        this.mInvitationMap.clear();
        for (GroupInvitationListResult.GroupInvitation groupInvitation : list) {
            if (groupInvitation.getExpiredTime() > 0) {
                this.mInvitationMap.put(groupInvitation.getGroupId(), groupInvitation);
            }
        }
    }

    public void initCoeditMap(List<CoeditMainListEntry> list) {
        this.mSpaceMap.clear();
        this.mNoteDataMap.clear();
        this.mFakeDataMap.clear();
        for (CoeditMainListEntry coeditMainListEntry : list) {
            if (coeditMainListEntry.getType() == 0) {
                this.mNoteDataMap.put(coeditMainListEntry.getMainListDocumentData().getUuid(), coeditMainListEntry);
            } else if (coeditMainListEntry.getType() == 1) {
                this.mSpaceMap.put(coeditMainListEntry.getSpaceEntry().getSpaceId(), coeditMainListEntry.getSpaceEntry());
            } else {
                this.mFakeDataMap.put(coeditMainListEntry.getMainListDocumentData().getUuid(), coeditMainListEntry);
            }
        }
        MainCoeditLogger.m7253i(TAG, "[CS9] initCoeditMap# spaces: " + this.mSpaceMap.size() + ", notes: " + this.mNoteDataMap.size() + ", fake: " + this.mFakeDataMap.size());
    }

    public void initCoeditSpaceDisplayData(List<Common> list) {
        Iterator<SpaceEntry> it = this.mSpaceMap.values().iterator();
        while (it.hasNext()) {
            list.add(new Common.CoeditSpace(it.next()));
        }
        this.mSpaceDisplayList.clear();
        this.mSpaceDisplayList.addAll(list);
        boolean z = this.mSpaceMap.size() > 0;
        this.mDocMapContract.putHolderInfoMap(5, z);
        if (z) {
            list.add(0, new Common.SubHeader(-16L));
        }
        MainCoeditLogger.m7253i(TAG, "initCoeditSpaceDisplayData# SpaceDisplayList : " + this.mSpaceDisplayList.size());
    }

    public void initCoeditSpaceModeDisplayData(Map<String, MainListDocumentData> map, List<Common> list, String str) {
        for (CoeditMainListEntry coeditMainListEntry : this.mNoteDataMap.values()) {
            if (FolderConstants.Coedit.UUID.equals(coeditMainListEntry.getMainListDocumentData().getCategoryUuid()) && str.equals(coeditMainListEntry.getMainListDocumentData().getMdeSpaceId())) {
                list.add(new Common.Coedit(coeditMainListEntry));
            }
            map.put(coeditMainListEntry.getMainListDocumentData().getUuid(), coeditMainListEntry.getMainListDocumentData());
        }
        initFakeDisplayData(map, list);
        MainCoeditLogger.m7253i(TAG, "initCoeditSpaceModeDisplayData# commonDisplayList : " + list.size());
    }

    public boolean removeCoeditInvitationMap(String str) {
        return (str == null || this.mInvitationMap.remove(str) == null) ? false : true;
    }
}
