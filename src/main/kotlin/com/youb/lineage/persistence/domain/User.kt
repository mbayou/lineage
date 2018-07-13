package com.youb.lineage.persistence.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User {

    @Id
    @GeneratedValue(generator = "uuid")
    private var id: Int = 0;
}