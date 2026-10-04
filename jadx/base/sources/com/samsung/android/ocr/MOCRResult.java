package com.samsung.android.ocr;

import android.graphics.Point;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCRResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Block {
        public Point[] bRect;
        public int isTabular;
        private int lang;
        public int lineCount;
        public Line[] lines;

        public String getText() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                Line[] lineArr = this.lines;
                if (i >= lineArr.length) {
                    return sb.toString();
                }
                sb.append(lineArr[i].getText());
                if (i < this.lines.length) {
                    sb.append("\n");
                }
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Char {
        public Point[] cRect;
        public int unicode;

        public String getText() {
            return Character.toString((char) this.unicode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DocColumn {
        public int[] blockIds;
        public Point[] colRect;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Document {
        public int columnCount;
        public DocColumn[] columns;
        public Point[] docRect;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Line {
        public Point[] lRect;
        public int lang;
        public int wordCount;
        public Word[] words;

        public String getText() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                Word[] wordArr = this.words;
                if (i >= wordArr.length) {
                    return sb.toString().trim();
                }
                Word word = wordArr[i];
                if (word.getText() != null) {
                    sb.append(word.getText());
                    if (i < this.words.length) {
                        sb.append(" ");
                    }
                }
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Page {
        private static final String TAG = "Page";
        public int blockCount;
        public Block[] blocks;
        public boolean debugViTExec;
        public Document document;
        public int ocrLang;
        public Table[] tables;

        public String getText() {
            StringBuilder sb = new StringBuilder();
            MOCRLog.m5683d(TAG, this.blockCount + " blocks");
            if (this.blockCount > 0) {
                for (Block block : this.blocks) {
                    sb.append(block.getText());
                }
            }
            return sb.toString().trim();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Table {
        public TableCell[] cells;
        int columnCount;
        public TableColumn[] columns;
        int rowCount;
        public TableRow[] rows;
        public Point[] tableRect;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TableCell {
        public Point[] cellRect;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TableColumn {
        public TableCell[] cells;
        public Point[] colRect;
        int rowCount;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TableRow {
        public TableCell[] cells;
        int columnCount;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Word {
        public int charCount;
        public Char[] chars;
        public float conf;
        public int lang;
        public Point[] wPoly;
        public Point[] wRect;
        public String wordText;

        public String getText() {
            return this.wordText;
        }
    }
}
