package com.vladsch.flexmark.util.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileUtil {
    public static String getDotExtension(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return (iLastIndexOf <= 0 || iLastIndexOf <= name.lastIndexOf(File.separatorChar)) ? "" : name.substring(iLastIndexOf);
    }

    @Nullable
    public static String getFileContent(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return sb.toString();
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static byte[] getFileContentBytes(File file) {
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public static byte[] getFileContentBytesWithExceptions(File file) {
        return Files.readAllBytes(file.toPath());
    }

    @NotNull
    public static String getFileContentWithExceptions(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                return sb.toString();
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    public static String getNameOnly(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return (iLastIndexOf <= 0 || iLastIndexOf <= name.lastIndexOf(File.separatorChar)) ? name : name.substring(0, iLastIndexOf);
    }

    public static boolean isChildOf(File file, File file2) {
        String path = file.getPath();
        String str = File.separator;
        return Utils.suffixWith(path, str).startsWith(Utils.suffixWith(file2.getPath(), str));
    }

    public static String pathSlash(File file) {
        String path = file.getPath();
        int iLastIndexOf = path.lastIndexOf(File.separatorChar);
        return iLastIndexOf != -1 ? path.substring(0, iLastIndexOf + 1) : "";
    }

    public static File plus(File file, String str) {
        return new File(file, str);
    }
}
