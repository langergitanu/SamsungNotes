package opennlp.tools.cmdline.lemmatizer;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmatizerMETool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LemmatizerMETool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model < sentences");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Learnable lemmatizer";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) throws Throwable {
        IOException e;
        Throwable th;
        if (strArr.length != 1) {
            logger.info(getHelp());
            return;
        }
        PerformanceMonitor performanceMonitor = null;
        LemmatizerME lemmatizerME = new LemmatizerME(new LemmatizerModelLoader().load(new File(strArr[0])));
        try {
            try {
                PlainTextByLineStream plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
                try {
                    performanceMonitor = new PerformanceMonitor("sent");
                    try {
                        performanceMonitor.start();
                        while (true) {
                            String str = plainTextByLineStream.read();
                            if (str == null) {
                                break;
                            }
                            try {
                                POSSample pOSSample = POSSample.parse(str);
                                logger.info(new LemmaSample(pOSSample.getSentence(), pOSSample.getTags(), lemmatizerME.lemmatize(pOSSample.getSentence(), pOSSample.getTags())).toString());
                                performanceMonitor.incrementCounter();
                            } catch (InvalidFormatException unused) {
                                logger.warn("Invalid format: {}", str);
                            }
                        }
                        plainTextByLineStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            plainTextByLineStream.close();
                            throw th;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    performanceMonitor = null;
                    th = th4;
                }
            } catch (IOException e2) {
                e = e2;
                CmdLineUtil.handleStdinIoError(e);
                performanceMonitor.stopAndPrintFinalResult();
            }
        } catch (IOException e3) {
            performanceMonitor = null;
            e = e3;
            CmdLineUtil.handleStdinIoError(e);
            performanceMonitor.stopAndPrintFinalResult();
        }
        performanceMonitor.stopAndPrintFinalResult();
    }
}
