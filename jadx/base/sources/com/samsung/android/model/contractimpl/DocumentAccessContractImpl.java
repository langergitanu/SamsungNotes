package com.samsung.android.model.contractimpl;

import android.content.Context;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.importer.ImportProcessor;
import com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p044K.C0158a;
import p186h1.C12028i;
import p244u1.C14477a;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DocumentAccessContractImpl implements DocumentAccessHandler.DocumentAccessContract {
    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public void cancelAllConvertTasks() {
        ConvertTaskManager.getInstance().cancelAll();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public void cancelImportBySetting() {
        ImportProcessor.cancel();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public void cancelImportCloudDataBySetting() {
        C14497a c14497aM15078a = C14497a.m15078a();
        c14497aM15078a.getClass();
        C0158a.m407a().getClass();
        if (C0158a.m411g()) {
            c14497aM15078a.f10310a.m4894a(new C12028i(), true);
        } else {
            Debugger.m8615i("ImportManager", "stopImportForce : not supported!)");
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public boolean copyDocument(Context context, String str, String str2) {
        return DocumentCopyUtils.copy(context, str, str2);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public void createCoverPreview(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i) {
        CoverEditorUtils.savePreviewJpg(context, str, str2, str3, str4, str5, i);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public Class<?> getDocOpenTriggerClass() {
        return DocOpenTriggerActivity.class;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public boolean isExternalCoeditRunning() {
        return CoeditNoteUpDownloader.getInstance().isExistRunningNoteUuids();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public boolean isSmartSwitchRunning() {
        String str = C0148f.f420k;
        return AbstractC0147e.f419a.m365f();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.document.DocumentAccessHandler.DocumentAccessContract
    public boolean isSyncRunning() {
        return !C14477a.m15065b().f10283a.m5099h();
    }
}
