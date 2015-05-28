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
package com.mlpadilla.automaton.dfa;

import com.mlpadilla.automaton.State;
import com.mlpadilla.automaton.Input;
import com.mlpadilla.automaton.Transition;

/**
 * Helper class which assists in obtaining the data needed to build a 
 * <code>DeterministicFiniteAutomaton</code>
 * @author mlpadilla
 */
public interface DataLoaderInterface {
    /**
     * Provides all states for an automaton
     * @return array of states
     */
    public State[] loadStates();
    /**
     * Provides all inputs (alphabet) for an automaton
     * @return array of inputs
     */
    public Input[] loadAlphabet();
     /**
     * Provides the transition function for the automaton
     * @return transition function
     */
    public Transition loadFunction();
     /**
     * Provides the start state for this automaton
     * @return start state
     */
    public State loadStartState();
    /**
     * Provides acceptance states for an automaton
     * @return array of acceptance states
     */
    public State[] loadAcceptanceState();
}
