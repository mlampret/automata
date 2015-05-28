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

/**
 * Interface for an Automaton.
 * @author mlpadilla
 */
public interface AutomatonInterface {
    /**
     * Determines whether the supplied word is accepted by this automaton or not
     * @param word sequence of input symbols
     * @return <code>true</code> if word is accepted by this automaton, <code>
     * false</code> otherwise
     * @throws com.mlpadilla.automaton.exception.UnknownInputException
     * if one of the input symbols on the word does not belong to the alphabet
     *  of this automaton
     */
    public boolean isWordAccepted(Input[] word) throws UnknownInputException;
}
