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
 * State.
 * @author mlpadilla
 */
public class State {
    
    private final String _name;
    // update equals and hashcode if adding more properties
    
    /**
     * Constructor
     * @param name for this state (formally q0, q1, etc.)
     */
    public State(String name) {
        _name = name;
    }
    
    /**
     * Getter for the name of this state
     * @return the name of this state
     */
    public String getName() { return _name; }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof State))
            return false;
        return _name.equals(((State)obj)._name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this._name);
        return hash;
    }

}
