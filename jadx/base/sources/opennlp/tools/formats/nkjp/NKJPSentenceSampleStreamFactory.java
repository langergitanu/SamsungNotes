package opennlp.tools.formats.nkjp;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NKJPSentenceSampleStreamFactory<P> extends AbstractSampleStreamFactory<SentenceSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.ParameterDescription(description = "file containing NKJP text", valueName = "text")
        File getTextFile();
    }

    public NKJPSentenceSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(SentenceSample.class, "nkjp", new NKJPSentenceSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<SentenceSample> create(String[] strArr) {
        NKJPSegmentationDocument nKJPSegmentationDocument;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        CmdLineUtil.checkInputFile("Data", parameters.getData());
        CmdLineUtil.checkInputFile(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, parameters.getTextFile());
        NKJPTextDocument nKJPTextDocument = null;
        try {
            nKJPSegmentationDocument = NKJPSegmentationDocument.parse(parameters.getData());
        } catch (IOException e) {
            e = e;
            nKJPSegmentationDocument = null;
        }
        try {
            nKJPTextDocument = NKJPTextDocument.parse(parameters.getTextFile());
        } catch (IOException e2) {
            e = e2;
            CmdLineUtil.handleCreateObjectStreamError(e);
        }
        return new NKJPSentenceSampleStream(nKJPSegmentationDocument, nKJPTextDocument);
    }
}
