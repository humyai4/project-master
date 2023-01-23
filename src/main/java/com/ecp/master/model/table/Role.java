package com.ecp.master.model.table;

import com.ecp.master.model.role.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Enumerated(EnumType.STRING)
//    @NaturalId
    @Column(length = 60)
    private RoleName name;


}
