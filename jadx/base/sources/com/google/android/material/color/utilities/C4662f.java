package com.google.android.material.color.utilities;

import android.os.Bundle;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import com.samsung.android.sdk.pen.ocr.SpenOcrBlockData;
import com.samsung.android.sdk.pen.ocr.SpenOcrPageData;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paUtils;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverStickerPresenter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: renamed from: com.google.android.material.color.utilities.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4662f implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2301a;

    public /* synthetic */ C4662f(int i) {
        this.f2301a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2301a) {
            case 0:
                return MaterialDynamicColors.lambda$textHintInverse$161((DynamicScheme) obj);
            case 1:
                return ((DynamicScheme) obj).neutralPalette;
            case 2:
                return MaterialDynamicColors.lambda$shadow$47((DynamicScheme) obj);
            case 3:
                return ((DynamicScheme) obj).neutralPalette;
            case 4:
                return MaterialDynamicColors.lambda$onSurface$32((DynamicScheme) obj);
            case 5:
                return MaterialDynamicColors.lambda$surfaceContainerHighest$30((DynamicScheme) obj);
            case 6:
                return ((DynamicScheme) obj).primaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$primaryFixed$104((DynamicScheme) obj);
            case 8:
                return ((DynamicScheme) obj).primaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$primaryFixedDim$107((DynamicScheme) obj);
            case 10:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 11:
                return MaterialDynamicColors.lambda$tertiaryContainer$86((DynamicScheme) obj);
            case 12:
                return (CsvException) ((OrderedObject) obj).getElement();
            case 13:
                return ((OrderedObject) obj).getElement();
            case 14:
                return SpenOcrPageData.lambda$findNearestTextBlock$0((SpenOcrBlockData) obj);
            case 15:
                return LlmServiceRunnable.singleResultMapper((List) obj);
            case 16:
                return LlmServiceRunnable.listResultMapper((List) obj);
            case 17:
                return new Result((Bundle) obj);
            case 18:
                return Collections.unmodifiableSet((Set) obj);
            case 19:
                return NeuralTranslator.lambda$getAvailableLanguageDirectionStringList$10((LanguageDirection) obj);
            case 20:
                return ((LanguageDirection) obj).getSourceLanguage();
            case 21:
                return (LanguageDirection) ((Map.Entry) obj).getKey();
            case 22:
                return ((LanguageDirection) obj).getTargetLanguage();
            case 23:
                return C2paUtils.getParcelFileDescriptor((String) obj);
            case 24:
                return C2paUtils.getFileExtension((String) obj);
            case 25:
                return ((DeletedNote) obj).getFilePath();
            case 26:
                return CoverStickerPresenter.lambda$updateDownloadedCategories$0((CoverStickerData) obj);
            case 27:
                return ((NotesDocumentCountEntry) obj).getUuid();
            case 28:
                return MainListDocumentDataDao.lambda$makeDocumentCountEntries$2((NotesDocumentCountEntry) obj);
            default:
                return NotesDocumentDao.lambda$updateTargets$2((String) obj);
        }
    }
}
