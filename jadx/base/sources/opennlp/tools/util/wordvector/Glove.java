package opennlp.tools.util.wordvector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import opennlp.tools.util.java.Experimental;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Experimental
public class Glove {
    private Glove() {
    }

    @Experimental
    public static WordVectorTable parse(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 1048576);
        HashMap map = new HashMap();
        int length = -1;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new MapWordVectorTable(Collections.unmodifiableMap(map));
            }
            String[] strArrSplit = line.split(" ");
            if (length == -1) {
                length = strArrSplit.length - 1;
            } else if (length != strArrSplit.length - 1) {
                throw new IOException("Vector dimension must be constant!");
            }
            int i = 0;
            String str = strArrSplit[0];
            float[] fArr = new float[length];
            while (i < length) {
                int i2 = i + 1;
                fArr[i] = Float.parseFloat(strArrSplit[i2]);
                i = i2;
            }
            map.put(str, new FloatArrayVector(fArr));
        }
    }
}
