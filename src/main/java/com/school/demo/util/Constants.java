/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/27/20, 4:23 PM
 */

package com.school.demo.util;

public class Constants {

    public enum ERole {
        ROLE_USER(1),
        ROLE_MODERATOR(2),
        ROLE_ADMIN(3),
        ROLE_TEACHER(4),
        ROLE_STUDENT(5);

        private int levelCode;

        ERole(int levelCode) {
            this.levelCode = levelCode;
        }
        public int getLevelCode(){
            return levelCode;
        }

        public static ERole valueOfLevelCode(int levelCode) {
            for (ERole e: values())
                if (e.levelCode == levelCode) {
                    return e;
                }
            return ROLE_USER;
        }
    }

    public enum EFee {
        RESTAURANT(1),
        TRANSPORT(2),
        INSCRIPTION(3);

        private int levelCode;

        EFee(int levelCode) {
            this.levelCode = levelCode;
        }
        public int getLevelCode(){
            return levelCode;
        }

        public static EFee valueOfLevelCode(int levelCode) {
            for (EFee e: values())
                if (e.levelCode == levelCode) {
                    return e;
                }
            return INSCRIPTION;
        }
    }
}
