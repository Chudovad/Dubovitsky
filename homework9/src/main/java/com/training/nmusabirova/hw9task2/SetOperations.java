package com.training.nmusabirova.hw9task2;

import java.util.HashSet;

public class SetOperations<T> extends HashSet {

    public HashSet<T> getUnion(HashSet set1, HashSet set2) {
        checkForNull(set1, set2);
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }

    public HashSet<T> getIntersection(HashSet set1, HashSet set2) {
        checkForNull(set1, set2);
        HashSet result = new HashSet(set1);
        result.retainAll(set2);
        return result;
    }

    public HashSet<T> getMinus(HashSet set1, HashSet set2) {
        checkForNull(set1, set2);
        HashSet result = new HashSet(set1);
        result.removeAll(set2);
        return result;
    }

    public HashSet<T> getDifference(HashSet set1, HashSet set2) {
        checkForNull(set1, set2);
        return getMinus(getUnion(set1, set2), getIntersection(set1, set2));
    }

    private static void checkForNull(HashSet set1, HashSet set2) {
        if (set1 == null || set2 == null) {
            throw new NullPointerException("Error! Sets cannot be empty.");
        }
    }
}
