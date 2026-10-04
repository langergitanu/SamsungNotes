package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.Conll02NameSampleStream;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class Conll02NameSampleStreamFactory<P> extends LanguageSampleStreamFactory<NameSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.ParameterDescription(valueName = "spa|nld")
        String getLang();

        @ArgumentParser.ParameterDescription(valueName = "per,loc,org,misc")
        String getTypes();
    }

    public Conll02NameSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(NameSample.class, "conll02", new Conll02NameSampleStreamFactory(Parameters.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<NameSample> create(String[] strArr) {
        Conll02NameSampleStream.LANGUAGE language;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        if ("nl".equals(parameters.getLang()) || "nld".equals(parameters.getLang())) {
            language = Conll02NameSampleStream.LANGUAGE.NLD;
            this.language = parameters.getLang();
        } else {
            if (!LangPackConfigConstants.LANGUAGE_CODE_ES.equals(parameters.getLang()) && !"spa".equals(parameters.getLang())) {
                throw new TerminateToolException(1, AbstractC0541b.m772n("Unsupported language: ", parameters.getLang()));
            }
            language = Conll02NameSampleStream.LANGUAGE.SPA;
            this.language = parameters.getLang();
        }
        boolean zContains = parameters.getTypes().contains("per");
        ?? r12 = zContains;
        if (parameters.getTypes().contains("org")) {
            r12 = (zContains ? 1 : 0) | 2;
        }
        ?? r13 = r12;
        if (parameters.getTypes().contains("loc")) {
            r13 = (r12 == true ? 1 : 0) | 4;
        }
        int i = r13;
        if (parameters.getTypes().contains("misc")) {
            i = (r13 == true ? 1 : 0) | 8;
        }
        try {
            return new Conll02NameSampleStream(language, CmdLineUtil.createInputStreamFactory(parameters.getData()), i);
        } catch (IOException e) {
            throw CmdLineUtil.createObjectStreamError(e);
        }
    }
}
