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

import com.mlpadilla.automaton.AutomatonInterface;
import com.mlpadilla.automaton.State;
import com.mlpadilla.automaton.Input;
import com.mlpadilla.automaton.Transition;
import com.mlpadilla.automaton.exception.UnknownInputException;
import com.mlpadilla.automaton.exception.UnknownStateException;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Deterministic Finite Automaton
 * @author mlpadilla
 */
public class DeterministicFiniteAutomaton implements AutomatonInterface{
    private HashSet<State> _stateSet = new HashSet<State>();
    private HashSet<Input> _alphabet = new HashSet<Input>();
    private Transition _function;
    private State _startState;
    private HashSet<State> _acceptanceStateSet = new HashSet<State>();
    /**
    * Constructor
    */
    private DeterministicFiniteAutomaton() {
    }
    
    /**
     * Factory method
     * @param stateSet array of states
     * @param alphabet array of input symbols that define this alphabet
     * @param function transition function
     * @param startState the start state
     * @param acceptanceStateSubset array of acceptance states
     * @return instance of <code>DeterministicFiniteAutomaton</code>
     * @throws UnknownStateException if the provided start or acceptance state
     * do not belong to the set of states provided
     */
    public static DeterministicFiniteAutomaton newInstance(
            State[] stateSet,
            Input[] alphabet,
            Transition function,
            State startState,
            State[] acceptanceStateSubset)
        throws UnknownStateException {
        
        DeterministicFiniteAutomaton instance =
                new DeterministicFiniteAutomaton();
        
        instance._stateSet.addAll(Arrays.asList(stateSet));
        instance._alphabet.addAll(Arrays.asList(alphabet));
        instance._function = function;
        
        if (!instance._stateSet.contains(startState))
            throw new UnknownStateException(
                "The start state " +
                    ((startState == null)? "null" : startState.getName()) +
                    " does not belong to the set of states provided for "
                    + "this automaton"
            );
        
        instance._startState = startState;
            
        for (State s: acceptanceStateSubset)
            if (!instance._stateSet.contains(s))
                throw new UnknownStateException(
                    "The acceptance state " +
                        ((s == null)? "null" : s.getName()) +
                        " does not belong to the set of states provided "
                        + "for this automaton"
            );
        
        instance._acceptanceStateSet.addAll(Arrays.asList(acceptanceStateSubset));
        
        return instance;
    }
    
    /**
     * Factory method
     * @param loader supplies the data needed to build a new
     * <code>DeterministicFiniteAutomaton</code>
     * @return instance of <code>DeterministicFiniteAutomaton</code>
     * @throws UnknownStateException if the provided start or acceptance state
     * do not belong to the set of states provided
     */
    public static DeterministicFiniteAutomaton newInstance(
            DataLoaderInterface loader
    ) throws UnknownStateException {
        return newInstance(
                loader.loadStates(),
                loader.loadAlphabet(),
                loader.loadFunction(),
                loader.loadStartState(),
                loader.loadAcceptanceState());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWordAccepted(Input[] word) throws UnknownInputException {
        Machine machine = new Machine();
        
        for (Input input: word) {
            machine.applyTransition(input);
        }
        
        return machine.isAcceptanceState();
    }
    
    /**
     * Creates a new instance of a Machine object for this automaton
     * @return a newly instantiated <code>Machine</code>
     */
    public Machine newMachine() {
        return new Machine();
    }
    
    /**
     * Stateful machine which allows step-by-step iteration through states.
     */
    public class Machine {
        private State _currentState;
        /**
         * Constructor
         */
        public Machine(){
            _currentState = _startState;
        }
        
        /**
         * Returns the current state of this machine.
         * @return current state
         */
        public State getCurrentState() {
            return _currentState;
        }
        /**
         * Determines whether this machine is currently set to the start state
         * or not.
         * @return <code>true</code> if the machine is set to the start state,
         * <code>false</code> otherwise
         */
        public boolean isStartState() {
            return _startState.equals(_currentState);
        }
        /**
         * Applies the transition function on the current state with the
         * provided input symbol.
         * @param a input symbol
         * @return next state
         * @throws UnknownInputException if the input symbol does not belong to
         * the alphabet of this automaton
         */
        public State applyTransition(Input a) throws UnknownInputException {
            if (!_alphabet.contains(a))
                throw new UnknownInputException("The input '" + a.getValue() +
                        "' is not recognised by this automaton");
            try {
                _currentState = _function.perform(_currentState, a);
            } catch (UnknownStateException ex) {
                // Impossible scenario as we start from the start state of this
                // automaton
            }
            return _currentState;
        }
        /** Determines whether this machine is currently set to an acceptance
         * state or not.
         * @return <code>true</code> if the machine is set to an acceptance
         *  state, <code>false</code> otherwise
         */
        public boolean isAcceptanceState() {
            return _acceptanceStateSet.contains(_currentState);
        }
    }
}
