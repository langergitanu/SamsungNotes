package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import android.content.Context;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.document.SmDocumentManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyTextEntity;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.jsonwrapper.StrokeDataJsonConverter;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.facade.RecognitionFacade;
import com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class StickySearchCollector extends AbsCollector implements ICollector {
    private static final String TAG = CollectLogger.createTag("StickySearchCollector");

    public StickySearchCollector(ICollectStateListener iCollectStateListener) {
        super(iCollectStateListener);
    }

    private void collectStickyNoteBodyTextData(SpenWNote spenWNote, String str, ICollectRepository iCollectRepository) {
        iCollectRepository.setStickyBodyTextData(getBodyTextDataInfo(spenWNote.getBodyText().getText(), str));
    }

    private void collectStickyNoteObjectRecognitionData(Context context, SpenWNote spenWNote, String str, String str2, ICollectRepository iCollectRepository) {
        List<TextInfo> listRecognizeWord = new RecognitionFacade().recognizeWord(context, str, spenWNote, getPageIds(spenWNote), new CancellationSignal());
        iCollectRepository.setStickyStrokeSearchData(getStrokeSearchDataInfo(listRecognizeWord, str2));
        iCollectRepository.setStickyStrokeActionLinkData(getStrokeActionLinkDataInfo(listRecognizeWord, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void collectStickySearchData(CollectInfo collectInfo, ICollectRepository iCollectRepository) throws Throwable {
        String str;
        int i;
        Throwable th;
        String str2;
        StringBuilder sb;
        DataLogger.m12302d(TAG, "collectStickySearchData");
        Context context = BaseUtils.getContext();
        SpenWNote wNote = collectInfo.getWNote();
        String uuid = collectInfo.getUuid();
        int defWidth = SmDocumentManager.getDefWidth(context);
        for (SpenWPage spenWPage : wNote.getPageList()) {
            int customObjectCount = spenWPage.getCustomObjectCount();
            int i2 = 0;
            while (i2 < customObjectCount) {
                SpenCustomObject customObject = spenWPage.getCustomObject(i2);
                if (customObject != null && (customObject instanceof SpenStickyNote)) {
                    String attachedFile = customObject.getAttachedFile();
                    if (!TextUtils.isEmpty(attachedFile) && AbstractC2322a.m1607A(attachedFile)) {
                        String id = customObject.getId();
                        SpenWNote spenWNote = null;
                        try {
                            SpenWNote spenWNoteMakeSpenWNote = DocumentConstructor.makeSpenWNote(context, attachedFile, defWidth, 2000, false, false);
                            i = defWidth;
                            str = uuid;
                            Context context2 = context;
                            try {
                                collectStickyNoteObjectRecognitionData(context2, spenWNoteMakeSpenWNote, str, id, iCollectRepository);
                                context = context2;
                                try {
                                    collectStickyNoteBodyTextData(spenWNoteMakeSpenWNote, id, iCollectRepository);
                                    if (spenWNoteMakeSpenWNote != null) {
                                        try {
                                            spenWNoteMakeSpenWNote.close(true);
                                        } catch (Exception e) {
                                            e = e;
                                            str2 = TAG;
                                            sb = new StringBuilder("collectStickySearchData, note close exception : ");
                                            sb.append(e.getMessage());
                                            DataLogger.m12302d(str2, sb.toString());
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    spenWNote = spenWNoteMakeSpenWNote;
                                    try {
                                        DataLogger.m12302d(TAG, "collectStickySearchData, exception : " + e.getMessage());
                                        if (spenWNote != null) {
                                            try {
                                                spenWNote.close(true);
                                            } catch (Exception e3) {
                                                e = e3;
                                                str2 = TAG;
                                                sb = new StringBuilder("collectStickySearchData, note close exception : ");
                                                sb.append(e.getMessage());
                                                DataLogger.m12302d(str2, sb.toString());
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        th = th;
                                        if (spenWNote == null) {
                                            throw th;
                                        }
                                        try {
                                            spenWNote.close(true);
                                            throw th;
                                        } catch (Exception e5) {
                                            DataLogger.m12302d(TAG, "collectStickySearchData, note close exception : " + e5.getMessage());
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    th = th;
                                    spenWNote = spenWNoteMakeSpenWNote;
                                    if (spenWNote == null) {
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                context = context2;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str = uuid;
                            i = defWidth;
                        } catch (Throwable th5) {
                            th = th5;
                            th = th;
                            if (spenWNote == null) {
                            }
                        }
                    } else {
                        str = uuid;
                        i = defWidth;
                    }
                }
                i2++;
                uuid = str;
                defWidth = i;
            }
            uuid = uuid;
        }
    }

    private StickyTextEntity getBodyTextDataInfo(String str, String str2) {
        StickyTextEntity stickyTextEntity = new StickyTextEntity();
        stickyTextEntity.setObjectId(str2);
        stickyTextEntity.setText(str);
        return stickyTextEntity;
    }

    private List<String> getPageIds(SpenWNote spenWNote) {
        ArrayList arrayList = new ArrayList();
        Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        return arrayList;
    }

    private List<StickyStrokeSearchEntity> getStrokeActionLinkDataInfo(List<TextInfo> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (TextInfo textInfo : list) {
            if (textInfo.linkType != -1) {
                StickyStrokeSearchEntity stickyStrokeSearchEntity = new StickyStrokeSearchEntity();
                stickyStrokeSearchEntity.setObjectId(str);
                stickyStrokeSearchEntity.setType(2);
                stickyStrokeSearchEntity.setPageWidth(textInfo.pageWidth);
                SpenWPage.ActionLinkData actionLinkData = new SpenWPage.ActionLinkData();
                actionLinkData.linkStr = textInfo.linkStr;
                actionLinkData.repObjectUuid = textInfo.repObjectUuid;
                actionLinkData.handleList = textInfo.linkObjects;
                actionLinkData.lastCharRect = textInfo.lastCharRect;
                actionLinkData.firstCharRect = textInfo.leftCharRect;
                actionLinkData.linkType = textInfo.linkType;
                actionLinkData.strokeRect = textInfo.strokeRect;
                actionLinkData.pageWidth = textInfo.pageWidth;
                String jsonStrFromActionLinkData = StrokeDataJsonConverter.getJsonStrFromActionLinkData(actionLinkData);
                if (jsonStrFromActionLinkData == null) {
                    jsonStrFromActionLinkData = "";
                }
                stickyStrokeSearchEntity.setActionLinkData(jsonStrFromActionLinkData);
                arrayList.add(stickyStrokeSearchEntity);
            }
        }
        return arrayList;
    }

    private List<StickyStrokeSearchEntity> getStrokeSearchDataInfo(List<TextInfo> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (TextInfo textInfo : list) {
            if (textInfo.linkType == -1) {
                StickyStrokeSearchEntity stickyStrokeSearchEntity = new StickyStrokeSearchEntity();
                stickyStrokeSearchEntity.setObjectId(str);
                stickyStrokeSearchEntity.setText(textInfo.str.trim());
                stickyStrokeSearchEntity.setLeft((int) textInfo.rect.left);
                stickyStrokeSearchEntity.setTop((int) textInfo.rect.top);
                stickyStrokeSearchEntity.setBottom((int) textInfo.rect.bottom);
                stickyStrokeSearchEntity.setRight((int) textInfo.rect.right);
                stickyStrokeSearchEntity.setPageWidth(textInfo.pageWidth);
                stickyStrokeSearchEntity.setType(1);
                arrayList.add(stickyStrokeSearchEntity);
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean collect(CollectInfo collectInfo, ICollectRepository iCollectRepository) throws Throwable {
        if (isCanceled()) {
            StickySearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        if (!isSupported() || !isAvailable(collectInfo) || !hasStickyMemo(collectInfo)) {
            DataLogger.m12302d(TAG, "collect not executed, not supported or not available");
            StickySearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
            return collectNext(collectInfo, iCollectRepository);
        }
        DataLogger.m12302d(TAG, "collect");
        preCollect(collectInfo, iCollectRepository);
        StickySearchCollectListenerManager.getInstance().notifyOnCollectStarted(collectInfo);
        try {
            collectStickySearchData(collectInfo, iCollectRepository);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("collect, exception: "), TAG);
        }
        if (isCanceled()) {
            StickySearchCollectListenerManager.getInstance().notifyOnCollectCanceled(collectInfo, iCollectRepository);
        } else {
            postCollect(collectInfo, iCollectRepository);
            StickySearchCollectListenerManager.getInstance().notifyOnCollectFinished(collectInfo, iCollectRepository);
        }
        return collectNext(collectInfo, iCollectRepository);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public boolean fail(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        StickySearchCollectListenerManager.getInstance().notifyOnCollectFailed(collectInfo, iCollectRepository);
        return failNext(collectInfo, iCollectRepository);
    }

    public boolean hasStickyMemo(CollectInfo collectInfo) {
        return collectInfo.getWNote().hasCustomObject();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void postCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "postCollect");
        CollectResolver.insertStickyStrokeSearchEntities(iCollectRepository.getStickyStrokeSearchData());
        CollectResolver.insertStickyStrokeSearchEntities(iCollectRepository.getStickyStrokeActionLinkData());
        CollectResolver.insertStickyBodyTextEntities(iCollectRepository.getStickyBodyTextData());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.AbsCollector, com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollector
    public void preCollect(CollectInfo collectInfo, ICollectRepository iCollectRepository) {
        DataLogger.m12302d(TAG, "preCollect");
        CollectResolver.removeStickySearchEntities(collectInfo.getUuid());
    }
}
