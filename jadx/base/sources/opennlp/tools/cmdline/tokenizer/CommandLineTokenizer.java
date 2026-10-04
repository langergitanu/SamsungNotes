package opennlp.tools.cmdline.tokenizer;

import java.io.IOException;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerStream;
import opennlp.tools.tokenize.WhitespaceTokenStream;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class CommandLineTokenizer {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CommandLineTokenizer.class);
    private final Tokenizer tokenizer;

    public CommandLineTokenizer(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public void process() {
        PerformanceMonitor performanceMonitor;
        IOException e;
        WhitespaceTokenStream whitespaceTokenStream;
        try {
            whitespaceTokenStream = new WhitespaceTokenStream(new TokenizerStream(this.tokenizer, new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding())));
            performanceMonitor = new PerformanceMonitor("sent");
        } catch (IOException e2) {
            performanceMonitor = null;
            e = e2;
        }
        try {
            performanceMonitor.start();
            while (true) {
                String str = whitespaceTokenStream.read();
                if (str == null) {
                    break;
                }
                logger.info(str);
                performanceMonitor.incrementCounter();
            }
        } catch (IOException e3) {
            e = e3;
            CmdLineUtil.handleStdinIoError(e);
        }
        performanceMonitor.stopAndPrintFinalResult();
    }
}
