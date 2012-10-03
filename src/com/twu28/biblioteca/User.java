package com.twu28.biblioteca;

public class User {
    private String userName;
    private String passWord;

    public User(String userName,String passWord){
        this.userName=userName;
        this.passWord=passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (passWord != null ? !passWord.equals(user.passWord) : user.passWord != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        return result;
    }

    public String returnDetails() {
        return userName;
    }
}
