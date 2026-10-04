package opennlp.tools.cmdline.postag;

import java.io.File;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.params.BasicTrainingParams;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
interface TrainingParams extends BasicTrainingParams {
    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "The XML tag dictionary file", valueName = "dictionaryPath")
    File getDict();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "A sub-class of POSTaggerFactory where to get implementation and resources.", valueName = "factoryName")
    String getFactory();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "The feature generator descriptor file", valueName = "featuregenFile")
    File getFeaturegen();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "The resources directory", valueName = "resourcesDir")
    File getResources();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "TagDictionary cutoff. If specified will create/expand a mutable TagDictionary", valueName = "tagDictCutoff")
    Integer getTagDictCutoff();
}
