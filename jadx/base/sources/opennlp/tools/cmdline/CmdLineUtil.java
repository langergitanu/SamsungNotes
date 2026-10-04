package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import opennlp.tools.commons.Internal;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public final class CmdLineUtil {
    static final int IO_BUFFER_SIZE = 1048576;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CmdLineUtil.class);

    private CmdLineUtil() {
    }

    public static void checkInputFile(String str, File file) {
        String strM773o = file.isDirectory() ? AbstractC0541b.m773o("The ", str, " file is a directory!") : !file.exists() ? AbstractC0541b.m773o("The ", str, " file does not exist!") : !file.canRead() ? AbstractC0541b.m773o("No permissions to read the ", str, " file!") : null;
        if (strM773o != null) {
            throw new TerminateToolException(-1, AbstractC0541b.m757C(strM773o, " Path: ", file.getAbsolutePath()));
        }
    }

    public static void checkLanguageCode(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(Locale.getISOLanguages()));
        arrayList.add("x-unspecified");
        if (!arrayList.contains(str)) {
            throw new TerminateToolException(1, AbstractC0541b.m773o("Unknown language code ", str, ", must be an ISO 639 code!"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkOutputFile(String str, File file) {
        String strM773o;
        if (file.exists()) {
            strM773o = file.isDirectory() ? AbstractC0541b.m773o("The ", str, " file is a directory!") : file.isFile() ? !file.canWrite() ? AbstractC0541b.m773o("No permissions to write the ", str, " file!") : null : AbstractC0541b.m773o("The ", str, " file is not a normal file!");
        } else {
            File parentFile = file.getAbsoluteFile().getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                strM773o = AbstractC0541b.m773o("The parent directory of the ", str, " file does not exist, please create it first!");
            } else if (!parentFile.canWrite()) {
                strM773o = AbstractC0541b.m773o("No permissions to create the ", str, " file!");
            }
        }
        if (strM773o != null) {
            throw new TerminateToolException(-1, AbstractC0541b.m757C(strM773o, " Path: ", file.getAbsolutePath()));
        }
    }

    public static boolean containsParam(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static InputStreamFactory createInputStreamFactory(File file) {
        try {
            return new MarkableFileInputStreamFactory(file);
        } catch (FileNotFoundException e) {
            throw new TerminateToolException(-1, "File '" + file + "' cannot be found", e);
        }
    }

    public static TerminateToolException createObjectStreamError(IOException iOException) {
        return new TerminateToolException(-1, AbstractC0541b.m772n("IO Error while creating an Input Stream: ", iOException.getMessage()), iOException);
    }

    public static Double getDoubleParameter(String str, String[] strArr) {
        String parameter = getParameter(str, strArr);
        if (parameter == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(parameter));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Integer getIntParameter(String str, String[] strArr) {
        String parameter = getParameter(str, strArr);
        if (parameter == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(parameter));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String getParameter(String str, String[] strArr) {
        int i;
        int parameterIndex = getParameterIndex(str, strArr);
        if (-1 >= parameterIndex || (i = parameterIndex + 1) >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public static int getParameterIndex(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].startsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) && strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static void handleCreateObjectStreamError(IOException iOException) {
        throw createObjectStreamError(iOException);
    }

    public static void handleStdinIoError(IOException iOException) {
        throw new TerminateToolException(-1, AbstractC0541b.m772n("IO Error while reading from stdin: ", iOException.getMessage()), iOException);
    }

    public static TrainingParameters loadTrainingParameters(String str, boolean z) {
        if (str == null) {
            return null;
        }
        checkInputFile("Training Parameter", new File(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                TrainingParameters trainingParameters = new TrainingParameters(bufferedInputStream);
                bufferedInputStream.close();
                if (!TrainerFactory.isValid(trainingParameters)) {
                    throw new TerminateToolException(1, AbstractC0541b.m773o("Training parameters file '", str, "' is invalid!"));
                }
                TrainerFactory.TrainerType trainerType = TrainerFactory.getTrainerType(trainingParameters);
                if (z || !trainerType.equals(TrainerFactory.TrainerType.EVENT_MODEL_SEQUENCE_TRAINER)) {
                    return trainingParameters;
                }
                throw new TerminateToolException(1, "Sequence training is not supported!");
            } finally {
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("Error during parameters loading: ", e.getMessage()), e);
        }
    }

    public static FileInputStream openInFile(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new TerminateToolException(-1, "File '" + file + "' cannot be found", e);
        }
    }

    public static void writeModel(String str, File file, BaseModel baseModel) {
        checkOutputFile(str + " model", file);
        Logger logger2 = logger;
        logger2.info("Writing {} model ... ", str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 1048576);
            try {
                baseModel.serialize(bufferedOutputStream);
                bufferedOutputStream.close();
                logger2.info(String.format("done (%.3fs)\n", Double.valueOf((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0d)));
                logger2.info("Wrote {} model to path: {}", str, file.getAbsolutePath());
            } finally {
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, "Error during writing model file '" + file + "'", e);
        }
    }
}
