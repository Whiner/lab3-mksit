package org.donntu.knt.mksit.lab3;

public class HashFunctionImpl implements HashFunction {
    @Override
    public String hashCode(String string) {
        char[] chars = string.toCharArray();
        int hash = 0;
        for (char aChar : chars) {
            hash += aChar;
        }
        return String.valueOf(hash);
    }
}
