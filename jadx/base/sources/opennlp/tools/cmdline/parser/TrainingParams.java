package opennlp.tools.cmdline.parser;

import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.io.File;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.params.BasicTrainingParams;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
interface TrainingParams extends BasicTrainingParams {
    @ArgumentParser.OptionalParameter(defaultValue = "false")
    @ArgumentParser.ParameterDescription(description = "Learn to generate function tags.", valueName = "true|false")
    Boolean getFun();

    @ArgumentParser.ParameterDescription(description = "head rules file.", valueName = "headRulesFile")
    File getHeadRules();

    @ArgumentParser.OptionalParameter
    @ArgumentParser.ParameterDescription(description = "head rules artifact serializer class name", valueName = SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME)
    String getHeadRulesSerializerImpl();

    @ArgumentParser.OptionalParameter(defaultValue = "CHUNKING")
    @ArgumentParser.ParameterDescription(description = "one of CHUNKING or TREEINSERT, default is CHUNKING.", valueName = "CHUNKING|TREEINSERT")
    String getParserType();
}
