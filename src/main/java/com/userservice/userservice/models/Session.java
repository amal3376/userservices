package com.userservice.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Session extends BaseModel{
    private Boolean sessionStatus;
    @ManyToOne
    @JoinColumn(name = "session_Id",
            referencedColumnName = "user_Id")
    private User user;
}
