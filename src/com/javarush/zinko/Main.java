package com.javarush.zinko;

import com.javarush.zinko.Ui.Dialogue;
import com.javarush.zinko.cryptography.Crypto;


public class Main {
    public static void main(String[] args) {
        new Dialogue().start();
        String input = "Этот текст написан для теста работы методов Энкод, Декод и Брут Форс. Первый проект, криптоаннализатор.\n" +
                "Курс джавараш, по программировнию, чтобы изменить свою жизнь в лучшую сторону. Обеспечить свою семью, дать им лучшую жизнь!" +
                "Возможно проблема в слишком коротком тексте, для которого плохо собирать статистику и поэтому мой брутфорс не работает, а возможно я просто не грамотный и это очень смешно";
        String encode = Crypto.encode(input, 10);
        System.out.println(encode);
        System.out.println("\n");
        //System.out.println(Crypto.decode(encode, 10));
        System.out.println("\n");
        System.out.println(Crypto.bruteForce(encode));


    }
}
