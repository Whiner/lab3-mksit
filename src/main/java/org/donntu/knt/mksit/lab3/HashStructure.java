package org.donntu.knt.mksit.lab3;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class HashStructure<T> {
    private List<Pair<String, LinkedList<T>>> store = new LinkedList<>();
    private HashFunction hashFunction;

    private String lastFoundKey = null;
    private LinkedList<T> lastFoundValueList = null;

    public HashStructure(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    public boolean contains(String key) {
        String hashCode = hashFunction.hashCode(key);
        Optional<Pair<String, LinkedList<T>>> equalPairOptional = getPair(hashCode);
        if(equalPairOptional.isPresent()) {
            Pair<String, LinkedList<T>> pair = equalPairOptional.get();
            lastFoundKey = key;
            lastFoundValueList = pair.getValue();
            return true;
        } else {
            return false;
        }
    }

    public T get(String key) {
        String hashCode = hashFunction.hashCode(key);
        if(key.equals(lastFoundKey)) {
            T first = lastFoundValueList.getFirst();
            lastFoundValueList = null;
            lastFoundKey = null;
            return first;
        } else {
            Optional<Pair<String, LinkedList<T>>> pair = getPair(hashCode);
            return pair.map(stringLinkedListPair -> stringLinkedListPair.getValue().getFirst()).orElse(null);
        }
    }

    public void put(String key, T value) {
        String code = hashFunction.hashCode(key);
        Optional<Pair<String, LinkedList<T>>> pair = getPair(code);
        if(pair.isPresent()) {
            LinkedList<T> valuesList = pair.get().getValue();
            valuesList.add(value);
        } else {
            LinkedList<T> valuesList = new LinkedList<>();
            valuesList.add(value);
            store.add(new Pair<>(code, valuesList));
        }
    }

    private Optional<Pair<String, LinkedList<T>>> getPair(String hashCode) {
        return store
                .stream()
                .filter(
                        pair -> pair
                                .getKey()
                                .equals(hashCode))
                .findFirst();
    }


}
