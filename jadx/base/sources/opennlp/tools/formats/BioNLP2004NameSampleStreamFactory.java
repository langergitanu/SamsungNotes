package opennlp.tools.formats;

import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BioNLP2004NameSampleStreamFactory<P> extends AbstractSampleStreamFactory<NameSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.ParameterDescription(valueName = "DNA,protein,cell_type,cell_line,RNA")
        String getTypes();
    }

    public BioNLP2004NameSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(NameSample.class, "bionlp2004", new BioNLP2004NameSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<NameSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        try {
            return new BioNLP2004NameSampleStream(CmdLineUtil.createInputStreamFactory(parameters.getData()), parameters.getTypes().contains("DNA") ? 1 : parameters.getTypes().contains("protein") ? 2 : parameters.getTypes().contains("cell_type") ? 4 : parameters.getTypes().contains("cell_line") ? 8 : parameters.getTypes().contains("RNA") ? 16 : 0);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
