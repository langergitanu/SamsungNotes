package opennlp.tools.formats;

import opennlp.tools.cmdline.ObjectStreamFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSampleStreamFactory<T, P> implements ObjectStreamFactory<T, P> {
    protected Class<P> params;

    private AbstractSampleStreamFactory() {
    }

    public String getLang() {
        return "eng";
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public Class<P> getParameters() {
        return this.params;
    }

    public AbstractSampleStreamFactory(Class<P> cls) {
        this.params = cls;
    }
}
