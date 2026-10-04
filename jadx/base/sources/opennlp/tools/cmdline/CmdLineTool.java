package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class CmdLineTool {
    public String getBasicHelp(Class<?> cls) {
        return getBasicHelp(cls);
    }

    public abstract String getHelp();

    public String getName() {
        return getClass().getName().endsWith("Tool") ? getClass().getSimpleName().substring(0, getClass().getSimpleName().length() - 4) : getClass().getSimpleName();
    }

    public String getShortDescription() {
        return "";
    }

    public boolean hasParams() {
        return true;
    }

    public <T> T validateAndParseParams(String[] strArr, Class<T> cls) {
        String strValidateArgumentsLoudly = ArgumentParser.validateArgumentsLoudly(strArr, (Class<?>) cls);
        if (strValidateArgumentsLoudly == null) {
            return (T) ArgumentParser.parse(strArr, cls);
        }
        throw new TerminateToolException(1, AbstractC0541b.m757C(strValidateArgumentsLoudly, "\n", getHelp()));
    }

    public String getBasicHelp(Class<?>... clsArr) {
        return AbstractC0541b.m774p("Usage: opennlp ", getName(), " ", ArgumentParser.createUsage(clsArr));
    }
}
