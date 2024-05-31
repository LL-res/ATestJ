package com.github.llres.designpattern.flyweight;

import java.util.ArrayList;
import java.util.List;

public class ImmutableElementFactory {
    private static List<ImmutableElement> immutables = new ArrayList<>();

    public static ImmutableElement getImmutableElement(String immutableField) {
        for (ImmutableElement immutableElement : immutables) {
            if (immutableElement.getImmutableField().equals(immutableField)) {
                return immutableElement;
            }
        }
        ImmutableElement immutableElement = new ImmutableElement(immutableField);
        immutables.add(immutableElement);
        return immutableElement;
    }
}
