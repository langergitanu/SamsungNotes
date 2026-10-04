package opennlp.tools.formats;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LanguageSampleStreamFactory<T, P> extends AbstractSampleStreamFactory<T, P> {
    protected String language;

    public LanguageSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    @Override // opennlp.tools.formats.AbstractSampleStreamFactory
    public String getLang() {
        return this.language;
    }
}
