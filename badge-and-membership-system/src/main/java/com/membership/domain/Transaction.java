package com.membership.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    private LocalDate dateTime;

    @ManyToOne
    @JoinColumn(name = "transacion_id")
    private Membership membership;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


}
