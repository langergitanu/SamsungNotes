package opennlp.tools.cmdline.doccat;

import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.params.BasicTrainingParams;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
interface TrainingParams extends BasicTrainingParams {
    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "A sub-class of DoccatFactory where to get implementation and resources.", valueName = "factoryName")
    String getFactory();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "Comma separated feature generator classes. Bag of words is used if not specified.", valueName = "fg")
    String getFeatureGenerators();
}
