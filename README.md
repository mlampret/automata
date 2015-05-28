# Automata library for Java

Java library for abstract machines (automata).

(In development)

## Supported automata

Deterministic Finite Automaton

## Structure of this repository

There are two java projects available at the moment:

### Automata

The library for automata.

* com.mlpadilla.automaton is the root project package

* com.mlpadilla.automaton.dfa provides an implementation of a Deterministic
Finite Automaton

### DfaTestClient

Simple command-line client for informal testing of the Deterministic Finite
Automaton.

## How to use

Import the library and use
com.mlpadilla.automaton.dfa.DeterministicFiniteAutomaton
through the Factory method 'newInstance'.

There are two constructors, one of them providing all parameters as defined by
the 5-tuple of
[its algebraic definition](http://en.wikipedia.org/wiki/Deterministic_finite_automaton#Formal_definition).
The other one provides a convenience Data Loader which is available by
implementing com.mlpadilla.automaton.dfa.DataLoaderInterface
