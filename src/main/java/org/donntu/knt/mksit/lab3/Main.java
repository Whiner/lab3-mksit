package org.donntu.knt.mksit.lab3;

import java.io.File;
import java.io.IOException;

import static org.donntu.knt.mksit.lab3.LZW.compress;
import static org.donntu.knt.mksit.lab3.LZW.decompress;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilename = "files/input.txt";
        String compressedFilename = compress(inputFilename);
        String decompressedFilename = decompress(compressedFilename);

        System.out.println("compress percent = " + CompressQualifier.compressPercent(
                new File(inputFilename),
                new File(compressedFilename))
        );
        System.out.println("is equals = " + CompressQualifier.isUncompressedEqualsSource(
                new File(inputFilename),
                new File(decompressedFilename))
        );
    }
}
