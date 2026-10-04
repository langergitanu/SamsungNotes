package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MakeCharacterDefinitions {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 2) {
            throw new IllegalArgumentException("The unicode-math-table.tex input and all-math-characters.txt output text files must both be provided");
        }
        int i = 0;
        String str = strArr[0];
        String str2 = strArr[1];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "US-ASCII"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2), "US-ASCII"));
        bufferedWriter.write("# This was generated from " + str + " during the SnuggleTeX build - do not edit!\n");
        Pattern patternCompile = Pattern.compile("\\\\UnicodeMathSymbol\\{\"(.{5})\\}\\{\\\\(\\w+)\\s*\\}\\{\\\\(\\w+)\\}");
        HashMap map = new HashMap();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                bufferedWriter.close();
                System.out.println("Types were " + map);
                System.out.println("Number of chars is " + i);
                return;
            }
            i++;
            Matcher matcher = patternCompile.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Could not parse line ".concat(line));
            }
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            String strGroup3 = matcher.group(3);
            Integer num = (Integer) map.get(strGroup3);
            map.put(strGroup3, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            if (!strGroup3.equals("mathalpha") && !strGroup3.equals("mathord") && !strGroup3.equals("mathop") && !strGroup3.equals("mathpunct") && !strGroup3.equals("mathrel") && !strGroup3.equals("mathbin") && !strGroup3.equals("mathaccent") && !strGroup3.equals("mathopen") && !strGroup3.equals("mathclose")) {
                strGroup3.equals("mathfence");
            }
            bufferedWriter.write(strGroup);
            bufferedWriter.write(58);
            bufferedWriter.write(strGroup2);
            bufferedWriter.write(58);
            bufferedWriter.write(strGroup3.substring(4).toUpperCase());
            bufferedWriter.write(10);
        }
    }
}
