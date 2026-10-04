package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.framework.core.ScspException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class StreamParser {
    public static String parseString(InputStream inputStream) throws ScspException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line.trim());
            }
        } catch (IOException e) {
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, "IOException occurred during data conversion received from the server.", e);
        }
    }
}
