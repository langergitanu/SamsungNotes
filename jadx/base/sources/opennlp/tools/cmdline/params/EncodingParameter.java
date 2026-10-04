package opennlp.tools.cmdline.params;

import java.nio.charset.Charset;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public interface EncodingParameter {
    @ArgumentParser.OptionalParameter(defaultValue = ArgumentParser.OptionalParameter.DEFAULT_CHARSET)
    @ArgumentParser.ParameterDescription(description = "encoding for reading and writing text, if absent the system default is used.", valueName = "charsetName")
    Charset getEncoding();
}
