package com.example.appityproyect.db.dao;

public class Appity {

        private String nieDni;
        private String username;
        private String passReg;
        private String passReg2;
        private String email;
        private String email2;
        private int edad;

        public Appity(String nieDni, String username, String passReg, String passReg2, String email, String email2, int edad) {
            this.nieDni = nieDni;
            this.username = username;
            this.passReg = passReg;
            this.passReg2 = passReg2;
            this.email = email;
            this.email2 = email2;
            this.edad = edad;
        }

        // Getters and setters
        public String getNieDni() {
            return nieDni;
        }

        public void setNieDni(String nieDni) {
            this.nieDni = nieDni;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassReg() {
            return passReg;
        }

        public void setPassReg(String passReg) {
            this.passReg = passReg;
        }

        public String getPassReg2() {
            return passReg2;
        }

        public void setPassReg2(String passReg2) {
            this.passReg2 = passReg2;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail2() {
            return email2;
        }

        public void setEmail2(String email2) {
            this.email2 = email2;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }



}

