package opennlp.tools.cmdline.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.formats.NameFinderCensus90NameStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.StringList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CensusDictionaryCreatorTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CensusDictionaryCreatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters {
        @ArgumentParser.ParameterDescription(valueName = "censusDict")
        String getCensusData();

        @ArgumentParser.ParameterDescription(valueName = "dict")
        String getDict();

        @ArgumentParser.OptionalParameter(defaultValue = "UTF-8")
        @ArgumentParser.ParameterDescription(valueName = "charsetName")
        String getEncoding();

        @ArgumentParser.OptionalParameter(defaultValue = "eng")
        @ArgumentParser.ParameterDescription(valueName = "code")
        String getLang();
    }

    public static Dictionary createDictionary(ObjectStream<StringList> objectStream) {
        Dictionary dictionary = new Dictionary(true);
        StringList stringList = objectStream.read();
        while (stringList != null) {
            if (!dictionary.contains(stringList)) {
                dictionary.put(stringList);
            }
            stringList = objectStream.read();
        }
        return dictionary;
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return getBasicHelp(Parameters.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Converts 1990 US Census names into a dictionary";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        Parameters parameters = (Parameters) validateAndParseParams(strArr, Parameters.class);
        File file = new File(parameters.getCensusData());
        File file2 = new File(parameters.getDict());
        CmdLineUtil.checkInputFile("Name data", file);
        CmdLineUtil.checkOutputFile("Dictionary file", file2);
        try {
            NameFinderCensus90NameStream nameFinderCensus90NameStream = new NameFinderCensus90NameStream(CmdLineUtil.createInputStreamFactory(file), Charset.forName(parameters.getEncoding()));
            try {
                Logger logger2 = logger;
                logger2.info("Creating Dictionary...");
                Dictionary dictionaryCreateDictionary = createDictionary(nameFinderCensus90NameStream);
                nameFinderCensus90NameStream.close();
                logger2.info("Saving Dictionary...");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        dictionaryCreateDictionary.serialize(fileOutputStream);
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (IOException e) {
                    throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while writing dictionary file: ", e.getMessage()), e);
                }
            } finally {
            }
        } catch (IOException e2) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading training data or indexing data: ", e2.getMessage()), e2);
        }
    }
}
