/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.controller;

import java.util.ArrayList;

/**
 *
 * @author Miten Bhadania
 */

public class OutputService {

    private ArrayList<String> combination;

    OutputService(ArrayList<String> letterCombinations) {
         this.combination = letterCombinations;
    }

    public ArrayList<String> getCombination() {
        return combination;
    }

    

    @Override
    public String toString() {
        return "outputService{" + "combination=" + combination + '}';
    }
}
