package com.samsung.android.support.senl.p148nt.model.collector.common;

import android.graphics.Rect;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.flatbuffer.C2747a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.collect.CollectTestLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.RetryState;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesPageSearchInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyTextEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesRetryRepository;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesStrokeRepository;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption.SDocEncryptionHelper;
import com.samsung.android.support.senl.p148nt.model.collector.common.jsonwrapper.StrokeDataJsonConverter;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectResolver {
    private static final String TAG = CollectLogger.createTag("CollectResolver");

    private static NotesStrokeSearchEntity convertToEntity(SpenSDoc.SearchData searchData, String str, String str2) {
        NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
        notesStrokeSearchEntity.setHasVisualCue(Integer.valueOf(searchData.hasVisualCue ? 1 : 0));
        notesStrokeSearchEntity.setFilePath(new File(searchData.filePath).getName());
        notesStrokeSearchEntity.setText(searchData.text);
        notesStrokeSearchEntity.setLeft(Integer.valueOf(searchData.rect.left));
        notesStrokeSearchEntity.setTop(Integer.valueOf(searchData.rect.top));
        notesStrokeSearchEntity.setBottom(Integer.valueOf(searchData.rect.bottom));
        notesStrokeSearchEntity.setRight(Integer.valueOf(searchData.rect.right));
        notesStrokeSearchEntity.setDocUuid(str);
        notesStrokeSearchEntity.setPageUuid(str2);
        notesStrokeSearchEntity.setPageWidth(Integer.valueOf(searchData.pageWidth));
        return notesStrokeSearchEntity;
    }

    public static List<NotesPageSearchInfoEntity> createChangedPageSearchInfoEntitiesWithContentModifiedAt(String str, SpenWNote spenWNote, Set<String> set, int i) {
        DataLogger.m12302d(TAG, "createChangedPageSearchInfoEntitiesWithContentModifiedAt");
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        Map<String, NotesPageSearchInfoEntity> pageSearchInfoMapFromDB = getPageSearchInfoMapFromDB(str);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(createPageSearchInfoEntityWithContentModifiedAt(pageSearchInfoMapFromDB, str, pageList.get(spenWNote.getPageIndexById(it.next())), i));
        }
        return arrayList;
    }

    public static List<NotesPageSearchInfoEntity> createPageSearchInfoEntitiesWithSearchModifiedAt(String str, SpenWNote spenWNote, Set<String> set, int i) {
        DataLogger.m12302d(TAG, "createPageSearchInfoEntitiesWithSearchModifiedAt");
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        Map<String, NotesPageSearchInfoEntity> pageSearchInfoMapFromDB = getPageSearchInfoMapFromDB(str);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            NotesPageSearchInfoEntity notesPageSearchInfoEntityCreatePageSearchInfoEntityWithSearchModifiedAt = createPageSearchInfoEntityWithSearchModifiedAt(pageSearchInfoMapFromDB, pageList.get(spenWNote.getPageIndexById(it.next())), i);
            if (notesPageSearchInfoEntityCreatePageSearchInfoEntityWithSearchModifiedAt != null) {
                arrayList.add(notesPageSearchInfoEntityCreatePageSearchInfoEntityWithSearchModifiedAt);
            }
        }
        return arrayList;
    }

    private static NotesPageSearchInfoEntity createPageSearchInfoEntityWithContentModifiedAt(Map<String, NotesPageSearchInfoEntity> map, String str, SpenWPage spenWPage, int i) {
        NotesPageSearchInfoEntity notesPageSearchInfoEntity = map.get(spenWPage.getId());
        if (notesPageSearchInfoEntity == null) {
            notesPageSearchInfoEntity = new NotesPageSearchInfoEntity();
            notesPageSearchInfoEntity.setDocumentUuid(str);
            notesPageSearchInfoEntity.setPageUuid(spenWPage.getId());
        }
        notesPageSearchInfoEntity.setLastContentModifiedAt(TimeManager.convertSdkTimeToAppTime(spenWPage.getModifiedTime()));
        notesPageSearchInfoEntity.setContentSource(i);
        return notesPageSearchInfoEntity;
    }

    @Nullable
    private static NotesPageSearchInfoEntity createPageSearchInfoEntityWithSearchModifiedAt(Map<String, NotesPageSearchInfoEntity> map, SpenWPage spenWPage, int i) {
        NotesPageSearchInfoEntity notesPageSearchInfoEntity = map.get(spenWPage.getId());
        if (notesPageSearchInfoEntity == null) {
            DataLogger.m12302d(TAG, "createPageSearchInfoEntitiesWithSearchModifiedAt, content is not set!!!");
            return null;
        }
        notesPageSearchInfoEntity.setLastSearchModifiedAt(TimeManager.convertSdkTimeToAppTime(spenWPage.getModifiedTime()));
        notesPageSearchInfoEntity.setSearchSource(i);
        notesPageSearchInfoEntity.setIsDirty(1);
        return notesPageSearchInfoEntity;
    }

    public static List<NotesPageSearchInfoEntity> createRemovedPageSearchInfoEntitiesWithContentModifiedAt(String str, Set<String> set) {
        DataLogger.m12302d(TAG, "createRemovedPageSearchInfoEntitiesWithContentModifiedAt");
        ArrayList arrayList = new ArrayList();
        Map<String, NotesPageSearchInfoEntity> pageSearchInfoMapFromDB = getPageSearchInfoMapFromDB(str);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            NotesPageSearchInfoEntity notesPageSearchInfoEntity = pageSearchInfoMapFromDB.get(it.next());
            if (notesPageSearchInfoEntity != null) {
                arrayList.add(notesPageSearchInfoEntity);
            }
        }
        return arrayList;
    }

    public static NotesRetryEntity createRetryEntity(String str, long j, @RetryState int i) {
        NotesRetryEntity notesRetryEntity = new NotesRetryEntity();
        notesRetryEntity.setDocUuid(str);
        notesRetryEntity.setState(i);
        notesRetryEntity.setLastModifiedAt(j);
        notesRetryEntity.setVersion(1);
        return notesRetryEntity;
    }

    public static Map<String, ArrayList<SpenWPage.StrokeRecognitionData>> createStrokeRecognitionData(Map<String, ArrayList<SpenWPage.SearchData>> map, Map<String, ArrayList<SpenWPage.ActionLinkData>> map2) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, ArrayList<SpenWPage.SearchData>> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                concurrentHashMap.put(key, mergeSearchActionLinkData(entry.getValue(), map2.get(key)));
            } catch (SpenAlreadyClosedException e) {
                DataLogger.m12303e(TAG, e.getMessage());
            } catch (IllegalArgumentException e2) {
                e = e2;
                DataLogger.m12303e(TAG, "createStrokeRecognitionData, exception  " + e.getMessage());
            } catch (NullPointerException e3) {
                e = e3;
                DataLogger.m12303e(TAG, "createStrokeRecognitionData, exception  " + e.getMessage());
            }
        }
        return concurrentHashMap;
    }

    public static List<String> createStrokeRecognitionDataResetPageIds(Set<SpenWPage> set, Map<String, ArrayList<SpenWPage.SearchData>> map) {
        ArrayList arrayList = new ArrayList();
        for (SpenWPage spenWPage : set) {
            String id = spenWPage.getId();
            if (!spenWPage.getStrokeRecognitionData().isEmpty() && map.get(id) == null) {
                arrayList.add(id);
            }
        }
        return arrayList;
    }

    public static void deleteReadyState(String str) {
        DataLogger.m12307i(TAG, "deleteReadyState, uuid : " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository().deleteByUuid(str);
    }

    public static Map<String, ArrayList<SpenWPage.ActionLinkData>> getActionLinkDataList(List<NotesStrokeSearchEntity> list) {
        HashMap map = new HashMap();
        for (NotesStrokeSearchEntity notesStrokeSearchEntity : list) {
            SpenWPage.ActionLinkData actionLinkDataFromJsonStr = StrokeDataJsonConverter.getActionLinkDataFromJsonStr(notesStrokeSearchEntity.getActionLinkData());
            ArrayList arrayList = (ArrayList) map.get(notesStrokeSearchEntity.getPageUuid());
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(actionLinkDataFromJsonStr);
            map.put(notesStrokeSearchEntity.getPageUuid(), arrayList);
        }
        return map;
    }

    public static Map<String, ArrayList<SpenWPage.ActionLinkData>> getActionLinkDataListFromDB(String str) {
        return getActionLinkDataList(NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().getEntities(str, 2));
    }

    public static Map<String, NotesPageSearchInfoEntity> getPageSearchInfoMapFromDB(String str) {
        HashMap map = new HashMap();
        for (NotesPageSearchInfoEntity notesPageSearchInfoEntity : NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createPageSearchInfoRepository().getEntities(str)) {
            map.put(notesPageSearchInfoEntity.getPageUuid(), notesPageSearchInfoEntity);
        }
        return map;
    }

    public static List<String> getRecognizeTextsWithExcludedTypes(String str, int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (NotesStrokeSearchEntity notesStrokeSearchEntity : NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().getEntityListWithExcludedTypes(str, iArr)) {
            if (notesStrokeSearchEntity.getType() == 2) {
                arrayList.add(StrokeDataJsonConverter.getActionLinkDataFromJsonStr(notesStrokeSearchEntity.getActionLinkData()).linkStr);
            } else {
                arrayList.add(notesStrokeSearchEntity.getText());
            }
        }
        return arrayList;
    }

    private static SpenSDoc.SearchData getSDocSearchDataFromEntity(NotesStrokeSearchEntity notesStrokeSearchEntity) {
        SpenSDoc.SearchData searchData = new SpenSDoc.SearchData();
        searchData.hasVisualCue = notesStrokeSearchEntity.getHasVisualCue().intValue() == 1;
        searchData.filePath = notesStrokeSearchEntity.getFilePath();
        searchData.text = notesStrokeSearchEntity.getText();
        Rect rect = new Rect();
        searchData.rect = rect;
        rect.left = notesStrokeSearchEntity.getLeft().intValue();
        searchData.rect.top = notesStrokeSearchEntity.getTop().intValue();
        searchData.rect.bottom = notesStrokeSearchEntity.getBottom().intValue();
        searchData.rect.right = notesStrokeSearchEntity.getRight().intValue();
        searchData.pageWidth = notesStrokeSearchEntity.getPageWidth().intValue();
        return searchData;
    }

    public static Map<String, ArrayList<SpenWPage.SearchData>> getSearchDataList(List<NotesStrokeSearchEntity> list) {
        HashMap map = new HashMap();
        if (list != null) {
            for (NotesStrokeSearchEntity notesStrokeSearchEntity : list) {
                SpenWPage.SearchData searchData = new SpenWPage.SearchData();
                searchData.type = notesStrokeSearchEntity.getType();
                searchData.rect = new Rect(notesStrokeSearchEntity.getLeft().intValue(), notesStrokeSearchEntity.getTop().intValue(), notesStrokeSearchEntity.getRight().intValue(), notesStrokeSearchEntity.getBottom().intValue());
                searchData.text = notesStrokeSearchEntity.getText();
                searchData.pageWidth = notesStrokeSearchEntity.getPageWidth().intValue();
                ArrayList arrayList = (ArrayList) map.get(notesStrokeSearchEntity.getPageUuid());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(searchData);
                map.put(notesStrokeSearchEntity.getPageUuid(), arrayList);
            }
        }
        return map;
    }

    public static Map<String, ArrayList<SpenWPage.SearchData>> getSearchDataListFromDB(String str) {
        return getSearchDataList(NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().getEntities(str, 1));
    }

    public static void insertContentTextData(NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
        DataLogger.m12307i(TAG, "insertContentTextData, len: " + notesDocumentTextSearchEntity.getStrippedContent().length());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentContentRepository().updateStrippedContent(notesDocumentTextSearchEntity.getDocUuid(), notesDocumentTextSearchEntity.getFilePath(), notesDocumentTextSearchEntity.getStrippedContent());
        SDocEncryptionHelper.encryptTextSearchData(BaseUtils.getContext(), notesDocumentTextSearchEntity.getDocUuid());
    }

    public static void insertPageSearchInfoEntities(@NonNull List<NotesPageSearchInfoEntity> list) {
        DataLogger.m12307i(TAG, "insertPageSearchInfoEntities#, count : " + list.size());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createPageSearchInfoRepository().insert(list);
    }

    public static void insertSDocSearchEntities(SpenSDoc.SearchData searchData, String str, String str2) {
        DataLogger.m12307i(TAG, "insertSDocSearchEntities");
        NotesStrokeSearchEntity notesStrokeSearchEntityConvertToEntity = convertToEntity(searchData, str, str2);
        NotesStrokeRepository notesStrokeRepositoryCreateDocumentStrokeRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository();
        notesStrokeSearchEntityConvertToEntity.setDocUuid(str);
        notesStrokeRepositoryCreateDocumentStrokeRepository.insert(notesStrokeSearchEntityConvertToEntity);
    }

    public static void insertStickyBodyTextEntities(@NonNull List<StickyTextEntity> list) {
        DataLogger.m12307i(TAG, "insertStickyBodyTextEntities#, count : " + list.size());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createStickyTextRepository().insert(list);
    }

    public static void insertStickyStrokeSearchEntities(@NonNull List<StickyStrokeSearchEntity> list) {
        DataLogger.m12307i(TAG, "insertStickyStrokeSearchEntities#, count : " + list.size());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createStickyStrokeRepository().insert(list);
    }

    public static void insertStrokeSearchEntities(@NonNull List<NotesStrokeSearchEntity> list) {
        DataLogger.m12307i(TAG, "insertStrokeSearchEntities#, count : " + list.size());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().insert(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$setActionLinkData$0(String str) {
        return new ArrayList();
    }

    private static ArrayList<SpenWPage.StrokeRecognitionData> mergeSearchActionLinkData(ArrayList<SpenWPage.SearchData> arrayList, ArrayList<SpenWPage.ActionLinkData> arrayList2) {
        ArrayList<SpenWPage.StrokeRecognitionData> arrayList3 = new ArrayList<>();
        CopyOnWriteArrayList<SpenWPage.ActionLinkData> copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (arrayList2 != null) {
            copyOnWriteArrayList.addAll(arrayList2);
        }
        for (SpenWPage.SearchData searchData : arrayList) {
            SpenWPage.StrokeRecognitionData strokeRecognitionData = new SpenWPage.StrokeRecognitionData();
            strokeRecognitionData.text = searchData.text;
            strokeRecognitionData.rect = searchData.rect;
            strokeRecognitionData.pageWidth = searchData.pageWidth;
            for (SpenWPage.ActionLinkData actionLinkData : copyOnWriteArrayList) {
                if (searchData.text.equals(actionLinkData.linkStr) && searchData.rect.equals(actionLinkData.strokeRect)) {
                    SpenWPage.StrokeRecognitionData.LinkData linkData = new SpenWPage.StrokeRecognitionData.LinkData();
                    strokeRecognitionData.actionLinkData = linkData;
                    linkData.indexList = new ArrayList<>();
                    SpenWPage.StrokeRecognitionData.LinkData linkData2 = strokeRecognitionData.actionLinkData;
                    linkData2.type = actionLinkData.linkType;
                    linkData2.firstCharRect = actionLinkData.firstCharRect;
                    linkData2.lastCharRect = actionLinkData.lastCharRect;
                    linkData2.indexList.addAll(actionLinkData.handleList);
                    strokeRecognitionData.actionLinkData.repObjectUuid = actionLinkData.repObjectUuid;
                    copyOnWriteArrayList.remove(actionLinkData);
                }
            }
            arrayList3.add(strokeRecognitionData);
        }
        return arrayList3;
    }

    public static void removePageSearchInfoEntities(List<NotesPageSearchInfoEntity> list) {
        DataLogger.m12307i(TAG, "removePageSearchInfoEntities#, count : " + list.size());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createPageSearchInfoRepository().delete(list);
    }

    public static void removeStickySearchEntities(String str) {
        DataLogger.m12307i(TAG, "removeStickySearchEntities#, uuid : " + str);
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createStickyStrokeRepository().deleteByUuid(Collections.singleton(str));
    }

    public static void removeStrokeSearchEntities(String str, Set<String> set) {
        DataLogger.m12307i(TAG, "removeStrokeSearchEntities#, uuid : " + str);
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().deleteByUuidAndPageIds(str, new ArrayList(set));
    }

    public static void removeStrokeSearchEntitiesWithType(String str, @NonNull Set<String> set, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("removeStrokeSearchEntitiesWithType#, uuid/page count/includeTypes : ", str, "/");
        sbM15l.append(set.size());
        sbM15l.append("/");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().deleteByUuidAndPageIds(str, new ArrayList(set), iArr);
    }

    public static void removeStrokeSearchEntitiesWithTypes(String str, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("removeStrokeSearchEntitiesWithTypes#, uuid/types : ", str, "/");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().deleteByUuidWithTypes(str, iArr);
    }

    private static void setActionLinkData(SpenSDoc spenSDoc, String str, List<NotesStrokeSearchEntity> list) {
        SpenContentBase content;
        SpenContentHandWriting spenContentHandWriting;
        ArrayList<SpenContentHandWriting.ActionLinkData> actionLinkData;
        String attachedFile;
        String str2 = TAG;
        DataLogger.m12307i(str2, "setActionLinkData, doc: " + spenSDoc);
        if (list == null || list.isEmpty()) {
            DataLogger.m12307i(str2, "setActionLinkData, actionLinkDataList is null or empty");
            return;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < spenSDoc.getContentCount(); i++) {
            SpenContentBase content2 = spenSDoc.getContent(i);
            if (content2.getType() == 3 && (attachedFile = ((SpenContentHandWriting) content2).getAttachedFile()) != null) {
                String[] strArrSplit = attachedFile.split("/");
                if (strArrSplit.length > 1) {
                    ((List) map.computeIfAbsent(strArrSplit[strArrSplit.length - 1], new C11419a(1))).add(Integer.valueOf(i));
                }
            }
        }
        List<Integer> list2 = (List) map.get(str);
        if (list2 != null) {
            for (Integer num : list2) {
                if (num != null && (content = spenSDoc.getContent(num.intValue())) != null && content.getType() == 3 && ((actionLinkData = (spenContentHandWriting = (SpenContentHandWriting) content).getActionLinkData()) == null || actionLinkData.isEmpty())) {
                    ArrayList<SpenContentHandWriting.ActionLinkData> arrayList = new ArrayList<>();
                    for (NotesStrokeSearchEntity notesStrokeSearchEntity : list) {
                        arrayList.add(StrokeDataJsonConverter.getActionLinkDataFromJsonStr(notesStrokeSearchEntity.getActionLinkData(), notesStrokeSearchEntity.getPageWidth().intValue()));
                    }
                    spenContentHandWriting.setActionLinkData(arrayList);
                }
            }
        }
    }

    public static void setDoneState(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iUpdateState = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository().updateState(str, 2);
        String str2 = TAG;
        DataLogger.m12307i(str2, "setDoneState, uuid/result " + str + "/" + iUpdateState);
        StringBuilder sb = new StringBuilder();
        AbstractC2821a.m2207B(sb, str2, " setDoneState, uuid/result ", str, "/");
        sb.append(iUpdateState);
        CollectTestLogger.log(sb.toString());
    }

    public static void setReadyState(String str, long j, @RetryState int i) {
        String str2 = TAG;
        DataLogger.m12307i(str2, "setReadyState, uuid/retryState " + str + "/" + i);
        StringBuilder sb = new StringBuilder();
        AbstractC2821a.m2207B(sb, str2, " setReadyState, uuid/retryState ", str, "/");
        sb.append(i);
        CollectTestLogger.log(sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesRetryRepository notesRetryRepositoryCreateDocumentRetryRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository();
        notesRetryRepositoryCreateDocumentRetryRepository.deleteByUuid(str);
        notesRetryRepositoryCreateDocumentRetryRepository.insert(createRetryEntity(str, j, i));
    }

    private static void setSDocSearchDataFromEntry(SpenSDoc spenSDoc, Map.Entry<String, ArrayList<NotesStrokeSearchEntity>> entry) {
        String key = entry.getKey();
        ArrayList<SpenSDoc.SearchData> arrayList = new ArrayList<>();
        Iterator<NotesStrokeSearchEntity> it = entry.getValue().iterator();
        while (it.hasNext()) {
            arrayList.add(getSDocSearchDataFromEntity(it.next()));
        }
        spenSDoc.setSearchData(key, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setSearchEntityToNoteDoc(SpenSDoc spenSDoc, String str, List<NotesStrokeSearchEntity> list, List<NotesStrokeSearchEntity> list2) {
        SpenSDoc spenSDoc2;
        Throwable th;
        Throwable th2;
        StringBuilder sb;
        String str2;
        IOException iOException;
        try {
            try {
                Iterator it = ((Map) list.stream().collect(Collectors.groupingBy(new C11419a(0), Collectors.toCollection(new C2747a(26))))).entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        setSDocSearchDataFromEntry(spenSDoc, (Map.Entry) it.next());
                    } catch (IOException e) {
                        e = e;
                        th2 = e;
                        spenSDoc2 = spenSDoc;
                        DataLogger.m12303e(TAG, "setSearchEntityToNoteDoc, exception : " + th2.getMessage());
                        if (spenSDoc2 != null) {
                            try {
                                if (!spenSDoc2.isClosed()) {
                                    spenSDoc2.close(true);
                                }
                            } catch (IOException e2) {
                                iOException = e2;
                                str2 = TAG;
                                sb = new StringBuilder("setSearchEntityToNoteDoc, close doc failed, e : ");
                                AbstractC11014a.m12332q(iOException, sb, str2);
                            }
                        }
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        th2 = e;
                        spenSDoc2 = spenSDoc;
                        DataLogger.m12303e(TAG, "setSearchEntityToNoteDoc, exception : " + th2.getMessage());
                        if (spenSDoc2 != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        spenSDoc2 = spenSDoc;
                        if (spenSDoc2 == null) {
                        }
                    }
                }
                setActionLinkData(spenSDoc, new File(str).getName(), list2);
                spenSDoc2 = spenSDoc;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (spenSDoc2 == null) {
                    throw th;
                }
                try {
                    if (spenSDoc2.isClosed()) {
                        throw th;
                    }
                    spenSDoc2.close(true);
                    throw th;
                } catch (IOException e5) {
                    AbstractC11014a.m12332q(e5, new StringBuilder("setSearchEntityToNoteDoc, close doc failed, e : "), TAG);
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            spenSDoc2 = spenSDoc;
            th2 = e;
            DataLogger.m12303e(TAG, "setSearchEntityToNoteDoc, exception : " + th2.getMessage());
            if (spenSDoc2 != null) {
            }
        } catch (IllegalArgumentException e7) {
            e = e7;
            spenSDoc2 = spenSDoc;
            th2 = e;
            DataLogger.m12303e(TAG, "setSearchEntityToNoteDoc, exception : " + th2.getMessage());
            if (spenSDoc2 != null) {
            }
        } catch (Throwable th5) {
            th = th5;
            spenSDoc2 = spenSDoc;
            th = th;
            if (spenSDoc2 == null) {
            }
        }
        try {
            spenSDoc2.save(str, ToolConstructor.makeSDocLocker(ApplicationManager.getInstance().getAppContext()).getUserCode(), true, spenSDoc.getCreatedTime(), spenSDoc.getModifiedTime());
            try {
                if (!spenSDoc2.isClosed()) {
                    spenSDoc2.close(true);
                }
            } catch (IOException e8) {
                iOException = e8;
                str2 = TAG;
                sb = new StringBuilder("setSearchEntityToNoteDoc, close doc failed, e : ");
                AbstractC11014a.m12332q(iOException, sb, str2);
            }
        } catch (IOException e9) {
            e = e9;
            th2 = e;
            DataLogger.m12303e(TAG, "setSearchEntityToNoteDoc, exception : " + th2.getMessage());
            if (spenSDoc2 != null) {
            }
        } catch (IllegalArgumentException e10) {
            e = e10;
            th2 = e;
            DataLogger.m12303e(TAG, "setSearchEntityToNoteDoc, exception : " + th2.getMessage());
            if (spenSDoc2 != null) {
            }
        }
    }

    public static void removeStrokeSearchEntities(String str, @NonNull Set<String> set, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("removeStrokeSearchEntities#, uuid/page count/excludeTypes : ", str, "/");
        sbM15l.append(set.size());
        sbM15l.append("/");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().deleteByUuidAndPageIdsWithExcludedTypes(str, new ArrayList(set), iArr);
    }
}
