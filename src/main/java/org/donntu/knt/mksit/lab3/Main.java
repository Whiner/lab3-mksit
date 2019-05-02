package org.donntu.knt.mksit.lab3;

import java.io.IOException;

import static org.donntu.knt.mksit.lab3.LZW.compress;
import static org.donntu.knt.mksit.lab3.LZW.decompress;

public class Main {
    public static void main(String[] args) throws IOException {
        compress("files/input.txt", "files/compressed_output.txt.lzw");
        decompress("files/compressed_output.txt.lzw", "files/decompressed_output.txt");
    }
}
