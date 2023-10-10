package com.simplon.dvdstore.dvdstore.services;

import org.springframework.security.core.userdetails.UserDetails;



public interface JwtUserService extends UserService {
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);

    boolean updatePassword(UserDetails userDetails);
}
//Remarque : Permet de découpler l'implémentation de la vérification utilisateur avec le JWT, peut-etre mocker dans
//les tests unitaires