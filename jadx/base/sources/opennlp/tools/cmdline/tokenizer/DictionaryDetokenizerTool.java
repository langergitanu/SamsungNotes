package opennlp.tools.cmdline.tokenizer;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.tokenize.DictionaryDetokenizer;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DictionaryDetokenizerTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DictionaryDetokenizerTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " detokenizerDictionary");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Normalizes tokenized text according to rules defined in a detokenizer dictionary";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        DictionaryDetokenizer dictionaryDetokenizer;
        PlainTextByLineStream plainTextByLineStream;
        PerformanceMonitor performanceMonitor;
        if (strArr.length != 1) {
            logger.info(getHelp());
            return;
        }
        try {
            dictionaryDetokenizer = new DictionaryDetokenizer(new DetokenizationDictionaryLoader().load(new File(strArr[0])));
            plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
            try {
                performanceMonitor = new PerformanceMonitor("sent");
                performanceMonitor.start();
            } finally {
            }
        } catch (IOException e) {
            CmdLineUtil.handleStdinIoError(e);
            return;
        }
        while (true) {
            String str = plainTextByLineStream.read();
            if (str == null) {
                performanceMonitor.stopAndPrintFinalResult();
                plainTextByLineStream.close();
                return;
            } else {
                logger.info(dictionaryDetokenizer.detokenize(WhitespaceTokenizer.INSTANCE.tokenize(str), null));
                performanceMonitor.incrementCounter();
            }
            CmdLineUtil.handleStdinIoError(e);
            return;
        }
    }
}
