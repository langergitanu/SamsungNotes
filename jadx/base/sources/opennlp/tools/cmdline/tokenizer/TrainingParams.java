package opennlp.tools.cmdline.tokenizer;

import java.io.File;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.params.BasicTrainingParams;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
interface TrainingParams extends BasicTrainingParams {
    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "abbreviation dictionary in XML format.", valueName = "path")
    File getAbbDict();

    @ArgumentParser.OptionalParameter(defaultValue = "false")
    @ArgumentParser.ParameterDescription(description = "Optimization flag to skip alpha numeric tokens for further tokenization", valueName = "isAlphaNumOpt")
    Boolean getAlphaNumOpt();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "Minimal number of times a feature must be seen", valueName = "cutOffNum")
    String getCutoff();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "A sub-class of TokenizerFactory where to get implementation and resources.", valueName = "factoryName")
    String getFactory();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "Number of training iterations", valueName = "iterationsNum")
    String getIterations();
}
