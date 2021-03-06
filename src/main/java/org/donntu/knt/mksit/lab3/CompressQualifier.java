package org.donntu.knt.mksit.lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Shilenko Alexander
 */
public class CompressQualifier {
    public static double compressPercent(File source, File compressed) {
        return 100 - ((double)compressed.length() / (double)source.length() * 100.0);
    }

    public static boolean isUncompressedEqualsSource(File source, File uncompressed) {
        try (
                BufferedReader sourceBufferedReader = new BufferedReader(new FileReader(source));
                BufferedReader uncompressedBufferedReader = new BufferedReader(new FileReader(uncompressed))
        ) {
            Optional<String> sourceText = sourceBufferedReader
                    .lines()
                    .reduce((s, str) -> s.concat(str) + '\n');
            Optional<String> uncompressedText = uncompressedBufferedReader
                    .lines()
                    .reduce((s, str) -> s.concat(str) + '\n');

            if(sourceText.isPresent() && uncompressedText.isPresent()) {
                return sourceText.get().equals(uncompressedText.get());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
