package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import com.samsung.android.support.senl.p148nt.model.utils.OldDocumentThumbnailUtils;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.util.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10065b implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7106a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7107b;

    public /* synthetic */ C10065b(String str, int i) {
        this.f7106a = i;
        this.f7107b = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f7106a) {
            case 0:
                return ComposerCacheFileUtil.lambda$deleteNoteAppAttachFolder$6(this.f7107b, file, str);
            case 1:
                return PwFileManager.lambda$deleteUnexpectedFile$3(this.f7107b, file, str);
            case 2:
                return NotesDocumentDeleteUtils.lambda$deleteSPenDocument$2(this.f7107b, file, str);
            default:
                return OldDocumentThumbnailUtils.lambda$deleteThumbnails$0(this.f7107b, file, str);
        }
    }
}
