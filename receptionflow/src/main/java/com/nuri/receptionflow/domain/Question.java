package com.nuri.receptionflow.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Question {

    private TalkType talkType;

    private String topicId;

    private Contents contents;
}
