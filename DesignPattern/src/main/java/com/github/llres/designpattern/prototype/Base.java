package com.github.llres.designpattern.prototype;

import java.io.Serializable;

public interface Base extends Serializable {
    Base clone();
}
