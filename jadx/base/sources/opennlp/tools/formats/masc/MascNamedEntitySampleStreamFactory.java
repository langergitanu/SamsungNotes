package opennlp.tools.formats.masc;

import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascNamedEntitySampleStreamFactory<P> extends AbstractSampleStreamFactory<NameSample, P> {
    public static final String MASC_FORMAT = "masc";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.ParameterDescription(description = "only include files which contain a given string in their name", valueName = "fileFilterString")
        String getFileFilter();

        @ArgumentParser.ParameterDescription(description = "search through files recursively", valueName = "recurrentSearch")
        boolean getRecurrentSearch();
    }

    public MascNamedEntitySampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$create$0(Parameters parameters, File file) {
        return file.getName().contains(parameters.getFileFilter());
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(NameSample.class, "masc", new MascNamedEntitySampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<NameSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        try {
            return new MascNamedEntitySampleStream(new MascDocumentStream(parameters.getData(), parameters.getRecurrentSearch(), new C13634a(parameters, 0)));
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            return null;
        }
    }
}
