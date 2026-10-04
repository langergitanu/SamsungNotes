package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractTypedParamTool<T, P> extends TypedCmdLineTool<T, P> {
    protected final Class<P> paramsClass;

    public AbstractTypedParamTool(Class<T> cls, Class<P> cls2) {
        super(cls);
        this.paramsClass = cls2;
    }

    @Override // opennlp.tools.cmdline.TypedCmdLineTool
    public String getHelp(String str) {
        if ("".equals(str) || "opennlp".equals(str)) {
            return getBasicHelp(this.paramsClass, StreamFactoryRegistry.getFactory(this.type, "opennlp").getParameters());
        }
        ObjectStreamFactory factory = StreamFactoryRegistry.getFactory(this.type, str);
        if (factory == null) {
            throw new TerminateToolException(1, AbstractC0541b.m774p("Format ", str, " is not found.\n", getHelp()));
        }
        String name = getName();
        String strCreateUsage = ArgumentParser.createUsage((Class<?>[]) new Class[]{this.paramsClass, factory.getParameters()});
        StringBuilder sbM16m = AbstractC0000a.m16m("Usage: opennlp ", name, Extension.DOT, str, " ");
        sbM16m.append(strCreateUsage);
        return sbM16m.toString();
    }
}
