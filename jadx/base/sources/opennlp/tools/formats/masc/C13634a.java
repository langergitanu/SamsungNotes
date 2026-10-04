package opennlp.tools.formats.masc;

import java.io.File;
import java.io.FileFilter;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.formats.masc.MascNamedEntitySampleStreamFactory;
import opennlp.tools.formats.masc.MascPOSSampleStreamFactory;
import opennlp.tools.formats.masc.MascSentenceSampleStreamFactory;
import opennlp.tools.formats.masc.MascTokenSampleStreamFactory;

/* JADX INFO: renamed from: opennlp.tools.formats.masc.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13634a implements FileFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9664a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ BasicFormatParams f9665b;

    public /* synthetic */ C13634a(BasicFormatParams basicFormatParams, int i) {
        this.f9664a = i;
        this.f9665b = basicFormatParams;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f9664a) {
            case 0:
                return MascNamedEntitySampleStreamFactory.lambda$create$0((MascNamedEntitySampleStreamFactory.Parameters) this.f9665b, file);
            case 1:
                return MascPOSSampleStreamFactory.lambda$create$0((MascPOSSampleStreamFactory.Parameters) this.f9665b, file);
            case 2:
                return MascSentenceSampleStreamFactory.lambda$create$0((MascSentenceSampleStreamFactory.Parameters) this.f9665b, file);
            default:
                return MascTokenSampleStreamFactory.lambda$create$0((MascTokenSampleStreamFactory.Parameters) this.f9665b, file);
        }
    }
}
