package com.simplon.dvdstore.dvdstore.controllers;

//on remplace class par record et on mets les paramètres
public record DvdStoreDtoMovies(String name, String genre, Long quantity, float price) {

}

