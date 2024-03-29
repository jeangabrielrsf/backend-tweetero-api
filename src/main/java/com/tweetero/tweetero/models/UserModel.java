package com.tweetero.tweetero.models;

import com.tweetero.tweetero.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String avatar;

    @Column(length = 100, nullable = false)
    private String username;

    public UserModel (UserDTO dto) {
        this.username = dto.getUsername();
        this.avatar = dto.getAvatar();
    }

}
