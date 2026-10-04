package opennlp.tools.cmdline.parser;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.postag.POSModelLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TaggerModelReplacerTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TaggerModelReplacerTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " parser.model tagger.model");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Replaces the tagger model in a parser model";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        if (strArr.length != 2) {
            logger.info(getHelp());
            return;
        }
        File file = new File(strArr[0]);
        CmdLineUtil.writeModel("parser", file, new ParserModelLoader().load(file).updateTaggerModel(new POSModelLoader().load(new File(strArr[1]))));
    }
}
