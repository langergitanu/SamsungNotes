package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class TextManager {
    private static final int DEFAULT_CHUNK_SIZE = 2950;
    private static final String INPUT_FILE_NAME = "summarization_30min.txt";
    private static final String TAG = "TextManager";
    private static final TextChunkContext mTextChunkContext = new TextChunkContext();

    private TextManager() {
    }

    public static void getChunkSenteneList(Context context, List<String> list) {
        list.addAll(mTextChunkContext.chunkTextWithDefaultSize(readInputTextFile(context, INPUT_FILE_NAME)));
    }

    private static String readInputTextFile(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append(" ");
                        } finally {
                        }
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            Log.e(TAG, "Error reading input file: " + str, e);
        }
        return sb.toString().trim();
    }

    public static void getChunkSenteneList(String str, List<String> list, int i, int i2) {
        list.addAll(mTextChunkContext.chunkText(str, i, i2));
    }

    public static void getChunkSenteneList(String str, List<String> list) {
        list.addAll(mTextChunkContext.chunkTextWithDefaultSize(str));
    }
}
