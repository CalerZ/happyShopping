package com.jkq.jsqiang.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Caler_赵康乐
 * @create 2020-02-13 20:53
 * @description :
 */
public class PasswordConf implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence);
    }
}
