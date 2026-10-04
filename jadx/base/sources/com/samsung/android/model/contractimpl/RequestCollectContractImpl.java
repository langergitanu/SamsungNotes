package com.samsung.android.model.contractimpl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.contract.RequestCollectContract;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RequestCollectContractImpl implements RequestCollectContract {
    private static final String TAG = "RequestCollectContractImpl";

    @Override // com.samsung.android.support.senl.p148nt.data.contract.RequestCollectContract
    public void cancelCollect() {
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setActionType(ICollectParam.ActionType.CANCEL.getValue()).build());
    }

    @Override // com.samsung.android.support.senl.p148nt.data.contract.RequestCollectContract
    public int getSourceType(@SearchConstants.Source int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? ICollectParam.SourceType.OTHERS.getValue() : ICollectParam.SourceType.SMART_SWITCH.getValue() : ICollectParam.SourceType.SYNC.getValue() : ICollectParam.SourceType.IMPORT.getValue() : ICollectParam.SourceType.COMPOSER.getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.contract.RequestCollectContract
    public void pausePdfCollect(@NonNull Class<?> cls, @NonNull String str) {
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setPdfActionCaller(cls).setPdfActionKey(str).setActionType(ICollectParam.ActionType.PAUSE_PDF.getValue()).build());
    }

    @Override // com.samsung.android.support.senl.p148nt.data.contract.RequestCollectContract
    public void resumePdfCollect(@NonNull Class<?> cls, @NonNull String str) {
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setPdfActionCaller(cls).setPdfActionKey(str).setActionType(ICollectParam.ActionType.RESUME_PDF.getValue()).build());
    }

    @Override // com.samsung.android.support.senl.p148nt.data.contract.RequestCollectContract
    public void startCollect(String str, String str2, long j, List<String> list, int i, boolean z) {
        int value;
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            DataLogger.m12309w(TAG, "startCollect, context is null");
            return;
        }
        if (NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentRetryRepository().getVersion(str) < 1) {
            value = ICollectParam.SourceType.OTHERS.getValue();
            DataLogger.m12307i(TAG, "startCollect, recover missing search data");
        } else {
            value = i;
        }
        CollectResolver.setReadyState(str, j, 1);
        CollectParam.CollectParamBuilder collectParamBuilder = new CollectParam.CollectParamBuilder();
        collectParamBuilder.setUuid(str).setLastModifiedAt(j).setInReadyState(true).setTriggerType(ICollectParam.TriggerType.SAVE.getValue()).setActionType(ICollectParam.ActionType.START.getValue()).setSourceType(value).setPriority((i == ICollectParam.SourceType.COMPOSER.getValue() ? ICollectParam.Priority.FOREGROUND : ICollectParam.Priority.BACKGROUND).getValue()).setIsNewNote(z).setLinkWith(ICollectParam.LinkWith.DEFAULT.getValue()).setChangedPageIdList(list);
        CollectController.getInstance().postCollectorTask(collectParamBuilder.build());
    }
}
