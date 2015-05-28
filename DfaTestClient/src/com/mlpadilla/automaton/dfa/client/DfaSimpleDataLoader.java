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
package com.mlpadilla.automaton.dfa.client;

import com.mlpadilla.automaton.Input;
import com.mlpadilla.automaton.State;
import com.mlpadilla.automaton.Transition;
import com.mlpadilla.automaton.dfa.DataLoaderInterface;
import com.mlpadilla.automaton.exception.UnknownInputException;
import com.mlpadilla.automaton.exception.UnknownStateException;

/**
 * Hard-coded example of loader for the following automaton:
 * Q = {q0,q1}
 * E = {e0,e1}
 * D = {
 *   {q0,0} -> {q0}
 *   {q0,1} -> {q1}
 *   {q1,0} -> {q0}
 *   {q1,1} -> {q1}
 * }
 * Start state: q0
 * Acceptance state: {q1}
 * 
 * @author mlpadilla
 */
public class DfaSimpleDataLoader implements DataLoaderInterface {

    private final State q0 = new State("q0");
    private final State q1 = new State("q1");
    private final Input e0 = new Input("0");
    private final Input e1 = new Input("1");
    
    @Override
    public State[] loadStates() {
        State[] vState = {q0,q1};
        
        return vState;
    }

    @Override
    public Input[] loadAlphabet() {
        Input[] vInput = {e0,e1};
        
        return vInput;
    }

    @Override
    public Transition loadFunction() {
        Transition function = (State q, Input a) -> {
            if (!(q.equals(q0) || q.equals(q1)))
                throw new UnknownStateException(
                        "Unknown state: "+ q.getName()
                );

            if (a.equals(e0))
                return q0;
            if (a.equals(e1))
                return q1;
            throw new UnknownInputException(
                    "Unknown input: "+ a.getValue()
            );
        };
        return function;
    }

    @Override
    public State loadStartState() {
        return q0;
    }

    @Override
    public State[] loadAcceptanceState() {
        State[] vState = {q1};
        
        return vState;
    }
    
}
