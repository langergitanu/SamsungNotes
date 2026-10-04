package opennlp.tools.formats.ontonotes;

import com.samsung.android.support.senl.p145cm.base.framework.content.C7969a;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.StandardCharsets;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.formats.DirectorySampleStream;
import opennlp.tools.formats.convert.FileToStringSampleStream;
import opennlp.tools.parser.Parse;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OntoNotesParseSampleStreamFactory extends AbstractSampleStreamFactory<Parse, OntoNotesFormatParameters> {
    public OntoNotesParseSampleStreamFactory() {
        super(OntoNotesFormatParameters.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$create$0(File file) {
        return file.isFile() ? file.getName().endsWith(".parse") : file.isDirectory();
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(Parse.class, "ontonotes", new OntoNotesParseSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<Parse> create(String[] strArr) {
        return new OntoNotesParseSampleStream(new DocumentToLineStream(new FileToStringSampleStream(new DirectorySampleStream(new File(((OntoNotesFormatParameters) ArgumentParser.parse(strArr, OntoNotesFormatParameters.class)).getOntoNotesDir()), (FileFilter) new C7969a(5), true), StandardCharsets.UTF_8)));
    }
}
