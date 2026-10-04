package opennlp.tools.cmdline.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenNameFinderTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenNameFinderTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model1 model2 ... modelN < sentences");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Learnable name finder";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        if (strArr.length == 0) {
            logger.info(getHelp());
            return;
        }
        int length = strArr.length;
        NameFinderME[] nameFinderMEArr = new NameFinderME[length];
        for (int i = 0; i < length; i++) {
            nameFinderMEArr[i] = new NameFinderME(new TokenNameFinderModelLoader().load(new File(strArr[i])));
        }
        PerformanceMonitor performanceMonitor = new PerformanceMonitor("sent");
        performanceMonitor.start();
        try {
            PlainTextByLineStream plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
            while (true) {
                try {
                    String str = plainTextByLineStream.read();
                    if (str == null) {
                        break;
                    }
                    String[] strArr2 = WhitespaceTokenizer.INSTANCE.tokenize(str);
                    if (strArr2.length == 0) {
                        for (int i2 = 0; i2 < length; i2++) {
                            nameFinderMEArr[i2].clearAdaptiveData();
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < length; i4++) {
                        Collections.addAll(arrayList, nameFinderMEArr[i4].find(strArr2));
                    }
                    logger.info(new NameSample(strArr2, NameFinderME.dropOverlappingSpans((Span[]) arrayList.toArray(new Span[0])), false).toString());
                    performanceMonitor.incrementCounter();
                } finally {
                }
            }
            plainTextByLineStream.close();
        } catch (IOException e) {
            CmdLineUtil.handleStdinIoError(e);
        }
        performanceMonitor.stopAndPrintFinalResult();
    }
}
