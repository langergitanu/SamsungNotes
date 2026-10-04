package p009B3;

import com.samsung.android.sdk.handwriting.resources.impl.HWRPreloadLanguageManager;
import com.samsung.android.sdk.pdf.SpenPdfAIModelLoader;
import com.samsung.android.sdk.pen.recogengine.resources.SpenResourceProviderFile;
import com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdDataHandler;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion42;
import com.samsung.android.support.senl.p148nt.model.service.NotesDocumentServiceIntentHandler;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: renamed from: B3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0035a implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f172a;

    public /* synthetic */ C0035a(int i) {
        this.f172a = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f172a) {
            case 0:
                return CoverStickerDownloadUtils.lambda$getDownloadedStickerDrawableList$0(file, str);
            case 1:
                return MigrationToVersion42.lambda$migrateBackgroundColor$0(file, str);
            case 2:
                return HWRPreloadLanguageManager.lambda$readExistingPreloadedResList$0(file, str);
            case 3:
                return HWRPreloadLanguageManager.lambda$readExistingPreloadedResList$1(file, str);
            case 4:
                return SpenCrowdDataHandler.getData$lambda$3(file, str);
            case 5:
                return DummyDocumentDetector.lambda$getSPenDocument$2(file, str);
            case 6:
                return WDocUtils.getSdkCacheDocCount$lambda$0(file, str);
            case 7:
                return ComposerCacheFileUtil.lambda$trimPdfWriterDir$0(file, str);
            case 8:
                return ComposerCacheFileUtil.lambda$trimPageThumbnail$2(file, str);
            case 9:
                return ComposerCacheFileUtil.lambda$deleteNoteAppAttachFolder$7(file, str);
            case 10:
                return PwFileManager.lambda$getValidCacheFiles$0(file, str);
            case 11:
                return PwFileManager.lambda$trimDummy$1(file, str);
            case 12:
                return NotesDocumentServiceIntentHandler.lambda$restorePDFWriterCaches$1(file, str);
            case 13:
                return NotesDocumentServiceIntentHandler.lambda$removeCacheAndResave$2(file, str);
            case 14:
                return NotesDocumentServiceIntentHandler.lambda$restoreDocumentCaches$0(file, str);
            case 15:
                return DocumentCacheUtils.lambda$existCacheFiles$0(file, str);
            case 16:
                return DocumentCacheUtils.lambda$getCacheCount$1(file, str);
            case 17:
                return SpenPdfAIModelLoader.deleteOldModelFiles$lambda$1(file, str);
            default:
                return SpenResourceProviderFile.getHWRDBfilenames$lambda$1$lambda$0(file, str);
        }
    }
}
