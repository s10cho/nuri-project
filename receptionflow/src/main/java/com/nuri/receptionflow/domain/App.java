package com.nuri.receptionflow.domain;

import static com.nuri.receptionflow.domain.TalkType.RESERVATION_TALK;
import static com.nuri.receptionflow.domain.TalkType.TALK;

import com.nuri.flowchart.domain.node.Node;

public class App {
    public static void main(String[] args) {

        Customer customer = getCustomer();

        Node<Boolean> isCenterOpen = new Node<>("", Center::isOpen);
        Node<Boolean> isReservationTalkEnabled = new Node<>("", Center::isReservationTalkEnabled);

        Node<TalkType> isTalkType = new Node<>("", customer::getQuestionTalkType)
            .next(TALK, isCenterOpen)
            .next(RESERVATION_TALK, isReservationTalkEnabled);

        // 고객이 접수를 한다.
        // 접수 유형(TalkType)이


    }

    private static Customer getCustomer() {
        Question question = new Question(
            TALK,
            "topic01",
            new Contents("text message")
        );
        Customer customer = Customer.has(question);
        return customer;
    }
}
