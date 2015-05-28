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

import com.mlpadilla.automaton.exception.UnknownInputException;
import com.mlpadilla.automaton.exception.UnknownStateException;

/**
 * A Transition defines the relation between the current state and the next
 * state given certain input symbol.
 * 
 * This is an implementation of the Command Pattern.
 * @author mlpadilla
 */
public interface Transition {
    /**
     * Applies the transition
     * @param q current state
     * @param a input symbol
     * @return state after applying the transition
     * @throws com.mlpadilla.automaton.exception.UnknownStateException if the
     * state provided cannot be used with this transition (might not be
     * recognised by the automaton).
     * @throws com.mlpadilla.automaton.exception.UnknownInputException if the
     * input symbol provided cannot be used with this transition (might not be
     * recognised by the automaton)..
     */
    public State perform(State q, Input a) throws UnknownStateException,
            UnknownInputException;
}
