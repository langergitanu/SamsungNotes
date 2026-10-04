package opennlp.tools.cmdline.dictionary;

import java.io.File;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.params.EncodingParameter;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
interface DictionaryBuilderParams extends EncodingParameter {
    @ArgumentParser.ParameterDescription(description = "Plain file with one entry per line", valueName = "in")
    File getInputFile();

    @ArgumentParser.ParameterDescription(description = "The dictionary file.", valueName = "out")
    File getOutputFile();
}
