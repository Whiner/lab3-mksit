package org.donntu.knt.mksit.lab3;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class HashStructure {
    private List<Pair<String, LinkedList<Object>>> store = new LinkedList<>();
    private HashFunction hashFunction;

    private String lastFoundKey = null;
    private LinkedList<Object> lastFoundValueList = null;

    public boolean contains(String key) {
        Optional<Pair<String, LinkedList<Object>>> equalPairOptional = getPair(key);
        if(equalPairOptional.isPresent()) {
            Pair<String, LinkedList<Object>> pair = equalPairOptional.get();
            lastFoundKey = pair.getKey();
            lastFoundValueList = pair.getValue();
            return true;
        } else {
            return false;
        }
    }

    public Object get(String key) {
        if(key.equals(lastFoundKey)) {
            return lastFoundValueList.getFirst();
        } else {
            Optional<Pair<String, LinkedList<Object>>> pair = getPair(key);
            if(pair.isPresent()) {

            }
            return null;
        }
    }

    public void put(Object object) {
        String code = hashFunction.hashCode(object);
        Optional<Pair<String, LinkedList<Object>>> pair = getPair(code);
        if(pair.isPresent()) {
            LinkedList<Object> value = pair.get().getValue();
            value.add(object);
        } else {
            LinkedList<Object> value = new LinkedList<>();
            value.add(object);
            store.add(new Pair<>(code, value));
        }
    }

    private Optional<Pair<String, LinkedList<Object>>> getPair(String key) {
        return store
                .stream()
                .filter(
                        pair -> pair
                                .getKey()
                                .equals(key))
                .findFirst();
    }


}
