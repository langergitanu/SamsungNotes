package opennlp.tools.formats.muc;

import com.samsung.android.support.senl.p145cm.base.framework.content.C7969a;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.StandardCharsets;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.cmdline.tokenizer.TokenizerModelLoader;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.formats.DirectorySampleStream;
import opennlp.tools.formats.convert.FileToStringSampleStream;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Muc6NameSampleStreamFactory extends AbstractSampleStreamFactory<NameSample, Parameters> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.ParameterDescription(valueName = "modelFile")
        File getTokenizerModel();
    }

    public Muc6NameSampleStreamFactory() {
        super(Parameters.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$create$0(File file) {
        return StringUtil.toLowerCase(file.getName()).endsWith(".sgm");
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(NameSample.class, "muc6", new Muc6NameSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<NameSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        return new MucNameSampleStream(new TokenizerME(new TokenizerModelLoader().load(parameters.getTokenizerModel())), new FileToStringSampleStream(new DirectorySampleStream(parameters.getData(), (FileFilter) new C7969a(3), false), StandardCharsets.UTF_8));
    }
}
