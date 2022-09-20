package com.nuri.receptionflow.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {

    private Question question;

    public static Customer has(Question question) {
        return new Customer(question);
    }

    public TalkType getQuestionTalkType() {
        return question.getTalkType();
    }
}
