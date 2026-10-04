package opennlp.tools.cmdline.namefind;

import java.io.File;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.params.BasicTrainingParams;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
interface TrainingParams extends BasicTrainingParams {
    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "A sub-class of TokenNameFinderFactory", valueName = "factoryName")
    String getFactory();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "The feature generator descriptor file", valueName = "featuregenFile")
    File getFeaturegen();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "name types to use for training", valueName = "types")
    String getNameTypes();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "The resources directory", valueName = "resourcesDir")
    File getResources();

    @ArgumentParser.OptionalParameter(defaultValue = "opennlp.tools.namefind.BioCodec")
    @ArgumentParser.ParameterDescription(description = "sequence codec used to code name spans", valueName = "codec")
    String getSequenceCodec();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "The type of the token name finder model", valueName = "modelType")
    String getType();
}
