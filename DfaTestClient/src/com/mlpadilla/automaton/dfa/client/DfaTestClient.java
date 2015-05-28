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
import com.mlpadilla.automaton.dfa.DeterministicFiniteAutomaton;
import com.mlpadilla.automaton.exception.UnknownInputException;
import com.mlpadilla.automaton.exception.UnknownStateException;
import java.util.Arrays;

/**
 *
 * @author mlpadilla
 */
public class DfaTestClient {
    private static DeterministicFiniteAutomaton dfa;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            dfa =
                DeterministicFiniteAutomaton.newInstance(
                        new DfaSimpleDataLoader()
                );
            Input e0 = new Input("0");
            Input e1 = new Input("1");
            Input[] acceptedWord = {e0, e1};
            Input[] rejectedWord = {e1, e0};
            
            System.out.println(testWordOutput(acceptedWord));
            System.out.println(testWordOutput(rejectedWord));
        } catch (UnknownStateException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    private static String testWordOutput(Input[] word) {
        boolean isAccepted;
        try {
            isAccepted = dfa.isWordAccepted(word);
        } catch (UnknownInputException ex) {
            return ex.getMessage();
        }
        
        return "Word '" + Arrays.toString(word) +
                "' is " + (isAccepted?"ACCEPTED":"REJECTED");
    }
    
}
