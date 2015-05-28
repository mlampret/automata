/*
 * Copyright 2015 mlpadilla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mlpadilla.automaton;

import java.util.Objects;

/**
 * Input symbol.
 * @author mlpadilla
 */
public class Input {
    
    private final String _value;
    // update equals and hashcode if adding more properties

    /**
     * Constructor
     * @param value input symbol
     */
    public Input(String value) {
        _value = value;
    }
    
    /**
     * Getter for the value of this input symbol
     * @return value of this input symbol
     */
    public String getValue() { return _value; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Input))
            return false;
        return _value.equals(((Input)obj)._value);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this._value);
        return hash;
    }

    @Override
    public String toString() {
        return "{" + _value + "}"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
 
}
