package opennlp.tools.cmdline.parser;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.cmdline.tokenizer.TokenizerModelLoader;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ParserTool extends BasicCmdLineTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ParserTool.class);
    private static final Pattern UNTOKENIZED_PAREN_PATTERN_1 = Pattern.compile("([^ ])([({)}])");
    private static final Pattern UNTOKENIZED_PAREN_PATTERN_2 = Pattern.compile("([({)}])([^ ])");

    public static Parse[] parseLine(String str, Parser parser, int i) {
        return parseLine(str, parser, WhitespaceTokenizer.INSTANCE, i);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return AbstractC0541b.m773o("Usage: opennlp ", getName(), " [-bs n -ap n -k n -tk tok_model] model < sentences \n-bs n: Use a beam size of n.\n-ap f: Advance outcomes in with at least f% of the probability mass.\n-k n: Show the top n parses. This will also display their log-probabilities.\n-tk tok_model: Use the specified tokenizer model to tokenize the sentences. Defaults to a WhitespaceTokenizer.");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Performs full syntactic parsing";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) throws Throwable {
        PerformanceMonitor performanceMonitor;
        PlainTextByLineStream plainTextByLineStream;
        boolean z = true;
        if (strArr.length < 1) {
            logger.info(getHelp());
            return;
        }
        ParserModel parserModelLoad = new ParserModelLoader().load(new File(strArr[strArr.length - 1]));
        Integer intParameter = CmdLineUtil.getIntParameter("-bs", strArr);
        if (intParameter == null) {
            intParameter = 20;
        }
        Integer intParameter2 = CmdLineUtil.getIntParameter("-k", strArr);
        if (intParameter2 == null) {
            intParameter2 = 1;
            z = false;
        }
        Double doubleParameter = CmdLineUtil.getDoubleParameter("-ap", strArr);
        if (doubleParameter == null) {
            doubleParameter = Double.valueOf(0.95d);
        }
        Tokenizer tokenizerME = WhitespaceTokenizer.INSTANCE;
        String parameter = CmdLineUtil.getParameter("-tk", strArr);
        if (parameter != null) {
            tokenizerME = new TokenizerME(new TokenizerModelLoader().load(new File(parameter)));
        }
        Parser parserCreate = ParserFactory.create(parserModelLoad, intParameter.intValue(), doubleParameter.doubleValue());
        PerformanceMonitor performanceMonitor2 = null;
        try {
            plainTextByLineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), SystemInputStreamFactory.encoding());
            try {
                performanceMonitor = new PerformanceMonitor("sent");
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            CmdLineUtil.handleStdinIoError(e);
            performanceMonitor = performanceMonitor2;
            performanceMonitor.stopAndPrintFinalResult();
        }
        try {
            performanceMonitor.start();
            while (true) {
                String str = plainTextByLineStream.read();
                if (str == null) {
                    try {
                        break;
                    } catch (IOException e2) {
                        e = e2;
                        performanceMonitor2 = performanceMonitor;
                        CmdLineUtil.handleStdinIoError(e);
                        performanceMonitor = performanceMonitor2;
                    }
                } else if (str.trim().length() == 0) {
                    logger.debug("empty line");
                } else {
                    Parse[] line = parseLine(str, parserCreate, tokenizerME, intParameter2.intValue());
                    int length = line.length;
                    for (int i = 0; i < length; i++) {
                        if (z) {
                            logger.debug("{} {} ", Integer.valueOf(i), Double.valueOf(line[i].getProb()));
                        }
                        line[i].show();
                        performanceMonitor.incrementCounter();
                    }
                }
            }
            plainTextByLineStream.close();
            performanceMonitor.stopAndPrintFinalResult();
        } catch (Throwable th2) {
            th = th2;
            performanceMonitor2 = performanceMonitor;
            try {
                plainTextByLineStream.close();
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
            throw th;
        }
    }

    public static Parse[] parseLine(String str, Parser parser, Tokenizer tokenizer, int i) {
        List<String> listAsList = Arrays.asList(tokenizer.tokenize(UNTOKENIZED_PAREN_PATTERN_2.matcher(UNTOKENIZED_PAREN_PATTERN_1.matcher(str).replaceAll("$1 $2")).replaceAll("$1 $2")));
        String strJoin = String.join(" ", listAsList);
        Parse parse = new Parse(strJoin, new Span(0, strJoin.length()), AbstractBottomUpParser.INC_NODE, 0.0d, 0);
        int i2 = 0;
        int length = 0;
        for (String str2 : listAsList) {
            parse.insert(new Parse(strJoin, new Span(length, str2.length() + length), AbstractBottomUpParser.TOK_NODE, 0.0d, i2));
            length += str2.length() + 1;
            i2++;
        }
        return i == 1 ? new Parse[]{parser.parse(parse)} : parser.parse(parse, i);
    }
}
