package opennlp.tools.cmdline;

import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractEvaluatorTool<T, P> extends AbstractTypedParamTool<T, P> {
    protected ObjectStreamFactory<T, P> factory;
    protected P params;
    protected ObjectStream<T> sampleStream;

    public AbstractEvaluatorTool(Class<T> cls, Class<P> cls2) {
        super(cls, cls2);
    }

    @Override // opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        validateAllArgs(strArr, this.paramsClass, str);
        this.params = (P) ArgumentParser.parse(ArgumentParser.filter(strArr, this.paramsClass), this.paramsClass);
        ObjectStreamFactory<T, P> streamFactory = getStreamFactory(str);
        this.factory = streamFactory;
        String[] strArrFilter = ArgumentParser.filter(strArr, streamFactory.getParameters());
        validateFactoryArgs(this.factory, strArrFilter);
        this.sampleStream = this.factory.create(strArrFilter);
    }
}
