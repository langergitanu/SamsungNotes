package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import opennlp.tools.cmdline.chunker.ChunkerConverterTool;
import opennlp.tools.cmdline.chunker.ChunkerCrossValidatorTool;
import opennlp.tools.cmdline.chunker.ChunkerEvaluatorTool;
import opennlp.tools.cmdline.chunker.ChunkerMETool;
import opennlp.tools.cmdline.chunker.ChunkerTrainerTool;
import opennlp.tools.cmdline.dictionary.DictionaryBuilderTool;
import opennlp.tools.cmdline.doccat.DoccatConverterTool;
import opennlp.tools.cmdline.doccat.DoccatCrossValidatorTool;
import opennlp.tools.cmdline.doccat.DoccatEvaluatorTool;
import opennlp.tools.cmdline.doccat.DoccatTool;
import opennlp.tools.cmdline.doccat.DoccatTrainerTool;
import opennlp.tools.cmdline.entitylinker.EntityLinkerTool;
import opennlp.tools.cmdline.langdetect.LanguageDetectorConverterTool;
import opennlp.tools.cmdline.langdetect.LanguageDetectorCrossValidatorTool;
import opennlp.tools.cmdline.langdetect.LanguageDetectorEvaluatorTool;
import opennlp.tools.cmdline.langdetect.LanguageDetectorTool;
import opennlp.tools.cmdline.langdetect.LanguageDetectorTrainerTool;
import opennlp.tools.cmdline.languagemodel.NGramLanguageModelTool;
import opennlp.tools.cmdline.lemmatizer.LemmatizerEvaluatorTool;
import opennlp.tools.cmdline.lemmatizer.LemmatizerMETool;
import opennlp.tools.cmdline.lemmatizer.LemmatizerTrainerTool;
import opennlp.tools.cmdline.namefind.CensusDictionaryCreatorTool;
import opennlp.tools.cmdline.namefind.TokenNameFinderConverterTool;
import opennlp.tools.cmdline.namefind.TokenNameFinderCrossValidatorTool;
import opennlp.tools.cmdline.namefind.TokenNameFinderEvaluatorTool;
import opennlp.tools.cmdline.namefind.TokenNameFinderTool;
import opennlp.tools.cmdline.namefind.TokenNameFinderTrainerTool;
import opennlp.tools.cmdline.parser.BuildModelUpdaterTool;
import opennlp.tools.cmdline.parser.CheckModelUpdaterTool;
import opennlp.tools.cmdline.parser.ParserConverterTool;
import opennlp.tools.cmdline.parser.ParserEvaluatorTool;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.cmdline.parser.ParserTrainerTool;
import opennlp.tools.cmdline.parser.TaggerModelReplacerTool;
import opennlp.tools.cmdline.postag.POSTaggerConverterTool;
import opennlp.tools.cmdline.postag.POSTaggerCrossValidatorTool;
import opennlp.tools.cmdline.postag.POSTaggerEvaluatorTool;
import opennlp.tools.cmdline.postag.POSTaggerTool;
import opennlp.tools.cmdline.postag.POSTaggerTrainerTool;
import opennlp.tools.cmdline.sentdetect.SentenceDetectorConverterTool;
import opennlp.tools.cmdline.sentdetect.SentenceDetectorCrossValidatorTool;
import opennlp.tools.cmdline.sentdetect.SentenceDetectorEvaluatorTool;
import opennlp.tools.cmdline.sentdetect.SentenceDetectorTool;
import opennlp.tools.cmdline.sentdetect.SentenceDetectorTrainerTool;
import opennlp.tools.cmdline.tokenizer.DictionaryDetokenizerTool;
import opennlp.tools.cmdline.tokenizer.SimpleTokenizerTool;
import opennlp.tools.cmdline.tokenizer.TokenizerConverterTool;
import opennlp.tools.cmdline.tokenizer.TokenizerCrossValidatorTool;
import opennlp.tools.cmdline.tokenizer.TokenizerMEEvaluatorTool;
import opennlp.tools.cmdline.tokenizer.TokenizerMETool;
import opennlp.tools.cmdline.tokenizer.TokenizerTrainerTool;
import opennlp.tools.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CLI {
    public static final String CMD = "opennlp";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CLI.class);
    private static Map<String, CmdLineTool> toolLookupMap;

    static {
        toolLookupMap = new LinkedHashMap();
        LinkedList<CmdLineTool> linkedList = new LinkedList();
        linkedList.add(new DoccatTool());
        linkedList.add(new DoccatTrainerTool());
        linkedList.add(new DoccatEvaluatorTool());
        linkedList.add(new DoccatCrossValidatorTool());
        linkedList.add(new DoccatConverterTool());
        linkedList.add(new LanguageDetectorTool());
        linkedList.add(new LanguageDetectorTrainerTool());
        linkedList.add(new LanguageDetectorConverterTool());
        linkedList.add(new LanguageDetectorCrossValidatorTool());
        linkedList.add(new LanguageDetectorEvaluatorTool());
        linkedList.add(new DictionaryBuilderTool());
        linkedList.add(new SimpleTokenizerTool());
        linkedList.add(new TokenizerMETool());
        linkedList.add(new TokenizerTrainerTool());
        linkedList.add(new TokenizerMEEvaluatorTool());
        linkedList.add(new TokenizerCrossValidatorTool());
        linkedList.add(new TokenizerConverterTool());
        linkedList.add(new DictionaryDetokenizerTool());
        linkedList.add(new SentenceDetectorTool());
        linkedList.add(new SentenceDetectorTrainerTool());
        linkedList.add(new SentenceDetectorEvaluatorTool());
        linkedList.add(new SentenceDetectorCrossValidatorTool());
        linkedList.add(new SentenceDetectorConverterTool());
        linkedList.add(new TokenNameFinderTool());
        linkedList.add(new TokenNameFinderTrainerTool());
        linkedList.add(new TokenNameFinderEvaluatorTool());
        linkedList.add(new TokenNameFinderCrossValidatorTool());
        linkedList.add(new TokenNameFinderConverterTool());
        linkedList.add(new CensusDictionaryCreatorTool());
        linkedList.add(new POSTaggerTool());
        linkedList.add(new POSTaggerTrainerTool());
        linkedList.add(new POSTaggerEvaluatorTool());
        linkedList.add(new POSTaggerCrossValidatorTool());
        linkedList.add(new POSTaggerConverterTool());
        linkedList.add(new LemmatizerMETool());
        linkedList.add(new LemmatizerTrainerTool());
        linkedList.add(new LemmatizerEvaluatorTool());
        linkedList.add(new ChunkerMETool());
        linkedList.add(new ChunkerTrainerTool());
        linkedList.add(new ChunkerEvaluatorTool());
        linkedList.add(new ChunkerCrossValidatorTool());
        linkedList.add(new ChunkerConverterTool());
        linkedList.add(new ParserTool());
        linkedList.add(new ParserTrainerTool());
        linkedList.add(new ParserEvaluatorTool());
        linkedList.add(new ParserConverterTool());
        linkedList.add(new BuildModelUpdaterTool());
        linkedList.add(new CheckModelUpdaterTool());
        linkedList.add(new TaggerModelReplacerTool());
        linkedList.add(new EntityLinkerTool());
        linkedList.add(new NGramLanguageModelTool());
        for (CmdLineTool cmdLineTool : linkedList) {
            toolLookupMap.put(cmdLineTool.getName(), cmdLineTool);
        }
        toolLookupMap = Collections.unmodifiableMap(toolLookupMap);
    }

    public static Map<String, CmdLineTool> getToolLookupMap() {
        return toolLookupMap;
    }

    public static Set<String> getToolNames() {
        return toolLookupMap.keySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: TerminateToolException -> 0x0043, TryCatch #0 {TerminateToolException -> 0x0043, blocks: (B:12:0x003c, B:20:0x0052, B:22:0x0056, B:26:0x0070, B:27:0x0073, B:29:0x0077, B:30:0x007d, B:33:0x0083, B:34:0x0089, B:35:0x009f, B:36:0x00a0, B:37:0x00b6, B:23:0x0063, B:25:0x0067, B:18:0x0048, B:38:0x00b7, B:39:0x00cd), top: B:43:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void main(String[] strArr) {
        String strSubstring;
        if (strArr.length == 0) {
            usage();
            System.exit(0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 1, strArr2, 0, length);
        String strSubstring2 = strArr[0];
        int iIndexOf = strSubstring2.indexOf(Extension.DOT);
        if (-1 < iIndexOf) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = "opennlp";
        }
        CmdLineTool cmdLineTool = toolLookupMap.get(strSubstring2);
        try {
        } catch (TerminateToolException e) {
            logger.error(e.getLocalizedMessage(), (Throwable) e);
            System.exit(e.getCode());
        }
        if (cmdLineTool == null) {
            throw new TerminateToolException(1, "Tool " + strSubstring2 + " is not found.");
        }
        if (length != 0 || !cmdLineTool.hasParams()) {
            if (length > 0 && "help".equals(strArr2[0])) {
                if (cmdLineTool instanceof TypedCmdLineTool) {
                    logger.info(((TypedCmdLineTool) cmdLineTool).getHelp(strSubstring));
                } else if (cmdLineTool instanceof BasicCmdLineTool) {
                    logger.info(cmdLineTool.getHelp());
                }
                System.exit(0);
            }
            if (cmdLineTool instanceof TypedCmdLineTool) {
                ((TypedCmdLineTool) cmdLineTool).run(strSubstring, strArr2);
            } else {
                if (!(cmdLineTool instanceof BasicCmdLineTool)) {
                    throw new TerminateToolException(1, "Tool " + strSubstring2 + " is not supported.");
                }
                if (-1 != iIndexOf) {
                    throw new TerminateToolException(1, "Tool " + strSubstring2 + " does not support formats.");
                }
                ((BasicCmdLineTool) cmdLineTool).run(strArr2);
            }
        }
        logger.info(String.format("Execution time: %.3f seconds\n", Double.valueOf((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0d)));
    }

    private static void usage() {
        String string;
        Logger logger2 = logger;
        logger2.info("OpenNLP {}.", Version.currentVersion());
        logger2.info("Usage: {} TOOL", "opennlp");
        int length = -1;
        for (String str : toolLookupMap.keySet()) {
            if (str.length() > length) {
                length = str.length();
            }
        }
        int i = length + 4;
        StringBuilder sb = new StringBuilder("where TOOL is one of: \n\n");
        for (CmdLineTool cmdLineTool : toolLookupMap.values()) {
            sb.append(Constant.WHITE_SPACE_FOR_LINK_ICON);
            sb.append(cmdLineTool.getName());
            int iMax = Math.max(0, StrictMath.abs(cmdLineTool.getName().length() - i));
            if (iMax < 0) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(iMax, "count is negative: "));
            }
            if (iMax != 0) {
                string = " ";
                if (iMax == 1) {
                    continue;
                } else {
                    if (1 > Integer.MAX_VALUE / iMax) {
                        throw new OutOfMemoryError(AbstractC0541b.m767i(iMax, "Repeating 1 bytes String ", " times will produce a String exceeding maximum size."));
                    }
                    StringBuilder sb2 = new StringBuilder(iMax);
                    for (int i2 = 0; i2 < iMax; i2++) {
                        sb2.append(" ");
                    }
                    string = sb2.toString();
                }
            } else {
                string = "";
            }
            sb.append(string);
            sb.append(cmdLineTool.getShortDescription());
            sb.append("\n");
        }
        Logger logger3 = logger;
        logger3.info(sb.toString());
        logger3.info("All tools print help when invoked with help parameter");
        logger3.info("Example: opennlp SimpleTokenizer help");
    }
}
