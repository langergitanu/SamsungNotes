package com.samsung.android.support.senl.p145cm.base.framework.content;

import java.io.File;
import java.io.FileFilter;
import opennlp.tools.formats.leipzig.LeipzigLanguageSampleStream;
import opennlp.tools.formats.masc.MascDocumentStream;
import opennlp.tools.formats.muc.Muc6NameSampleStreamFactory;
import opennlp.tools.formats.ontonotes.OntoNotesNameSampleStreamFactory;
import opennlp.tools.formats.ontonotes.OntoNotesParseSampleStreamFactory;

/* JADX INFO: renamed from: com.samsung.android.support.senl.cm.base.framework.content.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C7969a implements FileFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5787a;

    public /* synthetic */ C7969a(int i) {
        this.f5787a = i;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f5787a) {
            case 0:
                return ClipboardManagerCompat.deleteClipboardFolders$lambda$0(file);
            case 1:
                return LeipzigLanguageSampleStream.lambda$new$0(file);
            case 2:
                return MascDocumentStream.lambda$new$0(file);
            case 3:
                return Muc6NameSampleStreamFactory.lambda$create$0(file);
            case 4:
                return OntoNotesNameSampleStreamFactory.lambda$create$0(file);
            default:
                return OntoNotesParseSampleStreamFactory.lambda$create$0(file);
        }
    }
}
