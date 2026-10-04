package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class TypedCmdLineTool<T, P> extends CmdLineTool {
    protected final Class<T> type;

    public TypedCmdLineTool(Class<T> cls) {
        this.type = cls;
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getBasicHelp(Class<?>... clsArr) {
        String strM773o;
        Map factories = StreamFactoryRegistry.getFactories(this.type);
        if (1 < factories.size()) {
            StringBuilder sb = new StringBuilder();
            for (String str : factories.keySet()) {
                if (!"opennlp".equals(str)) {
                    AbstractC1974b.m1332y(sb, Extension.DOT, str, "|");
                }
            }
            strM773o = AbstractC0541b.m773o("[", sb.substring(0, sb.length() - 1), "] ");
        } else {
            strM773o = " ";
        }
        return AbstractC0541b.m774p("Usage: opennlp ", getName(), strM773o, ArgumentParser.createUsage(clsArr));
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getHelp() {
        return getHelp("");
    }

    public abstract String getHelp(String str);

    public ObjectStreamFactory<T, P> getStreamFactory(String str) {
        ObjectStreamFactory<T, P> factory = StreamFactoryRegistry.getFactory(this.type, str);
        if (factory != null) {
            return factory;
        }
        throw new TerminateToolException(1, AbstractC0541b.m774p("Format ", str, " is not found.\n", getHelp()));
    }

    public abstract void run(String str, String[] strArr);

    public <A> void validateAllArgs(String[] strArr, Class<A> cls, String str) {
        String strValidateArgumentsLoudly = ArgumentParser.validateArgumentsLoudly(strArr, (Class<?>[]) new Class[]{cls, getStreamFactory(str).getParameters()});
        if (strValidateArgumentsLoudly != null) {
            throw new TerminateToolException(1, AbstractC0541b.m757C(strValidateArgumentsLoudly, "\n", getHelp(str)));
        }
    }

    public void validateFactoryArgs(ObjectStreamFactory<T, P> objectStreamFactory, String[] strArr) {
        String strValidateArgumentsLoudly = ArgumentParser.validateArgumentsLoudly(strArr, (Class<?>) objectStreamFactory.getParameters());
        if (strValidateArgumentsLoudly != null) {
            throw new TerminateToolException(1, AbstractC0541b.m774p("Format parameters are invalid: ", strValidateArgumentsLoudly, "\nUsage: ", ArgumentParser.createUsage(objectStreamFactory.getParameters())));
        }
    }
}
