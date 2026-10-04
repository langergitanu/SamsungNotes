package opennlp.tools.cmdline.dictionary;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import opennlp.tools.cmdline.BasicCmdLineTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.dictionary.Dictionary;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryBuilderTool extends BasicCmdLineTool {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Params extends DictionaryBuilderParams {
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return getBasicHelp(Params.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Builds a new dictionary";
    }

    @Override // opennlp.tools.cmdline.BasicCmdLineTool
    public void run(String[] strArr) {
        Params params = (Params) validateAndParseParams(strArr, Params.class);
        File inputFile = params.getInputFile();
        File outputFile = params.getOutputFile();
        Charset encoding = params.getEncoding();
        CmdLineUtil.checkInputFile("dictionary input file", inputFile);
        CmdLineUtil.checkOutputFile("dictionary output file", outputFile);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), encoding));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                try {
                    Dictionary.parseOneEntryPerLine(bufferedReader).serialize(fileOutputStream);
                    fileOutputStream.close();
                    bufferedReader.close();
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading training data or indexing data: ", e.getMessage()), e);
        }
    }
}
