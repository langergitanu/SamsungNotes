package opennlp.tools.p217ml.maxent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BasicContextGenerator implements ContextGenerator<String> {
    private String separator;

    public BasicContextGenerator() {
        this.separator = " ";
    }

    @Override // opennlp.tools.p217ml.maxent.ContextGenerator
    public String[] getContext(String str) {
        return str.split(this.separator);
    }

    public BasicContextGenerator(String str) {
        this.separator = str;
    }
}
