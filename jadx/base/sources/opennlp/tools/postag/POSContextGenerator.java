package opennlp.tools.postag;

import opennlp.tools.util.BeamSearchContextGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface POSContextGenerator extends BeamSearchContextGenerator<String> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // opennlp.tools.util.BeamSearchContextGenerator
    String[] getContext(int i, String[] strArr, String[] strArr2, Object[] objArr);
}
