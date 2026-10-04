package com.samsung.android.support.senl.p148nt.stt.presenter;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.controller.STTVoiceDataController;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class C11534m implements DocumentFileManager.IOAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7908a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ List f7909b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7910c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f7911d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f7912e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f7913f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f7914g;

    public /* synthetic */ C11534m(SpenVoiceData spenVoiceData, String[] strArr, int[] iArr, List list, STTUpdateDataTask sTTUpdateDataTask, Map map) {
        this.f7910c = spenVoiceData;
        this.f7911d = strArr;
        this.f7912e = iArr;
        this.f7909b = list;
        this.f7913f = sTTUpdateDataTask;
        this.f7914g = map;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public final Object operate() {
        switch (this.f7908a) {
            case 0:
                return STTUpdateDataTask.C115191.invokeSuspend$lambda$0((SpenVoiceData) this.f7910c, (String[]) this.f7911d, (int[]) this.f7912e, this.f7909b, (STTUpdateDataTask) this.f7913f, (Map) this.f7914g);
            default:
                return STTUpdateDataTask.C115201.invokeSuspend$lambda$0(this.f7909b, (SpenVoiceTextDataReaderCache) this.f7910c, (STTVoiceDataController) this.f7911d, (Context) this.f7912e, (String) this.f7913f, (ArrayList) this.f7914g);
        }
    }

    public /* synthetic */ C11534m(List list, SpenVoiceTextDataReaderCache spenVoiceTextDataReaderCache, STTVoiceDataController sTTVoiceDataController, Context context, String str, ArrayList arrayList) {
        this.f7909b = list;
        this.f7910c = spenVoiceTextDataReaderCache;
        this.f7911d = sTTVoiceDataController;
        this.f7912e = context;
        this.f7913f = str;
        this.f7914g = arrayList;
    }
}
