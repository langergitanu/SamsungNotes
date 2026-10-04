package opennlp.tools.formats.leipzig;

import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class SampleSkipStream<T> implements ObjectStream<T> {
    private final ObjectStream<T> samples;
    private final int samplesToSkip;

    public SampleSkipStream(ObjectStream<T> objectStream, int i) {
        this.samples = objectStream;
        this.samplesToSkip = i;
        skipSamples();
    }

    private void skipSamples() {
        for (int i = 0; i < this.samplesToSkip && this.samples.read() != null; i++) {
        }
    }

    @Override // opennlp.tools.util.ObjectStream
    public T read() {
        return this.samples.read();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
        skipSamples();
    }
}
