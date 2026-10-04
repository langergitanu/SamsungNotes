package opennlp.tools.cmdline.languagemodel;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.languagemodel.NGramLanguageModel;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramLanguageModelTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NGramLanguageModelTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Gives the probability and most probable next token(s) of a sequence of tokens in a language model";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        PerformanceMonitor performanceMonitor;
        PlainTextByLineStream plainTextByLineStream;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(strArr[0])));
            try {
                NGramLanguageModel nGramLanguageModel = new NGramLanguageModel(bufferedInputStream);
                PerformanceMonitor performanceMonitor2 = null;
                try {
                    plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
                    try {
                        performanceMonitor = new PerformanceMonitor("nglm");
                        try {
                            performanceMonitor.start();
                        } catch (Throwable th) {
                            th = th;
                            performanceMonitor2 = performanceMonitor;
                            try {
                                plainTextByLineStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e) {
                    e = e;
                }
                while (true) {
                    String str = plainTextByLineStream.read();
                    if (str != null) {
                        String[] strArrSplit = str.split(" ");
                        try {
                            logger.info("{} -> prob: {}, next: {}", Arrays.toString(strArrSplit), Double.valueOf(nGramLanguageModel.calculateProbability(strArrSplit)), Arrays.toString(nGramLanguageModel.predictNextTokens(strArrSplit)));
                            performanceMonitor.incrementCounter();
                        } catch (Exception e2) {
                            logger.error("Error for line: {}", str, e2);
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e3) {
                            e = e3;
                            performanceMonitor2 = performanceMonitor;
                            CmdLineUtil.handleStdinIoError(e);
                            performanceMonitor = performanceMonitor2;
                        }
                    }
                    CmdLineUtil.handleStdinIoError(e);
                    performanceMonitor = performanceMonitor2;
                    performanceMonitor.stopAndPrintFinalResult();
                    bufferedInputStream.close();
                }
                plainTextByLineStream.close();
                performanceMonitor.stopAndPrintFinalResult();
                bufferedInputStream.close();
            } finally {
            }
        } catch (IOException e5) {
            logger.error(e5.getLocalizedMessage(), (Throwable) e5);
        }
    }
}
