package opennlp.tools.cmdline.tokenizer;

import androidx.appcompat.widget.AbstractC0541b;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SimpleTokenizerTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SimpleTokenizerTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " < sentences");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Character class tokenizer";
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public boolean hasParams() {
        return false;
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        if (strArr.length != 0) {
            logger.info(getHelp());
        } else {
            new CommandLineTokenizer(SimpleTokenizer.INSTANCE).process();
        }
    }
}
