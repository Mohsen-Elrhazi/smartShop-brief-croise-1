package com.mohsen.smartshop_brief_croise.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // Méthode pour hasher un mot de passe
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Méthode pour vérifier le mot de passe
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
