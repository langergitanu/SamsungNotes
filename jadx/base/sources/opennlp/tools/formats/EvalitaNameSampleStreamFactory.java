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
import opennlp.tools.formats.EvalitaNameSampleStream;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class EvalitaNameSampleStreamFactory<P> extends LanguageSampleStreamFactory<NameSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.ParameterDescription(valueName = LangPackConfigConstants.LANGUAGE_CODE_IT)
        String getLang();

        @ArgumentParser.ParameterDescription(valueName = "per,loc,org,gpe")
        String getTypes();
    }

    public EvalitaNameSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(NameSample.class, "evalita", new EvalitaNameSampleStreamFactory(Parameters.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<NameSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        if (!LangPackConfigConstants.LANGUAGE_CODE_IT.equals(parameters.getLang())) {
            throw new TerminateToolException(1, AbstractC0541b.m772n("Unsupported language: ", parameters.getLang()));
        }
        EvalitaNameSampleStream.LANGUAGE language = EvalitaNameSampleStream.LANGUAGE.IT;
        this.language = parameters.getLang();
        String types = parameters.getTypes();
        boolean zContains = types.contains("per");
        ?? r2 = zContains;
        if (types.contains("org")) {
            r2 = (zContains ? 1 : 0) | 2;
        }
        ?? r22 = r2;
        if (types.contains("loc")) {
            r22 = (r2 == true ? 1 : 0) | 4;
        }
        int i = r22;
        if (types.contains("gpe")) {
            i = (r22 == true ? 1 : 0) | 8;
        }
        try {
            return new EvalitaNameSampleStream(language, CmdLineUtil.createInputStreamFactory(parameters.getData()), i);
        } catch (IOException e) {
            throw CmdLineUtil.createObjectStreamError(e);
        }
    }
}
