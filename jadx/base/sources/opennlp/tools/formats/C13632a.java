package opennlp.tools.formats;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

/* JADX INFO: renamed from: opennlp.tools.formats.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13632a implements DirectoryStream.Filter {
    @Override // java.nio.file.DirectoryStream.Filter
    public final boolean accept(Object obj) {
        return TwentyNewsgroupSampleStream.lambda$new$0((Path) obj);
    }
}
