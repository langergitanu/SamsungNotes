package opennlp.tools.cmdline.entitylinker;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.scsp.common.Header;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.entitylinker.EntityLinker;
import opennlp.tools.entitylinker.EntityLinkerFactory;
import opennlp.tools.entitylinker.EntityLinkerProperties;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EntityLinkerTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) EntityLinkerTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " model < sentences");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Links an entity to an external data set";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        if (strArr.length == 0) {
            logger.info(getHelp());
            return;
        }
        try {
            boolean z = false;
            try {
                EntityLinker<?> linker = EntityLinkerFactory.getLinker(Header.LOCATION, new EntityLinkerProperties(new File(strArr[0])));
                PerformanceMonitor performanceMonitor = new PerformanceMonitor("sent");
                performanceMonitor.start();
                try {
                    PlainTextByLineStream plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
                    try {
                        ?? arrayList = new ArrayList();
                        while (true) {
                            String str = plainTextByLineStream.read();
                            if (str == null) {
                                break;
                            }
                            if (str.trim().isEmpty()) {
                                StringBuilder sb = new StringBuilder();
                                Span[] spanArr = new Span[arrayList.size()];
                                Span[][] spanArr2 = new Span[arrayList.size()][];
                                Span[][] spanArr3 = new Span[arrayList.size()][];
                                for (?? r9 = z; r9 < arrayList.size(); r9++) {
                                    NameSample nameSample = (NameSample) arrayList.get(r9);
                                    spanArr3[r9] = nameSample.getNames();
                                    int length = sb.length();
                                    Span[] spanArr4 = new Span[nameSample.getSentence().length];
                                    for (?? r13 = z; r13 < nameSample.getSentence().length; r13++) {
                                        int length2 = sb.length();
                                        sb.append(nameSample.getSentence()[r13]);
                                        sb.append(" ");
                                        spanArr4[r13] = new Span(length2, sb.length());
                                    }
                                    spanArr2[r9] = spanArr4;
                                    spanArr[r9] = new Span(length, sb.length());
                                    sb.append("\n");
                                    z = false;
                                }
                                Iterator it = linker.find(sb.toString(), spanArr, spanArr2, spanArr3).iterator();
                                while (it.hasNext()) {
                                    logger.info(((Span) it.next()).toString());
                                }
                                performanceMonitor.incrementCounter(arrayList.size());
                                arrayList.clear();
                                z = false;
                            } else {
                                arrayList.add(NameSample.parse(str, z));
                            }
                        }
                        plainTextByLineStream.close();
                    } finally {
                    }
                } catch (IOException e) {
                    CmdLineUtil.handleStdinIoError(e);
                }
                performanceMonitor.stopAndPrintFinalResult();
            } catch (Exception e2) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("Failed to instantiate the Entity Linker: ", e2.getMessage()));
            }
        } catch (IOException unused) {
            throw new TerminateToolException(-1, "Failed to load the properties file!");
        }
    }
}
