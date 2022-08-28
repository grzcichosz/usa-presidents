package com.usapresidents.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "PRESIDENT")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class President {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Timestamp termFrom;
    private Timestamp termTo;
    private String politicalParty;
}
