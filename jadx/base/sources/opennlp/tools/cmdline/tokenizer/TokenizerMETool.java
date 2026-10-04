package opennlp.tools.cmdline.tokenizer;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.tokenize.TokenizerME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenizerMETool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenizerMETool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model < sentences");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Learnable tokenizer";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        if (strArr.length != 1) {
            logger.info(getHelp());
        } else {
            new CommandLineTokenizer(new TokenizerME(new TokenizerModelLoader().load(new File(strArr[0])))).process();
        }
    }
}
