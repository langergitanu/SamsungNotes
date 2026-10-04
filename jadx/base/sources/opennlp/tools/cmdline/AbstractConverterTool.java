package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.util.Map;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractConverterTool<T, P> extends TypedCmdLineTool<T, P> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) AbstractConverterTool.class);

    public AbstractConverterTool(Class<T> cls) {
        super(cls);
    }

    private String createHelpString(String str, String str2) {
        StringBuilder sbM16m = AbstractC0000a.m16m("Usage: opennlp ", getName(), " ", str, " ");
        sbM16m.append(str2);
        return sbM16m.toString();
    }

    @Override // opennlp.tools.cmdline.TypedCmdLineTool, opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        Map factories = StreamFactoryRegistry.getFactories(this.type);
        StringBuilder sb = new StringBuilder("help|");
        for (String str : factories.keySet()) {
            if (!"opennlp".equals(str)) {
                sb.append(str);
                sb.append("|");
            }
        }
        return createHelpString(sb.substring(0, sb.length() - 1), "[help|options...]");
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        Map factories = StreamFactoryRegistry.getFactories(this.type);
        StringBuilder sb = new StringBuilder();
        if (2 == factories.keySet().size()) {
            for (String str : factories.keySet()) {
                if (!"opennlp".equals(str)) {
                    sb.append(str);
                }
            }
            return "Converts " + ((Object) sb) + " data format to native OpenNLP format";
        }
        if (2 >= factories.keySet().size()) {
            throw new AssertionError("There should be more than 1 factory registered for converter tool");
        }
        for (String str2 : factories.keySet()) {
            if (!"opennlp".equals(str2)) {
                sb.append(str2);
                sb.append(",");
            }
        }
        return AbstractC0541b.m773o("Converts external data formats (", sb.substring(0, sb.length() - 1), ") to native OpenNLP format");
    }

    @Override // opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        if (strArr.length == 0) {
            logger.info(getHelp());
            return;
        }
        String str2 = strArr[0];
        ObjectStreamFactory<T, P> streamFactory = getStreamFactory(str2);
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 1, strArr2, 0, length);
        String strCreateHelpString = createHelpString(str2, ArgumentParser.createUsage(streamFactory.getParameters()));
        if (length == 0 || (1 == length && "help".equals(strArr2[0]))) {
            logger.info(strCreateHelpString);
            System.exit(0);
        }
        String strValidateArgumentsLoudly = ArgumentParser.validateArgumentsLoudly(strArr2, (Class<?>) streamFactory.getParameters());
        if (strValidateArgumentsLoudly != null) {
            throw new TerminateToolException(1, AbstractC0541b.m757C(strValidateArgumentsLoudly, "\n", strCreateHelpString));
        }
        try {
            ObjectStream<T> objectStreamCreate = streamFactory.create(strArr2);
            while (true) {
                try {
                    T t = objectStreamCreate.read();
                    if (t == null) {
                        objectStreamCreate.close();
                        return;
                    }
                    logger.info(t.toString());
                } finally {
                }
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while converting data : ", e.getMessage()), e);
        }
    }

    @Override // opennlp.tools.cmdline.TypedCmdLineTool
    public String getHelp(String str) {
        return getHelp();
    }
}
