package opennlp.tools.cmdline.langdetect;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.util.ParagraphStream;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LanguageDetectorTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model < documents");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Learned language detector";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        if (strArr.length == 0) {
            logger.info(getHelp());
            return;
        }
        LanguageDetectorME languageDetectorME = new LanguageDetectorME(new LanguageDetectorModelLoader().load(new File(strArr[0])));
        PerformanceMonitor performanceMonitor = new PerformanceMonitor("doc");
        performanceMonitor.start();
        try {
            ParagraphStream paragraphStream = new ParagraphStream(new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding()));
            while (true) {
                String str = paragraphStream.read();
                if (str == null) {
                    break;
                }
                logger.info(new LanguageSample(languageDetectorME.predictLanguage(str), str).toString());
                performanceMonitor.incrementCounter();
            }
        } catch (IOException e) {
            CmdLineUtil.handleStdinIoError(e);
        }
        performanceMonitor.stopAndPrintFinalResult();
    }
}
