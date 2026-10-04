package opennlp.tools.cmdline;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public abstract class ModelLoader<T> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ModelLoader.class);
    private final String modelName;

    public ModelLoader(String str) {
        Objects.requireNonNull(str, "modelName must not be null!");
        this.modelName = str;
    }

    public T load(File file) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        CmdLineUtil.checkInputFile(this.modelName + " model", file);
        Logger logger2 = logger;
        logger2.info("Loading {} model ... ", this.modelName);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(CmdLineUtil.openInFile(file), 1048576);
            try {
                T tLoadModel = loadModel(bufferedInputStream);
                bufferedInputStream.close();
                logger2.info(String.format("done (%.3fs)\n", Double.valueOf((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0d)));
                return tLoadModel;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (InvalidFormatException e) {
            throw new TerminateToolException(-1, "Model has invalid format", e);
        } catch (IOException e2) {
            throw new TerminateToolException(-1, "IO error while loading model file '" + file + "'", e2);
        }
    }

    public abstract T loadModel(InputStream inputStream);
}
