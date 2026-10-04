package opennlp.tools.cmdline.postag;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class POSTaggerTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) POSTaggerTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model < sentences");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Learnable part of speech tagger";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) throws Throwable {
        IOException e;
        PlainTextByLineStream plainTextByLineStream;
        Throwable th;
        if (strArr.length != 1) {
            logger.info(getHelp());
            return;
        }
        PerformanceMonitor performanceMonitor = null;
        POSTaggerME pOSTaggerME = new POSTaggerME(new POSModelLoader().load(new File(strArr[0])));
        try {
            try {
                plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
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
        try {
            performanceMonitor = new PerformanceMonitor("sent");
            try {
                performanceMonitor.start();
                while (true) {
                    String str = plainTextByLineStream.read();
                    if (str == null) {
                        break;
                    }
                    String[] strArr2 = WhitespaceTokenizer.INSTANCE.tokenize(str);
                    logger.info(new POSSample(strArr2, pOSTaggerME.tag(strArr2)).toString());
                    performanceMonitor.incrementCounter();
                }
                plainTextByLineStream.close();
                performanceMonitor.stopAndPrintFinalResult();
            } catch (Throwable th2) {
                th = th2;
                try {
                    plainTextByLineStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th;
            }
        } catch (Throwable th4) {
            performanceMonitor = null;
            th = th4;
        }
    }
}
